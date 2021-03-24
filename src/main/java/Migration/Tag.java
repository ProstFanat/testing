package Migration;

import DB.RecordMapperValueObject;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Set;

public class Tag extends RecordMapperValueObject implements Serializable {

    public Long tagId;
    public String tagName;
    public Long organizationId;
    public Long transportNumber;
    public String truckNumber;
    public String trailerNumber;
    public String driverNumber;
    public String tagType;
    public Long tagTruckId;
    public Long tagTrailerId;
    public Long tagTransportId;
    public String tagAccessType = "public";
    public Long userId;

    public Long masterDBRefId;
    //refers to personal tags that can have only one user it was created by.
    public String userFullName;

    public Tag(ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
       // this.tagId = getLong(rs, "tag_id", rsColumns);
        this.tagName = getString(rs, "tag_name", rsColumns);
        this.tagType = getString(rs, "type", rsColumns, "address-book");
       // this.organizationId = getLong(rs, "organization_id", rsColumns);
        this.transportNumber = getLong(rs, "transport_number", rsColumns);
        this.truckNumber = getString(rs, "truck_number", rsColumns);
        this.trailerNumber = getString(rs, "trailer_number", rsColumns);
        this.driverNumber = getString(rs, "driver_number", rsColumns);
      //  this.tagTruckId = getLong(rs, "tag_truck_id", rsColumns);
      //  this.tagTrailerId = getLong(rs, "tag_trailer_id", rsColumns);
     //   this.tagTransportId = getLong(rs, "tag_transport_id", rsColumns);
        this.tagAccessType = getString(rs, "access_type", rsColumns);
      //  this.userId = getLong(rs, "user_id", rsColumns);
        this.userFullName = getString(rs, "user_full_name",rsColumns);
        this.masterDBRefId = getLong(rs, "master_db_ref_id",rsColumns);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", organizationId=" + organizationId +
                ", transportNumber=" + transportNumber +
                ", truckNumber='" + truckNumber + '\'' +
                ", trailerNumber='" + trailerNumber + '\'' +
                ", driverNumber='" + driverNumber + '\'' +
                ", tagType='" + tagType + '\'' +
                ", tagTruckId=" + tagTruckId +
                ", tagTrailerId=" + tagTrailerId +
                ", tagTransportId=" + tagTransportId +
                ", tagAccessType='" + tagAccessType + '\'' +
                ", userId=" + userId +
                ", masterDBRefId=" + masterDBRefId +
                ", userFullName='" + userFullName + '\'' +
                '}';
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getTransportNumber() {
        return transportNumber;
    }

    public void setTransportNumber(Long transportNumber) {
        this.transportNumber = transportNumber;
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

    public String getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(String driverNumber) {
        this.driverNumber = driverNumber;
    }

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    public Long getTagTruckId() {
        return tagTruckId;
    }

    public void setTagTruckId(Long tagTruckId) {
        this.tagTruckId = tagTruckId;
    }

    public Long getTagTrailerId() {
        return tagTrailerId;
    }

    public void setTagTrailerId(Long tagTrailerId) {
        this.tagTrailerId = tagTrailerId;
    }

    public Long getTagTransportId() {
        return tagTransportId;
    }

    public void setTagTransportId(Long tagTransportId) {
        this.tagTransportId = tagTransportId;
    }

    public String getTagAccessType() {
        return tagAccessType;
    }

    public void setTagAccessType(String tagAccessType) {
        this.tagAccessType = tagAccessType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMasterDBRefId() {
        return masterDBRefId;
    }

    public void setMasterDBRefId(Long masterDBRefId) {
        this.masterDBRefId = masterDBRefId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }
}
