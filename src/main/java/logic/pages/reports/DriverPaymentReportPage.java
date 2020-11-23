package logic.pages.reports;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DriverPaymentReportPage extends BasePage {
    @FindBy(css = "input[ng-model='vm.dateFromDriverPaymentReport']")
    private WebElement payFromDateField;
    @FindBy(css = "input[ng-model='vm.dateToDriverPaymentReport']")
    private WebElement payToDateField;
    @FindBy(css = "input[placeholder='Driver Name']")
    private WebElement driverNameField;
    @FindBy(css = "input[ng-model='vm.manualNeedSynchronize']")
    private WebElement getDataFromDispatchSystemCheckbox;
    @FindBy(id = "selectedFileBtn")
    private WebElement uploadFileButton;
    @FindBy(css = "button[ng-click='vm.getDriverPaymentReportPDF(vm.reportTypeDriverPaymentReport," +
            " vm.dateFromDriverPaymentReport, vm.dateToDriverPaymentReport, vm.driverIdDriverPaymentReport)']")
    private WebElement generatePDFButton;
    @FindBy(css = "button[ng-click='vm.getDriverPaymentReport(vm.reportTypeDriverPaymentReport, " +
            "vm.dateFromDriverPaymentReport, vm.dateToDriverPaymentReport, vm.driverIdDriverPaymentReport)']")
    private WebElement generateReportButton;
    @FindBy(css = "button[ng-click='vm.openQueueModeModal()']")
    private WebElement executeReportInBatchModeButton;
    @FindBy(css = "button[ng-click='vm.openSendReportModal()']")
    private WebElement sendLastGenerateReportButton;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(10, payFromDateField);
        if (!isElementDisplayedOnPage(payFromDateField, "Pay From Date field")) errorsCount++;
        if (!isElementDisplayedOnPage(payToDateField, "Pay To Date field")) errorsCount++;
        if (!isElementDisplayedOnPage(driverNameField, "Driver Name field")) errorsCount++;
        if (!isElementDisplayedOnPage(getDataFromDispatchSystemCheckbox, "Get Data From Dispatch System checkbox"))
            errorsCount++;
        if (!isElementDisplayedOnPage(uploadFileButton, "Upload File button")) errorsCount++;
        if (!isElementDisplayedOnPage(generatePDFButton, "Generate PDF button")) errorsCount++;
        if (!isElementDisplayedOnPage(generateReportButton, "Generate Report button")) errorsCount++;
        if (!isElementDisplayedOnPage(executeReportInBatchModeButton, "Execute Report In Batch Mode button"))
            errorsCount++;
        if (!isElementDisplayedOnPage(sendLastGenerateReportButton, "Send Last Generate Report button")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
