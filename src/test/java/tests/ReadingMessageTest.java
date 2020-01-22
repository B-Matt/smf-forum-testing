package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForumLoginPage;
import pages.ForumMessagePage;

public class ReadingMessageTest extends TestBase
{
    public String expectedMessage = "Testiranje sustava";

    /**
     * Checks if the {@code string} expectedMessage is in the message list.
     * When WebDriver gets all messages in a list then it sorts message list so that expected message is on top.
     * Then TestNG asserts if first message in list is equals to the expected message.     *
     */
    @Test
    public void testReadingForumMessage() throws InterruptedException {
        ForumMessagePage messagePage = PageFactory.initElements(driver, ForumMessagePage.class);

        messagePage.getInboxMessages(expectedMessage);

        Assert.assertEquals(messagePage.getInboxMessage(0), expectedMessage);
    }
}
