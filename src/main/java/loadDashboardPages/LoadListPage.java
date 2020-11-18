package loadDashboardPages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class LoadListPage {

    SelenideElement newLoadBtn = $x("//button[@routerlink='/load-list/create-load']");
    SelenideElement loadIdInput = $x("//input[@placeholder = 'Load ID']");
    SelenideElement statusInput = $x("//*[@placeholder = 'Status']//input");
    SelenideElement pickUpLocationInput = $x("//input[@placeholder = 'PickUp Location']");
    ElementsCollection pickUpLocationElements = $$x("");
    SelenideElement deliveryLocationInput = $x("//input[@placeholder = 'Delivery Location']");
    ElementsCollection deliveryLocationElements = $$x("");
    SelenideElement trailerTypeInput = $x("//*[@placeholder = 'Trailer Type']//input");
    SelenideElement organizationInput = $x("//*[@placeholder = 'Organization']//input");
    SelenideElement driverInput = $x("//*[@placeholder = 'Driver']//input");
    SelenideElement btnFilter = $x("//button[text() = ' Filter ']");
    public ElementsCollection tableSize = $$x("//datatable-row-wrapper");

    public LoadListPage clickNewLoadBtn() {
        newLoadBtn.click();
        return this;
    }

    public LoadListPage inputLoadId(String id){
        loadIdInput.sendKeys(id);
        return this;
    }

    public LoadListPage inputStatus(String status){
        statusInput.sendKeys(status);
        statusInput.pressEnter();
        return this;
    }

    public LoadListPage inputTrailerType(String trailerType){
        trailerTypeInput.sendKeys(trailerType);
        trailerTypeInput.pressEnter();
        return this;
    }

    public LoadListPage inputOrganization(String org){
        organizationInput.sendKeys(org);
        organizationInput.pressEnter();
        return this;
    }

    public LoadListPage inputDriver(String driver){
        driverInput.sendKeys(driver);
        driverInput.pressEnter();
        return this;
    }

    public LoadListPage inputPickUpLocation(String city){
        pickUpLocationInput.sendKeys(city);
        pickUpLocationElements.first().click();
        return this;
    }

    public LoadListPage inputDeliveryLocation(String city){
        deliveryLocationInput.sendKeys(city);
        deliveryLocationElements.first().click();
        return this;
    }

    public LoadListPage clickBtnFilter(){
        btnFilter.click();
        return this;
    }

    public int getTableSize(){
        return tableSize.size();
    }

    public LoadListPage checkTable(String filterBy, String value){
        int j = 0;
        switch (filterBy){
            case "loadId":
                j = 1;
            case "status":
                j = 3;
            case "pickUpLocation":
                j = 5;
            case "deliveryLocation":
                j = 6;
            case "trailerType":
                j = 7;
            case "organization":
                j = 11;
            case "driver":
                j = 12;
        }

        int startSize = getTableSize();
        int finishSize = 0;
        for(int i =0 ; i <= startSize;i++){
            if($x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[" + j +"]").getText().equals(value)) {
                finishSize++;
            } else {
                continue;
            }
        }

        $$x("//datatable-row-wrapper").shouldBe(CollectionCondition.size(finishSize));

        return this;
    }
}
