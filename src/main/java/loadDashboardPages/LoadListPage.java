package loadDashboardPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoadListPage {

    SelenideElement newLoadBtn = $x("//button[@routerlink='/load-list/create-load']");
    public static SelenideElement loadIdInput = $x("//input[@placeholder = 'Load ID']");

    public static SelenideElement btnFilter = $x("//button[text() = ' Filter ']");

    public LoadListPage clickNewLoadBtn() {
        newLoadBtn.click();
        return this;
    }

    public static void inputLoadId(String id){
        loadIdInput.sendKeys(id);
    }

    public static void clickBtnFilter(){
        btnFilter.click();
    }
}
