package CreateTransactions;

import LoginAndMainPages.MainAdminScreenPage;
import Main.CustomersPage;
import Main.DriversPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import resources.AppConstants;
import resources.BasePage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CreateTransaction extends BasePage {
    SelenideElement driverSelect = $x("//ng-select[@placeholder = 'Driver Name']//input");
    ElementsCollection driversList = $$x("//ng-select[@placeholder = 'Driver Name']//ng-dropdown-panel//div//div//div");
    SelenideElement btnOpenTransaction = $x("//button[text() = 'Open Transaction ']");
    SelenideElement descriptionInput = $x("//label[text() = 'Description: ']//..//textarea");
    SelenideElement btnSave = $x("//button[text() = 'Save ']");
    SelenideElement btnProcessed = $x("//button[text() = 'Processed ']");
    SelenideElement modalWindow = $x("//div[@class = 'modal-header']");
    SelenideElement btnModalWindowOk = $x("//button[text() = 'OK']");
    SelenideElement errorMessage = $x("//*[@role='alertdialog']");
    SelenideElement btnSkip = $x("//button[text() = 'Skip']"),
                    transactionStatusProcessed = $x("//*[text() = ' Processed']"),
                    btnTake = $x("//button[text() = 'Take ']"),
                    textareaInProcess = $x("//*[@role = 'document']//textarea"),
                    btnSaveProcess = $x("//*[@role = 'document']//button[text() = 'Save']"),
                    driverInfo = $x("//ng-select[@placeholder = 'Driver Name']//div//div//div[contains(@class, 'ng-value')]//span[contains(@class, 'ng-value-label')]");

    public static CustomersPage customersPage;
    public static DriversPage driversPage;
    public static MainAdminScreenPage mainAdminScreenPage;

    public CreateTransaction checkModalWindow(){
        if(modalWindow.isDisplayed()){
            btnModalWindowOk.click();
        }
        return this;
    }

    public CreateTransaction checkErrorMessage(){

        return this;
    }

    public void processTransaction(String comment){
        if(btnTake.isDisplayed()){
            btnTake.click();
        }
        btnProcessed.click();
        textareaInProcess.setValue(comment);
        btnSaveProcess.click();
        waitForPageToLoad();
        System.out.println("Transaction has been processed!");
    }

    public CreateTransaction createTransaction(Integer quantity, String commentTransaction){
        System.out.println("Creating transaction from company 'Company For Autotesting'");
        customersPage = new CustomersPage();
        driversPage = new DriversPage();
        mainAdminScreenPage = new MainAdminScreenPage();

        mainAdminScreenPage.clickCustomers();
        customersPage.logAsOrgOfCompany("Company For Autotesting");
        driversPage.openPage();
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/app/hos/#/eldHOS/editor/driver/63888/timestamp/1610575199999/timeZone/US%2FAlaska");
        int createdTransactions = 0, counter = 1;
        while(createdTransactions < quantity){
            System.out.println("counter = " + counter + "  createdTransactions = " + createdTransactions);
            driverSelect.click();
            driversList.get(counter).click();
            if(btnOpenTransaction.isDisplayed()){
                btnOpenTransaction.click();
                descriptionInput.setValue("tesssst");
                btnSave.click();
                waitForPageToLoad();
                processTransaction(commentTransaction);
                createdTransactions++;
            } else if (btnProcessed.isDisplayed()){
                processTransaction(commentTransaction);
                waitForPageToLoad();
                createdTransactions++;
            } else if (btnTake.isDisplayed()){
                processTransaction(commentTransaction);
                waitForPageToLoad();
                createdTransactions++;
            }
            counter++;
        }
        return this;
    }

    public Map<String, String> createWithReturningUrlAndDriverName(String commentTransaction){
        System.out.println("Creating transaction from company 'Company For Autotesting'");
        customersPage = new CustomersPage();
        driversPage = new DriversPage();
        mainAdminScreenPage = new MainAdminScreenPage();

        Map<String, String> result = new HashMap<String, String>();

        customersPage.openCustomersPage();
        customersPage.logAsOrgOfCompany("Company For Autotesting");
        driversPage.openPage();
        open("http://" + AppConstants.URL_OF_LOCAL_SERVER + ":8080/TrackEnsure/app/hos/#/eldHOS/editor/driver/63888/timestamp/1610575199999/timeZone/US%2FAlaska");
        int createdTransactions = 0, counter = 1;
        while(createdTransactions < 1){
            System.out.println("counter = " + counter + "  createdTransactions = " + createdTransactions);
            driverSelect.click();
            driversList.get(counter).click();
            if(btnOpenTransaction.exists()){
                btnOpenTransaction.click();
                descriptionInput.setValue("tesssst");
                btnSave.click();
                waitForPageToLoad();
                processTransaction(commentTransaction);
                createdTransactions++;

                result.put("url", url());
                result.put("name", driverInfo.getText());
                System.out.println(result.get("url"));
                System.out.println(result.get("name"));
            } else if (btnProcessed.exists()) {
                processTransaction(commentTransaction);
                waitForPageToLoad();
                createdTransactions++;

                result.put("url", url());
                result.put("name", driverInfo.getText());
                System.out.println(result.get("url"));
                System.out.println(result.get("name"));
            }
            counter++;
        }
        return result;
    }
}
