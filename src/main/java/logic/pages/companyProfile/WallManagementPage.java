package logic.pages.companyProfile;

import logic.BasePage;
import logic.pages.companyProfile.gpsDevices.NewUsageProfileModal;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WallManagementPage extends BasePage {
    @FindBy(css = "input[ng-model='vm.searchWallQuery']")
    private WebElement searchWallField;
    @FindBy(id = "wall-list-table")
    private WebElement wallListTable;
    @FindBy (partialLinkText = "Add New Wall")
    private WebElement addNewWallButton;
    @FindBy(css = "input[ng-model='vm.wall.wallName']")
    private WebElement wallNameFieldAddNewWallModal;
    @FindBy(css = "div[ng-model='vm.wall.userId']")
    private WebElement userFieldAddNewWallModal;
    @FindBy(css = "input[ng-model='vm.showTags']")
    private WebElement addTagsCheckboxAddNewWallModal;
    @FindBy(css = "select[ng-model='vm.selectedTagType']")
    private WebElement tagTypeFieldAddNewWallModal;
    @FindBy(css = "oi-select[ng-model='vm.wall.tagIds']")
    private WebElement wallTagsFieldAddNewWallModal;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelButton;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(searchWallField, "Search Wall field")) errorsCount++;
        if (!isElementDisplayedOnPage(wallListTable, "Wall List table")) errorsCount++;
        if (!isElementDisplayedOnPage(addNewWallButton, "Add New Wall button")) errorsCount++;
        else {
            clickOnElement(addNewWallButton);
            PdfReport.createNewSubAnchorNotBold("Add New Wall modal");
            if (!isElementDisplayedOnPage(wallNameFieldAddNewWallModal, "Wall Name field in Add New Wall modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(userFieldAddNewWallModal, "User field in Add New Wall modal")) errorsCount++;
            if (!isElementDisplayedOnPage(addTagsCheckboxAddNewWallModal, "Add Tags checkbox in Add New Wall modal"))
                errorsCount++;
            else {
                clickCheckbox(addTagsCheckboxAddNewWallModal, true, "Add Tags");
                waitToVisibilityOf(10, tagTypeFieldAddNewWallModal);
                if (!isElementDisplayedOnPage(tagTypeFieldAddNewWallModal, "Tag Type field in Add New Wall modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(wallTagsFieldAddNewWallModal, "Wall Tags field in Add New Wall modal"))
                    errorsCount++;
            }
            clickOnElement(cancelButton);
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
