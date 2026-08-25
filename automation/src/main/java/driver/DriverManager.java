package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
	 private static WebDriver driver;
	 
	 public static void initializeDriver() {

		    ChromeOptions options = new ChromeOptions();
		    options.setAcceptInsecureCerts(true);

		    driver = new ChromeDriver(options);
		}
	   
	    public static WebDriver getDriver() {
	        return driver;
	    }
	    
	    public static void quitDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }
}
