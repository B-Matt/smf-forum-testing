import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PostingInTopicTest
{
    public WebDriver driver;
    public String testURL = "https://gas-locator.com/smf/index.php";

    public String topicTitle = "Welcome to SMF!";
    public String postMessage = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                                "Maecenas a nulla erat. Nam vel rhoncus dui, ornare sagittis lectus. " +
                                "Vivamus tellus tortor, sodales vitae mattis a, scelerisque sit amet leo.";

    @BeforeMethod
    public void setupTest() {
        //System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    /**
     * Checks posting new posts inside given topic.
     */
    @Test
    public void testPostingInTopic() throws InterruptedException
    {
        WebElement boardTitle = driver.findElement(By.name("b1"));
        boardTitle.click();
        Thread.sleep(200);

        WebElement topicTitleLink = driver.findElement(By.id("msg_1"));
        topicTitleLink.click();
        Thread.sleep(200);

        WebElement replyButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[2]/ul/li[1]/a"));
        replyButton.click();
        Thread.sleep(200);

        WebElement postTextarea = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/div[3]/div/div[4]/div/div[1]/textarea"));
        postTextarea.sendKeys(postMessage);
        postTextarea.submit();
        Thread.sleep(200);

        WebElement boardTopics = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[3]/table/tbody/tr/td[3]/div/span/a"));
        Assert.assertEquals(boardTopics.getText(), topicTitle);
    }

    @AfterMethod
    public void teardownTest()
    {
        driver.quit();
    }
}
