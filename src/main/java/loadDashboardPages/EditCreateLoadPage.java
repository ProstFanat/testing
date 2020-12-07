package loadDashboardPages;

import com.codeborne.selenide.SelenideElement;
import loadDashboardPages.fragments.LoadSettingsFragment;
import loadDashboardPages.fragments.OffersTableFragment;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.url;

public class EditCreateLoadPage {

    LoadSettingsFragment loadSettingsFragment = new LoadSettingsFragment();
    OffersTableFragment offersTableFragment = new OffersTableFragment();

   public SelenideElement contacts = $("[id='contacts']");

   public LoadSettingsFragment getLoadSettingsFragment() {
        return loadSettingsFragment;
    }
    public OffersTableFragment getOffersTableFragment() {
        return offersTableFragment;
    }

    public EditCreateLoadPage setDefaultLoadSettings(){
        getLoadSettingsFragment().setPickupDate(22,"Nov", 2020)
                .setDeliveryDate(26,"Nov",2020)
                .setPickupLocation("Toront")
                .setDeliveryLocation("New Glaru")
                .setPickupZipCode("123NY")
                .setDeliveryZipCode("321CA")
                .selectTrailerType("Dry-Van")
                .setWeight("500")
                .selectTrailerLength("53")
                .setRate("200")
                .inputItemType("test")
                .selectFP("F")
                .inputDimension("testDimension")
                .inputComment("testComment");
    return this;
    }

    public EditCreateLoadPage checkLoadIdInUrl() {
        url().contains("edit-load;loadId=");
        return  this;
    }

    public String getID() {
        return url().substring(url().indexOf("=") + 1);
    }

    char quoMark = '"';
    public SelenideElement getReqAlertsMessage(String message){
        return $x("//*[@aria-label= " + quoMark + message + quoMark + "]");
    }

    public SelenideElement getContactInfo(){
        return contacts;
    }

}
