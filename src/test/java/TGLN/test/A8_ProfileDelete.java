package TGLN.test;

import TGLN.*;
import fleetEvents.fleet.LogOut;
import fleetEvents.fleet.resources.ConfPropertiesFleet;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class A8_ProfileDelete {


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
    }

    @Test
    public void testDeleteProfileAndCancel(){
        int number = (int) (Math.random() * 100000);
        main.openCreateNewProfile();
        create.inputName("test" + number);
        create.inputServerTimeout("" + number);
        create.inputLteTimeout("" + number);
        create.saveProfile();
        main.deleteProfile("test" + number);
        main.cancelDelete();
        main.filterTable("test" + number);
        Assert.assertTrue(("test" + number).equals(main.getValueProfileName()));
        main.deleteProfile("test" + number);
        main.confirmDelete();
    }

    @Test
    public void testDeleteProfileAndSave(){
        int number = (int) (Math.random() * 100000);
        main.openCreateNewProfile();
        create.inputName("test" + number);
        create.inputServerTimeout("" + number);
        create.inputLteTimeout("" + number);
        create.inputSleepSeconds("" + number);
        create.saveProfile();
        main.deleteProfile("test" + number);
        main.confirmDelete();
        main.filterTable("test" + number);
        Assert.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Please search another one.']"));
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
