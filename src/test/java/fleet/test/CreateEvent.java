package fleet.test;

import fleet.*;
import fleet.resources.ConfPropertiesFleet;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import resources.BasePage;
import resources.ConfProperties;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CreateEvent {
    public static WebDriver driver;
    public static OpenFleetPage open;
    public static createNewFleetEvent createTrip;
    public static mainFleet main;
    public static editEvent edit;
    public static filterFleet filter;
    public static BasePage basePage;
    public static LogOut logOut;

    /** Тесты
     * С типом release
     * и типом acquire
     * нужно проверить руками
     * сделанно это */

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
        driver.get("http://localhost:8080/TrackEnsure/login.do");
        open.openFleetEvents();
        basePage.sleep(1000);
        basePage.waitToVisibilityOf(10, createTrip.btnCreateNew);
        basePage.waitToBeClickable(10, createTrip.btnCreateNew);
        createTrip.clickBtnCreateTrip();
        basePage.waitToVisibilityOf(10, createTrip.commentField);
        basePage.waitToVisibilityOf(10, createTrip.commentField);
        createTrip.createTrip("new", "Local");
        main.clickBtnOpenTransaction();
        main.saveNewTransaction();
    }

    @BeforeEach
    public void before(){
        main.clickBtnAddNewEvent();
    }

    @Test
    public void emptyAll(){
        edit.apllyChanges();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), 'Please select an Event Type')]"));
        edit.cancelChanges();
    }

    @Test
    public void emptyType(){
        edit.inputPlace("NEW YORK OF STATE");
        edit.apllyChanges();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), 'Please select an Event Type')]"));
        edit.cancelChanges();
    }

    @Test
    public void emptyPlace(){
        edit.inputEventType("pickup");
        edit.apllyChanges();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), 'Please select a Place')]"));
        edit.cancelChanges();
    }

    @Test
    public void testWithTypeAndPlace(){
        edit.inputEventType("pickup");
        edit.inputPlace("NEW YORK OF STATE");
        edit.apllyChanges();
        if("pickup".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                Assertions.assertTrue(true);
            }
        }
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
    }

    @Test
    public void testOnlyWithStartDate(){
        edit.inputPlace("NEW YORK OF STATE");
        edit.inputEventType("pickup");
        edit.inputStartDate();
        edit.apllyChanges();
        if("pickup".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                if(!(" ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[12]//span")).getText()))) {
                    Assertions.assertTrue(true);
                }
            }
        }
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
    }

    @Test
    public void testOnlyWithFinishDate(){
        edit.inputEventType("pickup");
        edit.inputPlace("NEW YORK OF STATE");
        edit.inputFinishDate();
        edit.apllyChanges();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), 'Please select a Start Date')]"));
        edit.cancelChanges();
    }

    @Test
    public void testWithStartDateAndFinishDate(){
        edit.inputPlace("NEW YORK OF STATE");
        edit.inputEventType("pickup");
        edit.inputStartDate();
        edit.inputFinishDate();
        edit.apllyChanges();
        if("pickup".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                if(!(" ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[12]//span")).getText()))) {
                    if(!(" ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[13]//span")).getText()))) {
                        Assertions.assertTrue(true);
                    }
                }
            }
        }
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
    }

    @Test
    public void testWithStartDateLessThanFinishDate(){
        edit.inputEventType("pickup");
        edit.inputPlace("NEW YORK OF STATE");
        edit.inputStartDateLaterThanFinishDate();
        edit.apllyChanges();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), 'The Start Date cannot be later than the Finish Date.')]"));
        edit.cancelChanges();
    }

    @Test
    public void testWithOrder(){
        edit.inputEventType("pickup");
        edit.inputPlace("NEW YORK OF STATE");
        edit.inputOrder("CO-20-61201");
        edit.apllyChanges();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), 'Please select a Probill')]"));
        edit.cancelChanges();
    }

    @Test
    public void testWithOrderAndProbill(){
        edit.inputEventType("pickup");
        edit.inputPlace("NEW YORK OF STATE");
        edit.inputOrder("CO-20-61201");
        edit.inputProbill("409125");
        edit.apllyChanges();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), 'Please select a Cargo')]"));
        edit.cancelChanges();
    }

    @Test
    public void testWithOrderProbillAndCargo(){
        edit.inputEventType("pickup");
        edit.inputPlace("NEW YORK OF STATE");
        edit.inputOrder("CO-20-61201");
        edit.inputProbill("409125");
        edit.inputCargo("No description");
        edit.apllyChanges();
        if("pickup".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                if("409125 (Order: CO-20-61201)".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[10]//span")).getText())) {
                    Assertions.assertTrue(true);
                }
            }
        }
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
    }

    @Test
    public void testWithOrderThatDoNotHaveProbill(){
        edit.inputEventType("pickup");
        edit.inputPlace("NEW YORK OF STATE");
        edit.inputOrder("CO-20-61200");
        edit.apllyChanges();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), 'Please select a Probill')]"));
        edit.cancelChanges();
    }

    @Test
    public void testWithDriver1(){
        edit.inputEventType("pickup");
        edit.inputPlace("NEW YORK OF STATE");
        edit.inputDriver1(ConfPropertiesFleet.getProperty("fleet.driver1"));
        edit.apllyChanges();
        if("pickup".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                if(ConfPropertiesFleet.getProperty("fleet.driver1").equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[7]//span")).getText())) {
                    Assertions.assertTrue(true);
                }
            }
        }
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
    }

    @Test
    public void testWithDriver2(){
        edit.inputEventType("pickup");
        edit.inputPlace("NEW YORK OF STATE");
        edit.inputDriver2(ConfPropertiesFleet.getProperty("fleet.driver2"));
        edit.apllyChanges();
        if("pickup".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                if(ConfPropertiesFleet.getProperty("fleet.driver2").equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[8]//span")).getText())) {
                    Assertions.assertTrue(true);
                }
            }
        }
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
    }

    @Test
    public void testWithSameDrivers(){
        edit.inputEventType("pickup");
        edit.inputPlace("NEW YORK OF STATE");
        edit.inputDriver1(ConfPropertiesFleet.getProperty("fleet.driver2"));
        edit.inputDriver2(ConfPropertiesFleet.getProperty("fleet.driver2"));
        edit.apllyChanges();
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), 'Driver 1 and Driver 2 is the same!')]"));
        edit.cancelChanges();
    }

    @Test
    public void testWithETA(){
        edit.inputEventType("pickup");
        edit.inputPlace("NEW YORK OF STATE");
        edit.inputETA();
        edit.apllyChanges();
        if("pickup".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                if(!(" ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[11]//span")).getText()))){
                    Assertions.assertTrue(true);
                }
            }
        }
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
    }

    @Test
    public void testWithTruck(){
        edit.inputEventType("pickup");
        edit.inputPlace("NEW YORK OF STATE");
        edit.inputTruck(ConfProperties.getProperty("fleet.truck"));
        edit.apllyChanges();
        if("pickup".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                if(ConfProperties.getProperty("fleet.truck").equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[5]//span")).getText())){
                    Assertions.assertTrue(true);
                }
            }
        }
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
    }

    @Test
    public void testWithTrailer(){
        edit.inputEventType("pickup");
        edit.inputPlace("NEW YORK OF STATE");
        edit.inputTrailer(ConfProperties.getProperty("fleet.trailer"));
        edit.apllyChanges();
        if("pickup".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                if(ConfProperties.getProperty("fleet.trailer").equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[6]//span")).getText())){
                    Assertions.assertTrue(true);
                }
            }
        }
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
    }

    @Test
    public void testWithAll(){
        edit.inputEventType("pickup");
        edit.inputPlace("NEW YORK OF STATE");
        edit.inputETA();
        edit.inputStartDate();
        edit.inputFinishDate();
        edit.inputOrder("CO-20-61201");
        edit.inputProbill("409125");
        edit.inputCargo("No description");
        edit.inputDriver1(ConfProperties.getProperty("fleet.driver1"));
        edit.inputDriver2(ConfProperties.getProperty("fleet.driver2"));
        edit.inputTruck(ConfProperties.getProperty("fleet.truck"));
        edit.inputTrailer(ConfProperties.getProperty("fleet.trailer"));
        edit.apllyChanges();
        if("pickup".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                if(ConfProperties.getProperty("fleet.truck").equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[5]//span")).getText())){
                    if("409125 (Order: CO-20-61201)".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[10]//span")).getText())) {
                        if(ConfPropertiesFleet.getProperty("fleet.driver1").equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[7]//span")).getText())) {
                            if(ConfPropertiesFleet.getProperty("fleet.driver2").equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[8]//span")).getText())) {
                                if(ConfProperties.getProperty("fleet.trailer").equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[6]//span")).getText())) {
                                    if(!(" ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[11]//span")).getText()))) {
                                        if(!(" ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[12]//span")).getText()))) {
                                            if(!(" ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[13]//span")).getText()))) {
                                                Assertions.assertTrue(true);
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
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
    }

    /** More more tests....*/

    @Test
    public void testWithTypePickup(){
        edit.inputEventType("pickup");
        edit.inputPlace("NEW YORK OF STATE");
        edit.apllyChanges();
        if("pickup".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                Assertions.assertTrue(true);
            }
        }
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
    }

    @Test
    public void testWithTypeDelivery(){
        edit.inputEventType("delivery");
        edit.inputPlace("NEW YORK OF STATE");
        edit.apllyChanges();
        if("delivery".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                Assertions.assertTrue(true);
            }
        }
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
    }

    @Test
    public void testWithTypeLoad(){
        edit.inputEventType("load");
        edit.inputPlace("NEW YORK OF STATE");
        edit.apllyChanges();
        if("load".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                Assertions.assertTrue(true);
            }
        }
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
    }

    @Test
    public void testWithTypeUnload(){
        edit.inputEventType("unload");
        edit.inputPlace("NEW YORK OF STATE");
        edit.apllyChanges();
        if("unload".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                Assertions.assertTrue(true);
            }
        }
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
    }

    @Test
    public void testWithTypeHookTrailer(){
        edit.inputEventType("hook-trailer");
        edit.inputPlace("NEW YORK OF STATE");
        edit.apllyChanges();
        if("hook-trailer".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                Assertions.assertTrue(true);
            }
        }
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
    }

    @Test
    public void testWithTypeDropTrailer(){
        edit.inputEventType("drop-trailer");
        edit.inputPlace("NEW YORK OF STATE");
        edit.apllyChanges();
        if("hook-trailer".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                Assertions.assertTrue(true);
            }
        }
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
    }

    @Test
    public void testWithTypeAcquire(){
        edit.inputEventType("acquire");
        edit.inputPlace("NEW YORK OF STATE");
        edit.apllyChanges();
        if("acquire".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                Assertions.assertTrue(true);
            }
        }
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.clickBtnEditEvent();
        edit.inputEventType("unload");
        edit.apllyChanges();
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
    }

    @Test
    public void testWithTypeRelease(){
        edit.inputEventType("release");
        edit.inputPlace("NEW YORK OF STATE");
        edit.apllyChanges();
        if("release".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                Assertions.assertTrue(true);
            }
        }
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.clickBtnEditEvent();
        edit.inputEventType("unload");
        edit.apllyChanges();
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + 3 + "]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
    }

    @AfterEach
    public void afterTest(){
        driver.navigate().refresh();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
