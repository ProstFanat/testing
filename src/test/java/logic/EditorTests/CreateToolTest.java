package logic.EditorTests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import logic.dbConnection.EventDAO;
import logic.dbConnection.EventsData;
import logic.pages.admin.AdminPage;
import logic.pages.companyProfile.drivers.driverProfile.EditorPage;
import logic.pages.companyProfile.drivers.driverProfile.HosTab;
import logic.report.LogToAllure;
import logic.variables.Accounts;
import logic.variables.Listener;
import logic.variables.ModificationStep;
import logic.variables.UrlVariables;
import logic.variables.events.Event;
import logic.variables.events.EventsCode;
import logic.variables.events.EventsType;
import logic.webdriver.DriverFactory;
import logic.widgets.Editor.Modificators.CreateTool;
import logic.widgets.Header;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.sql.SQLException;
import java.util.ArrayList;

import static logic.webdriver.DriverFactory.getDriver;
import static org.testng.Assert.assertTrue;


@Listeners(Listener.class)

public class CreateToolTest {

    private static final Logger log = Logger.getLogger(CreateToolTest.class);
    private Event createdEvent = null;
    private final String SPECIFY_MODE = "Specify Event Duration";
    private final String SPLIT_MODE = "Split Existing Event";
    private CreateTool createTool = null;
    WebDriver driver = null;
    @BeforeClass
    @Step("Initialization of the browser driver. Open a browser window. Go to the main page.")
    public void install() throws SQLException {
        EventDAO.deleteEvents(Accounts.TEST_DRIVER_ID);
        EventDAO.createEvents(new EventsData().FIRST_EVENT(Accounts.TEST_DRIVER_ID));
        driver = DriverFactory.getDriver();
        driver.get(UrlVariables.getBaseURL());
        log.info("Go to " + UrlVariables.getBaseURL());
        Header header = new Header();
        header
                .clickOnLogin()
                .setValuesIntoLoginForm(Accounts.getLoginValues())
                .clickBtnSubmitLogin();
        AdminPage adminPage = new AdminPage();
        adminPage
                .closeConfirmStartShiftWindow()
                .goToCustomersPage()
                .findAndLoginAsCompany("IMOVE TRANS LLC")
                .goToNavigationBar()
                .goToDriversPage()
                .goToProfilesTab()
                .openDriverHosPage("Abror");
        ArrayList<String> newTab = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(newTab.get(1));
        new HosTab().goToViewer()
                .goToEldEditor();
    }

    @BeforeMethod
    public void beforeTest (ITestContext context)  {
        context.setAttribute("driver", DriverFactory.getDriver());
        new EditorPage().openTransactionAndInputValues().openCreateTool();
        createTool = new CreateTool();
    }

    @AfterMethod
    @Step("Clear the list of items to select.")
    public void refresh(){
        createTool = null;
        createdEvent = null;
        new EditorPage().deleteTransaction();
    }

    @AfterClass
    @Step("Closing the browser driver.")
    public void clean() throws SQLException {
        EventDAO.deleteEvents(Accounts.TEST_DRIVER_ID);
        driver.close();
    }

        @Description("Создать все Duty статусы и PC/YM на продолжительном ивенте")
        @Severity(SeverityLevel.CRITICAL)
        @Test(priority = 0, description = "TE_CREATE_001: DUTY EVENTS AND PC/YM")
        private void te_create_001_duty_events() {
            createdEvent  = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");

            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 10, 15, -1, logic.variables.ModificationStep.SAVE);

            createdEvent  = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 20, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 13, 40, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 15, 01, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PERSONAL_USE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 16, 20, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 17, 2, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.YARD_MOVE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 17, 6, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 18, 40, -1, logic.variables.ModificationStep.SAVE);
        }

        @Description("Создать все вертикальные события на ON")
        @Severity(SeverityLevel.NORMAL)
        @Test(priority = 0, description = "TE_CREATE_002: Vertical on ON")
        private void te_create_002_vertical_on() {
            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 10, 50, -1, logic.variables.ModificationStep.SAVE);

            createdEvent  = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGIN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 5, -1, logic.variables.ModificationStep.SAVE);

            createdEvent  = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGOUT, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 10, -1, logic.variables.ModificationStep.SAVE);

            createdEvent  = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_UP, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 15, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_DOWN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 20, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 25, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 30, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 35, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 40, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PC_YM_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 11, 50, -1);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGIN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, -1, -1, 0, logic.variables.ModificationStep.SAVE);
        }

        @Description("Создать все вертикальные события на OFF")
        @Severity(SeverityLevel.NORMAL)
        @Test(priority = 0, description = "TE_CREATE_003: Vertical on ON")
        private void te_create_003_vertical_off() {
            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 10, 50, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGIN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 5, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGOUT, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 10, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_UP, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 15, -1, logic.variables.ModificationStep.SAVE);

            createdEvent  = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_DOWN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 20, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 25, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 30, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 35, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 40, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PC_YM_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 11, 50, -1);

            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_UP, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, -1, -1, 0, logic.variables.ModificationStep.SAVE);
        }


        @Description("Создать все вертикальные события на Driving")
        @Severity(SeverityLevel.NORMAL)
        @Test(priority = 0, description = "TE_CREATE_004: Vertical on D")
        private void te_create_004_vertical_driving() {
            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 10, 50, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGIN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 5, -1, logic.variables.ModificationStep.SAVE);

            createdEvent  = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGOUT, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 10, -1, logic.variables.ModificationStep.SAVE);

            createdEvent  = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_UP, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 11, 15, -1);

            createdEvent  = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_DOWN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 11, 20, -1);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 25, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 30, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 35, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 40, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PC_YM_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 11, 50, -1);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, -1, -1, 0, logic.variables.ModificationStep.SAVE);
        }

        @Description("Создать все вертикальные события на Sleep")
        @Severity(SeverityLevel.NORMAL)
        @Test(priority = 0, description = "TE_CREATE_005: Vertical on S")
        private void te_create_005_vertical_sleep() {
            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 10, 50, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGIN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 5, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGOUT, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 10, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_UP, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 15, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_DOWN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 20, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 25, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 30, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 35, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 40, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PC_YM_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 11, 50, -1);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, -1, -1, 0, logic.variables.ModificationStep.SAVE);
        }

        @Description("Создать все вертикальные события на PU without Cleared")
        @Severity(SeverityLevel.NORMAL)
        @Test(priority = 0, description = "TE_CREATE_006: Vertical on PU w/o Cleared")
        private void te_create_006_vertical_pu_without_cleared() {
            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PERSONAL_USE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 10, 50, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGIN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 5, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGOUT, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 10, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_UP, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 15, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_DOWN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 20, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 25, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 30, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 35, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 40, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, -1, -1, 0, logic.variables.ModificationStep.SAVE);
        }

        @Description("Создать все вертикальные события на YM without Cleared")
        @Severity(SeverityLevel.NORMAL)
        @Test(priority = 0, description = "TE_CREATE_007: Vertical on YM w/o Cleared")
        private void te_create_007_vertical_ym_without_cleared() {

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.YARD_MOVE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 10, 50, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGIN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 5, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGOUT, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 10, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_UP, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 15, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_DOWN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 20, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 25, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 30, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 35, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 40, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, -1, -1, 0, logic.variables.ModificationStep.SAVE);
        }

        @Description("Создать все вертикальные события на PU with Cleared")
        @Severity(SeverityLevel.NORMAL)
        @Test(priority = 0, description = "TE_CREATE_008: Vertical on PU with Cleared")
        private void te_create_008_vertical_pu_with_cleared() {
            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PERSONAL_USE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 10, 50, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 14, 00, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGIN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 5, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGOUT, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 10, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_UP, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 15, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_DOWN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 20, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 25, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 30, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 35, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 40, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PC_YM_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 11, 50, -1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, -1, -1, 0, logic.variables.ModificationStep.SAVE);
        }

        @Description("Создать все вертикальные события на YM with cleared")
        @Severity(SeverityLevel.NORMAL)
        @Test(priority = 0, description = "TE_CREATE_009: Vertical on YM with Cleared")
        private void te_create_009_vertical_ym_with_cleared() {
            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.YARD_MOVE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 10, 50, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 14, 00, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGIN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 5, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGOUT, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 10, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_UP, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 15, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_DOWN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 20, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 25, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 30, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 35, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 40, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PC_YM_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 11, 50, -1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, -1, -1, 0, logic.variables.ModificationStep.SAVE);
        }

        @Description("Создать все Duty ивенты с помощью Split с корректным временем")
        @Severity(SeverityLevel.CRITICAL)
        @Test(priority = 0, description = "TE_CREATE_010: DUTY SPLIT")
        private void te_create_010_create_duty_with_split() {
            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 8, 0, -1, logic.variables.ModificationStep.SAVE, SPLIT_MODE, -1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 9, 0, -1, logic.variables.ModificationStep.SAVE, SPLIT_MODE, -1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 10, 0, -1, logic.variables.ModificationStep.SAVE, SPLIT_MODE, -1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 0, -1, logic.variables.ModificationStep.SAVE, SPLIT_MODE, -1);

        }

        @Description("Создать PC/YM ивенты с помощью Split с корректным временем")
        @Severity(SeverityLevel.CRITICAL)
        @Test(priority = 0, description = "TE_CREATE_011: PC/YM SPLIT")
        private void te_create_011_create_pc_with_split() {
            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 17, 0, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PERSONAL_USE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 13, 0, -1, logic.variables.ModificationStep.SAVE, SPLIT_MODE, -1);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.YARD_MOVE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 19, 0, -1, logic.variables.ModificationStep.SAVE, SPLIT_MODE, -1);

        }

        @Description("Создать все Duty ивенты с помощью Split с НЕ корректным временем")
        @Severity(SeverityLevel.NORMAL)
        @Test(priority = 0, description = "TE_CREATE_012: DUTY SPLIT ERROR")
        private void te_create_012_create_duty_with_split_error() {
            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 12, 0, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 8, 0, -1, SPLIT_MODE, +1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 9, 0, -1, SPLIT_MODE, +1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 10, 0, -1, SPLIT_MODE, +1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 11, 0, -1, SPLIT_MODE, +1);

        }

        @Description("Создать PC/YM ивенты с помощью Split с НЕ корректным временем")
        @Severity(SeverityLevel.NORMAL)
        @Test(priority = 0, description = "TE_CREATE_013: PC/YM SPLIT ERROR")
        private void te_create_013_create_pc_with_split_error() {
            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 18, 0, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PERSONAL_USE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 13, 0, -1, SPLIT_MODE, +1);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.YARD_MOVE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 15, 0, -1, SPLIT_MODE, +1);

        }

        @Description("Создать DUTY and PC/YM ивенты с помощью Specify")
        @Severity(SeverityLevel.CRITICAL)
        @Test(priority = 0, description = "TE_CREATE_011: DUTY PC/YM SPECIFY")
        private void te_create_014_create_duty_with_specify() {
            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 19, 0, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 18, 0, -1, logic.variables.ModificationStep.SAVE, SPECIFY_MODE, -30);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 16, 0, -1, logic.variables.ModificationStep.SAVE, SPECIFY_MODE, 30);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 14, 0, -1, logic.variables.ModificationStep.SAVE, SPECIFY_MODE, -30);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PERSONAL_USE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 13, 0, -1, logic.variables.ModificationStep.SAVE, SPECIFY_MODE, +30);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 11, 0, -1, SPECIFY_MODE, -30);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 0, -1, logic.variables.ModificationStep.SAVE, SPECIFY_MODE, -30);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.YARD_MOVE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 9, 30, -1, logic.variables.ModificationStep.SAVE, SPECIFY_MODE, +30);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 7, 13, -1, logic.variables.ModificationStep.SAVE, SPECIFY_MODE, -30);

        }

        @Description("Создать VERTICAL ивенты с помощью Specify")
        @Severity(SeverityLevel.CRITICAL)
        @Test(priority = 0, description = "TE_CREATE_015: VERTICAL SPECIFY")
        private void te_create_015_create_vertical_with_split() {
            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_UP, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 13, 0, -1, logic.variables.ModificationStep.SAVE, SPLIT_MODE, -1);

            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_DOWN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 13, 0, -1, logic.variables.ModificationStep.SAVE, SPLIT_MODE, -1);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGIN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 19, 0, -1, logic.variables.ModificationStep.SAVE, SPLIT_MODE, -1);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGOUT, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 13, 0, -1, logic.variables.ModificationStep.SAVE, SPLIT_MODE, -1);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PC_YM_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 19, 0, -1, logic.variables.ModificationStep.SAVE, SPLIT_MODE, -1);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 13, 0, -1, logic.variables.ModificationStep.SAVE, SPLIT_MODE, -1);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 19, 0, -1, logic.variables.ModificationStep.SAVE, SPLIT_MODE, -1);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 13, 0, -1, logic.variables.ModificationStep.SAVE, SPLIT_MODE, -1);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 19, 0, -1, logic.variables.ModificationStep.SAVE, SPLIT_MODE, -1);

        }

        @Description("Создать все ивенты в Gap")
        @Severity(SeverityLevel.NORMAL)
        @Test(priority = 0, description = "TE_CREATE_016: GAP")
        private void te_create_016_create_gap() {

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PERSONAL_USE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.YARD_MOVE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGIN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGOUT, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9);

            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_UP, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9);

            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_DOWN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9);

        }

        @Description("Создать все ивенты в Gap с помощью Split and Specify")
        @Severity(SeverityLevel.NORMAL)
        @Test(priority = 0, description = "TE_CREATE_017: GAP SPLIT/SPECIFY")
        private void te_create_017_create_gap() {

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9, SPLIT_MODE, -1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9, SPLIT_MODE, -1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9, SPLIT_MODE, -1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9, SPLIT_MODE, -1);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PERSONAL_USE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9, SPLIT_MODE, -1);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.YARD_MOVE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9, SPLIT_MODE, -1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9, SPECIFY_MODE, -1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9, SPECIFY_MODE, -1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9, SPECIFY_MODE, -1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9, SPECIFY_MODE, -1);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PERSONAL_USE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9, SPECIFY_MODE, -1);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.YARD_MOVE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, -1, 0, -9, SPECIFY_MODE, -1);
        }

        @Description("Создать все ивенты на одинаковое время")
        @Severity(SeverityLevel.MINOR)
        @Test(priority = 0, description = "TE_CREATE_018: SAME TIME")
        private void te_create_018_create_same_time() {

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 1, 0, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 1, 0, -1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 1, 0, -1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 1, 0, -1);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PERSONAL_USE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 1, 0, -1);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.YARD_MOVE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 1, 0, -1);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGIN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 1, 0, -1);

            createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGOUT, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 1, 0, -1);

            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_UP, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 1, 0, -1);

            createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_DOWN, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 1, 0, -1);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 1, 0, -1);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 1, 0, -1);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_LOGGED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 1, 0, -1);

            createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 1, 0, -1);

        }

        @Description("Создать Cleared на/перед/после PU в разных ситуациях")
        @Severity(SeverityLevel.MINOR)
        @Test(priority = 0, description = "TE_CREATE_019: PU TESTS")
        private void te_create_019_pu() {

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 1, 0, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PERSONAL_USE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 2, 0, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PC_YM_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 3, 0, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 2, 59, -1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 3, 1, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PERSONAL_USE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 4, 0, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PC_YM_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 5, 0, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PC_YM_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 4, 59, -1);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PC_YM_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 5, 1, -1);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PERSONAL_USE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 6, 0, -1, logic.variables.ModificationStep.SAVE);

        }

        @Description("Создать Cleared на/перед/после YM в разных ситуациях")
        @Severity(SeverityLevel.MINOR)
        @Test(priority = 0, description = "TE_CREATE_020: YM TESTS")
        private void te_create_020_ym() {

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 1, 0, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.YARD_MOVE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 2, 0, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PC_YM_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 3, 0, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 2, 59, -1);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 3, 1, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.YARD_MOVE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 4, 0, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PC_YM_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 5, 0, -1, logic.variables.ModificationStep.SAVE);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PC_YM_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 4, 59, -1);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PC_YM_CLEARED, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitError(createdEvent, 5, 1, -1);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.YARD_MOVE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 6, 0, -1, logic.variables.ModificationStep.SAVE);

        }

        @Description("Создать все Duty and PC/YM events группой в Preview и нажать Reset")
        @Severity(SeverityLevel.MINOR)
        @Test(priority = 0, description = "TE_CREATE_021: DUTY PC/YM PREVIEW AND RESET")
        private void te_create_021_preview_and_reset() {

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 6, 0, -1, ModificationStep.PREVIEW);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 7, 0, -1, ModificationStep.PREVIEW);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 8, 0, -1, ModificationStep.PREVIEW);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 9, 0, -1, ModificationStep.PREVIEW);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PERSONAL_USE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 10, 0, -1, ModificationStep.PREVIEW);

            createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 11, 0, -1, ModificationStep.PREVIEW);

            createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.YARD_MOVE, "100", "100");
            log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
            LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
            createTool.createEventAndWaitCorrectResult(createdEvent, 13, 0, -1, ModificationStep.PREVIEW);

        createTool.resetCreatedEventsInPreview();
    }

    @Description("Создать все Vertical events группой в Preview и нажать Reset")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 0, description = "TE_CREATE_022: VERTICAL PREVIEW AND RESET")
    private void te_create_022_preview_and_reset() {

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 6, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGIN, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 7, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGOUT, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 8, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 9, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_DOWN, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 10, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_UP, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 11, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_DOWN, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitError(createdEvent, 7, 30, -1);

        createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_UP, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitError(createdEvent, 8, 30, -1);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 13, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_LOGGED, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 14, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_LOGGED, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 15, 0, -1, ModificationStep.PREVIEW);

        createTool.resetCreatedEventsInPreview();
    }

    @Description("Создать DUTY AND PC/YM events в multi save")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 0, description = "TE_CREATE_023: DUTY AND PC/YM MULTI SAVE")
    private void te_create_023_preview_and_multi_save_duty() {

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 6, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 7, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 8, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 9, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PERSONAL_USE, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 10, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 11, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.YARD_MOVE, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 12, 0, -1, logic.variables.ModificationStep.SAVE);
    }

    @Description("Создать Vertical events в multi save")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 0, description = "TE_CREATE_024: VERTICAL MULTI SAVE")
    private void te_create_024_preview_and_multi_save_vertical() {

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 6, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGIN, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 7, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGOUT, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 8, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 9, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_DOWN, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 10, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_UP, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 11, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_DOWN, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitError(createdEvent, 7, 30, -1);

        createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_UP, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitError(createdEvent, 8, 30, -1);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 13, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_LOGGED, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 14, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_LOGGED, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 15, 0, -1, logic.variables.ModificationStep.SAVE);

    }

    @Description("Создать duty events с помощью SPLIT в multi save")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 0, description = "TE_CREATE_024: SPLIT DUTY MULTI SAVE")
    private void te_create_024_duty_preview_and_multi_save_split() {
        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 8, 0, -1, ModificationStep.PREVIEW, SPLIT_MODE, -20);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 9, 0, -1, ModificationStep.PREVIEW, SPLIT_MODE, -5);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 10, 0, -1, ModificationStep.PREVIEW, SPLIT_MODE, -16);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 11, 0, -1, ModificationStep.PREVIEW, SPLIT_MODE, -1);

        createTool.multiSaveSpecifyCreatedEvents();
    }

    @Description("Создать PC/YM events с помощью SPLIT в multi save")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 0, description = "TE_CREATE_025: SPLIT PC/YM MULTI SAVE")
    private void te_create_025_create_pc_with_split() {
        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 17, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PERSONAL_USE, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 13, 0, -1, ModificationStep.PREVIEW, SPLIT_MODE, -1);

        createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.YARD_MOVE, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 19, 0, -1, ModificationStep.PREVIEW, SPLIT_MODE, -1);

        createTool.multiSaveSpecifyCreatedEvents();


    }

    @Description("Создать PC/YM events с помощью SPECIFY в multi save")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 0, description = "TE_CREATE_026: SPECIFY DUTY PC/YM MULTI SAVE")
    private void te_create_026_preview_and_multi_save_specify() {

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 19, 0, -1, ModificationStep.PREVIEW);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 18, 0, -1, ModificationStep.PREVIEW, SPECIFY_MODE, -30);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 16, 0, -1, ModificationStep.PREVIEW, SPECIFY_MODE, 30);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 14, 0, -1, ModificationStep.PREVIEW, SPECIFY_MODE, -30);

        createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PERSONAL_USE, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 13, 0, -1, ModificationStep.PREVIEW, SPECIFY_MODE, +30);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.SLEEPER_BERTH, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitError(createdEvent, 11, 0, -1, "", -30);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 11, 0, -1, ModificationStep.PREVIEW, SPECIFY_MODE, -30);

        createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.YARD_MOVE, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 9, 30, -1, ModificationStep.PREVIEW, SPECIFY_MODE, +30);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 7, 13, -1, ModificationStep.PREVIEW, SPECIFY_MODE, -30);

        createTool.multiSaveSpecifyCreatedEvents();
    }

    @Description("Заполнить поля в Create для создания ивента и нажать Cancel")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 0, description = "TE_CREATE_027: CANCEL")
    private void te_create_027_cancel() {

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 6, 0, -1, ModificationStep.CANCEL);

        createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGIN, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 7, 0, -1, ModificationStep.CANCEL);

        createdEvent = new Event(EventsType.AUTHENTICATED_ACTIVITY, EventsCode.LOGOUT, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 8, 0, -1, ModificationStep.CANCEL);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.OFF_DUTY, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 9, 0, -1, ModificationStep.CANCEL);

        createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_DOWN, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 10, 0, -1, ModificationStep.CANCEL);

        createdEvent = new Event(EventsType.ENGINE_ACTIVITY, EventsCode.POWER_UP, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 11, 0, -1, ModificationStep.CANCEL);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 13, 0, -1, ModificationStep.CANCEL);

        createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.ELD_MULFUNCTION_LOGGED, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 14, 0, -1, ModificationStep.CANCEL);

        createdEvent = new Event(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC, EventsCode.DATA_DIAGNOSTIC_EVENT_LOGGED, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 15, 0, -1, ModificationStep.CANCEL);

        createdEvent = new Event(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.ON_DUTY, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 9, 0, -1, ModificationStep.CANCEL);

        createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PERSONAL_USE, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 9, 0, -1, ModificationStep.CANCEL);

        createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.YARD_MOVE, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 9, 0, -1, ModificationStep.CANCEL);

        createdEvent = new Event(EventsType.PERSONAL_USE_AND_YARD_MOVE, EventsCode.PC_YM_CLEARED, "100", "100");
        log.info("***CREATE NEW EVENT*** " + createdEvent.getEventName() + " event");
        LogToAllure.logToAllure("To create " + createdEvent.getEventName() + "event", createdEvent.toString());
        createTool.createEventAndWaitCorrectResult(createdEvent, 9, 0, -1, ModificationStep.CANCEL);
    }

    @Description("Проверка обязательных полей")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 0, description = "TE_CREATE_028: REQUIRED FIELDS")
    private void te_create_028_required_fields() {
        createTool.selectEventType("", "").
                selectTimeZone()
                .selectState()
                .enterCityValue("New City")
                .enterTotalVehicleMiles("100")
                .enterTotalEngineHours("100")
                .enterCoordinates()
                .clickOnPreview();
        assertTrue(new EditorPage().checkNotificationView());
        new EditorPage().closeNotification().clickCancelBtn();

        createTool.selectEventType(EventsType.DRIVER_DUTY_STATUS_CHANGED, "").
                selectTimeZone()
                .selectState()
                .enterCityValue("New City")
                .enterTotalVehicleMiles("100")
                .enterTotalEngineHours("100")
                .enterCoordinates()
                .clickOnPreview();
        assertTrue(new EditorPage().checkNotificationView());
        new EditorPage().closeNotification().clickCancelBtn();

        createTool.selectEventType(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING)
                .selectState()
                .enterCityValue("New City")
                .enterTotalVehicleMiles("100")
                .enterTotalEngineHours("100")
                .enterCoordinates()
                .clickOnPreview();
        assertTrue(new EditorPage().checkNotificationView());
        new EditorPage().closeNotification().clickCancelBtn();

        createTool.selectEventType(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING)
                .selectTimeZone()
                .selectState()
                .enterTotalVehicleMiles("100")
                .enterTotalEngineHours("100")
                .enterCoordinates()
                .clickOnPreview();
        assertTrue(new EditorPage().checkNotificationView());
        new EditorPage().closeNotification().clickCancelBtn();

        createTool.selectEventType(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING)
                .selectTimeZone()
                .enterTotalVehicleMiles("100")
                .enterTotalEngineHours("100")
                .enterCoordinates()
                .clickOnPreview();
        assertTrue(new EditorPage().checkNotificationView());
        new EditorPage().closeNotification().clickCancelBtn();

        createTool.selectEventType(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING)
                .selectTimeZone()
                .selectState()
                .enterCityValue("New City")
                .enterTotalVehicleMiles("100")
                .enterTotalEngineHours("100")
                .enterCoordinates()
                .clickOnPreview();
        assertTrue(new EditorPage().checkNotificationView());
        new EditorPage().closeNotification().clickCancelBtn();

        createTool.selectEventType(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING)
                .selectTimeZone()
                .selectState()
                .enterCityValue("New City")
                .enterTotalEngineHours("100")
                .enterCoordinates()
                .clickOnPreview();
        assertTrue(new EditorPage().checkNotificationView());
        new EditorPage().closeNotification().clickCancelBtn();

        createTool.selectEventType(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING)
                .selectTimeZone()
                .selectState()
                .enterCityValue("New City")
                .enterTotalVehicleMiles("100")
                .enterCoordinates()
                .clickOnPreview();
        assertTrue(new EditorPage().checkNotificationView());
        new EditorPage().closeNotification().clickCancelBtn();

        createTool.selectEventType(EventsType.DRIVER_DUTY_STATUS_CHANGED, EventsCode.DRIVING)
                .selectTimeZone()
                .selectState()
                .enterCityValue("New City")
                .enterTotalVehicleMiles("100")
                .enterTotalEngineHours("100")
                .clickOnPreview();
        assertTrue(new EditorPage().checkNotificationView());
        new EditorPage().closeNotification().clickCancelBtn();

    }

}
