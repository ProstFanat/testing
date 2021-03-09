package Migration.DAO;

import DB.DBConnection;
import Migration.DriverProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import static DB.DBConstant.*;
import static DB.RecordMapperValueObject.getRSColumns;

public class DriverProfileDAO {
    public String db;
    public String user;
    public String pass;

    public DriverProfileDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public DriverProfile getDriverById(String driverId) throws SQLException {
        DriverProfile driverProfile = null;

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from fleet.driver_profile WHERE driver_id=" + driverId;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                driverProfile =  new DriverProfile(rs, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driverProfile;
    }
}
