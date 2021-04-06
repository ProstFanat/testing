package Migration.DAO;

import DB.DBConnection;
import Migration.Migration;
import Migration.StripeCustomer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MigrationDAO {
    public String db;
    public String user;
    public String pass;

    public MigrationDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getCompletedMigrations() throws SQLException {
        Migration migration = null;
        List<String> migrations = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql =  "SELECT migration_id FROM eld.migration WHERE migration_status = 'completed'";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                migration =  new Migration(rs, null);
                migrations.add(migration.getMigrationId().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return migrations;
    }
}
