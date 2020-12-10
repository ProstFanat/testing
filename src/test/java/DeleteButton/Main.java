package DeleteButton;

import DeleteButton.resources.ConfPropertiesELD;

import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {

    public static LoginPage loginPage;
    public static LogOut logOut;
    public static WebDriver driver;
    public static DeleteButton deletebutton;

    @BeforeAll
    static void setup() {
//        //определение пути до драйвера и его настройка
//        System.setProperty("webdriver.chrome.driver", ConfPropertiesELD.getProperty("chromedriver"));
//        //создание экземпляра драйвера
//        driver = new ChromeDriver();
        open("http://localhost:8080/TrackEnsure/login.do");
        driver = getWebDriver();
        loginPage = new LoginPage(driver);
        logOut = new LogOut(driver);
        deletebutton = new DeleteButton(driver);
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfPropertiesELD.getProperty("loginpage"));
    }

    /** Create by: Fleet */

    @Test
    public void createFleetDeleteFleet() throws IOException {
        deletebutton.create(1);
        deletebutton.deleteCheck(1, 1);
    }

    @Test
    public void createFleetDeleteSupportTL() throws IOException {
        deletebutton.create(1);
        deletebutton.deleteCheck(1, 2);
    }

    @Test
    public void createFleetDeleteSupport() throws IOException {
        deletebutton.create(1);
        deletebutton.deleteCheck(1, 3);
    }

    @Test
    public void createFleetDeleteEditorTL() throws IOException {
        deletebutton.create(1);
        deletebutton.deleteCheck(1, 4);
    }

    @Test
    public void createFleetDeleteEditor() throws IOException {
        deletebutton.create(1);
        deletebutton.deleteCheck(1, 5);
    }

    /** Create by: Support TL */

    @Test
    public void createSupportTLDeleteFleet() throws IOException {
        deletebutton.create(2);
        deletebutton.deleteCheck(2, 1);
    }

    @Test
    public void createSupportTLDeleteSupportTL() throws IOException {
        deletebutton.create(2);
        deletebutton.deleteCheck(2, 2);
    }

    @Test
    public void createSupportTLDeleteSupport() throws IOException {
        deletebutton.create(2);
        deletebutton.deleteCheck(2, 3);
    }

    @Test
    public void createSupportTLDeleteEditorTL() throws IOException {
        deletebutton.create(2);
        deletebutton.deleteCheck(2, 4);
    }

    @Test
    public void createSupportTDeleteEditor() throws IOException {
        deletebutton.create(2);
        deletebutton.deleteCheck(2, 5);
    }

    /** Create by: Support */

    @Test
    public void createSupportDeleteFleet() throws IOException {
        deletebutton.create(3);
        deletebutton.deleteCheck(3, 1);
    }

    @Test
    public void createSupportDeleteSupportTL() throws IOException {
        deletebutton.create(3);
        deletebutton.deleteCheck(3, 2);
    }

    @Test
    public void createSupportDeleteSupport() throws IOException {
        deletebutton.create(3);
        deletebutton.deleteCheck(3, 3);
    }

    @Test
    public void createSupportDeleteEditorTL() throws IOException {
        deletebutton.create(3);
        deletebutton.deleteCheck(3, 4);
    }

    @Test
    public void createSupportDeleteEditor() throws IOException {
        deletebutton.create(3);
        deletebutton.deleteCheck(3, 5);
    }

    /** Create by: Editor TL*/

    @Test
    public void createEditorTLDeleteFleet() throws IOException {
        deletebutton.create(4);
        deletebutton.deleteCheck(4, 1);
    }

    @Test
    public void createEditorTLDeleteSupportTL() throws IOException {
        deletebutton.create(4);
        deletebutton.deleteCheck(4, 2);
    }

    @Test
    public void createEditorTLDeleteSupport() throws IOException {
        deletebutton.create(4);
        deletebutton.deleteCheck(4, 3);
    }

    @Test
    public void createEditorTLDeleteEditorTL() throws IOException {
        deletebutton.create(4);
        deletebutton.deleteCheck(4, 4);
    }

    @Test
    public void createEditorTLDeleteEditor() throws IOException {
        deletebutton.create(4);
        deletebutton.deleteCheck(4, 5);
    }

    /** Create by: Editor*/

    @Test
    public void createEditorDeleteFleet() throws IOException {
        deletebutton.create(5);
        deletebutton.deleteCheck(5, 1);
    }

    @Test
    public void createEditorDeleteSupportTL() throws IOException {
        deletebutton.create(5);
        deletebutton.deleteCheck(5, 2);
    }

    @Test
    public void createEditorDeleteSupport() throws IOException {
        deletebutton.create(5);
        deletebutton.deleteCheck(5, 3);
    }

    @Test
    public void createEditorDeleteEditorTL() throws IOException {
        deletebutton.create(5);
        deletebutton.deleteCheck(5, 4);
    }

    @Test
    public void createEditorDeleteEditor() throws IOException {
        deletebutton.create(5);
        deletebutton.deleteCheck(5, 5);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
