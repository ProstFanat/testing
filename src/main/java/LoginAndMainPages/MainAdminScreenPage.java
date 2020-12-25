package LoginAndMainPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainAdminScreenPage {

    SelenideElement loadSearchBtn = $x("//p[contains(text(), 'Load Search')]"),
    eldTransactionBtn = $x("//a[contains(@is-permitted-for, 'read.ELD-TRANSACTIONS')]");


    public void clickLoadSearchBtn() {
        loadSearchBtn.click();
    }

    public void clickSideMenuELDTransactionBtb() {
        eldTransactionBtn.click();
    }
}
