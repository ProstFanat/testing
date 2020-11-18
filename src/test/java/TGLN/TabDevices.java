package TGLN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;

import java.util.List;

public class TabDevices extends BasePage {

    public TabDevices(WebDriver driver) {
        super(driver);
    }

    /** Найти кнопку New GPS Device*/
    @FindBy(xpath = "//button[text() = 'New GPS Device']")
    public WebElement btnNewDevice;

    public void openNewDeviceForm(){
        waitToVisibilityOf(10, btnNewDevice);
        btnNewDevice.click();
    }

    /** Найти кнопку Advanced Search*/
    @FindBy(xpath = "//button[contains(text(), 'Advanced Search')]")
    public WebElement btnAdvancedSearch;

    /** Найти кнопку filter*/
    @FindBy(xpath = "//button[contains(text(), 'Filter')]")
    public WebElement btnFilter;

    /** Найти инпут для поиска*/
    @FindBy(xpath = "//input[@placeholder ='Name/Device UID']")
    public WebElement deviceUIDFilter;

    public void filterTable(String name){
        if(!(deviceUIDFilter.isDisplayed())){
            btnAdvancedSearch.click();
        }
        waitToVisibilityOf(10,deviceUIDFilter);
        deviceUIDFilter.clear();
        deviceUIDFilter.sendKeys(name);
        waitToBeClickable(10, btnFilter);
        btnFilter.click();
        sleep(500);
    }

    /** Find select of Types*/
    @FindBy(xpath = "//select[@ng-model = 'vm.filter.gpsDeviceType']")
    public WebElement selectOfTypes;

    /** Find TrackEnsure Type*/
    @FindBy(xpath = "//option[@label = 'TrackEnsure GPS Device']")
    public WebElement trackEnsureGPSDevices;

    /** Find Telitek Type*/
    @FindBy(xpath = "//option[@label = 'Telitek GPS Device']")
    public WebElement telitekGPSDevices;

    /** Find All Types*/
    @FindBy(xpath = "//option[@label = 'All']")
    public WebElement allGPSDevices;

    public void selectAllGPSDevices(){
        selectOfTypes.click();
        waitToVisibilityOf(10, allGPSDevices);
        allGPSDevices.click();
        sleep(1000);
    }

    public void selectTrackEnsureGPSDevices(){
        selectOfTypes.click();
        waitToVisibilityOf(10, trackEnsureGPSDevices);
        trackEnsureGPSDevices.click();
        sleep(1000);
    }

    public void selectTelitekGPSDevices(){
        selectOfTypes.click();
        waitToVisibilityOf(10, telitekGPSDevices);
        telitekGPSDevices.click();
        sleep(1000);
    }

    /** Find table devices*/
    @FindBy(xpath = "//*[@ng-style = 'colContainer.getViewportStyle()']//div//div[@ng-style ='Viewport.rowStyle(rowRenderIndex)']")
    public List<WebElement> tableDevices;

    public int getTableDevicesSize(){
        return tableDevices.size()/3;
    }

    /** Find Actions Button*/
    @FindBy(xpath = "//*[@id = 'single-button']")
    public WebElement btnActions;

    /** Find Update Button*/
    @FindBy(xpath = "//*[@is-permitted-for = 'update.GPS-DEVICES' ]//*[text() = ' Update']")
    public WebElement btnUpdateDevice;

    /** Find button Save Edit device*/
    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    public WebElement btnSaveEdit;

    /** Find button cancel Edit*/
    @FindBy(xpath = "//button[text() = 'Cancel']")
    public WebElement btnCancelEdit;

    /** Find Delete Button*/
    @FindBy(xpath = "//*[@is-permitted-for = 'update.GPS-DEVICES' ]//*[text() = ' Deactivate']")
    public WebElement btnDeleteDevice;

    /** Find Confirm Delete*/
    @FindBy(xpath = "//button[contains(text(), 'Ok')]")
    public WebElement btnOkDelete;

    public void confirmDelete(){
        btnOkDelete.click();
    }

    /** Find Cancel Delete*/
    @FindBy(xpath = "//button[contains(text(), 'Cancel')]")
    public WebElement btnCancelDelete;

    public void cancelDelete(){
        btnCancelDelete.click();
    }

    /** Find Monitor Button*/
    @FindBy(xpath = "//*[text() = ' Monitor']")
    public WebElement btnMonitorDevice;

    public void openEditForDevice(int i){
        driver.findElement(By.xpath("//*[text() = 'Actions ']//..//..//..//..//..//div[" + i + "]//button")).click();
        waitToVisibilityOf(10,btnUpdateDevice);
        btnUpdateDevice.click();
    }

    public void deleteDevice(int i){
        driver.findElement(By.xpath("//*[text() = 'Actions ']//..//..//..//..//..//div[" + i + "]//button")).click();
        waitToVisibilityOf(10, btnDeleteDevice);
        btnDeleteDevice.click();
    }

    /** Find select of Devices*/
    @FindBy(xpath = "//*[@ng-model='vm.filter.active']")
    public WebElement selectOfDevices;

    /** Find active Type All*/
    @FindBy(xpath = "//option[@label = 'all']")
    public WebElement allDevices;

    /** Find active Type active*/
    @FindBy(xpath = "//option[@label = 'active']")
    public WebElement activeDevices;

    /** Find active Type inactive*/
    @FindBy(xpath = "//option[@label = 'inactive']")
    public WebElement inactiveDevices;

    public void selectAllDevices(){
        if(!(deviceUIDFilter.isDisplayed())){
            btnAdvancedSearch.click();
        }
        selectOfDevices.click();
        waitToVisibilityOf(10, allDevices);
        allDevices.click();
        btnFilter.click();
        sleep(1000);
    }

    public void selectActiveDevices(){
        if(!(deviceUIDFilter.isDisplayed())){
            btnAdvancedSearch.click();
        }
        selectOfDevices.click();
        waitToVisibilityOf(10, activeDevices);
        activeDevices.click();
        btnFilter.click();
        sleep(1000);
    }

    public void selectInactiveDevices(){
        if(!(deviceUIDFilter.isDisplayed())){
            btnAdvancedSearch.click();
        }
        selectOfDevices.click();
        waitToVisibilityOf(10, inactiveDevices);
        inactiveDevices.click();
        btnFilter.click();
        sleep(1000);
    }

    /** Notification icons*/

    @FindBy(xpath = "//*[@uib-tooltip = 'Temperature notifications']")
    public WebElement iconTemperature;

    @FindBy(xpath = "//*[@uib-tooltip = 'Position notifications']")
    public WebElement iconPosition;

    @FindBy(xpath = "//*[@uib-tooltip = 'Voltage notifications']")
    public WebElement iconVoltage;

    @FindBy(xpath = "//*[@uib-tooltip = 'Motion notifications']")
    public WebElement iconMotion;

    @FindBy(xpath = "//*[@uib-tooltip = 'Device error notifications']")
    public WebElement iconDeviceError;

    @FindBy(xpath = "//*[@uib-tooltip = 'Device connectivity notifications']")
    public WebElement iconDeviceConnectivity;

    /** Find Tabs*/

    @FindBy(xpath = "//*[contains(@class, 'nav-tabs')]//*[text() ='Devices']")
    public WebElement devicesTab;

    @FindBy(xpath = "//*[contains(@class, 'nav-tabs')]//*[text() ='Usage Profiles']")
    public WebElement profilesTab;

    @FindBy(xpath = "//*[contains(@class, 'nav-tabs')]//*[text() ='Device Event Notifications']")
    public WebElement notificationsTab;

    public void openDevicesTab(){
        devicesTab.click();
    }

    public void openProfilesTab(){
        waitToVisibilityOf(10, profilesTab);
        waitToBeClickable(10, profilesTab);
        profilesTab.click();
    }

    public void openNotificationsTab(){
        notificationsTab.click();
    }
}
