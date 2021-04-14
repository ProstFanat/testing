package fleet.test;

import fleet.*;
import org.junit.jupiter.api.*;
import resources.AppConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import resources.AppConstants;

import resources.AppConstants;
import resources.BasePage;
import resources.AppConstants;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AdvancedSearchTruck {

    public static WebDriver driver;
    public static OpenFleetPage open;
    public static createNewFleetEvent createTrip;
    public static mainFleet main;
    public static editEvent edit;
    public static filterFleet filterFleet;
    public static filterTruckFleet filter;
    public static BasePage basePage;
    public static LogOut logOut;

    @BeforeAll
    static void setup() {
//        //определение пути до драйвера и его настройка
//        System.setProperty("webdriver.chrome.driver", ConfPropertiesFleet.getProperty("chromedriver"));
//        //создание экземпляра драйвера
//        driver = new ChromeDriver();
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        driver = getWebDriver();
        open = new OpenFleetPage(driver);
        createTrip = new createNewFleetEvent(driver);
        main = new mainFleet(driver);
        edit = new editEvent(driver);
        filterFleet = new filterFleet(driver);
        filter = new filterTruckFleet(driver);
        basePage = new BasePage(driver);
        logOut = new LogOut(driver);
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        open.openFleetEvents();
        basePage.sleep(1000);

    }

    @BeforeEach
    void beforeTest(){
        main.inputPerspective("Truck");
        filter.findTruck("1210");
        basePage.sleep(1000);
        basePage.waitToBeClickable(10, filterFleet.btnAdvancedSearch);
        filterFleet.clickBtnAdvancedSearch();
    }


    @Test
    public void filterEmpty(){
        filter.clearFilters();
        filter.showResults();
        int initTable = filter.table.size();
        filter.showResults();
        basePage.sleep(500);
        Assertions.assertEquals(initTable, filter.table.size());
    }

    @Test
    public void filterOnlyWithDrivers(){
        filter.inputDriver("Adrian Gherghel");
        filter.showResults();
        int counter = 0;

        if(filter.table.size() == 0){
            System.out.println("filterOnlyWithDrivers - empty table");
            Assertions.assertTrue(false);
        }

        for(int i = 1; i <= filter.table.size(); i++){
            if(driver.findElement(By.xpath("//datatable-row-wrapper["+ i +"]//datatable-body-cell[5]//span")).getText().equals("Adrian Gherghel")){
                counter++;
            } else if(driver.findElement(By.xpath("//datatable-row-wrapper["+ i +"]//datatable-body-cell[6]//span")).getText().equals("Adrian Gherghel")){
                counter++;
            }
        }
        basePage.sleep(500);
        Assertions.assertEquals(counter, filter.table.size());
    }

    @Test
    public void filterOnlyWithOrder(){
        filter.inputOrder("CO-20-61201", "409125");
        filter.showResults();
        int counter = 0;

        if(filter.table.size() == 0){
            System.out.println("filterOnlyWithOrder - empty table");
            Assertions.assertTrue(false);
        }

        for(int i = 1; i <= filter.table.size(); i++){
            if(driver.findElement(By.xpath("//datatable-row-wrapper["+ i +"]//datatable-body-cell[8]//span")).getText().equals("409125 (Order: CO-20-61201)")) {
                counter++;
            }
        }
        basePage.sleep(500);
        Assertions.assertEquals(counter, filter.table.size());
    }

    @Test
    public void filterOnlyWithOrderWithoutProbill(){
        filter.inputOrderWithoutProbill("CO-20-61201");
        filter.showResults();
        int counter = 0;

        if(filter.table.size() == 0){
            System.out.println("filterOnlyWithOrderWithoutProbill - empty table");
            Assertions.assertTrue(false);
        }

        for(int i = 1; i <= filter.table.size(); i++){
            if(driver.findElement(By.xpath("//datatable-row-wrapper["+ i +"]//datatable-body-cell[8]//span")).getText().equals("409125 (Order: CO-20-61201)")) {
                counter++;
            } else if (driver.findElement(By.xpath("//datatable-row-wrapper["+ i +"]//datatable-body-cell[8]//span")).getText().equals("408953 (Order: CO-20-61201)")){
                counter++;
            }
        }
        basePage.sleep(500);
        Assertions.assertEquals(counter, filter.table.size());
    }

    @Test
    public void filterOnlyWithTrailer(){
        filter.inputTrailer("1210T");
        filter.showResults();
        int counter = 0;

        if(filter.table.size() == 0){
            System.out.println("filterOnlyWithTrailer - empty table");
            Assertions.assertTrue(false);
        }

        for(int i = 1; i <= filter.table.size(); i++){
            if(driver.findElement(By.xpath("//datatable-row-wrapper["+ i +"]//datatable-body-cell[4]//div")).getText().equals("1210T")) {
                counter++;
            }
        }
        basePage.sleep(500);
        Assertions.assertEquals(counter, filter.table.size());
    }

    @Test
    public void filterOnlyWithDateFrom(){
        int init = filter.table.size();
        filter.inputStartDate();
        filter.showResults();
        basePage.sleep(500);
        Assertions.assertNotEquals(init, filter.table.size());
    }

    @Test
    public void filterOnlyWithDateTo(){
        int init = filter.table.size();
        filter.inputFinishDate();
        filter.showResults();
        basePage.sleep(500);
        Assertions.assertNotEquals(init, filter.table.size());
    }
    @Test
    public void filterWithAllFilters(){
        filter.inputDriver("Adrian Gherghel");
        filter.inputOrder("CO-20-61201", "409125");
        filter.inputTrailer("1210T");
//        filter.inputStartDate();
//        filter.inputFinishDate();
        filter.showResults();

        if(filter.table.size() == 0){
            System.out.println("filterWithAllFilters - empty table");
            Assertions.assertTrue(false);
        }

        if(driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[5]//span")).getText().equals("Adrian Gherghel")){
            if(driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[8]//span")).getText().equals("409125 (Order: CO-20-61201)")){
                if(driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[4]//div")).getText().equals("1210T")){
                    Assertions.assertTrue(true);
                }
            }
        }
    }

    @AfterEach
    void afterEach(){
        driver.navigate().refresh();
//        filter.clearFilters();
//        filter.showResults();
    }


    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
