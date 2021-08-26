package dispatcherManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;

import java.util.List;

public class dispatcherList extends BasePage {
    public dispatcherList(WebDriver driver) {
        super(driver);
    }

    /** Find List Tab*/
    @FindBy(xpath = "//*[text() = 'Dispatcher List']")
    public WebElement tabList;

    public void openTabList(){
        waitToVisibilityOf(10, tabList);
        waitToBeClickable(10, tabList);
        tabList.click();
    }

    /** Find Monitor Tab*/
    @FindBy(xpath = "//*[text() = 'Dispatcher Monitor']")
    public WebElement tabMonitor;

    public void openTabMonitor(){
        waitToVisibilityOf(10, tabMonitor);
        waitToBeClickable(10, tabMonitor);
        tabMonitor.click();
    }

    /** Find Button Add New Dispatcher*/
    @FindBy(xpath = "//*[@ng-click = 'vm.addDispatcher()']")
    public WebElement btnAddNewDispatcher;

    public void openFormAddNewDispatcher(){
        waitToVisibilityOf(10, btnAddNewDispatcher);
        waitToBeClickable(10, btnAddNewDispatcher);
        btnAddNewDispatcher.click();
    }

    /** Find input Dispatcher Name*/
    @FindBy(xpath = "//input[@placeholder = 'Dispatcher Name']")
    public WebElement inputDispatcherName;

    /** Find input Button Save*/
    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    public WebElement btnSave;

    /** Find input Button Cancel*/
    @FindBy(xpath = "//button[contains(text(), 'Cancel')]")
    public WebElement btnCancel;

    public void createNewDispatcher(String name){
        openFormAddNewDispatcher();
        waitToVisibilityOf(10, inputDispatcherName);
        inputDispatcherName.sendKeys(name);
        btnSave.click();
    }

    /** Find Input Search Dispatcher*/
    @FindBy(xpath = "//input[@placeholder = 'Search dispatcher...']")
    public WebElement searchDispatcher;

    public void inputSearchDispatcher(String dispatcher){
        waitToVisibilityOf(10, searchDispatcher);
        searchDispatcher.clear();
        searchDispatcher.sendKeys(dispatcher);
    }

    /** Find btn Update Dispatcher*/
    @FindBy(xpath = "//*[@uib-tooltip = 'Update']")
    public WebElement btnUpdateDispatcher;

    public void openFormUpdate(String dispatcher){
        inputSearchDispatcher(dispatcher);
        sleep(200);
        waitToVisibilityOf(10, btnUpdateDispatcher);
        waitToBeClickable(10, btnUpdateDispatcher);
        btnUpdateDispatcher.click();
    }

    public void updateDispatcher(String innerName, String newName){
        openFormUpdate(innerName);
        waitToVisibilityOf(10, inputDispatcherName);
        inputDispatcherName.clear();
        inputDispatcherName.sendKeys(newName);
        btnSave.click();
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //     ACL USEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEER
    /** Find btn add ACL user*/
    @FindBy(xpath = "//*[@uib-tooltip = 'Add ACL user']")
    public WebElement btnAddACLUser;

    public void openFormBtnACLUser(String dispatcher){
        inputSearchDispatcher(dispatcher);
        waitToVisibilityOf(10, btnAddACLUser);
        waitToBeClickable(10, btnAddACLUser);
        btnAddACLUser.click();
    }

    /** Find First Name input*/
    @FindBy(xpath = "//input[@ng-model = 'vm.user.firstName']")
    public WebElement aclFirstName;

    /** Find Last Name input*/
    @FindBy(xpath = "//input[@ng-model = 'vm.user.lastName']")
    public WebElement aclLastName;

    /** Find Email Name input*/
    @FindBy(xpath = "//input[@ng-model = 'vm.user.loginName']")
    public WebElement aclEmail;

    /** Find Password Name input*/
    @FindBy(xpath = "//input[@ng-model = 'vm.user.password']")
    public WebElement aclPassword;

    public void inputAclFirstname(String firstname){
        waitToVisibilityOf(10, aclFirstName);
        waitToVisibilityOf(10, aclFirstName);
        aclFirstName.sendKeys(firstname);
    }

    public void inputAclLastName(String lastname){
        waitToVisibilityOf(10, aclLastName);
        waitToVisibilityOf(10, aclLastName);
        aclLastName.sendKeys(lastname);
    }

    public void inputAclEmail(String email){
        waitToVisibilityOf(10, aclEmail);
        waitToVisibilityOf(10, aclEmail);
        aclEmail.sendKeys(email);
    }

    public void inputAclPassword(String password){
        waitToVisibilityOf(10, aclPassword);
        waitToVisibilityOf(10, aclPassword);
        aclPassword.sendKeys(password);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // TABLEEEEEEEEE

    /** Find table*/
    @FindBy(xpath = "//*[@role = 'rowgroup'][2]//div//div//*[@role = 'row']//div[@role = 'gridcell'][2]")
    public List<WebElement> table;

    /** Find Name cell*/
    @FindBy(xpath = "//*[@role = 'rowgroup'][2]//div//div[1]//*[@role = 'row']//div[@role = 'gridcell'][1]")
    public WebElement name;

}
