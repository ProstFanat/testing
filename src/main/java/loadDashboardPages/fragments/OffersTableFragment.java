package loadDashboardPages.fragments;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import resources.BasePage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class OffersTableFragment extends BasePage {

    public SelenideElement radiusPlaceHolder = $x("//input[@placeholder='Radius']"),
            searchDriversBtn = $x("//button[contains(text(), 'Search ')]"),
            SaveLoadAndSendOffersBtn = $x("//button[@class='btn btn-sm btn-success mt-2 pull-right']"),
            aclUserIcon = $x("//datatable-body-cell//*[contains(@class, 'fa-user')]"),
            withoutDrivingStatusCheckBox = $x("//input[@id='withoutDrivingStatus']"),
            clearFilterBtn = $x("//div[text() = 'Clear']"),
            messageRadiusMustBePositiveAndIntegerNumber = $x("//div[text() = ' Radius must be positive and integer number ']"),
            btnNextPage = $x("//a[@aria-label='go to next page']");
    public  ElementsCollection driversCollectionOnOffers = $$x("//*[@class = 'datatable-body']//datatable-row-wrapper//datatable-body-cell[4]"),
            driversCollection = $$x("//*[@class = 'datatable-body']//datatable-row-wrapper//datatable-body-cell[4]"),
            driversDHOCollection = $$x("//*[@class = 'datatable-body']//datatable-row-wrapper//datatable-body-cell[3]//span"),
            driversStatusCollection = $$x("//*[@class = 'datatable-body']//datatable-row-wrapper//datatable-body-cell[12]//span"),
            numbersOfTablePages = $$x("//datatable-pager//li[contains(@class, 'pages')]");


    List<String> drivers = new ArrayList<>();

    public OffersTableFragment searchDrivers(String value) {
        radiusPlaceHolder.setValue(value);
        searchDriversBtn.click();
        searchDriversBtn.hover();
        driversCollection.first().waitUntil(Condition.visible, 30000);
        return this;
    }

    public OffersTableFragment selectDrivers() {
        waitToVisibilityOf(driversCollection.first());
        for (int i = 0; i < driversCollection.size(); i++) {
            driversCollection.get(i).click();
            drivers.add(driversCollection.get(i).getText());
        }
        return this;
    }

    public OffersTableFragment selectDriverByName(String name) {
        waitToVisibilityOf(driversCollection.first());
        for (int i = 0; i < driversCollection.size(); i++) {
            if (driversCollection.get(i).getText().equals(name)) {
                driversCollection.get(i).click();
            }
        }
        return this;
    }

    public OffersTableFragment clickSaveLoadAndSendOffersBtn() {
        SaveLoadAndSendOffersBtn.click();
        return this;
    }

    public OffersTableFragment clickSearchButton() {
        searchDriversBtn.click();
        return this;
    }

    public OffersTableFragment clickClearButton() {
        clearFilterBtn.click();
        return this;
    }

    public OffersTableFragment checkDriversName() throws Exception {
        try {
            for (int i = 0; i < driversCollectionOnOffers.size(); i++)
                driversCollectionOnOffers.get(i).shouldHave(Condition.text(drivers.get(i)));
            return this;
        } catch (Exception e) {
            throw new Exception("Test Failed");
        }
    }

    public int getDriversListSize(){
        waitToVisibilityOf(driversCollection.first());
       return driversCollection.size();
    }

    public OffersTableFragment setCheckBoxWithoutDrivingStatus(boolean value){
        withoutDrivingStatusCheckBox.setSelected(value);
        return this;
    }

//    public void checkDriversStatus(boolean checkbox) {
//        boolean result = false;
//        if (checkbox) {
//            do {
//                for (int i = 0; i < driversCollection.size(); i++) {
//                    driversStatusCollection.get(i).shouldNotHave(Condition.text("Driving"));
//                }
//                btnNextPage.click();
//            } while (isBtnNextEnabled());
//        }
//    }

    public boolean checkDHOAddOffer(int ml){
        int initSize = driversCollection.size();
        int finalSize = 0;
        for (int i = 0; i < initSize; i++){
            double currentML = Double.parseDouble(driversDHOCollection.get(i).getText());
            if(currentML <= ml){
                finalSize++;
            }
        }
        return finalSize == initSize;
    }

    public boolean isBtnNextEnabled(){
        return !numbersOfTablePages.last().getAttribute("class").equals("pages active ng-star-inserted");
    }

    public void checkDriversStatus(boolean checkbox){
        boolean result = false;
        if(checkbox) {
            do {
                for (int i = 0; i < driversCollection.size(); i++) {
                    driversStatusCollection.get(i).shouldNotHave(Condition.text("Driving"));
                }
                btnNextPage.click();
            } while (isBtnNextEnabled());

            for (int i = 0; i < driversCollection.size(); i++) {
                driversStatusCollection.get(i).shouldNotHave(Condition.text("Driving"));
            }
            btnNextPage.click();

        } else {
            do {
                for (int i = 0; i < driversCollection.size(); i++) {
                    if(driversStatusCollection.get(i).getText().equals("Driving")){
                        result = true;
                        break;
                    }
                }
                if (result == true) {
                    break;
                }
                btnNextPage.click();
            } while (isBtnNextEnabled());

            for (int i = 0; i < driversCollection.size(); i++) {
                if(driversStatusCollection.get(i).getText().equals("Driving")){
                    result = true;
                    break;
                }
            }
            Assertions.assertTrue(result);
        }

    }

    public boolean isAclUserPresent() {
        return aclUserIcon.isDisplayed();
    }
}
