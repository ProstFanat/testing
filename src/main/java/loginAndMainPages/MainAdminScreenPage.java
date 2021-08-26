package loginAndMainPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainAdminScreenPage {

    SelenideElement loadSearchBtn = $x("//p[contains(text(), 'Load Search')]"),
    eldTransactionBtn = $x("//a[contains(@is-permitted-for, 'read.ELD-TRANSACTIONS')]"),
    customersBtn = $x("//*[text() = 'Customers']"),
    migrationBtn = $x("//a[contains(@is-permitted-for, 'read.ADMIN-MIGRATION-DASHBOARD')]");


    public void clickLoadSearchBtn() {
        loadSearchBtn.click();
    }

    public void clickSideMenuELDTransactionBtn() {
        eldTransactionBtn.click();
    }

    public void clickCustomers(){
        customersBtn.click();
    }

    public void clickSideMenuMigrationBtn() {
        migrationBtn.click();

    }
}
