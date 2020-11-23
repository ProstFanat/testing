package logic.webdriver;

import com.jayway.restassured.authentication.FormAuthConfig;
import com.jayway.restassured.config.LogConfig;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import logic.variables.events.EventTimestamp;
import org.apache.log4j.Logger;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.logging.LogType;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.*;
import static logic.webdriver.DriverFactory.getDriver;

public class DriverLogs {
    private static final Logger log = Logger.getLogger(DriverLogs.class);

    public static void printLog(String type) {
        List<LogEntry> entries = getDriver().manage().logs().get(type).getAll();
        System.out.println(entries.size() + " " + type + " log entries found");
        for (LogEntry entry : entries) {
            System.out.println(
                    new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
    }
    public static String getResponseByActionName (String actionName){
        LogEntries logs = getDriver().manage().logs().get(LogType.PERFORMANCE);
        for (LogEntry entry : logs) {
            try {
                JSONObject json = new JSONObject(entry.getMessage());
                JSONObject response = json.getJSONObject("message").getJSONObject("params").getJSONObject("response");
                String url = response.getString("url");
                if (url != null && url.contains(actionName)){
                    //log.info("Found response: " + json.getJSONObject("message").toString());
                    log.info("Response URL: " + url);
                   int status = response.getInt("status");
                   log.info("Status: " + status);
                   if (status!=200)
                       return null;
                   JSONObject headers = response.getJSONObject("headers");
                   String contentDisposition = headers.getString("Content-Disposition");
                    List<String> urlVariables = Arrays.asList(contentDisposition.split("="));
                    String fileName = urlVariables.get(1);
                    log.info("FILENAME = " + fileName);
                    return fileName;
                }
            } catch (JSONException ignore) {
            }
        }
        return null;
    }
/*
    public static void main(String[] args) {
       /* JSONObject json = new JSONObject(str);
        String[] a =  json.getJSONObject("params").getJSONObject("response").getJSONObject("requestHeaders").getString("Cookie").split(";");
        System.out.println(a[0].split("=")[1]);
        Response response = given()
                //.cookie(a[0].split("=")[1])
                .cookie("08AA752927BFA2330EE09CB17C9B9475")
                .when()
                .contentType(ContentType.JSON)
                .get("http://10.10.1.71:8080/TrackEnsure/eldAdmin?actionName=adminGetAllEventsByDriverAndRange" +
                        "&orgId=3353&driverId=34131&dateFrom=1597320000000&dateTo=1597953600000&active=Y&hideEventType9=Y")
                .then()
                .extract().response();
        System.out.println(response.jsonPath().getString(""));
    }
  */
}

