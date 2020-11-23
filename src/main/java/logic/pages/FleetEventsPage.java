package logic.pages;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FleetEventsPage extends BasePage {
    @FindBy(tagName = "h2")
    private WebElement pageHeader;
    @FindBy(xpath = "//button[contains(text(),'Advanced Search')]")
    private WebElement advancedSearchButton;
    @FindBy(id = "button-legend")
    private WebElement showLegendButton;
    @FindBy(id = "table-settings-button")
    private WebElement showColumnsButton;
    @FindBy(xpath = "//button[contains(text(),'Trailer Map')]")
    private WebElement trailMapButton;
    @FindBy(id = "activePov")
    private WebElement perspectiveField;
    @FindBy(css = "ng-select[placeholder='Search Trip Number']")
    private WebElement searchTripNumberField;
    @FindBy(xpath = "//button[contains(text(),'Create New Trip')]")
    private WebElement createNewTripButton;
    @FindBy(tagName = "ngx-datatable")
    private WebElement fleetEventsDatatable;
    @FindBy(id = "tripStatus")
    private WebElement tripStatusFieldCreateNewTripModal;
    @FindBy(id = "tripType")
    private WebElement tripTypeFieldCreateNewTripModal;
    @FindBy(id = "dispatcher")
    private WebElement dispatcherFieldCreateNewTripModal;
    @FindBy(id = "driver1")
    private WebElement driverOneFieldCreateNewTripModal;
    @FindBy(id = "driver2")
    private WebElement driverTwoFieldCreateNewTripModal;
    @FindBy(id = "startDate")
    private WebElement startDateFieldCreateNewTripModal;
    @FindBy(id = "finishDate")
    private WebElement finishDateFieldCreateNewTripModal;
    @FindBy(id = "truck")
    private WebElement truckFieldCreateNewTripModal;
    @FindBy(id = "trailer")
    private WebElement trailerFieldCreateNewTripModal;
    @FindBy(id = "comment")
    private WebElement commentFieldCreateNewTripModal;
    @FindBy(css = "ng-select[placeholder='Place']")
    private WebElement placeFieldCreateNewTripModal;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement closeCreateNewTripModal;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(pageHeader, "Page header")) errorsCount++;
        if (!checkTextOnElement(pageHeader, "Fleet Events")) errorsCount++;
        if (!isElementDisplayedOnPage(showLegendButton, "Show Legend button")) errorsCount++;
        if (!isElementDisplayedOnPage(fleetEventsDatatable, "Fleet Evebts Data table")) errorsCount++;
        if (!isElementDisplayedOnPage(advancedSearchButton, "Advanced Search button")) errorsCount++;
        if (!isElementDisplayedOnPage(showColumnsButton, "Show Columns button")) errorsCount++;
        if (!isElementDisplayedOnPage(trailMapButton, "Trailer Map button")) errorsCount++;
        if (!isElementDisplayedOnPage(perspectiveField, "Perspective field")) errorsCount++;
        if (!isElementDisplayedOnPage(searchTripNumberField, "Search Trip Number fiield")) errorsCount++;
        if (!isElementDisplayedOnPage(createNewTripButton, "Advanced Search button")) errorsCount++;
        else {
            clickOnElement(createNewTripButton);
            waitToVisibilityOf(10, tripStatusFieldCreateNewTripModal);
            PdfReport.createNewSubAnchorNotBold("Create New Trip modal");
            if (!isElementDisplayedOnPage(tripStatusFieldCreateNewTripModal, "Trip Status field in Create New Trip modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(tripTypeFieldCreateNewTripModal, "Trip Type field in Create New Trip modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(startDateFieldCreateNewTripModal, "Start Date field in Create New Trip modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(finishDateFieldCreateNewTripModal, "Finish Date field in Create New Trip modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(dispatcherFieldCreateNewTripModal, "Dispatcher field in Create New Trip modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(driverOneFieldCreateNewTripModal, "Driver 1 field in Create New Trip modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(driverTwoFieldCreateNewTripModal, "Driver 2 field in Create New Trip modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(truckFieldCreateNewTripModal, "Truck field in Create New Trip modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(trailerFieldCreateNewTripModal, "Trailer field in Create New Trip modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(commentFieldCreateNewTripModal, "Comment field in Create New Trip modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(placeFieldCreateNewTripModal, "Place field in Create New Trip modal"))
                errorsCount++;
            clickOnElement(closeCreateNewTripModal);
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
