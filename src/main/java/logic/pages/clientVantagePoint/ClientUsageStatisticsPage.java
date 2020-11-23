package logic.pages.clientVantagePoint;

import logic.report.PdfReport;
import logic.widgets.NavigationBar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClientUsageStatisticsPage extends ClientVintagePointPage {
    @FindBy(tagName = "h2")
    private WebElement pageHeader;
    @FindBy(css = "li[heading='Statistic']")
    private WebElement statisticTab;
    @FindBy(className = "chart-container")
    private WebElement chartContainer;
    @FindBy(css = "input[placeholder='Choose From date']")
    private WebElement dateFromField;
    @FindBy(css = "input[placeholder='Choose To date']")
    private WebElement dateToField;
    @FindBy(css = "button[ng-click='vm.filterList()']")
    private WebElement applyFilterBtn;
    @FindBy(css = "button[ng-click='vm.setBeginDate()']")
    private WebElement dropFilterBtn;
    @FindBy(css = "li[heading='Logs']")
    private WebElement logsTab;
    @FindBy(id = "log-list-table")
    private WebElement logList;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(60, pageHeader);
        if (!isElementDisplayedOnPage(pageHeader, "Page Header") && !checkTextOnElement(pageHeader, "Client Usage Statistics"))
            errorsCount++;
        if (!isElementDisplayedOnPage(statisticTab, "Statistic tab")) errorsCount++;
        else {
            PdfReport.createNewSubAnchorNotBold("Statistics tab");
            statisticTab.click();
            waitToVisibilityOf(10, chartContainer);
            if (!isElementDisplayedOnPage(chartContainer, "Chart Container")) errorsCount++;
            if (!isElementDisplayedOnPage(dateToField, "Date To Field")) errorsCount++;
            if (!isElementDisplayedOnPage(dateFromField, "Date From Field")) errorsCount++;
            if (!isElementDisplayedOnPage(applyFilterBtn, "Apply Filter Btn")) errorsCount++;
            if (!isElementDisplayedOnPage(dropFilterBtn, "Drop Filter Btn")) errorsCount++;
        }
        if (!isElementDisplayedOnPage(logsTab, "Logs Tab")) errorsCount++;
        else {
            PdfReport.createNewSubAnchorNotBold("Logs tab");
            logsTab.click();
            waitToVisibilityOf(10, logList);
            if (!isElementDisplayedOnPage(logList, "Log List")) errorsCount++;
        }
        PdfReport.writeJsLogFromWebDriver();
        new NavigationBar().navigateToClientVintagePointPage();
        return errorsCount == 0;
    }
}
