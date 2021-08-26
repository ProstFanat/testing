package migration;

import db.RecordMapperValueObject;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

public class MigrationUser extends RecordMapperValueObject {
    private Long migrationId;
    private Integer eventsDayQuantity;

    public Long getMigrationId() {
        return migrationId;
    }

    public MigrationUser(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        this.migrationId = getLong(rs, "migration_id", rsColumns);
        this.eventsDayQuantity = getInteger(rs, "events_day_quantity", rsColumns);
    }

    @Override
    public String toString() {
        return "MigrationUser{" +
                "migrationId=" + migrationId +
                ", eventsDayQuantity=" + eventsDayQuantity +
                '}';
    }

    public void setMigrationId(Long migrationId) {
        this.migrationId = migrationId;
    }

    public Integer getEventsDayQuantity() {
        return eventsDayQuantity;
    }

    public void setEventsDayQuantity(Integer eventsDayQuantity) {
        this.eventsDayQuantity = eventsDayQuantity;
    }

    @Override
    public List<Field> getFields() {
        return null;
    }
}
