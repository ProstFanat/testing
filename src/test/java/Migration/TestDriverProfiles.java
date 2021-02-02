package Migration;

import Migration.Fragments.DriversProfiles;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;


public class TestDriverProfiles {

    public static DriversProfiles driversProfiles;

    @BeforeAll
    static void setup() {
        driversProfiles = new DriversProfiles();
    }


    @Test
    public void test() throws SQLException {
        driversProfiles.compareDriverById("63047");
    }
}
