package logic.pages.priceCalculator;

import logic.report.PdfReport;
import logic.widgets.NavigationBar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContractorPage extends PriceCalculatorPage {
    @FindBy(css = "div[ui-grid='vm.contractorsList']")
    private WebElement contractorsList;
    @FindBy(css = "button[ng-click='vm.addCarrierContractorModal()']")
    private WebElement addContractorBtn;
    @FindBy(name = "addEditContractorForm")
    private WebElement addEditContractorForm;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelBtn;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(contractorsList, "Contractors List Table")) errorsCount++;
        if (!isElementDisplayedOnPage(addContractorBtn, "Add Contractor Btn")) errorsCount++;
        else {
            clickOnElement(addContractorBtn);
            waitToVisibilityOf(10, addEditContractorForm);
            PdfReport.createNewSubAnchorBold("Add Contractor modal");
            if (!isElementDisplayedOnPage(addEditContractorForm, "Add Edit Contractor Form")) errorsCount++;
            clickOnElement(cancelBtn);
        }
        PdfReport.writeJsLogFromWebDriver();
        new NavigationBar().navigateToPriceCalculatorPage();

        return errorsCount == 0;
    }
}
