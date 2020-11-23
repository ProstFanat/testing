package logic.pojo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import logic.csv.csvEvents.EventCSV;
import logic.report.LogToAllure;
import org.apache.log4j.Logger;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class JsonToGsonParser {
    protected static final Logger log = Logger.getLogger(JsonToGsonParser.class);

    public static List<EventsPojo> parseJsonStringToGson(String json){
        Gson gson = new Gson();
        Type eventsListType = new TypeToken<ArrayList<EventsPojo>>(){}.getType();
        ArrayList<EventsPojo> events = gson.fromJson(json, eventsListType);
        log.info("Found events from server: " + events.size());
        LogToAllure.logToAllure("Found events from server", String.valueOf(events.size()));
        return events;
    }



}
