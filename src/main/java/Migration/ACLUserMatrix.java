package Migration;

import DB.RecordMapperValueObject;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Set;

public class ACLUserMatrix extends RecordMapperValueObject implements Serializable {
    private Long userId;
    private String resourceName;
    private Character allowRead;
    private Character allowInsert;
    private Character allowUpdate;
    private Character allowDelete;
    private Character allowExport;

    public ACLUserMatrix(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
//        this.userId = getLong(rs, "user_id", rsColumns);
        this.resourceName = getString(rs, "resource_name", rsColumns);
        this.allowRead = getCharacter(rs, "allow_read", rsColumns);
        this.allowInsert = getCharacter(rs, "allow_insert", rsColumns);
        this.allowUpdate = getCharacter(rs, "allow_update", rsColumns);
        this.allowDelete = getCharacter(rs, "allow_delete", rsColumns);
        this.allowExport = getCharacter(rs, "allow_export", rsColumns);
    }

    @Override
    public String toString() {
        return "ACLUserMatrix{" +
                "userId=" + userId +
                ", resourceName='" + resourceName + '\'' +
                ", allowRead=" + allowRead +
                ", allowInsert=" + allowInsert +
                ", allowUpdate=" + allowUpdate +
                ", allowDelete=" + allowDelete +
                ", allowExport=" + allowExport +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Character getAllowRead() {
        return allowRead;
    }

    public void setAllowRead(Character allowRead) {
        this.allowRead = allowRead;
    }

    public Character getAllowInsert() {
        return allowInsert;
    }

    public void setAllowInsert(Character allowInsert) {
        this.allowInsert = allowInsert;
    }

    public Character getAllowUpdate() {
        return allowUpdate;
    }

    public void setAllowUpdate(Character allowUpdate) {
        this.allowUpdate = allowUpdate;
    }

    public Character getAllowDelete() {
        return allowDelete;
    }

    public void setAllowDelete(Character allowDelete) {
        this.allowDelete = allowDelete;
    }

    public Character getAllowExport() {
        return allowExport;
    }

    public void setAllowExport(Character allowExport) {
        this.allowExport = allowExport;
    }


}
