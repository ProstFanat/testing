package CreateTransactions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import resources.AppConstants;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class OpenEditor extends BasePage {
    SelenideElement orgInput = $x("//input[@placeholder = 'Organization']");
    SelenideElement btnSearch = $x("//button[@ng-click='vm.searchOrganizations()']");
    SelenideElement btnLogAsOrg = $x("//a[@uib-tooltip='Login As Organization']");

    public void openEditor(){
        Selenide.open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/fleet/admin-dashboard.jsp#/customers");
        waitForPageToLoad();
        orgInput.setValue("Company For Autotesting");
        btnSearch.click();
        btnLogAsOrg.click();
        waitForPageToLoad();
        Selenide.open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/app/hos/#/eldHOS/editor/driver/17663/timestamp/1606427999999/timeZone/US%2FEastern");
    }
}
