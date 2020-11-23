package logic.pages;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Level;

import static logic.webdriver.DriverFactory.getDriver;

public class OperationsPage extends BasePage {
    @FindBy(tagName = "h2")
    private WebElement pageHeader;
    @FindBy(css = "input[ng-model='vm.filter.tripNumber']")
    private WebElement tripNumberField;
    @FindBy(name = "driverFullName")
    private WebElement driverNameField;
    @FindBy(name = "truckNumber")
    private WebElement truckNumberField;
    @FindBy(name = "trailerNumber")
    private WebElement trailerNumberField;
    @FindBy(name = "tripStatus")
    private WebElement tripStatusField;
    @FindBy(name = "deliveryStatus")
    private WebElement deliveryStatusField;
    @FindBy(name = "department")
    private WebElement departmentField;
    @FindBy(css = "input[ng-model='vm.filter.dateFrom']")
    private WebElement createDateFromField;
    @FindBy(css = "input[ng-model='vm.filter.dateTo']")
    private WebElement createDateToField;
    @FindBy(css = "input[ng-model='vm.filter.nextStopDateFrom']")
    private WebElement nextStopDateFromField;
    @FindBy(css = "input[ng-model='vm.filter.nextStopDateTo']")
    private WebElement nextStopDateToField;
    @FindBy(className = "operationsBoardGrid")
    private WebElement operationsBoardGrid;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(60, pageHeader);
        if (!isElementDisplayedOnPage(pageHeader, "Page Header") && !checkTextOnElement(pageHeader, "Operations Board"))
            errorsCount++;
        if (!isElementDisplayedOnPage(tripNumberField, "Trip Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(driverNameField, "Driver Name field")) errorsCount++;
        if (!isElementDisplayedOnPage(truckNumberField, "Truck Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(trailerNumberField, "Trailer Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(tripStatusField, "Trip Status field")) errorsCount++;
        if (!isElementDisplayedOnPage(deliveryStatusField, "Delivery Status field")) errorsCount++;
        if (!isElementDisplayedOnPage(departmentField, "Department field")) errorsCount++;
        if (!isElementDisplayedOnPage(createDateToField, "Create Date To field")) errorsCount++;
        if (!isElementDisplayedOnPage(createDateFromField, "Create Date From field")) errorsCount++;
        if (!isElementDisplayedOnPage(nextStopDateToField, "Next Stop Date To field")) errorsCount++;
        if (!isElementDisplayedOnPage(nextStopDateFromField, "Next Stop Date From field")) errorsCount++;
        if (!isElementDisplayedOnPage(operationsBoardGrid, "Operations Board grid")) errorsCount++;

        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
