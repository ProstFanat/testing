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

    public ArrayList<String> getAclUserInGroupList(String Id) throws SQLException {
        ACLUserInGroup aclUserInGroup = null;
        ArrayList<String> aclUsersInGroup = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql =
                "SELECT DISTINCT auig.*, aug.*, aug.user_group AS group_name FROM acl_user_in_group auig "
                + "JOIN acl_user_group aug ON aug.group_id = auig.group_id WHERE "
                + "auig.user_id = " + Id + " ORDER BY group_name";
//        String sql = "SELECT * from public.acl_user_in_group WHERE user_id IN (SELECT user_id from public.acl_user WHERE organization_id = " + orgId + ") ORDER BY group_id";
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
