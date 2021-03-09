package Migration.DAO;

import DB.DBConnection;
import Migration.ACLResource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ACLResourceDAO {
    public String db;
    public String user;
    public String pass;

    public ACLResourceDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getListOfACLResourcesByOrgId(String orgId) {
        ArrayList<String> list = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from public.acl_resource WHERE org_id=" + orgId + " ORDER BY resource_name";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ACLResource vo =  new ACLResource(rs, null);
                list.add(vo.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
