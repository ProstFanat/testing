package logic.pages.companyProfile.gpsDevices;

import logic.report.PdfReport;
import logic.widgets.TagsWidget;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewUsageProfileModal extends GPSDevicePage {

    @FindBy(name = "profileName")
    private WebElement profileNameField;
    @FindBy(name = "serverTimeout")
    private WebElement serverTimeoutField;
    @FindBy(name = "lteTimeout")
    private WebElement lteTimeoutField;
    @FindBy(name = "sleepSeconds")
    private WebElement sleepSecondsField;
    @FindBy(id = "sleep-gps-on")
    private WebElement gpsKeepCheckbox;
    @FindBy(id = "always-awake-mode")
    private WebElement alwaysAwakeModeCheckbox;
    @FindBy(id = "temp-alert-enabled")
    private WebElement temperatureCheckbox;
    @FindBy(name = "tempAlertLow")
    private WebElement minTemperatureField;
    @FindBy(name = "tempAlertHigh")
    private WebElement maxTemperatureField;
    @FindBy(id = "acc-alert-enabled")
    private WebElement accelerationCheckbox;
    @FindBy(name = "accAlertThreshold")
    private WebElement thresholdField;
    @FindBy(name = "accAlertDuration")
    private WebElement durationField;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(10, profileNameField);
        if (!isElementDisplayedOnPage(profileNameField, "Profile field")) errorsCount++;
        if (!isElementDisplayedOnPage(serverTimeoutField, "Server Timeout field")) errorsCount++;
        if (!isElementDisplayedOnPage(lteTimeoutField, "LTE Timeout field")) errorsCount++;
        if (!isElementDisplayedOnPage(sleepSecondsField, "Sleep Seconds field")) errorsCount++;
        if (!isElementDisplayedOnPage(gpsKeepCheckbox, "GPS Keep checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(alwaysAwakeModeCheckbox, "Always Awake Mode checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(temperatureCheckbox, "Temperature checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(minTemperatureField, "Min Temperature field")) errorsCount++;
        if (!isElementDisplayedOnPage(maxTemperatureField, "Max Temperature field")) errorsCount++;
        if (!isElementDisplayedOnPage(accelerationCheckbox, "Acceleration checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(thresholdField, "Threshold field")) errorsCount++;
        if (!isElementDisplayedOnPage(durationField, "Duration field")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
