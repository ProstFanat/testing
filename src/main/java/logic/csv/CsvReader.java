package logic.csv;

import au.com.bytecode.opencsv.CSVReader;
import logic.csv.csvEvents.*;
import logic.pages.companyProfile.drivers.driverInfo.AddDriverProfilePage;
import logic.report.LogToAllure;
import org.apache.log4j.Logger;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;
import static logic.csv.HeadersCsvReport.*;

public class CsvReader {
    private static final Logger log = Logger.getLogger(CsvReader.class);
    public  List <EldEvents> eldEventsList = new ArrayList<>();
    public  List <DriversCertificationActions> driversCertificationActions  = new ArrayList<>();
    public  List <CmvEnginePowerUpAndShutDownEvents> cmvEnginePowerUpAndShutDownEvents = new ArrayList<>();
    public  List <EldEventAnnotationOrComments> eldEventAnnotationOrComments = new ArrayList<>();
    public  List <EldLoginAndLogoutEvents> eldLoginAndLogoutEvents = new ArrayList<>();
    public  List <MalfunctionsAndDataDiagnosticEvents> malfunctionsAndDataDiagnosticEvents = new ArrayList<>();
    public  List <UnidentifiedEvents> unidentifiedEvents = new ArrayList<>();
    public void parseCsvFile(String pathToCsvFile) throws Exception {
        CSVReader reader = new CSVReader(new FileReader(pathToCsvFile), ',' , '"' , 1);
        List<String[]> allRows = reader.readAll();
        String header="";
        for(String[] row : allRows){
            if(row.length==1){
                header = Arrays.toString(row).replaceAll("\\[", "").replaceAll("\\]","");
                continue;
            }
            switch (header)
            {
                case ELD_EVENT_LIST:{
                    eldEventsList.add(new EldEvents
                            .Builder()
                            .setEventSequence(row[0])
                            .setRecordStatus(parseInt(row[1]))
                            .setRecordOrigin(parseInt(row[2]))
                            .setEventType(parseInt(row[3]))
                            .setEventCode(parseInt(row[4]))
                            .setEventDate(row[5])
                            .setEventTime(row[6])
                            .setAccumulatedVehicleMiles(Double.parseDouble(row[7]))
                            .setElapsedEngineHours(Double.parseDouble(row[8]))
                            .setLatitude(row[9])
                            .setLongitude(row[10])
                            .setDistanceLastValidCoordinates(Double.parseDouble(row[11]))
                            .setOrderNumber(row[12])
                            .setOrderNumberForRecordOriginator(row[13])
                            .setMalfunctionIndicatorStatus(parseInt(row[14]))
                            .setDataDiagnosticEventIndicatorStatus(parseInt(row[15]))
                            .setEventDataCheckValue(row[16])
                            .build());
                }
                break;
                case ELD_EVENT_ANNOTATIONS_OR_COMMENTS:{
                    eldEventAnnotationOrComments.add(new EldEventAnnotationOrComments
                            .Builder()
                            .setEventSequence(row[0])
                            .setEldUserName(row[1])
                            .setCommentTextOrAnnotation(row[2])
                            .setEventDate(row[3])
                            .setEventTime(row[4])
                            .setDriverLocationDescription(row[5])
                            .build());
                }
                break;
                case DRIVERS_CERTIFICATION_ACTIONS:{
                    driversCertificationActions.add(new DriversCertificationActions
                            .Builder()
                            .setEventSequence(row[0])
                            .setEventCode(parseInt(row[1]))
                            .setEventDate(row[2])
                            .setEventTime(row[3])
                            .setDateOfTheCertifiedRecord(row[4])
                            .setOrderNumber(row[5])
                            .build());
                }
                break;
                case MALFUNCTIONS_AND_DATA_DIAGNOSTIC_EVENTS:{
                    malfunctionsAndDataDiagnosticEvents.add(new MalfunctionsAndDataDiagnosticEvents
                            .Builder()
                            .setEventSequence(row[0])
                            .setEventCode(parseInt(row[1]))
                            .setMalfunctionOrDiagnosticCode(row[2])
                            .setEventDate(row[3])
                            .setEventTime(row[4])
                            .setTotalVehicleMiles(Double.parseDouble(row[5]))
                            .setTotalEngineHours(Double.parseDouble(row[6]))
                            .setOrderNumber(row[7])
                            .build());
                }
                break;
                case ELD_LOGIN_LOGOUT_REPORT:{
                    eldLoginAndLogoutEvents.add(new EldLoginAndLogoutEvents
                            .Builder()
                            .setEventSequence(row[0])
                            .setEventCode(parseInt(row[1]))
                            .setEldUserName(row[2])
                            .setEventDate(row[3])
                            .setEventTime(row[4])
                            .setTotalVehicleMiles(Double.parseDouble(row[5]))
                            .setTotalEngineHours(Double.parseDouble(row[6]))
                            .build());
                }
                break;
                case CMV_ENGINE_POWER_UP_AND_SHUT_DOWN_ACTIVITY:{
                    cmvEnginePowerUpAndShutDownEvents.add(new CmvEnginePowerUpAndShutDownEvents
                            .Builder()
                            .setEventSequence(row[0])
                            .setEventCode(parseInt(row[1]))
                            .setEventDate(row[2])
                            .setEventTime(row[3])
                            .setTotalVehicleMiles(Double.parseDouble(row[4]))
                            .setTotalEngineHours(Double.parseDouble(row[5]))
                            .setLatitude(row[6])
                            .setLongitude(row[7])
                            .setPowerUnitNumber(row[8])
                            .setVinNumber(row[9])
                            .setTrailerNumber(row[10])
                            .setShippingNumber(row[11])
                            .build());
                }
                break;
                case UNIDENTIFIED_DRIVER_PROFILE_RECORDS:{
                    unidentifiedEvents.add(new UnidentifiedEvents
                            .Builder()
                            .setEventSequence(row[0])
                            .setRecordStatus(parseInt(row[1]))
                            .setRecordOrigin(parseInt(row[2]))
                            .setEventType(parseInt(row[3]))
                            .setEventCode(parseInt(row[4]))
                            .setEventDate(row[5])
                            .setEventTime(row[6])
                            .setAccumulatedVehicleMiles(Double.parseDouble(row[7]))
                            .setElapsedEngineHours(Double.parseDouble(row[8]))
                            .setLatitude(row[9])
                            .setLongitude(row[10])
                            .setDistanceLastValidCoordinates(Double.parseDouble(row[11]))
                            .setOrderNumber(row[12])
                            .setMalfunctionIndicatorStatus(parseInt(row[13]))
                            .setEventDataCheckValue(row[14])
                            .build());
                }
            }

        }
        int totalEventsFromCsv = eldEventsList.size() +  driversCertificationActions.size() +
                malfunctionsAndDataDiagnosticEvents.size() + eldLoginAndLogoutEvents.size() +cmvEnginePowerUpAndShutDownEvents.size()
                + unidentifiedEvents.size();
        log.info("Found events from CSV File:" +
                "TOTAL EVENTS = " + totalEventsFromCsv + "\n" +
                " ELD_EVENT_LIST = " + eldEventsList.size() + "\n" +
                " ELD_EVENT_ANNOTATIONS_OR_COMMENTS = " + eldEventAnnotationOrComments.size() + "\n" +
                " DRIVERS_CERTIFICATION_ACTIONS = " + driversCertificationActions.size() + "\n" +
                " MALFUNCTIONS_AND_DATA_DIAGNOSTIC_EVENTS = " + malfunctionsAndDataDiagnosticEvents.size() + "\n" +
                " ELD_LOGIN_LOGOUT_REPORT = " + eldLoginAndLogoutEvents.size() + "\n" +
                " CMV_ENGINE_POWER_UP_AND_SHUT_DOWN_ACTIVITY = " + cmvEnginePowerUpAndShutDownEvents.size() + "\n" +
                " UNIDENTIFIED_DRIVER_PROFILE_RECORDS = " + unidentifiedEvents.size() + "\n"
        );
        LogToAllure.logToAllure("Found events from CSV File", String.valueOf(totalEventsFromCsv));
    }
}
