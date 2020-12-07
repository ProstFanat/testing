package fleet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;

import java.util.List;

public class filterFleet extends BasePage {
    public WebDriver driver;

    public filterFleet(WebDriver driver) {
        super(driver);
    }

    /** Find Advanced search button*/
    @FindBy(xpath = "//button[text() = ' Advanced Search ']")
    public WebElement btnAdvancedSearch;

    public void clickBtnAdvancedSearch(){
        waitToBeClickable(10, btnAdvancedSearch);
        waitToVisibilityOf(10, btnAdvancedSearch);
        btnAdvancedSearch.click();
    }

    /** Find Driver input*/
    @FindBy(xpath = "//*[@placeholder = 'Search Driver']//input")
    public WebElement driverFilter;

    @FindBy(xpath = "//*[@placeholder = 'Search Driver']//..//button")
    public WebElement btnFindDriver;

    @FindBy(xpath = "//*[@placeholder = 'Search Driver']//ng-dropdown-panel")
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
    @FindBy(xpath = "//*[@placeholder = 'Search Order']//input")
    public WebElement orderFilter;

    /** Find search Button for order*/
    @FindBy(xpath = "//*[@placeholder = 'Search Order']//..//button")
    public WebElement btnSearchOrder;

    /** Find order from the list*/
    @FindBy(xpath = "//*[@placeholder = 'Search Order']//ng-dropdown-panel")
    public WebElement orderFromTheList;

    /** Find Probill input*/
    @FindBy(xpath = "//*[@placeholder = 'Probill']//input")
    public WebElement probillFilter;

    public void inputOrder(String order, String probill){
        orderFilter.sendKeys(order);
        waitToVisibilityOf(10, btnSearchOrder);
        waitToBeClickable(10, btnSearchOrder);
        btnSearchOrder.click();
        sleep(500);
        orderFromTheList.click();
        sleep(500);
        probillFilter.sendKeys(probill);
        probillFilter.sendKeys(Keys.ENTER);
    }

    public void inputOrderWithoutProbill(String order){
        orderFilter.sendKeys(order);
        waitToVisibilityOf(10, btnSearchOrder);
        waitToBeClickable(10, btnSearchOrder);
        btnSearchOrder.click();
        waitToVisibilityOf(10, orderFromTheList);
        waitToBeClickable(10, orderFromTheList);
        orderFromTheList.click();
    }

    /** Find Truck input*/
    @FindBy(xpath = "//*[@placeholder = 'Search Truck']//input")
    public WebElement truckFilter;

    @FindBy(xpath = "//*[@placeholder = 'Search Truck']//..//button")
    public WebElement btnFindTruck;

    @FindBy(xpath = "//*[@placeholder = 'Search Truck']//ng-dropdown-panel")
    public  WebElement truckFromList;

    public void inputTruck(String truck){
        truckFilter.sendKeys(truck);
        waitToVisibilityOf(10, btnFindTruck);
        waitToBeClickable(10, btnFindTruck );
        btnFindTruck.click();
        waitToVisibilityOf(10, truckFromList);
        waitToBeClickable(10, truckFromList);
        truckFromList.click();
    }

    /** Find trailer input*/
    @FindBy(xpath = "//*[@placeholder = 'Search Trailer']//input")
    public WebElement trailerFilter;

    @FindBy(xpath = "//*[@placeholder = 'Search Trailer']//..//button")
    public WebElement btnFindTrailer;

    @FindBy(xpath = "//*[@placeholder = 'Search Trailer']//ng-dropdown-panel")
    public  WebElement TrailerFromList;

    public void inputTrailer(String trailer){
        trailerFilter.sendKeys(trailer);
        waitToVisibilityOf(10, btnFindTrailer);
        waitToBeClickable(10, btnFindTrailer);
        btnFindTrailer.click();
        waitToVisibilityOf(10, TrailerFromList);
        waitToBeClickable(10, TrailerFromList);
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
        waitToBeClickable(10, btnShowResultFilter);
        btnShowResultFilter.click();
        sleep(500);
    }

    /** Найти колонку truck*/
    @FindBy(xpath = "//datatable-body-cell[5]")
    public WebElement cellTruck;

    /** Найти колонку trailer*/
    @FindBy(xpath = "//datatable-body-cell[6]")
    public WebElement cellTrailer;

    /** Найти колонку driver 1*/
    @FindBy(xpath = "//datatable-body-cell[7]")
    public WebElement cellDriver1;

    /** Найти колонку driver 2*/
    @FindBy(xpath = "//datatable-body-cell[8]")
    public WebElement cellDriver2;

    /** Найти колонку Probill*/
    @FindBy(xpath = "//datatable-body-cell[10]")
    public WebElement cellProbill;

    /** Найти колонку Start Date*/
    @FindBy(xpath = "//datatable-body-cell[12]")
    public WebElement cellStartDate;

    /** Найти колонку Finish Date*/
    @FindBy(xpath = "//datatable-body-cell[13]")
    public WebElement cellFinishDate;

    @FindBy(xpath = "//datatable-body-row")
    public List<WebElement> table;

    /** Проверка на наличие драйвера*/
    public boolean isFilteredByDriver(){
        int tableSize = table.size();
        int counter = -1;
        for(int i = 0; i <= tableSize; i++){
            if(driver.findElement(By.xpath("//datatable-row-wrapper["+ i +"]//datatable-body-cell[7]")).getText() == "Adrian Gherghel"){
                counter++;
            } else if(driver.findElement(By.xpath("//datatable-row-wrapper["+ i +"]//datatable-body-cell[8]")).getText() == "Adrian Gherghel"){
                counter++;
            }
        }

        if (counter == tableSize){
            return true;
        } else {
            return false;
        }
    }

}
