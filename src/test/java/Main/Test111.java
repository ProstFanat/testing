package Main;

import Login.Login;
import com.codeborne.selenide.Configuration;
import org.junit.*;
import static com.codeborne.selenide.Selenide.*;

public class Test111 {
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
