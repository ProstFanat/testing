package logic.webdriver;

import org.openqa.selenium.WebDriver;


public class DriverFactory {
    public static WebDriver getDriver() {
        WebDriver driver = null;
       // String browser = System.getProperty("Browser");
        String browser = "Chrome";
        switch (browser) {
            case "Chrome":
                driver = ChromeWebDriver.getWebDriver();
                break;
            case "Firefox":
                driver = FirefoxWebDriver.getWebDriver();
                break;
        }
        return driver;
    }

}
