package logic.variables.events;

public class EventCounter {
    private static int counter = 1;
    static public int plusEvent(){
        return counter++;
    }
    public static int getEventCount(){
        return counter;
    }
}
