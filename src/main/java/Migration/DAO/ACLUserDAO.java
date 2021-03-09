package Migration.DAO;

import DB.DBConnection;
import Migration.ACLUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ACLUserDAO {
    public String db;
    public String user;
    public String pass;

    public ACLUserDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public ACLUser getACLUserByDriverId(String driverId) throws SQLException {
        ACLUser vo = null;

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * FROM acl_user WHERE user_id IN " +
                "(SELECT acl_user_id FROM fleet.driver_profile WHERE driver_id = " + driverId + ")";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                vo = new ACLUser(rs, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }

    public ACLUser getACLUserByUserId(String userId) throws SQLException {
        ACLUser vo = null;

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * FROM acl_user WHERE user_id = " + userId;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                vo = new ACLUser(rs, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }
}
