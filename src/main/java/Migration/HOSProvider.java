package Migration;

import DB.RecordMapperValueObject;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class HOSProvider extends RecordMapperValueObject {
    public Long providerId;
    public String type;
    public String login;
    public String password;
    public Date lastTimeDataReceived;
    public Long orgId;
    public Date createDate;
    public Character status;

    public Long masterDBRefId;

    public HOSProvider(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }

//        this.providerId = getLong(rs, "provider_id", rsColumns);
        this.type = getString(rs, "type", rsColumns);
        this.login = getString(rs, "login", rsColumns);
        this.password = getString(rs, "password", rsColumns);
//        this.lastTimeDataReceived = getDate(rs, "last_time_data_received", rsColumns);
   //    this.orgId = getLong(rs, "org_id", rsColumns);
//        this.createDate = getDate(rs, "create_date", rsColumns);
        this.status = getCharacter(rs, "status", rsColumns);
 //       this.masterDBRefId = getLong(rs, "master_db_ref_id", rsColumns);
    }

    @Override
    public String toString() {
        return "HOSProvider{" +
                "providerId=" + providerId +
                ", type='" + type + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", lastTimeDataReceived=" + lastTimeDataReceived +
                ", orgId=" + orgId +
                ", createDate=" + createDate +
                ", status=" + status +
                ", masterDBRefId=" + masterDBRefId +
                '}';
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastTimeDataReceived() {
        return lastTimeDataReceived;
    }

    public void setLastTimeDataReceived(Date lastTimeDataReceived) {
        this.lastTimeDataReceived = lastTimeDataReceived;
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

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Long getMasterDBRefId() {
        return masterDBRefId;
    }

    public void setMasterDBRefId(Long masterDBRefId) {
        this.masterDBRefId = masterDBRefId;
    }

    @Override
    public List<Field> getFields() {
        return null;
    }
}
