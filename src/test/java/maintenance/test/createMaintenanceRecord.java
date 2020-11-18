package maintenance.test;

import maintenance.*;
//import fleetEvents.fleet.resources.ConfPropertiesFleet;
import maintenance.openMaintenance;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class createMaintenanceRecord {

    public static WebDriver driver;
    public static openMaintenance open;
    public static BasePage basePage;
    public static LogOut logOut;
    public static addMaintenanceRecordForGroup create;

    @BeforeClass
    public static void setup() {
//        //определение пути до драйвера и его настройка
//        System.setProperty("webdriver.chrome.driver", ConfPropertiesFleet.getProperty("chromedriver"));
//        //создание экземпляра драйвера
//        driver = new ChromeDriver();
        open("http://localhost:8080/TrackEnsure/login.do");
        driver = getWebDriver();
        open = new openMaintenance(driver);
        basePage = new BasePage(driver);
        logOut = new LogOut(driver);
        create = new addMaintenanceRecordForGroup(driver);
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get("http://localhost:8080/TrackEnsure/login.do");
        open.openMaintenance();
        basePage.sleep(1000);
    }

    @Test
    public void testOnlyWithPart(){
        create.openAddMaintenanceGroupForm();
        create.inputPartAction("autoTest");
        Assert.assertFalse(create.btnSaveMaintenance.isEnabled());
        create.cancelAdd();
    }

    @Test
    public void testOnlyWithQuantity(){
        create.openAddMaintenanceGroupForm();
        create.inputQuantity("123");
        Assert.assertFalse(create.btnSaveMaintenance.isEnabled());
        create.cancelAdd();
    }

    @Test
    public void testOnlyWithTruck(){
        create.openAddMaintenanceGroupForm();

        Assert.assertFalse(create.btnSaveMaintenance.isEnabled());
        create.cancelAdd();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
