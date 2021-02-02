package Migration;

import DB.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InspectionReportDao {
    private String db;
    private String user;
    private String pass;

    public InspectionReportDao(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public List<String> getInspectionReportsByDriver(String driverId) throws SQLException {
        InspectionReport inspectionReport = null;
        List<String> inspectionReports = new ArrayList<>();

        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from eld.inspection_report WHERE driver_id_1=" + driverId +
                " AND event_timestamp BETWEEN now() - '8 days'::INTERVAL and now()";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                inspectionReport =  new InspectionReport(rs, null);
                inspectionReports.add(inspectionReport.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inspectionReports;


    }

}
