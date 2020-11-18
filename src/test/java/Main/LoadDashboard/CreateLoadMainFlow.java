package Main.LoadDashboard;

import loadDashboardPages.CreateLoadPage;
import loadDashboardPages.LoadListPage;
import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class CreateLoadMainFlow {

    @BeforeClass
    public static void setup() {
        Configuration.startMaximized =true;
        open("http://localhost:8080/TrackEnsure/login.do");
    }

@Test
    public void createNewLoad(){
    LoginPage loginPage = new LoginPage();
    MainAdminScreenPage mainAdminScreenPage = new MainAdminScreenPage();
    CreateLoadPage createLoadPage = new CreateLoadPage();
    LoadListPage loadListPage = new LoadListPage();

    loginPage.login("5", "test");
    mainAdminScreenPage.clickLoadSearchBtn();
    loadListPage.clickNewLoadBtn();
    createLoadPage.getLoadSettingsFragment().setPickupDate(22,"Nov", 2020)
            .setDeliveryDate(26,"Nov",2020)
            .setPickupLocation("Toronto, ON, Canada")
            .setDeliveryLocation("New Glarus, WI, United States")
            .setPickupZipCode("123NY")
            .setDeliveryZipCode("321CA")
            .selectTrailerType("Dry Van");
//            .inputWeight(500)
//            .selectTrailerLength("53")
//            .inpeuRate(200)
//            .inputItemtype("test")
//            .selectFP("F")
//            .inputDimension("testDimension")
//            .inputComment("testComment");
//   createLoadPage.getOfferFragment().clickSearchDriverBtn()    //выцепить имя и запомнить в стрингу
//            .selectDriversFromDrvList()
//            .clickSaveLoadAndSendOffersBtn();
//
//    createLoadPage.getOfferFragment().selectOffersList()   ;  //собрать в колекцию весь список и сравнить его с selectDriversFromDrvList()



}


}