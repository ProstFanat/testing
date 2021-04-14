package Migration;

import LoginAndMainPages.LoginPage;

import MigrationDashboard.MainPageMigration;
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import resources.BasePage;
import resources.AppConstants;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class ForTesting {
    public static BasePage basePage;
    public static MainPageMigration mainPageMigration;


    @BeforeAll
    static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");

        basePage = new BasePage();
        mainPageMigration = new MainPageMigration();
        LoginPage loginPage = new LoginPage();

        loginPage.login("5", "test");
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/app-admin/migration-dashboard/#/migration-list");
    }

    @Test
    public void test() {
        mainPageMigration.setMigrationDateFromTo(1, "Feb", 2021, 18, "Feb", 2021)
                .setFromEld("TrackEnsure ELD")
                .setToEld("Smart eLog")
                .setCompanyName("Usko Express")
                .setDriverName("Petr Damian", "Usko Express")
                .setMigrationStatus("In Progress")
                //.setResponsiblePerson("Sergey Yastreba")
                .clickBtnApply();

        sleep(10000);
    }
}
