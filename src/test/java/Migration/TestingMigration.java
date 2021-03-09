package Migration;

import Migration.Fragments.CompareMethods;
import Migration.Fragments.TestMigration;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class TestingMigration extends CompareMethods{

    @Test
    public void testGet() throws SQLException, FileNotFoundException, IllegalAccessException {
        TestMigration.testByMigrationId("1267");
//        compareDriverByDriverId("63931");
//        compareEldEventsByDriverId("63931");
//        compareEldOriginalEventsById("63931");
    }
}
