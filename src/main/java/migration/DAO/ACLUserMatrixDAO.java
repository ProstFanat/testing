package migration.DAO;

import db.DBConnection;
import migration.ACLUserMatrix;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ACLUserMatrixDAO {
    public String db;
    public String user;
    public String pass;

    public ACLUserMatrixDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getListOfACLUserMatrixByUserId(String userId) {
        ArrayList<String> list = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        //(SELECT user_id from public.acl_user WHERE organization_id = " + orgId + ")
        String sql = "SELECT * from public.acl_user_matrix WHERE user_id = " + userId + " ORDER BY resource_name, allow_read, allow_insert, allow_delete";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ACLUserMatrix vo =  new ACLUserMatrix(rs, null);
                list.add(vo.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
