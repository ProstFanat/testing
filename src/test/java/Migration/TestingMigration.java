package Migration;

import Migration.Fragments.CompareMethods;
import Migration.Fragments.TestMigration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class TestingMigration extends CompareMethods{

    @Test
    public void testGet() throws SQLException {
       // compareACLUserInGroupByUserId("1650");
        TestMigration.testByMigrationId("623");
    }
}
