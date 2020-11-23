package logic.pages.cashControl;

import logic.pages.cashControl.actions.ActionsMenu;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TripTab extends CashControlPage {

    @FindBy(css = "ng-select[formcontrolname='driver']")
    private WebElement driverField;
    @FindBy(css = "input[placeholder='Date From']")
    private WebElement dateFromField;
    @FindBy(css = "input[placeholder='Date To']")
    private WebElement dateToField;
    @FindBy(css = "ng-select[bindvalue='poolId']")
    private WebElement poolNameField;
    @FindBy(css = "ng-select[placeholder='Trip']")
    private WebElement tipNumberField;
    @FindBy(xpath = "//button[contains(text(),'Filter')]")
    private WebElement filterButton;
    @FindBy(xpath = "//button[contains(text(),'Create Reporting Period')]")
    private WebElement createReportingPeriodButton;
    @FindBy(id = "button-basic")
    private WebElement actionsButton;
    @FindBy(className = "total-balance-block")
    private WebElement totalBalanceBlock;
    @FindBy(tagName = "ngx-datatable")
    private WebElement dataTable;
    @FindBy(xpath = "//app-reporting-period-modal/descendant::label[contains(text(),'Date From')]/following-sibling::input")
    private WebElement dateFromFieldCreateReportingPeriodModal;
    @FindBy(xpath = "//app-reporting-period-modal/descendant::label[contains(text(),'Date To')]/following-sibling::input")
    private WebElement dateToFieldCreateReportingPeriodModal;
    @FindBy(xpath = "//app-reporting-period-modal/descendant::button[contains(text(),'Cancel')]")
    private WebElement cancelButtonCreateReportingPeriodModal;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(driverField, "Driver field")) errorsCount++;
        if (!isElementDisplayedOnPage(dateFromField, "Date From field")) errorsCount++;
        if (!isElementDisplayedOnPage(dateToField, "Date To field")) errorsCount++;
        if (!isElementDisplayedOnPage(poolNameField, "Pool Name field")) errorsCount++;
        if (!isElementDisplayedOnPage(tipNumberField, "Tip Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(filterButton, "Filter button")) errorsCount++;
        if (!isElementDisplayedOnPage(totalBalanceBlock, "Total Balance block")) errorsCount++;
        if (!isElementDisplayedOnPage(dataTable, "Data table")) errorsCount++;
        if (!isElementDisplayedOnPage(createReportingPeriodButton, "Create Reporting Period button")) errorsCount++;
        else {
            PdfReport.createNewSubAnchorNotBold("Create Reporting Period");
            clickOnElement(createReportingPeriodButton);
            waitToVisibilityOf(10, dateFromFieldCreateReportingPeriodModal);
            if (!isElementDisplayedOnPage(dateFromFieldCreateReportingPeriodModal, "Date From field in Create Reporting Period modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(dateToFieldCreateReportingPeriodModal, "Date To field in Create Reporting Period modal"))
                errorsCount++;
            clickOnElement(cancelButtonCreateReportingPeriodModal);
        }
        if (!isElementDisplayedOnPage(actionsButton, "Actions button")) errorsCount++;
        else {
            PdfReport.createNewSubAnchor("Actions menu");
            if (!new ActionsMenu().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }

}
