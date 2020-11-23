package logic.pages.admin;

import logic.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage {
    public AdminPage() {
        super();
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        return false;
    }

    @FindBy (css = "div[ng-click=\"vm.goToState('customers')\"]")
    private WebElement customersBtn;
    @FindBy (css = "div[uib-modal-transclude='']")
    private WebElement confirmStartShiftModalWindow;

    public AdminPage closeConfirmStartShiftWindow(){
        waitToVisibilityOf(20,confirmStartShiftModalWindow);
        log.info("Close Confirm Start Shift Modal Window");
        driver.findElement(By.cssSelector("button[ng-click='vm.no()']")).click();
        return this;
    }
    public CustomersPage goToCustomersPage(){
        clickOnElement(customersBtn);
        return new CustomersPage();
    }
}
