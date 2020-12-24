package LoadDashboard;

import  java.sql.Connection;
import  java.sql.Statement;
import  java.sql.ResultSet;
import  java.sql.DriverManager;
import  java.sql.SQLException;

public class Database {

    public static void  main(String[] args) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        String dbUrl = "jdbc:postgresql://10.10.1.10:5434/trackensure";
        String username = "postgres";
        String password = "postgresTE!";

        //Query to Execute
        String query = "SELECT * FROM loads.offer WHERE load_id = 96";

        //Load mysql jdbc driver
        Class.forName("org.postgresql.Driver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl,username,password);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        while (rs.next()){
            String offer_id = rs.getString(1);
            String myAge = rs.getString(2);
            System. out.println();
        }
        // closing DB Connection
        con.close();
    }



}
