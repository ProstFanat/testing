package Migration;

import Migration.Fragments.CompareMethods;
import Migration.Fragments.TestMigration;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;

public class TestingMigration extends CompareMethods{

    @Test
    public void testGet() throws SQLException {;
        TestMigration.testByMigrationId("1011");
    }
}
