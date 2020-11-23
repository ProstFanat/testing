package logic.pages.companyProfile.drivers.driverProfile;

import logic.pages.companyProfile.drivers.ProfilesTab;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsPage extends ProfilesTab {
    @FindBy (xpath = "//div[2]/div/div[1]/div[8]/div/div[2]/p")
    private WebElement homeTerminalTimeZoneValue;
    @FindBy (xpath = "//div[2]/div/div[1]/div[6]/div/div[2]/p")
    private WebElement loginNameValue;

    public String parseTimeZoneFromDriverInformation(){
        waitToVisibilityOf(10, homeTerminalTimeZoneValue);
        String timezone = homeTerminalTimeZoneValue.getText();
        log.info("Parsed Home Terminal Time Zone from Details page: " + timezone);
        return timezone;
    }
    public String parseDriverLoginName(){
        waitToVisibilityOf(10, loginNameValue);
        String loginName = loginNameValue.getText();
        log.info("Parsed Login Name from Details page: " + loginName);
        return loginName;
    }
}
