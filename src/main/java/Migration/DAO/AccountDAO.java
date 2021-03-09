package Migration.DAO;

import DB.DBConnection;
import Migration.Account;
import Migration.Organization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    public String db;
    public String user;
    public String pass;

    public AccountDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public Account getAccountByOrgId(String orgId) throws SQLException {
        Account vo = null;

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * FROM public.account WHERE organization_id=" + orgId;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                vo = new Account(rs, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }
}
// SELECT * FROM account WHERE organization_id=