package ELDTransactionPages.Fragments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Collection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainEldTableFragment {

    SelenideElement viewBtn = $x("//span[contains(text(), ' View')]"),
            rowData = $x("//datatable-row-wrapper[1]//datatable-body-cell[4]"),
            deleteBtn = $x("//span[text()=' Delete Transaction']"),
            switchTablePages = $x("//i[@class='datatable-icon-right']");
    ElementsCollection actionsBtn = $$x("//div[contains(@class, 'btn-group w-100 ng-star-inserted')]"),
            rowsData = $$x("//datatable-row-wrapper//datatable-body-cell[4]"),
            actions = $$x("//ul[@id='dropdown-basic']");

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

    public SelenideElement getFirstTransactionDate() {
        return rowData;
    }

    public MainEldTableFragment clickDeleteBtn() {
        deleteBtn.click();
        return this;
    }

    public ElementsCollection getAllTransactionsDate() {
        return rowsData;
    }

    public boolean findTransaction(String Date) {
        if (!(rowsData.findBy(text(Date)).isEnabled())){
            switchTablePages.click();
        } if (rowsData.findBy(text(Date)).isEnabled()) {
            return true;
        } else {
            return false;
        }
    }

    public ElementsCollection getActions() {
    return actions;
    }
}
