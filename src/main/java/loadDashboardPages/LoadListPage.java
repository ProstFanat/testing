package loadDashboardPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoadListPage {

    SelenideElement newLoadBtn = $x("//button[@routerlink='/load-list/create-load']");
    SelenideElement loadIdInput = $x("//input[@placeholder = 'Load ID']");

    SelenideElement btnFilter = $x("//button[text() = ' Filter ']");

    public LoadListPage clickNewLoadBtn() {
        newLoadBtn.click();
        return this;
    }

    public LoadListPage inputLoadId(String id){
        loadIdInput.sendKeys(id);
        return this;
    }

    public LoadListPage clickBtnFilter(){
        btnFilter.click();
        return this;
    }
}
