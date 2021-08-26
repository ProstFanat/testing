package migration;

import db.RecordMapperValueObject;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class TrailerDeviceSignalHistory extends RecordMapperValueObject implements Serializable {
    public Long signalHistoryId;
    public Long previousHistoryId;
    public Long trailerId;
    public Date createDate;
    public Date signalTime;
    public String lat;
    public String lng;
    public Integer heading;
    public Integer altitude;
    public Character cargoLoaded;
    public Character fridgeOn;
    public BigDecimal temperature;
    public Character powerOn;
    public String battery;
    public Integer speed;
    public Character moving;
    public Date movingStartTime;
    public Date movingStopTime;
    public Integer deltaDistance;
    public String triggerZoneGeomIdList;
    public String city;
    public String provState;
    public String signalEvent;
    public Date processedZoneTrigger;
    public Date processedMovementTrigger;
    public Date processedVantagePointTrip;
    public Long orgId;

    public TrailerDeviceSignalHistory(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        //this.signalHistoryId = getLong(rs, "signal_history_id", rsColumns);
       // this.previousHistoryId = getLong(rs, "previous_history_id", rsColumns);
       // this.trailerId = getLong(rs, "trailer_id", rsColumns);
        this.createDate = getDate(rs, "create_date", rsColumns);
        this.signalTime = getDate(rs, "signal_time", rsColumns);
        this.lat = getString(rs, "lat", rsColumns);
        this.lng = getString(rs, "lng", rsColumns);
        this.heading = getInteger(rs, "heading", rsColumns);
        this.altitude = getInteger(rs, "altitude", rsColumns);
        this.cargoLoaded = getCharacter(rs, "cargo_loaded", rsColumns);
        this.fridgeOn = getCharacter(rs, "fridge_on", rsColumns);
        this.temperature = getBigDecimal(rs, "temperature", rsColumns);
        this.powerOn = getCharacter(rs, "power_on", rsColumns);
        this.battery = getString(rs, "battery", rsColumns);
        this.speed = getInteger(rs, "speed", rsColumns);
        this.moving = getCharacter(rs, "moving", rsColumns);
        this.movingStartTime = getDate(rs, "moving_start_time", rsColumns);
        this.movingStopTime = getDate(rs, "moving_stop_time", rsColumns);
        this.deltaDistance = getInteger(rs, "delta_distance", rsColumns);
       // this.triggerZoneGeomIdList = getString(rs, "trigger_zone_geom_id_list", rsColumns);
        this.city = getString(rs, "city", rsColumns);
        this.provState = getString(rs, "prov_state", rsColumns);
        this.signalEvent = getString(rs, "signal_event", rsColumns);
        this.processedZoneTrigger = getDate(rs, "processed_zone_trigger", rsColumns);
        this.processedMovementTrigger = getDate(rs, "processed_movement_trigger", rsColumns);
        this.processedVantagePointTrip = getDate(rs, "processed_vantage_point_trip", rsColumns);
        //this.orgId = getLong(rs, "org_id", rsColumns);
    }

    @Override
    public String toString() {
        return "TrailerDeviceSignalHistory{" +
                "signalHistoryId=" + signalHistoryId +
                ", previousHistoryId=" + previousHistoryId +
                ", trailerId=" + trailerId +
                ", createDate=" + createDate +
                ", signalTime=" + signalTime +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", heading=" + heading +
                ", altitude=" + altitude +
                ", cargoLoaded=" + cargoLoaded +
                ", fridgeOn=" + fridgeOn +
                ", temperature=" + temperature +
                ", powerOn=" + powerOn +
                ", battery='" + battery + '\'' +
                ", speed=" + speed +
                ", moving=" + moving +
                ", movingStartTime=" + movingStartTime +
                ", movingStopTime=" + movingStopTime +
                ", deltaDistance=" + deltaDistance +
                ", triggerZoneGeomIdList='" + triggerZoneGeomIdList + '\'' +
                ", city='" + city + '\'' +
                ", provState='" + provState + '\'' +
                ", signalEvent='" + signalEvent + '\'' +
                ", processedZoneTrigger=" + processedZoneTrigger +
                ", processedMovementTrigger=" + processedMovementTrigger +
                ", processedVantagePointTrip=" + processedVantagePointTrip +
                ", orgId=" + orgId +
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

    public Long getTrailerId() {
        return trailerId;
    }

    public void setTrailerId(Long trailerId) {
        this.trailerId = trailerId;
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

    public Character getCargoLoaded() {
        return cargoLoaded;
    }

    public void setCargoLoaded(Character cargoLoaded) {
        this.cargoLoaded = cargoLoaded;
    }

    public Character getFridgeOn() {
        return fridgeOn;
    }

    public void setFridgeOn(Character fridgeOn) {
        this.fridgeOn = fridgeOn;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public Character getPowerOn() {
        return powerOn;
    }

    public void setPowerOn(Character powerOn) {
        this.powerOn = powerOn;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
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

    public Integer getDeltaDistance() {
        return deltaDistance;
    }

    public void setDeltaDistance(Integer deltaDistance) {
        this.deltaDistance = deltaDistance;
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

    public String getSignalEvent() {
        return signalEvent;
    }

    public void setSignalEvent(String signalEvent) {
        this.signalEvent = signalEvent;
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

    @Override
    public List<Field> getFields() {
        return null;
    }
}