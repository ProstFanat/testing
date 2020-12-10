package Main;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class OptionsOfCompanyPage extends BasePage {

    public SelenideElement tabSystemOptions = $x("//a[text() = 'System Options']"),
                            dispatchingCheckBox = $x("//input[@id= 'send-loads-offers-to-drivers']"),
                            btnSaveDispatching = $x("//h4[text() = 'Dispatching']//..//input[@type = 'button']");

    public OptionsOfCompanyPage openPage(){
        open("http://localhost:8080/TrackEnsure/fleet/manager/cpOptions/#/");
        waitForPageToLoad();
        return this;
    }

    public OptionsOfCompanyPage goToSystemOptionsTab(){
        tabSystemOptions.click();
        return this;
    }

    public OptionsOfCompanyPage setDispatchingCheckBox(Boolean value){
        dispatchingCheckBox.setSelected(value);
        return this;
    }

    public OptionsOfCompanyPage clickBtnSave(){
        btnSaveDispatching.click();
        return this;
    }
}
