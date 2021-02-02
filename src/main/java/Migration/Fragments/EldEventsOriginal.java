package Migration.Fragments;

import Migration.EldEventDao;
import Migration.EldEventOriginalDao;
import Migration.GetNewId;
import org.junit.jupiter.api.Assertions;

import java.sql.SQLException;
import java.util.List;

import static DB.DBConstant.*;
import static DB.DBConstant.PASS_DB2;

public class EldEventsOriginal {

    public static void compareEldOriginalEventsById(String id) throws SQLException {
        EldEventOriginalDao eldEventsOriginalOld = new EldEventOriginalDao(DB_URL, USER_DB, PASS_DB);
        EldEventOriginalDao eldEventsOriginalNew = new EldEventOriginalDao(DB_URL2, USER_DB2, PASS_DB2);
        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> eldEventOld = eldEventsOriginalOld.getEldEventsOriginalForDriver(id);
        List<String> eldEventNew = eldEventsOriginalNew.getEldEventsOriginalForDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(eldEventNew, eldEventOld);
    }
}
