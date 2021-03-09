package Migration.DAO;

import DB.DBConnection;
import Migration.Organization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizationDAO {

    public String db;
    public String user;
    public String pass;

    public OrganizationDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public Organization getOrganizationById(String orgId) throws SQLException {
        Organization organization = null;

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from public.organization WHERE organization_id=" + orgId + " ORDER BY organization_name";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                organization = new Organization(rs, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return organization;
    }
}
