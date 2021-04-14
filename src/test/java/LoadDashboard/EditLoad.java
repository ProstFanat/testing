package LoadDashboard;

import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import loadDashboardPages.EditCreateLoadPage;
import loadDashboardPages.LoadListPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import resources.BasePage;
import resources.AppConstants;
import resources.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.back;

public class EditLoad {

    public static LoadListPage loadListPage;
    public static BasePage basePage;
    public static EditCreateLoadPage editCreateLoadPage;
    public static MainAdminScreenPage mainAdminScreenPage;
    public static ConfProperties confProperties;

    @BeforeAll
    static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");

        basePage = new BasePage();
        LoginPage loginPage = new LoginPage();
        editCreateLoadPage = new EditCreateLoadPage();
        loadListPage = new LoadListPage();
        editCreateLoadPage = new EditCreateLoadPage();
        loadListPage = new LoadListPage();
        mainAdminScreenPage = new MainAdminScreenPage();
        confProperties = new ConfProperties();

        loginPage.login("5", "test");

    }

    @Test
    public void editLoad() {

        mainAdminScreenPage.clickLoadSearchBtn();

        String id = loadListPage.getTableFragment().getFirstLoadId();
        loadListPage.getFilterLoadPageFragment().inputLoadId(id).clickBtnFilter();
        loadListPage.getTableFragment().saveLoadData();
        loadListPage.getTableFragment().loadActionBtnClick()
                .loadActionEditBtnClick();

        editCreateLoadPage.getLoadSettingsFragment().setPickupDate(23, "Nov", 2020)
                .setDeliveryDate(30, "Nov", 2020)
                .setPickupLocation(ConfProperties.getProperty("editLoad.setPickupLocation"))
                .setDeliveryLocation(ConfProperties.getProperty("editLoad.setDeliveryLocation"))
                .setPickupZipCode(ConfProperties.getProperty("editLoad.setPickupZipCode"))
                .setDeliveryZipCode(ConfProperties.getProperty("editLoad.setDeliveryZipCode"))
                .selectTrailerType(ConfProperties.getProperty("editLoad.selectTrailerType"))
                .setWeight(ConfProperties.getProperty("editLoad.setWeight"))
                .selectTrailerLength(ConfProperties.getProperty("editLoad.selectTrailerLength"))
                .setRate(ConfProperties.getProperty("editLoad.setRate"))
                .inputItemType(ConfProperties.getProperty("editLoad.inputItemType"))
                .selectFP(ConfProperties.getProperty("editLoad.selectFP"))
                .inputDimension(ConfProperties.getProperty("editLoad.inputDimension"))
                .inputComment(ConfProperties.getProperty("editLoad.inputComment"));

        editCreateLoadPage.getLoadSettingsFragment().clickSaveBtn();
        editCreateLoadPage.getReqAlertsMessage("Load successfully updated").shouldBe(Condition.visible);
        back();
        loadListPage.getFilterLoadPageFragment().inputLoadId(id)
                .clickBtnFilter();
        basePage.waitForPageToLoad();
        loadListPage.getPickupLocationInTable().shouldHave(Condition.text(ConfProperties.getProperty("editLoad.setPickupLocation")));

        Assertions.assertEquals("23-Nov-2020", loadListPage.getPickupDateInTable());
        loadListPage.getDeliveryPlaceInTable().shouldHave(Condition.text(ConfProperties.getProperty("editLoad.setDeliveryLocation")));
        Assertions.assertEquals("30-Nov-2020", loadListPage.getDeliveryDateInTable());
        loadListPage.getTrailerTypeInTable().shouldHave(Condition.text(ConfProperties.getProperty("editLoad.selectTrailerType")));
        loadListPage.getRateInTable().shouldHave(Condition.text(ConfProperties.getProperty("editLoad.setRate")));
        loadListPage.getWeightInTable().shouldHave(Condition.text(ConfProperties.getProperty("editLoad.setWeight")));
        loadListPage.getFPInTable().shouldHave(Condition.text(ConfProperties.getProperty("editLoad.selectFP")));
    }
}

