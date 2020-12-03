package Main.LoadDashboard;

import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import loadDashboardPages.EditCreateLoadPage;
import loadDashboardPages.LoadListPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import resources.BasePage;
import resources.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.back;

public class EditLoad {

    public static LoadListPage loadListPage;
    public static BasePage basePage;
    public static EditCreateLoadPage editCreateLoadPage;
    public static MainAdminScreenPage mainAdminScreenPage;
    public static ConfProperties confProperties;

    @BeforeClass
    public static void setup(){
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://localhost:8080/TrackEnsure/login.do");

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
    loadListPage.getTableFragment().loadActionBtnClick();
    loadListPage.getTableFragment().loadActionEditBtnClick();

    editCreateLoadPage.getLoadSettingsFragment().setPickupDate(23, "Nov", 2020);
    editCreateLoadPage.getLoadSettingsFragment().setDeliveryDate(30, "Nov", 2020);
    editCreateLoadPage.getLoadSettingsFragment().setPickupLocation(ConfProperties.getProperty("editLoad.setPickupLocation"));
    editCreateLoadPage.getLoadSettingsFragment().setDeliveryLocation(ConfProperties.getProperty("editLoad.setDeliveryLocation"));
    editCreateLoadPage.getLoadSettingsFragment().setPickupZipCode(ConfProperties.getProperty("editLoad.setPickupZipCode"));
    editCreateLoadPage.getLoadSettingsFragment().setDeliveryZipCode(ConfProperties.getProperty("editLoad.setDeliveryZipCode"));
    editCreateLoadPage.getLoadSettingsFragment().selectTrailerType(ConfProperties.getProperty("editLoad.selectTrailerType"));
    editCreateLoadPage.getLoadSettingsFragment().setWeight(ConfProperties.getProperty("editLoad.setWeight"));
    editCreateLoadPage.getLoadSettingsFragment().selectTrailerLength(ConfProperties.getProperty("editLoad.selectTrailerLength"));
    editCreateLoadPage.getLoadSettingsFragment().setRate(ConfProperties.getProperty("editLoad.setRate"));
    editCreateLoadPage.getLoadSettingsFragment().inputItemType(ConfProperties.getProperty("editLoad.inputItemType"));
    editCreateLoadPage.getLoadSettingsFragment().selectFP(ConfProperties.getProperty("editLoad.selectFP"));
    editCreateLoadPage.getLoadSettingsFragment().inputDimension(ConfProperties.getProperty("editLoad.inputDimension"));
    editCreateLoadPage.getLoadSettingsFragment().inputComment(ConfProperties.getProperty("editLoad.inputComment"));

    editCreateLoadPage.getLoadSettingsFragment().clickSaveBtn();
    back();
    loadListPage.getFilterLoadPageFragment().inputLoadId(id);
    loadListPage.getFilterLoadPageFragment().clickBtnFilter();
    basePage.waitForPageToLoad();
    loadListPage.getPickupLocationInTable().shouldHave(Condition.text(ConfProperties.getProperty("editLoad.setPickupLocation")));

    Assert.assertEquals(loadListPage.getPickupDateInTable() , "23-Nov-2020");
    loadListPage.getDeliveryPlaceInTable().shouldHave(Condition.text(ConfProperties.getProperty("editLoad.setDeliveryLocation")));
    Assert.assertEquals(loadListPage.getDeliveryDateInTable(), "30-Nov-2020");
    loadListPage.getTrailerTypeInTable().shouldHave(Condition.text(ConfProperties.getProperty("editLoad.selectTrailerType")));
    loadListPage.getRateInTable().shouldHave(Condition.text(ConfProperties.getProperty("editLoad.setRate")));
    loadListPage.getWeightInTable().shouldHave(Condition.text(ConfProperties.getProperty("editLoad.setWeight")));
    loadListPage.getFPInTable().shouldHave(Condition.text(ConfProperties.getProperty("editLoad.selectFP")));
}
}

