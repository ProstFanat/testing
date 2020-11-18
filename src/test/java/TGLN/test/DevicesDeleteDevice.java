package TGLN.test;

import TGLN.AddGPSDevice;
import TGLN.TabDevices;
import TGLN.OpenGPSDevices;
import fleetEvents.fleet.LogOut;
import fleetEvents.fleet.resources.ConfPropertiesFleet;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DevicesDeleteDevice {
    public static WebDriver driver;
    public static OpenGPSDevices open;
    public static BasePage basePage;
    public static LogOut logOut;
    public static TabDevices main;
    public static AddGPSDevice createDevice;
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
        createDevice = new AddGPSDevice(driver);
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/TrackEnsure/login.do");
        open.openGPSDevices();
    }

    @Test
    public void testDeactivateAndOk(){
        main.selectActiveDevices();
        int numberForUID = (int) (Math.random() * 1000000000);
        main.openNewDeviceForm();
        createDevice.inputDeviceUID("autoTest" + numberForUID);
        createDevice.saveDevice();
        main.filterTable("autoTest" + numberForUID);
        main.deleteDevice(1);
        main.confirmDelete();
        main.selectActiveDevices();
        main.filterTable("autoTest" + numberForUID);
        if(basePage.isElementDisplayedByPath("//*[text() ='There is no GPS Device available for the specified search.']")){
            main.selectInactiveDevices();
            Assert.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'autoTest" + numberForUID + "']"));
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testDeactivateAndCancelled(){
        main.selectActiveDevices();
        int numberForUID = (int) (Math.random() * 1000000000);
        main.openNewDeviceForm();
        createDevice.inputDeviceUID("autoTest" + numberForUID);
        createDevice.saveDevice();
        main.filterTable("autoTest" + numberForUID);
        main.deleteDevice(1);
        main.cancelDelete();
        main.selectActiveDevices();
        main.filterTable("autoTest" + numberForUID);
        if(main.getTableDevicesSize() == 1) {
            Assert.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'autoTest" + numberForUID + "']"));
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testDeactivateAndCreateWithSameUID(){
        main.selectActiveDevices();
        int numberForUID = (int) (Math.random() * 1000000000);
        main.openNewDeviceForm();
        createDevice.inputDeviceUID("autoTest" + numberForUID);
        createDevice.saveDevice();
        main.filterTable("autoTest" + numberForUID);
        main.deleteDevice(1);
        main.confirmDelete();
        main.filterTable("autoTest" + numberForUID);
        if(basePage.isElementDisplayedByPath("//*[text() ='There is no GPS Device available for the specified search.']")){
            main.openNewDeviceForm();
            createDevice.inputDeviceUID("autoTest" + numberForUID);
            createDevice.saveDevice();
            Assert.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), 'GPS Device with the same Device UID already exists')]"));
        } else {
            Assert.assertTrue(false);
        }
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
