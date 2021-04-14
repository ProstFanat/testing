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

public class AdvancedSearchTrip {

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
        filter = new filterFleet(driver);
        basePage = new BasePage(driver);
        logOut = new LogOut(driver);
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        open.openFleetEvents();
        basePage.sleep(1000);
        open.findTrip("716253");
        basePage.waitToBeClickable(10, filter.btnAdvancedSearch);
        //filter.clickBtnAdvancedSearch();
    }

    @BeforeEach
    void before(){
        filter.clickBtnAdvancedSearch();
        main.sleep(500);
        //driver.get(ConfPropertiesFleet.getProperty("loginPage"));
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

            if(driver.findElement(By.xpath("//datatable-row-wrapper["+ i +"]//datatable-body-cell[7]//span")).getText().equals("Adrian Gherghel")){
                counter++;
            } else if(driver.findElement(By.xpath("//datatable-row-wrapper["+ i +"]//datatable-body-cell[8]//span")).getText().equals("Adrian Gherghel")){
                counter++;
            }
        }
        basePage.sleep(500);
        Assertions.assertEquals(counter, filter.table.size());
    }

    @Test
    public void filterOnlyWithWrongDriver(){
        filter.inputDriver("Adrian Boychuk");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), 'Drivers not found')]"));
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
            System.out.println(driver.findElement(By.xpath("//datatable-row-wrapper["+ i +"]//datatable-body-cell[10]//span")).getText());
            if(driver.findElement(By.xpath("//datatable-row-wrapper["+ i +"]//datatable-body-cell[10]//span")).getText().equals("409125 (Order: CO-20-61201)")) {
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
            if(driver.findElement(By.xpath("//datatable-row-wrapper["+ i +"]//datatable-body-cell[10]//span")).getText().equals("409125 (Order: CO-20-61201)")) {
                counter++;
            }
        }
        basePage.sleep(500);
        Assertions.assertEquals(counter, filter.table.size());
    }

    @Test
    public void filterOnlyWithOrderThatDoNotHaveProbills(){
        filter.inputOrderWithoutProbill("CO-20-61200");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), 'Probills not found')]"));
    }

    @Test
    public void filterOnlyWithWrongOrder(){
        filter.inputOrderWithoutProbill("test");
        main.sleep(500);
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), 'Orders not found')]"));
    }

    @Test
    public void filterOnlyWithTruck(){
        filter.inputTruck("1210");
        filter.showResults();
        int counter = 0;

        if(filter.table.size() == 0){
            System.out.println("filterOnlyWithTruck - empty table");
            Assertions.assertTrue(false);
        }

        for(int i = 1; i <= filter.table.size(); i++){
            if(driver.findElement(By.xpath("//datatable-row-wrapper["+ i +"]//datatable-body-cell[5]//div")).getText().equals("1210")) {
                counter++;
            }
        }
        basePage.sleep(500);
        Assertions.assertEquals(counter, filter.table.size());
    }

    @Test
    public void filterOnlyWithWrongTruck(){
        filter.inputTruck("ha ha");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), 'Trucks not found')]"));
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
            if(driver.findElement(By.xpath("//datatable-row-wrapper["+ i +"]//datatable-body-cell[6]//div")).getText().equals("1210T")) {
                counter++;
            }
        }
        basePage.sleep(500);
        Assertions.assertEquals(counter, filter.table.size());
    }

    @Test
    public void filterOnlyWithWrongTrailer(){
        filter.inputTrailer("ha ha");
        Assertions.assertTrue(basePage.isElementDisplayedByPath("//*[contains(text(), 'Trailers not found')]"));
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
        filter.inputTruck("1210");
        filter.inputTrailer("1210T");
//        filter.inputStartDate();
//        filter.inputFinishDate();
        filter.showResults();

        if(filter.table.size() == 0){
            System.out.println("filterWithAllFilters - empty table");
            Assertions.assertTrue(false);
        }

        if(driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[7]//span")).getText().equals("Adrian Gherghel")){
            if(driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[10]//span")).getText().equals("409125 (Order: CO-20-61201)")){
                if(driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[5]//div")).getText().equals("1210")){
                    if(driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[6]//div")).getText().equals("1210T")){
                        Assertions.assertTrue(true);
                    }
                }
            }
        }
    }

    @AfterEach
    void beforeTest(){
        driver.navigate().refresh();
//        filter.clearFilters();
//        filter.showResults();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}