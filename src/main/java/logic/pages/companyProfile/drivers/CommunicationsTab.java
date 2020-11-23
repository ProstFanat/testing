package logic.pages.companyProfile.drivers;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommunicationsTab extends DriversPage{
    @FindBy (css = "button[ng-click='vm.openAddCommunicationForDriversGroupModal();']")
    private WebElement addCommunicationRecordForDriversGroupButton;
    @FindBy (css = "div[ui-grid='vm.driverCommunicationsList']")
    private WebElement driverCommunicationsListTable;
    @FindBy (css = "oi-select[ng-model='vm.selectedCommunication']")
    private WebElement communicationReasonFieldAddCommunicationModal;
    @FindBy (name = "expirationDate")
    private WebElement expirationDateFieldAddCommunicationModal;
    @FindBy (css = "select[ng-model='vm.communicationRecord.driverPeriodicNotification']")
    private WebElement driverPeriodicNotificationFieldAddCommunicationModal;
    @FindBy (id = "add-driver-communication-map-container")
    private WebElement mapContainerAddCommunicationModal;
    @FindBy (name = "driverFirstName")
    private WebElement driverFirstNameFieldAddCommunicationModal;
    @FindBy (name = "driverLastName")
    private WebElement driverLastNameFieldAddCommunicationModal;
    @FindBy (css = "div[ui-grid='vm.driverListGridOption']")
    private WebElement driverListGridAddCommunicationModal;
    @FindBy(xpath = "//button[contains(text(), 'Cancel')]")
    private WebElement cancelButtonAddConnectionTypeModal;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(10, addCommunicationRecordForDriversGroupButton);
        if (!isElementDisplayedOnPage(driverCommunicationsListTable, "Driver Communications List table")) errorsCount++;
        if (!isElementDisplayedOnPage(addCommunicationRecordForDriversGroupButton, "Add Communication Record For Drivers Group button")) errorsCount++;
        else {
            clickOnElement(addCommunicationRecordForDriversGroupButton);
            PdfReport.createNewSubAnchorBold("Add Communication Record For Drivers Group modal");
            waitToVisibilityOf(20, communicationReasonFieldAddCommunicationModal);
            if (!isElementDisplayedOnPage(communicationReasonFieldAddCommunicationModal, "Communication Reason field in Add Communication modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(expirationDateFieldAddCommunicationModal, "Expiration Date field in Add Communication modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(driverPeriodicNotificationFieldAddCommunicationModal, "Driver Periodic Notification field in Add Communication modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(mapContainerAddCommunicationModal, "Map Container in Add Communication modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(driverFirstNameFieldAddCommunicationModal, "First Name field in Add Communication modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(driverLastNameFieldAddCommunicationModal, "Last Name field in Add Communication modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(driverListGridAddCommunicationModal, "Driver List Grid container in Add Communication modal"))
                errorsCount++;
            clickOnElement(cancelButtonAddConnectionTypeModal);
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;    }
}
