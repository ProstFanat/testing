package logic.assetsTest;

import io.qameta.allure.Step;
import logic.AddAndEditDriverProfileTests;
import logic.exceptions.TrackEnsureException;
import logic.pages.admin.AdminPage;
import logic.pages.companyProfile.assets.AddAndEditTruckModal;
import logic.pages.companyProfile.assets.TrucksTab;
import logic.report.LogToAllure;
import logic.variables.Accounts;
import logic.dbConnection.entity.TruckProfile;
import logic.variables.UrlVariables;
import logic.widgets.Header;
import logic.widgets.NavigationBar;
import logic.widgets.TagsWidget;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;


import java.util.ArrayList;
import java.util.List;

import static logic.BasePage.GET_RANDOM_NUMS;
import static logic.webdriver.DriverFactory.getDriver;
import static org.testng.Assert.*;

public class AddAndEditTruckProfileTests {

    private static final Logger log = Logger.getLogger(AddAndEditDriverProfileTests.class);
    public Header header;

    @BeforeClass
    @Step("Initialization of the browser driver. Open a browser window. Go to the main page.")
    public void install() {
        getDriver().get(UrlVariables.getBaseURL());
        LogToAllure.logToAllure("Go to URL ", UrlVariables.getBaseURL());
        log.info("Go to " + UrlVariables.getBaseURL());
        header = new Header();
        header
                .clickOnLogin()
                .setValuesIntoLoginForm(Accounts.getLoginValues())
                .clickBtnSubmitLogin();
        AdminPage adminPage = new AdminPage();
        adminPage
                .closeConfirmStartShiftWindow()
                .goToCustomersPage()
                .findAndLoginAsCompany(Accounts.getCompanyForLogin());
        new NavigationBar()
                .goToAssetsPage()
                .goToTrucksPage();
    }

    @AfterClass
    public void logout() {
        new TagsWidget().deleteAllTags();
        header.logout();
    }

    @AfterMethod()
    public void afterMethod() {
        getDriver().navigate().refresh();
    }

    @DataProvider(name = "new-truck")
    public Object[][] method() {
        return new Object[][]{
                {new TruckProfile(true, GET_RANDOM_NUMS(), GET_RANDOM_NUMS(), "Alabama",
                        "1XKYDP9X4LJ414239", "MakeTest", "Tesla", "1995", "TareTest",
                        true, "trackensure-elog-gps", "", "700",
                        "25", "10", "PT30_", "0001", "", "Gasoline",
                        "ACTIVE", true, "70", true, "15",
                        "", "", "", "")},
                {new TruckProfile(false, GET_RANDOM_NUMS(), GET_RANDOM_NUMS(), "Alaska",
                        "1XKYDP9X4LJ414239", "MakeTest", "Tesla", "1998", "TareTest",
                        false, "trackensure-elog-gps", "", "700",
                        "25", "10", "PT30_", "2020", "", "Special-diesel",
                        "INACTIVE", false, "55", true, "15",
                        "", "", "", "")},
                {new TruckProfile(true, GET_RANDOM_NUMS(), GET_RANDOM_NUMS(), "Iowa",
                        "1XKYDP9X4LJ414239", "MakeTest", "Tesla", "2002", "TareTest",
                        true, "trackensure-elog-gps", "", "700",
                        "25", "10", "PT30_", "0301", "", "Propane",
                        "OUT OF SERVICE", true, "70", false, "25",
                        "", "", "", "")},
                {new TruckProfile(true, GET_RANDOM_NUMS(), GET_RANDOM_NUMS(), "Kansas",
                        "1XKYDP9X4LJ414239", "MakeTest", "Tesla", "2000", "TareTest",
                        false, "trackensure-elog-gps", "", "700",
                        "25", "10", "PT30_", "0001", "", "LNG",
                        "ACTIVE", false, "60", false, "20",
                        "", "", "", "")},
                {new TruckProfile(true, GET_RANDOM_NUMS(), GET_RANDOM_NUMS(), "Guam",
                        "1XKYDP9X4LJ414239", "", "", "", "",
                        false, "None", "", "200",
                        "", "", "PT30_", "", "", "A55",
                        "INACTIVE", false, "70", false, "20",
                        "", "", "", "")},
                {new TruckProfile(false, GET_RANDOM_NUMS(), GET_RANDOM_NUMS(), "Florida",
                        "1XKYDP9X4LJ414239", "MakeTest", "Tesla", "1995", "TareTest",
                        true, "trackensure-elog-gps", "", "700",
                        "25", "10", "PT30_", "0001", "", "Gasoline",
                        "OUT OF SERVICE", true, "70", true, "15",
                        "", "", "", "")},
                {new TruckProfile(false, GET_RANDOM_NUMS(), GET_RANDOM_NUMS(), "Guam",
                        "1XKYDP9X4LJ414239", "", "", "", "",
                        false, "None", "", "200",
                        "", "", "PT30_", "", "", "A55",
                        "ACTIVE", false, "70", false, "15",
                        "", "", "", "")},
        };
    }

    @Test(dataProvider = "new-truck")
    public void te_001_truck_profile_new_truck(TruckProfile truckProfile) {
        AddAndEditTruckModal addAndEditTruckModal = new AddAndEditTruckModal(truckProfile);

        new TrucksTab()
                .clickOnAddNewTruckBtn();

        addAndEditTruckModal
                .inputValuesInForms()
                .clickOnSaveTruck()
                .findTruck(truckProfile.getTruckNumber(), truckProfile.getStatus())
                .clickOnTruckNumber(truckProfile.getTruckNumber());
        addAndEditTruckModal
                .parseTruckProfile()
                .checkTruckProfileValues();

        truckProfile.setTruckNumber(GET_RANDOM_NUMS());
        truckProfile.setFifthWheel(!truckProfile.isFifthWheel());
        truckProfile.setPersonalUseLimitStatus(!truckProfile.isPersonalUseLimitStatus());
        truckProfile.setEldSerialNum("1111");
        truckProfile.setFuelType("Propane");
        truckProfile.setPersonalUseLimitValue("500");
        truckProfile.setYardMoveLimitValue("8");
        truckProfile.setMaxSpeedForStart("8");
        truckProfile.setMinStopDuration("200");
        truckProfile.setMinStopDeltaDistanceMeters("400");
        truckProfile.setLicensePlate(GET_RANDOM_NUMS());
        truckProfile.setVinNumber("1X321P9X4LJ412345");
        truckProfile.setMake("TestEdit");
        truckProfile.setModel("Audi");
        truckProfile.setTare("EditTest");
        truckProfile.setYear("1996");
        truckProfile.changeStatus();
        addAndEditTruckModal.setTruckProfile(truckProfile);

        addAndEditTruckModal
                .inputValuesInForms()
                .clickOnSaveTruck()
                .findTruck(truckProfile.getTruckNumber(), truckProfile.getStatus())
                .clickOnTruckNumber(truckProfile.getTruckNumber());
        addAndEditTruckModal
                .parseTruckProfile()
                .checkTruckProfileValues()
                .clickOnSaveTruck();
        if (truckProfile.getStatus().equals("ACTIVE")) {
            new TrucksTab()
                    .findTruck(truckProfile.getTruckNumber(), truckProfile.getStatus())
                    .clickOnTruckNumber(truckProfile.getTruckNumber())
                    .selectStatus("INACTIVE")
                    .clickOnSaveTruck();
        }

    }


    @DataProvider(name = "tags-attach")
    public Object[][] tagsProvider() {
        return new Object[][]{
                {"public"}, {"private"}, {"personal"}
        };
    }

    @Test(dataProvider = "tags-attach")
    public void te_002_truck_tags_attach(String tagType) {
        TagsWidget tagsWidget = new TagsWidget();
        String tagName = "TAG#" + GET_RANDOM_NUMS();
        try {
            tagsWidget.createTag(tagName, tagType);
            WebElement truckTable = getDriver().findElement(By.id("truck-list-table"));
            List<WebElement> rows = tagsWidget.findAllRowsInTable(truckTable);
            while (rows.size() <= 4) {
                AddAndEditTruckModal addAndEditTruckModal = new AddAndEditTruckModal(new TruckProfile(true, GET_RANDOM_NUMS(), GET_RANDOM_NUMS(), "Alabama",
                        "1XKYDP9X4LJ414239", "MakeTest", "Tesla", "1995", "TareTest",
                        true, "trackensure-elog-gps", "", "700",
                        "25", "10", "PT30_", "0001", "", "Gasoline",
                        "ACTIVE", true, "70", true, "15",
                        "", "", "", ""));
                new TrucksTab()
                        .clickOnAddNewTruckBtn();
                addAndEditTruckModal
                        .inputValuesInForms()
                        .clickOnSaveTruck();
                rows = tagsWidget.findAllRowsInTable(truckTable);
            }
            for (int i = 0; i < rows.size() / 2; i++) {
                WebElement x = rows.get(i);
                tagsWidget.attachTag(x, tagName);
            }
            tagsWidget.findTag(tagName);
            List<WebElement> rowsWithTag = tagsWidget.findAllRowsInTable(truckTable);
            log.info("CHECK: Tag added to " + rows.size() / 2 + " trucks, actual = " + rowsWithTag.size());
            assertEquals(rows.size() / 2, rowsWithTag.size(), "Selected rows");
        } catch (TrackEnsureException e) {
            fail(e.toString());
        }
    }

    @DataProvider(name = "tags-create-edit")
    public Object[][] tagsCreateEditProvider() {
        return new Object[][]{
                {"private", "personal"},
                {"personal", "private"},
                {"private", "public"},
                {"personal", "public"},
                {"public", "personal"},
                {"public", "private"},
        };
    }

    @Test(dataProvider = "tags-create-edit")
    public void te_003_truck_tags_create_edit(String createTag, String changeTagTo) {
        TagsWidget tagsWidget = new TagsWidget();
        String tagName = "TAG#" + GET_RANDOM_NUMS();
        try {
            tagsWidget.createTag(tagName, createTag);
            tagsWidget.editTag(tagName, changeTagTo);
        } catch (TrackEnsureException e) {
            fail(e.toString());
        }
    }
    @Test(dataProvider = "tags-attach")
    public void te_004_truck_tags_truck_profile(String tagType){
        TagsWidget tagsWidget = new TagsWidget();
        String tagName = "TAG#" + GET_RANDOM_NUMS();
        try {
            tagsWidget.createTag(tagName, tagType);
            WebElement truckTable = getDriver().findElement(By.id("truck-list-table"));
            List<WebElement> rows = tagsWidget.findAllRowsInTable(truckTable);
            while (rows.size() < 1) {
                AddAndEditTruckModal addAndEditTruckModal = new AddAndEditTruckModal(new TruckProfile(true, GET_RANDOM_NUMS(), GET_RANDOM_NUMS(), "Alabama",
                        "1XKYDP9X4LJ414239", "MakeTest", "Tesla", "1995", "TareTest",
                        true, "trackensure-elog-gps", "", "700",
                        "25", "10", "PT30_", "0001", "", "Gasoline",
                        "ACTIVE", true, "70", true, "15",
                        "", "", "", ""));
                new TrucksTab()
                        .clickOnAddNewTruckBtn();
                addAndEditTruckModal
                        .inputValuesInForms()
                        .clickOnSaveTruck();
                rows = tagsWidget.findAllRowsInTable(truckTable);
            }
            WebElement openProfile =  rows.get(0).findElement(By.cssSelector("a[uib-tooltip='View in New Window']"));
            openProfile.click();
            ArrayList<String> newTab = new ArrayList<>(getDriver().getWindowHandles());
            getDriver().switchTo().window(newTab.get(1));
           tagsWidget.attachTag(getDriver().findElement(By.className("tp-details-tab")),tagName);
        } catch (TrackEnsureException e) {
            fail(e.toString());
        } finally {
            ArrayList<String> newTab = new ArrayList<>(getDriver().getWindowHandles());
            if (newTab.size()>1) {
                getDriver().switchTo().window(newTab.get(1));
                getDriver().close();
                getDriver().switchTo().window(newTab.get(0));
            }
        }
    }
}
