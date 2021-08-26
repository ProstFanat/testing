package migration.Fragments;

import db.DBConnection;
import migration.DAO.MigrationUserDAO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static db.DBConstant.*;
import static migration.Fragments.CompareMethodsAsserts.*;
import static migration.Fragments.CompareMethodsDocument.*;
import static migration.Fragments.Report.catFont;

public class TestMigration{

    public static List<String> getDriversForMigration(String migrationID) {
        List<String> list = new ArrayList<>();

        Connection connection = DBConnection.getConnection(DB_URL, USER_DB, PASS_DB);
        String sql = "SELECT driver_id from eld.migration_user WHERE driver_id IS NOT null and migration_id =" + migrationID;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(String.valueOf(rs.getLong("driver_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String getOrgIdForMigration(String migrationID) {
        String vo = null;

        Connection connection = DBConnection.getConnection(DB_URL, USER_DB, PASS_DB);
        String sql = "SELECT org_id FROM eld.migration WHERE migration_id = " + migrationID;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                vo = String.valueOf(rs.getLong(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(vo);
        return vo;
    }

    public static List<String> getTrucksForMigration(String migrationID){
        List<String> list = new ArrayList<>();

        Connection connection = DBConnection.getConnection(DB_URL, USER_DB, PASS_DB);
        String sql = "SELECT truck_id from eld.migration_truck WHERE migration_id =" + migrationID ;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(String.valueOf(rs.getLong("truck_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<String> getTrailersForMigration(String migrationID){
        List<String> list = new ArrayList<>();

        Connection connection = DBConnection.getConnection(DB_URL, USER_DB, PASS_DB);
        String sql = "SELECT trailer_id from eld.migration_trailer WHERE migration_id =" + migrationID ;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(String.valueOf(rs.getLong("trailer_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<String> getOtherUsersForMigration(String migrationID){
        List<String> list = new ArrayList<>();

        Connection connection = DBConnection.getConnection(DB_URL, USER_DB, PASS_DB);
        String sql = "SELECT user_id from eld.migration_user WHERE driver_id is null and migration_id =" + migrationID ;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(String.valueOf(rs.getLong("user_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }


    public static void testByMigrationId(String migrationId) throws SQLException, IllegalAccessException, FileNotFoundException, DocumentException, NoSuchFieldException {
        String orgID = getOrgIdForMigration(migrationId);
        List<String> drivers = getDriversForMigration(migrationId);
        List<String> trucks = getTrucksForMigration(migrationId);
        List<String> trailers = getTrailersForMigration(migrationId);
        List<String> users = getOtherUsersForMigration(migrationId);

        MigrationUserDAO days = new MigrationUserDAO(DB_URL, USER_DB, PASS_DB);
        List<String> validationDays = days.getEventsDayQuantityForMigration(migrationId);
        VALIDATION_DAYS = validationDays.get(1);
        System.out.println(VALIDATION_DAYS);

        compareOrganizationsByOrgId(orgID);
        compareAddressesByOrgId(orgID);
        compareACLUserGroupsByOrgId(orgID);
        compareDepartmentsByOrgId(orgID);
        compareConsumersByOrgId(orgID);
        compareAccountsByOrgId(orgID);
        compareGpsSignalProviderByOrgId(orgID);
        compareHosProviderByOrgId(orgID);
        compareMessagingProviderByOrgId(orgID);
        compareGeocodeProviderByOrgId(orgID);
        compareGpsSignalConsumerByOrgId(orgID);
        compareEdiDataConsumerByOrgId(orgID);
        //compareOptionsByOrgId(orgID);
        compareACLMatricesByOrgId(orgID);
        compareContactsByOrgId(orgID);

        for (String driver : drivers) {
            compareDriverByDriverId(driver);
            compareEldEventsByDriverId(driver);
            compareEldOriginalEventsById(driver);
            compareInspectionReportDriverId(driver);
            compareEldBorderCrossingEventsDriverId(driver);
            compareEldSignalsHistoryDriverId(driver);
            compareFmcsaEldExportDriverId(driver);
            compareFuelPurchaseReceiptDriverId(driver);
            compareACLUsersByDriverId(driver);
            compareAddressBooksByDriverId(driver);
            compareHosDayVerify(driver);
            compareTagsByDriverId(driver);

//            compareStripeCustomerByDriver(driver);
//            compareStripeSubscriptionByDriver(driver);
//            compareStripeSubscriptionItemByDriver(driver);
//            compareEldSubscriptionsByDriver(driver);
           // compareACLUserInGroupByDriverId(driver);
        }

        for (String truck : trucks) {
            compareTruckByTruckId(truck);
            compareTruckDeviceSignalHistoryByTruckId(truck);
            compareTransportMovementByTruckId(truck);
            compareTransportMovementHistoryByTruckId(truck);
        }
        for (String trailer : trailers ) {
            compareTrailerByTrailerId(trailer);
            compareTrailerDeviceSignalHistoryByTrailerId(trailer);
        }
        for (String user : users){
            compareACLUsersByUserId(user);
            compareACLUserMatricesByUserId(user);
            compareAddressBooksByUserId(user);


//            compareStripeCustomerByUser(user);
//            compareStripeSubscriptionByUser(user);
//            compareStripeSubscriptionItemByUser(user);
//            compareEldSubscriptionsByUser(user);
//            compareACLUserInGroupByUserId(user);
        }
    }

    public static void testByMigrationIdWithDocument(String migrationId) throws SQLException, IllegalAccessException, FileNotFoundException, DocumentException, NoSuchFieldException{
        String orgID = getOrgIdForMigration(migrationId);
        List<String> drivers = getDriversForMigration(migrationId);
        List<String> trucks = getTrucksForMigration(migrationId);
        List<String> trailers = getTrailersForMigration(migrationId);
        List<String> users = getOtherUsersForMigration(migrationId);
        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        MigrationUserDAO days = new MigrationUserDAO(DB_URL, USER_DB, PASS_DB);
        List<String> validationDays = days.getEventsDayQuantityForMigration(migrationId);
        if(validationDays.size() == 0) {
            VALIDATION_DAYS = "8";
        } else {
            VALIDATION_DAYS = validationDays.get(0);
        }

        Document document = new Document();
        PdfWriter.getInstance(document,
                new FileOutputStream("/home/user/Idea/ResultOfTestingMigration/Migration " + migrationId + ".pdf"));
        document.open();

        Paragraph title = new Paragraph("migration " + migrationId, catFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        if (!(getNewId.getNewOrgId(orgID).equals("0"))) {
            compareOrganizationsByOrgId(orgID, document);
            compareAddressesByOrgId(orgID, document);
            compareACLUserGroupsByOrgId(orgID, document);
            compareACLResourcesByOrgId(orgID, document);
            compareDepartmentsByOrgId(orgID, document);
            compareConsumersByOrgId(orgID, document);
            compareAccountsByOrgId(orgID, document);
            compareGpsSignalProviderByOrgId(orgID, document);
            compareHosProviderByOrgId(orgID, document);
            compareMessagingProviderByOrgId(orgID, document);
            compareGeocodeProviderByOrgId(orgID, document);
            compareGpsSignalConsumerByOrgId(orgID, document);
            compareEdiDataConsumerByOrgId(orgID, document);
            //compareOptionsByOrgId(orgID, document);
            compareACLMatricesByOrgId(orgID, document);
            compareContactsByOrgId(orgID, document);
        }

        for (String driver : drivers) {
            if(getNewId.getNewDriverId(driver).equals("0")) {
                System.out.println("new driver id is null for driver" + driver);
            } else {
                compareDriverByDriverId(driver, document);
                compareEldEventsByDriverId(driver, document);
                compareEldOriginalEventsById(driver, document);
                compareInspectionReportDriverId(driver, document);
                compareEldBorderCrossingEventsDriverId(driver, document);
                compareEldSignalsHistoryDriverId(driver, document);
                compareFmcsaEldExportDriverId(driver, document);
                compareFuelPurchaseReceiptDriverId(driver, document);
                compareACLUsersByDriverId(driver, document);
                compareAddressBooksByDriverId(driver, document);
                compareHosDayVerify(driver, document);
                compareTagsByDriverId(driver, document);

//                compareStripeCustomerByDriver(driver, document);
//                compareStripeSubscriptionByDriver(driver, document);
//                compareStripeSubscriptionItemByDriver(driver, document);
//                compareEldSubscriptionsByDriver(driver, document);
//                compareACLUserInGroupByDriverId(driver, document);
            }
        }

        for (String truck : trucks) {
            if(!(getNewId.getNewTruckId(truck).equals("0"))) {
                compareTruckByTruckId(truck, document);
                compareTruckDeviceSignalHistoryByTruckId(truck, document);
                compareTransportMovementByTruckId(truck, document);
                compareTransportMovementHistoryByTruckId(truck, document);
            }
        }
        for (String trailer : trailers ) {
            if(!(getNewId.getNewTrailerId(trailer).equals("0"))) {
                compareTrailerByTrailerId(trailer, document);
                compareTrailerDeviceSignalHistoryByTrailerId(trailer, document);
            }
        }
        for (String user : users){
            if(!(getNewId.getNewAclUserId(user).equals("0"))) {
                compareACLUsersByUserId(user, document);
                compareACLUserMatricesByUserId(user, document);
                compareAddressBooksByUserId(user, document);


//                compareStripeCustomerByUser(user, document);
//                compareStripeSubscriptionByUser(user, document);
//                compareStripeSubscriptionItemByUser(user, document);
//                compareEldSubscriptionsByUser(user, document);
//                compareACLUserInGroupByUserId(user, document);
            }
        }

        document.close();

    }
}
