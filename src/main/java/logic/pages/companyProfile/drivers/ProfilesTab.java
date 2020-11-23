package logic.pages.companyProfile.drivers;

import logic.BasePage;
import logic.pages.companyProfile.drivers.driverInfo.AddDriverProfilePage;
import logic.pages.companyProfile.drivers.driverInfo.EditDriverProfilePage;
import logic.pages.companyProfile.drivers.driverProfile.HosTab;
import logic.report.LogToAllure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ProfilesTab extends DriversPage {
    public ProfilesTab() {
        super();
    }

    @FindBy(css = "a[is-permitted-for='create.DRIVER-PROFILE']")
    private WebElement addNewDriverBtn;
    @FindBy(name = "driverFirstName")
    private WebElement firstNameFilterField;
    @FindBy(name = "driverLastName")
    private WebElement lastNameFilterField;
    @FindBy (css = "span[class='slider round']")
    private WebElement changeDriverStatusCheckBox;
    @FindBy (xpath = "//button[contains(text(),'Ok')]")
    private WebElement deactivateBtnOk;
    @FindBy (xpath = "//button[contains(text(),'Cancel')]")
    private WebElement deactivateBtnCancel;
    @FindBy (css = "div[placeholder='Select Status...']")
    private WebElement statusFilter;
    @FindBy (css = "input[title='Selected page']")
    private WebElement selectPageField;
    @FindBy (css = "button[ng-click='pageNextPageClick()']")
    private WebElement nextPage;
    @FindBy (css = "input[ng-model='grid.options.paginationCurrentPage']")
    private WebElement currentPageNumberField;



    @Override
    public boolean isAllRequiredElementsPresent() {
        return false;
    }

    public AddDriverProfilePage addNewDriver() {
        waitToBeClickable(10, addNewDriverBtn);
        addNewDriverBtn.click();
        return new AddDriverProfilePage();
    }

    public ProfilesTab findDriver(String firstName, String status) {
        waitToVisibilityOf(10, firstNameFilterField);
        selectItemInSelector(statusFilter,status,"Status Filter","div");
        findItemByFilterInGrid(firstNameFilterField,firstName,"First Name");
        return this;
    }

    public boolean driverIsExists(String firstName){
        try {
            waitToVisibilityOf(10, firstNameFilterField);
            firstNameFilterField.sendKeys(firstName);
            return isElementPresent(driver.findElement(By.xpath("//a[contains(text(),'" + firstName + "')]")));
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public ProfilesTab changeDriverStatus(String firstName){
        findItemByFilterInGrid(firstNameFilterField,firstName,"First Name");
        changeDriverStatusCheckBox.click();
        return this;
    }

    public ProfilesTab deactivateDriverWindow(boolean deactivateDriverFlag){
        try{
            waitToVisibilityOf(20, deactivateBtnOk);
        } catch (TimeoutException | NoSuchElementException e){
            log.error("changeDriverStatus" + e);
            assertTrue(false, e.toString());
        }
        waitToBeClickable(20,deactivateBtnOk);
        if (deactivateDriverFlag)
            deactivateBtnOk.click();
        else
            deactivateBtnCancel.click();
        return this;
    }

    public EditDriverProfilePage clickOnDriverFirstName(String firstName) {
        try {
            WebElement firstNameElement = driver.findElement(By.xpath("//a[contains(text(),'" + firstName + "')]"));
            waitToBeClickable(10, firstNameElement);
            firstNameElement.click();
            log.info("Click on driver first name: " + firstName);
            LogToAllure.logToAllure("Click on driver first name", firstName);
            waitToVisibilityOf(20, driver.findElement(By.className("modal-content")));
        } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
            log.error(e);
            clickOnDriverFirstName(firstName);
        } catch (TimeoutException | NoSuchElementException e){
            log.error(e);
            assertTrue(false, e.toString());
        }
        return new EditDriverProfilePage();
    }
    public HosTab openDriverHosPage(String firstName){
        findItemByFilterInGrid(firstNameFilterField,firstName,"First Name");
        List<WebElement> hosBtns = driver.findElements(By.cssSelector("a[uib-tooltip='View HOS page']"));
        hosBtns.get(0).click();
        return new HosTab();
    }
    public HosTab openDriverHosPage(String firstName, String lastname){
        waitToVisibilityOf(10,lastNameFilterField);
        lastNameFilterField.clear();
        lastNameFilterField.sendKeys(lastname);
        findItemByFilterInGrid(firstNameFilterField,firstName,"First Name");
        List<WebElement> hosBtns = driver.findElements(By.cssSelector("a[uib-tooltip='View HOS page']"));
        hosBtns.get(0).click();
        return new HosTab();
    }

    public ArrayList<String[]> parseDriversFirstName(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<String[]> driversFirstName = new ArrayList<>();
        List<WebElement> firstNames;
        List<WebElement> lastNames;
        waitToVisibilityOf(20, driver.findElement(By.cssSelector("div[is-permitted-for='update.DRIVER-PROFILE']")));
        int numOfPages = Integer.parseInt(selectPageField.getAttribute("max"));
        try {
            log.error("Found " + numOfPages + " pages!");
            for (int i = 1; i <= numOfPages; i++) {
                firstNames = driver.findElements(By.cssSelector("div[is-permitted-for='update.DRIVER-PROFILE']"));
                lastNames = driver.findElements(By.cssSelector("div[class='ui-grid-cell ng-scope ui-grid-disable-selection ui-grid-coluiGrid-0008']"));
                for (WebElement firstName :
                        firstNames) {
                    driversFirstName.add(new String[]{firstName.getText(), lastNames.get(firstNames.indexOf(firstName)).getText()});
                }
                if (nextPage.getAttribute("disabled") == null) {
                    clickOnElement(nextPage);
                    firstNames.clear();
                    lastNames.clear();
                    waitTextToBePresentInElement(10, String.valueOf(i + 1), currentPageNumberField);
                }
            }
        }catch (IndexOutOfBoundsException e){
            return parseDriversFirstName();
        }
        LogToAllure.logToAllure("The names of the company drivers were parsed", String.valueOf(driversFirstName.size()));
        log.info("The names of "+driversFirstName.size()+" the company drivers were parsed");
        return driversFirstName;
    }
}
