package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriverWait wait;

    public WebDriver driver;

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

//    public BasePage(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//        this.driver = driver;
//    }
//
//    public void waitToBeClickable (int timeOut, WebElement element){
//        try {
//            new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class)
//                    .until(ExpectedConditions
//                            .elementToBeClickable(element));
//        } catch (TimeoutException e){
//            System.out.println("Test failed. Time to wait is end " + e);
//        }
//    }
//
//    public void waitToVisibilityOf (int timeOut, WebElement element){
//        new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
//    }
//
//    public Boolean isElementPresent(String path) {
//        try {
//            driver.findElement(By.xpath(path));
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    public boolean isElementDisplayed(WebElement element){
//        try {
//            element.isDisplayed();
//            return true; // Success!
//        } catch (NoSuchElementException ignored) {
//            return false;
//        }
//    }
//
//    public boolean isElementDisplayedByPath(String path){
//        try {
//            driver.findElement(By.xpath(path));
//            return true; // Success!
//        } catch (NoSuchElementException ignored) {
//            return false;
//        }
//    }
//
//    public void sleep(int time){
//        try {
//            Thread.sleep(time);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public boolean isVisible(WebElement element){
//        try {
//            element.click();
//            return true; // Success!
//        } catch (ElementNotInteractableException ignored) {
//            return false;
//        }
//    }
//
//    public void DriverSetUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, 10);
//    }
//
//    public String getInputValue(WebElement input){
//        return input.getAttribute("value");
//    }
}

