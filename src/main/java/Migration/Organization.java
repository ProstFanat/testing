package Migration;

import DB.RecordMapperValueObject;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Set;

public class Organization extends RecordMapperValueObject {

    private Long organizationId;
    private String organizationName;
    private Long addressId;
    private String businessType;
    private String bannerUrl;
    private String homeTerminalTimezone;
    private String usdotNumber;
    private String mcNumber;
    private Date createDate;

    private String accountPin;
    private Character ourSafetyService;


    public Organization(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
//        this.organizationId = getLong(rs, "organization_id", rsColumns);
        this.organizationName = getString(rs, "organization_name", rsColumns);
//        this.addressId = getLong(rs, "address_id", rsColumns);
        this.businessType = getString(rs, "business_type", rsColumns);
        this.bannerUrl = getString(rs, "banner_url", rsColumns);
        this.homeTerminalTimezone = getString(rs, "home_terminal_timezone", rsColumns);
        this.usdotNumber = getString(rs, "usdot_number", rsColumns);
        this.mcNumber = getString(rs, "mc_number", rsColumns);
        this.accountPin = getString(rs, "account_pin", rsColumns);
//        this.createDate = getDate(rs, "create_date", rsColumns);
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getHomeTerminalTimezone() {
        return homeTerminalTimezone;
    }

    public void setHomeTerminalTimezone(String homeTerminalTimezone) {
        this.homeTerminalTimezone = homeTerminalTimezone;
    }

    public String getUsdotNumber() {
        return usdotNumber;
    }

    public void setUsdotNumber(String usdotNumber) {
        this.usdotNumber = usdotNumber;
    }

    public String getMcNumber() {
        return mcNumber;
    }

    public void setMcNumber(String mcNumber) {
        this.mcNumber = mcNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAccountPin() {
        return accountPin;
    }

    public void setAccountPin(String accountPin) {
        this.accountPin = accountPin;
    }

    public Character getOurSafetyService() {
        return ourSafetyService;
    }

    public void setOurSafetyService(Character ourSafetyService) {
        this.ourSafetyService = ourSafetyService;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "organizationId=" + organizationId +
                ", organizationName='" + organizationName + '\'' +
                ", addressId=" + addressId +
                ", businessType='" + businessType + '\'' +
                ", bannerUrl='" + bannerUrl + '\'' +
                ", homeTerminalTimezone='" + homeTerminalTimezone + '\'' +
                ", usdotNumber='" + usdotNumber + '\'' +
                ", mcNumber='" + mcNumber + '\'' +
                ", createDate=" + createDate +
                ", accountPin='" + accountPin + '\'' +
                ", ourSafetyService=" + ourSafetyService +
                '}';
    }
}
