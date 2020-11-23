package logic.pages;

import logic.BasePage;
import logic.pages.reports.DriverPaymentReportPage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    @FindBy(id = "dashboard-list-table")
    private WebElement dashboardListTable;
    @FindBy(css = "button[ng-click='vm.refreshEnRoute()']")
    private WebElement refreshButton;
    @FindBy(css = "button[ng-click='vm.goToDriverPaymentReportPage()']")
    private WebElement goToDriverPaymentReportPageButton;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(10, dashboardListTable);
        if (!isElementDisplayedOnPage(dashboardListTable, "Dashboard List table")) errorsCount++;
        if (!isElementDisplayedOnPage(refreshButton, "Refresh button")) errorsCount++;
        if (!isElementDisplayedOnPage(goToDriverPaymentReportPageButton, "Go To Driver Payment Report Page button"))
            errorsCount++;
        else {
            PdfReport.createNewSubAnchor("Driver Payment Report page");
            if (!goToDriverPaymentReportPage().isAllRequiredElementsPresent()) errorsCount++;
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }

    public DriverPaymentReportPage goToDriverPaymentReportPage() {
        clickOnElement(goToDriverPaymentReportPageButton);
        return new DriverPaymentReportPage();
    }
}
