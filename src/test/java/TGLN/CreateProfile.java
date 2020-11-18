package TGLN;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;

public class CreateProfile extends BasePage {
    public CreateProfile(WebDriver driver) {
        super(driver);
    }

    /** Find profile name input */
    @FindBy(xpath = "//input[@name = 'profileName']")
    public WebElement nameInput;

    public void inputName(String name){
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    /** Find Server Timeout input*/
    @FindBy(xpath = "//input[@name = 'serverTimeout']")
    public WebElement serverTimeoutInput;

    public void inputServerTimeout(String timeout){
        serverTimeoutInput.clear();
        serverTimeoutInput.sendKeys(timeout);
    }

    /** Find LTE Timeout input */
    @FindBy(xpath = "//input[@name = 'lteTimeout']")
    public WebElement lteTimeoutInput;

    public void inputLteTimeout(String lte){
        lteTimeoutInput.clear();
        lteTimeoutInput.sendKeys(lte);
    }

    /** Find Sleep Seconds input */
    @FindBy(xpath = "//input[@name = 'sleepSeconds']")
    public WebElement sleepSecondsInput;

    public void inputSleepSeconds(String sleepSeconds){
        sleepSecondsInput.clear();
        sleepSecondsInput.sendKeys(sleepSeconds);
    }

    /** Find Read Sensors Interval input */
    @FindBy(xpath = "//input[@name = 'readSensorsInterval']")
    public WebElement readSensorsIntervalInput;

    public void inputReadSensorsInterval(String interval){
        readSensorsIntervalInput.clear();
        readSensorsIntervalInput.sendKeys(interval);
    }

    /** Find Read GPS Position Interval input*/
    @FindBy(xpath = "//input[@name = 'readPositionInterval']")
    public WebElement readGPSPositionIntervalInput;

    public void inputReadGPSPositionInterval(String interval){
        readGPSPositionIntervalInput.clear();
        readGPSPositionIntervalInput.sendKeys(interval);
    }

    /** Find Server Heartbeat Interval input*/
    @FindBy(xpath = "//input[@name = 'serverHeartbeatInterval']")
    public WebElement serverHeartbeatIntervalInput;

    public void inputServerHeartbeatInterval(String interval){
        serverHeartbeatIntervalInput.clear();
        serverHeartbeatIntervalInput.sendKeys(interval);
    }

    /** Find Threshold input*/
    @FindBy(xpath = "//input[@name = 'accAlertThreshold']")
    public WebElement thresholdInput;

    public void inputThreshold(String threshold){
        thresholdInput.clear();
        thresholdInput.sendKeys(threshold);
    }

    /** Find Duration input*/
    @FindBy(xpath = "//input[@name = 'accAlertDuration']")
    public WebElement durationInput;

    public void inputDuration(String duration){
        durationInput.clear();
        durationInput.sendKeys(duration);
    }

    /** Find GPS Sleep checkbox*/
    @FindBy(xpath = "//input[@id = 'sleep-gps-on']")
    public WebElement gpsSleepCheckbox;

    public void clickGpsSleepCheckbox(){
        waitToVisibilityOf(10,gpsSleepCheckbox);
        waitToBeClickable(10, gpsSleepCheckbox);
        gpsSleepCheckbox.click();
    }

    /** Find Always Awake mode checkbox*/
    @FindBy(xpath = "//input[@id = 'always-awake-mode']")
    public WebElement alwaysAwakeModeCheckbox;

    public void clickAlwaysAwakeModeCheckbox(){
        sleep(500);
        waitToVisibilityOf(10,alwaysAwakeModeCheckbox);
        waitToBeClickable(10, alwaysAwakeModeCheckbox);
        alwaysAwakeModeCheckbox.click();
    }

    /** Find Acceleration checkbox*/
    @FindBy(xpath = "//input[@id = 'acc-alert-enabled']")
    public WebElement accelerationCheckbox;

    public void clickAccelerationCheckbox(){
        sleep(500);
        waitToVisibilityOf(10,accelerationCheckbox);
        waitToBeClickable(10, accelerationCheckbox);
        accelerationCheckbox.click();
    }

    /** Find If Fully Charged*/
    @FindBy(xpath = "//*[contains(text(), 'hours')]")
    public WebElement ifFullyCharged;

    public String getValueIfFullyCharged(){
        return ifFullyCharged.getText();
    }

    /** Find equivalent to falling from ...*/
    @FindBy(xpath = "//*[contains(text(), 'Equivalent to falling from')]//span")
    public WebElement equivalentFalling;

    public String getEquivalentFalling(){
        return equivalentFalling.getText();
    }

    /** Find Button Save*/
    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    public WebElement btnSave;

    public void saveProfile(){
        btnSave.click();
    }

    /** Find Button Cancel*/
    @FindBy(xpath = "//button[contains(text(), 'Cancel')]")
    public WebElement btnCancel;

    public void cancelSavingProfile(){
        btnCancel.click();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Validation*/

    @FindBy(xpath = "//*[contains(text(), 'Value must be a positive and round number greater than or equal 10')][@class = 'text-danger p-absolute p-t-2 nowrap text-smaller']")
    public WebElement validationServerTimeout;

    @FindBy(xpath = "//*[contains(text(), 'Value must be a positive and round number greater than or equal 20')][@class = 'text-danger p-absolute p-t-2 nowrap text-smaller']")
    public WebElement validationLTETimeout;

    @FindBy(xpath = "//*[contains(text(), 'Value must be a positive and round number greater than or equal 63')][@class = 'text-danger p-absolute p-t-2 nowrap text-smaller']")
    public WebElement validationThresholdLower;

    @FindBy(xpath = "//*[contains(text(), 'Value must be a positive and round number less than or equal 8000')][@class = 'text-danger p-absolute p-t-2 nowrap text-smaller']")
    public WebElement validationThresholdUpper;

    @FindBy(xpath = "//*[contains(text(), 'Value must be a positive and round number')][@class = 'text-danger p-absolute p-t-2 nowrap text-smaller']")
    public WebElement validationThresholdUFractional;

    @FindBy(xpath = "//*[contains(text(), 'Value must be a positive and round number greater than or equal 160')][@class = 'text-danger p-absolute p-t-2 nowrap text-smaller']")
    public WebElement validationDurationLower;

    @FindBy(xpath = "//*[contains(text(), 'Value must be a positive and round number less than or equal 40800')][@class = 'text-danger p-absolute p-t-2 nowrap text-smaller']")
    public WebElement validationDurationUpper;

    @FindBy(xpath = "//*[contains(text(), 'Value must be a positive and round number')][@class = 'text-danger p-absolute p-t-2 nowrap text-smaller']")
    public WebElement validationDurationFractional;

    @FindBy(xpath = "//*[@name = 'readPositionInterval']//..//*[@class = 'text-danger p-absolute p-t-2 nowrap text-smaller'][contains(text(), 'Value must be a positive and round number')]")
    public WebElement validationReadGps;

    @FindBy(xpath = "//*[@name = 'readSensorsInterval']//..//*[@class = 'text-danger p-absolute p-t-2 nowrap text-smaller'][contains(text(), 'Value must be a positive and round number')]")
    public WebElement validationReadSensors;

    @FindBy(xpath = "//*[@name = 'serverHeartbeatInterval']//..//*[@class = 'text-danger p-absolute p-t-2 nowrap text-smaller'][contains(text(), 'Value must be a positive and round number')]")
    public WebElement validationServerHeartbeat;

    @FindBy(xpath = "//*[contains(text(), 'Value must be a positive and round number')][@class = 'text-danger p-absolute p-t-2 nowrap text-smaller']")
    public WebElement validationSleepSeconds;
}
