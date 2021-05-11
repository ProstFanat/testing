package GPSDevices;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import resources.AppConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;
import resources.AppConstants;

import java.util.List;

public class TabNotification extends BasePage {

    public TabNotification(WebDriver driver) {
        super(driver);
    }

    /** Find create Button*/
    @FindBy(xpath = "//button[text()  = 'Create Device Event Notification']")
    public WebElement btnCreateNotification;

    public void createNotification(){
        btnCreateNotification.click();
    }

    /** Найти инпут для поиска*/
    /** Найти кнопку Advanced Search*/
    @FindBy(xpath = "//button[contains(text(), 'Advanced Search')]")
    public WebElement btnAdvancedSearch;

    /** Найти кнопку filter*/
    @FindBy(xpath = "//button[contains(text(), 'Filter')]")
    public WebElement btnFilter;

    @FindBy(xpath = "//input[@placeholder ='Event Type']")
    public WebElement eventTypeNotificationFilter;

    public void filterTableNotification(String name){
        //if(!(eventTypeNotificationFilter.is())) {
            btnAdvancedSearch.click();
        //}
        //waitToVisibilityOf(10,eventTypeNotificationFilter);
        //eventTypeNotificationFilter.clear();
        sleep(500);
        eventTypeNotificationFilter.sendKeys(name);
        eventTypeNotificationFilter.sendKeys(Keys.ENTER);
        waitToBeClickable(10, btnFilter);
        sleep(500);
        btnFilter.click();
        sleep(500);
        btnAdvancedSearch.click();
    }

    /** Find select of Notifications*/
    @FindBy(xpath = "//*[@ng-model='vm.filter.active']")
    public WebElement selectOfNotificationType;

    /** Find active Type All*/
    @FindBy(xpath = "//option[@label = 'all']")
    public WebElement allNotifications;

    /** Find active Type active*/
    @FindBy(xpath = "//option[@label = 'active']")
    public WebElement activeNotification;

    /** Find active Type inactive*/
    @FindBy(xpath = "//option[@label = 'inactive']")
    public WebElement inactiveNotification;

    public void selectAllNotifications(){
        if(!(selectOfNotificationType.isDisplayed())){
            btnAdvancedSearch.click();
        }
        selectOfNotificationType.click();
        waitToVisibilityOf(10, allNotifications);
        allNotifications.click();
        btnFilter.click();
        sleep(1000);
    }

    public void selectActiveNotifications(){
        if(!(selectOfNotificationType.isDisplayed())){
            btnAdvancedSearch.click();
        }
        selectOfNotificationType.click();
        waitToVisibilityOf(10, activeNotification);
        activeNotification.click();
        btnFilter.click();
        sleep(1000);
    }

    public void selectInactiveNotifications(){
        if(!(selectOfNotificationType.isDisplayed())){
            btnAdvancedSearch.click();
        }
        selectOfNotificationType.click();
        waitToVisibilityOf(10, inactiveNotification);
        inactiveNotification.click();
        btnFilter.click();
        sleep(1000);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Working with table*/
    @FindBy(xpath = "//*[@container-id = \"'body'\"]//div[@role = 'rowgroup'][2]//div//*[@role = 'gridcell'][3]")
    public List<WebElement> table;

    public void changeStatus(String sendTo){

        for(int i = 1; i <= table.size(); i++){
            //System.out.println(driver.findElement(By.xpath("//*[@container-id = \"'body'\"]//div[@role = 'rowgroup'][2]//div[" + i + "]//*[@role = 'gridcell'][3]")).getText());
            if(sendTo.equals((driver.findElement(By.xpath("//*[@container-id = \"'body'\"]//div[@role = 'rowgroup'][2]//div[" + i + "]//*[@role = 'gridcell'][3]")).getText()))){
                driver.findElement(By.xpath("//*[@container-id = 'side']//div[@role = 'rowgroup'][2]//div[" + i + "]//button[@id = 'single-button']")).click();
                driver.findElement(By.xpath("//ul[" + i + "]//*[text() = ' Change Status']")).click();
                driver.findElement(By.xpath("//*[contains(text(), 'Ok')]")).click();
            }
        }
    }
}
