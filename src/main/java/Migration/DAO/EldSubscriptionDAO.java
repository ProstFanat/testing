package Migration.DAO;

import DB.DBConnection;
import Migration.EldSubscription;
import Migration.StripeSubscription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EldSubscriptionDAO {
    public String db;
    public String user;
    public String pass;

    public EldSubscriptionDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getEldSubscription(String id) throws SQLException {
        EldSubscription eldSubscription = null;
        List<String> eldSubscriptions = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql =  "SELECT * FROM eld.eld_subscription WHERE stripe_subscription_item_id IN " +
                "(SELECT id FROM eld.stripe_subscription_item WHERE user_id IN" +
                "(SELECT acl_user_id FROM fleet.driver_profile WHERE driver_id = " + id + "))" + " ORDER BY subscription_id";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                eldSubscription =  new EldSubscription(rs, null);
                eldSubscriptions.add(eldSubscription.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eldSubscriptions;
    }

    public List<String> getEldSubscriptionByUser(String id) throws SQLException {
        EldSubscription eldSubscription = null;
        List<String> eldSubscriptions = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql =  "SELECT * FROM eld.eld_subscription WHERE stripe_subscription_item_id IN " +
                "(SELECT id FROM eld.stripe_subscription_item WHERE user_id =" +
                 id +  ") ORDER BY subscription_id";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                eldSubscription =  new EldSubscription(rs, null);
                eldSubscriptions.add(eldSubscription.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eldSubscriptions;
    }
}
