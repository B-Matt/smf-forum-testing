package tests;

import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.Screenshot;

import java.util.concurrent.TimeUnit;

public class TestBase
{
    public WebDriver driver = null;

    @BeforeSuite
    public void init()
    {
        driver = WebDriverFactory.getInstance(WebDriverFactory.CHROME);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterTest(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            Screenshot screenshot = new Screenshot(driver);
            screenshot.captureScreenshot(result.getMethod().getMethodName());
        }
    }

    @AfterSuite
    public void tearDown()
    {
        if(driver != null) {
            driver.quit();
        }
    }
}
