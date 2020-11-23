package logic.widgets.Editor;

import logic.pages.companyProfile.drivers.driverProfile.EditorPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropList  extends EditorPage {
    private final By PATH_TO_DROP_LIST_ITEMS = By.cssSelector("span[class='ng-option-label ng-star-inserted']");
    private static final Logger log = Logger.getLogger(DropList.class);
    public DropList() {
        super();
    }

    public void selectItemInDropList (WebElement dropList, String itemValue){
        waitToBeClickable(10,dropList);
        dropList.click();
        List<WebElement> dutyTypes = driver.findElements(PATH_TO_DROP_LIST_ITEMS);
        for (WebElement dutyType: dutyTypes) {
            if (dutyType.getText().equals(itemValue)){
                log.info("Select item in droplist: "  + itemValue);
                dutyType.click();
                break;
            }
        }
     }

    public void selectFirstItemInDropList (WebElement dropList) {
        waitToBeClickable(20, dropList);
        try {
            dropList.click();
        } catch (ElementClickInterceptedException e) {
            log.error(e);
            selectFirstItemInDropList(dropList);
        }
        List<WebElement> dutyTypes = driver.findElements(PATH_TO_DROP_LIST_ITEMS);
        log.info("Select first item in droplist: " + dutyTypes.get(0).getText());
        dutyTypes.get(0).click();
    }
}
