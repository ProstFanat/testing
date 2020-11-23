package logic.pages.companyProfile.drivers.driverProfile;

import logic.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewerPage extends BasePage {
    @FindBy (css = "button[ispermittedfor='read.ELD-EDITOR']")
    private WebElement goToEldEditorBtn;
    public ViewerPage() {
        super();
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        return false;
    }

    public EditorPage goToEldEditor(){
        clickOnElement(goToEldEditorBtn);
        return new EditorPage();
    }
}
