package logic;

import logic.report.LogToAllure;
import logic.report.PdfReport;
import logic.variables.TestConstant;
import logic.webdriver.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static logic.webdriver.DriverFactory.getDriver;
import static org.testng.Assert.*;

public abstract class BasePage {
    protected static final Logger log = Logger.getLogger(BasePage.class);

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isAllRequiredElementsPresent();

    /*Нажатие на элемент со всеми нужными ожиданиями и логированием*/
    protected void clickOnElement(WebElement button) {
        waitToVisibilityOf(20, button);
        waitToBeClickable(20, button);
        log.info("Click on " + button.getText() + " button");
        LogToAllure.logToAllure("Click on " + button.getText() + " button");
        button.click();
    }

    /*Метод для активации чекбокса: Если чекбокс находится в нужном состоянии то ничего не делается*/
    protected void clickCheckbox(WebElement checkbox, boolean flag, String checkboxName) {
        waitToVisibilityOf(10, checkbox);
        if (checkbox.isSelected() != flag)
            checkbox.click();
        log.info("Set " + checkboxName + " checkbox - " + flag);
        LogToAllure.logToAllure("Set " + checkboxName + " checkbox", String.valueOf(flag));
    }

    /*Ввод текста в поле*/
    protected void inputTextInField(WebElement field, String text, String fieldName) {
        waitToVisibilityOf(10, field);
        if (!field.getAttribute("value").equals(text)) {
            field.clear();
            field.sendKeys(text);
            log.info("Input value in " + fieldName + " Field - " + text);
            LogToAllure.logToAllure("Input value in " + fieldName + " Field", text);
        } else
            log.info("** Text in " + fieldName + " field and text from user is equal: " + field.getAttribute("value") + " | " + text + " . Skip input to field.");
        if (!field.getAttribute("value").equals(text)) {
            inputTextInField(field, text, fieldName);
        }
    }

    /*Выбирается нужный пункт в кастомном селекторе, tag - это элемент который нужно выбрать*/
    protected void selectItemInSelector(WebElement selector, String itemName, String fieldName, String tag) {
        waitToVisibilityOf(10, selector);
        if (selector.getText().equals(itemName)) {
            log.info("** Text in " + fieldName + " field and text from user is equal: " + selector.getText() + " | " + itemName + " . Skip input to field.");
        } else {
            clickOnElement(selector);
            WebElement item = driver.findElement(By.xpath("//" + tag + "[contains(text(),'" + itemName + "')]"));
            clickOnElement(item);
        }
        log.info("Select value in selector " + fieldName + " - " + itemName);
        LogToAllure.logToAllure("Select value in selector " + fieldName, itemName);
    }

    /*Сравнение необходимого текста и текста с элемента*/
    protected boolean checkTextOnElement(WebElement element, String text) {
        if (element.getText().equals(text)) {
            log.info(element.getText() + " text is equals - " + text);
            LogToAllure.logToAllure("Text is equals", element.getText(), text);
            return true;
        } else {
            log.info(element.getText() + " text is NOT equals - " + text);
            LogToAllure.logToAllure("Text is NOT equals", element.getText(), text);
            return false;
        }
    }

    /*Ожидание когда элемент будет кликабельный*/
    protected void waitToBeClickable(int timeOut, WebElement element) {
        try {
            new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions
                            .elementToBeClickable(element));
        } catch (TimeoutException e) {
            log.error("Test failed. Time to wait is end " + e);
            fail("Test failed. Time to wait is end");
        }
    }

    /*Ожидание когда нужный текст появится в элементе*/
    protected void waitTextToBePresentInElement(int timeOut, String text, WebElement element) {
        try {
            new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.textToBePresentInElementValue(element, text));
        } catch (TimeoutException e) {
            log.error("Test failed. Time to wait is end " + e);
        }
    }

    /*Проверка есть ли элемент на странице*/
    protected void isElementPresent(By path) {
        boolean check;
        try {
            driver.findElement(path);
            check = true;
        } catch (NoSuchElementException e) {
            check = false;
        }
        assertFalse(check);
    }

    /*Проверка отображается ли элемент на странице*/
    protected boolean isElementDisplayedOnPage(WebElement element, String elementName) {
        try {
            if (element.isDisplayed()) {
                PdfReport.writeErrorToReport(elementName, true);
                log.info(elementName + " is displayed");
                LogToAllure.logToAllure(elementName + " is displayed");
                return true;
            } else {
                PdfReport.writeErrorToReport(elementName, false);
                log.error(elementName + " is NOT displayed");
                LogToAllure.logToAllure(elementName + " is NOT displayed");
                return false;
            }
        } catch (NoSuchElementException e) {
            PdfReport.writeErrorToReport(elementName, false);
            log.error(elementName + " is NOT displayed");
            LogToAllure.logToAllure(elementName + " is NOT displayed");
            return false;
        }
    }

    /*Проверка есть ли элемент на странице*/
    protected boolean isElementPresent(WebElement element) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            if (element.isDisplayed() && element.isEnabled()) {
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                return true;
            }
        } catch (NoSuchElementException | ElementClickInterceptedException | TimeoutException | StaleElementReferenceException e) {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            log.error(e);
            return false;
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return false;
    }

    /*Добавление новой вкладки браузера*/
    protected void addNewTab() {
        ((JavascriptExecutor) getDriver()).executeScript(TestConstant.ADD_NEW_TAB);
    }

    /*Ожидание оторажение элемента на странице*/
    protected void waitToVisibilityOf(int timeOut, WebElement element) {
        new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
    }

    /*Возвращает случайный набор чисел*/
    public static String GET_RANDOM_NUMS() {
        return Long.toString((long) (new Date().getTime() + Math.random() * 200 - 100));
    }

    /*Возвращает лист всех строк таблицы*/
    public List<WebElement> findAllRowsInTable(WebElement table) {
        waitToVisibilityOf(10, table);
        try {
            return table.findElements(By.className("ui-grid-row"));
        } catch (NoSuchElementException e) {
            log.error(e);
            return null;
        } finally {
            log.info("Find all rows in table");
        }
    }

    protected boolean assertTextValue(String actualResult, String expectedResult, String textComment){
        log.info("Text comparison ( "+textComment+" ) : Actual = " + actualResult +", Expected = " + expectedResult);
        boolean result;
        if (actualResult.equals(expectedResult)) {
            log.info("*** Texts is equals!");
            result = true;
        } else {
            log.error("*** Texts is NOT equals!");
            LogToAllure.logToAllure("Inconsistency found! " + textComment,actualResult, expectedResult );
            result =  false;
        }
        PdfReport.writeErrorToReport("Text comparison ( "+textComment+" ) : Actual = " + actualResult +", Expected = " + expectedResult, result);
        return result;
    }

    protected boolean assertBoolValue(boolean actualResult, boolean expectedResult, String textComment){
        log.info("Boolean value comparison ( "+textComment+" ) : Actual = " + actualResult +", Expected = " + expectedResult);
        boolean result;
        if (actualResult==expectedResult) {
            log.info("*** Values is equals!");
            result = true;
        } else {
            log.error("*** Values is NOT equals!");
            result =  false;
        }
        PdfReport.writeErrorToReport("Boolean value comparison ( "+textComment+" ) : Actual = " + actualResult +", Expected = " + expectedResult, result);
        return result;
    }

    /*Поиск нужного элемента в таблице, с учетом фильтра*/
    public WebElement findItemByFilterInGrid(WebElement filterField, String itemValue, String itemName) {
        waitToVisibilityOf(10, filterField);
        filterField.clear();
        filterField.sendKeys(itemValue);
        List<WebElement> element;
        WebElement foundElement = null;
        int errorCount = 0;
        try {
            while (errorCount < 10) {
                element = driver.findElements(By.className("ui-grid-row"));
                try {
                    foundElement = element.stream().filter(x -> x.getText().contains(itemValue)).findFirst().orElse(null);
                } catch (StaleElementReferenceException e) {
                    continue;
                }
                if (element != null && element.size() == 1)
                    return foundElement;
                else
                    errorCount++;
            }
        } catch (NoSuchElementException e) {
            log.error(e);
            fail("No Such Element in grid");
        }
        log.info("Find " + itemName + " by value:  " + itemValue);
        LogToAllure.logToAllure("Find " + itemName + " by value:  " + itemValue, itemValue);
        return foundElement;
    }

    /*Закрытие нотификации*/
    protected void closeNotificationWindow() {
        WebElement closeBtn = driver.findElement(By.cssSelector("button[ng-click='growlMessages.deleteMessage(message)']"));
        clickOnElement(closeBtn);
    }

    /*Нажатие на элемент на странице (поиск по тексту)*/
    protected void clickOnItemInGrid(String itemValue, String itemName) {
        try {
            By pathToItem = By.cssSelector("a[title='" + itemValue + "']");
            waitToBeClickable(10, driver.findElement(pathToItem));
            WebElement truckNumberGrid = driver.findElement(pathToItem);
            truckNumberGrid.click();
            log.info("Click on item in " + itemName + " : " + itemValue);
        } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
            log.error(e);
            clickOnItemInGrid(itemValue, itemName);
        } catch (TimeoutException | NoSuchElementException e) {
            log.error(e);
            fail(e.toString());
        }
    }
}
