package logic.pages.fuelControl;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FuelPricesTab extends FuelControlPage {
    @FindBy(css = "input[ng-model='vm.selectCountry']")
    private WebElement countryField;
    @FindBy(css = "input[ng-model='vm.selectState']")
    private WebElement provinceField;
    @FindBy(css = "input[ng-model='vm.selectCity']")
    private WebElement cityField;
    @FindBy(css = "input[ng-model='vm.selectDate']")
    private WebElement billingDateField;
    @FindBy(partialLinkText = "Add USA Prices")
    private WebElement addUsaPricesButton;
    @FindBy(partialLinkText = "Add Canada Prices")
    private WebElement addCanadaPricesButton;
    @FindBy(partialLinkText = "Daily Prices")
    private WebElement dailyPricesTab;
    @FindBy(partialLinkText = "Invoices")
    private WebElement invoicesTab;
    @FindBy(id = "fuel-prices-table")
    private WebElement fuelPricesTable;
    @FindBy(partialLinkText = "Add USA Invoice")
    private WebElement addUsaInvoiceButton;
    @FindBy(partialLinkText = "Add Canada Invoice")
    private WebElement addCanadaInvoiceButton;
    @FindBy(id = "fuel-prices-invoices-table")
    private WebElement fuelPricesInvoicesTable;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(dailyPricesTab, "Search Cards field")) errorsCount++;
        else {
            clickOnElement(dailyPricesTab);
            waitToVisibilityOf(10, countryField);
            PdfReport.createNewSubAnchorNotBold("Daily Prices Tab");
            if (!isElementDisplayedOnPage(countryField, "Country field")) errorsCount++;
            if (!isElementDisplayedOnPage(provinceField, "Province field")) errorsCount++;
            if (!isElementDisplayedOnPage(cityField, "City field")) errorsCount++;
            if (!isElementDisplayedOnPage(billingDateField, "Billing Date field")) errorsCount++;
            if (!isElementDisplayedOnPage(addUsaPricesButton, "Add USA Prices button")) errorsCount++;
            if (!isElementDisplayedOnPage(addCanadaPricesButton, "Add Canada Prices button")) errorsCount++;
            if (!isElementDisplayedOnPage(fuelPricesTable, "Fuel Prices table")) errorsCount++;
        }
        if (!isElementDisplayedOnPage(invoicesTab, "Invoices field")) errorsCount++;
        else {
            clickOnElement(invoicesTab);
            waitToVisibilityOf(10, addUsaInvoiceButton);
            PdfReport.createNewSubAnchorNotBold("Invoices Tab");
            if (!isElementDisplayedOnPage(addUsaInvoiceButton, "Add USA Invoice button")) errorsCount++;
            if (!isElementDisplayedOnPage(addCanadaInvoiceButton, "Add Canada Invoice button")) errorsCount++;
            if (!isElementDisplayedOnPage(fuelPricesInvoicesTable, "Fuel Prices Invoices table")) errorsCount++;
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
