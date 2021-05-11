package DispatcherManager;

import DispatcherManager.dispatcherList;
import DispatcherManager.dispatcherMonitor;
import DispatcherManager.openDispatcher;
import FleetEvents.OpenFleetPage;
import FleetEvents.createNewFleetEvent;
import FleetEvents.mainFleet;
import org.junit.jupiter.api.*;
import resources.AppConstants;
import org.openqa.selenium.WebDriver;
import resources.BasePage;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ListAddAclUser {


    public static WebDriver driver;
    public static openDispatcher open;
    public static createNewFleetEvent createTrip;
    public static FleetEvents.mainFleet mainFleet;
    public static BasePage basePage;
    public static dispatcherList main;
    public static dispatcherMonitor mainMonitor;
    public static OpenFleetPage openFleet;



    @BeforeAll
    static void setup() {
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        open.openDispatchers();
        basePage.sleep(1000);
    }

    @Test
    public void testWithoutAll(){
        int number = (int) (Math.random() * 1000000);
        main.createNewDispatcher("testAdrian" + number);
        main.openFormBtnACLUser("testAdrian" + number);

        Assertions.assertFalse(main.btnSave.isEnabled());
    }

    @Test
    public void testWithFirstName(){
        int number = (int) (Math.random() * 1000000);
        main.createNewDispatcher("testAdrian" + number);
        main.openFormBtnACLUser("testAdrian" + number);
        main.inputAclFirstname("testAdrian");

        Assertions.assertFalse(main.btnSave.isEnabled());
    }

    @Test
    public void testWithFirstAndLastName(){
        int number = (int) (Math.random() * 1000000);
        main.createNewDispatcher("testAdrian" + number);
        main.openFormBtnACLUser("testAdrian" + number);
        main.inputAclFirstname("testAdrian");
        main.inputAclLastName("" + number);

        Assertions.assertFalse(main.btnSave.isEnabled());
    }

    @Test
    public void testWithFirstLastNameAndEmail(){
        int number = (int) (Math.random() * 1000000);
        main.createNewDispatcher("testAdrian" + number);
        main.openFormBtnACLUser("testAdrian" + number);
        main.inputAclFirstname("testAdrian");
        main.inputAclLastName("" + number);
        main.inputAclEmail("testAdrian" + number +"@mail.com");

        Assertions.assertFalse(main.btnSave.isEnabled());
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
        Assertions.assertFalse(main.isElementPresent("//*[@uib-tooltip = 'Add ACL user']"));
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
                            Assertions.assertTrue(main.btnSave.isEnabled());
                        } else {
                            Assertions.assertTrue(false);
                        }
                    } else {
                        Assertions.assertTrue(false);
                    }
                } else {
                    Assertions.assertTrue(false);
                }
            } else {
                Assertions.assertTrue(false);
            }
        } else {
            Assertions.assertTrue(false);
        }
    }

    @AfterEach
    void beforeTests(){
        driver.navigate().refresh();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
