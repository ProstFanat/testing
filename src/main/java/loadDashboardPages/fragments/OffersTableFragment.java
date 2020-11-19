package loadDashboardPages.fragments;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class OffersTableFragment {

SelenideElement radiusPlaceHolder = $x("//input[@placeholder='Radius']");
    SelenideElement searchDriversBtn = $x("//button[contains(text(), 'Search ')]");
    ElementsCollection driversCollection = $$x("//*[@class = 'datatable-body']//datatable-row-wrapper//datatable-body-cell[3]");
    SelenideElement SaveLoadAndSendOffersBtn = $x("//button[@class='btn btn-sm btn-success mt-2 pull-right']");
ElementsCollection driversCollectionOnOffers =$$x("//*[@class = 'datatable-body']//datatable-row-wrapper//datatable-body-cell[4]");


    public OffersTableFragment searchAndSelectDrivers() {
        radiusPlaceHolder.setValue("5");
        searchDriversBtn.click();
        driversCollection.get(0).click();
        driversCollection.get(1).click();
        driversCollection.get(2).click();
        return this;
    }

//    public OffersTableFragment selectDriversFromDrvList() {
//
//
//   return this;
//    }

    public OffersTableFragment clickSaveLoadAndSendOffersBtn() {
        SaveLoadAndSendOffersBtn.click();
        return this;
    }

public String[] rememberDrivers(){
    String[] drivers = new String[3];
        for (int i = 0; i<=2; i++){
        drivers[i] = driversCollection.get(i).getText();
        driversCollection.get(i).click();
    }
        return drivers;
}

    public String[] getOffers() {
        String[] drivers = new String[3];
        for (int i = 0; i<=2; i++){
            drivers[i] = driversCollectionOnOffers.get(i).getText();
        }
        System.out.println(drivers);
        return drivers;
    }

    public void checkDrivers() {
        driversCollectionOnOffers.shouldHave(CollectionCondition.texts(rememberDrivers()));
    }
}

