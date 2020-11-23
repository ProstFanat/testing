package logic.pages.companyProfile.gpsDevices;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsageProfilesTab extends GPSDevicePage {
    @FindBy(xpath = "//button[contains(text(),'Advanced Search')]")
    private WebElement advancedSearchButton;
    @FindBy(css = "input[placeholder='Profile Name']")
    private WebElement profileNameField;
    @FindBy(xpath = "//button[contains(text(),'Filter')]")
    private WebElement filterButton;
    @FindBy(css = "button[ng-click='vm.createProfile()']")
    private WebElement newUsageProfileButton;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelButton;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(advancedSearchButton, "Advanced Search button")) errorsCount++;
        else {
            advancedSearchButton.click();
            waitToVisibilityOf(10, profileNameField);
            if (!isElementDisplayedOnPage(profileNameField, "Profile field")) errorsCount++;
            if (!isElementDisplayedOnPage(filterButton, "Filter button")) errorsCount++;
        }
        if (!isElementDisplayedOnPage(newUsageProfileButton, "New Usage Profile button")) errorsCount++;
        else {
            clickOnElement(newUsageProfileButton);
            PdfReport.createNewSubAnchorNotBold("Add Usage Profile modal");
            if (!new NewUsageProfileModal().isAllRequiredElementsPresent()) errorsCount++;
            clickOnElement(cancelButton);
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
