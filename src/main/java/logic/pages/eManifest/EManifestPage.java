package logic.pages.eManifest;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EManifestPage extends BasePage {
    @FindBy(linkText = "Shipments")
    private WebElement shipmentsTab;
    @FindBy(linkText = "e-Manifests")
    private WebElement eManifestsTab;
    @FindBy(linkText = "Customs Brokers")
    private WebElement customsBrokersTab;
    @FindBy(linkText = "History")
    private WebElement historyTab;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        PdfReport.createNewSubAnchor("Shipments Tab");
        if (!goToShipmentsTab().isAllRequiredElementsPresent()) errorsCount++;

        PdfReport.createNewSubAnchor("E-Manifests Tab");
        if (!goToEManifestsTab().isAllRequiredElementsPresent()) errorsCount++;

        PdfReport.createNewSubAnchor("Customs Brokers Tab");
        if (!goToCustomsBrokersTab().isAllRequiredElementsPresent()) errorsCount++;

        PdfReport.createNewSubAnchor("History Tab");
        if (!goToHistoryTab().isAllRequiredElementsPresent()) errorsCount++;

        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }

    public ShipmentsTab goToShipmentsTab() {
        clickOnElement(shipmentsTab);
        return new ShipmentsTab();
    }

    public EManifestsTab goToEManifestsTab() {
        clickOnElement(eManifestsTab);
        return new EManifestsTab();
    }

    public CustomsBrokersTab goToCustomsBrokersTab() {
        clickOnElement(customsBrokersTab);
        return new CustomsBrokersTab();
    }

    public HistoryTab goToHistoryTab() {
        clickOnElement(historyTab);
        return new HistoryTab();
    }
}
