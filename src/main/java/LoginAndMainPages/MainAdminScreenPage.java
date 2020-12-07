package LoginAndMainPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainAdminScreenPage {

    SelenideElement loadSearchBtn = $x("//p[contains(text(), 'Load Search')]");

    public void clickLoadSearchBtn() {
        loadSearchBtn.click();
    }
}
