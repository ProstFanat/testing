package Migration.Fragments;

import Migration.DriverProfile;
import Migration.DAO.DriverProfileDAO;
import org.junit.jupiter.api.Assertions;

import java.sql.SQLException;

import static DB.DBConstant.*;
import static DB.DBConstant.PASS_DB2;

public class DriversProfiles {

    public static void compareDriverById(String id) throws SQLException {
        DriverProfileDAO profileDAOOld = new DriverProfileDAO(DB_URL, USER_DB, PASS_DB);
        DriverProfileDAO profileDAONew = new DriverProfileDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);


        DriverProfile DriverProfileOld = profileDAOOld.getDriverById(id);
        DriverProfile DriverProfileNew = profileDAONew.getDriverById(getNewId.getNewDriverId(id));

        System.out.println(DriverProfileOld.toString());
        System.out.println(DriverProfileNew.toString());

        Assertions.assertEquals(DriverProfileOld.toString(), DriverProfileNew.toString());
    }
}
