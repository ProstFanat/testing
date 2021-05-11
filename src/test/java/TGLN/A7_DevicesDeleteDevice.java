package TGLN;

import FleetEvents.LogOut;
import GPSDevices.AddGPSDevice;
import GPSDevices.OpenGPSDevices;
import GPSDevices.TabDevices;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import resources.AppConstants;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class A7_DevicesDeleteDevice {
    public static WebDriver driver;
    public static OpenGPSDevices open;
    public static BasePage basePage;
    public static LogOut logOut;
    public static TabDevices main;
    public static AddGPSDevice createDevice;
    public static Actions actions;

    @BeforeAll
    static void setup() {
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        driver = getWebDriver();
        open = new OpenGPSDevices(driver);
        basePage = new BasePage(driver);
        logOut = new LogOut(driver);
        main = new TabDevices(driver);
        actions = new Actions(driver);
        createDevice = new AddGPSDevice(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
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
            Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'autoTest" + numberForUID + "']"));
        } else {
            Assertions.assertTrue(false);
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
            Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'autoTest" + numberForUID + "']"));
        } else {
            Assertions.assertTrue(false);
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
            Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), 'GPS Device with the same Device UID already exists')]"));
        } else {
            Assertions.assertTrue(false);
        }
    }

    @AfterEach
    void beforeTests(){
        driver.navigate().refresh();
    }

    @AfterAll
    public static void tearDown() {
         driver.quit();
    }
}
