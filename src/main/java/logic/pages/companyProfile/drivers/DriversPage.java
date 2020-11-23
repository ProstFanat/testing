package logic.pages.companyProfile.drivers;

import logic.BasePage;
import logic.pages.fuelControl.FuelControlPage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DriversPage extends BasePage {
    @FindBy (linkText = "Profiles")
    private WebElement profileTab;
    @FindBy (linkText = "HOS Summary")
    private WebElement hosSummaryTab;
    @FindBy (linkText = "Driver Communications Type")
    private WebElement driverCommunicationsTypeTab;
    @FindBy (linkText = "Communications")
    private WebElement communicationsTab;
    @FindBy (linkText = "Fuel Purchases")
    private WebElement fuelPurchasesTab;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
       /* PdfReport.createNewSubAnchor("Profiles Tab");
        if (!goToProfilesTab().isAllRequiredElementsPresent()) errorsCount++;*/

        PdfReport.createNewSubAnchor("HOS Summary tab");
        if (!goToHosSummaryTab().isAllRequiredElementsPresent()) errorsCount++;

        PdfReport.createNewSubAnchor("Driver Communications Type tab");
        if (!goToDriverCommunicationsTypeTab().isAllRequiredElementsPresent()) errorsCount++;

        PdfReport.createNewSubAnchor("Communications tab");
        if (!goToCommunicationsTab().isAllRequiredElementsPresent()) errorsCount++;

        PdfReport.createNewSubAnchor("Fuel Purchases tab");
        if (!goToFuelPurchasesTab().isAllRequiredElementsPresent()) errorsCount++;

        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }

    public ProfilesTab goToProfilesTab(){
        clickOnElement(profileTab);
        return new ProfilesTab();
    }
    public CommunicationsTab goToCommunicationsTab(){
        clickOnElement(communicationsTab);
        return new CommunicationsTab();
    }
    public DriverCommunicationsTypeTab goToDriverCommunicationsTypeTab(){
        clickOnElement(driverCommunicationsTypeTab);
        return new DriverCommunicationsTypeTab();
    }
    public FuelPurchasesTab goToFuelPurchasesTab(){
        clickOnElement(fuelPurchasesTab);
        return new FuelPurchasesTab();
    }
    public HosSummaryTab goToHosSummaryTab(){
        clickOnElement(hosSummaryTab);
        return new HosSummaryTab();
    }
}
