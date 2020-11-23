package logic.pages.orderTripPlanner;

import logic.report.PdfReport;
import logic.widgets.NavigationBar;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Level;

import static logic.webdriver.DriverFactory.getDriver;

public class OrderConfirmationPage extends OrderTripPlannerPage {
    @FindBy(tagName = "h2")
    private WebElement pageHeader;
    @FindBy(name = "newOrderForm")
    private WebElement newOrderForm;
    @FindBy(id = "customer-block")
    private WebElement customerBlock;
    @FindBy(id = "customs-broker-block")
    private WebElement customsBrokerBlock;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(60, pageHeader);
        if (!isElementDisplayedOnPage(pageHeader, "Page header")) errorsCount++;
        if (!checkTextOnElement(pageHeader, "Order Confirmation Form")) errorsCount++;
        if (!isElementDisplayedOnPage(newOrderForm, "New Order form")) errorsCount++;
        if (!isElementDisplayedOnPage(customerBlock, "Customer form")) errorsCount++;
        if (!isElementDisplayedOnPage(customsBrokerBlock, "Customs Broker form")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        new NavigationBar().navigateToOrderTripPlannerPage();
        return errorsCount == 0;
    }
}
