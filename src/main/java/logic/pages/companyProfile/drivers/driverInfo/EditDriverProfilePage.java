package logic.pages.companyProfile.drivers.driverInfo;

import logic.pages.companyProfile.drivers.ProfilesTab;
import logic.dbConnection.entity.DriverProfile;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class EditDriverProfilePage extends AddDriverProfilePage {
    @FindBy(css = "button[ng-click='vm.changePassword()']")
    private WebElement changePasswordBtn;
    @FindBy(xpath = "//a[contains(text(),'Document')]")
    private WebElement documentTab;
    @FindBy(xpath = "//a[contains(text(),'Upload Photo')]")
    private WebElement uploadPhotoTab;
    @FindBy(xpath = "//a[contains(text(),'Communications')]")
    private WebElement communicationsTab;
    @FindBy(xpath = "//a[contains(text(),'Additional Info')]")
    private WebElement additionalInfoTab;
    @FindBy(xpath = "//a[contains(text(),'Payment')]")
    private WebElement paymentTab;
    private DriverProfile driverProfile = null;
    private DriverProfile driverProfileAfterSave = null;
    private static final Logger log = Logger.getLogger(EditDriverProfilePage.class);

    public EditDriverProfilePage() {
    }

    public EditDriverProfilePage(DriverProfile driverProfile) {
        this.driverProfile = driverProfile;
    }

    public EditDriverProfilePage parseTrackEnsureElogDriverProfile() {
        waitToVisibilityOf(20, loginNameField);
        this.driverProfileAfterSave = new DriverProfile();
        driverProfileAfterSave.setHosProvider(hosProviderSelector.getText());
        driverProfileAfterSave.setForAudit(forAuditCheckbox.isSelected());
        driverProfileAfterSave.setFirstName(firstNameField.getAttribute("value"));
        driverProfileAfterSave.setLastName(lastNameField.getAttribute("value"));
        driverProfileAfterSave.setEmail(emailField.getAttribute("value"));
        driverProfileAfterSave.setPhone(phoneField.getAttribute("value"));
        driverProfileAfterSave.setStatus(statusSelector.getText());
        driverProfileAfterSave.setLoginName(loginNameField.getAttribute("value"));
        driverProfileAfterSave.setPassword(passwordField.getAttribute("value"));
        driverProfileAfterSave.setDriverLicenseNumber(licenseNumberField.getAttribute("value"));
        driverProfileAfterSave.setLicenseState(licenseStateSelector.getText());
        driverProfileAfterSave.setHomeTerminalTimezone(homeTerminalTimezoneSelector.getText());
        driverProfileAfterSave.setUsaMultidayBasis(eldMultidayBasisUsedUsaSelector.getText());
        driverProfileAfterSave.setCanadianMultidayBasis(eldMultidayBasisUsedCanSelector.getText());
        driverProfileAfterSave.seteLogAppMode(eLogAppModeSelector.getText());
        driverProfileAfterSave.setTripStatMinSpeed(tripStartMinSpeedField.getAttribute("value"));
        driverProfileAfterSave.setTripEndMaxSpeed(tripStartMaxSpeedField.getAttribute("value"));
        driverProfileAfterSave.setEldExempt(eldExemptCheckbox.isSelected());
        driverProfileAfterSave.setEldExemptComment(eldExemptCommentField.getAttribute("value"));
        driverProfileAfterSave.setDriverContractorWithPersonalAuthority(isDriverContractorWithPersonalAuthorityCheckbox.isSelected());
        if (isDriverContractorWithPersonalAuthorityCheckbox.isSelected()) {
            driverProfileAfterSave.setCompanyName(companyNameField.getAttribute("value"));
            driverProfileAfterSave.setCompanyAddress(companyAddressField.getAttribute("value"));
            driverProfileAfterSave.setSameAsCompanyAddress(sameAsCompanyAddressCheckbox.isSelected());
            if (sameAsCompanyAddressCheckbox.isSelected())
                driverProfileAfterSave.setYardAddress(companyAddressField.getAttribute("value"));
            else
                driverProfileAfterSave.setYardAddress(yardAddressField.getAttribute("value"));
            driverProfileAfterSave.setContactInfo(contactInfoField.getAttribute("value"));
            driverProfileAfterSave.setAuthorityNumbers(authorityNumbersField.getAttribute("value"));
        }
        driverProfileAfterSave.setYardMoveAllowed(eldIsYardMoveAllowedCheckbox.isSelected());
        driverProfileAfterSave.setPersonalUseAllowed(eldIsPersonalUseAllowedCheckbox.isSelected());
        driverProfileAfterSave.setOwnerOperator(ownerOperatorCheckbox.isSelected());
        driverProfileAfterSave.setTruckNumber(truckNumberSelector.getText());
        driverProfileAfterSave.setTrailerNumber(trailerNumberSelector.getText());
        driverProfileAfterSave.setRegainHoursAtMidnight(regainHoursAtMidnightCheckbox.isSelected());
        driverProfileAfterSave.setDisplayTimeOnMobileGraph(displayTimeOnMobileGraphCheckbox.isSelected());
        driverProfileAfterSave.setDisable15Days(disable15DaysCheckbox.isSelected());
        driverProfileAfterSave.setGenerateLocationDescription(generateLocationDescriptionField.getText());
        driverProfileAfterSave.setAllowEditInformation(allowEditInformationCheckbox.isSelected());
        driverProfileAfterSave.setCollectGpsWhileNotConnectedToTruck(collectGPSWithoutTruckCheckbox.isSelected());
        driverProfileAfterSave.setAutoSyncEvents(eldEventsAutoSyncCheckbox.isSelected());
        driverProfileAfterSave.setShowAlertOnNewMessage(showAlertOnNewMessageCheckbox.isSelected());
        driverProfileAfterSave.setEnableVoiceMessage(enableVoiceMessageCheckbox.isSelected());
        driverProfileAfterSave.setSoundNotificationOnNewMessage(soundNotificationOnNewMessageCheckbox.isSelected());
        driverProfileAfterSave.setAllowDeleteEventsInEldApp(allowDeleteEventsCheckbox.isSelected());
        driverProfileAfterSave.setAllowInsertEventsInEldApp(allowInsertEventsCheckbox.isSelected());
        driverProfileAfterSave.setAllowEditEventsInEldApp(allowEditEventsCheckbox.isSelected());
        driverProfileAfterSave.setAllowDrivingEventsInEldApp(allowDrivingEventsCheckbox.isSelected());
        driverProfileAfterSave.setOnlyDrivesInUsa(onlyUsaDrivingCheckbox.isSelected());
        driverProfileAfterSave.setRemindDriverToUpdateApp(remindDriverToUpdateAppCheckbox.isSelected());
        if (remindDriverToUpdateAppCheckbox.isSelected())
            driverProfileAfterSave.setRemindDriverToUpdateAppMinutes(remindDriverToUpdateAppMinutesField.getAttribute("value"));
        log.info("Parsed Driver Info: " + driverProfileAfterSave.toString());
        return this;
    }

    public boolean checkTrackEnsureElogDriverProfile() {
        int errorCount = 0;
        if (!assertTextValue(driverProfileAfterSave.getHosProvider(), driverProfile.getHosProvider(), "getHosProvider"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isForAudit(), driverProfile.isForAudit(), "isForAudit"))
            errorCount++;
        if (!assertTextValue(driverProfileAfterSave.getFirstName(), driverProfile.getFirstName(), "getFirstName"))
            errorCount++;
        if (!assertTextValue(driverProfileAfterSave.getLastName(), driverProfile.getLastName(), "getLastName"))
            errorCount++;
        if (!assertTextValue(driverProfileAfterSave.getEmail(), driverProfile.getEmail(), "getEmail")) errorCount++;
        if (!assertTextValue(driverProfileAfterSave.getStatus(), driverProfile.getStatus(), "getStatus")) errorCount++;
        if (!assertTextValue(driverProfileAfterSave.getCanadianMultidayBasis(), driverProfile.getCanadianMultidayBasis(), "getCanadianMultidayBasis"))
            errorCount++;
        if (!assertTextValue(driverProfileAfterSave.getUsaMultidayBasis(), driverProfile.getUsaMultidayBasis(), "getUsaMultidayBasis"))
            errorCount++;
        if (!assertTextValue(driverProfileAfterSave.getDriverLicenseNumber(), driverProfile.getDriverLicenseNumber(), "getDriverLicenseNumber"))
            errorCount++;
        if (!assertTextValue(driverProfileAfterSave.geteLogAppMode(), driverProfile.geteLogAppMode(), "geteLogAppMode"))
            errorCount++;
        if (!assertTextValue(driverProfileAfterSave.getLicenseState(), driverProfile.getLicenseState(), "getLicenseState"))
            errorCount++;
        if (!assertTextValue(driverProfileAfterSave.getHomeTerminalTimezone(), driverProfile.getHomeTerminalTimezone(), "getHomeTerminalTimezone"))
            errorCount++;
        if (driverProfileAfterSave.isEldExempt()) {
            if (!assertTextValue(driverProfileAfterSave.getEldExemptComment(), driverProfile.getEldExemptComment(), "getEldExemptComment"))
                errorCount++;
        } else {
            if (!assertTextValue(driverProfileAfterSave.getEldExemptComment(), "", "getEldExemptComment"))
                errorCount++;
        }
        if (!assertTextValue(driverProfileAfterSave.getPassword(), driverProfile.getPassword(), "getPassword"))
            errorCount++;
        if (!assertTextValue(driverProfileAfterSave.getTripEndMaxSpeed(), driverProfile.getTripEndMaxSpeed(), "getTripEndMaxSpeed"))
            errorCount++;
        if (!assertTextValue(driverProfileAfterSave.getTripStatMinSpeed(), driverProfile.getTripStatMinSpeed(), "getTripStatMinSpeed"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isEldExempt(), driverProfile.isEldExempt(), "isEldExempt"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isDriverContractorWithPersonalAuthority(), driverProfile.isDriverContractorWithPersonalAuthority(), "isDriverContractorWithPersonalAuthority"))
            errorCount++;
        if (driverProfileAfterSave.isDriverContractorWithPersonalAuthority()) {
            if (!assertTextValue(driverProfileAfterSave.getCompanyName(), driverProfile.getCompanyName(), "getCompanyName"))
                errorCount++;
            if (!assertTextValue(driverProfileAfterSave.getCompanyAddress(), driverProfile.getCompanyAddress(), "getCompanyAddress"))
                errorCount++;
            if (!assertBoolValue(driverProfileAfterSave.isSameAsCompanyAddress(), driverProfile.isSameAsCompanyAddress(), "isSameAsCompanyAddress"))
                errorCount++;
            if (!driverProfileAfterSave.isSameAsCompanyAddress()) {
                if (!assertTextValue(driverProfileAfterSave.getYardAddress(), driverProfile.getYardAddress(), "getYardAddress"))
                    errorCount++;
            } else {
                if (!assertTextValue(driverProfileAfterSave.getYardAddress(), driverProfile.getCompanyAddress(), "getYardAddress"))
                    errorCount++;
            }
            if (!assertTextValue(driverProfileAfterSave.getContactInfo(), driverProfile.getContactInfo(), "getContactInfo"))
                errorCount++;
            if (!assertTextValue(driverProfileAfterSave.getAuthorityNumbers(), driverProfile.getAuthorityNumbers(), "getAuthorityNumbers"))
                errorCount++;
        }
        if (!assertBoolValue(driverProfileAfterSave.isYardMoveAllowed(), driverProfile.isYardMoveAllowed(), "isYardMoveAllowed"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isPersonalUseAllowed(), driverProfile.isPersonalUseAllowed(), "isPersonalUseAllowed"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isOwnerOperator(), driverProfile.isOwnerOperator(), "isOwnerOperator"))
            errorCount++;
        if (driverProfileAfterSave.isOwnerOperator()) {
            if (!assertTextValue(driverProfileAfterSave.getTruckNumber(), driverProfile.getTruckNumber(), "getTruckNumber"))
                errorCount++;
            if (!assertTextValue(driverProfileAfterSave.getTrailerNumber(), driverProfile.getTrailerNumber(), "getTrailerNumber"))
                errorCount++;
        } else {
            if (!assertTextValue(driverProfileAfterSave.getTruckNumber(), "", "getTruckNumber")) errorCount++;
            if (!assertTextValue(driverProfileAfterSave.getTrailerNumber(), "", "getTrailerNumber")) errorCount++;
        }
        if (!assertBoolValue(driverProfileAfterSave.isRegainHoursAtMidnight(), driverProfile.isRegainHoursAtMidnight(), "isRegainHoursAtMidnight"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isDisplayTimeOnMobileGraph(), driverProfile.isDisplayTimeOnMobileGraph(), "isDisplayTimeOnMobileGraph"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isDisable15Days(), driverProfile.isDisable15Days(), "isDisable15Days"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isAllowEditInformation(), driverProfile.isAllowEditInformation(), "isAllowEditInformation"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isCollectGpsWhileNotConnectedToTruck(), driverProfile.isCollectGpsWhileNotConnectedToTruck(), "isCollectGpsWhileNotConnectedToTruck"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isAutoSyncEvents(), driverProfile.isAutoSyncEvents(), "isAutoSyncEvents"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isShowAlertOnNewMessage(), driverProfile.isShowAlertOnNewMessage(), "isShowAlertOnNewMessage"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isEnableVoiceMessage(), driverProfile.isEnableVoiceMessage(), "isEnableVoiceMessage"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isSoundNotificationOnNewMessage(), driverProfile.isSoundNotificationOnNewMessage(), "isSoundNotificationOnNewMessage"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isAllowDeleteEventsInEldApp(), driverProfile.isAllowDeleteEventsInEldApp(), "isAllowDeleteEventsInEldApp"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isAllowInsertEventsInEldApp(), driverProfile.isAllowInsertEventsInEldApp(), "isAllowInsertEventsInEldApp"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isAllowEditEventsInEldApp(), driverProfile.isAllowEditEventsInEldApp(), "isAllowEditEventsInEldApp"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isAllowDrivingEventsInEldApp(), driverProfile.isAllowDrivingEventsInEldApp(), "isAllowDrivingEventsInEldApp"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isOnlyDrivesInUsa(), driverProfile.isOnlyDrivesInUsa(), "isOnlyDrivesInUsa"))
            errorCount++;
        if (!assertBoolValue(driverProfileAfterSave.isRemindDriverToUpdateApp(), driverProfile.isRemindDriverToUpdateApp(), "isRemindDriverToUpdateApp"))
            errorCount++;
        if (driverProfileAfterSave.isRemindDriverToUpdateApp())
            if (!assertTextValue(driverProfileAfterSave.getRemindDriverToUpdateAppMinutes(), driverProfile.getRemindDriverToUpdateAppMinutes(), "getRemindDriverToUpdateAppMinutes"))
                errorCount++;
            else if (!assertTextValue(driverProfileAfterSave.getRemindDriverToUpdateAppMinutes(), "", "getRemindDriverToUpdateAppMinutes"))
                errorCount++;
        return errorCount == 0;
    }

    @Override
    public void selectHosProvider(String hosProvider) {
        super.selectHosProvider(hosProvider);
    }

    @Override
    public void clickForAudit(boolean forAudit) {
        super.clickForAudit(forAudit);
    }

    @Override
    public void inputFirstName(String firstName) {
        super.inputFirstName(firstName);
    }

    @Override
    public void inputLastName(String lastName) {
        super.inputLastName(lastName);
    }

    @Override
    public void inputEmail(String email) {
        super.inputEmail(email);
    }

    @Override
    public void inputPhoneNumber(String phoneNumber) {
        super.inputPhoneNumber(phoneNumber);
    }

    @Override
    public void selectStatus(String status) {
        super.selectStatus(status);
    }

    @Override
    public void inputLoginName(String loginName) {
        super.inputLoginName(loginName);
    }

    @Override
    public void inputPassword(String password) {
        super.inputPassword(password);
    }

    @Override
    public void inputConfirmPassword(String password) {
        super.inputConfirmPassword(password);
    }

    @Override
    public void inputLicenseNumber(String licenseNumber) {
        super.inputLicenseNumber(licenseNumber);
    }

    @Override
    public void selectLicenseState(String licenseState) {
        super.selectLicenseState(licenseState);
    }

    @Override
    public void selectHomeTerminalTimezone(String homeTerminalTimezone) {
        super.selectHomeTerminalTimezone(homeTerminalTimezone);
    }

    @Override
    public void selectEldMultidayBasisUsedUsa(String eldMultidayBasisUsedUsa) {
        super.selectEldMultidayBasisUsedUsa(eldMultidayBasisUsedUsa);
    }

    @Override
    public void selectEldMultidayBasisUsedCan(String eldMultidayBasisUsedCan) {
        super.selectEldMultidayBasisUsedCan(eldMultidayBasisUsedCan);
    }

    @Override
    public void selectELogAppMode(String eLogAppMode) {
        super.selectELogAppMode(eLogAppMode);
    }

    @Override
    public void inputEldEditMode(String eldEditMode) {
        super.inputEldEditMode(eldEditMode);
    }

    @Override
    public void inputTripStartMinSpeed(String tripStartMinSpeed) {
        super.inputTripStartMinSpeed(tripStartMinSpeed);
    }

    @Override
    public void inputTripStartMaxSpeed(String tripStartMaxSpeed) {
        super.inputTripStartMaxSpeed(tripStartMaxSpeed);
    }

    @Override
    public void clickEldExemptCheckbox(boolean eldExempt) {
        super.clickEldExemptCheckbox(eldExempt);
    }

    @Override
    public void inputEldExemptComment(String eldExemptComment) {
        super.inputEldExemptComment(eldExemptComment);
    }

    @Override
    public void clickDriverContractorWithPersonalAuthority(boolean isDriverContractorWithPersonalAuthority) {
        super.clickDriverContractorWithPersonalAuthority(isDriverContractorWithPersonalAuthority);
    }

    @Override
    public void inputCompanyName(String companyName) {
        super.inputCompanyName(companyName);
    }

    @Override
    public void inputCompanyAddress(String companyAddress) {
        super.inputCompanyAddress(companyAddress);
    }

    @Override
    public void clickSameAsCompanyAddress(boolean sameAsCompanyAddress) {
        super.clickSameAsCompanyAddress(sameAsCompanyAddress);
    }

    @Override
    public void inputYardAddress(String yardAddress) {
        super.inputYardAddress(yardAddress);
    }

    @Override
    public void inputContactInfo(String contactInfo) {
        super.inputContactInfo(contactInfo);
    }

    @Override
    public void inputAuthorityNumbers(String authorityNumbers) {
        super.inputAuthorityNumbers(authorityNumbers);
    }

    @Override
    public void clickEldIsYardMoveAllowed(boolean eldIsYardMoveAllowed) {
        super.clickEldIsYardMoveAllowed(eldIsYardMoveAllowed);
    }

    @Override
    public void clickEldIsPersonalUseAllowed(boolean eldIsPersonalUseAllowed) {
        super.clickEldIsPersonalUseAllowed(eldIsPersonalUseAllowed);
    }

    @Override
    public void clickRegainHoursAtMidnight(boolean regainHoursAtMidnight) {
        super.clickRegainHoursAtMidnight(regainHoursAtMidnight);
    }

    @Override
    public void clickOwnerOperator(boolean ownerOperator) {
        super.clickOwnerOperator(ownerOperator);
    }

    @Override
    public void selectTruckNumber(String truckNumber) {
        super.selectTruckNumber(truckNumber);
    }

    @Override
    public void selectTrailerNumber(String trailerNumber) {
        super.selectTrailerNumber(trailerNumber);
    }

    @Override
    public void clickDisable15Days(boolean disable15Days) {
        super.clickDisable15Days(disable15Days);
    }

    @Override
    public void selectGenerateLocationDescription(String generateLocationDescription) {
        super.selectGenerateLocationDescription(generateLocationDescription);
    }

    @Override
    public void clickDisplayTimeOnMobileGraph(boolean displayTimeOnMobileGraph) {
        super.clickDisplayTimeOnMobileGraph(displayTimeOnMobileGraph);
    }

    @Override
    public void clickAllowEditInformation(boolean allowEditInformation) {
        super.clickAllowEditInformation(allowEditInformation);
    }

    @Override
    public void clickCollectGPSWithoutTruck(boolean collectGPSWithoutTruck) {
        super.clickCollectGPSWithoutTruck(collectGPSWithoutTruck);
    }

    @Override
    public void clickEldEventsAutoSync(boolean eldEventsAutoSync) {
        super.clickEldEventsAutoSync(eldEventsAutoSync);
    }

    @Override
    public void clickShowAlertOnNewMessage(boolean showAlertOnNewMessage) {
        super.clickShowAlertOnNewMessage(showAlertOnNewMessage);
    }

    @Override
    public void clickEnableVoiceMessage(boolean enableVoiceMessage) {
        super.clickEnableVoiceMessage(enableVoiceMessage);
    }

    @Override
    public void clickSoundNotificationOnNewMessage(boolean soundNotificationOnNewMessage) {
        super.clickSoundNotificationOnNewMessage(soundNotificationOnNewMessage);
    }

    @Override
    public void clickAllowDeleteEvents(boolean allowDeleteEvents) {
        super.clickAllowDeleteEvents(allowDeleteEvents);
    }

    @Override
    public void clickAllowInsertEvents(boolean allowInsertEvents) {
        super.clickAllowInsertEvents(allowInsertEvents);
    }

    @Override
    public void clickAllowEditEvents(boolean allowEditEvents) {
        super.clickAllowEditEvents(allowEditEvents);
    }

    @Override
    public void clickAllowDrivingEvents(boolean allowDrivingEvents) {
        super.clickAllowDrivingEvents(allowDrivingEvents);
    }

    @Override
    public void clickOnlyUsaDriving(boolean onlyUsaDriving) {
        super.clickOnlyUsaDriving(onlyUsaDriving);
    }

    @Override
    public void clickRemindDriverToUpdateApp(boolean remindDriverToUpdateApp) {
        super.clickRemindDriverToUpdateApp(remindDriverToUpdateApp);
    }

    @Override
    public void inputRemindDriverToUpdateAppMinutes(String remindDriverToUpdateAppMinutes) {
        super.inputRemindDriverToUpdateAppMinutes(remindDriverToUpdateAppMinutes);
    }

    @Override
    public EditDriverProfilePage enterValuesInForms() {
        waitToVisibilityOf(10, changePasswordBtn);
        changePasswordBtn.click();
        super.setDriverProfile(driverProfile);
        super.enterValuesInForms();
        return this;
    }

    @Override
    public EditDriverProfilePage checkErrorMessage() {
        super.checkErrorMessage();
        return this;
    }

    @Override
    public ProfilesTab saveDriverProfile() {
        return super.saveDriverProfile();
    }

    public DocumentTab goToDocumentTab() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , saveDriverBtn);
        waitToVisibilityOf(20, documentTab);
        documentTab.click();
        return new DocumentTab();
    }

    public UploadPhotoTab goToUploadPhotoTab() {
        waitToVisibilityOf(20, uploadPhotoTab);
        uploadPhotoTab.click();
        return new UploadPhotoTab();
    }

    public CommunicationsTab goToCommunicationsTab() {
        waitToVisibilityOf(20, communicationsTab);
        communicationsTab.click();
        return new CommunicationsTab();
    }

    public AdditionalInfoTab goToAdditionalInfoTab() {
        waitToVisibilityOf(20, additionalInfoTab);
        additionalInfoTab.click();
        return new AdditionalInfoTab();
    }

    public PaymentTab goToPaymentTab() {
        waitToVisibilityOf(20, paymentTab);
        paymentTab.click();
        return new PaymentTab();
    }
}
