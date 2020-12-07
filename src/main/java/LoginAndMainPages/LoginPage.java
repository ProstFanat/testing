package LoginAndMainPages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    SelenideElement loginField = $x("//*[@id = 'email']");
    SelenideElement loginBtn = $x("//input[@value='Log In']");
    SelenideElement passwordField = $x("//*[@id = 'password']");

<<<<<<< HEAD:src/main/java/LoginAndMainPages/LoginPage.java
    public void login(String logIn, String pass){
        loginField.sendKeys(logIn);
        passwordField.sendKeys(pass);
=======
    public void login(){
        loginField.sendKeys("5");
        passwdField.sendKeys("test");
>>>>>>> CreateTransactions:src/main/java/Login/Login.java
        loginBtn.click();
    }
}
