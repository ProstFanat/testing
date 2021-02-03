package Migration;

import DB.RecordMapperValueObject;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Set;

public class FuelPurchaseReceipt extends RecordMapperValueObject {

    private Long		purchaseId;
    private Long		driverId;
    private Long		truckId;
    private Long 		orgId;
    private Date createDate;
    private Date		purchaseDate;
    private BigDecimal odometer;
    private String 		distanceUnit;
    private String 		countryCode; // 2 letters all capital case
    private String 		provStateCode; // 2 letters all capital case
    private String 		latitude;
    private String 		longitude;
    private String 		vendorName;
    private String 		fuelType;
    private BigDecimal 	volume;
    private String 		volumeUnit;
    private BigDecimal 	price;
    private String 		currency;
    private BigDecimal 	pricePerUnit;
    private String 		receiptImage;
    private Long		purchaseDateUTC;
    private String		refId;//received from eLog App (it is ID this receipt in TE DB)
    private String      driverFullName;
    private String		homeTerminalTimezone;
    private String      truckNumber;
    private Character   isValidReceipt;

    public FuelPurchaseReceipt(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        this.purchaseId = getLong(rs, "purchase_id", rsColumns);
        this.driverId = getLong(rs, "driver_id", rsColumns);
        this.truckId = getLong(rs, "truck_id", rsColumns);
        this.orgId = getLong(rs, "org_id", rsColumns);
        this.createDate = getDate(rs, "create_date", rsColumns);
        this.purchaseDate = getDate(rs, "purchase_date", rsColumns);
        this.odometer = getBigDecimal(rs, "odometer", rsColumns);
        this.distanceUnit = getString(rs, "distance_unit", rsColumns);
        this.countryCode = getString(rs, "country_code", rsColumns);
        this.provStateCode = getString(rs, "prov_state_code", rsColumns);
        this.latitude = getString(rs, "latitude", rsColumns);
        this.longitude = getString(rs, "longitude", rsColumns);
        this.vendorName = getString(rs, "vendor_name", rsColumns);
        this.fuelType = getString(rs, "fuel_type", rsColumns);
        this.volume = getBigDecimal(rs, "volume", rsColumns);
        this.volumeUnit = getString(rs, "volume_unit", rsColumns);
        this.price = getBigDecimal(rs, "price", rsColumns);
        this.currency = getString(rs, "currency", rsColumns);
        this.pricePerUnit = getBigDecimal(rs, "price_per_unit", rsColumns);
        this.receiptImage = getString(rs, "receipt_image", rsColumns);
        this.isValidReceipt = getCharacter(rs, "is_valid_receipt", rsColumns);
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getTruckId() {
        return truckId;
    }

    public void setTruckId(Long truckId) {
        this.truckId = truckId;
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

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getOdometer() {
        return odometer;
    }

    public void setOdometer(BigDecimal odometer) {
        this.odometer = odometer;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvStateCode() {
        return provStateCode;
    }

    public void setProvStateCode(String provStateCode) {
        this.provStateCode = provStateCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public String getVolumeUnit() {
        return volumeUnit;
    }

    public void setVolumeUnit(String volumeUnit) {
        this.volumeUnit = volumeUnit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getReceiptImage() {
        return receiptImage;
    }

    public void setReceiptImage(String receiptImage) {
        this.receiptImage = receiptImage;
    }

    public Long getPurchaseDateUTC() {
        return purchaseDateUTC;
    }

    public void setPurchaseDateUTC(Long purchaseDateUTC) {
        this.purchaseDateUTC = purchaseDateUTC;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getDriverFullName() {
        return driverFullName;
    }

    public void setDriverFullName(String driverFullName) {
        this.driverFullName = driverFullName;
    }

    public String getHomeTerminalTimezone() {
        return homeTerminalTimezone;
    }

    public void setHomeTerminalTimezone(String homeTerminalTimezone) {
        this.homeTerminalTimezone = homeTerminalTimezone;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public Character getIsValidReceipt() {
        return isValidReceipt;
    }

    public void setIsValidReceipt(Character isValidReceipt) {
        this.isValidReceipt = isValidReceipt;
    }

    @Override
    public String toString() {
        return "FuelPurchaseReceipt{" +
                "purchaseId=" + purchaseId +
                ", driverId=" + driverId +
                ", truckId=" + truckId +
                ", orgId=" + orgId +
                ", createDate=" + createDate +
                ", purchaseDate=" + purchaseDate +
                ", odometer=" + odometer +
                ", distanceUnit='" + distanceUnit + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", provStateCode='" + provStateCode + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", vendorName='" + vendorName + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", volume=" + volume +
                ", volumeUnit='" + volumeUnit + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", pricePerUnit=" + pricePerUnit +
                ", receiptImage='" + receiptImage + '\'' +
                ", purchaseDateUTC=" + purchaseDateUTC +
                ", refId='" + refId + '\'' +
                ", driverFullName='" + driverFullName + '\'' +
                ", homeTerminalTimezone='" + homeTerminalTimezone + '\'' +
                ", truckNumber='" + truckNumber + '\'' +
                ", isValidReceipt=" + isValidReceipt +
                '}';
    }
}
