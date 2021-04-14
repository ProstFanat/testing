package Main;

import com.codeborne.selenide.SelenideElement;
import resources.BasePage;
import resources.AppConstants;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class CustomersPage extends BasePage {

    SelenideElement orgInput = $x("//input[@placeholder='Organization']"),
            btnSearch = $x("//input[@placeholder='Organization']//..//..//..//button"),
            btnLogAsOrg = $x("//*[contains(@class, 'fa-sign-in')]"),
            btnIconOnSideBar = $x("//*[@tooltip = 'Customers']");

    public void openCustomersPage(){
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/fleet/admin-dashboard.jsp#/customers");
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
