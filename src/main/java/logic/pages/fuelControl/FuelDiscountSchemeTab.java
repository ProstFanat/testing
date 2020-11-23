package logic.pages.fuelControl;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FuelDiscountSchemeTab extends FuelControlPage {
    @FindBy (css = "button[ng-click='vm.addScheme()']")
    private WebElement addNewFuelDiscountSchemeBtn;
    @FindBy (css = "div[ui-grid='vm.listGridOption']")
    private WebElement discountTable;
    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(addNewFuelDiscountSchemeBtn, "Add New Fuel Discount Scheme button")) errorsCount++;
        if (!isElementDisplayedOnPage(discountTable, "Discounts table")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;    }
}
