package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForumLoginPage;
import pages.ForumTopicPage;

public class PostingInTopicTest extends TestBase
{
    public String topicTitle = "Welcome to SMF!"; // ima error tu s krivim titleom
    
    public String postMessage = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                                "Maecenas a nulla erat. Nam vel rhoncus dui, ornare sagittis lectus. " +
                                "Vivamus tellus tortor, sodales vitae mattis a, scelerisque sit amet leo.";

    /**
     * Checks posting new posts inside given topic.
     */
    @Test
    public void testPostingInTopic() throws InterruptedException
    {
        ForumTopicPage topicPage = PageFactory.initElements(driver, ForumTopicPage.class);

        topicPage.clickBoardTitle();
        Thread.sleep(200);

        topicPage.clickFirstTopic();
        Thread.sleep(200);

        topicPage.clickCreateNewButton();
        Thread.sleep(200);

        topicPage.setTopicMessage(postMessage);
        topicPage.submitTopicPost();
        Thread.sleep(200);

        Assert.assertEquals(topicPage.getBoardTopicTitle(), topicTitle);
    }
}
