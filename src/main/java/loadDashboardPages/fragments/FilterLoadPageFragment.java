package loadDashboardPages.fragments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import resources.BasePage;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class FilterLoadPageFragment extends BasePage {

    public  SelenideElement loadIdInput = $x("//input[@placeholder = 'Load ID']"),
            statusInput = $x("//*[@placeholder = 'Status']//input"),
            pickUpLocationInput = $x("//input[@placeholder = 'PickUp Location']"),
            deliveryLocationInput = $x("//input[@placeholder = 'Delivery Location']"),
            trailerTypeInput = $x("//*[@placeholder = 'Trailer Type']//input"),
            organizationInput = $x("//*[@placeholder = 'Organization']//input"),
            driverInput = $x("//*[@placeholder = 'Driver']//input"),
            btnFilter = $x("//button[text() = ' Filter ']");

    public  ElementsCollection deliveryLocationElements = $$x("//*[@ng-reflect-placeholder = 'Delivery Location']//*[@class = 'ng-star-inserted']"),
            pickUpLocationElements = $$x("//*[@ng-reflect-placeholder = 'PickUp Location']//*[@class = 'ng-star-inserted']"),
            statusElements = $$x("//*[@placeholder = 'Status']//*[@role = 'option']"),
            tableSize = $$x("//datatable-row-wrapper");

    public FilterLoadPageFragment inputLoadId(String id) {
        loadIdInput.setValue(id);
        return this;
    }

    public FilterLoadPageFragment inputStatus(String status) {
        statusInput.click();
        waitToVisibilityOf(statusElements.first());
        for (int i = 0; i < statusElements.size(); i++) {
            if (statusElements.get(i).getText().startsWith(status)) {
                statusElements.get(i).click();
            }
        }
        return this;//button[text()= 'Reject']
    }

    public FilterLoadPageFragment inputTrailerType(String trailerType) {
        trailerTypeInput.setValue(trailerType);
        trailerTypeInput.pressEnter();
        return this;
    }

    public FilterLoadPageFragment inputOrganization(String org) {
        organizationInput.setValue(org);
        organizationInput.pressEnter();
        return this;
    }

    public FilterLoadPageFragment inputDriver(String driver) {
        driverInput.setValue(driver);
        driverInput.pressEnter();
        return this;
    }

    public FilterLoadPageFragment inputPickUpLocation(String city) throws Exception {
        pickUpLocationInput.setValue(city);

        if (isVisible($x("//div[contains(@class, 'locations-popup')]//div//div"))) {
            for (int i = 1; i < pickUpLocationElements.size(); i++) {
                if (pickUpLocationElements.get(i).getText().startsWith(city)) {
                    pickUpLocationElements.get(i).click();
                }
            }
        } else {
            throw new Exception("failed");
        }
        return this;
    }

    public FilterLoadPageFragment inputDeliveryLocation(String city) throws Exception {
        deliveryLocationInput.setValue(city);

        if (isVisible($x("//div[contains(@class, 'locations-popup')]//div//div"))) {
            for (int i = 1; i < deliveryLocationElements.size(); i++) {
                if (deliveryLocationElements.get(i).getText().startsWith(city)) {
                    deliveryLocationElements.get(i).click();
                }
            }
        } else {
            throw new Exception("failed");
        }
        return this;
    }

    public FilterLoadPageFragment clickBtnFilter() {
        btnFilter.click();
        return this;
    }

    public int getTableSize() {
        return tableSize.size();
    }

    public FilterLoadPageFragment checkTable(String filterBy, String value) {
        int j = 0;

        if (filterBy.equals("loadId")) {
            j = 1;
        } else if (filterBy.equals("status")) {
            j = 3;
        } else if (filterBy.equals("pickUpLocation")) {
            j = 5;
        } else if (filterBy.equals("deliveryLocation")) {
            j = 7;
        } else if (filterBy.equals("trailerType")) {
            j = 8;
        } else if (filterBy.equals("organization")) {
            j = 12;
        } else if (filterBy.equals("driver")) {
            j = 13;
        } else {
            System.out.println("INPUT CORRECT FILTER BY");

            Assertions.assertTrue(false);
        }

        sleep(500);
        int startSize = getTableSize();
        int finishSize = 0;
        for (int i = 1; i <= startSize; i++) {
            if (j == 5 || j == 7) {
                if ($x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[" + j + "]//span").getText().contains(value)) {
                    finishSize++;
                }
            } else {
                if ($x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[" + j + "]//span").getText().equals(value)) {
                    finishSize++;
                }
            }
        }

        Assertions.assertEquals(startSize, finishSize);

        return this;
    }

    public void checkAll(String loadId, String status, String pickUpLocation, String deliveryLocation, String trailerType, String organization, String driver) {
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
            ) {
                finishSize++;
            } else {
                Assertions.assertFalse(true);
            }
        }

        Assertions.assertEquals(startSize, finishSize);
    }
}
