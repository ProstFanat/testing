package Migration;

import DB.DBConnection;

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
                driverProfile =  new DriverProfile(rs, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (driverProfile.getDriverId() == null) {
            return id;
        } else{
            return driverProfile.getDriverId().toString();
        }
    }
}
