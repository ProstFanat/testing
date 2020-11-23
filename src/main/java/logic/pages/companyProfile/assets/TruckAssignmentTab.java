package logic.pages.companyProfile.assets;

import logic.report.PdfReport;
import logic.widgets.TagsWidget;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TruckAssignmentTab extends AssetsPage {
    @FindBy(css = "input[ng-model='vm.filter.unit']")
    private WebElement unitField;
    @FindBy(css = "input[ng-model='vm.filter.currentlyLoggedIn']")
    private WebElement currentlyLoggedInField;
    @FindBy(css = "input[ng-model='vm.filter.assignedTo']")
    private WebElement assignedToField;
    @FindBy(css = "oi-select[ng-model='vm.filter.selectedTags']")
    private WebElement selectedTagsField;
    @FindBy(css = "select[ng-model='vm.filter.status']")
    private WebElement statusField;
    @FindBy(css = "div[ui-grid='vm.truckListGridOption']")
    private WebElement truckListTable;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(unitField, "Unit field")) errorsCount++;
        if (!isElementDisplayedOnPage(currentlyLoggedInField, "Currently Logged In field")) errorsCount++;
        if (!isElementDisplayedOnPage(assignedToField, "Assigned To field")) errorsCount++;
        if (!isElementDisplayedOnPage(selectedTagsField, "Tags field")) errorsCount++;
        if (!isElementDisplayedOnPage(statusField, "Status field")) errorsCount++;
//        if (!isElementDisplayedOnPage(truckListTable, "Truck List table")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
