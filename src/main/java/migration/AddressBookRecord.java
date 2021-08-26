package migration;

import db.RecordMapperValueObject;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

public class AddressBookRecord extends RecordMapperValueObject implements Serializable {
    public Long recordId;
    public Long organizationId;
    public String name;
    public String email;
    public List<Tag> tags;
    public Long aclUser;
    public String userType;
    public Character isPrimary;
    public Long vpCustomerId;
    public Character vpCustomerSendEmail;

    public Long recipientId;

    public AddressBookRecord(ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
//        this.recordId = getLong(rs, "record_id", rsColumns);
//        this.organizationId = getLong(rs, "org_id", rsColumns);
        this.name = getString(rs, "name", rsColumns);
        this.email = getString(rs, "email", rsColumns);
//        this.aclUser = getLong(rs, "acl_user", rsColumns);
        this.userType = getString(rs, "user_type", rsColumns);
        this.isPrimary = getCharacter(rs, "is_primary", rsColumns);
//        this.vpCustomerId = getLong(rs, "vp_customer_id", rsColumns);
        this.vpCustomerSendEmail = getCharacter(rs, "vp_customer_send_email", rsColumns);
    }

    @Override
    public String toString() {
        return "AddressBookRecord{" +
                "recordId=" + recordId +
                ", organizationId=" + organizationId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", tags=" + tags +
                ", aclUser=" + aclUser +
                ", userType='" + userType + '\'' +
                ", isPrimary=" + isPrimary +
                ", vpCustomerId=" + vpCustomerId +
                ", vpCustomerSendEmail=" + vpCustomerSendEmail +
                ", recipientId=" + recipientId +
                '}';
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Long getAclUser() {
        return aclUser;
    }

    public void setAclUser(Long aclUser) {
        this.aclUser = aclUser;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Character getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Character isPrimary) {
        this.isPrimary = isPrimary;
    }

    public Long getVpCustomerId() {
        return vpCustomerId;
    }

    public void setVpCustomerId(Long vpCustomerId) {
        this.vpCustomerId = vpCustomerId;
    }

    public Character getVpCustomerSendEmail() {
        return vpCustomerSendEmail;
    }

    public void setVpCustomerSendEmail(Character vpCustomerSendEmail) {
        this.vpCustomerSendEmail = vpCustomerSendEmail;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    @Override
    public List<Field> getFields() {
        return null;
    }
}
