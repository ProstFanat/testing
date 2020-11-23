package logic.pages;

import io.qameta.allure.Step;
import logic.BasePage;
import logic.variables.UrlVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class LoginPage extends BasePage {
    @FindBy (id = "email")
    private WebElement inputEmail;
    @FindBy (id = "password")
    private WebElement inputPassword;
    @FindBy(css = "input[type='submit']")
    private WebElement btnSubmitLogin;
    //@FindBy(partialLinkText = "/login.do")
    private WebElement registerNewCompanyBtn;

    public LoginPage() {
        super();
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        return false;
    }

    @Step("Enter login value to forms")
    public LoginPage setValuesIntoLoginForm (HashMap<String, String> values) {
        waitToVisibilityOf(10, inputEmail);
        inputEmail.sendKeys(values.get("login"));
        inputPassword.sendKeys(values.get("password"));
        log.info("Enter login value to forms: " + values.toString());
        return this;
    }

    @Step("Enter login value to forms")
    public LoginPage setValuesIntoLoginForm(String login, String password) {
        waitToVisibilityOf(20, driver.findElement(By.className("loginBox")));
        inputEmail.sendKeys(login);
        inputPassword.sendKeys(password);
        log.info("Enter login value to forms: " + login + " " + password);
        return this;
    }

    @Step("Click on Submit Login Button")
    public AssetsMapPage clickBtnSubmitLogin (){
        waitToVisibilityOf(20, btnSubmitLogin);
        btnSubmitLogin.click();
        log.info("Click on Submit Login Button");
        return new AssetsMapPage();
    }

    @Step("Click 'Register New Company'")
    public RegistrationPage clickOnRegisterNewCompany() {
        registerNewCompanyBtn = driver.findElement(By.cssSelector("a[href='"+ UrlVariables.getBaseURL()+"register/']"));
        waitToVisibilityOf(20, registerNewCompanyBtn);
        waitToBeClickable(10, registerNewCompanyBtn);
        registerNewCompanyBtn.click();
        log.info("Click on Register New Company link");
        return new RegistrationPage();
}

}
