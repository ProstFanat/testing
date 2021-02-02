package Migration;

import Migration.Fragments.EldEvents;
import Migration.Fragments.EldEventsOriginal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static DB.DBConstant.*;

public class TestEldEventsOriginal {
    public static EldEventsOriginal eldEventsOriginal;

    @BeforeAll
    static void setup() {
        eldEventsOriginal = new EldEventsOriginal();
    }

    @Test
    public void test() throws SQLException {
        eldEventsOriginal.compareEldOriginalEventsById("63599");

    }
}
