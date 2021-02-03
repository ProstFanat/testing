package Migration.DAO;

import DB.DBConnection;
import Migration.ACLUserInGroup;
import Migration.TransportMovement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AclUserInGroupDAO {
    private String db;
    private String user;
    private String pass;

    public AclUserInGroupDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public ArrayList<String> getAclUserGroupTruckId(String orgId) throws SQLException {
        ACLUserInGroup aclUserInGroup = null;
        ArrayList<String> aclUsersInGroup = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from public.acl_user_matrix WHERE user_id IN (SELECT user_id from public.acl_user WHERE organization_id = " + orgId + ") ORDER BY resource_name, allow_read, allow_insert, allow_delete";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                aclUserInGroup =  new ACLUserInGroup(rs, null);
                aclUsersInGroup.add(aclUserInGroup.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aclUsersInGroup;
    }
}
