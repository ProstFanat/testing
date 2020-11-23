package logic.pages;

import logic.BasePage;
import logic.variables.NotificationVariables;
import logic.widgets.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;


public class HomePage extends BasePage {
    @FindAll({
            @FindBy(xpath = "//*[@id=\"carouselHeader\"]/ol/li[1]"),
            @FindBy(xpath = "//*[@id=\"carouselHeader\"]/ol/li[2]"),
            @FindBy(xpath = "//*[@id=\"carouselHeader\"]/ol/li[3]"),
            @FindBy(xpath = "//*[@id=\"carouselHeader\"]/ol/li[4]"),
            @FindBy(xpath = "//*[@id=\"carouselHeader\"]/ol/li[5]"),
            @FindBy(xpath = "//*[@id=\"carouselHeader\"]/ol/li[6]"),
            @FindBy(xpath = "//*[@id=\"carouselHeader\"]/ol/li[7]")
    })
    private List<WebElement> carouselHeader;
    @FindBy(xpath = "//*[@id=\"btnTop\"]/a")
    private WebElement btnUpPage;
    @FindAll({
            @FindBy(xpath = "//*[@id=\"slide01\"]/div/a"),
            @FindBy(xpath = "//*[@id=\"slide02\"]/div/a"),
            @FindBy(xpath = "//*[@id=\"slide03\"]/div/a"),
            @FindBy(xpath = "//*[@id=\"slide04\"]/div/a"),
            @FindBy(xpath = "//*[@id=\"slide05\"]/div/a"),
            @FindBy(xpath = "//*[@id=\"slide06\"]/div/a"),
            @FindBy(xpath = "//*[@id=\"slide07\"]/div/a"),
    })
    private List<WebElement> btnReadMoreHeaderCrsl;
    @FindBy(xpath = "//*[@id=\"infoBlock-wrapper\"]/div[2]")
    private WebElement frmInfoBlock;
    @FindBy(xpath = "//*[@id=\"btnQuestion\"]/button")
    private WebElement btnGetInfoBlock;
    @FindAll({
            @FindBy(xpath = "//*[@id=\"infoBlock-wrapper\"]/div[2]/form/div[1]/input"),
            @FindBy(xpath = "//*[@id=\"infoBlock-wrapper\"]/div[2]/form/div[2]/input"),
            @FindBy(xpath = "//*[@id=\"infoBlock-wrapper\"]/div[2]/form/div[3]/input"),
            @FindBy(xpath = "//*[@id=\"infoBlock-wrapper\"]/div[2]/form/div[4]/textarea")
    })
    private List<WebElement> customerContactFormFloated;
    @FindBy(xpath = "//*[@id=\"infoBlock-wrapper\"]/div[2]/form/button")
    private WebElement btnSendContactForm;
    @FindBy(xpath = "/html/body/div[2]/div")
    private WebElement notificationSendContactFormOk;
    @FindBy(xpath = "/html/body/div[5]/div[1]/i")
    private WebElement btnCloseContactForm;
    @FindBy(xpath = "/html/body/div[5]/div[2]/form/div[1]/div")
    WebElement notificationReqValNameContactForm;
    @FindBy(xpath = "/html/body/div[5]/div[2]/form/div[4]/div")
    WebElement notificationReqValMessageContactForm;

    public HomePage() {
        super();
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        return false;
    }

    public HomePage clickImgLogo() {
        return new Header().clickOnLogo();

    }
/*
    public HomePage clickOnCrsl(int num) {
        new HomePage(driver)
                .waitToBeClickable(10, carouselHeader.get(num))
                .clickOnElement(carouselHeader.get(num));
        return this;
    }

    public HomePage clickOnUpBtn() {
        new HomePage(driver).waitToBeClickable(10, btnUpPage).clickOnElement(btnUpPage);
        return this;
    }

    public HomePage clickBtnReadMoreHeaderCrsl(int num) {
        new HomePage(driver)
                .waitToBeClickable(20, btnReadMoreHeaderCrsl.get(num))
                .clickOnElement(btnReadMoreHeaderCrsl.get(num));
        return this;
    }

    public HomePage clickOnBtnCloseContactForm() {
        new HomePage(driver).waitToBeClickable(10, btnCloseContactForm);
        btnCloseContactForm.click();
        return this;
    }

    public boolean checkInfoBlockIsDisplayed() {
        return new HomePage(driver).frmInfoBlock.isDisplayed();
    }

    public HomePage clickOnBtnGetIfoBlock() {
        new HomePage(driver).waitToBeClickable(10, btnGetInfoBlock);
        btnGetInfoBlock.click();
        return this;
    }

    public HomePage setValuesIntoInfoBlock(HashMap<String, String> values) {
        new HomePage(driver).waitToBeClickable(1, frmInfoBlock);
        customerContactFormFloated.get(0).sendKeys(values.get("name"));
        customerContactFormFloated.get(1).sendKeys(values.get("email"));
        customerContactFormFloated.get(2).sendKeys(values.get("phone"));
        customerContactFormFloated.get(3).sendKeys(values.get("message"));
        return this;
    }

    public WebElement getBtnUpPage() {
        return btnUpPage;
    }

    public HomePage clickOnBtnSendContactForm() {
        new HomePage(driver).waitToBeClickable(10, btnSendContactForm);
        btnSendContactForm.click();
        return this;
    }

    public boolean checkNotificationOkSendContactForm() {
        return checkTextOnElement(notificationSendContactFormOk, NotificationVariables.NOTIFICATION_SEND_CONTACT_FORM_TEXT);
    }

    public boolean checkNotificationOnContactFormReqValName() {
        return checkTextOnElement(notificationReqValNameContactForm, NotificationVariables.NOTIFICATION_REQ_VAL_CANTACT_TEXT);
    }
    public boolean checkNotificationOnContactFormReqValMessage() {
        return checkTextOnElement(notificationReqValMessageContactForm, NotificationVariables.NOTIFICATION_REQ_VAL_CANTACT_TEXT);
    }*/
}


