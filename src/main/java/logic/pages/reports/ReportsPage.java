package logic.pages.reports;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReportsPage extends BasePage {
    @FindBy(tagName = "h2")
    private WebElement pageHeader;
    @FindBy(className = "report-container")
    private WebElement reportContainer;
    @FindBy(linkText = "Reports")
    private WebElement reportsTab;
    @FindBy(linkText = "In Progress")
    private WebElement inProgressTab;
    @FindBy(css = "div[ui-view='reports-view']")
    private WebElement inProgressForm;
    @FindBy(css = "div[is-permitted-for='read.VIOLATION-REPORT']")
    private WebElement violationReportBlock;
    @FindBy(css = "div[is-permitted-for='read.PROBILL-REPORT']")
    private WebElement probillReportBlock;
    @FindBy(css = "div[is-permitted-for='read.EFS-TRANSACTION-REPORT']")
    private WebElement efsTransactionReportBlock;
    @FindBy(css = "div[is-permitted-for='read.FUEL-CONSUMPTION-AND-PURCHASE-REPORT']")
    private WebElement fuelConsumptionReportBlock;
    @FindBy(css = "div[is-permitted-for='read.AUDIT-REPORT']")
    private WebElement auditReportBlock;
    @FindBy(css = "div[is-permitted-for='read.AUDIT-REPORT-ON-THE-ROAD-TRIPS']")
    private WebElement auditReportOnTheRoadTripsBlock;
    @FindBy(css = "div[is-permitted-for='read.TRIP-REVENUE-REPORT']")
    private WebElement tripRevenueReportBlock;
    @FindBy(css = "div[is-permitted-for='read.LENA-REPORT']")
    private WebElement lenaReportBlock;
    @FindBy(css = "div[is-permitted-for='read.CITY-DRIVERS-REPORT']")
    private WebElement cityDriversReportBlock;
    @FindBy(css = "div[is-permitted-for='read.KIRK-FUEL-CARD-REPORT']")
    private WebElement kirkFueldCardReportBlock;
    @FindBy(css = "div[is-permitted-for='read.POD-REPORT']")
    private WebElement podReportBlock;
    @FindBy(css = "div[is-permitted-for='read.DATA-ENTRY-REPORT']")
    private WebElement dataEntryReportBlock;
    @FindBy(css = "div[is-permitted-for='read.DRIVERS-HIRED-LEFT-REPORT']")
    private WebElement driversHiredLeftReportBlock;
    @FindBy(css = "div[is-permitted-for='read.LAYOVER-WAITING-TIME-REPORT']")
    private WebElement layoverWaitingTimeReportBlock;
    @FindBy(css = "div[is-permitted-for='read.EQUIPMENT-MILEAGE-REPORT']")
    private WebElement equipmentMileageReportBlock;
    @FindBy(css = "div[ng-if='vm.showLAReports()']")
    private WebElement laReportsBlock;
    @FindBy(css = "div[is-permitted-for='read.PIN-REQUEST-REPORT']")
    private WebElement pinRequestReportBlock;
    @FindBy(css = "div[is-permitted-for='read.DRIVER-FUEL-PURCHASING-REPORT']")
    private WebElement driverFuelPurchasingReportBlock;
    @FindBy(css = "div[is-permitted-for='read.ACTIVE-DRIVERS-REPORT']")
    private WebElement activeDriversReportBlock;
    @FindBy(css = "div[is-permitted-for='read.OVERSPEED-REPORT']")
    private WebElement overspeedReportBlock;
    @FindBy(css = "div[is-permitted-for='read.TRAILERS-REPORT']")
    private WebElement trailersReportBlock;
    @FindBy(css = "div[is-permitted-for='read.TRAILERS-GPS-DIFFERENCE-REPORT']")
    private WebElement trailersGpsDifferenceReportBlock;
    @FindBy(css = "div[is-permitted-for='read.EQIPMENT-LAST-SCHEDULED-STOP-REPORT']")
    private WebElement eqipmentLastScheduledStopReportBlock;
    @FindBy(css = "div[is-permitted-for='read.LOG-AUDIT-REPORT']")
    private WebElement logAuditReportBlock;
    @FindBy(css = "div[is-permitted-for='read.ZONE-TRIGGER-REPORT']")
    private WebElement zoneTriggerReportBlock;
    @FindBy(css = "div[is-permitted-for='read.TRUCK-INACTIVITY-REPORT']")
    private WebElement truckInactivityReportBlock;
    @FindBy(css = "div[is-permitted-for='read.TRUCK-POSITION-REPORT']")
    private WebElement truckPositionReportBlock;
    @FindBy(css = "div[is-permitted-for='read.TRUCK-MOVEMENT-REPORT']")
    private WebElement truckMovementReportBlock;
    @FindBy(css = "div[is-permitted-for='read.LA-ACCOUNTING-REPORTS']")
    private WebElement laAccountingReportBlock;
    @FindBy(css = "div[is-permitted-for='read.HL-ACCOUNTING-REPORTS']")
    private WebElement hlAccountingReportBlock;
    @FindBy(css = "div[ng-if='vm.showElogActivityReport']")
    private WebElement elogActivityReportBlock;
    @FindBy(css = "div[is-permitted-for='read.ELD-PLATFORMS-AND-VERSIONS-REPORT']")
    private WebElement eldPlatformsAndVersionsReportBlock;
    @FindBy(css = "div[is-permitted-for='read.EQUIPMENT-WITH-TAGS-REPORT']")
    private WebElement equipmentWithTagsReportBlock;
    @FindBy(css = "div[is-permitted-for='read.DRIVER-ASSIGNMENT-REPORT']")
    private WebElement driverAssignmentReportBlock;
    @FindBy(css = "div[is-permitted-for='read.MISSING-CUSTOMS-DATA-REPORT']")
    private WebElement missingCustomsDataReportBlock;
    @FindBy(css = "div[is-permitted-for='read.DRIVER-CASH-FLOW-HISTORY-REPORT']")
    private WebElement driverCashFlowHistoryReportBlock;
    @FindBy(css = "div[is-permitted-for='read.EXPENSE-ACCT-HISTORY-REPORT']")
    private WebElement expenseAcctHistoryReportBlock;
    @FindBy(css = "div[is-permitted-for='read.ACTIVE-DRIVERS-BALANCES-REPORT']")
    private WebElement activeDriversBalancesReportBlock;
    @FindBy(css = "div[is-permitted-for='read.ISSUED-MONEY-CODES-REPORT']")
    private WebElement issuedMoneyCodesReportBlock;
    @FindBy(css = "div[is-permitted-for='read.DEDUCTION-FROM-SALARY-REPORT']")
    private WebElement deductionFromSalaryReportBlock;
    @FindBy(css = "div[is-permitted-for='read.INSURANCE-AND-SAFETY-BONUS-REPORT']")
    private WebElement insuranceAndSafetyBonusReportBlock;
    @FindBy(css = "div[is-permitted-for='read.FINAL-ACCOUNTING-REPORT']")
    private WebElement finalAccountingReportBlock;
    @FindBy(css = "div[is-permitted-for='read.MISSING-POD-REPORT']")
    private WebElement missingPodReportBlock;
    @FindBy(css = "div[is-permitted-for='read.CURRENCY-EXCHANGE-REPORT']")
    private WebElement currencyExchangeReportBlock;

    public List<String> getAllAvailableReports() {
        List<WebElement> reportsHeader = driver.findElements(By.tagName("h3"));
        return reportsHeader.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean generateProbillReport(String dateFrom, String dateTo) {
        WebElement dateFromField = probillReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateFrom']"));
        WebElement dateToField = probillReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateTo']"));
        WebElement generateReportButton = probillReportBlock.findElement(By.cssSelector("button[ng-click='vm.getProbillReport(vm.dateFrom, vm.dateTo)']"));
        inputTextInField(dateFromField, dateFrom, "Date From");
        inputTextInField(dateToField, dateTo, "Date To");
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateEfsTransactionReport(String dateFrom, String dateTo) {
        WebElement dateFromField = efsTransactionReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateFromEFS']"));
        WebElement dateToField = efsTransactionReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateToEFS']"));
        WebElement generateReportButton = efsTransactionReportBlock.findElement(By.cssSelector("button[ng-click='vm.getEFSTransactionReport(vm.dateFromEFS, vm.dateToEFS)']"));
        inputTextInField(dateFromField, dateFrom, "Date From");
        inputTextInField(dateToField, dateTo, "Date To");
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateFuelConsumptionAndPurchaseReport() {
        WebElement generateReportButton = fuelConsumptionReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.goToFuelConsumptionAndPurchaseReportPage()']"));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateAuditReport(String reportDate) {
        WebElement dateField = auditReportBlock.findElement(By.cssSelector("input[ng-model='vm.date']"));
        WebElement generateReportButton = auditReportBlock.findElement(By.cssSelector("button[ng-click='vm.getAuditReport(vm.date)']"));
        //inputTextInField(dateField, reportDate, "Date");
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateAuditReportsOnTheRoadTripsReport() {
        WebElement generateReportButton = auditReportOnTheRoadTripsBlock
                .findElement(By.cssSelector("button[ng-click='vm.getAuditReportOnTheRoad()']"));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateTripRevenueReport(String tripNumber) {
        WebElement tripNumberField = tripRevenueReportBlock.findElement(By.cssSelector("input[ng-model='vm.trKey']"));
        WebElement generateReportButton = tripRevenueReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getTripRevenueReport(vm.trKey)']"));
        inputTextInField(tripNumberField, tripNumber, "Trip Number");
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateLenaReport(String department) {
        WebElement departmentField = lenaReportBlock.findElement(By.cssSelector("div[ng-model='vm.selectedDepartmentId']"));
        WebElement generateReportButton = lenaReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getProbillCargoReport(vm.selectedDepartmentId)']"));
        //selectItemInSelector(departmentField, department, "Department", "a");
        clickOnElement(departmentField);
        List<WebElement> departments = driver.findElements(By.className("ui-select-choices-row-inner"));
        if (departments.size() > 0)
            clickOnElement(departments.get(0));
        else
            return false;
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateCityDriverReportReport() {
        WebElement generateReportButton = cityDriversReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getCityDriversReport()']"));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateKirkFuelCardsReportReport() {
        WebElement generateReportButton = kirkFueldCardReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getKirkFuelCardsReport()']"));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generatePodReport(String dateTo) {
        WebElement dateField = podReportBlock.findElement(By.cssSelector("input[ng-model='vm.datePOD']"));
        WebElement generateReportButton = podReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getPODReport(vm.datePOD)']"));
        inputTextInField(dateField, dateTo, "Date");
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateDataEntryReport(String dateTo) {
        WebElement dateField = dataEntryReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateDataEntry']"));
        WebElement generateReportButton = dataEntryReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getDataEntryReport(vm.dateDataEntry)']"));
        inputTextInField(dateField, dateTo, "Date");
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateDriversHiredReport(String dateFrom, String dateTo) {
        WebElement dateFromField = driversHiredLeftReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateFromDriversHiredLeft']"));
        WebElement dateToField = driversHiredLeftReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateToDriversHiredLeft']"));
        WebElement generateReportButton = driversHiredLeftReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getDriversHiredLeftReport(vm.dateFromDriversHiredLeft, vm.dateToDriversHiredLeft)']"));
        inputTextInField(dateFromField, dateFrom, "Date From");
        inputTextInField(dateToField, dateTo, "Date To");
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateNjCityListDailyReport() {
        WebElement generateReportButton = driver
                .findElement(By.cssSelector("button[ng-click='vm.getNJCityListReport()']"));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateLayoverWaitingTimeReport(String dateFrom) {
        WebElement dateField = layoverWaitingTimeReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateLayoverWaiting']"));
        WebElement generateReportButton = layoverWaitingTimeReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getLayoverWaitingReport(vm.dateLayoverWaiting)']"));
        inputTextInField(dateField, dateFrom, "Date From");
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateEquipmentMileageReport(String reportFileFormat) {
        WebElement generateReportButton = null;
        if (reportFileFormat.equals("xls"))
            generateReportButton = equipmentMileageReportBlock
                    .findElement(By.cssSelector("button[ng-click='vm.getEquipmentMileageReport()']"));
        else if (reportFileFormat.equals("xlsx"))
            generateReportButton = equipmentMileageReportBlock
                    .findElement(By.cssSelector("button[ng-click='vm.getEquipmentMileageReportXlsx()']"));
        if (generateReportButton != null)
            clickOnElement(generateReportButton);
        else
            return false;
        return true;
    }

    public boolean generatePinRequestReport() {
        WebElement generateReportButton = pinRequestReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getPINRequestReport(vm.datePINRequest)']"));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateDriversReport(String reportType) {
        WebElement generateReportButton = null;
        if (reportType.equals("All"))
            generateReportButton = activeDriversReportBlock
                    .findElement(By.cssSelector("button[ng-click='vm.getAllDriversReport()']"));
        else if (reportType.equals("Active"))
            generateReportButton = activeDriversReportBlock
                    .findElement(By.cssSelector("button[ng-click='vm.getActiveDriversReport()']"));
        if (generateReportButton != null)
            clickOnElement(generateReportButton);
        else
            return false;
        return true;
    }

    public boolean generateOverspeedReport(String dateFrom, String dateTo) {
        WebElement dateFromField = overspeedReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateFromOverspeed']"));
        WebElement dateToField = overspeedReportBlock.findElement(By.cssSelector("input[ng-model='vm.vm.dateToOverspeed']"));
        WebElement driverNameField = overspeedReportBlock.findElement(By.cssSelector("input[placeholder='Driver Name']"));
        WebElement generateReportButton = overspeedReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getOverspeedReport(vm.dateFromOverspeed, vm.dateToOverspeed, vm.driverIdOverSpeedReport)']"));
        inputTextInField(dateFromField, dateFrom, "Date From");
        inputTextInField(dateToField, dateTo, "Date To");
        clickOnElement(driverNameField);
        waitToVisibilityOf(10, overspeedReportBlock.findElement(By.className("select-dropdown-optgroup-option")));
        List<WebElement> driversOption = overspeedReportBlock.findElements(By.className("select-dropdown-optgroup-option"));
        if (driversOption.size() > 0)
            clickOnElement(driversOption.get(0));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateTrailersReport() {
        WebElement generateReportButton = trailersReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getReport()']"));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateTrailersGpsDifferenceReport() {
        WebElement generateReportButton = trailersGpsDifferenceReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getTrailersGPSReport()']"));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateZoneTriggerReport(String dateFrom, String dateTo) {
        WebElement dateFromField = zoneTriggerReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateFromZoneTriggerReport']"));
        WebElement dateToField = zoneTriggerReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateToZoneTriggerReport']"));
        WebElement driverNameField = zoneTriggerReportBlock.findElement(By.cssSelector("input[placeholder='Trigger Zone']"));
        WebElement generateReportButton = zoneTriggerReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getZoneTriggerReport(vm.triggerZoneId, vm.dateFromZoneTriggerReport, vm.dateToZoneTriggerReport)']"));
        inputTextInField(dateFromField, dateFrom, "Date From");
        inputTextInField(dateToField, dateTo, "Date To");
        clickOnElement(driverNameField);
        waitToVisibilityOf(10, zoneTriggerReportBlock.findElement(By.className("select-dropdown-optgroup-option")));
        List<WebElement> driversOption = zoneTriggerReportBlock.findElements(By.className("select-dropdown-optgroup-option"));
        if (driversOption.size() > 0)
            clickOnElement(driversOption.get(0));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateTruckInactivityReport(String hours, String miles) {
        WebElement hoursField = truckInactivityReportBlock.findElement(By.cssSelector("input[ng-model='vm.truckInactivityReport.hours']"));
        WebElement milesField = truckInactivityReportBlock.findElement(By.cssSelector("input[ng-model='vm.truckInactivityReport.radius']"));
        WebElement generateReportButton = truckInactivityReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getTruckInactivityReport(vm.truckInactivityReport)']"));
        inputTextInField(hoursField, hours, "Hours");
        inputTextInField(milesField, miles, "Miles");
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateTruckPositionReport(String days) {
        WebElement daysField = truckPositionReportBlock.findElement(By.cssSelector("input[ng-model='vm.truckPositionReport.days']"));
        WebElement truckNumberField = truckPositionReportBlock.findElement(By.cssSelector("input[placeholder='Truck Number']"));
        WebElement generateReportButton = truckPositionReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getTruckPositionReport(vm.truckPositionReport)']"));
        inputTextInField(daysField, days, "Days");
        clickOnElement(truckNumberField);
        waitToVisibilityOf(10, truckPositionReportBlock.findElement(By.className("select-dropdown-optgroup-option")));
        List<WebElement> driversOption = truckPositionReportBlock.findElements(By.className("select-dropdown-optgroup-option"));
        if (driversOption.size() > 0)
            clickOnElement(driversOption.get(0));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateTruckMovementReport(String dateFrom, String dateTo) {
        WebElement dateFromField = truckMovementReportBlock.findElement(By.cssSelector("input[ng-model='vm.truckMovementReport.fromDateTruckMovement']"));
        WebElement dateToField = truckMovementReportBlock.findElement(By.cssSelector("input[ng-model='vm.truckMovementReport.toDateTruckMovement']"));
        WebElement driverNameField = truckMovementReportBlock.findElement(By.cssSelector("input[placeholder='Truck Number']"));
        WebElement generateReportButton = truckMovementReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getTruckMovementReport(vm.truckMovementReport))']"));
        inputTextInField(dateFromField, dateFrom, "Date From");
        inputTextInField(dateToField, dateTo, "Date To");
        clickOnElement(driverNameField);
        waitToVisibilityOf(10, truckMovementReportBlock.findElement(By.className("select-dropdown-optgroup-option")));
        List<WebElement> driversOption = truckMovementReportBlock.findElements(By.className("select-dropdown-optgroup-option"));
        if (driversOption.size() > 0)
            clickOnElement(driversOption.get(0));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateElogActivityReport(String dateFrom, String dateTo) {
        WebElement dateFromField = elogActivityReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateFromElogActivityDatepicker']"));
        WebElement dateToField = elogActivityReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateToElogActivityDatepicker']"));
        WebElement generateReportButton = elogActivityReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getElogActivityReport(vm.dateFromElogActivityDatepicker, vm.dateToElogActivityDatepicker)']"));
        inputTextInField(dateFromField, dateFrom, "Date From");
        inputTextInField(dateToField, dateTo, "Date To");
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateEldPlatformAndVersionReport() {
        WebElement generateReportButton = eldPlatformsAndVersionsReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getELDPlatformsAndVersionsReport()']"));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateEquipmentWithTagsReport() {
        WebElement generateReportButton = equipmentWithTagsReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getEquipmentWithTagsReport()']"));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateDriverAssignmentReport() {
        //WebElement trucksStatusField = driverAssignmentReportBlock.findElement(By.cssSelector("div[ng-model='vm.truckStatus']"));
        WebElement generateReportButton = driverAssignmentReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getDriverAssignmentReport()']"));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateMissingCustomsDataReport() {
        WebElement generateReportButton = missingCustomsDataReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getMissingCustomsDataReport()']"));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateDriverCashFlowHistoryReport(String dateFrom, String dateTo) {
        WebElement dateFromField = driverCashFlowHistoryReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateFrom']"));
        WebElement dateToField = driverCashFlowHistoryReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateTo']"));
        WebElement driverNameField = driverCashFlowHistoryReportBlock.findElement(By.cssSelector("input[placeholder='Select Driver']"));

        WebElement generateReportButton = driverCashFlowHistoryReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getDriverCashFlowHistoryReport(vm.dateFrom, vm.dateTo, vm.driverId, vm.showAllDrivers)']"));
        inputTextInField(dateFromField, dateFrom, "Date From");
        inputTextInField(dateToField, dateTo, "Date To");
        clickOnElement(driverNameField);
        waitToVisibilityOf(10, driverCashFlowHistoryReportBlock.findElement(By.className("select-dropdown-optgroup-option")));
        List<WebElement> driversOption = driverCashFlowHistoryReportBlock.findElements(By.className("select-dropdown-optgroup-option"));
        if (driversOption.size() > 0)
            clickOnElement(driversOption.get(0));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateExpenseAcctHistoryReportBlockReport(String dateFrom, String dateTo) {
        WebElement dateFromField = expenseAcctHistoryReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateFrom']"));
        WebElement dateToField = expenseAcctHistoryReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateTo']"));
        WebElement expenseType = expenseAcctHistoryReportBlock.findElement(By.cssSelector("input[placeholder='Select Expense Type']"));

        WebElement generateReportButton = expenseAcctHistoryReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getDriverCashFlowHistoryReport(vm.dateFrom, vm.dateTo, vm.driverId, vm.showAllDrivers)']"));
        inputTextInField(dateFromField, dateFrom, "Date From");
        inputTextInField(dateToField, dateTo, "Date To");
        clickOnElement(expenseType);
        waitToVisibilityOf(10, expenseAcctHistoryReportBlock.findElement(By.className("select-dropdown-optgroup-option")));
        List<WebElement> driversOption = expenseAcctHistoryReportBlock.findElements(By.className("select-dropdown-optgroup-option"));
        if (driversOption.size() > 0)
            clickOnElement(driversOption.get(0));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateActiveDriversBalancesReportBlockReport(String dateFrom) {
        WebElement dateFromField = activeDriversBalancesReportBlock.findElement(By.cssSelector("input[ng-model='vm.date']"));
        WebElement generateReportButton = activeDriversBalancesReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getActiveDriveBalanceReport(vm.date, vm.currency)']"));
        inputTextInField(dateFromField, dateFrom, "Date");
        clickOnElement(generateReportButton);
        return true;
    }


    public boolean generateViolationReport(String dateFrom, String dateTo, String rules, boolean isActivateAllCheckboxes) {
        WebElement dateFromField = violationReportBlock.findElement(By.cssSelector("input[ng-model='vm.fromDateViolation']"));
        WebElement dateToField = violationReportBlock.findElement(By.cssSelector("input[ng-model='vm.toDateViolation']"));
        WebElement driverNameField = violationReportBlock.findElement(By.cssSelector("input[placeholder='Driver Name']"));
        WebElement selectRulesField = violationReportBlock.findElement(By.cssSelector("input[placeholder='Select Rules...']"));
        WebElement pdfReportBtn = violationReportBlock.findElement(By.cssSelector("button[ng-click='vm.getViolationReport(vm.fromDateViolation, vm.toDateViolation," +
                " vm.violationRuleSet, vm.driverIdViolationReport, vm.PDF)']"));
        if (isActivateAllCheckboxes) {
            WebElement generateLocationErrorsCheckbox = violationReportBlock.findElement(By.cssSelector("input[ng-model='vm.violationsFilter.generateLocationError']"));
            WebElement generateOverSpeedErrorsCheckbox = violationReportBlock.findElement(By.cssSelector("input[ng-model='vm.violationsFilter.generateOverSpeedError']"));
            WebElement generateOdometerErrorsCheckbox = violationReportBlock.findElement(By.cssSelector("input[ng-model='vm.violationsFilter.generateOdometerError']"));
            WebElement generateNotSignedDaySummaryErrorsCheckbox = violationReportBlock.findElement(By.cssSelector("input[ng-model='vm.violationsFilter.generateNotSignedDaySummaryError']"));
            WebElement generateNotSignedInspectionReportErrorsCheckbox = violationReportBlock.findElement(By.cssSelector("input[ng-model='vm.violationsFilter.generateNotSignedInspectionReportError']"));
            WebElement generateMissingBorderCrossErrorsCheckbox = violationReportBlock.findElement(By.cssSelector("input[ng-model='vm.violationsFilter.generateMissingBorderCrossError']"));
            WebElement generateOdometerDifferenceErrorsCheckbox = violationReportBlock.findElement(By.cssSelector("input[ng-model='vm.violationsFilter.generateOdometerDifferenceError']"));
            clickCheckbox(generateLocationErrorsCheckbox, true, "generateLocationErrorsCheckbox");
            clickCheckbox(generateOverSpeedErrorsCheckbox, true, "generateOverSpeedErrorsCheckbox");
            clickCheckbox(generateOdometerErrorsCheckbox, true, "generateOdometerErrorsCheckbox");
            clickCheckbox(generateNotSignedDaySummaryErrorsCheckbox, true, "generateNotSignedDaySummaryErrorsCheckbox");
            clickCheckbox(generateNotSignedInspectionReportErrorsCheckbox, true, "generateNotSignedInspectionReportErrorsCheckbox");
            clickCheckbox(generateMissingBorderCrossErrorsCheckbox, true, "generateMissingBorderCrossErrorsCheckbox");
            clickCheckbox(generateOdometerDifferenceErrorsCheckbox, true, "generateOdometerDifferenceErrorsCheckbox");

        }
        dateFromField.clear();
        dateToField.clear();
        driverNameField.clear();
        selectRulesField.clear();
        dateFromField.sendKeys(dateFrom);
        dateToField.sendKeys(dateTo);
        clickOnElement(driverNameField);
        waitToVisibilityOf(10, violationReportBlock.findElement(By.className("select-dropdown-optgroup-option")));
        List<WebElement> driversOption = violationReportBlock.findElements(By.className("select-dropdown-optgroup-option"));
        if (driversOption.size() > 0)
            clickOnElement(driversOption.get(0));
        selectRulesField.sendKeys(rules);
        selectRulesField.sendKeys(Keys.ENTER);
        clickOnElement(pdfReportBtn);
        return true;
    }
    /*TODO START*/

    public boolean generateIssuedMoneyCodesReport(String dateFrom, String dateTo) {
        WebElement dateFromField = issuedMoneyCodesReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateFromPickerIsOpened']"));
        WebElement dateToField = issuedMoneyCodesReportBlock.findElement(By.cssSelector("input[ng-model='vm.vm.dateToPickerIsOpened']"));
        WebElement generateReportButton = issuedMoneyCodesReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getIssuedMoneyCodesReport(vm.dateFrom, vm.dateTo)']"));
        inputTextInField(dateFromField, dateFrom, "Date From");
        inputTextInField(dateToField, dateTo, "Date To");
        clickOnElement(generateReportButton);
        return true;
    }
    public boolean generateDeductionFromSalaryReport (String dateFrom, String dateTo) {
        WebElement dateFromField = deductionFromSalaryReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateFrom']"));
        WebElement dateToField = deductionFromSalaryReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateTo']"));
        WebElement generateReportButton = deductionFromSalaryReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getDeductionFromSalaryReport(vm.dateFrom, vm.dateTo, vm.email)']"));
        inputTextInField(dateFromField, dateFrom, "Date From");
        inputTextInField(dateToField, dateTo, "Date To");
        clickOnElement(generateReportButton);
        return true;
    }
    public boolean generateFinalAccountingReport (String dateFrom, String dateTo) {
        WebElement dateFromField = finalAccountingReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateFromStr']"));
        WebElement dateToField = finalAccountingReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateToStr']"));
        WebElement generateReportButton = finalAccountingReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getFinalAccountingReport(vm.dateFrom, vm.dateTo)']"));
        inputTextInField(dateFromField, dateFrom, "Date From");
        inputTextInField(dateToField, dateTo, "Date To");
        clickOnElement(generateReportButton);
        return true;
    }
    public boolean generateDriversInsuranceAndSafetyBonusReport() {
        WebElement generateReportButton = insuranceAndSafetyBonusReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getDriversInsuranceAndSafetyBonusReport()']"));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateMissingPodReport() {
        WebElement generateReportButton = missingPodReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getMissingPODReport()']"));
        clickOnElement(generateReportButton);
        return true;
    }

    public boolean generateCurrencyExchangeReportBlockReport (String dateFrom, String dateTo) {
        WebElement dateFromField = currencyExchangeReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateFrom']"));
        WebElement dateToField = currencyExchangeReportBlock.findElement(By.cssSelector("input[ng-model='vm.dateTo']"));
        WebElement generateReportButton = currencyExchangeReportBlock
                .findElement(By.cssSelector("button[ng-click='vm.getCurrencyExchangeReport(vm.dateFrom, vm.dateTo)']"));
        inputTextInField(dateFromField, dateFrom, "Date From");
        inputTextInField(dateToField, dateTo, "Date To");
        clickOnElement(generateReportButton);
        return true;
    }
    /*TODO END*/
    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(60, pageHeader);
        if (!isElementDisplayedOnPage(pageHeader, "Page Header")) errorsCount++;
        if (!checkTextOnElement(pageHeader, "Reports")) errorsCount++;

        if (!isElementDisplayedOnPage(reportsTab, "Reports tab")) errorsCount++;
        else {
            if (!isElementDisplayedOnPage(reportContainer, "Reports container")) errorsCount++;
        }
        PdfReport.createNewSubAnchorBold("In Progress tab");
        if (!isElementDisplayedOnPage(inProgressTab, "In Progress tab")) errorsCount++;
        else {
            inProgressTab.click();
            waitToVisibilityOf(10, inProgressForm);
            if (!isElementDisplayedOnPage(inProgressForm, "In Progress form")) errorsCount++;
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }

}
