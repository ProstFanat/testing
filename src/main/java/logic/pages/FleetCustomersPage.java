package logic.pages;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FleetCustomersPage extends BasePage {
    @FindBy(css = "input[placeholder='Customer Name']")
    private WebElement customerNameInput;
    @FindBy(css = "input[placeholder='Phone']")
    private WebElement phoneInput;
    @FindBy(css = "input[placeholder='Email']")
    private WebElement emailInput;
    @FindBy(css = "ng-select[placeholder='Status']")
    private WebElement statusSelect;
    @FindBy(xpath = "//button[contains(text(),'Filter Customers')]")
    private WebElement filterCustomerButton;
    @FindBy(tagName = "ngx-datatable")
    private WebElement customerDatatable;
    @FindBy(xpath = "//button[contains(text(),'Create Customer...')]")
    private WebElement createCustomerButton;
    @FindBy(tagName = "create-customer-modal")
    private WebElement createCustomerModal;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelButton;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(customerNameInput, "Customer Name field")) errorsCount++;
       /* if (!isElementDisplayedOnPage(phoneInput, "Phone field")) errorsCount++;
        if (!isElementDisplayedOnPage(emailInput, "Email field")) errorsCount++;*/
        if (!isElementDisplayedOnPage(statusSelect, "Status select")) errorsCount++;
        if (!isElementDisplayedOnPage(filterCustomerButton, "Filter Customer button")) errorsCount++;
        if (!isElementDisplayedOnPage(createCustomerButton, "Create Customer button")) errorsCount++;
        else {
            clickOnElement(createCustomerButton);
            waitToVisibilityOf(10, createCustomerModal);
            PdfReport.createNewSubAnchorNotBold("Create Customer Form");
            if (!isElementDisplayedOnPage(createCustomerModal, "Create Customer modal")) errorsCount++;
            clickOnElement(cancelButton);
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
