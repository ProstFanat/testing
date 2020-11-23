package logic.widgets;

import logic.BasePage;
import logic.pages.*;
import logic.pages.cashControl.CashControlPage;
import logic.pages.clientVantagePoint.ClientVintagePointPage;
import logic.pages.companyProfile.*;
import logic.pages.companyProfile.assets.AssetsPage;
import logic.pages.companyProfile.departments.DepartmentsPage;
import logic.pages.companyProfile.drivers.DriversPage;
import logic.pages.companyProfile.drivers.ProfilesTab;
import logic.pages.companyProfile.drivers.driverInfo.PaymentPage;
import logic.pages.companyProfile.gpsDevices.GPSDevicePage;
import logic.pages.companyProfile.options.OptionsPage;
import logic.pages.companyProfile.store.StorePage;
import logic.pages.companyProfile.userManagement.UserManagementPage;
import logic.pages.eManifest.EManifestPage;
import logic.pages.fuelControl.FuelControlPage;
import logic.pages.orderTripPlanner.OrderTripPlannerPage;
import logic.pages.priceCalculator.PriceCalculatorPage;
import logic.pages.reports.ReportsPage;
import logic.variables.Accounts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends BasePage {
    @FindBy(xpath = "//*[@id='company-profile-dropdown']")
    private WebElement companyProfileBar;
    @FindBy(css = "a[is-permitted-for='read.ASSETS-MAP']")
    private WebElement assetsMapBtn;
    @FindBy(css = "a[is-permitted-for='read.OPERATIONS-BOARD']")
    private WebElement operationsBoard;
    @FindBy(css = "a[is-permitted-for='read.CLIENT-VANTAGE-POINT']")
    private WebElement clientVantagePoint;
    @FindBy(css = "a[is-permitted-for='read.TRIGGER']")
    private WebElement triggers;
    @FindBy(css = "a[is-permitted-for='read.DISPATCH-CONTRACTS']")
    private WebElement dispatchContracts;
    @FindBy(css = "a[is-permitted-for='read.INVOICES']")
    private WebElement invoices;
    @FindBy(css = "a[is-permitted-for='read.TRIP-DOCUMENTS']")
    private WebElement tripDocuments;
    @FindBy(css = "a[is-permitted-for='read.REPORT']")
    private WebElement reports;
    @FindBy(css = "a[is-permitted-for='read.ORDER-TRIP-PLANNER']")
    private WebElement orderTripPlanner;
    @FindBy(css = "a[is-permitted-for='read.PRICE-CALCULATOR']")
    private WebElement priceCalculator;
    @FindBy(css = "a[is-permitted-for='read.FUEL-CONTROL']")
    private WebElement fuelControl;
    @FindBy(css = "a[is-permitted-for='read.FLEET-CUSTOMERS']")
    private WebElement fleetCustomers;
    @FindBy(css = "a[is-permitted-for='read.TRIP-BOARD']")
    private WebElement tripBoard;
    @FindBy(css = "a[is-permitted-for='read.FLEET-EVENTS']")
    private WebElement fleetEvents;
    @FindBy(css = "a[is-permitted-for='read.MESSAGING']")
    private WebElement messaging;
    @FindBy(css = "a[is-permitted-for='read.ASSETS']")
    private WebElement maintenance;
    @FindBy (css = "a[is-permitted-for='read.CASH-CONTROL']")
    private WebElement cashControl;
    @FindBy (css = "a[is-permitted-for='read.E-MANIFEST']")
    private WebElement eManifest;
    @FindBy (css = "a[is-permitted-for='read.ADDRESS-BOOK']")
    private WebElement addressBook;
    @FindBy (css = "a[is-permitted-for='read.DASHBOARD']")
    private WebElement dashboard;

    public NavigationBar() {
        super();
        if (Accounts.getCompanyForLogin().equals("Test with DM"))
            clickOnFullScreenButton();
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        return false;
    }
    public void clickOnFullScreenButton(){
        clickOnElement(driver.findElement(By.cssSelector("button[uib-tooltip='Toggle fullscreen mode']")));
    }
    public AssetsMapPage navigateToAssetsMapPage(){
        clickOnElement(assetsMapBtn);
        return new AssetsMapPage();
    }
    public OperationsPage navigateToOperationsPage(){
        clickOnElement(operationsBoard);
        return new OperationsPage();
    }
    public ClientVintagePointPage navigateToClientVintagePointPage(){
        clickOnElement(clientVantagePoint);
        return new ClientVintagePointPage();
    }
    public TriggersPage navigateToTriggersPage(){
        clickOnElement(triggers);
        return new TriggersPage();
    }
    public DispatchContractsPage navigateToDispatchContractsPage(){
        clickOnElement(dispatchContracts);
        return new DispatchContractsPage();
    }
    public InvoicesPage navigateToInvoicesPage(){
        clickOnElement(invoices);
        return new InvoicesPage();
    }
    public TripDocumentsPage navigateToTripDocumentsPage(){
        clickOnElement(tripDocuments);
        return new TripDocumentsPage();
    }
    public ReportsPage navigateToReportsPage(){
        clickOnElement(reports);
        return new ReportsPage();
    }
    public OrderTripPlannerPage navigateToOrderTripPlannerPage(){
        clickOnElement(orderTripPlanner);
        return new OrderTripPlannerPage();
    }
    public PriceCalculatorPage navigateToPriceCalculatorPage(){
        clickOnElement(priceCalculator);
        return new PriceCalculatorPage();
    }
    public AddressBookPage navigateToAddressBookPage(){
        clickOnElement(addressBook);
        return new AddressBookPage();
    }
    public DashboardPage navigateToDashboardPage(){
        clickOnElement(dashboard);
        return new DashboardPage();
    }
    public FuelControlPage navigateToFuelControlPage(){
        clickOnElement(fuelControl);
        return new FuelControlPage();
    }
    public FleetCustomersPage navigateToFleetCustomersPage(){
        clickOnElement(fleetCustomers);
        return new FleetCustomersPage();
    }
    public TripBoardPage navigateToTripBoardPage(){
        clickOnElement(tripBoard);
        return new TripBoardPage();
    }
    public FleetEventsPage navigateToFleetEventsPage(){
        clickOnElement(fleetEvents);
        return new FleetEventsPage();
    }

    public CashControlPage navigateToCashControlPage(){
        clickOnElement(cashControl);
        return new CashControlPage();
    }
    public MessagingPage navigateToMessagingPage(){
        clickOnElement(messaging);
        return new MessagingPage();
    }
    public EManifestPage navigateEManifestPage(){
        clickOnElement(eManifest);
        return new EManifestPage();
    }
    public MaintenancePage navigateToMaintenancePage(){
        clickOnElement(maintenance);
        return new MaintenancePage();
    }
    private void navigateToCompanyProfile(String goTo) {
        waitToBeClickable(20, companyProfileBar);
        Actions action = new Actions(driver);
        action.moveToElement(companyProfileBar);
        action.perform();
        WebElement cp = driver.findElement(By.xpath("//a[contains(text(),'" + goTo + "')]"));
        cp.click();
    }

    public DriversPage goToDriversPage() {
        navigateToCompanyProfile("Drivers");
        return new DriversPage();
    }

    public GeneralPage goToGeneralPage() {
        navigateToCompanyProfile("General");
        return new GeneralPage();
    }
    public AssetsPage goToAssetsPage() {
        navigateToCompanyProfile("Assets");
        return new AssetsPage();
    }

    public GPSDevicePage goToGPSDevice() {
        navigateToCompanyProfile("GPS Devices");
        return new GPSDevicePage();
    }
    public DepartmentsPage goToDepartments() {
        navigateToCompanyProfile("Departments");
        return new DepartmentsPage();
    }
    public WallManagementPage goToWallManagement() {
        navigateToCompanyProfile("Wall Management");
        return new WallManagementPage();
    }
    public DataProvidersPage goToDataProviders() {
        navigateToCompanyProfile("Data Providers");
        return new DataProvidersPage();
    }
    public DataConsumersPage goToDataConsumers() {
        navigateToCompanyProfile("Data Consumers");
        return new DataConsumersPage();
    }
    public UserManagementPage goToUserManagement() {
        navigateToCompanyProfile("User Management");
        return new UserManagementPage();
    }
    public OptionsPage goToOptions() {
        navigateToCompanyProfile("Options");
        return new OptionsPage();
    }
    public AddressBookPage goToAddressBookFromCP() {
        navigateToCompanyProfile("Address Book");
        return new AddressBookPage();
    }
    public DispatchersPage goToDispatchers() {
        navigateToCompanyProfile("Dispatchers");
        return new DispatchersPage();
    }
    public StorePage goToStore() {
        navigateToCompanyProfile("Store");
        return new StorePage();
    }
    public PaymentPage goToPayment() {
        navigateToCompanyProfile("Payments");
        return new PaymentPage();
    }

}
