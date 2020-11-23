package logic.pages.priceCalculator;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CargoProfilesPage extends PriceCalculatorPage {
    @FindBy(css = "select[ng-model='vm.selectedCargoProfileType']")
    private WebElement selectCargoProfileType;
    @FindBy(css = "button[ng-click='vm.addCargoProfile()']")
    private WebElement addCargoProfileBtn;
    @FindBy(css = "select[ng-model='vm.priceCargoProfile.profileType']")
    private WebElement selectProfileTypeAddCargoModal;
    @FindBy(css = "input[ng-model='vm.priceCargoProfile.profileName']")
    private WebElement profileNameFieldAddCargoModal;
    @FindBy(css = "input[ng-model='vm.priceCargoProfile.maxCapacity']")
    private WebElement maxCapacityFieldAddCargoModal;
    @FindBy(css = "button[ng-click='vm.showTableView = !vm.showTableView']")
    private WebElement showTableViewBtn;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelBtn;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(selectCargoProfileType, "Select Cargo Profile type")) errorsCount++;
        if (!isElementDisplayedOnPage(addCargoProfileBtn, "Add Cargo Profile button")) errorsCount++;
        else {
            clickOnElement(addCargoProfileBtn);
            waitToVisibilityOf(10, selectCargoProfileType);
            PdfReport.createNewSubAnchorBold("Add Cargo modal");
            if (!isElementDisplayedOnPage(selectProfileTypeAddCargoModal, "Select Profile Type in Add Cargo modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(profileNameFieldAddCargoModal, "Profile Name Field in Add Cargo modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(maxCapacityFieldAddCargoModal, "Max Capacity Field in Add Cargo modal"))
                errorsCount++;
            clickOnElement(cancelBtn);
        }
        if (!isElementDisplayedOnPage(showTableViewBtn, "Show Table View button")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
