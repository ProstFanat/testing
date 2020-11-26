package loadDashboardPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DispatchingSettingsPage {
    SelenideElement orgNameInput = $x("//input[@placeholder='Organization Name']");
    SelenideElement btnFilter = $x("");
    SelenideElement driverNameInput = $x("//input[@placeholder='Driver Name']");
}
