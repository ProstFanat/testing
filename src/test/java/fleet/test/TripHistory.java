package fleet.test;

import fleet.*;
import fleet.resources.ConfPropertiesFleet;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TripHistory {

    public static WebDriver driver;
    public static OpenFleetPage open;
    public static createNewFleetEvent createTrip;
    public static mainFleet main;
    public static editEvent edit;
    public static filterFleet filter;
    public static BasePage basePage;
    public static LogOut logOut;
    public static historyTrip action;

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
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get("http://localhost:8080/TrackEnsure/login.do");
        open.openFleetEvents();
        basePage.sleep(1000);
        open.findTrip("716525");
    }

    /** Trip History*/
    @Test
    public void testOnlyLeftVersion(){
        action.openTripHistory();
        action.selectLeftVersion1();
        int initTable = action.tableLeft.size();
        action.useVersionLeft();
        basePage.sleep(3000);
        Assertions.assertEquals(initTable, filter.table.size());
    }

    @Test
    public void testLeftAndRightUseLeft(){
        action.openTripHistory();
        action.selectLeftVersion1();
        action.selectRightVersion2();
        int initTable = action.tableLeft.size();
        action.useVersionLeft();
        basePage.sleep(3000);
        Assertions.assertEquals(initTable, filter.table.size());
    }

    @Test
    public void testOnlyRightVersion(){
        action.openTripHistory();
        action.selectRightVersion2();
        int initTable = action.tableRight.size();
        action.useVersionRight();
        basePage.sleep(3000);
        Assertions.assertEquals(initTable, filter.table.size());
    }

    @Test
    public void testLeftAndRightUseRight(){
        action.openTripHistory();
        action.selectLeftVersion1();
        action.selectRightVersion2();
        int initTable = action.tableRight.size();
        action.useVersionRight();
        basePage.sleep(3000);
        Assertions.assertEquals(initTable, filter.table.size());
    }

    @Test
    public void testLeftAndRightOneVersionUseLeft(){
        action.openTripHistory();
        action.selectLeftVersion1();
        action.selectRightVersion1();
        int initTable = action.tableLeft.size();
        action.useVersionRight();
        basePage.sleep(3000);
        Assertions.assertEquals(initTable, filter.table.size());
    }

    @Test
    public void testLeftAndRightOneVersionUseRight(){
        action.openTripHistory();
        action.selectLeftVersion1();
        action.selectRightVersion1();
        int initTable = action.tableRight.size();
        action.useVersionRight();
        basePage.sleep(3000);
        Assertions.assertEquals(initTable, filter.table.size());
    }

    @Test
    public void testLeftAndRightAndClose(){
        int initTable = filter.table.size();
        action.openTripHistory();
        action.selectLeftVersion1();
        action.selectRightVersion1();
        action.closeHistory();
        basePage.sleep(3000);
        Assertions.assertEquals(initTable, filter.table.size());
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
