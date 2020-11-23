package logic.pages.companyProfile;

import logic.BasePage;
import logic.report.PdfReport;
import logic.widgets.TagsWidget;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookPage extends BasePage {
    @FindBy(css = "button[ng-click='vm.addAddressBook()']")
    private WebElement addClientButton;
    @FindBy(id = "address-book-list-table")
    private WebElement addressBookListTable;
    @FindBy(css = "input[ng-model='vm.addressBookRecord.name']")
    private WebElement nameFieldAddToAddressBookModal;
    @FindBy(css = "input[ng-model='vm.addressBookRecord.email']")
    private WebElement emailFieldAddToAddressBookModal;
    @FindBy(id = "mCSB_1")
    private WebElement leftContainerWithTagsAddToAddressBookModal;
    @FindBy(id = "mCSB_2")
    private WebElement rightContainerWithTagsAddToAddressBookModal;
    @FindBy(css = "button[ng-click='vm.cancel()']")
    private WebElement cancelButtonAddToAddressBookModal;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(10, addClientButton);
        if (!isElementDisplayedOnPage(addressBookListTable, "Address Book List table")) errorsCount++;
        if (!isElementDisplayedOnPage(addClientButton, "Add Client button")) errorsCount++;
        else {
            clickOnElement(addClientButton);
            waitToVisibilityOf(10, nameFieldAddToAddressBookModal);
            if (!isElementDisplayedOnPage(nameFieldAddToAddressBookModal, "Name field in Add To Address Book modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(emailFieldAddToAddressBookModal, "Email field in Add To Address Book modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(leftContainerWithTagsAddToAddressBookModal, "Left container With Tags in Add To Address Book modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(rightContainerWithTagsAddToAddressBookModal, "Right container With Tags in Add To Address Book modal"))
                errorsCount++;
            clickOnElement(cancelButtonAddToAddressBookModal);
        }
        if (!new TagsWidget().isAllRequiredElementsPresent()) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
