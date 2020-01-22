package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForumLoginPage;
import pages.ForumMessagePage;
import tests.TestBase;

public class SendingMessageTest extends TestBase
{
    public String messageReceiver = "Administrator";
    public String messageSubject = "Test Private Message";
    public String messageText = "Lorem ipsum amet.";

    @Test
    public void testSendingForumMessage() throws InterruptedException
    {
        ForumMessagePage messagePage = PageFactory.initElements(driver, ForumMessagePage.class);

        messagePage.clickSendButton();
        Thread.sleep(500);
        messagePage.setReceiver(messageReceiver);
        Thread.sleep(500);
        messagePage.setSubject(messageSubject);
        Thread.sleep(500);
        messagePage.setMessage(messageText);
        Thread.sleep(500);
        messagePage.clickSendMessageButton();

        Thread.sleep(500);
        Assert.assertTrue(messagePage.getSuccessMessage() != 0);
    }
}
