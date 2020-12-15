package LoadDashboard;

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

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LoadStatus {

    public static LoginPage loginPage;
    public static MainAdminScreenPage mainAdminScreenPage;
    public static EditCreateLoadPage editCreateLoadPage;
    public static LoadListPage loadListPage;
    public static BasePage basePage;


    @BeforeAll
    static void setup() {
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

    @BeforeEach
    void beforeTest() {
        open("http://localhost:8080/TrackEnsure/app/load-board/#/load-list");
    }


    @Test
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

    @Test
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



}