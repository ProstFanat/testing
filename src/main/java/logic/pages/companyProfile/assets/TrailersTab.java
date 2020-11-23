package logic.pages.companyProfile.assets;

import logic.report.PdfReport;
import logic.widgets.TagsWidget;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class TrailersTab extends AssetsPage {
    @FindBy(css = "button[ng-click='vm.clickedAddTrailer()']")
    private WebElement addNewTrailerBtn;
    @FindBy(css = "input[placeholder='Trailer Number']")
    private WebElement trailerNumberFilterField;
    @FindBy(css = "a[uib-tooltip='Update']")
    private WebElement updateTrailerProfileBtn;
    @FindBy(name = "trailerStatus")
    private WebElement statusFilterSelect;
    @FindBy(css = "input[ng-model='vm.selectedVin']")
    private WebElement vinNumberField;
    @FindBy(css = "input[ng-model='vm.selectedLicensePlate']")
    private WebElement licensePlateField;
    @FindBy(css = "oi-select[ng-model='vm.selectedTrailerTagIds']")
    private WebElement tagsField;
    @FindBy(id = "trailer-list-table")
    private WebElement trailerListTable;
    private final String pathToTrailerNumInGrid = "//div[1]/div/div[2]/div/a";

    public TrailersTab() {
        super();
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(trailerNumberFilterField, "Trailer Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(statusFilterSelect, "Status field")) errorsCount++;
        if (!isElementDisplayedOnPage(vinNumberField, "VIN field")) errorsCount++;
        if (!isElementDisplayedOnPage(licensePlateField, "License Plate field")) errorsCount++;
        if (!isElementDisplayedOnPage(tagsField, "Tags field")) errorsCount++;
        if (!isElementDisplayedOnPage(trailerListTable, "Trailer List table")) errorsCount++;
        if (!isElementDisplayedOnPage(addNewTrailerBtn, "Add New Trailer button")) errorsCount++;
        else {
            PdfReport.createNewSubAnchorNotBold("Add New Trailer modal");
            if (!clickOnAddNewTrailerBtn().isAllRequiredElementsPresent()) errorsCount++;
        }
        if (!new TagsWidget().isAllRequiredElementsPresent()) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }

    public AddAndEditTrailerModal clickOnAddNewTrailerBtn() {
        waitToVisibilityOf(10, addNewTrailerBtn);
        addNewTrailerBtn.click();
        return new AddAndEditTrailerModal();
    }

    public TrailersTab findTrailer(String trailerNumber, String trailerStatus) {
        if (!statusFilterSelect.getText().equals(trailerStatus)) {
            super.selectItemInSelector(statusFilterSelect, trailerStatus, "Trailer Status", "div");
        }
        super.findItemByFilterInGrid(trailerNumberFilterField, trailerNumber, "Trailer Number");
        return this;
    }

    public AddAndEditTrailerModal openEditTrailerProfile() {
        waitToBeClickable(10, updateTrailerProfileBtn);
        updateTrailerProfileBtn.click();
        return new AddAndEditTrailerModal();
    }
}
