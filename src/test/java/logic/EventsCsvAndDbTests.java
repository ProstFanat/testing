package logic;

import io.qameta.allure.Allure;
import logic.csv.CsvReader;
import logic.csv.ErrorLogs;
import logic.csv.csvEvents.*;
import logic.email.EmailReader;
import logic.pages.admin.AdminPage;
import logic.pages.admin.CustomersPage;
import logic.pages.companyProfile.drivers.driverProfile.HosTab;
import logic.pages.companyProfile.drivers.ProfilesTab;
import logic.pojo.EventsPojo;
import logic.pojo.JsonToGsonParser;
import logic.report.LogToAllure;
import logic.variables.Accounts;
import logic.variables.UrlVariables;
import logic.variables.events.EventTimestamp;
import logic.widgets.Header;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.util.*;

import static logic.variables.TestConstant.NUM_OF_DAYS_FOR_CSV_REPORT_GENERATE;
import static org.testng.Assert.*;
import static logic.webdriver.DriverFactory.getDriver;
public class EventsCsvAndDbTests {
    private static final Logger log = Logger.getLogger(EventsCsvAndDbTests.class);
    public Header header;
    private EmailReader emailReader = null;
    private HosTab hosTab = null;
    private ArrayList<String> newTab = null;
    private ProfilesTab profilesTab = null;
    private ArrayList<String[]> driversName = new ArrayList<>();
    @BeforeClass
    public void parseCsvAndGetEventsFromDb() throws Exception {
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
        AdminPage adminPage = new AdminPage();
        adminPage
                .closeConfirmStartShiftWindow()
                .goToCustomersPage()
                .findAndLoginAsCompany(Accounts.getCompanyForLogin())
                .goToNavigationBar()
                .goToDriversPage();
        driversName = profilesTab.parseDriversFirstName();
        new EmailReader(Accounts.EMAIL_ADDRESS, Accounts.EMAIL_PASSWORD, Accounts.EMAIL_SERVER).copyAllMessagesToReminderFolder();
    }
    @BeforeMethod
    public void beforeTest() throws Exception {
        emailReader = new EmailReader(Accounts.EMAIL_ADDRESS, Accounts.EMAIL_PASSWORD, Accounts.EMAIL_SERVER);
    }
    @AfterMethod
    public void afterMethod(){
        log.info("Errors found during the test. " + ErrorLogs.getErrorLogs().toString());
        log.info("No event found during the test.. " + ErrorLogs.getNoSuchElementLogs().toString());
        ErrorLogs.noSuchElementLogs.clear();
        ErrorLogs.errorLogs.clear();
        getDriver().close();
        newTab = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(newTab.get(0));
        Allure.getLifecycle().updateTestCase(testResult -> testResult.setHistoryId(null));
    }
    @AfterClass
    public void getErrorLogs(){
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
    public void te_csv_001_csv_and_db_events(Object [] firstName) throws Exception {
        CsvReader csvReader = new CsvReader();
        LogToAllure.logToAllure("Start test for driver: " + Arrays.toString(firstName));
        profilesTab.openDriverHosPage(firstName[0].toString(),firstName[1].toString());
        newTab = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(newTab.get(1));

        hosTab.generateHosReport(-14,0,"USA");
        assertNotNull(UrlVariables.checkGenerateHosReport("generateHOSPdfReport"));
        hosTab.generateHosReport(-14,0,"Canada");
        assertNotNull(UrlVariables.checkGenerateHosReport("generateHOSPdfReport"));

        hosTab.generateCsvReportToPersonalMail(NUM_OF_DAYS_FOR_CSV_REPORT_GENERATE,0);
        String pathToCsvFile = emailReader.searchCsvReportMail();
        HosTab.setCurrentDriverId();
        hosTab.addNewTab();
        newTab = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(newTab.get(2));
        HashMap <String, String> queryParams = new HashMap<>();
        queryParams.put("orgId", CustomersPage.loggedOrgId);
        queryParams.put("driverId", HosTab.getCurrentDriverId());
        queryParams.put("dateFrom", String.valueOf(EventTimestamp.getDate(NUM_OF_DAYS_FOR_CSV_REPORT_GENERATE*24).getTimeInMillis()));
        queryParams.put("dateTo", String.valueOf(EventTimestamp.getDate(1).getTimeInMillis()));
        getDriver().get(UrlVariables.buildStringForGetEvents(queryParams));
        List <EventsPojo> eventFromDb =  JsonToGsonParser.parseJsonStringToGson(getDriver().findElement(By.tagName("pre")).getText());
        getDriver().close();
        newTab = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(newTab.get(1));
        //List<EventEntity> eventFromDb = EventDAO.getEvents(HosPage.getCurrentDriverId());

        EventTimestamp.driverHomeTimeZone =  hosTab.goToDetails().parseTimeZoneFromDriverInformation();
        EventCSV.driverLoginNameFromDetailsPage = hosTab.goToDetails().parseDriverLoginName();
        csvReader.parseCsvFile(pathToCsvFile);

        log.info("--- START CHECK: ELD Events ---");
        LogToAllure.logToAllure("START CHECK: ELD Events",csvReader.eldEventsList.toString());
        for (EldEvents event:csvReader.eldEventsList)
            event.compareEventsFromCsvAndDb(eventFromDb);

        log.info("--- START CHECK: Drivers Certification Actions ---");
        LogToAllure.logToAllure("START CHECK: Drivers Certification Actions",csvReader.driversCertificationActions.toString());
        for (DriversCertificationActions event:csvReader.driversCertificationActions)
            event.compareEventsFromCsvAndDb(eventFromDb);

        log.info("--- START CHECK: ELD Event Annotation Or Comments ---");
        LogToAllure.logToAllure("START CHECK: ELD Event Annotation Or Comments",csvReader.eldEventAnnotationOrComments.toString());
        for (EldEventAnnotationOrComments event:csvReader.eldEventAnnotationOrComments)
            event.compareEventsFromCsvAndDb(eventFromDb);

        log.info("--- START CHECK: Malfunctions And Data Diagnostic Events ---");
        LogToAllure.logToAllure("START CHECK: Malfunctions And Data Diagnostic Events",csvReader.malfunctionsAndDataDiagnosticEvents.toString());
        for (MalfunctionsAndDataDiagnosticEvents event:csvReader.malfunctionsAndDataDiagnosticEvents)
            event.compareEventsFromCsvAndDb(eventFromDb);

        log.info("--- START CHECK: ELD Login And Logout Events ---");
        LogToAllure.logToAllure("START CHECK: ELD Login And Logout Events",csvReader.eldLoginAndLogoutEvents.toString());
        for (EldLoginAndLogoutEvents event:csvReader.eldLoginAndLogoutEvents)
            event.compareEventsFromCsvAndDb(eventFromDb);

        log.info("--- START CHECK: CMV Engine Power Up And Shut Down Events ---");
        LogToAllure.logToAllure("START CHECK: CMV Engine Power Up And Shut Down Events",csvReader.cmvEnginePowerUpAndShutDownEvents.toString());
        for (CmvEnginePowerUpAndShutDownEvents event:csvReader.cmvEnginePowerUpAndShutDownEvents)
            event.compareEventsFromCsvAndDb(eventFromDb);

        log.info("--- START CHECK: Unidentified Events ---");
        LogToAllure.logToAllure("START CHECK: Unidentified Events",csvReader.unidentifiedEvents.toString());
        for (UnidentifiedEvents event:csvReader.unidentifiedEvents)
            event.compareEventsFromCsvAndDb(eventFromDb);

        assertEquals(ErrorLogs.getErrorLogs().size(),0,"The number of errors is greater than zero: ");

    }

}
