package Migration;

import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import MigrationDashboard.CreateMigrationPage;
import MigrationDashboard.MainPageMigration;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import resources.AppConstants;

import static com.codeborne.selenide.Selenide.open;

public class CreateMigration {

    public static LoginPage loginPage;
    public static MainAdminScreenPage mainAdminScreenPage;
    public static MainPageMigration mainPageMigration;
    public static CreateMigrationPage createMigrationPage;

    @BeforeAll
    static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        loginPage = new LoginPage();
        mainAdminScreenPage = new MainAdminScreenPage();
        loginPage.login("5", "test");
        mainPageMigration = new MainPageMigration();
        createMigrationPage = new CreateMigrationPage();
    }


@Test
    static void createMigration (){
        mainAdminScreenPage.clickSideMenuMigrationBtn();
        mainPageMigration.clickCreateNewBtn();
        createMigrationPage.selectCompany("");


}


}