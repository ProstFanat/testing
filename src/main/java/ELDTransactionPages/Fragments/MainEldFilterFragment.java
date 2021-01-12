package ELDTransactionPages.Fragments;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainEldFilterFragment {

    public SelenideElement transactionsStatusFilter = $x("//*[@placeholder = 'Status']"),
//    transactionStatusFilterTable = $("placeholder=\"Status\""),
            filterBtn = $x("//button[text() = ' Filter ELD Transactions ']");

    public ElementsCollection transactionsStatuses = $$x("//div[@role = 'option']");


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
}

