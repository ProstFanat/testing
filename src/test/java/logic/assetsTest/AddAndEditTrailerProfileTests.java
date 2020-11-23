package logic.assetsTest;

import io.qameta.allure.Step;
import logic.dbConnection.entity.TruckProfile;
import logic.exceptions.TrackEnsureException;
import logic.pages.admin.AdminPage;
import logic.pages.companyProfile.assets.*;
import logic.report.LogToAllure;
import logic.variables.Accounts;
import logic.dbConnection.entity.TrailerProfile;
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
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class AddAndEditTrailerProfileTests {
    private static final Logger log = Logger.getLogger(AddAndEditTrailerProfileTests.class);
    private final String VIN_NUMBER = "1XKYDP9X4LJ414239";
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
                .goToTrailersPage();
    }
    @AfterMethod()
    public void afterMethod() {
        getDriver().navigate().refresh();
        new AssetsPage()
                .goToTrailersPage();
    }
    @AfterClass
    public void logout(){
        header.logout();
    }
    @DataProvider(name = "new-trailer")
    public Object[][] method() {
        return new Object[][]{
                {new TrailerProfile(GET_RANDOM_NUMS()+"Trailer",GET_RANDOM_NUMS(),"Alabama",VIN_NUMBER,"TestMake",
                        "1998","dry-van","2.9","None","","ACTIVE")},
                {new TrailerProfile(GET_RANDOM_NUMS()+"Trailer",GET_RANDOM_NUMS(),"Alaska",VIN_NUMBER,"TestMake",
                        "1999","reefer","3.2","None","","ACTIVE")},
                {new TrailerProfile(GET_RANDOM_NUMS()+"Trailer",GET_RANDOM_NUMS(),"Alaska",VIN_NUMBER,"TestMake",
                        "1950","heater","3","None","","ACTIVE")},
                {new TrailerProfile(GET_RANDOM_NUMS()+"Trailer",GET_RANDOM_NUMS(),"Alaska",VIN_NUMBER,"TestMake",
                        "1977","flatbed","2.5","None","","ACTIVE")},
                {new TrailerProfile(GET_RANDOM_NUMS()+"Trailer",GET_RANDOM_NUMS(),"Alaska",VIN_NUMBER,"TestMake",
                        "2010","three-axle","1.69","None","","ACTIVE")},
                {new TrailerProfile(GET_RANDOM_NUMS()+"Trailer",GET_RANDOM_NUMS(),"Alaska",VIN_NUMBER,"TestMake",
                        "2004","stepdeck","2.01","None","","ACTIVE")},
                {new TrailerProfile(GET_RANDOM_NUMS()+"Trailer",GET_RANDOM_NUMS(),"Alaska",VIN_NUMBER,"TestMake",
                        "2014","conestoga","2.32","None","","ACTIVE")},
                {new TrailerProfile(GET_RANDOM_NUMS()+"Trailer",GET_RANDOM_NUMS(),"Alaska",VIN_NUMBER,"TestMake",
                        "2018","car hauler","1.2","None","","ACTIVE")},
                {new TrailerProfile(GET_RANDOM_NUMS()+"Trailer",GET_RANDOM_NUMS(),"Alabama",VIN_NUMBER,"TestMake",
                        "2010","dry-van","3","trackensure-eld","","INACTIVE")},
                {new TrailerProfile(GET_RANDOM_NUMS()+"Trailer",GET_RANDOM_NUMS(),"Alaska",VIN_NUMBER,"TestMake",
                        "2009","reefer","2","trackensure-eld","","INACTIVE")},
                {new TrailerProfile(GET_RANDOM_NUMS()+"Trailer",GET_RANDOM_NUMS(),"Alaska",VIN_NUMBER,"TestMake",
                        "2008","heater","1.5","trackensure-eld","","INACTIVE")},
                {new TrailerProfile(GET_RANDOM_NUMS()+"Trailer",GET_RANDOM_NUMS(),"Alaska",VIN_NUMBER,"TestMake",
                        "2000","flatbed","4","trackensure-eld","","INACTIVE")},
                {new TrailerProfile(GET_RANDOM_NUMS()+"Trailer",GET_RANDOM_NUMS(),"Alaska",VIN_NUMBER,"TestMake",
                        "2006","three-axle","1","trackensure-eld","","OUT OF SERVICE")},
                {new TrailerProfile(GET_RANDOM_NUMS()+"Trailer",GET_RANDOM_NUMS(),"Alaska",VIN_NUMBER,"TestMake",
                        "1980","stepdeck","3","trackensure-eld","","OUT OF SERVICE")},
                {new TrailerProfile(GET_RANDOM_NUMS()+"Trailer",GET_RANDOM_NUMS(),"Alaska",VIN_NUMBER,"TestMake",
                        "1985","conestoga","2","trackensure-eld","","OUT OF SERVICE")},
                {new TrailerProfile(GET_RANDOM_NUMS()+"Trailer",GET_RANDOM_NUMS(),"Alaska",VIN_NUMBER,"TestMake",
                        "1989","car hauler","2.5","trackensure-eld","","OUT OF SERVICE")}
        };
    }
    /*
    @Test (dataProvider = "new-trailer")
    public void te_001_trailer_profile_new_trailer(TrailerProfile trailerProfile){
        AddAndEditTrailerModal addAndEditTrailerPage = new AddAndEditTrailerModal(trailerProfile);
        new TrailersTab()
                .clickOnAddNewTrailerBtn();
        addAndEditTrailerPage
                .inputValuesInForms()
                .clickOnSaveTrailer()
                .findTrailer(trailerProfile.getTrailerNumber(),trailerProfile.getStatus())
                .openEditTrailerProfile();
        addAndEditTrailerPage
                .parseTrailerProfile()
                .checkTrailerProfile();

        trailerProfile.setTrailerNumber(GET_RANDOM_NUMS() + "EditTrailer");
        trailerProfile.setLicensePlate(GET_RANDOM_NUMS());
        trailerProfile.setLicenseState("Iowa");
        trailerProfile.setVinNumber(VIN_NUMBER+"GT2");
        if(trailerProfile.getTrailerType().equals("dry-van"))
            trailerProfile.setTrailerType("heater");
        else
            trailerProfile.setTrailerType("dry-van");
        if (trailerProfile.getGpsProvider().equals("None"))
            trailerProfile.setGpsProvider("trackensure-eld");
        else
            trailerProfile.setGpsProvider("None");
        trailerProfile.changeStatus();
        trailerProfile.setYear("1991");
        addAndEditTrailerPage
                .setTrailerProfile(trailerProfile);

        addAndEditTrailerPage
                .inputValuesInForms()
                .clickOnSaveTrailer()
                .findTrailer(trailerProfile.getTrailerNumber(),trailerProfile.getStatus())
                .openEditTrailerProfile();
        addAndEditTrailerPage
                .parseTrailerProfile()
                .checkTrailerProfile();

        if(trailerProfile.getStatus().equals("ACTIVE")){
            new TrailersTab()
                    .findTrailer(trailerProfile.getTrailerNumber(),trailerProfile.getStatus())
                    .openEditTrailerProfile()
                    .selectStatus("INACTIVE")
                    .clickOnSaveTrailer();
        }
    }*/


    @DataProvider(name = "tags-attach")
    public Object[][] tagsProvider() {
        return new Object[][]{
                {"public"}, {"private"}, {"personal"}
        };
    }

    @Test(dataProvider = "tags-attach")
    public void te_002_trailer_tags_attach(String tagType) {
        TagsWidget tagsWidget = new TagsWidget();
        String tagName = "TAG#" + GET_RANDOM_NUMS();
        try {
            tagsWidget.createTag(tagName, tagType);
            WebElement trailerTable = getDriver().findElement(By.id("trailer-list-table"));
            List<WebElement> rows = tagsWidget.findAllRowsInTable(trailerTable);
            while (rows.size() <= 4) {
                AddAndEditTrailerModal addAndEditTrailerModal = new AddAndEditTrailerModal(new TrailerProfile(GET_RANDOM_NUMS()+"Trailer"
                        ,GET_RANDOM_NUMS(),"Alabama",VIN_NUMBER,"TestMake"
                        ,"1998","dry-van","2.9"
                        ,"None","","ACTIVE"));
                new TrailersTab()
                        .clickOnAddNewTrailerBtn();
                addAndEditTrailerModal
                        .inputValuesInForms()
                        .clickOnSaveTrailer();
                rows = tagsWidget.findAllRowsInTable(trailerTable);
            }
            for (int i = 0; i < rows.size() / 2; i++) {
                WebElement x = rows.get(i);
                tagsWidget.attachTag(x, tagName);
            }
            tagsWidget.findTag(tagName);
            List<WebElement> rowsWithTag = tagsWidget.findAllRowsInTable(trailerTable);
            log.info("CHECK: Tag added to " + rows.size() / 2 + " trailers, actual = " + rowsWithTag.size());
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
    public void te_003_trailer_tags_create_edit(String createTag, String changeTagTo) {
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
    public void te_004_trailer_tags_truck_profile(String tagType){
        TagsWidget tagsWidget = new TagsWidget();
        String tagName = "TAG#" + GET_RANDOM_NUMS();
        try {
            WebElement trailerTable = getDriver().findElement(By.id("trailer-list-table"));
            List<WebElement> rows = tagsWidget.findAllRowsInTable(trailerTable);
            while (rows.size() <= 4) {
                AddAndEditTrailerModal addAndEditTrailerModal = new AddAndEditTrailerModal(new TrailerProfile(GET_RANDOM_NUMS()+"Trailer"
                        ,GET_RANDOM_NUMS(),"Alabama",VIN_NUMBER,"TestMake"
                        ,"1998","dry-van","2.9"
                        ,"None","","ACTIVE"));
                new TrailersTab()
                        .clickOnAddNewTrailerBtn();
                addAndEditTrailerModal
                        .inputValuesInForms()
                        .clickOnSaveTrailer();
                rows = tagsWidget.findAllRowsInTable(trailerTable);
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
