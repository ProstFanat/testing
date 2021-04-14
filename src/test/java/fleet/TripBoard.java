package fleet;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import resources.AppConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;
import resources.AppConstants;

import java.util.List;

public class TripBoard extends BasePage {
    public TripBoard(WebDriver driver) {
        super(driver);
    }

    /** Find Button Advanced Search*/
    @FindBy(xpath = "//button[text() = ' Advanced Search ']")
    public WebElement btnAdvancedSearch;

    public void clickAdvancedSearch(){
        waitToVisibilityOf(10, btnAdvancedSearch);
        waitToBeClickable(10, btnAdvancedSearch);
        btnAdvancedSearch.click();
        sleep(500);
    }

    /** Find Trip# Input*/
    @FindBy(xpath = "//input[@placeholder = 'Trip #']")
    public WebElement tripInput;

    public void inputTripNumber(String tripNumber){
        tripInput.sendKeys(tripNumber);
    }

    /** Find Trip Status Input*/
    @FindBy(xpath = "//*[text() = 'Trip Status']//..//input")
    public WebElement tripStatusInput;

    public void inputTripStatus(String tripStatus){
        tripStatusInput.sendKeys(tripStatus);
        tripStatusInput.sendKeys(Keys.ENTER);
    }

    /** Find Trip Type Input*/
    @FindBy(xpath = "//*[text() = 'Trip Type']//..//input")
    public WebElement tripTypeInput;

    public void inputTripType(String tripType){
        tripTypeInput.sendKeys(tripType);
        tripTypeInput.sendKeys(Keys.ENTER);
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
        waitToBeClickable(10, btnFindDriver);
        btnFindDriver.click();
        waitToBeClickable(10,driverFromList);
        driverFromList.click();
    }

    /** Find Truck input*/
    @FindBy(xpath = "//*[@placeholder = 'Truck']//input")
    public WebElement truckFilter;

    @FindBy(xpath = "//*[@placeholder = 'Truck']//..//button")
    public WebElement btnFindTruck;

    @FindBy(xpath = "//*[@placeholder = 'Truck']//ng-dropdown-panel")
    public  WebElement truckFromList;

    public void inputTruck(String truck){
        truckFilter.sendKeys(truck);
        waitToBeClickable(10, truckFilter);
        btnFindTruck.click();
        waitToBeClickable(10, truckFromList);
        truckFromList.click();
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
    @FindBy(xpath = "//input[@placeholder = 'Create Date From']")
    public WebElement dateFromFilter;

    /** Find Date To form*/
    @FindBy(xpath = "//input[@placeholder = 'Create Date To']")
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

    /** Find btn Clear*/
    @FindBy(xpath = "//button[text() = 'Clear']")
    public WebElement btnClear;

    public void clearFilters(){
        btnClear.click();
    }

    /** Find btn Apply*/
    @FindBy(xpath = "//button[text() = ' Apply ']")
    public WebElement btnApply;

    public void applyFilters(){
        btnApply.click();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Table Find and get Info*/

    //////////////////////////////////////
    @FindBy(xpath = "//datatable-row-wrapper[1]//*[contains(@class, 'datatable-body-cell')][1]//span")
    public WebElement tableAlert;

    public boolean getAlert(){
        if(isElementDisplayed(tableAlert)){
            return true;
        } else {
            return false;
        }
    }

    //////////////////////////////////////
    @FindBy(xpath = "//datatable-row-wrapper[1]//*[contains(@class, 'datatable-body-cell')][2]//span")
    public WebElement tableTripNumber;

    public String getTripNumber(){
        return tableTripNumber.getText();
    }

    //////////////////////////////////////
    @FindBy(xpath = "//datatable-row-wrapper[1]//*[contains(@class, 'datatable-body-cell')][3]//span")
    public WebElement tableTripStatus;

    public String getTripStatus(){
        return tableTripStatus.getText();
    }

    //////////////////////////////////////
    @FindBy(xpath = "//datatable-row-wrapper[1]//*[contains(@class, 'datatable-body-cell')][4]//span")
    public WebElement tableTripType;

    public String getTripType(){
        return tableTripType.getText();
    }

    //////////////////////////////////////
    @FindBy(xpath = "//datatable-row-wrapper[1]//*[contains(@class, 'datatable-body-cell')][9]//a")
    public WebElement tableDriver1;

    public String getDriver1(){
        return tableDriver1.getText();
    }

    //////////////////////////////////////
    @FindBy(xpath = "//datatable-row-wrapper[1]//*[contains(@class, 'datatable-body-cell')][10]//a")
    public WebElement tableDriver2;

    public String getDriver2(){
        return tableDriver2.getText();
    }

    //////////////////////////////////////
    @FindBy(xpath = "//datatable-row-wrapper[1]//*[contains(@class, 'datatable-body-cell')][11]//a")
    public WebElement tableTruck;

    public String getTruck(){
        return tableTruck.getText();
    }

    //////////////////////////////////////
    @FindBy(xpath = "//datatable-row-wrapper[1]//*[contains(@class, 'datatable-body-cell')][12]//a")
    public WebElement tableTrailer;

    public String getTrailer(){
        return tableTrailer.getText();
    }

    @FindBy(xpath = "//datatable-row-wrapper")
    public List<WebElement> table;

    public int getTableSize(){
        return table.size();
    }

    /***/

    @FindBy(xpath = "//*[@class = 'datatable-icon-right']")
    public WebElement btnNextPage;

    public void goToTheNextPage(){
        btnNextPage.click();
    }

    @FindBy(xpath = "//*[@class = 'datatable-icon-left']")
    public WebElement btnPreviouslyPage;

    public void goToThePreviouslyPage(){
        btnPreviouslyPage.click();
    }


    public boolean filterBy(String value, String filterBy){
        int by = 0;
        String aOrSpan = "";
        int counter = 0;
        int counterTable = getTableSize();

        switch (filterBy){
            case ("status"):
                by = 3;
                aOrSpan = "span";
                break;
            case ("type"):
                by = 4;
                aOrSpan = "span";
                break;
            case ("driver1"):
                by = 9;
                aOrSpan = "a";
                //value = " " + value + " ";
                break;
            case ("truck"):
                by = 11;
                aOrSpan = "a";
                //value = " " + value + " ";
                break;
            case ("trailer"):
                by = 12;
                aOrSpan = "a";
                //value = " " + value + " ";
                break;
            case ("tripNumber"):
                by = 2;
                aOrSpan = "span";
                break;
        }

        for(int i = 1; i <= getTableSize(); i++){
            if(isElementDisplayedByPath("//datatable-row-wrapper[" + i + "]//*[contains(@class, 'datatable-body-cell')][" + by +"]//" + aOrSpan)) {
                if ((value).equals(driver.findElement(By.xpath("//datatable-row-wrapper[" + i + "]//*[contains(@class, 'datatable-body-cell')][" + by + "]//" + aOrSpan)).getText())) {
                    counter++;
                }
            }

            if(isElementDisplayedByPath("//datatable-row-wrapper[" + i + "]//*[contains(@class, 'datatable-body-cell')][10]//" + aOrSpan)) {
                if (by == 9) {
                    if ((value).equals(driver.findElement(By.xpath("//datatable-row-wrapper[" + i + "]//*[contains(@class, 'datatable-body-cell')][10]//" + aOrSpan)).getText())) {
                        counter++;
                    }
                }
            }

        }

        if(isVisible(btnPreviouslyPage)) {
            goToTheNextPage();
            counterTable = counterTable + getTableSize();
            for (int i = 1; i <= getTableSize(); i++) {
                if(isElementDisplayedByPath("//datatable-row-wrapper[" + i + "]//*[contains(@class, 'datatable-body-cell')][" + by +"]//" + aOrSpan)) {
                    if ((value).equals(driver.findElement(By.xpath("//datatable-row-wrapper[" + i + "]//*[contains(@class, 'datatable-body-cell')][" + by + "]//" + aOrSpan)).getText())) {
                        counter++;
                    }
                }

                if(isElementDisplayedByPath("//datatable-row-wrapper[" + i + "]//*[contains(@class, 'datatable-body-cell')][10]//" + aOrSpan)) {
                    if (by == 9) {
                        if ((value).equals(driver.findElement(By.xpath("//datatable-row-wrapper[" + i + "]//*[contains(@class, 'datatable-body-cell')][10]//" + aOrSpan)).getText())) {
                            counter++;
                        }
                    }
                }
            }
        }

//        System.out.println(counter);
//        System.out.println(counterTable);
        if(counter == counterTable){
            return true;
        } else {
            return false;
        }
    }

    // найти иконку fleet Events
    @FindBy(xpath = "//div[contains(@class, 'sidebar-inner')]//a[14]")
    private WebElement fleet;

    public String getLastTripNumber(){
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/app/trip-board/#/trip-list");
        waitToVisibilityOf(10, tableTripNumber);
        String temp = getTripNumber();
        waitToVisibilityOf(10, fleet);
        waitToBeClickable(10, fleet);
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/app/fleet-events/#/trip-view(details:trip-view-details)");
        return temp;
    }
}
