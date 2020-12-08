package logic.webdriver;

import logic.variables.TestConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class ChromeWebDriver {


    static WebDriver driver = null;

    public static WebDriver getWebDriver(){
        if(driver!=null) return driver;
        return getDriver();
    }

    private static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
       // chromePrefs.put("download.default_directory", TestConstant.PATH_TO_DOWNLOADS_FOLDER);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        String headless = "false";
        //String headless = System.getProperty("headless");
        if (headless.equals("true")) {
            options.addArguments("headless");
        }
        options.addArguments("window-size=1920,1080");
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
        options.setCapability("goog:loggingPrefs", logPrefs);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
        return driver;
    }
}
