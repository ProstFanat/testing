package logic.pages.companyProfile.gpsDevices;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeviceEventNotificationsTab extends GPSDevicePage {

    @FindBy(xpath = "//button[contains(text(),'Advanced Search')]")
    private WebElement advancedSearchButton;
    @FindBy(css = "oi-select[ng-model='vm.filter.eventType']")
    private WebElement eventTypeField;
    @FindBy(css = "select[ng-model='vm.filter.active']")
    private WebElement statusField;
    @FindBy(xpath = "//button[contains(text(),'Filter')]")
    private WebElement filterButton;
    @FindBy(css = "button[ng-click='vm.createNotification()']")
    private WebElement createDeviceEventNotificationButton;
    @FindBy(css = "select[ng-model='vm.notification.eventType']")
    private WebElement eventTypeFieldAddDeviceEventNotificationModal;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelButton;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(advancedSearchButton, "Advanced Search button")) errorsCount++;
        else {
            advancedSearchButton.click();
            if (!isElementDisplayedOnPage(eventTypeField, "Event Type field")) errorsCount++;
            if (!isElementDisplayedOnPage(statusField, "Status field")) errorsCount++;
            if (!isElementDisplayedOnPage(filterButton, "Filter button")) errorsCount++;
        }
        if (!isElementDisplayedOnPage(createDeviceEventNotificationButton, "Create Device Event Notification button"))
            errorsCount++;
        else {
            clickOnElement(createDeviceEventNotificationButton);
            waitToVisibilityOf(10, eventTypeFieldAddDeviceEventNotificationModal);
            if (!isElementDisplayedOnPage(eventTypeFieldAddDeviceEventNotificationModal, "Event Type field in Add Device Event Notification modal"))
                errorsCount++;
            clickOnElement(cancelButton);
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
