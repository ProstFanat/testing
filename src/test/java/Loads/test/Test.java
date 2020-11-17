package Loads.test;

import Loads.OpenLoads;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import resources.BasePage;
import resources.ConfProperties;

import java.util.concurrent.TimeUnit;

public class Test {
    public static WebDriver driver;
    public static BasePage basePage;
    public static OpenLoads open;

    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        open = new OpenLoads(driver);
        basePage = new BasePage(driver);
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/TrackEnsure/login.do");
        open.openPage();
        basePage.sleep(1000);
    }

    @Before
    public void before(){

    }

    @org.junit.Test
    public void test(){

    }




    @After
    public void afterTest(){
        driver.navigate().refresh();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
