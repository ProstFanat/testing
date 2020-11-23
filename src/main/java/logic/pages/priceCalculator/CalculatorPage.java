package logic.pages.priceCalculator;

import logic.report.PdfReport;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends PriceCalculatorPage {
    @FindBy(id = "pc-calculator-origin-autocomplete")
    private WebElement originAddressField;
    @FindBy(id = "pc-calculator-destinate-autocomplete")
    private WebElement destinationAddressField;
    @FindBy(css = "input[placeholder='Origin ZIP Code']")
    private WebElement originZipCodeField;
    @FindBy(css = "input[placeholder='Destination ZIP Code']")
    private WebElement destinationZipCodeField;
    @FindBy(id = "pc-map-container")
    private WebElement mapContainer;
    @FindBy(css = "div[ng-model='vm.calculator.customerId']")
    private WebElement selectCustomerField;
    @FindBy(css = "button[uib-tooltip='Show Offset Percent for this client']")
    private WebElement markupDiscountBtn;
    @FindBy(css = "button[uib-tooltip='Show Quotes History for this client']")
    private WebElement quotesHistoryBtn;
    @FindBy(css = "button[uib-tooltip='Show History']")
    private WebElement historyBtn;
    @FindBy(css = "input[placeholder='cargo unit']")
    private WebElement cargoUnitField;
    @FindBy(css = "input[ng-model='vm.calculator.spotModeData.pallets']")
    private WebElement palletsSpotModeField;
    @FindBy(css = "input[ng-model='vm.calculator.spotModeData.weight']")
    private WebElement weightSpotModeField;
    @FindBy(css = "input[ng-model='vm.calculator.spotModeData.commodity']")
    private WebElement commoditySpotModeField;
    @FindBy(css = "input[ng-model='vm.calculator.spotModeData.rate']")
    private WebElement rateSpotModeField;
    @FindBy(css = "input[ng-model='vm.calculator.spotModeData.fuelMarkup']")
    private WebElement fuelMarkupSpotModeField;
    @FindBy(css = "input[ng-model='vm.calculator.spotModeData.expiration']")
    private WebElement expirationSpotModeField;
    @FindBy(css = "select[ng-model='vm.selectedOption']")
    private WebElement extraServicesSelect;
    @FindBy(id = "standard")
    private WebElement standardModeCheckBox;
    @FindBy(id = "spot")
    private WebElement spotModeCheckBox;
    @FindBy(id = "multiple")
    private WebElement multipleModeCheckBox;
    @FindBy(css = "select[ng-model='vm.selectedCargoType']")
    private WebElement cargoTypeStandardModeSelect;
    @FindBy(css = "select[ng-model='vm.calculator.unit.cargoProfileId']")
    private WebElement cargoUnitStandardModeSelect;
    @FindBy(css = "input[ng-model='vm.calculator.unit.value']")
    private WebElement amountStandardModeField;
    @FindBy(css = "button[ng-click='vm.clearCalculator()']")
    private WebElement clearCalculatorStandardModeButton;
    @FindBy(css = "button[ng-click='vm.calculate()']")
    private WebElement calculateStandardModeButton;
    @FindBy(css = "input[ng-model='vm.part.amount']")
    private WebElement amountMultipleModeField;
    @FindBy(css = "input[ng-model='vm.part.price']")
    private WebElement priceMultipleModeField;
    @FindBy(css = "input[ng-model='vm.calculator.multipleModeExpiration']")
    private WebElement expirationMultipleModeField;
    @FindBy(css = "input[ng-model='vm.calculator.multipleModeCommodity']")
    private WebElement commodityMultipleModeField;
    @FindBy(css = "input[ng-model='vm.calculator.multipleModeUnitsOfMeasure']")
    private WebElement unitsOfMeasureMultipleModeField;
    @FindBy(css = "input[ng-model='vm.calculator.multipleModeNotes']")
    private WebElement notesMultipleModeField;
    @FindBy(css = "input[value='USD']")
    private WebElement usdRateCurrencyMultipleModeCheckBox;
    @FindBy(css = "input[value='CAD']")
    private WebElement cadRateCurrencyMultipleModeCheckBox;
    @FindBy(css = "button[uib-tooltip='add Client Profile']")
    private WebElement addClientProfileBtn;
    @FindBy(css = "div[ng-model='vm.selectedCustomer']")
    private WebElement searchCustomerAddProfileModalField;
    @FindBy(css = "button[ng-click='vm.addNewCustomer()']")
    private WebElement addNewCustomerAddProfileModalBtn;
    @FindBy(css = "input[ng-model='vm.customer.name']")
    private WebElement customerNameAddCustomerModalInput;
    @FindBy(css = "input[ng-model='vm.customer.addressLine1']")
    private WebElement addressLineAddCustomerModalInput;
    @FindBy(css = "oi-select[ng-model='vm.customer.country']")
    private WebElement countryAddCustomerModalSelect;
    @FindBy(css = "oi-select[ng-model='vm.customer.region']")
    private WebElement regionAddCustomerModalSelect;
    @FindBy(css = "input[ng-model='vm.customer.city']")
    private WebElement cityLineAddCustomerModalInput;
    @FindBy(css = "input[ng-model='vm.customer.postalCode']")
    private WebElement postalCodeAddCustomerModalInput;
    @FindBy(css = "input[ng-model='vm.phone']")
    private WebElement phoneLineAddCustomerModalInput;
    @FindBy(css = "input[ng-model='vm.email']")
    private WebElement emailLineAddCustomerModalInput;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelBtn;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(originAddressField, "Origin Address field")) errorsCount++;
        if (!isElementDisplayedOnPage(destinationAddressField, "Destination Address field")) errorsCount++;
        if (!isElementDisplayedOnPage(originZipCodeField, "Origin ZIP Code field")) errorsCount++;
        if (!isElementDisplayedOnPage(destinationZipCodeField, "Destination ZIP Code field")) errorsCount++;
        if (!isElementDisplayedOnPage(mapContainer, "Map container")) errorsCount++;
        if (!isElementDisplayedOnPage(addClientProfileBtn, "Add Client Profile button")) errorsCount++;
        else {
            addClientProfileBtn.click();
            waitToVisibilityOf(10, searchCustomerAddProfileModalField);
            PdfReport.createNewSubAnchorBold("Add Profile modal");
            if (!isElementDisplayedOnPage(searchCustomerAddProfileModalField, "Search Customer Field in Add Profile modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(addNewCustomerAddProfileModalBtn, "Add New Customer Button in Add Profile modal"))
                errorsCount++;
            else {
                addNewCustomerAddProfileModalBtn.click();
                waitToVisibilityOf(10, customerNameAddCustomerModalInput);
                PdfReport.createNewSubAnchorBold("Add New Customer modal");
                if (!isElementDisplayedOnPage(customerNameAddCustomerModalInput, "Customer Name Input in Add Customer modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(addressLineAddCustomerModalInput, "Address Customer Input in Add Customer modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(countryAddCustomerModalSelect, "County Select in Add Customer modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(regionAddCustomerModalSelect, "State/Province Select in Add Customer modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(cityLineAddCustomerModalInput, "City Input in Add Customer modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(postalCodeAddCustomerModalInput, "Postal Code Input in Add Customer modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(phoneLineAddCustomerModalInput, "Phone Input in Add Customer modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(emailLineAddCustomerModalInput, "Email Input in Add Customer modal"))
                    errorsCount++;
                driver.findElement(By.className("close")).click();
            }
            waitToBeClickable(10, addNewCustomerAddProfileModalBtn);
            clickOnElement(cancelBtn);
        }
        waitToBeClickable(20, standardModeCheckBox);
        if (!isElementDisplayedOnPage(standardModeCheckBox, "Standard Mode checkBox")) errorsCount++;
        else {
            try {
                standardModeCheckBox.click();
            } catch (ElementClickInterceptedException e){
                clickOnElement(cancelBtn);
            }
            waitToVisibilityOf(10, selectCustomerField);
            PdfReport.createNewSubAnchorBold("Standard Mode tab");
            if (!isElementDisplayedOnPage(selectCustomerField, "Select Customer field")) errorsCount++;
            if (!isElementDisplayedOnPage(markupDiscountBtn, "Markup/Discount button")) errorsCount++;
            if (!isElementDisplayedOnPage(quotesHistoryBtn, "Quotes History button")) errorsCount++;
            if (!isElementDisplayedOnPage(cargoTypeStandardModeSelect, "Cargo Type Standard Mode select"))
                errorsCount++;
            if (!isElementDisplayedOnPage(cargoUnitStandardModeSelect, "Cargo Unit Standard Mode select"))
                errorsCount++;
            if (!isElementDisplayedOnPage(amountStandardModeField, "Amount Standard Mode field")) errorsCount++;
            if (!isElementDisplayedOnPage(extraServicesSelect, "Extra Services select")) errorsCount++;
            if (!isElementDisplayedOnPage(clearCalculatorStandardModeButton, "Clear Calculator Standard Mode button"))
                errorsCount++;
            if (!isElementDisplayedOnPage(calculateStandardModeButton, "Calculate Standard Mode button"))
                errorsCount++;
        }

        if (!isElementDisplayedOnPage(spotModeCheckBox, "Spot Mode checkbox")) errorsCount++;
        else {
            spotModeCheckBox.click();
            waitToVisibilityOf(10, selectCustomerField);
            PdfReport.createNewSubAnchorBold("Spot Mode tab");
            if (!isElementDisplayedOnPage(selectCustomerField, "Select Customer field")) errorsCount++;
            if (!isElementDisplayedOnPage(markupDiscountBtn, "Markup/Discount button")) errorsCount++;
            if (!isElementDisplayedOnPage(quotesHistoryBtn, "Quotes History button")) errorsCount++;
            if (!isElementDisplayedOnPage(historyBtn, "Quotes History button")) errorsCount++;
            if (!isElementDisplayedOnPage(cargoUnitField, "Cargo Unit input in Spot Mode"))
                errorsCount++;
            if (!isElementDisplayedOnPage(palletsSpotModeField, "Pallets input in Spot Mode"))
                errorsCount++;
            if (!isElementDisplayedOnPage(weightSpotModeField, "Weight input in Spot Mode"))
                errorsCount++;
            if (!isElementDisplayedOnPage(commoditySpotModeField, "Commodity input in Spot Mode"))
                errorsCount++;
            if (!isElementDisplayedOnPage(rateSpotModeField, "Rate input in Spot Mode"))
                errorsCount++;
            if (!isElementDisplayedOnPage(fuelMarkupSpotModeField, "Fuel Markup input in Spot Mode"))
                errorsCount++;
            if (!isElementDisplayedOnPage(expirationSpotModeField, "Expiration input in Spot Mode"))
                errorsCount++;
            if (!isElementDisplayedOnPage(extraServicesSelect, "Extra Services select")) errorsCount++;
        }

        if (!isElementDisplayedOnPage(multipleModeCheckBox, "Multiple Mode checkbox")) errorsCount++;
        else {
            multipleModeCheckBox.click();
            waitToVisibilityOf(10, selectCustomerField);
            PdfReport.createNewSubAnchorBold("Multiple Mode tab");
            if (!isElementDisplayedOnPage(selectCustomerField, "Select Customer field")) errorsCount++;
            if (!isElementDisplayedOnPage(markupDiscountBtn, "Markup/Discount button")) errorsCount++;
            if (!isElementDisplayedOnPage(quotesHistoryBtn, "Quotes History button")) errorsCount++;
            if (!isElementDisplayedOnPage(historyBtn, "Quotes History button")) errorsCount++;
            if (!isElementDisplayedOnPage(amountMultipleModeField, "Amount input in Multiple Mode"))
                errorsCount++;
            if (!isElementDisplayedOnPage(priceMultipleModeField, "Price input in Multiple Mode"))
                errorsCount++;
            if (!isElementDisplayedOnPage(expirationMultipleModeField, "Expiration input in Multiple Mode"))
                errorsCount++;
            if (!isElementDisplayedOnPage(commodityMultipleModeField, "Commodity input in Multiple Mode"))
                errorsCount++;
            if (!isElementDisplayedOnPage(unitsOfMeasureMultipleModeField, "Units Of Measure input in Multiple Mode"))
                errorsCount++;
            if (!isElementDisplayedOnPage(notesMultipleModeField, "Notes input in Multiple Mode"))
                errorsCount++;
            if (!isElementDisplayedOnPage(usdRateCurrencyMultipleModeCheckBox, "USD checkbox in Multiple Mode"))
                errorsCount++;
            if (!isElementDisplayedOnPage(cadRateCurrencyMultipleModeCheckBox, "CAD checkbox in Multiple Mode"))
                errorsCount++;
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
