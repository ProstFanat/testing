package ELDTransactionPages.Fragments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainEldTableFragment {

   SelenideElement viewBtn = $x("//span[contains(text(), ' View')]");


   ElementsCollection actionsBtn = $$x("//div[contains(@class, 'btn-group w-100 ng-star-inserted')]"),
transactions = $$x("");


    public MainEldTableFragment clickFirstActionBtn() {
        actionsBtn.first().click();
        return this;
    }

    public MainEldTableFragment clickActionView() {
        viewBtn.click();
        return this;
    }


    public ElementsCollection getTransactionByComment(String comment) {
        return $$x("//p[text() = '" + comment + "']");
    }
}
