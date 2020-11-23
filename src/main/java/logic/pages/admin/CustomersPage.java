package logic.pages.admin;

import logic.BasePage;
import logic.pages.AssetsMapPage;
import logic.report.LogToAllure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CustomersPage extends BasePage {
    @FindBy(css = "input[placeholder='Organization']")
    private WebElement orgNumField;
    public static String loggedOrgId;
    @FindBy (css = "button[ng-click='vm.searchOrganizations()']")
    private WebElement searchOrgBtn;
    public CustomersPage() {
        super();
    }

    @Override
    public boolean isAllRequiredElementsPresent() {
        return false;
    }

    public AssetsMapPage findAndLoginAsCompany(String companyName) {
        waitToVisibilityOf(20, orgNumField);
        log.info("Search for a company by name: " + companyName);
        orgNumField.sendKeys(companyName);
        clickOnElement(searchOrgBtn);
        By pathToCompanyElement = By.cssSelector("div[ng-style='Viewport.rowStyle(rowRenderIndex)']");
        waitToVisibilityOf(20, driver.findElement(pathToCompanyElement));
        List<WebElement> companiesElements = driver.findElements(pathToCompanyElement);
        for (WebElement element : companiesElements) {
            if (element.getText().length()<3)
                continue;
            System.out.println(element.getText());
            WebElement companyNameFromTable = element.findElement(By.cssSelector("p[class='ng-binding']"));
            System.out.println(companyNameFromTable.getText());
                if (companyNameFromTable.getText().toLowerCase().equals(companyName.toLowerCase())) {
                    log.info("Found a company with the same name: " + companyNameFromTable.getText());
                    LogToAllure.logToAllure("Company search and authorization under the company account", companyNameFromTable.getText());
                    loggedOrgId = element.findElement(By.className("ui-grid-coluiGrid-000A")).getText();
                    element.findElement(By.cssSelector("a[uib-tooltip='Login As Organization']")).click();
                }
        }
        return new AssetsMapPage();
    }

}
