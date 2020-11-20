package Main.LoadDashboard;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import loadDashboardPages.CreateLoadPage;
import loadDashboardPages.LoadListPage;
import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Configuration;
import loadDashboardPages.fragments.OffersTableFragment;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class CreateLoadMainFlow {

    @BeforeClass
    public static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized =true;
        open("http://localhost:8080/TrackEnsure/login.do");
    }

@Test
    public void createNewLoad(){
    LoginPage loginPage = new LoginPage();
    MainAdminScreenPage mainAdminScreenPage = new MainAdminScreenPage();
    CreateLoadPage createLoadPage = new CreateLoadPage();
    LoadListPage loadListPage = new LoadListPage();
    //OffersTableFragment offersTableFragment = new OffersTableFragment();

    loginPage.login("5", "test");

    mainAdminScreenPage.clickLoadSearchBtn();

    loadListPage.clickNewLoadBtn();

    createLoadPage.setDefaultLoadSettings();
    createLoadPage.getOffersTableFragment().searchAndSelectDrivers();//.toString();//выцепить имя и запомнить в стрингу
    createLoadPage.getOffersTableFragment().rememberDrivers();
    createLoadPage.getOffersTableFragment().clickSaveLoadAndSendOffersBtn();
    createLoadPage.getOffersTableFragment().getOffers();

    createLoadPage.getOffersTableFragment().checkDrivers();

//    createLoadPage.getOfferFragment().selectOffersList()   ;  //собрать в колекцию весь список и сравнить его с selectDriversFromDrvList()



}



}