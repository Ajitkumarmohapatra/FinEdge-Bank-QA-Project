package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.DriverManager;

public class ScreenshotUtil {

    public static String captureScreenshot(String testName) {

        String screenshotPath =System.getProperty("user.dir")+ "/test-output/screenshots/"+ testName + ".png";

        File source =((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

        Path destination = Paths.get(screenshotPath);

        try {
            Files.createDirectories(destination.getParent());
            Files.copy(source.toPath(),destination);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}