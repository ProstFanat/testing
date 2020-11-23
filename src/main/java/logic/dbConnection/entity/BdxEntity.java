package logic.dbConnection.entity;

public class BdxEntity {
    private long orgId;
    private long driverId;
    private long truckId;
    private String crossingDate;
    private String recordOrigin;
    private String fromCountryCode;
    private String toCountryCode;

    public BdxEntity(long orgId, long driverId, long truckId, String crossingDate, String recordOrigin, String fromCountryCode, String toCountryCode) {
        this.orgId = orgId;
        this.driverId = driverId;
        this.truckId = truckId;
        this.crossingDate = crossingDate;
        this.recordOrigin = recordOrigin;
        this.fromCountryCode = fromCountryCode;
        this.toCountryCode = toCountryCode;
    }

    @Override
    public String toString() {
        return "BdxEntity{" +
                "orgId=" + orgId +
                ", driverId=" + driverId +
                ", truckId=" + truckId +
                ", crossingDate='" + crossingDate + '\'' +
                ", recordOrigin=" + recordOrigin +
                ", fromCountryCode='" + fromCountryCode + '\'' +
                ", toCountryCode='" + toCountryCode + '\'' +
                '}';
    }

    public BdxEntity() {
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public long getTruckId() {
        return truckId;
    }

    public void setTruckId(long truckId) {
        this.truckId = truckId;
    }

    public String getCrossingDate() {
        return crossingDate;
    }

    public void setCrossingDate(String crossingDate) {
        this.crossingDate = crossingDate;
    }

    public String getRecordOrigin() {
        return recordOrigin;
    }

    public void setRecordOrigin(String recordOrigin) {
        this.recordOrigin = recordOrigin;
    }

    public String getFromCountryCode() {
        return fromCountryCode;
    }

    public void setFromCountryCode(String fromCountryCode) {
        this.fromCountryCode = fromCountryCode;
    }

    public String getToCountryCode() {
        return toCountryCode;
    }

    public void setToCountryCode(String toCountryCode) {
        this.toCountryCode = toCountryCode;
    }
}
