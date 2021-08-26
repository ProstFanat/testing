package migration;

import db.RecordMapperValueObject;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class FMCSAELDExport extends RecordMapperValueObject {
    public Long fmcsaEldExportId;
    public Long orgId;
    public Long driverId;
    public Date createDate;
    public Date fromDate;
    public Date toDate;
    public String newsCode;
    public String transferResult;
    public Long startSequence;
    public Long endSequence;
    public String startOdometer;
    public String endOdometer;
    public String startEngineHours;
    public String endEngineHours;
    public String startLng;
    public String startLat;
    public String endLng;
    public String endLat;
    public String startChecksum;
    public String endChecksum;
    public String startLocationDescription;
    public String endLocationDescription;
    public String recipient;
    public String sendType;
    public String rejectComment;
    public Character isProhibitedZoneDetected;
    public String coDrivers;
    public String truckNumbers;

    public FMCSAELDExport(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
     //   this.fmcsaEldExportId = getLong(rs, "fmcsa_eld_export_id", rsColumns);
     //   this.orgId = getLong(rs, "org_id", rsColumns);
     //   this.driverId = getLong(rs, "driver_id", rsColumns);
        this.createDate = getDate(rs, "create_date", rsColumns);
        this.fromDate = getDate(rs, "from_date", rsColumns);
        this.toDate = getDate(rs, "to_date", rsColumns);
        this.newsCode = getString(rs, "news_code", rsColumns);
        this.transferResult = getString(rs, "transfer_result", rsColumns);
        this.startSequence = getLong(rs, "start_sequence", rsColumns);
        this.endSequence = getLong(rs, "end_sequence", rsColumns);
        this.startOdometer = getString(rs, "start_odometer", rsColumns);
        this.endOdometer = getString(rs, "end_odometer", rsColumns);
        this.startEngineHours = getString(rs, "start_engine_hours", rsColumns);
        this.endEngineHours = getString(rs, "end_engine_hours", rsColumns);
        this.startLng = getString(rs, "start_lng", rsColumns);
        this.startLat = getString(rs, "start_lat", rsColumns);
        this.endLng = getString(rs, "end_lng", rsColumns);
        this.endLat = getString(rs, "end_lat", rsColumns);
        this.startChecksum = getString(rs, "start_checksum", rsColumns);
        this.endChecksum = getString(rs, "end_checksum", rsColumns);
        this.startLocationDescription = getString(rs, "start_location_description", rsColumns);
        this.endLocationDescription = getString(rs, "end_location_description", rsColumns);
        this.recipient = getString(rs, "recipient", rsColumns);
        this.sendType = getString(rs, "send_type", rsColumns);
        this.rejectComment = getString(rs, "reject_comment", rsColumns);
        this.isProhibitedZoneDetected = getCharacter(rs, "is_prohibited_zone_detected", rsColumns);
        this.coDrivers = getString(rs, "co_drivers", rsColumns);
        this.truckNumbers = getString(rs, "truck_numbers", rsColumns);
    }

    public Long getFmcsaEldExportId() {
        return fmcsaEldExportId;
    }

    public void setFmcsaEldExportId(Long fmcsaEldExportId) {
        this.fmcsaEldExportId = fmcsaEldExportId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getNewsCode() {
        return newsCode;
    }

    public void setNewsCode(String newsCode) {
        this.newsCode = newsCode;
    }

    public String getTransferResult() {
        return transferResult;
    }

    public void setTransferResult(String transferResult) {
        this.transferResult = transferResult;
    }

    public Long getStartSequence() {
        return startSequence;
    }

    public void setStartSequence(Long startSequence) {
        this.startSequence = startSequence;
    }

    public Long getEndSequence() {
        return endSequence;
    }

    public void setEndSequence(Long endSequence) {
        this.endSequence = endSequence;
    }

    public String getStartOdometer() {
        return startOdometer;
    }

    public void setStartOdometer(String startOdometer) {
        this.startOdometer = startOdometer;
    }

    public String getEndOdometer() {
        return endOdometer;
    }

    public void setEndOdometer(String endOdometer) {
        this.endOdometer = endOdometer;
    }

    public String getStartEngineHours() {
        return startEngineHours;
    }

    public void setStartEngineHours(String startEngineHours) {
        this.startEngineHours = startEngineHours;
    }

    public String getEndEngineHours() {
        return endEngineHours;
    }

    public void setEndEngineHours(String endEngineHours) {
        this.endEngineHours = endEngineHours;
    }

    public String getStartLng() {
        return startLng;
    }

    public void setStartLng(String startLng) {
        this.startLng = startLng;
    }

    public String getStartLat() {
        return startLat;
    }

    public void setStartLat(String startLat) {
        this.startLat = startLat;
    }

    public String getEndLng() {
        return endLng;
    }

    public void setEndLng(String endLng) {
        this.endLng = endLng;
    }

    public String getEndLat() {
        return endLat;
    }

    public void setEndLat(String endLat) {
        this.endLat = endLat;
    }

    public String getStartChecksum() {
        return startChecksum;
    }

    public void setStartChecksum(String startChecksum) {
        this.startChecksum = startChecksum;
    }

    public String getEndChecksum() {
        return endChecksum;
    }

    public void setEndChecksum(String endChecksum) {
        this.endChecksum = endChecksum;
    }

    public String getStartLocationDescription() {
        return startLocationDescription;
    }

    public void setStartLocationDescription(String startLocationDescription) {
        this.startLocationDescription = startLocationDescription;
    }

    public String getEndLocationDescription() {
        return endLocationDescription;
    }

    public void setEndLocationDescription(String endLocationDescription) {
        this.endLocationDescription = endLocationDescription;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getRejectComment() {
        return rejectComment;
    }

    public void setRejectComment(String rejectComment) {
        this.rejectComment = rejectComment;
    }

    public Character getIsProhibitedZoneDetected() {
        return isProhibitedZoneDetected;
    }

    public void setIsProhibitedZoneDetected(Character isProhibitedZoneDetected) {
        this.isProhibitedZoneDetected = isProhibitedZoneDetected;
    }

    public String getCoDrivers() {
        return coDrivers;
    }

    public void setCoDrivers(String coDrivers) {
        this.coDrivers = coDrivers;
    }

    public String getTruckNumbers() {
        return truckNumbers;
    }

    public void setTruckNumbers(String truckNumbers) {
        this.truckNumbers = truckNumbers;
    }

    @Override
    public String toString() {
        return "FMCSAELDExport{" +
                "fmcsaEldExportId=" + fmcsaEldExportId +
                ", orgId=" + orgId +
                ", driverId=" + driverId +
                ", createDate=" + createDate +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", newsCode='" + newsCode + '\'' +
                ", transferResult='" + transferResult + '\'' +
                ", startSequence=" + startSequence +
                ", endSequence=" + endSequence +
                ", startOdometer='" + startOdometer + '\'' +
                ", endOdometer='" + endOdometer + '\'' +
                ", startEngineHours='" + startEngineHours + '\'' +
                ", endEngineHours='" + endEngineHours + '\'' +
                ", startLng='" + startLng + '\'' +
                ", startLat='" + startLat + '\'' +
                ", endLng='" + endLng + '\'' +
                ", endLat='" + endLat + '\'' +
                ", startChecksum='" + startChecksum + '\'' +
                ", endChecksum='" + endChecksum + '\'' +
                ", startLocationDescription='" + startLocationDescription + '\'' +
                ", endLocationDescription='" + endLocationDescription + '\'' +
                ", recipient='" + recipient + '\'' +
                ", sendType='" + sendType + '\'' +
                ", rejectComment='" + rejectComment + '\'' +
                ", isProhibitedZoneDetected=" + isProhibitedZoneDetected +
                ", coDrivers='" + coDrivers + '\'' +
                ", truckNumbers='" + truckNumbers + '\'' +
                '}';
    }

    @Override
    public List<Field> getFields() {
        return null;
    }
}
