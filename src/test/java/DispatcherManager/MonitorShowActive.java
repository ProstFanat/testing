package DispatcherManager;

import FleetEvents.OpenFleetPage;
import FleetEvents.createNewFleetEvent;
import FleetEvents.mainFleet;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import resources.AppConstants;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MonitorShowActive {

    public static WebDriver driver;
    public static openDispatcher open;
    public static createNewFleetEvent createTrip;
    public static FleetEvents.mainFleet mainFleet;
    public static BasePage basePage;
    public static dispatcherList mainList;
    public static dispatcherMonitor main;
    public static OpenFleetPage openFleet;

    @BeforeAll
    static void setup() {
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        driver = getWebDriver();
        open = new openDispatcher(driver);
        createTrip = new createNewFleetEvent(driver);
        mainFleet = new mainFleet(driver);
        basePage = new BasePage(driver);
        driver.manage().window().maximize();
        main = new dispatcherMonitor(driver);
        mainList = new dispatcherList(driver);
        openFleet = new OpenFleetPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        openFleet.openFleetEvents();
        basePage.sleep(1000);
    }

    @Test
    public void testStatusNew(){
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/app/fleet-events/#/trip-view(details:trip-view-details)");
        createTrip.openFormCreate();
        createTrip.createTripWithDispatcher("new", "Local");
        String trip = mainFleet.getTripNumber();
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/fleet/manager/cpDispatchers/#/");
        mainList.openTabMonitor();
        main.inputDispatcher("Adrian Boychuk");
        main.clickAdvancedSearch();
        main.inputTrip(trip);
        main.applyFilters();
        if(main.showActiveCheckbox.isSelected()){
            Assertions.assertEquals(1, main.table.size());
        }
    }

    @Test
    public void testStatusDispatched(){
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/app/fleet-events/#/trip-view(details:trip-view-details)");

        createTrip.openFormCreate();
        createTrip.createTripWithDispatcher("dispatched", "Local");
        String trip = mainFleet.getTripNumber();

        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/fleet/manager/cpDispatchers/#/");
        mainList.openTabMonitor();
        main.inputDispatcher("Adrian Boychuk");
        main.clickAdvancedSearch();
        main.inputTrip(trip);
        main.applyFilters();

        if(main.showActiveCheckbox.isSelected()){
            Assertions.assertEquals(1, main.table.size());
        }
    }

    @Test
    public void testStatusBooked(){
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/app/fleet-events/#/trip-view(details:trip-view-details)");

        createTrip.openFormCreate();
        createTrip.createTripWithDispatcher("booked", "Local");
        String trip = mainFleet.getTripNumber();

        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/fleet/manager/cpDispatchers/#/");
        mainList.openTabMonitor();
        main.inputDispatcher("Adrian Boychuk");
        main.clickAdvancedSearch();
        main.inputTrip(trip);
        main.applyFilters();

        if(main.showActiveCheckbox.isSelected()){
            Assertions.assertEquals(1, main.table.size());
        }
    }

    @Test
    public void testStatusDone(){
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/app/fleet-events/#/trip-view(details:trip-view-details)");

        createTrip.openFormCreate();
        createTrip.createTripWithDispatcher("done", "Local");
        String trip = mainFleet.getTripNumber();

        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/fleet/manager/cpDispatchers/#/");
        mainList.openTabMonitor();
        main.inputDispatcher("Adrian Boychuk");
        main.clickAdvancedSearch();
        main.inputTrip(trip);
        main.applyFilters();

        if(main.showActiveCheckbox.isSelected()){
            if(main.table.size() == 0){
                main.showActiveCheckbox.click();
                Assertions.assertEquals(1, main.table.size());
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @Test
    public void testStatusCancelled(){
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/app/fleet-events/#/trip-view(details:trip-view-details)");

        createTrip.openFormCreate();
        createTrip.createTripWithDispatcher("cancelled", "Local");
        String trip = mainFleet.getTripNumber();

        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/fleet/manager/cpDispatchers/#/");
        mainList.openTabMonitor();
        main.inputDispatcher("Adrian Boychuk");
        main.clickAdvancedSearch();
        main.inputTrip(trip);
        main.applyFilters();

        if(main.showActiveCheckbox.isSelected()){
            if(main.table.size() == 0){
                main.showActiveCheckbox.click();
                Assertions.assertEquals(1, main.table.size());
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
