package LoadDashboard;

import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import Main.DriversPage;
import Main.OptionsOfCompanyPage;
import com.codeborne.selenide.Configuration;
import Main.CustomersPage;
import loadDashboardPages.DispatchingSettingsPage;
import loadDashboardPages.EditCreateLoadPage;
import loadDashboardPages.LoadListPage;
import loadDashboardPages.fragments.FilterLoadPageFragment;
import loadDashboardPages.fragments.LoadSettingsFragment;

import org.junit.jupiter.api.*;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.*;

public class DispatchSettings {

    public static LoadListPage loadListPage;
    public static FilterLoadPageFragment filterLoadPageFragment;
    public static DispatchingSettingsPage dispatchingSettingsPage;
    public static BasePage basePage;
    public static EditCreateLoadPage editCreateLoadPage;
    public static LoadSettingsFragment loadSettingsFragment;
    public static CustomersPage customersPage;
    public static DriversPage driversPage;
    public static OptionsOfCompanyPage optionsOfCompanyPage;
    public static MainAdminScreenPage mainAdminScreenPage;
    public static LoginPage loginPage;


    @BeforeAll
    public static void setup(){
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://localhost:8080/TrackEnsure/login.do");

        optionsOfCompanyPage = new OptionsOfCompanyPage();
        driversPage = new DriversPage();
        customersPage = new CustomersPage();
        dispatchingSettingsPage = new DispatchingSettingsPage();
        basePage = new BasePage();
        loadSettingsFragment = new LoadSettingsFragment();
        editCreateLoadPage = new EditCreateLoadPage();
        loginPage = new LoginPage();
        mainAdminScreenPage = new MainAdminScreenPage();
        filterLoadPageFragment = new FilterLoadPageFragment();
        loadListPage = new LoadListPage();

    }

    @BeforeEach
    public void beforeTest(){
        open("http://localhost:8080/TrackEnsure/login.do");
        loginPage.login("5", "test");
        mainAdminScreenPage.clickLoadSearchBtn();
        open("http://localhost:8080/TrackEnsure/app/load-board/#/dispatch-settings");
        basePage.waitForPageToLoad();
    }

    @AfterEach
    public void afterTest(){

    }

    @AfterAll
    public static void afterAll(){
        open("http://localhost:8080/TrackEnsure/login.do");
        loginPage.login("5", "test");
        mainAdminScreenPage.clickLoadSearchBtn();
        open("http://localhost:8080/TrackEnsure/app/load-board/#/dispatch-settings");
        basePage.waitForPageToLoad();
        dispatchingSettingsPage.inputOrgName("Test with DM")
                .setAllOrgCheckBoxes(true);
    }

    @Test
    public void deactivateCheckBoxForCompany(){
        dispatchingSettingsPage.inputOrgName("EZH");
        dispatchingSettingsPage.checkBoxesForOrgList.first().setSelected(false);
        Assertions.assertFalse(dispatchingSettingsPage.btnShowDriversList.first().isEnabled());
    }

    @Test
    public void deactivateCheckBoxForCompanyWithShowDrivers(){
        dispatchingSettingsPage.inputOrgName("EZH")
            .setAllOrgCheckBoxes(true);
        dispatchingSettingsPage.showDriversForOrg("EZH INC");
        dispatchingSettingsPage.checkBoxesForOrgList.first().setSelected(false);
        Assertions.assertEquals(dispatchingSettingsPage.driversList.size(), 0);
    }

    @Test
    public void showDriversForCompanyAndDeactivateCheckBoxForAnotherCompany(){
        dispatchingSettingsPage.inputOrgName("EZH INC")
                .setAllOrgCheckBoxes(true)
                .showDriversForOrg("Hellen Log LLC")
                .inputOrgName("Hellen Log LLC")
                .setAllOrgCheckBoxes(true);
        dispatchingSettingsPage.checkBoxesForOrgList.first().setSelected(false);
        Assertions.assertTrue(dispatchingSettingsPage.driversList.size() > 0);
    }

    @Test
    public void deactivateCheckBoxForDriverBeforeCreatingLoad(){
        dispatchingSettingsPage.inputOrgName("Test with DM")
                .setAllOrgCheckBoxes(true)
                .showDrivers(1)
                .inputDriver("Rouzi Yalikun")
                .setAllDriverCheckBoxes(false);
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
        editCreateLoadPage.setDefaultLoadSettings();
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Ukraina");
        editCreateLoadPage.getOffersTableFragment().searchDrivers("200")
                .selectDriverByName("Rouzi Yalikun")
                .clickSaveLoadAndSendOffersBtn();
        basePage.waitToVisibilityOf(editCreateLoadPage.getLoadSettingsFragment().btnFilter);
        basePage.waitForPageToLoad();
        Assertions.assertTrue(editCreateLoadPage.getOffersTableFragment().isAclUserPresent());
    }

    @Test
    public void deactivateCheckBoxForDriverAfterCreatingLoad(){
        dispatchingSettingsPage.inputOrgName("Test with DM")
                .setAllOrgCheckBoxes(true)
                .showDrivers(1)
                .inputDriver("Rouzi Yalikun")
                .setAllDriverCheckBoxes(true);
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
        editCreateLoadPage.setDefaultLoadSettings();
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Ukraina");
        editCreateLoadPage.getOffersTableFragment().searchDrivers("200")
                .selectDriverByName("Rouzi Yalikun")
                .clickSaveLoadAndSendOffersBtn();
        basePage.waitToVisibilityOf(editCreateLoadPage.getLoadSettingsFragment().btnFilter);
        basePage.waitForPageToLoad();
        String id = editCreateLoadPage.getID();
        open("http://localhost:8080/TrackEnsure/app/load-board/#/dispatch-settings");
        dispatchingSettingsPage.inputOrgName("Test with DM")
                .showDrivers(1)
                .inputDriver("Rouzi Yalikun")
                .setAllDriverCheckBoxes(false);
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/edit-load?loadId=" + id);
        basePage.waitForPageToLoad();
        Assertions.assertFalse(editCreateLoadPage.getOffersTableFragment().isAclUserPresent());
    }

    @Test
    public void deactivateCheckBoxForOrgAfterCreatingLoad(){
        dispatchingSettingsPage.inputOrgName("Test with DM")
                .setAllOrgCheckBoxes(true)
                .showDrivers(1)
                .inputDriver("Rouzi Yalikun")
                .setAllDriverCheckBoxes(true);
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
        editCreateLoadPage.setDefaultLoadSettings();
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Ukraina");
        editCreateLoadPage.getOffersTableFragment().searchDrivers("200")
                .selectDriverByName("Rouzi Yalikun")
                .clickSaveLoadAndSendOffersBtn();
        basePage.waitToVisibilityOf(editCreateLoadPage.getLoadSettingsFragment().btnFilter);
        basePage.waitForPageToLoad();
        String id = editCreateLoadPage.getID();
        open("http://localhost:8080/TrackEnsure/app/load-board/#/dispatch-settings");
        dispatchingSettingsPage.inputOrgName("Test with DM")
                .setAllOrgCheckBoxes(false);
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/edit-load?loadId=" + id);
        basePage.waitForPageToLoad();
        Assertions.assertEquals(1, editCreateLoadPage.getOffersTableFragment().driversCollectionOnOffers.size());
    }

    @Test
    public void checkDriversOnAddOfferWithDeactivatedCheckBoxForOrg(){
        dispatchingSettingsPage.inputOrgName("Test with DM")
                .setAllOrgCheckBoxes(true);

        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
        editCreateLoadPage.setDefaultLoadSettings();
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Ukraina");
        editCreateLoadPage.getOffersTableFragment().searchDrivers("200");
        int initSize = editCreateLoadPage.getOffersTableFragment().getDriversListSize();

        open("http://localhost:8080/TrackEnsure/app/load-board/#/dispatch-settings");
        dispatchingSettingsPage.inputOrgName("Test with DM")
                .setAllOrgCheckBoxes(false);
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
        editCreateLoadPage.setDefaultLoadSettings();
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Ukraina");
        editCreateLoadPage.getOffersTableFragment().searchDrivers("200");

        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
        editCreateLoadPage.setDefaultLoadSettings();
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Ukraina");
        editCreateLoadPage.getOffersTableFragment().searchDrivers("200");
        int finalSize = editCreateLoadPage.getOffersTableFragment().getDriversListSize();

        Assertions.assertNotEquals(initSize, finalSize);
    }

    @Test
    public void deactivateCheckBoxForCompanyFromOptions(){
        dispatchingSettingsPage.inputOrgName("Test with DM")
                .setAllOrgCheckBoxes(true);

        customersPage.openCustomersPage();
        customersPage.logAsOrgOfCompany("Test with DM");

        optionsOfCompanyPage.openPage()
                .goToSystemOptionsTab();
        optionsOfCompanyPage.setDispatchingCheckBox(false)
                .clickBtnSave();

        open("http://localhost:8080/TrackEnsure/login.do");
        loginPage.login("5", "test");
        mainAdminScreenPage.clickLoadSearchBtn();
        open("http://localhost:8080/TrackEnsure/app/load-board/#/dispatch-settings");
        basePage.waitForPageToLoad();

        dispatchingSettingsPage.inputOrgName("Test with DM");
        Assertions.assertFalse(dispatchingSettingsPage.checkBoxesForOrgList.first().isSelected());

    }

    @Test
    public void deactivateCheckBoxForDriversFromProfile(){
        customersPage.openCustomersPage();
        customersPage.logAsOrgOfCompany("Test with DM");

        driversPage.openPage()
                    .openUpdatePageForDriver("Adrian", "Fanuzzi")
                    .setLoadBoardCheckBox(false)
                    .saveDriverProfile();

        open("http://localhost:8080/TrackEnsure/login.do");
        loginPage.login("5", "test");
        mainAdminScreenPage.clickLoadSearchBtn();
        open("http://localhost:8080/TrackEnsure/app/load-board/#/dispatch-settings");
        basePage.waitForPageToLoad();

        dispatchingSettingsPage.inputOrgName("Test with DM")
                                .setAllOrgCheckBoxes(true)
                                .showDrivers(1)
                                .inputDriver("Adrian Fanuzzi");
        Assertions.assertFalse(dispatchingSettingsPage.checkBoxesForDriversList.first().isSelected());
        dispatchingSettingsPage.checkBoxesForDriversList.first().setSelected(true);
    }
}
