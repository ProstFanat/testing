package migration.DAO;

import db.DBConnection;
import migration.FMCSAELDExport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static db.DBConstant.VALIDATION_DAYS;

public class FMCSAELDExportDAO {
    public String db;
    public String user;
    public String pass;

    public FMCSAELDExportDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getFMCSAELDExportForDriver(String driverId) throws SQLException {
        FMCSAELDExport fmcsaEldExport= null;
        List<String> fmcsaEldExports = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from eld.fmcsa_eld_export WHERE driver_id=" + driverId +
                " AND create_date BETWEEN now() - '" + VALIDATION_DAYS + " days'::INTERVAL and now() ORDER BY start_sequence";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                fmcsaEldExport =  new FMCSAELDExport(rs, null);
                fmcsaEldExports.add(fmcsaEldExport.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fmcsaEldExports;
    }
}