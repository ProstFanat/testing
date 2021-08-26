package migration;

import db.RecordMapperValueObject;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

public class ACLUserInGroup extends RecordMapperValueObject implements Serializable {
    public Long groupId;
    public Long userId;

    //join
    public String groupName;

    public ACLUserGroup group;

    public ACLUserInGroup(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
//        this.groupId = getLong(rs, "group_id", rsColumns);
//        this.userId = getLong(rs, "user_id", rsColumns);
        this.groupName = getString(rs, "group_name", rsColumns);
    }

    @Override
    public String toString() {
        return "ACLUserInGroup{" +
                "groupId=" + groupId +
                ", userId=" + userId +
                ", groupName='" + groupName + '\'' +
                ", group=" + group +
                '}';
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public ACLUserGroup getGroup() {
        return group;
    }

    public void setGroup(ACLUserGroup group) {
        this.group = group;
    }

    @Override
    public List<Field> getFields() {
        return null;
    }
}
