package logic;

import io.qameta.allure.Step;
import logic.pages.admin.AdminPage;
import logic.pages.companyProfile.drivers.ProfilesTab;
import logic.pages.companyProfile.drivers.driverInfo.AddDriverProfilePage;
import logic.pages.companyProfile.drivers.driverInfo.EditDriverProfilePage;
import logic.report.LogToAllure;
import logic.variables.Accounts;
import logic.dbConnection.entity.DriverProfile;
import logic.variables.Listener;
import logic.variables.UrlVariables;
import logic.widgets.Header;
import logic.widgets.NavigationBar;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import static logic.BasePage.GET_RANDOM_NUMS;
import static logic.webdriver.DriverFactory.getDriver;
@Listeners(Listener.class)

public class AddAndEditDriverProfileTests {
    private static final Logger log = Logger.getLogger(AddAndEditDriverProfileTests.class);
    final String ELD_HOS_PROVIDER = "TrackEnsure eLog";
    final String DRIVER_FIRST_NAME = "YevheniiTest";
    final String DRIVER_LAST_NAME = "TestDriver";
    final String DRIVER_EMAIL = "hudoliy43.e+test@gmail.com";
    final String DRIVER_PASSWORD = "AutoTest4";
    final String USA_CYCLE_7_60 = "7-Days/60-Hours";
    final String USA_CYCLE_8_70 = "8-Days/70-Hours";
    final String CAN_CYCLE_7_70 = "7-Days/70-Hours";
    final String CAN_CYCLE_14_120 = "14-Days/120-Hours";
    final String ELD_ELOG = "ELD";
    final String AOBRD_ELOG = "AOBRD";
    final String LICENSE_STATE = "Arizona";
    final String TIME_ZONE = "US/Arizona";
    final String ACTIVE_STATUS = "active";
    final String INACTIVE_STATUS = "inactive";
    final String UNAVAILABLE_STATUS = "unavailable";
    public Header header;

    @BeforeClass
    @Step("Initialization of the browser driver. Open a browser window. Go to the main page.")
    public void install() {
        getDriver().get(UrlVariables.getBaseURL());
        LogToAllure.logToAllure("Go to URL ", UrlVariables.getBaseURL());
        log.info("Go to " + UrlVariables.getBaseURL());
        header = new Header();
        header
                .clickOnLogin()
                .setValuesIntoLoginForm(Accounts.getLoginValues())
                .clickBtnSubmitLogin();
        AdminPage adminPage = new AdminPage();
        adminPage
                .closeConfirmStartShiftWindow()
                .goToCustomersPage()
                .findAndLoginAsCompany(Accounts.getCompanyForLogin());
        new NavigationBar()
                .goToDriversPage();
    }

    @BeforeMethod
    public void beforeMethod() {
    }

    @AfterMethod()
    public void afterMethod() {
        getDriver().navigate().refresh();
    }

    @AfterClass
    public void logout() {
        header.logout();
    }

    @DataProvider(name = "default")
    public Object[][] method() {
        return new Object[][]{
                {new DriverProfile(ELD_HOS_PROVIDER, true, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "959595959595", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_7_60, CAN_CYCLE_7_70, ELD_ELOG, "40", "60",
                        true, "Test Exempt Comment", true,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", true, false,
                        true, "111", "", true, true,
                        true, "Manual", true, true,
                        true, true, true, true,
                        true, true, true,
                        true, false, true, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, true, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "959595959595", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_7_70, ELD_ELOG, "20", "70",
                        false, "Test Exempt Comment", true,
                        "YevheniiTest", "New York", true, "New City",
                        "Test Info", "Test Num", true, false,
                        false, "111", "", false, false,
                        false, "Automatic", false, true,
                        true, true, false, false,
                        false, false, false,
                        true, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "959595959595", INACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "60",
                        true, "Test Exempt Comment", true,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num",
                        true, false, true, "111", "",
                        true, false, false, "Manual",
                        true, true,
                        true, true, true, false,
                        false, false, true,
                        true, false, true, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "959595959595", UNAVAILABLE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "60",
                        true, "Test Exempt Comment", true,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num",
                        true, false, true, "111", "",
                        true, false, false, "Manual",
                        true, true,
                        true, true, true, false,
                        false, false, true,
                        true, false, true, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "959595959595", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_7_60, CAN_CYCLE_14_120, AOBRD_ELOG, "40", "60",
                        true, "Test Exempt Comment", true,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", true, false,
                        true, "111", "", true, true,
                        true, "Manual", true, true,
                        true, true, true, true,
                        true, true, true,
                        true, false, true, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "959595959595", INACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, AOBRD_ELOG, "40", "60",
                        false, "Test Exempt Comment", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")}
        };
    }

    @Test(dataProvider = "default")
    public void te_new_driver_001_create_new_driver(DriverProfile driverProfile) {
        AddDriverProfilePage addDriverProfilePage = new AddDriverProfilePage(driverProfile);
        ProfilesTab profilesTab = new ProfilesTab();

        profilesTab.addNewDriver();
        addDriverProfilePage
                .enterValuesInForms()
                .saveDriverProfile()
                .findDriver(driverProfile.getFirstName(), driverProfile.getStatus())
                .clickOnDriverFirstName(driverProfile.getFirstName());
        EditDriverProfilePage editDriverProfilePage = new EditDriverProfilePage(driverProfile);
        Assert.assertTrue(editDriverProfilePage.parseTrackEnsureElogDriverProfile().checkTrackEnsureElogDriverProfile(), "Error after create");

        driverProfile.setFirstName(GET_RANDOM_NUMS());
        driverProfile.setLastName(driverProfile.getLastName() + "Edit");
        driverProfile.setEmail("Edit" + driverProfile.getEmail());
        driverProfile.setPhone(GET_RANDOM_NUMS());
        driverProfile.setPassword("NewTestPass123654");
        driverProfile.setLicenseState("Colorado");
        driverProfile.setHomeTerminalTimezone("US/Central");
        driverProfile.changeCheckBoxStatus();

        editDriverProfilePage = new EditDriverProfilePage(driverProfile);

        editDriverProfilePage
                .enterValuesInForms()
                .saveDriverProfile();

        new ProfilesTab().findDriver(driverProfile.getFirstName(), driverProfile.getStatus())
                .clickOnDriverFirstName(driverProfile.getFirstName());
        Assert.assertTrue(editDriverProfilePage.parseTrackEnsureElogDriverProfile().checkTrackEnsureElogDriverProfile(), "Error after edit");
        editDriverProfilePage
                .saveDriverProfile()
                .findDriver(driverProfile.getFirstName(), driverProfile.getStatus())
                .changeDriverStatus(driverProfile.getFirstName());

        if (driverProfile.getStatus().equals("active"))
            profilesTab.deactivateDriverWindow(true);
    }

    @DataProvider(name = "add-driver-profile-fields")
    public Object[][] driver_fields() {
        return new Object[][]{
                {new DriverProfile(ELD_HOS_PROVIDER, "", "", "", "active", "", "", "", "",
                        "", "", "", "")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL, "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, "", "", "")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL, "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        "", "", "", "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL, "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), "",
                        TIME_ZONE, "", "", "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL, "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, "", LICENSE_STATE,
                        TIME_ZONE, "", "", "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL, "active", GET_RANDOM_NUMS(), "", GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, "", "", "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL, "active", "", DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, "", "", "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, "", "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, "", "", "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), "", DRIVER_EMAIL, "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, "", "", "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, "", DRIVER_LAST_NAME, DRIVER_EMAIL, "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, "", "", "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, "test#test.com", "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, "", "", "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, "test###@test.com", "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, "", "", "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, "test 123@test.com", "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, "", "", "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, "@test.com", "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, "", "", "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL, "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, "", "", "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "number", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "60",
                        false, "Test Exempt Comment", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "123654#55452", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "60",
                        false, "Test Exempt Comment", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "1 5 8 test 4 5 5", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "60",
                        false, "Test Exempt Comment", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "$%$%$#$#@@@$$#", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "60",
                        false, "Test Exempt Comment", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "1241213432423", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, "GET_RANDOM_NUMS", LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "60",
                        false, "Test Exempt Comment", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, "#$#$#$#$#$@$@#@#", LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "60",
                        false, "Test Exempt Comment", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, "TEST + NUB 4554", LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "60",
                        false, "Test Exempt Comment", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "60",
                        true, "", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "81",
                        false, "", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "-1", "80",
                        false, "", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "81", "0",
                        false, "", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "-1",
                        false, "", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "80",
                        false, "", true,
                        "", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "80",
                        false, "", true,
                        "YevheniiTest", "", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "80",
                        false, "", true,
                        "YevheniiTest", "New York", false, "",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "80",
                        false, "", true,
                        "YevheniiTest", "New York", false, "New City",
                        "", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "80",
                        false, "", true,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
        };
    }

    @Test(dataProvider = "add-driver-profile-fields")
    public void te_new_driver_002_add_new_driver_fields(DriverProfile driverProfile) {
        AddDriverProfilePage addDriverProfilePage = new AddDriverProfilePage(driverProfile);
        new ProfilesTab()
                .addNewDriver();
        addDriverProfilePage
                .enterValuesInForms()
                .saveDriverProfile();
        addDriverProfilePage
                .checkErrorMessage();
    }

    @BeforeGroups("edit-driver-fields")
    public void beforeEditDriverFieldsGroup() {
        ProfilesTab profilesTab = new ProfilesTab();
        if (!profilesTab.driverIsExists(DRIVER_FIRST_NAME)) {
            AddDriverProfilePage addDriverProfilePage = new AddDriverProfilePage(new DriverProfile(ELD_HOS_PROVIDER, true, DRIVER_FIRST_NAME, GET_RANDOM_NUMS(), DRIVER_EMAIL,
                    "959595959595", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                    TIME_ZONE, USA_CYCLE_7_60, CAN_CYCLE_7_70, ELD_ELOG, "40", "60",
                    true, "Test Exempt Comment", true,
                    "YevheniiTest", "New York", false, "New City",
                    "Test Info", "Test Num", true, false,
                    true, "111", "", true, true,
                    true, "Manual", true, true,
                    true, true, true, true,
                    true, true, true,
                    true, false, true, "20"));
            new ProfilesTab()
                    .addNewDriver();
            addDriverProfilePage
                    .enterValuesInForms()
                    .saveDriverProfile();
        }
    }


    @AfterGroups("edit-driver-fields")
    public void afterEditDriverFieldsGroup() {
        new ProfilesTab()
                .findDriver(DRIVER_FIRST_NAME, ACTIVE_STATUS)
                .changeDriverStatus(DRIVER_FIRST_NAME)
                .deactivateDriverWindow(true);
    }


    @DataProvider(name = "edit-driver-profile-fields")
    public Object[][] edit_driver_fields() {
        return new Object[][]{
                {new DriverProfile(ELD_HOS_PROVIDER, "", "", "", "active", "", "", "", "",
                        "", "", "", "")},
                {new DriverProfile(ELD_HOS_PROVIDER, "", DRIVER_LAST_NAME, DRIVER_EMAIL, "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), "", DRIVER_EMAIL, "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, "", "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL, "active", "", DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL, "active", GET_RANDOM_NUMS(), "", GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL, "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, "", LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, "test#test.com", "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, "", "", "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, "test###@test.com", "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, "", "", "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, "test 123@test.com", "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, "", "", "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, "@test.com", "active", GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, "", "", "ELD")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "number", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "60",
                        false, "Test Exempt Comment", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "123654#55452", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "60",
                        false, "Test Exempt Comment", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "1 5 8 test 4 5 5", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "60",
                        false, "Test Exempt Comment", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "$%$%$#$#@@@$$#", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "60",
                        false, "Test Exempt Comment", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "1241213432423", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, "GET_RANDOM_NUMS", LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "60",
                        false, "Test Exempt Comment", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, "#$#$#$#$#$@$@#@#", LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "60",
                        false, "Test Exempt Comment", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, "TEST + NUB 4554", LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "60",
                        false, "Test Exempt Comment", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "60",
                        true, "", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "81",
                        false, "", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "-1", "80",
                        false, "", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "81", "0",
                        false, "", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "-1",
                        false, "", false,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "80",
                        false, "", true,
                        "", "New York", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "80",
                        false, "", true,
                        "YevheniiTest", "", false, "New City",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "80",
                        false, "", true,
                        "YevheniiTest", "New York", false, "",
                        "Test Info", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "80",
                        false, "", true,
                        "YevheniiTest", "New York", false, "New City",
                        "", "Test Num", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
                {new DriverProfile(ELD_HOS_PROVIDER, false, GET_RANDOM_NUMS(), DRIVER_LAST_NAME, DRIVER_EMAIL,
                        "2342342342342", ACTIVE_STATUS, GET_RANDOM_NUMS(), DRIVER_PASSWORD, GET_RANDOM_NUMS(), LICENSE_STATE,
                        TIME_ZONE, USA_CYCLE_8_70, CAN_CYCLE_14_120, ELD_ELOG, "40", "80",
                        false, "", true,
                        "YevheniiTest", "New York", false, "New City",
                        "Test Info", "", false, false,
                        false, "111", "", false, false,
                        false, "Manual", false, false,
                        false, false, false, false,
                        false, false, false,
                        false, false, false, "20")},
        };
    }

    @Test(dataProvider = "edit-driver-profile-fields", groups = {"edit-driver-fields"})
    public void te_new_driver_003_edit_driver_fields(DriverProfile driverProfile) {
        EditDriverProfilePage editDriverProfile = new EditDriverProfilePage(driverProfile);
        new ProfilesTab()
                .findDriver(DRIVER_FIRST_NAME, ACTIVE_STATUS)
                .clickOnDriverFirstName(DRIVER_FIRST_NAME);
        editDriverProfile
                .enterValuesInForms()
                .saveDriverProfile();
        editDriverProfile
                .checkErrorMessage();
    }
}
