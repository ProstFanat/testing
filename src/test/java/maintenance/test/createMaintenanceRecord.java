package maintenance.test;

import maintenance.*;

import maintenance.openMaintenance;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import resources.AppConstants;
import resources.BasePage;
import resources.AppConstants;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class createMaintenanceRecord {

    public static WebDriver driver;
    public static openMaintenance open;
    public static BasePage basePage;
    public static LogOut logOut;
    public static addMaintenanceRecordForGroup create;

    @BeforeAll
    static void setup() {
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        driver = getWebDriver();
        open = new openMaintenance(driver);
        basePage = new BasePage(driver);
        logOut = new LogOut(driver);
        create = new addMaintenanceRecordForGroup(driver);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        open.openMaintenance();
        basePage.sleep(1000);
    }

    @Test
    public void testOnlyWithPart(){
        create.openAddMaintenanceGroupForm();
        create.inputPartAction("autoTest");
        Assertions.assertFalse(create.btnSaveMaintenance.isEnabled());
        create.cancelAdd();
    }

    @Test
    public void testOnlyWithQuantity(){
        create.openAddMaintenanceGroupForm();
        create.inputQuantity("123");
        Assertions.assertFalse(create.btnSaveMaintenance.isEnabled());
        create.cancelAdd();
    }

    @Test
    public void testOnlyWithTruck(){
        create.openAddMaintenanceGroupForm();
        Assertions.assertFalse(create.btnSaveMaintenance.isEnabled());
        create.cancelAdd();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
