package Migration;

import DB.RecordMapperValueObject;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

public class Address extends RecordMapperValueObject {
    public Long addressId;
    public String country;
    public String region;
    public String city;
    public String town;
    public String village;
    public String hamlet;
    public String suburb;
    public String addressLine1;
    public String addressLine2;
    public String postalCode;
    public String latitude;
    public String longitude;

    public String locationName;
    public String countryCode;
    public String direction; // for ELogLocationDescriptionParser
    public String remotenessOfDirection; // for ELogLocationDescriptionParser
    public String addressAsOneLine;

    public String hereLocationId; // for Here geocode api

    public String street;
    public String houseNumber;

    public Address(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
//        this.addressId = getLong(rs, "address_id", rsColumns);
        this.country = getString(rs, "country", rsColumns);
        this.region = getString(rs, "region", rsColumns);
        this.city = getString(rs, "city", rsColumns);
        this.addressLine1 = getString(rs, "address_line_1", rsColumns);
        this.addressLine2 = getString(rs, "address_line_2", rsColumns);
        this.postalCode = getString(rs, "postal_code", rsColumns);
        this.latitude = getString(rs, "latitude", rsColumns);
        this.longitude = getString(rs, "longitude", rsColumns);
        this.street = getString(rs, "street", rsColumns);
        this.houseNumber = getString(rs, "house_umber",rsColumns);
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getHamlet() {
        return hamlet;
    }

    public void setHamlet(String hamlet) {
        this.hamlet = hamlet;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getRemotenessOfDirection() {
        return remotenessOfDirection;
    }

    public void setRemotenessOfDirection(String remotenessOfDirection) {
        this.remotenessOfDirection = remotenessOfDirection;
    }

    public String getAddressAsOneLine() {
        return addressAsOneLine;
    }

    public void setAddressAsOneLine(String addressAsOneLine) {
        this.addressAsOneLine = addressAsOneLine;
    }

    public String getHereLocationId() {
        return hereLocationId;
    }

    public void setHereLocationId(String hereLocationId) {
        this.hereLocationId = hereLocationId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                ", village='" + village + '\'' +
                ", hamlet='" + hamlet + '\'' +
                ", suburb='" + suburb + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", locationName='" + locationName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", direction='" + direction + '\'' +
                ", remotenessOfDirection='" + remotenessOfDirection + '\'' +
                ", addressAsOneLine='" + addressAsOneLine + '\'' +
                ", hereLocationId='" + hereLocationId + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }

    @Override
    public List<Field> getFields() {
        return null;
    }
}
