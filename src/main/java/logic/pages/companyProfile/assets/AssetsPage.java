package logic.pages.companyProfile.assets;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AssetsPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),'Trucks')]")
    private WebElement trucksTabBtn;
    @FindBy(xpath = "//a[contains(text(),'Trailers')]")
    private WebElement trailersTabBtn;
    @FindBy(xpath = "//a[contains(text(),'Transports')]")
    private WebElement transportsTabBtn;
    @FindBy (partialLinkText = "Asset Parts")
    private WebElement assetPartsTabBtn;
    @FindBy(xpath = "//a[contains(text(),'Maintenance')]")
    private WebElement maintenanceTabBtn;
    @FindBy(xpath = "//a[contains(text(),'Truck Assignment')]")
    private WebElement truckAssignmentTabBtn;
    @FindBy(tagName = "h2")
    private WebElement pageHeader;

    public TrucksTab goToTrucksPage() {
        waitToVisibilityOf(10, trucksTabBtn);
        trucksTabBtn.click();
        return new TrucksTab();
    }

    public TrailersTab goToTrailersPage() {
        waitToVisibilityOf(10, trailersTabBtn);
        trailersTabBtn.click();
        return new TrailersTab();
    }

    public TransportsTab goToTransportsPage() {
        waitToVisibilityOf(10, transportsTabBtn);
        transportsTabBtn.click();
        return new TransportsTab();
    }

    public AssetsPartsTab goToAssetsPartsPage() {
        waitToVisibilityOf(10, assetPartsTabBtn);
        assetPartsTabBtn.click();
        return new AssetsPartsTab();
    }

    public MaintenanceTab goToMaintenancePage() {
        waitToVisibilityOf(10, maintenanceTabBtn);
        maintenanceTabBtn.click();
        return new MaintenanceTab();
    }

    public TruckAssignmentTab goToTruckAssignmentPage() {
        waitToVisibilityOf(10, truckAssignmentTabBtn);
        truckAssignmentTabBtn.click();
        return new TruckAssignmentTab();
    }



    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(60, pageHeader);
        if (!isElementDisplayedOnPage(pageHeader, "Page header")) errorsCount++;

        PdfReport.createNewSubAnchorBold("Trucks tab");
        if (!isElementDisplayedOnPage(trucksTabBtn, "Trucks tab")) errorsCount++;
        else {
            if (!goToTrucksPage().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Trailers tab");
        if (!isElementDisplayedOnPage(trailersTabBtn, "Trailers tab")) errorsCount++;
        else {
            if (!goToTrailersPage().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Transports tab");
        if (!isElementDisplayedOnPage(transportsTabBtn, "Transports tab")) errorsCount++;
        else {
            if (!goToTransportsPage().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Asset Parts / Asset Related Action tab");
        if (!isElementDisplayedOnPage(assetPartsTabBtn, "Asset Parts / Asset Related Action tab")) errorsCount++;
        else {
            if (!goToAssetsPartsPage().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Maintenance tab");
        if (!isElementDisplayedOnPage(maintenanceTabBtn, "Maintenance tab")) errorsCount++;
        else {
            if (!goToMaintenancePage().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Truck Assignment tab");
        if (!isElementDisplayedOnPage(truckAssignmentTabBtn, "Truck Assignment tab")) errorsCount++;
        else {
            if (!goToTruckAssignmentPage().isAllRequiredElementsPresent()) errorsCount++;
        }
        return errorsCount == 0;
    }
}
