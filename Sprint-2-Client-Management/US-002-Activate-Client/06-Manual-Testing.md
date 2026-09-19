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
| Execution Date | 19 September 2026 |
| Status | In Progress |

---

## 2. Testing Objective

The objective of manual testing for US-002 is to verify that an authorized bank employee can activate an eligible existing client and that the resulting client status is correctly maintained.

The execution covered:

- Client search and navigation
- Client profile verification
- Three-dot menu and Actions
- Client activation
- Activation/status validation
- Negative scenarios
- Authorization validation
- Data validation
- Integration checks
- Regression checks

---

## 3. Navigation Flow

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

## 4. Observed Application Details

Clients page:

```text
http://localhost:4200/#/clients
```

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

Client profile example:

```text
http://localhost:4200/#/clients/11/general
```

Observed client used during activation validation:

| Field | Value |
|---|---|
| Client Name | Temp postman Customer |
| Client ID | 11 |
| Account No. | 000000011 |
| Status before activation | PENDING |
| Office | Mumbai Branch |
| Activation Date | 19 September 2026 |

---

## 5. Manual Execution Summary

The test case sheet contains 26 test cases.

| Metric | Count |
|---|---:|
| Total Test Cases | 26 |
| Passed | 25 |
| Failed | 1 |
| Not Executed | 0 |
| Execution Result | **PASS WITH 1 FAILURE** |

The failed test case is **TC-008**.

---

## 6. Test Case Execution Status

| Test Case ID | Test Description | Status |
|---|---|---|
| TC-001 | Verify Clients page loads successfully | PASS |
| TC-002 | Verify client search using client name | PASS |
| TC-003 | Verify client search using external ID | PASS |
| TC-004 | Verify client search using mobile number | PASS |
| TC-005 | Verify Pending client is displayed | PASS |
| TC-006 | Verify client profile can be opened | PASS |
| TC-007 | Verify client information is displayed correctly | PASS |
| TC-008 | Verify three-dot menu is displayed/clickable | **FAIL** |
| TC-009 | Verify Actions submenu is displayed | PASS |
| TC-010 | Verify Activate option is displayed | PASS |
| TC-011 | Verify eligible client can be activated | PASS |
| TC-012 | Verify client status after activation | PASS |
| TC-013 | Verify activation status persists after refresh | PASS |
| TC-014 | Verify activation status persists after reopening client | PASS |
| TC-015 | Verify already Active client cannot be activated again | PASS |
| TC-016 | Verify activation cancellation | PASS |
| TC-017 | Verify failed activation does not change client status | PASS |
| TC-018 | Verify activation error message | PASS |
| TC-019 | Verify unauthorized user cannot activate client | PASS |
| TC-020 | Verify client data after activation | PASS |
| TC-021 | Verify client activation through API | PASS |
| TC-022 | Verify client status in database after activation | PASS |
| TC-023 | Verify UI/API status consistency | PASS |
| TC-024 | Verify UI/database status consistency | PASS |
| TC-025 | Verify activation status after page refresh | PASS |
| TC-026 | Verify other client records remain unaffected | PASS |

---

## 7. Failed Test Case

### TC-008 – Verify Three-Dot Menu is Displayed/Clickable

**Status:** FAIL

**Expected Result:**

The three-dot menu should be visible and clickable so that the available client actions can be accessed.

**Actual Result:**

The three-dot menu is displayed, but it is not clickable as expected.

**Defect:**

This failure will be documented in `10-Bug-Reports.xlsx`.

---

## 8. Security Testing

### TC-019 – Verify Unauthorized User Cannot Activate Client

**Status:** PASS

The unauthorized-user activation scenario was executed and the configured access-control behavior prevented unauthorized activation.

---

## 9. Regression Testing

The following regression scenarios passed:

- TC-013 – Activation status persists after browser refresh
- TC-014 – Activation status persists after reopening the client
- TC-025 – Activation status remains after refresh
- TC-026 – Other client records remain unaffected

---

## 10. Current Status

**US-002 – Activate Client:** `In Progress`

Completed:

- Requirement Analysis
- UI Analysis
- Test Scenarios
- Test Cases
- Requirement Traceability Matrix
- Manual test execution
- API validation for executed API case
- SQL validation for executed SQL case

Pending:

- Selenium Automation
- Bug Report finalization
- Re-test of TC-008 after defect fix
- Final Test Execution update
- Phase-2 completion

---

## 11. Next Activity

Proceed with:

```text
09 – Selenium Automation
```

The failed TC-008 should also be tracked in the bug report and re-tested after the issue is fixed.
