package loadDashboardPages;

import loadDashboardPages.fragments.LoadSettingsFragment;
import loadDashboardPages.fragments.OffersTableFragment;

public class CreateLoadPage {

    LoadSettingsFragment loadSettingsFragment = new LoadSettingsFragment();
    OffersTableFragment offersTableFragment = new OffersTableFragment();

    public LoadSettingsFragment getLoadSettingsFragment() {
        return loadSettingsFragment;
    }
    public OffersTableFragment getOffersTableFragment() {
        return offersTableFragment;
    }

    public CreateLoadPage setDefaultLoadSettings(){
        getLoadSettingsFragment().setPickupDate(22,"Nov", 2020)
                .setDeliveryDate(26,"Nov",2020)
                .setPickupLocation("Toronto, ON, Canada")
                .setDeliveryLocation("New Glarus, WI, United States")
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
}
