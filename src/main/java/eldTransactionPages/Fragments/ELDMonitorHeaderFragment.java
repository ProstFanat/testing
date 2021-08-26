package eldTransactionPages.Fragments;

import com.codeborne.selenide.Condition;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class ELDMonitorHeaderFragment {

SelenideElement takeTransactionBtn = $x("//button[text()= ' Take Transaction ']");
    public SelenideElement rejectBtn = $x("//button[text()= ' Reject ']"),
    btnShowLegend = $x("//button[text()= ' Show Legend ']"),
    commiteBtn = $x("//button[text()= ' Commit ']");

    public ELDMonitorHeaderFragment clickTakeTransactionBtn() {
        takeTransactionBtn.click();
        return this;
    }

    public void clickRejectBtn() {
       sleep(5000);
        if (takeTransactionBtn.is(Condition.visible)) {
            takeTransactionBtn.click();
        }
        rejectBtn.click();
    }
    public void clickCommiteBtn() {
        sleep(5000);
        if (takeTransactionBtn.is(Condition.visible)) {
            takeTransactionBtn.click();
        }
        commiteBtn.click();
    }

}
