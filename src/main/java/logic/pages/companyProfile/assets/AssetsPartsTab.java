package logic.pages.companyProfile.assets;

import logic.report.PdfReport;
import logic.widgets.TagsWidget;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssetsPartsTab extends AssetsPage {
    @FindBy(css = "button[ng-click='vm.openAddPartWorkType();']")
    private WebElement addAssetRelatedPartOrAction;
    @FindBy(id = "maintenance-part-list-table")
    private WebElement maintenancePartListTable;
    @FindBy(name = "partType")
    private WebElement partActionFieldAddAssetRelatedPartOrActionModal;
    @FindBy(name = "lifeDistance")
    private WebElement lifeDistanceFieldAddAssetRelatedPartOrActionModal;
    @FindBy(name = "lifeDistanceIn")
    private WebElement unitsFieldAddAssetRelatedPartOrActionModal;
    @FindBy(name = "lifeHours")
    private WebElement lifeHoursFieldAddAssetRelatedPartOrActionModal;
    @FindBy(name = "notificationMargin")
    private WebElement notificationMarginFieldAddAssetRelatedPartOrActionModal;
    @FindBy(name = "notificationEmails")
    private WebElement notificationEmailsFieldAddAssetRelatedPartOrActionModal;
    @FindBy(css = "input[ng-model='vm.part.partNumber']")
    private WebElement partNumberFieldAddAssetRelatedPartOrActionModal;
    @FindBy(css = "input[ng-model='vm.part.vendorCode']")
    private WebElement vendorCodeFieldAddAssetRelatedPartOrActionModal;
    @FindBy(css = "oi-select[ng-model='vm.part.storageBin']")
    private WebElement strorageBinFieldAddAssetRelatedPartOrActionModal;
    @FindBy(css = "input[ng-model='vm.part.inStock']")
    private WebElement inStockFieldAddAssetRelatedPartOrActionModal;
    @FindBy(css = "input[ng-model='vm.part.onOrder']")
    private WebElement onOrderFieldAddAssetRelatedPartOrActionModal;
    @FindBy(css = "select[ng-model='vm.part.uom']")
    private WebElement uomFieldAddAssetRelatedPartOrActionModal;
    @FindBy(css = "input[ng-model='vm.part.lastCost']")
    private WebElement lastCostFieldAddAssetRelatedPartOrActionModal;
    @FindBy(css = "input[ng-model='vm.part.retailPrice']")
    private WebElement retailPriceFieldAddAssetRelatedPartOrActionModal;
    @FindBy(css = "textarea[ng-model='vm.part.description']")
    private WebElement descriptionFieldAddAssetRelatedPartOrActionModal;
    @FindBy(css = "input[ng-model='vm.part.repeatableAction']")
    private WebElement repeatableActionFieldAddAssetRelatedPartOrActionModal;
    @FindBy(name = "landmark")
    private WebElement landmarkFieldAddAssetRelatedPartOrActionModal;
    @FindBy(id = "add-truck-part-map-container")
    private WebElement addTruckPartMapContainerAddAssetRelatedPartOrActionModal;
    @FindBy(css = "button[ng-click='vm.addAddressBook()']")
    private WebElement addAddressBookButtonAddAssetRelatedPartOrActionModal;
    @FindBy(css = "input[ng-model='vm.addressBookRecord.name']")
    private WebElement nameFieldAddAddressBookModal;
    @FindBy(css = "input[ng-model='vm.addressBookRecord.email']")
    private WebElement emailFieldAddAddressBookModal;
    @FindBy(className = "close")
    private WebElement closeAddAddressBookModal;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelButtonAddAssetRelatedPartOrActionModal;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(maintenancePartListTable, "Maintenance Part List table")) errorsCount++;
        if (!isElementDisplayedOnPage(addAssetRelatedPartOrAction, "Add Asset Related Part Or Action button"))
            errorsCount++;
        else {
            clickOnElement(addAssetRelatedPartOrAction);
            PdfReport.createNewSubAnchorNotBold("Add Asset Related Part or Action modal");
            waitToVisibilityOf(10, partActionFieldAddAssetRelatedPartOrActionModal);
            if (!isElementDisplayedOnPage(partActionFieldAddAssetRelatedPartOrActionModal, "Part Action field in Add Asset Related Part Or Action modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(lifeDistanceFieldAddAssetRelatedPartOrActionModal, "Life Distance field in Add Asset Related Part Or Action modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(lifeHoursFieldAddAssetRelatedPartOrActionModal, "Life Hours field in Add Asset Related Part Or Action modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(unitsFieldAddAssetRelatedPartOrActionModal, "Units field in Add Asset Related Part Or Action modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(notificationMarginFieldAddAssetRelatedPartOrActionModal, "Notification Margin field in Add Asset Related Part Or Action modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(notificationEmailsFieldAddAssetRelatedPartOrActionModal, "Notification Emails field in Add Asset Related Part Or Action modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(partNumberFieldAddAssetRelatedPartOrActionModal, "Part Number field in Add Asset Related Part Or Action modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(vendorCodeFieldAddAssetRelatedPartOrActionModal, "Vendor Code field in Add Asset Related Part Or Action modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(strorageBinFieldAddAssetRelatedPartOrActionModal, "Storage Bin field in Add Asset Related Part Or Action modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(inStockFieldAddAssetRelatedPartOrActionModal, "In Stock field in Add Asset Related Part Or Action modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(onOrderFieldAddAssetRelatedPartOrActionModal, "On Order field in Add Asset Related Part Or Action modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(uomFieldAddAssetRelatedPartOrActionModal, "UOM field in Add Asset Related Part Or Action modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(lastCostFieldAddAssetRelatedPartOrActionModal, "Lost Cost field in Add Asset Related Part Or Action modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(retailPriceFieldAddAssetRelatedPartOrActionModal, "Retail Price field in Add Asset Related Part Or Action modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(descriptionFieldAddAssetRelatedPartOrActionModal, "Description field in Add Asset Related Part Or Action modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(repeatableActionFieldAddAssetRelatedPartOrActionModal, "Repeatable Action checkbox in Add Asset Related Part Or Action modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(landmarkFieldAddAssetRelatedPartOrActionModal, "Landmark field in Add Asset Related Part Or Action modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(addTruckPartMapContainerAddAssetRelatedPartOrActionModal, "Truck Map container in Add Asset Related Part Or Action modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(addAddressBookButtonAddAssetRelatedPartOrActionModal, "Add Address button in Add Asset Related Part Or Action modal"))
                errorsCount++;
            else {
                clickOnElement(addAddressBookButtonAddAssetRelatedPartOrActionModal);
                PdfReport.createNewSubAnchorNotBold("Add To Address Book modal");
                waitToVisibilityOf(10, nameFieldAddAddressBookModal);
                if (!isElementDisplayedOnPage(nameFieldAddAddressBookModal, "Name field in Add To Address Book modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(emailFieldAddAddressBookModal, "Email field in Add To Address Book modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(closeAddAddressBookModal, "Close button in Add To Address Book modal"))
                    errorsCount++;
                clickOnElement(closeAddAddressBookModal);
            }
            waitToBeClickable(10,addAddressBookButtonAddAssetRelatedPartOrActionModal);
            waitToVisibilityOf(10,addAddressBookButtonAddAssetRelatedPartOrActionModal);
            clickOnElement(driver.findElement(By.className("btn-warning")));
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
