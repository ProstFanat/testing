package Main;

import com.codeborne.selenide.SelenideElement;
//import org.openqa.selenium.WebElement;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class DriversPage extends BasePage {

    public SelenideElement firstNameInput = $x("//input[@name='driverFirstName']"),
                            lastNameInput = $x("//input[@name='driverLastName']"),
                            btnUpdateDriver = $x("//a[@uib-tooltip = 'Update']//i[contains(@class, 'fa-pencil')]"),
                            checkBoxActivateLoadBoard = $x("//*[@ng-if = 'vm.sendLoadOffers']//input"),
                            btnSave = $x("//button[contains(text(), 'Save')]");

    public DriversPage openPage(){
        open("http://localhost:8080/TrackEnsure/fleet/manager/cpDrivers/#/");
        return this;
    }

    public DriversPage openUpdatePageForDriver(String firstName, String lastName){
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        sleep(1000);
        btnUpdateDriver.click();

        return this;
    }

    public DriversPage setLoadBoardCheckBox(Boolean value){
        checkBoxActivateLoadBoard.setSelected(value);
        return this;
    }

    public DriversPage saveDriverProfile(){
        btnSave.click();
        waitToVisibilityOf(firstNameInput);
        return this;
    }

}
