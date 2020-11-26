package loadDashboardPages;

import com.codeborne.selenide.*;
import loadDashboardPages.fragments.FilterLoadPageFragment;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class LoadListPage {

    FilterLoadPageFragment filterLoadPageFragment = new FilterLoadPageFragment();
    SelenideElement newLoadBtn = $x("//button[@routerlink='/load-list/create-load']");
    ElementsCollection tableRows = $$x("//datatable-row-wrapper");
    SelenideElement tabDispatchingSettings = $x("//a[@ng-reflect-router-link='dispatch-settings']");

    public LoadListPage clickNewLoadBtn() {
        newLoadBtn.click();
        return this;
    }
    public FilterLoadPageFragment getFilterLoadPageFragment() {
        return filterLoadPageFragment;
    }

    public LoadListPage checkTableNotEmpty() {
        tableRows.shouldHaveSize(1);
        return this;
    }

    public LoadListPage clickTabDispatchingSettings() {
        tabDispatchingSettings.click();
        return this;
    }

}
