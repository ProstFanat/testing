package logic.pages.companyProfile.drivers.driverInfo;

import logic.report.LogToAllure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DocumentTab  extends EditDriverProfilePage{
    //@FindBy (xpath = "//button[contains(text(),'Add Document')]")
    @FindBy(xpath = "/html/body/div[1]/div/div/div/form/div[1]/div[30]/div/div/div[1]/div/div[1]/div/button")
    private WebElement addDocumentBtn;
    @FindBy (css = "oi-select[ng-model='vm.document.documentTypeId']")
    private WebElement documentTypeSelector;
    @FindBy (id = "document-number")
    private WebElement documentNumberField;
    @FindBy (name = "issuedDate")
    private WebElement issuedDateField;
    @FindBy (name = "expiryDate")
    private WebElement expiryDateField;
    @FindBy(xpath = "//div[1]/div/div/span/button")
    private WebElement issuedDateCalendarBtn;
    @FindBy(xpath = "//div[2]/div/div/span/button")
    private WebElement expiryDateCalendarBtn;
    @FindBy (id = "document-description")
    private WebElement documentDescriptionField;
    @FindBy (css = "button[ng-if='vm.document.isAdd']")
    private WebElement addBtn;
    @FindBy (css = "button[ng-click='vm.cancel()']")
    private WebElement CancelBtn;
    @FindBy (css = "li[ng-model='vm.droppedFile']")
    private WebElement addNewFileBtn;
    @FindBy (css = "button[ng-click='vm.openAddDocumentTypeModal()']")
    private WebElement addNewDocumentTypeBtn;
    @FindBy (css = "input[ng-model='vm.documentType']")
    private WebElement newDocumentNameTypeField;
    @FindBy (css = "input[ng-model='vm.tripDocument']")
    private WebElement tripDocumentCheckBox;


    public DocumentTab() {
        super();
    }
    public DocumentTab clickOnAddDocument(){
        waitToVisibilityOf(10, addDocumentBtn);
        addDocumentBtn.click();
        return this;
    }

    public DocumentTab selectDocumentType(){
        waitToVisibilityOf(10, documentTypeSelector);
        documentTypeSelector.click();
        WebElement item = driver.findElement(By.xpath("//li[contains(text(),'Driver License')]"));
        waitToVisibilityOf(10, item);
        item.click();
       return this;
    }

    public DocumentTab inputDocumentNumber(String documentNumber){
        waitToVisibilityOf(10, documentNumberField);
        documentNumberField.sendKeys(documentNumber);
        return this;
    }
    public DocumentTab clickOnAdd(){
        waitToBeClickable(10, addBtn);
        addBtn.click();
        return this;
    }

    public DocumentTab deleteDocument(){
        driver.findElement(By.cssSelector("div[row-render-index='rowRenderIndex']")).findElement(By.className("fa-eye")).click();
        return this;
    }

}
