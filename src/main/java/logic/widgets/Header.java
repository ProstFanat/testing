package logic.widgets;

import io.qameta.allure.Step;
import logic.BasePage;
import logic.pages.AssetsMapPage;
import logic.pages.HomePage;
import logic.pages.LoginPage;
import logic.report.LogToAllure;
import logic.variables.UrlVariables;
import org.apache.log4j.Logger;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {
    private static final Logger log = Logger.getLogger(Header.class);

    @FindBy(css = "div[class='user-name']")
    private WebElement userName;
    @FindBy(css = "div[class='company-name']")
    private WebElement companyName;
    //@FindBy(xpath = "/html/body/nav/div/div[1]/a/img")
    @FindBy (className = "navbar-brand")
    private WebElement imgLogo;
    //@FindBy(linkText = "/login.do")
    private WebElement btnLogin;
    @FindBy(linkText = "/html/body/div[3]/div[2]/nav/div/div[1]/a[1]/img")
    private WebElement imgLogoFleet;
    @FindBy(xpath = "//a[contains(text(),'LOG OUT')]")
    private WebElement logoutBtn;
    @FindBy(className = "account-pin")
    private WebElement accountPin;

    public Header() {
        super();
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        return false;
    }

    @Step("Click on Logo 'TrackEnsure'")
    public HomePage clickOnLogo() {
        imgLogo.click();
        return new HomePage();
    }
    public AssetsMapPage clickOnLogoFleet(){
        imgLogoFleet.click();
        return new AssetsMapPage();
    }

    @Step("Open Login page")
    public LoginPage clickOnLogin() {
        btnLogin = driver.findElement(By.cssSelector("a[href='"+UrlVariables.getBaseURL()+"login.do']"));
        waitToVisibilityOf(10, btnLogin);
        btnLogin.click();
        if (!driver.getCurrentUrl().contains("/login.do")) {
            System.out.println(driver.getCurrentUrl());
            return clickOnLogin();
        }
        log.info("Click on Login button page");
        return new LoginPage();
    }

    public Header checkUserAndCompanyName(String user, String company) {
        waitToVisibilityOf(20, companyName);
        log.info("CHECK: Company Name must be equals: " + companyName.getText() + " | " + company);
        LogToAllure.logToAllure("CHECK: Company Name must be equals", companyName.getText() + " | " + company);
        assertEquals(companyName.getText(), company);
        log.info("CHECK: User Name must be equals: " + userName.getText() + " | " + user);
        LogToAllure.logToAllure("CHECK: User Name must be equals", userName.getText() + " | " + user);
        assertEquals(userName.getText(), " " + user);
        return this;
    }

    public Header checkAccountPin(String orgPin) {
        LogToAllure.logToAllure("CHECK: Account PIN", driver.getTitle() + " | " + orgPin);
        log.info("CHECK: Account PIN: " + driver.getTitle() + " | " + orgPin);
        assertEquals(accountPin.getText(), "Account PIN: " + orgPin);
        return this;
    }

    @Step("Click on Logout")
    public Header logout() {
        logoutBtn.click();
        log.info("Click on Logout button");
        return this;
    }

}
