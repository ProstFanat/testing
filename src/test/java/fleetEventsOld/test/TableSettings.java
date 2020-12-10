package fleetEventsOld.test;

import fleetEventsOld.*;
import fleetEventsOld.resources.ConfPropertiesFleet;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TableSettings {

    public static WebDriver driver;
    public static WebDriver driverF;
    public static OpenFleetPage open;
    public static createNewFleetEvent createTrip;
    public static mainFleet main;
    public static editEvent edit;
    public static filterFleet filter;
    public static BasePage basePage;
    public static LogOut logOut;

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
        open.findTrip("716252");
    }

    @BeforeEach
    public void beforeTest(){
        main.clickBtnShowColumns();
    }

    @Test
    public void testClearAllBtnAll(){
        main.clickRadioAll();

        if(main.radioAll.isSelected()){
            if(main.radioSEQ.isSelected()){
                if(main.radioTRUCK.isSelected()){
                    if(main.radioTrailer.isSelected()){
                        if(main.radioDriver1.isSelected()){
                            if(main.radioDriver2.isSelected()){
                                if(main.radioProbill.isSelected()){
                                    if(main.radioETA.isSelected()){
                                        if(main.radioStartDate.isSelected()){
                                            if(main.radioFinishDate.isSelected()){
                                                if(main.radioStatus.isSelected()){
                                                    Assertions.assertTrue(false);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    Assertions.assertTrue(true);
    main.clickRadioAll();
    main.clickBtnShowColumns();
    }

    @Test
    public void testClearAll(){
        main.clickRadioSEQ();
        main.clickRadioTruck();
        main.clickRadioTrailer();
        main.clickRadioDriver1();
        main.clickRadioDriver2();
        main.clickRadioProbill();
        main.clickRadioETA();
        main.clickRadioStartDate();
        main.clickRadioFinishDate();
        main.clickRadioStatus();
        Assertions.assertFalse(main.radioAll.isSelected());
        main.clickRadioAll();
        main.clickBtnShowColumns();
    }

    @Test
    public void testAddAll(){
        main.clickRadioAll();
        main.clickRadioSEQ();
        main.clickRadioTruck();
        main.clickRadioTrailer();
        main.clickRadioDriver1();
        main.clickRadioDriver2();
        main.clickRadioProbill();
        main.clickRadioETA();
        main.clickRadioStartDate();
        main.clickRadioFinishDate();
        main.clickRadioStatus();
        Assertions.assertTrue(main.radioAll.isSelected());
        main.clickBtnShowColumns();
    }

    ////////
    @Test
    public void testInTableSEQ(){
        main.clickRadioSEQ();
        main.clickBtnShowColumns();
        Assertions.assertFalse(basePage.isElementDisplayed(main.columnSEQ));
        main.clickBtnShowColumns();
        main.clickRadioSEQ();
        main.clickBtnShowColumns();
    }

    @Test
    public void testInTableTruck() {
        main.clickRadioTruck();
        main.clickBtnShowColumns();
        Assertions.assertFalse(basePage.isElementDisplayed(main.columnTRUCK));
        main.clickBtnShowColumns();
        main.clickRadioTruck();
        main.clickBtnShowColumns();
    }

    @Test
    public void testInTableTrailer() {
        main.clickRadioTrailer();
        main.clickBtnShowColumns();
        Assertions.assertFalse(basePage.isElementDisplayed(main.columnTrailer));
        main.clickBtnShowColumns();
        main.clickRadioTrailer();
        main.clickBtnShowColumns();
    }

    @Test
    public void testInTableDriver1() {
        main.clickRadioDriver1();
        main.clickBtnShowColumns();
        Assertions.assertFalse(basePage.isElementDisplayed(main.columnDriver1));
        main.clickBtnShowColumns();
        main.clickRadioDriver1();
        main.clickBtnShowColumns();
    }

    @Test
    public void testInTableDriver2() {
        main.clickRadioDriver2();
        main.clickBtnShowColumns();
        Assertions.assertFalse(basePage.isElementDisplayed(main.columnDriver2));
        main.clickBtnShowColumns();
        main.clickRadioDriver2();
        main.clickBtnShowColumns();
    }

    @Test
    public void testInTableProbill() {
        main.clickRadioProbill();
        main.clickBtnShowColumns();
        Assertions.assertFalse(basePage.isElementDisplayed(main.columnProbill));
        main.clickBtnShowColumns();
        main.clickRadioProbill();
        main.clickBtnShowColumns();
    }

    @Test
    public void testInTableETA() {
        main.clickRadioETA();
        main.clickBtnShowColumns();
        Assertions.assertFalse(basePage.isElementDisplayed(main.columnETA));
        main.clickBtnShowColumns();
        main.clickRadioETA();
        main.clickBtnShowColumns();
    }

    @Test
    public void testInTableStartDate() {
        main.clickRadioStartDate();
        main.clickBtnShowColumns();
        Assertions.assertFalse(basePage.isElementDisplayed(main.columnStartDate));
        main.clickBtnShowColumns();
        main.clickRadioStartDate();
        main.clickBtnShowColumns();
    }

    @Test
    public void testInTableFinishDate() {
        main.clickRadioFinishDate();
        main.clickBtnShowColumns();
        Assertions.assertFalse(basePage.isElementDisplayed(main.columnFinishDate));
        main.clickBtnShowColumns();
        main.clickRadioFinishDate();
        main.clickBtnShowColumns();
    }

    @Test
    public void testInTableStatus() {
        main.clickRadioStatus();
        main.clickBtnShowColumns();
        Assertions.assertFalse(basePage.isElementDisplayed(main.columnStatus));
        main.clickBtnShowColumns();
        main.clickRadioStatus();
        main.clickBtnShowColumns();
    }

    @Test
    public void testReLogInWithoutSave(){
        if(main.radioAll.isSelected()){
            main.clickRadioDriver1();
            logOut.userLogout();
            driver.get("http://localhost:8080/TrackEnsure/login.do");
            open.openFleetEvents();
            basePage.sleep(1000);
            open.findTrip("714947");
            Assertions.assertTrue(basePage.isElementDisplayed(main.columnDriver1));
        } else {
            main.clickRadioAll();
            main.clickRadioDriver1();
            logOut.userLogout();
            driver.get("http://localhost:8080/TrackEnsure/login.do");
            open.openFleetEvents();
            basePage.sleep(1000);
            open.findTrip("714947");
            Assertions.assertTrue(basePage.isElementDisplayed(main.columnDriver1));
        }
    }

    @Test
    public void testReLogInWithSave(){
        if(main.radioAll.isSelected()){
            main.clickRadioDriver1();
            main.saveColumns();
            logOut.userLogout();
            driver.get("http://localhost:8080/TrackEnsure/login.do");
            open.openFleetEvents();
            basePage.sleep(1000);
            open.findTrip("714947");
            Assertions.assertFalse(basePage.isElementDisplayed(main.columnDriver1));
            main.clickBtnShowColumns();
            main.clickRadioDriver1();
        } else {
            main.clickRadioAll();
            main.clickRadioDriver1();
            main.saveColumns();
            logOut.userLogout();
            driver.get("http://localhost:8080/TrackEnsure/login.do");
            open.openFleetEvents();
            basePage.sleep(1000);
            open.findTrip("714947");
            Assertions.assertFalse(basePage.isElementDisplayed(main.columnDriver1));
            main.clickBtnShowColumns();
            main.clickRadioDriver1();
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
