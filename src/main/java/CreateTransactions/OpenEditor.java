package CreateTransactions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import resources.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class OpenEditor extends BasePage {
    SelenideElement passwdField = $x("//*[@id = 'password']");

    public OpenEditor(WebDriver driver) {
        super(driver);
    }

    public void openEditor(){
        Selenide.open("http://localhost:8080/TrackEnsure/fleet/admin-dashboard.jsp#/customers");

    }
}
