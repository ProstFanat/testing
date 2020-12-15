package LoadDashboard;

import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import Main.CustomersPage;
import Main.DriversPage;
import Main.OptionsOfCompanyPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import loadDashboardPages.DispatchingSettingsPage;
import loadDashboardPages.EditCreateLoadPage;
import loadDashboardPages.LoadListPage;
import loadDashboardPages.fragments.FilterLoadPageFragment;
import loadDashboardPages.fragments.LoadSettingsFragment;
import org.junit.jupiter.api.*;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class FilterTabAddOffers {

    public static LoadListPage loadListPage;
    public static FilterLoadPageFragment filterLoadPageFragment;
    public static DispatchingSettingsPage dispatchingSettingsPage;
    public static BasePage basePage;
    public static EditCreateLoadPage editCreateLoadPage;
    public static LoadSettingsFragment loadSettingsFragment;
    public static CustomersPage customersPage;
    public static DriversPage driversPage;
    public static OptionsOfCompanyPage optionsOfCompanyPage;
    public static MainAdminScreenPage mainAdminScreenPage;
    public static LoginPage loginPage;

    @BeforeAll
    static void setup(){
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://localhost:8080/TrackEnsure/login.do");

        optionsOfCompanyPage = new OptionsOfCompanyPage();
        driversPage = new DriversPage();
        customersPage = new CustomersPage();
        dispatchingSettingsPage = new DispatchingSettingsPage();
        basePage = new BasePage();
        loadSettingsFragment = new LoadSettingsFragment();
        editCreateLoadPage = new EditCreateLoadPage();
        loginPage = new LoginPage();
        mainAdminScreenPage = new MainAdminScreenPage();
        filterLoadPageFragment = new FilterLoadPageFragment();
        loadListPage = new LoadListPage();

        loginPage.login("5", "test");
        mainAdminScreenPage.clickLoadSearchBtn();
        loadListPage.clickNewLoadBtn();
    }

    @BeforeEach
    void beforeTest(){
        editCreateLoadPage.getLoadSettingsFragment().setPickupLocation("Toronto");
    }

    @AfterEach
    void afterEach(){
        refresh();
    }

    @AfterAll
    static void afterAll(){

    }

    @Test
    public void searchWithNormalRadius(){
        editCreateLoadPage.getOffersTableFragment().searchDrivers("5");

//        int initSize = editCreateLoadPage.getOffersTableFragment().driversCollection.size();
//        int finalSize = 0;
//        for (int i = 0; i < initSize; i++){
//            int qwe = editCreateLoadPage.getOffersTableFragment().driversDHOCollection.get(i).getText().parse;
//        }

        System.out.println(editCreateLoadPage.getOffersTableFragment().driversCollection.size());
    }
}
