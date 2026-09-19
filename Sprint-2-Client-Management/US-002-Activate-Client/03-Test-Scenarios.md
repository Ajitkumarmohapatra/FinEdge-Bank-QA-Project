# US-002 – Activate Client

# 03-Test-Scenarios

---

# 1. Test Scenario Overview

| Item | Details |
|------|---------|
| Story ID | US-002 |
| User Story | Activate Client |
| Module | Client Management |
| Priority | High |
| Story Points | 5 |
| Testing Type | Functional Testing |
| Application | Mifos / Apache Fineract |
| Environment | Local Development |
| Status | In Progress |

---

# 2. Test Objective

The objective of testing is to verify that an authorized bank employee can successfully activate an eligible existing client and that the client's status is updated correctly.

The testing will also verify:

- Client navigation
- Client search
- Client selection
- Client profile
- Three-dot action menu
- Actions submenu
- Activate option
- Activation processing
- Client status update
- Status persistence
- Negative scenarios
- Authorization behavior
- Error handling
- API validation
- SQL validation
- UI/API/Database data consistency

---

# 3. Application Navigation

The verified UI navigation path is:

```text
Clients
   ↓
Search / Locate Client
   ↓
Select Client Name
   ↓
Client General Page
   ↓
Three-Dot Menu
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

# 4. Preconditions

The following conditions should be satisfied before executing the test scenarios:

1. Mifos application should be available.
2. User should be successfully authenticated.
3. User should have appropriate Client Management permissions.
4. An existing client should be available.
5. The client should be in an eligible status for activation.
6. Required test data should be available.
7. API access should be available for API validation.
8. Database access should be available for SQL validation.

---

# 5. Test Data

Example client observed during UI analysis:

| Field | Value |
|------|-------|
| Client Name | Ajit734492 Kumar Test734492 |
| Account No. | 000000029 |
| External ID | EXT734492 |
| Office | Mumbai Branch |
| Client Classification | Regular |
| Client Type | Business |
| Staff | Unassigned |
| Current Status | PENDING |

The actual test data may vary between executions.

---

# 6. Test Scenario Summary

| Scenario ID | Test Scenario | Priority | Type |
|-------------|---------------|----------|------|
| TS-001 | Verify Clients page loads successfully | High | Positive |
| TS-002 | Verify client search using client name | High | Positive |
| TS-003 | Verify client search using external ID | High | Positive |
| TS-004 | Verify client search using mobile number | High | Positive |
| TS-005 | Verify Pending client is displayed | High | Positive |
| TS-006 | Verify client profile can be opened | High | Positive |
| TS-007 | Verify client information is displayed correctly | High | Validation |
| TS-008 | Verify three-dot menu is displayed | High | Positive |
| TS-009 | Verify Actions submenu is displayed | High | Positive |
| TS-010 | Verify Activate option is displayed | High | Positive |
| TS-011 | Verify eligible client can be activated | Critical | Positive |
| TS-012 | Verify client status after activation | Critical | Validation |
| TS-013 | Verify activation status persists after refresh | High | Regression |
| TS-014 | Verify activation status persists after reopening client | High | Regression |
| TS-015 | Verify already Active client cannot be activated again | High | Negative |
| TS-016 | Verify activation cancellation | Medium | Negative |
| TS-017 | Verify failed activation does not change client status | High | Negative |
| TS-018 | Verify activation error message | High | Negative |
| TS-019 | Verify unauthorized user cannot activate client | High | Security |
| TS-020 | Verify only selected client is activated | Critical | Validation |
| TS-021 | Verify activation through API | High | API |
| TS-022 | Verify client status in database after activation | Critical | SQL |
| TS-023 | Verify UI and API status consistency | High | Integration |
| TS-024 | Verify UI and database status consistency | High | Integration |
| TS-025 | Verify activation after page refresh | Medium | Regression |
| TS-026 | Verify other client records remain unaffected | Medium | Regression |

---

# 7. Functional Test Scenarios

## TS-001 – Verify Clients Page Loads Successfully

### Objective

Verify that the Client Management page loads successfully.

### Expected Result

The Clients page should load successfully and display the client list.

---

## TS-002 – Verify Client Search Using Client Name

### Objective

Verify that an existing client can be located using the client name.

### Test Data

```text
Ajit734492 Kumar Test734492
```

### Expected Result

The matching client should be displayed in the client list.

---

## TS-003 – Verify Client Search Using External ID

### Objective

Verify that an existing client can be located using the External ID.

### Test Data

```text
EXT734492
```

### Expected Result

The corresponding client should be displayed.

---

## TS-004 – Verify Client Search Using Mobile Number

### Objective

Verify that an existing client can be located using the mobile number.

### Test Data

```text
9817734492
```

### Expected Result

The corresponding client should be displayed.

---

## TS-005 – Verify Pending Client Is Displayed

### Objective

Verify that an eligible Pending client is displayed in the Client List.

### Expected Result

The client should be displayed with its current status.

Example:

```text
PENDING
```

---

## TS-006 – Verify Client Profile Can Be Opened

### Objective

Verify that the user can open the selected client profile.

### Expected Result

The selected client's General/Profile page should open successfully.

---

## TS-007 – Verify Client Information Is Displayed Correctly

### Objective

Verify that the selected client's information is displayed correctly.

### Validation Fields

- Client Name
- Office
- Account No.
- External ID
- Staff
- Client Type
- Client Classification
- Mobile Number
- Email

### Expected Result

The displayed information should correspond to the selected client.

---

## TS-008 – Verify Three-Dot Menu Is Displayed

### Objective

Verify that the three-dot menu is available on the client profile.

### Expected Result

The three-dot menu should be visible and clickable.

---

## TS-009 – Verify Actions Submenu Is Displayed

### Objective

Verify that the Actions submenu is available from the three-dot menu.

### Expected Result

The Actions submenu should open successfully.

---

## TS-010 – Verify Activate Option Is Displayed

### Objective

Verify that the Activate option is available for an eligible client.

### Expected Result

The Actions submenu should contain:

```text
Activate
```

---

## TS-011 – Verify Eligible Client Can Be Activated

### Objective

Verify that an eligible Pending client can be activated successfully.

### Steps

1. Open the Clients page.
2. Search for the required client.
3. Open the client profile.
4. Click the three-dot menu.
5. Open Actions.
6. Select Activate.
7. Complete the activation process.

### Expected Result

The activation operation should complete successfully.

---

## TS-012 – Verify Client Status After Activation

### Objective

Verify that the client status is updated after successful activation.

### Expected Result

The client's status should change from its previous eligible status to the active status displayed by the application.

The exact final status label should be confirmed during execution.

---

# 8. Negative Test Scenarios

## TS-015 – Verify Already Active Client Cannot Be Activated Again

### Objective

Verify the behavior when activation is attempted for a client who is already Active.

### Expected Result

The system should prevent invalid duplicate activation or provide appropriate handling.

---

## TS-016 – Verify Activation Cancellation

### Objective

Verify that the user can cancel the activation operation where cancellation is provided by the application.

### Expected Result

The activation should not be completed and the client status should remain unchanged.

---

## TS-017 – Verify Failed Activation Does Not Change Client Status

### Objective

Verify that a failed activation does not incorrectly update the client status.

### Expected Result

The client's original status should remain unchanged.

---

## TS-018 – Verify Activation Error Message

### Objective

Verify that an appropriate error message is displayed when activation fails.

### Expected Result

The system should display a meaningful error or validation message.

---

# 9. Security and Authorization Scenarios

## TS-019 – Verify Unauthorized User Cannot Activate Client

### Objective

Verify that a user without the required permission cannot activate a client.

### Expected Result

The system should prevent unauthorized activation according to the configured permission model.

---

# 10. Client Data Validation Scenarios

## TS-020 – Verify Only Selected Client Is Activated

### Objective

Verify that activation is performed against the intended client only.

### Expected Result

Only the selected client should have its status updated.

Other client records should remain unchanged.

---

# 11. API Testing Scenarios

## TS-021 – Verify Client Activation Through API

### Objective

Verify the client activation operation through the appropriate backend API.

### Validation

The following should be verified:

- Request method
- Endpoint
- Authentication
- Required headers
- Request payload
- Response status
- Response body
- Client status

### Expected Result

The API should return a successful response for a valid activation request and the client's status should be updated correctly.

### Note

The exact API endpoint and request structure will be documented during API analysis and Postman testing.

---

# 12. SQL Validation Scenarios

## TS-022 – Verify Client Status in Database After Activation

### Objective

Verify that the client's status is correctly updated in the database after successful activation.

### Validation

Verify:

- Client record
- Client identifier
- Client status
- Status-related fields
- Updated timestamp, where applicable

### Expected Result

The database should contain the updated status corresponding to the activated client.

### Note

The exact database table and column names will be identified during SQL validation.

---

# 13. Integration Test Scenarios

## TS-023 – Verify UI and API Status Consistency

### Objective

Verify that the client status displayed in the UI matches the status returned by the backend API.

### Expected Result

The UI and API should display the same client status.

---

## TS-024 – Verify UI and Database Status Consistency

### Objective

Verify that the client status displayed in the UI matches the value stored in the database.

### Expected Result

The UI and database should contain the same client status.

---

# 14. Regression Test Scenarios

## TS-025 – Verify Activation After Page Refresh

### Objective

Verify that the activated client's status remains correct after refreshing the application.

### Expected Result

The updated client status should remain unchanged after refresh.

---

## TS-026 – Verify Other Client Records Remain Unaffected

### Objective

Verify that activating one client does not negatively affect other client records.

### Expected Result

Other clients and their statuses should remain unchanged.

---

# 15. End-to-End Activation Scenario

The complete business flow should be validated as an end-to-end scenario.

```text
Login
   ↓
Clients
   ↓
Search Client
   ↓
Select Pending Client
   ↓
Open Client Profile
   ↓
Three-Dot Menu
   ↓
Actions
   ↓
Activate
   ↓
Complete Activation
   ↓
Verify Client Status
   ↓
Refresh Client Profile
   ↓
Verify Status Persistence
   ↓
API Validation
   ↓
SQL Validation
```

---

# 16. Test Scenario Coverage

| Testing Area | Covered |
|--------------|---------|
| Client Navigation | ✅ |
| Client Search | ✅ |
| Client Profile | ✅ |
| Client Information | ✅ |
| Client Status | ✅ |
| Three-Dot Menu | ✅ |
| Actions Menu | ✅ |
| Activate Option | ✅ |
| Activation | ✅ |
| Positive Scenarios | ✅ |
| Negative Scenarios | ✅ |
| Security / Authorization | ✅ |
| API Testing | ✅ |
| SQL Validation | ✅ |
| Integration Testing | ✅ |
| Regression Testing | ✅ |
| Data Consistency | ✅ |

---

# 17. Scenario Completion Criteria

US-002 test scenarios will be considered complete when:

- All identified scenarios have corresponding test cases.
- Positive scenarios are covered.
- Negative scenarios are covered.
- Security and authorization scenarios are covered.
- API validation scenarios are covered.
- SQL validation scenarios are covered.
- Integration scenarios are covered.
- Regression scenarios are covered.
- All requirements have traceable test coverage.

---

# 18. Test Execution Preparation

After completion of the test scenarios, the following activities will be performed:

1. Prepare detailed test cases.
2. Prepare Requirement Traceability Matrix.
3. Execute manual testing.
4. Perform API testing using Postman.
5. Perform SQL/database validation.
6. Develop Selenium automation.
7. Execute automated test cases.
8. Record defects.
9. Prepare test execution report.
10. Complete US-002 documentation.

---

# 19. Test Scenario Status

| Activity | Status |
|----------|--------|
| Requirement Analysis | ✅ Completed |
| UI Analysis | ✅ Completed |
| Test Scenarios | 🟡 In Progress |
| Test Cases | ⏳ Not Started |
| Requirement Traceability Matrix | ⏳ Not Started |
| Manual Testing | ⏳ Not Started |
| API Testing | ⏳ Not Started |
| SQL Validation | ⏳ Not Started |
| Selenium Automation | ⏳ Not Started |
| Bug Reporting | ⏳ Not Started |
| Test Execution Report | ⏳ Not Started |

---

# 20. Conclusion

The **US-002 – Activate Client** test scenarios cover the complete client activation workflow from locating an eligible client through activation and status verification.

The primary UI workflow is:

```text
Clients
   ↓
Search / Locate Client
   ↓
Select Client
   ↓
Client General Page
   ↓
Three-Dot Menu
   ↓
Actions
   ↓
Activate
   ↓
Activation
   ↓
Status Verification
```

The next activity is to create detailed test cases based on these scenarios.

**Next Document:** `04-US-002-Activate-Client-Test-Cases.xlsx`
