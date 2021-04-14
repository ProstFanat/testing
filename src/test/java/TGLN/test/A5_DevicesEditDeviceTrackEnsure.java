package TGLN.test;

import TGLN.*;
import fleetEvents.fleet.LogOut;

import org.junit.jupiter.api.*;
import resources.AppConstants;
import org.openqa.selenium.WebDriver;
import resources.AppConstants;
import org.openqa.selenium.interactions.Actions;
import resources.BasePage;
import resources.AppConstants;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class A5_DevicesEditDeviceTrackEnsure {
    public static WebDriver driver;
    public static OpenGPSDevices open;
    public static BasePage basePage;
    public static LogOut logOut;
    public static TabDevices main;
    public static AddGPSDevice createDevice;
    public static Actions actions;
    public static AddTruckToDevice addTruck;
    public static TabProfiles mainProfile;
    public static TabNotification mainNotification;
    public static CreateProfile createProfile;
    public static CreateNotifications createNotification;

    @BeforeAll
    static void setup() {
//        //определение пути до драйвера и его настройка
//        System.setProperty("webdriver.chrome.driver", ConfPropertiesFleet.getProperty("chromedriver"));
//        //создание экземпляра драйвера
//        driver = new ChromeDriver();
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        driver = getWebDriver();
        open = new OpenGPSDevices(driver);
        basePage = new BasePage(driver);
        logOut = new LogOut(driver);
        main = new TabDevices(driver);
        actions = new Actions(driver);
        addTruck = new AddTruckToDevice(driver);
        createDevice = new AddGPSDevice(driver);
        createNotification = new CreateNotifications(driver);
        createProfile = new CreateProfile(driver);
        mainProfile = new TabProfiles(driver);
        mainNotification = new TabNotification(driver);
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        open.openGPSDevices();
    }

    @Test
    public void testEditAllAndSave(){
        main.selectTrackEnsureGPSDevices();
        main.openNewDeviceForm();
        int numberForUID = (int) (Math.random() * 1000000000);
        createDevice.inputDeviceUID("autoTest" + numberForUID);
        createDevice.deviceUIDInput.clear();
        createDevice.serverInput.clear();
        createDevice.portInput.clear();
        createDevice.apnInput.clear();
        createDevice.inputDeviceUID("autoTest" + numberForUID);
        createDevice.inputServer("nezamenaServer");
        createDevice.inputPort("6666");
        createDevice.inputAPN("nezamenaAPN");
        createDevice.input1Profile();
        createDevice.saveDevice();
        main.filterTable("autoTest" + numberForUID);

        int tempNumberForUID = (int) (Math.random() * 1000000000);
        main.openEditForDevice(1);
        createDevice.deviceUIDInput.clear();
        createDevice.serverInput.clear();
        createDevice.portInput.clear();
        createDevice.apnInput.clear();
        createDevice.inputDeviceUID("autoTest" + tempNumberForUID);
        createDevice.inputServer("zamenaServer");
        createDevice.inputPort("6969");
        createDevice.inputAPN("zamenaAPN");
        createDevice.input2Profile();
        createDevice.selectPositionNotification();
        createDevice.saveDevice();
        main.filterTable("autoTest" + tempNumberForUID);
        if (basePage.isElementDisplayedByPath("//*[text() = 'autoTest" + tempNumberForUID + "']")) {
            if (basePage.isElementDisplayedByPath("//*[text() = 'zamenaServer']")) {
                if (basePage.isElementDisplayedByPath("//*[text() = '6969']")) {
                    if (basePage.isElementDisplayedByPath("//*[text() = 'zamenaAPN']")) {
                        if (basePage.isElementDisplayedByPath("//*[text() = '11']")) {
                            if (basePage.isElementDisplayed(main.iconPosition)) {
                                Assertions.assertTrue(true);
                            } else {Assertions.assertTrue(false);}
                        } else {Assertions.assertTrue(false);}
                    } else {Assertions.assertTrue(false);}
                } else {Assertions.assertTrue(false);}
            } else { Assertions.assertTrue(false);}
        } else { Assertions.assertTrue(false); }

        main.filterTable("autoTest" + tempNumberForUID);
        main.deleteDevice(1);
        main.confirmDelete();
    }

    @Test
    public void testEditAllAndCancel(){
        main.selectTrackEnsureGPSDevices();
        main.openNewDeviceForm();
        int numberForUID = (int) (Math.random() * 1000000000);
        createDevice.inputDeviceUID("autoTest" + numberForUID);
        createDevice.deviceUIDInput.clear();
        createDevice.serverInput.clear();
        createDevice.portInput.clear();
        createDevice.apnInput.clear();
        createDevice.inputDeviceUID("autoTest" + numberForUID);
        createDevice.inputServer("nezamenaServer");
        createDevice.inputPort("6666");
        createDevice.inputAPN("nezamenaAPN");
        createDevice.input1Profile();
        createDevice.saveDevice();
        main.filterTable("autoTest" + numberForUID);

        int tempNumberForUID = (int) (Math.random() * 1000000000);
        main.openEditForDevice(1);
        createDevice.deviceUIDInput.clear();
        createDevice.serverInput.clear();
        createDevice.portInput.clear();
        createDevice.apnInput.clear();
        createDevice.inputDeviceUID("autoTest" + tempNumberForUID);
        createDevice.inputServer("zamenaServer");
        createDevice.inputPort("6969");
        createDevice.inputAPN("zamenaAPN");
        createDevice.input2Profile();
        createDevice.selectPositionNotification();
        createDevice.cancelDevice();
        main.filterTable("autoTest" + tempNumberForUID);

        if(basePage.isElementDisplayedByPath("//*[text() ='There is no GPS Device available for the specified search.']")) {
            main.filterTable("autoTest" + numberForUID);
            if (basePage.isElementDisplayedByPath("//*[text() = 'autoTest" + numberForUID + "']")) {
                if (basePage.isElementDisplayedByPath("//*[text() = 'nezamenaServer']")) {
                    if (basePage.isElementDisplayedByPath("//*[text() = '6666']")) {
                        if (basePage.isElementDisplayedByPath("//*[text() = 'nezamenaAPN']")) {
                            if (basePage.isElementDisplayedByPath("//*[text() = 'testTemp']")) {
                                if (!(basePage.isElementDisplayed(main.iconPosition))) {
                                    Assertions.assertTrue(true);
                                } else {Assertions.assertTrue(false);}
                            } else {Assertions.assertTrue(false);}
                        } else {Assertions.assertTrue(false);}
                    } else {Assertions.assertTrue(false);}
                } else { Assertions.assertTrue(false);}
            } else { Assertions.assertTrue(false); }
        } else { Assertions.assertTrue(false); }

        main.filterTable("autoTest" + numberForUID);
        main.deleteDevice(1);
        main.confirmDelete();
    }

    @Test
    public void testAddTruckToDevice(){
        main.selectTrackEnsureGPSDevices();
        main.openNewDeviceForm();
        int numberForUID = (int) (Math.random() * 1000000000);
        createDevice.inputDeviceUID("autoTest" + numberForUID);
        createDevice.deviceUIDInput.clear();
        createDevice.serverInput.clear();
        createDevice.portInput.clear();
        createDevice.apnInput.clear();
        createDevice.inputDeviceUID("autoTest" + numberForUID);
        createDevice.inputServer("nezamenaServer");
        createDevice.inputPort("6666");
        createDevice.inputAPN("nezamenaAPN");
        createDevice.input1Profile();
        createDevice.saveDevice();

        addTruck.connectDeviceWithTruck("autoTests", "autoTest" + numberForUID);

        main.filterTable("autoTest" + numberForUID);
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'autoTests']"));

        main.filterTable("autoTest" + numberForUID);
        main.deleteDevice(1);
        main.confirmDelete();
    }

    @Test
    public void testAddTruckToDeviceAndEditDeviceUID(){
        main.selectTrackEnsureGPSDevices();
        main.openNewDeviceForm();
        int numberForUID = (int) (Math.random() * 1000000000);
        createDevice.inputDeviceUID("autoTest" + numberForUID);
        createDevice.deviceUIDInput.clear();
        createDevice.serverInput.clear();
        createDevice.portInput.clear();
        createDevice.apnInput.clear();
        createDevice.inputDeviceUID("autoTest" + numberForUID);
        createDevice.inputServer("nezamenaServer");
        createDevice.inputPort("6666");
        createDevice.inputAPN("nezamenaAPN");
        createDevice.input1Profile();
        createDevice.saveDevice();

        addTruck.connectDeviceWithTruck("autoTests", "autoTest" + numberForUID);

        main.filterTable("autoTest" + numberForUID);
        main.openEditForDevice(1);
        createDevice.deviceUIDInput.clear();
        createDevice.inputDeviceUID("autoTest");
        createDevice.saveDevice();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), 'You cannot edit Device UID because this device assigned to truck (previous value: autoTest" + numberForUID + ")')]"));
        createDevice.cancelDevice();

        main.filterTable("autoTest" + numberForUID);
        main.deleteDevice(1);
        main.confirmDelete();
    }

    @Test
    public void testEditAllAndSaveOfInactiveDevice(){
        main.selectTrackEnsureGPSDevices();
        main.openNewDeviceForm();
        int numberForUID = (int) (Math.random() * 1000000000);
        createDevice.inputDeviceUID("autoTest" + numberForUID);
        createDevice.deviceUIDInput.clear();
        createDevice.serverInput.clear();
        createDevice.portInput.clear();
        createDevice.apnInput.clear();
        createDevice.inputDeviceUID("autoTest" + numberForUID);
        createDevice.inputServer("nezamenaServer");
        createDevice.inputPort("6666");
        createDevice.inputAPN("nezamenaAPN");
        createDevice.input1Profile();
        createDevice.saveDevice();
        main.selectActiveDevices();
        main.filterTable("autoTest" + numberForUID);
        main.deleteDevice(1);
        main.confirmDelete();

        if(basePage.isElementDisplayedByPath("//*[text() ='There is no GPS Device available for the specified search.']")) {
            main.selectInactiveDevices();
            int tempNumberForUID = (int) (Math.random() * 1000000000);
            main.openEditForDevice(1);
            createDevice.deviceUIDInput.clear();
            createDevice.serverInput.clear();
            createDevice.portInput.clear();
            createDevice.apnInput.clear();
            createDevice.inputDeviceUID("autoTest" + tempNumberForUID);
            createDevice.inputServer("zamenaServer");
            createDevice.inputPort("6969");
            createDevice.inputAPN("zamenaAPN");
            createDevice.input2Profile();
            createDevice.selectPositionNotification();
            createDevice.saveDevice();
            main.filterTable("autoTest" + tempNumberForUID);
            if (basePage.isElementDisplayedByPath("//*[text() = 'autoTest" + tempNumberForUID + "']")) {
                if (basePage.isElementDisplayedByPath("//*[text() = 'zamenaServer']")) {
                    if (basePage.isElementDisplayedByPath("//*[text() = '6969']")) {
                        if (basePage.isElementDisplayedByPath("//*[text() = 'zamenaAPN']")) {
                            if (basePage.isElementDisplayedByPath("//*[text() = '11']")) {
                                if (basePage.isElementDisplayed(main.iconPosition)) {
                                    Assertions.assertTrue(true);
                                } else {
                                    Assertions.assertTrue(false);
                                }
                            } else {
                                Assertions.assertTrue(false);
                            }
                        } else {
                            Assertions.assertTrue(false);
                        }
                    } else {
                        Assertions.assertTrue(false);
                    }
                } else {
                    Assertions.assertTrue(false);
                }
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testAddNotificationsAndUpdateProfile(){
        main.openNewDeviceForm();
        int temp = (int) (Math.random() * 1000000);
        int temperature = (int) (Math.random() * 1000);
        createDevice.inputDeviceUID("autoTest" + temp);
        createDevice.input1Profile();
        createDevice.selectTemperature1Notification();
        createDevice.selectVoltageNotification();
        createDevice.selectDeviceConnectivityNotification();
        createDevice.selectMotionNotification();
        createDevice.selectDeviceErrorNotification();
        createDevice.selectPositionNotification();
        createDevice.saveDevice();
        main.filterTable("autoTest" + temp);

        main.openProfilesTab();
        mainProfile.updateProfile("testTemp");
        createProfile.inputSleepSeconds("" + temperature);
        createProfile.saveProfile();
        driver.navigate().refresh();
        main.filterTable("autoTest" + temp);

        if(basePage.isElementDisplayed(main.iconTemperature)){
            if(basePage.isElementDisplayed(main.iconMotion)){
                if(basePage.isElementDisplayed(main.iconVoltage)){
                    if(basePage.isElementDisplayed(main.iconPosition)){
                        if(basePage.isElementDisplayed(main.iconDeviceError)){
                            if(basePage.isElementDisplayed(main.iconDeviceConnectivity)){
                                Assertions.assertTrue(true);
                            } else {
                                Assertions.assertTrue(false);
                            }
                        } else {
                            Assertions.assertTrue(false);
                        }
                    } else {
                        Assertions.assertTrue(false);
                    }
                } else {
                    Assertions.assertTrue(false);
                }
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }

        main.filterTable("autoTest" + temp);
        main.deleteDevice(1);
        main.confirmDelete();

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
