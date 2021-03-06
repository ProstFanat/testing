package Migration;

import DB.RecordMapperValueObject;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Set;

public class ACLAssetsInGroup extends RecordMapperValueObject implements Serializable {
    private Long groupId;
    private Long trailerId;
    private Long truckId;
    private Long driverId;

    public ACLAssetsInGroup(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        this.groupId = getLong(rs, "group_id", rsColumns);
        this.trailerId = getLong(rs, "trailer_id", rsColumns);
        this.truckId = getLong(rs, "truck_id", rsColumns);
        this.driverId = getLong(rs, "driver_id", rsColumns);
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getTrailerId() {
        return trailerId;
    }

    public void setTrailerId(Long trailerId) {
        this.trailerId = trailerId;
    }

    public Long getTruckId() {
        return truckId;
    }

    public void setTruckId(Long truckId) {
        this.truckId = truckId;
    }

    @Override
    public String toString() {
        return "ACLAssetsInGroup{" +
                "groupId=" + groupId +
                ", trailerId=" + trailerId +
                ", truckId=" + truckId +
                ", driverId=" + driverId +
                '}';
    }
}
