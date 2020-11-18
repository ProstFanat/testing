package DeleteButton;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
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

    //ввод логина
    public void inputLogin(String login) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'email']")));
        loginField.sendKeys(login);
    }

    //ввод пароля
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    // нажать на кнопку логин
    public void clickLoginBtn() {
        loginBtn.click();
    }

    // Сделать скриншот
    public void takeScreen(String src, String name) throws IOException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File screenshot = ((TakesScreenshot) driver).
                getScreenshotAs(OutputType.FILE);
        String path = src + name;
        FileUtils.copyFile(screenshot, new File(path));
    }
}

