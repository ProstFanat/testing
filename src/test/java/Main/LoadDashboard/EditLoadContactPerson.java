package Main.LoadDashboard;

import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Configuration;
import loadDashboardPages.EditCreateLoadPage;
import loadDashboardPages.LoadListPage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import resources.BasePage;
import resources.ConfProperties;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.back;

public class EditLoadContactPerson {

    public static LoadListPage loadListPage;
   // public static FilterLoadPageFragment filterLoadPageFragment;
    public static BasePage basePage;


    @BeforeClass
    public static void setup(){
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://localhost:8080/TrackEnsure/login.do");

        basePage = new BasePage();
        LoginPage loginPage = new LoginPage();
        MainAdminScreenPage mainAdminScreenPage = new MainAdminScreenPage();
        EditCreateLoadPage editCreateLoadPage = new EditCreateLoadPage();
        loadListPage = new LoadListPage();

        loginPage.login("5", "test");
      //  mainAdminScreenPage.clickLoadSearchBtn();
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
public void editLoad() {
//    LoginPage loginPage = new LoginPage();
//    MainAdminScreenPage mainAdminScreenPage = new MainAdminScreenPage();
    EditCreateLoadPage editCreateLoadPage = new EditCreateLoadPage();
    LoadListPage loadListPage = new LoadListPage();

    MainAdminScreenPage mainAdminScreenPage = new MainAdminScreenPage();
    ConfProperties confProperties = new ConfProperties();


    mainAdminScreenPage.clickLoadSearchBtn();

    loadListPage.getTableFragment().saveLoadData();
//    loadListPage.getTableFragment().loadActionBtnClick();
//    loadListPage.getTableFragment().loadActionEditBtnClick();

    editCreateLoadPage.getLoadSettingsFragment().setPickupDate(23, "Nov", 2020);
    editCreateLoadPage.getLoadSettingsFragment().setDeliveryDate(30, "Nov", 2020);
    editCreateLoadPage.getLoadSettingsFragment().setPickupLocation(confProperties.getProperty("setPickupLocation"));
    editCreateLoadPage.getLoadSettingsFragment().setDeliveryLocation(confProperties.getProperty("setDeliveryLocation"));
    editCreateLoadPage.getLoadSettingsFragment().setPickupZipCode(confProperties.getProperty("setPickupZipCode"));
    editCreateLoadPage.getLoadSettingsFragment().setDeliveryZipCode(confProperties.getProperty("setDeliveryZipCode"));
    editCreateLoadPage.getLoadSettingsFragment().selectTrailerType(confProperties.getProperty("selectTrailerType"));
    editCreateLoadPage.getLoadSettingsFragment().setWeight(confProperties.getProperty("setWeight"));
    editCreateLoadPage.getLoadSettingsFragment().selectTrailerLength(confProperties.getProperty("selectTrailerLength"));
    editCreateLoadPage.getLoadSettingsFragment().setRate(confProperties.getProperty("setRate"));
    editCreateLoadPage.getLoadSettingsFragment().inputItemType(confProperties.getProperty("inputItemType"));
    editCreateLoadPage.getLoadSettingsFragment().selectFP(confProperties.getProperty("selectFP"));
    editCreateLoadPage.getLoadSettingsFragment().inputDimension(confProperties.getProperty("inputDimension"));
    editCreateLoadPage.getLoadSettingsFragment().inputComment(confProperties.getProperty("inputComment"));

    editCreateLoadPage.getOffersTableFragment().searchDrivers();
    editCreateLoadPage.getOffersTableFragment().selectDrivers();
    editCreateLoadPage.getOffersTableFragment().clickSaveLoadAndSendOffersBtn();
    String id = editCreateLoadPage.getID();
    back();
    back();

    loadListPage.getFilterLoadPageFragment().inputLoadId(id);
    loadListPage.checkAll(id, "",
            confProperties.getProperty("setPickupLocation"),
            confProperties.getProperty("setDeliveryLocation"),
            confProperties.getProperty("selectTrailerType"),
            "",
            "",
            confProperties.getProperty("selectFP"),
            confProperties.getProperty("setWeight"),
            confProperties.getProperty("setRate"));

    loadListPage.compareRawData();

}
}

