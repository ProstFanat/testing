package migration.DAO;

import db.DBConnection;
import migration.MigrationUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MigrationUserDAO {
    public String db;
    public String user;
    public String pass;

    public MigrationUserDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getEventsDayQuantityForMigration(String id) throws SQLException {
        MigrationUser day = null;
        List<String> days = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql =  "SELECT events_day_quantity FROM eld.migration_user WHERE migration_id = '" + id + "'";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                day =  new MigrationUser(rs, null);
                if(day.getEventsDayQuantity() != null) {
                    days.add(day.getEventsDayQuantity().toString());
                } else {
                    days.add("8");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return days;
    }
}
