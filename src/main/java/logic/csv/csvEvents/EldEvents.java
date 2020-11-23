package logic.csv.csvEvents;

import logic.csv.ErrorLogs;
import logic.dbConnection.entity.EventEntity;
import logic.pojo.EventsPojo;
import logic.variables.events.EventTimestamp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class EldEvents extends EventCSV  {

    @Override
    public void compareEventsFromCsvAndDb(List<EventsPojo> eventsFromDb) {
        checkEventForRequirement(this);
        Optional<EventsPojo> foundEvent = null;
        try {
            foundEvent = findEventFromCsvInDb(eventsFromDb);
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
            checkIntValue(foundEvent.get().getDataDiagnosticEventIdicatorStatus(), getDataDiagnosticEventIndicatorStatus(), "getDataDiagnosticEventIndicatorStatus",foundEvent.get().getEldSequence());
        } catch (NoSuchElementException e){
            log.error("* * * * No Such Event!");
            ErrorLogs.setNoSuchElementLogs("No Such Event! " + "CSV -> " + this.toString() + "DB -> " + foundEvent.toString() + "\n");
        }

    }

    @Override
    public String toString() {
        return "EldEvent{" +
                "eventSequence='" + eventSequence + '\'' +
                ", recordStatus=" + recordStatus +
                ", recordOrigin=" + recordOrigin +
                ", eventCode=" + eventCode +
                ", eventType=" + eventType +
                ", eventDate=" + eventDate +
                ", eventTime=" + eventTime +
                ", accumulatedVehicleMiles='" + accumulatedVehicleMiles + '\'' +
                ", elapsedEngineHours='" + elapsedEngineHours + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", distanceLastValidCoordinates=" + distanceLastValidCoordinates +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderNumberForRecordOriginator='" + orderNumberForRecordOriginator + '\'' +
                ", malfunctionIndicatorStatus='" + malfunctionIndicatorStatus + '\'' +
                ", dataDiagnosticEventIndicatorStatus=" + dataDiagnosticEventIndicatorStatus +
                ", eventDataCheckValue='" + eventDataCheckValue + '\'' +
                "\n";
    }

    @Override
    public Optional<EventsPojo> findEventFromCsvInDb(List<EventsPojo> eventFromDb) {
        return super.findEventFromCsvInDb(eventFromDb);
    }

    public static class Builder {
        private EldEvents newEldEldEvents;
        public Builder(){
            newEldEldEvents = new EldEvents();
        }
        public Builder setEventSequence(String eventSequence){
            newEldEldEvents.eventSequence =eventSequence;
            return this;
        }
        public Builder setRecordOrigin(int recordOrigin){
            newEldEldEvents.recordOrigin= recordOrigin;
            return this;
        }
        public Builder setRecordStatus(int recordStatus){
            newEldEldEvents.recordStatus=recordStatus;
            return this;
        }
        public Builder setEventType(int eventType){
            newEldEldEvents.eventType=eventType;
            return this;
        }
        public Builder setEventCode(int eventCode){
            newEldEldEvents.eventCode=eventCode;
            return this;
        }
        public Builder setEventTime(String eventTime){
            newEldEldEvents.eventTime=eventTime;
            return this;
        }
        public Builder setEventDate(String eventDate){
            newEldEldEvents.eventDate=eventDate;
            return this;
        }
        public Builder setAccumulatedVehicleMiles(double accumulatedVehicleMiles){
            newEldEldEvents.accumulatedVehicleMiles =accumulatedVehicleMiles;
            return this;
        }
        public Builder setElapsedEngineHours(double elapsedEngineHours){
            newEldEldEvents.elapsedEngineHours =elapsedEngineHours;
            return this;
        }
        public Builder setLatitude(String latitude){
            newEldEldEvents.latitude=latitude;
            return this;
        }
        public Builder setLongitude(String longitude){
            newEldEldEvents.longitude=longitude;
            return this;
        }
        public Builder setOrderNumberForRecordOriginator(String orderNumberForRecordOriginator){
            newEldEldEvents.orderNumberForRecordOriginator=orderNumberForRecordOriginator;
            return this;
        }
        public Builder setDistanceLastValidCoordinates(double distanceLastValidCoordinates){
            newEldEldEvents.distanceLastValidCoordinates=distanceLastValidCoordinates;
            return this;
        }
        public Builder setDataDiagnosticEventIndicatorStatus(int dataDiagnosticEventIndicatorStatus){
            newEldEldEvents.dataDiagnosticEventIndicatorStatus=dataDiagnosticEventIndicatorStatus;
            return this;
        }
        public Builder setMalfunctionIndicatorStatus(int malfunctionIndicatorStatus){
            newEldEldEvents.malfunctionIndicatorStatus=malfunctionIndicatorStatus;
            return this;
        }
        public Builder setEventDataCheckValue(String eventDataCheckValue){
            newEldEldEvents.eventDataCheckValue=eventDataCheckValue;
            return this;
        }
        public Builder setOrderNumber(String orderNumber){
            newEldEldEvents.orderNumber=orderNumber;
            return this;
        }
        public EldEvents build(){
            return newEldEldEvents;
        }
    }

}
