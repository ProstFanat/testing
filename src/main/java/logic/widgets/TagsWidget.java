package logic.widgets;

import logic.BasePage;
import logic.exceptions.TrackEnsureException;
import logic.report.LogToAllure;
import logic.report.PdfReport;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static logic.webdriver.DriverFactory.getDriver;

public class TagsWidget extends BasePage {
    @FindBy(css = "a[ng-click='vm.addTag()']")
    private WebElement addNewTagButton;
    @FindBy(id = "tag-list-table")
    private WebElement tagListTable;
    @FindBy(css = "input[placeholder='Start typing to find a tag']")
    private WebElement findTagInput;
    @FindBy(css = "input[ng-model='vm.tag.tagName']")
    private WebElement tagNameInputAddNewTagModal;
    @FindBy(css = "input[ng-model='vm.tagName']")
    private WebElement tagNameInputEditTagModal;
    @FindBy(css = "input[value='public']")
    private WebElement publicCheckboxAddNewTagModal;
    @FindBy(css = "input[value='personal']")
    private WebElement personalCheckboxAddNewTagModal;
    @FindBy(css = "input[value='private']")
    private WebElement privateCheckboxAddNewTagModal;
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelBtn;
    @FindBy(xpath = "//button[contains(text(),'Create Tag')]")
    private WebElement createTagButton;
    @FindBy(xpath = "//button[contains(text(),'Update tag')]")
    private WebElement updateTagButton;
    @FindBy(css = "input[placeholder='Tags']")
    private WebElement selectedTagInput;

    public final String PUBLIC_TAG_TYPE = "public";
    public final String PRIVATE_TAG_TYPE = "private";
    public final String PERSONAL_TAG_TYPE = "personal";

    private WebElement findTagInList(String tagName) {
        try {
            List<WebElement> tagsRowList = tagListTable.findElements(By.className("ui-grid-row"));
            return tagsRowList.stream().filter(element -> element.getText().equals(tagName)).findFirst().orElse(null);
        } catch (NoSuchElementException e) {
            log.error(e);
            return null;
        }
    }

    private void checkTagIsCorrectedAdd(String tagName, String tagType) throws TrackEnsureException {
        waitToBeClickable(10, addNewTagButton);
        WebElement tag = findTagInList(tagName);
        if (tag == null)
            throw new TrackEnsureException("Tag not found!");
        try {
            tag.findElement(By.cssSelector("a[ng-click='vm.editTag()']")).click();
            switch (tagType) {
                case PUBLIC_TAG_TYPE:
                    if (!personalCheckboxAddNewTagModal.getAttribute("disabled").equals("true")
                            && !privateCheckboxAddNewTagModal.getAttribute("disabled").equals("true")) {
                        LogToAllure.logToAllure("When the tag is of the Public type, the Private and Personal types are not available.");
                        throw new TrackEnsureException("When the tag is of the Public type, the Private and Personal types are not available.");
                    }
                    if (!publicCheckboxAddNewTagModal.isSelected())
                        throw new TrackEnsureException("Public checkbox is not selected.");
                    break;
                case PERSONAL_TAG_TYPE:
                    if (!personalCheckboxAddNewTagModal.isSelected())
                        throw new TrackEnsureException("Personal checkbox is not selected.");
                    break;
                case PRIVATE_TAG_TYPE:
                    if (!privateCheckboxAddNewTagModal.isSelected())
                        throw new TrackEnsureException("Private checkbox is not selected.");
            }
        } catch (Exception e) {
            log.error(e);
        } finally {
            clickOnElement(cancelBtn);
        }
    }

    public void createTag(String tagName, String tagType) throws TrackEnsureException {
        clickOnElement(addNewTagButton);
        waitToVisibilityOf(10, tagNameInputAddNewTagModal);
        tagNameInputAddNewTagModal.sendKeys(tagName);
        selectTagType(tagType);
        clickOnElement(createTagButton);
        checkTagIsCorrectedAdd(tagName, tagType);
    }

    private void selectTagType(String tagType) {
        switch (tagType) {
            case PUBLIC_TAG_TYPE:
                clickOnElement(publicCheckboxAddNewTagModal);
                break;
            case PERSONAL_TAG_TYPE:
                clickOnElement(personalCheckboxAddNewTagModal);
                break;
            case PRIVATE_TAG_TYPE:
                clickOnElement(privateCheckboxAddNewTagModal);
                break;
        }
    }

    public void editTag(String tagName, String tagType) throws TrackEnsureException {
        waitToBeClickable(10, addNewTagButton);
        WebElement tag = findTagInList(tagName);
        if (tag == null)
            throw new TrackEnsureException("Tag not found!");
        tag.findElement(By.cssSelector("a[ng-click='vm.editTag()']")).click();
        waitToVisibilityOf(10, tagNameInputEditTagModal);
        tagName = String.format("Edit%s", tagName);
        tagNameInputEditTagModal.clear();
        tagNameInputEditTagModal.sendKeys(tagName);
        if (publicCheckboxAddNewTagModal.isSelected()) {
            if (!personalCheckboxAddNewTagModal.getAttribute("disabled").equals("true")
                    && !privateCheckboxAddNewTagModal.getAttribute("disabled").equals("true")) {
                LogToAllure.logToAllure("When the tag is of the Public type, the Private and Personal types are not available.");
                throw new TrackEnsureException("When the tag is of the Public type, the Private and Personal types are not available.");
            }
        } else
            selectTagType(tagType);

        clickOnElement(updateTagButton);

        checkTagIsCorrectedAdd(tagName, tagType);

    }

    public void attachTag(WebElement row, String tagName) throws TrackEnsureException {
        try {
            clickOnElement(row.findElement(By.cssSelector("a[ng-click='vm.attachTag()']")));
            List<WebElement> toAttachTags = driver.findElements(By.cssSelector("li[ng-click='vm.attach(tag)']"));
            WebElement tag = toAttachTags.stream().filter(x -> x.getText().contains(tagName)).findFirst().orElse(null);
            if (tag == null)
                throw new NoSuchElementException("Tag is null");
            else
                clickOnElement(tag);
            clickOnElement(driver.findElement(By.xpath("//button[contains(text(),'Save')]")));
            clickOnElement(driver.findElement(By.xpath("//button[contains(text(),'Save')]")));

        } catch (NoSuchElementException e) {
            throw new TrackEnsureException("No Such Tag!");
        }
    }

    public void findTag(String tagName) throws TrackEnsureException {
        try {
            waitToVisibilityOf(10, selectedTagInput);
            waitToBeClickable(10, selectedTagInput);
            selectedTagInput.sendKeys(tagName);
            selectedTagInput.sendKeys(tagName);
           // driver.findElement(By.xpath("//li[contains(text(),'"+tagName+"')]")).click();
            selectedTagInput.sendKeys(Keys.ENTER);
            Thread.sleep(1500);
        } catch (NoSuchElementException | InterruptedException e) {
            throw new TrackEnsureException("No such tag!");
        }

    }

    public void deleteAllTags() {
        try {
            List<WebElement> deleteTags = getDriver().findElements(By.cssSelector("a[ng-click='vm.deleteTag()']"));
            if (deleteTags.size() != 0)
                while (deleteTags.size() > 0) {
                    try {
                        clickOnElement(deleteTags.get(0));
                        clickOnElement(driver.findElement(By.xpath("//button[contains(text(),'Yes, Do this!')]")));
                        clickOnElement(driver.findElement(By.cssSelector("button[ng-click='growlMessages.deleteMessage(message)']")));
                        if (deleteTags.size() <= 1)
                            break;
                        deleteTags.clear();
                        deleteTags = getDriver().findElements(By.cssSelector("a[ng-click='vm.deleteTag()']"));
                    } catch (Exception e){
                        log.error(e);
                    }
                }
        } catch (NoSuchElementException e) {
            log.error(e);
        }

    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(tagListTable, "Tag List table")) errorsCount++;
        if (!isElementDisplayedOnPage(findTagInput, "Find Tag field")) errorsCount++;
        if (!isElementDisplayedOnPage(addNewTagButton, "Add New Tag button")) errorsCount++;
        else {
            clickOnElement(addNewTagButton);
            waitToVisibilityOf(10, tagNameInputAddNewTagModal);
            PdfReport.createNewSubAnchorNotBold("Add New Tag modal");
            if (!isElementDisplayedOnPage(tagNameInputAddNewTagModal, "Tag Name field in Add New Tag modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(publicCheckboxAddNewTagModal, "Public checkbox in Add New Tag modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(personalCheckboxAddNewTagModal, "Personal checkbox in Add New Tag modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(privateCheckboxAddNewTagModal, "Private checkbox in Add New Tag modal"))
                errorsCount++;
            if (!isElementDisplayedOnPage(createTagButton, "Create Tag button in Add New Tag modal")) errorsCount++;
            if (!isElementDisplayedOnPage(cancelBtn, "Cancel button in Add New Tag modal")) errorsCount++;
            clickOnElement(cancelBtn);
        }
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
