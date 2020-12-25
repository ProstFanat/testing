package DB;

import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static sun.management.Agent.error;

public class DBLoads extends DBConnection {

    public void updateLoadStatusByLoadId(String id,String status) throws SQLException {
        String sql = "UPDATE loads.load SET status = ?::loads.load_status, WHERE offer_id = " + id;
        //getConnection().prepareStatement(sql);
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {
            System.out.println(ps.getResultSet().getString("load_id"));
//            ps.setString(1, status);
//            ps.executeUpdate();
        } catch (SQLException e) {
            error("Insert event is not successful: " + e);
        }
    }

    public void test(String id,String status) throws SQLException {
        int maxPrice = 50000;
        getConnection().prepareStatement("UPDATE loads.load SET status = ?::loads.load_status, WHERE offer_id = " + id);
//        preparedStatement.setInt(1, maxPrice);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while(resultSet.next()){
//
//            int id1 = resultSet.getInt("Id");
//            String name = resultSet.getString("ProductName");
//            int price = resultSet.getInt("Price");
//
//            System.out.printf("%d. %s - %d \n", id, name, price);
//        }
    }

    @Test
    public void test() throws SQLException {
        test("113", "Dispatched");
    }

}
