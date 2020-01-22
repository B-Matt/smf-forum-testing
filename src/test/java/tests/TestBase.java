package tests;

import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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

    @AfterSuite
    public void teardown()
    {
        if(driver != null) {
            driver.quit();
        }
    }
}
