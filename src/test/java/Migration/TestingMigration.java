package Migration;

import Migration.Fragments.CompareMethods;
import Migration.Fragments.EldEvents;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class TestingMigration extends CompareMethods{
    @BeforeAll
    static void setup() {
        ;
    }


    @Test
    public void test() throws SQLException {
        compareEldEventsById("64429");
    }
}
