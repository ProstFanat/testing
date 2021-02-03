package Migration.DAO;

import DB.DBConnection;
import Migration.Address;
import Migration.TransportMovement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransportMovementDAO {
    private String db;
    private String user;
    private String pass;

    public TransportMovementDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public ArrayList<String> getTransportMovementsByTruckId(String truckId) throws SQLException {
        TransportMovement transportMovement = null;
        ArrayList<String> transportMovements = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from public.transport_movement WHERE truck_id = " + truckId
                + " AND create_date BETWEEN now() - '8 days'::INTERVAL and now() ORDER BY create_date";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                transportMovement =  new TransportMovement(rs, null);
                transportMovements.add(transportMovement.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transportMovements;
    }
}
