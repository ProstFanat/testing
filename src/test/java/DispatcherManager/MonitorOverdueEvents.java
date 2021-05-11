package DispatcherManager;

import FleetEvents.OpenFleetPage;
import FleetEvents.createNewFleetEvent;
import FleetEvents.editEvent;
import FleetEvents.mainFleet;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import resources.AppConstants;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MonitorOverdueEvents {

    public static WebDriver driver;
    public static openDispatcher open;
    public static createNewFleetEvent createTrip;
    public static FleetEvents.mainFleet mainFleet;
    public static BasePage basePage;
    public static dispatcherList mainList;
    public static dispatcherMonitor main;
    public static OpenFleetPage openFleet;
    public static editEvent createEvent;



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
        createEvent = new editEvent(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        openFleet.openFleetEvents();
        basePage.sleep(1000);
    }

    @BeforeEach
    void beforeTest(){
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/app/fleet-events/#/trip-view(details:trip-view-details)");
        main.waitToVisibilityOf(10, createTrip.btnCreateNew);
        main.waitToBeClickable(10, createTrip.btnCreateNew);
        createTrip.clickBtnCreateTrip();
        main.waitToVisibilityOf(10, createTrip.commentField);
        main.waitToVisibilityOf(10, createTrip.commentField);
    }

    @Test
    public void testStartDateEarlieThanEta(){
        createTrip.inputTripStatus("new");
        createTrip.inputType("Local");
        createTrip.clickRadioOrder();
        createTrip.inputDispatcher("Adrian Boychuk");
        createTrip.clickBtnSave();
        String tripNumber = mainFleet.getTripNumber();
        mainFleet.clickBtnOpenTransaction();
        mainFleet.saveNewTransaction();

        mainFleet.clickBtnAddNewEvent();
        createEvent.inputEventType("load");
        createEvent.inputPlace("NEW YORK OF STATE");
        createEvent.inputStartDatePast();
        createEvent.inputEtaDateFuture();
        createEvent.apllyChanges();

        mainFleet.btnCommitTransaction.click();
        mainFleet.btnYesConfirm.click();
        main.waitToVisibilityOf(10, mainFleet.btnOpenTransaction);

        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/fleet/manager/cpDispatchers/#/");
        mainList.openTabMonitor();
        main.inputDispatcher("Adrian Boychuk");
        main.clickAdvancedSearch();
        main.inputTrip(tripNumber);
        main.applyFilters();

        Assertions.assertTrue(main.isElementDisplayedByPath("//*[@data-overdue-events = 'N']"));
    }


    @Test
    public void testWithEmpty(){
        createTrip.inputTripStatus("new");
        createTrip.inputType("Local");
        createTrip.clickRadioOrder();
        createTrip.inputDispatcher("Adrian Boychuk");
        createTrip.clickBtnSave();
        String tripNumber = mainFleet.getTripNumber();
        mainFleet.clickBtnOpenTransaction();
        mainFleet.saveNewTransaction();

        mainFleet.clickBtnAddNewEvent();
        createEvent.inputEventType("load");
        createEvent.inputPlace("NEW YORK OF STATE");
        createEvent.apllyChanges();

        mainFleet.btnCommitTransaction.click();
        mainFleet.btnYesConfirm.click();

        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/fleet/manager/cpDispatchers/#/");
        mainList.openTabMonitor();
        main.inputDispatcher("Adrian Boychuk");
        main.clickAdvancedSearch();
        main.inputTrip(tripNumber);
        main.applyFilters();

        Assertions.assertTrue(main.isElementDisplayedByPath("//*[@data-overdue-events = 'N']"));
    }

    @Test
    public void testEtaDateBiggerThanNow(){
        createTrip.inputTripStatus("new");
        createTrip.inputType("Local");
        createTrip.clickRadioOrder();
        createTrip.inputDispatcher("Adrian Boychuk");
        createTrip.clickBtnSave();
        String tripNumber = mainFleet.getTripNumber();
        mainFleet.clickBtnOpenTransaction();
        mainFleet.saveNewTransaction();

        mainFleet.clickBtnAddNewEvent();
        createEvent.inputEventType("load");
        createEvent.inputPlace("NEW YORK OF STATE");
        createEvent.inputEtaDateFuture();
        createEvent.apllyChanges();

        mainFleet.btnCommitTransaction.click();
        mainFleet.btnYesConfirm.click();

        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/fleet/manager/cpDispatchers/#/");
        mainList.openTabMonitor();
        main.inputDispatcher("Adrian Boychuk");
        main.clickAdvancedSearch();
        main.inputTrip(tripNumber);
        main.applyFilters();

        Assertions.assertTrue(main.isElementDisplayedByPath("//*[@data-overdue-events = 'N']"));
    }

    @Test
    public void testEtaDateEarlieThanStart(){
        createTrip.inputTripStatus("new");
        createTrip.inputType("Local");
        createTrip.clickRadioOrder();
        createTrip.inputDispatcher("Adrian Boychuk");
        createTrip.clickBtnSave();
        String tripNumber = mainFleet.getTripNumber();
        mainFleet.clickBtnOpenTransaction();
        mainFleet.saveNewTransaction();

        mainFleet.clickBtnAddNewEvent();
        createEvent.inputEventType("load");
        createEvent.inputPlace("NEW YORK OF STATE");
        createEvent.inputStartDateFuture();
        createEvent.inputEtaDatePast();
        createEvent.apllyChanges();

        mainFleet.btnCommitTransaction.click();
        mainFleet.btnYesConfirm.click();

        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/fleet/manager/cpDispatchers/#/");
        mainList.openTabMonitor();
        main.inputDispatcher("Adrian Boychuk");
        main.clickAdvancedSearch();
        main.inputTrip(tripNumber);
        main.applyFilters();

        Assertions.assertTrue(main.isElementDisplayedByPath("//*[@data-overdue-events = 'Y']"));
    }

    @Test
    public void testEtaDateLessThanNow(){
        createTrip.inputTripStatus("new");
        createTrip.inputType("Local");
        createTrip.clickRadioOrder();
        createTrip.inputDispatcher("Adrian Boychuk");
        createTrip.clickBtnSave();
        String tripNumber = mainFleet.getTripNumber();
        mainFleet.clickBtnOpenTransaction();
        mainFleet.saveNewTransaction();

        mainFleet.clickBtnAddNewEvent();
        createEvent.inputEventType("load");
        createEvent.inputPlace("NEW YORK OF STATE");
        createEvent.inputEtaDateFuture();
        createEvent.apllyChanges();

        mainFleet.btnCommitTransaction.click();
        mainFleet.btnYesConfirm.click();

        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/fleet/manager/cpDispatchers/#/");
        mainList.openTabMonitor();
        main.inputDispatcher("Adrian Boychuk");
        main.clickAdvancedSearch();
        main.inputTrip(tripNumber);
        main.applyFilters();

        Assertions.assertTrue(main.isElementDisplayedByPath("//*[@data-overdue-events = 'Y']"));
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
