package resources;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertFalse;

public class BasePage {

    public WebDriver driver;
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitToBeClickable (int timeOut, WebElement element){
        try {
            new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions
                            .elementToBeClickable(element));
        } catch (TimeoutException e){
            System.out.println("Test failed. Time to wait is end " + e);
        }
    }

    public void waitToVisibilityOf (int timeOut, WebElement element){
        new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
    }

    public Boolean isElementPresent(String path) {
        try {
            driver.findElement(By.xpath(path));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementDisplayed(WebElement element){
        try {
            element.isDisplayed();
            return true; // Success!
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    public boolean isElementDisplayedByPath(String path){
        try {
            driver.findElement(By.xpath(path));
            return true; // Success!
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isVisible(WebElement element){
        try {
            element.click();
            return true; // Success!
        } catch (ElementNotInteractableException ignored) {
            return false;
        }
    }

    public String getInputValue(WebElement input){
        return input.getAttribute("value");
    }
}

