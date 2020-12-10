package fleetEventsOld.test;

import fleetEventsOld.*;
import fleetEventsOld.resources.ConfPropertiesFleet;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TripNotifications {

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
    public static void setup() {
//        //определение пути до драйвера и его настройка
//        System.setProperty("webdriver.chrome.driver", ConfPropertiesFleet.getProperty("chromedriver"));
//        //создание экземпляра драйвера
//        driver = new ChromeDriver();
        open("http://localhost:8080/TrackEnsure/login.do");
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
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfPropertiesFleet.getProperty("loginPage"));
        open.openFleetEvents();
        basePage.sleep(1000);
    }

    @Test
    public void test(){
        String lastTripNumber = tripBoard.getLastTripNumber();
        int tripNumber = Integer.parseInt(lastTripNumber);

        createTrip.openFormCreate();
        createTrip.inputTripStatus(ConfPropertiesFleet.getProperty("fleet.tripStatus"));
        createTrip.inputType(ConfPropertiesFleet.getProperty("fleet.tripType"));
        createTrip.inputDriver1(ConfPropertiesFleet.getProperty("fleet.driver1"));
        createTrip.inputDriver1("Adrian");
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
