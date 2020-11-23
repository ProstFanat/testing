package logic.variables;

import logic.BasePage;
import logic.report.LogToAllure;
import logic.webdriver.DriverFactory;
import logic.webdriver.DriverLogs;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static logic.webdriver.DriverFactory.getDriver;

public class UrlVariables extends BasePage {


    public static String getBaseURL() {
        //String testPlace = System.getProperty("TestPlace");
        String testPlace = "Local";
        if (testPlace.equals("Prod"))
            return "https://trackensure.com/";
        else if (testPlace.equals("CA"))
            return "https://trackensure.ca/";
        else if (testPlace.equals("TestServer"))
            return "http://64.191.45.114:8081/TrackEnsure/";
        //return "http://10.10.1.158:8080/TrackEnsure/";
        return "http://192.168.0.102:8080/TrackEnsure/";
    }

    public static String dateInMilliseconds (){
        return "app/hos/#/eldHOS/editor/driver/"+Accounts.TEST_DRIVER_ID+"/timestamp/" + new Date().getTime() + "/timeZone/US%2FCentral";
    }

    public static String parseInfoFromUrl(String neededValue){
        List<String> urlVariables = Arrays.asList(getDriver().getCurrentUrl().split("/"));
        String driverId = urlVariables.get(urlVariables.indexOf(neededValue)+1);
        log.info("Parsed Driver ID from URL: " + driverId);
        LogToAllure.logToAllure("Parsed Driver ID from URL: ", driverId);
        return driverId;
    }

    public static String buildStringForGetEvents(HashMap <String, String> queryParameters){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getBaseURL())
                .append("eldAdmin?")
                .append("actionName=adminGetAllEventsByDriverAndRange")
                .append("&orgId=")
                .append(queryParameters.get("orgId"))
                .append("&driverId=")
                .append(queryParameters.get("driverId"))
                .append("&dateFrom=")
                .append(queryParameters.get("dateFrom"))
                .append("&dateTo=")
                .append(queryParameters.get("dateTo"))
                .append("&active=N&hideEventType9=Y");
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
    public static String checkGenerateHosReport(String responseName) {
        int tryCount = 1;
        boolean flag = false;
        while (!flag || tryCount < 60) {
            log.info("Try# " + tryCount);
            String result = DriverLogs.getResponseByActionName(responseName);
            if (result!=null) {
                return result;
            } else {
                tryCount++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
       return null;
    }
    @Override
    public boolean isAllRequiredElementsPresent() {
        return false;
    }
}
