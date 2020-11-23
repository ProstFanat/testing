package logic.pages.companyProfile.departments;

import logic.BasePage;
import logic.report.PdfReport;
import logic.widgets.TagsWidget;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DepartmentsPage extends BasePage {
    @FindBy(css = "input[ng-model='vm.searchText']")
    private WebElement searchDepartmentField;
    @FindBy(partialLinkText = "Create New Department")
    private WebElement createNewDepartmentButton;
    @FindBy(id = "department-list-table")
    private WebElement departmentListTable;
    @FindBy(linkText = "Main")
    private WebElement mainTabCreateNewDepartmentModal;
    @FindBy(name = "department-name")
    private WebElement departmentNameFieldCreateNewDepartmentModal;
    @FindBy(name = "has-outbound")
    private WebElement outboundCheckboxCreateNewDepartmentModal;
    @FindBy(name = "expired-on")
    private WebElement inboundCheckboxCreateNewDepartmentModal;
    @FindBy(css = "input[ng-model='vm.department.isLocal']")
    private WebElement localCheckboxCreateNewDepartmentModal;
    @FindBy(css = "input[ng-model='vm.department.collectRevenuePerMile']")
    private WebElement collectRevenuePerMileCheckboxCreateNewDepartmentModal;
    @FindBy(css = "div[ng-model='vm.department.colour']")
    private WebElement colourFieldCreateNewDepartmentModal;
    @FindBy(linkText = "Tags")
    private WebElement tagsTabCreateNewDepartmentModal;
    @FindBy(css = "input[ng-model='vm.searchAvailableTag']")
    private WebElement searchAvailableTagField;
    @FindBy(linkText = "Trucks")
    private WebElement trucksTabCreateNewDepartmentModal;
    @FindBy(css = "input[ng-model='vm.searchTruck']")
    private WebElement searchTruckField;
    @FindBy(css = "input[ng-model='vm.searchAvailableTruck']")
    private WebElement searchAvailableTruckField;
    @FindBy(linkText = "Trailers")
    private WebElement trailersTabCreateNewDepartmentModal;
    @FindBy(css = "input[ng-model='vm.searchTrailer']")
    private WebElement searchTrailerField;
    @FindBy(css = "input[ng-model='vm.searchAvailableTrailer']")
    private WebElement searchAvailableTrailerField;
    @FindBy(linkText = "Drivers")
    private WebElement driversTabCreateNewDepartmentModal;
    @FindBy(css = "input[ng-model='vm.searchDriver']")
    private WebElement searchDriverField;
    @FindBy(css = "input[ng-model='vm.searchAvailableDriver']")
    private WebElement searchAvailableDriverField;
    @FindBy(linkText = "Dispatchers")
    private WebElement dispatchersTabCreateNewDepartmentModal;
    @FindBy(css = "input[ng-model='vm.searchDispatcher']")
    private WebElement searchDispatcherField;
    @FindBy(css = "input[ng-model='vm.searchAvailableDispatcher']")
    private WebElement searchAvailableDispatcherField;
    @FindBy(linkText = "Users")
    private WebElement usersTabCreateNewDepartmentModal;
    @FindBy(css = "input[ng-model='vm.searchUser']")
    private WebElement searchUserField;
    @FindBy(css = "input[ng-model='vm.searchAvailableUser']")
    private WebElement searchAvailableUserField;
    @FindBy(xpath = "//button[contains(text(),'Close')]")
    private WebElement cancelButton;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(searchDepartmentField, "Search Department field")) errorsCount++;
        if (!isElementDisplayedOnPage(departmentListTable, "Department List table")) errorsCount++;
        if (!isElementDisplayedOnPage(createNewDepartmentButton, "Create new Department button")) errorsCount++;
        else {
            clickOnElement(createNewDepartmentButton);
            PdfReport.createNewSubAnchorBold("Add New Department modal");
            waitToVisibilityOf(10, mainTabCreateNewDepartmentModal);
            if (!isElementDisplayedOnPage(mainTabCreateNewDepartmentModal, "Main tab")) errorsCount++;
            else {
                clickOnElement(mainTabCreateNewDepartmentModal);
                PdfReport.createNewSubAnchorNotBold("Main tab");
                if (!isElementDisplayedOnPage(departmentNameFieldCreateNewDepartmentModal, "Department Name field in Create New Department modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(outboundCheckboxCreateNewDepartmentModal, "Outbound checkbox in Create New Department modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(inboundCheckboxCreateNewDepartmentModal, "Inbound checkbox in Create New Department modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(localCheckboxCreateNewDepartmentModal, "Local checkbox in Create New Department modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(collectRevenuePerMileCheckboxCreateNewDepartmentModal, "Collect Revenue Per Mile checkbox in Create New Department modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(colourFieldCreateNewDepartmentModal, "Colour field in Create New Department modal"))
                    errorsCount++;
            }
            if (!isElementDisplayedOnPage(tagsTabCreateNewDepartmentModal, "Tags tab")) errorsCount++;
            else {
                clickOnElement(tagsTabCreateNewDepartmentModal);
                PdfReport.createNewSubAnchorNotBold("Tags tab");
                if (!isElementDisplayedOnPage(searchAvailableTagField, "Search Available Tag field in Create New Department modal"))
                    errorsCount++;
                List<WebElement> departmentsList = driver.findElements(By.className("department-list"));
                PdfReport.writeErrorToReport("This window should have two columns, actual = " + departmentsList.size(), departmentsList.size() == 2);
            }

            if (!isElementDisplayedOnPage(trucksTabCreateNewDepartmentModal, "Trucks tab")) errorsCount++;
            else {
                clickOnElement(trucksTabCreateNewDepartmentModal);
                PdfReport.createNewSubAnchorNotBold("Trucks tab");
                if (!isElementDisplayedOnPage(searchTruckField, "Search Truck field in Create New Department modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(searchAvailableTruckField, "Search Available Truck field in Create New Department modal"))
                    errorsCount++;
                List<WebElement> departmentsList = driver.findElements(By.className("department-trucks-list"));
                PdfReport.writeErrorToReport("This window should have 2 columns, actual = " + departmentsList.size(), departmentsList.size() == 2);
            }

            if (!isElementDisplayedOnPage(trailersTabCreateNewDepartmentModal, "Trailers tab")) errorsCount++;
            else {
                clickOnElement(trailersTabCreateNewDepartmentModal);
                PdfReport.createNewSubAnchorNotBold("Trailers tab");
                if (!isElementDisplayedOnPage(searchTrailerField, "Search Trailer field in Create New Department modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(searchAvailableTrailerField, "Search Available Trailer field in Create New Department modal"))
                    errorsCount++;
                List<WebElement> departmentsList = driver.findElements(By.className("department-list"));
                PdfReport.writeErrorToReport("This window should have 2 columns, actual = " + departmentsList.size(), departmentsList.size() == 2);
            }

            if (!isElementDisplayedOnPage(driversTabCreateNewDepartmentModal, "Drivers tab")) errorsCount++;
            else {
                clickOnElement(driversTabCreateNewDepartmentModal);
                PdfReport.createNewSubAnchorNotBold("Drivers tab");
                if (!isElementDisplayedOnPage(searchDriverField, "Search Driver field in Create New Department modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(searchAvailableDriverField, "Search Available Driver field in Create New Department modal"))
                    errorsCount++;
                List<WebElement> departmentsList = driver.findElements(By.className("department-list"));
                PdfReport.writeErrorToReport("This window should have 2 columns, actual = " + departmentsList.size(), departmentsList.size() == 2);
            }

            if (!isElementDisplayedOnPage(dispatchersTabCreateNewDepartmentModal, "Dispatchers tab")) errorsCount++;
            else {
                clickOnElement(dispatchersTabCreateNewDepartmentModal);
                PdfReport.createNewSubAnchorNotBold("Dispatchers tab");
                if (!isElementDisplayedOnPage(searchDispatcherField, "Search Dispatcher field in Create New Department modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(searchAvailableDispatcherField, "Search Available Dispatcher field in Create New Department modal"))
                    errorsCount++;
                List<WebElement> departmentsList = driver.findElements(By.className("department-list"));
                PdfReport.writeErrorToReport("This window should have 2 columns, actual = " + departmentsList.size(), departmentsList.size() == 2);
            }

            if (!isElementDisplayedOnPage(usersTabCreateNewDepartmentModal, "Users tab")) errorsCount++;
            else {
                clickOnElement(usersTabCreateNewDepartmentModal);
                PdfReport.createNewSubAnchorNotBold("Users tab");
                if (!isElementDisplayedOnPage(searchUserField, "Search User field in Create New Department modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(searchAvailableUserField, "Search Available User field in Create New Department modal"))
                    errorsCount++;
                List<WebElement> departmentsList = driver.findElements(By.className("department-list"));
                PdfReport.writeErrorToReport("This window should have 2 columns, actual = " + departmentsList.size(), departmentsList.size() == 2);
            }
        clickOnElement(cancelButton);
        }

        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
