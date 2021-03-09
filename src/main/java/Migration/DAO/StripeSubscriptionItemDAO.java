package Migration.DAO;

import DB.DBConnection;
import Migration.StripeSubscription;
import Migration.StripeSubscriptionItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StripeSubscriptionItemDAO {

        public String db;
        public String user;
        public String pass;

        public StripeSubscriptionItemDAO(String db, String user, String pass) {
            this.db = db;
            this.user = user;
            this.pass = pass;
        }

    public StripeSubscriptionItemDAO(ResultSet rs, Object user) {
    }

    public List<String> getStripeSubscriptionItem(String id) throws SQLException {
            StripeSubscriptionItem stripeSubscriptionItem = null;
            List<String> stripeSubscriptionsItems = new ArrayList<>();

            Connection connection = DBConnection.getConnection(db, user, pass);
            String sql =  "SELECT * FROM eld.stripe_subscription_item WHERE user_id IN " +
                    "(SELECT acl_user_id FROM fleet.driver_profile WHERE driver_id = " + id + ")" + " ORDER BY ref_id";
            try (PreparedStatement ps = connection.prepareStatement(sql)){
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    stripeSubscriptionItem =  new StripeSubscriptionItem(rs, null);
                    stripeSubscriptionsItems.add(stripeSubscriptionsItems.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return stripeSubscriptionsItems;
        }

    public List<String> getStripeSubscriptionItemByUser(String id) throws SQLException {
        StripeSubscriptionItem stripeSubscriptionItem = null;
        List<String> stripeSubscriptionsItems = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql =  "SELECT * FROM eld.stripe_subscription_item WHERE user_id = "  + id +  " ORDER BY ref_id";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                stripeSubscriptionItem =  new StripeSubscriptionItem(rs, null);
                stripeSubscriptionsItems.add(stripeSubscriptionsItems.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stripeSubscriptionsItems;
    }
}
