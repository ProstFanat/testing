package resources;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class BasePage {

    public BasePage waitForPageToLoad() {
        new WebDriverWait(WebDriverRunner.getWebDriver(), 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return this;
    }

//    public WebDriverWait wait;
//
//    public WebDriver driver;
//    public BasePage(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//        this.driver = driver;
//    }
//
//    public void DriverSetUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, 10);
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

    public boolean isVisible(SelenideElement element) {
        try {
            element.should(visible);
            return true;
       // } catch (Exception e) {
        } catch (Exception e) {
            return false;
        }
    }

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
//    public String getInputValue(WebElement input){
//        return input.getAttribute("value");
//    }
}

