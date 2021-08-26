package migration;

import db.RecordMapperValueObject;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class InspectionReport extends RecordMapperValueObject {

    public Long reportId;
    public Long orgId;
    public Long driverId1;
    public Long driverId2;
    public Date createDate;
    public Date updateDate;
    public Date reportDate;
    public Long truckId;
    public String odometer;
    public String odometerUnit;
    public String trailerNumber;
    public String trailerLicense;
    public String locationDescription;
    public String comment;
    public Character vehicleIsSafeToDrive;
    public String defectsJson;
    public String checklistJson;
    public Long remoteReportId;

    public String truckNumber;

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Long getTruckId() {
        return truckId;
    }

    public void setTruckId(Long truckId) {
        this.truckId = truckId;
    }

    public String getOdometer() {
        return odometer;
    }

    public void setOdometer(String odometer) {
        this.odometer = odometer;
    }

    public String getOdometerUnit() {
        return odometerUnit;
    }

    public void setOdometerUnit(String odometerUnit) {
        this.odometerUnit = odometerUnit;
    }

    public String getTrailerNumber() {
        return trailerNumber;
    }

    public void setTrailerNumber(String trailerNumber) {
        this.trailerNumber = trailerNumber;
    }

    public String getTrailerLicense() {
        return trailerLicense;
    }

    public void setTrailerLicense(String trailerLicense) {
        this.trailerLicense = trailerLicense;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Character getVehicleIsSafeToDrive() {
        return vehicleIsSafeToDrive;
    }

    public void setVehicleIsSafeToDrive(Character vehicleIsSafeToDrive) {
        this.vehicleIsSafeToDrive = vehicleIsSafeToDrive;
    }

    public String getDefectsJson() {
        return defectsJson;
    }

    public void setDefectsJson(String defectsJson) {
        this.defectsJson = defectsJson;
    }

    public String getChecklistJson() {
        return checklistJson;
    }

    public void setChecklistJson(String checklistJson) {
        this.checklistJson = checklistJson;
    }

    public Long getRemoteReportId() {
        return remoteReportId;
    }

    public void setRemoteReportId(Long remoteReportId) {
        this.remoteReportId = remoteReportId;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    @Override
    public String toString() {
        return "InspectionReport{" +
                "reportId=" + reportId +
                ", orgId=" + orgId +
                ", driverId1=" + driverId1 +
                ", driverId2=" + driverId2 +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", reportDate=" + reportDate +
                ", truckId=" + truckId +
                ", odometer='" + odometer + '\'' +
                ", odometerUnit='" + odometerUnit + '\'' +
                ", trailerNumber='" + trailerNumber + '\'' +
                ", trailerLicense='" + trailerLicense + '\'' +
                ", locationDescription='" + locationDescription + '\'' +
                ", comment='" + comment + '\'' +
                ", vehicleIsSafeToDrive=" + vehicleIsSafeToDrive +
                ", defectsJson='" + defectsJson + '\'' +
                ", checklistJson='" + checklistJson + '\'' +
                ", remoteReportId=" + remoteReportId +
                ", truckNumber='" + truckNumber + '\'' +
                '}';
    }

    public InspectionReport(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }

       // this.reportId = getLong(rs, "report_id", rsColumns);
      //  this.orgId = getLong(rs, "org_id", rsColumns);
       // this.driverId1 = getLong(rs, "driver_id_1", rsColumns);
       // this.driverId2 = getLong(rs, "driver_id_2", rsColumns);
       // this.createDate = getDate(rs, "create_date", rsColumns);
       // this.updateDate = getDate(rs, "update_date", rsColumns);
        this.reportDate = getDate(rs, "report_date", rsColumns);
     //   this.truckId = getLong(rs, "truck_id", rsColumns);
        this.odometer = getString(rs, "odometer", rsColumns);
        this.odometerUnit = getString(rs, "odometer_unit",  rsColumns);
        this.trailerNumber = getString(rs, "trailer_number", rsColumns);
        this.trailerLicense = getString(rs, "trailer_license", rsColumns);
        this.locationDescription = getString(rs, "location_description", rsColumns);
        this.comment = getString(rs, "comment", rsColumns);
        this.vehicleIsSafeToDrive = getCharacter(rs, "vehicle_is_safe_to_drive", rsColumns);
        this.defectsJson = getString(rs, "defects_json", rsColumns);
        this.checklistJson = getString(rs, "checklist_json", rsColumns);
        this.remoteReportId = getLong(rs, "remote_report_id", rsColumns);
        this.truckNumber = getString(rs, "truck_number", rsColumns);
    }

    @Override
    public List<Field> getFields() {
        return null;
    }
}
