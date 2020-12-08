package logic.widgets.Editor.Modificators;

import logic.pages.companyProfile.drivers.driverProfile.EditorPage;
import logic.variables.ModificationStep;
import logic.variables.Modificators;
import logic.variables.events.*;
import logic.widgets.Editor.DropList;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;


public class CreateTool extends EditorPage {
    private EventsList event = null;

    public CreateTool() {
        super();
    }

    private DropList dropList = new DropList();
    @FindBy(xpath = "//app-add/div[2]/div[2]/div[1]/div/input")
    private WebElement eventTimeInput;
    @FindBy(css = "ng-select[placeholder='Select Event Type']")
    private WebElement selectEventType;
    @FindBy(css = "ng-select[placeholder='Select Duty Status']")
    private WebElement selectDutyStatus;
    @FindBy(css = "ng-select[placeholder='Select Time Zone']")
    private WebElement selectTimeZone;
    @FindBy(css = "input[placeholder='Odometer']")
    private WebElement totalVehicleMilesField;
    @FindBy(css = "input[placeholder='Total Engine Hours']")
    private WebElement totalEngineHoursField;
    @FindBy(css = "ng-select[placeholder='State/Province']")
    private WebElement stateProvinceField;
    @FindBy(css = "ng-select[placeholder='Truck']")
    private WebElement truckField;
    @FindBy(css = "input[placeholder='City']")
    private WebElement cityField;
    @FindBy(css = "input[placeholder='Trailer Number']")
    private WebElement trailerNumberField;
    @FindBy(css = "input[placeholder='Trailer Odometer']")
    private WebElement trailerOdometerField;
    @FindBy(css = "input[placeholder='Trailer License']")
    private WebElement trailerLicenseField;
    @FindBy(css = "input[placeholder='Shipping Number']")
    private WebElement shippingNumberField;
    @FindBy(css = "input[placeholder='Shipping From']")
    private WebElement shippingFromField;
    @FindBy(css = "input[placeholder='Shipping To']")
    private WebElement shippingToField;
    @FindBy(css = "input[placeholder='Accumulated Vehicle Miles']")
    private WebElement accumulatedVehicleMilesField;
    @FindBy(css = "input[placeholder='Elapsed Engine Hours']")
    private WebElement elapsedEngineHoursField;
    @FindBy(css = "input[placeholder='Latitude']")
    private WebElement latitudeField;
    @FindBy(css = "input[placeholder='Longitude']")
    private WebElement longitudeField;
    @FindBy(css = "textarea[class='form-control']")
    private WebElement commentField;
    @FindBy(css = "input[id='eventDuration']")
    private WebElement specifyEventDurationCheckBox;
    @FindBy(css = "input[id='splitExistingEvent']")
    private WebElement specifyExistingEventCheckBox;
    @FindBy(css = "input[placeholder='hours']")
    private WebElement hoursSpecifyEventField;
    @FindBy(css = "input[placeholder='minutes']")
    private WebElement minutesSpecifyEventField;
    @FindBy(xpath = "/app-add/div[2]/div[11]/div[2]/div[2]/input")
    private WebElement dateSpecifyEventField;
    private String eventTimestampFormat;
    private EventTimestamp eventTimestamp = new EventTimestamp();
    private static final Logger log = Logger.getLogger(CreateTool.class);
    private List<Event> createdEvents = new ArrayList<>();
    private final Modificators modificator = Modificators.CREATE;
    private final String TRUCK = "146622";

    public CreateTool enterTimeOfEvent(int hours, int minutes, int changeDateCoef) {
        eventTimeInput.click();
        DatePickerTool datePickerTool = new DatePickerTool(Integer.toString(hours), Integer.toString(minutes), changeDateCoef);
        datePickerTool.selectDay();
        if (hours != -1) {
            datePickerTool.inputHoursAndMinutes();
        }
        datePickerTool.clickSetTime();
        eventTimestampFormat = datePickerTool.getDayDate() + " " + datePickerTool.getHoursInput() + ":" + datePickerTool.getMinutesInput();
        return this;
    }

    public CreateTool selectEventType(String eventType, String eventCode) {
        log.info("Try to select the following event values: " + eventType + " / " + eventCode);
        if (eventType.equals("") || eventCode.equals("")) {
            log.warn("Type / event code field not selected: " + eventType + " / " + eventCode);
            return this;
        }
        dropList.selectItemInDropList(selectEventType, eventType);
        dropList.selectItemInDropList(selectDutyStatus, eventCode);
        return this;
    }

    public CreateTool selectTimeZone() {
        log.info("Try to select Time Zone");
        dropList.selectFirstItemInDropList(selectTimeZone);
        return this;
    }

    public CreateTool selectTruck() {
        log.info("Try to select Truck Number");
        dropList.selectItemInDropList(truckField, TRUCK);
        return this;
    }

    public CreateTool selectState() {
        log.info("Try to select State");
        dropList.selectFirstItemInDropList(stateProvinceField);
        return this;
    }

    public CreateTool enterCityValue(String city) {
        log.info("Enter City field: " + city);
        waitToVisibilityOf(10, cityField);
        cityField.clear();
        cityField.sendKeys(city);
        return this;
    }

    public CreateTool enterTotalVehicleMiles(String totalVehicleMiles) {
        log.info("Enter Total Vehicle Miles  field: " + totalVehicleMiles);
        totalVehicleMilesField.clear();
        totalVehicleMilesField.sendKeys(totalVehicleMiles);
        return this;
    }

    public CreateTool enterTotalEngineHours(String teh) {
        log.info("Enter Total Engine Hours  field: " + teh);
        totalEngineHoursField.clear();
        totalEngineHoursField.sendKeys(teh);
        return this;
    }

    public CreateTool enterCoordinates() {
        log.info("Enter Longitude and Latitude  fields: M");
        latitudeField.clear();
        longitudeField.clear();
        latitudeField.sendKeys("M");
        longitudeField.sendKeys("M");
        return this;
    }

    public CreateTool checkSpecifyEventDurationCheckBox() {
        specifyEventDurationCheckBox.click();
        return this;
    }

    public CreateTool checkSpecifyExistingEventCheckBox() {
        specifyExistingEventCheckBox.click();
        return this;
    }

    public CreateTool enterSpecifyTime(int hours, int minutes) {
        hoursSpecifyEventField.clear();
        minutesSpecifyEventField.clear();
        hoursSpecifyEventField.sendKeys(Integer.toString(hours));
        minutesSpecifyEventField.sendKeys(Integer.toString(minutes));
        return this;
    }

    public CreateTool createEventAndWaitCorrectResult(Event createdEvent, int hours, int minutes, int changeDateCoef, ModificationStep modificationStep) {
        event = new EventsList();
        enterValuesInForms(createdEvent, hours, minutes, changeDateCoef);
        if (hours == -1) {
            openEventTab().parseEvents(event, modificator);
            createdEvent.setEventTimestamp(event.getEvent().get(0).getEventTimestamp());
        } else
            createdEvent.setEventTimestamp(eventTimestamp.buildEventTimestamp(eventTimestampFormat));

        if (modificationStep == ModificationStep.CANCEL) {
            clickCancelBtn();
            openEventTab().parseEvents(event, modificator);
            Optional<Event> elementTofind = eventTimestamp.findEventByTimestamp(createdEvent, event);
            assertEquals(elementTofind, Optional.empty());
        } else if (modificationStep == ModificationStep.PREVIEW || modificationStep == ModificationStep.SAVE) {
            clickOnPreview().waitToBeSavedChanges();
            if (modificationStep == ModificationStep.PREVIEW) {
                openEventTab().parseEvents(event, modificator);
                Optional<Event> elementToFind = eventTimestamp.findEventByTimestamp(createdEvent, event);
                checkCorrectCreatedEvent(createdEvent, elementToFind);
                createdEvents.add(createdEvent);
            }
            if (modificationStep == ModificationStep.SAVE) {
                clickOnSave();
                openEventTab().parseEvents(event, modificator);
                for (Event eventAfterCreate : createdEvents) {
                    Optional<Event> elementToFind = eventTimestamp.findEventByTimestamp(eventAfterCreate, event);
                    checkCorrectCreatedEvent(eventAfterCreate, elementToFind);
                }
                createdEvents.clear();
            }
        }
        return this;
    }

    public void resetCreatedEventsInPreview() {
        clickOnResetBtn();
        waitToBeSavedChanges();
        Optional<Event> canceledEvent = null;
        for (Event eventAfterCancel : createdEvents) {
            boolean flag = false;
            int toTry = 1;
            while (!flag) {
                if (canceledEvent != null && canceledEvent.equals(Optional.empty())) flag = true;
                else if (toTry < 5) {
                    event = new EventsList();
                    openEventTab().parseEvents(event, modificator);
                    canceledEvent = eventTimestamp.findEventByTimestamp(eventAfterCancel, event);
                    toTry++;
                } else if (toTry >= 5) break;
            }
            assertEquals(canceledEvent, Optional.empty());
        }
    }

    public CreateTool multiSaveSpecifyCreatedEvents() {
        clickOnSave();
        EventsList eventsAfter = new EventsList();
        openEventTab().parseEvents(eventsAfter, modificator);
        try {
            for (int i = 0; i < eventsAfter.getEvent().size(); i++) {
                assertEquals(event.getEvent().get(i).getEventName(), eventsAfter.getEvent().get(i).getEventName());
                assertEquals(event.getEvent().get(i).getEventTimestamp(), eventsAfter.getEvent().get(i).getEventTimestamp());
                assertEquals(event.getEvent().get(i).getRecordOrigin(), eventsAfter.getEvent().get(i).getRecordOrigin());
            }
        } catch (IndexOutOfBoundsException e) {
            fail("Events list size before Save and after is no Equal " + e);
        }
        return this;
    }

    public CreateTool createEventAndWaitCorrectResult(Event createdEvent, int hours, int minutes, int changeDateCoef, ModificationStep createMode, String specifyMode, int timeChangesCoef) {
        event = new EventsList();
        waitToBeSavedChanges();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        openEventTab().parseEvents(event, modificator);
        enterValuesInForms(createdEvent, hours, minutes, changeDateCoef);
        if (createdEvent.getEventType().equals(EventsType.DRIVER_DUTY_STATUS_CHANGED)
                || createdEvent.getEventName().equals(EventsCode.PERSONAL_USE)
                || createdEvent.getEventName().equals(EventsCode.YARD_MOVE)) {
            checkSpecifyEventDurationCheckBox();
            if (specifyMode.equals("Split Existing Event"))
                checkSpecifyExistingEventCheckBox();
            createdEvent.setEventTimestamp(eventTimestamp.buildEventTimestamp(eventTimestampFormat));
            List<Integer> time = eventTimestamp.calculateMaxSpecifyTime(createdEvent, event, timeChangesCoef);
            log.info("The time that is inserted into the form for the Create Specify Event: " + time.get(0) + " h. " + time.get(1) + " m.");
            enterSpecifyTime(time.get(0), time.get(1));
            if (createMode == ModificationStep.CANCEL) {
                clickCancelBtn();
                openEventTab().parseEvents(event, modificator);
                Optional<Event> elementTofind = eventTimestamp.findEventByTimestamp(createdEvent, event);
                assertEquals(elementTofind, Optional.empty());
            } else if (createMode == ModificationStep.PREVIEW || createMode == ModificationStep.SAVE) {
                clickOnPreview().waitToBeSavedChanges();
                if (createMode == ModificationStep.PREVIEW) {
                } else if (createMode == ModificationStep.SAVE) {
                    clickOnSave().waitToBeSavedChanges();
                }
                event = new EventsList();
                openEventTab().parseEvents(event, modificator);
                Optional<Event> elementTofind = eventTimestamp.findEventByTimestamp(createdEvent, event);
                checkCorrectCreatedEvent(createdEvent, elementTofind);
                Optional<Event> dutyEventAfterCreated = eventTimestamp.findEventByTimestamp(eventTimestamp.addTime(time, createdEvent), event);
                log.info("CHECK: Created event after Specify/Split: " + dutyEventAfterCreated.get().toString());
                assertNotEquals(Optional.empty(), dutyEventAfterCreated);
            }
        } else {
            log.info("CHECK: Check for the absence of Specify and Split elements when creating vertical events");
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            isElementPresent(By.cssSelector("input[id='splitExistingEvent']"));
            isElementPresent(By.cssSelector("input[id='eventDuration']"));
            isElementPresent(By.cssSelector("input[placeholder='hours']"));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            clickCancelBtn();
        }
        return this;
    }


    public CreateTool createEventAndWaitError(Event createdEvent, int hours, int minutes, int changeDateCoef) {
        if (event == null) event = new EventsList();
        enterValuesInForms(createdEvent, hours, minutes, changeDateCoef);
        clickOnPreview();
        assertTrue(new EditorPage().checkNotificationView());
        new EditorPage().closeNotification().clickCancelBtn();
        createdEvent.setEventTimestamp(eventTimestamp.buildEventTimestamp(eventTimestampFormat));
        openEventTab().parseEvents(event, modificator);
        /*if (0 != event.getEvent().get(0).getEventTimestamp().compareTo(createdEvent.getEventTimestamp())) {
            Optional<Event> elementFind = eventTimestamp.findEventByTimestamp(createdEvent, event);
            assertEquals(elementFind, Optional.empty());
        }*/
        return this;
    }

    public CreateTool createEventAndWaitError(Event createdEvent, int hours, int minutes, int changeDateCoef, String createMode, int timeChangesCoef) {
        openEventTab().parseEvents(event, modificator);
        enterValuesInForms(createdEvent, hours, minutes, changeDateCoef);
        checkSpecifyEventDurationCheckBox();
        if (createMode.equals("Split Existing Event"))
            checkSpecifyExistingEventCheckBox();
        if (hours == -1)
            enterSpecifyTime(1, 1);
        else {
            createdEvent.setEventTimestamp(eventTimestamp.buildEventTimestamp(eventTimestampFormat));
            List<Integer> time = eventTimestamp.calculateMaxSpecifyTime(createdEvent, event, timeChangesCoef);
            log.info("The time that is inserted into the form for the Create Specify Event: " + time.get(0) + " h. " + time.get(1) + " m.");
            enterSpecifyTime(time.get(0), time.get(1));
        }
        clickOnPreview();
        assertTrue(new EditorPage().checkNotificationView());
        new EditorPage().closeNotification().clickCancelBtn();
        createdEvent.setEventTimestamp(eventTimestamp.buildEventTimestamp(eventTimestampFormat));
        openEventTab().parseEvents(event, modificator);
        Optional<Event> elementTofind = eventTimestamp.findEventByTimestamp(createdEvent, event);
        assertEquals(elementTofind, Optional.empty());
        return this;
    }

    private void enterValuesInForms(Event createdEvent, int hours, int minutes, int changeDateCoef) {
        enterTimeOfEvent(hours, minutes, changeDateCoef)
                .selectEventType(createdEvent.getEventType(), createdEvent.getEventName())
                .selectState()
                .enterCityValue("New City")
                .selectTimeZone()
                .selectTruck()
                .enterTotalVehicleMiles(createdEvent.getTotalVehicleMiles())
                .enterTotalEngineHours(createdEvent.getTotalEngineHours())
                .enterCoordinates();
    }

    private void checkCorrectCreatedEvent(Event createdEvent, Optional<Event> elementTofind) {
        log.info("CHECK: Comparison of entered data and data after creation: Entered Data: " + createdEvent.toString() + " --- Created event: " + elementTofind.get().toString());
        assertEquals(elementTofind.get().getEventName(), createdEvent.getEventName());
        assertEquals(elementTofind.get().getEventTimestamp(), createdEvent.getEventTimestamp());
        assertEquals(elementTofind.get().getTotalEngineHours(), createdEvent.getTotalEngineHours());
        assertEquals(elementTofind.get().getTotalVehicleMiles(), createdEvent.getTotalVehicleMiles());
        if (createdEvent.getEventType().equals(EventsType.AUTHENTICATED_ACTIVITY)
                || createdEvent.getEventType().equals(EventsType.ENGINE_ACTIVITY)
                || createdEvent.getEventType().equals(EventsType.MALFUNCTION_OR_DATE_DIAGNOSTIC))
            assertEquals(elementTofind.get().getRecordOrigin(), "1");
        else if (createdEvent.getEventType().equals(EventsType.PERSONAL_USE_AND_YARD_MOVE)
                || createdEvent.getEventName().equals(EventsCode.OFF_DUTY)
                || createdEvent.getEventName().equals(EventsCode.ON_DUTY)
                || createdEvent.getEventName().equals(EventsCode.SLEEPER_BERTH))
            assertEquals(elementTofind.get().getRecordOrigin(), "2");
        if (createdEvent.getEventName().equals(EventsCode.PERSONAL_USE)) {
            assertEquals(event.getEvent().get(elementTofind.get().getEventNum()).getEventName(), "Off Duty");
            log.info("CHECK: Before the created Personal Use event " + event.getEvent().get(elementTofind.get().getEventNum()) + " event is displayed.");
        } else if (createdEvent.getEventName().equals(EventsCode.YARD_MOVE)) {
            assertEquals(event.getEvent().get(elementTofind.get().getEventNum()).getEventName(), "On Duty");
            log.info("CHECK: Before the created Yard Move event " + event.getEvent().get(elementTofind.get().getEventNum()) + " event is displayed.");
        }
        if ((createdEvent.getEventName().equals(EventsCode.PERSONAL_USE) || (createdEvent.getEventName().equals(EventsCode.YARD_MOVE))) && elementTofind.get().getEventNum() != 1) {
            assertEquals(event.getEvent().get(elementTofind.get().getEventNum() - 2).getEventName(), "PC/YM Cleared");
            log.info("CHECK: After the created PC/YM event " + event.getEvent().get(elementTofind.get().getEventNum() - 2) + " event is displayed.");
        }
        if (createdEvent.getEventType().equals(EventsType.DRIVER_DUTY_STATUS_CHANGED) || createdEvent.getEventType().equals(EventsType.PERSONAL_USE_AND_YARD_MOVE)) {
            try {
                if (event.getEvent().size() > 2 && (event.getEvent().get(elementTofind.get().getEventNum() + 1).getEventName().equals(EventsCode.PERSONAL_USE)
                        || event.getEvent().get(elementTofind.get().getEventNum() + 1).getEventName().equals(EventsCode.YARD_MOVE))) {
                    assertEquals(event.getEvent().get(elementTofind.get().getEventNum()).getEventName(), "PC/YM Cleared");
                    log.info("CHECK: Before the created event " + event.getEvent().get(elementTofind.get().getEventNum()) + " event is displayed.");
                }
            } catch (IndexOutOfBoundsException e) {
                log.error("There are no necessary quantity of events for check" + e);
            }
        }
    }
}
