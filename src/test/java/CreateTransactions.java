
import  LoginAndMainPages.LoginPage;
import CreateTransactions.*;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.open;


public class CreateTransactions {
    public static LoginPage login;
    public static OpenEditor openEditor;
    public static CreateTransaction create;

    @BeforeAll
    static void setup() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        open("http://localhost:8080/TrackEnsure/login.do");
        login = new LoginPage();
        openEditor = new OpenEditor();
        create = new CreateTransaction();
        login.login();
        openEditor.openEditor();

    }

    @Test
    public void test(){
        create.create(10, 20);
    }
}
