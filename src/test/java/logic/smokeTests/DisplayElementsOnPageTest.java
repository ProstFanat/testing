package logic.smokeTests;

import com.itextpdf.text.pdf.PdfReader;
import io.qameta.allure.Step;
import logic.BasePage;
import logic.EditorTests.CreateToolTest;
import logic.csv.ErrorLogs;
import logic.dbConnection.EventDAO;
import logic.dbConnection.EventsData;
import logic.pages.admin.AdminPage;
import logic.report.PdfReport;
import logic.variables.Accounts;
import logic.variables.UrlVariables;
import logic.webdriver.DriverFactory;
import logic.widgets.Header;
import logic.widgets.NavigationBar;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.logging.Level;

import static logic.webdriver.DriverFactory.getDriver;
import static org.testng.Assert.fail;

public class DisplayElementsOnPageTest {
    ITestResult result;
    private WebDriver driver = null;
    private static final Logger log = Logger.getLogger(DisplayElementsOnPageTest.class);
    private Header header = new Header();
    private String HELEN_COMPANY = "Hellen";
    private String  HL_COMPANY = "Test with DM";
    private String  currentCompanyName = null;
    @BeforeClass
    @Step("Initialization of the browser driver. Open a browser window. Go to the main page.")
    public void install() {
        driver = DriverFactory.getDriver();
        PdfReport.createReportFile("POST DEPLOY VALIDATION REPORT");
    }

    @AfterClass
    public void close() {
        PdfReport.writeResultsToFile();
    }

    NavigationBar navigationBar = new NavigationBar();

    @DataProvider(name = "default")
    public Object[][] method() {
        return new Object[][]{
               /* {HELEN_COMPANY,"Assets Map"},
                {HELEN_COMPANY, "Operations Board"},
                {HELEN_COMPANY, "Client Vantage Point"},
                {HELEN_COMPANY, "Triggers"},
                {HELEN_COMPANY, "Dispatch Contracts"},
                {HELEN_COMPANY, "Invoices"},
                {HELEN_COMPANY, "Trip Documents"},
                {HELEN_COMPANY, "Reports"},
                {HELEN_COMPANY, "Orders Board"},
                {HELEN_COMPANY, "Price Calculator"},
                {HELEN_COMPANY, "Fuel Control"},
                {HELEN_COMPANY, "Fleet Customers"},
                {HELEN_COMPANY, "Trip Board"},
                {HELEN_COMPANY, "Fleet Events"},
                {HELEN_COMPANY, "Messages"},
                {HELEN_COMPANY, "General"},
                {HELEN_COMPANY, "Assets"},
                {HELEN_COMPANY, "GPS Devices"},
                {HELEN_COMPANY, "Drivers"},
                {HELEN_COMPANY, "Departments"},
                {HELEN_COMPANY, "Wall Management"},
                {HELEN_COMPANY, "User Management"},
                {HELEN_COMPANY, "Dispatchers"},*/
               /* {HL_COMPANY,"Assets Map"},
                {HL_COMPANY, "Operations Board"},
                {HL_COMPANY, "Client Vantage Point"},
                {HL_COMPANY, "Address Book"},
                {HL_COMPANY, "Triggers"},
                {HL_COMPANY, "Dispatch Contracts"},
                {HL_COMPANY, "Invoices"},
                {HL_COMPANY, "Trip Documents"},
                {HL_COMPANY, "Reports"},
                {HL_COMPANY, "Orders Board"},*/
                {HL_COMPANY, "Dashboard"},
            /*    {HL_COMPANY, "Price Calculator"},
                {HL_COMPANY, "Fuel Control"},
                {HL_COMPANY, "Fleet Customers"},
                {HL_COMPANY, "Cash Control"},
                {HL_COMPANY, "Trip Board"},
                {HL_COMPANY, "Fleet Events"},
                {HL_COMPANY, "E-Manifest"},
                {HL_COMPANY, "Messages"},
                {HL_COMPANY, "General"},
                {HL_COMPANY, "Assets"},
                {HL_COMPANY, "GPS Devices"},
                {HL_COMPANY, "Drivers"},
                {HL_COMPANY, "Departments"},
                {HL_COMPANY, "Wall Management"},
                {HL_COMPANY, "User Management"},
                {HL_COMPANY, "Dispatchers"},*/
        };
    }

    @AfterMethod
    public void goToAssets() {
        PdfReport.addEndOfBlockLine();
        header.clickOnLogo();
        if (currentCompanyName.equals(HL_COMPANY))
            navigationBar.clickOnFullScreenButton();
    }

    private boolean loginToCompanyForTest (String companyName){
        driver.get(UrlVariables.getBaseURL());
        log.info("Go to " + UrlVariables.getBaseURL());
        header
                .clickOnLogin()
                .setValuesIntoLoginForm(Accounts.getLoginValues())
                .clickBtnSubmitLogin();
        AdminPage adminPage = new AdminPage();
        adminPage
                .closeConfirmStartShiftWindow()
                .goToCustomersPage()
                .findAndLoginAsCompany(companyName)
                .goToNavigationBar();
        if (companyName.equals(HL_COMPANY))
            navigationBar.clickOnFullScreenButton();
        return driver.getTitle().contains("Assets Map - TrackEnsure");
    }

    @Test(dataProvider = "default")
    public void test(String companyName, String page) {
        if (!companyName.equals(currentCompanyName)){
            currentCompanyName = companyName;
           if (!loginToCompanyForTest(companyName))
               fail("Current page is not Assets Map, actual = " + driver.getTitle());
        }
        BasePage basePage = null;
        switch (page) {
            case "Assets Map":
                basePage = navigationBar.navigateToAssetsMapPage();
                break;
            case "Operations Board":
                basePage = navigationBar.navigateToOperationsPage();
                break;
            case "Triggers":
                basePage = navigationBar.navigateToTriggersPage();
                break;
            case "Client Vantage Point":
                basePage = navigationBar.navigateToClientVintagePointPage();
                break;
            case "Dispatch Contracts":
                basePage = navigationBar.navigateToDispatchContractsPage();
                break;
            case "Invoices":
                basePage = navigationBar.navigateToInvoicesPage();
                break;
            case "Trip Documents":
                basePage = navigationBar.navigateToTripDocumentsPage();
                break;
            case "Reports":
                basePage = navigationBar.navigateToReportsPage();
                break;
            case "Orders Board":
                basePage = navigationBar.navigateToOrderTripPlannerPage();
                break;
            case "Price Calculator":
                basePage = navigationBar.navigateToPriceCalculatorPage();
                break;
            case "Fuel Control":
                basePage = navigationBar.navigateToFuelControlPage();
                break;
            case "Fleet Customers":
                basePage = navigationBar.navigateToFleetCustomersPage();
                break;
            case "Trip Board":
                basePage = navigationBar.navigateToTripBoardPage();
                break;
            case "Fleet Events":
                basePage = navigationBar.navigateToFleetEventsPage();
                break;
            case "Messages":
                basePage = navigationBar.navigateToMessagingPage();
                break;
            case "General":
                basePage = navigationBar.goToGeneralPage();
                break;
            case "Assets":
                basePage = navigationBar.goToAssetsPage();
                break;
            case "Drivers":
                basePage = navigationBar.goToDriversPage();
                break;
            case "GPS Devices":
                basePage = navigationBar.goToGPSDevice();
                break;
            case "Departments":
                basePage = navigationBar.goToDepartments();
                break;
            case "Wall Management":
                basePage = navigationBar.goToWallManagement();
                break;
            case "Data Providers":
                basePage = navigationBar.goToDataProviders();
                break;
            case "Data Consumers":
                basePage = navigationBar.goToDataConsumers();
                break;
            case "User Management":
                basePage = navigationBar.goToUserManagement();
                break;
            case "Address Book":
                basePage = navigationBar.navigateToAddressBookPage();
                break;
            case "Options":
                basePage = navigationBar.goToOptions();
                break;
            case "Dispatchers":
                basePage = navigationBar.goToDispatchers();
                break;
            case "Store":
                basePage = navigationBar.goToStore();
                break;
            case "Payments":
                basePage = navigationBar.goToPayment();
                break;
            case "Cash Control":
                basePage = navigationBar.navigateToCashControlPage();
                break;
            case "E-Manifest":
                basePage = navigationBar.navigateEManifestPage();
                break;
            case "Dashboard":
                basePage = navigationBar.navigateToDashboardPage();
        }
        PdfReport.createNewAnchor(page);
        Assert.assertTrue(basePage.isAllRequiredElementsPresent());
    }
}
