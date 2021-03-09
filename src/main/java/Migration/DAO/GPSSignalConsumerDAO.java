package Migration.DAO;

import DB.DBConnection;
import Migration.EdiDataConsumer;
import Migration.GPSSignalConsumer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GPSSignalConsumerDAO {
    public String db;
    public String user;
    public String pass;

    public GPSSignalConsumerDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getGpsSignalConsumerByOrgId(String orgId) throws SQLException {
        GPSSignalConsumer gpsSignalConsumer = null;
        List<String> gpsSignalsConsumer = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from fleet.gps_signal_consumer WHERE org_id=" + orgId + " ORDER BY email";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                gpsSignalConsumer =  new GPSSignalConsumer(rs, null);
                gpsSignalsConsumer.add(gpsSignalConsumer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gpsSignalsConsumer;
    }
}
