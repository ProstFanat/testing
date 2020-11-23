package logic.pages.cashControl.actions;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IssueCashToDriverBlock extends ActionsMenu{
    //@FindBy(xpath = "//app-transfer-modal/descendant::label[starts-with(text(),'Pool')]/following-sibling::ng-select")
    @FindBy(css = "ng-select[placeholder='Cash Pool']")
    private WebElement cashPoolSelect;
    @FindBy (css = "ng-select[placeholder='Driver']")
    private WebElement driverSelect;
    @FindBy (css = "input[formcontrolname='amount']")
    private WebElement amountInput;
    @FindBy(xpath = "//app-transfer-modal/descendant::button[contains(text(),'Cancel')]")
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
        return errorsCount == 0;    }
}
