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

public class ReadingMessageTest
{
    public WebDriver driver;
    public String testURL = "https://gas-locator.com/smf/index.php?action=pm";
    public String expectedMessage = "Testiranje sustava";

    @BeforeMethod
    public void setupTest() {
        //System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(testURL);
    }

    /**
     * Checks if the {@code string} expectedMessage is in the message list.
     * When WebDriver gets all messages in a list then it sorts message list so that expected message is on top.
     * Then TestNG asserts if first message in list is equals to the expected message.     *
     */
    @Test
    public void testReadingForumMessage() {
        List<WebElement> inboxMessages = driver.findElements(By.className("inner"));
        inboxMessages.sort((o1, o2) -> {
            if (o1.getText().equals(expectedMessage))
                return -1;
            if (o2.getText().equals(expectedMessage))
                return 1;
            return 0;
        });
        Assert.assertEquals(inboxMessages.get(0).getText(), expectedMessage);
    }

    @AfterMethod
    public void teardownTest()
    {
        driver.quit();
    }
}
