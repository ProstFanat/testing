package logic.pages.fuelControl;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FuelStationsTab extends FuelControlPage {
    @FindBy(css = "input[ng-model='vm.searchStationName']")
    private WebElement stationNameInput;
    @FindBy(css = "input[ng-model='vm.searchCity']")
    private WebElement cityInput;
    @FindBy(css = "input[ng-model='vm.searchRegion']")
    private WebElement regionInput;
    @FindBy(css = "input[placeholder='Country...']")
    private WebElement countryInput;
    @FindBy(css = "input[ng-model='vm.searchType']")
    private WebElement typeInput;
    @FindBy(partialLinkText = "Export")
    private WebElement exportButton;
    @FindBy(partialLinkText = "Import")
    private WebElement importButton;
    @FindBy(partialLinkText = "Add Station")
    private WebElement addStationButton;
    @FindBy(partialLinkText = "Edit Station")
    private WebElement editStationButton;
    @FindBy(partialLinkText = "Delete Station")
    private WebElement deleteStationButton;
    @FindBy(id = "fuel-station-table")
    private WebElement fuelStationTable;
    @FindBy(id = "fs-map-container")
    private WebElement mapContainer;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(stationNameInput, "Station Name field")) errorsCount++;
        if (!isElementDisplayedOnPage(cityInput, "City field")) errorsCount++;
        if (!isElementDisplayedOnPage(regionInput, "Region field")) errorsCount++;
        if (!isElementDisplayedOnPage(countryInput, "Country field")) errorsCount++;
        if (!isElementDisplayedOnPage(typeInput, "Type field")) errorsCount++;
        if (!isElementDisplayedOnPage(exportButton, "Export button")) errorsCount++;
        if (!isElementDisplayedOnPage(importButton, "Import button")) errorsCount++;
        if (!isElementDisplayedOnPage(addStationButton, "Add Station button")) errorsCount++;
        if (!isElementDisplayedOnPage(editStationButton, "Edit Station button")) errorsCount++;
        if (!isElementDisplayedOnPage(deleteStationButton, "Delete Station button")) errorsCount++;
        if (!isElementDisplayedOnPage(mapContainer, "Map Container")) errorsCount++;
        if (!isElementDisplayedOnPage(fuelStationTable, "Fuel Station table")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
