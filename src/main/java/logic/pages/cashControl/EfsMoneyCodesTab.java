package logic.pages.cashControl;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EfsMoneyCodesTab extends CashControlPage {
    @FindBy(css = "input[formcontrolname='dateFrom']")
    private WebElement dateFromField;
    @FindBy(css = "input[formcontrolname='dateTo']")
    private WebElement dateToField;
    @FindBy(xpath = "//button[contains(text(),'Filter')]")
    private WebElement filterButton;
    @FindBy(tagName = "ngx-datatable")
    private WebElement datatable;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(dateFromField, "Date From field")) errorsCount++;
        if (!isElementDisplayedOnPage(dateToField, "Date To field")) errorsCount++;
        if (!isElementDisplayedOnPage(filterButton, "Filter button")) errorsCount++;
        if (!isElementDisplayedOnPage(datatable, "Data table")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
