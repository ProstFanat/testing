package ELDTransactionPages.Fragments;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainEldTableFragment {

    SelenideElement viewBtn = $x("//span[contains(text(), ' View')]"),
            rowDriverList = $x("//datatable-row-wrapper[1]//datatable-body-cell[6]"),
            deleteBtn = $x("//span[text()=' Delete Transaction']"),
            switchTablePagesBtn = $x("//i[@class='datatable-icon-right']"),
    switchNextBtn = $x("//a[@aria-label='go to last page']/ancestor::li"),
    actionBtn = $x("//div[contains(@class, 'btn-group w-100 ng-star-inserted')]//button");
    ElementsCollection actionsBtn = $$x("//div[contains(@class, 'btn-group w-100 ng-star-inserted')]"),
            rowsDriverLists = $$x("//datatable-row-wrapper//datatable-body-cell[6]"),
            actions = $$x("//ul[@id='dropdown-basic']//li//span");

    public MainEldTableFragment clickFirstActionBtn() {
        actionsBtn.first().click();
        return this;
    }

    public MainEldTableFragment clickActionBtn() {
        actionBtn.click();
        return this;
    }

    public MainEldTableFragment clickActionView() {
        viewBtn.click();
        return this;
    }

    public Boolean getTransactionByComment(String comment) {
        while (!(switchNextBtn.getAttribute("class")=="disabled")){
            if (!($x("//p[text() = '" + comment + "']").isDisplayed())) {
                switchTablePagesBtn.click();
            }}
            return ($x("//p[text() = '" + comment + "']").isDisplayed());
    }



    public SelenideElement getFirstTransactionDriver() {
        return rowDriverList;
    }

    public MainEldTableFragment clickDeleteBtn() {
        deleteBtn.click();
        return this;
    }

    public ElementsCollection getAllTransactionsDate() {
        return rowsDriverLists;
    }

    public boolean findTransaction(String Date) {
        if (!(rowsDriverLists.findBy(text(Date)).isEnabled())){
            switchTablePagesBtn.click();
        } if (rowsDriverLists.findBy(text(Date)).isEnabled()) {
            return true;
        } else {
            return false;
        }
    }

    public ElementsCollection getActions() {
    return actions;
    }
}
