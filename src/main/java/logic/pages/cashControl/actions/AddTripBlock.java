package logic.pages.cashControl.actions;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTripBlock extends ActionsMenu {
    @FindBy(css = "input[placeholder='Trip Number']")
    private WebElement tripNumberField;
    @FindBy(xpath = "//add-driver-cash-receipt/descendant::label[contains(text(),'Driver')]/following-sibling::ng-select")
    private WebElement driverField;
    @FindBy(xpath = "//add-driver-cash-receipt/descendant::label[contains(text(),'Co-Driver')]/following-sibling::ng-select")
    private WebElement coDriverField;
    @FindBy(xpath = "//add-driver-cash-receipt/descendant::label[contains(text(),'Processing Date')]/following-sibling::input")
    private WebElement processingDateField;
    @FindBy(xpath = "//add-driver-cash-receipt/descendant::label[contains(text(),'Trip Start Date')]/following-sibling::input")
    private WebElement tripStartDateField;
    @FindBy(xpath = "//add-driver-cash-receipt/descendant::label[contains(text(),'Trip Finish Date')]/following-sibling::input")
    private WebElement tripFinishDateField;
    @FindBy(css = "input[placeholder='Trip Notes']")
    private WebElement tripNotesField;
    @FindBy(id = "status")
    private WebElement statusCheckbox;
    @FindBy(css = "ng-select[placeholder='Type']")
    private WebElement typeField;
    @FindBy(css = "input[placeholder='Amount']")
    private WebElement amountField;
    @FindBy(css = "input[placeholder='Notes']")
    private WebElement notesField;
    @FindBy(id = "paidByCashCheck0")
    private WebElement paidByCashCheckbox;
    @FindBy(id = "sendCashAdvanceEmail")
    private WebElement sendCashAdvanceEmailCheckbox;


    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(tripNumberField, "Trip Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(driverField, "Driver field")) errorsCount++;
        if (!isElementDisplayedOnPage(coDriverField, "Co-Driver field")) errorsCount++;
        if (!isElementDisplayedOnPage(processingDateField, "Processing Date field")) errorsCount++;
        if (!isElementDisplayedOnPage(tripStartDateField, "Trip Start Date field")) errorsCount++;
        if (!isElementDisplayedOnPage(tripFinishDateField, "Trip Finish field")) errorsCount++;
        if (!isElementDisplayedOnPage(tripNotesField, "Filter button")) errorsCount++;
        if (!isElementDisplayedOnPage(statusCheckbox, "Status checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(typeField, "Type field")) errorsCount++;
        if (!isElementDisplayedOnPage(amountField, "Amount field")) errorsCount++;
        if (!isElementDisplayedOnPage(notesField, "Notes field")) errorsCount++;
        if (!isElementDisplayedOnPage(paidByCashCheckbox, "Paid By Cash checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(sendCashAdvanceEmailCheckbox, "Send Cash Advance Email checkbox")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
