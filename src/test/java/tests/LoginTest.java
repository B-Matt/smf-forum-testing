package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForumLoginPage;

public class LoginTest extends TestBase
{
    public String userName = "TestUser";
    public String userPassword = "password";

    @Test
    public void testForumLogin() throws InterruptedException
    {
        ForumLoginPage loginPage = PageFactory.initElements(driver, ForumLoginPage.class);

        loginPage.setNameLogin(userName);
        loginPage.setPasswordLogin(userPassword);
        loginPage.clickLoginButton();

        Thread.sleep(1000);
        Assert.assertTrue(loginPage.getUserPostsLink().getSize().width != 0);
    }
}