package loadDashboardPages.fragments;

import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class TableFragment {


    SelenideElement id = $x("");
    SelenideElement pickupDate = $x("");
    SelenideElement pickupPlace = $x("");
    SelenideElement deliveryDate = $x("");
    SelenideElement deliveryPlace = $x("");
    SelenideElement trailerType = $x("");
    SelenideElement weight = $x("");
    SelenideElement rate = $x("");
    SelenideElement fullPart = $x("");



    public Map<String, String> saveLoadData() {

        Map<String, String> rawData = new HashMap<>();

        rawData.put("ID", id.getText());
        rawData.put("PICKUP DATE", pickupDate.getText());
        rawData.put("PICKUP PLACE", pickupPlace.getText());
        rawData.put("DELIVERY DATE", deliveryDate.getText());
        rawData.put("DELIVERY PLACE", deliveryPlace.getText());
        rawData.put("TRAILER TYPE", trailerType.getText());
        rawData.put("WEIGHT", weight.getText());
        rawData.put("RATE", rate.getText());
        rawData.put("F/P", fullPart.getText());
        return  rawData;
    }




}
