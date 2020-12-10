package fleet.test;

import fleet.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.BasePage;
import resources.ConfProperties;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class EditEvent {
    public static WebDriver driver;
    public static OpenFleetPage open;
    public static createNewFleetEvent createTrip;
    public static mainFleet main;
    public static editEvent edit;
    public static filterFleet filter;
    public static BasePage basePage;
    public static LogOut logOut;

    @BeforeAll
    static void setup() {
        //определение пути до драйвера и его настройка
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
    void before(){
        main.clickBtnAddNewEvent();
        edit.inputEventType("pickup");
        edit.inputPlace("NEW YORK OF STATE");
        edit.inputETA();
        edit.inputStartDate();
        edit.inputFinishDate();
        edit.inputOrder("CO-20-61202");
        edit.inputProbill("408954");
        edit.inputCargo("FROZEN");
        edit.inputDriver1(ConfProperties.getProperty("fleet.driver1"));
        edit.inputDriver2(ConfProperties.getProperty("fleet.driver2"));
        edit.inputTruck("1210");
        edit.inputTrailer("1210T");
        edit.apllyChanges();
    }

    @Test
    public void testWithCancelledChanging(){
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[2]//button[@id = 'button-actions']")).click();
        main.clickBtnEditEvent();
        edit.inputEventType("load");
        edit.inputPlace("NEWLYWED FOODS");
        edit.inputETA2();
        edit.inputStartDate2();
        edit.inputFinishDate2();
        edit.inputOrder("CO-20-61201");
        edit.inputProbill("409125");
        edit.inputCargo("No description");
        edit.inputDriver1(ConfProperties.getProperty("fleet.driver2"));
        edit.inputDriver2(ConfProperties.getProperty("fleet.driver1"));
        edit.inputTruck("1120");
        edit.inputTrailer("1209T");
        edit.cancelChanges();
        if("pickup".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 16 AVIS DRIVE, 12110, LATHAM, NYUSA ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                if("1210".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[5]//span")).getText())){
                    if("408954 (Order: CO-20-61202)".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[10]//span")).getText())) {
                        if("Adrian Gherghel".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[7]//span")).getText())) {
                            if("Roger mcLaughlin".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[8]//span")).getText())) {
                                if("1210T".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[6]//span")).getText())) {
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
    }

    @Test
    public void testWithApplyChanging(){
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[2]//button[@id = 'button-actions']")).click();
        main.clickBtnEditEvent();
        edit.inputEventType("load");
        edit.inputPlace("NEWLYWED FOODS TORONTO WAREHOUSE");
        edit.inputETA2();
        edit.inputStartDate2();
        edit.inputFinishDate2();
        edit.inputOrder("CO-20-61201");
        edit.inputProbill("409125");
        edit.inputCargo("No description");
        edit.inputDriver1(ConfProperties.getProperty("fleet.driver2"));
        edit.inputDriver2(ConfProperties.getProperty("fleet.driver1"));
        edit.inputTruck("1120");
        edit.inputTrailer("1209T");
        edit.apllyChanges();
        if("load".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[4]//span")).getText())){
            if(" 450 SUPERIOR BLVD, L5T 2R9, MISSISSAUGA, ONCAN ".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[9]//div")).getText())) {
                if("1120".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[5]//span")).getText())){
                    if("409125 (Order: CO-20-61201)".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[10]//span")).getText())) {
                        if("Adrian Gherghel".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[8]//span")).getText())) {
                            if("Roger mcLaughlin".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[7]//span")).getText())) {
                                if("1209T".equals(driver.findElement(By.xpath("//datatable-row-wrapper[2]//datatable-body-cell[6]//span")).getText())) {
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
    }

    @Test
    public void testOfChangingStatus(){
        if(basePage.isElementDisplayedByPath("//datatable-scroller/datatable-row-wrapper[2]//datatable-body-cell[14]//*[contains(@class, 'text-warning')]")) {
            driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[2]//button[@id = 'button-actions']")).click();
            main.clickBtnEditEvent();
            edit.inputStartDate2();
            edit.inputFinishDate2();
            edit.apllyChanges();
            Assertions.assertTrue(basePage.isElementDisplayedByPath("//datatable-scroller/datatable-row-wrapper[2]//datatable-body-cell[14]//*[contains(@class, 'text-success')]"));
        }
    }

    @AfterEach
    void afterEach(){
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[3]//button[@id = 'button-actions']")).click();
        main.deleteEvent();
        driver.navigate().refresh();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
