package logic.widgets.Editor.Modificators;

import logic.pages.companyProfile.drivers.driverProfile.EditorPage;
import logic.report.LogToAllure;
import logic.variables.ModificationStep;
import logic.variables.Modificators;
import logic.variables.events.Event;
import logic.variables.events.EventsList;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.*;

public class DeleteTool extends EditorPage {
    @FindBy(css = "input[type='checkbox']")
    private WebElement nextEventToFillTheGapCheckbox;
    private EventsList events = null;
    private EventsList eventAfter = null;
    private EventsList eventsToDelete = null;
    private final Modificators modificator = Modificators.TRANSFER;
    private final EditorPage editor = new EditorPage();
    private static final Logger log = Logger.getLogger(TransferTool.class);
    private final List<Integer> elementsToSelect;
    private boolean isShiftNextEvent;

    public DeleteTool(List<Integer> elementsToSelect, boolean isShiftNextEvent) {
        this.elementsToSelect = elementsToSelect;
        this.isShiftNextEvent = isShiftNextEvent;
    }


    public void toDeleteEvent(ModificationStep step) {
        events = new EventsList();
        editor
                .openEventTab()
                .parseEvents(events, modificator)
                .openDeleteTool();
        LogToAllure.logToAllure("Parsed events from the Events table", events.getEvent().toString());
        selectElements(elementsToSelect, events);
        eventsToDelete = setEventsListByNumsOfEvents(events, elementsToSelect);
        clickCheckbox(nextEventToFillTheGapCheckbox, isShiftNextEvent, "Shift next event to fill the gap (only on duty status)");
        if (step == ModificationStep.PREVIEW)
            clickOnPreview()
                    .waitToBeSavedChanges();
        else if (step == ModificationStep.SAVE)
            clickOnPreview()
                    .clickOnSave()
                    .waitToBeSavedChanges();
    }

    public void isEventDeleted() {
        eventAfter = new EventsList();
        editor
                .openEventTab()
                .parseEvents(eventAfter, modificator)
                .openDeleteTool();
        LogToAllure.logToAllure("Parsed events from the Events table", events.getEvent().toString());
        for (Event event : eventsToDelete.getEvent()) {
            Event foundEvent = findElement(event, eventAfter, "id");
            if (event.getEventName().equals("Intermediate log")) {
                log.info("CHECK: Event from table is  " + event.getEventName());
                assertNotNull(foundEvent, event.getEventName() + " - not found in table!");
            } else {
                assertNull(foundEvent);
            }
            if (isShiftNextEvent) {
                Event oldEvent = events.event.get(event.getEventNum() - 2);
                Event currentEvent = findElement(event, eventAfter, "timestamp");
                System.out.println("oldEvent" + oldEvent.toString());
                System.out.println("currentEvent" + currentEvent.toString());
                assertEquals(currentEvent.getEventName(), oldEvent.getEventName(), "eventName");
                assertEquals(currentEvent.getEventTimestamp(), event.getEventTimestamp(), "timeStamp");
                assertEquals(currentEvent.getEventId(), oldEvent.getEventId(), "getEventId");
                assertEquals(currentEvent.getRecordOrigin(), oldEvent.getRecordOrigin(), "getEventId");
            }
        }
    }

    public boolean isCorrectDeleteValidation() {
        waitToVisibilityOf(20, errorToast);
        clickOnElement(errorToast);
        isEventsNotDeleted();
        return true;
    }

    public void isEventsNotDeleted() {
        eventAfter = new EventsList();
        editor.openEventTab().parseEvents(eventAfter, modificator);
        eventsToDelete.getEvent().forEach(event -> {
            Event foundEvent = findElement(event, eventAfter, "id");
            assertNotNull(foundEvent);
            log.info("CHECK: Events from old table and new table: " + event.toString() + " | " + foundEvent.toString());
            assertEquals(event.getEventName(), foundEvent.getEventName());
        });
    }

    public void setShiftNextEvent(boolean shiftNextEvent) {
        isShiftNextEvent = shiftNextEvent;
    }

    public boolean isShiftNextEvent() {
        return isShiftNextEvent;
    }
}
