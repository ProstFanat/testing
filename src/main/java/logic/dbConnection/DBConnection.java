package logic.dbConnection;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final Logger log = Logger.getLogger(DBConnection.class);
    static Connection con = null;
    public static Connection getConnection(){
        if(con!=null) return con;
        return getConnection(DBConstant.DB_URL, DBConstant.USER_DB, DBConstant.PASS_DB);
    }
    private static Connection getConnection(String db_url, String user, String password){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            log.error("PostgreSQL JDBC Driver is not found. Include it in your library path: " + e );
        }
        try {
            con = DriverManager.getConnection(db_url, user, password);
        } catch (SQLException e) {
            log.error("Connection Failed: " + e);
        }
        log.info("Connection is successful");
        return con;
    }

    public static void closeConnection()  {
        if(con!=null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
