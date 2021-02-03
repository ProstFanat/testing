package Migration;

import DB.RecordMapperValueObject;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Set;

public class EldBorderCrossingEvent extends RecordMapperValueObject {

    private Long id;
    private Long orgId;
    private Date createDate;
    private Date updateDate;
    private Date crossingDate;
    private Long driverId1;
    private Long driverId2;
    private Long truckId;
    private String truckNumber;
    private String eventOrigin;
    private String timeZoneOffset;
    private String odometer;
    private String latBeforeCross;
    private String lngBeforeCross;
    private String latAfterCross;
    private String lngAfterCross;
    private String fromCountryCode;
    private String toCountryCode;
    private String shippingNumber;
    private String trailerNumber;
    private String comment;
    private Long remoteId; // primary key on the phone/tablet database
    private String firstName;
    private String lastName;
    private String locationDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCrossingDate() {
        return crossingDate;
    }

    public void setCrossingDate(Date crossingDate) {
        this.crossingDate = crossingDate;
    }

    public Long getDriverId1() {
        return driverId1;
    }

    public void setDriverId1(Long driverId1) {
        this.driverId1 = driverId1;
    }

    public Long getDriverId2() {
        return driverId2;
    }

    public void setDriverId2(Long driverId2) {
        this.driverId2 = driverId2;
    }

    public Long getTruckId() {
        return truckId;
    }

    public void setTruckId(Long truckId) {
        this.truckId = truckId;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public String getEventOrigin() {
        return eventOrigin;
    }

    public void setEventOrigin(String eventOrigin) {
        this.eventOrigin = eventOrigin;
    }

    public String getTimeZoneOffset() {
        return timeZoneOffset;
    }

    public void setTimeZoneOffset(String timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
    }

    public String getOdometer() {
        return odometer;
    }

    public void setOdometer(String odometer) {
        this.odometer = odometer;
    }

    public String getLatBeforeCross() {
        return latBeforeCross;
    }

    public void setLatBeforeCross(String latBeforeCross) {
        this.latBeforeCross = latBeforeCross;
    }

    public String getLngBeforeCross() {
        return lngBeforeCross;
    }

    public void setLngBeforeCross(String lngBeforeCross) {
        this.lngBeforeCross = lngBeforeCross;
    }

    public String getLatAfterCross() {
        return latAfterCross;
    }

    public void setLatAfterCross(String latAfterCross) {
        this.latAfterCross = latAfterCross;
    }

    public String getLngAfterCross() {
        return lngAfterCross;
    }

    public void setLngAfterCross(String lngAfterCross) {
        this.lngAfterCross = lngAfterCross;
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

    public String getShippingNumber() {
        return shippingNumber;
    }

    public void setShippingNumber(String shippingNumber) {
        this.shippingNumber = shippingNumber;
    }

    public String getTrailerNumber() {
        return trailerNumber;
    }

    public void setTrailerNumber(String trailerNumber) {
        this.trailerNumber = trailerNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(Long remoteId) {
        this.remoteId = remoteId;
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

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public EldBorderCrossingEvent(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        //this.id = getLong(rs, "id", rsColumns);
        this.orgId = getLong(rs, "org_id", rsColumns);
        this.createDate = getDate(rs, "create_date", rsColumns);
        this.updateDate = getDate(rs, "update_date", rsColumns);
        this.crossingDate = getDate(rs, "crossing_date", rsColumns);
      //  this.driverId1 = getLong(rs, "driver_id_1", rsColumns);
      //  this.driverId2 = getLong(rs, "driver_id_2", rsColumns);
     //   this.truckId = getLong(rs, "truck_id", rsColumns);
        this.truckNumber = getString(rs, "truck_number", rsColumns);
        this.eventOrigin = getString(rs, "event_origin", rsColumns);
        this.timeZoneOffset = getString(rs, "time_zone_offset", rsColumns);
        this.odometer = getString(rs, "odometer", rsColumns);
        this.latBeforeCross = getString(rs, "lat_before_cross", rsColumns);
        this.lngBeforeCross = getString(rs, "lng_before_cross", rsColumns);
        this.latAfterCross = getString(rs, "lat_after_cross", rsColumns);
        this.lngAfterCross = getString(rs, "lng_after_cross", rsColumns);
        this.fromCountryCode = getString(rs, "from_country_code", rsColumns);
        this.toCountryCode = getString(rs, "to_country_code", rsColumns);
        this.shippingNumber = getString(rs, "shipping_number", rsColumns);
        this.trailerNumber = getString(rs, "trailer_number", rsColumns);
        this.comment = getString(rs, "comment", rsColumns);
        this.remoteId = getLong(rs, "remote_id", rsColumns);
    }


    public EldBorderCrossingEvent(Long id, Long orgId, Date createDate, Date updateDate, Date crossingDate, Long driverId1, Long driverId2, Long truckId, String eventOrigin, String timeZoneOffset, String odometer, String latBeforeCross, String lngBeforeCross, String latAfterCross, String lngAfterCross, String fromCountryCode, String toCountryCode, String shippingNumber, String trailerNumber, String comment, Long remoteId) {
        this.id = id;
        this.orgId = orgId;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.crossingDate = crossingDate;
        this.driverId1 = driverId1;
        this.driverId2 = driverId2;
        this.truckId = truckId;
        this.eventOrigin = eventOrigin;
        this.timeZoneOffset = timeZoneOffset;
        this.odometer = odometer;
        this.latBeforeCross = latBeforeCross;
        this.lngBeforeCross = lngBeforeCross;
        this.latAfterCross = latAfterCross;
        this.lngAfterCross = lngAfterCross;
        this.fromCountryCode = fromCountryCode;
        this.toCountryCode = toCountryCode;
        this.shippingNumber = shippingNumber;
        this.trailerNumber = trailerNumber;
        this.comment = comment;
        this.remoteId = remoteId;
    }

    @Override
    public String toString() {
        return "EldBorderCrossingEvent{" +
                "id=" + id +
                ", orgId=" + orgId +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", crossingDate=" + crossingDate +
                ", driverId1=" + driverId1 +
                ", driverId2=" + driverId2 +
                ", truckId=" + truckId +
                ", truckNumber='" + truckNumber + '\'' +
                ", eventOrigin='" + eventOrigin + '\'' +
                ", timeZoneOffset='" + timeZoneOffset + '\'' +
                ", odometer='" + odometer + '\'' +
                ", latBeforeCross='" + latBeforeCross + '\'' +
                ", lngBeforeCross='" + lngBeforeCross + '\'' +
                ", latAfterCross='" + latAfterCross + '\'' +
                ", lngAfterCross='" + lngAfterCross + '\'' +
                ", fromCountryCode='" + fromCountryCode + '\'' +
                ", toCountryCode='" + toCountryCode + '\'' +
                ", shippingNumber='" + shippingNumber + '\'' +
                ", trailerNumber='" + trailerNumber + '\'' +
                ", comment='" + comment + '\'' +
                ", remoteId=" + remoteId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", locationDescription='" + locationDescription + '\'' +
                '}';
    }
}
