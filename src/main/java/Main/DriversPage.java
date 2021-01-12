package Main;

import com.codeborne.selenide.SelenideElement;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class DriversPage extends BasePage {

    public SelenideElement firstNameInputSearch = $x("//input[@name='driverFirstName']"),
                            lastNameInputSearch = $x("//input[@name='driverLastName']"),
                            btnUpdateDriver = $x("//a[@uib-tooltip = 'Update']//i[contains(@class, 'fa-pencil')]"),
                            checkBoxActivateLoadBoard = $x("//*[@ng-if = 'vm.sendLoadOffers']//input"),
                            btnSave = $x("//button[contains(text(), 'Save')]");
    SelenideElement addNewDriverBtn = $x("//a[contains(text(), 'Add New Driver')]"),
            hosProviderInput = $x("//*[@aria-label = 'Select box activate']"),
            firstNameInput = $x(""),
            lastNameInput = $x(""),
            emailInput = $x(""),
            statusInput = $x(""),
            loginNameInput = $x(""),
            passInput = $x(""),
            confirmPassInput = $x(""),
            driverLicenseNumber = $x(""),
            licenseStateInput = $x(""),
            usaMultidayBasisInput = $x(""),
            CanadianMultidayBasisInput = $x(""),
            homeTerminalTimezoneInput = $x(""),
            eLogAppModeInput = $x(""),
            yardMoveCheckBox = $x(""),
            personalUseCheckBox = $x(""),
            regainHoursAtMidnightCheckBox = $x(""),
            saveBtn = $x(""),
            cancelBtn = $x("");

    public DriversPage openPage(){
        open("http://localhost:8080/TrackEnsure/fleet/manager/cpDrivers/#/");
        return this;
    }

    public DriversPage openUpdatePageForDriver(String firstName, String lastName){
        firstNameInputSearch.setValue(firstName);
        lastNameInputSearch.setValue(lastName);
        sleep(1000);
        btnUpdateDriver.click();

        return this;
    }

    public DriversPage setLoadBoardCheckBox(Boolean value){
        checkBoxActivateLoadBoard.setSelected(value);
        return this;
    }

    public DriversPage saveDriverProfile(){
        btnSave.click();
        waitToVisibilityOf(firstNameInputSearch);
        return this;
    }

    public DriversPage inputHOSProvider(){
        hosProviderInput.click();
        hosProviderInput.setValue("TrackEnsure eLog").pressEnter();
        return this;
    }

    public DriversPage inputFirstName(Integer num){
        firstNameInput.setValue("FirstName" + num);
        return this;
    }

    public DriversPage inputLastName(Integer num){
        lastNameInput.setValue("LastName" + num);
        return this;
    }

    public DriversPage inputEmail(Integer num){
        lastNameInput.setValue("email" + num + "@mail.com");
        return this;
    }

    public DriversPage inputLoginName(Integer num){
        loginNameInput.setValue("logName" + num);
        return this;
    }

    public DriversPage inputPass(){
        passInput.setValue("test");
        return this;
    }

    public DriversPage inputConfirmPass(){
        confirmPassInput.setValue("test");
        return this;
    }

    public DriversPage inputDriverLicenseNumber(Integer num){
        driverLicenseNumber.setValue("driverLicenseNumber" + num);
        return this;
    }

    public DriversPage inputLicenseState(){
        licenseStateInput.click();
        licenseStateInput.setValue("Alabama").pressEnter();
        return this;
    }

    public DriversPage createNewDriver(){
        addNewDriverBtn.click();
        inputHOSProvider();

        return this;
    }

}
