package TGLN.test;

import TGLN.*;
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

public class ProfileUpdate {


    public static WebDriver driver;
    public static OpenGPSDevices open;
    public static BasePage basePage;
    public static LogOut logOut;
    public static TabDevices mainDevices;
    public static AddGPSDevice createDevice;
    public static Actions actions;
    public static AddTruckToDevice addTruck;
    public static TabNotification mainNotification;
    public static CreateNotifications createNotification;
    public static TabProfiles main;
    public static CreateProfile create;


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
        mainDevices = new TabDevices(driver);
        mainNotification = new TabNotification(driver);
        createNotification = new CreateNotifications(driver);
        actions = new Actions(driver);
        addTruck = new AddTruckToDevice(driver);
        createDevice = new AddGPSDevice(driver);
        create = new CreateProfile(driver);
        main = new TabProfiles(driver);
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/TrackEnsure/login.do");
        open.openGPSDevices();
    }

    @Before
    public void beforeTest(){
        mainDevices.openProfilesTab();
        main.openCreateNewProfile();
    }

    @Test
    public void testUpdateAllAndSave(){
        int number = (int) (Math.random() * 1000000);
        create.inputName("test" + number);
        create.inputServerTimeout("" + number);
        create.inputLteTimeout("" + number);
        create.inputSleepSeconds("30");
        create.saveProfile();

        main.updateProfile("" + number);
        create.inputName("test" + number + 1);
        create.inputServerTimeout("" + number + 1);
        create.inputLteTimeout("" + number + 1);
        create.clickGpsSleepCheckbox();
        create.clickAlwaysAwakeModeCheckbox();
        create.clickAccelerationCheckbox();
        create.inputReadSensorsInterval("240");
        create.inputReadGPSPositionInterval("240");
        create.inputServerHeartbeatInterval("240");
        create.inputThreshold("200");
        create.inputDuration("300");
        create.saveProfile();

        main.filterTable("test" + number + 1);
        if(("test" + number + 1).equals(main.getValueProfileName())){
            if(("0").equals(main.getValueSleepSeconds())){
                if(("Y").equals(main.getValueSleepGPSOn())){
                    if(("N").equals(main.getValueTempAlertEnabled())){
                        if(("Y").equals(main.getValueAccAlertEnabled())){
                            if(("200").equals(main.getValueAccAlertThreshold())){
                                if(("300").equals(main.getValueAccAlertDuration())){
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
        } else {
            Assert.assertTrue(false);
        }

        main.deleteProfile("test" + number + 1);
        main.confirmDelete();
    }

    @Test
    public void testUpdateAllAndCancel(){
        int number = (int) (Math.random() * 1000000);
        create.inputName("test" + number);
        create.inputServerTimeout("" + number);
        create.inputLteTimeout("" + number);
        create.inputSleepSeconds("30");
        create.saveProfile();

        main.updateProfile("" + number);
        create.inputName("test" + number + 1);
        create.inputServerTimeout("" + number + 1);
        create.inputLteTimeout("" + number + 1);
        create.clickGpsSleepCheckbox();
        create.clickAlwaysAwakeModeCheckbox();
        create.clickAccelerationCheckbox();
        create.inputReadSensorsInterval("240");
        create.inputReadGPSPositionInterval("240");
        create.inputServerHeartbeatInterval("240");
        create.inputThreshold("200");
        create.inputDuration("300");
        create.cancelSavingProfile();

        main.filterTable("test" + number);
        if(("test" + number).equals(main.getValueProfileName())){
            if(("30").equals(main.getValueSleepSeconds())){
                if(("N").equals(main.getValueSleepGPSOn())){
                    if(("N").equals(main.getValueTempAlertEnabled())){
                        if(("N").equals(main.getValueAccAlertEnabled())){
                            if(("").equals(main.getValueAccAlertThreshold())){
                                if(("").equals(main.getValueAccAlertDuration())){
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
        } else {
            Assert.assertTrue(false);
        }

        main.deleteProfile("test" + number);
        main.confirmDelete();
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
