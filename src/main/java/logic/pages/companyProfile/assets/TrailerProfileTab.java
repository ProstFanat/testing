package logic.pages.companyProfile.assets;

import logic.dbConnection.entity.TrailerProfile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrailerProfileTab extends AssetsPage {
    @Override
    public boolean isAllRequiredElementsPresent() {
        return super.isAllRequiredElementsPresent();
    }

    @FindBy(css = "span[is-permitted-for='update.ASSETS']")
    private WebElement editTrailerProfileBtn;

    public TrailerProfileTab() {
        super();
    }

    public AddAndEditTrailerModal openEditTrailerProfile(TrailerProfile trailerProfile) {
        //waitToVisibilityOf(20,editTrailerProfileBtn);
        editTrailerProfileBtn.click();
        return new AddAndEditTrailerModal(trailerProfile);
    }
}
