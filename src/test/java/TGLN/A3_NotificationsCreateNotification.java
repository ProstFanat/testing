package TGLN;

import FleetEvents.LogOut;
import GPSDevices.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import resources.AppConstants;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

;

public class A3_NotificationsCreateNotification {

    public static WebDriver driver;
    public static OpenGPSDevices open;
    public static BasePage basePage;
    public static LogOut logOut;
    public static TabDevices mainDevices;
    public static AddGPSDevice createDevice;
    public static Actions actions;
    public static AddTruckToDevice addTruck;
    public static TabNotification main;
    public static CreateNotifications create;

    @BeforeAll
    static void setup() {

        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        driver = getWebDriver();
        open = new OpenGPSDevices(driver);
        basePage = new BasePage(driver);
        logOut = new LogOut(driver);
        mainDevices = new TabDevices(driver);
        main = new TabNotification(driver);
        create = new CreateNotifications(driver);
        actions = new Actions(driver);
        addTruck = new AddTruckToDevice(driver);
        createDevice = new AddGPSDevice(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        open.openGPSDevices();
    }

    @BeforeEach
    void beforeTest(){
        mainDevices.openNotificationsTab();
        main.createNotification();
    }

    @Test
    public void testEmpty(){
        create.saveNotification();
        Assertions.assertFalse(create.btnSaveNotification.isEnabled());
        create.cancelSavingNotification();
    }

    @Test
    public void testWithType(){
        create.selectTemperature();
        create.saveNotification();
        Assertions.assertFalse(create.btnSaveNotification.isEnabled());
        create.cancelSavingNotification();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Test of temperature*/

    @Test
    public void testTempInputTextToValue(){
        create.selectTemperature();
        create.inputValueTemp1("testtesttest");
        if(driver.findElement(By.xpath("//*[contains(text(), 'Value is not valid')]")).isDisplayed()){
            Assertions.assertFalse(create.btnSaveNotification.isEnabled());
        } else {
            Assertions.assertTrue(false);
        }
        create.cancelSavingNotification();
    }

    @Test
    public void testTempWith1Condition(){
        create.selectTemperature();
        create.selectBiggerForTemp1();
        create.inputValueTemp1("12");
        create.selectCelsiusForTemp1();
        create.selectEmailNotification();
        int number = (int) (Math.random() * 1000000000);
        create.inputEmail("test" + number + "@mail.com");
        create.saveNotification();
        main.filterTableNotification("TEMPERATURE");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Email: test" + number + "@mail.com; ']//..//..//..//*[@role = 'gridcell'][2]//div[contains(text(), 'Temp. > 12 C')]"));
        main.changeStatus("Email: test" + number + "@mail.com;");
    }

    @Test
    public void testTempWithSameConditions(){
        create.selectTemperature();
        create.selectBiggerForTemp1();
        create.addCondition();
        create.selectBiggerForTemp2();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'This operator is already in use']"));
        create.cancelSavingNotification();
    }

    @Test
    public void testTempAddAndDelCondition(){
        create.selectTemperature();
        create.addCondition();
        create.deleteSecondCondition();
        Assertions.assertFalse(basePage.isElementDisplayed(create.valueTemp2));
        create.cancelSavingNotification();
    }

    @Test
    public void testTempAddAllUnits(){
        create.selectTemperature();
        create.addCondition();
        create.addCondition();
        create.selectCelsiusForTemp1();
        create.selectKelvinForTemp2();
        create.selectFahrenheitForTemp3();
        Assertions.assertFalse(create.btnSaveNotification.isEnabled());
        create.cancelSavingNotification();
    }

    @Test
    public void testTempWithoutNotifyDetails(){
        create.selectTemperature();
        create.selectBiggerForTemp1();
        create.inputValueTemp1("12");
        create.selectCelsiusForTemp1();
        create.saveNotification();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Please, pick at least one method of notification']"));
        create.cancelSavingNotification();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Test of notify details*/

    @Test
    public void testNotifyAddAndDel(){
        create.selectMotion();
        create.selectEmailNotification();
        create.deleteEmail();
        Assertions.assertFalse(basePage.isElementDisplayed(create.emailBtnDelete));
        create.cancelSavingNotification();
    }

    @Test
    public void testNotifyAdd2EmailsInToOneInput(){
        int number = (int) (Math.random() * 100000000);
        create.selectMotion();
        create.selectEmailNotification();
        create.inputEmail("test" + number + "@mail.com, test" + (number + 1) + "@mail.com");
        create.saveNotification();
        main.filterTableNotification("MOTION");
        main.btnAdvancedSearch.click();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Email: test" + number + "@mail.com, test" + (number + 1) + "@mail.com; ']"));
        main.changeStatus("Email: test" + number + "@mail.com, test" + (number + 1) + "@mail.com;");
    }

    @Test
    public void testNotifyAdd2SmsInToOneInput(){
        int number = (int) (Math.random() * 100000000);
        create.selectMotion();
        create.selectSmsNotification();
        create.inputSMS(number + ", " + (number + 1));
        create.saveNotification();
        main.filterTableNotification("MOTION");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'SMS: " + number + ", " + (number + 1) + "; ']"));
        main.changeStatus("SMS: " + number + ", " + (number + 1) + ";");
    }

    @Test
    public void testNotifyAdd2VoiceInToOneInput(){
        int number = (int) (Math.random() * 100000000);
        create.selectMotion();
        create.selectVoiceNotification();
        create.inputVoice(number + ", " + (number + 1));
        create.saveNotification();
        main.filterTableNotification("MOTION");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Voice Message: " + number + ", " + (number + 1) + "; ']"));
        main.changeStatus("Voice Message: " + number + ", " + (number + 1) + ";");
    }

    @Test
    public void testNotifyAddZeroToDoNotRepeatFor(){
        create.selectMotion();
        create.selectEmailNotification();
        create.inputEmail("test@mail.com");
        create.emailDoNotRepeatFor.clear();
        create.inputEmailDoNotRepeatFor("0");
        Assertions.assertFalse(create.btnSaveNotification.isEnabled());
        create.cancelSavingNotification();
    }

    @Test
    public void testNotifyAddNegativeNumberToDoNotRepeatFor(){
        create.selectMotion();
        create.selectEmailNotification();
        create.inputEmail("test@mail.com");
        create.emailDoNotRepeatFor.clear();
        create.inputEmailDoNotRepeatFor("-1");
        Assertions.assertFalse(create.btnSaveNotification.isEnabled());
        create.cancelSavingNotification();
    }

    @Test
    public void testNotifyAddFractionalNumberToDoNotRepeatFor(){
        create.selectMotion();
        create.selectEmailNotification();
        create.inputEmail("test@mail.com");
        create.emailDoNotRepeatFor.clear();
        create.inputEmailDoNotRepeatFor("30.1");
        Assertions.assertFalse(create.btnSaveNotification.isEnabled());
        create.cancelSavingNotification();
    }

    @Test
    public void testNotifyWithEmailSMSAndVoice(){
        create.selectMotion();
        create.selectSmsNotification();
        create.selectEmailNotification();
        create.selectVoiceNotification();
        int number = (int) (Math.random() * 100000000);
        create.inputEmail("test" + number + "@mail.com");
        create.inputSMS( "" + number);
        create.inputVoice(number + "");
        create.saveNotification();
        main.filterTableNotification("MOTION");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'SMS: " + number + "; Email: test" + number + "@mail.com; Voice Message: " + number + "; ']"));
        main.changeStatus("SMS: " + number + "; Email: test" + number + "@mail.com; Voice Message: " + number + ";");
    }

    @Test
    public void testNotifyAddSameTypes(){
        create.selectMotion();
        create.selectEmailNotification();
        create.selectEmailNotification();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Notify Type is already in use!']"));
        create.cancelSavingNotification();
    }

    @Test
    public void testWithSemicolonEmail(){
        create.selectMotion();
        create.selectEmailNotification();
        int number = (int) (Math.random() * 100000000);
        create.inputEmail("test" + number + "@mail.com;");
        Assertions.assertFalse(create.btnSaveNotification.isEnabled());
        create.cancelSavingNotification();
    }

    @Test
    public void testWithSemicolonVoice(){
        create.selectMotion();
        create.selectVoiceNotification();
        int number = (int) (Math.random() * 100000000);
        create.inputVoice(number + ";");
        Assertions.assertFalse(create.btnSaveNotification.isEnabled());
        create.cancelSavingNotification();
    }

    @Test
    public void testWithSemicolonSms(){
        create.selectMotion();
        create.selectSmsNotification();
        int number = (int) (Math.random() * 100000000);
        create.inputSMS(number + ";");
        Assertions.assertFalse(create.btnSaveNotification.isEnabled());
        create.cancelSavingNotification();
    }

    @Test
    public void testWithDotVoice(){
        create.selectMotion();
        create.selectVoiceNotification();
        int number = (int) (Math.random() * 100000000);
        create.inputVoice(number + ".");
        Assertions.assertFalse(create.btnSaveNotification.isEnabled());
        create.cancelSavingNotification();
    }

    @Test
    public void testWithDotSms(){
        create.selectMotion();
        create.selectSmsNotification();
        int number = (int) (Math.random() * 100000000);
        create.inputSMS(number + ".");
        Assertions.assertFalse(create.btnSaveNotification.isEnabled());
        create.cancelSavingNotification();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Test Voltage*/

    @Test
    public void testVoltageWithZero(){
        create.selectVoltage();
        create.inputVolts("0");
        Assertions.assertFalse(create.btnSaveNotification.isEnabled());
        create.cancelSavingNotification();
    }

    @Test
    public void testVoltageWithNegative(){
        create.selectVoltage();
        create.inputVolts("-1");
        Assertions.assertFalse(create.btnSaveNotification.isEnabled());
        create.cancelSavingNotification();
    }

    @Test
    public void testVoltageWithFractionalNumber(){
        int number = (int) (Math.random() * 100000000);
        create.selectVoltage();
        create.inputVolts("30.1");
        create.selectEmailNotification();
        create.inputEmail("test" + number + "@mail.com");
        create.saveNotification();
        main.filterTableNotification("VOLTAGE");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Email: test" + number + "@mail.com; ']//..//..//..//*[@role = 'gridcell'][2]//div[contains(text(), 'Voltage < 30.1V')]"));
        main.changeStatus("Email: test" + number + "@mail.com;");
    }

    @Test
    public void testVoltageWithPositiveNumber(){
        int number = (int) (Math.random() * 100000000);
        create.selectVoltage();
        create.inputVolts("30");
        create.selectEmailNotification();
        create.inputEmail("test" + number + "@mail.com");
        create.saveNotification();
        main.filterTableNotification("VOLTAGE");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Email: test" + number + "@mail.com; ']//..//..//..//*[@role = 'gridcell'][2]//div[contains(text(), 'Voltage < 30V')]"));
        main.changeStatus("Email: test" + number + "@mail.com;");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Test Position*/

    @Test
    public void testPositionWithZero(){
        create.selectPosition();
        create.inputPosition("0");
        Assertions.assertFalse(create.btnSaveNotification.isEnabled());
        create.cancelSavingNotification();
    }

    @Test
    public void testPositionWithNegative(){
        create.selectPosition();
        create.inputPosition("-1");
        Assertions.assertFalse(create.btnSaveNotification.isEnabled());
        create.cancelSavingNotification();
    }

    @Test
    public void testPositionWithFractionalNumber(){
        int number = (int) (Math.random() * 100000000);
        create.selectPosition();
        create.inputPosition("30.1");
        create.selectEmailNotification();
        create.inputEmail("test" + number + "@mail.com");
        create.saveNotification();
        main.filterTableNotification("POSITION");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Email: test" + number + "@mail.com; ']//..//..//..//*[@role = 'gridcell'][2]//div[contains(text(), '> 30.1m')]"));
        main.changeStatus("Email: test" + number + "@mail.com;");
    }

    @Test
    public void testPositionWithPositiveNumber(){
        int number = (int) (Math.random() * 100000000);
        create.selectPosition();
        create.inputPosition("30");
        create.selectEmailNotification();
        create.inputEmail("test" + number + "@mail.com");
        create.saveNotification();
        main.filterTableNotification("POSITION");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Email: test" + number + "@mail.com; ']//..//..//..//*[@role = 'gridcell'][2]//div[contains(text(), '> 30m')]"));
        main.changeStatus("Email: test" + number + "@mail.com;");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void testCreateDeviceErrorNotification(){
        int number = (int) (Math.random() * 100000000);
        create.selectDeviceError();
        create.selectEmailNotification();
        create.inputEmail("test" + number + "@mail.com");
        create.saveNotification();
        main.filterTableNotification("DEVICE ERROR");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Email: test" + number + "@mail.com; ']"));
        main.changeStatus("Email: test" + number + "@mail.com;");
    }

    @Test
    public void testCreateDeviceConnectivityNotification(){
        int number = (int) (Math.random() * 100000000);
        create.selectDeviceConnectivity();
        create.selectEmailNotification();
        create.inputEmail("test" + number + "@mail.com");
        create.saveNotification();
        main.filterTableNotification("DEVICE CONNECTIVITY");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Email: test" + number + "@mail.com; ']"));
        main.changeStatus("Email: test" + number + "@mail.com;");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Tests of create from tab Devices*/

    @Test
    public void testCreateDeviceConnectivityFromDevices(){
        create.cancelSavingNotification();
        mainDevices.openDevicesTab();
        mainDevices.openNewDeviceForm();
        createDevice.selectNotificationTabManagement();
        createDevice.openCreateNotificationForm();
        int number = (int) (Math.random() * 100000000);
        create.selectDeviceConnectivity();
        create.selectEmailNotification();
        create.inputEmail("test" + number + "@mail.com");
        createDevice.saveNotification();
        createDevice.selectNotificationsTab();
        createDevice.cancelDevice();
        mainDevices.openNotificationsTab();
        main.filterTableNotification("DEVICE CONNECTIVITY");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Email: test" + number + "@mail.com; ']"));
        main.changeStatus("Email: test" + number + "@mail.com;");
    }

    @Test
    public void testCreateDeviceErrorFromDevices(){
        create.cancelSavingNotification();
        mainDevices.openDevicesTab();
        mainDevices.openNewDeviceForm();
        createDevice.selectNotificationTabManagement();
        createDevice.openCreateNotificationForm();
        int number = (int) (Math.random() * 100000000);
        create.selectDeviceError();
        create.selectEmailNotification();
        create.inputEmail("test" + number + "@mail.com");
        createDevice.saveNotification();
        createDevice.selectNotificationsTab();
        createDevice.cancelDevice();
        mainDevices.openNotificationsTab();
        main.filterTableNotification("DEVICE ERROR");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Email: test" + number + "@mail.com; ']"));
        main.changeStatus("Email: test" + number + "@mail.com;");
    }

    @Test
    public void testCreateMotionFromDevices(){
        create.cancelSavingNotification();
        mainDevices.openDevicesTab();
        mainDevices.openNewDeviceForm();
        createDevice.selectNotificationTabManagement();
        createDevice.openCreateNotificationForm();
        int number = (int) (Math.random() * 100000000);
        create.selectMotion();
        create.selectEmailNotification();
        create.inputEmail("test" + number + "@mail.com");
        createDevice.saveNotification();
        createDevice.selectNotificationsTab();
        createDevice.cancelDevice();
        mainDevices.openNotificationsTab();
        main.filterTableNotification("MOTION");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Email: test" + number + "@mail.com; ']"));
        main.changeStatus("Email: test" + number + "@mail.com;");
    }

    @Test
    public void testCreatePositionFromDevices(){
        create.cancelSavingNotification();
        mainDevices.openDevicesTab();
        mainDevices.openNewDeviceForm();
        createDevice.selectNotificationTabManagement();
        createDevice.openCreateNotificationForm();
        int number = (int) (Math.random() * 100000000);
        create.selectPosition();
        create.inputPosition("30");
        create.selectEmailNotification();
        create.inputEmail("test" + number + "@mail.com");
        createDevice.saveNotification();
        createDevice.selectNotificationsTab();
        createDevice.cancelDevice();
        mainDevices.openNotificationsTab();
        main.filterTableNotification("POSITION");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Email: test" + number + "@mail.com; ']//..//..//..//*[@role = 'gridcell'][2]//div[contains(text(), '> 30m')]"));
        main.changeStatus("Email: test" + number + "@mail.com;");
    }

    @Test
    public void testCreateVoltageFromDevices(){
        create.cancelSavingNotification();
        mainDevices.openDevicesTab();
        mainDevices.openNewDeviceForm();
        createDevice.selectNotificationTabManagement();
        createDevice.openCreateNotificationForm();
        int number = (int) (Math.random() * 100000000);
        create.selectVoltage();
        create.inputVolts("30");
        create.selectEmailNotification();
        create.inputEmail("test" + number + "@mail.com");
        createDevice.saveNotification();
        createDevice.selectNotificationsTab();
        createDevice.cancelDevice();
        mainDevices.openNotificationsTab();
        main.filterTableNotification("VOLTAGE");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Email: test" + number + "@mail.com; ']//..//..//..//*[@role = 'gridcell'][2]//div[contains(text(), 'Voltage < 30V')]"));
        main.changeStatus("Email: test" + number + "@mail.com;");
    }

    @Test
    public void testCreateTemperatureFromDevices(){
        create.cancelSavingNotification();
        mainDevices.openDevicesTab();
        mainDevices.openNewDeviceForm();
        createDevice.selectNotificationTabManagement();
        createDevice.openCreateNotificationForm();
        int number = (int) (Math.random() * 100000000);
        create.selectTemperature();
        create.selectEqualsForTemp1();
        create.inputValueTemp1("12");
        create.selectCelsiusForTemp1();
        create.selectEmailNotification();
        create.inputEmail("test" + number + "@mail.com");
        createDevice.saveNotification();
        createDevice.selectNotificationsTab();
        createDevice.cancelDevice();
        mainDevices.openNotificationsTab();
        main.filterTableNotification("TEMPERATURE");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Email: test" + number + "@mail.com; ']//..//..//..//*[@role = 'gridcell'][2]//div[contains(text(), 'Temp. = 12 C')]"));
        main.changeStatus("Email: test" + number + "@mail.com;");
    }

//    @Test
//    public void testChangeStatus(){
//        create.cancelSavingNotification();
//        main.filterTableNotification("VOLTAGE");
//        main.changeStatus("Email: testAuto@mail.com;");
//    }

    @AfterEach
    void beforeTests(){
        driver.navigate().refresh();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
