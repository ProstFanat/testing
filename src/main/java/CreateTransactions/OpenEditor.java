package CreateTransactions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import resources.AppConstants;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.*;

public class OpenEditor extends BasePage {
    SelenideElement orgInput = $x("//input[@placeholder = 'Organization']"),
                    btnSearch = $x("//button[@ng-click='vm.searchOrganizations()']"),
                    btnLogAsOrg = $x("//a[@uib-tooltip='Login As Organization']"),
                    viewHosPageBtn = $x("//*[@is-permitted-for='!read.HOS-DAY-VERIFY']"),
                    hosReportTab = $x("//*[@is-permitted-for = 'read.ELD-VIEWER']"),
                    btnGenerateReport = $x("//*[@ng-click='vm.goToHosReport()']"),
                    btnGoToEditor = $x("//*[@ispermittedfor='read.ELD-EDITOR']");

    public void openEditor(){
        Selenide.open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/fleet/admin-dashboard.jsp#/customers");
        orgInput.setValue("Company For Autotesting");
        btnSearch.click();
        btnLogAsOrg.click();
        waitForPageToLoad();
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/fleet/manager/cpDrivers/#/");
        waitForPageToLoad();
        viewHosPageBtn.click();
        switchTo().window(1);
        hosReportTab.click();
        btnGenerateReport.click();
        btnGoToEditor.click();
    }
}
