package Migration;

import DB.RecordMapperValueObject;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static DB.RecordMapperValueObject.getRSColumns;

public class Migration extends RecordMapperValueObject {
    private Long migrationId;
    private Long orgId;
    private String originalELDType;
    private String targetELDType;
    private String migrationStatus;
    private Date migrationScheduleDate;
    private Date migrationCompleteDate;
    private Long responsiblePerson;
    private Date createDate;
    private Date updateDate;
    private Date managerNotifiedDate;
    private Date driverNotifiedDate;
    private Date stripeMigrateDate;
    private String comment;
    private Character withTransportMovement;


    // Extra conditions for tasks
    private Character withStripeData = 'Y';
    private Character withTruckSignals = 'Y';

    public Migration(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        this.migrationId = getLong(rs, "migration_id", rsColumns);
        this.orgId = getLong(rs, "org_id", rsColumns);
        this.originalELDType = getString(rs, "original_eld_type", rsColumns);
        this.targetELDType = getString(rs, "target_eld_type", rsColumns);
        this.migrationStatus = getString(rs, "migration_status", rsColumns);
    }

    public Long getMigrationId() {
        return migrationId;
    }

    public void setMigrationId(Long migrationId) {
        this.migrationId = migrationId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOriginalELDType() {
        return originalELDType;
    }

    public void setOriginalELDType(String originalELDType) {
        this.originalELDType = originalELDType;
    }

    public String getTargetELDType() {
        return targetELDType;
    }

    public void setTargetELDType(String targetELDType) {
        this.targetELDType = targetELDType;
    }

    public String getMigrationStatus() {
        return migrationStatus;
    }

    public void setMigrationStatus(String migrationStatus) {
        this.migrationStatus = migrationStatus;
    }

    public Date getMigrationScheduleDate() {
        return migrationScheduleDate;
    }

    public void setMigrationScheduleDate(Date migrationScheduleDate) {
        this.migrationScheduleDate = migrationScheduleDate;
    }

    public Date getMigrationCompleteDate() {
        return migrationCompleteDate;
    }

    public void setMigrationCompleteDate(Date migrationCompleteDate) {
        this.migrationCompleteDate = migrationCompleteDate;
    }

    public Long getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(Long responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getManagerNotifiedDate() {
        return managerNotifiedDate;
    }

    public void setManagerNotifiedDate(Date managerNotifiedDate) {
        this.managerNotifiedDate = managerNotifiedDate;
    }

    public Date getDriverNotifiedDate() {
        return driverNotifiedDate;
    }

    public void setDriverNotifiedDate(Date driverNotifiedDate) {
        this.driverNotifiedDate = driverNotifiedDate;
    }

    public Date getStripeMigrateDate() {
        return stripeMigrateDate;
    }

    public void setStripeMigrateDate(Date stripeMigrateDate) {
        this.stripeMigrateDate = stripeMigrateDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Character getWithTransportMovement() {
        return withTransportMovement;
    }

    public void setWithTransportMovement(Character withTransportMovement) {
        this.withTransportMovement = withTransportMovement;
    }

    public Character getWithStripeData() {
        return withStripeData;
    }

    public void setWithStripeData(Character withStripeData) {
        this.withStripeData = withStripeData;
    }

    public Character getWithTruckSignals() {
        return withTruckSignals;
    }

    public void setWithTruckSignals(Character withTruckSignals) {
        this.withTruckSignals = withTruckSignals;
    }

    public Migration(String dbUrl, String userDb, String passDb) {
    }


    @Override
    public List<Field> getFields() {
        return null;
    }
}
