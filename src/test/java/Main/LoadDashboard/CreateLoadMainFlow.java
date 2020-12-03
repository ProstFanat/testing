package Main.LoadDashboard;

import com.codeborne.selenide.Condition;
import loadDashboardPages.EditCreateLoadPage;
import loadDashboardPages.LoadListPage;
import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CreateLoadMainFlow {

    public static LoginPage loginPage;
    public static MainAdminScreenPage mainAdminScreenPage;
    public static EditCreateLoadPage editCreateLoadPage;
    public static LoadListPage loadListPage;


    @BeforeClass
    public static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://localhost:8080/TrackEnsure/login.do");
        loginPage = new LoginPage();
        mainAdminScreenPage = new MainAdminScreenPage();
        editCreateLoadPage = new EditCreateLoadPage();
        loadListPage = new LoadListPage();

    }

    @Test
    public void createNewLoad() throws Exception {
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

    @Test
    public void createNewLoadReqFieldPickupDate()  {
        loginPage.login("5", "test");

        mainAdminScreenPage.clickLoadSearchBtn();

        loadListPage.clickNewLoadBtn();

        editCreateLoadPage.getLoadSettingsFragment().clickSaveBtn();
        editCreateLoadPage.getReqAlertsMessage("Please fill Pickup Date").shouldBe(Condition.visible);
        Assert.assertEquals(url(), "http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
    }
    @Test
    public void createNewLoadReqFieldPickLocation()  {
        loginPage.login("5", "test");

        mainAdminScreenPage.clickLoadSearchBtn();

        loadListPage.clickNewLoadBtn();

        editCreateLoadPage.getLoadSettingsFragment().setPickupDate(23, "Nov", 2020);
        editCreateLoadPage.getLoadSettingsFragment().clickSaveBtn();
        editCreateLoadPage.getReqAlertsMessage("City in PickUp Location are not determined, can't be saved").shouldBe(Condition.visible);
        Assert.assertEquals(url(), "http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
    }
    @Test
    public void createNewLoadReqFieldDelivDate()  {
        loginPage.login("5", "test");

        mainAdminScreenPage.clickLoadSearchBtn();

        loadListPage.clickNewLoadBtn();

        editCreateLoadPage.getLoadSettingsFragment().setPickupDate(23, "Nov", 2020);
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Toront");
        editCreateLoadPage.getLoadSettingsFragment().clickSaveBtn();
        editCreateLoadPage.getReqAlertsMessage("Please fill Delivery Date").shouldBe(Condition.visible);
        Assert.assertEquals(url(), "http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");

    }
    @Test
    public void createNewLoadReqFieldDelivLocation()  {
        loginPage.login("5", "test");

        mainAdminScreenPage.clickLoadSearchBtn();

        loadListPage.clickNewLoadBtn();

        editCreateLoadPage.getLoadSettingsFragment().setPickupDate(23, "Nov", 2020);
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Toront");
        editCreateLoadPage.getLoadSettingsFragment().setDeliveryDate(30, "Nov" ,2020 );
        editCreateLoadPage.getLoadSettingsFragment().clickSaveBtn();
        editCreateLoadPage.getReqAlertsMessage("City in Delivery Location are not determined, can't be saved").shouldBe(Condition.visible);
        Assert.assertEquals(url(), "http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
    }

    @Test
    public void createNewLoadReqFieldWeight()  {
        loginPage.login("5", "test");

        mainAdminScreenPage.clickLoadSearchBtn();

        loadListPage.clickNewLoadBtn();

        editCreateLoadPage.getLoadSettingsFragment().setPickupDate(23, "Nov", 2020);
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Toront");
        editCreateLoadPage.getLoadSettingsFragment().setDeliveryDate(30, "Nov" ,2020 );
        editCreateLoadPage.getLoadSettingsFragment().clickSaveBtn();
        editCreateLoadPage.getReqAlertsMessage("Please fill Weight").shouldBe(Condition.visible);
        Assert.assertEquals(url(), "http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
    }

}