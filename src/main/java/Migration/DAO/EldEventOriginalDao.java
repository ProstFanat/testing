package Migration.DAO;

import DB.DBConnection;
import Migration.EldEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DB.DBConstant.VALIDATION_DAYS;

public class EldEventOriginalDao {
    public String db;
    public String user;
    public String pass;

    public EldEventOriginalDao(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getEldEventsOriginalForDriver(String driverId) throws SQLException {
        EldEvent eldEvent = null;
        List<String> eldEvents = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql1 = "SELECT * from eld.eld_event_original WHERE driver_id_1=" + driverId +
                " AND event_timestamp BETWEEN now() - '" + VALIDATION_DAYS + " days'::INTERVAL and now() ORDER BY event_sequence ASC, event_timestamp ASC, eld_sequence ASC";
        try (PreparedStatement ps = connection.prepareStatement(sql1)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                eldEvent =  new EldEvent(rs, null);
                eldEvents.add(eldEvent.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql2 = "SELECT * from eld.eld_event_original WHERE driver_id_1 =" + driverId + "AND event_timestamp < now() - '" + VALIDATION_DAYS + " days'::INTERVAL and event_type = 1 and record_status = 1 order by event_timestamp DESC limit 1";
        try (PreparedStatement ps = connection.prepareStatement(sql2)){
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
