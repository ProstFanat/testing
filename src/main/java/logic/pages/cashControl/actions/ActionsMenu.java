package logic.pages.cashControl.actions;

import logic.pages.cashControl.TripTab;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActionsMenu extends TripTab {
    @FindBy(id = "button-basic")
    private WebElement actionButton;
    @FindBy(xpath = "//span[contains(text(),'Issue Cash to Driver')]")
    private WebElement issueCashToDriverButton;
    @FindBy(xpath = "//span[contains(text(),'Return Cash from Driver')]")
    private WebElement returnCashFromDriverButton;
    @FindBy(xpath = "//span[contains(text(),'Deduct from Salary')]")
    private WebElement deductFromSalaryButton;
    @FindBy(xpath = "//span[contains(text(),'Refund to Salary')]")
    private WebElement refundToSalaryButton;
    @FindBy(xpath = "//span[contains(text(),'Currency Exchange')]")
    private WebElement currencyExchangeButton;
    @FindBy(xpath = "//span[contains(text(),'Cash Transfer')]")
    private WebElement cashTransferButton;
    @FindBy(xpath = "//span[contains(text(),'Add Trip')]")
    private WebElement addTrip;

    public AddTripBlock openAddTripBlock(){
        clickOnElement(actionButton);
        clickOnElement(addTrip);
        return new AddTripBlock();
    }
    public IssueCashToDriverBlock openIssueCashToDriverBlock(){
        clickOnElement(actionButton);
        clickOnElement(issueCashToDriverButton);
        return new IssueCashToDriverBlock();
    }
    public ReturnCashFromDriverBlock openReturnCashFromDriverBlock(){
        clickOnElement(actionButton);
        clickOnElement(returnCashFromDriverButton);
        return new ReturnCashFromDriverBlock();
    }
    public DeductFromSalaryBlock openDeductFromSalaryBlock(){
        clickOnElement(actionButton);
        clickOnElement(deductFromSalaryButton);
        return new DeductFromSalaryBlock();
    }
    public RefundToSalaryBlock openRefundToSalaryBlock(){
        clickOnElement(actionButton);
        clickOnElement(refundToSalaryButton);
        return new RefundToSalaryBlock();
    }
    public CurrencyExchangeBlock openCurrencyExchangeBlock(){
        clickOnElement(actionButton);
        clickOnElement(currencyExchangeButton);
        return new CurrencyExchangeBlock();
    }
    public CashTransferBlock openCashTransferBlock(){
        clickOnElement(actionButton);
        clickOnElement(cashTransferButton);
        return new CashTransferBlock();
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        PdfReport.createNewSubAnchorNotBold("Add Trip block");
        if (!openAddTripBlock().isAllRequiredElementsPresent()) errorsCount++;

        PdfReport.createNewSubAnchorNotBold("Issue Cash To Driver block");
        if (!openIssueCashToDriverBlock().isAllRequiredElementsPresent()) errorsCount++;

        PdfReport.createNewSubAnchorNotBold("Refund To Salary block");
        if (!openRefundToSalaryBlock().isAllRequiredElementsPresent()) errorsCount++;

        PdfReport.createNewSubAnchorNotBold("Return Cash From Driver block");
        if (!openReturnCashFromDriverBlock().isAllRequiredElementsPresent()) errorsCount++;

        PdfReport.createNewSubAnchorNotBold("Deduct From Salary block");
        if (!openDeductFromSalaryBlock().isAllRequiredElementsPresent()) errorsCount++;

        PdfReport.createNewSubAnchorNotBold("Currency Exchange block");
        if (!openCurrencyExchangeBlock().isAllRequiredElementsPresent()) errorsCount++;

        PdfReport.createNewSubAnchorNotBold("Cash Transfer block");
        if (!openCashTransferBlock().isAllRequiredElementsPresent()) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
