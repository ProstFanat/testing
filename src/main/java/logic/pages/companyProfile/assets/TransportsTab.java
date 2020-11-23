package logic.pages.companyProfile.assets;

import logic.report.PdfReport;
import logic.widgets.TagsWidget;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransportsTab extends AssetsPage {
    @FindBy(css = "input[ng-model='vm.filter.truckOrTrailerNumber']")
    private WebElement truckOrTrailerNumberField;
    @FindBy(className = "tag-select")
    private WebElement tagsField;
    @FindBy(css = "button[ng-click='vm.addNewTransport()']")
    private WebElement addNewTransportButton;
    @FindBy(id = "transport-list-table")
    private WebElement transportListTable;
    @FindBy(css = "input[placeholder='Select Truck']")
    private WebElement selectTruckFieldAddNewTransportModal;
    @FindBy(css = "input[placeholder='Select Trailer']")
    private WebElement selectTrailerFieldAddNewTransportModal;
    @FindBy(css = "button[ng-click='vm.cancel()']")
    private WebElement cancelButtonAddNewTransportModal;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(10, truckOrTrailerNumberField);
        if (!isElementDisplayedOnPage(truckOrTrailerNumberField, "Trailer or Trailer Number field")) errorsCount++;
//        if (!isElementDisplayedOnPage(tagsField, "Tags field")) errorsCount++;
        if (!isElementDisplayedOnPage(transportListTable, "Transport List table")) errorsCount++;
        if (!isElementDisplayedOnPage(addNewTransportButton, "Add New Transport button")) errorsCount++;
        else {
            clickOnElement(addNewTransportButton);
            PdfReport.createNewSubAnchorNotBold("Add New Transport modal");
            waitToVisibilityOf(10, selectTrailerFieldAddNewTransportModal);
            if (!isElementDisplayedOnPage(selectTrailerFieldAddNewTransportModal, "Select Trailer field in Add New Transport modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(selectTruckFieldAddNewTransportModal, "Select Truck field in Add New Transport modal"))
                errorsCount++;
            clickOnElement(cancelButtonAddNewTransportModal);
        }
        if (!new TagsWidget().isAllRequiredElementsPresent()) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
