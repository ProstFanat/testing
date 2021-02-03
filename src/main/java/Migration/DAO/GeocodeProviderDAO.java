package Migration.DAO;

import DB.DBConnection;
import Migration.GPSSignalConsumer;
import Migration.GeocodeProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeocodeProviderDAO {
    private String db;
    private String user;
    private String pass;

    public GeocodeProviderDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getGeocodeProvideByOrgId(String orgId) throws SQLException {
        GeocodeProvider geocodeProvider = null;
        List<String> geocodeProviders = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from fleet.geocode_provider WHERE org_id=" + orgId;
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                geocodeProvider =  new GeocodeProvider(rs, null);
                geocodeProviders.add(geocodeProvider.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return geocodeProviders;
    }
}
