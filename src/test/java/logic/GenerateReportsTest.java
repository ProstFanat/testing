package logic;

import logic.exceptions.TrackEnsureException;
import logic.pages.admin.AdminPage;
import logic.pages.reports.ReportsPage;
import logic.report.LogToAllure;
import logic.report.PdfReport;
import logic.variables.Accounts;
import logic.variables.TestConstant;
import logic.variables.UrlVariables;
import logic.widgets.Header;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static logic.pages.reports.ReportsName.*;
import static logic.webdriver.DriverFactory.getDriver;
import static org.testng.Assert.fail;

public class GenerateReportsTest {
    public Header header;
    private List<String> reportsName = new ArrayList<>();
    private static final Logger log = Logger.getLogger(AddAndEditDriverProfileTests.class);
    private ReportsPage reportsPage = new ReportsPage();

    @BeforeClass
    public void parseCsvAndGetEventsFromDb() throws Exception {
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
                .findAndLoginAsCompany(Accounts.getCompanyForLogin())
                .goToNavigationBar()
                .navigateToReportsPage();
        reportsName = reportsPage.getAllAvailableReports();
        PdfReport.createReportFile("GENERATE REPORTS TEST REPORT");
    }

    @BeforeMethod
    private void deleteAllFiles() {
        for (File myFile : new File(TestConstant.PATH_TO_DOWNLOADS_FOLDER).listFiles())
            if (myFile.isFile()) myFile.delete();
    }

    @AfterClass
    private void afterClassMethod() {
        PdfReport.writeResultsToFile();
    }

    @AfterMethod
    private void afterMethod() {
        PdfReport.writeJsLogFromWebDriver();
        PdfReport.addEndOfBlockLine();
    }

    @DataProvider(name = "default")
    public Iterator<Object[]> driver() {
        List<Object[]> list = new ArrayList<>();
        for (String reportName : reportsName) {
            list.add(new Object[]{reportName});
        }
        return list.iterator();
    }

    @Test(dataProvider = "default")
    public void test(String reportName) {
        PdfReport.createNewAnchor(reportName);
        try {
            if (PROBILL_REPORTS.getReportName().equals(reportName)) {
                reportsPage.generateProbillReport("2020-11-05", "2020-11-05");
                checkGenerateReport("getProbillReport");

            } else if (EFS_TRANSACTION_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateEfsTransactionReport("2020-11-05", "2020-11-05");
                checkGenerateReport("getEFSTransactionReport");

            } else if (AUDIT_REPORTS.getReportName().equals(reportName)) {
                reportsPage.generateAuditReport("2020-11-05");
                checkGenerateReport("getAuditReport");

            } else if (TRIP_REVENUE_REPORTS.getReportName().equals(reportName)) {
                String tripNumber = "123";
                reportsPage.generateTripRevenueReport(tripNumber);
                checkGenerateReport("getTripRevenueReportByTrKey");

            } else if (LENA_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateLenaReport("CITY-ON");
                checkGenerateReport("getProbillCargoReport");

            } else if (CITY_DRIVERS_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateCityDriverReportReport();
                checkGenerateReport("getCityDriversReport");

            } else if (KIRK_FUEL_CARDS_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateKirkFuelCardsReportReport();
                checkGenerateReport("getKirkFuelCardsReport");

            } else if (POD_REPORT.getReportName().equals(reportName)) {
                reportsPage.generatePodReport("2020-11-07");
                checkGenerateReport("getPODReport");

            } else if (DATA_ENTRY_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateDataEntryReport("2020-11-07");
                checkGenerateReport("getDataEntryReport");

            } else if (DRIVERS_HIRED_LEFT_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateDriversHiredReport("2020-11-01", "2020-11-07");
                checkGenerateReport("getDriversHiredLeftReport");

            } else if (NJ_CITY_LIST_DAILY_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateNjCityListDailyReport();
                checkGenerateReport("getNJCityListReport");

            } else if (LAYOVER_WAITING_TIME_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateLayoverWaitingTimeReport("2020-11-07");
                checkGenerateReport("getLayoverWaitingReport");

            } else if (EQUIPMENT_MILEAGE_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateEquipmentMileageReport("xls");
                checkGenerateReport("getEquipmentMileageReport");
                reportsPage.generateEquipmentMileageReport("xlsx");
                checkGenerateReport("getEquipmentMileageReportXlsx");

            } else if (PIN_REQUEST_REPORT.getReportName().equals(reportName)) {
                reportsPage.generatePinRequestReport();
                checkGenerateReport("getFuelPinRequestReport");

            } else if (DRIVERS_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateDriversReport("All");
                checkGenerateReport("getAllDriversReport");
                reportsPage.generateDriversReport("Active");
                checkGenerateReport("getActiveDriversReport");

            } else if (VIOLATION_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateViolationReport("2020-11-07", "2020-11-08", "USA", true);
                checkGenerateReport("getViolationReportPDF");
                /*reportsPage.generateViolationReport("2020-11-07", "2020-11-08", "Canada", false);
                checkGenerateReport("getViolationReportPDF");*/

            } else if (TRAILERS_REPORT_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateTrailersReport();
                checkGenerateReport("getTrailersReport");

            } else if (TRAILERS_GPS_DIFFERENCE_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateTrailersGpsDifferenceReport();
                checkGenerateReport("getTrailersGPSReport");

            } else if (ZONE_TRIGGER_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateZoneTriggerReport("2020-11-07", "2020-11-08");
                checkGenerateReport("getZoneTriggerReport");

            } else if (TRUCK_INACTIVITY_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateTruckInactivityReport("1", "100");
                checkGenerateReport("getTruckInactivityReport");

            } else if (TRUCK_POSITION_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateTruckPositionReport("5");
                checkGenerateReport("getTruckPositionReport");

            } else if (TRUCK_MOVEMENT_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateTruckMovementReport("2020-11-07", "2020-11-08");
                checkGenerateReport("getTruckMovementReport");

            } else if (ELOG_ACTIVITY_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateElogActivityReport("2020-11-07", "2020-11-08");
                checkGenerateReport("getElogActivityReport");

            } else if (ELD_PLATFORMS_AND_VERSIONS_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateEldPlatformAndVersionReport();
                checkGenerateReport("getELDPlatformsAndVersionsReport");

            } else if (EQUIPMENT_WITH_TAGS_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateEquipmentWithTagsReport();
                checkGenerateReport("getEquipmentWithTagsReport");

            } else if (DRIVER_ASSIGNMENT_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateDriverAssignmentReport();
                checkGenerateReport("getDriverAssignmentReport");

            } else if (MISSING_CUSTOMS_DATA_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateMissingCustomsDataReport();
                checkGenerateReport("getMissingCustomsDataReport");

            } else if (DRIVER_CASH_FLOW_HISTORY_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateDriverCashFlowHistoryReport("2020-11-07", "2020-11-08");
                checkGenerateReport("getDriverCashFlowHistoryReport");

            } else if (EXPENSE_ACCT_HISTORY_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateExpenseAcctHistoryReportBlockReport("2020-11-07", "2020-11-08");
                checkGenerateReport("getDriverCashFlowHistoryReport");

            } else if (DRIVERS_BALANCES_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateActiveDriversBalancesReportBlockReport("2020-11-07");
                checkGenerateReport("getActiveDriveBalanceReport");

            } else if (ISSUED_MONEY_CODES_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateIssuedMoneyCodesReport("10-Nov-2020", "11-Nov-2020");
                checkGenerateReport("getIssuedMoneyCodesReport");

            } else if (LIST_OF_DEDUCTIONS_FROM_SALARY.getReportName().equals(reportName)) {
                reportsPage.generateDeductionFromSalaryReport("10-Nov-2020", "11-Nov-2020");
                checkGenerateReport("getDeductionFromSalaryReport");

            } else if (FINAL_ACCOUNTING_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateFinalAccountingReport("01-Nov-2020, 23:56:00", "11-Nov-2020, 09:39:49");
                checkGenerateReport("getFinalAccountingReport");

            } else if (DRIVER_INSURANCE_AND_SAFETY_BONUS_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateDriversInsuranceAndSafetyBonusReport();
                checkGenerateReport("getDriversInsuranceAndSafetyBonusReport");

            } else if (MISSING_PROOF_OF_DELIVERY_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateMissingPodReport();
                checkGenerateReport("getMissingPODReport");

            } else if (CURRENCY_EXCHANGE_REPORT.getReportName().equals(reportName)) {
                reportsPage.generateCurrencyExchangeReportBlockReport("10-Nov-2020", "11-Nov-2020");
                checkGenerateReport("getCurrencyExchangeReport");

            } else {
                PdfReport.writeErrorToReport("This test is not implemented", false);
                fail("This test is not implemented.");
            }
        } catch (TrackEnsureException e) {
            PdfReport.writeErrorToReport(e.getMessage(), false);
            fail(e.toString());
        }
    }

    private void checkGenerateReport(String responseName) throws TrackEnsureException {
        String fileName = UrlVariables.checkGenerateHosReport(responseName);
        if (fileName == null)
            throw new TrackEnsureException("Response method return FALSE result");
        PdfReport.writeErrorToReport("Response method return TRUE result, and download file = " + fileName, true);
        File report = new File(TestConstant.PATH_TO_DOWNLOADS_FOLDER + "/" + fileName);
        if (report.length() == 0)
            throw new TrackEnsureException("Report size is = 0");
        PdfReport.writeErrorToReport("Report file size = " + report.length(), true);

    }
}
