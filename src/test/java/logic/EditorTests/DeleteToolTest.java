package logic.EditorTests;

import io.qameta.allure.Step;
import logic.dbConnection.EventDAO;
import logic.dbConnection.EventsData;
import logic.dbConnection.entity.EventEntity;
import logic.pages.admin.AdminPage;
import logic.pages.companyProfile.drivers.driverProfile.EditorPage;
import logic.pages.companyProfile.drivers.driverProfile.HosTab;
import logic.report.LogToAllure;
import logic.variables.Accounts;
import logic.variables.ModificationStep;
import logic.variables.UrlVariables;
import logic.widgets.Editor.Modificators.DeleteTool;
import logic.widgets.Header;
import logic.widgets.NavigationBar;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static logic.webdriver.DriverFactory.getDriver;
import static org.testng.Assert.assertTrue;

public class DeleteToolTest {
    private static final Logger log = Logger.getLogger(TransferTests.class);
    private final EventsData eventsData = new EventsData();
    private EditorPage editor = null;
    private static final long SECOND_DRIVER_ID = 46605;
    private static final String FIRST_DRIVER_NAME = "Igors Kiselovs";
    private static final String SECOND_DRIVER_NAME = "John Transfer";


    @BeforeClass
    @Step("Initialization of the browser driver. Open a browser window. Go to the main page.")
    public void install() throws SQLException {
        NavigationBar navigationBar = new NavigationBar();
        Header header = new Header();
        HosTab hosTab = new HosTab();
        editor = new EditorPage();
        EventDAO.deleteBDXEvents();
        EventDAO.deleteEvents(Accounts.TEST_DRIVER_ID);
        EventDAO.createEvents(eventsData.FIRST_EVENT(Accounts.TEST_DRIVER_ID));
        getDriver().get(UrlVariables.getBaseURL());
        log.info("Go to " + UrlVariables.getBaseURL());

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
        hosTab.goToViewer().goToEldEditor();

    }


    @DataProvider(name = "delete_duty")
    public Object[][] deleteDutyProvider() {
        return new Object[][]{
                /* {"OFF DUTY", new ArrayList<>(Collections.singletonList(0)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, true},
                 {"PU WITH CLEARED", new ArrayList<>(Collections.singletonList(2)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                 {"YM WITH CLEARED", new ArrayList<>(Collections.singletonList(5)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                 {"ON DUTY", new ArrayList<>(Collections.singletonList(8)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                 {"DRIVING", new ArrayList<>(Collections.singletonList(7)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                 {"CLEARED AND PU", new ArrayList<>(Arrays.asList(1, 2)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                 {"CLEARED AND YM", new ArrayList<>(Arrays.asList(4, 5)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                 {"OFF AND ON", new ArrayList<>(Arrays.asList(0, 8)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                 {"DRIVING AND SLEEP", new ArrayList<>(Arrays.asList(1, 2)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                 {"CLEARED AND PU", new ArrayList<>(Arrays.asList(1, 8)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},*/
                {"Power Up", new ArrayList<>(Collections.singletonList(11)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, true},
                {"Power Up on OFF", new ArrayList<>(Arrays.asList(11, 12)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                {"Power Down", new ArrayList<>(Collections.singletonList(9)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                {"Power Down on Off", new ArrayList<>(Arrays.asList(9, 10)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                {"Login", new ArrayList<>(Collections.singletonList(7)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                {"Login on S", new ArrayList<>(Arrays.asList(7, 8)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                {"Logout", new ArrayList<>(Collections.singletonList(5)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                {"Logout on Off", new ArrayList<>(Arrays.asList(5, 6)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                {"ELD Malfunction Logged", new ArrayList<>(Collections.singletonList(3)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                {"ELD Malfunction Logged on ON", new ArrayList<>(Arrays.asList(3, 4)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                {"ELD Malfunction Cleared", new ArrayList<>(Collections.singletonList(1)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                {"ELD Malfunction Cleared on Off", new ArrayList<>(Arrays.asList(1, 2)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
        };
    }

    @Test(dataProvider = "delete_duty")
    public void te_delete_001_duty(String description, ArrayList<Integer> elementsToSelect, ArrayList<EventEntity> events, boolean isShiftNextEvent, boolean insert) {
        if (insert) {
            try {
                EventDAO.deleteEvents(Accounts.TEST_DRIVER_ID);
                EventDAO.createEvents(events);
            } catch (SQLException throwables) {
                log.error(throwables);
                Assert.fail(throwables.toString());
            }
        }
        editor.openTransactionAndInputValues();
        LogToAllure.logToAllure("TEST DESCRIPTION", description + "");
        DeleteTool deleteTool = new DeleteTool(elementsToSelect, isShiftNextEvent);
        deleteTool.toDeleteEvent(ModificationStep.SAVE);
        deleteTool.isEventDeleted();
    }

    @DataProvider(name = "delete_validation")
    public Object[][] deleteValidationProvider() {
        return new Object[][]{
                {"OFF DUTY", new ArrayList<>(Collections.singletonList(7)), eventsData.EVENTS_FOR_DELETE_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, true},
                {"PU WITH CLEARED", new ArrayList<>(Collections.singletonList(10)), eventsData.EVENTS_FOR_DELETE_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), true, false},
                {"ON before YM", new ArrayList<>(Collections.singletonList(5)), eventsData.EVENTS_FOR_DELETE_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},
                {"OFF before PU", new ArrayList<>(Collections.singletonList(1)), eventsData.EVENTS_FOR_DELETE_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false, false},

        };
    }

    @Test(dataProvider = "delete_validation")
    public void te_delete_002_validation(String description, ArrayList<Integer> elementsToSelect, ArrayList<EventEntity> events, boolean isShiftNextEvent, boolean insert) {
        if (insert) {
            try {
                EventDAO.deleteEvents(Accounts.TEST_DRIVER_ID);
                EventDAO.createEvents(events);
                editor.openTransactionAndInputValues();
            } catch (SQLException throwables) {
                log.error(throwables);
                Assert.fail(throwables.toString());
            }
        }
        LogToAllure.logToAllure("TEST DESCRIPTION", description + "");
        DeleteTool deleteTool = new DeleteTool(elementsToSelect, isShiftNextEvent);
        deleteTool.toDeleteEvent(ModificationStep.PREVIEW);
        deleteTool.isCorrectDeleteValidation();

    }

}
