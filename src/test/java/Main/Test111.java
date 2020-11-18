package Main;

import LoginAndMainPages.LoginPage;
import com.codeborne.selenide.Configuration;
import org.junit.*;
import static com.codeborne.selenide.Selenide.*;

public class Test111 {
    public static LoginPage login;

    @BeforeClass
    public static void setup() {
        Configuration.timeout = 100000;
        open("http://localhost:8080/TrackEnsure/login.do");
        login = new LoginPage();
    }

//    @Test
//    public void test(){
//        login.login();
//
//    }

}
