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
        filterLoadPageFragment.inputLoadId("658")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("loadId", "658");
    }

    @Test
    public void filterByStatus(){
        filterLoadPageFragment.inputStatus("Booked")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("status", "Booked");
    }

    @Test
    public void filterByPickUpLocation(){
        filterLoadPageFragment.inputPickUpLocation("Toronto")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("pickUpLocation", "Toronto, ON");
    }

    @Test
    public void filterByDeliveryLocation(){
        filterLoadPageFragment.inputDeliveryLocation("New York")
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
        filterLoadPageFragment.inputOrganization("Test with TP 2")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("organization", "Test with TP 2");
    }

    @Test
    public void filterByDriver(){
        filterLoadPageFragment.inputDriver("VASILII MOUZIKA")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("driver", "VASILII MOUZIKA");
    }

    @Test
    public void filterByUsingAllFilters(){
        filterLoadPageFragment.inputLoadId("658")
                .inputStatus("Delivered")
                .inputPickUpLocation("Toronto")
                .inputDeliveryLocation("West New York")
                .inputTrailerType("dry-van")
                .inputOrganization("Test with TP 2")
                .inputDriver("VASILII MOUZIKA")
                .clickBtnFilter();
        filterLoadPageFragment.checkAll("658", "Delivered", "Toronto", "West New York", "dry-van", "Test with TP 2", "VASILII MOUZIKA");
    }


    @After
    public void afterTest(){
        refresh();
    }
}
