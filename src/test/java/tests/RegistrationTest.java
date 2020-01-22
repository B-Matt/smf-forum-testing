package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForumLoginPage;
import pages.ForumRegisterPage;

public class RegistrationTest extends TestBase
{
    private String userName = "TestUser15";
    private String userMail = "yesefif75445@etopmail.com";
    private String userPassword = "password";

    /**
     * Checks users ability to register new account.
     */
    @Test
    public void testForumRegistration() throws InterruptedException
    {
        ForumLoginPage loginPage = PageFactory.initElements(driver, ForumLoginPage.class);
        ForumRegisterPage registerPage = PageFactory.initElements(driver, ForumRegisterPage.class);

        registerPage.setUserName(userName);
        registerPage.setEmail(userMail);
        registerPage.setPassword(userPassword);
        registerPage.clickRegisterButton();

        //Thread.sleep(1000);
        Assert.assertTrue(loginPage.getUserPostsLink().getSize().width != 0);
    }
}
