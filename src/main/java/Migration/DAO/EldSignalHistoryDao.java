package Migration.DAO;

import DB.DBConnection;
import Migration.EldSignalHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EldSignalHistoryDao {

    private String db;
    private String user;
    private String pass;

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
                " AND create_date BETWEEN now() - '8 days'::INTERVAL and now() ORDER BY odometer";
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
