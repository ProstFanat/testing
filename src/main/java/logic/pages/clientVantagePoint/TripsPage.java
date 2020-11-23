package logic.pages.clientVantagePoint;

import logic.report.PdfReport;
import logic.widgets.NavigationBar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TripsPage extends ClientVintagePointPage {
    @FindBy(tagName = "h2")
    private WebElement pageHeader;
    @FindBy(name = "tripNumber")
    private WebElement tripNumberField;
    @FindBy(css = "select[ng-model='vm.tripFilter.tripStatus']")
    private WebElement tripStatusSelect;
    @FindBy(css = "select[ng-model='vm.selectedCustomer']")
    private WebElement selectedCustomerSelect;
    @FindBy(name = "startDate")
    private WebElement startDateField;
    @FindBy(name = "createDate")
    private WebElement createDateField;
    @FindBy(css = "button[ng-click='vm.createManualTrip()']")
    private WebElement createManualTripBtn;
    @FindBy(name = "createManualTripForm")
    private WebElement createManualTripForm;
    @FindBy(css = "button[ng-click='vm.cancel()']")
    private WebElement cancelBtn;
    @FindBy (css = "input[ng-model='vm.trip.poNumber']")
    private WebElement probillFieldCreateManualTripForm;
    @FindBy (css = "input[ng-model='vm.trip.tripNumber']")
    private WebElement orderFieldCreateManualTripForm;
    @FindBy (css = "oi-select[ng-model='vm.customer']")
    private WebElement customerSelectCreateManualTripForm;
    @FindBy (css = "input[ng-model='vm.originAddress']")
    private WebElement originFieldCreateManualTripForm;
    @FindBy (css = "input[ng-model='vm.destinationAddress']")
    private WebElement destinationFieldCreateManualTripForm;
    @FindBy (css = "input[ng-model='vm.estStartTime']")
    private WebElement pickupDateFieldCreateManualTripForm;
    @FindBy (css = "input[ng-model='vm.estEndTime']")
    private WebElement deliveryDateFieldCreateManualTripForm;
    @FindBy (css = "oi-select[ng-model='vm.trip.truckId']")
    private WebElement truckIdFieldCreateManualTripForm;
    @FindBy (css = "oi-select[ng-model='vm.trip.trailerId']")
    private WebElement trailerIdFieldCreateManualTripForm;
    @FindBy (css = "input[ng-model='vm.trip.customerPONumber']")
    private WebElement customerPoNumberFieldCreateManualTripForm;
    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(60, pageHeader);
        if (!isElementDisplayedOnPage(pageHeader, "Page Header")) errorsCount++;
        if (!checkTextOnElement(pageHeader, "TRIPS")) errorsCount++;
        if (!isElementDisplayedOnPage(tripNumberField, "Trip Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(tripStatusSelect, "Trip Status field")) errorsCount++;
        if (!isElementDisplayedOnPage(selectedCustomerSelect, "Selected Customer select")) errorsCount++;
        if (!isElementDisplayedOnPage(startDateField, "Start Date field")) errorsCount++;
        if (!isElementDisplayedOnPage(createDateField, "Create Date field")) errorsCount++;
        if (!isElementDisplayedOnPage(createManualTripBtn, "Create Manual Trip button")) errorsCount++;
        else {
            PdfReport.createNewSubAnchorNotBold("Create Manual Trip modal");
            clickOnElement(createManualTripBtn);
            if (!isElementDisplayedOnPage(createManualTripForm, "Create Manual Trip form")) errorsCount++;
            if (!isElementDisplayedOnPage(probillFieldCreateManualTripForm, "Probill field in Create Manual Trip form")) errorsCount++;
            if (!isElementDisplayedOnPage(orderFieldCreateManualTripForm, "Order field in Create Manual Trip form")) errorsCount++;
            if (!isElementDisplayedOnPage(customerSelectCreateManualTripForm, "Customer field in Create Manual Trip form")) errorsCount++;
            if (!isElementDisplayedOnPage(originFieldCreateManualTripForm, "Origin field in Create Manual Trip form")) errorsCount++;
            if (!isElementDisplayedOnPage(destinationFieldCreateManualTripForm, "Destination field in Create Manual Trip form")) errorsCount++;
            if (!isElementDisplayedOnPage(pickupDateFieldCreateManualTripForm, "PickUp Date field in Create Manual Trip form")) errorsCount++;
            if (!isElementDisplayedOnPage(deliveryDateFieldCreateManualTripForm, "Delivery Date field in Create Manual Trip form")) errorsCount++;
            if (!isElementDisplayedOnPage(truckIdFieldCreateManualTripForm, "Truck field in Create Manual Trip form")) errorsCount++;
            if (!isElementDisplayedOnPage(trailerIdFieldCreateManualTripForm, "Trailer field in Create Manual Trip form")) errorsCount++;
            if (!isElementDisplayedOnPage(customerPoNumberFieldCreateManualTripForm, "Customer PO Number field in Create Manual Trip form")) errorsCount++;
            clickOnElement(cancelBtn);
        }
        PdfReport.writeJsLogFromWebDriver();
        new NavigationBar().navigateToClientVintagePointPage();

        return errorsCount == 0;
    }
}
