package loadDashboardPages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.$x;

public class LoadListPage {

    SelenideElement newLoadBtn = $x("//button[@routerlink='/load-list/create-load']");
    SelenideElement tabDispatchingSettings = $x("//a[@ng-reflect-router-link='dispatch-settings']");

    public LoadListPage clickNewLoadBtn() {
        newLoadBtn.click();
        return this;
    }

    public LoadListPage clickTabDispatchingSettings() {
        tabDispatchingSettings.click();
        return this;
    }

}
