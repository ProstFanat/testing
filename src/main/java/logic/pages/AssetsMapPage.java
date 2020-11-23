package logic.pages;

import logic.BasePage;
import logic.report.PdfReport;
import logic.variables.Accounts;
import logic.widgets.NavigationBar;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Level;

import static logic.webdriver.DriverFactory.getDriver;

public class AssetsMapPage extends BasePage {
    private static final Logger log = Logger.getLogger(AssetsMapPage.class);

    @FindBy(tagName = "h2")
    private WebElement pageHeader;
    @FindBy(css = "button[ng-click='vm.openEditWallNameModal()']")
    private WebElement unnamedWallBtn;
    @FindBy(css = "form[name='wallNameForm']")
    private WebElement wallNameForm;
    @FindBy(id = "distance-calculator-block")
    private WebElement distanceCalculatorBlock;
    @FindBy(className = "angular-google-map")
    private WebElement googleMapBlock;
    @FindBy(className = "submenu")
    private WebElement submenuBlock;

    public AssetsMapPage() {
        super();
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(60, pageHeader);
        if (!isElementDisplayedOnPage(pageHeader, "Page Header")) errorsCount++;
        if (!isElementDisplayedOnPage(unnamedWallBtn, "Unnamed Wall button")) errorsCount++;
        if (!isElementDisplayedOnPage(googleMapBlock, "Google Map block")) errorsCount++;
        if (!isElementDisplayedOnPage(submenuBlock, "Submenu block")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }

    public NavigationBar goToNavigationBar() {
        return new NavigationBar();
    }

}
