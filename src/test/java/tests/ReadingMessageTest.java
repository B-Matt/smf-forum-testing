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

    @Test(description = "Reads private message")
    public void testReadingForumMessage() {
        ForumMessagePage messagePage = PageFactory.initElements(driver, ForumMessagePage.class);

        messagePage.getInboxMessages(expectedMessage);

        Assert.assertEquals(messagePage.getInboxMessage(0), expectedMessage);
    }
}
