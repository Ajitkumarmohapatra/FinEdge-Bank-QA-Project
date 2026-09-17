package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CreateClientPage;
import pages.LoginPage;
import utils.ConfigReader;

public class CreateClientTest extends BaseTest {

    private LoginPage loginPage;
    private CreateClientPage createClientPage;
    
    
    // ==============================
    // Generate Unique Test Data
    // ==============================

    String uniqueId = String.valueOf(System.currentTimeMillis());
    String shortId = uniqueId.substring(uniqueId.length() - 6);

    String firstName = "Ajit" + shortId;
    String middleName = "Kumar";
    String lastName = "Test" + shortId;

    String mobileNumber ="9" + uniqueId.substring(uniqueId.length() - 9);
            

    String email = "ajit.test." + shortId + "@gmail.com";
           

    String externalId = "EXT" + shortId;

    // =========================================================
    // Login before every Create Client test
    // =========================================================

    @BeforeMethod
    public void login() {

        loginPage = new LoginPage();

        loginPage.enterUsername(ConfigReader.getProperty("username"));
                

        loginPage.enterPassword(ConfigReader.getProperty("password"));
                

        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isHomePageDisplayed(),"User was not redirected to the Home page after login.");
                

        createClientPage = new CreateClientPage();
    }


    // =========================================================
    // Existing Create Client positive test
    // =========================================================

    @Test(priority = 1)
    public void createClientTest() {

       


        // ==============================
        // Close Mifos warning popup
        // ==============================

        createClientPage.closeWarning();


        // ==============================
        // Navigation
        // ==============================

        createClientPage.clickInstitution();

        createClientPage.clickClients();

        createClientPage.clickCreateClient();


        // ==============================
        // General Details
        // ==============================

        createClientPage.selectOffice("Mumbai Branch");

        createClientPage.selectLegalForm("Person");

        createClientPage.enterExternalId(externalId);

        createClientPage.enterFirstName(firstName);

        createClientPage.enterMiddleName(middleName);

        createClientPage.enterLastName(lastName);

        createClientPage.selectGender("Male");

        createClientPage.enterMobileNumber(mobileNumber);

        createClientPage.enterEmail(email);

        createClientPage.selectClientType("Business");

        createClientPage.selectClientClassification("Regular");


        // ==============================
        // Checkboxes
        // ==============================

        createClientPage.selectActive();

        createClientPage.selectOpenSavingsAccount();

        createClientPage.selectSavingsProduct(
                "Smart Savings Account");


        // ==============================
        // Next
        // ==============================

        createClientPage.clickNext();


        // ==============================
        // Family Members
        // ==============================

        createClientPage.clickFamilyMembersNext();


        // ==============================
        // Preview Verification
        // ==============================

        System.out.println(
                "Client Name: "
                + createClientPage.getPreviewClientName());

        System.out.println(
                "Office: "
                + createClientPage.getPreviewOffice());

        System.out.println(
                "Legal Form: "
                + createClientPage.getPreviewLegalForm());

        System.out.println(
                "Mobile No: "
                + createClientPage.getPreviewMobileNumber());

        System.out.println(
                "Email Address: "
                + createClientPage.getPreviewEmail());

        System.out.println(
                "Client Type: "
                + createClientPage.getPreviewClientType());

        System.out.println(
                "Client Classification: "
                + createClientPage.getPreviewClientClassification());

        System.out.println(
                "Savings Product: "
                + createClientPage.getPreviewSavingsProduct());

        System.out.println(
                "Submitted On: "
                + createClientPage.getPreviewSubmittedOn());

        System.out.println(
                "Active: "
                + createClientPage.getPreviewActiveStatus());

        System.out.println(
                "Is Staff: "
                + createClientPage.getPreviewIsStaffStatus());


        // ==============================
        // Submit
        // ==============================

        createClientPage.clickSubmit();
    }


    // =========================================================
    // TC-013 - Office is Mandatory
    // =========================================================

    @Test(priority = 2)
    public void TC_013_OfficeIsMandatory() {

        // ==============================
        // Close warning if displayed
        // ==============================

        createClientPage.closeWarning();


        // ==============================
        // Navigation
        // ==============================

        createClientPage.clickInstitution();

        createClientPage.clickClients();

        createClientPage.clickCreateClient();


        // ==============================
        // Office intentionally BLANK
        // ==============================

        createClientPage.selectLegalForm("Person");

        createClientPage.enterFirstName(firstName);

        createClientPage.enterLastName(lastName);

        createClientPage.enterSubmittedOn("17 September 2026");
                


        // ==============================
        // Click Next
        // ==============================

        createClientPage.clickNext();


        // ==============================
        // Verify Office validation
        // ==============================

        String actualMessage =createClientPage.getOfficeValidationMessage();
                

        Assert.assertEquals(actualMessage,"Office is required","Incorrect validation message for Office.");              
        
    }
    
    @Test(priority = 3)
    public void TC_015_FirstNameIsMandatory() {

        // =========================================
        // Close Mifos warning popup
        // =========================================

        createClientPage.closeWarning();


        // =========================================
        // Navigation
        // Institution → Clients → Create Client
        // =========================================

        createClientPage.clickInstitution();

        createClientPage.clickClients();

        createClientPage.clickCreateClient();


        // =========================================
        // General Details
        // =========================================

        // Office is mandatory, so select it
        createClientPage.selectOffice("Mumbai Branch");

        // Legal Form is mandatory and has default value
        // Person is already selected

        // First Name intentionally left BLANK

        // Last Name is mandatory
        createClientPage.enterLastName(lastName);

        // Submitted On is mandatory
     //   createClientPage.enterSubmittedOn("17 September 2026");


        // =========================================
        // Click Next
        // =========================================

        createClientPage.clickNext();


        // =========================================
        // Validate First Name error
        // =========================================

        String actualMessage =createClientPage.getFirstNameValidationMessage();
                

        Assert.assertEquals(actualMessage, "Client first name is required", "Incorrect First Name validation message.");
                
               
    }
    
    @Test(priority = 4)
    public void TC_016_LastNameIsMandatory() {

        // =========================================
        // Close Mifos warning popup
        // =========================================

        createClientPage.closeWarning();


        // =========================================
        // Navigation
        // =========================================

        createClientPage.clickInstitution();

        createClientPage.clickClients();

        createClientPage.clickCreateClient();


        // =========================================
        // General Details
        // =========================================

        // Office is mandatory
        createClientPage.selectOffice("Mumbai Branch");

        // Legal Form already has default value: Person

        // First Name is mandatory
        createClientPage.enterFirstName(firstName);

        // Last Name intentionally BLANK


        // Submitted On is mandatory
        createClientPage.enterSubmittedOn("17 September 2026");
                
        // =========================================
        // Click Next
        // =========================================

        createClientPage.clickNext();


        // =========================================
        // Verify Last Name validation
        // =========================================

        String actualMessage = createClientPage.getLastNameValidationMessage();
               

        Assert.assertEquals(actualMessage,"Client last name is required","Incorrect Last Name validation message.");             
                
    }
    
    @Test(priority = 5)
    public void TC_023_MultipleMandatoryFieldValidations() {

        // =========================================
        // Close warning popup
        // =========================================

        createClientPage.closeWarning();
        // =========================================
        // Navigation
        // =========================================

        createClientPage.clickInstitution();

        createClientPage.clickClients();

        createClientPage.clickCreateClient();


        // =========================================
        // Mandatory fields
        // =========================================

        // Office intentionally BLANK

        // Legal Form = Person by default
        // Cannot be made blank through current UI

        // First Name intentionally BLANK

        // Last Name intentionally BLANK

        // Submitted On = today's date by default
        // Cannot be made blank through current UI


        // =========================================
        // Click Next
        // =========================================

        createClientPage.clickNext();
        // =========================================
        // Application moves to next step
        // Return to General step
        // =========================================

        createClientPage.clickPrevious();

        // =========================================
        // Verify First Name validation
        // =========================================

        String firstNameMessage =createClientPage.getFirstNameValidationMessage();
                

        Assert.assertEquals(firstNameMessage,"Client first name is required","Incorrect First Name validation message.");
                
        // =========================================
        // Verify Last Name validation
        // =========================================

        String lastNameMessage =createClientPage.getLastNameValidationMessage();
                
        Assert.assertEquals(lastNameMessage,"Client last name is required","Incorrect Last Name validation message.");
                
    }
    
    @Test(priority = 6)
    public void TC_024_EnteredDataRetainedAfterValidationError() {

        // =========================================
        // Close warning popup
        // =========================================

        createClientPage.closeWarning();

        // =========================================
        // Navigate to Create Client
        // =========================================

        createClientPage.clickInstitution();
        createClientPage.clickClients();
        createClientPage.clickCreateClient();

        // =========================================
        // Enter valid data
        // =========================================

        // Office = Head Office by default
        // Legal Form = Person by default

        // First Name intentionally BLANK

        createClientPage.enterMiddleName(middleName);

        createClientPage.enterLastName(lastName);

        createClientPage.enterMobileNumber(mobileNumber);

        createClientPage.enterEmail(email);

        // Submitted On = today's date by default
        // =========================================
        // Trigger validation
        // =========================================

        createClientPage.clickNext();
        // =========================================
        // Return to General step
        // =========================================

        createClientPage.clickPrevious();
        // =========================================
        // Verify previously entered data retained
        // =========================================

        Assert.assertEquals(
                createClientPage.getMiddleName(),middleName,"Middle Name was not retained after validation error.");                               
        
        Assert.assertEquals(
                createClientPage.getLastName(),lastName,"Last Name was not retained after validation error.");
                
        Assert.assertEquals(
                createClientPage.getMobileNumber(),mobileNumber,"Mobile Number was not retained after validation error.");
                
        Assert.assertEquals(
                createClientPage.getEmail(),email, "Email was not retained after validation error.");              
    }
    
    @Test(priority = 7)
    public void TC_026_ValidationMessagesDisappearAfterCorrection() {

        // =========================================
        // Close warning popup
        // =========================================

        createClientPage.closeWarning();


        // =========================================
        // Navigate to Create Client
        // =========================================

        createClientPage.clickInstitution();
        createClientPage.clickClients();
        createClientPage.clickCreateClient();


        // =========================================
        // Trigger validation errors
        // =========================================

        // Office = Head Office by default
        // Legal Form = Person by default
        // Submitted On = Today's date by default

        // First Name = BLANK
        // Last Name = BLANK

        createClientPage.clickNext();


        // =========================================
        // Return to General page
        // =========================================

        createClientPage.clickPrevious();


        // =========================================
        // Verify validation messages are displayed
        // =========================================

        Assert.assertEquals(
                createClientPage.getFirstNameValidationMessage(),
                "Client first name is required",
                "First Name validation message was not displayed."
        );

        Assert.assertEquals(
                createClientPage.getLastNameValidationMessage(),
                "Client last name is required",
                "Last Name validation message was not displayed."
        );


        // =========================================
        // Correct the invalid/missing fields
        // =========================================

        createClientPage.enterFirstName(firstName);

        createClientPage.enterLastName(lastName);


        // =========================================
        // Verify validation messages disappear
        // =========================================

        Assert.assertTrue(
                createClientPage.isFirstNameValidationMessageDisappeared(),
                "First Name validation message did not disappear after correction."
        );

        Assert.assertTrue(
                createClientPage.isLastNameValidationMessageDisappeared(),
                "Last Name validation message did not disappear after correction.");
    }
    
    @Test(priority = 8)
    public void TC_027_UserCanProceedAfterCompletingMandatoryFields() {

        CreateClientPage createClientPage = new CreateClientPage();

        // Close warning popup
        createClientPage.closeWarning();

        // Navigate to Create Client
        createClientPage.clickInstitution();
        createClientPage.clickClients();
        createClientPage.clickCreateClient();

        // ==============================
        // General Information
        // ==============================

        createClientPage.selectOffice("Mumbai Branch");

        createClientPage.selectLegalForm("Person");

        createClientPage.enterExternalId("EXT_TC027");

        createClientPage.enterFirstName("Ajit");

        createClientPage.enterMiddleName("Kumar");

        createClientPage.enterLastName("Mohapatra");

        createClientPage.selectGender("Male");

        createClientPage.enterMobileNumber("9876543210");

        createClientPage.enterEmail("ajit.tc027@gmail.com");

        createClientPage.selectClientType("Business");

        createClientPage.selectClientClassification("Regular");

        createClientPage.selectActive();

        // Open Savings Account
        createClientPage.selectOpenSavingsAccount();
        

        // Savings Product
        createClientPage.selectSavingsProduct("Smart Savings Account");

        // ==============================
        // Proceed to next step
        // ==============================

        createClientPage.clickNext();

        // Verify user successfully moved to next wizard step
        // Add the appropriate assertion for the next step here.
        Assert.assertTrue(
                createClientPage.isFamilyMembersStepDisplayed(),
                "User was not able to proceed to the next step.");
    }
    
    @Test(priority = 9)
    public void TC_032_FirstNameRejectsNumericInput() {

    	 CreateClientPage createClientPage = new CreateClientPage();

    	    createClientPage.closeWarning();
    	    createClientPage.clickInstitution();
    	    createClientPage.clickClients();
    	    createClientPage.clickCreateClient();

    	    // Select mandatory Office
    	    createClientPage.selectOffice("Mumbai Branch");

    	    // Enter numeric value
    	    createClientPage.enterFirstName("111");
    	    createClientPage.enterMiddleName("kumar");

    	    // Validate error message immediately
    	    String actualMessage = createClientPage.getFirstNameInvalidMessage();

    	    Assert.assertEquals(
    	        actualMessage,
    	        "Client first name cannot begin with a special character or number",
    	        "Incorrect validation message for numeric First Name.");
        
    }
    
    @Test(priority = 10)
    public void TC_033_FirstNameRejectsSpecialCharacters() {
    	 CreateClientPage createClientPage = new CreateClientPage();

    	    createClientPage.closeWarning();
    	    createClientPage.clickInstitution();
    	    createClientPage.clickClients();
    	    createClientPage.clickCreateClient();

    	    // Select mandatory Office
    	    createClientPage.selectOffice("Mumbai Branch");

    	    // Enter special characters
    	    createClientPage.enterFirstName("@#$%^");

    	    // Move cursor to another field to trigger validation
    	    createClientPage.enterMiddleName("kumar");

    	    // Get validation message
    	    String actualMessage = createClientPage.getFirstNameInvalidMessage();

    	    // Verify validation message
    	    Assert.assertEquals(
    	        actualMessage,
    	        "Client first name cannot begin with a special character or number",
    	        "Incorrect validation message for special characters in First Name."
    	    );
    }
}