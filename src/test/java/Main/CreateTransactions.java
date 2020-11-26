package Main;

import Login.Login;
import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class CreateTransactions {
    public static Login login;

    @BeforeClass
    public static void setup() {
        Configuration.timeout = 100000;
        open("http://localhost:8080/TrackEnsure/login.do");
        login = new Login();
        Configuration.timeout = 6000;
    }

    @Test
    public void test(){
        login.login();

    }
}
