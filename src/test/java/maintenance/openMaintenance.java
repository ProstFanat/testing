package maintenance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;

public class openMaintenance extends BasePage {
    public WebDriver driver;

    // найти поле логина
    @FindBy(xpath = "//*[@id = 'email']")
    private WebElement loginField;

    // найти кнопку логин
    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement loginBtn;

    // найти поле для пароля
    @FindBy(xpath = "//*[@id = 'password']")
    private WebElement passwdField;

    // найти иконку maintenance
    @FindBy(xpath = "//div[@id = 'sidebar']//a[13]")
    private WebElement maintenance;

    public openMaintenance(WebDriver driver) {
        super(driver);
    }

    public void openMaintenance(){
        waitToVisibilityOf(10, loginField);
        waitToBeClickable(10, loginField);
        loginField.sendKeys("358");
        passwdField.sendKeys("test");
        loginBtn.click();
        waitToVisibilityOf(10, maintenance);
        waitToBeClickable(10, maintenance);
        maintenance.click();
    }
}
