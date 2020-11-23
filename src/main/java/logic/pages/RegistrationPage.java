package logic.pages;

import logic.BasePage;
import logic.email.EmailReader;
import logic.report.LogToAllure;
import logic.variables.Accounts;
import logic.variables.UrlVariables;
import logic.widgets.Header;
import logic.widgets.NavigationBar;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.*;

import javax.mail.MessagingException;
import java.util.Date;

public class RegistrationPage extends BasePage {

    Header header = new Header();
    @FindBy(css = "div[ng-click=\"vm.nextStep('fleet')\"]")
    private WebElement registerAsFleetBtn;
    @FindBy(css = "div[ng-click=\"vm.nextStep('owner-operator')\"]")
    private WebElement registerAsOwnerBtn;
    @FindBy(css = "div[ng-click=\"vm.nextStep('driver')\"]")
    private WebElement registerAsDriverBtn;
    @FindBy(css = "input[placeholder='Organization Name']")
    private WebElement organizationNameField;
    @FindBy(css = "input[placeholder='Organization Pin']")
    private WebElement organizationPinField;
    @FindBy(css = "input[placeholder='USDOT Number']")
    private WebElement usdotNumField;
    @FindBy(css = "input[placeholder='First Name']")
    private WebElement firstNameField;
    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastNameField;
    @FindBy(css = "input[placeholder='Email']")
    private WebElement emailField;
    @FindBy(css = "input[placeholder='Password']")
    private WebElement passwordField;
    @FindBy(css = "input[placeholder='Confirm Password']")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    private WebElement driveForYouCompanyYes;
    @FindBy(xpath = "//button[contains(text(),'No')]")
    private WebElement driveForYouCompanyNo;
    @FindBy(css = "input[placeholder='Driver License Number']")
    private WebElement driverLicenseNumberField;
    @FindBy(css = "select[ng-model='vm.RS.fs1.selectedCountry']")
    private WebElement selectCountry;
    @FindBy(xpath = "//a[contains(text(),'Go to the Next Registration Step')]")
    private WebElement goToNextStep;
    @FindBy(css = "input[placeholder='Address']")
    private WebElement addressField;
    @FindBy(xpath = "//select[1]")
    private WebElement selectCountryOnNextStep;
    @FindBy(css = "input[placeholder='City']")
    private WebElement cityField;
    @FindBy(xpath = "//select[5]")
    private WebElement selectTimeZoneOnNextStep;
    @FindBy(css = "input[placeholder='Postal Code']")
    private WebElement postalCodeField;
    @FindBy(css = "input[placeholder='Phone Number']")
    private WebElement phoneNumberField;
    //@FindBy(xpath = "//a[contains(text(),'Finish Registration')]")
    @FindBy (partialLinkText = "Finish Registration")
    private WebElement finishRegistrationBtn;
    @FindBy(xpath = "//a[contains(text(),'Get back to the previous Registration Step')]")
    private WebElement getBackToThePreviousRegStep;
    @FindBy(css = "input[ng-model='vm.RS.data.acceptTermsOfUseAndPrivacyPolicy']")
    private WebElement acceptTermsOfUseAndPrivacyPolicyCheckbox;

    private String userRole;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private boolean alsoDriveForCompanyFlag = true;
    private String driverLicense;
    private String userCountry;
    private String userCity;
    private String userAddress;
    private String postalCode;
    private String phoneNumber;
    private String organizationPin;
    private String organizationName;
    private String verificationLink;
    private int tryCount = 0;

    final String TEST_ID = Long.toString(new Date().getTime());

    private static final Logger log = Logger.getLogger(RegistrationPage.class);

    public RegistrationPage() {
        super();
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        return false;
    }

    public RegistrationPage setValuesForFleet(String userFirstName, String userLastName, String userEmail,
                                              String userPassword, String organizationName, boolean alsoDriveForCompanyFlag, String driverLicense,
                                              String userCountry, String userCity,
                                              String userAddress, String postalCode, String phoneNumber) {
        this.userRole = "Fleet";
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPassword = userPassword;
        this.alsoDriveForCompanyFlag = alsoDriveForCompanyFlag;
        this.userCountry = userCountry;
        this.userCity = userCity;
        this.userAddress = userAddress;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.driverLicense = driverLicense;
        this.userEmail = userEmail;
        this.organizationName = organizationName;
        return this;
    }

    public RegistrationPage setValuesForOwner(String userFirstName, String userLastName, String userEmail,
                                              String userPassword, String organizationName, String driverLicense, String userCountry,
                                              String userCity, String userAddress, String postalCode, String phoneNumber) {
        this.userRole = "Owner";
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPassword = userPassword;
        this.userCountry = userCountry;
        this.userCity = userCity;
        this.userAddress = userAddress;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.driverLicense = driverLicense;
        this.userEmail = userEmail;
        this.organizationName = organizationName;
        return this;
    }

    public RegistrationPage setValuesForDriver(String organizationPin, String userFirstName, String userLastName, String userEmail,
                                               String userPassword,
                                               String userCountry, String userCity, String driverLicense
    ) {
        this.userRole = "Driver";
        this.organizationPin = organizationPin;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPassword = userPassword;
        this.userCountry = userCountry;
        this.userCity = userCity;
        this.driverLicense = driverLicense;
        this.userEmail = userEmail;
        return this;
    }


    public RegistrationPage selectRegistrationType() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switch (userRole) {
            case "Fleet": {
                waitToVisibilityOf(20, registerAsFleetBtn);
                waitToBeClickable(20, registerAsFleetBtn);
                registerAsFleetBtn.click();
            }
            break;
            case "Owner": {
                waitToVisibilityOf(20, registerAsOwnerBtn);
                waitToBeClickable(20, registerAsOwnerBtn);
                registerAsOwnerBtn.click();
            }
            break;
            case "Driver": {
                waitToVisibilityOf(20, registerAsDriverBtn);
                waitToBeClickable(20, registerAsDriverBtn);
                registerAsDriverBtn.click();
            }
            break;
        }
            /*try {
                waitToVisibilityOf(2,emailField);
            } catch(TimeoutException e){
               return selectRegistrationType();
        }*/
        log.info("Select registration type: " + userRole);
        LogToAllure.logToAllure("Select registration type", userRole);
        return this;
    }

    public RegistrationPage selectDoYouAlsoDriveForCompany() {
        if (alsoDriveForCompanyFlag)
            driveForYouCompanyYes.click();
        else
            driveForYouCompanyNo.click();
        log.info("Select 'Do You Also Drive For Company' - " + alsoDriveForCompanyFlag);
        LogToAllure.logToAllure("Select 'Do You Also Drive For Company'", String.valueOf(alsoDriveForCompanyFlag));
        return this;
    }

    public RegistrationPage inputOrganiztionName() {
        if (organizationName.equals("Template")) this.organizationName = TEST_ID;
        waitToVisibilityOf(10, organizationNameField);
        organizationNameField.clear();
        organizationNameField.sendKeys(organizationName);
        log.info("Input Organization Name: " + organizationName);
        LogToAllure.logToAllure("Input Organization Name", organizationName);
        return this;
    }

    public RegistrationPage inputUsdotNumber() {
        waitToVisibilityOf(10, usdotNumField);
        usdotNumField.clear();
        usdotNumField.sendKeys(TEST_ID);
        log.info("Input USDOT num: " + TEST_ID);
        LogToAllure.logToAllure("Input USDOT num", TEST_ID);
        return this;
    }

    public RegistrationPage inputName() {
        try {
            waitToVisibilityOf(10, firstNameField);
        } catch (Exception e) {
            if (!driver.getCurrentUrl().contains("step-1"))
                selectRegistrationType();
            else {
                log.error(e);
                assertTrue(false, e.toString());
            }
        }
        firstNameField.clear();
        lastNameField.clear();
        firstNameField.sendKeys(userFirstName);
        lastNameField.sendKeys(userLastName);
        log.info("Input User Name: " + userFirstName + " " + userLastName);
        LogToAllure.logToAllure("Input User Name", userFirstName + " " + userLastName);
        return this;
    }

    public RegistrationPage inputEmail() {
        if (userEmail.equals("Template")) this.userEmail = "trackensuretest+" + TEST_ID + "@ukr.net";
        waitToVisibilityOf(10, emailField);
        emailField.clear();
        emailField.sendKeys(userEmail);
        log.info("Input Email: " + userEmail);
        LogToAllure.logToAllure("Input Email", userEmail);
        return this;
    }

    public RegistrationPage inputPassword() {
        waitToVisibilityOf(10, passwordField);
        passwordField.clear();
        passwordField.sendKeys(userPassword);
        log.info("Input Password: " + userPassword);
        LogToAllure.logToAllure("Input Password", userPassword);
        return this;
    }

    public RegistrationPage inputConfirmPassword() {
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(userPassword);
        log.info("Input Confirm Password: " + userPassword);
        LogToAllure.logToAllure("Input Confirm Password", userPassword);
        return this;
    }

    public RegistrationPage inputDriverLicenseNumber() {
        if (driverLicense.equals("Template")) this.driverLicense = TEST_ID;
        waitToVisibilityOf(10, driverLicenseNumberField);
        driverLicenseNumberField.clear();
        driverLicenseNumberField.sendKeys(driverLicense);
        log.info("Input Driver License Number: " + driverLicense);
        LogToAllure.logToAllure("Input Driver License Number", driverLicense);
        return this;
    }

    public RegistrationPage inputDriverLicenseNumber(String licenseNum) {
        waitToVisibilityOf(10, driverLicenseNumberField);
        driverLicenseNumberField.clear();
        driverLicenseNumberField.sendKeys(licenseNum);
        log.info("Input Driver License Number: " + driverLicense);
        LogToAllure.logToAllure("Input Driver License Number", driverLicense);
        return this;
    }

    public RegistrationPage selectCountry() {
        if (userCountry.equals("") || userCountry.equals(" ")) return this;
        waitToVisibilityOf(10, selectCountry);
        Select countries = new Select(selectCountry);
        countries.selectByValue(userCountry);
        log.info("Select Country: " + userCountry);
        LogToAllure.logToAllure("Select Country", userCountry);
        WebElement stateSelect = driver.findElement(By.xpath("//select[2]"));
        waitToVisibilityOf(10, stateSelect);
        Select states = new Select(stateSelect);
        states.selectByIndex(2);
        log.info("Select state in Select menu - " + states.getFirstSelectedOption().getText());
        LogToAllure.logToAllure("Select state in Select menu", states.getFirstSelectedOption().getText());
        return this;
    }

    public RegistrationPage selectCountryAfterNextStep() {
        waitToVisibilityOf(10, selectCountryOnNextStep);
        Select countries = new Select(selectCountryOnNextStep);
        countries.selectByValue(userCountry);
        WebElement select = null;
        switch (userCountry) {
            case "United States": {
                select = driver.findElement(By.xpath("//select[2]"));
            }
            break;
            case "Canada": {
                select = driver.findElement(By.xpath("//select[3]"));
            }
            break;
            case "Mexico": {
                select = driver.findElement(By.xpath("//select[4]"));
            }
            break;
            case "":
                return this;
        }
        log.info("Select Country: " + userCountry);
        LogToAllure.logToAllure("Select Country", userCountry);
        waitToVisibilityOf(10, select);
        Select states = new Select(select);
        states.selectByIndex(2);
        log.info("Select state in Select menu - " + states.getFirstSelectedOption().getText());
        LogToAllure.logToAllure("Select state in Select menu", states.getFirstSelectedOption().getText());
        return this;
    }

    public RegistrationPage inputOrganizationPin() {
        waitToVisibilityOf(10, organizationPinField);
        organizationPinField.clear();
        organizationPinField.sendKeys(organizationPin);
        log.info("Input Organization Pin: " + organizationPin);
        LogToAllure.logToAllure("Input Organization Pin", organizationPin);
        return this;
    }

    public RegistrationPage selectTimeZoneAfterNextStep() {
        waitToVisibilityOf(10, selectTimeZoneOnNextStep);
        Select timeZone = new Select(selectTimeZoneOnNextStep);
        timeZone.selectByIndex(2);
        log.info("Select Time Zone in Select menu");
        LogToAllure.logToAllure("Select Time Zone in Select menu", timeZone.getFirstSelectedOption().getText());
        return this;
    }

    public RegistrationPage goToNextRegistrationStep() {
        waitToBeClickable(10, goToNextStep);
        goToNextStep.click();
        log.info("Click on 'Go To Next Registration Step'");
        LogToAllure.logToAllure("Click On 'Go To Next Registration Step'", "");
        return this;
    }

    public void checkGoNextRegStepIsDisabledBtn() {
        assertEquals(goToNextStep.getAttribute("disabled"), "true");
    }

    public void checkFinishRegIsEnabledBtn() {

        assertEquals(finishRegistrationBtn.getAttribute("disabled"), "true");
    }

    public RegistrationPage getBackToThePreviusRegistrationStep() {
        waitToBeClickable(10, getBackToThePreviousRegStep);
        getBackToThePreviousRegStep.click();
        log.info("Click on 'Go Back To Previous Registration Step'");
        LogToAllure.logToAllure("Click On 'Go Back To Previous Registration Step'", "");
        return this;
    }

    public RegistrationPage finishRegistration() {
        clickOnElement(finishRegistrationBtn);
        log.info("Click on 'Finish Registration'");
        LogToAllure.logToAllure("Click On 'Finish Registration'", "");
        return this;
    }

    public RegistrationPage inputAddress() {
        waitToVisibilityOf(10, addressField);
        addressField.clear();
        addressField.sendKeys(userAddress);
        log.info("Input Address: " + userAddress);
        LogToAllure.logToAllure("Input Address", userAddress);
        return this;
    }

    public RegistrationPage inputCity() {
        waitToVisibilityOf(10, cityField);
        cityField.clear();
        cityField.sendKeys(userCity);
        log.info("Input City: " + userCity);
        LogToAllure.logToAllure("Input City", userCity);
        return this;
    }

    public RegistrationPage inputPostalCode() {
        waitToVisibilityOf(10, postalCodeField);
        postalCodeField.clear();
        postalCodeField.sendKeys(postalCode);
        log.info("Input Postal Code: " + postalCode);
        LogToAllure.logToAllure("Input Postal Code", postalCode);
        return this;
    }

    public RegistrationPage inputPhoneNumber() {
        waitToVisibilityOf(10, phoneNumberField);
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phoneNumber);
        log.info("Input Phone Number: " + phoneNumber);
        LogToAllure.logToAllure("Input Phone Number", phoneNumber);
        return this;
    }

    public RegistrationPage enterValuesInFieldsFirstRegPage() {
        inputName()
                .inputUsdotNumber();
        if (userRole.equals("Driver")) {
            inputOrganizationPin();
            acceptTermsOfUseAndPrivacyPolicyCheckbox.click();
        } else inputOrganiztionName();
        inputEmail()
                .inputPassword()
                .inputConfirmPassword();
        if (userRole.equals("Fleet"))
            selectDoYouAlsoDriveForCompany();
        if (alsoDriveForCompanyFlag) {
            inputDriverLicenseNumber()
                    .selectCountry();
        }
        return this;
    }

    public RegistrationPage enterValuesInFieldsSecondRegPage() {
        inputCity()
                .inputAddress()
                .selectCountryAfterNextStep()
                .selectTimeZoneAfterNextStep()
                .inputPostalCode()
                .inputPhoneNumber();
        if (userRole.equals("Fleet") || userRole.equals("Owner"))
            acceptTermsOfUseAndPrivacyPolicyCheckbox.click();
        return this;
    }

    public RegistrationPage checkNewRegistration() {
        if (!userRole.equals("Driver")) {
            LogToAllure.logToAllure("Parsed verification link from message", verificationLink);
            log.info("Parsed verification link from letter " + verificationLink);

            LogToAllure.logToAllure("Go to URL", verificationLink);
            log.info("Go to: " + verificationLink);
            driver.get(verificationLink);

            header
                    .checkUserAndCompanyName(userFirstName + " " + userLastName, TEST_ID);
            log.info("CHECK: Title must be equals: " + driver.getTitle() + " | Assets Map - TrackEnsure");
            LogToAllure.logToAllure("CHECK: Title must be equals", driver.getTitle() + " | Assets Map - TrackEnsure");
            assertEquals(driver.getTitle(), "Assets Map - TrackEnsure");
            new NavigationBar()
                    .goToGeneralPage()
                    .checkCompanyGeneralInfoAfterRegistration(TEST_ID, userAddress, userCountry, userCity, postalCode);
            header.logout()
                    .clickOnLogin()
                    .setValuesIntoLoginForm(userEmail, userPassword)
                    .clickBtnSubmitLogin();
            LogToAllure.logToAllure("CHECK: Title must be equals", driver.getTitle() + " | Assets Map - TrackEnsure");
            log.info("CHECK: Title must be equals: " + driver.getTitle() + " | Assets Map - TrackEnsure");
            assertEquals(driver.getTitle(), "Assets Map - TrackEnsure");
        } else {
            new LoginPage().setValuesIntoLoginForm(userEmail, userPassword).clickBtnSubmitLogin();
            log.info("CHECK: Redirect to login page");
            LogToAllure.logToAllure("CHECK: Redirect to login page", "");


            header
                    .checkUserAndCompanyName(userFirstName + " " + userLastName, "HELLEN")
                    .checkAccountPin(organizationPin);
            LogToAllure.logToAllure("CHECK: Title must be equals", driver.getTitle() + " | Driver Profile - TrackEnsure");
            log.info("CHECK: Title must be equals: " + driver.getTitle() + " | Driver Profile - TrackEnsure");
            assertEquals(driver.getTitle(), "Driver Profile - TrackEnsure");

        }

        return this;
    }

    public RegistrationPage checkInvalidPinForDriverUser() {
        WebElement alertError = driver.findElement(By.xpath("//div[contains(text(),'Invalid PIN')]"));
        waitToVisibilityOf(10, alertError);
        assertTrue(alertError.isDisplayed());
        alertError.click();
        alertError.click();
        return this;
    }

    public RegistrationPage getVerificationLinkFromMessage() {
        LogToAllure.logToAllure("Waiting for confirmation message", "");
        EmailReader emailReader = null;
        try {
            emailReader = new EmailReader(Accounts.EMAIL_ADDRESS, Accounts.EMAIL_PASSWORD, Accounts.EMAIL_SERVER);
        } catch (MessagingException e) {
            log.error(e);
            assertTrue(false, e.toString());
        }
        try {
            this.verificationLink = emailReader.searchRegistrationMail(UrlVariables.getBaseURL());
        } catch (Exception e) {
            log.error(e);
            assertTrue(false, e.toString());
        }
        return this;
    }
}
