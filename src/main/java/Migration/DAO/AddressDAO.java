package Migration.DAO;

import DB.DBConnection;
import Migration.Address;
import Migration.EldBorderCrossingEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {
    public String db;
    public String user;
    public String pass;

    public AddressDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public Address getAddressByOrgId(String orgId) throws SQLException {
        Address address = null;

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * FROM public.address WHERE address_id in (SELECT address_id from public.organization WHERE organization_id = " + orgId + ")";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                address =  new Address(rs, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }
}
