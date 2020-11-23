package logic.pages.fuelControl;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FuelCardRequestTab extends FuelControlPage {
    @FindBy(css = "input[ng-model='vm.filter.searchRequestQuery']")
    private WebElement searchRequestRecordsField;
    @FindBy(css = "input[ng-model='vm.filter.dateFromStr']")
    private WebElement dateFromField;
    @FindBy(css = "input[ng-model='vm.filter.dateToStr']")
    private WebElement dateToField;
    @FindBy(css = "input[ng-model='vm.filter.statusError']")
    private WebElement showOnlyErrorCheckbox;
    @FindBy(css = "div[ui-grid='vm.fcRequestListGridOption']")
    private WebElement tableBody;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(searchRequestRecordsField, "Search Request Records field")) errorsCount++;
        if (!isElementDisplayedOnPage(dateFromField, "Date From field")) errorsCount++;
        if (!isElementDisplayedOnPage(dateToField, "Date To field")) errorsCount++;
        if (!isElementDisplayedOnPage(showOnlyErrorCheckbox, "Show Only Error checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(tableBody, "Table")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
