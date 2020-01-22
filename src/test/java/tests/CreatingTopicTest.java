package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForumLoginPage;
import pages.ForumTopicPage;

public class CreatingTopicTest extends TestBase
{
    public String topicTitle = "Lorem ipsum dolor";
    public String topicMessage = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
            "Maecenas a nulla erat. Nam vel rhoncus dui, ornare sagittis lectus. " +
            "Vivamus tellus tortor, sodales vitae mattis a, scelerisque sit amet leo.";

    /**
     * Checks creating new topics in forum.
     */
    @Test
    public void testPostingInTopic() throws InterruptedException
    {
        ForumTopicPage topicPage = PageFactory.initElements(driver, ForumTopicPage.class);

        topicPage.clickBoardTitle();
        Thread.sleep(500);
        topicPage.clickCreateNewButton();
        Thread.sleep(500);
        topicPage.setTopicTitle(topicTitle);
        Thread.sleep(500);
        topicPage.setTopicMessage(topicMessage);
        Thread.sleep(500);
        topicPage.submitTopicPost();
        Thread.sleep(500);

        Assert.assertEquals(topicPage.getBoardTopicTitle(), topicTitle);
    }
}
