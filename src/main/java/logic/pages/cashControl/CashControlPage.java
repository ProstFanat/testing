package logic.pages.cashControl;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CashControlPage extends BasePage {
    @FindBy(linkText = "Trip")
    private WebElement tripTab;
    @FindBy(linkText = "Pools")
    private WebElement poolTab;
    @FindBy(linkText = "EFS Money Codes")
    private WebElement efsMoneyCodesTab;
    @FindBy(linkText = "Reports")
    private WebElement reportsTab;

    public TripTab goToTripTab() {
        clickOnElement(tripTab);
        return new TripTab();
    }

    public PoolsTab goToPoolsTab() {
        clickOnElement(poolTab);
        return new PoolsTab();
    }

    public EfsMoneyCodesTab goToEfsMoneyCodesTab() {
        clickOnElement(efsMoneyCodesTab);
        return new EfsMoneyCodesTab();
    }

    public ReportsTab goToReportsTab() {
        clickOnElement(reportsTab);
        return new ReportsTab();
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        PdfReport.createNewSubAnchor("Trip tab");
        if (!goToTripTab().isAllRequiredElementsPresent()) errorsCount++;

        PdfReport.createNewSubAnchor("Pools tab");
        if (!goToPoolsTab().isAllRequiredElementsPresent()) errorsCount++;

        PdfReport.createNewSubAnchor("EFS Money Codes tab");
        if (!goToEfsMoneyCodesTab().isAllRequiredElementsPresent()) errorsCount++;

        PdfReport.createNewSubAnchor("Reports tab");
        if (!goToReportsTab().isAllRequiredElementsPresent()) errorsCount++;

        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
