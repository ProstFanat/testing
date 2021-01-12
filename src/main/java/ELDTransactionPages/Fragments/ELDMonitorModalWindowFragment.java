package ELDTransactionPages.Fragments;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ELDMonitorModalWindowFragment {

public SelenideElement modalCancelBtn = $x("//button[text() = 'Cancel']"),
        modalRejectBtn = $x("//button[text()= 'Reject']"),
        modalCommentField = $("[placeholder='Comment']"),
        modalCommitBtn = $x("//button[text()= 'Commit']");


public ELDMonitorModalWindowFragment clickCancelBtn() {
        modalCancelBtn.click();
        return this;
    }

    public ELDMonitorModalWindowFragment clickRejectBtn() {
        modalRejectBtn.click();
        return this;
    }

    public ELDMonitorModalWindowFragment typeComment(String comment) {
        modalCommentField.setValue(comment);
       return this;
}
    public ELDMonitorModalWindowFragment clickCommiteBtn() {
        modalCommitBtn.click();
        return this;
    }
}
