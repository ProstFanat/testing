package migration.DAO;

import db.DBConnection;
import migration.EldBorderCrossingEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static db.DBConstant.VALIDATION_DAYS;

public class EldBorderCrossingEventDao {
    public String db;
    public String user;
    public String pass;

    public EldBorderCrossingEventDao(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getEldBorderCrossingEventForDriver(String driverId) throws SQLException {
        EldBorderCrossingEvent eldBorderCrossingEvent = null;
        List<String> eldBorderCrossingEvents = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from eld.eld_border_crossing_event WHERE driver_id_1=" + driverId +
                " AND create_date BETWEEN now() - '" + VALIDATION_DAYS + " days'::INTERVAL and now() ORDER BY crossing_date";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                eldBorderCrossingEvent =  new EldBorderCrossingEvent(rs, null);
                eldBorderCrossingEvents.add(eldBorderCrossingEvent.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eldBorderCrossingEvents;
    }
}
