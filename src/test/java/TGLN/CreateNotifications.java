package TGLN;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;

public class CreateNotifications extends BasePage {
    public CreateNotifications(WebDriver driver) {
        super(driver);
    }

    /** Find Event Type input*/
    @FindBy(xpath = "//select[@ng-model = 'vm.notification.eventType']")
    public WebElement eventTypeInput;

    /** Find Temperature type*/
    @FindBy(xpath = "//option[@label = 'TEMPERATURE NOTIFICATIONS']")
    public WebElement temperatureType;

    /** Find Motion type*/
    @FindBy(xpath = "//option[@label = 'MOTION NOTIFICATIONS']")
    public WebElement motionType;

    /** Find Voltage type*/
    @FindBy(xpath = "//option[@label = 'VOLTAGE NOTIFICATIONS']")
    public WebElement voltageType;

    /** Find Position type*/
    @FindBy(xpath = "//option[@label = 'POSITION NOTIFICATIONS']")
    public WebElement positionType;

    /** Find Device Error type*/
    @FindBy(xpath = "//option[@label = 'DEVICE ERROR NOTIFICATIONS']")
    public WebElement deviceErrorType;

    /** Find Device Connectivity type*/
    @FindBy(xpath = "//option[@label = 'DEVICE CONNECTIVITY NOTIFICATIONS']")
    public WebElement deviceConnectivityType;

    /** Find empty type*/
    @FindBy(xpath = "//option[@value = '?']")
    public WebElement emptyType;

    public void selectTemperature(){
        waitToVisibilityOf(10, eventTypeInput);
        eventTypeInput.click();
        waitToVisibilityOf(10, temperatureType);
        temperatureType.click();
    }

    public void selectMotion(){
        waitToVisibilityOf(10, eventTypeInput);
        eventTypeInput.click();
        waitToVisibilityOf(10, motionType);
        motionType.click();
    }

    public void selectVoltage(){
        waitToVisibilityOf(10, eventTypeInput);
        eventTypeInput.click();
        waitToVisibilityOf(10, voltageType);
        voltageType.click();
    }

    public void selectPosition(){
        waitToVisibilityOf(10, eventTypeInput);
        eventTypeInput.click();
        waitToVisibilityOf(10, positionType);
        positionType.click();
    }

    public void selectDeviceError(){
        waitToVisibilityOf(10, eventTypeInput);
        eventTypeInput.click();
        waitToVisibilityOf(10, deviceErrorType);
        deviceErrorType.click();
    }

    public void selectDeviceConnectivity(){
        waitToVisibilityOf(10, eventTypeInput);
        eventTypeInput.click();
        waitToVisibilityOf(10, deviceConnectivityType);
        deviceConnectivityType.click();
    }

    public void selectEmpty(){
        eventTypeInput.click();
        waitToVisibilityOf(10, emptyType);
        emptyType.click();
    }

    /** Conditions for Temperature*/

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** All for First temp*/
    @FindBy(xpath = "//select[@name = 'conditionOperator0']")
    public WebElement operatorTemp1;

    @FindBy(xpath = "//select[@name = 'conditionOperator0']//option[@value = '=']")
    public WebElement operatorTemp1Equals;

    @FindBy(xpath = "//select[@name = 'conditionOperator0']//option[@value = '>']")
    public WebElement operatorTemp1Bigger;

    @FindBy(xpath = "//select[@name = 'conditionOperator0']//option[@value = '<']")
    public WebElement operatorTemp1Smaller;

    public void selectEqualsForTemp1(){
        operatorTemp1.click();
        waitToVisibilityOf(10, operatorTemp1Equals);
        operatorTemp1Equals.click();
    }

    public void selectBiggerForTemp1(){
        operatorTemp1.click();
        waitToVisibilityOf(10, operatorTemp1Bigger);
        operatorTemp1Bigger.click();
    }

    public void selectSmallerForTemp1(){
        operatorTemp1.click();
        waitToVisibilityOf(10, operatorTemp1Smaller);
        operatorTemp1Smaller.click();
    }

    @FindBy(xpath = "//input[@name = 'conditionValue0']")
    public WebElement valueTemp1;

    public void inputValueTemp1(String temp){
        valueTemp1.sendKeys(temp);
    }

    @FindBy(xpath = "//select[@name = 'conditionUnit0']")
    public WebElement unitTemp1;

    @FindBy(xpath = "//select[@name = 'conditionUnit0']//option[@value = 'C']")
    public WebElement operatorTemp1Celsius;

    @FindBy(xpath = "//select[@name = 'conditionUnit0']//option[@value = 'F']")
    public WebElement operatorTemp1Fahrenheit;

    @FindBy(xpath = "//select[@name = 'conditionUnit0']//option[@value = 'Ke']")
    public WebElement operatorTemp1Kelvin;

    public void selectCelsiusForTemp1(){
        valueTemp1.click();
        waitToVisibilityOf(10, operatorTemp1Celsius);
        operatorTemp1Celsius.click();
    }

    public void selectFahrenheitForTemp1(){
        valueTemp1.click();
        waitToVisibilityOf(10, operatorTemp1Fahrenheit);
        operatorTemp1Fahrenheit.click();
    }

    public void selectKelvinForTemp1(){
        valueTemp1.click();
        waitToVisibilityOf(10, operatorTemp1Kelvin);
        operatorTemp1Kelvin.click();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** All for Second temp*/
    @FindBy(xpath = "//select[@name = 'conditionOperator1']")
    public WebElement operatorTemp2;

    @FindBy(xpath = "//select[@name = 'conditionOperator1']//option[@value = '=']")
    public WebElement operatorTemp2Equals;

    @FindBy(xpath = "//select[@name = 'conditionOperator1']//option[@value = '>']")
    public WebElement operatorTemp2Bigger;

    @FindBy(xpath = "//select[@name = 'conditionOperator1']//option[@value = '<']")
    public WebElement operatorTemp2Smaller;

    public void selectEqualsForTemp2(){
        operatorTemp2.click();
        waitToVisibilityOf(10, operatorTemp2Equals);
        operatorTemp2Equals.click();
    }

    public void selectBiggerForTemp2(){
        operatorTemp2.click();
        waitToVisibilityOf(10, operatorTemp2Bigger);
        operatorTemp2Bigger.click();
    }

    public void selectSmallerForTemp2(){
        operatorTemp2.click();
        waitToVisibilityOf(10, operatorTemp2Smaller);
        operatorTemp2Smaller.click();
    }

    @FindBy(xpath = "//input[@name = 'conditionValue1']")
    public WebElement valueTemp2;

    public void inputValueTemp2(String temp){
        valueTemp2.sendKeys(temp);
    }

    @FindBy(xpath = "//select[@name = 'conditionUnit1']")
    public WebElement unitTemp2;

    @FindBy(xpath = "//select[@name = 'conditionUnit1']//option[@value = 'C']")
    public WebElement operatorTemp2Celsius;

    @FindBy(xpath = "//select[@name = 'conditionUnit1']//option[@value = 'F']")
    public WebElement operatorTemp2Fahrenheit;

    @FindBy(xpath = "//select[@name = 'conditionUnit1']//option[@value = 'K']")
    public WebElement operatorTemp2Kelvin;

    public void selectCelsiusForTemp2(){
        unitTemp2.click();
        waitToVisibilityOf(10, operatorTemp2Celsius);
        operatorTemp2Celsius.click();
    }

    public void selectFahrenheitForTemp2(){
        unitTemp2.click();
        waitToVisibilityOf(10, operatorTemp2Fahrenheit);
        operatorTemp2Fahrenheit.click();
    }

    public void selectKelvinForTemp2(){
        unitTemp2.click();
        waitToVisibilityOf(10, operatorTemp2Kelvin);
        operatorTemp2Kelvin.click();
    }

    @FindBy(xpath = "//*[@ng-repeat = 'condition in vm.notification.conditionTemp'][2]//*[@ng-click = 'vm.removeObjFromConditionArr($index)']")
    public WebElement btnDeleteTemp2;

    public void deleteSecondCondition(){
        btnDeleteTemp2.click();
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** All for Third temp*/
    @FindBy(xpath = "//select[@name = 'conditionOperator2']")
    public WebElement operatorTemp3;

    @FindBy(xpath = "//select[@name = 'conditionOperator2']//option[@value = '=']")
    public WebElement operatorTemp3Equals;

    @FindBy(xpath = "//select[@name = 'conditionOperator2']//option[@value = '>']")
    public WebElement operatorTemp3Bigger;

    @FindBy(xpath = "//select[@name = 'conditionOperator2']//option[@value = '<']")
    public WebElement operatorTemp3Smaller;

    public void selectEqualsForTemp3(){
        operatorTemp3.click();
        waitToVisibilityOf(10, operatorTemp3Equals);
        operatorTemp3Equals.click();
    }

    public void selectBiggerForTemp3(){
        operatorTemp3.click();
        waitToVisibilityOf(10, operatorTemp3Bigger);
        operatorTemp3Bigger.click();
    }

    public void selectSmallerForTemp3(){
        operatorTemp3.click();
        waitToVisibilityOf(10, operatorTemp3Smaller);
        operatorTemp3Smaller.click();
    }

    @FindBy(xpath = "//input[@name = 'conditionValue2']")
    public WebElement valueTemp3;

    public void inputValueTemp3(String temp){
        valueTemp3.sendKeys(temp);
    }

    @FindBy(xpath = "//select[@name = 'conditionUnit2']")
    public WebElement unitTemp3;

    @FindBy(xpath = "//select[@name = 'conditionUnit2']//option[@value = 'C']")
    public WebElement operatorTemp3Celsius;

    @FindBy(xpath = "//select[@name = 'conditionUnit2']//option[@value = 'F']")
    public WebElement operatorTemp3Fahrenheit;

    @FindBy(xpath = "//select[@name = 'conditionUnit2']//option[@value = 'Ke']")
    public WebElement operatorTemp3Kelvin;

    public void selectCelsiusForTemp3(){
        unitTemp3.click();
        waitToVisibilityOf(10, operatorTemp3Celsius);
        operatorTemp3Celsius.click();
    }

    public void selectFahrenheitForTemp3(){
        unitTemp3.click();
        waitToVisibilityOf(10, operatorTemp3Fahrenheit);
        operatorTemp3Fahrenheit.click();
    }

    public void selectKelvinForTemp3(){
        unitTemp3.click();
        waitToVisibilityOf(10, operatorTemp3Kelvin);
        operatorTemp3Kelvin.click();
    }

    @FindBy(xpath = "//*[@ng-repeat = 'condition in vm.notification.conditionTemp'][3]//*[@ng-click = 'vm.removeObjFromConditionArr($index)']")
    public WebElement btnDeleteTemp3;

    public void deleteThirdCondition(){
        btnDeleteTemp3.click();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** Working With Voltage Conditions*/

    @FindBy(xpath = "//input[@name = 'lowVoltageThreshold']")
    public WebElement voltsInput;

    public void inputVolts(String volt){
        voltsInput.sendKeys(volt);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** Working With Position Conditions*/

    @FindBy(xpath = "//input[@name = 'distanceThreshold']")
    public WebElement positionInput;

    public void inputPosition(String volt){
        positionInput.sendKeys(volt);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /** Notify Details*/

    @FindBy(xpath = "//select[@ng-model = 'vm.notifyType']")
    public WebElement selectTypeOfNotification;

    @FindBy(xpath = "//option[@label = 'Email']")
    public WebElement emailNotification;

    @FindBy(xpath = "//option[@label = 'SMS']")
    public WebElement smsNotification;

    @FindBy(xpath = "//option[@label = 'Voice Message']")
    public WebElement voiceNotification;

    @FindBy(xpath = "//button[@ng-click = 'vm.selectNotifyType(vm.notifyType)']")
    public WebElement btnAddNotification;

    public void selectEmailNotification(){
        selectTypeOfNotification.click();
        waitToVisibilityOf(10, emailNotification);
        emailNotification.click();
        btnAddNotification.click();
    }

    public void selectSmsNotification(){
        selectTypeOfNotification.click();
        waitToVisibilityOf(10, smsNotification);
        smsNotification.click();
        btnAddNotification.click();
    }

    public void selectVoiceNotification(){
        selectTypeOfNotification.click();
        waitToVisibilityOf(10, voiceNotification);
        voiceNotification.click();
        btnAddNotification.click();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Email */
    @FindBy(xpath = "//label[text() = 'Email']//..//input")
    public WebElement emailInput;

    @FindBy(xpath = "//label[text() = 'Email']//..//..//..//..//..//input[@type = 'number']")
    public WebElement emailDoNotRepeatFor;

    @FindBy(xpath = "//label[text() = 'Email']//..//..//..//..//..//*[@ng-click = 'vm.removeObjFromNotifyDetails($index)']")
    public WebElement emailBtnDelete;

    public void inputEmail(String email){
        emailInput.sendKeys(email);
    }

    public void inputEmailDoNotRepeatFor(String time){
        emailDoNotRepeatFor.sendKeys(time);
    }

    public void deleteEmail(){
        emailBtnDelete.click();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** SMS */
    @FindBy(xpath = "//label[text() = 'SMS']//..//input")
    public WebElement smsInput;

    @FindBy(xpath = "//label[text() = 'SMS']//..//..//..//..//..//input[@type = 'number']")
    public WebElement smsDoNotRepeatFor;

    @FindBy(xpath = "//label[text() = 'SMS']//..//..//..//..//..//*[@ng-click = 'vm.removeObjFromNotifyDetails($index)']")
    public WebElement smsBtnDelete;

    public void inputSMS(String number){
        smsInput.sendKeys(number);
    }

    public void inputSMSDoNotRepeatFor(String time){
        smsDoNotRepeatFor.sendKeys(time);
    }

    public void deleteSMS(){
        smsBtnDelete.click();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Voice Message */
    @FindBy(xpath = "//label[text() = 'Voice Message']//..//input")
    public WebElement voiceInput;

    @FindBy(xpath = "//label[text() = 'Voice Message']//..//..//..//..//..//input[@type = 'number']")
    public WebElement voiceDoNotRepeatFor;

    @FindBy(xpath = "//label[text() = 'Voice Message']//..//..//..//..//..//*[@ng-click = 'vm.removeObjFromNotifyDetails($index)']")
    public WebElement voiceBtnDelete;

    public void inputVoice(String number){
       voiceInput.sendKeys(number);
    }

    public void inputVoiceDoNotRepeatFor(String time){
        voiceDoNotRepeatFor.sendKeys(time);
    }

    public void deleteVoice(){
        voiceBtnDelete.click();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FindBy(xpath = "//button[text() = 'Save']")
    public WebElement btnSaveNotification;

    @FindBy(xpath = "//button[text() = 'Cancel']")
    public WebElement btnCancelSavingNotification;

    public void saveNotification(){
        btnSaveNotification.click();
    }

    public void cancelSavingNotification(){
        btnCancelSavingNotification.click();
    }

    /** Find btn add condition*/
    @FindBy(xpath = "//*[text() = 'Add']")
    public WebElement btnAddCondition;

    public void addCondition(){
        btnAddCondition.click();
    }

}
