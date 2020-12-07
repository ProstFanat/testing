package TGLN;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;

public class AddTruckToDevice extends BasePage {

    public AddTruckToDevice(WebDriver driver) {
        super(driver);
    }

    /** Find truckNumber Input*/
    @FindBy(xpath = "//input[@placeholder = 'Truck Number']")
    public WebElement truckNumberInput;

    /** Find Edit Button*/
    @FindBy(xpath = "//*[@href = 'http://localhost:8080/TrackEnsure/fleet/manager/truckProfile/#/id/283266']//..//*[contains(@class, 'fa-pencil')]")
    public WebElement btnEditTruck;

    /** Find GPS Provider div*/
    @FindBy(xpath = "//div[@placeholder = 'Select Provider']")
    public WebElement gpsProviderSpan;

    /** Find GPS Provider Input*/
    @FindBy(xpath = "//input[@placeholder = 'Select Provider']")
    public WebElement gpsProviderInput;

    /** Find GPS Unit ID div*/
    @FindBy(xpath = "//*[text() = 'Select GPS Unit']")
    public WebElement gpsUnitIdSpan;

    /** Find GPS Unit ID input*/
    @FindBy(xpath = "//input[@placeholder = 'Select GPS Unit']")
    public WebElement gpsUnitIdInput;

    /** Find Save Button*/
    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    public WebElement btnSave;

    public void connectDeviceWithTruck(String truck, String deviceUID){
        driver.get("http://localhost:8080/TrackEnsure/fleet/manager/cpAssets/#/");
        waitToVisibilityOf(10, truckNumberInput);
        waitToBeClickable(10, truckNumberInput);
        truckNumberInput.sendKeys(truck);
        btnEditTruck.click();
        waitToVisibilityOf(10,gpsProviderSpan);
        waitToBeClickable(10, gpsProviderSpan);
        gpsProviderSpan.click();
        gpsProviderInput.sendKeys("trackensure-elog-gps");
        gpsProviderInput.sendKeys(Keys.ENTER);
        gpsUnitIdSpan.click();
        gpsUnitIdInput.sendKeys(deviceUID);
        gpsUnitIdInput.sendKeys(Keys.ENTER);
        btnSave.click();
        sleep(1000);
        driver.get("http://localhost:8080/TrackEnsure/fleet/manager/cpGPSDevices/#/");
    }

}
