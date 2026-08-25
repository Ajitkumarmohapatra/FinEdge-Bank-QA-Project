package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverManager;

public class BasePage{
	
	protected WebDriverWait wait;
	
	public BasePage() {
	    this.wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10));
	}
	
	   // Find element and wait until it is visible
    protected WebElement find(By locator) {
        return wait.until( ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    // Click element
    protected void click(By locator) {
        find(locator).click();
    }

    // Enter text
    protected void type(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }
    
    // Get element text
    protected String getText(By locator) {
        return find(locator).getText();
    }

    // Check whether element is displayed
    protected boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
 // Wait until element contains expected text
    protected boolean waitForText(By locator, String expectedText) {
        return wait.until(
                ExpectedConditions.textToBePresentInElementLocated(locator,expectedText));
    }
    
    // Wait for element to be visible
    protected void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
 // Wait for URL
    protected boolean waitForUrlContains(String urlFragment) {
        return wait.until(ExpectedConditions.urlContains(urlFragment));
    }
    
    

    // Select dropdown by visible text
    protected void selectByVisibleText(By locator, String text) {
        Select select = new Select(find(locator));
        select.selectByVisibleText(text);
    }

    // Select dropdown by value
    protected void selectByValue(By locator, String value) {
        Select select = new Select(find(locator));
        select.selectByValue(value);
    }

    // Select dropdown by index
    protected void selectByIndex(By locator, int index) {
        Select select = new Select(find(locator));
        select.selectByIndex(index);
    }
    
    
}