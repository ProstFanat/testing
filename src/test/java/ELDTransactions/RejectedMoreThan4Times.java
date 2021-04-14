package ELDTransactions;

import CreateTransactions.CreateTransaction;
import ELDTransactionPages.ELDMonitorPage;
import ELDTransactionPages.EldTransactionPage;
import ELDTransactionPages.Fragments.MainEldFilterFragment;
import ELDTransactionPages.Fragments.MainEldTableFragment;
import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import Main.CustomersPage;
import Main.DriversPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import loadDashboardPages.EditCreateLoadPage;
import loadDashboardPages.LoadListPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import resources.AppConstants;
import resources.BasePage;
import resources.AppConstants;

import java.util.HashMap;
import java.util.Map;

import static ELDTransactions.Actions.eldMainPage;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class RejectedMoreThan4Times {

    public static LoginPage loginPage;
    public static MainAdminScreenPage mainAdminScreenPage;
    public static BasePage basePage;
    public static CustomersPage customersPage;
    public static DriversPage driversPage;
    public static CreateTransaction createTransaction;
    public static EldTransactionPage eldTransactionPage;
    public static ELDMonitorPage eldMonitorPage;
    public static MainEldFilterFragment mainEldFilterFragment;

    @BeforeAll
    static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        loginPage = new LoginPage();
        createTransaction = new CreateTransaction();
        customersPage = new CustomersPage();
        driversPage = new DriversPage();
        eldTransactionPage = new EldTransactionPage();
        eldMonitorPage = new ELDMonitorPage();
        basePage = new BasePage();
        mainAdminScreenPage = new MainAdminScreenPage();
        mainEldFilterFragment = new MainEldFilterFragment();
        loginPage.login("adrian@mail.com", "test");
    }

    @Test
    public void test(){
        Map<String, String> driver = new HashMap<>();
        driver = createTransaction.createWithReturningUrlAndDriverName("comment");

        for (int i = 1; i <= 4; i++) {
            open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
            loginPage.login("adrian@mail.com", "test");
            open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/app-admin/hos/#/eldTransactions/transactions");
            mainEldFilterFragment.filterByDriver("Company for Autotesting", driver.get("name"));
            eldTransactionPage.getMainEldTableFragment().clickActionBtn()
                    .clickActionView();
            eldMonitorPage.getEldMonitorHeaderFragment().clickRejectBtn();
            eldMonitorPage.getEldMonitorModalWindowFragment().typeComment("Ths is a " + i + "Reject");
            eldMonitorPage.getEldMonitorModalWindowFragment().clickRejectBtn();
            mainEldFilterFragment.driverFilter.waitUntil(Condition.visible, 10000);
            customersPage.openCustomersPageFromSideBar();
            customersPage.logAsOrgOfCompany("Company For Autotesting");
            open(driver.get("url"));
            createTransaction.processTransaction("This is a " + i + " process");
        }

        System.out.println("ПОСМОТРИ ТРАНЗАКЦИИ ДЕБИЛ");

    }
}
