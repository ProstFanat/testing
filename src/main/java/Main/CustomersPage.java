package Main;

import com.codeborne.selenide.SelenideElement;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class CustomersPage extends BasePage {

    SelenideElement orgInput = $x("//input[@placeholder='Organization']"),
            btnSearch = $x("//input[@placeholder='Organization']//..//..//..//button"),
            btnLogAsOrg = $x("//*[contains(@class, 'fa-sign-in')]"),
            btnIconOnSideBar = $x("//*[@tooltip = 'Customers']");

    public void openCustomersPage(){
        open("http://localhost:8080/TrackEnsure/fleet/admin-dashboard.jsp#/customers");
        waitForPageToLoad();
    }

    public void openCustomersPageFromSideBar(){
        btnIconOnSideBar.click();
    }

    public void logAsOrgOfCompany(String company){
        orgInput.setValue(company);
        btnSearch.click();
        waitToVisibilityOf(btnLogAsOrg);
        btnLogAsOrg.click();
    }
}
