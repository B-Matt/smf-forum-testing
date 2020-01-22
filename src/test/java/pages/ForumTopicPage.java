package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Holds web elements and methods for interaction with those elements for forum topic tests.
 */
public class ForumTopicPage
{
    @FindBy(how = How.NAME, using = "b1")
    WebElement boardTitle;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div/div[2]/div[2]/ul/li[1]/a")
    WebElement newPostButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div/form/div[3]/div/dl[1]/dd[1]/input")
    WebElement topicTitleInput;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div/form/div[3]/div/div[4]/div/div[1]/textarea")
    WebElement postTextarea;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div/div[3]/table/tbody/tr/td[3]/div/span/a")
    WebElement boardTopics;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div/div[3]/table/tbody/tr[1]/td[3]/div/span")
    WebElement firstTopicButton;

    public ForumTopicPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        driver.navigate().to("https://gas-locator.com/smf/index.php");
    }

    public void clickBoardTitle()
    {
        boardTitle.click();
    }

    public void clickCreateNewButton()
    {
        newPostButton.click();
    }

    public void setTopicTitle(String title)
    {
        topicTitleInput.sendKeys(title);
    }

    public void setTopicMessage(String topicMessage)
    {
        postTextarea.sendKeys(topicMessage);
    }

    public void submitTopicPost()
    {
        postTextarea.submit();
    }

    public String getBoardTopicTitle()
    {
        return boardTopics.getText();
    }

    public void clickFirstTopic()
    {
        firstTopicButton.click();
    }
}
