package DispatcherManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;
import resources.ConfProperties;

public class openDispatcher extends BasePage {

    // найти поле логина
    @FindBy(xpath = "//*[@id = 'email']")
    private WebElement loginField;

    // найти кнопку логин
    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement loginBtn;

    // найти поле для пароля
    @FindBy(xpath = "//*[@id = 'password']")
    private WebElement passwdField;


    public openDispatcher(WebDriver driver) {
        super(driver);
    }

    // открыть страницу
    public void openDispatchers(){
        waitToVisibilityOf(10, loginField);
        waitToBeClickable(10, loginField);
        loginField.sendKeys(ConfProperties.getProperty("fleet.login"));
        passwdField.sendKeys(ConfProperties.getProperty("fleet.password"));
        loginBtn.click();
        sleep(500);
        driver.get("http://localhost:8080/TrackEnsure/fleet/manager/cpDispatchers/#/");
    }

}


