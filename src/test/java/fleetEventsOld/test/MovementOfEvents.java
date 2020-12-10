package fleetEventsOld.test;

import fleetEventsOld.*;
import fleetEventsOld.resources.ConfPropertiesFleet;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MovementOfEvents {

    public static WebDriver driver;
    public static OpenFleetPage open;
    public static createNewFleetEvent createTrip;
    public static mainFleet main;
    public static editEvent edit;
    public static MoveEvents move;
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
        open("http://localhost:8080/TrackEnsure/login.do");
        driver = getWebDriver();
        open = new OpenFleetPage(driver);
        createTrip = new createNewFleetEvent(driver);
        main = new mainFleet(driver);
        edit = new editEvent(driver);
        move = new MoveEvents(driver);
        filter = new filterFleet(driver);
        basePage = new BasePage(driver);
        logOut = new LogOut(driver);
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get("http://localhost:8080/TrackEnsure/login.do");
        open.openFleetEvents();
        open.findTrip("716252");
    }

    @BeforeEach
    public void beforeTest(){
        main.clickBtnOpenTransaction();
        main.saveNewTransaction();
    }

    @Test
    public void testJustMoveDown(){
        String initType = move.getType5();
        move.moveDown5();
        basePage.sleep(500);
        Assertions.assertEquals(initType, move.getType6());
    }

    @Test
    public void testJustMoveUp(){
        String initType = move.getType6();
        move.moveUp6();
        basePage.sleep(500);
        Assertions.assertEquals(initType, move.getType5());
    }

    //////////////////////////////////////////////////////////////
    @Test
    public void testSecondEventMoveUpMessage(){
        move.moveUp2();
        basePage.sleep(500);
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), ' The Acquire event should be the first in the trip. Are you sure that you would like to change the event position?')]"));
        move.cancelMove();
    }

    @Test
    public void testSecondEventMoveUpMove(){
        String initType = move.getType2();
        move.moveUp2();
        move.applyMove();
        Assertions.assertEquals(initType,move.getType1());
//        move.moveDown1();
    }

    @Test
    public void testSecondEventMoveUpCancel() {
        String initType = move.getType2();
        move.moveUp2();
        move.cancelMove();
        Assertions.assertEquals(initType, move.getType2());
    }

    ///////////////////////////////////////////////////////////
    @Test
    public void testAcquireMoveDownMessage(){
        move.moveDown1();
        basePage.sleep(500);
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), ' The Acquire event should be the first in the trip. Are you sure that you would like to change the event position?')]"));
        move.cancelMove();
    }

    @Test
    public void testAcquireMoveDownMove(){
        String initType = move.getType1();
        move.moveDown1();
        move.applyMove();
        basePage.sleep(500);
        Assertions.assertEquals(initType, move.getType2());
//        move.moveUp2();
    }

    @Test
    public void testAcquireMoveDownCancel() {
        String initType = move.getType1();
        move.moveDown1();
        move.cancelMove();
        Assertions.assertEquals(initType, move.getType1());
    }

    /////////////////////////////////////////////////////////////////
    @Test
    public void testPreLastEventMoveDownMessage(){
        move.moveDown6();
        basePage.sleep(500);
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), ' The Release event should be the last in the trip. Are you sure that you would like to change the event position?\n')]"));
        move.cancelMove();
    }

    @Test
    public void testPreLastEventMoveDownMove(){
        String initType = move.getType6();
        move.moveDown6();
        move.applyMove();
        main.sleep(500);
        Assertions.assertEquals(initType, move.getType7());
//        move.moveUp7();
    }

    @Test
    public void testPreLastEventMoveDownCancel() {
        String initType = move.getType6();
        move.moveDown6();
        move.cancelMove();
        Assertions.assertEquals(initType, move.getType6());
    }

    ///////////////////////////////////////////////////////////////////
    @Test
    public void testReleaseMoveUpMessage(){
        move.moveUp7();
        basePage.sleep(500);
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), ' The Release event should be the last in the trip. Are you sure that you would like to change the event position?\n')]"));
        move.cancelMove();
    }

    @Test
    public void testReleaseEventMoveUpMove(){
        String initType = move.getType7();
        move.moveUp7();
        move.applyMove();
        basePage.sleep(500);
        Assertions.assertEquals(initType, move.getType6());
//        move.moveDown6();
    }

    @Test
    public void testReleaseEventMoveUpCancel() {
        String initType = move.getType7();
        move.moveUp7();
        move.cancelMove();
        Assertions.assertEquals(initType, move.getType7());
    }

    //////////////////////////////////////////////////////////
    @Test
    public void testFinishedMoveDownMessage(){
        move.moveDown4();
        basePage.sleep(500);
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), ' You are trying to move a completed event')]"));
        move.cancelMove();
    }

    @Test
    public void testFinishedMoveDownMove(){
        String initType = move.getType4();
        move.moveDown4();
        move.applyMove();
        basePage.sleep(500);
        Assertions.assertEquals(initType, move.getType5());
//        move.moveUp5();
    }

    @Test
    public void testFinishedMoveDownCancel() {
        String initType = move.getType4();
        move.moveDown4();
        move.cancelMove();
        Assertions.assertEquals(initType, move.getType4());
    }

    @Test
    public void testFinishedMoveUp() {
        String initType = move.getType4();
        move.moveUp4();
        Assertions.assertEquals(initType, move.getType3());
//        move.moveDown3();
//        move.applyMove();
    }

    @AfterEach
    public void afterTests(){
        main.sleep(500);
        main.deleteTransaction();
//        main.clickBtnDeleteTransaction();
//        main.clickBtnConfirmAction();
//        driver.navigate().refresh();
    }

    @AfterAll
    public static void after(){
        driver.quit();
    }
}
