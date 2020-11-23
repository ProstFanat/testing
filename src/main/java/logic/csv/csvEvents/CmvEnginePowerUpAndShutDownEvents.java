package logic.csv.csvEvents;

import logic.csv.ErrorLogs;
import logic.dbConnection.entity.EventEntity;
import logic.pojo.EventsPojo;
import logic.variables.events.EventTimestamp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CmvEnginePowerUpAndShutDownEvents  extends EventCSV{

    @Override
    public String toString() {
        return "CmvEnginePowerUpAndShutDownEvents{" +
                "powerUnitNumber='" + powerUnitNumber + '\'' +
                ", vinNumber='" + vinNumber + '\'' +
                ", trailerNumber='" + trailerNumber + '\'' +
                ", shippingNumber='" + shippingNumber + '\'' +
                ", eventSequence='" + eventSequence + '\'' +
                ", eventCode=" + eventCode +
                ", eventDate=" + eventDate +
                ", eventTime=" + eventTime +
                ", totalVehicleMiles='" + totalVehicleMiles + '\'' +
                ", totalEngineHours='" + totalEngineHours + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                "}\n";
    }

    @Override
    public Optional<EventsPojo> findEventFromCsvInDb(List<EventsPojo> eventFromDb) {
        return super.findEventFromCsvInDb(eventFromDb);
    }

    @Override
    public void compareEventsFromCsvAndDb(List<EventsPojo> eventsFromDb) {
        Optional <EventsPojo> foundEvent = findEventFromCsvInDb(eventsFromDb);
        try{
            log.info("*** CHECK: Compare event form CSV and DB: ELD Sequence = " + foundEvent.get().getEldSequence());
            checkIntValue(foundEvent.get().getEventCode(), getEventCode(), "getEventCode",foundEvent.get().getEldSequence());
            checkStringValue(EventTimestamp.buildEventTimestampByMilis(foundEvent.get().getEventTimestamp()) , EventTimestamp.csvTimeFormatToTimestamp(getEventDate(), getEventTime()), "getEventTimeStamp",foundEvent.get().getEldSequence());
            checkDoubleValue(foundEvent.get().getTotalVehicleMiles(),getTotalVehicleMiles(),"getTotalVehicleMiles",foundEvent.get().getEldSequence());
            checkDoubleValue(foundEvent.get().getTotalEngineHours(), getTotalEngineHours() , "getTotalEngineHours",foundEvent.get().getEldSequence());
            checkCoordinatesValue(foundEvent.get().getLongitude(), getLongitude(), "getLongitude",foundEvent.get().getEldSequence());
            checkCoordinatesValue(foundEvent.get().getLatitude(), getLatitude(), "getLatitude",foundEvent.get().getEldSequence());
            checkStringValue(foundEvent.get().getTruckVin(),getVinNumber(), "getVinNumber",foundEvent.get().getEldSequence());
            checkShippingTrailerNumbersValue(foundEvent.get().getTrailerNumber(),getTrailerNumber(), "getTrailerNumber",foundEvent.get().getEldSequence());
            checkShippingTrailerNumbersValue(foundEvent.get().getShippingNumber(),getShippingNumber(), "getShippingNumber",foundEvent.get().getEldSequence());
            checkStringValue(foundEvent.get().getTruckNumber(),getPowerUnitNumber(), "getPowerUnitNumber",foundEvent.get().getEldSequence());
        } catch (NoSuchElementException e){
            log.error("* * * * No Such Event!");
            ErrorLogs.setNoSuchElementLogs("No Such Event! " + "CSV -> " + this.toString() + "DB -> " + foundEvent.toString());
        }
    }

    public static class Builder {
        private CmvEnginePowerUpAndShutDownEvents newCmvEnginePowerUpAndShutDownEvents;
        public Builder(){
            newCmvEnginePowerUpAndShutDownEvents = new CmvEnginePowerUpAndShutDownEvents();
        }
        public Builder setEventSequence(String eventSequence){
            newCmvEnginePowerUpAndShutDownEvents.eventSequence =eventSequence;
            return this;
        }
        public Builder setEventCode(int eventCode){
            newCmvEnginePowerUpAndShutDownEvents.eventCode=eventCode;
            return this;
        }
        public Builder setEventTime(String eventTime){
            newCmvEnginePowerUpAndShutDownEvents.eventTime=eventTime;
            return this;
        }
        public Builder setEventDate(String eventDate){
            newCmvEnginePowerUpAndShutDownEvents.eventDate=eventDate;
            return this;
        }
        public Builder setTotalVehicleMiles(double totalVehicleMiles){
            newCmvEnginePowerUpAndShutDownEvents.totalVehicleMiles=totalVehicleMiles;
            return this;
        }
        public Builder setTotalEngineHours(double totalEngineHours){
            newCmvEnginePowerUpAndShutDownEvents.totalEngineHours=totalEngineHours;
            return this;
        }
        public Builder setPowerUnitNumber(String powerUnitNumber){
            newCmvEnginePowerUpAndShutDownEvents.powerUnitNumber=powerUnitNumber;
            return this;
        }
        public Builder setVinNumber(String vinNumber){
            newCmvEnginePowerUpAndShutDownEvents.vinNumber=vinNumber;
            return this;
        }
        public Builder setTrailerNumber(String trailerNumber){
            newCmvEnginePowerUpAndShutDownEvents.trailerNumber=trailerNumber;
            return this;
        }
        public Builder setShippingNumber(String shippingNumber){
            newCmvEnginePowerUpAndShutDownEvents.shippingNumber=shippingNumber;
            return this;
        }
        public Builder setLatitude(String latitude){
            newCmvEnginePowerUpAndShutDownEvents.latitude=latitude;
            return this;
        }
        public Builder setLongitude(String longitude){
            newCmvEnginePowerUpAndShutDownEvents.longitude=longitude;
            return this;
        }

        public CmvEnginePowerUpAndShutDownEvents build(){
            return newCmvEnginePowerUpAndShutDownEvents;
        }
    }
}
