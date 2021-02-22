package Migration;

import DB.RecordMapperValueObject;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Truck extends RecordMapperValueObject {
    private Long truckId;
    private String refTruckId;
    private String truckNumber;
    private Long organizationId;
    private String vin;
    private String licensePlate;
    private String licenseStateProvince;
    private String make;
    private String model;
    private String modelYear;
    private String tare;
    private Character fifthWheel;
    private String gpsProvider; // constants for providers are in GPSSignalProvider class
    private String gpsUnitId;
    private String eldSerialNumber;
    private Integer maxSpeedForStop;
    private Integer minStopDuration;
    private Integer minStopDeltaDistanceMeters = 200;
    private String fuelType = "diesel";
    private Character onTrip = 'N';
    private Long borderConnectTruckTypeId;
    private Integer odometerOffset; // for PT30 device
    private Character readTruckFaultCode = 'N';
    private Date requestTruckFaultCode;
    private Character constantlyProcessFaultCodes = 'N';
    private Long eldSequence;
    private Long masterDBRefId;
    private Long clientDBRefId;

    private Date updateDate;

    private String pt30SerialNumber;
    private String pt30SerialVersion;
    private boolean isNeedUpdatePt30SerialVersion;

    // JOIN customs.border_connect_truck_type
    private String borderConnectTruckType;

    private List<Tag> tags = new ArrayList<>();

    private Date positionTime;


    private String status;

    private String odometer;//current odometer value (while from the myshawtracking_position_report)

    private DriverProfile driverProfile;

    private Long currentDriverProfileId1;

    private Long currentDriverProfileId2;

    private String refUnitAddress; //only for MyShawTracking

    private Long currentLoggedInDriver;

    private Boolean isExistUnidentifiedEvents;

    private Character personalUseAllow = 'N';

    private Integer personalUseLimit;

    private Character yardMoveAllow = 'N';

    private Integer yardMoveLimit;


    public Truck(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        //this.truckId                        = getLong(rs, "truck_id", rsColumns);
       // this.refTruckId                     = getString(rs, "ref_truck_id", rsColumns);
        this.truckNumber                    = getString(rs, "truck_number", rsColumns);
       // this.organizationId                 = getLong(rs, "organization_id", rsColumns);
        this.vin                            = getString(rs, "vin", rsColumns);
        this.licensePlate                   = getString(rs, "license_plate", rsColumns);
        this.licenseStateProvince           = getString(rs, "license_state_province", rsColumns);
        this.make                           = getString(rs, "make", rsColumns);
        this.model                          = getString(rs, "model", rsColumns);
        this.modelYear                      = getString(rs, "model_year", rsColumns);
        this.tare                           = getString(rs, "tare", rsColumns);
        this.fifthWheel                     = getCharacter(rs, "fifth_wheel", rsColumns);
        this.gpsProvider                    = getString(rs, "gps_provider", rsColumns);
       // this.gpsUnitId                      = getString(rs, "gps_unit_id", rsColumns);
        this.eldSerialNumber                = getString(rs, "eld_serial_number", rsColumns);
        this.maxSpeedForStop                = getInteger(rs, "max_speed_for_stop", rsColumns);
        this.minStopDuration                = getInteger(rs, "min_stop_duration", rsColumns);
        this.minStopDeltaDistanceMeters     = getInteger(rs, "min_stop_delta_distance_meters", rsColumns, 200);
        this.positionTime                   = getDate(rs, "ref_pos_ts", rsColumns);
        this.fuelType                       = getString(rs, "fuel_type", rsColumns);
        this.onTrip                         = getCharacter(rs, "on_trip", rsColumns, 'N');
        this.status                         = getString(rs, "status", rsColumns);
        this.borderConnectTruckTypeId       = getLong(rs, "border_connect_truck_type_id", rsColumns);
        this.odometerOffset                 = getInteger(rs, "odometer_offset", rsColumns);
        this.borderConnectTruckType         = getString(rs, "border_connect_truck_type", rsColumns);
        this.readTruckFaultCode				= getCharacter(rs, "read_truck_fault_code", rsColumns, 'N');
        this.requestTruckFaultCode			= getDate(rs, "request_truck_fault_code", rsColumns);
        this.constantlyProcessFaultCodes	= getCharacter(rs, "constantly_process_fault_codes", rsColumns, 'N');
       // this.currentDriverProfileId1        = getLong(rs, "current_driver_profile_id_1", rsColumns);
     //   this.currentDriverProfileId2        = getLong(rs, "current_driver_profile_id_2", rsColumns);
        this.eldSequence 					= getLong(rs, "eld_sequence", rsColumns);
        //this.updateDate 					= getDate(rs, "update_date", rsColumns);
        this.pt30SerialNumber               = getString(rs, "pt30_serial_number", rsColumns);
        this.pt30SerialVersion              = getString(rs, "pt30_serial_version", rsColumns);
        this.personalUseAllow 				= getCharacter(rs, "personal_use_allow", rsColumns, 'N');
        this.personalUseLimit 				= getInteger(rs, "personal_use_limit", rsColumns);
        this.yardMoveAllow				    = getCharacter(rs, "yard_move_allow", rsColumns, 'N');
        this.yardMoveLimit             		= getInteger(rs, "yard_move_limit", rsColumns);
        //this.masterDBRefId = getLong(rs, "master_db_ref_id", rsColumns);
      //  this.clientDBRefId = getLong(rs, "client_db_ref_id", rsColumns);
    }

    public Truck(final ResultSet rs, Set<String> rsColumns, String aaa) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        this.truckId                        = getLong(rs, "truck_id", rsColumns);
        this.refTruckId                     = getString(rs, "ref_truck_id", rsColumns);
        this.truckNumber                    = getString(rs, "truck_number", rsColumns);
        this.organizationId                 = getLong(rs, "organization_id", rsColumns);
        this.vin                            = getString(rs, "vin", rsColumns);
        this.licensePlate                   = getString(rs, "license_plate", rsColumns);
        this.licenseStateProvince           = getString(rs, "license_state_province", rsColumns);
        this.make                           = getString(rs, "make", rsColumns);
        this.model                          = getString(rs, "model", rsColumns);
        this.modelYear                      = getString(rs, "model_year", rsColumns);
        this.tare                           = getString(rs, "tare", rsColumns);
        this.fifthWheel                     = getCharacter(rs, "fifth_wheel", rsColumns);
        this.gpsProvider                    = getString(rs, "gps_provider", rsColumns);
        this.gpsUnitId                      = getString(rs, "gps_unit_id", rsColumns);
        this.eldSerialNumber                = getString(rs, "eld_serial_number", rsColumns);
        this.maxSpeedForStop                = getInteger(rs, "max_speed_for_stop", rsColumns);
        this.minStopDuration                = getInteger(rs, "min_stop_duration", rsColumns);
        this.minStopDeltaDistanceMeters     = getInteger(rs, "min_stop_delta_distance_meters", rsColumns, 200);
        this.positionTime                   = getDate(rs, "ref_pos_ts", rsColumns);
        this.fuelType                       = getString(rs, "fuel_type", rsColumns);
        this.onTrip                         = getCharacter(rs, "on_trip", rsColumns, 'N');
        this.status                         = getString(rs, "status", rsColumns);
        this.borderConnectTruckTypeId       = getLong(rs, "border_connect_truck_type_id", rsColumns);
        this.odometerOffset                 = getInteger(rs, "odometer_offset", rsColumns);
        this.borderConnectTruckType         = getString(rs, "border_connect_truck_type", rsColumns);
        this.readTruckFaultCode				= getCharacter(rs, "read_truck_fault_code", rsColumns, 'N');
        this.requestTruckFaultCode			= getDate(rs, "request_truck_fault_code", rsColumns);
        this.constantlyProcessFaultCodes	= getCharacter(rs, "constantly_process_fault_codes", rsColumns, 'N');
        this.currentDriverProfileId1        = getLong(rs, "current_driver_profile_id_1", rsColumns);
        this.currentDriverProfileId2        = getLong(rs, "current_driver_profile_id_2", rsColumns);
        this.eldSequence 					= getLong(rs, "eld_sequence", rsColumns);
        this.updateDate 					= getDate(rs, "update_date", rsColumns);
        this.pt30SerialNumber               = getString(rs, "pt30_serial_number", rsColumns);
        this.pt30SerialVersion              = getString(rs, "pt30_serial_version", rsColumns);
        this.personalUseAllow 				= getCharacter(rs, "personal_use_allow", rsColumns, 'N');
        this.personalUseLimit 				= getInteger(rs, "personal_use_limit", rsColumns);
        this.yardMoveAllow				    = getCharacter(rs, "yard_move_allow", rsColumns, 'N');
        this.yardMoveLimit             		= getInteger(rs, "yard_move_limit", rsColumns);
        this.masterDBRefId = getLong(rs, "master_db_ref_id", rsColumns);
        this.clientDBRefId = getLong(rs, "client_db_ref_id", rsColumns);
    }

    @Override
    public String toString() {
        return "Truck{" +
                "truckId=" + truckId +
                ", refTruckId='" + refTruckId + '\'' +
                ", truckNumber='" + truckNumber + '\'' +
                ", organizationId=" + organizationId +
                ", vin='" + vin + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", licenseStateProvince='" + licenseStateProvince + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", modelYear='" + modelYear + '\'' +
                ", tare='" + tare + '\'' +
                ", fifthWheel=" + fifthWheel +
                ", gpsProvider='" + gpsProvider + '\'' +
                ", gpsUnitId='" + gpsUnitId + '\'' +
                ", eldSerialNumber='" + eldSerialNumber + '\'' +
                ", maxSpeedForStop=" + maxSpeedForStop +
                ", minStopDuration=" + minStopDuration +
                ", minStopDeltaDistanceMeters=" + minStopDeltaDistanceMeters +
                ", fuelType='" + fuelType + '\'' +
                ", onTrip=" + onTrip +
                ", borderConnectTruckTypeId=" + borderConnectTruckTypeId +
                ", odometerOffset=" + odometerOffset +
                ", readTruckFaultCode=" + readTruckFaultCode +
                ", requestTruckFaultCode=" + requestTruckFaultCode +
                ", constantlyProcessFaultCodes=" + constantlyProcessFaultCodes +
                ", eldSequence=" + eldSequence +
                ", masterDBRefId=" + masterDBRefId +
                ", clientDBRefId=" + clientDBRefId +
                ", updateDate=" + updateDate +
                ", pt30SerialNumber='" + pt30SerialNumber + '\'' +
                ", pt30SerialVersion='" + pt30SerialVersion + '\'' +
                ", isNeedUpdatePt30SerialVersion=" + isNeedUpdatePt30SerialVersion +
                ", borderConnectTruckType='" + borderConnectTruckType + '\'' +
                ", tags=" + tags +
                ", positionTime=" + positionTime +
                ", status='" + status + '\'' +
                ", odometer='" + odometer + '\'' +
                ", driverProfile=" + driverProfile +
                ", currentDriverProfileId1=" + currentDriverProfileId1 +
                ", currentDriverProfileId2=" + currentDriverProfileId2 +
                ", refUnitAddress='" + refUnitAddress + '\'' +
                ", currentLoggedInDriver=" + currentLoggedInDriver +
                ", isExistUnidentifiedEvents=" + isExistUnidentifiedEvents +
                ", personalUseAllow=" + personalUseAllow +
                ", personalUseLimit=" + personalUseLimit +
                ", yardMoveAllow=" + yardMoveAllow +
                ", yardMoveLimit=" + yardMoveLimit +
                '}';
    }

    public Long getTruckId() {
        return truckId;
    }

    public void setTruckId(Long truckId) {
        this.truckId = truckId;
    }

    public String getRefTruckId() {
        return refTruckId;
    }

    public void setRefTruckId(String refTruckId) {
        this.refTruckId = refTruckId;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicenseStateProvince() {
        return licenseStateProvince;
    }

    public void setLicenseStateProvince(String licenseStateProvince) {
        this.licenseStateProvince = licenseStateProvince;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public String getTare() {
        return tare;
    }

    public void setTare(String tare) {
        this.tare = tare;
    }

    public Character getFifthWheel() {
        return fifthWheel;
    }

    public void setFifthWheel(Character fifthWheel) {
        this.fifthWheel = fifthWheel;
    }

    public String getGpsProvider() {
        return gpsProvider;
    }

    public void setGpsProvider(String gpsProvider) {
        this.gpsProvider = gpsProvider;
    }

    public String getGpsUnitId() {
        return gpsUnitId;
    }

    public void setGpsUnitId(String gpsUnitId) {
        this.gpsUnitId = gpsUnitId;
    }

    public String getEldSerialNumber() {
        return eldSerialNumber;
    }

    public void setEldSerialNumber(String eldSerialNumber) {
        this.eldSerialNumber = eldSerialNumber;
    }

    public Integer getMaxSpeedForStop() {
        return maxSpeedForStop;
    }

    public void setMaxSpeedForStop(Integer maxSpeedForStop) {
        this.maxSpeedForStop = maxSpeedForStop;
    }

    public Integer getMinStopDuration() {
        return minStopDuration;
    }

    public void setMinStopDuration(Integer minStopDuration) {
        this.minStopDuration = minStopDuration;
    }

    public Integer getMinStopDeltaDistanceMeters() {
        return minStopDeltaDistanceMeters;
    }

    public void setMinStopDeltaDistanceMeters(Integer minStopDeltaDistanceMeters) {
        this.minStopDeltaDistanceMeters = minStopDeltaDistanceMeters;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Character getOnTrip() {
        return onTrip;
    }

    public void setOnTrip(Character onTrip) {
        this.onTrip = onTrip;
    }

    public Long getBorderConnectTruckTypeId() {
        return borderConnectTruckTypeId;
    }

    public void setBorderConnectTruckTypeId(Long borderConnectTruckTypeId) {
        this.borderConnectTruckTypeId = borderConnectTruckTypeId;
    }

    public Integer getOdometerOffset() {
        return odometerOffset;
    }

    public void setOdometerOffset(Integer odometerOffset) {
        this.odometerOffset = odometerOffset;
    }

    public Character getReadTruckFaultCode() {
        return readTruckFaultCode;
    }

    public void setReadTruckFaultCode(Character readTruckFaultCode) {
        this.readTruckFaultCode = readTruckFaultCode;
    }

    public Date getRequestTruckFaultCode() {
        return requestTruckFaultCode;
    }

    public void setRequestTruckFaultCode(Date requestTruckFaultCode) {
        this.requestTruckFaultCode = requestTruckFaultCode;
    }

    public Character getConstantlyProcessFaultCodes() {
        return constantlyProcessFaultCodes;
    }

    public void setConstantlyProcessFaultCodes(Character constantlyProcessFaultCodes) {
        this.constantlyProcessFaultCodes = constantlyProcessFaultCodes;
    }

    public Long getEldSequence() {
        return eldSequence;
    }

    public void setEldSequence(Long eldSequence) {
        this.eldSequence = eldSequence;
    }

    public Long getMasterDBRefId() {
        return masterDBRefId;
    }

    public void setMasterDBRefId(Long masterDBRefId) {
        this.masterDBRefId = masterDBRefId;
    }

    public Long getClientDBRefId() {
        return clientDBRefId;
    }

    public void setClientDBRefId(Long clientDBRefId) {
        this.clientDBRefId = clientDBRefId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getPt30SerialNumber() {
        return pt30SerialNumber;
    }

    public void setPt30SerialNumber(String pt30SerialNumber) {
        this.pt30SerialNumber = pt30SerialNumber;
    }

    public String getPt30SerialVersion() {
        return pt30SerialVersion;
    }

    public void setPt30SerialVersion(String pt30SerialVersion) {
        this.pt30SerialVersion = pt30SerialVersion;
    }

    public boolean isNeedUpdatePt30SerialVersion() {
        return isNeedUpdatePt30SerialVersion;
    }

    public void setNeedUpdatePt30SerialVersion(boolean needUpdatePt30SerialVersion) {
        isNeedUpdatePt30SerialVersion = needUpdatePt30SerialVersion;
    }

    public String getBorderConnectTruckType() {
        return borderConnectTruckType;
    }

    public void setBorderConnectTruckType(String borderConnectTruckType) {
        this.borderConnectTruckType = borderConnectTruckType;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Date getPositionTime() {
        return positionTime;
    }

    public void setPositionTime(Date positionTime) {
        this.positionTime = positionTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOdometer() {
        return odometer;
    }

    public void setOdometer(String odometer) {
        this.odometer = odometer;
    }

    public DriverProfile getDriverProfile() {
        return driverProfile;
    }

    public void setDriverProfile(DriverProfile driverProfile) {
        this.driverProfile = driverProfile;
    }

    public Long getCurrentDriverProfileId1() {
        return currentDriverProfileId1;
    }

    public void setCurrentDriverProfileId1(Long currentDriverProfileId1) {
        this.currentDriverProfileId1 = currentDriverProfileId1;
    }

    public Long getCurrentDriverProfileId2() {
        return currentDriverProfileId2;
    }

    public void setCurrentDriverProfileId2(Long currentDriverProfileId2) {
        this.currentDriverProfileId2 = currentDriverProfileId2;
    }

    public String getRefUnitAddress() {
        return refUnitAddress;
    }

    public void setRefUnitAddress(String refUnitAddress) {
        this.refUnitAddress = refUnitAddress;
    }

    public Long getCurrentLoggedInDriver() {
        return currentLoggedInDriver;
    }

    public void setCurrentLoggedInDriver(Long currentLoggedInDriver) {
        this.currentLoggedInDriver = currentLoggedInDriver;
    }

    public Boolean getExistUnidentifiedEvents() {
        return isExistUnidentifiedEvents;
    }

    public void setExistUnidentifiedEvents(Boolean existUnidentifiedEvents) {
        isExistUnidentifiedEvents = existUnidentifiedEvents;
    }

    public Character getPersonalUseAllow() {
        return personalUseAllow;
    }

    public void setPersonalUseAllow(Character personalUseAllow) {
        this.personalUseAllow = personalUseAllow;
    }

    public Integer getPersonalUseLimit() {
        return personalUseLimit;
    }

    public void setPersonalUseLimit(Integer personalUseLimit) {
        this.personalUseLimit = personalUseLimit;
    }

    public Character getYardMoveAllow() {
        return yardMoveAllow;
    }

    public void setYardMoveAllow(Character yardMoveAllow) {
        this.yardMoveAllow = yardMoveAllow;
    }

    public Integer getYardMoveLimit() {
        return yardMoveLimit;
    }

    public void setYardMoveLimit(Integer yardMoveLimit) {
        this.yardMoveLimit = yardMoveLimit;
    }
}
