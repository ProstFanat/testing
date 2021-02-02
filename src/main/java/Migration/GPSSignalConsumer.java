package Migration;

import DB.RecordMapperValueObject;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Set;

public class GPSSignalConsumer extends RecordMapperValueObject {
    private Long consumerId;
    private String type;
    private Long orgId;
    private Date createDate;
    private String replayEmail;
    private String email;
    private  String emailSubject;

    public GPSSignalConsumer(ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        this.consumerId = getLong(rs, "consumer_id", rsColumns);
        this.type = getString(rs, "type", rsColumns);
        this.orgId = getLong(rs,"org_id", rsColumns);
        this.createDate = getDate(rs, "create_date", rsColumns);
        this.replayEmail = getString(rs, "reply_email", rsColumns);
        this.email = getString(rs, "email", rsColumns);
        this.emailSubject = getString(rs, "email_subject", rsColumns);
    }

    @Override
    public String toString() {
        return "GPSSignalConsumer{" +
                "consumerId=" + consumerId +
                ", type='" + type + '\'' +
                ", orgId=" + orgId +
                ", createDate=" + createDate +
                ", replayEmail='" + replayEmail + '\'' +
                ", email='" + email + '\'' +
                ", emailSubject='" + emailSubject + '\'' +
                '}';
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getReplayEmail() {
        return replayEmail;
    }

    public void setReplayEmail(String replayEmail) {
        this.replayEmail = replayEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }
}
