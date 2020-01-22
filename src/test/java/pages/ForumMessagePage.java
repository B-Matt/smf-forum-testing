package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Holds web elements and methods for interaction with those elements for forum private message tests.
 */
public class ForumMessagePage
{
    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div/div[2]/ul/li[1]/a/span")
    WebElement messagesButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div/div[2]/ul/li[1]/ul/li[1]/a/span")
    WebElement sendMessageButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div/div/div[3]/div/form/div/div/dl/dd[1]/input")
    WebElement receiverInputBox;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div/div/div[3]/div/form/div/div/dl/dd[3]/input")
    WebElement subjectInputBox;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div/div/div[3]/div/form/div/div/div[3]/div/div[1]/textarea")
    WebElement messageTextBox;

    @FindBy(how = How.ID, using = "profile_success")
    WebElement successMsg;

    @FindBys({
        @FindBy(className = "inner")
    })
    List<WebElement> inboxMessages;

    public ForumMessagePage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        driver.navigate().to("https://gas-locator.com/smf/index.php?action=pm");
    }

    public void clickSendButton()
    {
        messagesButton.click();
        sendMessageButton.click();
    }

    public void setReceiver(String receiver)
    {
        receiverInputBox.sendKeys(receiver);
    }

    public void setSubject(String subject)
    {
        subjectInputBox.clear();
        subjectInputBox.sendKeys(subject);
    }

    public void setMessage(String message)
    {
        messageTextBox.sendKeys(message);
    }

    public void clickSendMessageButton()
    {
        messageTextBox.submit();
    }

    public int getSuccessMessage()
    {
        return successMsg.getSize().width;
    }

    public void getInboxMessages(String expectedMessage)
    {
        inboxMessages.sort((o1, o2) -> {
            if (o1.getText().equals(expectedMessage))
                return -1;
            if (o2.getText().equals(expectedMessage))
                return 1;
            return 0;
        });
    }

    public String getInboxMessage(int index)
    {
        return inboxMessages.get(index).getText();
    }
}
