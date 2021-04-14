package fleetEventsOld;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import resources.AppConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;
import resources.AppConstants;

public class createNewFleetEvent extends BasePage {
    public WebDriver driver;

    /** Find button Create New transaction */
    @FindBy(xpath = "//button[contains(text(), 'Create New Trip')]")
    public WebElement btnCreateNew;

    public void clickBtnCreateTrip(){
        btnCreateNew.click();
    }

    /** Find button edit trip*/
    @FindBy(xpath = "//button[text() = ' Edit Trip ']")
    public WebElement btnEditTrip;

    public void clickBtnEditTrip(){
        btnCreateNew.click();
    }

    /** Find comment field */
    @FindBy(xpath = "//textarea[@id = 'comment']")
    public WebElement commentField;

    public void inputComment(String comment){
        commentField.sendKeys(comment);
    }

    /** Find trip status */
    @FindBy(xpath = "//*[@id='tripStatus']//input")
    public WebElement tripStatus;

    @FindBy(xpath = "//*[@role = 'option']")
    public WebElement tripStatusList;

    public void inputTripStatus(String status){
        waitToVisibilityOf(10, tripStatus);
        tripStatus.sendKeys(status);
        tripStatusList.click();
    }

    /** Find type local */
    @FindBy(xpath = "//*[@id='tripType']//input")
    public WebElement tripType;

    public void inputType(String type){
        tripType.sendKeys(type);
        tripType.sendKeys(Keys.ENTER);
    }

    /** Find Driver 1 */
    @FindBy(xpath = "//*[@id='driver1']//input")
    public WebElement driver1;

    public void inputDriver1(String driver){
        driver1.sendKeys(driver);
        driver1.sendKeys(Keys.ENTER);
    }

    /** Find Driver 2 */
    @FindBy(xpath = "//*[@id='driver2']//input")
    public WebElement driver2;

    public void inputDriver2(String driver){
        driver2.sendKeys(driver);
        driver2.sendKeys(Keys.ENTER);
    }

    public void inputDriver1SameDriver2(String driver){
        driver1.sendKeys(driver);
        driver1.sendKeys(Keys.ENTER);
        driver2.sendKeys(driver);
        driver2.sendKeys(Keys.ENTER);
    }

    /** Find dispatcher */
    @FindBy(xpath = "//*[@id='dispatcher']//input")
    public WebElement dispatcher;

    public void inputDispatcher(String dispatcherName){
        dispatcher.sendKeys(dispatcherName);
        dispatcher.sendKeys(Keys.ENTER);
    }

    /** Find truck */
    @FindBy(xpath = "//*[@id='truck']//input")
    public WebElement truck;

    public void inputTruck(String truckNumber){
        truck.sendKeys(truckNumber);
        truck.sendKeys(Keys.ENTER);
    }

    /** Find trailer */
    @FindBy(xpath = "//*[@id='trailer']//input")
    public WebElement trailer;

    public void inputTrailer(String trailerNumber){
        trailer.sendKeys(trailerNumber);
        trailer.sendKeys(Keys.ENTER);
    }

    /** Find save button */
    @FindBy(xpath = "//*[@class='modal-footer']//button[contains(@class, 'btn-succes')]")
    public WebElement btnSave;

    public void clickBtnSave(){
        btnSave.click();
    }

    /** Find Cancel Button*/
    @FindBy(xpath = "//*[@class='modal-footer']//button[contains(@class, 'btn-primary')]")
    public WebElement btnCancel;

    public void clickBtnCancel(){
        btnCancel.click();
    }

    /** Find place radio button*/
    @FindBy(xpath = "//*[contains(text(), 'Create acquire and')]//input")
    public WebElement radioPlace;

    public void clickRadioPlace(){
        radioPlace.click();
    }

    /** Find place selector*/
    @FindBy(xpath = "//div/ng-select[@placeholder = 'Place']")
    public WebElement placeList;

    /** Find place in the list*/
    @FindBy(xpath = "//*[text() = 'Highlight Terminal']")
    public WebElement placeFromPlaceList;

    public void inputPlace(){
        if (radioPlace.isSelected()) {
            placeList.click();
            placeFromPlaceList.click();
        } else {
            clickRadioPlace();
            placeList.click();
            placeFromPlaceList.click();
        }
    }

    /** Find Order radio button*/
    @FindBy(xpath = "//*[contains(text(), 'Create Trip Based on Order')]//input")
    public WebElement radioOrder;

    public void clickRadioOrder(){
        radioOrder.click();
    }

    /** Find Order input*/
    @FindBy(xpath = "//*[@bindlabel = 'orderNumber']//input")
    public WebElement inputOrder;

    /** Find Button Add Selected Order*/
    @FindBy(xpath = "//button[text() = ' Add Selected Order ']")
    public WebElement btnAddOrder;

    /** Find order in list*/
    @FindBy(xpath = "//*[@bindvalue = 'orderId']/ng-dropdown-panel")
    private WebElement inputOrderFromList;

    /** Find button search order*/
    @FindBy(xpath = "//*[@bindvalue = 'orderId']//following-sibling::button")
    private WebElement btnSearchOrder;

    public void inputOrder(String order){
        if (radioOrder.isSelected()){
            inputOrder.sendKeys(order);
            btnSearchOrder.click();
            inputOrderFromList.click();
            waitToBeClickable(10,btnAddOrder);
            btnAddOrder.click();
        } else {
            clickRadioOrder();
            inputOrder.sendKeys(order);
            btnSearchOrder.click();
            inputOrderFromList.click();
            btnAddOrder.click();
        }
    }

    /** Find Notification radio button*/
    @FindBy(xpath = "//*[contains(text(), 'Send Notification')]//div")
    public WebElement radioNotification;

    public void clickRadioNotification(){
        radioNotification.click();
    }

    /** Find Send notification time select*/
    @FindBy(xpath = "//*[contains(text(), 'Send notification')]//input[@role = 'combobox']")
    public WebElement setNotificationTimeSelect;

    /** Find time for notification*/
    @FindBy(xpath = "//*[contains(text(), 'Send notification')]//ng-dropdown-panel//div[@role = 'option'][1]")
    public WebElement setNotificationTime;

    public void setNotificationTime(){
        waitToBeClickable(10, radioNotification);
        radioNotification.click();
        setNotificationTimeSelect.click();
        setNotificationTime.click();
    }

    /** Find notification email*/
    @FindBy(xpath = "//input[@type = 'email']")
    public  WebElement notificationEmail;

    public void inputNotificationEmail(String email){
        clickRadioNotification();
        notificationEmail.sendKeys(email);
    }

    public void setNotificationWithEmailAndTime(String email){
        if(radioNotification.isSelected()) {
            setNotificationTimeSelect.click();
            setNotificationTime.click();
            notificationEmail.sendKeys(email);
        } else {
            clickRadioNotification();
            setNotificationTimeSelect.click();
            setNotificationTime.click();
            notificationEmail.sendKeys(email);
        }
    }

    /** Find Start Date picker*/
    @FindBy(xpath = "//*[@id = 'startDate']")
    public WebElement startDatePicker;

    /** Find Set Date Button*/
    @FindBy(xpath = "//button//span[text() = 'Set']")
    public WebElement btnSetDate;

    /** Find first date*/
    @FindBy(xpath = "//tbody[@role='grid']/tr[2]/td[1]")
    public WebElement firstDate;

    /** Find second Date*/
    @FindBy(xpath = "//tbody[@role='grid']/tr[2]/td[6]")
    public WebElement secondDate;

    /** Find Finish Date picker*/
    @FindBy(xpath = "//*[@id = 'finishDate']")
    public WebElement finishDatePicker;

    public void setTime(){
        btnSetDate.click();
    }

    public void inputStartDate(){
        waitToBeClickable(10, startDatePicker);
        sleep(500);
        startDatePicker.click();
        sleep(500);
        firstDate.click();
        waitToBeClickable(10, btnSetDate);
        sleep(500);
        btnSetDate.click();
    }

    public void inputFinishDate(){
        waitToBeClickable(10, finishDatePicker);
        sleep(500);
        finishDatePicker.click();
        sleep(500);
        secondDate.click();
        waitToVisibilityOf(10, btnSetDate);
        sleep(500);
        btnSetDate.click();
    }

    public void inputStartDateLessThenFinishDate(){
        sleep(500);
        startDatePicker.click();
        sleep(500);
        secondDate.click();
        sleep(500);
        setTime();

        sleep(500);
        finishDatePicker.click();
        sleep(500);
        firstDate.click();
        sleep(500);
        setTime();
    }

    /** Find trip number*/
    @FindBy(xpath = "//*[@placeholder = 'Search Trip Number']//input")
    public WebElement tripNumberInput;

    @FindBy(xpath = "//*[text() = 'Trip #: ']/..")
    public WebElement tripNumber;

    public void findTripNumber(String trip){
        tripNumberInput.sendKeys(trip);
        tripNumberInput.sendKeys(Keys.ENTER);
        tripNumberInput.sendKeys(Keys.ENTER);
    }

    /** Find confirm delete order button*/
    @FindBy(xpath = "//button[text() = 'Yes']")
    public WebElement btnConfirmDeleteOrder;

    /** Find Delete order button*/
    @FindBy(xpath = "//*[contains(text(), 'Order # CO-20-61201')]//..//button")
    private WebElement btnDeleteOrder;

    public void deleteOrder(){
        waitToVisibilityOf(10, btnDeleteOrder);
        btnDeleteOrder.click();
    }

    /** Find message that order dose not have probills*/
    public boolean isOrderDoesNotHaveProbills(String orderNumber){
        return isElementDisplayedByPath("//*[contains(text(), 'Order # " + orderNumber + "Does Not Have Any Probill')]");
    }

    public void createTrip(String status, String type){
        inputTripStatus(status);
        inputType(type);
        System.out.println(tripType.getText());
        inputPlace();
        clickBtnSave();
    }

    public void openFormCreate(){
        waitToVisibilityOf(10, btnCreateNew);
        waitToBeClickable(10, btnCreateNew);
        clickBtnCreateTrip();
        waitToVisibilityOf(10, commentField);
        waitToVisibilityOf(10, commentField);
        sleep(500);
    }



    public createNewFleetEvent(WebDriver driver) {
        super(driver);
    }
}
