package logic.variables;


import io.qameta.allure.Attachment;
import logic.report.PdfReport;
import logic.webdriver.ChromeWebDriver;
import logic.webdriver.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    private static final Logger log = Logger.getLogger(Listener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("********Test start: " + iTestResult.getMethod().getMethodName() + "********");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("++++++TEST PASSED: " + iTestResult.getMethod().getMethodName() + "+++++++");
        //PdfReport.writeTestResult("PASSED");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("------TEST FAILED: " + iTestResult.getMethod().getMethodName() + "-------");
        //PdfReport.writeTestResult("FAILED");
        ITestContext context = iTestResult.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");
//        saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        DriverFactory.getDriver().navigate().refresh();

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("********Test Skipped: " + iTestResult.getMethod().getMethodName() + "********");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

}
