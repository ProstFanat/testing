package logic.pages.orderTripPlanner;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderTripPlannerPage extends BasePage {
    @FindBy(tagName = "h2")
    private WebElement pageHeader;
    @FindBy(css = "input[ng-model='vm.orderBoardFromCreateDatePicker']")
    private WebElement orderBoardFromCreateDatePicker;
    @FindBy(css = "input[ng-model='vm.orderBoardToCreateDatePicker']")
    private WebElement orderBoardToCreateDatePicker;
    @FindBy(css = "input[ng-model='vm.orderBoardFilter.confirmationNumber']")
    private WebElement orderBoardFilterConfirmationNumber;
    @FindBy(css = "input[placeholder='Select Customer']")
    private WebElement orderBoardSelectCustomerField;
    @FindBy(id = "order-list-table")
    private WebElement orderListTable;
    @FindBy(id = "trip-list-table")
    private WebElement tripListTable;
    @FindBy(css = "input[ng-model='vm.tripBoardFromCreateDatePicker']")
    private WebElement tripBoardFromCreateDatePicker;
    @FindBy(css = "input[ng-model='vm.tripBoardToCreateDatePicker']")
    private WebElement tripBoardToCreateDatePicker;
    @FindBy(css = "input[ng-model='vm.tripBoardFilter.tripNumber']")
    private WebElement tripBoardTripNumberField;
    @FindBy(css = "input[placeholder='Driver']")
    private WebElement tripBoardDriverField;
    @FindBy(css = "input[placeholder='Truck #']")
    private WebElement tripBoardTruckNumberField;
    @FindBy(css = "input[placeholder='Trailer #']")
    private WebElement tripBoardTrailerNumberField;
    @FindBy(partialLinkText = "Add New Order")
    private WebElement addNewOrder;
    @FindBy(partialLinkText = "Order Trip Planner")
    private WebElement newOrderTripPlanner;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(60, pageHeader);
        if (!isElementDisplayedOnPage(pageHeader, "Page header")) errorsCount++;
        if (!isElementDisplayedOnPage(orderBoardFromCreateDatePicker, "Create Date From datepicker in Order Board"))
            errorsCount++;
        if (!isElementDisplayedOnPage(orderBoardToCreateDatePicker, "Create Date To datepicker in Order Board"))
            errorsCount++;
        if (!isElementDisplayedOnPage(orderBoardFilterConfirmationNumber, "Confirmation field in Order Board"))
            errorsCount++;
        if (!isElementDisplayedOnPage(orderBoardSelectCustomerField, "Customer field in Order Board"))
            errorsCount++;
        if (!isElementDisplayedOnPage(orderListTable, "Order List table in Order Board")) errorsCount++;
        if (!isElementDisplayedOnPage(tripBoardFromCreateDatePicker, "Create From datepicker in Trip Board"))
            errorsCount++;
        if (!isElementDisplayedOnPage(tripBoardToCreateDatePicker, "Create To datepicker in Trip Board")) errorsCount++;
        if (!isElementDisplayedOnPage(tripBoardTripNumberField, "Trip Number field in Trip Board")) errorsCount++;
        if (!isElementDisplayedOnPage(tripBoardDriverField, "Driver field in Trip Board")) errorsCount++;
        if (!isElementDisplayedOnPage(tripBoardTruckNumberField, "Truck Number field in Trip Board")) errorsCount++;
        if (!isElementDisplayedOnPage(tripBoardTrailerNumberField, "Trailer Number field in Trip Board")) errorsCount++;
        if (!isElementDisplayedOnPage(tripListTable, "Trip List table in Trip Board")) errorsCount++;

        PdfReport.writeJsLogFromWebDriver();

        if (!isElementDisplayedOnPage(addNewOrder, "Add New Order button")) errorsCount++;
        else {
            PdfReport.createNewSubAnchorBold("Order Confirmation Form");
            if (!goToOrderConfirmationPage().isAllRequiredElementsPresent()) errorsCount++;
        }

        if (!isElementDisplayedOnPage(newOrderTripPlanner, "New Order Trip Planner button")) errorsCount++;
        else {
            PdfReport.createNewSubAnchorBold("Order Trip Planner");
            if (!goToOrderTripPlannerFromTripsBoard().isAllRequiredElementsPresent()) errorsCount++;
        }

        return errorsCount == 0;
    }

    public OrderConfirmationPage goToOrderConfirmationPage() {
        clickOnElement(addNewOrder);
        return new OrderConfirmationPage();
    }

    public OrderTripPlannerTripsBoardPage goToOrderTripPlannerFromTripsBoard() {
        clickOnElement(newOrderTripPlanner);
        return new OrderTripPlannerTripsBoardPage();
    }
}
