package Migration;

import Migration.DAO.MigrationDAO;
import Migration.Fragments.TestMigration;
import com.itextpdf.text.DocumentException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.naming.Context;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import static DB.DBConstant.*;
import static java.lang.Thread.sleep;

public class CheckMigrationProcessor {

    @Test
    public void testingMigrations() throws SQLException, NoSuchFieldException, FileNotFoundException, DocumentException, IllegalAccessException, InterruptedException {
        MigrationDAO migration = new MigrationDAO(DB_URL, USER_DB, PASS_DB);
        List<String> migrationList = migration.getCompletedMigrations();
        for(int i = 1; i > 0; i++) {
            System.out.println("Starts");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            for (String migrationId : migrationList) {
                File f = new File("/home/user/Idea/ResultOfTestingMigration/Migration " + migrationId + ".pdf");
                if (!(f.exists() && !f.isDirectory())) {
                    TestMigration.testByMigrationIdWithDocument("199");
                }
            }
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("Sleeeeeep....");

            Thread.sleep(60000);
        }

    }
}
