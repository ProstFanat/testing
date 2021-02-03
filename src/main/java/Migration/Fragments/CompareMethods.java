package Migration.Fragments;

import Migration.Account;
import Migration.DAO.*;
import Migration.DriverProfile;
import Migration.Organization;
import org.junit.jupiter.api.Assertions;

import java.sql.SQLException;
import java.util.List;

import static DB.DBConstant.*;

public class CompareMethods {

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

    public static void compareEldEventsById(String id) throws SQLException {
        EldEventDao profileDAOOld = new EldEventDao(DB_URL, USER_DB, PASS_DB);
        EldEventDao profileDAONew = new EldEventDao(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);


        List<String> eldEventOld = profileDAOOld.getEldEventsForDriver(id);
        List<String> eldEventNew = profileDAONew.getEldEventsForDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(eldEventNew, eldEventOld);
    }

    public static void compareEldOriginalEventsById(String id) throws SQLException {
        EldEventOriginalDao eldEventsOriginalOld = new EldEventOriginalDao(DB_URL, USER_DB, PASS_DB);
        EldEventOriginalDao eldEventsOriginalNew = new EldEventOriginalDao(DB_URL2, USER_DB2, PASS_DB2);
        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> eldEventOld = eldEventsOriginalOld.getEldEventsOriginalForDriver(id);
        List<String> eldEventNew = eldEventsOriginalNew.getEldEventsOriginalForDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(eldEventNew, eldEventOld);
    }

    public static void compareAccountsByOrgId(String id) throws SQLException {
        AccountDAO daoOld = new AccountDAO(DB_URL, USER_DB, PASS_DB);
        AccountDAO daoNew = new AccountDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Account oldValue = daoOld.getAccountByOrgId(id);
        Account newValue = daoNew.getAccountByOrgId(id);

        Assertions.assertEquals(newValue, oldValue);
    }

    public static void compareOrganizationsByOrgId(String id) throws SQLException {
        OrganizationDAO daoOld = new OrganizationDAO(DB_URL, USER_DB, PASS_DB);
        OrganizationDAO daoNew = new OrganizationDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Organization oldValue = daoOld.getOrganizationById(id);
        Organization newValue = daoNew.getOrganizationById(id);

        Assertions.assertEquals(newValue, oldValue);
    }
}
