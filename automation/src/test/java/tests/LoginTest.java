package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverManager;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

	@Test(priority = 1)
	public void validLoginTest() {

		LoginPage loginPage = new LoginPage();

		loginPage.enterUsername(ConfigReader.getProperty("username"));

		loginPage.enterPassword(ConfigReader.getProperty("password"));

		loginPage.clickLogin();

		Assert.assertTrue(loginPage.isHomePageDisplayed(),"User was not redirected to the Home page after successful login.");
	/*	Assert.assertTrue(
			    false,
			    "Temporary failure to verify screenshot capture."
			);
	*/
	}
	
	   @Test(priority = 2)
	    public void invalidUsernameTest() {

	        LoginPage loginPage = new LoginPage();

	        loginPage.enterUsername("invalidUser123");

	        loginPage.enterPassword(ConfigReader.getProperty("password"));

	        loginPage.clickLogin();

	        Assert.assertEquals(
	                loginPage.getLoginErrorMessage(),
	                "Your session has expired or the credentials are invalid.",
	                "Expected invalid credentials error message was not displayed.");
	    }
	   
	   @Test(priority = 3)
	   public void invalidPasswordTest() {

	       LoginPage loginPage = new LoginPage();

	       loginPage.enterUsername(
	               ConfigReader.getProperty("username")
	       );

	       loginPage.enterPassword("wrongPassword123");

	       loginPage.clickLogin();

	       Assert.assertEquals(
	               loginPage.getLoginErrorMessage(),
	               "Your session has expired or the credentials are invalid.",
	               "Expected invalid credentials error message was not displayed.");
	   }
	   
	   @Test(priority = 4)
	   public void emptyUsernameTest() {

	       LoginPage loginPage = new LoginPage();

	       // Click username field but leave it empty
	       loginPage.clickUsernameField();

	       // Enter valid password
	       loginPage.enterPassword(ConfigReader.getProperty("password"));

	       Assert.assertEquals(
	               loginPage.getUsernameErrorMessage(),
	               "Username is required",
	               "Username required validation message was not displayed.");

	       Assert.assertFalse(
	               loginPage.isLoginButtonEnabled(),
	               "Login button should be disabled when username is empty.");
	   }
	   
	   @Test(priority = 5)
	   public void emptyPasswordTest() {

	       LoginPage loginPage = new LoginPage();

	       // Enter valid username
	       loginPage.enterUsername(
	               ConfigReader.getProperty("username")
	       );

	       // Click password field but leave it empty
	       loginPage.clickPasswordField();

	       // Move focus away from password field
	       loginPage.clickUsernameField();

	       Assert.assertEquals(
	               loginPage.getPasswordErrorMessage(),
	               "Password is required (min length 8)",
	               "Password required validation message was not displayed."
	       );

	       Assert.assertFalse(
	               loginPage.isLoginButtonEnabled(),
	               "Login button should be disabled when password is empty.");
	   }
	   
	   @Test(priority = 6)
	   public void emptyUsernameAndPasswordTest() {

	       LoginPage loginPage = new LoginPage();

	       // Click username field and leave it empty
	       loginPage.clickUsernameField();

	       // Click password field and leave it empty
	       loginPage.clickPasswordField();

	       // Move focus away from password field
	       loginPage.clickUsernameField();

	       Assert.assertEquals(
	               loginPage.getUsernameErrorMessage(),
	               "Username is required",
	               "Username required validation message was not displayed.");
	       

	       Assert.assertEquals(
	               loginPage.getPasswordErrorMessage(),
	               "Password is required (min length 8)",
	               "Password required validation message was not displayed.");
	       

	       Assert.assertFalse(
	               loginPage.isLoginButtonEnabled(),
	               "Login button should be disabled when both fields are empty.");
	   }
	   
	   @Test(priority = 7)
	   public void invalidUsernameAndPasswordTest() {

	       LoginPage loginPage = new LoginPage();

	       loginPage.enterUsername("invalidUser123");
	       loginPage.enterPassword("wrongPassword123");

	       loginPage.clickLogin();

	       Assert.assertEquals(
	               loginPage.getLoginErrorMessage(),
	               "Your session has expired or the credentials are invalid.",
	               "Expected invalid credentials error message was not displayed.");
	       
	   }
	   
	   @Test(priority = 8)
	   public void passwordBelowMinimumLengthTest() {

	       LoginPage loginPage = new LoginPage();

	       loginPage.enterUsername(
	               ConfigReader.getProperty("username")
	       );

	       loginPage.enterPassword("abc");

	       // Move focus away from password field
	       loginPage.clickUsernameField();

	       Assert.assertEquals(
	               loginPage.getPasswordErrorMessage(),
	               "Password is required",
	               "Password validation message was not displayed."
	       );

	       Assert.assertFalse(
	               loginPage.isLoginButtonEnabled(),
	               "Login button should be disabled for a password below minimum length."
	       );
	   }
	   
	   @Test(priority = 9)
	   public void usernameWithLeadingSpacesTest() {

	       LoginPage loginPage = new LoginPage();

	       loginPage.enterUsername("   " + ConfigReader.getProperty("username"));

	       loginPage.enterPassword(ConfigReader.getProperty("password"));
	       

	       loginPage.clickLogin();

	       Assert.assertTrue(
	               DriverManager.getDriver().getCurrentUrl().contains("#/login"),
	               "User should remain on the login page when username contains leading spaces.");
	       
	   }
	   
	   @Test(priority = 10)
	   public void usernameWithTrailingSpacesTest() {

	       LoginPage loginPage = new LoginPage();

	       loginPage.enterUsername(
	               ConfigReader.getProperty("username") + "   "
	       );

	       loginPage.enterPassword(
	               ConfigReader.getProperty("password")
	       );

	       loginPage.clickLogin();

	       Assert.assertTrue(
	               DriverManager.getDriver().getCurrentUrl().contains("#/login"),
	               "User should remain on the login page when username contains trailing spaces."
	       );
	   }
	   
	   @Test(priority = 11)
	   public void passwordWithLeadingSpacesTest() {

	       LoginPage loginPage = new LoginPage();

	       loginPage.enterUsername(
	               ConfigReader.getProperty("username")
	       );

	       loginPage.enterPassword(
	               "   " + ConfigReader.getProperty("password")
	       );

	       loginPage.clickLogin();

	       Assert.assertTrue(
	               DriverManager.getDriver().getCurrentUrl().contains("#/login"),
	               "User should remain on the login page when password contains leading spaces."
	       );
	   }
	   
	   @Test(priority = 12)
	   public void passwordWithTrailingSpacesTest() {

	       LoginPage loginPage = new LoginPage();

	       loginPage.enterUsername(
	               ConfigReader.getProperty("username")
	       );

	       loginPage.enterPassword(
	               ConfigReader.getProperty("password") + "   "
	       );

	       loginPage.clickLogin();

	       Assert.assertTrue(
	               DriverManager.getDriver().getCurrentUrl().contains("#/login"),
	               "User should remain on the login page when password contains trailing spaces."
	       );
	   }
	   
	   @Test(priority = 13)
	   public void usernameWithSpecialCharactersTest() {

	       LoginPage loginPage = new LoginPage();

	       loginPage.enterUsername("@@@###$$$");

	       loginPage.enterPassword(
	               ConfigReader.getProperty("password")
	       );

	       loginPage.clickLogin();

	       Assert.assertTrue(
	               DriverManager.getDriver().getCurrentUrl().contains("#/login"),
	               "User should remain on the login page when username contains invalid special characters."
	       );
	   }
	   
	   
	   @Test(priority = 14)
	   public void passwordWithSpecialCharactersTest() {

	       LoginPage loginPage = new LoginPage();

	       loginPage.enterUsername(
	               ConfigReader.getProperty("username")
	       );

	       loginPage.enterPassword("@@@###$$$");

	       loginPage.clickLogin();

	       Assert.assertTrue(
	               DriverManager.getDriver().getCurrentUrl().contains("#/login"),
	               "User should remain on the login page when password contains invalid special characters."
	       );
	   }
	   
	   @Test(priority = 15)
	   public void usernameWithNumbersOnlyTest() {

	       LoginPage loginPage = new LoginPage();

	       loginPage.enterUsername("123456789");

	       loginPage.enterPassword(
	               ConfigReader.getProperty("password")
	       );

	       loginPage.clickLogin();

	       Assert.assertTrue(
	               DriverManager.getDriver().getCurrentUrl().contains("#/login"),
	               "User should remain on the login page when username contains numbers only."
	       );
	   }
	   
	   @Test(priority = 16)
	   public void invalidServerUrlTest() {

	       DriverManager.getDriver().get(
	               ConfigReader.getProperty("url") + "/invalid-server-url"
	       );

	       String currentUrl = DriverManager.getDriver().getCurrentUrl();

	       System.out.println("Current URL: " + currentUrl);

	       Assert.assertTrue(
	               currentUrl.contains("#/login/invalid-server-url"),
	               "Application did not remain within the login route for the invalid server URL."
	       );
	   }
}