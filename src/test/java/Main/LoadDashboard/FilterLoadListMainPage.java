package Main.LoadDashboard;

import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import com.codeborne.selenide.Configuration;
import loadDashboardPages.LoadListPage;
import loadDashboardPages.fragments.FilterLoadPageFragment;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class FilterLoadListMainPage {

    public static LoadListPage loadListPage;
    public static FilterLoadPageFragment filterLoadPageFragment;


    @BeforeClass
    public static void setup(){
        Configuration.timeout = 100000;
        Configuration.startMaximized = true;
        open("http://localhost:8080/TrackEnsure/login.do");

        LoginPage loginPage = new LoginPage();
        MainAdminScreenPage mainAdminScreenPage = new MainAdminScreenPage();
        filterLoadPageFragment = new FilterLoadPageFragment();
        loadListPage = new LoadListPage();

        loginPage.login("5", "test");
        mainAdminScreenPage.clickLoadSearchBtn();
    }

    @Test
    public void filterByLoadId(){
        filterLoadPageFragment.inputLoadId("624")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("loadId", "624");
    }

    @Test
    public void filterByStatus(){
        filterLoadPageFragment.inputStatus("Prebooked")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("status", "Prebooked");
    }

    @Test
    public void filterByPickUpLocation(){
        filterLoadPageFragment.inputPickUpLocation("Toronto")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("pickUpLocation", "Toronto, ON");
    }

    @Test
    public void filterByDeliveryLocation(){
        filterLoadPageFragment.inputDeliveryLocation("West New York")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("deliveryLocation", "West New York");
    }

    @Test
    public void filterByTrailerType(){
        filterLoadPageFragment.inputTrailerType("dry-van")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("trailerType", "dry-van");
    }

    @Test
    public void filterByOrganization(){
        filterLoadPageFragment.inputOrganization("")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("organization", "dry-van");
    }

    @Test
    public void filterByDriver(){
        filterLoadPageFragment.inputDriver("")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("driver", "");
    }

    @Test
    public void filterByUsingAllFilters(){
        filterLoadPageFragment.inputLoadId("642")
                .inputStatus("Prebooked")
                .inputPickUpLocation("Toronto")
                .inputDeliveryLocation("West New York")
                .inputTrailerType("dry-van")
                .inputOrganization("")
                .inputDriver("")
                .clickBtnFilter();
        filterLoadPageFragment.checkAll("642", "Prebooked", "Toronto", "West New York", "dry-van", "", "");
    }


    @After
    public void afterTest(){
        refresh();
    }
}
