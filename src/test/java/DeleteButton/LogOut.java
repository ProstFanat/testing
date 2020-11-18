package DeleteButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOut {

    public WebDriver driver;
    public LogOut(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // найти кнопку Log Out
    @FindBy(xpath = "//*[contains(@class, 'btn-log-out') ]")
    private WebElement logoutBtn;

    // нажать на кнопку Log Out
    public void userLogout() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'btn-log-out') ]")));
        logoutBtn.click();
    }
}