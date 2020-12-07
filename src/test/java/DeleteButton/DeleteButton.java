package DeleteButton;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import resources.ConfProperties;

import java.io.IOException;

import static DeleteButton.Main.*;
import static org.junit.Assert.assertFalse;

public class DeleteButton extends BasePage {


    // закрыть окно начала смены
    @FindBy(xpath = "//*[@class = 'modal-footer']//button[2]")
    private WebElement shift;

    public DeleteButton(WebDriver driver) {
        super(driver);
    }

    public void cancelShift(){
        waitToVisibilityOf(10, shift);
        waitToBeClickable(10,shift);
        shift.click();
    }

    // найти и нажать на поле customers
    @FindBy(xpath = "//*[@class = 'admin-main-screen-menu']//i[@class = 'fa fa-users fa-4x']")
    private WebElement customers;

    public void openCustomers(){
        waitToVisibilityOf(10, customers);
        waitToBeClickable(10, customers);
        customers.click();
    }

    // найти и заполнить поле организации
    @FindBy(xpath = "/html/body/admin-view/div/div/div/ui-view/customers/div/div/div[2]/div/div[1]/div/div/div[2]/div[1]/div/input")
    private WebElement organizations;

    public void inputOrg(String org){
        waitToVisibilityOf(10, organizations);
        waitToBeClickable(10,organizations);
        organizations.sendKeys(org);
    }

    // найти и нажать на кнопку логин как организация
    @FindBy(xpath = "//*[contains(@class , 'fa-sign-in')]")
    private WebElement loginOrg;

    public void logAsOrg(){
        waitToVisibilityOf(10, loginOrg);
        waitToBeClickable(10, loginOrg);
        loginOrg.click();
    }

    // Перейти на эдитор
    public void goToEditor(String src){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get(src);
    }

    // Открыть транзакцию
    @FindBy(xpath = "//app-modiffiers/div/div[1]/button")
    private WebElement openTransaction;

    @FindBy(xpath = "//div[@class='modal-body']//div[@class='row mt-1']//textarea")
    private WebElement inputDescription;

    @FindBy(xpath = "//div[@class='modal-footer']/button[contains(@class, 'btn-primary')]")
    private WebElement btnSave;

    public void createTransaction(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (visibleDeleteBtn() == true){
            deleteTransaction();
            openTransaction.click();
            waitToVisibilityOf(10, inputDescription);
            waitToBeClickable(10, inputDescription);
            inputDescription.sendKeys("test");
            btnSave.click();
        } else {
            openTransaction.click();
            waitToVisibilityOf(10, inputDescription);
            waitToBeClickable(10, inputDescription);
            inputDescription.sendKeys("test");
            btnSave.click();
        }
    }

    // Удалить транзакцию
    @FindBy(xpath = "//button[contains(text(), 'Delete')]")
    private WebElement btnDelete;

    // Подтвердить удаление
    @FindBy(xpath = "//div[@class = 'modal-footer']//button[1]")
    private WebElement btnDeleteYes;

    public boolean visibleDeleteBtn(){
        try {
            btnDelete.isDisplayed();
            return true; // Success!
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    public void deleteTransaction(){
        waitToVisibilityOf(10, btnDelete);
        waitToBeClickable(10, btnDelete);
        btnDelete.click();
        waitToVisibilityOf(10, btnDelete);
        waitToBeClickable(10, btnDelete);
        btnDeleteYes.click();
    }

    public void checkButton(){
        if (visibleDeleteBtn()){
            deletebutton.deleteTransaction();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        assertFalse(visibleDeleteBtn());
    }

    public void create(int indexCreate){
        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage.inputLogin(ConfProperties.getProperty("loginCreate" + indexCreate));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();

        if(indexCreate != 1) {
            deletebutton.cancelShift();
            deletebutton.openCustomers();
            deletebutton.inputOrg(ConfProperties.getProperty("company"));
            deletebutton.logAsOrg();
            deletebutton.goToEditor(ConfProperties.getProperty("editor" + indexCreate));
            deletebutton.createTransaction();
        } else {
            deletebutton.goToEditor(ConfProperties.getProperty("editor" + indexCreate));
            deletebutton.createTransaction();
        }
        logOut.userLogout();
    }

    public void deleteCheck(int indexCreate, int indexDelete) throws IOException {

        String deleteBy = "";
        String createBy = "";
        switch (indexCreate) {
            case 1:
                createBy = "fleet manager";
                break;
            case 2:
                createBy = "Support TL";
                break;
            case 3:
                createBy = "Support";
                break;
            case 4:
                createBy = "Editor TL";
                break;
            case 5:
                createBy = "Editor";
                break;
        }
        switch (indexDelete) {
            case 1:
                deleteBy = "fleet manager";
                break;
            case 2:
                deleteBy = "Support TL";
                break;
            case 3:
                deleteBy = "Support";
                break;
            case 4:
                deleteBy = "Editor TL";
                break;
            case 5:
                deleteBy = "Editor";
                break;
        }

        driver.get(ConfProperties.getProperty("loginpage"));
        loginPage.inputLogin(ConfProperties.getProperty("loginDelete" + indexDelete));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();

        if(indexDelete != 1){
            deletebutton.cancelShift();
            deletebutton.openCustomers();
            deletebutton.inputOrg(ConfProperties.getProperty("company"));
            deletebutton.logAsOrg();
            deletebutton.goToEditor(ConfProperties.getProperty("editor" + indexCreate));
            deletebutton.checkButton();
            loginPage.takeScreen(ConfProperties.getProperty("screen"),"create by:" + createBy + " " + "delete by:" + deleteBy);
        } else {
            deletebutton.goToEditor(ConfProperties.getProperty("editor" + indexCreate));
            deletebutton.checkButton();
            loginPage.takeScreen(ConfProperties.getProperty("screen"),"create by" + createBy + " " + "delete by:" + deleteBy);
        }
        logOut.userLogout();
    }

}