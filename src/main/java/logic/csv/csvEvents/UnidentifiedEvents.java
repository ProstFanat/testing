package logic.csv.csvEvents;

import logic.csv.ErrorLogs;
import logic.dbConnection.entity.EventEntity;
import logic.pojo.EventsPojo;
import logic.variables.events.EventTimestamp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class UnidentifiedEvents extends EventCSV {

    @Override
    public void compareEventsFromCsvAndDb(List<EventsPojo> eventsFromDb) {
        checkEventForRequirement(this);
        Optional<EventsPojo> foundEvent = findEventFromCsvInDb(eventsFromDb);
        try{
            log.info("*** CHECK: Compare event form CSV and DB: ELD Sequence = " + foundEvent.get().getEldSequence());
            checkIntValue(foundEvent.get().getRecordStatus(), getRecordStatus(), "getRecordStatus",foundEvent.get().getEldSequence());
            checkIntValue(foundEvent.get().getRecordOrigin(), getRecordOrigin(), "getRecordOrigin",foundEvent.get().getEldSequence());
            checkIntValue(foundEvent.get().getEventType(), getEventType(), "getEventType",foundEvent.get().getEldSequence());
            checkIntValue(foundEvent.get().getEventCode(), getEventCode(), "getEventCode",foundEvent.get().getEldSequence());
            checkDoubleValue(foundEvent.get().getAccumulatedVehicleMiles(), getAccumulatedVehicleMiles(), "getAccumulatedVehicleMiles",foundEvent.get().getEldSequence());
            checkDoubleValue(foundEvent.get().getElapsedEngineHours(), getElapsedEngineHours(), "getElapsedEngineHours",foundEvent.get().getEldSequence());
            checkCoordinatesValue(foundEvent.get().getLongitude(), getLongitude(), "getLongitude",foundEvent.get().getEldSequence());
            checkCoordinatesValue(foundEvent.get().getLatitude(), getLatitude(), "getLatitude",foundEvent.get().getEldSequence());
            checkStringValue(EventTimestamp.buildEventTimestampByMilis(foundEvent.get().getEventTimestamp()) , EventTimestamp.csvTimeFormatToTimestamp(getEventDate(), getEventTime()), "getEventTimeStamp",foundEvent.get().getEldSequence());
            checkDoubleValue(foundEvent.get().getDistanceSinceLastValidCoords(), getDistanceLastValidCoordinates(), "getDistanceLastValidCoordinates",foundEvent.get().getEldSequence());
            checkIntValue(foundEvent.get().getMalfunctionIndicatorStatus(), getMalfunctionIndicatorStatus(), "getMalfunctionIndicatorStatus",foundEvent.get().getEldSequence());

        } catch (NoSuchElementException e){
            log.error("* * * * No Such Event!");
            ErrorLogs.setNoSuchElementLogs("No Such Event! " + "CSV -> " + this.toString() + "DB -> " + foundEvent.toString() + "\n");
        }
    }

    public static class Builder {
        private UnidentifiedEvents newUnidentifiedEvents;
        public Builder(){
            newUnidentifiedEvents = new UnidentifiedEvents();
        }
        public Builder setEventSequence(String eventSequence){
            newUnidentifiedEvents.eventSequence =eventSequence;
            return this;
        }
        public Builder setRecordOrigin(int recordOrigin){
            newUnidentifiedEvents.recordOrigin= recordOrigin;
            return this;
        }
        public Builder setRecordStatus(int recordStatus){
            newUnidentifiedEvents.recordStatus=recordStatus;
            return this;
        }
        public Builder setEventType(int eventType){
            newUnidentifiedEvents.eventType=eventType;
            return this;
        }
        public Builder setEventCode(int eventCode){
            newUnidentifiedEvents.eventCode=eventCode;
            return this;
        }
        public Builder setEventTime(String eventTime){
            newUnidentifiedEvents.eventTime=eventTime;
            return this;
        }
        public Builder setEventDate(String eventDate){
            newUnidentifiedEvents.eventDate=eventDate;
            return this;
        }
        public Builder setAccumulatedVehicleMiles(double accumulatedVehicleMiles){
            newUnidentifiedEvents.accumulatedVehicleMiles =accumulatedVehicleMiles;
            return this;
        }
        public Builder setElapsedEngineHours(double elapsedEngineHours){
            newUnidentifiedEvents.elapsedEngineHours =elapsedEngineHours;
            return this;
        }
        public Builder setLatitude(String latitude){
            newUnidentifiedEvents.latitude=latitude;
            return this;
        }
        public Builder setLongitude(String longitude){
            newUnidentifiedEvents.longitude=longitude;
            return this;
        }
        public Builder setOrderNumberForRecordOriginator(String orderNumberForRecordOriginator){
            newUnidentifiedEvents.orderNumberForRecordOriginator=orderNumberForRecordOriginator;
            return this;
        }
        public Builder setDistanceLastValidCoordinates(double distanceLastValidCoordinates){
            newUnidentifiedEvents.distanceLastValidCoordinates=distanceLastValidCoordinates;
            return this;
        }
        public Builder setDataDiagnosticEventIndicatorStatus(int dataDiagnosticEventIndicatorStatus){
            newUnidentifiedEvents.dataDiagnosticEventIndicatorStatus=dataDiagnosticEventIndicatorStatus;
            return this;
        }
        public Builder setEventDataCheckValue(String eventDataCheckValue){
            newUnidentifiedEvents.eventDataCheckValue=eventDataCheckValue;
            return this;
        }
        public Builder setOrderNumber(String orderNumber){
            newUnidentifiedEvents.orderNumber=orderNumber;
            return this;
        }
        public Builder setMalfunctionIndicatorStatus(int malfunctionIndicatorStatus){
            newUnidentifiedEvents.malfunctionIndicatorStatus=malfunctionIndicatorStatus;
            return this;
        }
        public UnidentifiedEvents build(){
            return newUnidentifiedEvents;
        }
    }
}
