package loadDashboardPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DispatchingSettingsPage extends BasePage {
    public  SelenideElement orgNameInput = $x("//input[@placeholder='Organization Name']"),
            btnFilter = $x("//button[text() = ' Filter ']"),
            driverNameInput = $x("//input[@placeholder='Driver Name']");
    public  ElementsCollection organizationsList = $$x("//*[@placeholder = 'Organization Name']//..//..//..//..//datatable-row-wrapper"),
            checkBoxesForOrgList = $$x("//*[@placeholder = 'Organization Name']//..//..//..//..//datatable-row-wrapper//datatable-body-cell[1]//input"),
            btnShowDriversList = $$x("//*[@placeholder = 'Organization Name']//..//..//..//..//datatable-row-wrapper//datatable-body-cell[3]//button"),
            driversList = $$x("//*[@placeholder = 'Driver Name']//..//..//..//datatable-row-wrapper"),
            checkBoxesForDriversList = $$x("//*[@placeholder = 'Driver Name']//..//..//..//datatable-row-wrapper//datatable-body-cell[1]//input");


    public DispatchingSettingsPage inputOrgName(String org) {
        waitToVisibilityOf(orgNameInput);
        orgNameInput.setValue(org);
        btnFilter.click();
        waitToVisibilityOf(checkBoxesForOrgList.first());

        return this;
    }

    public DispatchingSettingsPage inputDriver(String driver) {
        driverNameInput.setValue(driver);

        return this;
    }

    public DispatchingSettingsPage showDrivers(int number) {
        //.get(number).click();
        $x("//*[@placeholder = 'Organization Name']//..//..//..//..//datatable-row-wrapper[" + number + "]//datatable-body-cell[3]//button").click();

        return this;
    }

    public DispatchingSettingsPage showDriversForOrg(String org) {
        if (organizationsList.size() == 1) {
            checkBoxesForOrgList.first().setSelected(true);
            showDrivers(1);
        } else if (organizationsList.size() > 1) {
            for (int i = 1; i < organizationsList.size(); i++) {
                if (org.equals($x("//*[@placeholder = 'Organization Name']//..//..//..//..//datatable-row-wrapper[" + i + "]//datatable-body-cell[2]//span").getText())) {
                    checkBoxesForOrgList.get(i).setSelected(true);
                    showDrivers(i);
                }
            }
        } else {
            System.out.println("Table Empty");
        }
        return this;
    }

    public DispatchingSettingsPage setAllOrgCheckBoxes(boolean value) {
        for (int i = 1; i <= organizationsList.size(); i++) {
            $x("//*[@placeholder = 'Organization Name']//..//..//..//..//datatable-row-wrapper[" + i + "]//datatable-body-cell[1]//input").setSelected(value);
        }
        return this;
    }

    public DispatchingSettingsPage setAllDriverCheckBoxes(boolean value) {
        for (int i = 1; i <= driversList.size(); i++) {
            $x("//*[@placeholder = 'Driver Name']//..//..//..//datatable-row-wrapper[ " + i + "]//datatable-body-cell[1]//input").setSelected(value);
        }
        return this;
    }

}
