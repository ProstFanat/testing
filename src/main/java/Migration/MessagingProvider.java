package Migration;

import DB.RecordMapperValueObject;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Set;

public class MessagingProvider extends RecordMapperValueObject {
    private Long providerId;
    private String type;
    private String login;
    private String password;
    private Long orgId;
    private Character status = 'Y';
    private Date createDate;
    private String parameter1;


    public MessagingProvider(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
//        this.providerId = getLong(rs, "provider_id", rsColumns);
        this.type = getString(rs, "provider_type", rsColumns);
        this.login = getString(rs, "login", rsColumns);
        this.password = getString(rs, "password", rsColumns);
//        this.orgId = getLong(rs, "org_id", rsColumns);
        this.status = getCharacter(rs, "status", rsColumns);
//        this.createDate = getDate(rs, "create_date", rsColumns);
//        this.parameter1 = getString(rs, "parameter_1", rsColumns);
    }

    @Override
    public String toString() {
        return "MessagingProvider{" +
                "providerId=" + providerId +
                ", type='" + type + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
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
}
