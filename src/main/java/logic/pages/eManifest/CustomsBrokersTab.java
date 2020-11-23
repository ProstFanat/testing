package logic.pages.eManifest;

import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomsBrokersTab extends EManifestPage {
    @FindBy(css = "input[ng-model='vm.filter']")
    private WebElement filterField;
    @FindBy(css = "button[ng-click='vm.applyFilter(vm.filter)']")
    private WebElement findButton;
    @FindBy(css = "div[ui-grid='vm.uiGridOption']")
    private WebElement brokersGrid;
    @FindBy(css = "button[ng-click='vm.addBroker()']")
    private WebElement createBrokerButton;
    @FindBy(css = "input[ng-model='vm.broker.broker']")
    private WebElement brokerNameFieldAddNewBrokerModal;
    @FindBy(css = "input[ng-model='vm.broker.phone']")
    private WebElement phoneFieldAddNewBrokerModal;
    @FindBy(css = "input[ng-model='vm.broker.email']")
    private WebElement emailFieldAddNewBrokerModal;
    @FindBy(css = "input[ng-model='vm.broker.fax']")
    private WebElement faxFieldAddNewBrokerModal;
    @FindBy(css = "div[ng-model='vm.broker.brokerType']")
    private WebElement brokerTypeFieldAddNewBrokerModal;
    @FindBy(css = "button[ng-click='vm.cancel()']")
    private WebElement cancelButtonAddNewBrokerModal;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(10, filterField);
        if (!isElementDisplayedOnPage(filterField, "Filter field")) errorsCount++;
        if (!isElementDisplayedOnPage(findButton, "Find button")) errorsCount++;
        if (!isElementDisplayedOnPage(brokersGrid, "Brokers grid")) errorsCount++;
        if (!isElementDisplayedOnPage(createBrokerButton, "Create Broker button")) errorsCount++;
        else {
            clickOnElement(createBrokerButton);
            PdfReport.createNewSubAnchorNotBold("Add New Broker modal");
            waitToVisibilityOf(10, brokerNameFieldAddNewBrokerModal);
            if (!isElementDisplayedOnPage(brokerNameFieldAddNewBrokerModal, "Broker Name field in Add New Broker modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(phoneFieldAddNewBrokerModal, "Phone field in Add New Broker modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(emailFieldAddNewBrokerModal, "Email field in Add New Broker modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(faxFieldAddNewBrokerModal, "Fax field in Add New Broker modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(brokerTypeFieldAddNewBrokerModal, "Broker Type field in Add New Broker modal"))
                errorsCount++;
            clickOnElement(cancelButtonAddNewBrokerModal);
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
