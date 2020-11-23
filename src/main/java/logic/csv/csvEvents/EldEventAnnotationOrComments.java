package logic.csv.csvEvents;

import logic.csv.ErrorLogs;
import logic.dbConnection.entity.EventEntity;
import logic.pojo.EventsPojo;
import logic.variables.events.EventTimestamp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class EldEventAnnotationOrComments extends EventCSV{

    @Override
    public String toString() {
        return "EldEventAnnotationOrComments{" +
                "eldUserName='" + eldUserName + '\'' +
                ", commentTextOrAnnotation='" + commentTextOrAnnotation + '\'' +
                ", driverLocationDescription='" + driverLocationDescription + '\'' +
                ", eventSequence='" + eventSequence + '\'' +
                ", eventDate=" + eventDate +
                ", eventTime=" + eventTime +
                "}\n";
    }

    @Override
    public void compareEventsFromCsvAndDb(List<EventsPojo> eventsFromDb) {
        Optional<EventsPojo> foundEvent = findEventFromCsvInDb(eventsFromDb);
        try{
            log.info("*** CHECK: Compare event form CSV and DB: ELD Sequence = " + foundEvent.get().getEldSequence());
            checkStringValue(driverLoginNameFromDetailsPage,getEldUserName(), "getEldUserName",foundEvent.get().getEldSequence());
            checkStringValue(foundEvent.get().getComment(),getCommentTextOrAnnotation(), "getCommentTextOrAnnotation",foundEvent.get().getEldSequence());
            checkStringValue(EventTimestamp.buildEventTimestampByMilis(foundEvent.get().getEventTimestamp()) , EventTimestamp.csvTimeFormatToTimestamp(getEventDate(), getEventTime()), "getEventTimeStamp",foundEvent.get().getEldSequence());
        } catch (
                NoSuchElementException e){
            log.error("* * * * No Such Event!");
            ErrorLogs.setNoSuchElementLogs("No Such Event! " + "CSV -> " + this.toString() + "DB -> " + foundEvent.toString());
        }
    }

    public static class Builder {
        private EldEventAnnotationOrComments newEldEventAnnotationOrComments;
        public Builder(){
            newEldEventAnnotationOrComments = new EldEventAnnotationOrComments();
        }
        public Builder setEventSequence(String eventSequence){
            newEldEventAnnotationOrComments.eventSequence =eventSequence;
            return this;
        }
        public Builder setCommentTextOrAnnotation(String commentTextOrAnnotation){
            newEldEventAnnotationOrComments.commentTextOrAnnotation =commentTextOrAnnotation;
            return this;
        }
        public Builder setDriverLocationDescription(String driverLocationDescription){
            newEldEventAnnotationOrComments.driverLocationDescription =driverLocationDescription;
            return this;
        }
        public Builder setEldUserName(String eldUserName){
            newEldEventAnnotationOrComments.eldUserName =eldUserName;
            return this;
        }
        public Builder setEventTime(String eventTime){
            newEldEventAnnotationOrComments.eventTime=eventTime;
            return this;
        }
        public Builder setEventDate(String eventDate){
            newEldEventAnnotationOrComments.eventDate=eventDate;
            return this;
        }
        public EldEventAnnotationOrComments build(){
            return newEldEventAnnotationOrComments;
        }
    }
}
