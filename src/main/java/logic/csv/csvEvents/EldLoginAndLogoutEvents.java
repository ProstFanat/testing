package logic.csv.csvEvents;

import logic.csv.ErrorLogs;
import logic.dbConnection.entity.EventEntity;
import logic.pojo.EventsPojo;
import logic.variables.events.EventTimestamp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class EldLoginAndLogoutEvents extends EventCSV{
    @Override
    public void compareEventsFromCsvAndDb(List<EventsPojo> eventsFromDb) {
        Optional<EventsPojo> foundEvent = findEventFromCsvInDb(eventsFromDb);
        try{
            log.info("*** CHECK: Compare event form CSV and DB: ELD Sequence = " + foundEvent.get().getEldSequence());
            checkStringValue(driverLoginNameFromDetailsPage,getEldUserName(), "getEldUserName",foundEvent.get().getEldSequence());
            checkIntValue(foundEvent.get().getEventCode(), getEventCode(), "getEventCode",foundEvent.get().getEldSequence());
            checkStringValue(EventTimestamp.buildEventTimestampByMilis(foundEvent.get().getEventTimestamp()) , EventTimestamp.csvTimeFormatToTimestamp(getEventDate(), getEventTime()), "getEventTimeStamp",foundEvent.get().getEldSequence());
            checkDoubleValue(foundEvent.get().getTotalVehicleMiles(),getTotalVehicleMiles(),"getTotalVehicleMiles",foundEvent.get().getEldSequence());
            checkDoubleValue(foundEvent.get().getTotalEngineHours(), getTotalEngineHours() , "getTotalEngineHours",foundEvent.get().getEldSequence());
        } catch (NoSuchElementException e){
            log.error("* * * * No Such Event!");
            ErrorLogs.setNoSuchElementLogs("No Such Event! " + "CSV -> " + this.toString() + "DB -> " + foundEvent.toString() + "\n");
        }
    }

    @Override
    public String toString() {
        return "EldLoginAndLogoutEvents{" +
                "eldUserName='" + eldUserName + '\'' +
                ", eventSequence='" + eventSequence + '\'' +
                ", eventCode=" + eventCode +
                ", eventDate=" + eventDate +
                ", eventTime=" + eventTime +
                ", totalVehicleMiles='" + totalVehicleMiles + '\'' +
                ", totalEngineHours='" + totalEngineHours + '\'' +
                "}\n";
    }

    public static class Builder {
        private EldLoginAndLogoutEvents newEldLoginAndLogoutEvents;
        public Builder(){
            newEldLoginAndLogoutEvents = new EldLoginAndLogoutEvents();
        }
        public Builder setEventSequence(String eventSequence){
            newEldLoginAndLogoutEvents.eventSequence =eventSequence;
            return this;
        }
        public Builder setEventCode(int eventCode){
            newEldLoginAndLogoutEvents.eventCode=eventCode;
            return this;
        }
        public Builder setEventTime(String eventTime){
            newEldLoginAndLogoutEvents.eventTime=eventTime;
            return this;
        }
        public Builder setEventDate(String eventDate){
            newEldLoginAndLogoutEvents.eventDate=eventDate;
            return this;
        }
        public Builder setEldUserName(String eldUserName){
            newEldLoginAndLogoutEvents.eldUserName =eldUserName;
            return this;
        }
        public Builder setTotalVehicleMiles(double totalVehicleMiles){
            newEldLoginAndLogoutEvents.totalVehicleMiles=totalVehicleMiles;
            return this;
        }
        public Builder setTotalEngineHours(double totalEngineHours){
            newEldLoginAndLogoutEvents.totalEngineHours=totalEngineHours;
            return this;
        }
        public EldLoginAndLogoutEvents build(){
            return newEldLoginAndLogoutEvents;
        }
    }
}
