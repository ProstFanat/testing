package DispatcherManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import resources.AppConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;
import resources.AppConstants;

import java.util.List;

public class dispatcherMonitor extends BasePage {
    public dispatcherMonitor(WebDriver driver) {
        super(driver);
    }

    /** Find Dispatcher input*/
    @FindBy(xpath = "//input[@placeholder = 'Choose dispatcher...']")
    public WebElement dispatcherInput;

    @FindBy(xpath = "//ul[@class = 'select-search-list']//li[2]//input//..//..//li[1]")
    public WebElement dispatcherInputLi;

    public void inputDispatcher(String dispatcher){
        waitToVisibilityOf(10, dispatcherInput);
        waitToBeClickable(10, dispatcherInput);
        dispatcherInput.click();
        dispatcherInput.sendKeys(dispatcher);
        dispatcherInput.sendKeys(Keys.ENTER);
    }

    /** Find Checkbox Show active trips only*/
    @FindBy(xpath = "//input[@type = 'checkbox']")
    public WebElement showActiveCheckbox;

    public void showOnlyActiveTrips(){
        if(!(showActiveCheckbox.isSelected())){
            showActiveCheckbox.click();
        }
    }

    public void showAllTrips(){
        if(showActiveCheckbox.isSelected()){
            showActiveCheckbox.click();
        }
    }

    /** Find Button Advanced Search*/
    @FindBy(xpath = "//button[contains(text(), 'Advanced Search')]")
    public WebElement btnAdvancedSearch;

    public void clickAdvancedSearch(){
        waitToVisibilityOf(10, btnAdvancedSearch);
        waitToBeClickable(10, btnAdvancedSearch);
        btnAdvancedSearch.click();
        sleep(500);
    }

    /** Find Trip Input*/
    @FindBy(xpath = "//input[@placeholder = 'Enter Trip Number']")
    public WebElement tripInput;

    public void inputTrip(String trip){
        waitToBeClickable(10, tripInput);
        tripInput.sendKeys(trip);
    }

    /** Find Status Input*/
    @FindBy(xpath = "//input[@placeholder = 'Choose Trip Status...']")
    public WebElement statusInput;

    public void inputStatus(String status){
        waitToBeClickable(10, statusInput);
        statusInput.sendKeys(status);
        statusInput.sendKeys(Keys.ENTER);
    }

    /** Find Type Input*/
    @FindBy(xpath = "//input[@placeholder = 'Choose Trip Type...']")
    public WebElement typeInput;

    public void inputType(String type){
        waitToBeClickable(10, typeInput);
        typeInput.sendKeys(type);
        typeInput.sendKeys(Keys.ENTER);
    }

    /** Find Driver Input*/
    @FindBy(xpath = "//input[@placeholder = 'Choose Driver...']")
    public WebElement driverInput;

    public void inputDriver(String driver1){
        waitToBeClickable(10, driverInput);
        driverInput.sendKeys(driver1);
        driverInput.sendKeys(Keys.ENTER);
    }

    /** Find Truck Input*/
    @FindBy(xpath = "//input[@placeholder = 'Choose Truck...']")
    public WebElement truckInput;

    public void inputTruck(String truck){
        waitToBeClickable(10, truckInput);
        truckInput.sendKeys(truck);
        truckInput.sendKeys(Keys.ENTER);
    }

    /** Find Trailer Input*/
    @FindBy(xpath = "//input[@placeholder = 'Choose Trailer...']")
    public WebElement trailerInput;

    public void inputTrailer(String trailer){
        waitToBeClickable(10, trailerInput);
        trailerInput.sendKeys(trailer);
        trailerInput.sendKeys(Keys.ENTER);
    }

    /** Find button Clear*/
    @FindBy(xpath = "//button[text() = 'Clear']")
    public WebElement btnClear;

    public void clearFilters(){
        btnClear.click();
        sleep(500);
    }

    /** Find button Apply*/
    @FindBy(xpath = "//button[text() = 'Apply']")
    public WebElement btnApply;

    public void applyFilters(){
        btnApply.click();
        sleep(1000);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /** Working with table */
    @FindBy(xpath = "//dispatcher-monitor//*[@role = 'grid']//*[@role = 'rowgroup'][2]//*[@role = 'gridcell'][1]//div")
    public WebElement tableTrip;

    public String getTripNumber(){
        return tableTrip.getText();
    }

    @FindBy(xpath = "//dispatcher-monitor//*[@role = 'grid']//*[@role = 'rowgroup'][2]//*[@role = 'gridcell'][2]//div")
    public WebElement tableStatus;

    public String getTripStatus(){
        return tableStatus.getText();
    }

    @FindBy(xpath = "//dispatcher-monitor//*[@role = 'grid']//*[@role = 'rowgroup'][2]//*[@role = 'gridcell'][3]//div")
    public WebElement tableType;

    public String getTripType(){
        return tableType.getText();
    }

    @FindBy(xpath = "//dispatcher-monitor//*[@role = 'grid']//*[@role = 'rowgroup'][2]//*[@role = 'gridcell'][5]//div")
    public WebElement tableDriver1;

    public String getTripDriver1(){
        return tableDriver1.getText();
    }

    @FindBy(xpath = "//dispatcher-monitor//*[@role = 'grid']//*[@role = 'rowgroup'][2]//*[@role = 'gridcell'][6]//div")
    public WebElement tableDriver2;

    public String getTripDriver2(){
        return tableDriver2.getText();
    }

    @FindBy(xpath = "//dispatcher-monitor//*[@role = 'grid']//*[@role = 'rowgroup'][2]//*[@role = 'gridcell'][7]//div")
    public WebElement tableTruck;

    public String getTripTruck(){
        return tableTruck.getText();
    }

    @FindBy(xpath = "//dispatcher-monitor//*[@role = 'grid']//*[@role = 'rowgroup'][2]//*[@role = 'gridcell'][8]//div")
    public WebElement tableTrailer;

    public String getTripTrailer(){
        return tableTrailer.getText();
    }

    /** Find Button Action*/
    @FindBy(xpath = "//dispatcher-monitor//*[@role = 'grid']//*[@role = 'rowgroup'][2]//*[@role = 'gridcell'][11]//div")
    public WebElement btnActions;

    @FindBy(xpath = "//dispatcher-monitor//*[@role = 'grid']//*[@role = 'rowgroup'][2]//div[@role = 'row']")
    public List<WebElement> table;

    public int getTableSize(){
        return table.size();
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean filterBy(String value, String filterBy){
        int by = 0;
        int counter = 0;
        int counterTable = getTableSize();
        String helpA = "";

        switch (filterBy){
            case ("status"):
                by = 2;
//                helpA = "//div";
                break;
            case ("type"):
                by = 3;
//                helpA = "//div";
                break;
            case ("driver1"):
                by = 5;
                helpA = "//a";
                break;
            case ("truck"):
                by = 7;
                helpA = "//a";
                break;
            case ("trailer"):
                by = 8;
                helpA = "//a";
                break;
            case ("tripNumber"):
                by = 1;
//                helpA = "//div";
                break;
        }

        for(int i = 1; i <= getTableSize(); i++){
            //System.out.println(driver.findElement(By.xpath("//dispatcher-monitor//*[@role = 'grid']//*[@role = 'rowgroup'][2]//div//div[" + i + "]//div[@role = 'row']//div//div[" + by + "]//*[contains(@class, 'ui-grid-cell')]" + helpA)).getText());
            //if((value).equals(driver.findElement(By.xpath("//dispatcher-monitor//*[@role = 'grid']//*[@role = 'rowgroup'][2]//div//div[" + i + "]//*[@role = 'gridcell'][" + by + "]")).getText())){
            if((value).equals(driver.findElement(By.xpath("//dispatcher-monitor//*[@role = 'grid']//*[@role = 'rowgroup'][2]//div//div[" + i + "]//div[@role = 'row']//div//div[" + by + "]//*[contains(@class, 'ui-grid-cell')]" + helpA)).getText())){
                counter++;
            }

            if(by == 5){
                //if((value).equals(driver.findElement(By.xpath("//dispatcher-monitor//*[@role = 'grid']//*[@role = 'rowgroup'][2]//div//div[" + i + "]//*[@role = 'gridcell'][5]")).getText())){
                if((value).equals(driver.findElement(By.xpath("//dispatcher-monitor//*[@role = 'grid']//*[@role = 'rowgroup'][2]//div//div[" + i + "]//div[@role = 'row']//div//div[6]//*[contains(@class, 'ui-grid-cell')]" + helpA)).getText())){
                    counter++;
                }
            }
        }
//        System.out.println();
//        System.out.println(counter);
//        System.out.println(counterTable);
        if(counter == counterTable){
            return true;
        } else {
            return false;
        }
    }

}
