package logic.pages.fuelControl;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FuelCardHistoryTab extends FuelControlPage {
    @FindBy(css = "input[ng-model='vm.searchCardQuery']")
    private WebElement historyRecordsField;
    @FindBy(css = "input[ng-model='vm.cardNumber']")
    private WebElement cardNumberField;
    @FindBy(css = "input[ng-model='vm.truckNumber']")
    private WebElement truckNumberField;
    @FindBy(css = "input[ng-model='vm.driverName']")
    private WebElement driverNameField;
    @FindBy(css = "input[ng-model='vm.dateFrom']")
    private WebElement dateFromField;
    @FindBy(css = "input[ng-model='vm.dateTo']")
    private WebElement dateToField;
    @FindBy(css = "input[ng-model='vm.filterStatusError']")
    private WebElement showOnlyErrorCheckbox;
    @FindBy(css = "input[ng-model='vm.showToClient']")
    private WebElement systemInfoCheckbox;
    @FindBy(css = "div[ui-grid='vm.fcHistoryGridOption']")
    private WebElement tableBody;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(historyRecordsField, "History Records field")) errorsCount++;
        if (!isElementDisplayedOnPage(cardNumberField, "Search by Card Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(truckNumberField, "Truck Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(driverNameField, "Driver Name field")) errorsCount++;
        if (!isElementDisplayedOnPage(dateFromField, "Date From field")) errorsCount++;
        if (!isElementDisplayedOnPage(dateToField, "Date To field")) errorsCount++;
        if (!isElementDisplayedOnPage(showOnlyErrorCheckbox, "Show Only Error checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(systemInfoCheckbox, "System Info checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(tableBody, "Table")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
