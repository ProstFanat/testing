package Migration;

import DB.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EldEventOriginalDao {
    private String db;
    private String user;
    private String pass;

    public EldEventOriginalDao(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getEldEventsOriginalForDriver(String driverId) throws SQLException {
        EldEvent eldEvent = null;
        List<String> eldEvents = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from eld.eld_event_original WHERE driver_id_1=" + driverId +
                " AND event_timestamp BETWEEN now() - '8 days'::INTERVAL and now()";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                eldEvent =  new EldEvent(rs, null);
                eldEvents.add(eldEvent.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eldEvents;


    }
}
