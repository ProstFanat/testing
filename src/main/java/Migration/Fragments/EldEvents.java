package Migration.Fragments;

import Migration.*;
import org.junit.jupiter.api.Assertions;

import java.sql.SQLException;
import java.util.List;

import static DB.DBConstant.*;
import static DB.DBConstant.PASS_DB2;

public class EldEvents {


    public static void compareEldEventsById(String id) throws SQLException {
        EldEventDao profileDAOOld = new EldEventDao(DB_URL, USER_DB, PASS_DB);
        EldEventDao profileDAONew = new EldEventDao(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> eldEventOld = profileDAOOld.getEldEventsForDriver(id);
        List<String> eldEventNew = profileDAONew.getEldEventsForDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(eldEventNew, eldEventOld);
    }
}
