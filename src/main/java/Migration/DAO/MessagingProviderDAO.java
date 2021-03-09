package Migration.DAO;

import DB.DBConnection;
import Migration.GeocodeProvider;
import Migration.MessagingProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessagingProviderDAO {
    public String db;
    public String user;
    public String pass;

    public MessagingProviderDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getMessagingProvideByOrgId(String orgId) throws SQLException {
        MessagingProvider messagingProvider = null;
        List<String> messagingProviders = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from fleet.messaging_provider WHERE org_id=" + orgId + " ORDER BY login";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                messagingProvider =  new MessagingProvider(rs, null);
                messagingProviders.add(messagingProvider.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return messagingProviders;
    }
}
