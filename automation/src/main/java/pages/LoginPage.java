package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import utils.ConfigReader;

public class LoginPage extends BasePage {
	
	  public LoginPage() {
	        super();
	    }

    private By usernameField =By.cssSelector("input[formcontrolname='username']");

    private By passwordField =By.cssSelector("input[formcontrolname='password']");

    private By loginButtonShadowHost =By.cssSelector("mifosx-m3-button.login-submit-button md-filled-button");
    
    private By loginErrorMessage =By.cssSelector("div[matsnackbarlabel]");
    
    private By usernameErrorMessage = By.xpath("//mat-error[contains(normalize-space(.), 'Username is required')]");
    
    private By passwordErrorMessage = By.xpath("//mat-error[contains(normalize-space(.), 'Password is required')]");

  
    
    public void enterUsername(String username) {
        type(usernameField, username);
    }
    
    public void enterPassword(String password) {
        type(passwordField, password);
    }
    
    
    public void clickLogin() {

        WebElement shadowHost = find(loginButtonShadowHost);

        SearchContext shadowRoot = shadowHost.getShadowRoot();

        WebElement loginButton = shadowRoot.findElement(By.cssSelector("button#button"));

        loginButton.click();
    }
    
    public boolean isHomePageDisplayed() {
        return waitForUrlContains("#/home");
    }
    
    public void clickUsernameField() {
        click(usernameField);
    }
    
    public void clickPasswordField() {
        click(passwordField);
    }
    
    public String getLoginErrorMessage() {

        String expectedMessage = "Your session has expired or the credentials are invalid.";

        waitForText(loginErrorMessage, expectedMessage);

        return getText(loginErrorMessage);
    }
    
    public String getUsernameErrorMessage() {
        return getText(usernameErrorMessage);
    }
    
    public String getPasswordErrorMessage() {
        return getText(passwordErrorMessage);
    }
    
    public boolean isLoginButtonEnabled() {

        WebElement shadowHost = find(loginButtonShadowHost);

        SearchContext shadowRoot = shadowHost.getShadowRoot();

        WebElement loginButton =shadowRoot.findElement(By.cssSelector("button#button"));

        return loginButton.isEnabled();
    }
    
 

}