package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.DriverManager;
import utils.ConfigReader;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverManager.initializeDriver();

        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}