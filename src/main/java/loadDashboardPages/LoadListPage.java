package loadDashboardPages;

import com.codeborne.selenide.*;
import loadDashboardPages.fragments.FilterLoadPageFragment;
import loadDashboardPages.fragments.TableFragment;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.*;

public class LoadListPage {


    TableFragment tableFragment = new TableFragment();
    FilterLoadPageFragment filterLoadPageFragment = new FilterLoadPageFragment();
    SelenideElement newLoadBtn = $x("//button[@routerlink='/load-list/create-load']");
    ElementsCollection tableRows = $$x("//datatable-row-wrapper");
    SelenideElement tabDispatchingSettings = $x("//a[text() = 'Dispatch Settings']");
    public ElementsCollection tableSize = $$x("//datatable-row-wrapper");


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

    public int getTableSize() {
        return tableSize.size();
    }

    public void checkAll(String loadId, String status, String pickUpLocation, String deliveryLocation, String trailerType, String organization, String driver, String fullPart, String weight, String rate) {
        sleep(500);
        int startSize = getTableSize();
        int finishSize = 0;

        for (int i = 1; i <= startSize; i++) {
            if ($x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[1]//span").getText().equals(loadId)
                    && $x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[3]//span").getText().equals(status)
                    && $x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[5]//span").getText().contains(pickUpLocation)
                    && $x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[7]//span").getText().contains(deliveryLocation)
                    && $x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[8]//span").getText().equals(trailerType)
                    && $x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[12]//span").getText().equals(organization)
                    && $x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[13]//span").getText().equals(driver)
                    && $x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[13]//span").getText().equals(fullPart)
                    && $x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[13]//span").getText().equals(rate)
                    && $x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[13]//span").getText().equals(weight)
            ) {
                finishSize++;
            } else {
                Assert.assertFalse(true);
            }
        }
        Assert.assertEquals(startSize, finishSize);
    }

    public LoadListPage compareRawData() {
        tableFragment.saveLoadData().get("id") ;//  ("hjk");

return  this;
    }
public  LoadListPage checkPickUpdate(){
        return this;
}


}



