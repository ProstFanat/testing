package logic.pages.companyProfile.userManagement;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserManagementPage extends BasePage {
    @FindBy(linkText = "Users")
    private WebElement usersTab;
    @FindBy(linkText = "Groups")
    private WebElement groupsTab;
    @FindBy(tagName = "h2")
    private WebElement pageHeader;

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        waitToVisibilityOf(60, pageHeader);
        if (!isElementDisplayedOnPage(pageHeader, "Page header")) errorsCount++;

        PdfReport.createNewSubAnchorBold("Users tab");
        if (!isElementDisplayedOnPage(usersTab, "Users tab")) errorsCount++;
        else {
            if (!goToUsersTab().isAllRequiredElementsPresent()) errorsCount++;
        }

        PdfReport.createNewSubAnchorBold("Groups tab");
        if (!isElementDisplayedOnPage(groupsTab, "Groups tab")) errorsCount++;
        else {
            if (!goToGroupsTab().isAllRequiredElementsPresent()) errorsCount++;
        }
        return errorsCount == 0;
    }

    public GroupsTab goToGroupsTab() {
        clickOnElement(groupsTab);
        return new GroupsTab();
    }

    public UsersTab goToUsersTab() {
        clickOnElement(usersTab);
        return new UsersTab();
    }
}
