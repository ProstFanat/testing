package logic.pages.companyProfile.drivers;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HosSummaryTab extends DriversPage{
    @FindBy (name = "firstName")
    private WebElement firstNameField;
    @FindBy (name = "lastName")
    private WebElement truckNumberField;
    @FindBy (css = "input[ng-model='vm.filter.driverWithEvents']")
    private WebElement driverWithEventsCheckbox;
    @FindBy (xpath = "//button[contains(text(), 'Load HOS Data')]")
    private WebElement loadHosDataButton;
    @FindBy (css = "div[ui-grid='vm.driversHOSList']")
    private WebElement driversHOSListTable;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(10, firstNameField);
        if (!isElementDisplayedOnPage(firstNameField, "First Name field")) errorsCount++;
        if (!isElementDisplayedOnPage(truckNumberField, "Truck Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(driverWithEventsCheckbox, "Driver With Events checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(loadHosDataButton, "Load HOS Data button")) errorsCount++;
        if (!isElementDisplayedOnPage(driversHOSListTable, "Drivers HOS List table")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;    }
}
