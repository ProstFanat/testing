
package logic.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class EventsPojo {

    @SerializedName("eventId")
    @Expose
    private String eventId;
    @SerializedName("orgId")
    @Expose
    private String orgId;
    @SerializedName("createDate")
    @Expose
    private String createDate;
    @SerializedName("driverId1")
    @Expose
    private String driverId1;
    @SerializedName("driverId2")
    @Expose
    private String driverId2;
    @SerializedName("truckId")
    @Expose
    private String truckId;
    @SerializedName("truckNumber")
    @Expose
    private String truckNumber;
    @SerializedName("trailerNumber")
    @Expose
    private String trailerNumber;
    @SerializedName("truckVin")
    @Expose
    private String truckVin;
    @SerializedName("deviceUid")
    @Expose
    private String deviceUid;
    @SerializedName("eventSequence")
    @Expose
    private Integer eventSequence;
    @SerializedName("recordStatus")
    @Expose
    private Integer recordStatus;
    @SerializedName("recordOrigin")
    @Expose
    private Integer recordOrigin;
    @SerializedName("eventType")
    @Expose
    private Integer eventType;
    @SerializedName("eventCode")
    @Expose
    private Integer eventCode;
    @SerializedName("eventDate")
    @Expose
    private String eventDate;
    @SerializedName("eventTime")
    @Expose
    private String eventTime;
    @SerializedName("timeZoneOffset")
    @Expose
    private String timeZoneOffset;
    @SerializedName("eventTimestamp")
    @Expose
    private long eventTimestamp;
    @SerializedName("eventTimestampMs")
    @Expose
    private String eventTimestampMs;
    @SerializedName("accumulatedVehicleMiles")
    @Expose
    private double accumulatedVehicleMiles;
    @SerializedName("totalVehicleMiles")
    @Expose
    private double totalVehicleMiles;
    @SerializedName("elapsedEngineHours")
    @Expose
    private double elapsedEngineHours;
    @SerializedName("totalEngineHours")
    @Expose
    private double totalEngineHours;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("latitudeSecondary")
    @Expose
    private String latitudeSecondary;
    @SerializedName("longitudeSecondary")
    @Expose
    private String longitudeSecondary;
    @SerializedName("locationDescription")
    @Expose
    private String locationDescription;
    @SerializedName("distanceSinceLastValidCoords")
    @Expose
    private double distanceSinceLastValidCoords;
    @SerializedName("malfunctionIndicatorStatus")
    @Expose
    private int malfunctionIndicatorStatus;
    @SerializedName("dataDiagnosticEventIdicatorStatus")
    @Expose
    private int dataDiagnosticEventIdicatorStatus;
    @SerializedName("malfunctionDiagnosticCode")
    @Expose
    private String malfunctionDiagnosticCode;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("dataCheckValue")
    @Expose
    private String dataCheckValue;
    @SerializedName("driverCertified")
    @Expose
    private String driverCertified;
    @SerializedName("shippingNumber")
    @Expose
    private String shippingNumber;
    @SerializedName("certifiedDate")
    @Expose
    private Object certifiedDate;
    @SerializedName("borderCrossingDate")
    @Expose
    private String borderCrossingDate;
    @SerializedName("deviceSequence")
    @Expose
    private String deviceSequence;
    @SerializedName("deleteTime")
    @Expose
    private String deleteTime;
    @SerializedName("distanceCoord")
    @Expose
    private String distanceCoord;
    @SerializedName("distanceOdo")
    @Expose
    private String distanceOdo;
    @SerializedName("metaDataStatus")
    @Expose
    private String metaDataStatus;
    @SerializedName("speed")
    @Expose
    private String speed;
    @SerializedName("homeTerminalTimeZone")
    @Expose
    private String homeTerminalTimeZone;
    @SerializedName("eldSequence")
    @Expose
    private String eldSequence;
    @SerializedName("elogAppMode")
    @Expose
    private String elogAppMode;
    @SerializedName("deviceType")
    @Expose
    private String deviceType;
    @SerializedName("appVersion")
    @Expose
    private String appVersion;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("provState")
    @Expose
    private String provState;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("eventVersion")
    @Expose
    private String eventVersion;
    @SerializedName("fuelPurchaseReceiptId")
    @Expose
    private String fuelPurchaseReceiptId;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("rejectedDrivers")
    @Expose
    private String rejectedDrivers;
    @SerializedName("dataGap")
    @Expose
    private String dataGap;
    @SerializedName("processedSpeedViolationProcessor")
    @Expose
    private String processedSpeedViolationProcessor;
    @SerializedName("remoteEventId")
    @Expose
    private String remoteEventId;
    @SerializedName("oldEventId")
    @Expose
    private String oldEventId;
    @SerializedName("isPersonalConveyanceOrYardMove")
    @Expose
    private String isPersonalConveyanceOrYardMove;
    @SerializedName("totalVehicleMilesEnd")
    @Expose
    private String totalVehicleMilesEnd;
    @SerializedName("eldSerialNumber")
    @Expose
    private String eldSerialNumber;
    @SerializedName("trailerHooked")
    @Expose
    private String trailerHooked;
    @SerializedName("trailerDropped")
    @Expose
    private String trailerDropped;
    @SerializedName("shippingNumberStarted")
    @Expose
    private String shippingNumberStarted;
    @SerializedName("shippingNumberStopped")
    @Expose
    private String shippingNumberStopped;
    @SerializedName("originalEvent")
    @Expose
    private String originalEvent;
    @SerializedName("oldTimestamp")
    @Expose
    private String oldTimestamp;
    @SerializedName("meta")
    @Expose
    private String meta;
    @SerializedName("fleetManagerCommentUnnasign")
    @Expose
    private String fleetManagerCommentUnnasign;
    @SerializedName("straightDistanceBetweenEvents")
    @Expose
    private String straightDistanceBetweenEvents;
    @SerializedName("eventBlocked")
    @Expose
    private String eventBlocked;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDriverId1() {
        return driverId1;
    }

    public void setDriverId1(String driverId1) {
        this.driverId1 = driverId1;
    }

    public String getDriverId2() {
        return driverId2;
    }

    public void setDriverId2(String driverId2) {
        this.driverId2 = driverId2;
    }

    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public String getTrailerNumber() {
        return trailerNumber;
    }

    public void setTrailerNumber(String trailerNumber) {
        this.trailerNumber = trailerNumber;
    }

    public String getTruckVin() {
        return truckVin;
    }

    public void setTruckVin(String truckVin) {
        this.truckVin = truckVin;
    }

    public String getDeviceUid() {
        return deviceUid;
    }

    public void setDeviceUid(String deviceUid) {
        this.deviceUid = deviceUid;
    }

    public Integer getEventSequence() {
        return eventSequence;
    }

    public void setEventSequence(Integer eventSequence) {
        this.eventSequence = eventSequence;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Integer getRecordOrigin() {
        return recordOrigin;
    }

    public void setRecordOrigin(Integer recordOrigin) {
        this.recordOrigin = recordOrigin;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public Integer getEventCode() {
        return eventCode;
    }

    public void setEventCode(Integer eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getTimeZoneOffset() {
        return timeZoneOffset;
    }

    public void setTimeZoneOffset(String timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
    }

    public long getEventTimestamp() {
        return eventTimestamp;
    }

    public void setEventTimestamp(long eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public String getEventTimestampMs() {
        return eventTimestampMs;
    }

    public void setEventTimestampMs(String eventTimestampMs) {
        this.eventTimestampMs = eventTimestampMs;
    }

    public double getAccumulatedVehicleMiles() {
        return accumulatedVehicleMiles;
    }

    public void setAccumulatedVehicleMiles(double accumulatedVehicleMiles) {
        this.accumulatedVehicleMiles = accumulatedVehicleMiles;
    }

    public double getTotalVehicleMiles() {
        return totalVehicleMiles;
    }

    public void setTotalVehicleMiles(double totalVehicleMiles) {
        this.totalVehicleMiles = totalVehicleMiles;
    }

    public double getElapsedEngineHours() {
        return elapsedEngineHours;
    }

    public void setElapsedEngineHours(double elapsedEngineHours) {
        this.elapsedEngineHours = elapsedEngineHours;
    }

    public double getTotalEngineHours() {
        return totalEngineHours;
    }

    public void setTotalEngineHours(double totalEngineHours) {
        this.totalEngineHours = totalEngineHours;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitudeSecondary() {
        return latitudeSecondary;
    }

    public void setLatitudeSecondary(String latitudeSecondary) {
        this.latitudeSecondary = latitudeSecondary;
    }

    public String getLongitudeSecondary() {
        return longitudeSecondary;
    }

    public void setLongitudeSecondary(String longitudeSecondary) {
        this.longitudeSecondary = longitudeSecondary;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public double getDistanceSinceLastValidCoords() {
        return distanceSinceLastValidCoords;
    }

    public void setDistanceSinceLastValidCoords(double distanceSinceLastValidCoords) {
        this.distanceSinceLastValidCoords = distanceSinceLastValidCoords;
    }

    public int getMalfunctionIndicatorStatus() {
        return malfunctionIndicatorStatus;
    }

    public void setMalfunctionIndicatorStatus(int malfunctionIndicatorStatus) {
        this.malfunctionIndicatorStatus = malfunctionIndicatorStatus;
    }

    public int getDataDiagnosticEventIdicatorStatus() {
        return dataDiagnosticEventIdicatorStatus;
    }

    public void setDataDiagnosticEventIdicatorStatus(int dataDiagnosticEventIdicatorStatus) {
        this.dataDiagnosticEventIdicatorStatus = dataDiagnosticEventIdicatorStatus;
    }

    public String getMalfunctionDiagnosticCode() {
        return malfunctionDiagnosticCode;
    }

    public void setMalfunctionDiagnosticCode(String malfunctionDiagnosticCode) {
        this.malfunctionDiagnosticCode = malfunctionDiagnosticCode;
    }

    public String getComment() {
        if(comment!=null)
            return comment.replaceAll("[^A-Za-zА-Яа-я0-9]", "");
        else return "";
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDataCheckValue() {
        return dataCheckValue;
    }

    public void setDataCheckValue(String dataCheckValue) {
        this.dataCheckValue = dataCheckValue;
    }

    public String getDriverCertified() {
        return driverCertified;
    }

    public void setDriverCertified(String driverCertified) {
        this.driverCertified = driverCertified;
    }

    public String getShippingNumber() {
        return shippingNumber;
    }

    public void setShippingNumber(String shippingNumber) {
        this.shippingNumber = shippingNumber;
    }

    public Object getCertifiedDate() {
        return certifiedDate;
    }

    public void setCertifiedDate(Object certifiedDate) {
        this.certifiedDate = certifiedDate;
    }

    public String getBorderCrossingDate() {
        return borderCrossingDate;
    }

    public void setBorderCrossingDate(String borderCrossingDate) {
        this.borderCrossingDate = borderCrossingDate;
    }

    public String getDeviceSequence() {
        return deviceSequence;
    }

    public void setDeviceSequence(String deviceSequence) {
        this.deviceSequence = deviceSequence;
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getDistanceCoord() {
        return distanceCoord;
    }

    public void setDistanceCoord(String distanceCoord) {
        this.distanceCoord = distanceCoord;
    }

    public String getDistanceOdo() {
        return distanceOdo;
    }

    public void setDistanceOdo(String distanceOdo) {
        this.distanceOdo = distanceOdo;
    }

    public String getMetaDataStatus() {
        return metaDataStatus;
    }

    public void setMetaDataStatus(String metaDataStatus) {
        this.metaDataStatus = metaDataStatus;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getHomeTerminalTimeZone() {
        return homeTerminalTimeZone;
    }

    public void setHomeTerminalTimeZone(String homeTerminalTimeZone) {
        this.homeTerminalTimeZone = homeTerminalTimeZone;
    }

    public String getEldSequence() {
        return eldSequence;
    }

    public void setEldSequence(String eldSequence) {
        this.eldSequence = eldSequence;
    }

    public String getElogAppMode() {
        return elogAppMode;
    }

    public void setElogAppMode(String elogAppMode) {
        this.elogAppMode = elogAppMode;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvState() {
        return provState;
    }

    public void setProvState(String provState) {
        this.provState = provState;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEventVersion() {
        return eventVersion;
    }

    public void setEventVersion(String eventVersion) {
        this.eventVersion = eventVersion;
    }

    public String getFuelPurchaseReceiptId() {
        return fuelPurchaseReceiptId;
    }

    public void setFuelPurchaseReceiptId(String fuelPurchaseReceiptId) {
        this.fuelPurchaseReceiptId = fuelPurchaseReceiptId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getRejectedDrivers() {
        return rejectedDrivers;
    }

    public void setRejectedDrivers(String rejectedDrivers) {
        this.rejectedDrivers = rejectedDrivers;
    }

    public String getDataGap() {
        return dataGap;
    }

    public void setDataGap(String dataGap) {
        this.dataGap = dataGap;
    }

    public String getProcessedSpeedViolationProcessor() {
        return processedSpeedViolationProcessor;
    }

    public void setProcessedSpeedViolationProcessor(String processedSpeedViolationProcessor) {
        this.processedSpeedViolationProcessor = processedSpeedViolationProcessor;
    }

    public String getRemoteEventId() {
        return remoteEventId;
    }

    public void setRemoteEventId(String remoteEventId) {
        this.remoteEventId = remoteEventId;
    }

    public String getOldEventId() {
        return oldEventId;
    }

    public void setOldEventId(String oldEventId) {
        this.oldEventId = oldEventId;
    }

    public String getIsPersonalConveyanceOrYardMove() {
        return isPersonalConveyanceOrYardMove;
    }

    public void setIsPersonalConveyanceOrYardMove(String isPersonalConveyanceOrYardMove) {
        this.isPersonalConveyanceOrYardMove = isPersonalConveyanceOrYardMove;
    }

    public String getTotalVehicleMilesEnd() {
        return totalVehicleMilesEnd;
    }

    public void setTotalVehicleMilesEnd(String totalVehicleMilesEnd) {
        this.totalVehicleMilesEnd = totalVehicleMilesEnd;
    }

    public String getEldSerialNumber() {
        return eldSerialNumber;
    }

    public void setEldSerialNumber(String eldSerialNumber) {
        this.eldSerialNumber = eldSerialNumber;
    }

    public String getTrailerHooked() {
        return trailerHooked;
    }

    public void setTrailerHooked(String trailerHooked) {
        this.trailerHooked = trailerHooked;
    }

    public String getTrailerDropped() {
        return trailerDropped;
    }

    public void setTrailerDropped(String trailerDropped) {
        this.trailerDropped = trailerDropped;
    }

    public String getShippingNumberStarted() {
        return shippingNumberStarted;
    }

    public void setShippingNumberStarted(String shippingNumberStarted) {
        this.shippingNumberStarted = shippingNumberStarted;
    }

    public String getShippingNumberStopped() {
        return shippingNumberStopped;
    }

    public void setShippingNumberStopped(String shippingNumberStopped) {
        this.shippingNumberStopped = shippingNumberStopped;
    }

    public String getOriginalEvent() {
        return originalEvent;
    }

    public void setOriginalEvent(String originalEvent) {
        this.originalEvent = originalEvent;
    }

    public String getOldTimestamp() {
        return oldTimestamp;
    }

    public void setOldTimestamp(String oldTimestamp) {
        this.oldTimestamp = oldTimestamp;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getFleetManagerCommentUnnasign() {
        return fleetManagerCommentUnnasign;
    }

    public void setFleetManagerCommentUnnasign(String fleetManagerCommentUnnasign) {
        this.fleetManagerCommentUnnasign = fleetManagerCommentUnnasign;
    }

    public String getStraightDistanceBetweenEvents() {
        return straightDistanceBetweenEvents;
    }

    public void setStraightDistanceBetweenEvents(String straightDistanceBetweenEvents) {
        this.straightDistanceBetweenEvents = straightDistanceBetweenEvents;
    }

    public String getEventBlocked() {
        return eventBlocked;
    }

    public void setEventBlocked(String eventBlocked) {
        this.eventBlocked = eventBlocked;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("eventId", eventId).append("orgId", orgId).append("createDate", createDate).append("driverId1", driverId1).append("driverId2", driverId2).append("truckId", truckId).append("truckNumber", truckNumber).append("trailerNumber", trailerNumber).append("truckVin", truckVin).append("deviceUid", deviceUid).append("eventSequence", eventSequence).append("recordStatus", recordStatus).append("recordOrigin", recordOrigin).append("eventType", eventType).append("eventCode", eventCode).append("eventDate", eventDate).append("eventTime", eventTime).append("timeZoneOffset", timeZoneOffset).append("eventTimestamp", eventTimestamp).append("eventTimestampMs", eventTimestampMs).append("accumulatedVehicleMiles", accumulatedVehicleMiles).append("totalVehicleMiles", totalVehicleMiles).append("elapsedEngineHours", elapsedEngineHours).append("totalEngineHours", totalEngineHours).append("latitude", latitude).append("longitude", longitude).append("latitudeSecondary", latitudeSecondary).append("longitudeSecondary", longitudeSecondary).append("locationDescription", locationDescription).append("distanceSinceLastValidCoords", distanceSinceLastValidCoords).append("malfunctionIndicatorStatus", malfunctionIndicatorStatus).append("dataDiagnosticEventIdicatorStatus", dataDiagnosticEventIdicatorStatus).append("malfunctionDiagnosticCode", malfunctionDiagnosticCode).append("comment", comment).append("dataCheckValue", dataCheckValue).append("driverCertified", driverCertified).append("shippingNumber", shippingNumber).append("certifiedDate", certifiedDate).append("borderCrossingDate", borderCrossingDate).append("deviceSequence", deviceSequence).append("deleteTime", deleteTime).append("distanceCoord", distanceCoord).append("distanceOdo", distanceOdo).append("metaDataStatus", metaDataStatus).append("speed", speed).append("homeTerminalTimeZone", homeTerminalTimeZone).append("eldSequence", eldSequence).append("elogAppMode", elogAppMode).append("deviceType", deviceType).append("appVersion", appVersion).append("country", country).append("provState", provState).append("city", city).append("eventVersion", eventVersion).append("fuelPurchaseReceiptId", fuelPurchaseReceiptId).append("platform", platform).append("rejectedDrivers", rejectedDrivers).append("dataGap", dataGap).append("processedSpeedViolationProcessor", processedSpeedViolationProcessor).append("remoteEventId", remoteEventId).append("oldEventId", oldEventId).append("isPersonalConveyanceOrYardMove", isPersonalConveyanceOrYardMove).append("totalVehicleMilesEnd", totalVehicleMilesEnd).append("eldSerialNumber", eldSerialNumber).append("trailerHooked", trailerHooked).append("trailerDropped", trailerDropped).append("shippingNumberStarted", shippingNumberStarted).append("shippingNumberStopped", shippingNumberStopped).append("originalEvent", originalEvent).append("oldTimestamp", oldTimestamp).append("meta", meta).append("fleetManagerCommentUnnasign", fleetManagerCommentUnnasign).append("straightDistanceBetweenEvents", straightDistanceBetweenEvents).append("eventBlocked", eventBlocked).toString();
    }

}