package FleetEvents;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;

public class editEvent extends BasePage {
    public editEvent(WebDriver driver) {
        super(driver);
    }

    public WebDriver driver;
    public mainFleet main;

    /** Find Event Type input*/
    @FindBy(xpath = "//*[@id = 'eventType']//input")
    public WebElement eventType;

    public void inputEventType(String type){
        waitToBeClickable(10, eventType);
        eventType.sendKeys(type);
        eventType.sendKeys(Keys.ENTER);
    }

    /** Find ETA input*/
    @FindBy(xpath = "//*[@id = 'eta']")
    public WebElement etaInput;

    /** Find Start Date form*/
    @FindBy(xpath = "//*[@id = 'startDate']")
    public WebElement startDate;

    /** Find Finish Date*/
    @FindBy(xpath = "//*[@id = 'finishDate']")
    public WebElement finishDate;

    /** Find first date*/
    @FindBy(xpath = "//tbody/tr[2]/td[1]")
    public WebElement firstDate;

    /** Find second date*/
    @FindBy(xpath = "//tbody/tr[2]/td[7]")
    public WebElement secondDate;

    /** Find first date 2*/
    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    public WebElement firstDate2;

    /** Find second date 2*/
    @FindBy(xpath = "//tbody/tr[1]/td[7]")
    public WebElement secondDate2;

    /** Find Set Date Button*/
    @FindBy(xpath = "//button//span[text() = 'Set']")
    public WebElement btnSetDate;

    public void inputETA(){
        waitToBeClickable(10, etaInput);
        sleep(1000);
        etaInput.click();
        sleep(1000);
        firstDate.click();
        waitToVisibilityOf(10, btnSetDate);
        sleep(1000);
        btnSetDate.click();
    }

    public void inputETA2(){
        waitToBeClickable(10, etaInput);
        sleep(1000);
        etaInput.click();
        sleep(1000);
        firstDate2.click();
        waitToVisibilityOf(10, btnSetDate);
        sleep(1000);
        btnSetDate.click();
    }

    public void inputStartDate(){
        waitToBeClickable(10, startDate);
        sleep(1000);
        startDate.click();
        sleep(1000);
        firstDate.click();
        waitToVisibilityOf(10, btnSetDate);
        sleep(1000);
        btnSetDate.click();
    }

    public void inputStartDate2(){
        waitToBeClickable(10, startDate);
        sleep(1000);
        startDate.click();
        sleep(1000);
        firstDate2.click();
        waitToVisibilityOf(10, btnSetDate);
        sleep(1000);
        btnSetDate.click();
    }

    public void inputFinishDate(){
        waitToBeClickable(10, finishDate);
        sleep(1000);
        finishDate.click();
        sleep(1000);
        secondDate.click();
        waitToVisibilityOf(10, btnSetDate);
        sleep(1000);
        btnSetDate.click();
    }

    public void inputFinishDate2(){
        waitToBeClickable(10, finishDate);
        sleep(1000);
        finishDate.click();
        sleep(1000);
        secondDate2.click();
        waitToVisibilityOf(10, btnSetDate);
        sleep(1000);
        btnSetDate.click();
    }

    public void inputStartDateLaterThanFinishDate(){
        waitToBeClickable(10, startDate);
        sleep(1000);
        startDate.click();
        sleep(1000);
        secondDate.click();
        waitToVisibilityOf(10, btnSetDate);
        sleep(1000);
        btnSetDate.click();

        waitToBeClickable(10, finishDate);
        sleep(1000);
        finishDate.click();
        sleep(1000);
        firstDate.click();
        waitToVisibilityOf(10, btnSetDate);
        sleep(1000);
        btnSetDate.click();
    }

    /** Find Past date*/
    @FindBy(xpath = "//tbody[@role='grid']/tr[1]/td[1]")
    public WebElement pastDate;

    /** Find Future date*/
    @FindBy(xpath = "//tbody[@role='grid']/tr[6]/td[7]")
    public WebElement futureDate;

    public void inputStartDatePast(){
        waitToBeClickable(10, startDate);
        sleep(500);
        startDate.click();
        sleep(500);
        pastDate.click();
        waitToBeClickable(10, btnSetDate);
        sleep(500);
        btnSetDate.click();
    }

    public void inputStartDateFuture(){
        waitToBeClickable(10, startDate);
        sleep(500);
        startDate.click();
        sleep(500);
        futureDate.click();
        waitToBeClickable(10, btnSetDate);
        sleep(500);
        btnSetDate.click();
    }

    /** Find ETA picker*/
    @FindBy(xpath = "//*[@id = 'eta']")
    public WebElement etaPicker;

    public void inputEtaDatePast(){
        waitToBeClickable(10, etaPicker);
        sleep(500);
        etaPicker.click();
        sleep(500);
        pastDate.click();
        waitToBeClickable(10, btnSetDate);
        sleep(500);
        btnSetDate.click();
    }

    public void inputEtaDateFuture(){
        waitToBeClickable(10, etaPicker);
        sleep(500);
        etaPicker.click();
        sleep(500);
        futureDate.click();
        waitToBeClickable(10, btnSetDate);
        sleep(500);
        btnSetDate.click();
    }

    /** Find Place input*/
    @FindBy(xpath = "//*[@id = 'place']//input")
    public WebElement placeInput;

    /** Find Place find button*/
    @FindBy(xpath = "//*[@id = 'place']/../button")
    public WebElement btnFindPlace;

    /** Find Place from list*/
    @FindBy(xpath = "//*[@id = 'place']/ng-dropdown-panel")
    private WebElement placeFromList;

    public void inputPlace(String place){
        waitToBeClickable(10,placeInput);
        placeInput.sendKeys(place);
        waitToVisibilityOf(10, btnFindPlace);
        waitToBeClickable(10,btnFindPlace );
        btnFindPlace.click();
        sleep(500);
        placeFromList.click();
    }

    /** Find Order input*/
    @FindBy(xpath = "//*[@id = 'order']//input")
    public WebElement orderInput;

    /** Find Order find button*/
    @FindBy(xpath = "//*[@id = 'order']/../button")
    public WebElement btnFindOrder;

    /** Find Place from list*/
    @FindBy(xpath = "//*[@id = 'order']/ng-dropdown-panel")
    private WebElement orderFromList;

    public void inputOrder(String order){
        waitToBeClickable(10, orderInput);
        orderInput.sendKeys(order);
        btnFindOrder.click();
        waitToBeClickable(10, orderFromList);
        sleep(500);
        orderFromList.click();
    }

    /** Find Probill input*/
    @FindBy(xpath = "//*[@id = 'probill']//input")
    public WebElement probillInput;

    public void inputProbill(String probill){
        waitToBeClickable(10, probillInput);
        probillInput.sendKeys(probill);
        probillInput.sendKeys(Keys.ENTER);
    }

    /** Find Cargo input*/
    @FindBy(xpath = "//*[@id = 'cargo']//input")
    public WebElement cargoInput;

    public void inputCargo(String cargo){
        waitToBeClickable(10, cargoInput);
        cargoInput.sendKeys(cargo);
        cargoInput.sendKeys(Keys.ENTER);
    }

    /** Find Driver 1 input*/
    @FindBy(xpath = "//*[@id = 'driver1']//input")
    public WebElement driver1Input;

    public void inputDriver1(String driver1){
        waitToBeClickable(10, driver1Input);
        driver1Input.sendKeys(driver1);
        driver1Input.sendKeys(Keys.ENTER);
        driver1Input.sendKeys(Keys.ENTER);
    }

    /** Find Driver 2 input*/
    @FindBy(xpath = "//*[@id = 'driver2']//input")
    public WebElement driver2Input;

    public void inputDriver2(String driver2){
        waitToBeClickable(10, driver2Input);
        driver2Input.sendKeys(driver2);
        driver2Input.sendKeys(Keys.ENTER);
        driver2Input.sendKeys(Keys.ENTER);
    }

    /** Find Truck input*/
    @FindBy(xpath = "//*[@id = 'truck']//input")
    public WebElement truckInput;

    public void inputTruck(String truck){
        waitToBeClickable(10, truckInput);
        truckInput.sendKeys(truck);
        truckInput.sendKeys(Keys.ENTER);
        truckInput.sendKeys(Keys.ENTER);
    }

    /** Find Trailer input*/
    @FindBy(xpath = "//*[@id = 'trailer']//input")
    public WebElement trailerInput;

    public void inputTrailer(String trailer){
        waitToBeClickable(10, trailerInput);
        trailerInput.sendKeys(trailer);
        trailerInput.sendKeys(Keys.ENTER);
        trailerInput.sendKeys(Keys.ENTER);
    }

    /** Find Apply Button*/
    @FindBy(xpath = "//button[text() = 'Apply ']")
    public WebElement btnApply;

    public void apllyChanges(){
        waitToBeClickable(10, btnApply);
        btnApply.click();
    }

    /** Find Cancel Button*/
    @FindBy(xpath = "//button[text() = 'Cancel']")
    public WebElement btnCancel;

    public void cancelChanges(){
        waitToBeClickable(10, btnCancel);
        btnCancel.click();
    }
}
