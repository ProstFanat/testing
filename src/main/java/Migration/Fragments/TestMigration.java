package Migration.Fragments;

import DB.DBConnection;
import Migration.ACLUser;
import Migration.InspectionReport;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DB.DBConstant.*;

public class TestMigration  extends CompareMethods{

    public static List<String> getDriversForMigration(String migrationID){
        List<String> list = new ArrayList<>();

        Connection connection = DBConnection.getConnection(DB_URL, USER_DB, PASS_DB);
        String sql = "SELECT driver_id from eld.migration_user WHERE driver_id IS NOT null and migration_id =" + migrationID ;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(String.valueOf(rs.getLong("driver_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String getOrgIdForMigration(String migrationID){
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


    public static void testByMigrationId(String migrationId) throws SQLException, FileNotFoundException {
        String orgID = getOrgIdForMigration(migrationId);
        List<String> drivers = getDriversForMigration(migrationId);
        List<String> trucks = getTrucksForMigration(migrationId);
        List<String> trailers = getTrailersForMigration(migrationId);
        List<String> users = getOtherUsersForMigration(migrationId);

//        compareOrganizationsByOrgId(orgID);
//        compareAddressesByOrgId(orgID);
//        compareACLUserGroupsByOrgId(orgID);
//        compareDepartmentsByOrgId(orgID);
//        compareConsumersByOrgId(orgID);
//        compareAccountsByOrgId(orgID);
//        compareGpsSignalProviderByOrgId(orgID);
//        compareHosProviderByOrgId(orgID);
//        compareMessagingProviderByOrgId(orgID);
//        compareGeocodeProviderByOrgId(orgID);
//        compareGpsSignalConsumerByOrgId(orgID);
//        compareEdiDataConsumerByOrgId(orgID);
//        compareOptionsByOrgId(orgID);
//        compareACLMatricesByOrgId(orgID);
//        compareContactsByOrgId(orgID);

        for (String driver : drivers) {
//            compareDriverByDriverId(driver);
//            compareEldEventsByDriverId(driver);
//            compareEldOriginalEventsById(driver);
//            compareInspectionReportDriverId(driver);
//            compareEldBorderCrossingEventsDriverId(driver);
//            compareEldSignalsHistoryDriverId(driver);
//            compareFmcsaEldExportDriverId(driver);
//            compareFuelPurchaseReceiptDriverId(driver);
//            compareACLUsersByDriverId(driver);
//            compareAddressBooksByDriverId(driver);

            compareStripeCustomer(driver);
            compareStripeSubscription(driver);
            compareStripeSubscriptionItem(driver);
            compareEldSubscriptions(driver);
            //compareACLUserInGroupByDriverId(driver);
        }

//        for (String truck : trucks) {
//            compareTruckByTruckId(truck);
//            compareTruckDeviceSignalHistoryByTruckId(truck);
//            compareTagsByOrgId(truck);
//            compareTransportMovementByTruckId(truck);
//            compareTransportMovementHistoryByTruckId(truck);
//        }
//        for (String trailer : trailers ) {
//            compareTrailerByTrailerId(trailer);
//            compareTrailerDeviceSignalHistoryByTrailerId(trailer);
//        }
//        for (String user : users){
//            compareACLUsersByUserId(user);
//            compareACLUserMatricesByUserId(user);
//            compareAddressBooksByUserId(user);
//           // compareACLUserInGroupByUserId(user);
//        }

    }
}
