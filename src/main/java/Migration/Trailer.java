package Migration;

import DB.RecordMapperValueObject;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Trailer extends RecordMapperValueObject implements Serializable {
    public Long trailerId;
    public String refTrailerId;
    public String picture;
    public String owner;
    public String trailerLength;
    public Long orgId;
    public String trailerNumber;
    public String gpsProvider; // constants in GPSSignalProvider
    public String gpsUnitId;
    public String vin;
    public String make;
    public String year;
    public String trailerType;
    public String licensePlate;
    public String licenseStateProvince;
    public String status;
    public Long borderConnectTrailerTypeId;

    public Long masterDBRefId;
    public Long clientDBRefId;

//    public Migration migration;

    // JOIN customs.border_connect_trailer_type
    public String borderConnectTrailerType;

    // join fields
    public Date positionTime;

    public List<Tag> tags = new ArrayList<>();

//    public TrailerDeviceSignal deviceSignal;

//    public List<MaintenancePartRecord> maintenanceList;

    public String battery;

    public Trailer(ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        //this.trailerId = getLong(rs, "trailer_id", rsColumns);                                          //addVOField("trailer_id", Types.BIGINT, "setTrailerId", Long.class, "getTrailerId");// 		addVOField("ref_trailer_id", Types.VARCHAR, "setRefTrailerId", String.class, "getRefTrailerId");
        this.picture = getString(rs, "picture", rsColumns);                                             //addVOField("picture", Types.VARCHAR, "setPicture", String.class, "getPicture");
        this.owner = getString(rs, "owner", rsColumns);                                                 //addVOField("owner", Types.VARCHAR, "setOwner", String.class, "getOwner");
        this.trailerLength = getString(rs, "trailer_length", rsColumns);                                //addVOField("trailer_length", Types.VARCHAR, "setTrailerLength", String.class, "getTrailerLength");
       // this.orgId = getLong(rs, "org_id", rsColumns);                                                  //addVOField("org_id", Types.BIGINT, "setOrgId", Long.class, "getOrgId");
        this.trailerNumber = getString(rs, "trailer_number", rsColumns);                                //addVOField("trailer_number", Types.VARCHAR, "setTrailerNumber", String.class, "getTrailerNumber");
        this.gpsProvider = getString(rs, "gps_provider", rsColumns);                                    //addVOField("gps_provider", Types.VARCHAR, "setGpsProvider", String.class, "getGpsProvider");
       // this.gpsUnitId = getString(rs, "gps_unit_id", rsColumns);                                       //addVOField("gps_unit_id", Types.VARCHAR, "setGpsUnitId", String.class, "getGpsUnitId");
        this.vin = getString(rs, "vin", rsColumns);                                                     //addVOField("vin", Types.VARCHAR, "setVin", String.class, "getVin");
        this.make = getString(rs, "make", rsColumns);                                                   //addVOField("make", Types.VARCHAR, "setMake", String.class, "getMake");
        this.year = getString(rs, "year", rsColumns);                                                   //addVOField("year", Types.VARCHAR, "setYear", String.class, "getYear");
        this.trailerType = getString(rs, "trailer_type", rsColumns);                                    //addVOField("trailer_type", Types.VARCHAR, "setTrailerType", String.class, "getTrailerType");
        this.licensePlate = getString(rs, "license_plate", rsColumns);                                  //addVOField("license_plate", Types.VARCHAR, "setLicensePlate", String.class, "getLicensePlate");
        this.licenseStateProvince = getString(rs, "license_state_province", rsColumns);                 //addVOField("license_state_province", Types.VARCHAR, "setLicenseStateProvince", String.class, "getLicenseStateProvince");
        this.status = getString(rs, "status", rsColumns);                                               //addVOField("status", Types.VARCHAR, "setStatus", String.class, "getStatus");
        this.borderConnectTrailerTypeId = getLong(rs, "border_connect_trailer_type_id", rsColumns);     //addVOField("border_connect_trailer_type_id", Types.BIGINT, "setBorderConnectTrailerTypeId", Long.class, "getBorderConnectTrailerTypeId");
        this.borderConnectTrailerType = getString(rs, "border_connect_trailer_type", rsColumns);        //addVOField("border_connect_trailer_type", Types.VARCHAR, "setBorderConnectTrailerType", String.class, "getBorderConnectTrailerType");

        //JOINS
        this.positionTime = getDate(rs, "ref_event_date_time", rsColumns);                              //addVOField("ref_event_date_time", Types.TIMESTAMP, "setPositionTime", Date.class, "getPositionTime");
        this.battery = getString(rs, "battery", rsColumns);                                             //addVOField("battery", Types.VARCHAR, "setBattery", String.class, "getBattery");

       // this.masterDBRefId = getLong(rs, "master_db_ref_id", rsColumns);
       // this.clientDBRefId = getLong(rs, "client_db_ref_id", rsColumns);
    }

    public Trailer(ResultSet rs, Set<String> rsColumns, String a) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        this.trailerId = getLong(rs, "trailer_id", rsColumns);                                          //addVOField("trailer_id", Types.BIGINT, "setTrailerId", Long.class, "getTrailerId");// 		addVOField("ref_trailer_id", Types.VARCHAR, "setRefTrailerId", String.class, "getRefTrailerId");
        this.picture = getString(rs, "picture", rsColumns);                                             //addVOField("picture", Types.VARCHAR, "setPicture", String.class, "getPicture");
        this.owner = getString(rs, "owner", rsColumns);                                                 //addVOField("owner", Types.VARCHAR, "setOwner", String.class, "getOwner");
        this.trailerLength = getString(rs, "trailer_length", rsColumns);                                //addVOField("trailer_length", Types.VARCHAR, "setTrailerLength", String.class, "getTrailerLength");
        this.orgId = getLong(rs, "org_id", rsColumns);                                                  //addVOField("org_id", Types.BIGINT, "setOrgId", Long.class, "getOrgId");
        this.trailerNumber = getString(rs, "trailer_number", rsColumns);                                //addVOField("trailer_number", Types.VARCHAR, "setTrailerNumber", String.class, "getTrailerNumber");
        this.gpsProvider = getString(rs, "gps_provider", rsColumns);                                    //addVOField("gps_provider", Types.VARCHAR, "setGpsProvider", String.class, "getGpsProvider");
        this.gpsUnitId = getString(rs, "gps_unit_id", rsColumns);                                       //addVOField("gps_unit_id", Types.VARCHAR, "setGpsUnitId", String.class, "getGpsUnitId");
        this.vin = getString(rs, "vin", rsColumns);                                                     //addVOField("vin", Types.VARCHAR, "setVin", String.class, "getVin");
        this.make = getString(rs, "make", rsColumns);                                                   //addVOField("make", Types.VARCHAR, "setMake", String.class, "getMake");
        this.year = getString(rs, "year", rsColumns);                                                   //addVOField("year", Types.VARCHAR, "setYear", String.class, "getYear");
        this.trailerType = getString(rs, "trailer_type", rsColumns);                                    //addVOField("trailer_type", Types.VARCHAR, "setTrailerType", String.class, "getTrailerType");
        this.licensePlate = getString(rs, "license_plate", rsColumns);                                  //addVOField("license_plate", Types.VARCHAR, "setLicensePlate", String.class, "getLicensePlate");
        this.licenseStateProvince = getString(rs, "license_state_province", rsColumns);                 //addVOField("license_state_province", Types.VARCHAR, "setLicenseStateProvince", String.class, "getLicenseStateProvince");
        this.status = getString(rs, "status", rsColumns);                                               //addVOField("status", Types.VARCHAR, "setStatus", String.class, "getStatus");
        this.borderConnectTrailerTypeId = getLong(rs, "border_connect_trailer_type_id", rsColumns);     //addVOField("border_connect_trailer_type_id", Types.BIGINT, "setBorderConnectTrailerTypeId", Long.class, "getBorderConnectTrailerTypeId");
        this.borderConnectTrailerType = getString(rs, "border_connect_trailer_type", rsColumns);        //addVOField("border_connect_trailer_type", Types.VARCHAR, "setBorderConnectTrailerType", String.class, "getBorderConnectTrailerType");

        //JOINS
        this.positionTime = getDate(rs, "ref_event_date_time", rsColumns);                              //addVOField("ref_event_date_time", Types.TIMESTAMP, "setPositionTime", Date.class, "getPositionTime");
        this.battery = getString(rs, "battery", rsColumns);                                             //addVOField("battery", Types.VARCHAR, "setBattery", String.class, "getBattery");

        this.masterDBRefId = getLong(rs, "master_db_ref_id", rsColumns);
        this.clientDBRefId = getLong(rs, "client_db_ref_id", rsColumns);
    }

    @Override
    public String toString() {
        return "Trailer{" +
                "trailerId=" + trailerId +
                ", refTrailerId='" + refTrailerId + '\'' +
                ", picture='" + picture + '\'' +
                ", owner='" + owner + '\'' +
                ", trailerLength='" + trailerLength + '\'' +
                ", orgId=" + orgId +
                ", trailerNumber='" + trailerNumber + '\'' +
                ", gpsProvider='" + gpsProvider + '\'' +
                ", gpsUnitId='" + gpsUnitId + '\'' +
                ", vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", year='" + year + '\'' +
                ", trailerType='" + trailerType + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", licenseStateProvince='" + licenseStateProvince + '\'' +
                ", status='" + status + '\'' +
                ", borderConnectTrailerTypeId=" + borderConnectTrailerTypeId +
                ", masterDBRefId=" + masterDBRefId +
                ", clientDBRefId=" + clientDBRefId +
                ", borderConnectTrailerType='" + borderConnectTrailerType + '\'' +
                ", positionTime=" + positionTime +
                ", tags=" + tags +
                ", battery='" + battery + '\'' +
                '}';
    }

    public Long getTrailerId() {
        return trailerId;
    }

    public void setTrailerId(Long trailerId) {
        this.trailerId = trailerId;
    }

    public String getRefTrailerId() {
        return refTrailerId;
    }

    public void setRefTrailerId(String refTrailerId) {
        this.refTrailerId = refTrailerId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTrailerLength() {
        return trailerLength;
    }

    public void setTrailerLength(String trailerLength) {
        this.trailerLength = trailerLength;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getTrailerNumber() {
        return trailerNumber;
    }

    public void setTrailerNumber(String trailerNumber) {
        this.trailerNumber = trailerNumber;
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

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTrailerType() {
        return trailerType;
    }

    public void setTrailerType(String trailerType) {
        this.trailerType = trailerType;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getBorderConnectTrailerTypeId() {
        return borderConnectTrailerTypeId;
    }

    public void setBorderConnectTrailerTypeId(Long borderConnectTrailerTypeId) {
        this.borderConnectTrailerTypeId = borderConnectTrailerTypeId;
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

    public String getBorderConnectTrailerType() {
        return borderConnectTrailerType;
    }

    public void setBorderConnectTrailerType(String borderConnectTrailerType) {
        this.borderConnectTrailerType = borderConnectTrailerType;
    }

    public Date getPositionTime() {
        return positionTime;
    }

    public void setPositionTime(Date positionTime) {
        this.positionTime = positionTime;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }
}
