package logic.variables.events;

import logic.pages.companyProfile.drivers.driverProfile.EditorPage;
import logic.variables.Modificators;
import logic.widgets.Editor.Events;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class EventsList extends EditorPage {
    private static final Logger log = Logger.getLogger(EventsList.class);
    public List<Event> event = new ArrayList<>();

    public EventsList() {
        super();
    }

    public Events setEvent(int numOfEvents, Modificators modificator) {
        log.info("Start parsing events: to parse " + numOfEvents + " events");
        for (int i = 1; i <= numOfEvents; i++) {
            switch (modificator){
                case CREATE:{
                    this.event.add(new Event
                            .Builder(i)
                            .setEventName()
                            .setEventTimestamp()
                            .setEventId()
                            .setTotalVehicleMiles()
                            .setTotalEngineHours()
                            .setTruckNumber()
                            .setIsGapDate()
                            .setRecordOrigin()
                            .setRecordStatus()
                            .build());
                }
                break;
                case SHIFT:
                case TRANSFER:{
                    this.event.add(new Event
                            .Builder(i)
                            .setEventName()
                            .setEventTimestamp()
                            .setEventId()
                            .setIsGapDate()
                            .setRecordOrigin()
                            .setRecordStatus()
                            .build());
                }
            }
            log.info("Parsing event №" + i + " " + this.event.get(i - 1).toString());
        }
        return new Events();
    }

    public Events setEvent(List<Integer> elementNum, Modificators modificator) {
        int i = 0;
        for (int element :
                elementNum) {
            switch (modificator){
                case CREATE:{
                    this.event.add(new Event
                            .Builder(element+1)
                            .setEventName()
                            .setEventTimestamp()
                            .setEventId()
                            .setTotalVehicleMiles()
                            .setTotalEngineHours()
                            .setTruckNumber()
                            .setIsGapDate()
                            .setRecordOrigin()
                            .setRecordStatus()
                            .build());
                }
                break;
                case SHIFT:
                case TRANSFER:{
                    this.event.add(new Event
                            .Builder(element+1)
                            .setEventName()
                            .setEventTimestamp()
                            .setEventId()
                            .setIsGapDate()
                            .setRecordOrigin()
                            .setRecordStatus()
                            .build());
                }
            }
            log.info("Parsing event №" + element + " " + this.event.get(i).toString());
            i++;
        }
        return new Events();
    }

    public List<Event> getEvent() {
        return event;
    }

}
