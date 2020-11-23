package logic.pages.companyProfile.assets;

import logic.report.PdfReport;
import logic.widgets.TagsWidget;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class TrucksTab extends AssetsPage {
    @FindBy(css = "button[ng-click='vm.clickedAddTruck()']")
    private WebElement addNewTruckBtn;
    @FindBy(css = "input[placeholder='Truck Number']")
    private WebElement truckNumberField;
    @FindBy(name = "truckStatus")
    private WebElement statusFilterSelect;
    @FindBy(css = "input[placeholder='VIN']")
    private WebElement vinField;
    @FindBy(css = "input[ng-model='vm.filter.licensePlate']")
    private WebElement licensePlateField;
    @FindBy(css = "input[placeholder='Tags']")
    private WebElement tagsField;
    @FindBy(id = "truck-list-table")
    private WebElement truckListTable;


    private final String pathToTruckNumInGrid = "//div[1]/div/div[2]/div/a";

    public TrucksTab() {
        super();
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(truckNumberField, "Truck Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(statusFilterSelect, "Status field")) errorsCount++;
        if (!isElementDisplayedOnPage(vinField, "VIN field")) errorsCount++;
        if (!isElementDisplayedOnPage(licensePlateField, "License Plate field")) errorsCount++;
        if (!isElementDisplayedOnPage(tagsField, "Tags field")) errorsCount++;
        if (!isElementDisplayedOnPage(truckListTable, "Truck List table")) errorsCount++;
        if (!isElementDisplayedOnPage(addNewTruckBtn, "Add New Truck button")) errorsCount++;
        else {
            PdfReport.createNewSubAnchorNotBold("Add New Truck modal");
            if (!clickOnAddNewTruckBtn().isAllRequiredElementsPresent()) errorsCount++;
        }
        if (!new TagsWidget().isAllRequiredElementsPresent()) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }

    public AddAndEditTruckModal clickOnAddNewTruckBtn() {
        waitToVisibilityOf(10, addNewTruckBtn);
        addNewTruckBtn.click();
        return new AddAndEditTruckModal();
    }

    public TrucksTab findTruck(String truckNumber, String truckStatus) {
        if (!statusFilterSelect.getText().equals(truckStatus)) {
            super.selectItemInSelector(statusFilterSelect, truckStatus, "Truck Status", "div");
        }
        super.findItemByFilterInGrid(truckNumberField, truckNumber, "Truck Number");
        return this;
    }

    public AddAndEditTruckModal clickOnTruckNumber(String truckNumber) {
        try {
            super.clickOnItemInGrid(truckNumber, "Truck Number");
            waitToVisibilityOf(20, driver.findElement(By.className("modal-body")));
        } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
            log.error(e);
            clickOnTruckNumber(truckNumber);
        } catch (TimeoutException | NoSuchElementException e) {
            log.error(e);
            fail(e.toString());
        }
        return new AddAndEditTruckModal();
    }
}
