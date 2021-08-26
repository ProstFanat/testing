package eldTransactionPages.Fragments;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ELDMonitorTabsFragment {

    SelenideElement eldViewerTab = $x("//a[text() = 'ELD Viewer']");

    public ELDMonitorTabsFragment eldViewerTabClick() {
        eldViewerTab.click();
        return this;
    }




}
