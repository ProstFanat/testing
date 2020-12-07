package DispatcherManager.test;

import DispatcherManager.dispatcherList;
import DispatcherManager.dispatcherMonitor;
import DispatcherManager.openDispatcher;
import fleetEvents.fleet.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MonitorAdvancedSearch {

    public static WebDriver driver;
    public static openDispatcher open;
    public static createNewFleetEvent createTrip;
    public static mainFleet mainFleet;
    public static BasePage basePage;
    public static dispatcherList mainList;
    public static dispatcherMonitor main;

    @BeforeClass
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
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get("http://localhost:8080/TrackEnsure/login.do");
        open.openDispatchers();
        basePage.sleep(1000);
    }

    @Before
    public void beforeTest(){
        mainList.openTabMonitor();
        main.inputDispatcher("Kirk West");
        main.clickAdvancedSearch();
    }

    @Test
    public void testFilterByTripNumber(){
        main.inputTrip("715685");
        main.applyFilters();
        Assert.assertTrue(main.filterBy("715685", "tripNumber"));
    }

    @Test
    public void testFilterByTripStatus(){
        main.inputStatus("booked");
        main.applyFilters();
        Assert.assertTrue(main.filterBy("booked", "status"));
    }

    @Test
    public void testFilterByTripType(){
        main.inputType("Highway/Local");
        main.applyFilters();
        Assert.assertTrue(main.filterBy("Highway/Local", "type"));
    }

    @Test
    public void testFilterByTripDriver(){
        main.inputDriver("Valeri Belioutsa");
        main.applyFilters();
        Assert.assertTrue(main.filterBy("Valeri Belioutsa", "driver1"));
    }

    @Test
    public void testFilterByTripTruck(){
        main.inputTruck("0108632412");
        main.applyFilters();
        Assert.assertTrue(main.filterBy("0108632412", "truck"));
    }

    @Test
    public void testFilterByTripTrailer(){
        main.inputTrailer("1210T");
        main.applyFilters();
        Assert.assertTrue(main.filterBy("1210T", "trailer"));
    }

    @Test
    public void testFilterWithAll(){
        main.inputTrip("715685");
        main.inputStatus("booked");
        main.inputType("Highway/Local");
        main.inputDriver("Valeri Belioutsa");
        main.inputTruck("0108632412");
        main.inputTrailer("1210T");
        main.applyFilters();
        if(main.filterBy("715685", "tripNumber")){
            if(main.filterBy("booked", "status")){
                if(main.filterBy("Highway/Local", "type")){
                    if(main.filterBy("Valeri Belioutsa", "driver1")){
                        if(main.filterBy("0108632412", "truck")){
                            if(main.filterBy("1210T", "trailer")){
                                Assert.assertTrue(true);
                            } else {
                                Assert.assertTrue(false);
                            }
                        } else {
                            Assert.assertTrue(false);
                        }
                    } else {
                        Assert.assertTrue(false);
                    }
                } else {
                    Assert.assertTrue(false);
                }
            } else {
                Assert.assertTrue(false);
            }
        } else {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testValidationTripNumberSearch(){
        main.inputTrip("1234567890123456");
        Assert.assertEquals("123456789012345", main.getInputValue(main.tripInput));
    }

    @Test
    public void testChangeDispatcher(){
        main.inputTrip("715685");

        main.dispatcherInputLi.click();
        main.inputDispatcher("TestAdrian716981");

        if("715685".equals(main.getInputValue(main.tripInput))){
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @After
    public void afterTests(){
        driver.navigate().refresh();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
