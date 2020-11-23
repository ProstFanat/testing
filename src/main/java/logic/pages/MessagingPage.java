package logic.pages;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MessagingPage extends BasePage {
    @FindBy(tagName = "h2")
    private WebElement pageHeader;
    @FindBy (className = "messages-sidebar-first")
    private WebElement sessionListSidebar;
    @FindBy (className = "messages-sidebar-second")
    private WebElement chatsListSidebar;
    @FindBy (css = "button[ng-click='vm.openNewSession()']")
    private WebElement newSessionButton;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(pageHeader, "Page header")) errorsCount++;
        if (!checkTextOnElement(pageHeader, "Messages")) errorsCount++;
        if (!isElementDisplayedOnPage(sessionListSidebar, "List of Session block")) errorsCount++;
        if (!isElementDisplayedOnPage(chatsListSidebar, "List of Chats block")) errorsCount++;
        if (!isElementDisplayedOnPage(newSessionButton, "New Session button")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;    }
}
