package fleet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;

import java.util.List;

public class historyTrip extends BasePage {
    public historyTrip(WebDriver driver) {
        super(driver);
    }

    public WebDriver driver;

    /** Find Actions Button*/
    @FindBy(xpath = "//*[@id = 'button-basic']")
    public WebElement btnActions;

    /** Find Trip history button*/
    @FindBy(xpath = "//*[@id = 'dropdown-basic']")
    public WebElement btnTripHistory;

    public void openTripHistory(){
        waitToBeClickable(10, btnActions);
        btnActions.click();
        waitToBeClickable(10, btnTripHistory);
        btnTripHistory.click();
    }

    /** Find version Left select*/
    @FindBy(xpath = "//*[@id = 'selectedTripVersionLeft']")
    public WebElement inputVersionLeft;

    /** Find version Left List with first element*/
    @FindBy(xpath = "//*[@id = 'selectedTripVersionLeft']//ng-dropdown-panel/div/div/div[1]")
    public WebElement listVersionLeft1;

    /** Find version Left List with second element*/
    @FindBy(xpath = "//*[@id = 'selectedTripVersionLeft']//ng-dropdown-panel/div/div/div[2]")
    public WebElement listVersionLeft2;

    /** Find version Right select*/
    @FindBy(xpath = "//*[@id = 'selectedTripVersionRight']")
    public WebElement inputVersionRight;

    /** Find version Right List with first element*/
    @FindBy(xpath = "//*[@id = 'selectedTripVersionRight']//ng-dropdown-panel/div/div/div[1]")
    public WebElement listVersionRight1;

    /** Find version Right List with second element*/
    @FindBy(xpath = "//*[@id = 'selectedTripVersionRight']//ng-dropdown-panel/div/div/div[2]")
    public WebElement listVersionRight2;

    public void selectLeftVersion1(){
        waitToVisibilityOf(10, inputVersionLeft);
        inputVersionLeft.click();
        waitToVisibilityOf(10, listVersionLeft1);
        listVersionLeft1.click();
    }

    public void selectLeftVersion2(){
        waitToVisibilityOf(10, inputVersionLeft);
        inputVersionLeft.click();
        waitToVisibilityOf(10, listVersionLeft2);
        listVersionLeft2.click();
    }

    public void selectRightVersion1(){
        waitToVisibilityOf(10, inputVersionRight);
        inputVersionRight.click();
        waitToVisibilityOf(10, listVersionRight1);
        listVersionRight1.click();
    }

    public void selectRightVersion2(){
        waitToVisibilityOf(10, inputVersionRight);
        inputVersionRight.click();
        waitToVisibilityOf(10, listVersionRight2);
        listVersionRight2.click();
    }

    /** Find Button Difference*/
    @FindBy(xpath = "//*[text() = ' Difference ']")
    public WebElement btnDifference;

    public void showDifference(){
        waitToBeClickable(10, btnDifference);
        btnDifference.click();
    }

    /** Find Use Version Left*/
    @FindBy(xpath = "//*[@class = 'modal-body']/div/div[1]//*[text() = ' Use Version ']")
    public WebElement btnUseVersionLeft;

    /** Find Use Version Right*/
    @FindBy(xpath = "//*[@class = 'modal-body']/div/div[2]//*[text() = ' Use Version ']")
    public WebElement btnUseVersionRight;

    public void useVersionLeft(){
        waitToBeClickable(10, btnUseVersionLeft);
        btnUseVersionLeft.click();
    }

    public void useVersionRight(){
        waitToBeClickable(10, btnUseVersionRight);
        btnUseVersionRight.click();
    }

    /** Find left table*/
    @FindBy(xpath = "//*[@class = 'modal-body']/div/div[1]//datatable-body//datatable-row-wrapper")
    public List<WebElement> tableLeft;

    /** Find right table*/
    @FindBy(xpath = "//*[@class = 'modal-body']/div/div[2]//datatable-body//datatable-row-wrapper")
    public List<WebElement> tableRight;

    /** Find button exit trip history*/
    @FindBy(xpath = "//*[@class= 'modal-header']//button")
    public WebElement btnCloseHistory;

    public void closeHistory(){
        btnCloseHistory.click();
    }
}
