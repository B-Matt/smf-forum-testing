package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Holds web elements and methods for interaction with those elements for forum registration tests.
 */
public class ForumRegisterPage
{
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div/div/form/div[3]/fieldset/dl[1]/dd[1]/input")
    WebElement nameInputBox;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div/div/form/div[3]/fieldset/dl[1]/dd[2]/input")
    WebElement emailInputBox;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div/div/form/div[3]/fieldset/dl[2]/dd/input")
    WebElement passwordInputBox;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div/div/form/div[3]/fieldset/dl[3]/dd/input")
    WebElement passwordConfInputBox;

    public ForumRegisterPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        driver.navigate().to("https://gas-locator.com/smf/index.php?action=register");
    }

    public void setUserName(String userName)
    {
        nameInputBox.sendKeys(userName);
    }

    public void setEmail(String email)
    {
        emailInputBox.sendKeys(email);
    }

    public void setPassword(String password)
    {
        passwordInputBox.sendKeys(password);
        passwordConfInputBox.sendKeys(password);
    }

    public void clickRegisterButton()
    {
        passwordConfInputBox.submit();
    }
}
