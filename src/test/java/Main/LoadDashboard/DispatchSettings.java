package Main.LoadDashboard;

import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Configuration;
import loadDashboardPages.DispatchingSettingsPage;
import loadDashboardPages.LoadListPage;
import loadDashboardPages.fragments.FilterLoadPageFragment;
import org.junit.*;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class DispatchSettings {

    public static LoadListPage loadListPage;
    public static FilterLoadPageFragment filterLoadPageFragment;
    public static DispatchingSettingsPage dispatchingSettingsPage;
    public static BasePage basePage;


    @BeforeClass
    public static void setup(){
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://localhost:8080/TrackEnsure/login.do");

        dispatchingSettingsPage = new DispatchingSettingsPage();
        basePage = new BasePage();
        LoginPage loginPage = new LoginPage();
        MainAdminScreenPage mainAdminScreenPage = new MainAdminScreenPage();
        filterLoadPageFragment = new FilterLoadPageFragment();
        loadListPage = new LoadListPage();

        loginPage.login("5", "test");
        mainAdminScreenPage.clickLoadSearchBtn();
        loadListPage.clickTabDispatchingSettings();
    }

    @Before
    public void beforeTest(){
        basePage.waitForPageToLoad();
    }

    @After
    public void afterTest(){
        refresh();
    }

    @Test
    public void deactivateCheckBoxForCompany(){
        dispatchingSettingsPage.inputOrgName("EZH");
        dispatchingSettingsPage.checkBoxesForOrgList.first().setSelected(false);
        Assert.assertFalse(dispatchingSettingsPage.btnShowDriversList.first().isEnabled());
    }

    @Test
    public void deactivateCheckBoxForCompanyWithShowDrivers(){
        dispatchingSettingsPage.showDriversForOrg("EZH INC");
        dispatchingSettingsPage.checkBoxesForOrgList.first().setSelected(false);
        Assert.assertEquals(dispatchingSettingsPage.driversList.size(), 0);
    }

    @Test
    public void showDriversForCompanyAndDeactivateCheckBoxForAnotherCompany(){
        dispatchingSettingsPage.inputOrgName("EZH INC")
                .setAllOrgCheckBoxesTrue()
                .showDriversForOrg("Hellen Log LLC")
                .inputOrgName("Hellen Log LLC")
                .setAllOrgCheckBoxesTrue();
        dispatchingSettingsPage.checkBoxesForOrgList.first().setSelected(false);
        Assert.assertTrue(dispatchingSettingsPage.driversList.size() > 0);
    }

    @Test
    public void test(){

    }
}
