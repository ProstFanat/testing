package logic.csv;

import logic.report.LogToAllure;

import java.util.ArrayList;
import java.util.List;

public class ErrorLogs {
    public static List<String> noSuchElementLogs = new ArrayList<>();
    public static List<String> errorLogs = new ArrayList<>();
    public static List<String> getNoSuchElementLogs() {
        LogToAllure.logToAllure("Complete No Such Elements Logs", noSuchElementLogs.toString());
        return noSuchElementLogs;
    }

    public static void setNoSuchElementLogs(String log) {
        ErrorLogs.noSuchElementLogs.add(log);
    }

    public static List<String> getErrorLogs() {
        LogToAllure.logToAllure("Complete Final Error Logs", errorLogs.toString());
        return errorLogs;
    }

    public static void setErrorLogs(String log) {
        ErrorLogs.errorLogs.add(log);
    }


}
