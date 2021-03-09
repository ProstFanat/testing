package Migration.DAO;

import DB.DBConnection;
import Migration.Account;
import Migration.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactDAO {
    public String db;
    public String user;
    public String pass;

    public ContactDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public Contact getContactByOrgId(String orgId) throws SQLException {
        Contact vo = null;

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * FROM public.contact WHERE contact_id IN (SELECT contact_id FROM public.account WHERE organization_id=" + orgId + ")";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                vo = new Contact(rs, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }
}
