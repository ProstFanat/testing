package logic.pages.eManifest;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HistoryTab extends EManifestPage {
    @FindBy(css = "input[ng-model='vm.filter.number']")
    private WebElement numberField;
    @FindBy(css = "input[ng-model='vm.filter.userName']")
    private WebElement userNameField;
    @FindBy(css = "input[value='emanifest']")
    private WebElement emanifestCheckbox;
    @FindBy(css = "input[value='shipment']")
    private WebElement shipmentCheckbox;
    @FindBy(id = "uiGridCustomsHistory")
    private WebElement customsHistoryGrid;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(10, numberField);
        if (!isElementDisplayedOnPage(numberField, "Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(userNameField, "User Name field")) errorsCount++;
        if (!isElementDisplayedOnPage(emanifestCheckbox, "e-Manifest checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(shipmentCheckbox, "Shipment checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(customsHistoryGrid, "Customs History grid")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
