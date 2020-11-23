package logic.pages;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TriggersPage extends BasePage {
    @FindBy(tagName = "h2")
    private WebElement pageHeader;
    @FindBy(css = "li[heading='Zone Trigger List']")
    private WebElement zoneTriggerTab;
    @FindBy(id = "trigger-zone-list-table")
    private WebElement triggerZoneListTable;
    @FindBy(css = "li[heading='Movement Trigger List']")
    private WebElement movementTriggerTab;
    @FindBy(id = "trigger-movement-list-table")
    private WebElement triggerMovementListTable;
    @FindBy(css = "li[heading='Signal Delay Trigger List']")
    private WebElement signalDelayTriggerTab;
    @FindBy(id = "trigger-signal-delay-list-table")
    private WebElement triggerSignalDelayListTable;
    @FindBy(css = "li[heading='Scheduler List']")
    private WebElement schedulerTab;
    @FindBy(id = "trigger-scheduler-list-table")
    private WebElement triggerSchedulerListTable;
    @FindBy(css = "li[heading='Violation Trigger List']")
    private WebElement violationTriggerTab;
    @FindBy(id = "violation-trigger-list-table")
    private WebElement violationTriggerListTable;
    @FindBy(css = "li[heading='Speed Limit Trigger List']")
    private WebElement speedLimitTriggerTab;
    @FindBy(id = "speed-limit-trigger-list-table")
    private WebElement speedLimitTriggerListTable;
    @FindBy(css = "a[ng-click='vm.createNewTrigger()']")
    private WebElement createNewTriggerBtn;
    @FindBy(css = "select[ng-model='vm.chosenTrigger']")
    private WebElement newTriggerSelect;
    @FindBy(css = "button[ng-click='vm.cancel()']")
    private WebElement cancelBtn;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(60, pageHeader);
        if (!isElementDisplayedOnPage(pageHeader, "Page Header")) errorsCount++;
        if (!checkTextOnElement(pageHeader, "View Triggers")) errorsCount++;

        PdfReport.createNewSubAnchorBold("Zone Trigger tab");
        if (!isElementDisplayedOnPage(zoneTriggerTab, "Zone Trigger tab")) errorsCount++;
        else {
            if (!isElementDisplayedOnPage(triggerZoneListTable, "Trigger Zone List table")) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Movement Trigger tab");
        if (!isElementDisplayedOnPage(movementTriggerTab, "Movement Trigger tab")) errorsCount++;
        else {
            movementTriggerTab.click();
            waitToVisibilityOf(10, triggerMovementListTable);
            if (!isElementDisplayedOnPage(triggerMovementListTable, "Trigger Movement List table")) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Signal Delay Trigger tab");
        if (!isElementDisplayedOnPage(signalDelayTriggerTab, "Signal Delay Trigger tab")) errorsCount++;
        else {
            signalDelayTriggerTab.click();
            waitToVisibilityOf(10, triggerSignalDelayListTable);
            if (!isElementDisplayedOnPage(triggerSignalDelayListTable, "Signal Delay List table")) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Schedule tab");
        if (!isElementDisplayedOnPage(schedulerTab, "Schedule tab")) errorsCount++;
        else {
            schedulerTab.click();
            waitToVisibilityOf(10, triggerSchedulerListTable);
            if (!isElementDisplayedOnPage(triggerSchedulerListTable, "Scheduler table")) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Violation Trigger tab");
        if (!isElementDisplayedOnPage(violationTriggerTab, "Violation Trigger tab")) errorsCount++;
        else {
            violationTriggerTab.click();
            waitToVisibilityOf(10, violationTriggerListTable);
            if (!isElementDisplayedOnPage(violationTriggerListTable, "Violation List table")) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Speed Limit Trigger List tab");
        if (!isElementDisplayedOnPage(speedLimitTriggerTab, "Speed Limit Trigger tab")) errorsCount++;
        else {
            speedLimitTriggerTab.click();
            waitToVisibilityOf(10, speedLimitTriggerListTable);
            if (!isElementDisplayedOnPage(speedLimitTriggerListTable, "Speed Limit List table")) errorsCount++;
        }

        if (!isElementDisplayedOnPage(createNewTriggerBtn, "Create New Trigger button")) errorsCount++;
        else {
            PdfReport.createNewSubAnchorBold("Create New Trigger modal");
            createNewTriggerBtn.click();
            waitToVisibilityOf(10, newTriggerSelect);
            if (!isElementDisplayedOnPage(newTriggerSelect, "New Trigger select")) errorsCount++;
            cancelBtn.click();
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
