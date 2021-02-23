package DB;

import java.sql.*;

public class DBLoads extends DBConnection {

    public void updateLoadStatusByLoadId(String id, String status) throws SQLException, ClassNotFoundException {

        Connection connection = null;
        Statement statement = null;


        Class.forName("org.postgresql.Driver");

        connection = DriverManager.getConnection(DBConstant.DB_URL, DBConstant.USER_DB, DBConstant.PASS_DB);

        statement = connection.createStatement();

        String sql;
        sql = "UPDATE loads.load SET status = '" + status + "' WHERE load_id = " + id;

        statement.executeUpdate(sql);


        statement.close();
        connection.close();


    }

    public void updateOfferStatusByLoadId(String load_id, String status) throws SQLException, ClassNotFoundException {
        int offer_id = 0;
        Connection connection = null;
        Statement statement = null;

        Class.forName("org.postgresql.Driver");

        connection = DriverManager.getConnection(DBConstant.DB_URL, DBConstant.USER_DB, DBConstant.PASS_DB);

        statement = connection.createStatement();

        String updateOfferStatus, getOfferId;
        getOfferId = "SELECT offer_id FROM loads.offer WHERE load_id = " + load_id;

        ResultSet getOffer = statement.executeQuery(getOfferId);

        while (getOffer.next()) {
            offer_id = getOffer.getInt("offer_id");
        }

        updateOfferStatus = "UPDATE loads.offer SET status = '" + status + "', update_date = NOW() WHERE offer_id = " + offer_id;
        statement.executeUpdate(updateOfferStatus);

        getOffer.close();
        statement.close();
        connection.close();


    }
}
