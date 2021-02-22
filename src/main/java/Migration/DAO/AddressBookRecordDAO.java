package Migration.DAO;

import DB.DBConnection;
import Migration.AddressBookRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressBookRecordDAO {
    private String db;
    private String user;
    private String pass;

    public AddressBookRecordDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getListOfAddressBookRecordsByDriverId(String driverId) {
        ArrayList<String> list = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
       // "SELECT * from public.address_book WHERE org_id=" + orgId + " ORDER BY name, email";
        String sql =
        "SELECT * FROM public.address_book WHERE acl_user IN " +
                "(SELECT acl_user_id FROM fleet.driver_profile WHERE driver_id = " + driverId + ")" + " ORDER BY name, email";
//                + " AND create_date BETWEEN now() - '8 days'::INTERVAL and now()";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AddressBookRecord vo = new AddressBookRecord(rs, null);
                list.add(vo.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String> getListOfAddressBookRecordsByUserId(String userId) {
        ArrayList<String> list = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);

        String sql =  "SELECT * from public.address_book WHERE acl_user=" + userId + " ORDER BY name, email";
//                "SELECT * FROM public.address_book WHERE acl_user IN " +
//                        "(SELECT acl_user_id FROM fleet.driver_profile WHERE driver_id = " + driverId + ")";
//                + " AND create_date BETWEEN now() - '8 days'::INTERVAL and now()";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AddressBookRecord vo = new AddressBookRecord(rs, null);
                list.add(vo.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
