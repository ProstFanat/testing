package ELDTransactions;

import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import Main.CustomersPage;
import com.codeborne.selenide.Configuration;
import loadDashboardPages.EditCreateLoadPage;
import loadDashboardPages.LoadListPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class ForTesting {

    public static LoginPage loginPage;
    public static MainAdminScreenPage mainAdminScreenPage;
    public static EditCreateLoadPage editCreateLoadPage;
    public static LoadListPage loadListPage;
    public static BasePage basePage;
    public static CustomersPage customersPage;

    @BeforeAll
    static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://localhost:8080/TrackEnsure/login.do");
        loginPage = new LoginPage();
        customersPage = new CustomersPage();
        mainAdminScreenPage = new MainAdminScreenPage();
        loginPage.login("adrian@mail.com", "test");
        mainAdminScreenPage.clickCustomers();
        customersPage.logAsOrgOfCompany("Company For Autotesting");
    }

    @Test
    public void test(){

    }
}
