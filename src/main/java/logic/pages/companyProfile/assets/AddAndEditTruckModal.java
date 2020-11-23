package logic.pages.companyProfile.assets;

import logic.report.LogToAllure;
import logic.report.PdfReport;
import logic.dbConnection.entity.TruckProfile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.*;

import java.util.List;

public class AddAndEditTruckModal extends TrucksTab {

    @FindBy(css = "input[ng-model='vm.isTrackEnsureELD']")
    private WebElement isTrackEnsureEldCheckBox;
    @FindBy(css = "input[placeholder='Number']")
    private WebElement truckNumberField;
    @FindBy(css = "input[placeholder='License Plate']")
    private WebElement licensePlateField;
    @FindBy(css = "select[ng-model='vm.truckProfile.licenseStateProvince']")
    private WebElement licenseStateSelect;
    @FindBy(css = "input[ng-model='vm.truckProfile.vin']")
    private WebElement vinNumberField;
    @FindBy(css = "input[placeholder='Make']")
    private WebElement makeField;
    @FindBy(css = "input[placeholder='Model']")
    private WebElement modelField;
    @FindBy(css = "input[placeholder='Year']")
    private WebElement yearField;
    @FindBy(css = "input[placeholder='Tare']")
    private WebElement tareField;
    @FindBys({
            @FindBy(css = "label[ng-model='vm.truckProfile.fifthWheel']")
    })
    private List<WebElement> fifthWheelBtns;
    @FindBy(css = "div[placeholder='Select Provider']")
    private WebElement gpsProviderSelect;
    @FindBy(css = "input[ng-model='vm.truckProfile.gpsUnitId']")
    private WebElement gpsUnitIdSelect;
    @FindBy(id = "minStopDelta")
    private WebElement minStopDeltaDistanceMetersField;
    @FindBy(id = "maxSpeed")
    private WebElement maxSpeedForStartField;
    @FindBy(css = "input[placeholder='Duration (m)']")
    private WebElement minStopDurationField;
    @FindBy(css = "div[placeholder='Select']")
    private WebElement eldSerialSelect;
    @FindBy(css = "input[placeholder='XXXX']")
    private WebElement eldSerialField;
    @FindBy(css = "oi-select[placeholder='Select Fuel Type']")
    private WebElement fuelTypeSelect;
    @FindBy(css = "div[placeholder='Status']")
    private WebElement statusSelect;
    @FindBy(css = "input[ng-model='vm.truckProfile.personalUseAllow']")
    private WebElement personalUseLimitCheckBox;
    @FindBy(css = "input[ng-model='vm.truckProfile.personalUseLimit']")
    private WebElement personalUseLimitField;
    @FindBy(css = "input[ng-model='vm.truckProfile.yardMoveAllow']")
    private WebElement yardMoveLimitCheckBox;
    @FindBy(css = "input[ng-model='vm.truckProfile.yardMoveLimit']")
    private WebElement yardMoveLimitField;
    @FindBy(css = "div[ng-model='vm.assignToDriver']")
    private WebElement assignedDriverOneSelect;
    @FindBy(css = "div[ng-model='vm.tempAssignedDriver']")
    private WebElement tempAssignedDriverOneSelect;
    @FindBy(css = "div[ng-model='vm.assignToDriver2']")
    private WebElement assignedDriverTwoSelect;
    @FindBy(css = "div[ng-model='vm.tempAssignedDriver2']")
    private WebElement tempAssignedDriverTwoSelect;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    protected WebElement saveTruckBtn;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    protected WebElement cancelTruckBtn;
    @FindBy(xpath = "//div[@ng-bind-html]")
    private WebElement errorNotificationMsg;

    public TruckProfile truckProfile;
    public TruckProfile truckProfileAfterSave;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(truckNumberField, "Truck Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(licensePlateField, "License Plate field")) errorsCount++;
        if (!isElementDisplayedOnPage(vinNumberField, "VIN Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(makeField, "Make field")) errorsCount++;
        if (!isElementDisplayedOnPage(modelField, "Model field")) errorsCount++;
        if (!isElementDisplayedOnPage(yearField, "Year field")) errorsCount++;
        if (!isElementDisplayedOnPage(tareField, "Tare field")) errorsCount++;
        if (!isElementDisplayedOnPage(gpsProviderSelect, "GPS Provider field")) errorsCount++;
        if (!isElementDisplayedOnPage(gpsUnitIdSelect, "GPS Unit ID field")) errorsCount++;
        if (!isElementDisplayedOnPage(minStopDeltaDistanceMetersField, "Min Stop Delta Distance Meters field")) errorsCount++;
        if (!isElementDisplayedOnPage(maxSpeedForStartField, "Max Speed For Start field")) errorsCount++;
        if (!isElementDisplayedOnPage(minStopDurationField, "Min Stop Duration field")) errorsCount++;
        if (!isElementDisplayedOnPage(eldSerialSelect, "ELD Serial field")) errorsCount++;
        if (!isElementDisplayedOnPage(fuelTypeSelect, "Fuel Type field")) errorsCount++;
        if (!isElementDisplayedOnPage(statusSelect, "Status field")) errorsCount++;
        if (!isElementDisplayedOnPage(personalUseLimitField, "Personal Use Limit field")) errorsCount++;
        if (!isElementDisplayedOnPage(personalUseLimitCheckBox, "Personal Use Limit checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(yardMoveLimitField, "Yard Move Limit field")) errorsCount++;
        if (!isElementDisplayedOnPage(yardMoveLimitCheckBox, "Yard Move Limit checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(assignedDriverOneSelect, "Assigned To Driver 1 field")) errorsCount++;
        if (!isElementDisplayedOnPage(assignedDriverTwoSelect, "Assigned To Driver 2 field")) errorsCount++;
        if (!isElementDisplayedOnPage(tempAssignedDriverOneSelect, "Temp Assigned To Driver 1 field")) errorsCount++;
        if (!isElementDisplayedOnPage(tempAssignedDriverTwoSelect, "Temp Assigned To Driver 2 field")) errorsCount++;
        if (!isElementDisplayedOnPage(isTrackEnsureEldCheckBox, "TrackEnsure eLog checkbox")) errorsCount++;
        clickOnElement(cancelTruckBtn);
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }

    public void setTruckProfile(TruckProfile truckProfile) {
        this.truckProfile = truckProfile;
    }

    public AddAndEditTruckModal(TruckProfile truckProfile) {
        super();
        this.truckProfile = truckProfile;
    }

    public AddAndEditTruckModal() {
        super();
    }

    public AddAndEditTruckModal clickTrackEnsureEldCheckBox(boolean isTrackEnsureEld) {
        clickCheckbox(isTrackEnsureEldCheckBox, isTrackEnsureEld, "TrackEnsure ELD");
        return this;
    }

    public AddAndEditTruckModal inputTruckNumber(String truckNumber) {
        inputTextInField(truckNumberField, truckNumber, "Truck Number");
        return this;
    }

    public AddAndEditTruckModal inputLicensePlate(String licensePlate) {
        inputTextInField(licensePlateField, licensePlate, "License Plate");
        return this;
    }

    public AddAndEditTruckModal selectLicenseState(String licenseState) {
        Select select = new Select(licenseStateSelect);
        select.selectByVisibleText(licenseState);
        return this;
    }

    public AddAndEditTruckModal inputVinNumber(String vinNumber) {
        inputTextInField(vinNumberField, vinNumber, "VIN Number");
        return this;
    }

    public AddAndEditTruckModal inputMake(String make) {
        inputTextInField(makeField, make, "Make");
        return this;
    }

    public AddAndEditTruckModal inputModel(String model) {
        inputTextInField(modelField, model, "Model");
        return this;
    }

    public AddAndEditTruckModal inputYear(String year) {
        inputTextInField(yearField, year, "Year");
        return this;
    }

    public AddAndEditTruckModal inputTare(String tare) {
        inputTextInField(tareField, tare, "Tare");
        return this;
    }

    public AddAndEditTruckModal selectFifthWheel(boolean isFifthWheel) {
        if (isFifthWheel) {
            // yesFifthWheel.click();
            fifthWheelBtns.get(0).click();
        } else
            fifthWheelBtns.get(1).click();
        //noFifthWheel.click();
        return this;
    }

    public AddAndEditTruckModal selectGpsProvider(String gpsProvider) {
        selectItemInSelector(gpsProviderSelect, gpsProvider, "GPS Provider", "div");
        return this;
    }

    /* public AddAndEditTruckPage selectGpsUnit(String gpsUnit){
         selectItemInSelector(gpsUnitIdSelect,gpsUnit,"GPS Unit Id");
         return this;
     }
 */
    public AddAndEditTruckModal inputMinStopDeltaDistanceMeters(String minStopDelta) {
        inputTextInField(minStopDeltaDistanceMetersField, minStopDelta, "Min Stop Delta Distance Meters Field");
        return this;
    }

    public AddAndEditTruckModal inputMaxSpeedForStart(String maxSpeedForStart) {
        inputTextInField(maxSpeedForStartField, maxSpeedForStart, "Max Speed For Start");
        return this;
    }

    public AddAndEditTruckModal inputMinStopDuration(String minStopDuration) {
        inputTextInField(minStopDurationField, minStopDuration, "Min Stop Duration");
        return this;
    }

    public AddAndEditTruckModal selectEldSerial(String eldSerial, String eldSerialNum) {
        selectItemInSelector(eldSerialSelect, eldSerial, "ELD Serial", "div");
        inputTextInField(eldSerialField, eldSerialNum, "ELD Serial");
        return this;
    }

    public AddAndEditTruckModal selectFuelType(String fuelType) {
        selectItemInSelector(fuelTypeSelect, fuelType, "Fuel Type", "li");
        return this;
    }

    public AddAndEditTruckModal selectStatus(String status) {
        selectItemInSelector(statusSelect, status, "Status", "div");
        return this;
    }

    public AddAndEditTruckModal inputPersonalUseLimit(boolean personalUseLimitStatus, String personalUseLimit) {
        clickCheckbox(personalUseLimitCheckBox, personalUseLimitStatus, "Personal Use Limit");
        if (personalUseLimitStatus)
            inputTextInField(personalUseLimitField, personalUseLimit, "Personal Use Limit");
        return this;
    }

    public AddAndEditTruckModal inputYardMoveLimit(boolean yardMoveLimitStatus, String yardMoveLimit) {
        clickCheckbox(yardMoveLimitCheckBox, yardMoveLimitStatus, "Yard Move Limit");
        if (yardMoveLimitStatus)
            inputTextInField(yardMoveLimitField, yardMoveLimit, "Yard Move Limit");
        return this;
    }

    public AddAndEditTruckModal inputValuesInForms() {
        clickTrackEnsureEldCheckBox(truckProfile.isTrackEnsureElog());
        selectStatus(truckProfile.getStatus());
        inputTruckNumber(truckProfile.getTruckNumber());
        inputLicensePlate(truckProfile.getLicensePlate());
        selectLicenseState(truckProfile.getLicenseState());
        inputVinNumber(truckProfile.getVinNumber());
        inputMake(truckProfile.getMake());
        inputModel(truckProfile.getModel());
        inputYear(truckProfile.getYear());
        inputTare(truckProfile.getTare());
        selectFifthWheel(truckProfile.isFifthWheel());
        selectGpsProvider(truckProfile.getGpsProvider());
        inputMinStopDeltaDistanceMeters(truckProfile.getMinStopDeltaDistanceMeters());
        inputMaxSpeedForStart(truckProfile.getMaxSpeedForStart());
        inputMinStopDuration(truckProfile.getMinStopDuration());
        selectEldSerial(truckProfile.getEldSerial(), truckProfile.getEldSerialNum());
        selectFuelType(truckProfile.getFuelType());
        inputPersonalUseLimit(truckProfile.isPersonalUseLimitStatus(), truckProfile.getPersonalUseLimitValue());
        inputYardMoveLimit(truckProfile.isYardMoveLimitStatus(), truckProfile.getYardMoveLimitValue());
        return this;
    }

    public AddAndEditTruckModal parseTruckProfile() {
        waitToVisibilityOf(20, truckNumberField);
        truckProfileAfterSave = new TruckProfile();
        truckProfileAfterSave.setTrackEnsureElog(isTrackEnsureEldCheckBox.isSelected());
        truckProfileAfterSave.setTruckNumber(truckNumberField.getAttribute("value"));
        truckProfileAfterSave.setLicensePlate(licensePlateField.getAttribute("value"));
        truckProfileAfterSave.setLicenseState(new Select(licenseStateSelect).getFirstSelectedOption().getText());
        truckProfileAfterSave.setVinNumber(vinNumberField.getAttribute("value"));
        truckProfileAfterSave.setMake(makeField.getAttribute("value"));
        truckProfileAfterSave.setModel(modelField.getAttribute("value"));
        truckProfileAfterSave.setYear(yearField.getAttribute("value"));
        truckProfileAfterSave.setTare(tareField.getAttribute("value"));
        truckProfileAfterSave.setFifthWheel(getFifthWheelsStatus());
        truckProfileAfterSave.setGpsProvider(gpsProviderSelect.getText());
        if (!truckProfileAfterSave.getGpsProvider().equals("None")) {
            if (gpsUnitIdSelect.getText().equals("Select GPS Unit"))
                truckProfileAfterSave.setGpsUnitId("");
            else
                truckProfileAfterSave.setGpsUnitId(gpsUnitIdSelect.getAttribute("value"));
        } else
            truckProfileAfterSave.setGpsUnitId("");
        truckProfileAfterSave.setMinStopDeltaDistanceMeters(minStopDeltaDistanceMetersField.getAttribute("value"));
        truckProfileAfterSave.setMaxSpeedForStart(maxSpeedForStartField.getAttribute("value"));
        truckProfileAfterSave.setMinStopDuration(minStopDurationField.getAttribute("value"));
        truckProfileAfterSave.setEldSerial(eldSerialSelect.getText());
        truckProfileAfterSave.setEldSerialNum(eldSerialField.getAttribute("value"));
        truckProfileAfterSave.setFuelType(fuelTypeSelect.getText());
        truckProfileAfterSave.setStatus(statusSelect.getText());
        truckProfileAfterSave.setPersonalUseLimitStatus(personalUseLimitCheckBox.isSelected());
        if (truckProfileAfterSave.isPersonalUseLimitStatus())
            truckProfileAfterSave.setPersonalUseLimitValue(personalUseLimitField.getAttribute("value"));
        else
            truckProfileAfterSave.setPersonalUseLimitValue("");
        truckProfileAfterSave.setYardMoveLimitStatus(yardMoveLimitCheckBox.isSelected());
        if (truckProfileAfterSave.isYardMoveLimitStatus())
            truckProfileAfterSave.setYardMoveLimitValue(yardMoveLimitField.getAttribute("value"));
        else
            truckProfileAfterSave.setYardMoveLimitValue("");
        String assignedFieldPlaceholder = "Type to search driver and click Enter";
        if (assignedDriverOneSelect.getText().contains(assignedFieldPlaceholder))
            truckProfileAfterSave.setAssignedToDriverOne("");
        else
            truckProfileAfterSave.setAssignedToDriverOne(assignedDriverOneSelect.getText());
        if (tempAssignedDriverOneSelect.getText().contains(assignedFieldPlaceholder))
            truckProfileAfterSave.setTempAssignedToDriverOne("");
        else
            truckProfileAfterSave.setTempAssignedToDriverOne(tempAssignedDriverOneSelect.getText());
        if (assignedDriverTwoSelect.getText().contains(assignedFieldPlaceholder))
            truckProfileAfterSave.setAssignedToDriverTwo("");
        else
            truckProfileAfterSave.setAssignedToDriverTwo(assignedDriverTwoSelect.getText());
        if (tempAssignedDriverTwoSelect.getText().contains(assignedFieldPlaceholder))
            truckProfileAfterSave.setTempAssignedToDriverTwo("");
        else
            truckProfileAfterSave.setTempAssignedToDriverTwo(tempAssignedDriverTwoSelect.getText());
        log.info("Parsed Truck Profile info: " + truckProfileAfterSave.toString());
        return this;
    }

    public AddAndEditTruckModal checkTruckProfileValues() {
        //assertEquals(truckProfileAfterSave.isTrackEnsureElog(),truckProfile.isTrackEnsureElog(),"isTrackEnsureElog");
        assertEquals(truckProfileAfterSave.getTruckNumber(), truckProfile.getTruckNumber(), "getTruckNumber");
        assertEquals(truckProfileAfterSave.getLicensePlate(), truckProfile.getLicensePlate(), "getLicensePlate");
        assertEquals(truckProfileAfterSave.getLicenseState(), truckProfile.getLicenseState(), "getLicenseState");
        assertEquals(truckProfileAfterSave.getVinNumber(), truckProfile.getVinNumber(), "getVinNumber");
        assertEquals(truckProfileAfterSave.getMake(), truckProfile.getMake(), "getMake");
        assertEquals(truckProfileAfterSave.getModel(), truckProfile.getModel(), "getModel");
        assertEquals(truckProfileAfterSave.getYear(), truckProfile.getYear(), "getYear");
        assertEquals(truckProfileAfterSave.getTare(), truckProfile.getTare(), "getTare");
        assertEquals(truckProfileAfterSave.isFifthWheel(), truckProfile.isFifthWheel(), "isFifthWheel");
        assertEquals(truckProfileAfterSave.getGpsProvider(), truckProfile.getGpsProvider(), "getGpsProvider");
        assertEquals(truckProfileAfterSave.getGpsUnitId(), truckProfile.getGpsUnitId(), "getMinStopDeltaDistanceMeters");
        assertEquals(truckProfileAfterSave.getMinStopDeltaDistanceMeters(), truckProfile.getMinStopDeltaDistanceMeters(), "getMinStopDeltaDistanceMeters");
        assertEquals(truckProfileAfterSave.getMaxSpeedForStart(), truckProfile.getMaxSpeedForStart(), "getMaxSpeedForStart");
        assertEquals(truckProfileAfterSave.getMinStopDuration(), truckProfile.getMinStopDuration(), "getMinStopDuration");
        assertEquals(truckProfileAfterSave.getEldSerial(), truckProfile.getEldSerial(), "getEldSerial");
        assertEquals(truckProfileAfterSave.getOdometerOffset(), truckProfile.getOdometerOffset(), "getOdometerOffset");
        assertEquals(truckProfileAfterSave.getEldSerialNum(), truckProfile.getEldSerialNum(), "getEldSerialNum");
        assertEquals(truckProfileAfterSave.getFuelType(), truckProfile.getFuelType(), "getFuelType");
        assertEquals(truckProfileAfterSave.getStatus(), truckProfile.getStatus(), "getStatus");
        assertEquals(truckProfileAfterSave.isPersonalUseLimitStatus(), truckProfile.isPersonalUseLimitStatus(), "isPersonalUseLimitStatus");
        if (truckProfileAfterSave.isPersonalUseLimitStatus())
            assertEquals(truckProfileAfterSave.getPersonalUseLimitValue(), truckProfile.getPersonalUseLimitValue(), "getPersonalUseLimitValue");
        assertEquals(truckProfileAfterSave.isYardMoveLimitStatus(), truckProfile.isYardMoveLimitStatus(), "isYardMoveLimitStatus");
        if (truckProfileAfterSave.isYardMoveLimitStatus())
            assertEquals(truckProfileAfterSave.getYardMoveLimitValue(), truckProfile.getYardMoveLimitValue(), "getYardMoveLimitValue");
        assertEquals(truckProfileAfterSave.getAssignedToDriverOne(), truckProfile.getAssignedToDriverOne(), "getAssignedToDriverOne");
        assertEquals(truckProfileAfterSave.getTempAssignedToDriverOne(), truckProfile.getTempAssignedToDriverOne(), "getTempAssignedToDriverOne");
        assertEquals(truckProfileAfterSave.getAssignedToDriverTwo(), truckProfile.getAssignedToDriverTwo(), "getAssignedToDriverTwo");
        assertEquals(truckProfileAfterSave.getTempAssignedToDriverTwo(), truckProfile.getTempAssignedToDriverTwo(), "getTempAssignedToDriverTwo");
        return this;
    }

    public boolean getFifthWheelsStatus() {
        if (fifthWheelBtns.get(0).getAttribute("class").contains("active"))
            return true;
        else
            return false;
    }

    public TrucksTab clickOnSaveTruck() {
        waitToVisibilityOf(10, saveTruckBtn);
        saveTruckBtn.click();
        log.info("Click on Save Button");
        LogToAllure.logToAllure("Clock on Save Button", "");
        closeNotificationWindow();
        return new TrucksTab();
    }
}
