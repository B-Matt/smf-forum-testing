import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest
{
    public WebDriver driver;
    public String testURL = "https://gas-locator.com/smf/";

    public String userName = "TestUser";
    public String userPassword = "password";

    @BeforeMethod
    public void setupTest() {
        //System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    @Test
    public void testForumLogin() throws InterruptedException
    {
        WebElement nameInputBox = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[1]/form/input[1]"));
        nameInputBox.sendKeys(userName);

        WebElement passwordInputBox = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[1]/form/input[2]"));
        passwordInputBox.sendKeys(userPassword);
        passwordInputBox.submit();

        Thread.sleep(1000);
        WebElement showUserPosts = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[1]/ul/li[2]/a"));
        Assert.assertTrue(showUserPosts.getSize().width != 0);
    }

    @AfterMethod
    public void teardownTest()
    {
        driver.quit();
    }
}