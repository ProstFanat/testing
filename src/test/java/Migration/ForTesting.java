package Migration;

import LoginAndMainPages.LoginPage;

import MigrationDashboard.MainPageMigration;
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.open;

public class ForTesting {
    public static BasePage basePage;
    public static MainPageMigration mainPageMigration;


    @BeforeAll
    static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://10.10.1.83:8080/TrackEnsure/login.do");

        basePage = new BasePage();
        mainPageMigration = new MainPageMigration();
        LoginPage loginPage = new LoginPage();

        loginPage.login("5", "test");
        open("http://10.10.1.83:8080/TrackEnsure/app-admin/migration-dashboard/#/migration-list");
    }

    @Test
    public void editLoad() {

    }
}
