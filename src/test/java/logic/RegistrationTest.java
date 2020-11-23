package logic;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import logic.email.EmailReader;
import logic.pages.RegistrationPage;
import logic.report.LogToAllure;
import logic.variables.Accounts;
import logic.variables.Listener;
import logic.variables.UrlVariables;
import logic.widgets.Header;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.*;

import javax.mail.MessagingException;

import static logic.webdriver.DriverFactory.getDriver;

@Listeners(Listener.class)

public class RegistrationTest {
    final String FIRST_PAGE_REG_FLAG = "Only First Page Registration";
    final String SECOND_PAGE_REG_FLAG = "Second Page Registration";

    final String FIRST_NAME = "Yevhenii";
    final String LAST_NAME = "Test";
    final String PASSWORD = "Test1234";

    final String TEMPLATE_VALUE = "Template";
    private static final Logger log = Logger.getLogger(RegistrationTest.class);
    //private final String ORGANIZATION_PIN = "YZ4SU";
    private final String ORGANIZATION_PIN = "H7BWA";
    private RegistrationPage registrationPage = null;

    @BeforeClass
    @Step("Initialization of the browser driver. Open a browser window. Go to the main page.")
    public void install() {
        getDriver().get(UrlVariables.getBaseURL());
        LogToAllure.logToAllure("Go to URL ", UrlVariables.getBaseURL());
        log.info("Go to " + UrlVariables.getBaseURL());

    }

    @BeforeMethod
    public void beforeMethod(ITestContext context) {
        context.setAttribute("driver", getDriver());
        Header header = new Header();
        header.clickOnLogin()
                .clickOnRegisterNewCompany();
        registrationPage = new RegistrationPage();
    }

    @AfterMethod
    public void afterMethod() {
        registrationPage = null;
        getDriver().get(UrlVariables.getBaseURL());
        try {
            new EmailReader(Accounts.EMAIL_ADDRESS, Accounts.EMAIL_PASSWORD, Accounts.EMAIL_SERVER).copyAllMessagesToReminderFolder();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void close() {

        //driverFactory.getDriver().close();
    }

    @AfterGroups("successful-registration")
    public void afterSuccessfulRegistration() {

    }

    @DataProvider(name = "fleet")
    public Object[][] dataProviderFleet() {
        return new Object[][]{
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "10001", "1647362990"},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, false, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "10001", "1647362990"},
        };
    }

    @Description("Регистрация пользователя в роли Fleet с корректно заполнеными полями.")
    @Test(description = "TE_REG_001_NEW_FLEET_USER", dataProvider = "fleet")
    public void te_reg_001_new_fleet_user(String firstName, String lastName, String email, String pass, String orgName, boolean alsoDriveForCompany, String driverLicense,
                                          String country, String city, String address, String postal, String phoneNumber) {
        registrationPage.setValuesForFleet(
                firstName, lastName, email, pass, orgName, alsoDriveForCompany, driverLicense, country, city, address, postal, phoneNumber)
                .selectRegistrationType()
                .enterValuesInFieldsFirstRegPage()
                .goToNextRegistrationStep()
                .enterValuesInFieldsSecondRegPage()
                .finishRegistration()
                .getVerificationLinkFromMessage()
                .checkNewRegistration();
    }

    @DataProvider(name = "fleet-fields")
    public Object[][] dataProviderFleetFields() {
        return new Object[][]{
                {FIRST_NAME, "", "", "", "", true, "", "", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, "", "", "", true, "", "", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, "", "", true, "", "", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, "", true, "", "", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, true, "", "", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {"", LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, "12345", PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, "test@test", PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, "тест@еу.com", PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, "", PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, "#$%^#@test.com", PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "", "", "", "", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "Toronto", "", "", "", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "", "", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "10001", "", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "", "Test,5", "10001", "16473629900", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "Test", "16473629900", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "$%%#%#", "16473629900", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "тест", "16473629900", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "10001", "16473629", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "10001", "16473629900рр", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "10001", "3543453#%#$##", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, true, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "10001", "rgregergerger", SECOND_PAGE_REG_FLAG},
        };
    }

    @Description("Регистрация пользователя в роли Fleet с корректно заполнеными полями.")
    @Test(description = "TE_REG_002_FLEET_FIELDS", dataProvider = "fleet-fields")
    public void te_reg_002_fleet_fields(String firstName, String lastName, String email, String pass, String orgName, boolean alsoDriveForCompany, String driverLicense,
                                        String country, String city, String address, String postal, String phoneNumber, String regFlag) {
        registrationPage.setValuesForFleet(
                firstName, lastName, email, pass, orgName, alsoDriveForCompany, driverLicense, country, city, address, postal, phoneNumber)
                .selectRegistrationType()
                .enterValuesInFieldsFirstRegPage();
        if (regFlag.equals("Only First Page Registration"))
            registrationPage.checkGoNextRegStepIsDisabledBtn();
        else if (regFlag.equals("Second Page Registration")) {
            registrationPage.goToNextRegistrationStep()
                    .enterValuesInFieldsSecondRegPage()
                    .checkFinishRegIsEnabledBtn();
        }
    }

    @DataProvider(name = "owner")
    public Object[][] dataProviderOwner() {
        return new Object[][]{
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "10001", "1647362990"}
        };
    }

    @Description("Регистрация пользователя в роли Owner с корректно заполнеными полями.")
    @Test(description = "TE_REG_003_NEW_OWNER_USER", dataProvider = "owner")
    public void te_reg_003_new_owner_user(String firstName, String lastName, String email, String pass, String orgName, String driverLicense,
                                          String country, String city, String address, String postal, String phoneNumber) {
        registrationPage.setValuesForOwner(
                firstName, lastName, email, pass, orgName, driverLicense, country, city, address, postal, phoneNumber)
                .selectRegistrationType()
                .enterValuesInFieldsFirstRegPage()
                .goToNextRegistrationStep()
                .enterValuesInFieldsSecondRegPage()
                .finishRegistration()
                .getVerificationLinkFromMessage()
                .checkNewRegistration();
    }

    @DataProvider(name = "owner-fields")
    public Object[][] dataProviderOwnerFields() {
        return new Object[][]{
                {FIRST_NAME, "", "", "", "", "", "", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, "", "", "", "", "", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, "", "", "", "", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, "", "", "", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, "", "", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {"", LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, "12345", PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, "test@test", PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, "тест@еу.com", PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, "", PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, "#$%^#@test.com", PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "", "", "", "", FIRST_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "", "", "", "", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "Toronto", "", "", "", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "", "", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "10001", "", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "", "Test,5", "10001", "16473629900", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "Test", "16473629900", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "$%%#%#", "16473629900", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "тест", "16473629900", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "10001", "16473629", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "10001", "16473629900рр", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "10001", "3543453#%#$##", SECOND_PAGE_REG_FLAG},
                {FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, TEMPLATE_VALUE, "Canada", "Toronto", "Test,5", "10001", "rgregergerger", SECOND_PAGE_REG_FLAG},
        };
    }

    @Description("Проверка полей для регистрации Owner")
    @Test(description = "TE_REG_004_OWNER_FIELDS", dataProvider = "owner-fields")
    public void te_reg_004_owner_fields(String firstName, String lastName, String email, String pass, String orgName, String driverLicense,
                                        String country, String city, String address, String postal, String phoneNumber, String regFlag) {
        registrationPage.setValuesForOwner(
                firstName, lastName, email, pass, orgName, driverLicense, country, city, address, postal, phoneNumber)
                .selectRegistrationType()
                .enterValuesInFieldsFirstRegPage();
        if (regFlag.equals("Only First Page Registration"))
            registrationPage.checkGoNextRegStepIsDisabledBtn();
        else if (regFlag.equals("Second Page Registration")) {
            registrationPage.goToNextRegistrationStep()
                    .enterValuesInFieldsSecondRegPage()
                    .checkFinishRegIsEnabledBtn();
        }
    }

    @DataProvider(name = "driver")
    public Object[][] dataProviderDriver() {
        return new Object[][]{
                {ORGANIZATION_PIN, FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, "Mexico", "Mexico"}
        };
    }

    @Description("Регистрация пользователя в роли Driver с корректно заполнеными полями.")
    @Test(description = "TE_REG_005_DRIVER", dataProvider = "driver")
    public void te_reg_005_driver(String organizationPin, String firstName, String lastName, String email, String pass, String driverLicense,
                                  String country, String city) {
        registrationPage.setValuesForDriver(
                organizationPin, firstName, lastName, email, pass, country, city, driverLicense)
                .selectRegistrationType()
                .enterValuesInFieldsFirstRegPage()
                .finishRegistration()
                .checkNewRegistration();
    }

    @DataProvider(name = "driver-fields")
    public Object[][] dataProviderDriverFields() {
        return new Object[][]{
                {ORGANIZATION_PIN, "", "", "", "", "", "", ""},
                {ORGANIZATION_PIN, FIRST_NAME, "", "", "", "", "", ""},
                {ORGANIZATION_PIN, FIRST_NAME, LAST_NAME, "", "", "", "", ""},
                {ORGANIZATION_PIN, FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, "", "", "", ""},
                {ORGANIZATION_PIN, FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, "", "", ""},
                {"", FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, "Mexico", "Mexico"},
                {ORGANIZATION_PIN, FIRST_NAME, LAST_NAME, "12344", PASSWORD, TEMPLATE_VALUE, "Mexico", "Mexico"},
                {ORGANIZATION_PIN, FIRST_NAME, LAST_NAME, "#%#%#@gmail.com", PASSWORD, TEMPLATE_VALUE, "Mexico", "Mexico"},
                {ORGANIZATION_PIN, FIRST_NAME, LAST_NAME, "test@test", PASSWORD, TEMPLATE_VALUE, "Mexico", "Mexico"},
                {ORGANIZATION_PIN, FIRST_NAME, LAST_NAME, "тест@тест.ком", PASSWORD, TEMPLATE_VALUE, "Mexico", "Mexico"},
                {" ", " ", " ", " ", " ", " ", " ", " "}
        };
    }

    @Description("Проверка полей для регистрации Driver")
    @Test(description = "TE_REG_006_DRIVER_FIELDS", dataProvider = "driver-fields")
    public void te_reg_006_driver_fields(String organizationPin, String firstName, String lastName, String email, String pass, String driverLicense,
                                         String country, String city) {
        registrationPage.setValuesForDriver(
                organizationPin, firstName, lastName, email, pass, country, city, driverLicense)
                .selectRegistrationType()
                .enterValuesInFieldsFirstRegPage()
                .checkFinishRegIsEnabledBtn();
    }

    @DataProvider(name = "driver-pin")
    public Object[][] dataProviderDriverPin() {
        return new Object[][]{
                {"23423424", FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, "Mexico", "Mexico"},
                {"EEEE EEE", FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, "Mexico", "Mexico"},
                {"#$#$TETST", FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, "Mexico", "Mexico"},
                {ORGANIZATION_PIN + "TEST", FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, "Mexico", "Mexico"},
                {"НУЕЫЕЫВ", FIRST_NAME, LAST_NAME, TEMPLATE_VALUE, PASSWORD, TEMPLATE_VALUE, "Mexico", "Mexico"},
        };
    }

    @Description("Проверка невозможности регистрации нового Driver с некорректным Company PIN")
    @Test(description = "TE_REG_007_DRIVER_PIN", dataProvider = "driver-pin")
    public void te_reg_007_driver_pin(String organizationPin, String firstName, String lastName, String email, String pass, String driverLicense,
                                      String country, String city) {
        registrationPage.setValuesForDriver(
                organizationPin, firstName, lastName, email, pass, country, city, driverLicense)
                .selectRegistrationType()
                .enterValuesInFieldsFirstRegPage()
                .finishRegistration()
                .checkInvalidPinForDriverUser();
    }

}

