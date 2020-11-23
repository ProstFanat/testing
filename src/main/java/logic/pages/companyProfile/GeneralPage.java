package logic.pages.companyProfile;

import logic.BasePage;
import logic.report.PdfReport;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class GeneralPage extends BasePage {
    @FindBy(id = "cp-general-map-container")
    private WebElement mapContainer;
    @FindBy(xpath = "//cp-general-tab/div/div[2]/div[1]/div[2]/span")
    private WebElement orgNameField;
    @FindBy(xpath = "//cp-general-tab/div/div[2]/div[2]/div[2]/span")
    private WebElement addressField;
    @FindBy(xpath = "//cp-general-tab/div/div[2]/div[3]/div[2]/span")
    private WebElement countryField;
    @FindBy(xpath = "//cp-general-tab/div/div[2]/div[4]/div[2]/span")
    private WebElement regionField;
    @FindBy(xpath = "//cp-general-tab/div/div[2]/div[5]/div[2]/span")
    private WebElement cityField;
    @FindBy(xpath = "//cp-general-tab/div/div[2]/div[6]/div[2]/span")
    private WebElement postalCodeField;
    @FindBy(id = "upload-logo")
    private WebElement uploadFileField;

    public void checkCompanyGeneralInfoAfterRegistration(String orgName, String address, String county, String city, String postalCode) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.textToBe(By.xpath("//cp-general-tab/div/div[2]/div[1]/div[2]/span"), orgName));
        log.info("CHECK: Org Name on General Page must be equals: " + orgNameField.getText() + " | " + orgName);
        assertEquals(orgNameField.getText(), orgName);
        log.info("CHECK: Address on General Page  " + addressField.getText());
        assertFalse(addressField.getText().isEmpty());
        log.info("CHECK: Country on General Page must be equals: " + countryField.getText() + " | " + county);
        assertEquals(countryField.getText(), county);
        log.info("CHECK: City on General Page must be equals: " + cityField.getText() + " | " + city);
        assertEquals(cityField.getText(), city);
        log.info("CHECK: Postal Code on General Page : " + postalCodeField.getText());
        assertFalse(postalCodeField.getText().isEmpty());
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        int errorsCount = 0;
        if (!isElementDisplayedOnPage(orgNameField, "Organization Name field")) errorsCount++;
        if (!isElementDisplayedOnPage(addressField, "Address field")) errorsCount++;
        if (!isElementDisplayedOnPage(countryField, "Country field")) errorsCount++;
        if (!isElementDisplayedOnPage(regionField, "Region field")) errorsCount++;
        if (!isElementDisplayedOnPage(cityField, "City field")) errorsCount++;
        if (!isElementDisplayedOnPage(postalCodeField, "Postal Code field")) errorsCount++;
        if (!isElementDisplayedOnPage(mapContainer, "Map container")) errorsCount++;
        PdfReport.writeJsLogFromWebDriver();
        return errorsCount == 0;
    }
}
