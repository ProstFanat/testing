package migration.DAO;

import db.DBConnection;
import migration.TrailerDeviceSignalHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrailerDeviceSignalHistoryDAO {
    public String db;
    public String user;
    public String pass;

    public TrailerDeviceSignalHistoryDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getTrailerDeviceSignalsByTrailerId(String trailerId) throws SQLException {
        TrailerDeviceSignalHistory trailerDeviceSignalHistory = null;
        List<String> trailerDeviceSignalsHistory = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from public.trailer_device_signal_history WHERE trailer_id=" + trailerId +
                " AND signal_time BETWEEN now() - '8 days'::INTERVAL and now() ORDER BY signal_time";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                trailerDeviceSignalHistory =  new TrailerDeviceSignalHistory(rs, null);
                trailerDeviceSignalsHistory.add(trailerDeviceSignalHistory.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trailerDeviceSignalsHistory;
    }
}
