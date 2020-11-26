package CreateTransactions;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CreateTransaction extends BasePage {
    SelenideElement driverSelect = $x("//ng-select[@placeholder = 'Driver Name']//input");
    ElementsCollection driversList = $$x("//ng-select[@placeholder = 'Driver Name']//ng-dropdown-panel//div//div//div");
    SelenideElement btnOpenTransaction = $x("//button[text() = 'Open Transaction ']");
    SelenideElement descriptionInput = $x("//label[text() = 'Description: ']//..//textarea");
    SelenideElement btnSave = $x("//button[text() = 'Save ']");
    SelenideElement btnProcessed = $x("//button[text() = 'Processed ']");
    SelenideElement modalWindow = $x("//div[@class = 'modal-header']");
    SelenideElement btnModalWindowOk = $x("//button[text() = 'OK']");

    public CreateTransaction checkModalWindow(){
        if(modalWindow.isDisplayed()){
            btnModalWindowOk.click();
        }
        return this;
    }

    public void create(int from, int to){
        for(int i = from; i <= to; i++ ){
            driverSelect.click();
            driversList.get(i).click();
            waitForPageToLoad();
            checkModalWindow();
            if(btnOpenTransaction.isEnabled()){
                btnOpenTransaction.click();
                descriptionInput.setValue("test");
                btnSave.click();
                btnProcessed.click();
            } else if (btnProcessed.isEnabled()){
                btnProcessed.click();
            } else {
                continue;
            }
        }
    }
}
