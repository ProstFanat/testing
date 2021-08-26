package migration;

import db.RecordMapperValueObject;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

public class EdiDataConsumer extends RecordMapperValueObject {
    public Long consumerId;
    public Long customerId;
    public Long orgId;
    public String receiverId;
    public String senderId;
    public String authInfo;
    public String securityInfo;
    public String ftpInformation;
    public Character invoice;


    public EdiDataConsumer(ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
//        this.consumerId = getLong(rs, "consumer_id", rsColumns);
//        this.customerId = getLong(rs, "customer_id", rsColumns);
//        this.orgId = getLong(rs,"org_id", rsColumns);
//        this.receiverId = getString(rs, "receiver_id", rsColumns);
//        this.senderId = getString(rs, "sender_id", rsColumns);
        this.authInfo = getString(rs, "auth_info", rsColumns);
        this.securityInfo = getString(rs, "security_info", rsColumns);
        this.ftpInformation = getString(rs, "ftp_information", rsColumns);
        this.invoice = getCharacter(rs, "invoice", rsColumns);
    }

    @Override
    public String toString() {
        return "EdiDataConsumer{" +
                "consumerId=" + consumerId +
                ", customerId=" + customerId +
                ", orgId=" + orgId +
                ", receiverId='" + receiverId + '\'' +
                ", senderId='" + senderId + '\'' +
                ", authInfo='" + authInfo + '\'' +
                ", securityInfo='" + securityInfo + '\'' +
                ", ftpInformation='" + ftpInformation + '\'' +
                ", invoice=" + invoice +
                '}';
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }

    public String getSecurityInfo() {
        return securityInfo;
    }

    public void setSecurityInfo(String securityInfo) {
        this.securityInfo = securityInfo;
    }

    public String getFtpInformation() {
        return ftpInformation;
    }

    public void setFtpInformation(String ftpInformation) {
        this.ftpInformation = ftpInformation;
    }

    public Character getInvoice() {
        return invoice;
    }

    public void setInvoice(Character invoice) {
        this.invoice = invoice;
    }

    @Override
    public List<Field> getFields() {
        return null;
    }
}
