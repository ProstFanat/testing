package logic.pages.orderTripPlanner;

import logic.report.PdfReport;
import logic.widgets.NavigationBar;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Level;

import static logic.webdriver.DriverFactory.getDriver;

public class OrderTripPlannerTripsBoardPage extends OrderTripPlannerPage {
    @FindBy(tagName = "h2")
    private WebElement pageHeader;
    @FindBy(css = "li[heading='Orders']")
    private WebElement ordersTab;
    @FindBy(css = "li[heading='Places']")
    private WebElement placesTab;
    @FindBy(className = "angular-google-map")
    private WebElement angularGoogleMapBlock;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(60, pageHeader);
        if (!isElementDisplayedOnPage(pageHeader, "Page header")) errorsCount++;
        if (!checkTextOnElement(pageHeader, "Order Trip Planner")) errorsCount++;
        if (!isElementDisplayedOnPage(ordersTab, "Orders tab")) errorsCount++;
        if (!isElementDisplayedOnPage(placesTab, "Places tab")) errorsCount++;
        if (!isElementDisplayedOnPage(angularGoogleMapBlock, "Angular Google Map block")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        new NavigationBar().navigateToOrderTripPlannerPage();
        return errorsCount == 0;
    }
}
