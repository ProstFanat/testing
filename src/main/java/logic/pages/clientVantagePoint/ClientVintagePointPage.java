package logic.pages.clientVantagePoint;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClientVintagePointPage extends BasePage {
    @FindBy(tagName = "h2")
    private WebElement pageHeader;
    @FindBy(css = "input[ng-change='vm.filterVantagePointClients()']")
    private WebElement searchField;
    @FindBy(css = "div[ui-grid='vm.clientList']")
    private WebElement clientsGrid;
    @FindBy(partialLinkText = "Client Usage Statistics")
    private WebElement clientUsageStatisticsBtn;
    @FindBy(partialLinkText = "Find Trip")
    private WebElement findTripBtn;
    @FindBy(css = "button[ng-click='vm.addVantagePointClient()']")
    private WebElement addVantagePointBtn;
    @FindBy(name = "addVantagePointClientForm")
    private WebElement addVantagePointClientForm;
    @FindBy(css = "button[ng-click='vm.cancel()']")
    private WebElement cancelBtn;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(60, pageHeader);
        if (!isElementDisplayedOnPage(pageHeader, "Page Header")) errorsCount++;
        if (!checkTextOnElement(pageHeader, "Client Vantage Point")) errorsCount++;
        if (!isElementDisplayedOnPage(searchField, "Search field")) errorsCount++;

        if (!isElementDisplayedOnPage(addVantagePointBtn, "Add Vantage Point button")) errorsCount++;
        else {
            PdfReport.createNewSubAnchorNotBold("Add Vantage Point modal");
            addVantagePointBtn.click();
            waitToVisibilityOf(10, addVantagePointClientForm);
            if (!isElementDisplayedOnPage(addVantagePointClientForm, "Add Vantage Point form")) errorsCount++;
            cancelBtn.click();
        }
        PdfReport.writeJsLogFromWebDriver();
        waitToVisibilityOf(10, clientUsageStatisticsBtn);
        if (!isElementDisplayedOnPage(clientUsageStatisticsBtn, "Client Usage Statistics button")) errorsCount++;
        else {
            PdfReport.createNewSubAnchorBold("Client Usage Statistics Page");
            if (!goToClientUsageStatisticsPage().isAllRequiredElementsPresent()) errorsCount++;
        }

        waitToVisibilityOf(10, findTripBtn);
        if (!isElementDisplayedOnPage(findTripBtn, "Find Trip button")) errorsCount++;
        else {
            PdfReport.createNewSubAnchorBold("Trips Page");
            if (!goToTripsPage().isAllRequiredElementsPresent()) errorsCount++;
        }
        return errorsCount == 0;
    }

    public ClientUsageStatisticsPage goToClientUsageStatisticsPage() {
        clickOnElement(clientUsageStatisticsBtn);
        return new ClientUsageStatisticsPage();
    }

    public TripsPage goToTripsPage() {
        clickOnElement(findTripBtn);
        return new TripsPage();
    }
}
