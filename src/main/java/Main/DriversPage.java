package Main;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.*;

public class DriversPage extends BasePage {

    public SelenideElement firstNameInputSearch = $x("//input[@name='driverFirstName']"),
                            lastNameInputSearch = $x("//input[@name='driverLastName']"),
                            btnUpdateDriver = $x("//a[@uib-tooltip = 'Update']//i[contains(@class, 'fa-pencil')]"),
                            checkBoxActivateLoadBoard = $x("//*[@ng-if = 'vm.sendLoadOffers']//input"),
                            btnSave = $x("//button[contains(text(), 'Save')]");
    SelenideElement addNewDriverBtn = $x("//a[contains(text(), 'Add New Driver')]"),
            hosProviderInput = $x("//*[@placeholder = 'HOS Provider']"),
            firstNameInput = $x("//input[@placeholder = 'John']"),
            lastNameInput = $x("//input[@placeholder = 'Smith']"),
            emailInput = $x("//input[@name = 'email'][@placeholder = 'johnsmith@example.com']"),
            loginNameInput = $x("//input[@name = 'loginName'][@placeholder = 'johnsmith@example.com']"),
            passInput = $x("//input[@id = 'button-password']"),
            confirmPassInput = $x("//input[@id = 'button-confirm-password']"),
            driverLicenseNumber = $x("//input[@name = 'licenseNumber']"),
            licenseStateInput = $x("//div[@placeholder = 'Select State']"),
            usaMultidayBasisInput = $x("//div[@name = 'eldMultidayBasisUsed']"),
            canadianMultidayBasisInput = $x("//label[text() = 'Canadian Multiday Basis: ']//..//div[@placeholder = 'Select']"),
            homeTerminalTimezoneInput = $x("//div[@placeholder = 'Select Timezone']"),
            eLogAppModeInput = $x("//label[text() = 'eLog App Mode: ']//..//div[@placeholder = 'Select']"),
            yardMoveCheckBox = $x("//input[@ng-model = 'vm.driver.eldIsYardMoveAllowed']"),
            personalUseCheckBox = $x("//input[@ng-model = 'vm.driver.eldIsPersonalUseAllowed']"),
            regainHoursAtMidnightCheckBox = $x("//input[@ng-model = 'vm.driver.regainHoursAtMidnight']"),
            saveBtn = $x("//button[@ng-click = 'vm.ok(addDriverForm)']"),
            cancelBtn = $x("//*[@class = 'modal-footer']//button[@ng-click = 'vm.cancel()']");
    ElementsCollection hosProviders = $$x("//*[@placeholder = 'HOS Provider']//..//li"),
    licenseStatusList = $$x("//div[@placeholder = 'Select State']//..//*[@role = 'option']"),
    usaMultidayList = $$x("//div[@name = 'eldMultidayBasisUsed']//..//*[@role = 'option']"),
    canadianMultidayList = $$x("//label[text() = 'Canadian Multiday Basis: ']//..//*[@role = 'option']"),
    homeTerminalZoneList = $$x("//div[@placeholder = 'Select Timezone']//..//*[@role = 'option']"),
    eLogAppList = $$x("//label[text() = 'eLog App Mode: ']//..//*[@role = 'option']");

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
        hosProviders.first().click();
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
        emailInput.setValue("email" + num + "@mail.com");
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
        licenseStatusList.first().click();
        return this;
    }

    public DriversPage inputUSAMultidayBasis(){
        usaMultidayBasisInput.click();
        usaMultidayList.get(1).click();
        return this;
    }

    public DriversPage inputCanadianMultidayBasis(){
        canadianMultidayBasisInput.click();
        canadianMultidayList.get(1).click();
        return this;
    }

    public DriversPage inputHomeTerminalTimezone(){
        homeTerminalTimezoneInput.click();
        homeTerminalZoneList.first().click();
        return this;
    }

    public DriversPage inputElogAppMode(){
        eLogAppModeInput.click();
        eLogAppList.first().click();
        return this;
    }

    public DriversPage setTrueCheckBoxYardMove(){
        yardMoveCheckBox.setSelected(true);
        return this;
    }

    public DriversPage setTrueCheckBoxPersonalUse(){
        personalUseCheckBox.setSelected(true);
        return this;
    }

    public DriversPage setTrueCheckBoxRegainHoursAtMidnightCheckBox(){
        regainHoursAtMidnightCheckBox.setSelected(true);
        return this;
    }

    public DriversPage saveDriver(){
        saveBtn.click();
        return this;
    }

    public DriversPage cancelDriver(){
        cancelBtn.click();
        return this;
    }

    public DriversPage createNewDriver(){
        addNewDriverBtn.click();
        inputHOSProvider();

        int num = (int) (Math.random() * 100000);
        inputFirstName(num);
        inputLastName(num);
        inputEmail(num);
        inputLoginName(num);
        inputPass();
        inputConfirmPass();
        inputDriverLicenseNumber(num);
        inputLicenseState();
        inputUSAMultidayBasis();
        inputCanadianMultidayBasis();
        inputHomeTerminalTimezone();
        inputElogAppMode();
        setTrueCheckBoxYardMove();
        setTrueCheckBoxPersonalUse();
        setTrueCheckBoxRegainHoursAtMidnightCheckBox();

        saveDriver();
        addNewDriverBtn.waitUntil(Condition.exist, 10000);
        return this;
    }

}
