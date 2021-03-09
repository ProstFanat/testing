package Migration.DAO;

import DB.DBConnection;
import Migration.GPSSignalProvider;
import Migration.StripeCustomer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StripeCustomerDAO {
    public String db;
    public String user;
    public String pass;

    public StripeCustomerDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getStripeCustomerByDriverId(String id) throws SQLException {
        StripeCustomer stripeCustomer = null;
        List<String> stripeCustomers = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql =  "SELECT * FROM eld.stripe_customer WHERE user_id IN " +
                "(SELECT acl_user_id FROM fleet.driver_profile WHERE driver_id = " + id + ")" + " ORDER BY ref_id, ref_email";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                stripeCustomer =  new StripeCustomer(rs, null);
                stripeCustomers.add(stripeCustomer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stripeCustomers;
    }

    public List<String> getStripeCustomerByUser(String id) throws SQLException {
        StripeCustomer stripeCustomer = null;
        List<String> stripeCustomers = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql =  "SELECT * FROM eld.stripe_customer WHERE user_id = " +
                  id +   " ORDER BY ref_id, ref_email";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                stripeCustomer =  new StripeCustomer(rs, null);
                stripeCustomers.add(stripeCustomer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stripeCustomers;
    }
}
