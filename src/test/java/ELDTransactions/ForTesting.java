package ELDTransactions;

import CreateTransactions.CreateTransaction;
import LoginAndMainPages.LoginPage;
import LoginAndMainPages.MainAdminScreenPage;
import Main.CustomersPage;
import Main.DriversPage;
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
    public static DriversPage driversPage;
    public static CreateTransaction createTransaction;

    @BeforeAll
    static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://10.10.1.83:8080/TrackEnsure/login.do");
        loginPage = new LoginPage();
        createTransaction = new CreateTransaction();
        customersPage = new CustomersPage();
        driversPage = new DriversPage();
        mainAdminScreenPage = new MainAdminScreenPage();
        loginPage.login("5", "test");
        mainAdminScreenPage.clickCustomers();
        customersPage.logAsOrgOfCompany("Company For Autotesting");
        driversPage.openPage();
    }

    @Test
    public void test(){
        createTransaction.createTransaction(40, "comment");
        sleep(5000);
    }
}
