package logic.widgets.Editor.Modificators;

import logic.pages.companyProfile.drivers.driverProfile.EditorPage;
import logic.report.LogToAllure;
import logic.variables.Accounts;
import logic.variables.ModificationStep;
import logic.variables.Modificators;
import logic.variables.events.Event;
import logic.variables.events.EventsList;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.*;

public class TransferTool extends EditorPage {
    @FindBy(css = "ng-select[placeholder='Select Driver']")
    private WebElement driverForTransferSelector;
    private EventsList events = null;
    private EventsList eventAfter = null;
    private EventsList eventsToTransfer = null;
    private final Modificators modificator = Modificators.TRANSFER;
    private final EditorPage editor = new EditorPage();
    private static final Logger log = Logger.getLogger(TransferTool.class);
    private List<Integer> elementsToSelect;

    public TransferTool() {
        super();
    }

    public TransferTool(List<Integer> elementsToSelect) {
        this.elementsToSelect = elementsToSelect;
    }

    private void selectDriverForTransfer(String driverName) {
        selectItemInSelector(driverForTransferSelector, driverName, "Select Driver", "span");
    }

    public TransferTool toTransferEvents(ModificationStep step) {
        events = new EventsList();
        editor
                .openEventTab()
                .parseEvents(events, modificator)
                .openTransferTool();
        LogToAllure.logToAllure("Parsed events from the Events table", events.getEvent().toString());
        eventsToTransfer = setEventsListByNumsOfEvents(events, elementsToSelect);
        selectElements(elementsToSelect, events);
        selectDriverForTransfer(Accounts.DRIVER_TO_TRANSFER_NAME);
        if (step == ModificationStep.PREVIEW)
            clickOnPreview()
                    .waitToBeSavedChanges();
        else if (step == ModificationStep.SAVE)
            clickOnPreview()
                    .clickOnSave()
                    .waitToBeSavedChanges();
        return this;
    }

    public boolean isCorrectTransferValidation() {
        waitToVisibilityOf(20, errorToast);
        clickOnElement(errorToast);
        isEventsTransferredToAnotherDriver();
        return true;
    }

    public void isEventsTransferredToAnotherDriver() {
        eventAfter = new EventsList();
        editor.openEventTab().parseEvents(eventAfter, modificator);
        eventsToTransfer.getEvent().forEach(event -> {
            Event foundEvent = findElement(event, eventAfter, "timestamp");
            if (event.getEventName().equals("Border Cross") || event.getEventName().contains("certification")) {
                log.info("CHECK: Event from old table is  " + event.getEventName());
                assertNull(foundEvent);
            } else {
                assertNotNull(foundEvent);
                log.info("CHECK: Events from old table and new table: " + event.toString() + " | " + foundEvent.toString());
                assertEquals(event.getEventName(), foundEvent.getEventName());
                checkRecordOrigin(foundEvent);
            }
        });
    }

    public void checkThatThereAreNoEventsInTable() {
        eventAfter = new EventsList();
        editor.openEventTab().parseEvents(eventAfter, modificator);
        LogToAllure.logToAllure("Parsed events from the Events table", events.getEvent().toString());
        for (Event event : eventsToTransfer.getEvent()) {
            Event foundEvent = findElement(event, eventAfter, "id");
            if (event.getEventName().equals("Border Cross") || event.getEventName().contains("certification")) {
                log.info("CHECK: Event from table is  " + event.getEventName());
                assertNotNull(foundEvent, event.getEventName() + " - not found in table!");
            } else {
                assertNull(foundEvent);
            }
        }
    }


}
