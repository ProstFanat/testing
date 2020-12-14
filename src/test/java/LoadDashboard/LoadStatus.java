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
    public void filterByLoadId(){

        loadListPage.getFilterLoadPageFragment().inputStatus("Prebooked").clickBtnFilter();
        loadListPage.getTableFragment().loadActionBtnClick();
        String id = loadListPage.getTableFragment().getFirstLoadId();
        loadListPage.getFilterLoadPageFragment().inputLoadId(id).clickBtnFilter();
        loadListPage.getTableFragment().getActionsFromActionBtn().shouldHaveSize(2);
//        loadListPage.getTableFragment().getActionsFromActionBtn().shouldHave().shouldHave();
//String test1 = loadListPage.getTableFragment().getActionsFromActionBtn().
//        String test2 = loadListPage.getTableFragment().getActionsFromActionBtn().get(1).toString();
//        System.out.println(test1);
//        System.out.println(test2);
    }









}