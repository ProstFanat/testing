package logic.pages.companyProfile.drivers;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DriverCommunicationsTypeTab extends DriversPage {
    @FindBy(css = "button[ng-click='vm.openAddCommunicationModal();']")
    private WebElement addConnectionTypeButton;
    @FindBy(id = "communication-type-list-table")
    private WebElement communicationTypeListTable;
    @FindBy(name = "communicationReason")
    private WebElement communicationReasonFieldAddConnectionTypeModal;
    @FindBy(css = "textarea[ng-model='vm.communicationType.description']")
    private WebElement descriptionFieldAddConnectionTypeModal;
    @FindBy(css = "input[ng-model='vm.communicationType.notificationMargin']")
    private WebElement notificationMarginFieldAddConnectionTypeModal;
    @FindBy(name = "notificationLandmark")
    private WebElement notificationLandmarkFieldAddConnectionTypeModal;
    @FindBy(name = "notificationEmails")
    private WebElement notificationEmailsFieldAddConnectionTypeModal;
    @FindBy(css = "button[ng-click='vm.addAddressBook()']")
    private WebElement addAddressBookButtonAddConnectionTypeModal;
    @FindBy(css = "input[ng-model='vm.communicationType.repeatableAction']")
    private WebElement repeatableActionFieldAddConnectionTypeModal;
    @FindBy(id = "add-communication-map-container")
    private WebElement mapContainerFieldAddConnectionTypeModal;
    @FindBy(css = "input[ng-model='vm.addressBookRecord.name']")
    private WebElement nameFieldAddAddressBookModal;
    @FindBy(css = "input[ng-model='vm.addressBookRecord.email']")
    private WebElement emailFieldAddAddressBookModal;
    @FindBy(className = "close")
    private WebElement closeAddAddressBookModal;
    @FindBy(className = "btn-warning")
    private WebElement cancelButtonAddConnectionTypeModal;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(10, addConnectionTypeButton);
        if (!isElementDisplayedOnPage(communicationTypeListTable, "Communication Type List table")) errorsCount++;
        if (!isElementDisplayedOnPage(addConnectionTypeButton, "Add Connection Type button")) errorsCount++;
        else {
            clickOnElement(addConnectionTypeButton);
            PdfReport.createNewSubAnchorBold("Add Connection Type modal");
            waitToVisibilityOf(20, communicationReasonFieldAddConnectionTypeModal);
            if (!isElementDisplayedOnPage(communicationReasonFieldAddConnectionTypeModal, "Communication Reason field in Add Connection Type modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(descriptionFieldAddConnectionTypeModal, "Description field in Add Connection Type modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(notificationMarginFieldAddConnectionTypeModal, "Notification Margin field in Add Connection Type modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(notificationLandmarkFieldAddConnectionTypeModal, "Notification Landmark field in Add Connection Type modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(notificationEmailsFieldAddConnectionTypeModal, "Notification Emails field in Add Connection Type modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(repeatableActionFieldAddConnectionTypeModal, "Repeatable Action field in Add Connection Type modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(mapContainerFieldAddConnectionTypeModal, "Map container in Add Connection Type modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(addAddressBookButtonAddConnectionTypeModal, "Add Address Book button in Add Connection Type modal"))
                errorsCount++;
            else {
                clickOnElement(addAddressBookButtonAddConnectionTypeModal);
                PdfReport.createNewSubAnchorNotBold("Add Address Book modal");
                waitToVisibilityOf(20, nameFieldAddAddressBookModal);
                if (!isElementDisplayedOnPage(nameFieldAddAddressBookModal, "Name field in Add Address Book modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(emailFieldAddAddressBookModal, "Email field in Add Address Book modal"))
                    errorsCount++;
                clickOnElement(closeAddAddressBookModal);
            }
            clickOnElement(cancelButtonAddConnectionTypeModal);
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
