package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Captures test screenshot and writes it to the hard drive.
 * Screenshot it written in this folder: "project/target/screens".
 */
public class Screenshot
{
    private final String SCREENSHOTS_FOLDER = "target/screens";
    private WebDriver webDriver;
    private int screenshotIndex = 0;

    public Screenshot(WebDriver driver)
    {
        webDriver = driver;
    }

    /**
     * Captures screenshot when test fails and writes it to the hard drive.
     */
    public void captureScreenshot(String fileName)
    {
        String filePath = String.format("%s/%s", System.getProperty("user.dir"), SCREENSHOTS_FOLDER);
        File fileDir = new File(filePath);
        fileDir.mkdirs();
        File screenPath = new File(fileDir, getScreenName(fileName));

        TakesScreenshot takesScreenshot = ((TakesScreenshot) webDriver);
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        System.out.println("Taken screen saved: " + screenPath);
        writeScreenshot(screenPath, screenshot);
    }

    /**
     * Writes screenshot of test to the hard drive.
     * @param path Path where to save taken screenshot.
     * @param screenshot Taken screenshot image.
     */
    private void writeScreenshot(File path, byte[] screenshot)
    {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(path);
            outputStream.write(screenshot);
            outputStream.flush();
        } catch (IOException e) {
            System.out.println("Error saving screenshot to: " + path.getAbsolutePath());
        } finally {
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    System.out.println("Can't close stream.");
                }
            }
        }
    }

    /**
     * Gets test screenshot name in this format: "fileName-test-dd-MM-yyyy-HH-mm-ss (eg. logintest-test-23-01-2020-08-35-30-1)"
     * @return Formated screenshot name.
     */
    private String getScreenName(String fileName)
    {
        screenshotIndex++;
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        return String.format("%s-test-%s-%d.png", fileName, dateFormat.format(new Date()), screenshotIndex);
    }
}
