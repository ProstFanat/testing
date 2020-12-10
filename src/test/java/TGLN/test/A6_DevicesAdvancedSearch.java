package TGLN.test;

import TGLN.AddGPSDevice;
import TGLN.TabDevices;
import TGLN.OpenGPSDevices;
import fleetEvents.fleet.LogOut;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class A6_DevicesAdvancedSearch {

    public static WebDriver driver;
    public static OpenGPSDevices open;
    public static BasePage basePage;
    public static LogOut logOut;
    public static TabDevices main;
    public static AddGPSDevice createDevice;
    public static Actions actions;

    @BeforeAll
    static void setup() {
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
    public void testSearchTrackEnsureAtTrackEnsure(){
        main.selectTrackEnsureGPSDevices();
        main.filterTable("testEmulator3");
        if(main.getTableDevicesSize() == 1) {
            Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'testEmulator3']"));
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testSearchTrackEnsureAtAll(){
        main.selectAllGPSDevices();
        main.filterTable("testEmulator3");
        if(main.getTableDevicesSize() == 1) {
            Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'testEmulator3']"));
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testSearchTelitekAtTelitek(){
        main.selectTelitekGPSDevices();
        main.filterTable("regregtest");
        if(main.getTableDevicesSize() == 1) {
            Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'regregtest']"));
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testSearchTelitekAtAll(){
        main.selectAllGPSDevices();
        main.filterTable("regregtest");
        if(main.getTableDevicesSize() == 1) {
            Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'regregtest']"));
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testSearchTelitekAtTrackEnsure(){
        main.selectTrackEnsureGPSDevices();
        main.filterTable("regregtest");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() ='There is no GPS Device available for the specified search.']"));
    }

    @Test
    public void testSearchTrackEnsureAtTelitek(){
        main.selectTelitekGPSDevices();
        main.filterTable("testEmulator3");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() ='There is no GPS Device available for the specified search.']"));
    }

    @Test
    public void testSearchNonexistentDeviceAtTrackEnsure(){
        main.selectTrackEnsureGPSDevices();
        main.filterTable("search");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() ='There is no GPS Device available for the specified search.']"));
    }

    @Test
    public void testSearchNonexistentDeviceAtTelitek(){
        main.selectTelitekGPSDevices();
        main.filterTable("search");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() ='There is no GPS Device available for the specified search.']"));
    }

    @Test
    public void testSearchNonexistentDeviceAtAll(){
        main.selectAllGPSDevices();
        main.filterTable("search");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() ='There is no GPS Device available for the specified search.']"));
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
