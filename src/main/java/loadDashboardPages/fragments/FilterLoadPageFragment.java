package loadDashboardPages.fragments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.*;

public class FilterLoadPageFragment extends BasePage {

    SelenideElement loadIdInput = $x("//input[@placeholder = 'Load ID']");
    SelenideElement statusInput = $x("//*[@placeholder = 'Status']//input");
    ElementsCollection statusElements = $$x("//*[@placeholder = 'Status']//*[@role = 'option']");
    SelenideElement pickUpLocationInput = $x("//input[@placeholder = 'PickUp Location']");
    ElementsCollection pickUpLocationElements = $$x("//*[@ng-reflect-placeholder = 'PickUp Location']//*[@class = 'ng-star-inserted']");
    SelenideElement deliveryLocationInput = $x("//input[@placeholder = 'Delivery Location']");
    ElementsCollection deliveryLocationElements = $$x("//*[@ng-reflect-placeholder = 'Delivery Location']//*[@class = 'ng-star-inserted']");
    SelenideElement trailerTypeInput = $x("//*[@placeholder = 'Trailer Type']//input");
    SelenideElement organizationInput = $x("//*[@placeholder = 'Organization']//input");
    SelenideElement driverInput = $x("//*[@placeholder = 'Driver']//input");
    SelenideElement btnFilter = $x("//button[text() = ' Filter ']");
    public ElementsCollection tableSize = $$x("//datatable-row-wrapper");

    public FilterLoadPageFragment inputLoadId(String id) {
        loadIdInput.sendKeys(id);
        return this;
    }

    public FilterLoadPageFragment inputStatus(String status) {
        statusInput.sendKeys(status);
        isVisible(statusElements.first());
        for (int i = 1; i < statusElements.size(); i++) {
            if (statusElements.get(i).getText().startsWith(status)) {
                statusElements.get(i).click();
            }
        }
        return this;
    }

    public FilterLoadPageFragment inputTrailerType(String trailerType) {
        trailerTypeInput.sendKeys(trailerType);
        trailerTypeInput.pressEnter();
        return this;
    }

    public FilterLoadPageFragment inputOrganization(String org) {
        organizationInput.sendKeys(org);
        organizationInput.pressEnter();
        return this;
    }

    public FilterLoadPageFragment inputDriver(String driver) {
        driverInput.sendKeys(driver);
        driverInput.pressEnter();
        return this;
    }

    public FilterLoadPageFragment inputPickUpLocation(String city) throws Exception {
        pickUpLocationInput.sendKeys(city);

        if (isVisible($x("//div[contains(@class, 'locations-popup')]//div//div"))) {
            for (int i = 1; i < pickUpLocationElements.size(); i++) {
                if (pickUpLocationElements.get(i).getText().startsWith(city)) {
                    pickUpLocationElements.get(i).click();
                }
            }
        } else {
            throw new Exception("Hello");
        }
        return this;
    }

    public FilterLoadPageFragment inputDeliveryLocation(String city) throws Exception {
        deliveryLocationInput.sendKeys(city);

        if (isVisible($x("//div[contains(@class, 'locations-popup')]//div//div"))) {
            for (int i = 1; i < deliveryLocationElements.size(); i++) {
                if (deliveryLocationElements.get(i).getText().startsWith(city)) {
                    deliveryLocationElements.get(i).click();
                }
            }
        } else {
            throw new Exception("Hello");
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
            Assert.assertTrue(false);
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

        Assert.assertEquals(startSize, finishSize);

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
                Assert.assertFalse(true);
            }
        }

        Assert.assertEquals(startSize, finishSize);
    }
}
