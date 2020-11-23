package logic.pages.companyProfile.assets;

import logic.report.LogToAllure;
import logic.report.PdfReport;
import logic.dbConnection.entity.TrailerProfile;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.*;

public class AddAndEditTrailerModal extends TrailersTab {
    @FindBy(css = "input[placeholder='Trailer #']")
    private WebElement trailerNumberField;
    @FindBy(css = "input[placeholder='License Plate']")
    private WebElement licensePlateField;
    @FindBy(css = "select[ng-model='vm.trailerProfile.licenseStateProvince']")
    private WebElement licenseStateSelect;
    @FindBy(css = "input[placeholder='Vin']")
    private WebElement vinField;
    @FindBy(css = "input[placeholder='Make']")
    private WebElement makeField;
    @FindBy(css = "input[placeholder='Year']")
    private WebElement yearField;
    @FindBy(css = "div[ng-model='vm.trailerProfile.trailerType']")
    private WebElement trailerTypeSelect;
    @FindBy(css = "input[ng-model='vm.trailerProfile.trailerLength']")
    private WebElement trailerLengthField;
    @FindBy(css = "div[ng-model='vm.selectedGpsProvider']")
    private WebElement gpsProviderSelect;
    @FindBy(css = "input[ng-model='vm.trailerProfile.gpsUnitId']")
    private WebElement gpsUnitIdSelect;
    @FindBy(css = "div[ng-model='vm.trailerProfile.status']")
    private WebElement statusSelect;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    protected WebElement saveTrailerBtn;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    protected WebElement cancelTrailerBtn;
    @FindBy(xpath = "//div[@ng-bind-html]")
    private WebElement errorNotificationMsg;

    public TrailerProfile trailerProfile;
    public TrailerProfile trailerProfileAfterSave;

    public AddAndEditTrailerModal() {
        super();
    }

    public AddAndEditTrailerModal(TrailerProfile trailerProfile) {
        super();
        this.trailerProfile = trailerProfile;
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(trailerNumberField, "Trailer Number field in Add Trailer modal")) errorsCount++;
        if (!isElementDisplayedOnPage(licensePlateField, "License Plate field in Add Trailer modal")) errorsCount++;
        if (!isElementDisplayedOnPage(licenseStateSelect, "License State field in Add Trailer modal")) errorsCount++;
        if (!isElementDisplayedOnPage(vinField, "VIN field in Add Trailer modal")) errorsCount++;
        if (!isElementDisplayedOnPage(makeField, "Make field in Add Trailer modal")) errorsCount++;
        if (!isElementDisplayedOnPage(yearField, "Year field in Add Trailer modal")) errorsCount++;
        if (!isElementDisplayedOnPage(trailerTypeSelect, "Trailer Type field in Add Trailer modal")) errorsCount++;
        if (!isElementDisplayedOnPage(trailerLengthField, "Trailer Length field in Add Trailer modal")) errorsCount++;
        if (!isElementDisplayedOnPage(gpsProviderSelect, "GPS Provider field in Add Trailer modal")) errorsCount++;
        if (!isElementDisplayedOnPage(gpsUnitIdSelect, "GPS Unit field in Add Trailer modal")) errorsCount++;
        if (!isElementDisplayedOnPage(statusSelect, "Status field in Add Trailer modal")) errorsCount++;
        clickOnElement(cancelTrailerBtn);
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }

    public void setTrailerProfile(TrailerProfile trailerProfile) {
        this.trailerProfile = trailerProfile;
    }

    public AddAndEditTrailerModal inputTrailerNumber(String trailerNumber) {
        inputTextInField(trailerNumberField, trailerNumber, "Trailer Number");
        return this;
    }

    public AddAndEditTrailerModal inputLicensePlate(String licensePlate) {
        inputTextInField(licensePlateField, licensePlate, "License Plate");
        return this;
    }

    public AddAndEditTrailerModal selectLicenseState(String licenseState) {
        new Select(licenseStateSelect).selectByVisibleText(licenseState);
        log.info("Select License State: " + licenseState);
        return this;
    }

    public AddAndEditTrailerModal inputVinNumber(String vinNumber) {
        inputTextInField(vinField, vinNumber, "VIN Number");
        return this;
    }

    public AddAndEditTrailerModal inputMake(String make) {
        inputTextInField(makeField, make, "Make");
        return this;
    }

    public AddAndEditTrailerModal inputYear(String year) {
        inputTextInField(yearField, year, "Year");
        return this;
    }

    public AddAndEditTrailerModal selectTrailerType(String trailerType) {
        selectItemInSelector(trailerTypeSelect, trailerType, "Trailer Type", "div");
        return this;
    }

    public AddAndEditTrailerModal inputTrailerLength(String trailerLength) {
        inputTextInField(trailerLengthField, trailerLength, "Trailer Length");
        return this;
    }

    public AddAndEditTrailerModal selectGpsProvider(String gpsProvider) {
        selectItemInSelector(gpsProviderSelect, gpsProvider, "GPS Provider", "div");
        return this;
    }

    public AddAndEditTrailerModal selectStatus(String status) {
        selectItemInSelector(statusSelect, status, "Status", "div");
        return this;
    }

    public AddAndEditTrailerModal inputValuesInForms() {
        inputTrailerNumber(trailerProfile.getTrailerNumber());
        inputLicensePlate(trailerProfile.getLicensePlate());
        selectLicenseState(trailerProfile.getLicenseState());
        inputVinNumber(trailerProfile.getVinNumber());
        inputMake(trailerProfile.getMake());
        inputYear(trailerProfile.getYear());
        selectTrailerType(trailerProfile.getTrailerType());
        inputTrailerLength(trailerProfile.getTrailerLength());
        selectGpsProvider(trailerProfile.getGpsProvider());
        selectStatus((trailerProfile.getStatus()));
        return this;
    }

    public AddAndEditTrailerModal parseTrailerProfile() {
        this.trailerProfileAfterSave = new TrailerProfile();
        try {
            this.trailerProfileAfterSave.setTrailerNumber(trailerNumberField.getAttribute("value"));
            this.trailerProfileAfterSave.setLicensePlate(licensePlateField.getAttribute("value"));
            Select licenseState = new Select(licenseStateSelect);
            this.trailerProfileAfterSave.setLicenseState(licenseState.getFirstSelectedOption().getText());
            if (trailerProfileAfterSave.getLicenseState().equals("")) {
                licenseState = new Select(licenseStateSelect);
                this.trailerProfileAfterSave.setLicenseState(licenseState.getFirstSelectedOption().getText());
            }
            this.trailerProfileAfterSave.setVinNumber(vinField.getAttribute("value"));
            this.trailerProfileAfterSave.setMake(makeField.getAttribute("value"));
            this.trailerProfileAfterSave.setYear(yearField.getAttribute("value"));
            this.trailerProfileAfterSave.setTrailerType(trailerTypeSelect.getText());
            this.trailerProfileAfterSave.setTrailerLength(trailerLengthField.getAttribute("value"));
            this.trailerProfileAfterSave.setGpsProvider(gpsProviderSelect.getText());
            this.trailerProfileAfterSave.setStatus(statusSelect.getText());
        } catch (StaleElementReferenceException e) {
            return parseTrailerProfile();
        }
        log.info("Parsed Trailer Profile info: " + trailerProfileAfterSave.toString());
        LogToAllure.logToAllure("Parsed Trailer Profile info", trailerProfileAfterSave.toString());
        return this;
    }

    public AddAndEditTrailerModal checkTrailerProfile() {
        assertEquals(trailerProfileAfterSave.getTrailerNumber(), trailerProfile.getTrailerNumber(), "getTrailerNumber");
        assertEquals(trailerProfileAfterSave.getLicensePlate(), trailerProfile.getLicensePlate(), "getLicensePlate");
        assertEquals(trailerProfileAfterSave.getLicenseState(), trailerProfile.getLicenseState(), "getLicenseState");
        assertEquals(trailerProfileAfterSave.getVinNumber(), trailerProfile.getVinNumber(), "getVinNumber");
        assertEquals(trailerProfileAfterSave.getMake(), trailerProfile.getMake(), "getMake");
        assertEquals(trailerProfileAfterSave.getYear(), trailerProfile.getYear(), "getYear");
        assertEquals(trailerProfileAfterSave.getTrailerType(), trailerProfile.getTrailerType(), "getTrailerType");
        assertEquals(trailerProfileAfterSave.getTrailerLength(), trailerProfile.getTrailerLength(), "getTrailerLength");
        assertEquals(trailerProfileAfterSave.getGpsProvider(), trailerProfile.getGpsProvider(), "getGpsProvider");
        assertEquals(trailerProfileAfterSave.getStatus(), trailerProfile.getStatus(), "getStatus");
        return this;
    }

    public TrailersTab clickOnSaveTrailer() {
        waitToVisibilityOf(10, saveTrailerBtn);
        saveTrailerBtn.click();
        log.info("Click on Save Button");
        LogToAllure.logToAllure("Clock on Save Button", "");
        closeNotificationWindow();
        return new TrailersTab();
    }

}
