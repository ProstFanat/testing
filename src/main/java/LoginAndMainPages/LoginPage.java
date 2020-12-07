package LoginAndMainPages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    SelenideElement loginField = $x("//*[@id = 'email']");
    SelenideElement loginBtn = $x("//input[@value='Log In']");
    SelenideElement passwordField = $x("//*[@id = 'password']");

    public void login(String logIn, String pass) {
        loginField.sendKeys(logIn);
        passwordField.sendKeys(pass);
        loginBtn.click();
    }

    public void login(){
        loginField.sendKeys("5");
        passwordField.sendKeys("test");
        loginBtn.click();
    }
}
