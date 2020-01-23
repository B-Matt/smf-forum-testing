package drivers;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory
{
    /* Browsers constants */
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String OPERA = "opera";
    public static final String INTERNET_EXPLORER = "ie";
    public static final String SAFARI = "safari";

    /* Platform constants */
    public static final String WINDOWS = "windows";
    public static final String XP = "xp";
    public static final String VISTA = "vista";
    public static final String MAC = "mac";
    public static final String LINUX = "linux";

    private WebDriverFactory() {}

    /*
     * Factory method to return a WebDriver instance given the browser to hit
     *
     * @param browser : String representing the local browser to hit
     *
     * @param username : username for BASIC authentication on the page to test
     *
     * @param password : password for BASIC authentication on the page to test
     *
     * @return WebDriver instance
     */
    public static WebDriver getInstance(String browser)
    {
        WebDriver webDriver = null;
        if (CHROME.equals(browser)) {
            setChromeDriver();
            webDriver = new ChromeDriver();
        }
        else if (FIREFOX.equals(browser)) {
            setFirefoxDriver();
            webDriver = new FirefoxDriver();
        }
        else if (INTERNET_EXPLORER.equals(browser)) {
            isSupportedPlatform(browser);
            webDriver = new InternetExplorerDriver();
        }
        else if (OPERA.equals(browser)) {
            //setOperaDriver();
            webDriver = new OperaDriver();
        }
        else if (SAFARI.equals(browser)) {
            isSupportedPlatform(browser);
            webDriver = new SafariDriver();
        }
        return webDriver;
    }

    /*
     * Helper method to set version and platform for a specific browser
     *
     * @param capability : DesiredCapabilities object coming from the selected
     * browser
     *
     * @param version : browser version
     *
     * @param platform : browser platform
     *
     * @return DesiredCapabilities
     */
    private static void setVersionAndPlatform(DesiredCapabilities capability, String version, String platform)
    {
        if (MAC.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.MAC);
        }
        else if (LINUX.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.LINUX);
        }
        else if (XP.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.XP);
        }
        else if (VISTA.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.VISTA);
        }
        else if (WINDOWS.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.WINDOWS);
        }

        if (version != null) {
            capability.setVersion(version);
        }
    }

    /*
     * Helper method to set ChromeDriver location into the right system property
     */
    private static void setChromeDriver()
    {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/java/drivers/chromedriver.exe");
    }

    /*
     * Helper method to set FirefoxDriver location into the right system property
     */
    private static void setFirefoxDriver()
    {
        System.setProperty("webdriver.gecko.driver",
                System.getProperty("user.dir") + "/src/test/java/drivers/geckodriver.exe");
    }

    /*
     * Helper method to set OperaDriver location into the right system property
     */
    private static void setOperaDriver()
    {
        System.setProperty("webdriver.opera.driver",
                System.getProperty("user.dir") + "/src/test/java/drivers/operadriver.exe");
    }

    private static void isSupportedPlatform(String browser)
    {
        boolean is_supported = true;
        Platform current = Platform.getCurrent();
        if (INTERNET_EXPLORER.equals(browser)) {
            is_supported = Platform.WINDOWS.is(current);
        }
        else if (SAFARI.equals(browser)) {
            is_supported = Platform.MAC.is(current) || Platform.WINDOWS.is(current);
        }
        assert is_supported : "Platform is not supported by " + browser.toUpperCase() + " browser!";
    }
}