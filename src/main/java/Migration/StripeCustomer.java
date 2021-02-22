package Migration;


import DB.RecordMapperValueObject;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Set;

import static DB.RecordMapperValueObject.getRSColumns;

public class StripeCustomer extends RecordMapperValueObject {
    private Long id;
    private Long userId;
    private Long orgId;
    private Date createDate;
    private String orgName;

    //Stripe
    private String refId;
    private String refSource;
    private String refEmail;

    //Shipping details
    private String refCountry;
    private String refCity;
    private String refLine1;
    private String refLine2;
    private String refPostalCode;
    private String refState;
    private String refPhone;

    private ACLUser aclUser;
    private Organization organization;

    private String lastCardDigits;
    private Long masterDBRefId;

    // join organization
    private String usdotNumber;

    public StripeCustomer(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
       // this.id = getLong(rs, "id", rsColumns);
       // this.userId = getLong(rs, "user_id", rsColumns);
        //this.createDate = getDate(rs, "create_date", rsColumns);
        this.refId = getString(rs, "ref_id", rsColumns);
        this.refSource = getString(rs, "ref_source", rsColumns);
        this.refEmail = getString(rs, "ref_email", rsColumns);
        this.refCountry = getString(rs, "ref_country", rsColumns);
        this.refCity = getString(rs, "ref_city", rsColumns);
        this.refLine1 = getString(rs, "ref_line_1", rsColumns);
        this.refLine2 = getString(rs, "ref_line_2", rsColumns);
        this.refPostalCode = getString(rs, "ref_postal_code", rsColumns);
        this.refState = getString(rs, "ref_state", rsColumns);
        this.refPhone = getString(rs, "ref_phone", rsColumns);
        this.lastCardDigits = getString(rs, "last_card_digits", rsColumns);
      //  this.masterDBRefId = masterDBRefId;
    }

    public StripeCustomer(ResultSet rs, Object userId) {
    }

    @Override
    public String toString() {
        return "StripeCustomer{" +
                "id=" + id +
                ", userId=" + userId +
                ", orgId=" + orgId +
                ", createDate=" + createDate +
                ", orgName='" + orgName + '\'' +
                ", refId='" + refId + '\'' +
                ", refSource='" + refSource + '\'' +
                ", refEmail='" + refEmail + '\'' +
                ", refCountry='" + refCountry + '\'' +
                ", refCity='" + refCity + '\'' +
                ", refLine1='" + refLine1 + '\'' +
                ", refLine2='" + refLine2 + '\'' +
                ", refPostalCode='" + refPostalCode + '\'' +
                ", refState='" + refState + '\'' +
                ", refPhone='" + refPhone + '\'' +
                ", aclUser=" + aclUser +
                ", organization=" + organization +
                ", lastCardDigits='" + lastCardDigits + '\'' +
                ", masterDBRefId=" + masterDBRefId +
                ", usdotNumber='" + usdotNumber + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getRefSource() {
        return refSource;
    }

    public void setRefSource(String refSource) {
        this.refSource = refSource;
    }

    public String getRefEmail() {
        return refEmail;
    }

    public void setRefEmail(String refEmail) {
        this.refEmail = refEmail;
    }

    public String getRefCountry() {
        return refCountry;
    }

    public void setRefCountry(String refCountry) {
        this.refCountry = refCountry;
    }

    public String getRefCity() {
        return refCity;
    }

    public void setRefCity(String refCity) {
        this.refCity = refCity;
    }

    public String getRefLine1() {
        return refLine1;
    }

    public void setRefLine1(String refLine1) {
        this.refLine1 = refLine1;
    }

    public String getRefLine2() {
        return refLine2;
    }

    public void setRefLine2(String refLine2) {
        this.refLine2 = refLine2;
    }

    public String getRefPostalCode() {
        return refPostalCode;
    }

    public void setRefPostalCode(String refPostalCode) {
        this.refPostalCode = refPostalCode;
    }

    public String getRefState() {
        return refState;
    }

    public void setRefState(String refState) {
        this.refState = refState;
    }

    public String getRefPhone() {
        return refPhone;
    }

    public void setRefPhone(String refPhone) {
        this.refPhone = refPhone;
    }

    public ACLUser getAclUser() {
        return aclUser;
    }

    public void setAclUser(ACLUser aclUser) {
        this.aclUser = aclUser;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getLastCardDigits() {
        return lastCardDigits;
    }

    public void setLastCardDigits(String lastCardDigits) {
        this.lastCardDigits = lastCardDigits;
    }

    public Long getMasterDBRefId() {
        return masterDBRefId;
    }

    public void setMasterDBRefId(Long masterDBRefId) {
        this.masterDBRefId = masterDBRefId;
    }

    public String getUsdotNumber() {
        return usdotNumber;
    }

    public void setUsdotNumber(String usdotNumber) {
        this.usdotNumber = usdotNumber;
    }
}
