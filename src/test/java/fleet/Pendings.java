package fleet;

import FleetEvents.*;
import org.junit.jupiter.api.*;
import resources.AppConstants;
import org.openqa.selenium.WebDriver;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Pendings {

    public static WebDriver driver;
    public static OpenFleetPage open;
    public static createNewFleetEvent createTrip;
    public static mainFleet main;
    public static editEvent edit;
    public static filterFleet filter;
    public static BasePage basePage;
    public static LogOut logOut;
    public static historyTrip action;
    public static TripBoard tripBoard;

    @BeforeAll
    static void setup() {
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        driver = getWebDriver();
        open = new OpenFleetPage(driver);
        createTrip = new createNewFleetEvent(driver);
        main = new mainFleet(driver);
        edit = new editEvent(driver);
        action = new historyTrip(driver);
        filter = new filterFleet(driver);
        basePage = new BasePage(driver);
        logOut = new LogOut(driver);
        tripBoard = new TripBoard(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        open.openFleetEvents();
        basePage.sleep(1000);
    }

    @BeforeEach
    void beforeTest(){

    }

    @Test
    public void testOpenTransaction(){
        createTrip.openFormCreate();
        createTrip.createTrip("new", "Local");

        main.openTransaction();
        main.sleep(1000);

        Assertions.assertTrue(main.btnCommitTransaction.isEnabled());
    }

    @Test
    public void testUseVersion(){
        createTrip.openFormCreate();
        createTrip.createTrip("new", "Local");

        action.openTripHistory();
        action.selectLeftVersion1();
        int initTable = action.tableLeft.size();
        action.useVersionLeft();
        main.sleep(1000);

        Assertions.assertFalse(action.inputVersionRight.isEnabled());
    }

    @Test
    public void testDeleteTransaction(){
        createTrip.openFormCreate();
        createTrip.createTrip("new", "Local");

        main.openTransaction();

        main.deleteTransaction();
        main.sleep(1000);
        Assertions.assertTrue(main.btnOpenTransaction.isDisplayed());
    }

    @Test
    public void testCommitTransaction(){
        createTrip.openFormCreate();
        createTrip.createTrip("new", "Local");

        main.openTransaction();

        main.commitTransaction();
        main.sleep(1000);
        Assertions.assertTrue(main.btnOpenTransaction.isEnabled());
    }

    @Test
    public void testUpdateTrip(){
        createTrip.openFormCreate();
        createTrip.createTrip("new", "Local");

        main.openTransaction();

        main.updateTrip();
        createTrip.inputStartDate();
        createTrip.inputFinishDate();
        createTrip.inputDispatcher("Adrian Boychuk");
        createTrip.inputDriver1("Adrian Gherghel");
        createTrip.inputDriver2("Adrian Fanuzzi");
        createTrip.inputTruck("1210");
        createTrip.inputTrailer("1210T");
        createTrip.inputComment("test test test");
        createTrip.clickBtnSave();
        main.sleep(1000);

        Assertions.assertTrue(main.btnUpdateTrip.isDisplayed());
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
