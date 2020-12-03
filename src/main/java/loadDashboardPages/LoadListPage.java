package loadDashboardPages;

import com.codeborne.selenide.*;
import loadDashboardPages.fragments.FilterLoadPageFragment;
import loadDashboardPages.fragments.TableFragment;

import static com.codeborne.selenide.Selenide.*;

public class LoadListPage {


    TableFragment tableFragment = new TableFragment();
    FilterLoadPageFragment filterLoadPageFragment = new FilterLoadPageFragment();
    SelenideElement newLoadBtn = $x("//button[@routerlink='/load-list/create-load']");
    ElementsCollection tableRows = $$x("//datatable-row-wrapper");
    SelenideElement tabDispatchingSettings = $x("//a[text() = 'Dispatch Settings']");
    public ElementsCollection tableSize = $$x("//datatable-row-wrapper");
    SelenideElement pickupLocationInTable = $x("//datatable-row-wrapper//datatable-body-cell[5]//span");
    SelenideElement deliveryLocationInTable = $x("//datatable-row-wrapper//datatable-body-cell[7]//span");
    SelenideElement deliveryDateInTable = $x("//datatable-row-wrapper//datatable-body-cell[6]//span");
    SelenideElement pickupDateInTable = $x("//datatable-row-wrapper//datatable-body-cell[4]//span");
    SelenideElement trailerTypeInTable = $x("//datatable-row-wrapper//datatable-body-cell[8]//span");
    SelenideElement weightInTable = $x("//datatable-row-wrapper//datatable-body-cell[9]//span");
    SelenideElement rateInTable = $x("//datatable-row-wrapper//datatable-body-cell[10]//span");
    SelenideElement fPInTable = $x("//datatable-row-wrapper//datatable-body-cell[11]//span");
SelenideElement reqFieldMessage = $x("//arial-label");


    public LoadListPage clickNewLoadBtn() {
        newLoadBtn.click();
        return this;
    }
    public FilterLoadPageFragment getFilterLoadPageFragment() {
        return filterLoadPageFragment;
    }

    public LoadListPage checkTableNotEmpty() {
        tableRows.shouldHaveSize(1);
        return this;
    }

    public LoadListPage clickTabDispatchingSettings() {
        tabDispatchingSettings.click();
        return this;
    }
    public TableFragment getTableFragment() {
        return tableFragment;
    }

    public SelenideElement getPickupLocationInTable(){
        return pickupLocationInTable;
}

    public String getPickupDateInTable() {
        return pickupDateInTable.getText().substring(0,11);
    }

//    public SelenideElement getPickupDateInTable() {
//        return pickupDateInTable;
//    }
//
//    public SelenideElement getDeliveryDateInTable() {
//        return deliveryDateInTable;
//    }

        public String getDeliveryDateInTable() {
        return deliveryDateInTable.getText().substring(0,11);
    }

    public SelenideElement getDeliveryPlaceInTable() {
    return deliveryLocationInTable;
    }

    public SelenideElement getTrailerTypeInTable() {
        return trailerTypeInTable;
    }


    public SelenideElement getRateInTable() {
    return rateInTable;
    }


    public SelenideElement getWeightInTable() {
    return weightInTable;
    }

    public SelenideElement getFPInTable() {
        return fPInTable;
    }


}



