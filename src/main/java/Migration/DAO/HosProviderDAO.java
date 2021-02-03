package Migration.DAO;

import DB.DBConnection;
import Migration.GPSSignalProvider;
import Migration.HOSProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HosProviderDAO {
    private String db;
    private String user;
    private String pass;

    public HosProviderDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getHOSProvideByOrgId(String orgId) throws SQLException {
        HOSProvider hosProvider = null;
        List<String> hosProviders = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from fleet.hos_provider WHERE org_id=" + orgId + " ORDER BY login";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                hosProvider =  new HOSProvider(rs, null);
                hosProviders.add(hosProvider.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hosProviders;
    }
}
