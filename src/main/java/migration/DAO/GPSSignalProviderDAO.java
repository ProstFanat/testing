package migration.DAO;

import db.DBConnection;
import migration.GPSSignalProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GPSSignalProviderDAO {
    public String db;
    public String user;
    public String pass;

    public GPSSignalProviderDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getGpsSignalsProvideByOrgId(String orgId) throws SQLException {
        GPSSignalProvider gpsSignalProvider = null;
        List<String> gpsSignalsProvider = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from fleet.gps_signal_provider WHERE org_id=" + orgId + "and active = 'Y' ORDER BY login";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                gpsSignalProvider =  new GPSSignalProvider(rs, null);
                gpsSignalsProvider.add(gpsSignalProvider.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gpsSignalsProvider;
    }
}