package Migration.DAO;

import DB.DBConnection;
import Migration.GPSSignalProvider;
import Migration.HosDayVerify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DB.DBConstant.VALIDATION_DAYS;

public class HosDayVerifyDAO {
    public String db;
    public String user;
    public String pass;

    public HosDayVerifyDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getHosVerifyByDriver(String id) throws SQLException {
        HosDayVerify hosDayVerify = null;
        List<String> hosDaysVerify = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from eld.hos_day_verify WHERE driver_id = " + id +
                " AND verified_date BETWEEN now() - '" + VALIDATION_DAYS + " days'::INTERVAL and now() ORDER BY verified_date";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                hosDayVerify =  new HosDayVerify(rs, null);
                hosDaysVerify.add(hosDayVerify.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hosDaysVerify;
    }
}
