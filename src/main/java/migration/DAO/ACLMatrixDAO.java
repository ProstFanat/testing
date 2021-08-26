package migration.DAO;

import db.DBConnection;
import migration.ACLMatrix;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ACLMatrixDAO {
    public String db;
    public String user;
    public String pass;

    public ACLMatrixDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getListOfACLMatrixByOrgId(String orgId) {
        ArrayList<String> list = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from public.acl_matrix WHERE group_id IN (SELECT group_id from public.acl_user_group WHERE org_id = " + orgId + ") ORDER BY resource_name, allow_read, allow_update";
//                + " AND create_date BETWEEN now() - '8 days'::INTERVAL and now()";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ACLMatrix vo =  new ACLMatrix(rs, null);
                list.add(vo.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}