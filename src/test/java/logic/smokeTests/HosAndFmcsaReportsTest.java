package logic.smokeTests;

import io.qameta.allure.Step;
import io.qameta.allure.testng.TestInstanceParameter;
import logic.AddAndEditDriverProfileTests;
import logic.email.EmailReader;
import logic.pages.companyProfile.drivers.driverProfile.HosTab;
import logic.pages.companyProfile.drivers.ProfilesTab;
import logic.report.LogToAllure;
import logic.variables.Accounts;
import logic.variables.Listener;
import logic.variables.UrlVariables;
import logic.webdriver.DriverFactory;
import logic.widgets.Header;
import logic.widgets.NavigationBar;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.*;
import static logic.webdriver.DriverFactory.getDriver;
@Listeners(Listener.class)

public class HosAndFmcsaReportsTest {
    @TestInstanceParameter ("Interation")
    int i = 1;
    public Header header;
    private EmailReader emailReader = null;
    private HosTab hosTab = null;
    private ArrayList<String> newTab = null;
    private ProfilesTab profilesTab = null;
    private ArrayList<String[]> driversName = new ArrayList<>();
    private static final Logger log = Logger.getLogger(AddAndEditDriverProfileTests.class);
    @BeforeClass
    @Step("Initialization of the browser driver. Open a browser window. Go to the main page.")
    public void install() {
        profilesTab = new ProfilesTab();
        getDriver().get(UrlVariables.getBaseURL());
        LogToAllure.logToAllure("Go to URL ", UrlVariables.getBaseURL());
        log.info("Go to " + UrlVariables.getBaseURL());
        hosTab = new HosTab();
        header = new Header();
        header
                .clickOnLogin()
                .setValuesIntoLoginForm(Accounts.getLoginValues())
                .clickBtnSubmitLogin();
       /* AdminPage adminPage = new AdminPage();
        adminPage
                .closeConfirmStartShiftWindow()
                .goToCustomersPage()
                .findAndLoginAsCompany(Accounts.getCompanyForLogin())*/
                new NavigationBar()
                .goToDriversPage();
        driversName = profilesTab.parseDriversFirstName();
    }
    @BeforeMethod
    public void connectToEmailServer(ITestContext context) throws MessagingException {
        context.setAttribute("driver", DriverFactory.getDriver());
        emailReader = new EmailReader(Accounts.EMAIL_ADDRESS, Accounts.EMAIL_PASSWORD, Accounts.EMAIL_SERVER);
    }
    @AfterMethod
    public void afterMethod(){
        getDriver().close();
        newTab = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(newTab.get(0));
    }
    @AfterClass
    public void logout(){
        header.logout();
    }
    @DataProvider(name = "default")
    public Iterator<Object[]> driver(){
        List<Object[]> list = new ArrayList<>();
        for (String[] driverName:driversName) {
            list.add(new Object[]{driverName[0],driverName[1]});
        }
        return list.iterator();
    }
    @Test (dataProvider = "default")
    public void te_hos_report_001(Object [] firstName) throws IOException, MessagingException {
        LogToAllure.logToAllure("Start test for driver: " + Arrays.toString(firstName));
        profilesTab.openDriverHosPage(firstName[0].toString(),firstName[1].toString());
        newTab = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(newTab.get(1));
        hosTab.generateCsvReportToPersonalMail(-15,0);
        assertNotNull(emailReader.searchCsvReportMail());

        hosTab.generateHosReport(-14,0,"USA");
        assertNotNull(UrlVariables.checkGenerateHosReport("generateHOSPdfReport"));
        hosTab.generateHosReport(-14,0,"Canada");
        assertNotNull(UrlVariables.checkGenerateHosReport("generateHOSPdfReport"));
    }
}
