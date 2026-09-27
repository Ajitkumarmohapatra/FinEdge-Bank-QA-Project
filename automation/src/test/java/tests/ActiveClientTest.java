package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ActiveClientPage;
import pages.LoginPage;
import utils.ConfigReader;

public class ActiveClientTest extends BaseTest {

    private LoginPage loginPage;
    private ActiveClientPage activeClientPage;

    @BeforeMethod
    public void initializePages() {

        loginPage = new LoginPage();
        activeClientPage = new ActiveClientPage();
    }

    @Test(priority=1)
    public void openRecentClientTest() {

        // Step 1: Login
        loginPage.enterUsername(
                ConfigReader.getProperty("username")
        );

        loginPage.enterPassword(
                ConfigReader.getProperty("password")
        );

        loginPage.clickLogin();

        // Step 2: Verify Home page
        Assert.assertTrue(
                loginPage.isHomePageDisplayed(),
                "Home page was not displayed after login."
        );

        // Step 3: Close Mifos warning
        activeClientPage.closeWarning();

        // Step 4: Navigate Institution → Clients
        activeClientPage.navigateToClients();

        // Step 5: Get recent clients dynamically
        List<String> names =
                activeClientPage.getRecentClientNames();

        Assert.assertFalse(
                names.isEmpty(),
                "No client names found on Clients page."
        );

        // Step 6: Select first client dynamically
        String clientName = names.get(0);

        System.out.println(
                "Selected Client: " + clientName
        );

        // Step 7: Open client profile
        activeClientPage.clickClient(clientName);
    }
    
    @Test(priority=2)
    public void activatePendingClientTest() {

        // Step 1: Login
        loginPage.enterUsername(
                ConfigReader.getProperty("username")
        );

        loginPage.enterPassword(
                ConfigReader.getProperty("password")
        );

        loginPage.clickLogin();

        // Step 2: Verify Home page
        Assert.assertTrue(
                loginPage.isHomePageDisplayed(),
                "Home page was not displayed after login."
        );

        // Step 3: Close Mifos warning
        activeClientPage.closeWarning();

        // Step 4: Navigate Institution → Clients
        activeClientPage.navigateToClients();

        // Step 5: Find a PENDING client dynamically
        String clientName =
                activeClientPage.getPendingClientName();

        System.out.println(
                "Selected Pending Client: " + clientName
        );

        // Step 6: Open client profile
        activeClientPage.clickClient(clientName);

        // Step 7: Open profile actions menu
        activeClientPage.clickActionsMenu();

        // Step 8: Click Actions
        activeClientPage.clickActions();

        // Step 9: Click Activate
        activeClientPage.clickActivate();
        
      
        // click calender icon 
        activeClientPage.clickActivationCalendar();
        
     // Step 11: Select today's date dynamically
        activeClientPage.selectToday();

        // Step 12: Confirm activation
        activeClientPage.clickConfirm();
        
        activeClientPage.navigateToClients();

        boolean active = activeClientPage.isClientActive(clientName);

        Assert.assertTrue(
            active,
            "Client '" + clientName + "' was not activated successfully."
        );
    }
}