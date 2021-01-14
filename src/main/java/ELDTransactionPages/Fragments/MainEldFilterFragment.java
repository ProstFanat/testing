package ELDTransactionPages.Fragments;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.*;

public class MainEldFilterFragment extends BasePage {

    public SelenideElement transactionsStatusFilter = $x("//*[@placeholder = 'Status']"),
//    transactionStatusFilterTable = $("placeholder=\"Status\""),
            filterBtn = $x("//button[text() = ' Filter ELD Transactions ']"),
            companyFilter = $x("//*[@placeholder = 'Organization']//input"),
            driverFilter = $x("//*[@placeholder = 'Driver']//input");

    public ElementsCollection transactionsStatuses = $$x("//div[@role = 'option']"),
        listOfElements = $$x("//*[@role = 'option']");


    public MainEldFilterFragment changeStatusFilter(String status){

        sleep(5000);
        transactionsStatusFilter.click();
       // transactionsStatusFilter.selectOptionContainingText(status);

        for (int i = 0; i < transactionsStatuses.size(); i++) {
            if (transactionsStatuses.get(i).getText().startsWith(status)) {
                transactionsStatuses.get(i).click();
            }
        }
        return this;
    }


    public MainEldFilterFragment clickFilterBtn() {
        filterBtn.click();
        return this;
    }

    public void filterByDriver(String company, String driver){
        companyFilter.sendKeys(company);
        listOfElements.first().click();
        companyFilter.pressEnter();

        driverFilter.waitUntil(Condition.enabled, 10000);
        //listOfElements.first().click();
        driverFilter.sendKeys(driver);
        driverFilter.pressEnter();

        clickFilterBtn();
        sleep(2000);
    }
}

