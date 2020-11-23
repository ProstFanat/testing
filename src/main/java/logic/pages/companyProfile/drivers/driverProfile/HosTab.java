package logic.pages.companyProfile.drivers.driverProfile;

import logic.BasePage;
import logic.variables.UrlVariables;
import logic.variables.events.EventTimestamp;
import logic.webdriver.DriverLogs;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static logic.variables.Accounts.EMAIL_ADDRESS;
import static org.testng.Assert.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class HosTab extends BasePage {
    @FindBy (css = "a[is-permitted-for='read.ELD-VIEWER']")
    private WebElement hosReportTab;
    @FindBy (css = "a[ng-click='vm.tabOption = 2']")
    private WebElement generateHosPdfReportTab;
    @FindBy (css = "a[is-permitted-for='read.FMCSA-VIEWER']")
    private WebElement csvReportTab;
    @FindBy (css = "button[ng-click='vm.goToHosReport()']")
    private WebElement goToViewerBtn;
    @FindBy(css = "input[placeholder='Select Start Date...']")
    private WebElement dateFromReportField;
    @FindBy(css = "input[placeholder='Select End Date...']")
    private WebElement dateToReportField;
    @FindBy (css = "button[ng-click='vm.generatePDFReport()']")
    private WebElement generateHosReportBtn;
    //@FindBy(css = "div[placeholder='Select Rules...']")
    @FindBy(xpath = "//*[@id=\"app-main-area\"]/div/div/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div[3]/div/div[1]/span")
    //@FindBy(css = "span[ng-click='$select.activate()']")
    private WebElement hosReportRulesSelect;
    @FindBy (xpath = "//*[@id=\"app-main-area\"]/div/div/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div[1]/div/div[1]/span")
    private WebElement csvReportTransferMethodSelect;
    @FindBy (css = "input[ng-model='vm.fmcsaEmail']")
    private WebElement csvEmailField;
    @FindBy (css = "input[ng-model='vm.fmcsaComment']")
    private WebElement csvCommentField;
    @FindBy (css = "button[ng-click='vm.sendFMCSAReport()']")
    private WebElement sendCsvReportBtn;
    @FindBy (css = "a[ng-click=\"vm.changeTab('details')\"]")
    private WebElement goToDetailsTab;
    @FindBy (className = "alert-error")
    private WebElement errorNotification;
    @FindBy (css = "div[ng-if='!vm.selectedCycle && vm.errorMessage']")
    private WebElement thereAreNoEventsError;
    public static String currentDriverId;

    public static String getCurrentDriverId() {
        return currentDriverId;
    }

    public static void setCurrentDriverId() {
        HosTab.currentDriverId = UrlVariables.parseInfoFromUrl("driver");
    }

    public HosTab() {
        super();
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        return false;
    }

    private static final Logger log = Logger.getLogger(HosTab.class);

    public ViewerPage goToViewer(){
        clickOnElement(hosReportTab);
        clickOnElement(goToViewerBtn);
        return new ViewerPage();
    }
    public DetailsPage goToDetails(){
        clickOnElement(goToDetailsTab);
        return new DetailsPage();
    }
    public HosTab generateHosReport(int minusDayFromCoef, int minusDayToCoef, String rules){
        clickOnElement(generateHosPdfReportTab);
        selectDateInDatePicker(dateFromReportField,minusDayFromCoef);
        selectDateInDatePicker(dateToReportField,minusDayToCoef);
        selectItemInSelector(hosReportRulesSelect,rules,"Rules","div");
        clickOnElement(generateHosReportBtn);
        return this;
    }
    public void selectDateInDatePicker(WebElement dateField, int dateChangeCoef){
        clickOnElement(dateField);
        SimpleDateFormat newFormat = new SimpleDateFormat("dd-MMMM yyyy ", Locale.ENGLISH);
        List <String> splitDate = Arrays.asList(newFormat.format(EventTimestamp.getDate(dateChangeCoef*24).getTime()).split("-"));
        WebElement datepickerWindow = driver.findElement(By.cssSelector("ul[ng-click='$event.stopPropagation()']"));
        waitToVisibilityOf(20, datepickerWindow);

            while (!datepickerWindow.findElement(By.cssSelector("strong[class='ng-binding']")).getText().equals(splitDate.get(1).trim())){
                datepickerWindow.findElement(By.cssSelector("button[ng-click='move(-1)']")).click();
                log.info("Current month in datepicker is - " + datepickerWindow.findElement(By.cssSelector("strong[class='ng-binding']")).getText() + ". Click on -1 Month");
            }
        List<WebElement> days = driver.findElements(By.xpath("//span[contains(text(),'" + splitDate.get(0) + "')]"));
        for (WebElement day:
                days) {
            if(!day.getAttribute("class").contains("text-muted")) {
                day.click();
                break;
            }
        }
        log.info("Select date in date picker: " + splitDate.toString());
    }

    public void generateCsvReportToPersonalMail(int minusDayFromCoef, int minusDayToCoef){
        waitToVisibilityOf(20, hosReportTab);
        if(!isElementPresent(csvReportTab))
            fail("This driver does not have access to the FMCSA report!");
        else if (isElementPresent(thereAreNoEventsError))
            fail("There are no events for this driver!");

        waitToVisibilityOf(10, csvReportTab);
        csvReportTab.click();
        selectDateInDatePicker(dateFromReportField, minusDayFromCoef);
        selectDateInDatePicker(dateToReportField,minusDayToCoef);
        selectItemInSelector(csvReportTransferMethodSelect,"Email (Personal)","Transfer Method","div");
        if(csvEmailField.getAttribute("disabled")==null) {
            csvEmailField.clear();
            csvEmailField.sendKeys(EMAIL_ADDRESS);
        }
        else
            fail("In 'Email Personal' mode this email field must be active!");
        if(!csvReportTransferMethodSelect.getText().equals("Email (Personal)"))
            fail("ERROR! Selected not 'Email Personal' mode.");
        clickOnElement(sendCsvReportBtn);
        waitToBeClickable(20, sendCsvReportBtn);
        if(isElementPresent(errorNotification))
            fail("Transaction for driver is open!");
    }

    

}
