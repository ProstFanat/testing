package migration.DAO;

import db.DBConnection;
import migration.StripeSubscription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StripeSubscriptionDAO {
    public String db;
    public String user;
    public String pass;

    public StripeSubscriptionDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getStripeSubscription(String id) throws SQLException {
        StripeSubscription stripeSubscription = null;
        List<String> stripeSubscriptions = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql =  "SELECT * FROM eld.stripe_subscription WHERE user_id IN " +
                "(SELECT acl_user_id FROM fleet.driver_profile WHERE driver_id = " + id + ")" + " ORDER BY ref_id";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                stripeSubscription =  new StripeSubscription(rs, null);
                stripeSubscriptions.add(stripeSubscription.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stripeSubscriptions;
    }

    public List<String> getStripeSubscriptionByUser(String id) throws SQLException {
        StripeSubscription stripeSubscription = null;
        List<String> stripeSubscriptions = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql =  "SELECT * FROM eld.stripe_subscription WHERE user_id = "  + id + " ORDER BY ref_id";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                stripeSubscription =  new StripeSubscription(rs, null);
                stripeSubscriptions.add(stripeSubscription.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stripeSubscriptions;
    }
}
