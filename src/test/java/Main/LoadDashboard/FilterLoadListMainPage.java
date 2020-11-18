package Main.LoadDashboard;

import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Configuration;
import loadDashboardPages.LoadListPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class FilterLoadListMainPage {

    public static LoadListPage loadListPage;


    @BeforeClass
    public void setup(){
        Configuration.timeout = 100000;
        open("http://localhost:8080/TrackEnsure/login.do");

        LoginPage loginPage = new LoginPage();
        MainAdminScreenPage mainAdminScreenPage = new MainAdminScreenPage();
        loadListPage = new LoadListPage();

        loginPage.login("5", "test");
        mainAdminScreenPage.clickLoadSearchBtn();
    }

    @Test
    public void filterByLoadId(){

        loadListPage.clickNewLoadBtn().clickBtnFilter();

    }
}
