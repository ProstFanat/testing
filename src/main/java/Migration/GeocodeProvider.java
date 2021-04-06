package Migration;

import DB.RecordMapperValueObject;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class GeocodeProvider extends RecordMapperValueObject {
    public Long providerId;
    public String providerType;
    public Integer priority;
    public String apiKey;
    public String appCode; //Only for Here Maps
    public Long orgId;
    public Character status = 'Y';
    public Date createDate;
    public String parameter1;

    public GeocodeProvider() {
    }

    public GeocodeProvider(ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
//        this.providerId = getLong(rs, "provider_id", rsColumns);
        this.providerType = getString(rs, "provider_type", rsColumns);
        this.priority = getInteger(rs,"priority", rsColumns);
        this.apiKey = getString(rs, "api_key", rsColumns);
        this.appCode = getString(rs, "app_code", rsColumns);
//        this.orgId = getLong(rs, "org_id", rsColumns);
        this.status = getCharacter(rs, "status", rsColumns);
//        this.createDate = getDate(rs, "create_date", rsColumns);
//        this.parameter1 = getString(rs, "parameter_1", rsColumns);
    }

    @Override
    public String toString() {
        return "GeocodeProvider{" +
                "providerId=" + providerId +
                ", providerType='" + providerType + '\'' +
                ", priority=" + priority +
                ", apiKey='" + apiKey + '\'' +
                ", appCode='" + appCode + '\'' +
                ", orgId=" + orgId +
                ", status=" + status +
                ", createDate=" + createDate +
                ", parameter1='" + parameter1 + '\'' +
                '}';
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public String getProviderType() {
        return providerType;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    @Override
    public List<Field> getFields() {
        return null;
    }
}
