package gpsDevices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;

public class TabProfiles extends BasePage {
    public TabProfiles(WebDriver driver) {
        super(driver);
    }

    /** Find Button New Usage profile*/
    @FindBy(xpath = "//button[text() = 'New Usage Profile']")
    public WebElement btnCreateNewProfile;

    public void openCreateNewProfile(){
        btnCreateNewProfile.click();
    }

    /** Find Button Advanced search*/
    @FindBy(xpath = "//*[contains(text(),  'Advanced Search')]")
    public WebElement btnAdvancedSearch;

    /** Find input profile name*/
    @FindBy(xpath = "//input[@placeholder = 'Profile Name']")
    public WebElement profileNameInput;

    /** Find Button Filter*/
    @FindBy(xpath = "//button[text() = 'Filter']")
    public WebElement btnFilter;

    /** Find Button Actions*/
    @FindBy(xpath = "//button[text() = 'Actions ']")
    public WebElement btnActions;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Working with table*/

    /** Find Profile Name*/
    @FindBy(xpath = "//*[@container-id = 'side']//*[@role = 'gridcell']")
    public WebElement profileName;


    public String getValueProfileName(){
        return profileName.getText();
    }

    /** Find Server Timeout*/
    @FindBy(xpath = "//*[@container-id = \"'body'\"]//*[@role = 'gridcell'][1]")
    public WebElement serverTimeout;

    public String getValueServerTimeout(){
        return serverTimeout.getText();
    }

    /** Find LTE Timeout*/
    @FindBy(xpath = "//*[@container-id = \"'body'\"]//*[@role = 'gridcell'][2]")
    public WebElement lteTimeout;

    public String getValueLteTimeout(){
        return lteTimeout.getText();
    }

    /** Find Sleep Seconds*/
    @FindBy(xpath = "//*[@container-id = \"'body'\"]//*[@role = 'gridcell'][3]")
    public WebElement sleepSeconds;

    public String getValueSleepSeconds(){
        return sleepSeconds.getText();
    }

    /** Find Sleep GPS On*/
    @FindBy(xpath = "//*[@container-id = \"'body'\"]//*[@role = 'gridcell'][4]")
    public WebElement sleepGpsOn;

    public String getValueSleepGPSOn(){
        return sleepGpsOn.getText();
    }

    /** Find TEmp Alert Enabled*/
    @FindBy(xpath = "//*[@container-id = \"'body'\"]//*[@role = 'gridcell'][5]")
    public WebElement tempAlertEnabled;

    public String getValueTempAlertEnabled(){
        return tempAlertEnabled.getText();
    }

    /** Find TEmp Alert low*/
    @FindBy(xpath = "//*[@container-id = \"'body'\"]//*[@role = 'gridcell'][6]")
    public WebElement tempAlertLow;

    public String getValueTempAlertLow(){
        return tempAlertLow.getText();
    }

    /** Find TEmp Alert high*/
    @FindBy(xpath = "//*[@container-id = \"'body'\"]//*[@role = 'gridcell'][7]")
    public WebElement tempAlertHigh;

    public String getValueTempAlertHigh(){
        return tempAlertHigh.getText();
    }

    /** Find Acc Alert Enabled*/
    @FindBy(xpath = "//*[@container-id = \"'body'\"]//*[@role = 'gridcell'][8]")
    public WebElement accAlertEnabled;

    public String getValueAccAlertEnabled(){
        return accAlertEnabled.getText();
    }

    /** Find Acc Alert Threshold*/
    @FindBy(xpath = "//*[@container-id = \"'body'\"]//*[@role = 'gridcell'][9]")
    public WebElement accAlertThreshold;

    public String getValueAccAlertThreshold(){
        return accAlertThreshold.getText();
    }

    /** Find Acc Alert Duration*/
    @FindBy(xpath = "//*[@container-id = \"'body'\"]//*[@role = 'gridcell'][10]")
    public WebElement accAlertDuration;

    public String getValueAccAlertDuration(){
        return accAlertDuration.getText();
    }

    /** Find Ruuvi Mac*/
    @FindBy(xpath = "//*[@container-id = \"'body'\"]//*[@role = 'gridcell'][11]")
    public WebElement ruuviMac;

    public String getValueRuuviMac(){
        return ruuviMac.getText();
    }

    /** Find Ruuvi Timeout*/
    @FindBy(xpath = "//*[@container-id = \"'body'\"]//*[@role = 'gridcell'][12]")
    public WebElement ruuviTimeout;

    public String getValueRuuviTimeout(){
        return ruuviTimeout.getText();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void filterTable(String name){
        waitToVisibilityOf(10,btnAdvancedSearch);
        waitToBeClickable(10,btnAdvancedSearch);
        if(!(profileNameInput.isDisplayed())){
            btnAdvancedSearch.click();
        }
        profileNameInput.clear();
        profileNameInput.sendKeys(name);
        btnFilter.click();
    }

    /** Find Button Update*/
    @FindBy(xpath = "//*[text() = ' Update']")
    public WebElement btnUpdate;

    public void updateProfile(String profileName){
        if(!(profileNameInput.isDisplayed())){
            btnAdvancedSearch.click();
        }
        profileNameInput.clear();
        profileNameInput.sendKeys(profileName);
        btnFilter.click();
        btnActions.click();
        btnUpdate.click();
    }

    /** Find Button delete*/
    @FindBy(xpath = "//*[text() = ' Delete']")
    public WebElement btnDelete;

    public void deleteProfile(String profileName){
        if(!(profileNameInput.isDisplayed())){
            btnAdvancedSearch.click();
        }
        profileNameInput.clear();
        profileNameInput.sendKeys(profileName);
        btnFilter.click();
        btnActions.click();
        btnDelete.click();
    }

    /** Find btn OK*/
    @FindBy(xpath = "//button[contains(text(), 'Ok')]")
    public WebElement btnOk;

    public void confirmDelete(){
        waitToVisibilityOf(10, btnOk);
        btnOk.click();
    }

    /** Find cancel btn*/
    @FindBy(xpath = "//button[contains(text(), 'Cancel')]")
    public WebElement btnCancel;

    public void cancelDelete(){
        waitToVisibilityOf(10, btnCancel);
        btnCancel.click();
    }

}
