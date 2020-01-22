package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ForumLoginPage
{
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[2]/div[1]/form/input[1]")
    WebElement nameInputBox;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[2]/div[1]/form/input[2]")
    WebElement passwordInputBox;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[2]/div[1]/ul/li[2]/a")
    WebElement showUserPosts;

    public ForumLoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        driver.navigate().to("https://gas-locator.com/smf/");
    }

    public void setNameLogin(String userName)
    {
        nameInputBox.sendKeys(userName);
    }

    public void setPasswordLogin(String password)
    {
        passwordInputBox.sendKeys(password);
    }

    public void clickLoginButton()
    {
        passwordInputBox.submit();
    }

    public WebElement getUserPostsLink()
    {
        return showUserPosts;
    }
}
