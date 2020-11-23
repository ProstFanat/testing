package logic.pages;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvoicesPage extends BasePage {
    @FindBy(tagName = "h2")
    private WebElement pageHeader;
    @FindBy(css = "input[placeholder='Date From']")
    private WebElement dateFromField;
    @FindBy(css = "input[placeholder='Date To']")
    private WebElement dateToField;
    @FindBy(css = "ng-select[placeholder='Select Customer Name ']")
    private WebElement selectCustomerNameField;
    @FindBy(css = "ng-select[placeholder='Select Division Name ']")
    private WebElement selectDivisionNameField;
    @FindBy(css = "ng-select[formcontrolname='orderNumber']")
    private WebElement orderNumberField;
    @FindBy(css = "ng-select[placeholder='Select status']")
    private WebElement selectStatusField;
    @FindBy(xpath = "//button[contains(text(),'Filter')]")
    private WebElement filterBtn;
    @FindBy(xpath = "//button[contains(text(),'Create Invoice')]")
    private WebElement createInvoice;
    @FindBy(className = "modal-content")
    private WebElement createInvoiceForm;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelBtn;
    @FindBy(className = "cash-tables-wrapper")
    private WebElement cashTable;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(60, pageHeader);
        if (!isElementDisplayedOnPage(pageHeader, "Page Header")) errorsCount++;
        if (!checkTextOnElement(pageHeader, "Invoices")) errorsCount++;
        if (!isElementDisplayedOnPage(dateFromField, "Date From field")) errorsCount++;
        if (!isElementDisplayedOnPage(dateToField, "Date To field")) errorsCount++;
        if (!isElementDisplayedOnPage(selectCustomerNameField, "Select Customer Name field")) errorsCount++;
        if (!isElementDisplayedOnPage(selectDivisionNameField, "Select Division Name field")) errorsCount++;
        if (!isElementDisplayedOnPage(orderNumberField, "Select Order Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(selectStatusField, "Select Status field")) errorsCount++;
        if (!isElementDisplayedOnPage(filterBtn, "Filter button")) errorsCount++;
        if (!isElementDisplayedOnPage(cashTable, "Table block")) errorsCount++;
        if (!isElementDisplayedOnPage(createInvoice, "Create Invoice button")) errorsCount++;
        else {
            PdfReport.createNewSubAnchorBold("Create Invoice modal");
            createInvoice.click();
            waitToVisibilityOf(10, createInvoiceForm);
            if (!isElementDisplayedOnPage(createInvoiceForm, "Create Invoice form")) errorsCount++;
            cancelBtn.click();
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
