package DispatcherManager.test;

import DispatcherManager.dispatcherList;
import DispatcherManager.dispatcherMonitor;
import DispatcherManager.openDispatcher;
import fleetEvents.fleet.OpenFleetPage;
import fleetEvents.fleet.createNewFleetEvent;
import fleetEvents.fleet.mainFleet;
import fleetEvents.fleet.resources.ConfPropertiesFleet;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MonitorShowActive {

    public static WebDriver driver;
    public static openDispatcher open;
    public static createNewFleetEvent createTrip;
    public static fleetEvents.fleet.mainFleet mainFleet;
    public static BasePage basePage;
    public static dispatcherList mainList;
    public static dispatcherMonitor main;
    public static OpenFleetPage openFleet;

    @BeforeAll
    public static void setup() {
//        //определение пути до драйвера и его настройка
//        System.setProperty("webdriver.chrome.driver", ConfPropertiesFleet.getProperty("chromedriver"));
//        //создание экземпляра драйвера
//        driver = new ChromeDriver();
        open("http://localhost:8080/TrackEnsure/login.do");
        driver = getWebDriver();
        open = new openDispatcher(driver);
        createTrip = new createNewFleetEvent(driver);
        mainFleet = new mainFleet(driver);
        basePage = new BasePage(driver);
        driver.manage().window().maximize();
        main = new dispatcherMonitor(driver);
        mainList = new dispatcherList(driver);
        openFleet = new OpenFleetPage(driver);
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get("http://localhost:8080/TrackEnsure/login.do");
        openFleet.openFleetEvents();
        basePage.sleep(1000);
    }

    @BeforeEach
    public void beforeTest(){
    }

    @Test
    public void testStatusNew(){
        driver.get("http://localhost:8080/TrackEnsure/app/fleet-events/#/trip-view(details:trip-view-details)");

        createTrip.openFormCreate();
        createTrip.createTripWithDispatcher("new", "Local");
        String trip = mainFleet.getTripNumber();


        driver.get("http://localhost:8080/TrackEnsure/fleet/manager/cpDispatchers/#/");
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
        driver.get("http://localhost:8080/TrackEnsure/app/fleet-events/#/trip-view(details:trip-view-details)");

        createTrip.openFormCreate();
        createTrip.createTripWithDispatcher("dispatched", "Local");
        String trip = mainFleet.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/fleet/manager/cpDispatchers/#/");
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
        driver.get("http://localhost:8080/TrackEnsure/app/fleet-events/#/trip-view(details:trip-view-details)");

        createTrip.openFormCreate();
        createTrip.createTripWithDispatcher("booked", "Local");
        String trip = mainFleet.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/fleet/manager/cpDispatchers/#/");
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
        driver.get("http://localhost:8080/TrackEnsure/app/fleet-events/#/trip-view(details:trip-view-details)");

        createTrip.openFormCreate();
        createTrip.createTripWithDispatcher("done", "Local");
        String trip = mainFleet.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/fleet/manager/cpDispatchers/#/");
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
        driver.get("http://localhost:8080/TrackEnsure/app/fleet-events/#/trip-view(details:trip-view-details)");

        createTrip.openFormCreate();
        createTrip.createTripWithDispatcher("cancelled", "Local");
        String trip = mainFleet.getTripNumber();

        driver.get("http://localhost:8080/TrackEnsure/fleet/manager/cpDispatchers/#/");
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
    public void afterTests(){
        driver.navigate().refresh();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
