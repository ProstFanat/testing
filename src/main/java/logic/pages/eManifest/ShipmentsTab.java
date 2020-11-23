package logic.pages.eManifest;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShipmentsTab extends EManifestPage {
    @FindBy(css = "input[ng-model='vm.filter.shipmentControlNumber']")
    private WebElement shipmentControlNumberField;
    @FindBy(css = "input[ng-model='vm.filter.pb']")
    private WebElement pbField;
    @FindBy(css = "input[placeholder='Status']")
    private WebElement statusField;
    @FindBy(css = "input[placeholder='Type']")
    private WebElement typeField;
    @FindBy(css = "input[ng-model='vm.filter.fullName']")
    private WebElement editedByField;
    @FindBy(id = "shipments-archive-check")
    private WebElement shipmentsArchiveCheckbox;
    @FindBy(css = "button[ng-click='vm.createShipmentModal()']")
    private WebElement createShipmentButton;
    @FindBy(id = "uiGrid")
    private WebElement shipmentsGrid;
    @FindBy(css = "div[ng-model='vm.selectedProbillId']")
    private WebElement selectedProbillIdField;
    @FindBy(css = "div[ng-model='vm.selectedCargoId']")
    private WebElement selectedCargoIdField;
    @FindBy(xpath = "//button[contains(text(),'Generate Shipment')]")
    private WebElement generateShipmentButton;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelCreateShipmentButton;


    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(10, shipmentControlNumberField);
        if (!isElementDisplayedOnPage(shipmentControlNumberField, "Shipment Control Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(pbField, "PB field")) errorsCount++;
        if (!isElementDisplayedOnPage(typeField, "Type field")) errorsCount++;
        if (!isElementDisplayedOnPage(editedByField, "Edited By field")) errorsCount++;
        if (!isElementDisplayedOnPage(statusField, "Status field")) errorsCount++;
        if (!isElementDisplayedOnPage(shipmentsArchiveCheckbox, "Shipments Archive checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(createShipmentButton, "Create Shipment button")) errorsCount++;
        else {
            clickOnElement(createShipmentButton);
            PdfReport.createNewSubAnchor("Create Shipment modal");
            waitToVisibilityOf(10, selectedProbillIdField);
            if (!isElementDisplayedOnPage(selectedProbillIdField, "Select Probill field")) errorsCount++;
            if (!isElementDisplayedOnPage(selectedCargoIdField, "Select Cargo field")) errorsCount++;
            if (!isElementDisplayedOnPage(generateShipmentButton, "Generate Shipment button")) errorsCount++;
            clickOnElement(cancelCreateShipmentButton);
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
