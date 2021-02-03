package Migration;

import DB.RecordMapperValueObject;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Set;

public class Account extends RecordMapperValueObject implements Serializable {
    private Long accountId;
    private Long primaryUserId;
    private Long organizationId;
    private String accountPin;
    private String referralCode;
    private Character active;
    private Long billingAddressId;
    private Long contactId;
    private Date createDate;
    private Character isPersonal;
    private String subscriptionType = "stripe";
    private Character sendLoadOffers = 'Y';

    private String note;
    private String salesNote;

    public Account(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        this.accountId = getLong(rs, "account_id", rsColumns);
        this.primaryUserId = getLong(rs, "primary_user_id", rsColumns);
        this.organizationId = getLong(rs, "organization_id", rsColumns);
        this.accountPin = getString(rs, "account_pin", rsColumns);
        this.referralCode = getString(rs, "referral_code", rsColumns);
        this.active = getCharacter(rs, "active", rsColumns);
        this.billingAddressId = getLong(rs, "billing_address_id", rsColumns);
        this.contactId = getLong(rs, "contact_id", rsColumns);
        this.createDate = getDate(rs, "create_date", rsColumns);
        this.isPersonal = getCharacter(rs, "is_personal", rsColumns);
        this.note = getString(rs, "note", rsColumns);
        this.salesNote = getString(rs, "sales_note", rsColumns);
        this.sendLoadOffers = getCharacter(rs, "send_load_offers", rsColumns);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", primaryUserId=" + primaryUserId +
                ", organizationId=" + organizationId +
                ", accountPin='" + accountPin + '\'' +
                ", referralCode='" + referralCode + '\'' +
                ", active=" + active +
                ", billingAddressId=" + billingAddressId +
                ", contactId=" + contactId +
                ", createDate=" + createDate +
                ", isPersonal=" + isPersonal +
                ", subscriptionType='" + subscriptionType + '\'' +
                ", sendLoadOffers=" + sendLoadOffers +
                ", note='" + note + '\'' +
                ", salesNote='" + salesNote + '\'' +
                '}';
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getPrimaryUserId() {
        return primaryUserId;
    }

    public void setPrimaryUserId(Long primaryUserId) {
        this.primaryUserId = primaryUserId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getAccountPin() {
        return accountPin;
    }

    public void setAccountPin(String accountPin) {
        this.accountPin = accountPin;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Long getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(Long billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Character getIsPersonal() {
        return isPersonal;
    }

    public void setIsPersonal(Character isPersonal) {
        this.isPersonal = isPersonal;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public Character getSendLoadOffers() {
        return sendLoadOffers;
    }

    public void setSendLoadOffers(Character sendLoadOffers) {
        this.sendLoadOffers = sendLoadOffers;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSalesNote() {
        return salesNote;
    }

    public void setSalesNote(String salesNote) {
        this.salesNote = salesNote;
    }
}
