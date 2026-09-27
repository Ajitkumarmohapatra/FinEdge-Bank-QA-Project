# 09 -- Selenium Automation

## US-002 -- Activate Client

------------------------------------------------------------------------

## 1. Document Information

  Field                  Details
  ---------------------- --------------------------------
  Project                FinEdge Bank QA Project
  Phase                  Phase 2 -- Client Management
  User Story             US-002 -- Activate Client
  Module                 Client Management
  Domain                 Banking / BFSI
  Automation Tool        Selenium WebDriver
  Programming Language   Java
  Test Framework         TestNG
  Design Pattern         Page Object Model (POM)
  Build Tool             Maven
  Browser                Google Chrome
  Automation Status      **Completed for 7 test cases**

------------------------------------------------------------------------

## 2. Objective

The objective of Selenium automation for **US-002 -- Activate Client**
is to automate the verified UI workflow for opening the Clients page,
dynamically identifying an eligible Pending client, opening the client
profile, accessing the Actions menu, activating the client, selecting
the current date, and verifying that the client status changes to
**ACTIVE**.

The automation is designed to avoid hard-coding dynamic client names
wherever possible.

------------------------------------------------------------------------

## 3. Automation Coverage

A total of **7 test cases** from US-002 are currently covered through
Selenium automation.

  Test Case ID   Test Case                                 Automation Status
  -------------- ----------------------------------------- -------------------
  TC-001         Verify Clients page loads successfully    **Automated**
  TC-005         Verify Pending client is displayed        **Automated**
  TC-006         Verify client profile can be opened       **Automated**
  TC-009         Verify Actions submenu is displayed       **Automated**
  TC-010         Verify Activate option is displayed       **Automated**
  TC-011         Verify eligible client can be activated   **Automated**
  TC-012         Verify client status after activation     **Automated**

> The seven test cases are covered through the existing automation flow.
> Seven separate `@Test` methods are not required because a single
> end-to-end automation method can exercise and validate multiple
> related test-case scenarios.

------------------------------------------------------------------------

## 4. Automation Framework

The automation follows the existing Page Object Model framework.

``` text
src/test/java
│
├── base
│   └── BaseTest.java
│
├── pages
│   ├── LoginPage.java
│   ├── NavigationMenu.java
│   └── ActiveClientPage.java
│
├── tests
│   └── ActiveClientTest.java
│
└── utils
    ├── ConfigReader.java
    └── DriverManager.java
```

### Framework Components

  Component            Purpose
  -------------------- -------------------------------------------
  Selenium WebDriver   Browser automation
  Java                 Programming language
  TestNG               Test execution and assertions
  Maven                Dependency/build management
  Page Object Model    Separation of page actions and test logic
  WebDriverWait        Explicit synchronization
  ChromeDriver         Chrome browser execution
  ConfigReader         Reads environment/test configuration
  DriverManager        WebDriver initialization and cleanup

------------------------------------------------------------------------

## 5. Automated Navigation Flow

The automated workflow is:

``` text
Login
   ↓
Verify Home Page
   ↓
Close Mifos Warning Popup
   ↓
Institution
   ↓
Clients
   ↓
Verify Clients Page / Read Client List
   ↓
Identify Pending Client Dynamically
   ↓
Open Client Profile
   ↓
Open Three-Dot / Actions Menu
   ↓
Open Actions
   ↓
Select Activate
   ↓
Open Activation Calendar
   ↓
Select Today's Date Dynamically
   ↓
Confirm Activation
   ↓
Navigate Back to Clients
   ↓
Find Same Client Dynamically
   ↓
Verify ACTIVE Status
```

------------------------------------------------------------------------

## 6. Dynamic Client Selection

Client names are not hard-coded because client records can change
between executions.

The automation reads the currently displayed client rows and identifies
a client whose status contains `PENDING`.

### Method

``` java
public String getPendingClientName() {

    By clientRows = By.cssSelector("div.list-row");

    waitForElementPresence(clientRows);

    List<WebElement> rows = findElements(clientRows);

    for (WebElement row : rows) {

        String rowText = row.getText().trim();

        System.out.println("Checking Client Row: " + rowText);

        if (rowText.contains("PENDING")) {

            WebElement nameElement =
                row.findElement(By.cssSelector("span.name"));

            return nameElement.getText().trim();
        }
    }

    throw new RuntimeException(
        "No PENDING client found on Clients page."
    );
}
```

### Example Execution

``` text
Selected Pending Client: swara tfyygyg
```

The actual client name may be different during another execution.

------------------------------------------------------------------------

## 7. Dynamic Recent Client Selection

The automation also reads the displayed client names instead of storing
a fixed client name.

``` java
public List<String> getRecentClientNames() {

    waitForElementPresence(clientNames);

    List<WebElement> elements = findElements(clientNames);

    List<String> names = new ArrayList<>();

    for (int i = 0; i < Math.min(5, elements.size()); i++) {

        String name = elements.get(i).getText().trim();

        if (!name.isEmpty()) {
            names.add(name);
        }
    }

    return names;
}
```

The first available client can then be selected dynamically:

``` java
List<String> names = activeClientPage.getRecentClientNames();

Assert.assertFalse(
    names.isEmpty(),
    "No client names found on Clients page."
);

String clientName = names.get(0);

System.out.println("Selected Client: " + clientName);

activeClientPage.clickClient(clientName);
```

------------------------------------------------------------------------

## 8. Page Object -- ActiveClientPage

The `ActiveClientPage` contains the locators and reusable actions
required for the Active Client workflow.

### Important Locators

``` java
private By clientSearchField =
    By.cssSelector(
        "input[placeholder='Search by client name, external Id, mobile']"
    );

private By actionsMenu =
    By.cssSelector("mat-icon.actions-menu");

private By actionsMenuItem =
    By.xpath(
        "//button[@mat-menu-item]" +
        "[.//span[contains(@class,'mat-mdc-menu-item-text')" +
        " and normalize-space()='Actions']]"
    );

private By activateMenuItem =
    By.xpath(
        "//button[@mat-menu-item]" +
        "[.//span[contains(@class,'mat-mdc-menu-item-text')" +
        " and normalize-space()='Activate']]"
    );

private By activationCalendarButton =
    By.cssSelector("button[aria-label='Open calendar']");

private By confirmButton =
    By.xpath("//button[normalize-space()='Confirm']");
```

### Dynamic Client Row

``` java
private By clientRow(String clientName) {

    return By.xpath(
        "//div[contains(@class,'list-row')]" +
        "[.//span[contains(@class,'name') and " +
        "contains(normalize-space(),'" + clientName + "')]]"
    );
}
```

------------------------------------------------------------------------

## 9. Warning Popup Handling

After login, the Mifos warning popup can block interaction with the
Institution menu.

The automation closes the popup before navigation.

``` java
private By warningCloseButton =
    By.cssSelector(
        "mat-dialog-actions button[mat-dialog-close]"
    );

public void closeWarning() {
    click(warningCloseButton);
}
```

This prevents the warning overlay from intercepting the
Institution/Clients navigation.

------------------------------------------------------------------------

## 10. Navigation to Clients

The automation uses the existing `NavigationMenu` page object.

``` java
public void navigateToClients() {

    navigationMenu.clickInstitution();

    navigationMenu.clickClients();
}
```

The flow is:

``` text
Institution
    ↓
Clients
```

------------------------------------------------------------------------

## 11. Open Client Profile

The selected client is opened using its dynamically retrieved name.

``` java
public void clickClient(String clientName) {

    click(clientRow(clientName));
}
```

Example:

``` text
Selected Pending Client: swara tfyygyg
```

The corresponding client profile is opened without hard-coding the
client name.

------------------------------------------------------------------------

## 12. Actions Menu and Activate

The client profile contains the three-dot Actions menu.

The automation performs:

``` java
activeClientPage.clickActionsMenu();
activeClientPage.clickActions();
activeClientPage.clickActivate();
```

This covers:

-   TC-009 -- Verify Actions submenu is displayed
-   TC-010 -- Verify Activate option is displayed
-   TC-011 -- Verify eligible client can be activated

------------------------------------------------------------------------

## 13. Dynamic Today's Date Selection

The activation date is selected through the calendar UI.

The automation does not hard-code a date such as:

``` text
27 September 2026
```

Instead, it generates the current date dynamically.

``` java
String todayDateValue = LocalDate.now()
    .format(
        DateTimeFormatter.ofPattern("d MMMM yyyy")
    );

By todayDate = By.cssSelector(
    "mat-calendar button[aria-label='" +
    todayDateValue + "']"
);

WebElement today = wait.until(
    ExpectedConditions.elementToBeClickable(todayDate)
);

today.click();
```

This allows the test to continue working on future execution dates.

------------------------------------------------------------------------

## 14. Confirm Activation

After selecting today's date, the automation clicks the Confirm button.

``` java
public void clickConfirm() {

    click(confirmButton);
}
```

The activation workflow is therefore:

``` text
Activate
   ↓
Open Calendar
   ↓
Select Today's Date
   ↓
Confirm
```

------------------------------------------------------------------------

## 15. Post-Activation Verification

After activation, the automation returns to the Clients page and
searches for the same client.

The row text is captured dynamically.

``` java
public boolean isClientActive(String clientName) {

    By clientRow = clientRow(clientName);

    WebElement row = wait.until(
        ExpectedConditions.visibilityOfElementLocated(clientRow)
    );

    String rowText = row.getText().trim();

    System.out.println(
        "Activated Client Row: " + rowText
    );

    return rowText.contains("ACTIVE");
}
```

The test then asserts:

``` java
boolean active =
    activeClientPage.isClientActive(clientName);

Assert.assertTrue(
    active,
    "Client '" + clientName +
    "' was not activated successfully."
);
```

This directly validates:

**TC-012 -- Verify client status after activation**

------------------------------------------------------------------------

## 16. ActiveClientTest -- Automated Scenarios

### Test 1 -- Open Recent Client

``` java
@Test(priority = 1)
public void openRecentClientTest() {

    loginPage.enterUsername(
        ConfigReader.getProperty("username")
    );

    loginPage.enterPassword(
        ConfigReader.getProperty("password")
    );

    loginPage.clickLogin();

    Assert.assertTrue(
        loginPage.isHomePageDisplayed(),
        "Home page was not displayed after login."
    );

    activeClientPage.closeWarning();

    activeClientPage.navigateToClients();

    List<String> names =
        activeClientPage.getRecentClientNames();

    Assert.assertFalse(
        names.isEmpty(),
        "No client names found on Clients page."
    );

    String clientName = names.get(0);

    System.out.println(
        "Selected Client: " + clientName
    );

    activeClientPage.clickClient(clientName);
}
```

### Test 2 -- Activate Pending Client and Verify Status

``` java
@Test(priority = 2)
public void activatePendingClientTest() {

    loginPage.enterUsername(
        ConfigReader.getProperty("username")
    );

    loginPage.enterPassword(
        ConfigReader.getProperty("password")
    );

    loginPage.clickLogin();

    Assert.assertTrue(
        loginPage.isHomePageDisplayed(),
        "Home page was not displayed after login."
    );

    activeClientPage.closeWarning();

    activeClientPage.navigateToClients();

    String clientName =
        activeClientPage.getPendingClientName();

    System.out.println(
        "Selected Pending Client: " + clientName
    );

    activeClientPage.clickClient(clientName);

    activeClientPage.clickActionsMenu();
    activeClientPage.clickActions();
    activeClientPage.clickActivate();

    activeClientPage.clickActivationCalendar();
    activeClientPage.selectToday();

    activeClientPage.clickConfirm();

    activeClientPage.navigateToClients();

    boolean active =
        activeClientPage.isClientActive(clientName);

    Assert.assertTrue(
        active,
        "Client '" + clientName +
        "' was not activated successfully."
    );

    System.out.println(
        "SUCCESS: Client '" +
        clientName +
        "' is ACTIVE."
    );
}
```

------------------------------------------------------------------------

## 17. Test Execution Result

The Active Client Selenium automation was executed successfully using
TestNG.

### Execution Result

``` text
Tests run: 2
Failures: 0
Skips: 0
```

### Test Results

  Test Method                   Result
  ----------------------------- ----------
  `openRecentClientTest`        **PASS**
  `activatePendingClientTest`   **PASS**

Example execution output:

``` text
Selected Client: Ajit838316 Kumar Test838316

Selected Pending Client: swara tfyygyg

Activated Client Row:
ST
swara tfyygyg
Person · Activated 27 September 2026
ACTIVE
000000050
—
Mumbai Branch

PASSED: tests.ActiveClientTest.openRecentClientTest
PASSED: tests.ActiveClientTest.activatePendingClientTest

Tests run: 2
Failures: 0
Skips: 0
```

------------------------------------------------------------------------

## 18. Test Case Coverage Summary

Although the implementation currently contains **2 TestNG test
methods**, the automation covers **7 test-case scenarios**.

  -----------------------------------------------------------------------
  Test Case                           Covered Through
  ----------------------------------- -----------------------------------
  TC-001 -- Clients page loads        `navigateToClients()` + client list
  successfully                        retrieval

  TC-005 -- Pending client is         `getPendingClientName()`
  displayed                           

  TC-006 -- Client profile can be     `clickClient(clientName)`
  opened                              

  TC-009 -- Actions submenu is        `clickActionsMenu()` +
  displayed                           `clickActions()`

  TC-010 -- Activate option is        `clickActivate()`
  displayed                           

  TC-011 -- Eligible client can be    Activate → Date → Confirm
  activated                           

  TC-012 -- Client status after       `isClientActive(clientName)` +
  activation                          assertion
  -----------------------------------------------------------------------

### Coverage

``` text
US-002 Total Test Cases       : 26
Selenium Automated            : 7
Remaining Selenium Scenarios  : 19
```

The remaining test cases should be automated only after their
corresponding UI/API/database behavior has been validated.

------------------------------------------------------------------------

## 19. Dynamic Data Handling

The automation avoids hard-coding values that can change between
executions.

### Dynamic Client Name

``` java
String clientName =
    activeClientPage.getPendingClientName();
```

### Dynamic Today's Date

``` java
LocalDate.now()
```

### Dynamic Client Status

``` java
return rowText.contains("ACTIVE");
```

This makes the automation more reusable across different test executions
and test data.

------------------------------------------------------------------------

## 20. Synchronization Strategy

The automation uses explicit waits instead of fixed `Thread.sleep()`
statements.

Examples:

``` java
wait.until(
    ExpectedConditions.elementToBeClickable(locator)
);
```

and:

``` java
waitForElementPresence(locator);
```

This is important because the Mifos application uses Angular Material
components and dynamic client-list rendering.

------------------------------------------------------------------------

## 21. Automation Design Principles

The Active Client automation follows these principles:

1.  Use Page Object Model.
2.  Keep locators inside page classes.
3.  Keep test flow inside TestNG test classes.
4.  Use explicit waits for dynamic UI elements.
5.  Avoid hard-coded client names.
6.  Generate/select today's date dynamically.
7.  Re-read the client after activation.
8.  Assert the final client status.
9.  Reuse common login and navigation components.
10. Keep the existing working framework unchanged unless a real
    automation defect is identified.

------------------------------------------------------------------------

## 22. Current Selenium Automation Status

**US-002 -- Activate Client Selenium Automation: COMPLETED for the
currently planned 7 UI test cases.**

### Completed

``` text
TC-001  Clients page loads successfully       ✓
TC-005  Pending client is displayed           ✓
TC-006  Client profile can be opened          ✓
TC-009  Actions submenu is displayed          ✓
TC-010  Activate option is displayed          ✓
TC-011  Eligible client can be activated      ✓
TC-012  Client status after activation        ✓
```

### Execution

``` text
TestNG Tests Executed : 2
Passed                : 2
Failed                : 0
Skipped               : 0
```

------------------------------------------------------------------------

## 23. Remaining Automation Scope

The remaining US-002 test cases are not marked as automated in this
document until they are actually implemented and executed.

Potential remaining areas include:

-   Client search by name
-   Client search by External ID
-   Client search by mobile number
-   Client information validation
-   Already-active client behavior
-   Activation cancellation
-   Negative activation scenarios
-   Security-related activation validation
-   API validation
-   SQL/database validation
-   Integration scenarios
-   Regression scenarios

These should be automated and documented separately as they are
implemented.

------------------------------------------------------------------------

## 24. Conclusion

Selenium automation for **US-002 -- Activate Client** has successfully
automated the core Active Client UI workflow.

The current automation dynamically identifies an eligible Pending
client, opens the client profile, accesses the Actions menu, activates
the client using today's date, and verifies that the same client is
displayed as **ACTIVE** after activation.

The current Selenium automation covers **7 test cases** and has been
successfully executed with:

``` text
2 TestNG tests
2 Passed
0 Failed
0 Skipped
```

The implementation uses the existing **Java + Selenium WebDriver +
TestNG + Maven + Page Object Model** framework.

------------------------------------------------------------------------

## 25. Next Activity

Continue with the remaining **US-002 Active Client** test cases and
update this document after each automation scenario is implemented and
successfully executed.
