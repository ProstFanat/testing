package logic.variables.events;

import logic.pages.companyProfile.drivers.driverProfile.EditorPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static logic.variables.events.EventTimestamp.parseStrToDate;

public class Event extends EditorPage {
    private String eventType;
    private String eventName;
    private Date eventTimestamp;
    private String eventId;
    private String recordOrigin;
    private String recordStatus;
    private String totalVehicleMiles;
    private String totalEngineHours;
    private String truckNumber;
    private String isGapDate;
    private int eventNum;
    private static final Logger log = Logger.getLogger(Event.class);

    public Event(String eventType, String eventName, String totalVehicleMiles, String totalEngineHours) {
        this.eventType = eventType;
        this.eventName = eventName;
        this.totalVehicleMiles = totalVehicleMiles;
        this.totalEngineHours = totalEngineHours;
    }

    private static By pathToElementBuilder(int eventNum, int bodyCell, int infoType) {
        return By.xpath("//datatable-row-wrapper[" + eventNum + "]/datatable-body-row/div[" + bodyCell + "]/datatable-body-cell[" + infoType + "]/div/span");
    }

    public Event() {
        super();
    }

    public void setEventTimestamp(Date eventTimestamp) {
        Date result = new Date(eventTimestamp.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy hh:mm a", Locale.ENGLISH);
        String time = formatter.format(result);
        try {
            this.eventTimestamp = formatter.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getEventType() {
        return eventType;
    }


    public String getIsGapDate() {
        return isGapDate;
    }


    public String getRecordOrigin() {
        return recordOrigin;
    }

    public Date getEventTimestamp() {
        return eventTimestamp;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventId() {
        return eventId;
    }

    public WebElement getEventNameElement() {
        return driver.findElement(pathToElementBuilder(eventNum, 1, 2));
    }

    public String getTotalVehicleMiles() {
        return totalVehicleMiles;
    }


    public String getTotalEngineHours() {
        return totalEngineHours;
    }


    public String getTruckNumber() {
        return truckNumber;
    }


    public int getEventNum() {
        return eventNum;
    }


    public Date addTime(List<Integer> time) {
        int hours = 0;
        int minutes = 0;
        hours = time.get(0);
        minutes = time.get(1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(eventTimestamp);
        cal.add(Calendar.HOUR, hours);
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", eventTimestamp=" + eventTimestamp +
                ", eventId='" + eventId + '\'' +
                ", RO='" + recordOrigin + '\'' +
                ", totalVehicleMiles='" + totalVehicleMiles + '\'' +
                ", totalEngineHours='" + totalEngineHours + '\'' +
                ", truckNumber='" + truckNumber + '\'' +
                ", isGapDate='" + isGapDate + '\'' +
                ", eventNum='" + eventNum + '\'' +
                '}';
    }

    public static class Builder {
        private Event event;

        public Builder(int eventNum) {
            event = new Event();
            event.eventNum = eventNum;
        }

        public Builder setEventName() {
            try {
                WebElement eventNameElement = event.driver.findElement(pathToElementBuilder(event.eventNum, 1, 2));
                event.eventName = eventNameElement.getText();
            } catch (StaleElementReferenceException e) {
                log.error("setEventName: element №" + event.eventNum + " " + e);
                setEventName();
            }
            return this;
        }

        public Builder setEventTimestamp() {
            try {
                WebElement eventTimestampElement = event.driver.findElement(pathToElementBuilder(event.eventNum, 1, 3));
                event.eventTimestamp = parseStrToDate(eventTimestampElement.getText());
            } catch (StaleElementReferenceException e) {
                log.error("setEventTimestamp: element №" + event.eventNum + " " + e);
                setEventTimestamp();
            }
            return this;
        }

        public Builder setIsGapDate() {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy hh:mm a", Locale.ENGLISH);
            Date currentTimestamp = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(currentTimestamp);
            cal.add(Calendar.HOUR, -217);
            if (cal.getTimeInMillis() >= event.eventTimestamp.getTime()) {
                event.isGapDate = "Y";
            } else event.isGapDate = "N";
            return this;
        }

        public Builder setEventId() {
            try {
                WebElement eventIdElement = event.driver.findElement(pathToElementBuilder(event.eventNum, 2, 1));
                event.eventId = eventIdElement.getText();
            } catch (StaleElementReferenceException e) {
                log.error("setEventId: element №" + event.eventNum + " " + e);
                setEventId();
            }
            return this;
        }

        public Builder setRecordOrigin() {
            try {
                WebElement recordOriginElement = event.driver.findElement(pathToElementBuilder(event.eventNum, 2, 2));
                event.recordOrigin = recordOriginElement.getText();
            } catch (StaleElementReferenceException e) {
                log.error("setRecordOrigin: element №" + event.eventNum + " " + e);
                setRecordOrigin();
            }
            return this;
        }
        public Builder setRecordStatus() {
            try {
                WebElement recordStatusElement = event.driver.findElement(pathToElementBuilder(event.eventNum, 2, 1));
                event.recordStatus = recordStatusElement.getText();
            } catch (StaleElementReferenceException e) {
                log.error("setRecordStatus: element №" + event.eventNum + " " + e);
                setRecordStatus();
            }
            return this;
        }
        public Builder setTruckNumber() {
            try {
                WebElement truckNumberElement = event.driver.findElement(pathToElementBuilder(event.eventNum, 2, 24));
                event.truckNumber = truckNumberElement.getText();
            } catch (StaleElementReferenceException e) {
                log.error("setTruckNumber: element №" + event.eventNum + " " + e);
                setTruckNumber();
            }
            return this;
        }

        public Builder setTotalEngineHours() {
            try {
                WebElement totalEngineHoursElement = event.driver.findElement(pathToElementBuilder(event.eventNum, 2, 11));
                event.totalEngineHours = totalEngineHoursElement.getText();
            } catch (StaleElementReferenceException e) {
                log.error("setEventName: element №" + event.eventNum + " " + e);
                setTotalEngineHours();
            }
            return this;
        }

        public Builder setTotalVehicleMiles() {
            try {
                WebElement totalVehicleMilesElement = event.driver.findElement(pathToElementBuilder(event.eventNum, 2, 8));
                event.totalVehicleMiles = totalVehicleMilesElement.getText();
            } catch (StaleElementReferenceException e) {
                log.error("totalVehicleMiles: element №" + event.eventNum + " " + e);
                setTotalVehicleMiles();
            }
            return this;
        }

        public Event build() {
            return event;
        }
    }
}

