package logic.email;

import logic.variables.Accounts;
import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.search.FromTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.*;

public class EmailReader {
    private Folder folder;
    private Folder reminderFolder;
    private static int tryCount = 0;
    private static final Logger log = Logger.getLogger(EmailReader.class);

    public EmailReader(String username, String password, String server) throws MessagingException {
        Properties properties = System.getProperties();
        try {
            properties.load(new FileInputStream((new File("src/main/resources/email.properties"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Session session = Session.getInstance(properties);
        Store store = session.getStore("imaps");
        store.connect(server, username, password);
        log.info("Connect to: " + server + " server / " + username + " user.");
        folder = store.getFolder("INBOX");
        folder.open(Folder.READ_WRITE);
        reminderFolder = store.getFolder("Reminder");
        reminderFolder.open(Folder.READ_WRITE);
    }

    public Message getMessageByIndex(int index) throws MessagingException {
        return folder.getMessage(index);
    }

    public Message getLatestMessage() throws MessagingException {
        return getMessageByIndex(getNumberOfMessages());
    }

    public int getNumberOfMessages() throws MessagingException {
        return folder.getMessageCount();
    }


    public String getMessageContent(Message message) throws Exception {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(message.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }

    public List<String> getUrlsFromMessage(Message message, String linkText) throws Exception {
        String html = getMessageContent(message);
        List<String> allMatches = new ArrayList<String>();
        Matcher matcher = Pattern.compile("(<a [^>]+>)" + linkText + "</a>").matcher(html);
        while (matcher.find()) {
            String aTag = matcher.group(1);
            allMatches.add(aTag.substring(aTag.indexOf("http"), aTag.indexOf("\">")));
        }
        return allMatches;
    }

    public boolean isMessageUnread(Message message) throws Exception {
        return !message.isSet(Flags.Flag.SEEN);
    }

    public Message[] getMessagesBySubject(String subject, boolean unreadOnly, int maxToSearch) throws Exception {
        Map<String, Integer> indices = getStartAndEndIndices(maxToSearch);

        Message messages[] = folder.search(
                new SubjectTerm(subject),
                folder.getMessages(indices.get("startIndex"), indices.get("endIndex")));

        if (unreadOnly) {
            List<Message> unreadMessages = new ArrayList<Message>();
            for (Message message : messages) {
                if (isMessageUnread(message)) {
                    unreadMessages.add(message);
                }
            }
            messages = unreadMessages.toArray(new Message[]{});
        }

        return messages;
    }

    public EmailReader copyAllMessagesToReminderFolder() {
        try {
            folder.copyMessages(folder.getMessages(), reminderFolder);
            folder.close(true);
            log.info("Copy messages from INBOX to Reminder folder.");
        } catch (MessagingException e) {
            log.error("Messages copy to Reminder folder error." + e);
        }
        return this;
    }

    public Message[] getMessagesBySender(String subject, boolean unreadOnly, int maxToSearch, String senderMail) throws Exception {
        Map<String, Integer> indices = getStartAndEndIndices(maxToSearch);
        SearchTerm sender = new FromTerm(new InternetAddress(senderMail));

        Message messages[] = folder.search(sender);

        if (unreadOnly) {
            List<Message> unreadMessages = new ArrayList<Message>();
            for (Message message : messages) {
                if (isMessageUnread(message)) {
                    unreadMessages.add(message);
                }
            }
            messages = unreadMessages.toArray(new Message[]{});
        }

        return messages;
    }

    private Map<String, Integer> getStartAndEndIndices(int max) throws MessagingException {
        int endIndex = getNumberOfMessages();
        int startIndex = endIndex - max;
        if (startIndex < 1) {
            startIndex = 1;
        }
        Map<String, Integer> indices = new HashMap<String, Integer>();
        indices.put("startIndex", startIndex);
        indices.put("endIndex", endIndex);

        return indices;
    }

    public String searchCsvReportMail() throws IOException, MessagingException {
        final String pathToFile = "/home/evgeniy/Desktop/Reports";
        Message message = waitToUnSeenAndLastMailWithSubject("ELD records from");
        String attachFiles = "";
        String contentType = null;
        contentType = message.getContentType();
        String messageContent = "";
        if (contentType.contains("multipart")) {
            Multipart multipart = (Multipart) message.getContent();
            int numberOfParts = multipart.getCount();
            for (int partCount = 0; partCount < numberOfParts; partCount++) {
                MimeBodyPart part = (MimeBodyPart) multipart.getBodyPart(partCount);
                if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                    String fileName = part.getFileName();
                    attachFiles += fileName + ", ";
                    part.saveFile(pathToFile + File.separator + fileName);
                } else {
                    messageContent = part.getContent().toString();
                }
            }
            if (attachFiles.length() > 1) {
                attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
            }
        } else if (contentType.contains("text/plain")
                || contentType.contains("text/html")) {
            Object content = message.getContent();
            if (content != null) {
                messageContent = content.toString();
            }
        }
        log.info("Message: " + messageContent);
        log.info("Attachmentsge: " + attachFiles);
        log.info("*** Set flag to message - 'SEEN'.");
        message.setFlag(Flags.Flag.SEEN, true);
        if (attachFiles==null || attachFiles.equals(""))
            return null;
        return pathToFile + File.separator + attachFiles;
    }

    public String searchRegistrationMail(String verificationTextLink) {
        String link = null;
        Message message = waitToUnSeenAndLastMailWithSubject("Registration Reminder");
        try {
            log.info("**** Try to parse verification URL from message.");
            link = getUrlsFromMessage(message, verificationTextLink).get(0);
        } catch (IndexOutOfBoundsException e) {
            if (tryCount < 80) {
                log.info("Verification link in message not found. Try #" + tryCount);
                tryCount++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                return searchRegistrationMail(verificationTextLink);
            } else if (tryCount >= 80) {
                log.error("*** Found message read. Tries are exhausted. TEST FAILED.");
                assertTrue(false, "Link  not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("*** Set flag to message - 'SEEN'.");
        try {
            message.setFlag(Flags.Flag.SEEN, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        tryCount=0;
        return link;
    }

    private Message waitToUnSeenAndLastMailWithSubject(String subject){
        Message message = null;
        log.info("Try to find latest message");
        try {
            message = getLatestMessage();
            log.info("** If found message subject is '"+subject+"'");
            if (message.getSubject().contains(subject)) {
                log.info("*** Found message subject is '"+subject+"'");
                if (!isMessageUnread(message) && tryCount < 80) {
                    log.info("*** Found message read. Try# " + tryCount);
                    tryCount++;
                    Thread.sleep(2000);
                    return  waitToUnSeenAndLastMailWithSubject(subject);
                } else if (!isMessageUnread(message) && tryCount >= 80) {
                    log.error("*** Found message read. Tries are exhausted. TEST FAILED.");
                    assertTrue(false, "Message not found.");
                }
            } else {
                log.info("*** Found message subject is NOT '"+subject+"'. Try #" + tryCount);
                if (tryCount >= 80) assertTrue(false, "Message Not Found.");
                tryCount++;
                Thread.sleep(2000);
                return  waitToUnSeenAndLastMailWithSubject(subject);
            }
        } catch (MessagingException e) {
            log.error(e);
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            if (tryCount < 80) {
                log.info("Latest message not found. Try #" + tryCount);
                tryCount++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                return  waitToUnSeenAndLastMailWithSubject(subject);
            } else if (tryCount >= 80) {
                log.error("*** Found message read. Tries are exhausted. TEST FAILED.");
                assertTrue(false, "Message  not found.");
            }
        } catch (Exception e) {
            log.error(e);
        }
        tryCount=0;
        return message;
    }

}


