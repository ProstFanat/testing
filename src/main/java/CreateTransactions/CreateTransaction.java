package CreateTransactions;

import LoginAndMainPages.MainAdminScreenPage;
import Main.CustomersPage;
import Main.DriversPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.*;

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
    btnTake = $x("//button[text() = 'Take']");

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

    public CreateTransaction createTransaction(Integer quantity){
        System.out.println("Creating transaction from company 'Company For Autotesting'");
        customersPage = new CustomersPage();
        driversPage = new DriversPage();
        mainAdminScreenPage = new MainAdminScreenPage();

        mainAdminScreenPage.clickCustomers();
        customersPage.logAsOrgOfCompany("Company For Autotesting");
        driversPage.openPage();
        open("http://localhost:8080/TrackEnsure/app/hos/#/eldHOS/editor/driver/63888/timestamp/1610575199999/timeZone/US%2FAlaska");
        int createdTransactions = 0, counter = 1;
        while(createdTransactions < quantity){
            System.out.println("counter = " + counter + "  createdTransactions = " + createdTransactions);
            driverSelect.click();
            driversList.get(counter).click();
            if(btnOpenTransaction.exists()){
                btnOpenTransaction.click();
                descriptionInput.setValue("tesssst");
                btnSave.click();
                waitForPageToLoad();
                btnProcessed.click();
                btnSkip.click();
                waitForPageToLoad();
                createdTransactions++;
            } else if (btnProcessed.exists()){
                btnProcessed.click();
                btnSkip.click();
                waitForPageToLoad();
                createdTransactions++;
            } else if (btnTake.exists()){
                btnTake.click();
                btnProcessed.click();
                btnSkip.click();
                waitForPageToLoad();
                createdTransactions++;
            }
            counter++;
        }
        return this;
    }

//    public void HARD_create(int from, int to){
//        for(int i = from; i <= to; i++ ){
//            refresh();
//            driverSelect.click();
//            driversList.get(i).click();
//            waitForPageToLoad();
//            checkModalWindow();
//            if(isHidden(btnOpenTransaction)){
//                btnOpenTransaction.click();
//                if(isVisible(errorMessage)){
//                    continue;
//                } else {
//                    descriptionInput.setValue("test");
//                    btnSave.click();
//                    if(isVisible(errorMessage)){
//                        continue;
//                    } else {
//                        btnProcessed.click();
//                        if(isVisible(errorMessage)){
//                            continue;
//                        }
//                    }
//                }
//
//            } else if (isHidden(btnProcessed)){
//                btnProcessed.click();
//            } else {
//                continue;
//            }
//        }
//    }
}
