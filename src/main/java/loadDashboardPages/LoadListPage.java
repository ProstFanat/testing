package loadDashboardPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoadListPage {

    SelenideElement newLoadBtn = $x("//button[@routerlink='/load-list/create-load']");


    public LoadListPage clickNewLoadBtn() {
        newLoadBtn.click();
        return this;
    }
}
