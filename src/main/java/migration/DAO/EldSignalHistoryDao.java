package migration.DAO;

import db.DBConnection;
import migration.EldSignalHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static db.DBConstant.VALIDATION_DAYS;

public class EldSignalHistoryDao {

    public String db;
    public String user;
    public String pass;

    public EldSignalHistoryDao(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getEldSignalsHistoryByDriver(String driverId) throws SQLException {
        EldSignalHistory eldSignalHistory = null;
        List<String> eldSignalsHistory = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from eld.eld_signal_history WHERE driver_id_1=" + driverId +
                " AND create_date BETWEEN now() - '" + VALIDATION_DAYS + " days'::INTERVAL and now() ORDER BY odometer, signal_time, create_date";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                eldSignalHistory =  new EldSignalHistory(rs, null);
                eldSignalsHistory.add(eldSignalHistory.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eldSignalsHistory;


    }

}