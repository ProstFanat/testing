package logic.pages.eManifest;

import logic.report.PdfReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateEManifestModal extends EManifestsTab {
    @FindBy(id = "org-list-select")
    private WebElement tripNumberField;
    @FindBy(css = "input[ng-model='vm.manifest.scacCode']")
    private WebElement scacCodeField;
    @FindBy(css = "input[ng-model='vm.manifest.tripNumber']")
    private WebElement numberField;
    @FindBy(css = "oi-select[ng-model='vm.manifest.portOfArrival']")
    private WebElement usPortOfArrivalField;
    @FindBy(css = "oi-select[ng-model='vm.manifest.firstCanadianPortOfEntry']")
    private WebElement firstCanadianPortOfEntryField;
    @FindBy(css = "input[ng-model='vm.manifest.estimatedArrivalDate']")
    private WebElement estimatedArrivalDateField;
    @FindBy(css = "oi-select[ng-model='vm.manifest.truckNumber']")
    private WebElement truckNumberField;
    @FindBy(css = "oi-select[ng-model='vm.manifest.trailerNumber1']")
    private WebElement trailerNumberField;
    @FindBy(linkText = "Add Trailer")
    private WebElement addTrailerButton;
    @FindBy(css = "div[ng-model='vm.selectedDriver']")
    private WebElement quickAssignDriverField;
    @FindBy(linkText = "Add Team Driver")
    private WebElement addTeamDriverField;
    @FindBy(css = "div[ng-model='vm.selectedPassenger']")
    private WebElement selectedPassengerField;
    /*@FindBy(css = "input[ng-model='vm.manifest._fda']")
    private WebElement fdaCheckbox;
    @FindBy(css = "input[ng-model='vm.manifest._meatInspection']")
    private WebElement meatInspectionCheckbox;
    @FindBy(css = "input[ng-model='vm.manifest._fishWildlife']")
    private WebElement fishWildlifeCheckbox;
    @FindBy(css = "input[ng-model='vm.manifest._agriculture']")
    private WebElement agricultureCheckbox;
    @FindBy(css = "input[ng-model='vm.manifest._food']")
    private WebElement foodCheckbox;
    @FindBy(css = "input[ng-model='vm.manifest._hazmat']")
    private WebElement hazmatCheckbox;
    @FindBy(css = "input[ng-model='vm.manifest._bondUSD']")
    private WebElement usaCheckbox;
    @FindBy(css = "input[ng-model='vm.manifest._bondCAD']")
    private WebElement canCheckbox;*/
    @FindBy(css = "button[ng-click=\"vm.addNewItem('truck')\"]")
    private WebElement addTruckButton;
    @FindBy(css = "input[ng-model='vm.truck.number']")
    private WebElement numberFieldAddTruckModal;
    @FindBy(css = "input[ng-model='vm.truck.vinNumber']")
    private WebElement vinNumberFieldAddTruckModal;
    @FindBy(css = "select[ng-model='vm.truck.type']")
    private WebElement typeFieldAddTruckModal;
    @FindBy(css = "input[ng-model='vm.truck.dotNumber']")
    private WebElement dotNumberFieldAddTruckModal;
    @FindBy(css = "input[ng-model='vm.truck.insurancePolicy.insuranceCompanyName']")
    private WebElement insuranceCompanyNameFieldAddTruckModal;
    @FindBy(css = "input[ng-model='vm.truck.insurancePolicy.policyNumber']")
    private WebElement policyNumberFieldAddTruckModal;
    @FindBy(css = "input[ng-model='vm.truck.insurancePolicy.issuedDate']")
    private WebElement issuedDateFieldAddTruckModal;
    @FindBy(css = "input[ng-model='vm.truck.insurancePolicy.policyAmount']")
    private WebElement policyAmountFieldAddTruckModal;
    @FindBy(css = "input[ng-model='vm.truck.licensePlate.number']")
    private WebElement numberLicensePlateFieldAddTruckModal;
    @FindBy(css = "select[ng-model='vm.truck.licensePlate.stateProvince']")
    private WebElement stateProvinceFieldAddTruckModal;
    @FindBy(css = "button[ng-click=\"vm.addNewItem('trailer 1')\"]")
    private WebElement addNewTrailerButton;
    @FindBy(css = "input[ng-model='vm.trailer.number']")
    private WebElement numberFieldAddTrailer;
    @FindBy(css = "select[ng-model='vm.trailer.type']")
    private WebElement typeFieldAddTrailer;
    @FindBy(css = "input[ng-model='vm.trailer.licensePlate.number']")
    private WebElement numberLicensePlateFieldAddTrailer;
    @FindBy(css = "select[ng-model='vm.trailer.licensePlate.stateProvince']")
    private WebElement stateProvinceFieldAddTrailer;
    @FindBy(css = "button[ng-click='vm.sendEmanifest()']")
    private WebElement sendEmanifestButton;
    @FindBy(css = "button[ng-click='vm.updateEManifestWithShipments()']")
    private WebElement updateEManifestWithShipmentsButton;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(10, tripNumberField);
        if (!isElementDisplayedOnPage(tripNumberField, "Trip Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(scacCodeField, "SCAC field")) errorsCount++;
        if (!isElementDisplayedOnPage(numberField, "Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(usPortOfArrivalField, "US Port Of Arrival field")) errorsCount++;
        if (!isElementDisplayedOnPage(firstCanadianPortOfEntryField, "First Canadian Port Of Entry field"))
            errorsCount++;
        if (!isElementDisplayedOnPage(estimatedArrivalDateField, "Estimated Arrival Date field")) errorsCount++;
        if (!isElementDisplayedOnPage(truckNumberField, "Truck Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(trailerNumberField, "Trailer Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(quickAssignDriverField, "Quick Assign Driver field")) errorsCount++;
        if (!isElementDisplayedOnPage(selectedPassengerField, "Quick Assign Passengers field")) errorsCount++;
        if (!isElementDisplayedOnPage(addTrailerButton, "Add Trailer button")) errorsCount++;
        if (!isElementDisplayedOnPage(addTeamDriverField, "Add Team Driver button")) errorsCount++;
        List<WebElement> shipmentSpecificationsCheckboxes = driver.findElements(By.className("checkbox"));
        if (shipmentSpecificationsCheckboxes.size() != 8) {
            PdfReport.writeErrorToReport("Shipment Specifications checkboxes size: Expected  = 8, but Actual = "
                    + shipmentSpecificationsCheckboxes.size(), false);
            log.error("Shipment Specifications checkboxes size: Expected  = 8, but Actual = "
                    + shipmentSpecificationsCheckboxes.size());
            errorsCount++;
        } else {
            PdfReport.writeErrorToReport("Shipment Specifications checkboxes is displayed", true);
            log.error("Shipment Specifications checkboxes size: Expected  = 8, but Actual = "
                    + shipmentSpecificationsCheckboxes.size());
        }
        if (!isElementDisplayedOnPage(sendEmanifestButton, "Send e-Manifest button")) errorsCount++;
        if (!isElementDisplayedOnPage(updateEManifestWithShipmentsButton, "Update e-Manifest With Shipments button"))
            errorsCount++;
        if (!isElementDisplayedOnPage(addTruckButton, "Add Truck button")) errorsCount++;
        else {
            clickOnElement(addTruckButton);
            PdfReport.createNewSubAnchorNotBold("Add Truck modal");
            waitToVisibilityOf(10, numberFieldAddTruckModal);
            if (!isElementDisplayedOnPage(numberFieldAddTruckModal, "Number field in Add Truck modal")) errorsCount++;
            if (!isElementDisplayedOnPage(typeFieldAddTruckModal, "Type field in Add Truck modal")) errorsCount++;
            if (!isElementDisplayedOnPage(vinNumberFieldAddTruckModal, "VIN Number field in Add Truck modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(dotNumberFieldAddTruckModal, "Dot Number field in Add Truck modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(insuranceCompanyNameFieldAddTruckModal, "Insurance Company Name field in Add Truck modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(policyNumberFieldAddTruckModal, "Policy Number field in Add Truck modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(policyAmountFieldAddTruckModal, "Policy Amount field in Add Truck modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(issuedDateFieldAddTruckModal, "Issued Date field in Add Truck modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(numberLicensePlateFieldAddTruckModal, "Number License Plate field in Add Truck modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(stateProvinceFieldAddTruckModal, "State / Province field in Add Truck modal"))
                errorsCount++;
            clickOnElement(driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")));
        }
        waitToBeClickable(10, addTrailerButton);
        if (!isElementDisplayedOnPage(addTrailerButton, "Add New Trailer button")) errorsCount++;
        else {
            clickOnElement(addNewTrailerButton);
            PdfReport.createNewSubAnchorNotBold("Add Trailer modal");
            waitToVisibilityOf(10, numberFieldAddTrailer);
            if (!isElementDisplayedOnPage(numberFieldAddTrailer, "Number field in Add Trailer modal")) errorsCount++;
            if (!isElementDisplayedOnPage(typeFieldAddTrailer, "Type field in Add Trailer modal")) errorsCount++;
            if (!isElementDisplayedOnPage(numberLicensePlateFieldAddTrailer, "Number License Plate field in Add Trailer modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(stateProvinceFieldAddTrailer, "State / Province field in Add Trailer modal"))
                errorsCount++;
            clickOnElement(driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")));
        }
        waitToVisibilityOf(10, addTrailerButton);
        clickOnElement(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div[2]/button[2]")));
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
