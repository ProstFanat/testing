package Migration;

import DB.RecordMapperValueObject;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ACLUserGroup extends RecordMapperValueObject implements Serializable {
    public Long groupId;
    public String userGroup;
    public String description;
    public Long orgId;

    public Long masterDBRefId;

    public List<ACLMatrix> groupResources = new ArrayList<>();

    public List<ACLAssetsInGroup> trailerInGroupList = new ArrayList<>();
    public List<ACLAssetsInGroup> truckInGroupList = new ArrayList<>();
    public List<ACLAssetsInGroup> driverInGroupList = new ArrayList<>();

    public ACLUserGroup(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
//        this.groupId = getLong(rs, "group_id", rsColumns);
        this.userGroup = getString(rs, "user_group", rsColumns);
        this.description = getString(rs, "description", rsColumns);
     //   this.orgId = getLong(rs, "org_id", rsColumns);
       // this.masterDBRefId = getLong(rs, "master_db_ref_id", rsColumns);
    }

    public ACLUserGroup(final ResultSet rs, Set<String> rsColumns, String a) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        this.groupId = getLong(rs, "group_id", rsColumns);
        this.userGroup = getString(rs, "user_group", rsColumns);
        this.description = getString(rs, "description", rsColumns);
        this.orgId = getLong(rs, "org_id", rsColumns);
        this.masterDBRefId = getLong(rs, "master_db_ref_id", rsColumns);
    }

    @Override
    public String toString() {
        return "ACLUserGroup{" +
                "groupId=" + groupId +
                ", userGroup='" + userGroup + '\'' +
                ", description='" + description + '\'' +
                ", orgId=" + orgId +
                ", masterDBRefId=" + masterDBRefId +
                ", groupResources=" + groupResources +
                ", trailerInGroupList=" + trailerInGroupList +
                ", truckInGroupList=" + truckInGroupList +
                ", driverInGroupList=" + driverInGroupList +
                '}';
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getMasterDBRefId() {
        return masterDBRefId;
    }

    public void setMasterDBRefId(Long masterDBRefId) {
        this.masterDBRefId = masterDBRefId;
    }

    public List<ACLMatrix> getGroupResources() {
        return groupResources;
    }

    public void setGroupResources(List<ACLMatrix> groupResources) {
        this.groupResources = groupResources;
    }

    public List<ACLAssetsInGroup> getTrailerInGroupList() {
        return trailerInGroupList;
    }

    public void setTrailerInGroupList(List<ACLAssetsInGroup> trailerInGroupList) {
        this.trailerInGroupList = trailerInGroupList;
    }

    public List<ACLAssetsInGroup> getTruckInGroupList() {
        return truckInGroupList;
    }

    public void setTruckInGroupList(List<ACLAssetsInGroup> truckInGroupList) {
        this.truckInGroupList = truckInGroupList;
    }

    public List<ACLAssetsInGroup> getDriverInGroupList() {
        return driverInGroupList;
    }

    public void setDriverInGroupList(List<ACLAssetsInGroup> driverInGroupList) {
        this.driverInGroupList = driverInGroupList;
    }
}
