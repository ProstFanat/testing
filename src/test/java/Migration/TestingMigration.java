package Migration;

import Migration.Fragments.CompareMethods;
import Migration.Fragments.TestMigration;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class TestingMigration extends CompareMethods{

    @Test
    public void testGet() throws SQLException, FileNotFoundException, IllegalAccessException {
        TestMigration.testByMigrationId("2090");
//        compareDriverByDriverId("43356");
//        compareEldEventsByDriverId("43356");
//        compareEldOriginalEventsById("43356");
    }
}
