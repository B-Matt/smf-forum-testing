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
    public String testURL = "https://forum.cityofangels-roleplay.com/";

    public String userName = "Username";
    public String userPassword = "password";

    @BeforeMethod
    public void setupTest() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
        Thread.sleep(6000);                             // Compesate for Cloudflare Protection
    }

    @Test
    public void testForumLogin() throws InterruptedException
    {
        WebElement nameInputBox = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/form/input[1]"));
        nameInputBox.sendKeys(userName);

        WebElement passwordInputBox = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/form/input[2]"));
        passwordInputBox.sendKeys(userPassword);
        passwordInputBox.submit();

        Thread.sleep(2000);
        WebElement profileAvatar = driver.findElement(By.className("avatars"));
        Assert.assertTrue(profileAvatar.getSize().width != 0);
    }

    @AfterMethod
    public void teardownTest()
    {
        driver.quit();
    }
}