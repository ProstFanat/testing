package Main.LoadDashboard;


import loadDashboardPages.CreateLoadPage;
import loadDashboardPages.LoadListPage;
import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class CreateLoadMainFlow {

    @BeforeClass
    public static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://localhost:8080/TrackEnsure/login.do");
    }

    @Test
    public void createNewLoad() throws Exception {
        LoginPage loginPage = new LoginPage();
        MainAdminScreenPage mainAdminScreenPage = new MainAdminScreenPage();
        CreateLoadPage createLoadPage = new CreateLoadPage();
        LoadListPage loadListPage = new LoadListPage();

        loginPage.login("5", "test");

        mainAdminScreenPage.clickLoadSearchBtn();

        loadListPage.clickNewLoadBtn();

        createLoadPage.setDefaultLoadSettings();
        createLoadPage.getOffersTableFragment().searchDrivers()
                .selectDrivers()
                .clickSaveLoadAndSendOffersBtn();
        createLoadPage.getOffersTableFragment().checkDriversName();

    }

}