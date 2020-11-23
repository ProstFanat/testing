package logic.dbConnection.entity;

import logic.csv.csvEvents.EventCSV;
import logic.csv.csvEvents.MalfunctionsAndDataDiagnosticEvents;
import logic.variables.events.Event;

public class EventEntity {
    private long driver_id_1;
    private long truck_id;
    private long org_id;
    private int recordStatus;
    private int recordOrigin;
    private int eventType;
    private int eventCode;
    private String latitude;
    private String longitude;
    private String location_description;
    private String device_uid;
    private String eventSequence;
    private String eventTimeStamp;
    private double totalVehicleMiles;
    private double accumulatedVehicleMiles;
    private double totalEngineHours;
    private double elapsedEngineHours;
    private String orderNumber;
    private String eldUserName;
    private String powerUnitNumber;
    private String truckNumber;
    private String vinNumber;
    private String trailerNumber;
    private String shippingNumber;
    private String malfunctionOrDiagnosticCode;
    private String commentTextOrAnnotation;
    private String driverLocationDescription;
    private String orderNumberForRecordOriginator;
    private double distanceLastValidCoordinates;
    private int dataDiagnosticEventIndicatorStatus;
    private int malfunctionIndicatorStatus;
    private String dateOfTheCertifiedRecord;
    public EventEntity() {
    }

    public EventEntity(long driver_id_1, long truck_id, long org_id, int recordStatus, int recordOrigin, int eventType,
                       int eventCode, String latitude, String longitude, String location_description, String device_uid, String eventTimeStamp) {
        this.driver_id_1 = driver_id_1;
        this.truck_id = truck_id;
        this.org_id = org_id;
        this.recordStatus = recordStatus;
        this.recordOrigin = recordOrigin;
        this.eventType = eventType;
        this.eventCode = eventCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.location_description = location_description;
        this.device_uid = device_uid;
        this.eventTimeStamp = eventTimeStamp;
    }

    public long getDriver_id_1() {
        return driver_id_1;
    }

    public void setDriver_id_1(long driver_id_1) {
        this.driver_id_1 = driver_id_1;
    }

    public long getTruck_id() {
        return truck_id;
    }

    public void setTruck_id(long truck_id) {
        this.truck_id = truck_id;
    }

    public long getOrg_id() {
        return org_id;
    }

    public void setOrg_id(long org_id) {
        this.org_id = org_id;
    }

    public int getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(int recordStatus) {
        this.recordStatus = recordStatus;
    }

    public int getRecordOrigin() {
        return recordOrigin;
    }

    public void setRecordOrigin(int recordOrigin) {
        this.recordOrigin = recordOrigin;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public int getEventCode() {
        return eventCode;
    }

    public void setEventCode(int eventCode) {
        this.eventCode = eventCode;
    }

    public String getLatitude() {
        try {
            return EventCSV.roundNumToTwoNums(latitude);
        } catch (NullPointerException e){
            return "";
        } catch (NumberFormatException e) {
            return latitude;
        }
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        try {
            return EventCSV.roundNumToTwoNums(longitude);
        } catch (NullPointerException e){
            return "";
        } catch (NumberFormatException e) {
            return longitude;
        }
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLocation_description() {
        return location_description;
    }

    public void setLocation_description(String location_description) {
        this.location_description = location_description;
    }

    public String getDevice_uid() {
        return device_uid;
    }

    public void setDevice_uid(String device_uid) {
        this.device_uid = device_uid;
    }

    public String getEventSequence() {
        return eventSequence;
    }

    public void setEventSequence(String eventSequence) {
        this.eventSequence = eventSequence;
    }

    public String getEventTimeStamp() {
        return eventTimeStamp.split("\\.", 2)[0];
    }

    public void setEventTimeStamp(String eventTimeStamp) {
        this.eventTimeStamp = eventTimeStamp;
    }

    public double getTotalVehicleMiles() {
        return totalVehicleMiles;
    }

    public void setTotalVehicleMiles(double totalVehicleMiles) {
        this.totalVehicleMiles = totalVehicleMiles;
    }

    public double getAccumulatedVehicleMiles() {
        return accumulatedVehicleMiles;
    }

    public void setAccumulatedVehicleMiles(double accumulatedVehicleMiles) {
        this.accumulatedVehicleMiles = accumulatedVehicleMiles;
    }

    public double getTotalEngineHours() {
        return totalEngineHours;
    }

    public void setTotalEngineHours(double totalEngineHours) {
        this.totalEngineHours = totalEngineHours;
    }

    public double getElapsedEngineHours() {
        return elapsedEngineHours;
    }

    public void setElapsedEngineHours(double elapsedEngineHours) {
        this.elapsedEngineHours = elapsedEngineHours;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getEldUserName() {
        return eldUserName;
    }

    public void setEldUserName(String eldUserName) {
        this.eldUserName = eldUserName;
    }

    public String getPowerUnitNumber() {
        return powerUnitNumber;
    }

    public void setPowerUnitNumber(String powerUnitNumber) {
        this.powerUnitNumber = powerUnitNumber;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getTrailerNumber() {
        return trailerNumber;
    }

    public void setTrailerNumber(String trailerNumber) {
        this.trailerNumber=trailerNumber;
    }

    public String getShippingNumber() {
        return shippingNumber;
    }

    public void setShippingNumber(String shippingNumber) {
        this.shippingNumber=shippingNumber;
    }

    public String getMalfunctionOrDiagnosticCode() {
        return malfunctionOrDiagnosticCode;
    }

    public void setMalfunctionOrDiagnosticCode(String malfunctionOrDiagnosticCode) {
        this.malfunctionOrDiagnosticCode = malfunctionOrDiagnosticCode;
    }

    public String getCommentTextOrAnnotation() {
        if(commentTextOrAnnotation==null)
            return "";
        return commentTextOrAnnotation;    }

    public void setCommentTextOrAnnotation(String commentTextOrAnnotation) {
        this.commentTextOrAnnotation = commentTextOrAnnotation;
    }

    public String getDriverLocationDescription() {
        return driverLocationDescription;
    }

    public void setDriverLocationDescription(String driverLocationDescription) {
        this.driverLocationDescription = driverLocationDescription;
    }

    public String getOrderNumberForRecordOriginator() {
        return orderNumberForRecordOriginator;
    }

    public void setOrderNumberForRecordOriginator(String orderNumberForRecordOriginator) {
        this.orderNumberForRecordOriginator = orderNumberForRecordOriginator;
    }

    public double getDistanceLastValidCoordinates() {
        return distanceLastValidCoordinates;
    }

    public void setDistanceLastValidCoordinates(double distanceLastValidCoordinates) {
        this.distanceLastValidCoordinates = distanceLastValidCoordinates;
    }

    public int getDataDiagnosticEventIndicatorStatus() {
        return dataDiagnosticEventIndicatorStatus;
    }

    public void setDataDiagnosticEventIndicatorStatus(int dataDiagnosticEventIndicatorStatus) {
        this.dataDiagnosticEventIndicatorStatus = dataDiagnosticEventIndicatorStatus;
    }

    public int getMalfunctionIndicatorStatus() {
        return malfunctionIndicatorStatus;
    }

    public void setMalfunctionIndicatorStatus(int malfunctionIndicatorStatus) {
        this.malfunctionIndicatorStatus = malfunctionIndicatorStatus;
    }

    public String getDateOfTheCertifiedRecord() {
        return dateOfTheCertifiedRecord;
    }

    public void setDateOfTheCertifiedRecord(String dateOfTheCertifiedRecord) {
        this.dateOfTheCertifiedRecord = dateOfTheCertifiedRecord;
    }
    public static class Builder {
        private EventEntity eventEntity;
        public Builder(){
            eventEntity = new EventEntity();
        }
        public Builder setEventSequence(String eventSequence){
            eventEntity.eventSequence =eventSequence;
            return this;
        }
        public Builder setEventTimeStamp(String eventTimestamp){
            eventEntity.eventTimeStamp=eventTimestamp;
            return this;
        }
        public Builder setDriverId1(long driver_id_1){
            eventEntity.driver_id_1=driver_id_1;
            return this;
        }
        public Builder setEventCode(int eventCode){
            eventEntity.eventCode=eventCode;
            return this;
        }
        public Builder setRecordStatus(int recordStatus){
            eventEntity.recordStatus=recordStatus;
            return this;
        }
        public Builder setRecordOrigin(int recordOrigin){
            eventEntity.recordOrigin=recordOrigin;
            return this;
        }
        public Builder setEventType(int eventType){
            eventEntity.eventType=eventType;
            return this;
        }
        public Builder setTotalVehicleMiles(double totalVehicleMiles){
            eventEntity.totalVehicleMiles=totalVehicleMiles;
            return this;
        }
        public Builder setTotalEngineHours(double totalEngineHours){
            eventEntity.totalEngineHours=totalEngineHours;
            return this;
        }
        public Builder setElapsedEngineHours(double elapsedEngineHours){
            eventEntity.elapsedEngineHours=elapsedEngineHours;
            return this;
        }
        public Builder setAccumulatedVehicleMiles(double accumulatedVehicleMiles){
            eventEntity.accumulatedVehicleMiles=accumulatedVehicleMiles;
            return this;
        }
        public Builder setTruckNumber(String truckNumber){
            eventEntity.truckNumber=truckNumber;
            return this;
        }
        public Builder setLatitude(String latitude){
            eventEntity.latitude=latitude;
            return this;
        }
        public Builder setLongitude(String longitude){
            eventEntity.longitude=longitude;
            return this;
        }
        public Builder setLocationDescription(String location_description){
            eventEntity.location_description=location_description;
            return this;
        }
        public Builder setDeviceUid(String device_uid){
            eventEntity.device_uid=device_uid;
            return this;
        }
        public Builder setOrderNumber(String orderNumber){
            eventEntity.orderNumber=orderNumber;
            return this;
        }
        public Builder setEldUserName(String eldUserName){
            eventEntity.eldUserName=eldUserName;
            return this;
        }
        public Builder setPowerUnitNumber(String powerUnitNumber){
            eventEntity.powerUnitNumber=powerUnitNumber;
            return this;
        }
        public Builder setVinNumber(String vinNumber){
            eventEntity.vinNumber=vinNumber;
            return this;
        }
        public Builder setTrailerNumber(String trailerNumber){
            eventEntity.trailerNumber=trailerNumber;
            return this;
        }
        public Builder setShippingNumber(String shippingNumber){
            eventEntity.shippingNumber=shippingNumber;
            return this;
        }
        public Builder setMalfunctionOrDiagnosticCode(String malfunctionOrDiagnosticCode){
            eventEntity.malfunctionOrDiagnosticCode=malfunctionOrDiagnosticCode;
            return this;
        }
        public Builder setCommentTextOrAnnotation(String commentTextOrAnnotation){
            eventEntity.commentTextOrAnnotation=commentTextOrAnnotation;
            return this;
        }
        public Builder setDriverLocationDescription(String driverLocationDescription){
            eventEntity.driverLocationDescription=driverLocationDescription;
            return this;
        }
        public Builder setOrderNumberForRecordOriginator(String orderNumberForRecordOriginator){
            eventEntity.orderNumberForRecordOriginator=orderNumberForRecordOriginator;
            return this;
        }
        public Builder setDateOfTheCertifiedRecord(String dateOfTheCertifiedRecord){
            eventEntity.dateOfTheCertifiedRecord=dateOfTheCertifiedRecord;
            return this;
        }
        public Builder setDistanceLastValidCoordinates(double distanceLastValidCoordinates){
            eventEntity.distanceLastValidCoordinates=distanceLastValidCoordinates;
            return this;
        }
        public Builder setDataDiagnosticEventIndicatorStatus(int dataDiagnosticEventIndicatorStatus){
            eventEntity.dataDiagnosticEventIndicatorStatus=dataDiagnosticEventIndicatorStatus;
            return this;
        }
        public Builder setMalfunctionIndicatorStatus(int malfunctionIndicatorStatus){
            eventEntity.malfunctionIndicatorStatus=malfunctionIndicatorStatus;
            return this;
        }

        public EventEntity build(){
            return eventEntity;
        }
    }
    @Override
    public String toString() {
        return "EventEntity{" +
                "driver_id_1=" + driver_id_1 +
                ", truck_id=" + truck_id +
                ", org_id=" + org_id +
                ", location_description='" + location_description + '\'' +
                ", device_uid='" + device_uid + '\'' +
                ", eventSequence=" + eventSequence +
                ", record_status=" + recordStatus +
                ", record_origin=" + recordOrigin +
                ", event_type=" + eventType +
                ", event_code=" + eventCode +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", eventTimeStamp='" + eventTimeStamp + '\'' +
                ", totalVehicleMiles='" + totalVehicleMiles + '\'' +
                ", accumulatedVehicleMiles='" + accumulatedVehicleMiles + '\'' +
                ", totalEngineHours='" + totalEngineHours + '\'' +
                ", elapsedEngineHours='" + elapsedEngineHours + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", eldUserName='" + eldUserName + '\'' +
                ", powerUnitNumber='" + powerUnitNumber + '\'' +
                ", truckNumber='" + truckNumber + '\'' +
                ", vinNumber='" + vinNumber + '\'' +
                ", trailerNumber='" + trailerNumber + '\'' +
                ", shippingNumber='" + shippingNumber + '\'' +
                ", malfunctionOrDiagnosticCode='" + malfunctionOrDiagnosticCode + '\'' +
                ", commentTextOrAnnotation='" + commentTextOrAnnotation + '\'' +
                ", driverLocationDescription='" + driverLocationDescription + '\'' +
                ", distanceLastValidCoordinates='" + distanceLastValidCoordinates + '\'' +
                ", dataDiagnosticEventIndicatorStatus='" + dataDiagnosticEventIndicatorStatus + '\'' +
                ", malfunctionIndicatorStatus='" + malfunctionIndicatorStatus + '\'' +
                ", dateOfTheCertifiedRecord='" + dateOfTheCertifiedRecord + '\'' +
                "}\n";
    }

}

