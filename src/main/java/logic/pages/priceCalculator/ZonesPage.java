package logic.pages.priceCalculator;

import logic.report.PdfReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ZonesPage extends PriceCalculatorPage {
    @FindBy(css = "input[ng-model='vm.searchZoneQuery']")
    private WebElement findZoneInput;
    @FindBy(css = "div[ui-grid='vm.pcZoneListGridOption']")
    private WebElement zonesListTable;
    @FindBy(css = "a[ng-click='vm.addZone()']")
    private WebElement addZoneBtn;
    @FindBy(id = "pc-zone-map-container")
    private WebElement zoneMapContainer;
    @FindBy(id = "draw-zone-modal-address-autocomplete")
    private WebElement searchAddressField;
    @FindBy(name = "zipCodes")
    private WebElement searchZipCodeField;
    @FindBy(id = "show-hide-zones")
    private WebElement showZonesCheckBox;
    @FindBy(css = "input[ng-model='vm.zone.name']")
    private WebElement zoneNameField;
    @FindBy(css = "input[ng-model='vm.searchCity']")
    private WebElement searchIncludedCityField;
    @FindBy(css = "input[ng-model='vm.searchExcludedCity']")
    private WebElement searchExcludedCityField;
    @FindBy(css = "input[placeholder='Select Contractor']")
    private WebElement selectContractorField;
    @FindBy(css = "button[ng-click='vm.addCarrierContractorModal()']")
    private WebElement addCarrierContractorBtn;
    @FindBy(css = "input[ng-model='vm.contractor.name']")
    private WebElement nameFieldContractorModal;
    @FindBy(css = "input[ng-model='vm.contractor.address.addressLine1']")
    private WebElement addressLineFieldContractorModal;
    @FindBy(name = "region")
    private WebElement regionFieldContractorModal;
    @FindBy(name = "city")
    private WebElement cityFieldContractorModal;
    @FindBy(name = "postalCode")
    private WebElement postalCodeFieldContractorModal;
    @FindBy(name = "country")
    private WebElement countryFieldContractorModal;
    @FindBy(css = "input[ng-model='vm.contractor.contacts']")
    private WebElement contactsFieldContractorModal;
    @FindBy(css = "input[ng-model='vm.contractor.activeInd']")
    private WebElement activeCheckBoxContractorModal;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelBtn;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(findZoneInput, "Find Zone Input")) errorsCount++;
        if (!isElementDisplayedOnPage(zonesListTable, "Zones List Table")) errorsCount++;
        if (!isElementDisplayedOnPage(zoneMapContainer, "Zone Map Container")) errorsCount++;
        if (!isElementDisplayedOnPage(addZoneBtn, "Add Zone Btn")) errorsCount++;
        else {
            clickOnElement(addZoneBtn);
            waitToVisibilityOf(10, searchZipCodeField);
            PdfReport.createNewSubAnchorBold("Add New Zone modal");
            if (!isElementDisplayedOnPage(searchAddressField, "Search Address Field")) errorsCount++;
            if (!isElementDisplayedOnPage(searchZipCodeField, "Search Zip Code Field")) errorsCount++;
            if (!isElementDisplayedOnPage(showZonesCheckBox, "Show Zones CheckBox")) errorsCount++;
            if (!isElementDisplayedOnPage(searchIncludedCityField, "Search Included City Field")) errorsCount++;
            if (!isElementDisplayedOnPage(searchExcludedCityField, "Search Excluded City Field")) errorsCount++;
            if (!isElementDisplayedOnPage(selectContractorField, "Select Contractor Field")) errorsCount++;
            if (!isElementDisplayedOnPage(addCarrierContractorBtn, "AddCarrier Contractor Btn")) errorsCount++;
            else {
                clickOnElement(addCarrierContractorBtn);
                waitToVisibilityOf(10,nameFieldContractorModal);
                PdfReport.createNewSubAnchorBold("Add New Contractor modal");
                if (!isElementDisplayedOnPage(nameFieldContractorModal, "Name Btn Contractor Modal")) errorsCount++;
                if (!isElementDisplayedOnPage(addressLineFieldContractorModal, "Address Line Field Contractor Modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(regionFieldContractorModal, "Region Field Contractor Modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(cityFieldContractorModal, "City Field Contractor Modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(postalCodeFieldContractorModal, "Postal Code Field Contractor Modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(countryFieldContractorModal, "Country Field Contractor Modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(contactsFieldContractorModal, "Contacts Field Contractor Modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(activeCheckBoxContractorModal, "Active CheckBox Contractor Modal"))
                    errorsCount++;
                clickOnElement(driver.findElement(By.cssSelector("button[ng-click='vm.cancel()']")));
            }
            waitToBeClickable(10,addCarrierContractorBtn);
            clickOnElement(driver.findElement(By.cssSelector("button[ng-click='vm.clickedCancel()']")));
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
