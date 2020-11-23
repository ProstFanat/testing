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
    public void filterByStatusBooked(){
        filterLoadPageFragment.inputStatus("Booked")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("status", "Booked");
    }

    @Test
    public void filterByStatusPreBooked(){
        filterLoadPageFragment.inputStatus("Prebooked")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("status", "Prebooked");
    }

    @Test
    public void filterByStatusDispatched(){
        filterLoadPageFragment.inputStatus("Dispatched")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("status", "Dispatched");
    }

    @Test
    public void filterByStatusDelivered(){
        filterLoadPageFragment.inputStatus("Delivered")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("status", "Delivered");
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
    public void filterByTrailerTypeDryVan(){
        filterLoadPageFragment.inputTrailerType("dry-van")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("trailerType", "dry-van");
    }

    @Test
    public void filterByTrailerTypeHeater(){
        filterLoadPageFragment.inputTrailerType("heater")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("trailerType", "heater");
    }

    @Test
    public void filterByTrailerTypeFlatbed(){
        filterLoadPageFragment.inputTrailerType("flatbed")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("trailerType", "flatbed");
    }

    @Test
    public void filterByTrailerTypeThreeAxle(){
        filterLoadPageFragment.inputTrailerType("three-axle")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("trailerType", "three-axle");
    }

    @Test
    public void filterByTrailerTypeStepdeck(){
        filterLoadPageFragment.inputTrailerType("stepdeck")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("trailerType", "stepdeck");
    }

    @Test
    public void filterByTrailerTypeConestoga(){
        filterLoadPageFragment.inputTrailerType("conestoga")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("trailerType", "conestoga");
    }

    @Test
    public void filterByTrailerTypeCarHauler(){
        filterLoadPageFragment.inputTrailerType("car hauler")
                .clickBtnFilter();
        filterLoadPageFragment.checkTable("trailerType", "car hauler");
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
