package Migration.DAO;

import DB.DBConnection;
import Migration.DriverProfile;
import Migration.Truck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TruckDAO {
    public String db;
    public String user;
    public String pass;

    public TruckDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public Truck getTruckById(String truckId) throws SQLException {
        Truck truck = null;

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from public.truck WHERE truck_id=" + truckId;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                truck =  new Truck(rs, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return truck;
    }
}
