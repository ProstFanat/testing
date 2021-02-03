package Migration;

import DB.RecordMapperValueObject;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Set;

public class EldSignalHistory extends RecordMapperValueObject {
    private Long historyId;
    private Long previousHistoryId;
    private Long orgId;
    private Date createDate;
    private Long driverId1;
    private Long driverId2;
    private Long truckId;
    private String latitude;
    private String longitude;
    private String latitudeSecondary;
    private String longitudeSecondary;
    private Date signalTime;
    private Boolean engineOn;
    private String vin;
    private String rpm;
    private String speed;
    private String odometer;
    private String distanceSinceEngineStart;
    private String engineHours;
    private String engineRuntime;
    private String voltage;
    private String stateCode;
    private String eldDeviceName;
    private String eldDeviceSerial;
    private String eldDeviceVersion;
    private Long dataProviderId;
    private Long truckDeviceSignalHistoryId;
    private String locationDescription;

    public EldSignalHistory(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        this.historyId = getLong(rs, "history_id", rsColumns);
        this.previousHistoryId = getLong(rs, "previous_history_id", rsColumns);
        this.orgId = getLong(rs, "org_id", rsColumns);
        this.createDate = getDate(rs, "create_date", rsColumns);
        this.driverId1 = getLong(rs, "driver_id_1", rsColumns);
        this.driverId2 = getLong(rs, "driver_id_2", rsColumns);
        this.truckId = getLong(rs, "truck_id", rsColumns);
        this.latitude = getString(rs, "latitude", rsColumns);
        this.longitude = getString(rs, "longitude", rsColumns);
        this.latitudeSecondary = getString(rs, "latitude_secondary", rsColumns);
        this.longitudeSecondary = getString(rs, "longitude_secondary", rsColumns);
        this.signalTime = getDate(rs, "signal_time", rsColumns);
        this.engineOn = getBooleanFromCharacter(rs, "truck_id", rsColumns);
        this.vin = getString(rs, "vin", rsColumns);
        this.rpm = getString(rs, "rpm", rsColumns);
        this.speed = getString(rs, "speed", rsColumns);
        this.odometer = getString(rs, "odometer", rsColumns);
        this.distanceSinceEngineStart = getString(rs, "distance_since_engine_start", rsColumns);
        this.engineHours = getString(rs, "engine_hours", rsColumns);
        this.engineRuntime = getString(rs, "engine_runtime", rsColumns);
        this.voltage = getString(rs, "voltage", rsColumns);
        this.stateCode = getString(rs, "state_code", rsColumns);
        this.eldDeviceName = getString(rs, "eld_device_name", rsColumns);
        this.eldDeviceSerial = getString(rs, "eld_device_serial", rsColumns);
        this.eldDeviceVersion = getString(rs, "eld_device_version", rsColumns);
        this.dataProviderId = getLong(rs, "data_provider_id", rsColumns);
        this.truckDeviceSignalHistoryId = getLong(rs, "truck_device_signal_history_id", rsColumns);
        this.locationDescription = getString(rs, "location_description", rsColumns);
    }

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public Long getPreviousHistoryId() {
        return previousHistoryId;
    }

    public void setPreviousHistoryId(Long previousHistoryId) {
        this.previousHistoryId = previousHistoryId;
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

    public Date getSignalTime() {
        return signalTime;
    }

    public void setSignalTime(Date signalTime) {
        this.signalTime = signalTime;
    }

    public Boolean getEngineOn() {
        return engineOn;
    }

    public void setEngineOn(Boolean engineOn) {
        this.engineOn = engineOn;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getRpm() {
        return rpm;
    }

    public void setRpm(String rpm) {
        this.rpm = rpm;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getOdometer() {
        return odometer;
    }

    public void setOdometer(String odometer) {
        this.odometer = odometer;
    }

    public String getDistanceSinceEngineStart() {
        return distanceSinceEngineStart;
    }

    public void setDistanceSinceEngineStart(String distanceSinceEngineStart) {
        this.distanceSinceEngineStart = distanceSinceEngineStart;
    }

    public String getEngineHours() {
        return engineHours;
    }

    public void setEngineHours(String engineHours) {
        this.engineHours = engineHours;
    }

    public String getEngineRuntime() {
        return engineRuntime;
    }

    public void setEngineRuntime(String engineRuntime) {
        this.engineRuntime = engineRuntime;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getEldDeviceName() {
        return eldDeviceName;
    }

    public void setEldDeviceName(String eldDeviceName) {
        this.eldDeviceName = eldDeviceName;
    }

    public String getEldDeviceSerial() {
        return eldDeviceSerial;
    }

    public void setEldDeviceSerial(String eldDeviceSerial) {
        this.eldDeviceSerial = eldDeviceSerial;
    }

    public String getEldDeviceVersion() {
        return eldDeviceVersion;
    }

    public void setEldDeviceVersion(String eldDeviceVersion) {
        this.eldDeviceVersion = eldDeviceVersion;
    }

    public Long getDataProviderId() {
        return dataProviderId;
    }

    public void setDataProviderId(Long dataProviderId) {
        this.dataProviderId = dataProviderId;
    }

    public Long getTruckDeviceSignalHistoryId() {
        return truckDeviceSignalHistoryId;
    }

    public void setTruckDeviceSignalHistoryId(Long truckDeviceSignalHistoryId) {
        this.truckDeviceSignalHistoryId = truckDeviceSignalHistoryId;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    @Override
    public String toString() {
        return "EldSignalHistory{" +
                "historyId=" + historyId +
                ", previousHistoryId=" + previousHistoryId +
                ", orgId=" + orgId +
                ", createDate=" + createDate +
                ", driverId1=" + driverId1 +
                ", driverId2=" + driverId2 +
                ", truckId=" + truckId +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitudeSecondary='" + latitudeSecondary + '\'' +
                ", longitudeSecondary='" + longitudeSecondary + '\'' +
                ", signalTime=" + signalTime +
                ", engineOn=" + engineOn +
                ", vin='" + vin + '\'' +
                ", rpm='" + rpm + '\'' +
                ", speed='" + speed + '\'' +
                ", odometer='" + odometer + '\'' +
                ", distanceSinceEngineStart='" + distanceSinceEngineStart + '\'' +
                ", engineHours='" + engineHours + '\'' +
                ", engineRuntime='" + engineRuntime + '\'' +
                ", voltage='" + voltage + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", eldDeviceName='" + eldDeviceName + '\'' +
                ", eldDeviceSerial='" + eldDeviceSerial + '\'' +
                ", eldDeviceVersion='" + eldDeviceVersion + '\'' +
                ", dataProviderId=" + dataProviderId +
                ", truckDeviceSignalHistoryId=" + truckDeviceSignalHistoryId +
                ", locationDescription='" + locationDescription + '\'' +
                '}';
    }
}
