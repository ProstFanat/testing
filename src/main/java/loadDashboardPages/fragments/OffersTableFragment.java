package loadDashboardPages.fragments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class OffersTableFragment {

SelenideElement radiusPlaceHolder = $x("//input[@placeholder='Radius']");
    SelenideElement searchDriversBtn = $x("//button[contains(text(), 'Search ')]");
    ElementsCollection driversCollection = $$x("");


    public void searchDriver() {
        radiusPlaceHolder.setValue("10");
        searchDriversBtn.click();
        driversCollection.get(0).click();
        driversCollection.get(1).click();
        driversCollection.get(2).click();

    }
}
