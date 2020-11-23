package logic.pages.companyProfile.drivers;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FuelPurchasesTab extends DriversPage {
    @FindBy(css = "div[ng-model='vm.selectedDriver']")
    private WebElement selectDriverField;
    @FindBy(css = "input[ng-model='vm.filter.dateFrom']")
    private WebElement dateFromField;
    @FindBy(css = "input[ng-model='vm.filter.dateTo']")
    private WebElement dateToField;
    @FindBy(css = "button[ng-click='vm.getFuelPurchasesForAllDrivers(vm.filter)']")
    private WebElement applyButton;
    @FindBy(css = "div[ui-grid='vm.uiGridOption']")
    private WebElement fuelPurchasesTable;
    @FindBy(css = "button[ng-click='vm.addFuelPurchasesModal()']")
    private WebElement addFuelPurchasesButton;
    @FindBy(css = "oi-select[ng-model='vm.fuelPurchase.driverId']")
    private WebElement driverFieldAddFuelPurchasesModal;
    @FindBy(name = "truckId")
    private WebElement truckFieldAddFuelPurchasesModal;
    @FindBy(css = "input[ng-model='vm.fuelPurchase.purchaseDateObj']")
    private WebElement purchaseDateFieldAddFuelPurchasesModal;
    @FindBy(name = "countryCode")
    private WebElement countryFieldAddFuelPurchasesModal;
    @FindBy(name = "provStateCode")
    private WebElement provStateCodeFieldAddFuelPurchasesModal;
    @FindBy(name = "vendorName")
    private WebElement vendorNameFieldAddFuelPurchasesModal;
    @FindBy(name = "fuelType")
    private WebElement fuelTypeFieldAddFuelPurchasesModal;
    @FindBy(name = "volume")
    private WebElement volumeFieldAddFuelPurchasesModal;
    @FindBy(name = "volumeUnit")
    private WebElement volumeUnitFieldAddFuelPurchasesModal;
    @FindBy(name = "price")
    private WebElement priceFieldAddFuelPurchasesModal;
    @FindBy(name = "currency")
    private WebElement currencyFieldAddFuelPurchasesModal;
    @FindBy(name = "pricePerUnit")
    private WebElement pricePerUnitFieldAddFuelPurchasesModal;
    @FindBy(css = "button[ng-click='vm.startUploadPhoto()']")
    private WebElement uploadPhotoButtonFieldAddFuelPurchasesModal;
    @FindBy(xpath = "//button[contains(text(), 'Cancel')]")
    private WebElement cancelButtonAddFuelPurchasesModal;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(10, selectDriverField);
        if (!isElementDisplayedOnPage(selectDriverField, "Select Driver field")) errorsCount++;
        if (!isElementDisplayedOnPage(dateFromField, "Date From field")) errorsCount++;
        if (!isElementDisplayedOnPage(dateToField, "Date To field")) errorsCount++;
        if (!isElementDisplayedOnPage(applyButton, "Apply button")) errorsCount++;
        if (!isElementDisplayedOnPage(fuelPurchasesTable, "Fuel Purchases table")) errorsCount++;
        if (!isElementDisplayedOnPage(addFuelPurchasesButton, "Add Fuel Purchases button")) errorsCount++;
        else {
            clickOnElement(addFuelPurchasesButton);
            PdfReport.createNewSubAnchorNotBold("Add Fuel Purchases modal");
            waitToVisibilityOf(10, driverFieldAddFuelPurchasesModal);
            if (!isElementDisplayedOnPage(driverFieldAddFuelPurchasesModal, "Driver field in Add Fuel Purchases modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(truckFieldAddFuelPurchasesModal, "Truck field in Add Fuel Purchases modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(purchaseDateFieldAddFuelPurchasesModal, "Purchase Date field in Add Fuel Purchases modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(countryFieldAddFuelPurchasesModal, "Country field in Add Fuel Purchases modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(provStateCodeFieldAddFuelPurchasesModal, "State field in Add Fuel Purchases modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(vendorNameFieldAddFuelPurchasesModal, "Vendor field in Add Fuel Purchases modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(fuelTypeFieldAddFuelPurchasesModal, "Fuel Type field in Add Fuel Purchases modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(volumeFieldAddFuelPurchasesModal, "Volume field in Add Fuel Purchases modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(volumeUnitFieldAddFuelPurchasesModal, "Volume Unit field in Add Fuel Purchases modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(priceFieldAddFuelPurchasesModal, "Price field in Add Fuel Purchases modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(currencyFieldAddFuelPurchasesModal, "Currency field in Add Fuel Purchases modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(pricePerUnitFieldAddFuelPurchasesModal, "Price Per Unit field in Add Fuel Purchases modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(volumeUnitFieldAddFuelPurchasesModal, "Volume Unit field in Add Fuel Purchases modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(uploadPhotoButtonFieldAddFuelPurchasesModal, "Upload Photo button in Add Fuel Purchases modal"))
                errorsCount++;
            clickOnElement(cancelButtonAddFuelPurchasesModal);
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }

}
