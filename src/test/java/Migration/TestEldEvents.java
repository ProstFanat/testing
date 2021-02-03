package Migration;

import Migration.Fragments.DriversProfiles;
import Migration.Fragments.EldEvents;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static DB.DBConstant.*;

public class TestEldEvents {
    public static EldEvents eldEvents;

    @BeforeAll
    static void setup() {
        eldEvents = new EldEvents();
    }


    @Test
    public void test() throws SQLException {
        eldEvents.compareEldEventsById("289039");
    }
}
