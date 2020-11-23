package logic.pages.cashControl.actions;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencyExchangeBlock extends ActionsMenu{
    //@FindBy (xpath = "//currency-exchange/div[1]/div[2]/div[1]/div/ng-select")
    @FindBy (xpath = "//currency-exchange/descendant::label[contains(text(),'Driver')]/following-sibling::ng-select")
    private WebElement driverField;
    @FindBy (css = "input[placeholder='Amount']")
    private WebElement outgoingAmountField;
    @FindBy (css = "input[placeholder='Exchange Rate']")
    private WebElement exchangeRateField;
    @FindBy (xpath = "//currency-exchange/descendant::label[contains(text(),'Incoming')]/following-sibling::div/child::input")
    private WebElement incomingAmountField;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(driverField, "Driver field")) errorsCount++;
        if (!isElementDisplayedOnPage(outgoingAmountField, "Outgoing Amount field")) errorsCount++;
        if (!isElementDisplayedOnPage(exchangeRateField, "Exchange Rate field")) errorsCount++;
        if (!isElementDisplayedOnPage(incomingAmountField, "Incoming Amount field")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;    }
}
