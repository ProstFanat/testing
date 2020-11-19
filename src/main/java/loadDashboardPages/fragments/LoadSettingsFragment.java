package loadDashboardPages.fragments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class LoadSettingsFragment {

    SelenideElement pickupDatePickerField = $x("//input[@id='pickupDate']");
    SelenideElement chooseMonthAndYearBtn = $x("//button[@aria-label='Choose month and year']");
    SelenideElement deliveryDatePickerField = $x("//input[@id='deliveryDate']");
    SelenideElement setDatePickerBtn = $x("//span[text() = 'Set']");
    SelenideElement pickupLocationInput = $x("//input[@placeholder = 'PickUp Location']");
    SelenideElement deliveryLocationInput = $x("//input[@placeholder = 'Delivery Location']");
    SelenideElement pickupZipCodeInput = $x("//input[@id = 'zipCodePick']");
    SelenideElement deliveryZipCodeInput = $x("//input[@id = 'zipCodeDrop']");
    SelenideElement trailerTypeDropdown = $x("//*[@placeholder = 'Trailer Type']");
    SelenideElement weightInput = $x("//input[@id='weight']");
    SelenideElement trailerLengthDropBox = $x("//select[@id = 'trailerLength']");
    ElementsCollection trailerTypesCollection = $$x("//span[@class='ng-option-label ng-star-inserted']");
    SelenideElement rateInput = $x("//input[@id='rate']");
    SelenideElement itemTypeInput = $x("//input[@id='itemType']");
    SelenideElement dimensionsInput = $x("//input[@id='dimensions']");
    SelenideElement commentInput = $x("//textarea[@id='comments']");

    public LoadSettingsFragment setPickupDate(int day, String month, int year) {
        pickupDatePickerField.click();
        chooseMonthAndYearBtn.click();
        $x("//td[@aria-label='" + year + "']").click();
        $x("//span[text()= '" + month + "']").click();
        $x("//span[text()= '" + day + "']").click();
        setDatePickerBtn.click();
        return this;
    }

    public LoadSettingsFragment setDeliveryDate(int day, String month, int year) {
        deliveryDatePickerField.click();
        chooseMonthAndYearBtn.click();
        $x("//td[@aria-label='" + year + "']").click();
        $x("//span[text()= '" + month + "']").click();
        $x("//span[text()= '" + day + "']").click();
        setDatePickerBtn.click();
        return this;
    }

    public LoadSettingsFragment setPickupLocation(String fullLocationName) {
        pickupLocationInput.click();
        pickupLocationInput.val(fullLocationName).pressEnter();
        return this;
    }

    public LoadSettingsFragment setDeliveryLocation(String fullLocationName) {
        deliveryLocationInput.click();
        deliveryLocationInput.val(fullLocationName).pressEnter();
        return this;
    }

    public LoadSettingsFragment setPickupZipCode(String zipCode) {
        pickupZipCodeInput.setValue(zipCode);
        return this;
    }

    public LoadSettingsFragment setDeliveryZipCode(String zipCode) {
        deliveryZipCodeInput.setValue(zipCode);
        return this;
    }

    public LoadSettingsFragment selectTrailerType(String trailerType) {
        trailerTypeDropdown.click();
        trailerTypesCollection.findBy(exactText(trailerType)).click();
        return this;
    }

    public LoadSettingsFragment setWeight(String Weight) {
        weightInput.click();
        weightInput.setValue(Weight);
        return this;
    }

    public LoadSettingsFragment selectTrailerLength(String length) {
        trailerLengthDropBox.selectOptionByValue(length);
        return this;
    }

    public LoadSettingsFragment setRate(String rate) {
        rateInput.setValue(rate);
        return this;
    }

    public LoadSettingsFragment inputItemType(String itemType) {
        itemTypeInput.setValue(itemType);
        return this;
    }

    public LoadSettingsFragment selectFP(String FullOrPart) {
        itemTypeInput.setValue(FullOrPart).pressEnter();
        return this;
    }

    public LoadSettingsFragment inputDimension(String testDimension) {
        dimensionsInput.setValue(testDimension);
        return this;
    }

    public LoadSettingsFragment inputComment(String testComment) {
        commentInput.setValue(testComment);
        return this;
    }
}
