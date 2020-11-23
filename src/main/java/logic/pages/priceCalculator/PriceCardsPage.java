package logic.pages.priceCalculator;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceCardsPage extends PriceCalculatorPage {
    @FindBy(css = "input[ng-model='vm.filter.zoneFrom']")
    private WebElement zoneFromField;
    @FindBy(css = "input[ng-model='vm.filter.zoneTo']")
    private WebElement zoneToField;
    @FindBy(css = "button[ng-click='vm.getPriceCardsReport()']")
    private WebElement exportPriceCardsBtn;
    @FindBy(css = "button[ng-click='vm.addPriceModal()']")
    private WebElement addPriceCardBtn;
    @FindBy(id = "pc-add-price-card-origin-autocomplete")
    private WebElement originFieldAddPriceCardModal;
    @FindBy(id = "pc-add-price-card-destinate-autocomplete")
    private WebElement destinateFieldAddPriceCardModal;
    @FindBy(css = "input[ng-model='vm.priceCard.fromZipCode']")
    private WebElement originZipCodeFieldAddPriceCardModal;
    @FindBy(css = "input[ng-model='vm.priceCard.toZipCode']")
    private WebElement destinationZipCodeFieldAddPriceCardModal;
    @FindBy(id = "pc-add-price-card-map-container")
    private WebElement priceCardMapContainerAddPriceCardModal;
    @FindBy(css = "select[ng-model='vm.selectedCargoType']")
    private WebElement selectCargoTypeAddPriceCardModal;
    @FindBy(css = "select[ng-model='vm.priceCard.selectedCargoProfile']")
    private WebElement selectProfileTypeAddPriceCardModal;
    @FindBy(css = "select[ng-model='vm.priceCard.selectedExtraService']")
    private WebElement selectExtraServiceAddPriceCardModal;
    @FindBy(css = "input[ng-model='vm.priceCard.selectedExtraServicePrice']")
    private WebElement extraServicePriceInputAddPriceCardModal;
    @FindBy(id = "extra-service-in-percent")
    private WebElement extraServiceInPercentCheckBoxAddPriceCardModal;
    @FindBy(css = "button[ng-click='vm.addGroupPriceOption()']")
    private WebElement addGroupPriceOptionBtnAddPriceCardModal;
    @FindBy(css = "button[ng-click='vm.addExtraService()']")
    private WebElement addExtraServiceBtnAddPriceCardModal;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelBtnAddPriceCardModal;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(zoneFromField, "Zone From field")) errorsCount++;
        if (!isElementDisplayedOnPage(zoneToField, "Zone To field")) errorsCount++;
        if (!isElementDisplayedOnPage(exportPriceCardsBtn, "Export Price Cards button")) errorsCount++;
        if (!isElementDisplayedOnPage(addPriceCardBtn, "Add Price Card button")) errorsCount++;
        else {
            clickOnElement(addPriceCardBtn);
            PdfReport.createNewSubAnchorBold("Add Price Card modal");
            waitToVisibilityOf(10, originZipCodeFieldAddPriceCardModal);
            if (!isElementDisplayedOnPage(originFieldAddPriceCardModal, "Origin field in Add Price Card modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(originZipCodeFieldAddPriceCardModal, "Origin ZIP Code field in Add Price Card modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(destinateFieldAddPriceCardModal, "Destinate field in Add Price Card modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(destinationZipCodeFieldAddPriceCardModal, "Destinate  ZIP Code field in Add Price Card modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(priceCardMapContainerAddPriceCardModal, "Price Card Map container in Add Price Card modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(selectCargoTypeAddPriceCardModal, "Select Cargo Type field in Add Price Card modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(selectProfileTypeAddPriceCardModal, "Select Cargo Unit field in Add Price Card modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(selectExtraServiceAddPriceCardModal, "Select Extra Services field in Add Price Card modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(extraServicePriceInputAddPriceCardModal, "Price field in Add Price Card modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(extraServiceInPercentCheckBoxAddPriceCardModal, "Extra Service In Percent checkbox in Add Price Card modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(addGroupPriceOptionBtnAddPriceCardModal, "Add Group Price Option button in Add Price Card modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(addExtraServiceBtnAddPriceCardModal, "Add Extra Service button in Add Price Card modal"))
                errorsCount++;
            clickOnElement(cancelBtnAddPriceCardModal);
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
