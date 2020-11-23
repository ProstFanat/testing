package logic.pages.companyProfile.gpsDevices;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GPSDevicePage extends BasePage {
    @FindBy(linkText = "Devices")
    private WebElement devicesTab;
    @FindBy(linkText = "Usage Profiles")
    private WebElement usageProfilesTab;
    @FindBy(linkText = "Device Event Notifications")
    private WebElement deviceEventNotificationsTab;
    @FindBy(tagName = "h2")
    private WebElement pageHeader;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(60, pageHeader);
        if (!isElementDisplayedOnPage(pageHeader, "Page header")) errorsCount++;

        PdfReport.createNewSubAnchorBold("Devices tab");
        if (!isElementDisplayedOnPage(devicesTab, "Devices tab")) errorsCount++;
        else {
            if (!goToDevicesTab().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Usage Profiles tab");
        if (!isElementDisplayedOnPage(usageProfilesTab, "Usage Profiles tab")) errorsCount++;
        else {
            if (!goToUsageProfilesTab().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Device Event Notifications tab");
        if (!isElementDisplayedOnPage(deviceEventNotificationsTab, "Device Event Notifications tab")) errorsCount++;
        else {
            if (!goToDeviceEventNotificationsTab().isAllRequiredElementsPresent()) errorsCount++;
        }
        return errorsCount == 0;
    }

    public DevicesTab goToDevicesTab() {
        clickOnElement(devicesTab);
        return new DevicesTab();
    }

    public UsageProfilesTab goToUsageProfilesTab() {
        clickOnElement(usageProfilesTab);
        return new UsageProfilesTab();
    }

    public DeviceEventNotificationsTab goToDeviceEventNotificationsTab() {
        clickOnElement(deviceEventNotificationsTab);
        return new DeviceEventNotificationsTab();
    }
}
