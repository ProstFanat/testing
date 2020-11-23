package logic.trackensureLogs;
import java.util.ArrayList;
import logic.dbConnection.entity.DriverProfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.testng.Assert.*;

public class Logs {
    public Logs() {
    }

    private ArrayList<String> logFileStrings = new ArrayList<>();

    public void readStatisticFile(){
        FileReader logFile;
        try {
            logFile = new FileReader("/home/evgeniy/dev/logs/statistics.log");
            BufferedReader reader = new BufferedReader(logFile);
            String line = null;
            while ((line = reader.readLine()) != null) {
                logFileStrings.add(line);
            }
            System.out.println(logFileStrings.get(logFileStrings.size()-1));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void checkDriverProfileLog(DriverProfile driverProfile, DriverProfile driverProfileAfterSave){
        readStatisticFile();
        createLogString("firstName",driverProfile.getFirstName(), driverProfileAfterSave.getFirstName());
        createLogString("lastName",driverProfile.getLastName(), driverProfileAfterSave.getLastName());
        createLogString("status",driverProfile.getStatus(), driverProfileAfterSave.getStatus());
        createLogString("loginName",driverProfile.getLoginName(), driverProfileAfterSave.getLoginName());
        createLogString("phone",driverProfile.getPhone(), driverProfileAfterSave.getPhone());
        createLogString("homeTerminalTimezone",driverProfile.getHomeTerminalTimezone(), driverProfileAfterSave.getHomeTerminalTimezone());
        createLogString("eldExempt",driverProfile.isEldExempt(), driverProfileAfterSave.isEldExempt());
        createLogString("licenseNumber",driverProfile.getDriverLicenseNumber(), driverProfileAfterSave.getDriverLicenseNumber());
        createLogString("licenseState",driverProfile.getLicenseState(), driverProfileAfterSave.getLicenseState());
        createLogString("eldMultidayBasisUsed",driverProfile.getUsaMultidayBasis(), driverProfileAfterSave.getUsaMultidayBasis());
        createLogString("eldMultidayBasisUsedCan",driverProfile.getCanadianMultidayBasis(), driverProfileAfterSave.getCanadianMultidayBasis());
        createLogString("eldIsYardMoveAllowed",driverProfile.isYardMoveAllowed(), driverProfileAfterSave.isYardMoveAllowed());
        createLogString("eldIsPersonalUseAllowed",driverProfile.isPersonalUseAllowed(), driverProfileAfterSave.isPersonalUseAllowed());
        //createLogString("eldExemptComment",driverProfile.getEldExemptComment(), driverProfileAfterSave.getEldExemptComment());
        createLogString("eldEditMode",driverProfile.getEldEditMode(), driverProfileAfterSave.getEldEditMode());
        createLogString("ownerOperator",driverProfile.isOwnerOperator(), driverProfileAfterSave.isOwnerOperator());
        createLogString("truckId",driverProfile.getTruckNumber(), driverProfileAfterSave.getTruckNumber());
        createLogString("trailerId",driverProfile.getTrailerNumber(), driverProfileAfterSave.getTrailerNumber());
        createLogString("tripStartMinSpeed",driverProfile.getTripStatMinSpeed(), driverProfileAfterSave.getTripStatMinSpeed());
        createLogString("tripEndMaxSpeed",driverProfile.getTripEndMaxSpeed(), driverProfileAfterSave.getTripEndMaxSpeed());
        createLogString("regainHoursAtMidnight",driverProfile.isRegainHoursAtMidnight(), driverProfileAfterSave.isRegainHoursAtMidnight());
        createLogString("displayTimeOnMobileGraph",driverProfile.isDisplayTimeOnMobileGraph(), driverProfileAfterSave.isDisplayTimeOnMobileGraph());
        createLogString("disable15Days",driverProfile.isDisable15Days(), driverProfileAfterSave.isDisable15Days());
        createLogString("allowEditInformation",driverProfile.isAllowEditInformation(), driverProfileAfterSave.isAllowEditInformation());
        createLogString("allowDeleteEvents",driverProfile.isAllowDeleteEventsInEldApp(), driverProfileAfterSave.isAllowDeleteEventsInEldApp());
        createLogString("allowInsertEvents",driverProfile.isAllowInsertEventsInEldApp(), driverProfileAfterSave.isAllowInsertEventsInEldApp());
        createLogString("allowEditEvents",driverProfile.isAllowEditInformation(), driverProfileAfterSave.isAllowEditInformation());
        createLogString("allowDrivingEvents",driverProfile.isAllowDrivingEventsInEldApp(), driverProfileAfterSave.isAllowDrivingEventsInEldApp());
        createLogString("collectGPSWithoutTruck",driverProfile.isCollectGpsWhileNotConnectedToTruck(), driverProfileAfterSave.isCollectGpsWhileNotConnectedToTruck());
        createLogString("generateLocationDescription",driverProfile.getGenerateLocationDescription(), driverProfileAfterSave.getGenerateLocationDescription());
        createLogString("opentextPassword",driverProfile.getPassword(), driverProfileAfterSave.getPassword());
        createLogString("showAlertOnNewMessage",driverProfile.isShowAlertOnNewMessage(), driverProfileAfterSave.isShowAlertOnNewMessage());
        createLogString("enableVoiceMessage",driverProfile.isEnableVoiceMessage(), driverProfileAfterSave.isEnableVoiceMessage());
        createLogString("email",driverProfile.getEmail(), driverProfileAfterSave.getEmail());
        createLogString("isDriverContractorWithPersonalAuthority",driverProfile.isDriverContractorWithPersonalAuthority(), driverProfileAfterSave.isDriverContractorWithPersonalAuthority());
        createLogString("companyName",driverProfile.getCompanyName(), driverProfileAfterSave.getCompanyName());
        createLogString("companyAddress",driverProfile.getCompanyAddress(), driverProfileAfterSave.getCompanyAddress());
        createLogString("yardAddress",driverProfile.getYardAddress(), driverProfileAfterSave.getYardAddress());
        createLogString("contactInfo",driverProfile.getContactInfo(), driverProfileAfterSave.getContactInfo());
        createLogString("authorityNumbers",driverProfile.getAuthorityNumbers(), driverProfileAfterSave.getAuthorityNumbers());
        createLogString("eldEventsAutoSync",driverProfile.isAutoSyncEvents(), driverProfileAfterSave.isAutoSyncEvents());
        createLogString("appVersionMsgIntervalMin",driverProfile.getRemindDriverToUpdateAppMinutes(), driverProfileAfterSave.getRemindDriverToUpdateAppMinutes());
        createLogString("onlyUsaDriving",driverProfile.isOnlyDrivesInUsa(), driverProfileAfterSave.isOnlyDrivesInUsa());
    }

    private void createLogString(String parameterName,String beforeChanges, String afterChanges){
        if(!beforeChanges.equals(afterChanges)) {
            StringBuilder logStringForCheck = new StringBuilder("");
            logStringForCheck.append(parameterName).append("=");
            if (beforeChanges.equals("")) {
                logStringForCheck.append("[null ->");
            } else
                logStringForCheck.append("[").append(beforeChanges).append(" ->");
            if (afterChanges.equals("")) {
                logStringForCheck.append(" null]");
            } else
                logStringForCheck.append(" ").append(afterChanges).append("]");
            System.out.println(logStringForCheck.toString());
            assertTrue(logFileStrings.get(logFileStrings.size()-1).contains(logStringForCheck.toString()));
        }
    }

    private void createLogString(String parameterName,boolean beforeChanges, boolean afterChanges){
        if(beforeChanges!=afterChanges) {
            StringBuilder logStringForCheck = new StringBuilder("");
            logStringForCheck.append(parameterName).append("=");
            if (beforeChanges) {
                logStringForCheck.append("[Y ->");
            } else
                logStringForCheck.append("[N ->");
            if (afterChanges) {
                logStringForCheck.append(" Y]");
            } else
                logStringForCheck.append(" N]");
            System.out.println(logStringForCheck.toString());
            assertTrue(logFileStrings.get(logFileStrings.size()-1).contains(logStringForCheck.toString()));
        }
    }
}
