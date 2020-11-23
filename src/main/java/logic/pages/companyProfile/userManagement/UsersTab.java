package logic.pages.companyProfile.userManagement;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersTab extends UserManagementPage {
    @FindBy(css = "input[ng-model='vm.searchUserQuery']")
    private WebElement searchUserField;
    @FindBy(css = "div[ng-model='vm.selectGroup']")
    private WebElement groupField;
    @FindBy(name = "userStatus")
    private WebElement userStatusField;
    @FindBy(css = "input[ng-model='vm.onlyVantagePointClientGroup']")
    private WebElement onlyVantagePointClientGroupCheckbox;
    @FindBy(css = "input[ng-model='vm.onlySoftwareUsers']")
    private WebElement onlySoftwareUsersCheckbox;
    @FindBy(css = "div[ui-grid='vm.userListOptions']")
    private WebElement userListTable;
    @FindBy(partialLinkText = "Add New User")
    private WebElement addNewUserButton;
    @FindBy(css = "input[ng-model='vm.user.firstName']")
    private WebElement firstNameFieldAddNewUserModal;
    @FindBy(css = "input[ng-model='vm.user.lastName']")
    private WebElement lastNameFieldAddNewUserModal;
    @FindBy(css = "input[ng-model='vm.user.loginName']")
    private WebElement loginNameFieldAddNewUserModal;
    @FindBy(css = "input[ng-model='vm.user.password']")
    private WebElement passwordFieldAddNewUserModal;
    @FindBy(id = "checkbox-active-ind")
    private WebElement activeCheckboxAddNewUserModal;
    @FindBy(css = "oi-select[ng-model='vm.userToCopy']")
    private WebElement copyFromFieldAddNewUserModal;
    @FindBy(css = "input[ng-model='vm.searchGroup.resourceName']")
    private WebElement searchResourceFieldAddNewUserModal;
    @FindBy(linkText = "Groups")
    private WebElement groupsTab;
    @FindBy(id = "mCSB_1")
    private WebElement availableGroupsList;
    @FindBy(id = "mCSB_2")
    private WebElement selectedGroupsList;
    @FindBy(linkText = "Departments")
    private WebElement departmentsTab;
    @FindBy(id = "mCSB_3")
    private WebElement availableDepartmentsList;
    @FindBy(id = "mCSB_4")
    private WebElement selectedDepartmentsList;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelButton;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(searchUserField, "Search User field")) errorsCount++;
        if (!isElementDisplayedOnPage(groupField, "Group field")) errorsCount++;
        if (!isElementDisplayedOnPage(userStatusField, "User Status field")) errorsCount++;
        if (!isElementDisplayedOnPage(onlyVantagePointClientGroupCheckbox, "Only Vantage Point Client checkbox"))
            errorsCount++;
        if (!isElementDisplayedOnPage(onlySoftwareUsersCheckbox, "Only Software Users checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(userListTable, "User List table")) errorsCount++;
        if (!isElementDisplayedOnPage(addNewUserButton, "Add New User button")) errorsCount++;
        else {
            clickOnElement(addNewUserButton);
            PdfReport.createNewSubAnchorBold("Add New User modal");
            waitToVisibilityOf(10, firstNameFieldAddNewUserModal);
            if (!isElementDisplayedOnPage(firstNameFieldAddNewUserModal, "First Name field in Add New User modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(lastNameFieldAddNewUserModal, "Last Name field in Add New User modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(loginNameFieldAddNewUserModal, "Login Name field in Add New User modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(passwordFieldAddNewUserModal, "Password field in Add New User modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(activeCheckboxAddNewUserModal, "Active checkbox in Add New User modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(copyFromFieldAddNewUserModal, "Copy From field in Add New User modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(searchResourceFieldAddNewUserModal, "Search Resource field in Add New User modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(groupsTab, "Groups tab in Add New User modal"))
                errorsCount++;
            else {
                clickOnElement(groupsTab);
                PdfReport.createNewSubAnchorNotBold("Groups tab");
                if (!isElementDisplayedOnPage(availableGroupsList, "Available Groups list in Add New User modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(selectedGroupsList, "Selected Groups list in Add New User modal"))
                    errorsCount++;
            }
            if (!isElementDisplayedOnPage(departmentsTab, "Departments tab in Add New User modal"))
                errorsCount++;
            else {
                clickOnElement(departmentsTab);
                PdfReport.createNewSubAnchorNotBold("Departments tab");
                if (!isElementDisplayedOnPage(availableDepartmentsList, "Available Departments list in Add New User modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(selectedDepartmentsList, "Selected Departments list in Add New User modal"))
                    errorsCount++;
            }
            clickOnElement(cancelButton);
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
