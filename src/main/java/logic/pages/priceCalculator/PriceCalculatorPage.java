package logic.pages.priceCalculator;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PriceCalculatorPage extends BasePage {
    @FindBy(tagName = "h2")
    private WebElement pageHeader;
    @FindBy(linkText = "Calculator")
    private WebElement calculatorTab;
    @FindBy(linkText = "Zones")
    private WebElement zonesTab;
    @FindBy(linkText = "Cargo Profiles")
    private WebElement cargoProfilesTab;
    @FindBy(linkText = "Price Cards")
    private WebElement priceCardsTab;
    @FindBy(linkText = "Client Profiles")
    private WebElement clientProfilesTab;
    @FindBy(linkText = "Contractor")
    private WebElement contractorTab;

    public CalculatorPage navigateToCalculatorPage() {
        clickOnElement(calculatorTab);
        return new CalculatorPage();
    }

    public ZonesPage navigateToZonesPage() {
        clickOnElement(zonesTab);
        return new ZonesPage();
    }

    public CargoProfilesPage navigateToCargoProfilesPage() {
        clickOnElement(cargoProfilesTab);
        return new CargoProfilesPage();
    }

    public PriceCardsPage navigateToPriceCardsPage() {
        clickOnElement(priceCardsTab);
        return new PriceCardsPage();
    }

    public ClientProfilesPage navigateToClientProfilesPage() {
        clickOnElement(clientProfilesTab);
        return new ClientProfilesPage();
    }

    public ContractorPage navigateToContractorPage() {
        clickOnElement(contractorTab);
        return new ContractorPage();
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(60, pageHeader);
        if (!isElementDisplayedOnPage(pageHeader, "Page Header")) errorsCount++;
        PdfReport.createNewSubAnchorBold("Calculator tab");
        if (!checkTextOnElement(pageHeader, "Price Calculator")) errorsCount++;
        if (!isElementDisplayedOnPage(calculatorTab, "Calculator Tab")) errorsCount++;
        else {
            clickOnElement(calculatorTab);
            if (!navigateToCalculatorPage().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Zones Tab");
        if (!isElementDisplayedOnPage(zonesTab, "Zones Tab")) errorsCount++;
        else {
            clickOnElement(zonesTab);
            if (!navigateToZonesPage().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Cargo Profiles Tab");
        if (!isElementDisplayedOnPage(cargoProfilesTab, "Cargo Profiles Tab")) errorsCount++;
        else {
            clickOnElement(cargoProfilesTab);
            if (!navigateToCargoProfilesPage().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Price Cards tab");
        if (!isElementDisplayedOnPage(priceCardsTab, "Price Cards Tab")) errorsCount++;
        else {
            clickOnElement(priceCardsTab);
            if (!navigateToPriceCardsPage().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Client Profile Tab");
        if (!isElementDisplayedOnPage(clientProfilesTab, "Client Profiles Tab")) errorsCount++;
        else {
            clickOnElement(clientProfilesTab);
            if (!navigateToClientProfilesPage().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Contractor Tab");
        if (!isElementDisplayedOnPage(contractorTab, "Contractor Tab")) errorsCount++;
        else {
            clickOnElement(contractorTab);
            if (!navigateToContractorPage().isAllRequiredElementsPresent()) errorsCount++;
        }
        return errorsCount == 0;
    }
}
