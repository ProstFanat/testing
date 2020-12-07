package fleet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;

public class MoveEvents extends BasePage {
    public MoveEvents(WebDriver driver) {
        super(driver);
    }

    public WebDriver driver;

    /** Find apply move button*/
    @FindBy(xpath = "//button[text() = 'Move ']")
    public WebElement btnApplyMove;

    public void applyMove(){
        waitToVisibilityOf(10,btnApplyMove);
        waitToBeClickable(10, btnApplyMove);
        sleep(500);
        btnApplyMove.click();
    }

    /** Find cancel move button*/
    @FindBy(xpath = "//button[text() = ' Cancel']")
    public WebElement btnCancelMove;

    public void cancelMove(){
        waitToVisibilityOf(10, btnCancelMove);
        waitToBeClickable(10, btnCancelMove);
        sleep(500);
        btnCancelMove.click();
    }

    /** 1 Event*/
    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[1]//datatable-body-cell[4]//span")
    public WebElement event1Type;

    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[1]//button[contains(@tooltip, 'Move Up')]")
    public WebElement event1Up;

    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[1]//button[contains(@tooltip, 'Move Down')]")
    public WebElement event1Down;

    public void moveUp1(){
        event1Up.click();
    }

    public void moveDown1(){
        sleep(500);
        event1Down.click();
    }

    public String getType1(){
        return  event1Type.getText();
    }

    /** 2 Event*/
    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[2]//datatable-body-cell[4]//span")
    public WebElement event2Type;

    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[2]//button[contains(@tooltip, 'Move Up')]")
    public WebElement event2Up;

    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[2]//button[contains(@tooltip, 'Move Down')]")
    public WebElement event2Down;

    public void moveUp2(){
        event2Up.click();
    }

    public void moveDown2(){
        event2Down.click();
    }

    public String getType2(){
        return  event2Type.getText();
    }

    /** 3 Event*/
    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[3]//datatable-body-cell[4]//span")
    public WebElement event3Type;

    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[3]//button[contains(@tooltip, 'Move Up')]")
    public WebElement event3Up;

    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[3]//button[contains(@tooltip, 'Move Down')]")
    public WebElement event3Down;

    public void moveUp3(){
        event3Up.click();
    }

    public void moveDown3(){
        event3Down.click();
    }

    public String getType3(){
        return  event3Type.getText();
    }

    /** 4 Event*/
    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[4]//datatable-body-cell[4]//span")
    public WebElement event4Type;

    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[4]//button[contains(@tooltip, 'Move Up')]")
    public WebElement event4Up;

    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[4]//button[contains(@tooltip, 'Move Down')]")
    public WebElement event4Down;

    public void moveUp4(){
        event4Up.click();
    }

    public void moveDown4(){
        event4Down.click();
    }

    public String getType4(){
        return  event4Type.getText();
    }

    /** 5 Event*/
    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[5]//datatable-body-cell[4]//span")
    public WebElement event5Type;

    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[5]//button[contains(@tooltip, 'Move Up')]")
    public WebElement event5Up;

    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[5]//button[contains(@tooltip, 'Move Down')]")
    public WebElement event5Down;

    public void moveUp5(){
        event5Up.click();
    }

    public void moveDown5(){
        event5Down.click();
    }

    public String getType5(){
         return event5Type.getText();
    }

    /** 6 Event*/
    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[6]//datatable-body-cell[4]//span")
    public WebElement event6Type;

    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[6]//button[contains(@tooltip, 'Move Up')]")
    public WebElement event6Up;

    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[6]//button[contains(@tooltip, 'Move Down')]")
    public WebElement event6Down;

    public void moveUp6(){
        event6Up.click();
    }

    public void moveDown6(){
        event6Down.click();
    }

    public String getType6(){
        return event6Type.getText();
    }

    /** 7 Event*/
    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[7]//datatable-body-cell[4]//span")
    public WebElement event7Type;

    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[7]//button[contains(@tooltip, 'Move Up')]")
    public WebElement event7Up;

    @FindBy(xpath = "//datatable-scroller/datatable-row-wrapper[7]//button[contains(@tooltip, 'Move Down')]")
    public WebElement event7Down;

    public void moveUp7(){
        event7Up.click();
    }

    public void moveDown7(){
        event7Down.click();
    }

    public String getType7(){
        return  event7Type.getText();
    }
}
