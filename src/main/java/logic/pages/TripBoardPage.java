package logic.pages;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TripBoardPage extends BasePage {
    @FindBy(tagName = "h2")
    private WebElement pageHeader;
    @FindBy(xpath = "//button[contains(text(),'Advanced Search')]")
    private WebElement advancedSearchButton;
    @FindBy(id = "button-legend")
    private WebElement showLegendButton;
    @FindBy(css = "input[placeholder='Trip #']")
    private WebElement tripNumberInput;
    @FindBy(id = "tripStatus")
    private WebElement tripStatusInput;
    @FindBy(id = "tripType")
    private WebElement tripTypeInput;
    @FindBy(css = "ng-select[bindvalue='driverId']")
    private WebElement driverInput;
    @FindBy(css = "ng-select[bindvalue='truckId']")
    private WebElement truckInput;
    @FindBy(css = "ng-select[bindvalue='trailerId']")
    private WebElement trailerInput;
    @FindBy(css = "input[placeholder='Create Date From']")
    private WebElement createDateFromInput;
    @FindBy(css = "input[placeholder='Create Date To']")
    private WebElement createDateToInput;
    @FindBy(xpath = "//button[contains(text(),'Clear')]")
    private WebElement clearButton;
    @FindBy(xpath = "//button[contains(text(),'Apply')]")
    private WebElement applyButton;
    @FindBy(tagName = "ngx-datatable")
    private WebElement tripDatatable;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(pageHeader, "Page header")) errorsCount++;
        if (!checkTextOnElement(pageHeader, "Trip Board")) errorsCount++;
        if (!isElementDisplayedOnPage(showLegendButton, "Show Legend button")) errorsCount++;
        if (!isElementDisplayedOnPage(tripDatatable, "Trip Data table")) errorsCount++;
        if (!isElementDisplayedOnPage(advancedSearchButton, "Advanced Search button")) errorsCount++;
        else {
            String disabledAttribute = advancedSearchButton.getAttribute("disabled");
            if ("true".contains(disabledAttribute))
                PdfReport.writeErrorToReport("Advanced Search button is disabled, there is no way to open an additional menu.", false);
            else {
                clickOnElement(advancedSearchButton);
                waitToVisibilityOf(10, tripNumberInput);
                PdfReport.createNewSubAnchorNotBold("Advanced Search block");
                if (!isElementDisplayedOnPage(tripNumberInput, "Trip Number field")) errorsCount++;
                if (!isElementDisplayedOnPage(tripStatusInput, "Trip Status field")) errorsCount++;
                if (!isElementDisplayedOnPage(tripTypeInput, "Trip Type field")) errorsCount++;
                if (!isElementDisplayedOnPage(driverInput, "Driver field")) errorsCount++;
                if (!isElementDisplayedOnPage(truckInput, "Truck field")) errorsCount++;
                if (!isElementDisplayedOnPage(trailerInput, "Trailer field")) errorsCount++;
                if (!isElementDisplayedOnPage(createDateFromInput, "Create Date From field")) errorsCount++;
                if (!isElementDisplayedOnPage(createDateToInput, "Create Date To field")) errorsCount++;
                if (!isElementDisplayedOnPage(clearButton, "Clear button")) errorsCount++;
                if (!isElementDisplayedOnPage(applyButton, "Apply button")) errorsCount++;
            }
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
