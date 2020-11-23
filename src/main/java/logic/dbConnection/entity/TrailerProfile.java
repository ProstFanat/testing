package logic.dbConnection.entity;

public class TrailerProfile {
    private String trailerNumber = "";
    private String licensePlate = "";
    private String licenseState = "";
    private String vinNumber = "";
    private String make = "";
    private String year = "";
    private String trailerType = "";
    private String trailerLength = "";
    private String gpsProvider = "";
    private String gpsUnitId = "";
    private String status = "";

    public TrailerProfile() {
    }

    public TrailerProfile(String trailerNumber, String licensePlate, String licenseState,
                          String vinNumber, String make, String year, String trailerType,
                          String trailerLength, String gpsProvider, String gpsUnitId, String status) {
        this.trailerNumber = trailerNumber;
        this.licensePlate = licensePlate;
        this.licenseState = licenseState;
        this.vinNumber = vinNumber;
        this.make = make;
        this.year = year;
        this.trailerType = trailerType;
        this.trailerLength = trailerLength;
        this.gpsProvider = gpsProvider;
        this.gpsUnitId = gpsUnitId;
        this.status = status;
    }

    public String getTrailerNumber() {
        return trailerNumber;
    }

    public void setTrailerNumber(String trailerNumber) {
        this.trailerNumber = trailerNumber;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTrailerType() {
        return trailerType;
    }

    public void setTrailerType(String trailerType) {
        this.trailerType = trailerType;
    }

    public String getTrailerLength() {
        return trailerLength;
    }

    public void setTrailerLength(String trailerLength) {
        this.trailerLength = trailerLength;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return "\nTrailerProfile{" +
                "\ntrailerNumber='" + trailerNumber + '\'' +
                ", \nlicensePlate='" + licensePlate + '\'' +
                ", \nlicenseState='" + licenseState + '\'' +
                ", \nvinNumber='" + vinNumber + '\'' +
                ", \nmake='" + make + '\'' +
                ", \nyear='" + year + '\'' +
                ", \ntrailerType='" + trailerType + '\'' +
                ", \ntrailerLength='" + trailerLength + '\'' +
                ", \ngpsProvider='" + gpsProvider + '\'' +
                ", \ngpsUnitId='" + gpsUnitId + '\'' +
                ", \nstatus='" + status + '\'' +
                "\n}";
    }
}
