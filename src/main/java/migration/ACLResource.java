package migration;

import db.RecordMapperValueObject;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

public class ACLResource extends RecordMapperValueObject implements Serializable {
    public String resourceName;
    public String description;
    public Long orgId;

    public ACLResource(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        this.resourceName = getString(rs, "resource_name", rsColumns);
        this.description = getString(rs, "description", rsColumns);
        this.orgId = getLong(rs, "org_id", rsColumns);
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
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

    @Override
    public String toString() {
        return "ACLResource{" +
                "resourceName='" + resourceName + '\'' +
                ", description='" + description + '\'' +
                ", orgId=" + orgId +
                '}';
    }

    @Override
    public List<Field> getFields() {
        return null;
    }
}
