package logic.pages.cashControl.actions;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CashTransferBlock extends ActionsMenu{
    @FindBy (xpath = "//cash-transfer/descendant::label[contains(text(),'From Driver')]/following-sibling::ng-select")
    private WebElement fromDriverField;
    @FindBy (css = "input[placeholder='Amount']")
    private WebElement amountField;
    @FindBy (xpath = "//cash-transfer/descendant::label[contains(text(),'To Driver')]/following-sibling::ng-select")
    private WebElement toDriverField;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(fromDriverField, "From Driver field")) errorsCount++;
        if (!isElementDisplayedOnPage(amountField, "Amount field")) errorsCount++;
        if (!isElementDisplayedOnPage(toDriverField, "To Driver field")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;    }
}
