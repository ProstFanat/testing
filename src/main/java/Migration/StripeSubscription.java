package Migration;

import DB.RecordMapperValueObject;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class StripeSubscription extends RecordMapperValueObject {
    public Long id;
    public String refId;
    public Long stripeCustomerId;
    public Long userId;
    public Long orgId;
    public Character active;
    public Date lastChargeDate;
    public Date activeDueDate;
    public Date createDate;
    public String orgName;
    public Double taxPercent = new Double(0);
    public Character viewed = new Character('N');
    public Date trialEnd;
    public Long createdByUserId;

    //join data
    public Date lastBillingDate;
    public Long totalBillingAmount;
    public Long lastBillingAmount;

    public StripeCustomer stripeCustomer;
    public ACLUser createdByUser;

    //  1: Ok
    //  0: Invoices was not found
    // -1: Exists invoice with false paid
    // -2: The current month or year was not paid
    public String status;

    public Long timeToEndSubscriptionMs;

    public StripeSubscription(ResultSet rs, Object o) {
    }

    public StripeSubscription(Long id, String refId, Long stripeCustomerId, Long userId, Long orgId,
                              StripeCustomer stripeCustomer, Date createDate, Character active, Date lastChargeDate, Date activeDueDate, String orgName, Double taxPercent, Character viewed, Date trialEnd, Long createdByUserId) {
        //this.id = id;
       // this.refId = refId;
        //this.stripeCustomerId = stripeCustomerId;
       // this.userId = userId;
       // this.orgId = orgId;
        this.stripeCustomer = stripeCustomer;
        this.active = active;
        this.lastChargeDate = lastChargeDate;
        //this.stripeSubscriptionItemList = stripeSubscriptionItemList;
        this.createDate = createDate;
        this.lastChargeDate = lastChargeDate;
        this.activeDueDate = activeDueDate;
        //this.orgName = orgName;
        this.taxPercent = taxPercent;
        this.viewed = viewed;
        this.trialEnd = trialEnd;
        this.createdByUserId = createdByUserId;
    }

    public StripeSubscription(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        this.id = getLong(rs, "id", rsColumns);
        this.refId = getString(rs, "ref_id", rsColumns);
        //this.createDate = getDate(rs, "create_date", rsColumns);
        this.stripeCustomerId = getLong(rs, "stripe_customer_id", rsColumns);
        this.userId = getLong(rs, "user_id", rsColumns);
        this.orgId = getLong(rs, "org_id", rsColumns);
        this.active = getCharacter(rs, "stripe_customer_id", rsColumns);
        this.lastChargeDate = getDate(rs, "last_charge_date", rsColumns);
        this.activeDueDate = getDate(rs, "active_due_date", rsColumns);
        this.taxPercent = getDouble(rs, "tax_percent", rsColumns);
        this.viewed = getCharacter(rs, "viewed", rsColumns);
        this.trialEnd = getDate(rs, "trial_end", rsColumns);
        this.createdByUserId = getLong(rs, "created_by_user_id", rsColumns);
    }

    @Override
    public String toString() {
        return "StripeSubscription{" +
                "id=" + id +
                ", refId='" + refId + '\'' +
                ", stripeCustomerId=" + stripeCustomerId +
                ", userId=" + userId +
                ", orgId=" + orgId +
                ", active=" + active +
                ", lastChargeDate=" + lastChargeDate +
                ", activeDueDate=" + activeDueDate +
                ", createDate=" + createDate +
                ", orgName='" + orgName + '\'' +
                ", taxPercent=" + taxPercent +
                ", viewed=" + viewed +
                ", trialEnd=" + trialEnd +
                ", createdByUserId=" + createdByUserId +
                ", lastBillingDate=" + lastBillingDate +
                ", totalBillingAmount=" + totalBillingAmount +
                ", lastBillingAmount=" + lastBillingAmount +
                ", stripeCustomer=" + stripeCustomer +
                ", createdByUser=" + createdByUser +
                ", status='" + status + '\'' +
                ", timeToEndSubscriptionMs=" + timeToEndSubscriptionMs +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public Long getStripeCustomerId() {
        return stripeCustomerId;
    }

    public void setStripeCustomerId(Long stripeCustomerId) {
        this.stripeCustomerId = stripeCustomerId;
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

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Date getLastChargeDate() {
        return lastChargeDate;
    }

    public void setLastChargeDate(Date lastChargeDate) {
        this.lastChargeDate = lastChargeDate;
    }

    public Date getActiveDueDate() {
        return activeDueDate;
    }

    public void setActiveDueDate(Date activeDueDate) {
        this.activeDueDate = activeDueDate;
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

    public Double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(Double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public Character getViewed() {
        return viewed;
    }

    public void setViewed(Character viewed) {
        this.viewed = viewed;
    }

    public Date getTrialEnd() {
        return trialEnd;
    }

    public void setTrialEnd(Date trialEnd) {
        this.trialEnd = trialEnd;
    }

    public Long getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(Long createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public Date getLastBillingDate() {
        return lastBillingDate;
    }

    public void setLastBillingDate(Date lastBillingDate) {
        this.lastBillingDate = lastBillingDate;
    }

    public Long getTotalBillingAmount() {
        return totalBillingAmount;
    }

    public void setTotalBillingAmount(Long totalBillingAmount) {
        this.totalBillingAmount = totalBillingAmount;
    }

    public Long getLastBillingAmount() {
        return lastBillingAmount;
    }

    public void setLastBillingAmount(Long lastBillingAmount) {
        this.lastBillingAmount = lastBillingAmount;
    }

    public StripeCustomer getStripeCustomer() {
        return stripeCustomer;
    }

    public void setStripeCustomer(StripeCustomer stripeCustomer) {
        this.stripeCustomer = stripeCustomer;
    }

    public ACLUser getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(ACLUser createdByUser) {
        this.createdByUser = createdByUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTimeToEndSubscriptionMs() {
        return timeToEndSubscriptionMs;
    }

    public void setTimeToEndSubscriptionMs(Long timeToEndSubscriptionMs) {
        this.timeToEndSubscriptionMs = timeToEndSubscriptionMs;
    }
}
