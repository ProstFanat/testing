package logic.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class FirefoxWebDriver {


    static WebDriver driver = null;

    public static WebDriver getWebDriver() {
        if (driver != null) return driver;
        return getDriver();
    }

    private static WebDriver getDriver() {
       /* FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--no-sandbox");*/
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        // FirefoxOptions firefoxOptions = new FirefoxOptions();
        // firefoxOptions.setBinary(firefoxBinary);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
