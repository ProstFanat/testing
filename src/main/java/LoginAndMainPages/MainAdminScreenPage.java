package LoginAndMainPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainAdminScreenPage {

    SelenideElement loadSearchBtn = $x("//p[contains(text(), 'Load Search')]"),
    eldTransactionBtn = $x("//a[contains(@is-permitted-for, 'read.ELD-TRANSACTIONS')]"),
    customersBtn = $x("//*[text() = 'Customers']");


    public void clickLoadSearchBtn() {
        loadSearchBtn.click();
    }

    public void clickSideMenuELDTransactionBtn() {
        eldTransactionBtn.click();
    }

    public void clickCustomers(){
        customersBtn.click();
    }
}
