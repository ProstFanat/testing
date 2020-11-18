package TGLN.test;

import TGLN.AddGPSDevice;
import TGLN.TabDevices;
import TGLN.OpenGPSDevices;
import fleetEvents.fleet.*;
import fleetEvents.fleet.resources.ConfPropertiesFleet;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DevicesCreateDeviceTrackEnsure {
    public static WebDriver driver;
    public static OpenGPSDevices open;
    public static BasePage basePage;
    public static LogOut logOut;
    public static TabDevices main;
    public static AddGPSDevice createDevice;
    private static int numberForUID;
    public static Actions actions;

    @BeforeClass
    public static void setup() {
//        //определение пути до драйвера и его настройка
//        System.setProperty("webdriver.chrome.driver", ConfPropertiesFleet.getProperty("chromedriver"));
//        //создание экземпляра драйвера
//        driver = new ChromeDriver();
        open("http://localhost:8080/TrackEnsure/login.do");
        driver = getWebDriver();
        open = new OpenGPSDevices(driver);
        basePage = new BasePage(driver);
        logOut = new LogOut(driver);
        main = new TabDevices(driver);
        actions = new Actions(driver);
        numberForUID = (int) (Math.random() * 1000000000);
        createDevice = new AddGPSDevice(driver);
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/TrackEnsure/login.do");
        open.openGPSDevices();
    }

    @Before
    public void before(){
        main.openNewDeviceForm();
    }

    @Test
    public void testEmptyAll() {
        createDevice.deviceUIDInput.clear();
        createDevice.serverInput.clear();
        createDevice.portInput.clear();
        createDevice.apnInput.clear();
        Assert.assertFalse(createDevice.btnSave.isEnabled());
        createDevice.cancelDevice();
    }

    @Test
    public void testOnlyWithDeviceUID() {
        int temp = (int) (Math.random() * 1000000);
        createDevice.inputDeviceUID("autoTest" + temp);
        createDevice.serverInput.clear();
        createDevice.portInput.clear();
        createDevice.apnInput.clear();
        Assert.assertFalse(createDevice.btnSave.isEnabled());
        createDevice.cancelDevice();
    }

    @Test
    public void testWithDeviceUIDAndServer() {
        int temp = (int) (Math.random() * 1000000);
        createDevice.inputDeviceUID("autoTest" + temp);
        createDevice.portInput.clear();
        createDevice.apnInput.clear();
        Assert.assertFalse(createDevice.btnSave.isEnabled());
        createDevice.cancelDevice();
    }

    @Test
    public void testWithDeviceUIDServerAndPort() {
        int temp = (int) (Math.random() * 1000000);
        createDevice.inputDeviceUID("autoTest" + temp);
        createDevice.apnInput.clear();
        Assert.assertFalse(createDevice.btnSave.isEnabled());
        createDevice.cancelDevice();
    }

    @Test
    public void testWithDeviceUIDServerPortAndAPN() {
        createDevice.inputDeviceUID("autoTest" + numberForUID);
        createDevice.saveDevice();
        main.filterTable("autoTest" + numberForUID);
        if(main.getTableDevicesSize() == 1) {
            Assert.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'autoTest" + numberForUID + "']"));
        }
    }

    @Test
    public void testWithAlreadyExistsDeviceUID() {
        createDevice.inputDeviceUID("Test111");
        createDevice.saveDevice();
        Assert.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), 'GPS Device with the same Device UID already exist' )]"));
        createDevice.cancelDevice();
    }

    @Test
    public void testInputSymbolsToPort() {
        createDevice.inputDeviceUID("autoTest" + numberForUID);
        createDevice.portInput.clear();
        createDevice.inputPort("hello123");
        Assert.assertFalse(createDevice.btnSave.isEnabled());
        createDevice.cancelDevice();
    }

    @Test
    public void testFullyChargedWithDiffProfiles(){
        String init = createDevice.getIfFullyCharged();
        createDevice.input2Profile();
        Assert.assertFalse(init.equals(createDevice.getIfFullyCharged()));
        createDevice.cancelDevice();
    }

//    @Test
//    public void testInfoAboutProfile(){
//        createDevice.input1Profile();
//        if("10".equals(createDevice.getServerTimeout())){
//            if("20".equals(createDevice.getLteTimeout())){
//                if("1 second".equals(createDevice.getDeviceSleepSeconds())){
//                    if("ON".equals(createDevice.getGpsSleep())){
//                        if("150/600".equals(createDevice.getMotionDetection())){
//                            Assert.assertTrue(true);
//                        }
//                    }
//                }
//            }
//        }
//        createDevice.cancelDevice();
//    }

    @Test
    public void testAddAndDelNotification(){
        createDevice.selectTemperature1Notification();
        if(basePage.isElementDisplayedByPath("//*[contains(@ng-repeat, 'notification in')][1]//button")){
            createDevice.deleteNotification(1);
        }
        if(!(basePage.isElementDisplayedByPath("//*[contains(@ng-repeat, 'notification in')][1]//button"))){
            Assert.assertTrue(true);
        }
        createDevice.cancelDevice();
    }

    @Test
    public void testAddAndSaveNotification(){
        int temp = (int) (Math.random() * 1000000);
        createDevice.inputDeviceUID("autoTest" + temp);
        createDevice.selectTemperature1Notification();
        createDevice.saveDevice();
        main.filterTable("autoTest" + temp);
        if(basePage.isElementDisplayed(main.iconTemperature)){
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testAddAllTypesOfNotification(){
        int temp = (int) (Math.random() * 1000000);
        createDevice.inputDeviceUID("autoTest" + temp);
        createDevice.selectTemperature1Notification();
        createDevice.selectVoltageNotification();
        createDevice.selectDeviceConnectivityNotification();
        createDevice.selectMotionNotification();
        createDevice.selectDeviceErrorNotification();
        createDevice.selectPositionNotification();
        createDevice.saveDevice();
        main.filterTable("autoTest" + temp);
        if(basePage.isElementDisplayed(main.iconTemperature)){
            if(basePage.isElementDisplayed(main.iconMotion)){
                if(basePage.isElementDisplayed(main.iconVoltage)){
                    if(basePage.isElementDisplayed(main.iconPosition)){
                        if(basePage.isElementDisplayed(main.iconDeviceError)){
                            if(basePage.isElementDisplayed(main.iconDeviceConnectivity)){
                                Assert.assertTrue(true);
                            } else {
                                Assert.assertTrue(false);
                            }
                        } else {
                            Assert.assertTrue(false);
                        }
                    } else {
                        Assert.assertTrue(false);
                    }
                } else {
                    Assert.assertTrue(false);
                }
            } else {
                Assert.assertTrue(false);
            }
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testWithSameTypeOfNotification(){
        int temp = (int) (Math.random() * 1000000);
        createDevice.inputDeviceUID("autoTest" + temp);
        createDevice.selectTemperature1Notification();
        createDevice.selectTemperature2Notification();
        Assert.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Sorry. You already have TEMPERATURE NOTIFICATIONS for this device.']"));
        createDevice.cancelDevice();
    }

    @After
    public void afterTests(){
        driver.navigate().refresh();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
