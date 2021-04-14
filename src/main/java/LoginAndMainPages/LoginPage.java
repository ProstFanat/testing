package LoginAndMainPages;

import com.codeborne.selenide.SelenideElement;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    SelenideElement loginField = $x("//*[@id = 'email']");
    SelenideElement loginBtn = $x("//input[@value='Log In']");
    SelenideElement passwordField = $x("//*[@id = 'password']");
    SelenideElement cancelShiftBtn = $x("//*[@class = 'modal-footer']//button[@ng-click = 'vm.no()']");

    public void login(String logIn, String pass) {
        loginField.sendKeys(logIn);
        passwordField.sendKeys(pass);
        loginBtn.click();
        waitForPageToLoad();
        if (cancelShiftBtn.exists()){
            cancelShiftBtn.click();
            waitForPageToLoad();
        }
    }

    public void login(){
        loginField.sendKeys("5");
        passwordField.sendKeys("test");
        loginBtn.click();
    }
}
