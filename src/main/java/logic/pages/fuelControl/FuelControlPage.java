package logic.pages.fuelControl;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FuelControlPage extends BasePage {
    @FindBy(tagName = "h2")
    private WebElement pageHeader;
    @FindBy(linkText = "Fuel Cards")
    private WebElement fuelCardTab;
    @FindBy(linkText = "Fuel Card History")
    private WebElement fuelCardHistoryTab;
    @FindBy(linkText = "Fuel Card Request")
    private WebElement fuelCardRequestTab;
    @FindBy(linkText = "Fuel Prices")
    private WebElement fuelPricesTab;
    @FindBy(linkText = "Fuel Stations")
    private WebElement fuelStationsTab;
    @FindBy(linkText = "Fuel Discount Scheme")
    private WebElement fuelDiscountSchemeTab;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(60, pageHeader);
        if (!isElementDisplayedOnPage(pageHeader, "Page header")) errorsCount++;

        PdfReport.createNewSubAnchorBold("Fuel Cards tab");
        if (!isElementDisplayedOnPage(fuelCardTab, "Fuel Cards tab")) errorsCount++;
        else {
            clickOnElement(fuelCardTab);
            if (!goToFuelCardsTab().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Fuel Card History Tab");
        if (!isElementDisplayedOnPage(fuelCardHistoryTab, "Fuel Card History tab")) errorsCount++;
        else {
            clickOnElement(fuelCardHistoryTab);
            if (!goToFuelCardsHistoryTab().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Fuel Card Request Tab");
        if (!isElementDisplayedOnPage(fuelCardRequestTab, "Fuel Card Request Tab")) errorsCount++;
        else {
            clickOnElement(fuelCardRequestTab);
            if (!goToFuelCardRequestTab().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Fuel Prices tab");
        if (!isElementDisplayedOnPage(fuelPricesTab, "Fuel Prices Tab")) errorsCount++;
        else {
            clickOnElement(fuelPricesTab);
            if (!goToFuelPricesTab().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Fuel Stations Tab");
        if (!isElementDisplayedOnPage(fuelStationsTab, "Fuel Stations Tab")) errorsCount++;
        else {
            clickOnElement(fuelStationsTab);
            if (!goToFuelStationsTab().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Fuel Discount Scheme Tab");
        if (!isElementDisplayedOnPage(fuelDiscountSchemeTab, "Fuel Discount Scheme Tab")) errorsCount++;
        else {
            clickOnElement(fuelDiscountSchemeTab);
            if (!goToFuelDiscountSchemeTab().isAllRequiredElementsPresent()) errorsCount++;
        }
        return errorsCount == 0;
    }

    public FuelCardsTab goToFuelCardsTab() {
        clickOnElement(fuelCardTab);
        return new FuelCardsTab();
    }

    public FuelCardHistoryTab goToFuelCardsHistoryTab() {
        clickOnElement(fuelCardHistoryTab);
        return new FuelCardHistoryTab();
    }

    public FuelCardRequestTab goToFuelCardRequestTab() {
        clickOnElement(fuelCardRequestTab);
        return new FuelCardRequestTab();
    }

    public FuelPricesTab goToFuelPricesTab() {
        clickOnElement(fuelPricesTab);
        return new FuelPricesTab();
    }

    public FuelStationsTab goToFuelStationsTab() {
        clickOnElement(fuelStationsTab);
        return new FuelStationsTab();
    }

    public FuelDiscountSchemeTab goToFuelDiscountSchemeTab() {
        clickOnElement(fuelDiscountSchemeTab);
        return new FuelDiscountSchemeTab();
    }
}
