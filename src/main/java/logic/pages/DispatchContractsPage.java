package logic.pages;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DispatchContractsPage extends BasePage {
    @FindBy(tagName = "h2")
    private WebElement pageHeader;
    @FindBy(css = "ng-select[placeholder='Type to search Carrier']")
    private WebElement carrierField;
    @FindBy(css = "ng-select[placeholder='Role']")
    private WebElement roleField;
    @FindBy(css = "ng-select[placeholder='Status']")
    private WebElement statusField;
    @FindBy(xpath = "//button[contains(text(),'Filter')]")
    private WebElement filterBtn;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    private WebElement addBtn;
    @FindBy(className = "modal-content")
    private WebElement createContractForm;
    @FindBy(className = "cash-tables-wrapper")
    private WebElement cashTable;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelBtn;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(60, pageHeader);
        if (!isElementDisplayedOnPage(pageHeader, "Page Header")) errorsCount++;
        if (!checkTextOnElement(pageHeader, "Dispatch Contracts")) errorsCount++;
        if (!isElementDisplayedOnPage(carrierField, "Carrier field")) errorsCount++;
        if (!isElementDisplayedOnPage(roleField, "Role field")) errorsCount++;
        if (!isElementDisplayedOnPage(statusField, "Status field")) errorsCount++;
        if (!isElementDisplayedOnPage(filterBtn, "Filter button")) errorsCount++;
        if (!isElementDisplayedOnPage(cashTable, "Table")) errorsCount++;
        if (!isElementDisplayedOnPage(addBtn, "Add button")) errorsCount++;
        else {
            PdfReport.createNewSubAnchorBold("Create Contract modal");
            addBtn.click();
            waitToVisibilityOf(10, createContractForm);
            if (!isElementDisplayedOnPage(createContractForm, "Create Contract form")) errorsCount++;
            cancelBtn.click();
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
