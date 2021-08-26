package migration;

import db.RecordMapperValueObject;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

public class ACLMatrix extends RecordMapperValueObject implements Serializable {
    public Long groupId;
    public String resourceName;
    public Character allowRead;
    public Character allowInsert;
    public Character allowUpdate;
    public Character allowDelete;
    public Character allowExport;

    public ACLMatrix(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }

        this.resourceName = getString(rs, "resource_name", rsColumns);
        this.allowRead = getCharacter(rs, "allow_read", rsColumns);
        this.allowInsert = getCharacter(rs, "allow_insert", rsColumns);
        this.allowUpdate = getCharacter(rs, "allow_update", rsColumns);
        this.allowDelete = getCharacter(rs, "allow_delete", rsColumns);
        this.allowExport = getCharacter(rs, "allow_export", rsColumns);
    }

    public Long getGroupId() {
        return groupId;
    }
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
    public String getResourceName() {
        return resourceName;
    }
    public void setResourceName(String resourceName) {
        this.resourceName=resourceName;
    }
    public Character getAllowRead() {
        return allowRead;
    }
    public void setAllowRead(Character allowRead) {
        this.allowRead=allowRead;
    }
    public Character getAllowInsert() {
        return allowInsert;
    }
    public void setAllowInsert(Character allowInsert) {
        this.allowInsert=allowInsert;
    }
    public Character getAllowUpdate() {
        return allowUpdate;
    }
    public void setAllowUpdate(Character allowUpdate) {
        this.allowUpdate=allowUpdate;
    }
    public Character getAllowDelete() {
        return allowDelete;
    }
    public void setAllowDelete(Character allowDelete) {
        this.allowDelete=allowDelete;
    }
    public Character getAllowExport() {
        return allowExport;
    }
    public void setAllowExport(Character allowExport) {
        this.allowExport = allowExport;
    }

    @Override
    public String toString() {
        return "ACLMatrix{" +
                "groupId=" + groupId +
                ", resourceName='" + resourceName + '\'' +
                ", allowRead=" + allowRead +
                ", allowInsert=" + allowInsert +
                ", allowUpdate=" + allowUpdate +
                ", allowDelete=" + allowDelete +
                ", allowExport=" + allowExport +
                '}';
    }

    @Override
    public List<Field> getFields() {
        return null;
    }
}
