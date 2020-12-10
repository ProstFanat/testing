package DeleteButton;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.*;

public class BasePage {

    public WebDriver driver;
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    protected void waitToBeClickable (int timeOut, WebElement element){
        try {
            new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions
                            .elementToBeClickable(element));
        } catch (TimeoutException e){
            System.out.println("Test failed. Time to wait is end " + e);
        }
    }

    protected void waitToVisibilityOf (int timeOut, WebElement element){
        new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
    }

    protected void isElementPresent(By path) {
        boolean check;
        try {
            driver.findElement(path);
            check = true;
        } catch (NoSuchElementException e) {
            check = false;
        }
        Assertions.assertFalse(check);
    }

    public void sleep(int i) {
    }
}
