package Migration.DAO;

import DB.DBConnection;
import Migration.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    private String db;
    private String user;
    private String pass;

    public DepartmentDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getListOfDepartmentsByOrgId(String orgId) {
        ArrayList<String> list = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from fleet.department WHERE org_id=" + orgId;
//                + " AND create_date BETWEEN now() - '8 days'::INTERVAL and now()";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Department department =  new Department(rs, null);
                list.add(department.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
