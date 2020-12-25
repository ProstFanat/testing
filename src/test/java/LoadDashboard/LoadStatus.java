package LoadDashboard;

import DB.DBConnection;
import DB.DBLoads;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import loadDashboardPages.EditCreateLoadPage;
import loadDashboardPages.LoadListPage;
import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.BasePage;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.*;
import static sun.management.Agent.error;


public class LoadStatus {

    public static LoginPage loginPage;
    public static MainAdminScreenPage mainAdminScreenPage;
    public static EditCreateLoadPage editCreateLoadPage;
    public static LoadListPage loadListPage;
    public static BasePage basePage;
    public static DBLoads dbLoads;


    @BeforeAll
    static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://localhost:8080/TrackEnsure/login.do");
        loginPage = new LoginPage();
        mainAdminScreenPage = new MainAdminScreenPage();
        editCreateLoadPage = new EditCreateLoadPage();
        dbLoads = new DBLoads();
        loadListPage = new LoadListPage();
        loginPage.login("5", "test");
        basePage = new BasePage();
    }

    @BeforeEach
    void beforeTest() {
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
    }

    @Test()
    public void loadStatusPrebooked() {
        loadListPage.clickNewLoadBtn();
        editCreateLoadPage.setDefaultLoadSettings().getLoadSettingsFragment().clickSaveBtn();
        editCreateLoadPage.getLoadSettingsFragment().waitClickbleSaveBtn();
        String id = editCreateLoadPage.getID();
        editCreateLoadPage.backToLoadBoard();

        loadListPage.getFilterLoadPageFragment().inputStatus("Prebooked").clickBtnFilter();
        loadListPage.getFilterLoadPageFragment().inputLoadId(id).clickBtnFilter();
        loadListPage.getTableFragment().loadActionBtnClick();
        loadListPage.getTableFragment().actionsFromActionBtnSize().shouldHaveSize(2);

        Assertions.assertEquals("Edit", loadListPage.getTableFragment().getActionsFromActionBtn().get(0));
        Assertions.assertEquals("Delete", loadListPage.getTableFragment().getActionsFromActionBtn().get(1));
    }

    @Test()
    public void loadStatusBooked() {
        loadListPage.clickNewLoadBtn();
        editCreateLoadPage.setDefaultLoadSettings().getLoadSettingsFragment();
        editCreateLoadPage.getOffersTableFragment()
                .searchDrivers("7")
                .selectDrivers()
                .clickSaveLoadAndSendOffersBtn()
                .clearFilterBtn.waitUntil(Condition.visible, 5000);
        String id = editCreateLoadPage.getID();
        editCreateLoadPage.backToLoadBoard();

        loadListPage.getFilterLoadPageFragment().inputStatus("Booked").clickBtnFilter();
        loadListPage.getFilterLoadPageFragment().inputLoadId(id).clickBtnFilter();
        loadListPage.getTableFragment().loadActionBtnClick();
        loadListPage.getTableFragment().actionsFromActionBtnSize().shouldHaveSize(2);

        Assertions.assertEquals("Edit", loadListPage.getTableFragment().getActionsFromActionBtn().get(0));
        Assertions.assertEquals("Delete", loadListPage.getTableFragment().getActionsFromActionBtn().get(1));
    }

    @Test
    public void loadStatusDispatched() throws SQLException, ClassNotFoundException {
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
        editCreateLoadPage.setDefaultLoadSettings();
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Ukraina");
        editCreateLoadPage.getOffersTableFragment().searchDrivers("200")
                .selectDriverByName("Mao Ntwari")
                .clickSaveLoadAndSendOffersBtn();
        basePage.waitToVisibilityOf(editCreateLoadPage.getLoadSettingsFragment().btnFilter);
        String load_id = editCreateLoadPage.getID();

        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
        dbLoads.updateLoadStatusByLoadId(load_id, "Dispatched");
        loadListPage.getFilterLoadPageFragment().inputLoadId(load_id).clickBtnFilter();
        loadListPage.getTableFragment().loadActionBtnClick();
        loadListPage.getTableFragment().actionsFromActionBtnSize().shouldHaveSize(3);

        Assertions.assertEquals("Edit", loadListPage.getTableFragment().getActionsFromActionBtn().get(0));
        Assertions.assertEquals("Delete", loadListPage.getTableFragment().getActionsFromActionBtn().get(1));
        Assertions.assertEquals("Delivered", loadListPage.getTableFragment().getActionsFromActionBtn().get(2));
    }

    @Test
    public void loadStatusDelivered() throws SQLException, ClassNotFoundException {
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
        editCreateLoadPage.setDefaultLoadSettings();
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Ukraina");
        editCreateLoadPage.getOffersTableFragment().searchDrivers("200")
                .selectDriverByName("Mao Ntwari")
                .clickSaveLoadAndSendOffersBtn();
        basePage.waitToVisibilityOf(editCreateLoadPage.getLoadSettingsFragment().btnFilter);
        String load_id = editCreateLoadPage.getID();

        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
        dbLoads.updateLoadStatusByLoadId(load_id, "Delivered");
        loadListPage.getFilterLoadPageFragment().inputLoadId(load_id).clickBtnFilter();
        loadListPage.getTableFragment().loadActionBtnClick();
        loadListPage.getTableFragment().actionsFromActionBtnSize().shouldHaveSize(1);

        Assertions.assertEquals("Delete", loadListPage.getTableFragment().getActionsFromActionBtn().get(0));
    }

    @Test
    public void loadStatusWithOneOffer(){
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
        editCreateLoadPage.setDefaultLoadSettings();
        editCreateLoadPage.getLoadSettingsFragment().clickSaveBtn();
        basePage.waitToVisibilityOf(editCreateLoadPage.getLoadSettingsFragment().btnFilter);
        String load_id = editCreateLoadPage.getID();

        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
        loadListPage.getFilterLoadPageFragment().inputLoadId(load_id)
                .inputStatus("Prebooked")
                .clickBtnFilter()
                .tableSize.shouldHaveSize(1);

        loadListPage.getTableFragment().loadActionBtnClick()
                .loadActionEditBtnClick();
        editCreateLoadPage.getLoadSettingsFragment().goToAddOfferTab();
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Ukraina");
        editCreateLoadPage.getOffersTableFragment().searchDrivers("200")
                .selectDriverByName("Mao Ntwari")
                .clickSaveLoadAndSendOffersBtn();
        basePage.waitToVisibilityOf(editCreateLoadPage.getLoadSettingsFragment().btnFilter);
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
        loadListPage.getFilterLoadPageFragment().inputLoadId(load_id)
                .inputStatus("Booked")
                .clickBtnFilter()
                .tableSize.shouldHaveSize(1);
    }

    @Test
    public void deleteOffersFromLoadWithStatusBooked(){
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
        editCreateLoadPage.setDefaultLoadSettings();
        editCreateLoadPage.getLoadSettingsFragment().clickSaveBtn();
        basePage.waitToVisibilityOf(editCreateLoadPage.getLoadSettingsFragment().btnFilter);
        String load_id = editCreateLoadPage.getID();

        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
        loadListPage.getFilterLoadPageFragment().inputLoadId(load_id)
                .inputStatus("Prebooked")
                .clickBtnFilter()
                .tableSize.shouldHaveSize(1);

        loadListPage.getTableFragment().loadActionBtnClick()
                .loadActionEditBtnClick();
        editCreateLoadPage.getLoadSettingsFragment().goToAddOfferTab();
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Ukraina");
        editCreateLoadPage.getOffersTableFragment().searchDrivers("200")
                .selectDriverByName("Mao Ntwari")
                .clickSaveLoadAndSendOffersBtn();
        basePage.waitToVisibilityOf(editCreateLoadPage.getLoadSettingsFragment().btnFilter);
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
        loadListPage.getFilterLoadPageFragment().inputLoadId(load_id)
                .inputStatus("Booked")
                .clickBtnFilter()
                .tableSize.shouldHaveSize(1);

        loadListPage.getTableFragment().loadActionBtnClick()
                .loadActionEditBtnClick();
        editCreateLoadPage.getLoadSettingsFragment()
                .deleteOffer(1)
                .buttonsActionsOffers.shouldHaveSize(0);
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
        loadListPage.getFilterLoadPageFragment().inputLoadId(load_id)
                .inputStatus("Prebooked")
                .clickBtnFilter()
                .tableSize.shouldHaveSize(1);
    }

    @Test
    public void deleteOffersFromLoadWithStatusDispatched() throws SQLException, ClassNotFoundException {
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
        editCreateLoadPage.setDefaultLoadSettings();
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Ukraina");
        editCreateLoadPage.getOffersTableFragment().searchDrivers("200")
                .selectDriverByName("Mao Ntwari")
                .clickSaveLoadAndSendOffersBtn();
        basePage.waitToVisibilityOf(editCreateLoadPage.getLoadSettingsFragment().btnFilter);
        String load_id = editCreateLoadPage.getID();
        dbLoads.updateOfferStatusByLoadId(load_id, "booked");
        editCreateLoadPage.getLoadSettingsFragment().btnFilter.click();
        editCreateLoadPage.getLoadSettingsFragment().confirmOffer(1);
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
        loadListPage.getFilterLoadPageFragment().inputLoadId(load_id)
                .inputStatus("Dispatched")
                .clickBtnFilter()
                .tableSize.shouldHaveSize(1);

        loadListPage.getTableFragment().loadActionBtnClick()
                .loadActionEditBtnClick();
        editCreateLoadPage.getLoadSettingsFragment()
                .deleteOffer(1)
                .buttonsActionsOffers.shouldHaveSize(0);
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
        loadListPage.getFilterLoadPageFragment().inputLoadId(load_id)
                .inputStatus("Prebooked")
                .clickBtnFilter()
                .tableSize.shouldHaveSize(1);
    }

    @Test
    public void deleteOneOfferFromLoadWithStatusDispatched() throws SQLException, ClassNotFoundException {
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
        editCreateLoadPage.setDefaultLoadSettings();
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Ukraina");
        editCreateLoadPage.getOffersTableFragment().searchDrivers("200")
                .selectDriverByName("Mao Ntwari")
                .clickSaveLoadAndSendOffersBtn();
        basePage.waitToVisibilityOf(editCreateLoadPage.getLoadSettingsFragment().btnFilter);
        String load_id = editCreateLoadPage.getID();
        dbLoads.updateOfferStatusByLoadId(load_id, "booked");
        editCreateLoadPage.getLoadSettingsFragment().btnFilter.click();
        editCreateLoadPage.getLoadSettingsFragment().confirmOffer(1);

        editCreateLoadPage.getLoadSettingsFragment().goToAddOfferTab();
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Ukraina");
        editCreateLoadPage.getOffersTableFragment().searchDrivers("200")
                .selectDriverByName("Oleksandr Vengren")
                .clickSaveLoadAndSendOffersBtn();
        basePage.waitToVisibilityOf(editCreateLoadPage.getLoadSettingsFragment().btnFilter);

        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
        loadListPage.getFilterLoadPageFragment().inputLoadId(load_id)
                .inputStatus("Dispatched")
                .clickBtnFilter()
                .tableSize.shouldHaveSize(1);

        loadListPage.getTableFragment().loadActionBtnClick()
                .loadActionEditBtnClick();
        editCreateLoadPage.getLoadSettingsFragment()
                .deleteOffer(1)
                .buttonsActionsOffers.shouldHaveSize(1);
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
        loadListPage.getFilterLoadPageFragment().inputLoadId(load_id)
                .inputStatus("Booked")
                .clickBtnFilter()
                .tableSize.shouldHaveSize(1);
    }

    @Test
    public void addBookedOfferToLoadWithStatusBooked() throws SQLException, ClassNotFoundException {
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
        editCreateLoadPage.setDefaultLoadSettings();
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Ukraina");
        editCreateLoadPage.getOffersTableFragment().searchDrivers("200")
                .selectDriverByName("Mao Ntwari")
                .clickSaveLoadAndSendOffersBtn();
        basePage.waitToVisibilityOf(editCreateLoadPage.getLoadSettingsFragment().btnFilter);
        String load_id = editCreateLoadPage.getID();

        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
        loadListPage.getFilterLoadPageFragment().inputLoadId(load_id)
                .inputStatus("Booked")
                .clickBtnFilter()
                .tableSize.shouldHaveSize(1);

        loadListPage.getTableFragment().loadActionBtnClick()
                .loadActionEditBtnClick();

        dbLoads.updateOfferStatusByLoadId(load_id, "booked");
        editCreateLoadPage.getLoadSettingsFragment().btnFilter.click();

        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
        loadListPage.getFilterLoadPageFragment().inputLoadId(load_id)
                .inputStatus("Booked")
                .clickBtnFilter()
                .tableSize.shouldHaveSize(1);
    }

    @Test
    public void rejectOfferFromLoadWithStatusDispatched() throws SQLException, ClassNotFoundException {
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
        editCreateLoadPage.setDefaultLoadSettings();
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Ukraina");
        editCreateLoadPage.getOffersTableFragment().searchDrivers("200")
                .selectDriverByName("Mao Ntwari")
                .clickSaveLoadAndSendOffersBtn();
        basePage.waitToVisibilityOf(editCreateLoadPage.getLoadSettingsFragment().btnFilter);
        String load_id = editCreateLoadPage.getID();
        dbLoads.updateOfferStatusByLoadId(load_id, "booked");
        editCreateLoadPage.getLoadSettingsFragment().btnFilter.click();
        editCreateLoadPage.getLoadSettingsFragment().confirmOffer(1);
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
        loadListPage.getFilterLoadPageFragment().inputLoadId(load_id)
                .inputStatus("Dispatched")
                .clickBtnFilter()
                .tableSize.shouldHaveSize(1);

        loadListPage.getTableFragment().loadActionBtnClick()
                .loadActionEditBtnClick();
        editCreateLoadPage.getLoadSettingsFragment()
                .rejectOffer(1)
                .buttonsActionsOffers.shouldHaveSize(1);
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
        loadListPage.getFilterLoadPageFragment().inputLoadId(load_id)
                .inputStatus("Booked")
                .clickBtnFilter()
                .tableSize.shouldHaveSize(1);
    }

    @Test
    public void rejectOffersFromLoadWithStatusBooked() throws SQLException, ClassNotFoundException {
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list/create-load");
        editCreateLoadPage.setDefaultLoadSettings();
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Ukraina");
        editCreateLoadPage.getOffersTableFragment().searchDrivers("200")
                .selectDriverByName("Mao Ntwari")
                .clickSaveLoadAndSendOffersBtn();
        basePage.waitToVisibilityOf(editCreateLoadPage.getLoadSettingsFragment().btnFilter);
        String load_id = editCreateLoadPage.getID();
        dbLoads.updateOfferStatusByLoadId(load_id, "booked");
        editCreateLoadPage.getLoadSettingsFragment().btnFilter.click();
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
        loadListPage.getFilterLoadPageFragment().inputLoadId(load_id)
                .inputStatus("Booked")
                .clickBtnFilter()
                .tableSize.shouldHaveSize(1);

        loadListPage.getTableFragment().loadActionBtnClick()
                .loadActionEditBtnClick();
        editCreateLoadPage.getLoadSettingsFragment()
                .rejectOffer(1)
                .buttonsActionsOffers.shouldHaveSize(1);
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
        loadListPage.getFilterLoadPageFragment().inputLoadId(load_id)
                .inputStatus("Booked")
                .clickBtnFilter()
                .tableSize.shouldHaveSize(1);
    }



//
//    @Test()
//    public void loadStatusBookedWithBookedOffer() { //throws SQLException{
//        loadListPage.clickNewLoadBtn();
//        editCreateLoadPage.setDefaultLoadSettings().getLoadSettingsFragment();
//        editCreateLoadPage.getOffersTableFragment()
//                .searchDrivers("7")
//                .selectDrivers()
//                .clickSaveLoadAndSendOffersBtn()
//                .clearFilterBtn.waitUntil(Condition.visible, 5000);
//        String id = editCreateLoadPage.getID();
//        editCreateLoadPage.backToLoadBoard();
//
//
//        //changeOfferStatus("booked");
//
//        loadListPage.getFilterLoadPageFragment().inputStatus("Booked").clickBtnFilter();
//        loadListPage.getFilterLoadPageFragment().inputLoadId(id).clickBtnFilter();
//        loadListPage.getTableFragment().loadActionBtnClick();
//        loadListPage.getTableFragment().actionsFromActionBtnSize().shouldHaveSize(2);
//
//        Assertions.assertEquals("Edit", loadListPage.getTableFragment().getActionsFromActionBtn().get(0));
//        Assertions.assertEquals("Delete", loadListPage.getTableFragment().getActionsFromActionBtn().get(1));
//    }

}
