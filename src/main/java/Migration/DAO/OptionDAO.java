package Migration.DAO;

import DB.DBConnection;
import Migration.Option;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OptionDAO {
    public String db;
    public String user;
    public String pass;

    public OptionDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getListOfOptionsByOrgId(String orgId) {
        ArrayList<String> list = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * FROM fleet.option_value value LEFT JOIN fleet.option option ON option.option_id = value.option_id WHERE value.org_id = " + orgId + " ORDER BY option_name, option_type";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Option vo = new Option(rs, null);
                list.add(vo.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
