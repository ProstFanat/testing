package Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;
import static com.codeborne.selenide.Selenide.*;
import resources.ConfProperties;

public class Login extends BasePage {
    public WebDriver driver;

    public Login(WebDriver driver) {
        super(driver);
    }

    // найти поле логина
    @FindBy(xpath = "//*[@id = 'email']")
    private WebElement loginField;

    // найти кнопку логин
    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement loginBtn;

    // найти поле для пароля
    @FindBy(xpath = "//*[@id = 'password']")
    private WebElement passwdField;

    public void login(String login){
        open("http://localhost:8080/TrackEnsure/login.do");
        waitToVisibilityOf(10, loginField);
        waitToBeClickable(10, loginField);
        loginField.sendKeys(login);
        passwdField.sendKeys("test");
        loginBtn.click();
        sleep(500);
    }
}
