package fleet;

import FleetEvents.*;
import org.junit.jupiter.api.*;
import resources.AppConstants;

import org.openqa.selenium.WebDriver;

import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TripBoardSearch {


    public static WebDriver driver;
    public static OpenFleetPage open;
    public static createNewFleetEvent createTrip;
    public static mainFleet mainFleetEvents;
    public static editEvent edit;
    public static filterFleet filter;
    public static BasePage basePage;
    public static LogOut logOut;
    public static TripBoard main;

    @BeforeAll
    static void setup() {
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        driver = getWebDriver();
        open = new OpenFleetPage(driver);
        createTrip = new createNewFleetEvent(driver);
        mainFleetEvents = new mainFleet(driver);
        edit = new editEvent(driver);
        filter = new filterFleet(driver);
        basePage = new BasePage(driver);
        logOut = new LogOut(driver);
        main = new TripBoard(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        open.openFleetEvents();
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/app/trip-board/#/trip-list");
    }

    @BeforeEach
    void beforeTest(){
        main.sleep(1000);
        main.clickAdvancedSearch();
    }

    @Test
    public void testFilterTrip(){
        main.inputTripNumber("716525");
        main.applyFilters();
        basePage.sleep(500);
        Assertions.assertTrue(main.filterBy("716525", "tripNumber"));
    }

    @Test
    public void testFilterStatus(){
        main.inputTripStatus("new");
        main.applyFilters();
        basePage.sleep(500);
        Assertions.assertTrue(main.filterBy("new", "status"));
    }

    @Test
    public void testFilterType(){
        main.inputTripType("Local");
        main.applyFilters();
        basePage.sleep(500);
        Assertions.assertTrue(main.filterBy("Local", "type"));
    }

    @Test
    public void testFilterDriver(){
        main.inputDriver("Adrian Gherghel");
        main.applyFilters();
        basePage.sleep(500);
        Assertions.assertTrue(main.filterBy("Adrian Gherghel", "driver1"));
    }

    @Test
    public void testFilterTruck(){
        main.inputTruck("1210");
        main.applyFilters();
        basePage.sleep(500);
        Assertions.assertTrue(main.filterBy("1210", "truck"));
    }

    @Test
    public void testFilterTrailer(){
        main.inputTrailer("1210T");
        main.applyFilters();
        basePage.sleep(500);
        Assertions.assertTrue(main.filterBy("1210T", "trailer"));
    }

    @Test
    public void testWithAll(){
        main.inputTripNumber("716167");
        main.inputTripStatus("new");
        main.inputTripType("Local");
        main.inputDriver("Adrian Gherghel");
        main.inputTruck("1210");
        main.inputTrailer("1210T");
        main.applyFilters();
        basePage.sleep(500);
        if(main.filterBy("716167", "tripNumber")) {
            if(main.filterBy("new", "status")){
                if(main.filterBy("Local", "type")){
                    if(main.filterBy("Adrian Gherghel", "driver1")){
                        if(main.filterBy("1210", "truck")){
                            Assertions.assertTrue(main.filterBy("1210T", "trailer"));
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


    @AfterEach
    void beforeTests(){
        driver.navigate().refresh();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
