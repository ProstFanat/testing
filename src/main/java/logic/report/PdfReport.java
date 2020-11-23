package logic.report;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import logic.variables.UrlVariables;
import org.apache.log4j.Logger;
import org.openqa.selenium.logging.LogEntry;

import static logic.webdriver.DriverFactory.getDriver;

public class PdfReport {
    private static final Logger log = Logger.getLogger(PdfReport.class);

    private static final Font anchorFont = new Font(Font.FontFamily.TIMES_ROMAN, 20,
            Font.BOLD);
    private static final Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static final Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static final Font greyFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.DARK_GRAY);
    private static final Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static final Font bold = new Font(Font.FontFamily.TIMES_ROMAN, 14,
            Font.BOLD);
    private static final Font notBold = new Font(Font.FontFamily.TIMES_ROMAN, 14,
            Font.NORMAL);
    private static final Font success = new Font(Font.FontFamily.TIMES_ROMAN, 14,
            Font.BOLD, BaseColor.GREEN);
    private static final Font failed = new Font(Font.FontFamily.TIMES_ROMAN, 14,
            Font.BOLD, BaseColor.RED);
    private static final Font skipped = new Font(Font.FontFamily.TIMES_ROMAN, 14,
            Font.BOLD, BaseColor.GRAY);
    public static ByteArrayOutputStream bout;

    public static ByteArrayOutputStream getBout() {
        return bout;
    }

    public static Document document = null;
    private static Anchor anchor;
    private static Chapter catPart;


    public static void createReportFile(String reportName) {
        try {
            document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("/home/evgeniy/Desktop/Reports/"
                    +reportName.replaceAll("\\s+","").toLowerCase()+"_"+new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss").format(new Date())+".pdf"));
            bout = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, bout);
            Paragraph article = new Paragraph();
            document.open();
            article.setAlignment(Element.ALIGN_CENTER);
            article.add(new Paragraph(reportName, anchorFont));
            article.add(new Paragraph("Report date: " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()), smallBold));
            article.add(new Paragraph("Environment: " + UrlVariables.getBaseURL(), smallBold));
            article.add(new Paragraph("_______________________________________________", anchorFont));
            document.add(article);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeErrorToReport(String message, boolean result) {
        try {
            if (result)
                document.add(new Paragraph("+ " + message, greyFont));
            else
                document.add(new Paragraph("- " + message, redFont));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void writeNumberedErrorsList(ArrayList<String> errors) {
        List numberedL = new List();
        numberedL.setIndentationLeft(30f);
        numberedL.setNumbered(true);
        errors.forEach(numberedL::add);
        try {
            document.add(numberedL);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void createNewAnchor(String name) {
        anchor = new Anchor(name + "\n", anchorFont);
        try {
            document.add(anchor);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void createNewSubAnchor(String name) {
        anchor = new Anchor(name + "\n", smallBold);
        try {
            document.add(anchor);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void createNewSubAnchorBold(String name) {
        anchor = new Anchor(name + "\n", bold);
        try {
            document.add(anchor);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void createNewSubAnchorNotBold(String name) {
        anchor = new Anchor(name + "\n", notBold);
        try {
            document.add(anchor);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void addEndOfBlockLine() {
        anchor = new Anchor("_____________________________________________________________\n", notBold);
        try {
            document.add(anchor);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void writeTestResult(String result) {
        anchor = new Anchor("TEST RESULT: ", notBold);
        try {
            document.add(anchor);
            switch (result) {
                case "PASSED":
                    document.add(new Anchor(result, success));
                    break;
                case "FAILED":
                    document.add(new Anchor(result, failed));
                    break;
                case "SKIPPED":
                    document.add(new Anchor(result, skipped));
                    break;
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void writeJsLogFromWebDriver() {
        java.util.List<LogEntry> all = getDriver().manage().logs().get("browser").filter(Level.SEVERE);
        if (all.size() > 0) {
            createNewSubAnchorBold("Console Errors");
            for (int i = 0; i < all.size(); i++) {
                LogEntry l = all.get(i);
                log.error(l);
                PdfReport.writeErrorToReport(i + 1 + ". " + l.toString(), false);
            }
        }
    }

    public static void writeResultsToFile() {
        document.close();
    }
}
