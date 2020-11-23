package logic.variables.events;

import io.qameta.allure.Step;
import logic.widgets.Editor.Events;
import logic.widgets.Editor.Modificators.CreateTool;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class EventTimestamp {

    public EventTimestamp() {
    }

    public static String driverHomeTimeZone = null;
    private static final Logger log = Logger.getLogger(EventTimestamp.class);

    public Optional<Event> findEventByTimestamp(Event createdEvent, EventsList event) {
        Optional<Event> elementTofind = null;
        try {
            elementTofind = event.getEvent().stream().filter(e -> e.getEventTimestamp().compareTo(createdEvent.getEventTimestamp()) == 0).findFirst();
            log.info("The event was found with the required event timestamp identifier: " + elementTofind.toString());
        } catch (java.util.NoSuchElementException ex) {
            log.error("The event was not found with the required " + ex);
            System.out.println(ex);
        }
        return elementTofind;
    }

    public static String csvTimeFormatToTimestamp(String eventDate, String eventTime) {
        TimeZone timeZone = TimeZone.getTimeZone(driverHomeTimeZone);
        DateFormat oldFormat = new SimpleDateFormat("MMddyy HHmmss", Locale.ENGLISH);
        oldFormat.setTimeZone(timeZone);
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date oldTimestamp = null;
        String newTimestamp = null;
        try {
            oldTimestamp = oldFormat.parse(eventDate + " " + eventTime);
            newTimestamp = newFormat.format(oldTimestamp);
        } catch (ParseException e) {
            System.out.println(e);
        }

        return newTimestamp;
    }
    public static Date parseStrToDate(String eventTimestampString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy hh:mm a", Locale.ENGLISH);
        Date date = null;
        try {
            date = formatter.parse(eventTimestampString);
        } catch (ParseException e) {
            log.error(e);
        }
        return date;
    }

    public static String buildEventTimestampByMilis(long milSec) {
        Date date = new Date(milSec);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public Optional<Event> findEventByTimestamp(Date eventTimestamp, EventsList event) {
        Optional<Event> elementTofind = null;
        try {
            elementTofind = event.getEvent().stream().filter(e -> e.getEventTimestamp().compareTo(eventTimestamp) == 0).findFirst();
            log.info("The event was found with the required event timestamp identifier: " + elementTofind.toString());
        } catch (java.util.NoSuchElementException ex) {
            log.error("The event was not found with the required " + ex);
            System.out.println(ex);
        }
        return elementTofind;
    }

    public Date getEventTimestampAfterModification(int elementNum, EventsList eventAfter, EventsList event) {
        Optional<Event> oldEvent = null;
        try {
            oldEvent = eventAfter.getEvent().stream().filter(e -> e.getEventId().equals(event.getEvent().get(elementNum).getEventId())).findFirst();
            log.info("The event was found with the required event_id identifier: " + oldEvent.toString());
        } catch (java.util.NoSuchElementException ex) {
            log.error("The event was not found with the required event_id identifier: " + event.getEvent().get(elementNum).getEventId() + " " + ex);
        }
        return oldEvent.get().getEventTimestamp();
    }

    public Date buildEventTimestamp(String eventTimestamp) {
        SimpleDateFormat oldFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm", Locale.ENGLISH);
        Date oldTimestamp = null;
        try {
            oldTimestamp = oldFormat.parse(eventTimestamp);
        } catch (ParseException e) {
            log.error("e");
        }
        SimpleDateFormat newFormat = new SimpleDateFormat("dd-MMM-yy hh:mm a", Locale.ENGLISH);
        String time = newFormat.format(oldTimestamp.getTime());
        Date newEventTimestamp = null;
        try {
            newEventTimestamp = newFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newEventTimestamp;
    }

    public List<Integer> calculateMaxSpecifyTime(Event createdEvent, EventsList event, int timeChangesCoef) {
        List<Integer> time = new ArrayList<>();
        long difference = 0;
        log.info("Calculation of the maximum time for Create Event Specify");
        for (int i = 0; i < event.getEvent().size(); i++) {
            log.info("** The time of the event that is checking: #" + i + " - " + event.getEvent().get(i).getEventTimestamp());
            if (event.getEvent().get(i).getEventTimestamp().compareTo(createdEvent.getEventTimestamp()) < 0 && i != 0) {
                log.info("*** The time of the event that is checked is less than the time of the event that is created: #" + i + " - " + event.getEvent().get(i).getEventTimestamp() + " И " + createdEvent.getEventTimestamp());
                difference = Math.abs(event.getEvent().get(i - 1).getEventTimestamp().getTime() - createdEvent.getEventTimestamp().getTime());
                break;
            } else if (event.getEvent().get(i).getEventTimestamp().compareTo(createdEvent.getEventTimestamp()) < 0 && i == 0) {
                log.info("*** The time of the event that is checked is less than the time of the event that is created: #" + i + " - " + event.getEvent().get(i).getEventTimestamp() + " И " + createdEvent.getEventTimestamp());
                Date nextEventDate = getDate(-1).getTime();
                difference = Math.abs(nextEventDate.getTime() - createdEvent.getEventTimestamp().getTime());
            }
        }
        long diffMax = TimeUnit.SECONDS.convert(difference, TimeUnit.MILLISECONDS);
        diffMax += timeChangesCoef * 60;
        time.add((int) diffMax / 3600);
        time.add((int) diffMax / 60 % 60);
        return time;
    }

    public Date addTime(List<Integer> time, Event event) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(event.getEventTimestamp());
        cal.add(Calendar.HOUR, time.get(0));
        cal.add(Calendar.MINUTE, time.get(1));
        Date modifiedDate = cal.getTime();
        return modifiedDate;
    }

    public HashMap<String, Integer> getTimeDifference(EventsList event, List<java.lang.Integer> eventNum) {
        int sizeOfListEvents = event.getEvent().size();
        HashMap<String, Integer> time = new HashMap<>();
        List<Long> differenceMax = new ArrayList();
        List<Long> differenceMin = new ArrayList();
        log.info("Start: Get Max and Min time difference for Shift");
        for (int element : eventNum) {
            if (event.getEvent().get(element).getIsGapDate().equals("Y")) continue;
            Date lastSelectedEventDate = event.getEvent().get(element).getEventTimestamp();
            log.info("Selected event №" + element + ": " + event.getEvent().get(element).toString());
            if (!eventNum.contains(element + 1) && element != sizeOfListEvents - 1) {
                Date nextEventDate = null;
                if (event.getEvent().get(element + 1).getIsGapDate().equals("Y") || event.getEvent().get(element).getEventName().equals("Border Cross")) {
                    nextEventDate = getDate(-217).getTime();
                } else nextEventDate = event.getEvent().get(element + 1).getEventTimestamp();
                differenceMin.add(Math.abs(lastSelectedEventDate.getTime() - nextEventDate.getTime()));
                log.info("Get the difference to event  №" + (element + 1) + ": " + event.getEvent().get(element + 1).toString()
                        + ". Difference  = " + differenceMin.get(differenceMin.size() - 1));
            } else if (element == sizeOfListEvents - 1) {
                differenceMin.add(0L);
            } else if (eventNum.contains(element + 1) && event.getEvent().get(element + 1).getIsGapDate().equals("Y")) {
                Date nextEventDate = getDate(-217).getTime();
                differenceMin.add(Math.abs(lastSelectedEventDate.getTime() - nextEventDate.getTime()));
            }
            if (element != 0 & !eventNum.contains(element - 1)) {
                Date nextEventDate = null;
                if (event.getEvent().get(element).getEventName().equals("Border Cross")) {
                    nextEventDate = getDate(-1).getTime();
                } else nextEventDate = event.getEvent().get(element - 1).getEventTimestamp();
                differenceMax.add(Math.abs(lastSelectedEventDate.getTime() - nextEventDate.getTime()));
                log.info("Get the difference to event  №" + (element - 1) + ": " + event.getEvent().get(element - 1).toString()
                        + ". Difference  = " + differenceMax.get(differenceMax.size() - 1));
            } else if (element == 0) {
                Date nextEventDate = getDate(-1).getTime();
                differenceMax.add(Math.abs(lastSelectedEventDate.getTime() - nextEventDate.getTime()));
                log.info("Get the difference to event  №" + (element) + ": " + event.getEvent().get(element).toString()
                        + ". Difference  = " + differenceMax.get(differenceMax.size() - 1));
            }
        }
        long diffMax = TimeUnit.SECONDS.convert(Collections.min(differenceMax), TimeUnit.MILLISECONDS);
        long diffMin = TimeUnit.SECONDS.convert(Collections.min(differenceMin), TimeUnit.MILLISECONDS);
        time.put("right", (int) diffMax);
        time.put("left", (int) diffMin);
        log.info("Found maximum and minimum time for Shift event set: " + time.toString());
        return time;
    }


    public static Calendar getDate(int minusHours) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, minusHours);
        return cal;
    }

    @Step("Calculation of time for which the event will move in the direction - {3}")
    public List<Integer> calculateHoursAndMinutes(EventsList event, List<java.lang.Integer> eventNum, int coefOfTimeReduction, String directionOfMove) {
        HashMap<String, Integer> timeInSeconds = null;
        timeInSeconds = getTimeDifference(event, eventNum);
        List<Integer> time = new ArrayList<>();
        int hours = 0;
        int minutes = 0;
        if (timeInSeconds.get(directionOfMove) == 120 && coefOfTimeReduction != 2) {
            hours = (timeInSeconds.get(directionOfMove)) / 3600;
            minutes = (timeInSeconds.get(directionOfMove)) / 60 % 60;
        } else if (timeInSeconds.get(directionOfMove) > 120 && coefOfTimeReduction != 2) {
            hours = (timeInSeconds.get(directionOfMove) + coefOfTimeReduction) / 3600;
            minutes = (timeInSeconds.get(directionOfMove) + coefOfTimeReduction) / 60 % 60;
        } else if (coefOfTimeReduction == 2) {
            hours = (timeInSeconds.get(directionOfMove) / coefOfTimeReduction) / 3600;
            minutes = (timeInSeconds.get(directionOfMove) / coefOfTimeReduction) / 60 % 60;
        }
        if (directionOfMove.equals("left")) {
            hours *= -1;
            minutes *= -1;
        }
        time.add(hours);
        time.add(minutes);
        return time;
    }
}
