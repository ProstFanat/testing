package fleetEventsOld;

import resources.BasePage;
import resources.AppConstants;
import resources.ConfProperties;
import org.openqa.selenium.WebDriver;
import resources.AppConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenFleetPage extends BasePage {

    // найти поле логина
    @FindBy(xpath = "//*[@id = 'email']")
    private WebElement loginField;

    // найти кнопку логин
    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement loginBtn;

    // найти поле для пароля
    @FindBy(xpath = "//*[@id = 'password']")
    private WebElement passwdField;

    // найти иконку fleet Events
    @FindBy(xpath = "//div[@id = 'sidebar']//a[16]")
    private WebElement fleet;

    public OpenFleetPage(WebDriver driver) {
        super(driver);
    }

    // открыть страницу
    public void openFleetEvents(){
        waitToVisibilityOf(10, loginField);
        waitToBeClickable(10, loginField);
        loginField.sendKeys(ConfProperties.getProperty("fleet.login"));
        passwdField.sendKeys(ConfProperties.getProperty("fleet.password"));
        loginBtn.click();
        sleep(500);
        driver.get("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/app/fleet-events/#/trip-view(details:trip-view-details)");
    }

    /** Найти поле для трип номера*/
    @FindBy(xpath = "//*[@placeholder = 'Search Trip Number']//input")
    private WebElement inputTripNumber;

    /** Найти кнопку поиска для трип номера*/
    @FindBy(xpath = "//*[@placeholder = 'Search Trip Number']//..//button")
    private WebElement btnSearchTrip;

    /** Найти трип в списке*/
    @FindBy(xpath = "//*[@placeholder = 'Search Trip Number']//ng-dropdown-panel")
    private WebElement tripFromList;

    public void findTrip(String trip){
        waitToVisibilityOf(10, inputTripNumber);
        waitToBeClickable(10, inputTripNumber);
        inputTripNumber.sendKeys(trip);
        btnSearchTrip.click();
        waitToBeClickable(10, tripFromList);
        sleep(500);
        tripFromList.click();
    }

}
