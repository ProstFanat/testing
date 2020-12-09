package LoadDashboard;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import loadDashboardPages.EditCreateLoadPage;
import loadDashboardPages.LoadListPage;
import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CreateLoadMainFlow {

    public static LoginPage loginPage;
    public static MainAdminScreenPage mainAdminScreenPage;
    public static EditCreateLoadPage editCreateLoadPage;
    public static LoadListPage loadListPage;
    public static BasePage basePage;

    @BeforeClass
    public static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://localhost:8080/TrackEnsure/login.do");
        loginPage = new LoginPage();
        mainAdminScreenPage = new MainAdminScreenPage();
        editCreateLoadPage = new EditCreateLoadPage();
        loadListPage = new LoadListPage();
        loginPage.login("5", "test");
        basePage = new BasePage();
    }

    @Test
    public void createNewLoad() throws Exception {
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
        loadListPage.tableSize.shouldHave(CollectionCondition.size(1));
    }

    @Test
    public void createNewLoadReqFieldPickupDate() {
        mainAdminScreenPage.clickLoadSearchBtn();

        loadListPage.clickNewLoadBtn();

        editCreateLoadPage.getLoadSettingsFragment().clickSaveBtn();
        editCreateLoadPage.getReqAlertsMessage("Please fill Pickup Date").shouldBe(Condition.visible);
        Assert.assertEquals(url(), "http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
    }

    @Test
    public void createNewLoadReqFieldPickLocation() {
        mainAdminScreenPage.clickLoadSearchBtn();

        loadListPage.clickNewLoadBtn();

        editCreateLoadPage.getLoadSettingsFragment().setPickupDate(23, "Nov", 2020)
                .clickSaveBtn();
        editCreateLoadPage.getReqAlertsMessage("City in PickUp Location are not determined, can't be saved").shouldBe(Condition.visible);
        Assert.assertEquals(url(), "http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
    }

    @Test
    public void createNewLoadReqFieldDelivDate() {
        mainAdminScreenPage.clickLoadSearchBtn();

        loadListPage.clickNewLoadBtn();

        editCreateLoadPage.getLoadSettingsFragment().setPickupDate(23, "Nov", 2020)
                .setPickupLocation("Toront")
                .clickSaveBtn();
        editCreateLoadPage.getReqAlertsMessage("Please fill Delivery Date").shouldBe(Condition.visible);
        Assert.assertEquals(url(), "http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");

    }

    @Test
    public void createNewLoadReqFieldDelivLocation() {
        mainAdminScreenPage.clickLoadSearchBtn();

        loadListPage.clickNewLoadBtn();

        editCreateLoadPage.getLoadSettingsFragment().setPickupDate(23, "Nov", 2020)
                .setPickupLocation("Toront")
                .setDeliveryDate(30, "Nov", 2020)
                .clickSaveBtn();
        editCreateLoadPage.getReqAlertsMessage("City in Delivery Location are not determined, can't be saved").shouldBe(Condition.visible);
        Assert.assertEquals(url(), "http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
    }

    @Test
    public void createNewLoadReqFieldWeight() {
        mainAdminScreenPage.clickLoadSearchBtn();

        loadListPage.clickNewLoadBtn();

        editCreateLoadPage.getLoadSettingsFragment().setPickupDate(23, "Nov", 2020)
                .setPickupLocation("Toront")
                .setDeliveryDate(30, "Nov", 2020)
                .setDeliveryLocation("New")
                .clickSaveBtn();
        editCreateLoadPage.getReqAlertsMessage("Please fill Weight").shouldBe(Condition.visible);
        Assert.assertEquals(url(), "http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
    }

    @Test
    public void createNewLoadReqFieldFP() {
        mainAdminScreenPage.clickLoadSearchBtn();

        loadListPage.clickNewLoadBtn();

        editCreateLoadPage.getLoadSettingsFragment().setPickupDate(23, "Nov", 2020)
                .setPickupLocation("Toront")
                .setDeliveryDate(30, "Nov", 2020)
                .setDeliveryLocation("New")
                .setWeight("99")
                .clickSaveBtn();
        editCreateLoadPage.getReqAlertsMessage("Please fill F/P").shouldBe(Condition.visible);
        Assert.assertEquals(url(), "http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
    }

    @Test
    public void createNewLoadReqFieldContacts() {
        mainAdminScreenPage.clickLoadSearchBtn();

        loadListPage.clickNewLoadBtn();
        editCreateLoadPage.getLoadSettingsFragment().getContactInfo().should(Condition.attribute("ng-reflect-model", "1-279-888-6600"));
        editCreateLoadPage.getLoadSettingsFragment().setPickupDate(23, "Nov", 2020)
                .clearContact()
                .setPickupLocation("Toront")
                .setDeliveryDate(30, "Nov", 2020)
                .setDeliveryLocation("New")
                .setWeight("99")
                .selectFP("F")
                .clickSaveBtn();
        editCreateLoadPage.getReqAlertsMessage("Please fill Contacts").shouldBe(Condition.visible);
        Assert.assertEquals(url(), "http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
    }

@Test
    public void deleteLoad()  {
    mainAdminScreenPage.clickLoadSearchBtn();


    loadListPage.clickNewLoadBtn();

    editCreateLoadPage.setDefaultLoadSettings();
    editCreateLoadPage.getOffersTableFragment().searchDrivers("7")
            .selectDrivers()
            .clickSaveLoadAndSendOffersBtn();
    basePage.waitToVisibilityOf($x("//button[text() = ' Filter ']"));
    String id = editCreateLoadPage.getID();
    System.out.println(id);
    back();
    back();

    loadListPage.getFilterLoadPageFragment().inputLoadId(id);
    loadListPage.getFilterLoadPageFragment().clickBtnFilter();
    loadListPage.tableSize.shouldHave(CollectionCondition.size(1));
    loadListPage.getTableFragment().deleteLoad();
    loadListPage.tableSize.shouldHave(CollectionCondition.size(0));

}
}