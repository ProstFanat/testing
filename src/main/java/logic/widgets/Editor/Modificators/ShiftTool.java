package logic.widgets.Editor.Modificators;

import io.qameta.allure.Step;
import logic.pages.companyProfile.drivers.driverProfile.EditorPage;
import logic.report.LogToAllure;
import logic.variables.Modificators;
import logic.variables.events.Event;
import logic.variables.events.EventTimestamp;
import logic.variables.events.EventsList;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShiftTool extends EditorPage {

    @FindBy(xpath = "//app-modiffiers/div/div[2]/div[3]/app-shift/div[2]/div[2]/div[1]/div/input")
    private WebElement hoursInput;
    @FindBy(xpath = "//app-modiffiers/div/div[2]/div[3]/app-shift/div[2]/div[3]/div[1]/div/input")
    private WebElement minutesInput;
    @FindAll({
            @FindBy(xpath = "/html/body/app-root/div/app-editor/div/div/div/div/div/div[2]/div/app-modiffiers/div/div[2]/div[3]/app-shift/div[2]/div[2]/div[3]/span[1]"),
            @FindBy(xpath = "/html/body/app-root/div/app-editor/div/div/div/div/div/div[2]/div/app-modiffiers/div/div[2]/div[3]/app-shift/div[2]/div[2]/div[3]/span[2]"),
            @FindBy(xpath = "/html/body/app-root/div/app-editor/div/div/div/div/div/div[2]/div/app-modiffiers/div/div[2]/div[3]/app-shift/div[2]/div[3]/div[3]/span[1]"),
            @FindBy(xpath = "/html/body/app-root/div/app-editor/div/div/div/div/div/div[2]/div/app-modiffiers/div/div[2]/div[3]/app-shift/div[2]/div[3]/div[3]/span[2]")
    })
    private List<WebElement> minMaxTime;
    @FindBy(xpath = "/html/body/app-root/div/app-editor/div/div/div/div/div/div[2]/div/app-modiffiers/div/div[2]/div[3]/app-shift/div[2]/app-bulk/div/div[1]/div[1]/div/div/input")
    private WebElement bulkDateFromShiftInput;
    @FindBy(xpath = "/html/body/app-root/div/app-editor/div/div/div/div/div/div[2]/div/app-modiffiers/div/div[2]/div[3]/app-shift/div[2]/app-bulk/div/div[1]/div[2]/div/div/input")
    private WebElement bulkDateToShiftInput;
    @FindBy(xpath = "/html/body/app-root/div/app-editor/div/div/div/div/div/div[2]/div/app-modiffiers/div/div[2]/div[3]/app-shift/div[2]/app-bulk/div/div[1]/div[1]/div/div/div/button")
    private WebElement bulkDateFromShiftBtn;
    @FindBy(xpath = "/html/body/app-root/div/app-editor/div/div/div/div/div/div[2]/div/app-modiffiers/div/div[2]/div[3]/app-shift/div[2]/app-bulk/div/div[1]/div[2]/div/div/div/button")
    private WebElement bulkDateToShiftBtn;
    @FindBy(xpath = "/html/body/app-root/div/app-editor/div/div/div/div/div/div[2]/div/app-modiffiers/div/div[2]/div[3]/app-shift/div[2]/app-bulk/div/div[2]/div[2]/button[1]")
    private WebElement bulkApplyFillterBtn;
    @FindBy(xpath = "/html/body/app-root/div/app-editor/div/div/div/div/div/div[2]/div/app-modiffiers/div/div[2]/div[3]/app-shift/div[2]/app-bulk/div/div[3]/p/strong")
    private WebElement selectedEventsCounter;
    @FindBy(xpath = "/html/body/app-root/div/app-editor/div/div/div/div/div/div[2]/div/app-modiffiers/div/div[2]/div[3]/app-shift/div[2]/div[3]/div[1]/div")
    private WebElement checkClassMinutesInput;
    @FindBy(xpath = "/html/body/app-root/div/app-editor/div/div/div/div/div/div[2]/div/app-modiffiers/div/div[2]/div[3]/app-shift/div[2]/app-bulk/div/div[3]/p")
    private WebElement thereAroNotEventsLabel;
    @FindBy(xpath = "/html/body/app-root/div/app-editor/div/div/div/div/div/div[2]/div/app-modiffiers/div/div[2]/div[3]/app-shift/div[2]/app-bulk/div/div[2]/div[2]/button[2]")
    private WebElement resetBtn;
    EventTimestamp eventTimestamp = null;
    public List<Integer> hoursAndMinutesToMove = new ArrayList<>();
    private EventsList event = null;
    private EventsList eventAfter = null;
    private EventsList eventBackup = null;
    private int numOfEvents;
    private final Modificators modificator = Modificators.SHIFT;

    public ShiftTool() {
        super();
        eventTimestamp = new EventTimestamp();
        event = new EventsList();
        eventAfter = new EventsList();
    }

    public void setNumOfEvents(int numOfEvents) {
        this.numOfEvents = numOfEvents;
    }

    private static final Logger log = Logger.getLogger(ShiftTool.class);


    public ShiftTool inputHours(List<Integer> time, int coefOfTimeReduction) {
        waitToBeClickable(10, minutesInput);
        hoursInput.clear();
        minutesInput.clear();
        hoursInput.sendKeys(Integer.toString(time.get(0)));
        minutesInput.sendKeys(Integer.toString(time.get(1)));
        log.info("Enter time in  forms for Shift: hour= " + time.get(0) + " minutes=" + time.get(1));
        LogToAllure.logToAllure("Enter time in forms for Shift ", " hour= " + time.get(0) + " minutes=" + time.get(1));
        if (coefOfTimeReduction == 60 && time.get(0) != 0 && time.get(1) != 0) {
            while (!overTimeMinutesCheck(time.get(1))) {
                log.debug("Retrying time entry is greater than maximum");
            }
        }
        return new ShiftTool();
    }

    private boolean overTimeMinutesCheck(int minutes) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (checkClassMinutesInput.getAttribute("class").equals("field-invalid")) {
            return true;
        } else {
            minutesInput.clear();
            minutesInput.sendKeys(Integer.toString(minutes));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    @Step("Click on Preview button on Shift")
    public EditorPage clickOnPreview() {

        return new EditorPage().clickOnPreview();
    }

    @Step("Open Events Tab")
    public EditorPage openEventsTab() {
        return new EditorPage().openEventTab();
    }

    @Step("Click on Date To Button in Bulk")
    public EditorPage clickOnBulkDateToShiftBtn() {
        waitToBeClickable(10, bulkDateToShiftBtn);
        bulkDateToShiftBtn.click();
        return new EditorPage();
    }

    @Step("Click on Date From Button in Bulk")
    public EditorPage clickOnBulkDateFromShiftBtn() {
        waitToBeClickable(10, bulkDateToShiftBtn);
        bulkDateFromShiftBtn.click();
        return new EditorPage();
    }

    @Step("Click on Apply Filter Button")
    public EditorPage clickOnBulkApplyFillterBtn() {
        waitToBeClickable(10, bulkApplyFillterBtn);
        bulkApplyFillterBtn.click();
        return new EditorPage();
    }

    @Step("Calculation of the number of selected events between {0} and {1} events")
    public boolean checkCountSelectedEvents(int eventFrom, int eventTo) {
        int count = 0;
        for (int i = eventTo; i <= eventFrom; i++)
            count++;
        return checkTextOnElement(selectedEventsCounter, Integer.toString(count));
    }

    public ShiftTool moveAndWaitCorrectResult(List<Integer> elementsToSelect, int coefOfTimeReduction, String directionOfMove, String moveMode) {
        EditorPage editor = new EditorPage();
        event = new EventsList();
        eventAfter = new EventsList();
        editor.openEventTab().parseEvents(event, modificator);
        LogToAllure.logToAllure("Parsed events from the Events table", event.getEvent().toString());
        hoursAndMinutesToMove = eventTimestamp.calculateHoursAndMinutes(event, elementsToSelect, coefOfTimeReduction, directionOfMove);
        editor.openShisftTool()
                .openEventsTab()
                .selectElements(elementsToSelect, event)
                .openShisftTool()
                .inputHours(hoursAndMinutesToMove, coefOfTimeReduction);
        if (moveMode.equals("Cancel")) {
            editor.clickCancelBtn();
            openEventTab()
                    .parseEvents(eventAfter, modificator);
            shiftCheckEventsWithoutChanges(elementsToSelect, event, eventAfter);
            hoursAndMinutesToMove.clear();
            return this;
        }

        if (moveMode.equals("Reset")) {
            editor
                    .clickOnResetBtn()
                    .waitToBeSavedChanges();
            openEventTab()
                    .parseEvents(eventAfter, modificator);
            shiftCheckEventsWithoutChanges(elementsToSelect, eventBackup, eventAfter);
            hoursAndMinutesToMove.clear();
            event = eventAfter;
            eventAfter = new EventsList();
            eventBackup = new EventsList();
            return this;
        }


        if (hoursAndMinutesToMove.get(0) == 0 && hoursAndMinutesToMove.get(1) == 0) {
            editor.clickOnInActivePreviewBtn().
                    openEventTab()
                    .parseEvents(eventAfter, modificator);
            shiftCheckEventsWithoutChanges(elementsToSelect, event, eventAfter);
            hoursInput.clear();
            minutesInput.clear();
            resetBtn.click();
            hoursAndMinutesToMove.clear();
            return this;
        }

        if (moveMode.equals("Preview")) {
            editor.clickOnPreview()
                    .waitToBeSavedChangesAfterPreview();
            eventBackup = event;
        }

        if (moveMode.equals("Save")) {
            editor.clickOnPreview()
                    .clickOnSave()
                    .waitToBeSavedChanges();
            eventBackup = new EventsList();
        }

        editor.openEventTab()
                .parseEvents(eventAfter, modificator);
        shiftMoveEventsCheck(elementsToSelect, hoursAndMinutesToMove, event, eventAfter);
        LogToAllure.logToAllure("Parsed events from the Events table after modification", eventAfter.getEvent().toString());
        hoursAndMinutesToMove.clear();
        event = eventAfter;
        eventAfter = new EventsList();
        return this;
    }


    public void moveAndWaitError(List<Integer> elementsToSelect, int coefOfTimeReduction, String directionOfMove) {
        EditorPage editor = new EditorPage();
        if (event.getEvent().size() == 0) {
            event = new EventsList();
            openEventTab().parseEvents(event, modificator);
        }
        hoursAndMinutesToMove = eventTimestamp.calculateHoursAndMinutes(event, elementsToSelect, coefOfTimeReduction, directionOfMove);
        LogToAllure.logToAllure("Parsed events: ", event.getEvent().toString());
        editor.openShisftTool()
                .openEventsTab()
                .selectElements(elementsToSelect, event)
                .openShisftTool()
                .inputHours(hoursAndMinutesToMove, coefOfTimeReduction)
                .clickOnPreview();
        assertTrue(editor.checkNotificationView());
        //assertTrue(editor.checkNotificationTextMsg(NotificationVariables.NOTIFICATION_SHIFT_ERROR_MSG));
        editor.closeNotification().clickCancelBtn();
        editor.openEventTab()
                .parseEvents(eventAfter, elementsToSelect, modificator);
        shiftCheckEventsWithoutChanges(elementsToSelect, event, eventAfter);
        hoursAndMinutesToMove.clear();
        LogToAllure.logToAllure("Events after modification: ", eventAfter.getEvent().toString());
        eventAfter = new EventsList();
    }

    public void checkNotSelectedEventInGapDate(List<Integer> elementsToSelect) {
        openEventTab().parseEvents(event, modificator);
        LogToAllure.logToAllure("Parsed events: ", event.getEvent().toString());
        openShisftTool()
                .openEventsTab()
                .selectElements(elementsToSelect, event)
                .openShisftTool();
        hoursAndMinutesToMove.clear();
        checkTextOnElement(thereAroNotEventsLabel, "There are no events");
    }

    public void moveWithBulkTool(List<Integer> elementsToSelect, int coefOfTimeReduction, String directionOfMove) {
        event = new EventsList();
        openEventTab().parseEvents(event, modificator);
        LogToAllure.logToAllure("Parsed events: ", event.getEvent().toString());
        EditorPage editor = new EditorPage();
        editor.openShisftTool();
        int eventFrom = elementsToSelect.get(1);
        int eventTo = elementsToSelect.get(0);
        clickOnBulkDateFromShiftBtn()
                .clickElement(eventFrom, event)
                .openShisftTool()
                .clickOnBulkDateToShiftBtn()
                .clickElement(eventTo, event)
                .openShisftTool().clickOnBulkApplyFillterBtn();
        assertTrue(new ShiftTool().checkCountSelectedEvents(eventFrom, eventTo), "SelectedEvents");
        elementsToSelect.clear();
        for (int i = eventTo; i <= eventFrom; i++) {
            elementsToSelect.add(i);
        }
        hoursAndMinutesToMove = eventTimestamp.calculateHoursAndMinutes(event, elementsToSelect, coefOfTimeReduction, directionOfMove);
        new ShiftTool().inputHours(hoursAndMinutesToMove, coefOfTimeReduction)
                .clickOnPreview()
                .clickOnSave()
                .waitToBeSavedChanges()
                .openEventTab()
                .parseEvents(eventAfter, modificator);
        shiftMoveEventsCheck(elementsToSelect, hoursAndMinutesToMove, event, eventAfter);
        hoursAndMinutesToMove.clear();
        LogToAllure.logToAllure("Events after modification: ", eventAfter.getEvent().toString());
        eventAfter = new EventsList();
        //elementsToSelect.clear();
    }

    public void moveWithBulkTool(int coefOfTimeReduction, String directionOfMove) {
        List<Integer> elementsToSelect = new ArrayList<>();
        if (event.getEvent().size() == 0) {
            event = new EventsList();
            openEventTab().parseEvents(event, modificator);
        }
        LogToAllure.logToAllure("Parsed events: ", event.getEvent().toString());
        EditorPage editor = new EditorPage();
        editor.openShisftTool();
        clickOnBulkApplyFillterBtn();
        for (int i = 0; i <= event.getEvent().size() - 1; i++) {
            if (event.getEvent().get(i).getIsGapDate().equals("N"))
                elementsToSelect.add(i);
        }
        hoursAndMinutesToMove = eventTimestamp.calculateHoursAndMinutes(event, elementsToSelect, coefOfTimeReduction, directionOfMove);
        new ShiftTool().inputHours(hoursAndMinutesToMove, coefOfTimeReduction)
                .clickOnPreview()
                .clickOnSave()
                .waitToBeSavedChanges()
                .openEventTab()
                .parseEvents(eventAfter, modificator);
        shiftMoveEventsCheck(elementsToSelect, hoursAndMinutesToMove, event, eventAfter);
        hoursAndMinutesToMove.clear();
        LogToAllure.logToAllure("Events after modification: ", eventAfter.getEvent().toString());
        event = eventAfter;
        eventAfter = new EventsList();
        //elementsToSelect.clear();
    }

    public int findBdxEvent() {
        event = new EventsList();
        openEventTab().parseEvents(event, modificator);
        Optional<Event> bdx = null;
        try {
            bdx = event.getEvent().stream().filter(e -> e.getEventName().equals("Border Cross")).findFirst();
            log.info("The BDX event was found: " + bdx.toString());
        } catch (java.util.NoSuchElementException ex) {
            log.error("The BDX event was not found " + ex);
            assertTrue(false, "The BDX event was not found");
        }
        return bdx.get().getEventNum() - 1;
    }

    public void shiftMoveEventsCheck(List<Integer> elementsToSelect, List<Integer> hoursAndMinutesToMove, EventsList event, EventsList eventAfter) {
        for (int elementNum : elementsToSelect) {
            LogToAllure.logToAllure(event.getEvent().get(elementNum).getEventName() + " event time comparison.", "Time before: " + event.getEvent().get(elementNum).getEventTimestamp() +
                    "\n | Time After: " + eventAfter.getEvent().get(elementNum).getEventTimestamp());
            if (event.getEvent().get(elementNum).getIsGapDate().equals("Y")) {
                assertEquals(new EventTimestamp().getEventTimestampAfterModification(elementNum, eventAfter, event),
                        event.getEvent().get(elementNum).getEventTimestamp());
            } else if (event.getEvent().get(elementNum).getIsGapDate().equals("N")) {
                assertEquals(eventTimestamp.getEventTimestampAfterModification(elementNum, eventAfter, event),
                        eventTimestamp.addTime(hoursAndMinutesToMove, event.getEvent().get(elementNum)));
                if (event.getEvent().get(elementNum).getEventName().equals("PC/YM Cleared")) {
                    //int nextEventAfterCleared = elementsToSelect.get(0) - 1;
                    int nextEventAfterCleared = elementNum - 1;
                    assertEquals(eventTimestamp.getEventTimestampAfterModification(nextEventAfterCleared, eventAfter, event),
                            event.getEvent().get(nextEventAfterCleared).addTime(hoursAndMinutesToMove));
                }
            }
        }
    }

    public void shiftCheckEventsWithoutChanges(List<Integer> elementsToSelect, EventsList event, EventsList eventAfter) {
        for (int elementNum : elementsToSelect) {
            LogToAllure.logToAllure(event.getEvent().get(elementNum).getEventName() + " event time comparison.", "Time before: " + event.getEvent().get(elementNum).getEventTimestamp() +
                    "| Event After: " + eventTimestamp.getEventTimestampAfterModification(elementNum, eventAfter, event));
            assertEquals(eventTimestamp.getEventTimestampAfterModification(elementNum, eventAfter, event),
                    event.getEvent().get(elementNum).getEventTimestamp());
        }
    }
}