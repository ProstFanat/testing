package GPSDevices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import resources.AppConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;
import resources.AppConstants;

public class AddGPSDevice extends BasePage {
    public AddGPSDevice(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);

    /** Find Device type select*/
    @FindBy(xpath = "//label[text() = 'GPS Device Type ']//..//select")
    public WebElement deviceTypeInput;

    /** Find TrackEnsure type*/
    @FindBy(xpath = "//label[text() = 'GPS Device Type ']//..//option[@label = 'TrackEnsure GPS Device']")
    public WebElement selectTrackEnsure;

    /** Find Telitek type*/
    @FindBy(xpath = "//label[text() = 'GPS Device Type ']//..//option[@label = 'Telitek GPS Device']")
    public WebElement selectTelitek;

    public void inputTrackEnsureType(){
        deviceTypeInput.click();
        waitToVisibilityOf(10, selectTrackEnsure);
        selectTrackEnsure.click();
    }

    public void inputTelitekType(){
        deviceTypeInput.click();
        waitToVisibilityOf(10, selectTelitek);
        selectTelitek.click();
    }


    /** Find Device UID input*/
    @FindBy(xpath = "//label[text() = 'Device UID ']//..//input")
    public WebElement deviceUIDInput;

    public void inputDeviceUID(String uid){
        deviceUIDInput.sendKeys(uid);
    }

    /** Find Server input*/
    @FindBy(xpath = "//label[text() = 'Server ']//..//input")
    public WebElement serverInput;

    public void inputServer(String server){
        serverInput.sendKeys(server);

    }

    /** Find Server port input*/
    @FindBy(xpath = "//label[text() = 'Server Port ']//..//input")
    public WebElement portInput;

    public void inputPort(String port){
        portInput.sendKeys(port);
    }

    /** Find APN input*/
    @FindBy(xpath = "//label[text() = 'APN ']//..//input")
    public WebElement apnInput;

    public void inputAPN(String apn){
        apnInput.sendKeys(apn);
    }

    /** Find Usage Profile select*/
    @FindBy(xpath = "//*[@class = 'row profile-section-container']//select")
    public WebElement usageProfileInput;

    /** Find 1 profile*/
    @FindBy(xpath = "//option[@label = 'testTemp']")
    public WebElement select1Type;

    /** Find 2 profile */
    @FindBy(xpath = "//option[@label = '11']")
    public WebElement select2Type;

    public void input1Profile(){
        usageProfileInput.click();
        waitToVisibilityOf(10, select1Type);
        select1Type.click();
        sleep(500);
    }

    public void input2Profile(){
        usageProfileInput.click();
        waitToVisibilityOf(10, select2Type);
        select2Type.click();
        sleep(500);
    }

    /** Find Server Timeout value*/
    @FindBy(xpath = "//*[contains(text(), 'Server Timeout')]//strong")
    public WebElement serverTimeout;

    public String getServerTimeout(){
        return serverTimeout.getText();
    }

    /** Find LTE Timeout value*/
    @FindBy(xpath = "//*[contains(text(), 'LTE Timeout')]//strong")
    public WebElement lteTimeout;

    public String getLteTimeout(){
        return lteTimeout.getText();
    }

    /** Find Device Sleep Seconds value*/
    @FindBy(xpath = "//*[contains(text(), 'Device Sleep Seconds')]//strong")
    public WebElement deviceSleepSeconds;

    public String getDeviceSleepSeconds(){
        return deviceSleepSeconds.getText();
    }

    /** Find GPS Sleep value*/
    @FindBy(xpath = "//*[contains(text(), 'GPS Sleep')]//strong")
    public WebElement gpsSleep;

    public String getGpsSleep(){
        return gpsSleep.getText();
    }

    /** Find Motion detection while awake value*/
    @FindBy(xpath = "//*[contains(text(), 'Motion detection while awake')]//strong")
    public WebElement motionDetectionWhile;

    public String getMotionDetection(){
        return motionDetectionWhile.getText();
    }

    /** Find If Fully Charged value*/
    @FindBy(xpath = "//label[text() = 'If Fully Charged(4.7V):']//..//..//div[2]")
    public WebElement ifFullyCharged;

    public String getIfFullyCharged(){
        return ifFullyCharged.getText();
    }

    /** Find Notifications select*/
    @FindBy(xpath = "//select-notification-section//select")
    public WebElement notificationSelect;

    /** Find Add button*/
    @FindBy(xpath = "//*[text() = ' Add']")
    public WebElement btnAddNotification;

    /** Find Temperature 1 Notification*/
    @FindBy(xpath = "//*[@label = 'TEMPERATURE NOTIFICATIONS |  Temp. > 5 C;'][1]")
    public WebElement temperature1;

    public void selectTemperature1Notification(){
        notificationSelect.click();
        waitToVisibilityOf(10,temperature1);
        temperature1.click();
        btnAddNotification.click();
    }

    /** Find Temperature 2 Notification*/
    @FindBy(xpath = "//*[@label = 'TEMPERATURE NOTIFICATIONS |  Temp. > 5 C; Temp. < 0 C; Temp. = 3 C;'][1]")
    public WebElement temperature2;

    public void selectTemperature2Notification(){
        notificationSelect.click();
        waitToVisibilityOf(10,temperature2);
        temperature2.click();
        btnAddNotification.click();
    }

    /** Find Device Connectivity Notification*/
    @FindBy(xpath = "//*[@label = 'DEVICE CONNECTIVITY NOTIFICATIONS'][1]")
    public WebElement deviceConnectivity;

    public void selectDeviceConnectivityNotification(){
        notificationSelect.click();
        waitToVisibilityOf(10,deviceConnectivity);
        deviceConnectivity.click();
        btnAddNotification.click();
    }

    /** Find Voltage Notification*/
    @FindBy(xpath = "//*[@label = 'VOLTAGE NOTIFICATIONS |  Voltage < 233V'][1]")
    public WebElement voltage;

    public void selectVoltageNotification(){
        notificationSelect.click();
        waitToVisibilityOf(10,voltage);
        voltage.click();
        btnAddNotification.click();
    }

    /** Find Motion Notification*/
    @FindBy(xpath = "//*[@label = 'MOTION NOTIFICATIONS'][1]")
    public WebElement motion;

    public void selectMotionNotification(){
        notificationSelect.click();
        waitToVisibilityOf(10,motion);
        motion.click();
        btnAddNotification.click();
    }

    /** Find Device Error Notification*/
    @FindBy(xpath = "//*[@label = 'DEVICE ERROR NOTIFICATIONS'][1]")
    public WebElement deviceError;

    public void selectDeviceErrorNotification(){
        notificationSelect.click();
        waitToVisibilityOf(10,deviceError);
        deviceError.click();
        btnAddNotification.click();
    }

    /** Find Position Notification*/
    @FindBy(xpath = "//*[@label = 'POSITION NOTIFICATIONS |  > 10m'][1]")
    public WebElement position;

    public void selectPositionNotification(){
        notificationSelect.click();
        waitToVisibilityOf(10,position);
        position.click();
        btnAddNotification.click();
    }

    /** Remove Notification*/
    public void deleteNotification(int number){
        //*[contains(@ng-repeat, 'notification in')][1]//button
        driver.findElement(By.xpath("//*[contains(@ng-repeat, 'notification in')][" + number + "]//button")).click();
    }

    /** Find button Save device*/
    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    public WebElement btnSave;

    public void saveDevice(){
        actions.moveToElement(btnSave);
        btnSave.click();
    }

    /** Find button cancel*/
    @FindBy(xpath = "//button[text() = 'Cancel']")
    public WebElement btnCancel;

    public void cancelDevice(){
        actions.moveToElement(btnCancel);
        waitToVisibilityOf(10, btnCancel);
        btnCancel.click();
    }

    /** Find tab profile Management*/
    @FindBy(xpath = "//*[text() = 'Profile Management']")
    public WebElement tabProfileManagement;

    public void selectProfileTabManagement(){
        tabProfileManagement.click();
    }

    /** Find Create New Profile*/
    @FindBy(xpath = "//button[text() = 'Create New Profile']")
    public WebElement btnCreateNewProfile;

    public void createNewProfile(){
        waitToVisibilityOf(10, btnCreateNewProfile);
        btnCreateNewProfile.click();
    }

    /** Find tab profile usage*/
    @FindBy(xpath = "//*[text() = 'Usage Profile']")
    public WebElement tabUsageProfile;

    public void selectProfileTabUsage(){
        tabUsageProfile.click();
    }

    /** Find tab Notification Management*/
    @FindBy(xpath = "//*[contains(@class, 'nav-tabs')]//*[text() = 'Notification Management']")
    public WebElement tabNotificationManagement;

    public void selectNotificationTabManagement(){
        waitToBeClickable(10, tabNotificationManagement);
        tabNotificationManagement.click();
    }

    /** Find tab Notification*/
    @FindBy(xpath = "//*[contains(@class, 'nav-tabs')]//*[text() = 'Notifications']")
    public WebElement tabNotifications;

    public void selectNotificationsTab(){
        tabNotifications.click();
    }

    /** Find btn Create New Notification*/
    @FindBy(xpath = "//button[contains(text(), 'Create New Notification')]")
    public WebElement btnCreateNewNotification;

    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    public WebElement btnSaveNotification;

    public void saveNotification(){
        btnSaveNotification.click();
    }

    public void openCreateNotificationForm(){
        waitToVisibilityOf(10, btnCreateNewNotification);
        btnCreateNewNotification.click();
    }
}
