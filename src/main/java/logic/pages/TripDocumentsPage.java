package logic.pages;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TripDocumentsPage extends BasePage {
    @FindBy(tagName = "h2")
    private WebElement pageHeader;
    @FindBy(css = "input[ng-model='vm.selectedDateFrom']")
    private WebElement dateFromField;
    @FindBy(css = "input[ng-model='vm.selectedDateTo']")
    private WebElement dateToField;
    @FindBy(css = "select[ng-model='vm.searchFilter.documentType']")
    private WebElement contextTypeField;
    @FindBy(css = "div[placeholder='Trip Number']")
    private WebElement tripNumberField;
    @FindBy(css = "input[placeholder='Driver Name']")
    private WebElement driverNameField;
    @FindBy(css = "input[placeholder='Truck Number']")
    private WebElement truckNumberField;
    @FindBy(css = "button[ng-click='vm.clickedClearFields()']")
    private WebElement clearBtn;
    @FindBy(css = "button[ng-click='vm.clickedSearchDocuments()']")
    private WebElement searchBtn;
    @FindBy(css = "button[ng-click='vm.clickedAddDocument()']")
    private WebElement addDocumentBtn;
    @FindBy(id = "trip-document-list")
    private WebElement tripDocumentList;
    @FindBy(className = "modal-body")
    private WebElement addTripModal;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelBtn;
    @FindBy (id = "trip-number-list-select")
    private WebElement tripNumberSelectAddTripDocModal;
    @FindBy (css = "oi-select[ng-model='vm.selectedDriver']")
    private WebElement driverNameSelectAddTripDocModal;
    @FindBy (css = "oi-select[ng-model='vm.selectedTruckNumber']")
    private WebElement truckNumberSelectAddTripDocModal;
    @FindBy (css = "select[ng-model='vm.selectedTripDocumentType']")
    private WebElement selectTypeAddTripDocModal;
    @FindBy (css = "textarea[ng-model='vm.commentTripDocument']")
    private WebElement commentFieldAddTripDocModal;
    @FindBy (css = "div[ng-model='vm.droppedFile']")
    private WebElement droppedFileFieldAddTripDocModal;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(60, pageHeader);
        if (!isElementDisplayedOnPage(pageHeader, "Page Header")) errorsCount++;
        if (!checkTextOnElement(pageHeader, "Trip Documents")) errorsCount++;
        if (!isElementDisplayedOnPage(dateFromField, "Date From field")) errorsCount++;
        if (!isElementDisplayedOnPage(dateToField, "Date To field")) errorsCount++;
        if (!isElementDisplayedOnPage(contextTypeField, "Context Type field")) errorsCount++;
        if (!isElementDisplayedOnPage(tripNumberField, "Trip Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(driverNameField, "Driver Name field")) errorsCount++;
        if (!isElementDisplayedOnPage(truckNumberField, "Truck Number field")) errorsCount++;
        if (!isElementDisplayedOnPage(clearBtn, "Clear button")) errorsCount++;
        if (!isElementDisplayedOnPage(searchBtn, "Search button")) errorsCount++;
        if (!isElementDisplayedOnPage(tripDocumentList, "Trip Document list")) errorsCount++;

        if (!isElementDisplayedOnPage(addDocumentBtn, "Add Document button")) errorsCount++;
        else {
            PdfReport.createNewSubAnchorBold("Add Trip Document modal");
            addDocumentBtn.click();
            waitToVisibilityOf(10, addTripModal);
            if (!isElementDisplayedOnPage(addTripModal, "Add Trip form")) errorsCount++;
            if (!isElementDisplayedOnPage(tripNumberSelectAddTripDocModal, "Trip Number select in Add Trip Document Modal")) errorsCount++;
            if (!isElementDisplayedOnPage(driverNameSelectAddTripDocModal, "Driver Name select in Add Trip Document Modal")) errorsCount++;
            if (!isElementDisplayedOnPage(truckNumberSelectAddTripDocModal, "Truck Number select in Add Trip Document Modal")) errorsCount++;
            if (!isElementDisplayedOnPage(selectTypeAddTripDocModal, "Type select in Add Trip Document Modal")) errorsCount++;
            if (!isElementDisplayedOnPage(commentFieldAddTripDocModal, "Comment field in Add Trip Document Modal")) errorsCount++;
            if (!isElementDisplayedOnPage(droppedFileFieldAddTripDocModal, "Drop File area in Add Trip Document Modal")) errorsCount++;
            cancelBtn.click();
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
