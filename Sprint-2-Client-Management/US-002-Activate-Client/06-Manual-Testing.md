# US-002 – Activate Client – Manual Testing

## 1. Document Information

| Field | Details |
|---|---|
| Story ID | US-002 |
| Story Name | Activate Client |
| Module | Client Management |
| Priority | High |
| Story Points | 5 |
| Testing Type | Manual Functional Testing |
| Application | Mifos Web Application |
| Environment | Local QA/Test Environment |
| Base URL | `http://localhost:4200/` |
| Status | In Progress |

---

## 2. Testing Objective

The objective of manual testing for US-002 is to verify that an authorized bank employee can activate an eligible existing client and that the client status is correctly updated and persisted.

The testing also verifies:

- Client search and navigation
- Current client status
- Activation action
- Activation feedback
- Status update
- Persistence after refresh/reopen
- Already-active client behavior
- Failed activation behavior
- Error handling
- Authorization behavior
- Impact on other client records

---

## 3. Preconditions

Before starting execution:

1. Mifos/Fineract application is running.
2. User is logged in with an authorized bank employee account.
3. At least one existing client is available.
4. A client eligible for activation is available.
5. The selected client can be searched from the Clients page.
6. Test data is available for negative and regression scenarios where required.

---

## 4. Navigation Flow

The expected manual navigation flow is:

```text
Login
  ↓
Clients
  ↓
Search / Locate Client
  ↓
Select Client Name
  ↓
Client General / Profile Page
  ↓
Three-dot Menu
  ↓
Actions
  ↓
Activate
  ↓
Activation Process
  ↓
Verify Client Status
```

---

## 5. Test Environment

### Application URL

```text
http://localhost:4200/
```

### Clients Page

```text
http://localhost:4200/#/clients
```

### Client Profile

The client profile is opened by selecting the client name from the Clients page.

Example observed profile URL:

```text
http://localhost:4200/#/clients/29/general
```

The client ID is dynamic and should not be hard-coded in automation.

---

# 6. Positive Test Execution

## MT-001 – Verify Clients Page Loads

### Steps

1. Login to the Mifos application.
2. Navigate to **Clients**.
3. Observe the Clients page.

### Expected Result

- Clients page loads successfully.
- Client search field is displayed.
- Client records are displayed.
- Table columns are available.

### Observed UI

Search placeholder:

```text
Search by client name, external Id, mobile
```

Observed table columns:

```text
Name
Status
Account No.
External ID
Office Name
Actions
```

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## MT-002 – Search Client by Name

### Steps

1. Open the Clients page.
2. Enter a valid client name in the search field.
3. Execute the search.
4. Observe the result.

### Expected Result

The matching client record should be displayed.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## MT-003 – Search Client by External ID

### Steps

1. Open the Clients page.
2. Enter a valid External ID.
3. Execute the search.
4. Observe the result.

### Expected Result

The corresponding client should be displayed.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## MT-004 – Search Client by Mobile Number

### Steps

1. Open the Clients page.
2. Enter a valid mobile number.
3. Execute the search.
4. Observe the result.

### Expected Result

The corresponding client should be displayed.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## MT-005 – Verify Pending Client

### Steps

1. Search for an eligible client.
2. Locate the client in the result table.
3. Check the Status column.

### Expected Result

The selected client should show its current status. For the activation scenario, an eligible pending client should be available.

### Example Observed Data

```text
Name: Ajit695423 Kumar Test695423
Status: PENDING
Account No.: 000000028
External ID: EXT695423
Office: Mumbai Branch
```

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## MT-006 – Open Client Profile

### Steps

1. Search for the required client.
2. Click the client name.
3. Observe the client profile page.

### Expected Result

The selected client's General/Profile page should open.

### Observed Profile

Tabs include:

```text
General
Personal Data
Address
Family Members
Identities
Documents
Notes
```

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## MT-007 – Verify Client Information

### Steps

1. Open the client profile.
2. Verify the displayed client information.
3. Compare the information with the selected client record.

### Expected Result

The profile should display information belonging to the selected client.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## MT-008 – Verify Three-dot Menu

### Steps

1. Open the client profile.
2. Locate the three-dot menu.
3. Click the menu.

### Expected Result

The menu should open and display available client actions.

Observed options include:

```text
Edit
Actions
Assign Staff
More
```

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## MT-009 – Verify Actions Submenu

### Steps

1. Open the three-dot menu.
2. Select **Actions**.
3. Observe the submenu.

### Expected Result

The Actions submenu should be displayed.

Observed options include:

```text
Close
Transfer Client
Activate
Withdraw
Reject
Delete
```

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## MT-010 – Verify Activate Option

### Steps

1. Open the client profile.
2. Click the three-dot menu.
3. Click **Actions**.
4. Locate **Activate**.

### Expected Result

The Activate option should be available for an eligible client.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## MT-011 – Activate Eligible Client

### Steps

1. Open an eligible client profile.
2. Open the three-dot menu.
3. Select **Actions**.
4. Select **Activate**.
5. Complete the activation process presented by the application.
6. Observe the result.

### Expected Result

The eligible client should be successfully activated.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## MT-012 – Verify Client Status After Activation

### Steps

1. Complete client activation.
2. Observe the client profile/status.
3. Verify the status after activation.

### Expected Result

The application should display the client's active status after successful activation.

> The exact final status label should be confirmed during execution rather than assumed in advance.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

# 7. Persistence Testing

## MT-013 – Verify Status After Page Refresh

### Steps

1. Successfully activate the client.
2. Refresh the browser page.
3. Observe the client status.

### Expected Result

The activated status should remain unchanged after refresh.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## MT-014 – Verify Status After Reopening Client

### Steps

1. Successfully activate the client.
2. Navigate away from the client profile.
3. Search for the same client again.
4. Open the client profile.

### Expected Result

The updated client status should remain persisted.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

# 8. Negative Testing

## MT-015 – Attempt to Activate Already Active Client

### Steps

1. Locate a client that is already active.
2. Open the client profile.
3. Open the three-dot menu.
4. Select Actions.
5. Observe the Activate option/action.

### Expected Result

The system should not allow an already active client to be activated again, or should provide appropriate validation/feedback.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## MT-016 – Cancel Activation

### Steps

1. Open an eligible client.
2. Select Actions → Activate.
3. If a confirmation/cancellation control is presented, select Cancel.
4. Observe the client status.

### Expected Result

Activation should be cancelled and the client's previous status should remain unchanged.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

> The exact confirmation/cancellation UI is to be validated during execution.

---

## MT-017 – Verify Status After Failed Activation

### Steps

1. Attempt activation using a condition that causes activation to fail.
2. Observe the application response.
3. Check the client status.

### Expected Result

- Appropriate failure handling should occur.
- Client status should not be incorrectly changed.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## MT-018 – Verify Activation Error Message

### Steps

1. Trigger a valid activation failure condition.
2. Observe the application message.

### Expected Result

The application should display appropriate error/validation feedback.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

> Exact error message wording should be captured during execution.

---

# 9. Security / Authorization Testing

## MT-019 – Verify Unauthorized User Cannot Activate Client

### Steps

1. Login using a user without the required activation permission.
2. Navigate to the client profile.
3. Open the Actions menu.
4. Check the Activate option.
5. If available, attempt activation.

### Expected Result

The unauthorized user should not be able to perform client activation.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

> The exact permission configuration must be available in the test environment before execution.

---

# 10. Data Validation Testing

## MT-020 – Verify Only Selected Client Is Activated

### Steps

1. Identify two or more client records.
2. Select one eligible client.
3. Activate the selected client.
4. Check the status of the selected client.
5. Check the status of other client records.

### Expected Result

- Only the selected client should be affected.
- Other client records should remain unchanged.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

# 11. API Validation

## MT-021 – Verify Client Activation Through API

### Steps

1. Identify the API endpoint used for client activation.
2. Prepare the required authentication and headers.
3. Send the activation request.
4. Verify the response.
5. Verify the client's resulting status.

### Expected Result

- API should process the activation request correctly.
- Response should indicate the appropriate result.
- Client status should be updated according to the API response.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

> The exact activation endpoint and request payload are to be identified/validated during API testing.

---

# 12. SQL Validation

## MT-022 – Verify Client Status in Database

### Steps

1. Identify the client ID.
2. Connect to the test database.
3. Query the relevant client record.
4. Check the stored client status before activation.
5. Activate the client through the application.
6. Query the client record again.
7. Compare the status.

### Expected Result

The database should contain the updated client status after successful activation.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

> The exact database table and column should be confirmed from the application's database schema before execution.

---

# 13. Integration Testing

## MT-023 – Verify UI and API Status Consistency

### Steps

1. Activate the client through the UI.
2. Retrieve the client information through the API.
3. Compare the status shown by UI and API.

### Expected Result

UI and API should report the same client status.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## MT-024 – Verify UI and Database Status Consistency

### Steps

1. Activate the client through the UI.
2. Verify the status in the UI.
3. Query the corresponding client record in the database.
4. Compare the values.

### Expected Result

The UI status and database status should be consistent.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

# 14. Regression Testing

## MT-025 – Verify Activation After Browser Refresh

### Steps

1. Activate an eligible client.
2. Refresh the browser.
3. Navigate back to the client profile.
4. Verify the status.

### Expected Result

The client should remain in the updated status after refresh.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## MT-026 – Verify Other Client Records Are Unaffected

### Steps

1. Identify multiple clients.
2. Record their current statuses.
3. Activate one eligible client.
4. Recheck the other clients.

### Expected Result

Only the selected client should be updated. Other client records should remain unchanged.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

# 15. Test Data

The following data has been observed during UI analysis and can be used as reference data, subject to availability in the current environment.

| Field | Example |
|---|---|
| Client Name | Ajit695423 Kumar Test695423 |
| Status | PENDING |
| Account No. | 000000028 |
| External ID | EXT695423 |
| Office | Mumbai Branch |

Another observed client:

| Field | Example |
|---|---|
| Client Name | Ajit734492 Kumar Test734492 |
| Account No. | 000000029 |
| External ID | EXT734492 |
| Office | Mumbai Branch |
| Client Classification | Regular |
| Client Type | Business |
| Staff | Unassigned |
| Mobile | 9817734492 |
| Email | ajit.test.734492@gmail.com |

> Test data should be revalidated before execution because client records can change between test runs.

---

# 16. Defect Reporting

If any test case fails, create a defect with the following information:

| Field | Details |
|---|---|
| Defect ID | BUG-XXX |
| Test Case ID | TC-XXX |
| Summary | Short description |
| Module | Client Management |
| Story | US-002 |
| Environment | QA/Test |
| Preconditions | Required setup |
| Steps to Reproduce | Detailed steps |
| Expected Result | Expected behavior |
| Actual Result | Actual behavior |
| Severity | Critical/High/Medium/Low |
| Priority | High/Medium/Low |
| Evidence | Screenshot/Video/Logs |
| Status | New |

---

# 17. Manual Test Execution Summary

| Metric | Count |
|---|---:|
| Total Manual Test Cases | 26 |
| Executed | 0 |
| Passed | 0 |
| Failed | 0 |
| Blocked | 0 |
| Not Executed | 26 |
| Defects Raised | 0 |

The execution counts should be updated after actual test execution.

---

# 18. Entry Criteria

Manual execution can begin when:

- Mifos application is available.
- Login is working.
- Required test user is available.
- Eligible client data is available.
- Client Management module is accessible.
- Required test environment is stable.

---

# 19. Exit Criteria

Testing can be considered complete when:

- All applicable test cases are executed.
- Critical/High defects are resolved or formally accepted.
- Activation behavior is verified.
- Status persistence is verified.
- Negative scenarios are executed.
- API and SQL validations are completed where applicable.
- Regression checks are completed.
- Test execution results are documented.

---

# 20. Current Testing Status

**US-002 – Activate Client:** `In Progress`

### Completed

- Requirement Analysis
- UI Analysis
- Test Scenarios
- Test Cases
- Requirement Traceability Matrix

### Pending

- Manual Test Execution
- API Testing
- SQL Validation
- Selenium Automation
- Bug Reporting
- Test Execution Report
- Sprint documentation update

---

# 21. Next Activity

The next activity is to execute the manual test cases starting with:

```text
TC-001 → TC-026
```

During execution, record:

```text
Actual Result
Status
Defect ID (if failed)
Evidence
```

After manual execution, update the execution results before starting API, SQL, and Selenium automation activities.
