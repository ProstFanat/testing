package Migration;

import DB.RecordMapperValueObject;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Set;

public class StripeSubscriptionItem extends RecordMapperValueObject {
    private Long id;
    private String refId;
    private Long stripePlanId;
    private Long stripeSubscriptionId;
    private Long userId;
    private Long orgId;
    private Long quantity;
    private Date createDate;
    private String driverIdsJson;
    private Character active;
    private StripeSubscription stripeSubscription;

    public StripeSubscriptionItem(Long id, String refId, Long stripePlanId, Long stripeSubscriptionId, Long userId, Long orgId, Long quantity,
                                  StripeSubscription stripeSubscription, Date createDate, String driverIdsJson, Character active) {
        //this.id = id;
        //this.refId = refId;
        //this.stripePlanId = stripePlanId;
       // this.stripeSubscriptionId = stripeSubscriptionId;
      //  this.userId = userId;
      //  this.orgId = orgId;
        this.quantity = quantity;
        this.stripeSubscription = stripeSubscription;
        this.createDate = createDate;
        this.driverIdsJson = driverIdsJson;
        this.active = active;
    }

    public StripeSubscriptionItem(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
       // this.id = getLong(rs, "id", rsColumns);
        this.refId = getString(rs, "ref_id", rsColumns);
        this.quantity = getLong(rs, "quantity", rsColumns);
        this.createDate = getDate(rs, "create_date", rsColumns);

       // this.userId = getLong(rs, "user_id", rsColumns);
        //this.orgId = getLong(rs, "org_id", rsColumns);
        this.active = getCharacter(rs, "stripe_customer_id", rsColumns);
    }

    @Override
    public String toString() {
        return "StripeSubscriptionItem{" +
                "id=" + id +
                ", refId='" + refId + '\'' +
                ", stripePlanId=" + stripePlanId +
                ", stripeSubscriptionId=" + stripeSubscriptionId +
                ", userId=" + userId +
                ", orgId=" + orgId +
                ", quantity=" + quantity +
                ", createDate=" + createDate +
                ", driverIdsJson='" + driverIdsJson + '\'' +
                ", active=" + active +
                ", stripeSubscription=" + stripeSubscription +
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

    public Long getStripePlanId() {
        return stripePlanId;
    }

    public void setStripePlanId(Long stripePlanId) {
        this.stripePlanId = stripePlanId;
    }

    public Long getStripeSubscriptionId() {
        return stripeSubscriptionId;
    }

    public void setStripeSubscriptionId(Long stripeSubscriptionId) {
        this.stripeSubscriptionId = stripeSubscriptionId;
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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDriverIdsJson() {
        return driverIdsJson;
    }

    public void setDriverIdsJson(String driverIdsJson) {
        this.driverIdsJson = driverIdsJson;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public StripeSubscription getStripeSubscription() {
        return stripeSubscription;
    }

    public void setStripeSubscription(StripeSubscription stripeSubscription) {
        this.stripeSubscription = stripeSubscription;
    }
}
