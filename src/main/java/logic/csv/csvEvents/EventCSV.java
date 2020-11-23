package logic.csv.csvEvents;

import logic.csv.ErrorLogs;
import logic.dbConnection.entity.EventEntity;
import logic.pojo.EventsPojo;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.*;

public abstract class EventCSV {
    protected static final Logger log = Logger.getLogger(EventCSV.class);

    public static final double DELTA = 1;

    protected String eventSequence;
    protected int recordOrigin;
    protected int recordStatus;
    protected int eventType;
    protected int eventCode;
    protected String eventDate;
    protected String eventTime;
    protected double totalVehicleMiles;
    protected double accumulatedVehicleMiles;
    protected double totalEngineHours;
    protected double elapsedEngineHours;
    protected String latitude;
    protected String longitude;
    protected String orderNumber;
    protected String eldUserName;
    protected String orderNumberForRecordOriginator;
    protected double distanceLastValidCoordinates;
    protected int dataDiagnosticEventIndicatorStatus;
    protected String eventDataCheckValue;
    protected int malfunctionIndicatorStatus;
    protected String dateOfTheCertifiedRecord;
    protected String powerUnitNumber;
    protected String vinNumber;
    protected String trailerNumber;
    protected String shippingNumber;
    protected String commentTextOrAnnotation;
    protected String driverLocationDescription;
    protected String malfunctionOrDiagnosticCode;
    public static String driverLoginNameFromDetailsPage;

    public String getEventSequence() {
        return eventSequence;
    }

    public void setEventSequence(String eventSequence) {
        this.eventSequence = eventSequence;
    }

    public int getRecordOrigin() {
        return recordOrigin;
    }

    public void setRecordOrigin(int recordOrigin) {
        this.recordOrigin = recordOrigin;
    }

    public int getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(int recordStatus) {
        this.recordStatus = recordStatus;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public int getEventCode() {
        return eventCode;
    }

    public void setEventCode(int eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public double getTotalVehicleMiles() {
        return totalVehicleMiles;
    }

    public double getAccumulatedVehicleMiles() {
        return accumulatedVehicleMiles;
    }

    public double getTotalEngineHours() {
        return totalEngineHours;
    }

    public double getElapsedEngineHours() {
        return elapsedEngineHours;
    }

    public String getLatitude() {
        try {
            return EventCSV.roundNumToTwoNums(latitude);
        } catch (NumberFormatException exception){
            return latitude;
        }
    }

    public String getLongitude() {
        try {
            return EventCSV.roundNumToTwoNums(longitude);
        } catch (NumberFormatException exception){
            return longitude;
        }
    }

    public void setTotalVehicleMiles(double totalVehicleMiles) {
        this.totalVehicleMiles = totalVehicleMiles;
    }

    public void setAccumulatedVehicleMiles(double accumulatedVehicleMiles) {
        this.accumulatedVehicleMiles = accumulatedVehicleMiles;
    }

    public void setTotalEngineHours(double totalEngineHours) {
        this.totalEngineHours = totalEngineHours;
    }

    public void setElapsedEngineHours(double elapsedEngineHours) {
        this.elapsedEngineHours = elapsedEngineHours;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setEldUserName(String eldUserName) {
        this.eldUserName = eldUserName;
    }

    public String getOrderNumberForRecordOriginator() {
        return orderNumberForRecordOriginator;
    }

    public void setOrderNumberForRecordOriginator(String orderNumberForRecordOriginator) {
        this.orderNumberForRecordOriginator = orderNumberForRecordOriginator;
    }

    public double getDistanceLastValidCoordinates() {
        return distanceLastValidCoordinates;
    }

    public void setDistanceLastValidCoordinates(double distanceLastValidCoordinates) {
        this.distanceLastValidCoordinates = distanceLastValidCoordinates;
    }

    public int getDataDiagnosticEventIndicatorStatus() {
        return dataDiagnosticEventIndicatorStatus;
    }

    public void setDataDiagnosticEventIndicatorStatus(int dataDiagnosticEventIndicatorStatus) {
        this.dataDiagnosticEventIndicatorStatus = dataDiagnosticEventIndicatorStatus;
    }

    public String getEventDataCheckValue() {
        return eventDataCheckValue;
    }

    public void setEventDataCheckValue(String eventDataCheckValue) {
        this.eventDataCheckValue = eventDataCheckValue;
    }

    public int getMalfunctionIndicatorStatus() {
        return malfunctionIndicatorStatus;
    }

    public void setMalfunctionIndicatorStatus(int malfunctionIndicatorStatus) {
        this.malfunctionIndicatorStatus = malfunctionIndicatorStatus;
    }

    public String getDateOfTheCertifiedRecord() {
        return dateOfTheCertifiedRecord;
    }

    public void setDateOfTheCertifiedRecord(String dateOfTheCertifiedRecord) {
        this.dateOfTheCertifiedRecord = dateOfTheCertifiedRecord;
    }

    public void setPowerUnitNumber(String powerUnitNumber) {
        this.powerUnitNumber = powerUnitNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public void setTrailerNumber(String trailerNumber) {
        this.trailerNumber = trailerNumber;
    }

    public void setShippingNumber(String shippingNumber) {
        this.shippingNumber = shippingNumber;
    }

    public String getCommentTextOrAnnotation() {
        return commentTextOrAnnotation.replaceAll("[^A-Za-zА-Яа-я0-9]", "");
    }

    public void setCommentTextOrAnnotation(String commentTextOrAnnotation) {
        this.commentTextOrAnnotation = commentTextOrAnnotation.replaceAll("[^A-Za-zА-Яа-я0-9]", "");
    }

    public String getDriverLocationDescription() {
        return driverLocationDescription;
    }

    public void setDriverLocationDescription(String driverLocationDescription) {
        this.driverLocationDescription = driverLocationDescription;
    }

    public String getMalfunctionOrDiagnosticCode() {
        return malfunctionOrDiagnosticCode;
    }

    public void setMalfunctionOrDiagnosticCode(String malfunctionOrDiagnosticCode) {
        this.malfunctionOrDiagnosticCode = malfunctionOrDiagnosticCode;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getEldUserName() {
        return eldUserName;
    }

    public static String roundNumToTwoNums(String num) {
        DecimalFormat df = new DecimalFormat("#");
        return df.format(Double.parseDouble(num));
    }

    public Optional<EventsPojo> findEventFromCsvInDb(List<EventsPojo> eventFromDb) {
        log.info("** Find event from CSV in DB: ELD Sequence = " + Integer.parseInt(getEventSequence(), 16));
        Optional<EventsPojo> foundEvent = null;
        try {
            foundEvent = eventFromDb
                    .stream()
                    .filter(e -> e.getEldSequence().equals(String.valueOf(Integer.parseInt(getEventSequence(), 16))))
                    .findFirst();
        } catch (java.util.NoSuchElementException exception) {
            log.error("Error! No Such Event! " + exception);
        }
        return foundEvent;
    }
    public String getPowerUnitNumber() {
        return powerUnitNumber;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public String getTrailerNumber() {
        return trailerNumber;
    }

    public String getShippingNumber() {
        return shippingNumber.trim();
    }

    public static String getFieldValueFromJson(String json, String field, int numOfArray) {
        try {
            JSONArray jsonObject = new JSONArray(json);
            int jsonLength = jsonObject.length();
            if (jsonLength>1){
                for(int i=0;i<jsonLength;i++){
                    if(!field.contains(jsonObject.getJSONObject(i).getString("number"))){

                    }
                }
            }
        } catch (JSONException | NullPointerException e){
            log.error(e);
        }
        return "";
    }
    public  abstract void compareEventsFromCsvAndDb(List<EventsPojo> eventsFromDb);
    public void checkEventForRequirement(EventCSV event) {
        if (event.getEventType() == 1 || event.getEventType() == 3) {
            if (event.getEventCode() == 1
                    || event.getEventCode() == 2
                    || event.getEventCode() == 0
                    && !event.getEventSequence().equals("1")){
                assertNotEquals(event.getRecordOrigin(), 1, "getRecordOrigin - ELDSequence=" + event.getEventSequence() + "; ET= "
                        + event.getEventType()+ "; EC= " + event.getEventCode()+ "; RO=" + event.getRecordOrigin() );
            }
        }
        if (event.getEventType() == 2
                || event.getEventType() == 5
                || event.getEventType() == 6
                || event.getEventType() == 7) {
            assertNotEquals(event.getRecordOrigin(), 2,"getRecordOrigin - ELDSequence=" + event.getEventSequence() + "; ET= " + event.getEventType()+
                    "; EC= " + event.getEventCode()+ "; RO=" + event.getRecordOrigin());
        }
        if (event.getEventType() == 4)
            assertNotEquals(event.getRecordOrigin(), 1,"getRecordOrigin - ELDSequence=" +
                    event.getEventSequence() + "; ET= " + event.getEventType()+ "; EC= " + event.getEventCode() + "; RO=" + event.getRecordOrigin());
    }
    protected boolean checkIntValue(int eventFromDb, int eventFromCsv, String nameOfField, String eventSequence){
        log.info("* * * * " + "ELD Sequence= " +eventSequence + "-> " + nameOfField + ": DB= " + eventFromDb + " ; CSV= " + eventFromCsv);
        if(eventFromDb==eventFromCsv)
            return true;
        else
            ErrorLogs.setErrorLogs("ELD Sequence= " +eventSequence + "-> " + nameOfField + ": DB= " + eventFromDb + " ; CSV= " + eventFromCsv + "\n" );
        return false;
    }
    protected boolean checkDoubleValue(double eventFromDb, double eventFromCsv, String nameOfField, String eventSequence){
        log.info("* * * * " + "ELD Sequence= " +eventSequence + "-> " + nameOfField + ": DB= " + eventFromDb + " ; CSV= " + eventFromCsv);
        if((nameOfField.equals("getElapsedEngineHours") && eventFromCsv>99.9)
                || nameOfField.equals("getAccumulatedVehicleMiles") && eventFromCsv>9999 ){
            ErrorLogs.setErrorLogs("ELD Sequence= " +eventSequence + " " + nameOfField + ": DB= " + eventFromDb + " ; CSV= " + eventFromCsv  + "\n" );
            return false;
        }
        if(Math.abs(eventFromDb-eventFromCsv)<=1)
            return true;
        else
            ErrorLogs.setErrorLogs("ELD Sequence= " +eventSequence + " " + nameOfField + ": DB= " + eventFromDb + " ; CSV= " + eventFromCsv  + "\n" );
        return false;
    }
    protected boolean checkStringValue(String eventFromDb, String eventFromCsv, String nameOfField, String eventSequence){
        log.info("* * * * " + "ELD Sequence= " +eventSequence + "-> " + nameOfField + ": DB= " + eventFromDb + " ; CSV= " + eventFromCsv);
        try {
            if (eventFromDb.trim().equals(eventFromCsv.trim())) {
                return true;
            }
        } catch (NullPointerException exception){
            if(eventFromCsv==null && eventFromDb==null || eventFromCsv.equals("") || eventFromDb.equals(""))
                return true;
        }
        ErrorLogs.setErrorLogs("ELD Sequence= " +eventSequence + " " + nameOfField + ": DB= " + eventFromDb + " ; CSV= " + eventFromCsv  + "\n" );
        return false;
    }

    protected boolean checkShippingTrailerNumbersValue(String eventFromDb, String eventFromCsv, String nameOfField, String eventSequence){
        log.info("* * * * " + "ELD Sequence= " +eventSequence + "-> " + nameOfField + ": DB= " + eventFromDb + " ; CSV= " + eventFromCsv);
        if (eventFromCsv.equals("")) {
            if (eventFromDb==null ||eventFromDb.equals("[]")
                    || eventFromDb.equals("[{\"number\":\"\",\"from\":\"\",\"to\":\"\"}]")
                    ||eventFromDb.equals("[{\"number\":null,\"from\":null,\"to\":null}]"))
                return true;
            else
                ErrorLogs.setErrorLogs("ELD Sequence= " + eventSequence + " " + nameOfField + ": DB= " + eventFromDb + " ; CSV= " + eventFromCsv + "\n");
        } else {
            JSONArray jsonObject = new JSONArray(eventFromDb);
            int jsonLength = jsonObject.length();
            if (jsonLength > 1) {
                for (int i = 0; i < jsonLength; i++) {
                    try {
                        String numberValue = jsonObject.getJSONObject(i).getString("number");
                        if (!eventFromCsv.contains(numberValue)) {
                            ErrorLogs.setErrorLogs("ELD Sequence= " + eventSequence + " " + nameOfField + ": DB= " + eventFromDb + " ; CSV= " + eventFromCsv + "\n");
                        }
                    } catch (JSONException | NullPointerException exception) {
                        ErrorLogs.setErrorLogs("ELD Sequence= " + eventSequence + " " + nameOfField + ": DB= " + eventFromDb + " ; CSV= " + eventFromCsv + "\n");
                    }
                }
            }
        }
        /*try {
            if (eventFromCsv.equals("")) {
                if (eventFromDb.equals("") || eventFromDb.contains("{\"number\":\"\",\"from\":\"\",\"to\":\"\"}"))
                    return true;
                else
                    ErrorLogs.setErrorLogs("ELD Sequence= " + eventSequence + " " + nameOfField + ": DB= " + eventFromDb + " ; CSV= " + eventFromCsv + "\n");
            } else {
                String[] numbersFromCsv = eventFromCsv.split(" ");
                for (String number :
                        numbersFromCsv) {
                    if (!eventFromDb.contains(number))
                        ErrorLogs.setErrorLogs("ELD Sequence= " + eventSequence + " " + nameOfField + ": DB= " + eventFromDb + " ; CSV= " + eventFromCsv + "\n");
                }
            }
            ErrorLogs.setErrorLogs("ELD Sequence= " + eventSequence + " " + nameOfField + ": DB= " + eventFromDb + " ; CSV= " + eventFromCsv + "\n");
        } catch (NullPointerException exception)
        {
            ErrorLogs.setErrorLogs("ELD Sequence= " + eventSequence + " " + nameOfField + ": DB= " + eventFromDb + " ; CSV= " + eventFromCsv + "\n");

        }*/
        return false;
    }
    protected boolean checkCoordinatesValue(String eventFromDb, String eventFromCsv, String nameOfField, String eventSequence){
        try {
            if (checkDoubleValue(Double.parseDouble(eventFromDb), Double.parseDouble(eventFromCsv), nameOfField, eventSequence)) {
                log.info("* * * * " + "ELD Sequence= " + eventSequence + "-> " + nameOfField + ": DB= " + eventFromDb + " ; CSV= " + eventFromCsv);
                return true;
            }
        } catch (NumberFormatException exception){
            if (checkStringValue(eventFromDb, eventFromCsv, nameOfField, eventSequence)) {
                log.info("* * * * " + "ELD Sequence= " + eventSequence + "-> " + nameOfField + ": DB= " + eventFromDb + " ; CSV= " + eventFromCsv);
                return true;
            }
        }
        ErrorLogs.setErrorLogs("ELD Sequence= " +eventSequence + " " + nameOfField + ": DB= " + eventFromDb + " ; CSV= " + eventFromCsv  + "\n" );
        return false;
    }

}
