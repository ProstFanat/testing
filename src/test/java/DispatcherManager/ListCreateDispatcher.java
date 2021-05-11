package DispatcherManager;

import DispatcherManager.dispatcherList;
import DispatcherManager.dispatcherMonitor;
import DispatcherManager.openDispatcher;
import FleetEvents.OpenFleetPage;
import FleetEvents.createNewFleetEvent;
import FleetEvents.mainFleet;
import org.junit.jupiter.api.*;
import resources.AppConstants;
import org.openqa.selenium.WebDriver;
import resources.BasePage;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ListCreateDispatcher {

    public static WebDriver driver;
    public static openDispatcher open;
    public static createNewFleetEvent createTrip;
    public static FleetEvents.mainFleet mainFleet;
    public static BasePage basePage;
    public static dispatcherList main;
    public static dispatcherMonitor mainMonitor;
    public static OpenFleetPage openFleet;



    @BeforeAll
    public static void setup() {
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        driver = getWebDriver();
        open = new openDispatcher(driver);
        createTrip = new createNewFleetEvent(driver);
        mainFleet = new mainFleet(driver);
        basePage = new BasePage(driver);
        driver.manage().window().maximize();
        mainMonitor = new dispatcherMonitor(driver);
        main= new dispatcherList(driver);
        openFleet = new OpenFleetPage(driver);
        open = new openDispatcher(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        open.openDispatchers();
        basePage.sleep(1000);
    }

    @Test
    public void testCreateDispatcher(){
        int number = (int) (Math.random() * 1000000);
        main.createNewDispatcher("testAdrian" + number);
        main.inputSearchDispatcher("testAdrian" + number);
        Assertions.assertEquals(main.name.getText(), "testAdrian" + number);
    }

    @Test
    public void testCreateDispatcherWithAlreadyExistsName(){
        int number = (int) (Math.random() * 1000000);
        main.createNewDispatcher("testAdrian" + number);
        main.createNewDispatcher("testAdrian" + number);
        if(main.isElementDisplayedByPath("//*[text() = 'Dispatcher " + "testAdrian" + number + " already exists']")){
            main.inputSearchDispatcher("testAdrian" + number);
            Assertions.assertEquals(1, main.table.size());
        }
    }

    @Test
    public void testWithEmpty(){
        main.openFormAddNewDispatcher();
        Assertions.assertFalse(main.btnSave.isEnabled());
    }


    @AfterEach
    public void afterTests(){
        driver.navigate().refresh();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
