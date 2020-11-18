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

    public static LoginPage login;


    @BeforeClass
    public static void setup() {
        Configuration.timeout = 100000;
        open("http://localhost:8080/TrackEnsure/login.do");
        //login = new LoginPage();
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
    createLoadPage.loadSettingsFragment.setPickupDate()
            .setDeliveryDate()
            .inputPickupLocation("Toronto, ON, Canada")
            .inputPickupLocation("New Glarus, WI, United States")
            .inputPickupZipCode("123NY")
            .inputDeliveryZipCode("321CA")
            .selectTrailerType("Dry Van")
            .inputWeight(500)
            .selectTrailerLength("53")
            .inpeuRate(200)
            .inputItemtype("test")
            .selectFP("F")
            .inputDimension("testDimension")
            .inputComment("testComment");
    createLoadPage.addOfferFragment.clickSearchDriverBtn()
            .selectDriversFromDrvList()
            .clickSaveLoadAndSendOffersBtn();

    createLoadPage.offerFragment.selectOffersList()   ;  //собрать в колекцию весь список и сравнить его с selectDriversFromDrvList()



}
}