package loadDashboardPages.fragments;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.*;

public class FilterLoadPageFragment {

    SelenideElement loadIdInput = $x("//input[@placeholder = 'Load ID']");
    SelenideElement statusInput = $x("//*[@placeholder = 'Status']//input");
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
        statusInput.pressEnter();
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

    public FilterLoadPageFragment inputPickUpLocation(String city) {
        pickUpLocationInput.sendKeys(city);
        pickUpLocationElements.first().click();
        return this;
    }

    public FilterLoadPageFragment inputDeliveryLocation(String city) {
        deliveryLocationInput.sendKeys(city);
        deliveryLocationElements.first().click();
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
            if ($x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[1]//span").getText().equals(loadId)) {
                if ($x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[3]//span").getText().equals(status)) {
                    if ($x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[5]//span").getText().contains(pickUpLocation)) {
                        if ($x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[7]//span").getText().contains(deliveryLocation)) {
                            if ($x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[8]//span").getText().equals(trailerType)) {
                                if ($x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[12]//span").getText().equals(organization)) {
                                    if ($x("//datatable-row-wrapper[" + i + "]//datatable-body-cell[13]//span").getText().equals(driver)) {
                                        finishSize++;
                                    } else {
                                        Assert.assertFalse(true);
                                    }
                                } else {
                                    Assert.assertFalse(true);
                                }
                            } else {
                                Assert.assertFalse(true);
                            }
                        } else {
                            Assert.assertFalse(true);
                        }
                    } else {
                        Assert.assertFalse(true);
                    }
                } else {
                    Assert.assertFalse(true);
                }
            } else {
                Assert.assertFalse(true);
            }
        }

        Assert.assertEquals(startSize, finishSize);
    }
}
