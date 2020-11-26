package Login;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class Login {

    SelenideElement loginField = $x("//*[@id = 'email']");
    SelenideElement loginBtn = $x("//input[@value='Log In']");
    SelenideElement passwdField = $x("//*[@id = 'password']");

    public void login(){
        loginField.sendKeys("5");
        passwdField.sendKeys("test");
        loginBtn.click();
    }
}
