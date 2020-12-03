package Main.LoadDashboard;

import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Configuration;
import loadDashboardPages.DispatchingSettingsPage;
import loadDashboardPages.EditCreateLoadPage;
import loadDashboardPages.LoadListPage;
import loadDashboardPages.fragments.FilterLoadPageFragment;
import loadDashboardPages.fragments.LoadSettingsFragment;
import org.junit.*;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.*;

public class DispatchSettings {

    public static LoadListPage loadListPage;
    public static FilterLoadPageFragment filterLoadPageFragment;
    public static DispatchingSettingsPage dispatchingSettingsPage;
    public static BasePage basePage;
    public static EditCreateLoadPage editCreateLoadPage;
    public static LoadSettingsFragment loadSettingsFragment;


    @BeforeClass
    public static void setup(){
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://localhost:8080/TrackEnsure/login.do");

        dispatchingSettingsPage = new DispatchingSettingsPage();
        basePage = new BasePage();
        loadSettingsFragment = new LoadSettingsFragment();
        editCreateLoadPage = new EditCreateLoadPage();
        LoginPage loginPage = new LoginPage();
        MainAdminScreenPage mainAdminScreenPage = new MainAdminScreenPage();
        filterLoadPageFragment = new FilterLoadPageFragment();
        loadListPage = new LoadListPage();

        loginPage.login("5", "test");
        mainAdminScreenPage.clickLoadSearchBtn();
    }

    @Before
    public void beforeTest(){
        open("http://localhost:8080/TrackEnsure/app/load-board/#/dispatch-settings");
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
    public void deactivateCheckBoxForDriver(){
        dispatchingSettingsPage.inputOrgName("Test with DM")
                .showDrivers(1)
                .inputDriver("Rouzi Yalikun")
                .setAllDriverCheckBoxesTrue()
                .checkBoxesForDriversList.first().setSelected(false);
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
        editCreateLoadPage.setDefaultLoadSettings();
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Ukraina");
        editCreateLoadPage.getOffersTableFragment().searchDrivers("200")
                .selectDriverByName("Rouzi Yalikun")
                .clickSaveLoadAndSendOffersBtn();
        basePage.waitToVisibilityOf(editCreateLoadPage.getLoadSettingsFragment().btnFilter);
        basePage.waitForPageToLoad();
        Assert.assertTrue(editCreateLoadPage.getOffersTableFragment().isAclUserPresent());
    }
}
