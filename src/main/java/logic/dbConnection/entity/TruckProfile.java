package logic.dbConnection.entity;

public class TruckProfile {
   private boolean trackEnsureElog = false;
   private String truckNumber = "";
    private String licensePlate = "";
    private String licenseState = "";
    private String vinNumber = "";
    private String make = "";
    private String model = "";
    private String year = "";
    private String tare = "";
    private boolean fifthWheel = false;
    private String gpsProvider = "";
    private String gpsUnitId = "";
    private String minStopDeltaDistanceMeters = "";
    private String maxSpeedForStart = "";
    private String minStopDuration = "";
    private String eldSerial = "";
    private String eldSerialNum = "";
    private String odometerOffset = "";
    private String fuelType = "";
    private String status = "";
    private boolean personalUseLimitStatus = false;
    private String personalUseLimitValue = "";
    private boolean yardMoveLimitStatus = false;
    private String yardMoveLimitValue = "";
    private String assignedToDriverOne = "";
    private String tempAssignedToDriverOne = "";
    private String assignedToDriverTwo = "";
    private String tempAssignedToDriverTwo = "";

    public TruckProfile() {
    }
    public TruckProfile(boolean trackEnsureElog, String truckNumber, String licensePlate, String licenseState,
                        String vinNumber, String make, String model, String year, String tare, boolean fifthWheel,
                        String gpsProvider, String gpsUnitId, String minStopDeltaDistanceMeters, String maxSpeedForStart,
                        String minStopDuration, String eldSerial,String eldSerialNum, String odometerOffset, String fuelType, String status,
                        boolean personalUseLimitStatus, String personalUseLimitValue, boolean yardMoveLimitStatus,
                        String yardMoveLimitValue, String assignedToDriverOne, String tempAssignedToDriverOne,
                        String assignedToDriverTwo, String tempAssignedToDriverTwo) {
        this.trackEnsureElog = trackEnsureElog;
        this.truckNumber = truckNumber;
        this.licensePlate = licensePlate;
        this.licenseState = licenseState;
        this.vinNumber = vinNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.tare = tare;
        this.fifthWheel = fifthWheel;
        this.gpsProvider = gpsProvider;
        this.gpsUnitId = gpsUnitId;
        this.minStopDeltaDistanceMeters = minStopDeltaDistanceMeters;
        this.maxSpeedForStart = maxSpeedForStart;
        this.minStopDuration = minStopDuration;
        this.eldSerial = eldSerial;
        this.eldSerialNum = eldSerialNum;
        this.odometerOffset = odometerOffset;
        this.fuelType = fuelType;
        this.status = status;
        this.personalUseLimitStatus = personalUseLimitStatus;
        this.personalUseLimitValue = personalUseLimitValue;
        this.yardMoveLimitStatus = yardMoveLimitStatus;
        this.yardMoveLimitValue = yardMoveLimitValue;
        this.assignedToDriverOne = assignedToDriverOne;
        this.tempAssignedToDriverOne = tempAssignedToDriverOne;
        this.assignedToDriverTwo = assignedToDriverTwo;
        this.tempAssignedToDriverTwo = tempAssignedToDriverTwo;
    }

    public String getEldSerialNum() {
        return eldSerialNum;
    }

    public void setEldSerialNum(String eldSerialNum) {
        this.eldSerialNum = eldSerialNum;
    }

    public boolean isTrackEnsureElog() {
        return trackEnsureElog;
    }

    public void setTrackEnsureElog(boolean trackEnsureElog) {
        this.trackEnsureElog = trackEnsureElog;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicenseState() {
        return licenseState;
    }

    public void setLicenseState(String licenseState) {
        this.licenseState = licenseState;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTare() {
        return tare;
    }

    public void setTare(String tare) {
        this.tare = tare;
    }

    public boolean isFifthWheel() {
        return fifthWheel;
    }

    public void setFifthWheel(boolean fifthWheel) {
        this.fifthWheel = fifthWheel;
    }

    public String getGpsProvider() {
        return gpsProvider;
    }

    public void setGpsProvider(String gpsProvider) {
        this.gpsProvider = gpsProvider;
    }

    public String getGpsUnitId() {
        return gpsUnitId;
    }

    public void setGpsUnitId(String gpsUnitId) {
        this.gpsUnitId = gpsUnitId;
    }

    public String getMinStopDeltaDistanceMeters() {
        return minStopDeltaDistanceMeters;
    }

    public void setMinStopDeltaDistanceMeters(String minStopDeltaDistanceMeters) {
        this.minStopDeltaDistanceMeters = minStopDeltaDistanceMeters;
    }

    public String getMaxSpeedForStart() {
        return maxSpeedForStart;
    }

    public void setMaxSpeedForStart(String maxSpeedForStart) {
        this.maxSpeedForStart = maxSpeedForStart;
    }

    public String getMinStopDuration() {
        return minStopDuration;
    }

    public void setMinStopDuration(String minStopDuration) {
        this.minStopDuration = minStopDuration;
    }

    public String getEldSerial() {
        return eldSerial;
    }

    public void setEldSerial(String eldSerial) {
        this.eldSerial = eldSerial;
    }

    public String getOdometerOffset() {
        return odometerOffset;
    }

    public void setOdometerOffset(String odometerOffset) {
        this.odometerOffset = odometerOffset;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPersonalUseLimitStatus() {
        return personalUseLimitStatus;
    }

    public void setPersonalUseLimitStatus(boolean personalUseLimitStatus) {
        this.personalUseLimitStatus = personalUseLimitStatus;
    }

    public String getPersonalUseLimitValue() {
        return personalUseLimitValue;
    }

    public void setPersonalUseLimitValue(String personalUseLimitValue) {
        this.personalUseLimitValue = personalUseLimitValue;
    }

    public boolean isYardMoveLimitStatus() {
        return yardMoveLimitStatus;
    }

    public void setYardMoveLimitStatus(boolean yardMoveLimitStatus) {
        this.yardMoveLimitStatus = yardMoveLimitStatus;
    }

    public String getYardMoveLimitValue() {
        return yardMoveLimitValue;
    }

    public void setYardMoveLimitValue(String yardMoveLimitValue) {
        this.yardMoveLimitValue = yardMoveLimitValue;
    }

    public String getAssignedToDriverOne() {
        return assignedToDriverOne;
    }

    public void setAssignedToDriverOne(String assignedToDriverOne) {
        this.assignedToDriverOne = assignedToDriverOne;
    }

    public String getTempAssignedToDriverOne() {
        return tempAssignedToDriverOne;
    }

    public void setTempAssignedToDriverOne(String tempAssignedToDriverOne) {
        this.tempAssignedToDriverOne = tempAssignedToDriverOne;
    }

    public String getAssignedToDriverTwo() {
        return assignedToDriverTwo;
    }

    public void setAssignedToDriverTwo(String assignedToDriverTwo) {
        this.assignedToDriverTwo = assignedToDriverTwo;
    }

    public String getTempAssignedToDriverTwo() {
        return tempAssignedToDriverTwo;
    }

    public void setTempAssignedToDriverTwo(String tempAssignedToDriverTwo) {
        this.tempAssignedToDriverTwo = tempAssignedToDriverTwo;
    }
    public void changeStatus(){
        if(this.status.equals("ACTIVE"))
            this.status="INACTIVE";
        else if(this.status.equals("INACTIVE"))
            this.status="OUT OF SERVICE";
        else if(this.status.equals("OUT OF SERVICE"))
            this.status="INACTIVE";
    }
    @Override
    public String toString() {
        return "\nTruckProfile{" +
                " \ntrackEnsureElog=" + trackEnsureElog +
                ",\n truckNumber='" + truckNumber + '\'' +
                ",\n licensePlate='" + licensePlate + '\'' +
                ",\n licenseState='" + licenseState + '\'' +
                ",\n vinNumber='" + vinNumber + '\'' +
                ",\n make='" + make + '\'' +
                ",\n model='" + model + '\'' +
                ",\n year='" + year + '\'' +
                ",\n tare='" + tare + '\'' +
                ",\n fifthWheel=" + fifthWheel +
                ",\n gpsProvider='" + gpsProvider + '\'' +
                ",\n gpsUnitId='" + gpsUnitId + '\'' +
                ",\n minStopDeltaDistanceMeters='" + minStopDeltaDistanceMeters + '\'' +
                ",\n maxSpeedForStart='" + maxSpeedForStart + '\'' +
                ",\n minStopDuration='" + minStopDuration + '\'' +
                ",\n eldSerial='" + eldSerial + '\'' +
                ",\n eldSerialNum='" + eldSerialNum + '\'' +
                ",\n odometerOffset='" + odometerOffset + '\'' +
                ",\n fuelType='" + fuelType + '\'' +
                ",\n status='" + status + '\'' +
                ",\n personalUseLimitStatus=" + personalUseLimitStatus +
                ",\n personalUseLimitValue='" + personalUseLimitValue + '\'' +
                ",\n yardMoveLimitStatus=" + yardMoveLimitStatus +
                ",\n yardMoveLimitValue='" + yardMoveLimitValue + '\'' +
                ",\n assignedToDriverOne='" + assignedToDriverOne + '\'' +
                ",\n tempAssignedToDriverOne='" + tempAssignedToDriverOne + '\'' +
                ",\n assignedToDriverTwo='" + assignedToDriverTwo + '\'' +
                ",\n tempAssignedToDriverTwo='" + tempAssignedToDriverTwo + '\'' +
                "\n}";
    }
}
