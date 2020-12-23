package FleetLoadBoard;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import loadDashboardPages.DispatchingSettingsPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainFleetBoardTablePage {

    public SelenideElement orgNameInput = $x("//input[@placeholder='Organization Name']");



//
//    public DispatchingSettingsPage inputOrgName(String org) {
//        waitToVisibilityOf(orgNameInput);
//        orgNameInput.setValue(org);
//        btnFilter.click();
//        waitToVisibilityOf(checkBoxesForOrgList.first());
//
//        return this;
//    }







}
