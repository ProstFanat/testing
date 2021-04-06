package Migration;

import DB.RecordMapperValueObject;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class EldSubscription extends RecordMapperValueObject {
    public Long subscriptionId;
    public Long orgId;
    public Character active;
    public String eldComputerItemId;
    public Long stripeSubscriptionItemId;
    public Long pricePerSubscription;

    public EldSubscription(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        this.subscriptionId = getLong(rs, "subscription_id", rsColumns);
        this.orgId = getLong(rs, "org_id", rsColumns);
        this.active = getCharacter(rs, "active", rsColumns);
        this.eldComputerItemId = getString(rs, "eld_computer_uuid", rsColumns);
        this.stripeSubscriptionItemId = getLong(rs, "stripe_subscription_item_id", rsColumns);
        this.pricePerSubscription = getLong(rs, "price_per_subscription", rsColumns);
    }

    @Override
    public String toString() {
        return "EldSubscription{" +
                "fields=" + fields +
                ", subscriptionId=" + subscriptionId +
                ", orgId=" + orgId +
                ", active=" + active +
                ", eldComputerItemId='" + eldComputerItemId + '\'' +
                ", stripeSubscriptionItemId=" + stripeSubscriptionItemId +
                ", pricePerSubscription=" + pricePerSubscription +
                '}';
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
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

    public String getEldComputerItemId() {
        return eldComputerItemId;
    }

    public void setEldComputerItemId(String eldComputerItemId) {
        this.eldComputerItemId = eldComputerItemId;
    }

    public Long getStripeSubscriptionItemId() {
        return stripeSubscriptionItemId;
    }

    public void setStripeSubscriptionItemId(Long stripeSubscriptionItemId) {
        this.stripeSubscriptionItemId = stripeSubscriptionItemId;
    }

    public Long getPricePerSubscription() {
        return pricePerSubscription;
    }

    public void setPricePerSubscription(Long pricePerSubscription) {
        this.pricePerSubscription = pricePerSubscription;
    }

    @Override
    public List<Field> getFields() {
        return null;
    }
}
