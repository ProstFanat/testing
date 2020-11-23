package logic.pages.fuelControl;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FuelCardsTab extends FuelControlPage {
    @FindBy(css = "input[ng-model='vm.searchCardQuery']")
    private WebElement searchCardField;
    @FindBy(css = "input[ng-model='vm.cardNumber']")
    private WebElement cardNumberField;
    @FindBy(css = "input[placeholder='Search by policy number...']")
    private WebElement policyNumberField;
    @FindBy(css = "input[ng-model='vm.truckNumber']")
    private WebElement truckNumberField;
    @FindBy(css = "input[ng-model='vm.driverName']")
    private WebElement driverNameField;
    @FindBy(css = "input[ng-model='vm.statusYes']")
    private WebElement statusYesCheckbox;
    @FindBy(css = "input[ng-model='vm.statusNo']")
    private WebElement statusNoCheckbox;
    @FindBy(css = "input[ng-model='vm.statusDel']")
    private WebElement statusDelCheckbox;
    @FindBy(css = "div[ui-grid='vm.fcListGridOption']")
    private WebElement tableBody;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(searchCardField, "Search Cards field")) errorsCount++;
        if (!isElementDisplayedOnPage(cardNumberField, "Search by Card Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(policyNumberField, "Search by Policy Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(truckNumberField, "Truck Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(driverNameField, "Driver Name field")) errorsCount++;
        if (!isElementDisplayedOnPage(statusYesCheckbox, "Status Yes checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(statusNoCheckbox, "Status No checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(statusDelCheckbox, "Status Del checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(tableBody, "Table")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
