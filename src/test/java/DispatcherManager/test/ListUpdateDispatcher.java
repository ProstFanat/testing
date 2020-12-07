package DispatcherManager.test;

import DispatcherManager.dispatcherList;
import DispatcherManager.dispatcherMonitor;
import DispatcherManager.openDispatcher;
import fleetEvents.fleet.OpenFleetPage;
import fleetEvents.fleet.createNewFleetEvent;
import fleetEvents.fleet.mainFleet;
import fleetEvents.fleet.resources.ConfPropertiesFleet;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ListUpdateDispatcher {

    public static WebDriver driver;
    public static openDispatcher open;
    public static createNewFleetEvent createTrip;
    public static fleetEvents.fleet.mainFleet mainFleet;
    public static BasePage basePage;
    public static dispatcherList main;
    public static dispatcherMonitor mainMonitor;
    public static OpenFleetPage openFleet;



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
        mainMonitor = new dispatcherMonitor(driver);
        main= new dispatcherList(driver);
        openFleet = new OpenFleetPage(driver);
        open = new openDispatcher(driver);
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get("http://localhost:8080/TrackEnsure/login.do");
        open.openDispatchers();
        basePage.sleep(1000);
    }

    @Before
    public void beforeTest(){
    }

    @Test
    public void testUpdateAndSave(){
        int number = (int) (Math.random() * 1000000);
        main.createNewDispatcher("testAdrian" + number);
        main.updateDispatcher("testAdrian" + number, "testAdrian" + number + 1);

        main.inputSearchDispatcher("testAdrian" + number);
        if(!( main.table.size() == 0)) {
            main.inputSearchDispatcher("testAdrian" + number + 1);
            Assert.assertEquals(main.name.getText(), "testAdrian" + number + 1);
        }
    }

    @Test
    public void testUpdateAndCancel(){
        int number = (int) (Math.random() * 1000000);

        main.createNewDispatcher("testAdrian" + number);

        main.openFormUpdate("testAdrian" + number);
        main.waitToVisibilityOf(10, main.inputDispatcherName);
        main.inputDispatcherName.clear();
        main.inputDispatcherName.sendKeys("testAdrian" + number + 1);
        main.btnCancel.click();

        main.inputSearchDispatcher("testAdrian" + number + 1);
        if(!( main.table.size() == 0)) {
            main.inputSearchDispatcher("testAdrian" + number);
            Assert.assertEquals(main.name.getText(), "testAdrian" + number);
        }
    }

    @Test
    public void testUpdateEmpty(){
        int number = (int) (Math.random() * 1000000);
        main.createNewDispatcher("testAdrian" + number);

        main.openFormUpdate("testAdrian" + number);
        main.waitToVisibilityOf(10, main.inputDispatcherName);
        main.inputDispatcherName.clear();

        Assert.assertFalse(main.btnSave.isEnabled());
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
