package logic.pages.companyProfile.drivers.driverInfo;

import logic.BasePage;
import logic.pages.companyProfile.drivers.ProfilesTab;
import logic.report.LogToAllure;
import logic.dbConnection.entity.DriverProfile;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.*;

public class AddDriverProfilePage extends BasePage {
    @FindBy(css = "div[placeholder='HOS Provider']")
    protected WebElement hosProviderSelector;
    @FindBy(name = "firstName")
    protected WebElement firstNameField;
    @FindBy(name = "lastName")
    protected WebElement lastNameField;
    @FindBy(name = "email")
    protected WebElement emailField;
    @FindBy(name = "phone")
    protected WebElement phoneField;
    @FindBy(name = "loginName")
    protected WebElement loginNameField;
    @FindBy(name = "opentextPassword")
    protected WebElement passwordField;
    @FindBy(name = "confirmPassword")
    protected WebElement confirmPasswordField;
    @FindBy(css = "div[placeholder='Status...']")
    protected WebElement statusSelector;
    @FindBy(css = "div[placeholder='Select State']")
    protected WebElement licenseStateSelector;
    @FindBy(css = "div[placeholder='Select Timezone']")
    protected WebElement homeTerminalTimezoneSelector;
    @FindBy(css = "input[ng-model='vm.driver.forAudit']")
    protected WebElement forAuditCheckbox;
    @FindBy(css = "input[ng-model='vm.driver.ownerOperator']")
    protected WebElement ownerOperatorCheckbox;
    @FindBy(css = "div[placeholder='Select Truck Number...']")
    protected WebElement truckNumberSelector;
    @FindBy(css = "div[placeholder='Select Trailer Number...']")
    protected WebElement trailerNumberSelector;
    @FindBy(name = "licenseNumber")
    protected WebElement licenseNumberField;
    @FindBy(css = "div[ng-model='vm.driver.eldMultidayBasisUsedCan']")
    protected WebElement eldMultidayBasisUsedCanSelector;
    @FindBy(css = "div[ng-model='vm.driver.eldMultidayBasisUsed']")
    protected WebElement eldMultidayBasisUsedUsaSelector;
    @FindBy(css = "input[ng-model='vm.driver.eldEditMode']")
    protected WebElement eldEditModeField;
    @FindBy(name = "eldAppMode")
    protected WebElement eLogAppModeSelector;
    @FindBy(css = "input[ng-model='vm.driver.tripStartMinSpeed']")
    protected WebElement tripStartMinSpeedField;
    @FindBy(css = "input[ng-model='vm.driver.tripEndMaxSpeed']")
    protected WebElement tripStartMaxSpeedField;
    @FindBy(css = "input[ng-model='vm.driver.eldExempt']")
    protected WebElement eldExemptCheckbox;
    @FindBy(css = "input[ng-model='vm.driver.isDriverContractorWithPersonalAuthority']")
    protected WebElement isDriverContractorWithPersonalAuthorityCheckbox;
    @FindBy (name = "companyName")
    protected  WebElement companyNameField;
    @FindBy (name = "companyAddress")
    protected  WebElement companyAddressField;
    @FindBy (name = "yardAddress")
    protected  WebElement yardAddressField;
    @FindBy(css = "input[ng-model='vm.sameAsCompanyAddress']")
    protected WebElement sameAsCompanyAddressCheckbox;
    @FindBy (name = "contactInfo")
    protected  WebElement contactInfoField;
    @FindBy (name = "authorityNumbers")
    protected  WebElement authorityNumbersField;
    @FindBy(css = "input[ng-model='vm.driver.eldIsYardMoveAllowed']")
    protected WebElement eldIsYardMoveAllowedCheckbox;
    @FindBy(css = "input[ng-model='vm.driver.eldIsPersonalUseAllowed']")
    protected WebElement eldIsPersonalUseAllowedCheckbox;
    @FindBy(css = "input[ng-model='vm.driver.eldExemptComment']")
    protected WebElement eldExemptCommentField;
    @FindBy(css = "input[ng-model='vm.driver.regainHoursAtMidnight']")
    protected WebElement regainHoursAtMidnightCheckbox;
    @FindBy(css = "input[ng-model='vm.driver.displayTimeOnMobileGraph']")
    protected WebElement displayTimeOnMobileGraphCheckbox;
    @FindBy(css = "input[ng-model='vm.driver.disable15Days']")
    protected WebElement disable15DaysCheckbox;
    @FindBy(css = "input[ng-model='vm.driver.allowEditInformation']")
    protected WebElement allowEditInformationCheckbox;
    @FindBy(css = "input[ng-model='vm.driver.collectGPSWithoutTruck']")
    protected WebElement collectGPSWithoutTruckCheckbox;
    @FindBy(css = "input[ng-model='vm.driver.eldEventsAutoSync']")
    protected WebElement eldEventsAutoSyncCheckbox;
    @FindBy(css = "input[ng-model='vm.driver.showAlertOnNewMessage']")
    protected WebElement showAlertOnNewMessageCheckbox;
    @FindBy(css = "input[ng-model='vm.driver.enableVoiceMessage']")
    protected WebElement enableVoiceMessageCheckbox;
    @FindBy(css = "input[ng-model='vm.driver.soundNotificationOnNewMessage']")
    protected WebElement soundNotificationOnNewMessageCheckbox;
    @FindBy(css = "input[ng-model='vm.driver.allowDeleteEvents']")
    protected WebElement allowDeleteEventsCheckbox;
    @FindBy(css = "input[ng-model='vm.driver.allowInsertEvents']")
    protected WebElement allowInsertEventsCheckbox;
    @FindBy(css = "input[ng-model='vm.driver.allowEditEvents']")
    protected WebElement allowEditEventsCheckbox;
    @FindBy(css = "input[ng-model='vm.driver.allowDrivingEvents']")
    protected WebElement allowDrivingEventsCheckbox;
    @FindBy(css = "input[ng-model='vm.driver.onlyUsaDriving']")
    protected WebElement onlyUsaDrivingCheckbox;
    @FindBy(css = "input[ng-model='vm.allowAppVersionMsgIntervalMin']")
    protected WebElement remindDriverToUpdateAppCheckbox;
    @FindBy(css = "input[ng-model='vm.driver.appVersionMsgIntervalMin']")
    protected WebElement remindDriverToUpdateAppMinutesField;
    @FindBy(css = "div[ng-model='vm.driver.generateLocationDescription']")
    protected WebElement generateLocationDescriptionField;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    protected WebElement saveDriverBtn;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    protected WebElement cancelDriverBtn;
    @FindBy (xpath = "//div[@ng-bind-html]")
    private WebElement errorNotificationMsg;
    private int tries=0;
    private static final Logger log = Logger.getLogger(AddDriverProfilePage.class);

    private DriverProfile driverProfile = null;

    public AddDriverProfilePage() {
        super();
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        return false;
    }

    public void setDriverProfile(DriverProfile driverProfile) {
        this.driverProfile = driverProfile;
    }

    public AddDriverProfilePage(DriverProfile driverProfile) {
        super();
        this.driverProfile = driverProfile;
    }

    protected void selectItemInSelector(WebElement selector, String itemName, String fieldName) {
        if(itemName.equals("")){
            selector.click();
            driver.findElement(By.xpath("//form/div[1]/div[5]/div[2]/div/label")).click();
        } else
            super.selectItemInSelector(selector,itemName,fieldName,"div");
    }

    public void selectHosProvider(String hosProvider){
        selectItemInSelector(hosProviderSelector, hosProvider,"HOS Provider");
        if(!hosProviderSelector.getText().equals(hosProvider) & tries<15)
            selectHosProvider(hosProvider);
    }
    public void clickForAudit(boolean forAudit){
        clickCheckbox(forAuditCheckbox, forAudit, "For Audit");
    }

    public void inputFirstName(String firstName){
        inputTextInField(firstNameField, firstName,"First Name");
    }
    public void inputLastName(String lastName){
        inputTextInField(lastNameField, lastName,"Last Name");
    }
    public void inputEmail(String email){
        inputTextInField(emailField, email,"Email");
    }
    public void inputPhoneNumber(String phoneNumber){
        inputTextInField(phoneField, phoneNumber,"Phone Number");
    }
    public void selectStatus(String status){
        selectItemInSelector(statusSelector, status,"Status");
    }
    public void inputLoginName(String loginName){
        inputTextInField(loginNameField, loginName,"Login Name");
    }
    public void inputPassword(String password){
        inputTextInField(passwordField, password,"Password");
    }
    public void inputConfirmPassword(String password){
        inputTextInField(confirmPasswordField, password,"Confirm Password");
    }
    public void inputLicenseNumber(String licenseNumber){
        inputTextInField(licenseNumberField, licenseNumber,"License Number");
    }
    public void selectLicenseState(String licenseState){
        selectItemInSelector(licenseStateSelector, licenseState,"License State");
    }
    public void selectHomeTerminalTimezone(String homeTerminalTimezone){
        selectItemInSelector(homeTerminalTimezoneSelector, homeTerminalTimezone,"Home Terminal Timezone");
    }
    public void selectEldMultidayBasisUsedUsa(String eldMultidayBasisUsedUsa){
        selectItemInSelector(eldMultidayBasisUsedUsaSelector, eldMultidayBasisUsedUsa,"ELD Multiday Basis Used USA");
    }
    public void selectEldMultidayBasisUsedCan(String eldMultidayBasisUsedCan){
        selectItemInSelector(eldMultidayBasisUsedCanSelector, eldMultidayBasisUsedCan,"ELD Multiday Basis Used CA");
    }
    public void selectELogAppMode(String eLogAppMode){
        selectItemInSelector(eLogAppModeSelector, eLogAppMode,"eLog App Mode");
    }
    public void inputEldEditMode(String eldEditMode){
        inputTextInField(eldEditModeField, eldEditMode,"ELD Edit Mode");
    }
    public void inputTripStartMinSpeed(String tripStartMinSpeed){
        inputTextInField(tripStartMinSpeedField, tripStartMinSpeed,"Trip Start Min Speed");
    }
    public void inputTripStartMaxSpeed(String tripStartMaxSpeed){
        inputTextInField(tripStartMaxSpeedField, tripStartMaxSpeed,"Trip Start Max Speed");
    }
    public void clickEldExemptCheckbox(boolean eldExempt){
        if(eldExemptCheckbox.isSelected())
            eldExemptCommentField.clear();
        clickCheckbox(eldExemptCheckbox, eldExempt, "ELD Exempt");
    }
    public void inputEldExemptComment(String eldExemptComment){
        inputTextInField(eldExemptCommentField, eldExemptComment,"ELD Exempt Comment");
    }
    public void clickDriverContractorWithPersonalAuthority(boolean isDriverContractorWithPersonalAuthority){
        clickCheckbox(isDriverContractorWithPersonalAuthorityCheckbox, isDriverContractorWithPersonalAuthority, "Driver Contractor With Personal Authority");
    }
    public void inputCompanyName(String companyName){
        inputTextInField(companyNameField, companyName,"Company Name");
    }
    public void inputCompanyAddress(String companyAddress){
        inputTextInField(companyAddressField, companyAddress,"Company Address");
    }
    public void clickSameAsCompanyAddress(boolean sameAsCompanyAddress){
        clickCheckbox(sameAsCompanyAddressCheckbox, sameAsCompanyAddress, "Same As Company Address");
    }
    public void inputYardAddress(String yardAddress){
        inputTextInField(yardAddressField, yardAddress,"Yard Address");
    }
    public void inputContactInfo(String contactInfo){
        inputTextInField(contactInfoField, contactInfo,"Contact Info");
    }
    public void inputAuthorityNumbers(String authorityNumbers){
        inputTextInField(authorityNumbersField, authorityNumbers,"Authority Numbers");
    }
    public void clickEldIsYardMoveAllowed(boolean eldIsYardMoveAllowed){
        clickCheckbox(eldIsYardMoveAllowedCheckbox, eldIsYardMoveAllowed, "ELD Is YardM ove Allowed");
    }
    public void clickEldIsPersonalUseAllowed(boolean eldIsPersonalUseAllowed){
        clickCheckbox(eldIsPersonalUseAllowedCheckbox, eldIsPersonalUseAllowed, "ELD Is Personal Use Allowed");
    }
    public void clickRegainHoursAtMidnight(boolean regainHoursAtMidnight){
        clickCheckbox(regainHoursAtMidnightCheckbox, regainHoursAtMidnight, "Regain Hours At Midnight");
    }
    public void clickOwnerOperator(boolean ownerOperator){
        clickCheckbox(ownerOperatorCheckbox,ownerOperator,"Owner Operator");
    }
    public void selectTruckNumber(String truckNumber){
        selectItemInSelector(truckNumberSelector, truckNumber,"Truck Number");
    }
    public void selectTrailerNumber(String trailerNumber){
        selectItemInSelector(trailerNumberSelector, trailerNumber,"Trailer Number");
    }
    public void clickDisable15Days(boolean disable15Days){
        clickCheckbox(disable15DaysCheckbox, disable15Days, "Disable 15 Days");
    }
    public void selectGenerateLocationDescription(String generateLocationDescription){
        selectItemInSelector(generateLocationDescriptionField, generateLocationDescription,"Generate Location Description");
    }
    public void clickDisplayTimeOnMobileGraph(boolean displayTimeOnMobileGraph){
        clickCheckbox(displayTimeOnMobileGraphCheckbox, displayTimeOnMobileGraph, "Display Time On Mobile Graph");
    }
    public void clickAllowEditInformation(boolean allowEditInformation){
        clickCheckbox(allowEditInformationCheckbox, allowEditInformation, "Allow Edit Information");
    }
    public void clickCollectGPSWithoutTruck(boolean collectGPSWithoutTruck){
        clickCheckbox(collectGPSWithoutTruckCheckbox, collectGPSWithoutTruck, "Collect GPS Without Truck");
    }
    public void clickEldEventsAutoSync(boolean eldEventsAutoSync){
        clickCheckbox(eldEventsAutoSyncCheckbox, eldEventsAutoSync, "ELD Events Auto Sync");
    }
    public void clickShowAlertOnNewMessage(boolean showAlertOnNewMessage){
        clickCheckbox(showAlertOnNewMessageCheckbox, showAlertOnNewMessage, "Show Alert On New Message");
    }
    public void clickEnableVoiceMessage(boolean enableVoiceMessage){
        clickCheckbox(enableVoiceMessageCheckbox, enableVoiceMessage, "Enable Voice Message");
    }
    public void clickSoundNotificationOnNewMessage(boolean soundNotificationOnNewMessage){
        clickCheckbox(soundNotificationOnNewMessageCheckbox, soundNotificationOnNewMessage, "Sound Notification On New Message");
    }
    public void clickAllowDeleteEvents(boolean allowDeleteEvents){
        clickCheckbox(allowDeleteEventsCheckbox, allowDeleteEvents, "Allow Delete Events");
    }
    public void clickAllowInsertEvents(boolean allowInsertEvents){
        clickCheckbox(allowInsertEventsCheckbox, allowInsertEvents, "Allow Insert Events");
    }
    public void clickAllowEditEvents(boolean allowEditEvents){
        clickCheckbox(allowEditEventsCheckbox, allowEditEvents, "Allow Edit Events");
    }
    public void clickAllowDrivingEvents(boolean allowDrivingEvents){
        clickCheckbox(allowDrivingEventsCheckbox, allowDrivingEvents, "Allow Driving Events");
    }
    public void clickOnlyUsaDriving(boolean onlyUsaDriving){
        clickCheckbox(onlyUsaDrivingCheckbox, onlyUsaDriving, "Only USA Driving");
    }
    public void clickRemindDriverToUpdateApp(boolean remindDriverToUpdateApp){
        clickCheckbox(remindDriverToUpdateAppCheckbox, remindDriverToUpdateApp, "Remind Driver To Update App");
    }
    public void inputRemindDriverToUpdateAppMinutes(String remindDriverToUpdateAppMinutes){
        inputTextInField(remindDriverToUpdateAppMinutesField, remindDriverToUpdateAppMinutes,"Remind Driver To Update App Minutes");
    }
    public AddDriverProfilePage enterValuesInForms() {
        waitToVisibilityOf(15, hosProviderSelector);
        selectHosProvider(driverProfile.getHosProvider());
        clickForAudit(driverProfile.isForAudit());
        inputFirstName(driverProfile.getFirstName());
        inputLastName(driverProfile.getLastName());
        inputEmail(driverProfile.getEmail());
        inputPhoneNumber(driverProfile.getPhone());
        selectStatus(driverProfile.getStatus());
        inputLoginName(driverProfile.getLoginName());
        clickOwnerOperator(driverProfile.isOwnerOperator());
        if (driverProfile.isOwnerOperator()){
            selectTruckNumber(driverProfile.getTruckNumber());
            selectTrailerNumber(driverProfile.getTrailerNumber());
        }
        if (driverProfile.getHosProvider().equals("TrackEnsure eLog")){
            inputPassword(driverProfile.getPassword());
            inputConfirmPassword(driverProfile.getPassword());
            inputLicenseNumber(driverProfile.getDriverLicenseNumber());
            selectLicenseState(driverProfile.getLicenseState());
            selectHomeTerminalTimezone(driverProfile.getHomeTerminalTimezone());
            selectEldMultidayBasisUsedUsa(driverProfile.getUsaMultidayBasis());
            selectEldMultidayBasisUsedCan(driverProfile.getCanadianMultidayBasis());
            selectELogAppMode(driverProfile.geteLogAppMode());
            inputTripStartMinSpeed(driverProfile.getTripStatMinSpeed());
            inputTripStartMaxSpeed(driverProfile.getTripEndMaxSpeed());
            clickEldExemptCheckbox(driverProfile.isEldExempt());
            if(driverProfile.isEldExempt())
                inputEldExemptComment(driverProfile.getEldExemptComment());
            clickDriverContractorWithPersonalAuthority(driverProfile.isDriverContractorWithPersonalAuthority());
            if(driverProfile.isDriverContractorWithPersonalAuthority()){
                inputCompanyName(driverProfile.getCompanyName());
                inputCompanyAddress(driverProfile.getCompanyAddress());
                clickSameAsCompanyAddress(driverProfile.isSameAsCompanyAddress());
                if (!driverProfile.isSameAsCompanyAddress())
                    inputYardAddress(driverProfile.getYardAddress());
                inputContactInfo(driverProfile.getContactInfo());
                inputAuthorityNumbers(driverProfile.getAuthorityNumbers());
            }
            if(driverProfile.geteLogAppMode().equals("ELD")) {
                clickEldIsYardMoveAllowed(driverProfile.isYardMoveAllowed());
                clickEldIsPersonalUseAllowed(driverProfile.isPersonalUseAllowed());
            } else {
                driverProfile.setYardMoveAllowed(false);
                driverProfile.setPersonalUseAllowed(false);
            }
            clickRegainHoursAtMidnight(driverProfile.isRegainHoursAtMidnight());
            clickDisable15Days(driverProfile.isDisable15Days());
            selectGenerateLocationDescription(driverProfile.getGenerateLocationDescription());
            clickDisplayTimeOnMobileGraph(driverProfile.isDisplayTimeOnMobileGraph());
            clickAllowEditInformation(driverProfile.isAllowEditInformation());
            clickCollectGPSWithoutTruck(driverProfile.isCollectGpsWhileNotConnectedToTruck());
            clickEldEventsAutoSync(driverProfile.isAutoSyncEvents());
            clickShowAlertOnNewMessage(driverProfile.isShowAlertOnNewMessage());
            clickEnableVoiceMessage(driverProfile.isEnableVoiceMessage());
            clickSoundNotificationOnNewMessage(driverProfile.isSoundNotificationOnNewMessage());
            clickAllowDeleteEvents(driverProfile.isAllowDeleteEventsInEldApp());
            clickAllowInsertEvents(driverProfile.isAllowInsertEventsInEldApp());
            clickAllowEditEvents(driverProfile.isAllowEditEventsInEldApp());
            clickAllowDrivingEvents(driverProfile.isAllowDrivingEventsInEldApp());
            //clickOnlyUsaDriving(driverProfile.isOnlyDrivesInUsa());
            clickRemindDriverToUpdateApp(driverProfile.isRemindDriverToUpdateApp());
            if (driverProfile.isRemindDriverToUpdateApp())
                inputRemindDriverToUpdateAppMinutes(driverProfile.getRemindDriverToUpdateAppMinutes());
        }
        return this;
    }


    public AddDriverProfilePage checkErrorMessage(){
        waitToVisibilityOf(10, errorNotificationMsg);
        assertTrue(errorNotificationMsg.isDisplayed(), "Error Notification message");
        driver.findElement(By.xpath("//button[@data-dismiss]")).click();
        return this;
    }

    public ProfilesTab saveDriverProfile() {
        waitToBeClickable(20, saveDriverBtn);
        saveDriverBtn.click();
        log.info("Click on Save Driver Button");
        LogToAllure.logToAllure("Clock on Save Driver Button");
        //closeNotificationWindow();
        return new ProfilesTab();
    }
}
