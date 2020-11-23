package logic.pages.cashControl.actions;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class DeductFromSalaryBlock extends ActionsMenu{
    @FindBy(xpath = "//deduct-from-salary/descendant::label[contains(text(),'Driver')]/following-sibling::ng-select")
    private WebElement driverField;
    @FindBy(css = "input[placeholder='Amount']")
    private WebElement amountField;
    @FindBy(id = "exchange-rate")
    private WebElement exchangeRateField;
    @FindBy(xpath = "//deduct-from-salary/descendant::label[starts-with(text(),'Additional')]/following-sibling::textarea")
    private WebElement additionalInformationField;
    @FindBy(css = "input[placeholder='Final Amount']")
    private WebElement finalAmountField;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(driverField, "Driver field")) errorsCount++;
        if (!isElementDisplayedOnPage(amountField, "Amount field")) errorsCount++;
        if (!isElementDisplayedOnPage(exchangeRateField, "Exchange Rate field")) errorsCount++;
        if (!isElementDisplayedOnPage(additionalInformationField, "Additional Information field")) errorsCount++;
        if (!isElementDisplayedOnPage(finalAmountField, "Final Amount field")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
