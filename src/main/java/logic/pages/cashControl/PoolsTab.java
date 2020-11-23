package logic.pages.cashControl;

import logic.report.PdfReport;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PoolsTab extends CashControlPage {
    @FindBy(css = "input[formcontrolname='name']")
    private WebElement nameField;
    @FindBy(css = "ng-select[formcontrolname='poolType']")
    private WebElement poolTypeField;
    @FindBy(css = "ng-select[placeholder='Status']")
    private WebElement statusField;
    @FindBy(xpath = "//button[contains(text(),'Filter')]")
    private WebElement filterButton;
    @FindBy(xpath = "//button[contains(text(),'Manage Expense Types')]")
    private WebElement manageExpenseTypesButton;
    @FindBy(xpath = "//button[contains(text(),'Create Pool')]")
    private WebElement createPoolButton;
    @FindBy(className = "cash-tables-wrapper")
    private WebElement cashTables;
    @FindBy(xpath = "//app-pool-modal/descendant::label[contains(text(),'Name')]/following-sibling::input")
    private WebElement nameFieldCreatePoolModal;
    @FindBy(xpath = "//app-pool-modal/descendant::label[contains(text(),'Pool Type')]/following-sibling::ng-select")
    private WebElement poolTypeFieldCreatePoolModal;
    @FindBy(xpath = "//app-pool-modal/descendant::label[contains(text(),'Balance')]/following-sibling::input")
    private WebElement balanceFieldCreatePoolModal;
    @FindBy(xpath = "//app-pool-modal/descendant::label[contains(text(),'Currency')]/following-sibling::ng-select")
    private WebElement currencyFieldCreatePoolModal;
    @FindBy(xpath = "//app-pool-modal/descendant::button[contains(text(),'Cancel')]")
    private WebElement cancelButtonCreatePoolModal;
    @FindBy(xpath = "//app-pool-modal/descendant::button[contains(text(),'Save')]")
    private WebElement saveButtonCreatePoolModal;
    @FindBy(css = "ng-select[placeholder ='Expense Type']")
    private WebElement exoticTypeFieldManageExpenseTypesModal;
    @FindBy(className = "fa-plus")
    private WebElement newExpenseTypeButtonManageExpenseTypesModal;
    @FindBy(css = "input[placeholder='Name']")
    private WebElement nameFieldManageExpenseTypesModal;
    @FindBy(xpath = "//expense-type-modal/descendant::button[contains(text(),'Cancel')]")
    private WebElement cancelButtonManageExpenseTypesModal;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(nameField, "Name field")) errorsCount++;
        if (!isElementDisplayedOnPage(poolTypeField, "Pool Type field")) errorsCount++;
        if (!isElementDisplayedOnPage(statusField, "Status field")) errorsCount++;
        if (!isElementDisplayedOnPage(filterButton, "Filter button")) errorsCount++;
        if (!isElementDisplayedOnPage(cashTables, "Cash table")) errorsCount++;
        if (!isElementDisplayedOnPage(manageExpenseTypesButton, "Manage Expense Types button")) errorsCount++;
        else {
            PdfReport.createNewSubAnchorNotBold("Manage Expense Types modal");
            clickOnElement(manageExpenseTypesButton);
            waitToVisibilityOf(10, exoticTypeFieldManageExpenseTypesModal);
            if (!isElementDisplayedOnPage(exoticTypeFieldManageExpenseTypesModal, "Exotic Type field in Manage Expense Types modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(newExpenseTypeButtonManageExpenseTypesModal, "New Expense Type button in Manage Expense Types modal"))
                errorsCount++;
            clickOnElement(newExpenseTypeButtonManageExpenseTypesModal);
            if (!isElementDisplayedOnPage(nameFieldManageExpenseTypesModal, "Name field in Manage Expense Types modal"))
                errorsCount++;
            clickOnElement(cancelButtonManageExpenseTypesModal);
        }
        waitToBeClickable(10, createPoolButton);
        if (!isElementDisplayedOnPage(createPoolButton, "Create Pool button")) errorsCount++;
        else {
            PdfReport.createNewSubAnchorNotBold("Create Pool  modal");
            clickOnElement(createPoolButton);
            waitToVisibilityOf(10, nameFieldCreatePoolModal);
            if (!isElementDisplayedOnPage(nameFieldCreatePoolModal, "Name field in Create Pool modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(poolTypeFieldCreatePoolModal, "Pool Type field in Create Pool modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(balanceFieldCreatePoolModal, "Balance field in Create Pool modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(currencyFieldCreatePoolModal, "Currency field in Create Pool modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(saveButtonCreatePoolModal, "Save button in Create Pool modal"))
                errorsCount++;
            clickOnElement(cancelButtonCreatePoolModal);
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
