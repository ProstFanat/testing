package logic.pages.cashControl;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportsTab extends CashControlPage{
    @FindBy (tagName = "active-drivers-balances")
    private WebElement activeDriversBalancesReportBlock;
    @FindBy (tagName = "currency-exchange")
    private WebElement currencyExchangeReportBlock;
    @FindBy (tagName = "driver-cash-flow-history")
    private WebElement driverCashFlowHistoryReportBlock;
    @FindBy (tagName = "expense-acct-history")
    private WebElement expenseAcctHistoryReportBlock;
    @FindBy (tagName = "final-accounting")
    private WebElement finalAccountingReportBlock;
    @FindBy (tagName = "issued-money-codes")
    private WebElement issuedMoneyCodesReportBlock;
    @FindBy (tagName = "list-of-deductions-refunds")
    private WebElement listOfDeductionsRefundsReportBlock;
    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(activeDriversBalancesReportBlock, "Active Drivers Balances Report block")) errorsCount++;
        if (!isElementDisplayedOnPage(currencyExchangeReportBlock, "Currency Exchange Report block")) errorsCount++;
        if (!isElementDisplayedOnPage(driverCashFlowHistoryReportBlock, "Driver Cash Flow History Report block")) errorsCount++;
        if (!isElementDisplayedOnPage(expenseAcctHistoryReportBlock, "Expense Acct History Report block")) errorsCount++;
        if (!isElementDisplayedOnPage(finalAccountingReportBlock, "Final Accounting Report block")) errorsCount++;
        if (!isElementDisplayedOnPage(issuedMoneyCodesReportBlock, "Issued Money Codes Report block")) errorsCount++;
        if (!isElementDisplayedOnPage(listOfDeductionsRefundsReportBlock, "List Of Deductions Refunds Report block")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;        }
}
