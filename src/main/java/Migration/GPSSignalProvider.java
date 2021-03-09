package Migration;

import DB.RecordMapperValueObject;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Set;

public class GPSSignalProvider extends RecordMapperValueObject implements Serializable {
    public Long providerId;
    public String type;
    public String login;
    public String password;
    public Long myshawSubscriberId;
    public Long spireonAccountId;
    public String appMode; // For 'trackensure-app-gps' type only
    public Date lastTimeDataReceived;
    public Long orgId;
    public Date createDate;

    public Long masterDBRefId;

    public GPSSignalProvider(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
//        this.providerId = getLong(rs, "provider_id", rsColumns);
        this.type = getString(rs, "type", rsColumns);
        this.login = getString(rs, "login", rsColumns);
        this.password = getString(rs, "password", rsColumns);
//        this.myshawSubscriberId = getLong(rs, "myshaw_subscriber_id", rsColumns);
//        this.spireonAccountId = getLong(rs, "spireon_account_id", rsColumns);
        this.appMode = getString(rs, "app_mode", rsColumns);
//        this.lastTimeDataReceived = getDate(rs, "last_time_data_received", rsColumns);
     //   this.orgId = getLong(rs, "org_id", rsColumns);
//        this.createDate = getDate(rs, "create_date", rsColumns);
  //      this.masterDBRefId = getLong(rs, "master_db_ref_id", rsColumns);
    }

    @Override
    public String toString() {
        return "GPSSignalProvider{" +
                "providerId=" + providerId +
                ", type='" + type + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", myshawSubscriberId=" + myshawSubscriberId +
                ", spireonAccountId=" + spireonAccountId +
                ", appMode='" + appMode + '\'' +
                ", lastTimeDataReceived=" + lastTimeDataReceived +
                ", orgId=" + orgId +
                ", createDate=" + createDate +
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

    public Long getMyshawSubscriberId() {
        return myshawSubscriberId;
    }

    public void setMyshawSubscriberId(Long myshawSubscriberId) {
        this.myshawSubscriberId = myshawSubscriberId;
    }

    public Long getSpireonAccountId() {
        return spireonAccountId;
    }

    public void setSpireonAccountId(Long spireonAccountId) {
        this.spireonAccountId = spireonAccountId;
    }

    public String getAppMode() {
        return appMode;
    }

    public void setAppMode(String appMode) {
        this.appMode = appMode;
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

    public Long getMasterDBRefId() {
        return masterDBRefId;
    }

    public void setMasterDBRefId(Long masterDBRefId) {
        this.masterDBRefId = masterDBRefId;
    }
}
