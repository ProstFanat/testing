package Migration;

import DB.RecordMapperValueObject;
import Migration.Fragments.GetNewId;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Set;

public class EldEvent extends RecordMapperValueObject {
    public Long eventId;
    public Long orgId;
    public Date createDate;
    public Long driverId1;
    public Long driverId2;
    public Long truckId;
    public String truckNumber;
    public String trailerNumber;
    public String truckVin;
    public String deviceUid;
    public Integer eventSequence;
    public Integer recordStatus;
    public Integer recordOrigin;
    public Integer eventType;
    public Integer eventCode;
    public String eventDate;
    public String eventTime;
    public String timeZoneOffset;
    public Date eventTimestamp;
    public Long eventTimestampMs;
    public String accumulatedVehicleMiles;
    public String totalVehicleMiles;
    public String elapsedEngineHours;
    public String totalEngineHours;
    public String latitude;
    public String longitude;
    public String latitudeSecondary;
    public String longitudeSecondary;
    public String locationDescription;
    public String distanceSinceLastValidCoords;
    public String malfunctionIndicatorStatus;
    public String dataDiagnosticEventIdicatorStatus;
    public String malfunctionDiagnosticCode;
    public String comment;
    public String dataCheckValue;
    public Date driverCertified;
    public String shippingNumber;
    public String certifiedDate;
    public Date borderCrossingDate;
    public Integer deviceSequence;
    public Date deleteTime;
    public Double distanceCoord;
    public Double distanceOdo;
    public String metaDataStatus;
    public Double speed;
    public String homeTerminalTimeZone;
    public Long eldSequence;
    public String elogAppMode;
    public String deviceType;
    public String appVersion;
    public String country;
    public String provState;
    public String city;
    public Integer eventVersion;
    public Long fuelPurchaseReceiptId;
    public String platform;
    public String rejectedDrivers;
    public Character dataGap = 'N';
    public Date processedSpeedViolationProcessor;
    public Long duration;



    public Long remoteEventId;


    public Long oldEventId;

    public Character isPersonalConveyanceOrYardMove; // for AOBRD mode only; used with OFF or ON events. OFF->PC, ON->YM
    public String totalVehicleMilesEnd; // odometer at the end of the event, this is used for AOBRD mode for Personal Conveyance or Yard Move events.
    public String eldSerialNumber;

    public String trailerHooked;  // FIXME: Remove this, we do not use this
    public String trailerDropped; // FIXME: Remove this, we do not use this
    public String shippingNumberStarted; // FIXME: Remove this, we do not use this
    public String shippingNumberStopped; // FIXME: Remove this, we do not use this



   // public ELDEvent originalEvent; // used as an original event to a requested change event (recordStatus=3)
   public Date oldTimestamp; // used for special edit of events to (keep the original timestamp)

   // public transient ELDEventMetaData meta = null;


    public String fleetManagerCommentUnnasign;

    public String straightDistanceBetweenEvents = "";


    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getDriverId1() {
        return driverId1;
    }

    public void setDriverId1(Long driverId1) {
        this.driverId1 = driverId1;
    }

    public Long getDriverId2() {
        return driverId2;
    }

    public void setDriverId2(Long driverId2) {
        this.driverId2 = driverId2;
    }

    public Long getTruckId() {
        return truckId;
    }

    public void setTruckId(Long truckId) {
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

    public Date getEventTimestamp() {
        return eventTimestamp;
    }

    public void setEventTimestamp(Date eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public Long getEventTimestampMs() {
        return eventTimestampMs;
    }

    public void setEventTimestampMs(Long eventTimestampMs) {
        this.eventTimestampMs = eventTimestampMs;
    }

    public String getAccumulatedVehicleMiles() {
        return accumulatedVehicleMiles;
    }

    public void setAccumulatedVehicleMiles(String accumulatedVehicleMiles) {
        this.accumulatedVehicleMiles = accumulatedVehicleMiles;
    }

    public String getTotalVehicleMiles() {
        return totalVehicleMiles;
    }

    public void setTotalVehicleMiles(String totalVehicleMiles) {
        this.totalVehicleMiles = totalVehicleMiles;
    }

    public String getElapsedEngineHours() {
        return elapsedEngineHours;
    }

    public void setElapsedEngineHours(String elapsedEngineHours) {
        this.elapsedEngineHours = elapsedEngineHours;
    }

    public String getTotalEngineHours() {
        return totalEngineHours;
    }

    public void setTotalEngineHours(String totalEngineHours) {
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

    public String getDistanceSinceLastValidCoords() {
        return distanceSinceLastValidCoords;
    }

    public void setDistanceSinceLastValidCoords(String distanceSinceLastValidCoords) {
        this.distanceSinceLastValidCoords = distanceSinceLastValidCoords;
    }

    public String getMalfunctionIndicatorStatus() {
        return malfunctionIndicatorStatus;
    }

    public void setMalfunctionIndicatorStatus(String malfunctionIndicatorStatus) {
        this.malfunctionIndicatorStatus = malfunctionIndicatorStatus;
    }

    public String getDataDiagnosticEventIdicatorStatus() {
        return dataDiagnosticEventIdicatorStatus;
    }

    public void setDataDiagnosticEventIdicatorStatus(String dataDiagnosticEventIdicatorStatus) {
        this.dataDiagnosticEventIdicatorStatus = dataDiagnosticEventIdicatorStatus;
    }

    public String getMalfunctionDiagnosticCode() {
        return malfunctionDiagnosticCode;
    }

    public void setMalfunctionDiagnosticCode(String malfunctionDiagnosticCode) {
        this.malfunctionDiagnosticCode = malfunctionDiagnosticCode;
    }

    public String getComment() {
        return comment;
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

    public Date getDriverCertified() {
        return driverCertified;
    }

    public void setDriverCertified(Date driverCertified) {
        this.driverCertified = driverCertified;
    }

    public String getShippingNumber() {
        return shippingNumber;
    }

    public void setShippingNumber(String shippingNumber) {
        this.shippingNumber = shippingNumber;
    }

    public String getCertifiedDate() {
        return certifiedDate;
    }

    public void setCertifiedDate(String certifiedDate) {
        this.certifiedDate = certifiedDate;
    }

    public Date getBorderCrossingDate() {
        return borderCrossingDate;
    }

    public void setBorderCrossingDate(Date borderCrossingDate) {
        this.borderCrossingDate = borderCrossingDate;
    }

    public Integer getDeviceSequence() {
        return deviceSequence;
    }

    public void setDeviceSequence(Integer deviceSequence) {
        this.deviceSequence = deviceSequence;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Double getDistanceCoord() {
        return distanceCoord;
    }

    public void setDistanceCoord(Double distanceCoord) {
        this.distanceCoord = distanceCoord;
    }

    public Double getDistanceOdo() {
        return distanceOdo;
    }

    public void setDistanceOdo(Double distanceOdo) {
        this.distanceOdo = distanceOdo;
    }

    public String getMetaDataStatus() {
        return metaDataStatus;
    }

    public void setMetaDataStatus(String metaDataStatus) {
        this.metaDataStatus = metaDataStatus;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getHomeTerminalTimeZone() {
        return homeTerminalTimeZone;
    }

    public void setHomeTerminalTimeZone(String homeTerminalTimeZone) {
        this.homeTerminalTimeZone = homeTerminalTimeZone;
    }

    public Long getEldSequence() {
        return eldSequence;
    }

    public void setEldSequence(Long eldSequence) {
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

    public Integer getEventVersion() {
        return eventVersion;
    }

    public void setEventVersion(Integer eventVersion) {
        this.eventVersion = eventVersion;
    }

    public Long getFuelPurchaseReceiptId() {
        return fuelPurchaseReceiptId;
    }

    public void setFuelPurchaseReceiptId(Long fuelPurchaseReceiptId) {
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

    public Character getDataGap() {
        return dataGap;
    }

    public void setDataGap(Character dataGap) {
        this.dataGap = dataGap;
    }

    public Date getProcessedSpeedViolationProcessor() {
        return processedSpeedViolationProcessor;
    }

    public void setProcessedSpeedViolationProcessor(Date processedSpeedViolationProcessor) {
        this.processedSpeedViolationProcessor = processedSpeedViolationProcessor;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getRemoteEventId() {
        return remoteEventId;
    }

    public void setRemoteEventId(Long remoteEventId) {
        this.remoteEventId = remoteEventId;
    }

    public Long getOldEventId() {
        return oldEventId;
    }

    public void setOldEventId(Long oldEventId) {
        this.oldEventId = oldEventId;
    }

    public Character getIsPersonalConveyanceOrYardMove() {
        return isPersonalConveyanceOrYardMove;
    }

    public void setIsPersonalConveyanceOrYardMove(Character isPersonalConveyanceOrYardMove) {
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

    public Date getOldTimestamp() {
        return oldTimestamp;
    }

    public void setOldTimestamp(Date oldTimestamp) {
        this.oldTimestamp = oldTimestamp;
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

    @Override
    public String toString() {
        return "EldEvent{" +
                "eventId=" + eventId +
                ", orgId=" + orgId +
                ", createDate=" + createDate +
                ", driverId1=" + driverId1 +
                ", driverId2=" + driverId2 +
                ", truckId=" + truckId +
                ", truckNumber='" + truckNumber + '\'' +
                ", trailerNumber='" + trailerNumber + '\'' +
                ", truckVin='" + truckVin + '\'' +
                ", deviceUid='" + deviceUid + '\'' +
                ", eventSequence=" + eventSequence +
                ", recordStatus=" + recordStatus +
                ", recordOrigin=" + recordOrigin +
                ", eventType=" + eventType +
                ", eventCode=" + eventCode +
                ", eventDate='" + eventDate + '\'' +
                ", eventTime='" + eventTime + '\'' +
                ", timeZoneOffset='" + timeZoneOffset + '\'' +
                ", eventTimestamp=" + eventTimestamp +
                ", eventTimestampMs=" + eventTimestampMs +
                ", accumulatedVehicleMiles='" + accumulatedVehicleMiles + '\'' +
                ", totalVehicleMiles='" + totalVehicleMiles + '\'' +
                ", elapsedEngineHours='" + elapsedEngineHours + '\'' +
                ", totalEngineHours='" + totalEngineHours + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitudeSecondary='" + latitudeSecondary + '\'' +
                ", longitudeSecondary='" + longitudeSecondary + '\'' +
                ", locationDescription='" + locationDescription + '\'' +
                ", distanceSinceLastValidCoords='" + distanceSinceLastValidCoords + '\'' +
                ", malfunctionIndicatorStatus='" + malfunctionIndicatorStatus + '\'' +
                ", dataDiagnosticEventIdicatorStatus='" + dataDiagnosticEventIdicatorStatus + '\'' +
                ", malfunctionDiagnosticCode='" + malfunctionDiagnosticCode + '\'' +
                ", comment='" + comment + '\'' +
                ", dataCheckValue='" + dataCheckValue + '\'' +
                ", driverCertified=" + driverCertified +
                ", shippingNumber='" + shippingNumber + '\'' +
                ", certifiedDate='" + certifiedDate + '\'' +
                ", borderCrossingDate=" + borderCrossingDate +
                ", deviceSequence=" + deviceSequence +
                ", deleteTime=" + deleteTime +
                ", distanceCoord=" + distanceCoord +
                ", distanceOdo=" + distanceOdo +
                ", metaDataStatus='" + metaDataStatus + '\'' +
                ", speed=" + speed +
                ", homeTerminalTimeZone='" + homeTerminalTimeZone + '\'' +
                ", eldSequence=" + eldSequence +
                ", elogAppMode='" + elogAppMode + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", country='" + country + '\'' +
                ", provState='" + provState + '\'' +
                ", city='" + city + '\'' +
                ", eventVersion=" + eventVersion +
                ", fuelPurchaseReceiptId=" + fuelPurchaseReceiptId +
                ", platform='" + platform + '\'' +
                ", rejectedDrivers='" + rejectedDrivers + '\'' +
                ", dataGap=" + dataGap +
                ", processedSpeedViolationProcessor=" + processedSpeedViolationProcessor +
                ", duration=" + duration +
                ", remoteEventId=" + remoteEventId +
                ", oldEventId=" + oldEventId +
                ", isPersonalConveyanceOrYardMove=" + isPersonalConveyanceOrYardMove +
                ", totalVehicleMilesEnd='" + totalVehicleMilesEnd + '\'' +
                ", eldSerialNumber='" + eldSerialNumber + '\'' +
                ", trailerHooked='" + trailerHooked + '\'' +
                ", trailerDropped='" + trailerDropped + '\'' +
                ", shippingNumberStarted='" + shippingNumberStarted + '\'' +
                ", shippingNumberStopped='" + shippingNumberStopped + '\'' +
                ", oldTimestamp=" + oldTimestamp +
                ", fleetManagerCommentUnnasign='" + fleetManagerCommentUnnasign + '\'' +
                ", straightDistanceBetweenEvents='" + straightDistanceBetweenEvents + '\'' +
                '}';
    }

    public EldEvent(ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
       // this.eventId = getLong(rs, "event_id", rsColumns);
       // this.orgId = getLong(rs, "org_id", rsColumns);
        //this.createDate = getDate(rs, "create_date", rsColumns);
       //  this.driverId1 = getLong(rs, "driver_id_1", rsColumns);
       // this.driverId2 = getLong(rs, "driver_id_2", rsColumns);
        //this.truckId = getLong(rs, "truck_id", rsColumns);
        this.truckNumber = getString(rs, "truck_number", rsColumns);
        this.trailerNumber = getString(rs, "trailer_number", rsColumns);
        this.truckVin = getString(rs, "truck_vin", rsColumns);
        this.deviceUid = getString(rs, "device_uid", rsColumns);
        this.eventSequence = getInteger(rs, "event_sequence", rsColumns);
        this.recordStatus = getInteger(rs, "record_status", rsColumns);
        this.recordOrigin = getInteger(rs, "record_origin", rsColumns);
        this.eventType = getInteger(rs, "event_type", rsColumns);
        this.eventCode = getInteger(rs, "event_code", rsColumns);
        this.eventDate = getString(rs, "event_date", rsColumns);
        this.eventTime = getString(rs, "event_time", rsColumns);
        this.timeZoneOffset = getString(rs, "time_zone_offset", rsColumns);
        this.eventTimestamp = getDate(rs, "event_timestamp", rsColumns);
        this.accumulatedVehicleMiles = getString(rs, "accumulated_vehicle_miles", rsColumns);
        this.totalVehicleMiles = getString(rs, "total_vehicle_miles", rsColumns);
        this.elapsedEngineHours = getString(rs, "elapsed_engine_hours", rsColumns);
        this.totalEngineHours = getString(rs, "total_engine_hours", rsColumns);
        this.latitude = getString(rs, "latitude", rsColumns);
        this.longitude = getString(rs, "longitude", rsColumns);
        this.latitudeSecondary = getString(rs, "latitude_secondary", rsColumns);
        this.longitudeSecondary = getString(rs, "longitude_secondary", rsColumns);
        this.locationDescription = getString(rs, "location_description", rsColumns);
        this.distanceSinceLastValidCoords = getString(rs, "distance_since_last_valid_coords", rsColumns);
        this.malfunctionIndicatorStatus = getString(rs, "malfunction_indicator_status", rsColumns);
        this.dataDiagnosticEventIdicatorStatus = getString(rs, "data_diagnostic_event_idicator_status", rsColumns);
        this.malfunctionDiagnosticCode = getString(rs, "malfunction_diagnostic_code", rsColumns);
        this.comment = getString(rs, "comment", rsColumns);
        this.dataCheckValue = getString(rs, "data_check_value", rsColumns);
        this.shippingNumber = getString(rs, "shipping_number", rsColumns);
        this.driverCertified = getDate(rs, "driver_certified", rsColumns);
        this.certifiedDate = getString(rs, "certified_date", rsColumns);
        this.borderCrossingDate = getDate(rs, "border_crossing_date", rsColumns);
        this.remoteEventId = getLong(rs, "remote_event_id", rsColumns);
        this.isPersonalConveyanceOrYardMove = getCharacter(rs, "is_personal_conveyance_or_yard_move", rsColumns, 'N');
        this.totalVehicleMilesEnd = getString(rs, "total_vehicle_miles_end", rsColumns);
        this.trailerHooked = getString(rs, "trailer_hooked", rsColumns);
        this.trailerDropped = getString(rs, "trailer_dropped", rsColumns);
        this.shippingNumberStarted = getString(rs, "shipping_number_started", rsColumns);
        this.shippingNumberStopped = getString(rs, "shipping_number_stopped", rsColumns);
        this.eldSerialNumber = getString(rs, "eld_serial_number", rsColumns);
        this.deviceSequence = getInteger(rs, "device_sequence", rsColumns);
        //this.deleteTime = getDate(rs, "delete_time", rsColumns);
        //this.eldSequence = getLong(rs, "eld_sequence", rsColumns);
        this.country = getString(rs, "country", rsColumns);
        this.provState = getString(rs, "prov_state", rsColumns);
        this.city = getString(rs, "city", rsColumns);
        this.eventVersion = getInteger(rs, "event_version", rsColumns);
        this.elogAppMode = getString(rs, "elog_app_mode", rsColumns);
        this.deviceType = getString(rs, "device_type", rsColumns);
        this.appVersion = getString(rs, "app_version", rsColumns);
        this.fuelPurchaseReceiptId = getLong(rs, "fuel_purchase_receipt_id", rsColumns);
        this.platform = getString(rs, "platform", rsColumns);
        this.rejectedDrivers = getString(rs, "rejected_drivers", rsColumns);
        this.dataGap = getCharacter(rs, "data_gap", rsColumns, 'N');
        this.fleetManagerCommentUnnasign = getString(rs, "fleet_manager_comment_unnasign", rsColumns);
    }

    public EldEvent(Long eventId, Long orgId, Date createDate, Long driverId1, Long driverId2, Long truckId, String truckNumber, String trailerNumber,
                    String truckVin, String deviceUid, Integer eventSequence, Integer recordStatus, Integer recordOrigin, Integer eventType,
                    Integer eventCode, String eventDate, String eventTime, String timeZoneOffset, Date eventTimestamp, Long eventTimestampMs,
                    String accumulatedVehicleMiles, String totalVehicleMiles, String elapsedEngineHours, String totalEngineHours, String latitude,
                    String longitude, String latitudeSecondary, String longitudeSecondary, String locationDescription, String distanceSinceLastValidCoords,
                    String malfunctionIndicatorStatus, String dataDiagnosticEventIdicatorStatus, String malfunctionDiagnosticCode, String comment,
                    String dataCheckValue, Date driverCertified, String shippingNumber, String certifiedDate, Date borderCrossingDate,
                    Integer deviceSequence, Date deleteTime, Long eldSequence, String elogAppMode, String deviceType, String appVersion,
                    String country, String provState, String city, Integer eventVersion, Long fuelPurchaseReceiptId, Long remoteEventId,
                    Character isPersonalConveyanceOrYardMove, String totalVehicleMilesEnd, String eldSerialNumber, String platform, Character dataGap) {
        this.eventId = eventId;
        this.orgId = orgId;
        this.createDate = createDate;
        this.driverId1 = driverId1;
        this.driverId2 = driverId2;
        this.truckId = truckId;
        this.truckNumber = truckNumber;
        this.trailerNumber = trailerNumber;
        this.truckVin = truckVin;
        this.deviceUid = deviceUid;
        this.eventSequence = eventSequence;
        this.recordStatus = recordStatus;
        this.recordOrigin = recordOrigin;
        this.eventType = eventType;
        this.eventCode = eventCode;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.timeZoneOffset = timeZoneOffset;
        this.eventTimestamp = eventTimestamp;
        this.eventTimestampMs = eventTimestampMs;
        this.accumulatedVehicleMiles = accumulatedVehicleMiles;
        this.totalVehicleMiles = totalVehicleMiles;
        this.elapsedEngineHours = elapsedEngineHours;
        this.totalEngineHours = totalEngineHours;
        this.latitude = latitude;
        this.longitude = longitude;
        this.latitudeSecondary = latitudeSecondary;
        this.longitudeSecondary = longitudeSecondary;
        this.locationDescription = locationDescription;
        this.distanceSinceLastValidCoords = distanceSinceLastValidCoords;
        this.malfunctionIndicatorStatus = malfunctionIndicatorStatus;
        this.dataDiagnosticEventIdicatorStatus = dataDiagnosticEventIdicatorStatus;
        this.malfunctionDiagnosticCode = malfunctionDiagnosticCode;
        this.comment = comment;
        this.dataCheckValue = dataCheckValue;
        this.driverCertified = driverCertified;
        this.shippingNumber = shippingNumber;
        this.certifiedDate = certifiedDate;
        this.borderCrossingDate = borderCrossingDate;
        this.deviceSequence = deviceSequence;
        this.deleteTime = deleteTime;
        this.eldSequence = eldSequence;
        this.elogAppMode = elogAppMode;
        this.deviceType = deviceType;
        this.appVersion = appVersion;
        this.country = country;
        this.provState = provState;
        this.city = city;
        this.eventVersion = eventVersion;
        this.fuelPurchaseReceiptId = fuelPurchaseReceiptId;
        this.remoteEventId = remoteEventId;
        this.isPersonalConveyanceOrYardMove = isPersonalConveyanceOrYardMove;
        this.totalVehicleMilesEnd = totalVehicleMilesEnd;
        this.eldSerialNumber = eldSerialNumber;
        this.platform = platform;
        this.dataGap = dataGap;
    }
}
