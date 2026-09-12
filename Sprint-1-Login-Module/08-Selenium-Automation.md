# Selenium Automation – Login Module**

**---**

# # 1. Overview**

The Login Module automation was implemented using Selenium WebDriver with Java and TestNG.

The automation framework follows the Page Object Model (POM) design pattern to provide reusable, maintainable, and scalable automation code.

## # Automation Status**

\| Item | Details |

\|------|---------|

\| Module | Login |

\| Automation Tool | Selenium WebDriver |

\| Programming Language | Java |

\| Test Framework | TestNG |

\| Build Tool | Maven |

\| Design Pattern | Page Object Model (POM) |

\| Automated Test Cases | 16 |

\| Test Class | LoginTest.java |

\| Page Object | LoginPage.java |

\| Driver Management | DriverManager.java |

\| Reporting | Extent Reports |

\| Test Listener | TestListener.java |

\| Screenshot Utility | ScreenshotUtil.java |

\| Configuration | config.properties |

\| Status | COMPLETED |

**---**

# # 2. Automation Framework Structure**

\`\`\`text

automation

└── src

    ├── main

    │   └── java

    │       ├── base

    │       │   ├── BasePage.java

    │       │   └── BaseTest.java

    │       │

    │       ├── components

    │       │   ├── driver

    │       │   │   └── DriverManager.java

    │       │   │

    │       │   ├── listeners

    │       │   │   └── TestListener.java

    │       │   │

    │       │   └── pages

    │       │       └── LoginPage.java

    │       │

    │       └── utils

    │           ├── ConfigReader.java

    │           ├── ExtentReportManager.java

    │           └── ScreenshotUtil.java

    │

    └── test

        ├── java

        │   └── tests

        │       └── LoginTest.java

        │

        └── resources

            └── config.properties
# 3. Automation Framework Components
# # 3.1 BasePage.java

BasePage.java is the common page-level base class used by page objects.

It provides reusable functionality that can be shared across different application pages.
# # 3.2 BaseTest.java

BaseTest.java is the base class for TestNG test classes.

It provides common test setup and teardown functionality required for WebDriver-based test execution.
# # 3.3 DriverManager.java

DriverManager.java is responsible for WebDriver management.

The test classes use the centralized driver instance through DriverManager.

This helps maintain consistent browser management across the automation framework.
# # 3.4 LoginPage.java

LoginPage.java implements the Page Object Model for the Login page.

Login-related actions and validations are maintained inside the Login Page Object rather than placing locator and page interaction logic directly inside the test class.

Examples of Login Page operations used by the tests include:

Enter username

Enter password

Click Login

Click username field

Click password field

Get login error message

Get username validation message

Get password validation message

Verify Login button state

Verify Home page
# # 3.5 ConfigReader.java

ConfigReader.java is used to read configuration values from the external properties file.

The automation retrieves values such as:

Application URL

Username

Password

from:

src/test/resources/config.properties

This avoids hard-coding environment-specific credentials and URLs directly inside the test methods.
# # 3.6 TestListener.java

TestListener.java provides TestNG listener functionality.

The listener is integrated with the automation framework to handle test execution events and reporting-related activities.
# # 3.7 ExtentReportManager.java

ExtentReportManager.java manages Extent Reports for automation execution.

Extent Reports provide a readable execution report containing test execution information.
# # 3.8 ScreenshotUtil.java

ScreenshotUtil.java provides screenshot capture functionality.

Screenshots can be used as execution evidence, particularly when investigating failed test cases.
# 4. Login Automation Test Class

The primary Login automation test class is:

LoginTest.java

The test class extends:

BaseTest

and uses:

LoginPage

DriverManager

ConfigReader

The test methods are implemented using TestNG @Test annotations with execution priorities.
# 5. Automated Login Test Coverage

A total of 16 Login scenarios have been automated.

Priority    Automated Test  Test Coverage

1   Valid Login Positive authentication

2   Invalid Username    Invalid credential validation

3   Invalid Password    Invalid credential validation

4   Empty Username  Mandatory field validation

5   Empty Password  Mandatory field validation

6   Empty Username and Password Mandatory field validation

7   Invalid Username and Password   Negative authentication

8   Password Below Minimum Length   Boundary/field validation

9   Username with Leading Spaces    Input validation

10  Username with Trailing Spaces   Input validation

11  Password with Leading Spaces    Input validation

12  Password with Trailing Spaces   Input validation

13  Username with Special Characters    Negative input validation

14  Password with Special Characters    Negative input validation

15  Username with Numbers Only  Negative input validation

16  Invalid Server URL  Invalid route/server URL validation

Note: The table above uses the automation test execution priority/method order. The exact TC\_LOGIN\_XXX mapping is maintained separately in the Login Test Cases workbook.
# 6. Detailed Automated Test Scenarios
# # 6.1 Valid Login

Test Method:

validLoginTest()

Test Steps

Create the Login Page object.

Read the valid username from configuration.

Enter the username.

Read the valid password from configuration.

Enter the password.

Click Login.

Verify that the Home page is displayed.

Validation

The test uses a TestNG assertion to verify that the user is redirected to the Home page after successful authentication.
# # 6.2 Invalid Username

Test Method:

invalidUsernameTest()

Test Data

Username: Invalid username

Password: Valid password

Validation

The test verifies that the expected invalid credentials error message is displayed.

Expected message:

Your session has expired or the credentials are invalid.
# # 6.3 Invalid Password

Test Method:

invalidPasswordTest()

Test Data

Username: Valid username

Password: Invalid password

Validation

The test verifies that the expected invalid credentials error message is displayed.

Expected message:

Your session has expired or the credentials are invalid.
# # 6.4 Empty Username

Test Method:

emptyUsernameTest()

Test Steps

Leave the username field empty.

Enter a valid password.

Trigger username field validation.

Verify the username validation message.

Verify Login button state.

Expected Result

Username validation message:

Username is required

The Login button should remain disabled when the username is empty.
# # 6.5 Empty Password

Test Method:

emptyPasswordTest()

Test Steps

Enter a valid username.

Leave the password field empty.

Move focus away from the password field.

Verify password validation.

Verify Login button state.

Expected Result

Password validation message:

Password is required (min length 8)

The Login button should remain disabled when the password is empty.
# # 6.6 Empty Username and Password

Test Method:

emptyUsernameAndPasswordTest()

Validation

The test verifies:

Username required validation.

Password required validation.

Login button is disabled.

Expected username message:

Username is required

Expected password message:

Password is required (min length 8)
# # 6.7 Invalid Username and Password

Test Method:

invalidUsernameAndPasswordTest()

Test Data

Both username and password are invalid.

Expected Result

The login attempt should fail and the expected invalid credentials error message should be displayed.
# # 6.8 Password Below Minimum Length

Test Method:

passwordBelowMinimumLengthTest()

Test Data

A password shorter than the required minimum length is entered.

Validation

The test verifies:

Password validation message.

Login button is disabled.
# # 6.9 Username with Leading Spaces

Test Method:

usernameWithLeadingSpacesTest()

Test Data

Leading spaces are added before the valid username.

Validation

The test verifies that the user remains on the Login page and authentication does not succeed.
# # 6.10 Username with Trailing Spaces

Test Method:

usernameWithTrailingSpacesTest()

Test Data

Trailing spaces are added after the valid username.

Validation

The test verifies that the user remains on the Login page.
# # 6.11 Password with Leading Spaces

Test Method:

passwordWithLeadingSpacesTest()

Test Data

Leading spaces are added before the valid password.

Validation

The test verifies that the user remains on the Login page.
# # 6.12 Password with Trailing Spaces

Test Method:

passwordWithTrailingSpacesTest()

Test Data

Trailing spaces are added after the valid password.

Validation

The test verifies that the user remains on the Login page.
# # 6.13 Username with Special Characters

Test Method:

usernameWithSpecialCharactersTest()

Test Data

@@@###$$$

Expected Result

Authentication should not succeed and the user should remain on the Login page.
# # 6.14 Password with Special Characters

Test Method:

passwordWithSpecialCharactersTest()

Test Data

@@@###$$$

Expected Result

Authentication should not succeed and the user should remain on the Login page.
# # 6.15 Username with Numbers Only

Test Method:

usernameWithNumbersOnlyTest()

Test Data

123456789

Expected Result

Authentication should not succeed and the user should remain on the Login page.
# # 6.16 Invalid Server URL

Test Method:

invalidServerUrlTest()

Test Steps

Retrieve the configured application URL.

Append an invalid server URL path.

Navigate to the resulting URL.

Retrieve the current browser URL.

Verify the application remains within the expected Login route.

Expected Result

The current URL should contain:
# /login/invalid-server-url
# # 7. Assertions Implemented

TestNG assertions are used to validate expected application behavior.

The automation includes assertions for:

Successful Login

Home page is displayed

Invalid Credentials

Your session has expired or the credentials are invalid.

Mandatory Fields

Username is required

Password is required (min length 8)

Login Button State

The automation verifies that the Login button is disabled when mandatory fields are invalid or empty.

Invalid Input

The automation verifies that the browser remains on the Login page for invalid username/password input scenarios.

Invalid Server URL

The automation verifies the expected Login route for an invalid server URL scenario.
# 8. Configuration Management

The automation uses an external configuration file:

src/test/resources/config.properties

Configuration is accessed through:

ConfigReader.java

The following values are retrieved from configuration:

url

username

password

This approach provides separation between test logic and environment-specific configuration.
# 9. Page Object Model Implementation

The automation follows the Page Object Model (POM) architecture.

The Login page interactions are encapsulated in:

LoginPage.java

The test class focuses on:

Test data

Test execution

Assertions

Expected behavior

The page object focuses on:

Page interactions

Field operations

Page validations

Login-related element handling

This separation improves:

Maintainability

Reusability

Readability

Scalability
# 10. Driver Management

WebDriver management is centralized through:

DriverManager.java

Tests access the active driver through the DriverManager instead of creating independent driver instances inside every test method.

This provides a cleaner framework architecture and supports centralized browser management.
# 11. Test Execution

The Login tests are implemented using TestNG.

Each test method is annotated using:

```java
@Test
```

Execution priority is assigned to the automated Login scenarios.

The automation contains:

```text
16 TestNG test methods
```

covering positive, negative, validation, boundary, input, and invalid-route scenarios.


# 12. Reporting

The automation framework includes Extent Reports.

Reporting is managed through:

ExtentReportManager.java

The framework also contains:

TestListener.java

for TestNG test execution event handling.

This provides a structured mechanism for capturing automation execution results.
# 13. Screenshot Support

The framework includes:

ScreenshotUtil.java

for screenshot capture.

Screenshots can be used as evidence during automation execution and failure investigation.
# 14. Automation Coverage Summary

| Category | Automated Coverage |
|----------|--------------------:|
| Positive Login | 1 |
| Invalid Credentials | 3 |
| Mandatory Field Validation | 3 |
| Password Boundary Validation | 1 |
| Username Input Validation | 2 |
| Password Input Validation | 2 |
| Special Character Validation | 2 |
| Numeric Username Validation | 1 |
| Invalid Server URL | 1 |
| **Total** | **16** |


# 15. Automation Completion Status

| Activity | Status |
|----------|--------|
| Selenium WebDriver Setup | COMPLETED |
| TestNG Integration | COMPLETED |
| Maven Integration | COMPLETED |
| Page Object Model | COMPLETED |
| Driver Management | COMPLETED |
| Login Page Object | COMPLETED |
| Configuration Management | COMPLETED |
| Login Test Implementation | COMPLETED |
| TestNG Assertions | COMPLETED |
| Test Listener | COMPLETED |
| Extent Reporting | COMPLETED |
| Screenshot Utility | COMPLETED |
| Login Automation Coverage | **16 TEST CASES COMPLETED** |


# 16. Conclusion

Selenium automation for the FinEdge Bank Login Module has been completed.

A total of 16 Login scenarios have been automated using Selenium WebDriver, Java, TestNG, Maven, and the Page Object Model.

The automation covers:

Successful authentication

Invalid username

Invalid password

Invalid username and password

Empty username

Empty password

Empty username and password

Password minimum-length validation

Leading and trailing spaces

Special characters

Numeric-only username

Invalid server URL

The framework also provides:

Centralized WebDriver management

Page Object Model architecture

External configuration

TestNG listener support

Extent Reports

Screenshot support

Final Automation Status

Selenium Automation: COMPLETED

Total Login Tests Automated: 16
