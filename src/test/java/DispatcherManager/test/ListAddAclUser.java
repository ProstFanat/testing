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

public class ListAddAclUser {


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
    public void testWithoutAll(){
        int number = (int) (Math.random() * 1000000);
        main.createNewDispatcher("testAdrian" + number);
        main.openFormBtnACLUser("testAdrian" + number);

        Assert.assertFalse(main.btnSave.isEnabled());
    }

    @Test
    public void testWithFirstName(){
        int number = (int) (Math.random() * 1000000);
        main.createNewDispatcher("testAdrian" + number);
        main.openFormBtnACLUser("testAdrian" + number);
        main.inputAclFirstname("testAdrian");

        Assert.assertFalse(main.btnSave.isEnabled());
    }

    @Test
    public void testWithFirstAndLastName(){
        int number = (int) (Math.random() * 1000000);
        main.createNewDispatcher("testAdrian" + number);
        main.openFormBtnACLUser("testAdrian" + number);
        main.inputAclFirstname("testAdrian");
        main.inputAclLastName("" + number);

        Assert.assertFalse(main.btnSave.isEnabled());
    }

    @Test
    public void testWithFirstLastNameAndEmail(){
        int number = (int) (Math.random() * 1000000);
        main.createNewDispatcher("testAdrian" + number);
        main.openFormBtnACLUser("testAdrian" + number);
        main.inputAclFirstname("testAdrian");
        main.inputAclLastName("" + number);
        main.inputAclEmail("testAdrian" + number +"@mail.com");

        Assert.assertFalse(main.btnSave.isEnabled());
    }

    @Test
    public void testWithAll(){
        int number = (int) (Math.random() * 1000000);
        main.createNewDispatcher("testAdrian" + number);
        main.openFormBtnACLUser("testAdrian" + number);
        main.inputAclFirstname("testAdrian");
        main.inputAclLastName("" + number);
        main.inputAclEmail("testAdrian" + number +"@mail.com");
        main.inputAclPassword("test");
        main.btnSave.click();


        main.inputSearchDispatcher("testAdrian" + number);
        main.sleep(1000);
        Assert.assertFalse(main.isElementPresent("//*[@uib-tooltip = 'Add ACL user']"));
    }

    @Test
    public void testValidationOfEmailInput(){
        int number = (int) (Math.random() * 1000000);
        main.createNewDispatcher("testAdrian" + number);
        main.openFormBtnACLUser("testAdrian" + number);
        main.inputAclFirstname("testAdrian");
        main.inputAclLastName("" + number);
        main.inputAclPassword("test");
        main.inputAclEmail("testAdrian" + number);
        if(!(main.btnSave.isEnabled())){
            main.aclEmail.sendKeys("@");
            if(!(main.btnSave.isEnabled())){
                main.aclEmail.sendKeys("test");
                if(!(main.btnSave.isEnabled())){
                    main.aclEmail.sendKeys(".");
                    if(!(main.btnSave.isEnabled())){
                        main.aclEmail.sendKeys("t");
                        if(!(main.btnSave.isEnabled())){
                            main.aclEmail.sendKeys("e");
                            Assert.assertTrue(main.btnSave.isEnabled());
                        } else {
                            Assert.assertTrue(false);
                        }
                    } else {
                        Assert.assertTrue(false);
                    }
                } else {
                    Assert.assertTrue(false);
                }
            } else {
                Assert.assertTrue(false);
            }
        } else {
            Assert.assertTrue(false);
        }
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
