package logic.pages.companyProfile.assets;

import logic.report.PdfReport;
import logic.widgets.TagsWidget;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MaintenanceTab extends AssetsPage {
    @FindBy(css = "input[placeholder='Truck Number']")
    private WebElement truckNumberField;
    @FindBy(css = "input[ng-model='vm.filter.trailerNumber']")
    private WebElement trailerNumberField;
    @FindBy(css = "input[ng-model='vm.filter.effectiveDate']")
    private WebElement effectiveDateField;
    @FindBy(xpath = "//button[contains(text(),'More filters')]")
    private WebElement moreFilterButton;
    @FindBy(css = "input[ng-model='vm.filter.odometer']")
    private WebElement odometerField;
    @FindBy(css = "input[ng-model='vm.filter.partType']")
    private WebElement partTypeField;
    @FindBy(css = "input[ng-model='vm.filter.lifeDistance']")
    private WebElement lifeDistanceField;
    @FindBy(css = "input[ng-model='vm.filter.lifeHours']")
    private WebElement lifeHoursField;
    @FindBy(css = "input[ng-model='vm.filter.notificationEmail']")
    private WebElement notificationEmailField;
    @FindBy(css = "button[ng-click='vm.applyPartActionForGroup();']")
    private WebElement addMaintenanceRecordForGroupOfAssetsButton;
    @FindBy(className = "maintenance-record-for-truck-trailer-grid")
    private WebElement maintenanceGrid;
    @FindBy(css = "oi-select[ng-model='vm.selectedMaintenancePart']")
    private WebElement partActionFieldAddMaintenanceRecordModal;
    @FindBy(css = "input[ng-model='vm.maintenanceRecord.quantity']")
    private WebElement quantityFieldAddMaintenanceRecordModal;
    @FindBy(css = "textarea[ng-model='vm.maintenanceRecord.comment']")
    private WebElement commentFieldAddMaintenanceRecordModal;
    @FindBy(css = "oi-select[ng-model='vm.selectedTags']")
    private WebElement filterByTagFieldAddMaintenanceRecordModal;
    @FindBy(css = "li[heading='Truck']")
    private WebElement truckTabAddMaintenanceRecordModal;
    @FindBy(css = "li[heading='Trailer']")
    private WebElement trailerTabAddMaintenanceRecordModal;
    @FindBy(css = "div[ui-grid='vm.truckListGridOption']")
    private WebElement truckListGridAddMaintenanceRecordModal;
    @FindBy(css = "div[ui-grid='vm.trailerListGridOption']")
    private WebElement trailerListGridAddMaintenanceRecordModal;
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    private WebElement addButtonAddMaintenanceRecordModal;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelButtonAddMaintenanceRecordModal;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(10, trailerNumberField);
        if (!isElementDisplayedOnPage(maintenanceGrid, "Maintenance table")) errorsCount++;
        if (!isElementDisplayedOnPage(trailerNumberField, "Trailer Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(effectiveDateField, "Effective Date field")) errorsCount++;
//        if (!isElementDisplayedOnPage(truckNumberField, "Truck Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(moreFilterButton, "More Filter button")) errorsCount++;
        else {
            clickOnElement(moreFilterButton);
            waitToVisibilityOf(10, odometerField);
            if (!isElementDisplayedOnPage(odometerField, "Odometer field")) errorsCount++;
            if (!isElementDisplayedOnPage(partTypeField, "Part Type field")) errorsCount++;
            if (!isElementDisplayedOnPage(lifeDistanceField, "Life Distance field")) errorsCount++;
            if (!isElementDisplayedOnPage(lifeHoursField, "Life Hours field")) errorsCount++;
            if (!isElementDisplayedOnPage(notificationEmailField, "Notification Email field")) errorsCount++;
        }
        if (!isElementDisplayedOnPage(addMaintenanceRecordForGroupOfAssetsButton, "Add Maintenance Record For Group Of Assets button"))
            errorsCount++;
        else {
            clickOnElement(addMaintenanceRecordForGroupOfAssetsButton);
            PdfReport.createNewSubAnchorNotBold("Add Maintenance Record for Group of Assets modal");
            waitToVisibilityOf(10, partActionFieldAddMaintenanceRecordModal);
            if (!isElementDisplayedOnPage(partActionFieldAddMaintenanceRecordModal, "Part Action field in Add Maintenance Record modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(quantityFieldAddMaintenanceRecordModal, "Quantity field in Add Maintenance Record modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(commentFieldAddMaintenanceRecordModal, "Comment field in Add Maintenance Record modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(filterByTagFieldAddMaintenanceRecordModal, "Filter By Tag field in Add Maintenance Record modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(truckTabAddMaintenanceRecordModal, "Truck tab in Add Maintenance Record modal"))
                errorsCount++;
            else {
                clickOnElement(truckTabAddMaintenanceRecordModal);
                if (!isElementDisplayedOnPage(truckListGridAddMaintenanceRecordModal, "Truck List table in  Add Maintenance Record modal"))
                    errorsCount++;
            }
            if (!isElementDisplayedOnPage(trailerTabAddMaintenanceRecordModal, "Trailer tab in Add Maintenance Record modal"))
                errorsCount++;
            else {
                clickOnElement(trailerTabAddMaintenanceRecordModal);
                if (!isElementDisplayedOnPage(trailerListGridAddMaintenanceRecordModal, "Trailer List table in  Add Maintenance Record modal"))
                    errorsCount++;
            }
            if (!isElementDisplayedOnPage(addButtonAddMaintenanceRecordModal, "Add button in Add Maintenance Record modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(cancelButtonAddMaintenanceRecordModal, "Cancel button in Add Maintenance Record modal"))
                errorsCount++;
            clickOnElement(cancelButtonAddMaintenanceRecordModal);
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
