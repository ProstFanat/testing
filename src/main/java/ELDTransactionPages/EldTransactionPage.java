package ELDTransactionPages;

import ELDTransactionPages.Fragments.ConfirmModalWindowFragment;
import ELDTransactionPages.Fragments.MainEldFilterFragment;
import ELDTransactionPages.Fragments.MainEldTableFragment;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EldTransactionPage {

    MainEldTableFragment mainEldTableFragment = new MainEldTableFragment();
    MainEldFilterFragment mainEldFilterFragment = new MainEldFilterFragment();
    ConfirmModalWindowFragment confirmModalWindowFragment = new ConfirmModalWindowFragment();

    public MainEldTableFragment getMainEldTableFragment() {
        return mainEldTableFragment;
    }

    char quoMark = '"';
    public SelenideElement checkMessage(String message) {
        return $x("//*[@aria-label= " + quoMark + message + quoMark + "]");
    }

    public MainEldFilterFragment getMainEldFilterFragment() {
        return mainEldFilterFragment;
    }

    public ConfirmModalWindowFragment getConfirmModalWindowFragment() {
        return confirmModalWindowFragment;
    }
}
