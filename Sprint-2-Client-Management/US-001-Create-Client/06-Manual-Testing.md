brary
/
06-Manual-Testing.md


US-001 – Create Client Manual Testing
1. Module Overview
Module: Client Management
User Story: US-001 – Create Client
Document: Manual Testing Execution Report
Execution Date: 2026-08-09

This document summarizes the manual test execution performed for the Create Client user story. Detailed test cases are maintained in 04-US-001-Create-Client-Test-Cases.xlsx, while requirement coverage is maintained in 05-Requirement-Traceability-Matrix.xlsx.

2. Testing Objective
The objective of manual testing is to verify that the Create Client functionality:

Allows authorized users to create clients successfully.

Validates mandatory and optional fields correctly.

Handles valid, invalid, boundary, and negative inputs.

Provides appropriate validation and error messages.

Maintains expected UI behavior and usability.

Enforces relevant security and access-control requirements.

Supports accessibility requirements covered by the executed test cases.

Persists client information correctly where applicable.

3. Test Scope
In Scope
Create Client page navigation

Client information fields

Field-level validations

Mandatory-field validations

Mobile number and email validation

Date validation

Dropdowns and checkboxes

Form navigation

Client creation and persistence

UI and usability checks

Accessibility checks

Security and authentication scenarios

Negative and boundary-value testing

Out of Scope / Not Executed
Some scenarios were skipped because they were not executed during the current test cycle. These are listed in the Skipped Test Cases section.

4. Test Execution Summary
Status	Count
Pass	192
Fail	18
Skip	21
Total	231
Execution Result
83.12% of the executed test cases passed.

7.79% failed.

9.09% were skipped.

Pass percentage is calculated against all 231 test cases. The current execution contains 192 passed, 18 failed, and 21 skipped cases.

5. Test Execution by Test Type
Test Type	Pass	Fail	Skip	Total
Accessibility	6	0	0	6
Audit	1	0	0	1
Business Rule	9	0	0	9
Functional	15	0	2	17
Performance	7	0	0	7
Planned	101	17	16	134
Reliability	1	0	0	1
Security	4	0	3	7
UI	33	1	0	34
Validation	15	0	0	15
6. Functional Testing
Functional testing covered:

Create Client page access.

Valid client creation.

Mandatory-field behavior.

Input validation.

Dropdown and checkbox behavior.

Form navigation.

Save/Create functionality.

Data persistence where executed.

Several functional and validation scenarios passed successfully. Failed functional/validation scenarios are documented in the Defects / Failed Test Cases section.

7. Validation Testing
Validation testing covered:

Invalid characters.

Numeric and alphabetic input.

Minimum and maximum field lengths.

Mobile number validation.

Email validation.

Date validation.

Mandatory-field validation.

Validation messages.

The execution identified validation gaps in First Name, Last Name, Mobile Number, date entry, and mandatory-field navigation.

8. UI Testing
UI testing covered:

Visibility of controls.

Field and control presentation.

Dropdown visibility.

Form layout.

Error-message presentation.

Readability and usability.

Most UI checks passed. TC-091, TC-092, and TC-093 identified issues related to the Staff dropdown.

9. Accessibility Testing
Accessibility scenarios were executed for:

Keyboard access to interactive controls.

Logical keyboard focus order.

Visible and meaningful form-control labels.

Visual identification of mandatory fields.

Keyboard interaction with the date picker where supported.

Clear validation messages.

Error messages next to corresponding fields.

Readability without unnecessary horizontal scrolling.

Readability and usability of text, controls, and layout.

The executed accessibility test cases passed.

10. Negative Testing
Negative testing included invalid input, boundary values, invalid dates, missing mandatory values, and other invalid user actions.

The following negative/boundary scenarios failed and require review:

First Name special characters.

First Name trailing spaces.

First Name maximum/exceeding maximum length.

Last Name maximum/exceeding maximum length.

Mobile Number alphabetic/special-character input.

Mobile Number minimum/maximum length.

Invalid manual date entry.

Invalid Email Address validation.

Invalid Mobile Number validation.

11. Defects / Failed Test Cases
The following 18 test cases were marked Fail in the execution sheet.

Test Case ID	Test Case	Actual Result	Expected Result	Priority	Severity
TC-033	Verify First Name rejects special characters	first name field acepts Special charecters .	Validation message is displayed or input is rejected according to business rules.	Major	Validation
TC-036	Verify trailing spaces in First Name	The First Name field accepts the trailing spaces without trimming or displaying any validation message.	Trailing spaces are trimmed or handled according to requirements.	Minor	Validation
TC-038	Verify First Name maximum length	acepts 150 + charecters	it should not acept between 50 charecters	Major	Boundary
TC-039	Verify First Name exceeds maximum length	It acepts more than 51 charecters	Validation message should displayed or extra characters are not accepted.	Major	Boundary
TC-056	Verify Last Name maximum length	No error messages are showing .	System behaves Error message .	Major	Boundary
TC-057	Verify Last Name exceeds maximum length	No validation in this field	Validation message should displayed or additional characters are rejected.	Major	Boundary
TC-064	Verify Mobile Number rejects alphabetic characters	Acepts alphabates	Validation message should displayed or input is rejected.	Major	Validation
TC-065	Verify Mobile Number rejects special characters	It acepts special charecters	Validation message should displayed or input is rejected.	Major	Validation
TC-066	Verify Mobile Number minimum length	The Mobile Number field accepts a number with fewer than 10 digits without displaying any validation message.	Validation should displayed according to business rules.	Major	Boundary
TC-067	Verify Mobile Number maximum length	It acepts 1 value	Validation is displayed or extra digits are rejected.	Major	Boundary
TC-091	Verify Staff dropdown is displayed	Not working .	Dropdown should be visible.	Medium	Minor
TC-092	Verify Staff dropdown displays configured staff	Not working .	Configured staff should displayed.	Major	Functional
TC-093	Verify Staff selection	Staff is selected bydefault .	Selected staff member is displayed correctly.	Minor	Functional
TC-117	Verify invalid manual date entry	It is acepting typing manually date	Validation message should displayed or invalid input is rejected.	Major	Validation
TC-137	Verify multiple checkboxes can be selected together	Not Executed	All selected checkboxes remain checked.	Minor	Functional
TC-145	Verify Next button validates mandatory fields before navigation	after leave mandatory field the page moves to next page .	Validation messages are displayed and navigation is blocked.	Critical	Validation
TC-184	Verify validation message for invalid Email Address	Not showing Any Error message when user leave this text box .	Appropriate validation message should displayed.	Major	Validation
TC-185	Verify validation message for invalid Mobile Number	Not showing Any Error message when user leave this text box .	Appropriate validation message is displayed.	Major	Validation
Defect ID: No defect IDs were entered in the current Excel execution sheet. Failed scenarios should be linked to Jira/bug IDs when defects are formally logged.

12. Skipped Test Cases
The following 21 test cases were marked Skip and were not executed during this test cycle.

Test Case ID	Test Case	Status
TC-031	Verify First Name accepts valid alphabetic characters	Not executed / skipped
TC-032	Verify First Name rejects numeric input	Not executed / skipped
TC-075	Verify Email Address without domain is rejected	Not executed / skipped
TC-079	Verify Email Address is stored after client creation	Not executed / skipped
TC-118	Verify Submitted On persists after navigation	Not executed / skipped
TC-119	Verify Submitted On is stored correctly after client creation	Not executed / skipped
TC-160	Verify Cancel exits client creation without saving data	Not executed / skipped
TC-161	Verify cancelled client is not available in Client Search	Not executed / skipped
TC-189	Verify graceful handling of database save failure	Not executed / skipped
TC-190	Verify application behavior during network interruption while saving	Not executed / skipped
TC-192	Verify validation messages are displayed near the corresponding fields	Not executed / skipped
TC-198	Verify unauthenticated users are redirected to the login page	Not executed / skipped
TC-199	Verify session timeout redirects the user to the login page	Not executed / skipped
TC-200	Verify user cannot continue client creation after session expiry	Not executed / skipped
TC-201	Verify client information is transmitted over HTTPS	Not executed / skipped
TC-202	Verify sensitive client information is protected from unauthorized access	Not executed / skipped
TC-203	Verify application safely handles SQL Injection attempts	Not executed / skipped
TC-204	Verify application safely handles Cross-Site Scripting (XSS) attempts	Not executed / skipped
TC-205	Verify HTML tags are handled safely	Not executed / skipped
TC-206	Verify browser Back button does not bypass authentication after logout	Not executed / skipped
TC-207	Verify bookmarked Create Client URL requires authentication	Not executed / skipped
These cases should be executed in a subsequent test cycle when the required environment, data, permissions, or supporting conditions are available.

13. Test Evidence
Test execution evidence should be maintained with the corresponding test case or defect where applicable.

Recommended evidence includes:

Screenshots for failed UI/validation scenarios.

Request/response evidence for API-related checks.

Database evidence for persistence checks.

Defect references for failed scenarios.

Relevant logs for reliability/security failures.

14. Traceability
Requirement-to-test coverage is maintained separately in:

05-Requirement-Traceability-Matrix.xlsx

Test-case execution details are maintained in:

04-US-001-Create-Client-Test-Cases.xlsx

15. Final Test Result
Overall Status: FAIL / NOT READY FOR FULL PASS

A total of 231 test cases were planned/executed in the current execution sheet:

192 Passed

18 Failed

21 Skipped

The Create Client module requires correction of the identified validation, Staff dropdown, date validation, mandatory-field navigation, and invalid Email/Mobile validation issues before the failed scenarios can be considered passed.

After fixes are deployed, the failed test cases should be retested, and the skipped security, reliability, persistence, and cancellation scenarios should be executed.

16. Related Documents
04-US-001-Create-Client-Test-Cases.xlsx

05-Requirement-Traceability-Matrix.xlsx

01-Requirement-Analysis.md

02-UI-Analysis.md

03-Test-Scenarios.md