package Migration.DAO;

import DB.DBConnection;
import Migration.EldSignalHistory;
import Migration.TruckDeviceSignalHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TruckDeviceSignalHistoryDAO {
    private String db;
    private String user;
    private String pass;

    public TruckDeviceSignalHistoryDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getTruckDeviceSignalsByTruckId(String truckId) throws SQLException {
        TruckDeviceSignalHistory truckDeviceSignalHistory = null;
        List<String> truckDeviceSignalsHistory = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from public.truck_device_signal_history WHERE truck_id=" + truckId +
                " AND create_date BETWEEN now() - '8 days'::INTERVAL and now() ORDER BY odometer";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                truckDeviceSignalHistory =  new TruckDeviceSignalHistory(rs, null);
                truckDeviceSignalsHistory.add(truckDeviceSignalHistory.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return truckDeviceSignalsHistory;


    }
}
