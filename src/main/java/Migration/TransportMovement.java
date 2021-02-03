package Migration;

import DB.RecordMapperValueObject;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class TransportMovement extends RecordMapperValueObject {
    private Long transportId;
    private Long orgId;
    private Long tractorRefId;
    private String tractorLat;
    private String tractorLng;
    private Date tractorPositionTime;
    private Long trailerRefId;
    private String trailerLat;
    private String trailerLng;
    private Date trailerPositionTime;
    private Integer confidenceLevel;
    private Character activeStatus;
    private Date createDate;
    private Date updateDate;
    private Long truckId;
    private Long truckDeviceSignalId;
    private Long trailerDeviceSignalId;

    // these fields are used by the zone trigger processor, not part of the transport_movement
    private String tractorNumber;
    private Long tractorId;
    private String trailerNumber;

    private List<Tag> tags = new ArrayList<>();
    private Date positionTime;

    // for transport_movement_history
    private Long driverId;
    private String driverName;
    private Date deactivateDate;
    private String deactivateTractorLat;
    private String deactivateTractorLng;
    private String deactivateTrailerLat;
    private String deactivateTrailerLng;
    private String truckNumber;

    public TransportMovement(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        this.transportId = getLong(rs, "transport_id", rsColumns);
        this.orgId = getLong(rs, "org_id", rsColumns);
        this.tractorRefId = getLong(rs, "tractor_ref_id", rsColumns);
        this.tractorLat = getString(rs, "tractor_lat", rsColumns);
        this.tractorLng = getString(rs, "tractor_lng", rsColumns);
        this.tractorPositionTime = getDate(rs, "tractor_position_time", rsColumns);
        this.trailerRefId = getLong(rs, "trailer_ref_id", rsColumns);
        this.trailerLat = getString(rs, "trailer_lat", rsColumns);
        this.trailerLng = getString(rs, "trailer_lng", rsColumns);
        this.trailerPositionTime = getDate(rs, "trailer_position_time", rsColumns);
        this.confidenceLevel = getInteger(rs, "confidence_level", rsColumns);
        this.activeStatus = getCharacter(rs, "active_status", rsColumns);
        this.createDate = getDate(rs, "create_date", rsColumns);
        this.updateDate = getDate(rs, "update_date", rsColumns);
        this.truckId = getLong(rs, "truck_id", rsColumns);
        this.truckDeviceSignalId = getLong(rs, "truck_device_signal_id", rsColumns);
        this.trailerDeviceSignalId = getLong(rs, "trailer_device_signal_id", rsColumns);
        this.trailerNumber = getString(rs, "trailer_number", rsColumns);
        this.positionTime = getDate(rs, "ref_pos_ts", rsColumns);
        this.driverId = getLong(rs, "driver_id", rsColumns);
        this.driverName = getString(rs, "driver_name", rsColumns);
        this.deactivateDate = getDate(rs, "deactivate_date", rsColumns);
        this.deactivateTractorLat = getString(rs, "deactivate_tractor_lat", rsColumns);
        this.deactivateTractorLng = getString(rs, "deactivate_tractor_lng", rsColumns);
        this.deactivateTrailerLat = getString(rs, "deactivate_trailer_lat", rsColumns);
        this.deactivateTrailerLng = getString(rs, "deactivate_trailer_lng", rsColumns);
        this.truckNumber = getString(rs, "truck_number", rsColumns);
    }

    @Override
    public String toString() {
        return "TransportMovement{" +
                "transportId=" + transportId +
                ", orgId=" + orgId +
                ", tractorRefId=" + tractorRefId +
                ", tractorLat='" + tractorLat + '\'' +
                ", tractorLng='" + tractorLng + '\'' +
                ", tractorPositionTime=" + tractorPositionTime +
                ", trailerRefId=" + trailerRefId +
                ", trailerLat='" + trailerLat + '\'' +
                ", trailerLng='" + trailerLng + '\'' +
                ", trailerPositionTime=" + trailerPositionTime +
                ", confidenceLevel=" + confidenceLevel +
                ", activeStatus=" + activeStatus +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", truckId=" + truckId +
                ", truckDeviceSignalId=" + truckDeviceSignalId +
                ", trailerDeviceSignalId=" + trailerDeviceSignalId +
                ", tractorNumber='" + tractorNumber + '\'' +
                ", tractorId=" + tractorId +
                ", trailerNumber='" + trailerNumber + '\'' +
                ", tags=" + tags +
                ", positionTime=" + positionTime +
                ", driverId=" + driverId +
                ", driverName='" + driverName + '\'' +
                ", deactivateDate=" + deactivateDate +
                ", deactivateTractorLat='" + deactivateTractorLat + '\'' +
                ", deactivateTractorLng='" + deactivateTractorLng + '\'' +
                ", deactivateTrailerLat='" + deactivateTrailerLat + '\'' +
                ", deactivateTrailerLng='" + deactivateTrailerLng + '\'' +
                ", truckNumber='" + truckNumber + '\'' +
                '}';
    }

    public String getTractorNumber() {
        return tractorNumber;
    }
    public void setTractorNumber(String tractorNumber) {
        this.tractorNumber = tractorNumber;
    }
    public String getTrailerNumber() {
        return trailerNumber;
    }
    public void setTrailerNumber(String trailerNumber) {
        this.trailerNumber = trailerNumber;
    }
    public Long getTransportId() {
        return transportId;
    }
    public void setTransportId(Long transportId) {
        this.transportId = transportId;
    }
    public Long getTractorRefId() {
        return tractorRefId;
    }
    public void setTractorRefId(Long tractorRefId) {
        this.tractorRefId = tractorRefId;
    }
    public String getTractorLat() {
        return tractorLat;
    }
    public void setTractorLat(String tractorLat) {
        this.tractorLat = tractorLat;
    }
    public String getTractorLng() {
        return tractorLng;
    }
    public void setTractorLng(String tractorLng) {
        this.tractorLng = tractorLng;
    }
    public Date getTractorPositionTime() {
        return tractorPositionTime;
    }
    public void setTractorPositionTime(Date tractorPositionTime) {
        this.tractorPositionTime = tractorPositionTime;
    }
    public Long getTrailerRefId() {
        return trailerRefId;
    }
    public void setTrailerRefId(Long trailerRefId) {
        this.trailerRefId = trailerRefId;
    }
    public String getTrailerLat() {
        return trailerLat;
    }
    public void setTrailerLat(String trailerLat) {
        this.trailerLat = trailerLat;
    }
    public String getTrailerLng() {
        return trailerLng;
    }
    public void setTrailerLng(String trailerLng) {
        this.trailerLng = trailerLng;
    }
    public Date getTrailerPositionTime() {
        return trailerPositionTime;
    }
    public void setTrailerPositionTime(Date trailerPositionTime) {
        this.trailerPositionTime = trailerPositionTime;
    }
    public Integer getConfidenceLevel() {
        return confidenceLevel;
    }
    public void setConfidenceLevel(Integer confidenceLevel) {
        this.confidenceLevel = confidenceLevel;
    }
    public Character getActiveStatus() {
        return activeStatus;
    }
    public void setActiveStatus(Character activeStatus) {
        this.activeStatus = activeStatus;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Long getOrgId() {
        return orgId;
    }
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
    public Date getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public List<Tag> getTags() {
        return tags;
    }
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Long getTractorId() {
        return tractorId;
    }

    public void setTractorId(Long tractorId) {
        this.tractorId = tractorId;
    }

    public Date getPositionTime() {
        return positionTime;
    }

    public void setPositionTime(Date positionTime) {
        this.positionTime = positionTime;
    }

    public Long getTruckId() {
        return truckId;
    }

    public void setTruckId(Long truckId) {
        this.truckId = truckId;
    }

    public Long getTruckDeviceSignalId() {
        return truckDeviceSignalId;
    }

    public void setTruckDeviceSignalId(Long truckDeviceSignalId) {
        this.truckDeviceSignalId = truckDeviceSignalId;
    }

    public Long getTrailerDeviceSignalId() {
        return trailerDeviceSignalId;
    }

    public void setTrailerDeviceSignalId(Long trailerDeviceSignalId) {
        this.trailerDeviceSignalId = trailerDeviceSignalId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Date getDeactivateDate() {
        return deactivateDate;
    }

    public void setDeactivateDate(Date deactivateDate) {
        this.deactivateDate = deactivateDate;
    }

    public String getDeactivateTractorLat() {
        return deactivateTractorLat;
    }

    public void setDeactivateTractorLat(String deactivateTractorLat) {
        this.deactivateTractorLat = deactivateTractorLat;
    }

    public String getDeactivateTractorLng() {
        return deactivateTractorLng;
    }

    public void setDeactivateTractorLng(String deactivateTractorLng) {
        this.deactivateTractorLng = deactivateTractorLng;
    }

    public String getDeactivateTrailerLat() {
        return deactivateTrailerLat;
    }

    public void setDeactivateTrailerLat(String deactivateTrailerLat) {
        this.deactivateTrailerLat = deactivateTrailerLat;
    }

    public String getDeactivateTrailerLng() {
        return deactivateTrailerLng;
    }

    public void setDeactivateTrailerLng(String deactivateTrailerLng) {
        this.deactivateTrailerLng = deactivateTrailerLng;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }
}
