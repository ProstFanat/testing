package loadDashboardPages.fragments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class TableFragment {

    public  SelenideElement actionBtn = $x("//button[@id='button-actions']"),
            pickupDate = $x("//datatable-row-wrapper//datatable-body-cell[4]//span"),
            pickupPlace = $x("//datatable-row-wrapper//datatable-body-cell[5]//span"),
            deliveryDate = $x("//datatable-row-wrapper//datatable-body-cell[6]//span"),
            deliveryPlace = $x("//datatable-row-wrapper//datatable-body-cell[7]//span"),
            trailerType = $x("//datatable-row-wrapper//datatable-body-cell[8]//span"),
            weight = $x("//datatable-row-wrapper//datatable-body-cell[9]//span"),
            rate = $x("//datatable-row-wrapper//datatable-body-cell[10]//span"),
            fullPart = $x("//datatable-row-wrapper//datatable-body-cell[11]//span"),
            editBtn = $x("//i[@class='fa fa-pencil mr-2']"),
            deleteLoadBtn = $x("//div[contains(text(), ' Delete')]"),
            confirmYesButton = $x("//button[contains(text(), 'Yes')]");

    public  ElementsCollection id = $$x("//datatable-row-wrapper//datatable-body-cell[1]//span"),
                        actionsFromActionBtn = $$x("//div[@class = 'dropdown show open']//div");

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
        return id.get(0).getText();
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

    public TableFragment deleteLoad() {
        actionBtn.click();
        deleteLoadBtn.click();
        confirmYesButton.click();

        return this;
    }

    public ElementsCollection actionsFromActionBtnSize() {
        return actionsFromActionBtn;
    }

    public List<String> getActionsFromActionBtn() {
List <String> actionsList = new ArrayList<>();
        for (int i = 0; i < actionsFromActionBtn.size(); i++) {
            actionsList.add(actionsFromActionBtn.get(i).getText());
        }
    return actionsList;
    }

}
