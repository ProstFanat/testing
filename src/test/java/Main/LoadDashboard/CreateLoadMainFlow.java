package Main.LoadDashboard;

import loadDashboardPages.EditCreateLoadPage;
import loadDashboardPages.LoadListPage;
import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

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
        EditCreateLoadPage editCreateLoadPage = new EditCreateLoadPage();
        LoadListPage loadListPage = new LoadListPage();


        loginPage.login("5", "test");

        mainAdminScreenPage.clickLoadSearchBtn();

        loadListPage.clickNewLoadBtn();

        editCreateLoadPage.setDefaultLoadSettings();
        editCreateLoadPage.getOffersTableFragment().searchDrivers("7")
                .selectDrivers()
                .clickSaveLoadAndSendOffersBtn();
        editCreateLoadPage.getOffersTableFragment().checkDriversName();
        editCreateLoadPage.checkLoadIdInUrl();
        String id = editCreateLoadPage.getID();
        back();
        back();

        loadListPage.getFilterLoadPageFragment().inputLoadId(id);
        loadListPage.getFilterLoadPageFragment().clickBtnFilter();

    }

}