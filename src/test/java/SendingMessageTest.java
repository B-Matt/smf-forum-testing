import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SendingMessageTest
{
    public WebDriver driver;
    public String testURL = "https://gas-locator.com/smf/index.php?action=pm;sa=send";

    public String messageReceiver = "Administrator";
    public String messageSubject = "Test Private Message";
    public String messageText = "password";

    @BeforeMethod
    public void setupTest() {
        //System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    @Test
    public void testSendingForumMessage() throws InterruptedException
    {
        WebElement receiverInputBox = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div/form/div/div/dl/dd[1]/input"));
        receiverInputBox.sendKeys(messageReceiver);

        WebElement subjectInputBox = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div/form/div/div/dl/dd[3]/input"));
        subjectInputBox.sendKeys(messageSubject);

        WebElement messageTextBox = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[3]/div/form/div/div/div[3]/div/div[1]/textarea"));
        messageTextBox.sendKeys(messageText);
        messageTextBox.submit();

        Thread.sleep(500);
        WebElement successSent = driver.findElement(By.id("profile_success"));
        Assert.assertTrue(successSent.getSize().width != 0);
    }

    @AfterMethod
    public void teardownTest()
    {
        driver.quit();
    }
}
