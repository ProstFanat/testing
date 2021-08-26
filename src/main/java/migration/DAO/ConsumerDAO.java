package migration.DAO;

import db.DBConnection;
import migration.Consumer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConsumerDAO {
    public String db;
    public String user;
    public String pass;

    public ConsumerDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getListOfConsumersByOrgId(String orgId) {
        ArrayList<String> list = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from api.consumer WHERE org_id=" + orgId + " ORDER BY consumer_name";
        //, comment
//                + " AND create_date BETWEEN now() - '8 days'::INTERVAL and now()";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Consumer consumer = new Consumer(rs, null);
                list.add(consumer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}