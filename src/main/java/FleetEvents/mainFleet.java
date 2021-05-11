package FleetEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import resources.AppConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;
import resources.AppConstants;

public class mainFleet extends BasePage {
    public mainFleet(WebDriver driver) {
        super(driver);
    }

    public WebDriver driver;

    /** Find Open transaction button*/
    @FindBy(xpath = "//button[text() = ' Open Transaction ']")
    public WebElement btnOpenTransaction;

    public void clickBtnOpenTransaction(){
        waitToVisibilityOf(10, btnOpenTransaction);
        waitToBeClickable(10, btnOpenTransaction);
        btnOpenTransaction.click();
    }

    public void openTransaction(){
        clickBtnOpenTransaction();
        saveNewTransaction();
    }

    /** Find Delete transaction button*/
    @FindBy(xpath = "//button[text() = ' Delete ']")
    public WebElement btnDeleteTransaction;

    public void deleteTransaction(){
        waitToVisibilityOf(10, btnDeleteTransaction);
        btnDeleteTransaction.click();
        waitToVisibilityOf(10, btnYesConfirm);
        waitToBeClickable(10, btnYesConfirm);
        btnYesConfirm.click();
    }

    /** Find Commit transaction button*/
    @FindBy(xpath = "//button[text() = ' Commit ']")
    public WebElement btnCommitTransaction;

    public void clickBtnCommitTransaction(){
        waitToVisibilityOf(10, btnCommitTransaction);
        waitToBeClickable(10, btnCommitTransaction);
        btnCommitTransaction.click();
    }

    /** Find Confirm action button*/
    @FindBy(xpath = "//button[text() = 'Yes ']")
    public WebElement btnYesConfirm;

    public void commitTransaction(){
        clickBtnCommitTransaction();
        waitToVisibilityOf(10, btnYesConfirm);
        waitToBeClickable(10, btnYesConfirm);
        btnYesConfirm.click();
    }

    public void clickBtnConfirmAction(){
        waitToVisibilityOf(10, btnYesConfirm);
        waitToBeClickable(10, btnYesConfirm);
        btnYesConfirm.click();
    }

    /** Find Cancelled action button*/
    @FindBy(xpath = "//button[text() = ' Cancel']")
    public WebElement btnCancelConfirm;

    public void clickBtnCancelledAction(){
        waitToVisibilityOf(10, btnCancelConfirm);
        waitToBeClickable(10, btnCancelConfirm);
        btnCancelConfirm.click();
    }

    /** Find Add New Event Button*/
    @FindBy(xpath = "//button[text() = ' Add New Event ']")
    public WebElement btnAddNewEvent;

    public void clickBtnAddNewEvent(){
        waitToVisibilityOf(10, btnAddNewEvent);
        waitToBeClickable(10, btnAddNewEvent);
        sleep(500);
        btnAddNewEvent.click();
    }

    /** Find Actions button*/
    public void openActionsMenu(int SEQ){
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + SEQ + "]//button[@id = 'button-actions']")).click();
    }

    /** Find Insert Event below button*/
    @FindBy(xpath = "//*[@id = 'dropdown-actions']//*[text() = ' Insert Event Bellow ']")
    public WebElement btnInsertEventBellow;

    public void clickBtnInsertEventBelow(){
        openActionsMenu(1);
        waitToVisibilityOf(10, btnInsertEventBellow);
        waitToBeClickable(10, btnInsertEventBellow);
        btnCancelConfirm.click();
        btnInsertEventBellow.click();
    }

    /** Find delete Event button*/
    @FindBy(xpath = "//*[@id = 'dropdown-actions']//*[text() = ' Delete ']")
    public WebElement btnDeleteEvent;

    public void clickBtnDelete(){
        //openActionsMenu(SEQ);
        waitToVisibilityOf(10, btnDeleteEvent);
        waitToBeClickable(10, btnDeleteEvent);
        btnDeleteEvent.click();
    }

    /** Find Edit Event button*/
    @FindBy(xpath = "//*[@id = 'dropdown-actions']//*[text() = ' Edit ']")
    public WebElement btnEditEvent;

    public void clickBtnEditEvent(){
       // openActionsMenu(1);
        waitToVisibilityOf(10, btnEditEvent);
        waitToBeClickable(10, btnEditEvent);
        btnEditEvent.click();
    }

    /** Find move up button*/
    public void moveUp(int SEQ){
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + SEQ + "]//button[contains(@tooltip, 'Move Up')]")).click();
    }

    /** Find move down button*/
    public void moveDown(int SEQ){
        driver.findElement(By.xpath("//datatable-scroller/datatable-row-wrapper[" + SEQ + "]//button[contains(@tooltip, 'Move Down')]")).click();
    }

    /** Find Show/Hide legend*/
    @FindBy(xpath = "//button[@id = 'button-legend']")
    public WebElement btnShowHideLegend;

    public void clickBtnShowHideLegend(){
        waitToVisibilityOf(10, btnShowHideLegend);
        waitToBeClickable(10, btnShowHideLegend);
        btnShowHideLegend.click();
    }

    /** Find Show Columns button*/
    @FindBy(xpath = "//button[@id = 'table-settings-button']")
    public WebElement btnShowColumns;

    public void clickBtnShowColumns(){
        btnShowColumns.click();
    }

    /** Find radio All*/
    @FindBy(xpath = "//ul[@id = 'table-settings']//li[1]//input")
    public WebElement radioAll;

    public void clickRadioAll(){
        radioAll.click();
    }

    /** Find radio SEQ*/
    @FindBy(xpath = "//ul[@id = 'table-settings']//li[4]//input")
    public WebElement radioSEQ;

    public void clickRadioSEQ(){
        radioSEQ.click();
    }

    /** Find radio TRUCK*/
    @FindBy(xpath = "//ul[@id = 'table-settings']//li[6]//input")
    public WebElement radioTRUCK;

    public void clickRadioTruck(){
        radioTRUCK.click();
    }

    /** Find radio Trailer*/
    @FindBy(xpath = "//ul[@id = 'table-settings']//li[7]//input")
    public WebElement radioTrailer;

    public void clickRadioTrailer(){
        radioTrailer.click();
    }

    /** Find radio Driver 1*/
    @FindBy(xpath = "//ul[@id = 'table-settings']//li[8]//input")
    public WebElement radioDriver1;

    public void clickRadioDriver1(){
         radioDriver1.click();
    }

    /** Find radio Driver 2*/
    @FindBy(xpath = "//ul[@id = 'table-settings']//li[9]//input")
    public WebElement radioDriver2;

    public void clickRadioDriver2(){
        radioDriver2.click();
    }

    /** Find radio Probill*/
    @FindBy(xpath = "//ul[@id = 'table-settings']//li[11]//input")
    public WebElement radioProbill;

    public void clickRadioProbill(){
        radioProbill.click();
    }

    /** Find radio ETA*/
    @FindBy(xpath = "//ul[@id = 'table-settings']//li[12]//input")
    public WebElement radioETA;

    public void clickRadioETA(){
        radioETA.click();
    }

    /** Find radio Start Date*/
    @FindBy(xpath = "//ul[@id = 'table-settings']//li[13]//input")
    public WebElement radioStartDate;

    public void clickRadioStartDate(){
        radioStartDate.click();
    }

    /** Find radio FinishDate*/
    @FindBy(xpath = "//ul[@id = 'table-settings']//li[14]//input")
    public WebElement radioFinishDate;

    public void clickRadioFinishDate(){
        radioFinishDate.click();
    }

    /** Find radio Status*/
    @FindBy(xpath = "//ul[@id = 'table-settings']//li[15]//input")
    public WebElement radioStatus;

    public void clickRadioStatus(){
        radioStatus.click();
    }

    ////////////////////

    /** Find column SEQ*/
    @FindBy(xpath = "//datatable-header//*[text() = 'SEQ']")
    public WebElement columnSEQ;

    /** Find column TRUCK*/
    @FindBy(xpath = "//datatable-header//*[text() = 'Truck #']']")
    public WebElement columnTRUCK;

    /** Find column Trailer*/
    @FindBy(xpath = "//datatable-header//*[text() = 'Trailer #']")
    public WebElement columnTrailer;

    /** Find column Driver 1*/
    @FindBy(xpath = "//datatable-header//*[text() = 'Driver 1']")
    public WebElement columnDriver1;

    /** Find column Driver 2*/
    @FindBy(xpath = "//datatable-header//*[text() = 'Driver 2']")
    public WebElement columnDriver2;

    /** Find column Probill*/
    @FindBy(xpath = "//datatable-header//*[text() = 'Probill #']")
    public WebElement columnProbill;

    /** Find column ETA*/
    @FindBy(xpath = "//datatable-header//*[text() = 'ETA']")
    public WebElement columnETA;

    /** Find column Star Date*/
    @FindBy(xpath = "//datatable-header//*[text() = 'Start Date']")
    public WebElement columnStartDate;

    /** Find column FinishDate*/
    @FindBy(xpath = "//datatable-header//*[text() = 'Finish Date']")
    public WebElement columnFinishDate;

    /** Find column Status*/
    @FindBy(xpath = "//datatable-header//*[text() = 'Status']")
    public WebElement columnStatus;


    /** Find Button Save Columns*/
    @FindBy(xpath = "//ul[@id = 'table-settings']//li//button")
    public WebElement btnSaveColumns;

    public void saveColumns(){
        btnSaveColumns.click();
    }

    /** Find */

    /** Find Trailer Map button*/
    @FindBy(xpath = "//button[text() = ' Trailer Map ']")
    public WebElement btnTrailerMap;

    /** Find Actions with trip button*/
    @FindBy(xpath = "//button[@id = 'button-basic']")
    public WebElement btnActionsTrip;

    /** Find Edit Trip Button*/
    @FindBy(xpath = "//*[contains(text(), ' Edit Trip ')]")
    public WebElement btnEditTrip;

    public void openEditTrip(){
        waitToVisibilityOf(10, btnEditTrip);
        waitToBeClickable(10, btnEditTrip);
        btnEditTrip.click();
    }

    /** Find Show History button*/
    @FindBy(xpath = "//*[contains(text(), ' Show History ')]")
    public WebElement btnShowHistory;

    public void openTripHistory(){
        btnActionsTrip.click();
        waitToVisibilityOf(10, btnShowHistory);
        waitToBeClickable(10, btnShowHistory);
        btnShowHistory.click();
    }

    /** Find next page button*/
    @FindBy(xpath = "//*[@aria-label = 'go to next page']")
    public WebElement btnNextPage;

    public void goToNextPage(){
        btnNextPage.click();
    }

    /** Find previous page button*/
    @FindBy(xpath = "//*[@aria-label = 'go to previous page']")
    public WebElement btnPreviousPage;

    public void goToPreviousPage(){
        btnPreviousPage.click();
    }

    /** Find Go to the First page Button*/
    @FindBy(xpath = "//*[@aria-label = 'go to first page']")
    public WebElement btnFirstPage;

    public void goToFirstPage(){
        btnFirstPage.click();
    }

    /** Find go to the last page button*/
    @FindBy(xpath = "//*[@aria-label = 'go to last page']")
    public WebElement btnLastPage;

    public void goToLastpage(){
        btnLastPage.click();
    }

    /** Find Comment to transaction info input*/
    @FindBy(xpath = "//textarea")
    public WebElement commentInNewTransaction;

    public void inputCommentToTransaction(String text){
        commentInNewTransaction.sendKeys(text);
    }

    /** Find save transaction info button*/
    @FindBy(xpath = "//button[text() = 'Save']")
    public WebElement btnSaveNewTransaction;

    public void saveNewTransaction(){
        waitToVisibilityOf(10,btnSaveNewTransaction);
        waitToBeClickable(10, btnSaveNewTransaction);
        btnSaveNewTransaction.click();
    }

    /** Find cancel opening transaction button*/
    @FindBy(xpath = "//button[text() = 'Cancel']")
    public WebElement btnCancelNewTransaction;

    public void cancelNewTransaction(){
        waitToVisibilityOf(10,btnCancelNewTransaction);
        waitToBeClickable(10, btnCancelNewTransaction);
        btnCancelNewTransaction.click();
    }

    /** Find order in table*/
    public boolean isOrderInTable(String order){
        return isElementDisplayedByPath("//*[contains(text(), 'Order: " + order +"')]");
    }

    /** Find Place in table*/
    public boolean isPlaceInTable(){
        return  isElementDisplayedByPath("//*[@title = '391 Creditstone Road, L4K 1N8, Vaughan, OntarioCanada']");
    }

    public void deleteEvent(){
        clickBtnDelete();
        waitToVisibilityOf(10,btnYesConfirm);
        waitToBeClickable(10,btnYesConfirm);
        btnYesConfirm.click();
    }

    /** Find perspective input*/
    @FindBy(xpath = "//*[@id = 'activePov']//input")
    public WebElement perspectiveInput;

    public void inputPerspective(String perspective){
        perspectiveInput.sendKeys(perspective);
        perspectiveInput.sendKeys(Keys.ENTER);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FindBy(xpath = "//*[text() = 'Trip #: ']//..")
    public WebElement tripNumber;

    public String getTripNumber(){
        if(isElementDisplayed(tripNumber)) {
            return tripNumber.getText().substring(8);
        } else {
            return "";
        }
    }

    @FindBy(xpath = "//button[text() = ' Edit Trip ']")
    public WebElement btnUpdateTrip;

    public void updateTrip(){
        waitToVisibilityOf(10, btnUpdateTrip);
        waitToBeClickable(10, btnUpdateTrip);
        btnUpdateTrip.click();
//        if(btnUpdateTrip.isEnabled()){
//            btnUpdateTrip.click();
//        } else {
//            clickBtnOpenTransaction();
//            saveNewTransaction();
//            btnUpdateTrip.click();
//        }
    }
}