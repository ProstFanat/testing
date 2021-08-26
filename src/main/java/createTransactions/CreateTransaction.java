package createTransactions;

import loginAndMainPages.MainAdminScreenPage;
import main.CustomersPage;
import main.DriversPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import resources.BasePage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CreateTransaction extends BasePage {
    SelenideElement driverSelect = $x("//ng-select[@placeholder = 'Select Driver']//input");
    ElementsCollection driversList = $$x("//ng-dropdown-panel//*[@role = 'option']");
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
                    driverInfo = $x("//ng-dropdown-panel//*[@role = 'option'][@aria-selected = 'true']");

    public static CustomersPage customersPage;
    public static DriversPage driversPage;
    public static MainAdminScreenPage mainAdminScreenPage;
    public static OpenEditor openEditor;

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
        waitForPageToLoad();
        textareaInProcess.click();
        btnSaveProcess.click();
        waitForPageToLoad();
        System.out.println("Transaction has been processed!");
    }

    public CreateTransaction createTransaction(Integer quantity, String commentTransaction){
        System.out.println("Creating transaction from company 'Company For Autotesting'");
        customersPage = new CustomersPage();
        driversPage = new DriversPage();
        mainAdminScreenPage = new MainAdminScreenPage();

        //openEditor.openEditor();

        int createdTransactions = 0, counter = 1;
        while(createdTransactions < quantity){
            System.out.println("counter = " + counter + "  createdTransactions = " + createdTransactions);
            driverSelect.click();
            driversList.get(counter).click();
            try {
                if (btnOpenTransaction.isDisplayed()) {
                    btnOpenTransaction.click();
                    descriptionInput.setValue("Created by Java").click();
                    btnSave.click();
                    waitForPageToLoad();
                    processTransaction(commentTransaction);
                    createdTransactions++;
                } else if (btnProcessed.isDisplayed()) {
                    processTransaction(commentTransaction);
                    waitForPageToLoad();
                    createdTransactions++;
                } else if (btnTake.isDisplayed()) {
                    processTransaction(commentTransaction);
                    waitForPageToLoad();
                    createdTransactions++;
                }
            } catch (Exception e){
                System.out.println(e);
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
        openEditor = new OpenEditor();

        Map<String, String> result = new HashMap<String, String>();

        openEditor.openEditor();
        int createdTransactions = 0, counter = 1;
        while(createdTransactions < 1){
            System.out.println("counter = " + counter + "  createdTransactions = " + createdTransactions);
            driverSelect.click();
            driversList.get(counter).click();
            waitForPageToLoad();

            try {
                if (btnOpenTransaction.isDisplayed()) {
                    btnOpenTransaction.click();
                    descriptionInput.setValue("Created by Java");
                    btnSave.click();
                    waitForPageToLoad();
                    processTransaction(commentTransaction);
                    createdTransactions++;

                    result.put("url", url());
                    result.put("name", driverInfo.getText());
                    System.out.println(result.get("url"));
                    System.out.println(result.get("name"));
                } else if (btnProcessed.is(Condition.visible)) {
                    processTransaction(commentTransaction);
                    waitForPageToLoad();
                    createdTransactions++;

                    result.put("url", url());
                    result.put("name", driverInfo.getText());
                    System.out.println(result.get("url"));
                    System.out.println(result.get("name"));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            counter++;
            if(createdTransactions > 0) break;
        }
        return result;
    }
}
