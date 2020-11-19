package loadDashboardPages.fragments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class OffersTableFragment {

SelenideElement radiusPlaceHolder = $x("//input[@placeholder='Radius']");
    SelenideElement searchDriversBtn = $x("//button[contains(text(), 'Search ')]");
    ElementsCollection drivers = $$x("");


    public void searchDriver() {
        radiusPlaceHolder.setValue("10");
        searchDriversBtn.click();

    }
}
