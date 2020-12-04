package loadDashboardPages.fragments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class LoadSettingsFragment {

    public  SelenideElement pickupDatePickerField = $x("//input[@id='pickupDate']"),
            chooseMonthAndYearBtn = $x("//button[@aria-label='Choose month and year']"),
            deliveryDatePickerField = $x("//input[@id='deliveryDate']"),
            setDatePickerBtn = $x("//span[text() = 'Set']"),
            pickupLocationInput = $x("//input[@placeholder = 'PickUp Location']"),
            deliveryLocationInput = $x("//input[@placeholder = 'Delivery Location']"),
            pickupZipCodeInput = $x("//input[@id = 'zipCodePick']"),
            deliveryZipCodeInput = $x("//input[@id = 'zipCodeDrop']"),
            trailerTypeDropdown = $x("//*[@placeholder = 'Trailer Type']"),
            weightInput = $x("//input[@id='weight']"),
            trailerLengthDropBox = $x("//select[@id = 'trailerLength']"),
            fullPart = $x("//select[@id = 'fp']"),
            saveBtnLoad = $x("//button[contains (text(), ' Save Load ')]"),
            rateInput = $x("//input[@id='rate']"),
            itemTypeInput = $x("//input[@id='itemType']"),
            dimensionsInput = $x("//input[@id='dimensions']"),
            commentInput = $x("//textarea[@id='comments']"),
            btnFilter = $x("//button[text() = ' Filter ']");

    public  ElementsCollection pickUpLocationElements = $$x("//input[@placeholder = 'PickUp Location']//..//*[@class = 'ng-star-inserted']"),
            deliveryLocationElements = $$x("//input[@placeholder = 'Delivery Location']//..//*[@class = 'ng-star-inserted']"),
            trailerTypesCollection = $$x("//span[@class='ng-option-label ng-star-inserted']");



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

    public LoadSettingsFragment setPickupLocation(String partLocationName) {
        pickupLocationInput.clear();
        pickupLocationInput.sendKeys(partLocationName);
        pickUpLocationElements.first().click();
        return this;
    }

    public LoadSettingsFragment setDeliveryLocation(String partLocationName) {
        deliveryLocationInput.clear();
        deliveryLocationInput.sendKeys(partLocationName);
        deliveryLocationElements.first().click();
        return this;

    }

    public LoadSettingsFragment setPickupZipCode(String zipCode) {
        pickupZipCodeInput.clear();
        pickupZipCodeInput.setValue(zipCode);
        return this;
    }

    public LoadSettingsFragment setDeliveryZipCode(String zipCode) {
        deliveryZipCodeInput.clear();
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
        weightInput.clear();
        weightInput.setValue(Weight);
        return this;
    }

    public LoadSettingsFragment selectTrailerLength(String length) {
        trailerLengthDropBox.selectOptionByValue(length);
        return this;
    }

    public LoadSettingsFragment setRate(String rate) {
        rateInput.clear();
        rateInput.setValue(rate);
        return this;
    }

    public LoadSettingsFragment inputItemType(String itemType) {
        itemTypeInput.clear();
        itemTypeInput.setValue(itemType);
        return this;
    }

    public LoadSettingsFragment selectFP(String FullOrPart) {
        fullPart.click();
        fullPart.sendKeys(FullOrPart);
        fullPart.pressEnter();
        return this;
    }

    public LoadSettingsFragment inputDimension(String testDimension) {
        dimensionsInput.clear();
        dimensionsInput.setValue(testDimension);
        return this;
    }

    public LoadSettingsFragment inputComment(String testComment) {
        commentInput.clear();
        commentInput.setValue(testComment);
        return this;
    }

    public LoadSettingsFragment clickSaveBtn() {
        saveBtnLoad.click();
        return this;
    }
}
