package eldTransactionPages.Fragments;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ConfirmModalWindowFragment {
    SelenideElement yesBtn = $x("//button[text()='Yes ']");


    public ConfirmModalWindowFragment clickYesBtn() {
        yesBtn.click();
        return this;
    }


}
