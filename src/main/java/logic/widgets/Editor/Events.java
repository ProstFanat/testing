package logic.widgets.Editor;

import io.qameta.allure.Step;
import logic.pages.companyProfile.drivers.driverProfile.EditorPage;
import logic.variables.Modificators;
import logic.variables.events.EventsList;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Events extends EditorPage {
    private static final Logger log = Logger.getLogger(Events.class);
    //@FindBy(xpath = "/html/body/app-root/div/app-editor/div/div/div/div/div/div[1]/div[2]/app-events/div[2]/div/div/div[2]/app-events-list/div[2]/ngx-datatable/div/datatable-footer/div/div")
    @FindBy(className = "page-count")
    private WebElement eventsCounter;

    public Events() {
        super();
    }

    @Step("Parsing events information from the Events table.")
    public EditorPage parseEvents(EventsList event, Modificators modificator) {
        int value = Integer.parseInt(eventsCounter.getText().replaceAll("[^0-9]", ""));
        int errorCounter = 0;
        while (value == 0 || errorCounter > 5) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            value = Integer.parseInt(eventsCounter.getText().replaceAll("[^0-9]", ""));
            errorCounter++;
        }

        event.setEvent(value, modificator);
        return new EditorPage();
    }

    public EditorPage parseEvents(EventsList event, List<Integer> elementNum, Modificators modificator) {
        event.setEvent(elementNum, modificator);
        return new EditorPage();
    }


}
