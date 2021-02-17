package Migration;

import DB.RecordMapperValueObject;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Set;

public class Department extends RecordMapperValueObject {
    private Long departmentId;
    private Long orgId;
    private String name;
    private Boolean hasOutbound;
    private Boolean hasInbound;
    private String colour;
    private Boolean isLocal;
    private Boolean collectRevenuePerMile;
    private Date createDate;
    private String refDepartmentCode;//TransPlus: Division.DivCode
    private String refDepartmentId;//TransPlus: Division.DivisionID

    private Long masterDBRefId;

    public Department(ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
//        this.departmentId = getLong(rs, "department_id", rsColumns);
//        this.orgId = getLong(rs, "org_id", rsColumns);
        this.name = getString(rs, "name", rsColumns);
        this.hasOutbound = getBooleanFromCharacter(rs, "has_outbound", rsColumns, true);
        this.hasInbound = getBooleanFromCharacter(rs, "has_inbound", rsColumns, true);
        this.isLocal = getBooleanFromCharacter(rs, "is_local", rsColumns, false);
        this.collectRevenuePerMile = getBooleanFromCharacter(rs, "collect_revenue_per_mile", rsColumns, true);
        this.colour = getString(rs, "colour", rsColumns);
//        this.createDate = getDate(rs, "create_date", rsColumns);
        this.refDepartmentCode = getString(rs, "ref_department_code", rsColumns);
//        this.refDepartmentId = getString(rs, "ref_department_id", rsColumns);
      //  this.masterDBRefId = getLong(rs, "master_db_ref_id", rsColumns);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", orgId=" + orgId +
                ", name='" + name + '\'' +
                ", hasOutbound=" + hasOutbound +
                ", hasInbound=" + hasInbound +
                ", colour='" + colour + '\'' +
                ", isLocal=" + isLocal +
                ", collectRevenuePerMile=" + collectRevenuePerMile +
                ", createDate=" + createDate +
                ", refDepartmentCode='" + refDepartmentCode + '\'' +
                ", refDepartmentId='" + refDepartmentId + '\'' +
                ", masterDBRefId=" + masterDBRefId +
                '}';
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHasOutbound() {
        return hasOutbound;
    }

    public void setHasOutbound(Boolean hasOutbound) {
        this.hasOutbound = hasOutbound;
    }

    public Boolean getHasInbound() {
        return hasInbound;
    }

    public void setHasInbound(Boolean hasInbound) {
        this.hasInbound = hasInbound;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Boolean getLocal() {
        return isLocal;
    }

    public void setLocal(Boolean local) {
        isLocal = local;
    }

    public Boolean getCollectRevenuePerMile() {
        return collectRevenuePerMile;
    }

    public void setCollectRevenuePerMile(Boolean collectRevenuePerMile) {
        this.collectRevenuePerMile = collectRevenuePerMile;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRefDepartmentCode() {
        return refDepartmentCode;
    }

    public void setRefDepartmentCode(String refDepartmentCode) {
        this.refDepartmentCode = refDepartmentCode;
    }

    public String getRefDepartmentId() {
        return refDepartmentId;
    }

    public void setRefDepartmentId(String refDepartmentId) {
        this.refDepartmentId = refDepartmentId;
    }

    public Long getMasterDBRefId() {
        return masterDBRefId;
    }

    public void setMasterDBRefId(Long masterDBRefId) {
        this.masterDBRefId = masterDBRefId;
    }
}
