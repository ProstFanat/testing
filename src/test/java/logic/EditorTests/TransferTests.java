package logic.EditorTests;

import io.qameta.allure.Step;
import logic.dbConnection.EventDAO;
import logic.dbConnection.EventsData;
import logic.dbConnection.entity.EventEntity;
import logic.pages.admin.AdminPage;
import logic.pages.companyProfile.drivers.driverProfile.EditorPage;
import logic.pages.companyProfile.drivers.driverProfile.HosTab;
import logic.pages.companyProfile.drivers.ProfilesTab;
import logic.variables.Accounts;
import logic.variables.ModificationStep;
import logic.variables.UrlVariables;
import logic.widgets.Editor.Modificators.TransferTool;
import logic.widgets.Header;
import logic.widgets.NavigationBar;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static logic.webdriver.DriverFactory.getDriver;

public class TransferTests {
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
        ProfilesTab profilesTab = new ProfilesTab();
        Header header = new Header();
        HosTab hosTab = new HosTab();
        editor = new EditorPage();
        EventDAO.deleteBDXEvents();
        EventDAO.deleteEvents(Accounts.TEST_DRIVER_ID);
        EventDAO.deleteEvents(SECOND_DRIVER_ID);
        EventDAO.createEvents(eventsData.FIRST_EVENT(Accounts.TEST_DRIVER_ID));
        EventDAO.createEvents(eventsData.FIRST_EVENT(SECOND_DRIVER_ID));

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
                .findAndLoginAsCompany("MGK express Corp");

        navigationBar.goToDriversPage().goToProfilesTab().openDriverHosPage("Igors");
        ArrayList<String> newTab = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(newTab.get(1));
        hosTab.goToViewer().goToEldEditor();

    }

    private void doTransfer(ArrayList<Integer> elementsToSelect) {
        editor.changeDriverView(FIRST_DRIVER_NAME);
        TransferTool transferTool = new TransferTool(elementsToSelect);
        editor.openTransactionAndInputValues();
        transferTool.toTransferEvents(ModificationStep.SAVE)
                .checkThatThereAreNoEventsInTable();
        editor.changeDriverView(SECOND_DRIVER_NAME);
        transferTool.isEventsTransferredToAnotherDriver();
        editor.deleteTransaction();
    }

    @DataProvider(name = "default")
    public Object[][] method() {
        return new Object[][]{
                //C, PU, OFF
                {new ArrayList<>(Arrays.asList(1, 2, 3)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), true},
                //C, YM, ON
                {new ArrayList<>(Arrays.asList(4, 5, 6)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                //ON, D,S
                {new ArrayList<>(Arrays.asList(8, 9, 10)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                //ON,D
                {new ArrayList<>(Arrays.asList(6, 7)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                //OFF
                {new ArrayList<>(Collections.singletonList(11)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                //S
                {new ArrayList<>(Collections.singletonList(10)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                //C, PU, OFF, C, YM, ON
                {new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                //D,ON,D,S,OFF
                {new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                //D
                {new ArrayList<>(Collections.singletonList(9)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                //D,D
                {new ArrayList<>(Arrays.asList(6, 7)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID), false},
                //Login
                {new ArrayList<>(Collections.singletonList(11)), eventsData.EVENTS_FOR_TRANSFER_DRIVING_WITH_INTERM_EVENTS_AND_VERTICAL(Accounts.TEST_DRIVER_ID), true},
                //Logout
                {new ArrayList<>(Collections.singletonList(10)), eventsData.EVENTS_FOR_TRANSFER_DRIVING_WITH_INTERM_EVENTS_AND_VERTICAL(Accounts.TEST_DRIVER_ID), false},
                //Logout and Login
                {new ArrayList<>(Arrays.asList(10, 11)), eventsData.EVENTS_FOR_TRANSFER_DRIVING_WITH_INTERM_EVENTS_AND_VERTICAL(Accounts.TEST_DRIVER_ID), false},
                //Logout and Login, OFF
                {new ArrayList<>(Arrays.asList(10, 11, 12)), eventsData.EVENTS_FOR_TRANSFER_DRIVING_WITH_INTERM_EVENTS_AND_VERTICAL(Accounts.TEST_DRIVER_ID), false},
                //Power Up
                {new ArrayList<>(Collections.singletonList(7)), eventsData.EVENTS_FOR_TRANSFER_DRIVING_WITH_INTERM_EVENTS_AND_VERTICAL(Accounts.TEST_DRIVER_ID), true},
                //Power Down
                {new ArrayList<>(Collections.singletonList(8)), eventsData.EVENTS_FOR_TRANSFER_DRIVING_WITH_INTERM_EVENTS_AND_VERTICAL(Accounts.TEST_DRIVER_ID), false},
                //Power Up and Power Down
                {new ArrayList<>(Arrays.asList(7, 8)), eventsData.EVENTS_FOR_TRANSFER_DRIVING_WITH_INTERM_EVENTS_AND_VERTICAL(Accounts.TEST_DRIVER_ID), false},
                //Power Up and Power Down, on
                {new ArrayList<>(Arrays.asList(7, 8, 9)), eventsData.EVENTS_FOR_TRANSFER_DRIVING_WITH_INTERM_EVENTS_AND_VERTICAL(Accounts.TEST_DRIVER_ID), false},
                //D with Inter
                {new ArrayList<>(Arrays.asList(3, 4, 5, 6)), eventsData.EVENTS_FOR_TRANSFER_DRIVING_WITH_INTERM_EVENTS_AND_VERTICAL(Accounts.TEST_DRIVER_ID), false},
                //D with Inter x2 and S
                {new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6)), eventsData.EVENTS_FOR_TRANSFER_DRIVING_WITH_INTERM_EVENTS_AND_VERTICAL(Accounts.TEST_DRIVER_ID), false},
                //ML
                {new ArrayList<>(Collections.singletonList(10)), eventsData.EVENTS_FOR_TRANSFER_DUTY_WITH_MALFUNCTION_DATA_DIAGNOST(Accounts.TEST_DRIVER_ID), true},
                //MC
                {new ArrayList<>(Collections.singletonList(11)), eventsData.EVENTS_FOR_TRANSFER_DUTY_WITH_MALFUNCTION_DATA_DIAGNOST(Accounts.TEST_DRIVER_ID), false},
                //ML, MC
                {new ArrayList<>(Arrays.asList(10, 11)), eventsData.EVENTS_FOR_TRANSFER_DUTY_WITH_MALFUNCTION_DATA_DIAGNOST(Accounts.TEST_DRIVER_ID), false},
                //ML, MC, D
                {new ArrayList<>(Arrays.asList(10, 11, 12)), eventsData.EVENTS_FOR_TRANSFER_DUTY_WITH_MALFUNCTION_DATA_DIAGNOST(Accounts.TEST_DRIVER_ID), false},
                //DDL
                {new ArrayList<>(Collections.singletonList(8)), eventsData.EVENTS_FOR_TRANSFER_DUTY_WITH_MALFUNCTION_DATA_DIAGNOST(Accounts.TEST_DRIVER_ID), false},
                //DDC
                {new ArrayList<>(Collections.singletonList(7)), eventsData.EVENTS_FOR_TRANSFER_DUTY_WITH_MALFUNCTION_DATA_DIAGNOST(Accounts.TEST_DRIVER_ID), false},
                //DDL, DDC
                {new ArrayList<>(Arrays.asList(7, 8)), eventsData.EVENTS_FOR_TRANSFER_DUTY_WITH_MALFUNCTION_DATA_DIAGNOST(Accounts.TEST_DRIVER_ID), false},
                //DDL, DDC, ON
                {new ArrayList<>(Arrays.asList(7, 8, 9)), eventsData.EVENTS_FOR_TRANSFER_DUTY_WITH_MALFUNCTION_DATA_DIAGNOST(Accounts.TEST_DRIVER_ID), false},
                //D, I x 3, D, ML, DDL
                {new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6)), eventsData.EVENTS_FOR_TRANSFER_DUTY_WITH_MALFUNCTION_DATA_DIAGNOST(Accounts.TEST_DRIVER_ID), false},

        };
    }

    @Test(dataProvider = "default")
    public void te_transfer_001(ArrayList<Integer> elementsToSelect, List<EventEntity> eventsList, boolean insertAndDeleteEvents) {
        if (insertAndDeleteEvents) {
            try {
                EventDAO.deleteEvents(Accounts.TEST_DRIVER_ID);
                EventDAO.deleteEvents(SECOND_DRIVER_ID);
                EventDAO.createEvents(eventsList);
                EventDAO.createEvents(eventsData.FIRST_EVENT(SECOND_DRIVER_ID));
            } catch (SQLException throwables) {
                log.error(throwables);
                Assert.fail(throwables.toString());
            }
        }
        doTransfer(elementsToSelect);
    }

    @DataProvider(name = "bdx-cert")
    public Object[][] bdx_cert_provider() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(0, 1)), true},
                {new ArrayList<>(Arrays.asList(5, 6, 7, 8)), false}

        };
    }

    @Test(dataProvider = "bdx-cert")
    public void te_transfer_002_bdx_cert(ArrayList<Integer> elementsToSelect, boolean insert) {
        if (insert) {
            try {
                EventDAO.deleteBDXEvents();
                EventDAO.createBDX(eventsData.EVENTS_FOR_TRANSFER_BDX(Accounts.TEST_DRIVER_ID));
                EventDAO.createEvents(eventsData.EVENTS_FOR_TRANSFER_DUTY_CERT_BDX(Accounts.TEST_DRIVER_ID));
            } catch (SQLException throwables) {
                log.error(throwables);
                Assert.fail(throwables.toString());
            }
        }
        doTransfer(elementsToSelect);
    }


    @DataProvider(name = "validations")
    public Object[][] validations_provider() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(0, 1)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID)
                        , eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS_FOR_SECOND_DRIVER(SECOND_DRIVER_ID), true},
                {new ArrayList<>(Arrays.asList(3, 4)), eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS(Accounts.TEST_DRIVER_ID)
                        , eventsData.EVENTS_FOR_TRANSFER_DUTY_EVENTS_FOR_SECOND_DRIVER(SECOND_DRIVER_ID), false},
        };
    }

    @Test(dataProvider = "validations")
    public void te_transfer_003_validations(ArrayList<Integer> elementsToSelect, List<EventEntity> eventsListForFirstDriver
            , List<EventEntity> eventsListForSecondDriver, boolean insert) {
        if (insert) {
            try {
                EventDAO.deleteEvents(Accounts.TEST_DRIVER_ID);
                EventDAO.deleteEvents(SECOND_DRIVER_ID);
                EventDAO.createEvents(eventsListForFirstDriver);
                EventDAO.createEvents(eventsListForSecondDriver);
            } catch (SQLException throwables) {
                log.error(throwables);
                Assert.fail(throwables.toString());
            }
        }
        editor.changeDriverView(FIRST_DRIVER_NAME);
        editor.openTransactionAndInputValues();
        TransferTool transferTool = new TransferTool(elementsToSelect);
        Assert.assertTrue(transferTool.toTransferEvents(ModificationStep.PREVIEW)
                .isCorrectTransferValidation());
        editor.changeDriverView(SECOND_DRIVER_NAME);
        if (editor.isTransactionOpen()) {
            editor.deleteTransaction();
            Assert.fail("Transaction is open!");
        }
        transferTool.checkThatThereAreNoEventsInTable();
    }
}
