package logic.pages.cashControl.actions;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReturnCashFromDriverBlock extends ActionsMenu {
    @FindBy(xpath = "//app-return-pool/descendant::label[contains(text(),'To Pool List')]/following-sibling::ng-select")
    private WebElement cashPoolSelect;
    @FindBy(css = "ng-select[placeholder='Driver']")
    private WebElement driverSelect;
    @FindBy(css = "input[formcontrolname='amount']")
    private WebElement amountInput;
    @FindBy(xpath = "//app-return-pool/descendant::button[contains(text(),'Cancel')]")
    private WebElement closeTransferModal;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(10, cashPoolSelect);
        if (!isElementDisplayedOnPage(cashPoolSelect, "Cash Pool field")) errorsCount++;
        if (!isElementDisplayedOnPage(driverSelect, "Driver field")) errorsCount++;
        if (!isElementDisplayedOnPage(amountInput, "Amount field")) errorsCount++;
        clickOnElement(closeTransferModal);
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
