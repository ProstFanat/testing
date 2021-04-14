package maintenance;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import resources.AppConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;
import resources.AppConstants;

public class addMaintenanceRecordForGroup extends BasePage {

    public WebDriver driver;

    public addMaintenanceRecordForGroup(WebDriver driver) {
        super(driver);
    }

    /** Find button Add Maintenance Record For Group Of Assets */
    @FindBy(xpath = "//button[text() = 'Add Maintenance Record for Group of Assets']")
    public WebElement btnAddMaintenanceGroup;

    public void openAddMaintenanceGroupForm(){
        btnAddMaintenanceGroup.click();
    }

    /** Find part/action input*/
    @FindBy(xpath = "//*[text() = 'Part/Action: ']//..//input")
    public WebElement partActionForm;

    public void inputPartAction(String partAction){
        partActionForm.sendKeys(partAction);
        partActionForm.sendKeys(Keys.ENTER);
    }

    /** Find quantity input*/
    @FindBy(xpath = "//*[text() = 'Quantity: ']//..//input")
    public WebElement quantityForm;

    public void inputQuantity(String quantity){
        quantityForm.sendKeys(quantity);
    }

    /** Find Comment input*/
    @FindBy(xpath = "//*[text() = 'Comment:']//..//textarea")
    public WebElement commentForm;

    public void inputComment(String comment){
        commentForm.sendKeys(comment);
    }

    /** Find btn Add*/
    @FindBy(xpath = "//*[@class = 'modal-footer']//button[contains(text(), 'Add') ]")
    public WebElement btnSaveMaintenance;

    public void addMaintenance(){
        btnSaveMaintenance.click();
    }

    /** Find btn Cancel*/
    @FindBy(xpath = "//*[@class = 'modal-footer']//button[contains(text(), 'Cancel') ]")
    public WebElement btnCancelMaintenance;

    public void cancelAdd(){
        btnCancelMaintenance.click();
    }

    /** Find Truck Tab*/
    @FindBy(xpath = "//*[@class = 'nav nav-tabs']//*[text() = 'Truck']")
    public WebElement truckTab;

    public void openTruckList(){
        truckTab.click();
    }

    /** Find 1 truck from list*/
    @FindBy(xpath = "//*[@class = 'tab-content']//div[contains(@class, 'tab-pane')][1]//*[2]//*[@role = 'rowheader']")
    public WebElement truck1List;

    /** Find 2 truck from list*/
    @FindBy(xpath = "//*[@class = 'tab-content']//div[contains(@class, 'tab-pane')][1]//*[3]//*[@role = 'rowheader']")
    public WebElement truck2List;

    public void selectTruck1(){
        truck1List.click();
    }

    public void selectTruck2(){
        truck2List.click();
    }

    /** Find Trailer Tab*/
    @FindBy(xpath = "//*[@class = 'nav nav-tabs']//*[text() = 'Trailer']")
    public WebElement trailerTab;

    public void openTrailerList(){
        trailerTab.click();
    }

    /** Find 1 trailer from list*/
    @FindBy(xpath = "//*[@class = 'tab-content']//div[contains(@class, 'tab-pane')][2]//*[2]//*[@role = 'rowheader']")
    public WebElement trailer1List;

    /** Find 2 truck from list*/
    @FindBy(xpath = "//*[@class = 'tab-content']//div[contains(@class, 'tab-pane')][2]//*[3]//*[@role = 'rowheader']")
    public WebElement trailer2List;

    public void selectTrailer1(){
        trailer1List.click();
    }

    public void selectTrailer2(){
        trailer2List.click();
    }

    /** Find input filter tag*/
    @FindBy(xpath = "//*[text() = 'Filter by tag']//..//input")
    public WebElement filterTag;

    public void inputTag(String tag){
        filterTag.sendKeys(tag);
        filterTag.sendKeys(Keys.ENTER);
    }
}
