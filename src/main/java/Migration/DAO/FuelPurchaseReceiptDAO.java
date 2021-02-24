package Migration.DAO;

import DB.DBConnection;
import Migration.FuelPurchaseReceipt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuelPurchaseReceiptDAO {
    private String db;
    private String user;
    private String pass;

    public FuelPurchaseReceiptDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getFuelPurchaseReceiptForDriver(String driverId) throws SQLException {
        FuelPurchaseReceipt fuelPurchaseReceipt= null;
        List<String> fuelPurchaseReceipts = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from eld.fuel_purchase_receipt WHERE driver_id=" + driverId +
                " AND create_date BETWEEN now() - '8 days'::INTERVAL and now() ORDER BY purchase_date ";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                fuelPurchaseReceipt =  new FuelPurchaseReceipt(rs, null);
                fuelPurchaseReceipts.add(fuelPurchaseReceipt.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fuelPurchaseReceipts;
    }
}
