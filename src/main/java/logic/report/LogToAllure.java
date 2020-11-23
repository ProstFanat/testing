package logic.report;

import io.qameta.allure.Step;

public class LogToAllure {
    @Step ("{0}")
    public static void logToAllure (String message, String log){}
    @Step ("{0}")
    public static void logToAllure (String message, String object1, String object2){}
    @Step ("{0}")
    public static void logToAllure (String message){}
}
