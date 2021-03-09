package Migration.DAO;

import DB.DBConnection;
import Migration.Tag;
import Migration.TruckDeviceSignalHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class tagDAO {
    public String db;
    public String user;
    public String pass;

    public tagDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getTagsByOrgId(String orgId) throws SQLException {
        Tag tag = null;
        List<String> tags = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from public.tag WHERE organization_id=" + orgId + " ORDER BY tag_name";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                tag =  new Tag(rs, null);
                tags.add(tag.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tags;
    }
}
