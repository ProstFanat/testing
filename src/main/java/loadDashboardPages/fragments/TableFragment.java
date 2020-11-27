package loadDashboardPages.fragments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class TableFragment {

    SelenideElement actionBtn = $x("//button[@id='button-actions']");
    ElementsCollection id = $$x("//datatable-row-wrapper//datatable-body-cell[1]//span");
    SelenideElement pickupDate = $x("//datatable-row-wrapper//datatable-body-cell[4]//span");
    SelenideElement pickupPlace = $x("//datatable-row-wrapper//datatable-body-cell[5]//span");
    SelenideElement deliveryDate = $x("//datatable-row-wrapper//datatable-body-cell[6]//span");
    SelenideElement deliveryPlace = $x("//datatable-row-wrapper//datatable-body-cell[7]//span");
    SelenideElement trailerType = $x("//datatable-row-wrapper//datatable-body-cell[8]//span");
    SelenideElement weight = $x("//datatable-row-wrapper//datatable-body-cell[9]//span");
    SelenideElement rate = $x("//datatable-row-wrapper//datatable-body-cell[10]//span");
    SelenideElement fullPart = $x("//datatable-row-wrapper//datatable-body-cell[11]//span");
    SelenideElement editBtn = $x("//i[@class='fa fa-pencil mr-2']");
    public Map<String, String> saveLoadData() {

        Map<String, String> rawData = new HashMap<>();

        rawData.put("PICKUP DATE", pickupDate.getText());
        rawData.put("PICKUP PLACE", pickupPlace.getText());
        rawData.put("DELIVERY DATE", deliveryDate.getText());
        rawData.put("DELIVERY PLACE", deliveryPlace.getText());
        rawData.put("TRAILER TYPE", trailerType.getText());
        rawData.put("WEIGHT", weight.getText());
        rawData.put("RATE", rate.getText());
        rawData.put("F/P", fullPart.getText());
        System.out.println(rawData);
        return rawData;
    }


    public String getFirstLoadId() {
        return id.get(1).getText();
    }

    public TableFragment loadActionBtnClick(int rowNumber) {
        $x("//datatable-row-wrapper[" + rowNumber + "]//button[@id='button-actions']").click();
        return this;
    }

    public TableFragment loadActionBtnClick() {
        actionBtn.click();
        return this;
    }

    public TableFragment loadActionEditBtnClick() {
        editBtn.click();
        return this;
    }
}
