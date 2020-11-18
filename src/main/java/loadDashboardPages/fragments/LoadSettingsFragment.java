package loadDashboardPages.fragments;

import com.codeborne.selenide.SelenideElement;


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

    public LoadSettingsFragment selectTrailerType(String trailerType) {   //нот воркинг =((( надо доработать
        trailerTypeDropdown.click();
//        trailerTypeDropdown
        return this;
    }

    public LoadSettingsFragment setWeight(String Weight) {
        weightInput.setValue(Weight);
        return this;
    }

    public LoadSettingsFragment selectTrailerLength(String length) {
        trailerLengthDropBox.selectOptionByValue(length);
        return this;
    }
}
