package Migration.DAO;

import DB.DBConnection;
import Migration.Trailer;
import Migration.Truck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrailerDAO {
    private String db;
    private String user;
    private String pass;

    public TrailerDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public Trailer getTrailerById(String truckId) throws SQLException {
        Trailer trailer = null;

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from public.truck WHERE truck_id=" + truckId;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                trailer =  new Trailer(rs, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trailer;
    }
}
