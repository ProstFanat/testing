package Migration;

import DB.RecordMapperValueObject;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Set;

public class  TruckDeviceSignalHistory extends RecordMapperValueObject implements Serializable {
    private Long signalHistoryId;
    private Long previousHistoryId;
    private Long truckId;
    private Date createDate;
    private Date signalTime;
    private String lat;
    private String lng;
    private Integer heading;
    private Integer altitude;
    private Character ignitionOn;
    private String battery;
    private String odometer;
    private Integer speed;
    private Character moving;
    private Date movingStartTime;
    private Date movingStopTime;
    private String triggerZoneGeomIdList;
    private String city;
    private String provState;
    private String extra;
    private String signalEvent;
    private String driverUID1;
    private String driverUID2;
    private Long driverProfile1Id;
    private Long driverProfile2Id;
    private Integer deltaDistance;
    private Date processedZoneTrigger;
    private Date processedMovementTrigger;
    private Date processedVantagePointTrip;
    private Long orgId;
    private String foundAddress;

    public TruckDeviceSignalHistory(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
       // this.signalHistoryId = getLong(rs, "signal_history_id", rsColumns);
       // this.previousHistoryId = getLong(rs, "previous_history_id", rsColumns);
      //  this.truckId = getLong(rs, "truck_id", rsColumns);
        this.createDate = getDate(rs, "create_date", rsColumns);
        this.signalTime = getDate(rs, "signal_time", rsColumns);
        this.lat = getString(rs, "lat", rsColumns);
        this.lng = getString(rs, "lng", rsColumns);
        this.heading = getInteger(rs, "heading", rsColumns);
        this.altitude = getInteger(rs, "altitude", rsColumns);
        this.ignitionOn = getCharacter(rs, "ignition_on", rsColumns);
        this.battery = getString(rs, "battery", rsColumns);
        this.odometer = getString(rs, "odometer", rsColumns);
        this.speed = getInteger(rs, "speed", rsColumns);
        this.moving = getCharacter(rs, "moving", rsColumns);
        this.movingStartTime = getDate(rs, "moving_start_time", rsColumns);
        this.movingStopTime = getDate(rs, "moving_stop_time", rsColumns);
        this.triggerZoneGeomIdList = getString(rs, "trigger_zone_geom_id_list", rsColumns);
        this.city = getString(rs, "city", rsColumns);
        this.provState = getString(rs, "prov_state", rsColumns);
        this.extra = getString(rs, "extra", rsColumns);
        this.signalEvent = getString(rs, "signal_event", rsColumns);
        this.driverUID1 = getString(rs, "driver_uid_1", rsColumns);
        this.driverUID2 = getString(rs, "driver_uid_2", rsColumns);
      //  this.driverProfile1Id = getLong(rs, "driver_profile_1_id", rsColumns);
      //  this.driverProfile2Id = getLong(rs, "driver_profile_2_id", rsColumns);
        this.deltaDistance = getInteger(rs, "delta_distance", rsColumns);
        this.processedZoneTrigger = getDate(rs, "processed_zone_trigger", rsColumns);
        this.processedMovementTrigger = getDate(rs, "processed_movement_trigger", rsColumns);
        this.processedVantagePointTrip = getDate(rs, "processed_vantage_point_trip", rsColumns);
       // this.orgId = getLong(rs, "org_id", rsColumns);
        this.foundAddress = getString(rs, "found_address", rsColumns);
    }

    @Override
    public String toString() {
        return "TruckDeviceSignalHistory{" +
                "signalHistoryId=" + signalHistoryId +
                ", previousHistoryId=" + previousHistoryId +
                ", truckId=" + truckId +
                ", createDate=" + createDate +
                ", signalTime=" + signalTime +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", heading=" + heading +
                ", altitude=" + altitude +
                ", ignitionOn=" + ignitionOn +
                ", battery='" + battery + '\'' +
                ", odometer='" + odometer + '\'' +
                ", speed=" + speed +
                ", moving=" + moving +
                ", movingStartTime=" + movingStartTime +
                ", movingStopTime=" + movingStopTime +
                ", triggerZoneGeomIdList='" + triggerZoneGeomIdList + '\'' +
                ", city='" + city + '\'' +
                ", provState='" + provState + '\'' +
                ", extra='" + extra + '\'' +
                ", signalEvent='" + signalEvent + '\'' +
                ", driverUID1='" + driverUID1 + '\'' +
                ", driverUID2='" + driverUID2 + '\'' +
                ", driverProfile1Id=" + driverProfile1Id +
                ", driverProfile2Id=" + driverProfile2Id +
                ", deltaDistance=" + deltaDistance +
                ", processedZoneTrigger=" + processedZoneTrigger +
                ", processedMovementTrigger=" + processedMovementTrigger +
                ", processedVantagePointTrip=" + processedVantagePointTrip +
                ", orgId=" + orgId +
                ", foundAddress='" + foundAddress + '\'' +
                '}';
    }

    public Long getSignalHistoryId() {
        return signalHistoryId;
    }

    public void setSignalHistoryId(Long signalHistoryId) {
        this.signalHistoryId = signalHistoryId;
    }

    public Long getPreviousHistoryId() {
        return previousHistoryId;
    }

    public void setPreviousHistoryId(Long previousHistoryId) {
        this.previousHistoryId = previousHistoryId;
    }

    public Long getTruckId() {
        return truckId;
    }

    public void setTruckId(Long truckId) {
        this.truckId = truckId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getSignalTime() {
        return signalTime;
    }

    public void setSignalTime(Date signalTime) {
        this.signalTime = signalTime;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Integer getHeading() {
        return heading;
    }

    public void setHeading(Integer heading) {
        this.heading = heading;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public Character getIgnitionOn() {
        return ignitionOn;
    }

    public void setIgnitionOn(Character ignitionOn) {
        this.ignitionOn = ignitionOn;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getOdometer() {
        return odometer;
    }

    public void setOdometer(String odometer) {
        this.odometer = odometer;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Character getMoving() {
        return moving;
    }

    public void setMoving(Character moving) {
        this.moving = moving;
    }

    public Date getMovingStartTime() {
        return movingStartTime;
    }

    public void setMovingStartTime(Date movingStartTime) {
        this.movingStartTime = movingStartTime;
    }

    public Date getMovingStopTime() {
        return movingStopTime;
    }

    public void setMovingStopTime(Date movingStopTime) {
        this.movingStopTime = movingStopTime;
    }

    public String getTriggerZoneGeomIdList() {
        return triggerZoneGeomIdList;
    }

    public void setTriggerZoneGeomIdList(String triggerZoneGeomIdList) {
        this.triggerZoneGeomIdList = triggerZoneGeomIdList;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvState() {
        return provState;
    }

    public void setProvState(String provState) {
        this.provState = provState;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getSignalEvent() {
        return signalEvent;
    }

    public void setSignalEvent(String signalEvent) {
        this.signalEvent = signalEvent;
    }

    public String getDriverUID1() {
        return driverUID1;
    }

    public void setDriverUID1(String driverUID1) {
        this.driverUID1 = driverUID1;
    }

    public String getDriverUID2() {
        return driverUID2;
    }

    public void setDriverUID2(String driverUID2) {
        this.driverUID2 = driverUID2;
    }

    public Long getDriverProfile1Id() {
        return driverProfile1Id;
    }

    public void setDriverProfile1Id(Long driverProfile1Id) {
        this.driverProfile1Id = driverProfile1Id;
    }

    public Long getDriverProfile2Id() {
        return driverProfile2Id;
    }

    public void setDriverProfile2Id(Long driverProfile2Id) {
        this.driverProfile2Id = driverProfile2Id;
    }

    public Integer getDeltaDistance() {
        return deltaDistance;
    }

    public void setDeltaDistance(Integer deltaDistance) {
        this.deltaDistance = deltaDistance;
    }

    public Date getProcessedZoneTrigger() {
        return processedZoneTrigger;
    }

    public void setProcessedZoneTrigger(Date processedZoneTrigger) {
        this.processedZoneTrigger = processedZoneTrigger;
    }

    public Date getProcessedMovementTrigger() {
        return processedMovementTrigger;
    }

    public void setProcessedMovementTrigger(Date processedMovementTrigger) {
        this.processedMovementTrigger = processedMovementTrigger;
    }

    public Date getProcessedVantagePointTrip() {
        return processedVantagePointTrip;
    }

    public void setProcessedVantagePointTrip(Date processedVantagePointTrip) {
        this.processedVantagePointTrip = processedVantagePointTrip;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getFoundAddress() {
        return foundAddress;
    }

    public void setFoundAddress(String foundAddress) {
        this.foundAddress = foundAddress;
    }
}
