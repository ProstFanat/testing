package fleetEventsOld.test;

import fleetEventsOld.*;
import fleetEventsOld.resources.ConfPropertiesFleet;

import org.junit.jupiter.api.*;
import resources.AppConstants;
import org.openqa.selenium.WebDriver;
import resources.AppConstants;
;
import resources.BasePage;
import resources.AppConstants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CreateNewTrip {

    public static WebDriver driver;
    public static OpenFleetPage open;
    public static createNewFleetEvent createTrip;
    public static mainFleet main;
    public static editEvent edit;
    public static filterFleet filter;
    public static BasePage basePage;
    public static LogOut logOut;
    public static TripBoard tripBoard;

    @BeforeAll
    static void setup() {
//        //определение пути до драйвера и его настройка
//         System.setProperty("webdriver.chrome.driver", ConfPropertiesFleet.getProperty("chromedriver"));
//        //создание экземпляра драйвера
//        driver = new ChromeDriver();
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        driver = getWebDriver();
        open = new OpenFleetPage(driver);
        createTrip = new createNewFleetEvent(driver);
        main = new mainFleet(driver);
        edit = new editEvent(driver);
        filter = new filterFleet(driver);
        basePage = new BasePage(driver);
        logOut = new LogOut(driver);
        tripBoard = new TripBoard(driver);
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        open.openFleetEvents();
        basePage.sleep(1000);
    }

    @BeforeEach
    void before(){
    }

    @Test
    public void testCancel(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        createTrip.openFormCreate();
        createTrip.inputComment(ConfPropertiesFleet.getProperty("fleet.comment"));
        createTrip.inputTripStatus(ConfPropertiesFleet.getProperty("fleet.tripStatus"));
        createTrip.inputType(ConfPropertiesFleet.getProperty("fleet.tripType"));
        createTrip.inputDriver1(ConfPropertiesFleet.getProperty("fleet.driver1"));
        createTrip.inputDriver2(ConfPropertiesFleet.getProperty("fleet.driver2"));
        createTrip.inputDispatcher(ConfPropertiesFleet.getProperty("fleet.dispatcher"));
        createTrip.inputTruck(ConfPropertiesFleet.getProperty("fleet.truck"));
        createTrip.inputTrailer(ConfPropertiesFleet.getProperty("fleet.trailer"));
        createTrip.inputPlace();
        createTrip.btnCancel.click();
        Assertions.assertNotEquals(main.getTripNumber(), lastTripNumber);
//        Assertions.assertFalse(basePage.isElementDisplayedByPath("//*[text() = 'Trip #: ']"));
    }

    @Test
    public void testSave(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
        createTrip.inputComment(ConfPropertiesFleet.getProperty("fleet.comment"));
        createTrip.inputTripStatus(ConfPropertiesFleet.getProperty("fleet.tripStatus"));
        createTrip.inputType(ConfPropertiesFleet.getProperty("fleet.tripType"));
        createTrip.inputDriver1(ConfPropertiesFleet.getProperty("fleet.driver1"));
        createTrip.inputDriver2(ConfPropertiesFleet.getProperty("fleet.driver2"));
        createTrip.inputDispatcher(ConfPropertiesFleet.getProperty("fleet.dispatcher"));
        createTrip.inputTruck(ConfPropertiesFleet.getProperty("fleet.truck"));
        createTrip.inputTrailer(ConfPropertiesFleet.getProperty("fleet.trailer"));
        createTrip.inputPlace();
        createTrip.clickBtnSave();

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);
        //Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Trip #: ']"));
    }

    @Test
    public void testAddAndDeleteOrder(){
        createTrip.openFormCreate();
        createTrip.inputOrder("CO-20-61201");
        createTrip.deleteOrder();
        createTrip.clickBtnCancel();
        Assertions.assertFalse(basePage.isElementDisplayedByPath("//*[contains(text(), 'Order # CO-20-61201')"));
//        createTrip.clickBtnCancel();
    }

    @Test
    public void testAddOrdersAndDeleteAll(){
        createTrip.openFormCreate();
        createTrip.inputOrder("CO-20-61201");
        createTrip.inputOrder("CO-20-61202");
        createTrip.clickRadioOrder();
        basePage.waitToBeClickable(10, createTrip.btnConfirmDeleteOrder);
        basePage.waitToVisibilityOf(10, createTrip.btnConfirmDeleteOrder);
        createTrip.btnConfirmDeleteOrder.click();
        Assertions.assertFalse(createTrip.radioOrder.isSelected());
//        createTrip.clickBtnCancel();
    }

    @Test
    public void testOrderWithoutProbill(){
        createTrip.openFormCreate();
        createTrip.inputOrder("CO-20-61200");
        Assertions.assertFalse(createTrip.isOrderDoesNotHaveProbills("CO-20-61200"));
//        createTrip.clickBtnCancel();
    }

    @Test
    public void testAddOrderAndSave(){
        createTrip.openFormCreate();
        createTrip.inputTripStatus(ConfPropertiesFleet.getProperty("fleet.tripStatus"));
        createTrip.inputType(ConfPropertiesFleet.getProperty("fleet.tripType"));
        createTrip.inputOrder("CO-20-61202");
        createTrip.clickBtnSave();
        main.sleep(500);
        Assertions.assertTrue(main.isOrderInTable("CO-20-61202"));
    }

    @Test
    public void testBasedOnPlace(){
        createTrip.openFormCreate();
        createTrip.inputTripStatus(ConfPropertiesFleet.getProperty("fleet.tripStatus"));
        createTrip.inputType(ConfPropertiesFleet.getProperty("fleet.tripType"));
        createTrip.inputPlace();
        createTrip.clickBtnSave();
        Assertions.assertTrue(main.isPlaceInTable());
    }

    @Test
    public void testNotificationWithoutEmail(){
        createTrip.openFormCreate();
        //createTrip.inputComment(ConfPropertiesFleet.getProperty("fleet.comment"));
        createTrip.inputTripStatus(ConfPropertiesFleet.getProperty("fleet.tripStatus"));
        createTrip.inputType(ConfPropertiesFleet.getProperty("fleet.tripType"));
        createTrip.inputDriver1(ConfPropertiesFleet.getProperty("fleet.driver1"));
        createTrip.inputDriver2(ConfPropertiesFleet.getProperty("fleet.driver2"));
        createTrip.inputDispatcher(ConfPropertiesFleet.getProperty("fleet.dispatcher"));
        createTrip.inputTruck(ConfPropertiesFleet.getProperty("fleet.truck"));
        createTrip.inputTrailer(ConfPropertiesFleet.getProperty("fleet.trailer"));
        createTrip.inputStartDate();
        createTrip.inputFinishDate();
        createTrip.inputPlace();
        createTrip.setNotificationTime();
        createTrip.clickBtnSave();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//div[contains(text(), 'Notification Email is a required field!')]"));
;;        createTrip.clickBtnCancel();
    }

    @Test
    public void testNotificationWithEmail(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
//        createTrip.inputComment(ConfPropertiesFleet.getProperty("fleet.comment"));
        createTrip.inputTripStatus(ConfPropertiesFleet.getProperty("fleet.tripStatus"));
        createTrip.inputType(ConfPropertiesFleet.getProperty("fleet.tripType"));
        createTrip.inputDriver1(ConfPropertiesFleet.getProperty("fleet.driver1"));
        createTrip.inputDriver2(ConfPropertiesFleet.getProperty("fleet.driver2"));
        createTrip.inputDispatcher(ConfPropertiesFleet.getProperty("fleet.dispatcher"));
        createTrip.inputTruck(ConfPropertiesFleet.getProperty("fleet.truck"));
        createTrip.inputTrailer(ConfPropertiesFleet.getProperty("fleet.trailer"));
        createTrip.inputStartDate();
        createTrip.inputFinishDate();
        createTrip.inputPlace();
        createTrip.inputNotificationEmail("test@mail.com");
        createTrip.clickBtnSave();

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);
        //Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Trip #: ']"));
    }

    @Test
    public void testWithoutStatus(){
        createTrip.openFormCreate();
        createTrip.inputType(ConfPropertiesFleet.getProperty("fleet.tripType"));
        createTrip.inputPlace();
        createTrip.clickBtnSave();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[@aria-label = 'Trip Status is a required field!']"));
 //       createTrip.clickBtnCancel();
    }

    @Test
    public void testWithoutType(){
        createTrip.openFormCreate();
        createTrip.inputTripStatus(ConfPropertiesFleet.getProperty("fleet.tripStatus"));
        createTrip.inputPlace();
        createTrip.clickBtnSave();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[@aria-label = 'Trip Type is a required field!']"));
 //       createTrip.clickBtnCancel();
    }

    @Test
    public void testWithoutFinishDate(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
        createTrip.inputTripStatus(ConfPropertiesFleet.getProperty("fleet.tripStatus"));
        createTrip.inputType(ConfPropertiesFleet.getProperty("fleet.tripType"));
        createTrip.inputStartDate();
        createTrip.inputPlace();
        createTrip.clickBtnSave();

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);
        //Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[text() = 'Trip #: ']"));
    }

    @Test
    public void testWithoutStartDate(){
        createTrip.openFormCreate();
        createTrip.inputTripStatus(ConfPropertiesFleet.getProperty("fleet.tripStatus"));
        createTrip.inputType(ConfPropertiesFleet.getProperty("fleet.tripType"));
        createTrip.inputFinishDate();
        createTrip.inputPlace();
        createTrip.clickBtnSave();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[@aria-label = 'Please select a Start Date']"));
 //       createTrip.clickBtnCancel();
    }

    @Test
    public void testWhenStartDateLessThenFinish(){
        createTrip.openFormCreate();
        createTrip.inputTripStatus(ConfPropertiesFleet.getProperty("fleet.tripStatus"));
        createTrip.inputType(ConfPropertiesFleet.getProperty("fleet.tripType"));
        createTrip.inputStartDateLessThenFinishDate();
        createTrip.inputPlace();
        createTrip.clickBtnSave();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[@id ='toast-container']//div[contains(@aria-label, 'The Start Date')]"));
//        createTrip.clickBtnCancel();
    }

    @Test
    public void testBasedOnOrderWithoutOrder(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
        createTrip.inputTripStatus(ConfPropertiesFleet.getProperty("fleet.tripStatus"));
        createTrip.inputType(ConfPropertiesFleet.getProperty("fleet.tripType"));
        createTrip.clickRadioOrder();
        createTrip.clickBtnSave();

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);
    }

    @Test
    public void testBasedOnPlaceWithoutPlace(){
        createTrip.openFormCreate();
        createTrip.inputTripStatus(ConfPropertiesFleet.getProperty("fleet.tripStatus"));
        createTrip.inputType(ConfPropertiesFleet.getProperty("fleet.tripType"));
        createTrip.clickBtnSave();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[@id ='toast-container']//div[contains(@aria-label, 'Please select one')]"));
//        createTrip.clickBtnCancel();
    }

    @Test
    public void testBasedOnPlaceWithoutAll(){
        createTrip.openFormCreate();
        createTrip.clickBtnSave();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[@aria-label = 'Trip Status is a required field!']"));
//        createTrip.clickBtnCancel();
    }

    @Test
    public void testWithSameDrivers(){
        createTrip.openFormCreate();
        createTrip.inputTripStatus("new");
        createTrip.inputType("Local");
        createTrip.inputDriver1SameDriver2(ConfPropertiesFleet.getProperty("fleet.driver1"));
        createTrip.inputPlace();
        createTrip.clickBtnSave();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[@aria-label = 'Driver 1 and Driver 2 is the same!']"));
//        createTrip.clickBtnCancel();
    }

    /***/
    @Test
    public void testStatusNewTypeHighway(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
        createTrip.createTrip("new", "Highway");

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);
//        createTrip.clickBtnCancel();
    }

    @Test
    public void testStatusDispatchedTypeHighway(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
        createTrip.createTrip("dispatched", "Highway");

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);

//        createTrip.clickBtnCancel();
    }

    @Test
    public void testStatusCancelledTypeHighway(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
        createTrip.createTrip("cancelled", "Highway");

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);

//        createTrip.clickBtnCancel();
    }

    @Test
    public void testStatusDoneTypeHighway(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
        createTrip.createTrip("done", "Highway");

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);
//        createTrip.clickBtnCancel();
    }

    @Test
    public void testStatusBookedTypeHighway(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
        createTrip.createTrip("booked", "Highway");

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);
//        createTrip.clickBtnCancel();
    }

    /***/
    @Test
    public void testStatusNewTypeHighwayLocal(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);


        createTrip.openFormCreate();
        createTrip.createTrip("new", "Highway/Local");

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);
//        createTrip.clickBtnCancel();
    }

    @Test
    public void testStatusDispatchedTypeHighwayLocal(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
        createTrip.createTrip("dispatched", "Highway/Local");

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);
//        createTrip.clickBtnCancel();
    }

    @Test
    public void testStatusCancelledTypeHighwayLocal(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
        createTrip.createTrip("cancelled", "Highway/Local");

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);
//        createTrip.clickBtnCancel();
    }

    @Test
    public void testStatusDoneTypeHighwayLocal(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
        createTrip.createTrip("done", "Highway/Local");

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);
//        createTrip.clickBtnCancel();
    }

    @Test
    public void testStatusBookedTypeHighwayLocal(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
        createTrip.createTrip("booked", "Highway/Local");

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);
//        createTrip.clickBtnCancel();
    }

    /***/
    @Test
    public void testStatusNewTypeLocal(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
        createTrip.createTrip("new", "Local");

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);
//        createTrip.clickBtnCancel();
    }

    @Test
    public void testStatusDispatchedTypeLocal(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
        createTrip.createTrip("dispatched", "Local");

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);
//        createTrip.clickBtnCancel();
    }

    @Test
    public void testStatusCancelledTypeLocal(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
        createTrip.createTrip("cancelled", "Local");

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);
//        createTrip.clickBtnCancel();
    }

    @Test
    public void testStatusDoneTypeLocal(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
        createTrip.createTrip("done", "Local");

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);
//        createTrip.clickBtnCancel();
    }

    @Test
    public void testStatusBookedTypeLocal(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
        createTrip.createTrip("booked", "Local");

        int currentTripNumber = Integer.parseInt(main.getTripNumber());
        Assertions.assertEquals(currentTripNumber, tripNumber + 1);
//        createTrip.clickBtnCancel();
    }

    @AfterEach
    void beforeTest(){
       driver.navigate().refresh();
    }


    @AfterAll
    public static void tearDown() {
       driver.quit();
    }
}
