package loadDashboardPages.fragments;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.Keys;
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
            btnFilter = $x("//button[text() = ' Filter ']"),
            contacts = $("[id='contacts']"),
            tabAddOffer = $x("//div[text() = 'Add Offer ']"),
            tabOffers = $x("//div[text() = 'Offers ']"),
            btnEditTrailerForOffer = $x("//bs-dropdown-container//div[text() = ' Edit Trailer ']"),
            btnDeleteOffer = $x("//bs-dropdown-container//div[text() = ' Delete ']"),
            btnConfirmOffer = $x("//bs-dropdown-container//div[text() = ' Confirm ']"),
            btnRejectOffer = $x("//bs-dropdown-container//div[text() = ' Reject ']");


    public  ElementsCollection pickUpLocationElements = $$x("//input[@placeholder = 'PickUp Location']//..//*[@class = 'ng-star-inserted']"),
            deliveryLocationElements = $$x("//input[@placeholder = 'Delivery Location']//..//*[@class = 'ng-star-inserted']"),
            trailerTypesCollection = $$x("//span[@class='ng-option-label ng-star-inserted']"),
            buttonsActionsOffers = $$x("//button[text() = ' Actions ']");




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

    public LoadSettingsFragment clearContactField(){     //clear() не работает
        contacts.click();
        contacts.sendKeys(Keys.CONTROL,"a");
        contacts.sendKeys(Keys.BACK_SPACE);
        return this;
    }

    public SelenideElement getContactInfo(){
        return contacts;
    }

    public LoadSettingsFragment waitClickbleSaveBtn(){
        saveBtnLoad.shouldBe(enabled);
        return this;
    }

    public LoadSettingsFragment goToAddOfferTab(){
        tabAddOffer.click();
        return this;
    }

    public LoadSettingsFragment goToOffersTab(){
        tabOffers.click();
        return this;
    }

    public LoadSettingsFragment deleteOffer(int number){
        System.out.println("Delete...");
        buttonsActionsOffers.get(number - 1).click();
        btnDeleteOffer.click();
        return this;
    }

    public LoadSettingsFragment confirmOffer(int number){
        System.out.println("Confirm...");
        buttonsActionsOffers.get(number - 1).click();
        btnConfirmOffer.click();
        buttonsActionsOffers.first().waitUntil(Condition.enabled, 30000);
        return this;
    }
    public LoadSettingsFragment rejectOffer(int number){
        System.out.println("Reject...");
        buttonsActionsOffers.get(number - 1).click();
        btnRejectOffer.click();
        return this;
    }
}
