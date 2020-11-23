package logic.EditorTests;

import io.qameta.allure.*;
import logic.dbConnection.DBConnection;
import logic.dbConnection.EventDAO;
import logic.dbConnection.EventsData;
import logic.dbConnection.entity.EventEntity;
import logic.pages.admin.AdminPage;
import logic.pages.companyProfile.drivers.driverProfile.HosTab;
import logic.report.LogToAllure;
import logic.variables.*;
import logic.pages.companyProfile.drivers.driverProfile.EditorPage;
import logic.webdriver.DriverFactory;
import logic.widgets.Editor.Modificators.ShiftTool;
import logic.widgets.Header;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.sql.SQLException;
import java.util.*;

import static logic.webdriver.DriverFactory.getDriver;
import static org.testng.Assert.*;

@Listeners(Listener.class)

public class ShiftToolTest {
    private List<Integer> elementsToSelect = new ArrayList<>();
    private static final Logger log = Logger.getLogger(ShiftToolTest.class);
    private EventsData eventsData = new EventsData();
    private EditorPage editor = null;
    private ShiftTool shiftTool = null;
    private static final String PREVIEW_MODE = "Preview";
    private static final String SAVE_MODE = "Save";
    private static final String CANCEL_MODE = "Cancel";
    private static final String RESET_MODE = "Reset";
    private static final String LEFT_MOVE = "left";
    private static final String RIGHT_MOVE = "right";
    private static final int MORE_THAN_MAX = 120;
    private static final int LESS_THAN_MAX = -120;
    private static final int MOVE_TO_MIDDLE = 2;
    private int numOfEvents = 0; //колличество ивентов которые создались и будут парситься с таблицы в редакторе

    @BeforeClass
    @Step("Initialization of the browser driver. Open a browser window. Go to the main page.")
    public void install() throws SQLException {
        EventDAO.deleteEvents(Accounts.TEST_DRIVER_ID);
        EventDAO.createEvents(eventsData.FIRST_EVENT(Accounts.TEST_DRIVER_ID));
        DriverFactory.getDriver().get(UrlVariables.getBaseURL());
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
                .findAndLoginAsCompany("MGK express Corp")
                .goToNavigationBar()
                .goToDriversPage()
                .goToProfilesTab()
                .openDriverHosPage("Igors");
        ArrayList<String> newTab = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(newTab.get(1));
        new HosTab().goToViewer()
                .goToEldEditor();

    }

    @BeforeMethod
    public void beforeTest(ITestContext context) {
        context.setAttribute("driver", DriverFactory.getDriver());
    }

    @AfterMethod
    @Step("Clear the list of items to select. Clearing the list of maximum time for moving events.")
    public void refresh() {
        elementsToSelect.clear();
    }

    @AfterClass
    @Step("Closing the browser driver. Closing a database connection.")
    public void clean() {
        // DriverFactory.getDriver().close();
        DBConnection.closeConnection();
    }

    private void openTransaction() {
        editor = new EditorPage();
        editor.openTransactionAndInputValues();
    }

    private void deleteTransactionAndEvents() {
        try {
            EventDAO.deleteEvents(Accounts.TEST_DRIVER_ID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        editor.deleteTransaction();
        editor = null;
        numOfEvents = 0;
    }

    private boolean setTestingData(List<EventEntity> events, boolean insert) {
        if (insert) {
            try {
                EventDAO.deleteEvents(Accounts.TEST_DRIVER_ID);
                EventDAO.createEvents(events);
            } catch (SQLException throwables) {
                log.error(throwables);
                return false;
            }
            shiftTool = new ShiftTool();
            numOfEvents = events.size();
            shiftTool.setNumOfEvents(numOfEvents + 1);
            openTransaction();
        }
        return true;
    }

    /*Проверка корректности переноса ивентов на максимально допустимое и недопустимое значение времени*/

    @DataProvider(name = "first_gr")
    public Object[][] move_and_wait_error_gr_first() {
        return new Object[][]{
                {"ELD malfunction cleared", new ArrayList<>(Collections.singletonList(1)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), true},
                {"ELD malfunction logged", new ArrayList<>(Collections.singletonList(3)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"Logout", new ArrayList<>(Collections.singletonList(5)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"Login", new ArrayList<>(Collections.singletonList(7)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"Power Down", new ArrayList<>(Collections.singletonList(9)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"Power Up", new ArrayList<>(Collections.singletonList(11)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"Off Duty", new ArrayList<>(Collections.singletonList(12)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"Sleeper Berth", new ArrayList<>(Collections.singletonList(10)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"Sleeper Berth + Login", new ArrayList<>(Collections.singletonList(8)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"Off Duty + Logout", new ArrayList<>(Collections.singletonList(6)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"On Duty + Eld Malfunction Logged", new ArrayList<>(Collections.singletonList(4)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"Off Duty  + Eld Malfunction Logged", new ArrayList<>(Collections.singletonList(2)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"Off Duty AND Power Up", new ArrayList<>(Arrays.asList(11, 12)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"Sleeper Berth AND Login", new ArrayList<>(Arrays.asList(7, 8)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"On Duty AND ELD mulfunction logged", new ArrayList<>(Arrays.asList(3, 4)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"Off Duty AND ELD mulfunction cleared", new ArrayList<>(Arrays.asList(1, 2)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"Off Duty, Power Up, Sleeper Berth, Login", new ArrayList<>(Arrays.asList(9, 10, 11, 12)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"Logout, On Duty, ELD mulfunction logged, Off Duty", new ArrayList<>(Arrays.asList(2, 3, 4, 5)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"Off Duty, On Duty, Off Duty ,Sleeper Berth", new ArrayList<>(Arrays.asList(2, 4, 6, 8)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"ELD malfunction cleared, ELD mulfunction logged, Logout, Login, Power Down, Power Up", new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"Data diagnostic event logged", new ArrayList<>(Collections.singletonList(6)), eventsData.EVENTS_FOR_SHIFT_GROUP_TWO(Accounts.TEST_DRIVER_ID), true},
                {"Personal Use без Cleared ", new ArrayList<>(Collections.singletonList(9)), eventsData.EVENTS_FOR_SHIFT_GROUP_TWO(Accounts.TEST_DRIVER_ID), false},
                {"Driving без Intermediate", new ArrayList<>(Collections.singletonList(5)), eventsData.EVENTS_FOR_SHIFT_GROUP_TWO(Accounts.TEST_DRIVER_ID), false},
                {"Personal Use c Cleared", new ArrayList<>(Arrays.asList(7, 8, 9)), eventsData.EVENTS_FOR_SHIFT_GROUP_TWO(Accounts.TEST_DRIVER_ID), false},
                //{"Driving with Intermediate", new ArrayList<>(Collections.singletonList(6)), eventsData.EVENTS_FOR_SHIFT_GROUP_WITH_BDX_AND_INTERMEDIATE(Accounts.TEST_DRIVER_ID), true},
                //{"Driving with Intermediate и группу ивентов", new ArrayList<>(Arrays.asList(6, 7, 8)), eventsData.EVENTS_FOR_SHIFT_GROUP_WITH_BDX_AND_INTERMEDIATE(Accounts.TEST_DRIVER_ID), false},
                {"OFF перед Gap Date", new ArrayList<>(Collections.singletonList(2)), eventsData.EVENTS_FOR_SHIFT_GROUP_GAP_DATE(Accounts.TEST_DRIVER_ID), true},
                {"Группа ивентов в Gap Date", new ArrayList<>(Arrays.asList(1, 2, 3, 4)), eventsData.EVENTS_FOR_SHIFT_GROUP_GAP_DATE(Accounts.TEST_DRIVER_ID), false},
        };
    }

    @Test(dataProvider = "first_gr")
    public void te_shift_001_more_than_max(String description, ArrayList<Integer> elementsToSelect, ArrayList<EventEntity> events, boolean insert) {
        assertTrue(setTestingData(events, insert));
        LogToAllure.logToAllure("TEST DESCRIPTION", description + " more than max");
        shiftTool.moveAndWaitError(elementsToSelect, MORE_THAN_MAX, RIGHT_MOVE);
        shiftTool.moveAndWaitError(elementsToSelect, MORE_THAN_MAX, LEFT_MOVE);
    }


    @Test(dataProvider = "first_gr")
    public void te_shift_002_correct_move(String description, ArrayList<Integer> elementsToSelect, ArrayList<EventEntity> events, boolean insert) {
        assertTrue(setTestingData(events, insert));
        LogToAllure.logToAllure("TEST DESCRIPTION", description + " less than max");
        shiftTool.moveAndWaitCorrectResult(elementsToSelect, LESS_THAN_MAX, RIGHT_MOVE, SAVE_MODE);
        shiftTool.moveAndWaitCorrectResult(elementsToSelect, LESS_THAN_MAX, LEFT_MOVE, SAVE_MODE);
        shiftTool.moveAndWaitCorrectResult(elementsToSelect, MOVE_TO_MIDDLE, RIGHT_MOVE, SAVE_MODE);
    }

    /*Проверка того, что данные не изменяются после выбора ивентов и нажатии кнопки Cancel*/

    @DataProvider(name = "cancel")
    public Object[][] cancelProvider() {
        return new Object[][]{
                {"EMC, OFF, EML, ON", new ArrayList<>(Arrays.asList(1, 2, 3, 4)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), true},
                {"", new ArrayList<>(Arrays.asList(5, 6, 7, 8)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"", new ArrayList<>(Arrays.asList(1, 3, 5, 7)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"", new ArrayList<>(Arrays.asList(2, 4, 6, 8)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
        };
    }

    @Test(dataProvider = "cancel")
    public void te_shift_003_cancel(String description, ArrayList<Integer> elementsToSelect, ArrayList<EventEntity> events, boolean insert) {
        assertTrue(setTestingData(events, insert));
        LogToAllure.logToAllure("TEST DESCRIPTION", description + " select and click Cancel");
        shiftTool.moveAndWaitCorrectResult(elementsToSelect, LESS_THAN_MAX, LEFT_MOVE, CANCEL_MODE);
        shiftTool.moveAndWaitCorrectResult(elementsToSelect, LESS_THAN_MAX, RIGHT_MOVE, CANCEL_MODE);
    }

    /*Проверка того, что данные не изменяются после выбора ивентов, нажатии кнопки Preview и сброса всех изменений кнопкой Reset*/
    @Test(dataProvider = "cancel")
    public void te_shift_004_reset(String description, ArrayList<Integer> elementsToSelect, ArrayList<EventEntity> events, boolean insert) {
        assertTrue(setTestingData(events, insert));
        LogToAllure.logToAllure("TEST DESCRIPTION", description + " Preview and click Reset");
        shiftTool.moveAndWaitCorrectResult(elementsToSelect, LESS_THAN_MAX, LEFT_MOVE, PREVIEW_MODE);
        shiftTool.moveAndWaitCorrectResult(elementsToSelect, LESS_THAN_MAX, LEFT_MOVE, RESET_MODE);
        shiftTool.moveAndWaitCorrectResult(elementsToSelect, LESS_THAN_MAX, RIGHT_MOVE, PREVIEW_MODE);
        shiftTool.moveAndWaitCorrectResult(elementsToSelect, LESS_THAN_MAX, RIGHT_MOVE, RESET_MODE);
    }

    /*Проверка того, что данные корректно изменяются после нескольких модификаций в состоянии Preview и сохранения изменений*/
    @DataProvider(name = "multi_preview")
    public Object[][] multiPreviewProvider() {
        return new Object[][]{
                {"", new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), true},
                {"", new ArrayList<>(Arrays.asList(9, 10, 11, 12)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
        };
    }

    @Test(dataProvider = "multi_preview")
    public void te_shift_005_multi_preview(String description, ArrayList<Integer> elementsToSelect, ArrayList<EventEntity> events, boolean insert) {
        assertTrue(setTestingData(events, insert));
        LogToAllure.logToAllure("TEST DESCRIPTION", description + " multi Preview and Save");
        shiftTool.moveAndWaitCorrectResult(elementsToSelect, LESS_THAN_MAX, RIGHT_MOVE, PREVIEW_MODE);
        shiftTool.moveAndWaitCorrectResult(elementsToSelect, LESS_THAN_MAX, LEFT_MOVE, PREVIEW_MODE);
        shiftTool.moveAndWaitCorrectResult(elementsToSelect, MOVE_TO_MIDDLE, RIGHT_MOVE, SAVE_MODE);
    }

    /*Проверка корректности переноса ивентов используя Bulk*/
    @DataProvider(name = "bulk-to-from")
    public Object[][] bulkToFromProvider() {
        return new Object[][]{
                {"Group of Events in Gap", new ArrayList<>(Arrays.asList(1, 3)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), true},
                {"OFF перед Gap Date", new ArrayList<>(Arrays.asList(0, 5)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"EMC - не в GAP, ON в GAP", new ArrayList<>(Arrays.asList(2, 8)), eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                {"EMC - не в GAP, ON в GAP", null, eventsData.EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},

        };
    }

    @Test(dataProvider = "bulk-to-from")
    public void te_shift_006_bulk_to_from(String description, ArrayList<Integer> elementsToSelect, ArrayList<EventEntity> events, boolean insert) {
        assertTrue(setTestingData(events, insert));
        LogToAllure.logToAllure("TEST DESCRIPTION", description + " more than max");
        if (elementsToSelect != null) {
            shiftTool.moveWithBulkTool(elementsToSelect, LESS_THAN_MAX, RIGHT_MOVE);
            shiftTool.moveWithBulkTool(elementsToSelect, LESS_THAN_MAX, LEFT_MOVE);
            shiftTool.moveWithBulkTool(elementsToSelect, MOVE_TO_MIDDLE, RIGHT_MOVE);
        } else {
            shiftTool.moveWithBulkTool(LESS_THAN_MAX, RIGHT_MOVE);
            shiftTool.moveWithBulkTool(LESS_THAN_MAX, LEFT_MOVE);
            shiftTool.moveWithBulkTool(MOVE_TO_MIDDLE, RIGHT_MOVE);
        }
    }

    /*Проверка переноса одного PC/Cleared*/
    @DataProvider(name = "cleared")
    public Object[][] clearedProvider() {
        return new Object[][]{
                {"Cleared on YM", new ArrayList<>(Collections.singletonList(1)), eventsData.EVENTS_FOR_SHIFT_GROUP_TWO(Accounts.TEST_DRIVER_ID), true},
                {"Cleared on PU", new ArrayList<>(Collections.singletonList(8)), eventsData.EVENTS_FOR_SHIFT_GROUP_TWO(Accounts.TEST_DRIVER_ID), false},
        };
    }

    @Test(dataProvider = "cleared")
    public void te_shift_007_cleared(String description, ArrayList<Integer> elementsToSelect, ArrayList<EventEntity> events, boolean insert) {
        assertTrue(setTestingData(events, insert));
        LogToAllure.logToAllure("TEST DESCRIPTION", description + " move less than max");
        shiftTool.moveAndWaitCorrectResult(elementsToSelect, LESS_THAN_MAX, LEFT_MOVE, SAVE_MODE);
        shiftTool.moveAndWaitCorrectResult(elementsToSelect, LESS_THAN_MAX, RIGHT_MOVE, SAVE_MODE);
    }

    /*Проверка переноса ивентов в Gap Date*/
    @DataProvider(name = "gap-date")
    public Object[][] gapDateProvider() {
        return new Object[][]{
                {"First Event in Gap", new ArrayList<>(Collections.singletonList(3)), eventsData.EVENTS_FOR_SHIFT_GROUP_GAP_DATE(Accounts.TEST_DRIVER_ID), true},
                {"Group of Events in Gap", new ArrayList<>(Arrays.asList(3, 4, 5, 6)), eventsData.EVENTS_FOR_SHIFT_GROUP_GAP_DATE(Accounts.TEST_DRIVER_ID), false},
                {"OFF перед Gap Date", new ArrayList<>(Arrays.asList(6, 7, 8)), eventsData.EVENTS_FOR_SHIFT_GROUP_GAP_DATE(Accounts.TEST_DRIVER_ID), false},
                {"EMC - не в GAP, ON в GAP", new ArrayList<>(Arrays.asList(1, 4)), eventsData.EVENTS_FOR_SHIFT_GROUP_GAP_DATE(Accounts.TEST_DRIVER_ID), false}
        };
    }

    @Test(dataProvider = "gap-date")
    public void te_shift_008_gap_date(String description, ArrayList<Integer> elementsToSelect, ArrayList<EventEntity> events, boolean insert) {
        assertTrue(setTestingData(events, insert));
        LogToAllure.logToAllure("TEST DESCRIPTION", description + " more than max");
        new ShiftTool().checkNotSelectedEventInGapDate(elementsToSelect);
    }

    @Description("BDX перенести вперед на время которое НЕ нарушает последовательность ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 0, description = "TE_SHIFT_THIRD_GR_001: BDX -> LESS than max TO right", groups = {"BDX and Driving with Intermediate events"})
    public void te_shift_009_bdx() {
        assertTrue(setTestingData(eventsData.EVENTS_FOR_SHIFT_GROUP_WITH_BDX_AND_INTERMEDIATE(Accounts.TEST_DRIVER_ID), true));

        elementsToSelect.add(shiftTool.findBdxEvent());
        shiftTool.moveAndWaitCorrectResult(elementsToSelect, LESS_THAN_MAX, RIGHT_MOVE, SAVE_MODE);
        elementsToSelect.clear();

        elementsToSelect.add(shiftTool.findBdxEvent());
        shiftTool.moveAndWaitCorrectResult(elementsToSelect, LESS_THAN_MAX, LEFT_MOVE, SAVE_MODE);
        elementsToSelect.clear();

        elementsToSelect.add(shiftTool.findBdxEvent());
        shiftTool.moveAndWaitCorrectResult(elementsToSelect, MOVE_TO_MIDDLE, RIGHT_MOVE, SAVE_MODE);
        elementsToSelect.clear();
    }
}
