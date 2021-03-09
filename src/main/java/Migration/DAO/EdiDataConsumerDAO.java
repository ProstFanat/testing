package Migration.DAO;

import DB.DBConnection;
import Migration.EdiDataConsumer;
import Migration.Truck;
import Migration.TruckDeviceSignalHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EdiDataConsumerDAO {
    public String db;
    public String user;
    public String pass;

    public EdiDataConsumerDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getEdiDataConsumerByOrgId(String orgId) throws SQLException {
        EdiDataConsumer ediDataConsumer = null;
        List<String> ediDataConsumers = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from fleet.edi_data_consumer WHERE org_id=" + orgId + " ORDER BY auth_info, active, ftp_information, security_info";
        // нет поля по которому можно нормально сортировать
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ediDataConsumer =  new EdiDataConsumer(rs, null);
                ediDataConsumers.add(ediDataConsumer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ediDataConsumers;
    }
}
