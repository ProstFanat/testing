package Main;

import Login.Login;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import resources.BasePage;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import java.util.concurrent.TimeUnit;

public class Test111 {

    public static WebDriver driver;
    public static BasePage basePage;
    public static Login login;

    @BeforeClass
    public static void setup() {
        Configuration.timeout = 100000;

        open("http://localhost:8080/TrackEnsure/login.do");
        driver = getWebDriver();
        basePage = new BasePage(driver);
        login = new Login(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        login.login("10");
    }

    @Before
    public void before(){

    }

    @Test
    public void test(){
        System.out.println("hello world");
    }

    @After
    public void afterTest(){
        Selenide.refresh();
    }

    @AfterClass
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}
