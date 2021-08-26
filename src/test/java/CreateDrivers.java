import loginAndMainPages.LoginPage;
import main.CustomersPage;
import main.DriversPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import resources.AppConstants;

import static com.codeborne.selenide.Selenide.open;

public class CreateDrivers {

    public static LoginPage login;
    public static CreateTransactions create;
    public static DriversPage driversPage;
    public static CustomersPage customersPage;

    @BeforeAll
    static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/login.do");
        login = new LoginPage();
        create = new CreateTransactions();
        customersPage = new CustomersPage();
        driversPage = new DriversPage();
        login.login();
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/fleet/admin-dashboard.jsp#/customers");
        customersPage.logAsOrgOfCompany("Company For Autotesting");
        driversPage.openPage();
    }

    @Test
    public void test(){
        driversPage.createNewDriver();
        for(int i = 0; i < 100; i++) {
            driversPage.createNewDriver();
        }
    }
}
