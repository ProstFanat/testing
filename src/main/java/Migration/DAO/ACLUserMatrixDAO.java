package Migration.DAO;

import DB.DBConnection;
import Migration.ACLUserMatrix;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ACLUserMatrixDAO {
    private String db;
    private String user;
    private String pass;

    public ACLUserMatrixDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getListOfACLUserMatrixByOrgId(String orgId) {
        ArrayList<String> list = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from public.acl_user_matrix WHERE user_id IN (SELECT user_id from public.acl_user WHERE organization_id = " + orgId + ")";
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
