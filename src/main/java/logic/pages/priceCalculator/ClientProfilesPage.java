package logic.pages.priceCalculator;

import logic.report.PdfReport;
import logic.widgets.NavigationBar;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Level;

import static logic.webdriver.DriverFactory.getDriver;

public class ClientProfilesPage extends PriceCalculatorPage {
    @FindBy(css = "input[ng-model='vm.filterText']")
    private WebElement findCompanyByNameField;
    @FindBy(css = "button[ng-click='vm.quotesHistory = !vm.quotesHistory']")
    private WebElement showQuotesHistoryBtn;
    @FindBy(css = "button[ng-click='vm.addClientProfile()']")
    private WebElement addClientProfileBtn;
    @FindBy(css = "button[ng-click='vm.showTableView = !vm.showTableView']")
    private WebElement showTableViewBtn;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(findCompanyByNameField, "Find Company By Name Field")) errorsCount++;
        if (!isElementDisplayedOnPage(showQuotesHistoryBtn, "Show Quotes History Btn")) errorsCount++;
        if (!isElementDisplayedOnPage(addClientProfileBtn, "Add Client Profile Btn")) errorsCount++;
        if (!isElementDisplayedOnPage(showTableViewBtn, "Show Table View Btn")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
