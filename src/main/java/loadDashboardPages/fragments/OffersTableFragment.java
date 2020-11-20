package loadDashboardPages.fragments;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class OffersTableFragment {

    SelenideElement radiusPlaceHolder = $x("//input[@placeholder='Radius']");
    SelenideElement searchDriversBtn = $x("//button[contains(text(), 'Search ')]");
    ElementsCollection driversCollection = $$x("//*[@class = 'datatable-body']//datatable-row-wrapper//datatable-body-cell[3]");
    SelenideElement SaveLoadAndSendOffersBtn = $x("//button[@class='btn btn-sm btn-success mt-2 pull-right']");
    ElementsCollection driversCollectionOnOffers = $$x("//*[@class = 'datatable-body']//datatable-row-wrapper//datatable-body-cell[4]");

    public OffersTableFragment searchDrivers() {
        radiusPlaceHolder.setValue("7");
        searchDriversBtn.click();
        return this;
    }


    public OffersTableFragment selectDrivers(){
        for (int i = 0; i <= driversCollection.size(); i++) {
            driversCollection.get(i).click();
        }
        return this;
    }


    public OffersTableFragment clickSaveLoadAndSendOffersBtn() {
        SaveLoadAndSendOffersBtn.click();
        return this;
    }


    public OffersTableFragment checkDriversName() {
        for (int i = 0; i <= driversCollectionOnOffers.size(); i++)
            driversCollectionOnOffers.get(i).shouldHave(Condition.text(driversCollection.get(i).getText()));
        return this;
    }



    public ElementsCollection checkDrivers() {
        return driversCollectionOnOffers;
    }
}
