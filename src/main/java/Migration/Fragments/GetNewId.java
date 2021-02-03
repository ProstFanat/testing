package Migration.Fragments;

import DB.DBConnection;
import Migration.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GetNewId {

    private String db;
    private String user;
    private String pass;

    public GetNewId(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public String getNewDriverId(String id){
        DriverProfile driverProfile = null;

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from fleet.driver_profile WHERE master_db_ref_id=" + id;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                driverProfile =  new DriverProfile(rs, null, "new");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driverProfile.getDriverId().toString();

    }

    public String getNewTruckId(String id){
        Truck truck = null;

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from public.truck WHERE master_db_ref_id=" + id;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                truck =  new Truck(rs, null, "a");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return truck.getTruckId().toString();
    }

    public String getNewTrailerId(String id){
        Trailer trailer = null;

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from public.trailer WHERE master_db_ref_id=" + id;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                trailer =  new Trailer(rs, null, "a");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trailer.getTrailerId().toString();
    }

//    public String getNewOrgId(String id){
//        Trailer trailer = null;
//
//        Connection connection = DBConnection.getConnection(db, user, pass);
//        String sql = "SELECT * from public.trailer WHERE master_db_ref_id=" + id;
//        try (PreparedStatement ps = connection.prepareStatement(sql)){
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()){
//                trailer =  new Trailer(rs, null);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return trailer.getTrailerId().toString();
//    }

    public String getNewAclUserId(String id){
        ACLUser aclUser = null;

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from public.acl_user WHERE master_db_ref_id=" + id;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                aclUser =  new ACLUser(rs, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aclUser.getUserId().toString();
    }

    public String getNewGpsSignalProviderId(String id){
        GPSSignalProvider gpsSignalProvider = null;

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from fleet.gps_signal_provider WHERE master_db_ref_id=" + id;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                gpsSignalProvider =  new GPSSignalProvider(rs, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gpsSignalProvider.getProviderId().toString();
    }

    public String getNewHosProviderId(String id){
        HOSProvider hosProvider = null;

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from fleet.hos_provider WHERE master_db_ref_id=" + id;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                hosProvider =  new HOSProvider(rs, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hosProvider.getProviderId().toString();
    }

    public String getNewDepartmentId(String id){
        Department department = null;

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from fleet.department WHERE master_db_ref_id=" + id;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                department =  new Department(rs, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return department.getDepartmentId().toString();
    }

//    public String getNewAclUserGroupId(String id){
//        ACLUserGroup aclUserGroup = null;
//
//        Connection connection = DBConnection.getConnection(db, user, pass);
//        String sql = "SELECT * from public.acl_user_group WHERE master_db_ref_id=" + id;
//        try (PreparedStatement ps = connection.prepareStatement(sql)){
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()){
//                aclUserGroup =  new Department(rs, null);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return aclUserGroup.getDepartmentId().toString();
//    }
}
