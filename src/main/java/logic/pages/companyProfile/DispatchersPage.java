package logic.pages.companyProfile;

import logic.BasePage;
import logic.pages.companyProfile.gpsDevices.NewUsageProfileModal;
import logic.report.PdfReport;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DispatchersPage extends BasePage {
    @FindBy (css = "input[ng-model='vm.searchText']")
    private WebElement searchDispatcherField;
    @FindBy (className = "dispatchers-list-grid")
    private WebElement dispatchersListTable;
    @FindBy (partialLinkText = "Add New Dispatcher")
    private WebElement addDispatcherButton;
    @FindBy (css = "input[ng-model='vm.dispatcherName']")
    private WebElement dispatcherNameFieldAddDispatcherModal;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelButton;
    @FindBy(css = "input[ng-model='vm.user.firstName']")
    private WebElement firstNameFieldAddDispatchUserModal;
    @FindBy(css = "input[ng-model='vm.user.lastName']")
    private WebElement lastNameFieldAddDispatchUserModal;
    @FindBy(css = "input[ng-model='vm.user.loginName']")
    private WebElement loginNameFieldAddDispatchUserModal;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(searchDispatcherField, "Search Dispatcher field")) errorsCount++;
        if (!isElementDisplayedOnPage(dispatchersListTable, "Dispatcher List table")) errorsCount++;
        if (!isElementDisplayedOnPage(addDispatcherButton, "Add Dispatcher button")) errorsCount++;
        else {
            clickOnElement(addDispatcherButton);
            PdfReport.createNewSubAnchorNotBold("Add Dispatcher modal");
            if (!isElementDisplayedOnPage(dispatcherNameFieldAddDispatcherModal, "Dispatcher Name field in Add Dispatcher modal")) errorsCount++;
            clickOnElement(cancelButton);
        }
        try {
            List<WebElement> addAclUserBtns = driver.findElements(By.cssSelector("a[uib-tooltip='Add ACL user']"));
            if (addAclUserBtns.size()>0){
                clickOnElement(addAclUserBtns.get(0));

            }
        } catch (NoSuchElementException e){
            log.error("No Such 'Add ACL User' buttons: " + e);
            PdfReport.writeErrorToReport("No such 'Add ACL User' button", false);
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
