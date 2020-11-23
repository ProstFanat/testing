package logic.pages.companyProfile.gpsDevices;

import logic.report.PdfReport;
import logic.widgets.TagsWidget;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DevicesTab extends GPSDevicePage {
    @FindBy(xpath = "//button[contains(text(),'Advanced Search')]")
    private WebElement advancedSearchButton;
    @FindBy(css = "select[ng-model='vm.filter.gpsDeviceType']")
    private WebElement gpsDeviceTypeField;
    @FindBy(css = "input[ng-model='vm.filter.name']")
    private WebElement nameField;
    @FindBy(xpath = "//button[contains(text(),'Filter')]")
    private WebElement filterButton;
    @FindBy(xpath = "//button[contains(text(),'New GPS Device')]")
    private WebElement newGPSDeviceButton;
    @FindBy(css = "select[ng-model='vm.selectedGPSDeviceType']")
    private WebElement gpsDeviceTypeFieldAddGpsDeviceModal;
    @FindBy(css = "input[ng-model='vm.gpsDevice.deviceUid']")
    private WebElement deviceUidFieldAddGpsDeviceModal;
    @FindBy(css = "input[ng-model='vm.gpsDevice.server']")
    private WebElement serverFieldAddGpsDeviceModal;
    @FindBy(css = "input[ng-model='vm.gpsDevice.serverPort']")
    private WebElement serverPortFieldAddGpsDeviceModal;
    @FindBy(css = "input[ng-model='vm.gpsDevice.apn']")
    private WebElement apnFieldAddGpsDeviceModal;
    @FindBy(linkText = "Usage Profile")
    private WebElement usageProfileTabAddGpsDeviceModal;
    @FindBy(linkText = "Profile Management")
    private WebElement profileManagementTabAddGpsDeviceModal;
    @FindBy(css = "button[ng-click='vm.createProfile()']")
    private WebElement createProfileButtonAddGpsDeviceModal;
    @FindBy(linkText = "Notifications")
    private WebElement notificationsTabAddGpsDeviceModal;
    @FindBy(css = "select[ng-model='vm.notification']")
    private WebElement notificationFieldAddTabGpsDeviceModal;
    @FindBy(css = "button[ng-click='vm.addNotification(vm.notification)']")
    private WebElement addNotificationButtonAddTabGpsDeviceModal;
    @FindBy(linkText = "Notification Management")
    private WebElement notificationsManagementTabAddGpsDeviceModal;
    @FindBy(css = "button[ng-click='vm.createNotification()']")
    private WebElement createNotificationButtonAddGpsDeviceModal;
    @FindBy(css = "select[ng-model='vm.notification.eventType']")
    private WebElement eventTypeFieldAddGpsDeviceModal;
    @FindBy(css = "select[ng-model='vm.profile']")
    private WebElement profileFieldAddGpsDeviceModal;
    @FindBy(className = "btn-warning")
    private WebElement cancelButtonAddGpsDeviceModal;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(gpsDeviceTypeField, "GPS Device Type field")) errorsCount++;
        if (!isElementDisplayedOnPage(advancedSearchButton, "Advanced Search button")) errorsCount++;
        else {
            advancedSearchButton.click();
            if (!isElementDisplayedOnPage(nameField, "Name field")) errorsCount++;
            if (!isElementDisplayedOnPage(filterButton, "Filter button")) errorsCount++;
        }
        if (!isElementDisplayedOnPage(newGPSDeviceButton, "New GPS Device button")) errorsCount++;
        else {
            clickOnElement(newGPSDeviceButton);
            PdfReport.createNewSubAnchorNotBold("Add GPS Device modal");
            waitToVisibilityOf(10, gpsDeviceTypeFieldAddGpsDeviceModal);
            if (!isElementDisplayedOnPage(gpsDeviceTypeFieldAddGpsDeviceModal, "GPS Device Type field in Add GPS Device modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(gpsDeviceTypeFieldAddGpsDeviceModal, "GPS Device Type field in Add GPS Device modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(deviceUidFieldAddGpsDeviceModal, "Device UID field in Add GPS Device modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(serverFieldAddGpsDeviceModal, "Server field in Add GPS Device modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(serverPortFieldAddGpsDeviceModal, "Server Port field in Add GPS Device modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(apnFieldAddGpsDeviceModal, "APN field in Add GPS Device modal"))
                errorsCount++;

            if (!isElementDisplayedOnPage(usageProfileTabAddGpsDeviceModal, "Usage Profile tab in Add GPS Device modal"))
                errorsCount++;
            else {
                clickOnElement(usageProfileTabAddGpsDeviceModal);
                PdfReport.createNewSubAnchorNotBold("Usage Profile tab");
                if (!isElementDisplayedOnPage(profileFieldAddGpsDeviceModal, "Profile field in Add GPS Device modal"))
                    errorsCount++;
            }

            if (!isElementDisplayedOnPage(profileManagementTabAddGpsDeviceModal, "Profile Management tab in Add GPS Device modal"))
                errorsCount++;
            else {
                clickOnElement(profileManagementTabAddGpsDeviceModal);
                PdfReport.createNewSubAnchorNotBold("Profile Management tab");
                if (!isElementDisplayedOnPage(createProfileButtonAddGpsDeviceModal, "Create New Profile in Add GPS Device modal"))
                    errorsCount++;
                else {
                    clickOnElement(createProfileButtonAddGpsDeviceModal);
                    PdfReport.createNewSubAnchorNotBold("New Usage Profile modal");
                    if (!new NewUsageProfileModal().isAllRequiredElementsPresent()) errorsCount++;
                }
            }
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",cancelButtonAddGpsDeviceModal);
            waitToVisibilityOf(10, notificationsTabAddGpsDeviceModal);
            if (!isElementDisplayedOnPage(notificationsTabAddGpsDeviceModal, "Notifications tab in Add GPS Device modal"))
                errorsCount++;
            else {
                clickOnElement(notificationsTabAddGpsDeviceModal);
                PdfReport.createNewSubAnchorNotBold("Notification tab");
                if (!isElementDisplayedOnPage(notificationFieldAddTabGpsDeviceModal, "Notification field in Add GPS Device modal"))
                    errorsCount++;
                if (!isElementDisplayedOnPage(addNotificationButtonAddTabGpsDeviceModal, "Add Notification button in Add GPS Device modal"))
                    errorsCount++;
            }

            if (!isElementDisplayedOnPage(notificationsManagementTabAddGpsDeviceModal, "Notifications Management tab in Add GPS Device modal"))
                errorsCount++;
            else {
                clickOnElement(notificationsManagementTabAddGpsDeviceModal);
                PdfReport.createNewSubAnchorNotBold("Notification Management tab");
                if (!isElementDisplayedOnPage(createNotificationButtonAddGpsDeviceModal, "Create New Notification button in Add GPS Device modal"))
                    errorsCount++;
                else {
                    clickOnElement(createNotificationButtonAddGpsDeviceModal);
                    if (!isElementDisplayedOnPage(eventTypeFieldAddGpsDeviceModal, "Event Type field in Add GPS Device modal"))
                        errorsCount++;
                }
            }

            clickOnElement(cancelButtonAddGpsDeviceModal);
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
