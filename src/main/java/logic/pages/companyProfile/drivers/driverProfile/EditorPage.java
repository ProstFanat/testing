package logic.pages.companyProfile.drivers.driverProfile;


import io.qameta.allure.Step;
import logic.BasePage;
import logic.report.LogToAllure;
import logic.variables.events.Event;
import logic.variables.events.EventsCode;
import logic.variables.events.EventsList;
import logic.widgets.Editor.Events;
import logic.widgets.Editor.Modificators.CreateTool;
import logic.widgets.Editor.Modificators.TransferTool;
import logic.widgets.Editor.OpenTransactionForm;
import logic.widgets.Editor.Modificators.ShiftTool;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class EditorPage extends BasePage {
    @FindBy(className = "toast-error")
    protected WebElement errorToast;
    @FindBy(xpath = "//button[contains(text(),'Open Transaction')]")
    private WebElement openTransactionBtn;
    @FindBy(xpath = "//li[contains(text(),'Events')]")
    private WebElement eventsTabBtn;
    @FindBy(css = "button[title='Create']")
    private WebElement createToolBtn;
    @FindBy(css = "button[title='Transfer']")
    private WebElement transferToolBtn;
    @FindBy(css = "button[title='Shift']")
    private WebElement shiftToolBtn;
    @FindBy(css = "button[title='Delete']")
    private WebElement deleteToolBtn;
    @FindBy(xpath = "//button[contains(text(),'Preview')]")
    private WebElement previewBtn;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement saveBtn;
    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    private WebElement deleteTransaction;
    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    private WebElement yesDeleteTransaction;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelBtn;
    @FindBy(xpath = "//*[@id='toast-container']/div/div")
    private WebElement notificationErrorBlock;
    @FindBy(xpath = "//button[contains(text(),'Go to Viewer')]")
    private WebElement goToViewerBtn;
    @FindBy(xpath = "//app-modiffiers/div/div[2]/div[4]/div/button[2]")
    private WebElement resetBtn;
    @FindBy(css = "ng-select[placeholder='Driver Name']")
    private WebElement driverSelector;
    @FindBy(xpath = "//li[contains(text(),'eLog')]")
    private WebElement elogTab;
    private static final Logger log = Logger.getLogger(EditorPage.class);

    public EditorPage() {
        super();
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        return false;
    }

    private static int tryCount = 0;


    @Step("Change driver")
    public EditorPage changeDriverView(String driverName) {
        selectItemInSelector(driverSelector, driverName, "Driver Name", "span");
        return this;
    }

    @Step("Click on Open Transaction button")
    public OpenTransactionForm openTransaction() {
        try {
            waitToVisibilityOf(40, openTransactionBtn);
            waitToBeClickable(40, openTransactionBtn);
            openTransactionBtn.click();
            log.info("Click on Open Transaction Button");
        } catch (NoSuchElementException | ElementClickInterceptedException | StaleElementReferenceException e) {
            log.error(e);
            if (isElementPresent(deleteTransaction)) {
                deleteTransaction();
            } else openTransaction();
        }
        return new OpenTransactionForm();
    }


    public EditorPage clickOnResetBtn() {
        clickOnElement(resetBtn);
        return this;
    }

    public EditorPage openTransactionAndInputValues() {
        if (isTransactionOpen()) {
            deleteTransaction();
        }
        openTransaction()
                .inputComment("Comment")
                .inputDescription("Description")
                .clickOnSave().openEventTab();
        return this;

    }

    @Step("Click on Create Tool modificator button")
    public CreateTool openCreateTool() {
        clickOnElement(createToolBtn);
        return new CreateTool();
    }

    @Step("Click on Delete Tool modificator button")
    public CreateTool openDeleteTool() {
        clickOnElement(deleteToolBtn);
        return new CreateTool();
    }

    @Step("Click on Transfer Tool modificator button")
    public TransferTool openTransferTool() {
        clickOnElement(transferToolBtn);
        return new TransferTool();
    }

    @Step("Click on Shift Tool modificator button")
    public ShiftTool openShisftTool() {
        clickOnElement(shiftToolBtn);
        return new ShiftTool();
    }

    @Step("Click on  Preview button")
    public EditorPage clickOnPreview() {
        clickOnElement(previewBtn);
        return this;
    }

    public EditorPage clickOnInActivePreviewBtn() {
        previewBtn.click();
        return this;
    }

    public EditorPage clickOnCancelForWait() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Click on Save button")
    public EditorPage clickOnSave() {
        clickOnElement(saveBtn);
        return this;
    }

    public EditorPage waitToBeSavedChanges() {
        long start = System.nanoTime();
        waitToBeClickable(20, goToViewerBtn);
        while (goToViewerBtn.getAttribute("disabled")!=null){}
        long end = System.nanoTime();
        log.info("Wait to saved changes = " + TimeUnit.SECONDS.convert((end - start), TimeUnit.NANOSECONDS) + " seconds");
        return this;
    }

    public EditorPage waitToBeSavedChangesAfterPreview() {
        long start = System.nanoTime();
        waitToBeClickable(20, saveBtn);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        log.info("Wait to saved changes = " + TimeUnit.SECONDS.convert((end - start), TimeUnit.NANOSECONDS) + " seconds");
        return this;
    }


    @Step("Delete transaction")
    public EditorPage deleteTransaction() {
        try {
            waitToVisibilityOf(50, deleteTransaction);
            waitToBeClickable(50, deleteTransaction);
            deleteTransaction.click();
        } catch (StaleElementReferenceException e) {
            log.error(e);
            return deleteTransaction();
        } catch (ElementClickInterceptedException e) {
            if (tryCount < 20) {
                driver.navigate().refresh();
                log.error(e);
                tryCount++;
                return deleteTransaction();
            } else {
                fail(e.toString());
            }
        }
        waitToVisibilityOf(50, yesDeleteTransaction);
        yesDeleteTransaction.click();
        waitToVisibilityOf(20, openTransactionBtn);
        waitToBeClickable(20, openTransactionBtn);
        return this;
    }

    @Step("Select elements {0}")
    public EditorPage selectElements(List<Integer> elementToSelect, EventsList event) {
        elementToSelect.forEach(elementNum -> clickElement(elementNum, event));
        return this;
    }

    public boolean isTransactionOpen() {
        return isElementPresent(deleteTransaction);
    }

    public EditorPage clickElement(int elementToSelect, EventsList event) {
        try {
            String elementId = event.getEvent().get(elementToSelect).getEventId();
            LogToAllure.logToAllure("Select element " + event.getEvent().get(elementToSelect).getEventName(), event.getEvent().get(elementToSelect).toString());
            WebElement element = driver.findElement(By.xpath("//span[@class='ng-star-inserted' and contains(text(), '" + elementId + "')]"));
            waitToVisibilityOf(10, element);
            element.click();
            log.info("Click on element: " + element.toString());
        } catch (StaleElementReferenceException e) {
            log.error("Click Element №" + elementToSelect + " " + e);
            clickElement(elementToSelect, event);
        }

        return this;
    }

    @Step("Click on Event Tab Open button")
    public Events openEventTab() {
        waitToBeClickable(30, eventsTabBtn);
        try {
            eventsTabBtn.click();
        } catch (ElementClickInterceptedException e) {
            log.error(e);
            if (tryCount < 5) {
                tryCount++;
                openEventTab();
            } else fail();
        }

        return new Events();
    }

    public EditorPage openElogTab() {
        clickOnElement(elogTab);
        return this;
    }

    @Step("Click on Cancel button")
    public EditorPage clickCancelBtn() {
        waitToBeClickable(10, cancelBtn);
        cancelBtn.click();
        return this;
    }

    @Step("Checking Shift Error Display.")
    public boolean checkNotificationView() {
        return notificationErrorBlock.isEnabled();
    }

    @Step("Checking the text of the Shift error:{0}")
    public boolean checkNotificationTextMsg(String textMsg) {
        return checkTextOnElement(notificationErrorBlock, textMsg);
    }

    @Step("Closing the Shift Error Notification.")
    public EditorPage closeNotification() {
        waitToBeClickable(15, notificationErrorBlock);
        notificationErrorBlock.click();
        return this;
    }


    public List<Integer> findIntermediateEvents(List<Integer> elementNum, EventsList event) {
        int num = 0;
        for (Event thisEvent : event.getEvent()) {
            if (thisEvent.getEventName().equals("Intermediate log") && event.getEvent().get(thisEvent.getEventNum()).getEventName().equals("Intermediate log")) {
                num = thisEvent.getEventNum();
                elementNum.add(num);
                log.info("Find intermediate event: " + thisEvent.toString());
            }
            if (thisEvent.getEventName().equals("Intermediate log") && event.getEvent().get(thisEvent.getEventNum() - 2).getEventName().equals("Intermediate log") && !event.getEvent().get(thisEvent.getEventNum()).getEventName().equals("Intermediate log")) {
                num = thisEvent.getEventNum();
                elementNum.add(num);
                log.info("Find intermediate event: " + thisEvent.toString());
            }
        }
        return elementNum;
    }

    protected void checkRecordOrigin(Event event) {
        if (event.getEventName().equals(EventsCode.LOGIN)
                | event.getEventName().equals(EventsCode.LOGOUT)
                | event.getEventName().equals(EventsCode.POWER_UP)
                | event.getEventName().equals(EventsCode.POWER_DOWN)
                | event.getEventName().equals(EventsCode.ELD_MULFUNCTION_LOGGED)
                | event.getEventName().equals(EventsCode.ELD_MULFUNCTION_CLEARED)
                | event.getEventName().equals(EventsCode.DATA_DIAGNOSTIC_EVENT_LOGGED)
                | event.getEventName().equals(EventsCode.DATA_DIAGNOSTIC_EVENT_CLEARED)
        )
            assertEquals(event.getRecordOrigin(), "1");
        else if (event.getEventName().equals(EventsCode.OFF_DUTY)
                | event.getEventName().equals(EventsCode.SLEEPER_BERTH)
                | event.getEventName().equals(EventsCode.PERSONAL_USE)
                | event.getEventName().equals(EventsCode.YARD_MOVE)
                | event.getEventName().equals(EventsCode.PC_YM_CLEARED))
            assertEquals(event.getRecordOrigin(), "2");
    }

    protected Event findElement(Event event, EventsList eventsList, String findBy) {
        Event foundEvent = null;
        try {
            if (findBy.equals("id"))
                foundEvent = eventsList.getEvent().stream().filter(e -> e.getEventId().equals(event.getEventId())).findFirst().orElse(null);
            else if (findBy.equals("timestamp"))
                foundEvent = eventsList.getEvent().stream().filter(e -> e.getEventTimestamp().equals(event.getEventTimestamp())).findFirst().orElse(null);
            log.info("The event was found: " + foundEvent.toString());
        } catch (NullPointerException ex) {
            log.error("The event was not found " + event.toString());
        }
        return foundEvent;
    }

    protected EventsList setEventsListByNumsOfEvents(EventsList allEvents, List<Integer> elementsToSelect) {
        EventsList selectedEvents = new EventsList();
        elementsToSelect.forEach(elementNum -> selectedEvents.getEvent().add(allEvents.getEvent().get(elementNum)));
        log.info("Events to be selected: " + selectedEvents.getEvent().toString());
        return selectedEvents;
    }
}
