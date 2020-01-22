package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForumLoginPage;

public class LoginTest extends TestBase
{
    public String userName = "TestUser";
    public String userPassword = "password";

    /**
     * Checks users ability to login into account.
     */
    @Test
    public void testForumLogin() throws InterruptedException
    {
        ForumLoginPage loginPage = PageFactory.initElements(driver, ForumLoginPage.class);

        loginPage.setNameLogin(userName);
        Thread.sleep(500);
        loginPage.setPasswordLogin(userPassword);
        Thread.sleep(500);
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.getUserPostsLink().getSize().width != 0);
    }
}