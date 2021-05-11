package FleetEvents;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import resources.AppConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;
import resources.AppConstants;

import java.util.List;

public class filterTruckFleet extends BasePage {
    public WebDriver driver;

    public filterTruckFleet(WebDriver driver) {
        super(driver);
    }

    /** Find Advanced search button*/
    @FindBy(xpath = "//button[text() = ' Advanced Search ']")
    public WebElement btnAdvancedSearch;

    public void clickBtnAdvancedSearch(){
        waitToVisibilityOf(10, btnAdvancedSearch);
        btnAdvancedSearch.click();
    }

    /** Find Driver input*/
    @FindBy(xpath = "//*[@placeholder = 'Driver']//input")
    public WebElement driverFilter;

    @FindBy(xpath = "//*[@placeholder = 'Driver']//..//button")
    public WebElement btnFindDriver;

    @FindBy(xpath = "//*[@placeholder = 'Driver']//ng-dropdown-panel")
    public  WebElement driverFromList;

    public void inputDriver(String driver){
        driverFilter.sendKeys(driver);
        waitToVisibilityOf(10, btnFindDriver);
        waitToBeClickable(10, btnFindDriver);
        btnFindDriver.click();
        waitToVisibilityOf(10, driverFromList);
        waitToBeClickable(10,driverFromList);
        driverFromList.click();
    }

    /** Find Order input*/
    @FindBy(xpath = "//*[@placeholder = 'Order']//input")
    public WebElement orderFilter;

    /** Find search Button for order*/
    @FindBy(xpath = "//*[@placeholder = 'Order']//..//button")
    public WebElement btnSearchOrder;

    /** Find order from the list*/
    @FindBy(xpath = "//*[@placeholder = 'Order']//ng-dropdown-panel")
    public WebElement orderFromTheList;

    /** Find Probill input*/
    @FindBy(xpath = "//*[@placeholder = 'Probill']//input")
    public WebElement probillFilter;

    public void inputOrder(String order, String probill){
        waitToVisibilityOf(10, orderFilter);
        waitToBeClickable(10, orderFilter);
        orderFilter.sendKeys(order);
        sleep(500);
        btnSearchOrder.click();
        sleep(500);
        orderFromTheList.click();
        waitToBeClickable(10, probillFilter);
        probillFilter.sendKeys(probill);
        probillFilter.sendKeys(Keys.ENTER);
    }

    public void inputOrderWithoutProbill(String order){
        orderFilter.sendKeys(order);
        btnSearchOrder.click();
        sleep(500);
        orderFromTheList.click();
    }

    /** Find trailer input*/
    @FindBy(xpath = "//*[@placeholder = 'Trailer']//input")
    public WebElement trailerFilter;

    @FindBy(xpath = "//*[@placeholder = 'Trailer']//..//button")
    public WebElement btnFindTrailer;

    @FindBy(xpath = "//*[@placeholder = 'Trailer']//ng-dropdown-panel")
    public  WebElement TrailerFromList;

    public void inputTrailer(String trailer){
        trailerFilter.sendKeys(trailer);
        waitToBeClickable(10, btnFindTrailer);
        btnFindTrailer.click();
        waitToBeClickable(10,TrailerFromList);
        TrailerFromList.click();
    }

    /** Find Date From form*/
    @FindBy(xpath = "//input[@placeholder = 'Date From']")
    public WebElement dateFromFilter;

    /** Find Date To form*/
    @FindBy(xpath = "//input[@placeholder = 'Date To']")
    public WebElement dateToFilter;

    /** Find first date*/
    @FindBy(xpath = "//tbody/tr[2]/td[1]")
    public WebElement firstDate;

    /** Find second date*/
    @FindBy(xpath = "//tbody/tr[2]/td[7]")
    public WebElement secondDate;

    /** Find Set Date Button*/
    @FindBy(xpath = "//button//span[text() = 'Set']")
    public WebElement btnSetDate;

    public void inputStartDate(){
        waitToBeClickable(10, dateFromFilter);
        sleep(1000);
        dateFromFilter.click();
        sleep(1000);
        firstDate.click();
        waitToBeClickable(10, btnSetDate);
        sleep(1000);
        btnSetDate.click();
    }

    public void inputFinishDate(){
        waitToBeClickable(10, dateToFilter);
        sleep(1000);
        dateToFilter.click();
        sleep(1000);
        secondDate.click();
        waitToVisibilityOf(10, btnSetDate);
        sleep(1000);
        btnSetDate.click();
    }

    public void inputStartDateLessThenFinishDate(){
        sleep(1000);
        dateFromFilter.click();
        sleep(1000);
        secondDate.click();
        sleep(1000);
        btnSetDate.click();

        sleep(1000);
        dateToFilter.click();
        sleep(1000);
        firstDate.click();
        sleep(1000);
        btnSetDate.click();
    }

    /** Find Clear button*/
    @FindBy(xpath = "//button[contains(text(), 'Clear')]")
    public WebElement btnClearFilter;

    public void clearFilters(){
        btnClearFilter.click();
    }

    /** Find Show Result button*/
    @FindBy(xpath = "//button[contains(text(), 'Show Result')]")
    public WebElement btnShowResultFilter;

    public void showResults(){
        btnShowResultFilter.click();
        sleep(1000);
    }

    /** Найти колонку trailer*/
    @FindBy(xpath = "//datatable-body-cell[4]")
    public WebElement cellTrailer;

    /** Найти колонку driver 1*/
    @FindBy(xpath = "//datatable-body-cell[5]")
    public WebElement cellDriver1;

    /** Найти колонку driver 2*/
    @FindBy(xpath = "//datatable-body-cell[6]")
    public WebElement cellDriver2;

    /** Найти колонку Probill*/
    @FindBy(xpath = "//datatable-body-cell[8]")
    public WebElement cellProbill;

    /** Найти колонку Start Date*/
    @FindBy(xpath = "//datatable-body-cell[10]")
    public WebElement cellStartDate;

    /** Найти колонку Finish Date*/
    @FindBy(xpath = "//datatable-body-cell[11]")
    public WebElement cellFinishDate;

    @FindBy(xpath = "//datatable-body-row")
    public List<WebElement> table;

    /** Find search truck input*/
    @FindBy(xpath = "//*[@placeholder = 'Search Truck Number']//input")
    public WebElement inputSearchTruck;

    /** Find search truck button*/
    @FindBy(xpath = "//*[@placeholder = 'Search Truck Number']//..//button")
    public WebElement btnSearchTruckInput;

    /** Find search truck button*/
    @FindBy(xpath = "//*[@placeholder = 'Search Truck Number']//ng-dropdown-panel")
    public WebElement listSearchTruck;

    public void findTruck(String truck){
        inputSearchTruck.sendKeys(truck);
        waitToVisibilityOf(10, btnSearchTruckInput);
        waitToBeClickable(10, btnSearchTruckInput);
        btnSearchTruckInput.click();
        waitToVisibilityOf(10, listSearchTruck);
        waitToBeClickable(10, listSearchTruck);
        sleep(500);
        listSearchTruck.click();
    }
}
