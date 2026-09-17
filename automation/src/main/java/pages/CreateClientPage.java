package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import driver.DriverManager;

public class CreateClientPage extends BasePage {

	public CreateClientPage() {
		super();
	}
	

	
	private By warningCloseButton =
	        By.cssSelector("mat-dialog-actions button[mat-dialog-close]");
	
	public void closeWarning() {
	    click(warningCloseButton);
	}

	// ==============================
	// Navigation Locators
	// ==============================

	private By institutionMenu = By.xpath("//a[@class='mat-mdc-menu-trigger tab-link ng-star-inserted']");

	private By clientsMenu = By.xpath("//span[contains(text(),'Clients')]");

	private By createClientButton = By.linkText("Create Client");

	// ==============================
	// Navigation Actions
	// ==============================

	public void clickInstitution() {
		waitForOverlayToDisappear();
		click(institutionMenu);
	}

	public void clickClients() {
		click(clientsMenu);
	}

	public void clickCreateClient() {
		click(createClientButton);
	}

	// ==============================
	// General Page - Locators
	// ==============================

	private By officeDropdown = By
			.xpath("//mat-label[contains(normalize-space(),'Office')]/ancestor::mat-form-field//mat-select");

	private By legalFormDropdown = By.cssSelector("mat-select[formcontrolname='legalFormId']");

	private By externalIdField = By.cssSelector("input[formcontrolname='externalId']");

	private By firstNameField = By.cssSelector("input[formcontrolname='firstname']");

	private By middleNameField = By.cssSelector("input[formcontrolname='middlename']");

	private By lastNameField = By.cssSelector("input[formcontrolname='lastname']");

	private By dateOfBirthField = By.xpath("PLACEHOLDER_DOB_LOCATOR");

	private By genderDropdown = By.cssSelector("mat-select[formcontrolname='genderId']");

	private By staffDropdown = By.cssSelector("mat-select[formcontrolname='staffId']");

	private By isStaffCheckbox = By.cssSelector("//label[normalize-space()='Is staff?']");

	private By mobileNumberField = By.cssSelector("input[formcontrolname='mobileNo']");

	private By emailField = By.cssSelector("input[formcontrolname='emailAddress']");

	private By clientTypeDropdown = By.cssSelector("mat-select[formcontrolname='clientTypeId']");

	private By clientClassificationDropdown = By.cssSelector("mat-select[formcontrolname='clientClassificationId']");

	private By clientClassificationOption = By.xpath("//mat-option[.//span[normalize-space()='Regular']]");

	private By submittedOnField = By.cssSelector("input[formcontrolname='submittedOnDate']");

	private By activeCheckbox = By.cssSelector("mat-checkbox[formcontrolname='active']");

	private By openSavingsAccountCheckbox = By.xpath("//label[normalize-space()='Open Savings Account?']");
	
	private By savingsProductDropdown = By.cssSelector("mat-select[formcontrolname='savingsProductId']");
	
	
	//=================================
	// Validation 
	
	private By officeValidationMessage = By.xpath("//mat-error[contains(normalize-space(.),'Office is required')]");	
	
	public String getOfficeValidationMessage() {
		 waitForTextPresent(officeValidationMessage,"Office is required");

			    return getText(officeValidationMessage).trim();
	}
	
	private By firstNameValidationMessage =
	        By.xpath("//mat-error[contains(normalize-space(.),'Client first name is required')]");
	
	public String getFirstNameValidationMessage() {

		 waitForTextPresent(firstNameValidationMessage,"Client first name is required");
		 
		 WebElement error = DriverManager.getDriver().findElement(firstNameValidationMessage);
		            

			    return getText(firstNameValidationMessage).trim();
	}
	
	private By lastNameValidationMessage =
	        By.xpath("//mat-error[contains(normalize-space(.),'Client last name is required')]");
	
	public String getLastNameValidationMessage() {

		 waitForTextPresent( lastNameValidationMessage, "Client last name is required");
			       
		 WebElement error = DriverManager.getDriver().findElement(lastNameValidationMessage);
		            
			    return getText(lastNameValidationMessage).trim();
	}

	protected void waitForTextPresent(By locator, String expectedText) {
	    wait.until( ExpectedConditions.textToBePresentInElementLocated( locator,expectedText));	           
	}  
	
	public String getMiddleName() {
	    return find(middleNameField).getAttribute("value");
	}

	public String getLastName() {
	    return find(lastNameField).getAttribute("value");
	}

	public String getMobileNumber() {
	    return find(mobileNumberField).getAttribute("value");
	}

	public String getEmail() {
	    return find(emailField).getAttribute("value");
	}
	
	public boolean isFirstNameValidationMessageDisappeared() {

	    return waitForElementToDisappear(firstNameValidationMessage);
	}
	
	public boolean isLastNameValidationMessageDisappeared() {

	    return waitForElementToDisappear(lastNameValidationMessage);
	}
	
	
	public void enterInvalidFirstName(String value) {
	    enterFirstName(value);
	    clickNext();
	}
	
	//===============================
	//Family Members
	private By familyMembersHeading =
	        By.xpath("//*[normalize-space()='Family Members']");
	
	public boolean isFamilyMembersStepDisplayed() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(familyMembersHeading)).isDisplayed();
	    
	}
	
	private By firstNameInvalidMessage = By.xpath(
		    "//mat-error[contains(.,'Client first name') and contains(.,'special character or number')]");
		
	
	public String getFirstNameInvalidMessage() {
		wait.until(
		        ExpectedConditions.visibilityOfElementLocated(firstNameInvalidMessage));
		 WebElement errorMessage =
		            find(firstNameInvalidMessage);
		 return errorMessage.getAttribute("textContent").trim();
	}
	
	
	// ==============================
	// Navigation Buttons
	// ==============================

	private By previousButton = By.xpath("(//button[@matStepperPrevious and not(@disabled)])[last()]");

	private By nextButton = By.xpath("//button[.//span[contains(text(),'Next')]]");

	// ==============================
	// Family Members Page
	// ==============================

	private By addFamilyMemberButton = By.xpath("//button[.//span[normalize-space()='Add']]");

	private By familyMembersNextButton = By.xpath("(//button[@matsteppernext])[2]");

	// ==============================
	// Preview Page
	// ==============================

	private By previewClientName = By.xpath("//span[normalize-space()='Name']/following-sibling::span[1]");

	private By previewOffice = By.xpath("//span[normalize-space()='Office']/following-sibling::span[1]");

	private By previewLegalForm = By.xpath("//span[normalize-space()='Legal Form']/following-sibling::span[1]");

	private By previewClientType = By.xpath("//span[normalize-space()='Legal Form']/following-sibling::span[1]");
	
	private By previewClientClassification =By.xpath("//span[normalize-space()='Client Classification']/following-sibling::span");
	
	private By previewSavingsProduct =By.xpath("//span[normalize-space()='Savings Product']/following-sibling::span");
	        
	        

	private By previewSubmittedOn = By.xpath("//span[normalize-space()='Submitted On Date']/following-sibling::span[1]");
			
	
	private By previewMobileNumber =By.xpath("//span[normalize-space()='Mobile No']/following-sibling::span");
	
	private By previewEmail =By.xpath("//span[normalize-space()='Email Address']/following-sibling::span");
	        
	        

	private By previewActive = By.xpath("//span[normalize-space()='Active?']/following-sibling::span[1]");

	private By previewIsStaff = By.xpath("//span[normalize-space()='Is staff?']/following-sibling::span[1]");

	private By cancelButton = By.xpath("//button[.//span[normalize-space()='Cancel']]	");

	private By submitButton = By.xpath("//button[.//span[normalize-space()='Submit']]");

	// =========================================================
	// General Page - Actions
	// =========================================================

	public void selectOffice(String office) {
		selectMatOption(officeDropdown, office);
	}

	public void selectLegalForm(String legalForm) {
		selectMatOption(legalFormDropdown, legalForm);
	}

	public void enterExternalId(String externalId) {
		type(externalIdField, externalId);
	}

	public void enterFirstName(String firstName) {
		type(firstNameField, firstName);
	}

	public void enterMiddleName(String middleName) {
		type(middleNameField, middleName);
	}

	public void enterLastName(String lastName) {
		type(lastNameField, lastName);
	}

	public void enterDateOfBirth(String dateOfBirth) {
		type(dateOfBirthField, dateOfBirth);
	}

	public void selectGender(String gender) {
		selectMatOption(genderDropdown, gender);
	}

	public void selectStaff(String staff) {
		selectMatOption(staffDropdown, staff);
	}

	public void selectClientType(String clientType) {
		selectMatOption(clientTypeDropdown, clientType);
	}

	public void selectClientClassification(String classification) {
		selectMatOption(clientClassificationDropdown, classification);

	}

	public void enterMobileNumber(String mobileNumber) {
		type(mobileNumberField, mobileNumber);
	}

	public void enterEmail(String email) {
		type(emailField, email);
	}

	public void enterSubmittedOn(String submittedOn) {
		type(submittedOnField, submittedOn);
	}
	
	
	public void selectSavingsProduct(String productName) {

	    click(savingsProductDropdown);

	    By option = By.xpath(
	        "//mat-option[@role='option']//span[normalize-space()='"
	        + productName + "']");
	    
	    waitForElement(option);
	    click(option);
	}

	// =========================================================
	// Checkboxes
	// =========================================================

	public void selectIsStaff() {
		click(isStaffCheckbox);
	}

	public void selectActive() {
		click(activeCheckbox);
	}

	public void selectOpenSavingsAccount() {
		click(openSavingsAccountCheckbox);
	}

	// =========================================================
	// Navigation
	// =========================================================

	public void clickNext() {
		click(nextButton);
	}

	public void clickPrevious() {
		click(previousButton);
	}

	// =========================================================
	// Family Members
	// =========================================================

	public void clickAddFamilyMember() {
		click(addFamilyMemberButton);
	}

	public void clickGeneralNext() {
		click(nextButton);
	}

	public void clickFamilyMembersNext() {
		click(familyMembersNextButton);
	}
	// =========================================================
	// Preview - Verification
	// =========================================================

	public String getPreviewClientName() {
		return getText(previewClientName);
	}

	public String getPreviewOffice() {
		return getText(previewOffice);
	}

	public String getPreviewLegalForm() {
		return getText(previewLegalForm);
	}

	public String getPreviewClientType() {
		return getText(previewClientType);
	}

	public String getPreviewSubmittedOn() {
		return getText(previewSubmittedOn);
	}

	public String getPreviewActiveStatus() {
		return getText(previewActive);
	}

	public String getPreviewIsStaffStatus() {
		return getText(previewIsStaff);
	}
	
	public String getPreviewMobileNumber() {
	    return getText(previewMobileNumber);
	}
	
	public String getPreviewEmail() {
	    return getText(previewEmail);
	}
	
	public String getPreviewClientClassification() {
	    return getText(previewClientClassification);
	}

	public String getPreviewSavingsProduct() {
	    return getText(previewSavingsProduct);
	}

	

	// =========================================================
	// Preview Actions
	// =========================================================

	public void clickCancel() {
		click(cancelButton);
	}

	public void clickSubmit() {
		click(submitButton);
	}
}