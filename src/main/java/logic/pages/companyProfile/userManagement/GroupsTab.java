package logic.pages.companyProfile.userManagement;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GroupsTab extends UserManagementPage {
    @FindBy(css = "input[ng-model='vm.searchGroupQuery']")
    private WebElement searchGroupField;
    @FindBy(css = "div[ui-grid='vm.groupListOptions']")
    private WebElement groupListTable;
    @FindBy(partialLinkText = "Add New Group")
    private WebElement addNewGroupButton;
    @FindBy(css = "input[value='emptyForm']")
    private WebElement createEmptyFormCheckboxAddNewGroupModal;
    @FindBy(css = "input[value='existingGroup']")
    private WebElement existingGroupCheckboxAddNewGroupModal;
    @FindBy(css = "input[value='proposedTemplate']")
    private WebElement proposedTemplateCheckboxAddNewGroupModal;
    @FindBy(css = "oi-select[ng-model='vm.selectedGroup']")
    private WebElement selectGroupFieldAddNewGroupModal;
    @FindBy(css = "oi-select[ng-model='vm.selectedTemplate']")
    private WebElement selectTemplateFieldAddNewGroupModal;
    @FindBy(css = "input[ng-model='vm.group.userGroup']")
    private WebElement nameFieldAddNewGroupModal;
    @FindBy(css = "textarea[ng-model='vm.group.description']")
    private WebElement descriptionFieldAddNewGroupModal;
    @FindBy(linkText = "Resources")
    private WebElement resourcesTab;
    @FindBy(linkText = "Trucks")
    private WebElement trucksTab;
    @FindBy(linkText = "Trailers")
    private WebElement trailersTab;
    @FindBy(linkText = "Drivers")
    private WebElement driversTab;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelButton;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(searchGroupField, "Search Group field")) errorsCount++;
        if (!isElementDisplayedOnPage(groupListTable, "Group List table")) errorsCount++;
        if (!isElementDisplayedOnPage(addNewGroupButton, "Add New Group button")) errorsCount++;
        else {
            clickOnElement(addNewGroupButton);
            PdfReport.createNewSubAnchorBold("Add New Group modal");
            waitToVisibilityOf(10, nameFieldAddNewGroupModal);
            if (!isElementDisplayedOnPage(nameFieldAddNewGroupModal, "Name field in Add New Group modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(createEmptyFormCheckboxAddNewGroupModal, "Create Empty Form checkbox in Add New Group modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(existingGroupCheckboxAddNewGroupModal, "Existing Group checkbox in Add New Group modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(proposedTemplateCheckboxAddNewGroupModal, "Proposed Template checkbox in Add New Group modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(selectGroupFieldAddNewGroupModal, "Select Group field in Add New Group modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(selectTemplateFieldAddNewGroupModal, "Select Template field in Add New Group modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(descriptionFieldAddNewGroupModal, "Description field in Add New Group modal"))
                errorsCount++;

            if (!isElementDisplayedOnPage(resourcesTab, "Resources tab in Add New Group modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(trucksTab, "Trucks tab in Add New Group modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(trailersTab, "Trailers tab in Add New Group modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(driversTab, "Drivers tab in Add New Group modal"))
                errorsCount++;
            clickOnElement(cancelButton);
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
