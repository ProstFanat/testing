package logic.pages.eManifest;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EManifestsTab extends EManifestPage {
    @FindBy(css = "input[ng-model='vm.filter.number']")
    private WebElement numberField;
    @FindBy(css = "oi-select[ng-model='vm.filter.type']")
    private WebElement typeField;
    @FindBy(css = "input[ng-model='vm.filter.pb']")
    private WebElement pbField;
    @FindBy(css = "oi-select[ng-model='vm.filter.status']")
    private WebElement statusField;
    @FindBy(css = "oi-select[ng-model='vm.filter.customsStatus']")
    private WebElement customsStatusField;
    @FindBy(css = "input[ng-model='vm.filter.truckNumber']")
    private WebElement truckNumberField;
    @FindBy(css = "input[ng-model='vm.filter.trailerNumber']")
    private WebElement trailerNumberField;
    @FindBy(css = "input[ng-model='vm.filter.driverName']")
    private WebElement driverNameField;
    @FindBy(css = "input[ng-model='vm.filter.fullName']")
    private WebElement editByField;
    @FindBy(id = "emanifest-archive-check")
    private WebElement archiveCheckbox;
    @FindBy(css = "button[ng-click='vm.addEManifest()']")
    private WebElement createEManifestButton;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(10, numberField);
        if (!isElementDisplayedOnPage(numberField, "Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(pbField, "PB field")) errorsCount++;
        if (!isElementDisplayedOnPage(typeField, "Type field")) errorsCount++;
        if (!isElementDisplayedOnPage(customsStatusField, "Customs Status field")) errorsCount++;
        if (!isElementDisplayedOnPage(statusField, "Status field")) errorsCount++;
        if (!isElementDisplayedOnPage(truckNumberField, "Truck Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(trailerNumberField, "Trailer Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(driverNameField, "Driver Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(editByField, "Edit By field")) errorsCount++;
        if (!isElementDisplayedOnPage(archiveCheckbox, "Archive checkbox")) errorsCount++;
        if (!isElementDisplayedOnPage(archiveCheckbox, "Archive checkbox")) errorsCount++;
        else {
            if (!createEManifest().isAllRequiredElementsPresent()) errorsCount++;
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }

    public CreateEManifestModal createEManifest() {
        clickOnElement(createEManifestButton);
        return new CreateEManifestModal();
    }
}
