package Migration;

import Migration.Fragments.CompareMethodsAsserts;
import Migration.Fragments.TestMigration;
import com.itextpdf.text.DocumentException;
import org.testng.annotations.Test;
//import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class TestingMigration extends CompareMethodsAsserts {

    @Test
    public void testGet() throws SQLException, FileNotFoundException, IllegalAccessException, DocumentException, NoSuchFieldException {
       //TestMigration.testByMigrationId("59");
       TestMigration.testByMigrationIdWithDocument("2");
//        compareDriverByDriverId("43356");
//        compareEldEventsByDriverId("43356");
//        compareEldOriginalEventsById("43356");
    }
}
