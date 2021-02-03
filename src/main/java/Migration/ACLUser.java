package Migration;

import DB.RecordMapperValueObject;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ACLUser extends RecordMapperValueObject implements Serializable {
    private Long userId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String loginName;
    private transient String password;
    private transient String salt;
    private Character activeInd;
    private Character accessToAllOrg;

    private Long masterDBRefId;
    private Long clientDBRefId;

    private String userLanguage;

    private Long organizationId;
    private String userType;

    private String organizationName;
    private Date lastLoginDateTime;

    private List<ACLMatrix> permissionMatrix;

    private List<ACLUserMatrix> userPermissionMatrix;

    private String status;
    private Character resetPassword = 'N';

    private Long driverId;

    public ACLUser(ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
//        this.userId = getLong(rs, "user_id", rsColumns);
        this.firstName = getString(rs, "first_name", rsColumns);
        this.lastName = getString(rs, "last_name", rsColumns);
        this.loginName = getString(rs, "login_name", rsColumns);
        this.activeInd = getCharacter(rs, "active_ind", rsColumns, 'Y');
        this.accessToAllOrg = getCharacter(rs, "access_to_all_org", rsColumns, 'N');
        this.userType = getString(rs, "user_type", rsColumns);
//        this.organizationId = getLong(rs, "organization_id", rsColumns);
        this.salt = getString(rs, "salt", rsColumns);
        this.userLanguage = getString(rs, "user_language", rsColumns);
        this.status = getString(rs, "status", rsColumns);
        this.lastLoginDateTime = getDate(rs, "last_login_date_time", rsColumns);
//        this.driverId = getLong(rs, "driver_id", rsColumns);
        this.password = getString(rs, "password", rsColumns);
//        this.masterDBRefId = getLong(rs, "master_db_ref_id", rsColumns);
//        this.clientDBRefId = getLong(rs, "client_db_ref_id", rsColumns);
    }

    @Override
    public String toString() {
        return "ACLUser{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", activeInd=" + activeInd +
                ", accessToAllOrg=" + accessToAllOrg +
                ", masterDBRefId=" + masterDBRefId +
                ", clientDBRefId=" + clientDBRefId +
                ", userLanguage='" + userLanguage + '\'' +
                ", organizationId=" + organizationId +
                ", userType='" + userType + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", lastLoginDateTime=" + lastLoginDateTime +
                ", permissionMatrix=" + permissionMatrix +
                ", userPermissionMatrix=" + userPermissionMatrix +
                ", status='" + status + '\'' +
                ", resetPassword=" + resetPassword +
                ", driverId=" + driverId +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Character getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(Character activeInd) {
        this.activeInd = activeInd;
    }

    public Character getAccessToAllOrg() {
        return accessToAllOrg;
    }

    public void setAccessToAllOrg(Character accessToAllOrg) {
        this.accessToAllOrg = accessToAllOrg;
    }

    public Long getMasterDBRefId() {
        return masterDBRefId;
    }

    public void setMasterDBRefId(Long masterDBRefId) {
        this.masterDBRefId = masterDBRefId;
    }

    public Long getClientDBRefId() {
        return clientDBRefId;
    }

    public void setClientDBRefId(Long clientDBRefId) {
        this.clientDBRefId = clientDBRefId;
    }

    public String getUserLanguage() {
        return userLanguage;
    }

    public void setUserLanguage(String userLanguage) {
        this.userLanguage = userLanguage;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Date getLastLoginDateTime() {
        return lastLoginDateTime;
    }

    public void setLastLoginDateTime(Date lastLoginDateTime) {
        this.lastLoginDateTime = lastLoginDateTime;
    }

    public List<ACLMatrix> getPermissionMatrix() {
        return permissionMatrix;
    }

    public void setPermissionMatrix(List<ACLMatrix> permissionMatrix) {
        this.permissionMatrix = permissionMatrix;
    }

    public List<ACLUserMatrix> getUserPermissionMatrix() {
        return userPermissionMatrix;
    }

    public void setUserPermissionMatrix(List<ACLUserMatrix> userPermissionMatrix) {
        this.userPermissionMatrix = userPermissionMatrix;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Character getResetPassword() {
        return resetPassword;
    }

    public void setResetPassword(Character resetPassword) {
        this.resetPassword = resetPassword;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }
}
