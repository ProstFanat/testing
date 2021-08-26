package migration;

import db.RecordMapperValueObject;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

public class Consumer extends RecordMapperValueObject implements Serializable {

    public Long consumerId;
    public String consumerName;
    public Long orgId;
    public String token;
    public String comment;

    public Consumer(ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
//        this.consumerId = getLong(rs, "consumer_id", rsColumns);
        this.consumerName = getString(rs, "consumer_name", rsColumns);
      //  this.orgId = getLong(rs, "org_id", rsColumns);
     //   this.comment = getString(rs, "comment", rsColumns);
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "consumerId=" + consumerId +
                ", consumerName='" + consumerName + '\'' +
                ", orgId=" + orgId +
                ", token='" + token + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public List<Field> getFields() {
        return null;
    }
}