package Main.LoadDashboard;

import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Configuration;
import loadDashboardPages.LoadListPage;
import loadDashboardPages.fragments.FilterLoadPageFragment;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class EditLoadContactPerson {

    public static LoadListPage loadListPage;
    public static FilterLoadPageFragment filterLoadPageFragment;
    public static BasePage basePage;


    @BeforeClass
    public static void setup(){
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://localhost:8080/TrackEnsure/login.do");

        basePage = new BasePage();
        LoginPage loginPage = new LoginPage();
        MainAdminScreenPage mainAdminScreenPage = new MainAdminScreenPage();
        filterLoadPageFragment = new FilterLoadPageFragment();
        loadListPage = new LoadListPage();

        loginPage.login("5", "test");
        mainAdminScreenPage.clickLoadSearchBtn();
    }

    @Before
    public void beforeTest(){
        basePage.waitForPageToLoad();
    }

    @After
    public void afterTest(){
        refresh();
    }
}
