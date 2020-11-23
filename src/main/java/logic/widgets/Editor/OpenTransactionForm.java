package logic.widgets.Editor;

import io.qameta.allure.Step;
import logic.pages.companyProfile.drivers.driverProfile.EditorPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenTransactionForm extends EditorPage {
    @FindBy(xpath = "//div[3]/div/textarea")
    private WebElement descriptionTextArea;
    @FindBy(xpath = "//div[4]/div/textarea")
    private WebElement commentTextArea;
    @FindBy(xpath = "//*[@id='changeDrivingDuration']")
    private WebElement changeDrivingDurationCheckBox;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement saveBtn;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelBtn;

    public OpenTransactionForm() {
        super();
    }

    @Step ("Enter text {0} in Description area")
    public OpenTransactionForm inputDescription (String description){
        descriptionTextArea.sendKeys(description);
        return new OpenTransactionForm();
    }
    @Step("Enter text {0} in Comment area")
    public OpenTransactionForm inputComment (String comment){
        commentTextArea.sendKeys(comment);
        return new OpenTransactionForm();
    }

    public OpenTransactionForm checkChangeDrivingDuration (){
        changeDrivingDurationCheckBox.click();
        return new OpenTransactionForm();
    }
    @Step ("Save to open transaction")
    public EditorPage clickOnSave (){
        waitToBeClickable(10, saveBtn);
        saveBtn.click();
        return new EditorPage();
    }
}
