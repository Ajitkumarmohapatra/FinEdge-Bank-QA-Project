# US-002 – Activate Client
## Test Execution Report

---

## 1. Document Information

| Field | Details |
|---|---|
| User Story | US-002 – Activate Client |
| Module | Client Management |
| Project | FinEdge Bank QA Project |
| Domain | Banking / BFSI |
| Test Type | Manual, API, SQL, Integration |
| Execution Date | 19 September 2026 |
| Total Test Cases | 26 |
| Passed | 25 |
| Failed | 1 |
| Not Executed | 0 |
| Overall Result | **PASS WITH 1 FAILURE** |

---

## 2. Execution Objective

The objective of this test execution is to verify the complete client activation functionality.

The testing covers:

- Client search and identification
- Client profile navigation
- Client status verification
- Activate client functionality
- Activation validation
- Negative and security scenarios
- API validation
- Database validation
- UI/API consistency
- UI/Database consistency
- Regression validation

---

## 3. Test Execution Summary

| Test Type | Total | Passed | Failed | Not Executed |
|---|---:|---:|---:|---:|
| Functional Testing | 12 | 11 | 1 | 0 |
| Negative Testing | 4 | 4 | 0 | 0 |
| Security Testing | 1 | 1 | 0 | 0 |
| Data Validation | 1 | 1 | 0 | 0 |
| API Testing | 1 | 1 | 0 | 0 |
| SQL Testing | 1 | 1 | 0 | 0 |
| Integration Testing | 2 | 2 | 0 | 0 |
| Regression Testing | 2 | 2 | 0 | 0 |
| Other Validation | 2 | 2 | 0 | 0 |
| **Total** | **26** | **25** | **1** | **0** |

---

## 4. Test Case Execution Status

| Test Case ID | Test Description | Status |
|---|---|---|
| TC-001 | Navigate to Clients module | PASS |
| TC-002 | Search existing client | PASS |
| TC-003 | Select client from search results | PASS |
| TC-004 | Verify client profile page | PASS |
| TC-005 | Verify current client status | PASS |
| TC-006 | Verify three-dot action menu | PASS |
| TC-007 | Verify Actions submenu | PASS |
| TC-008 | Verify three-dot menu is displayed/clickable | **FAIL** |
| TC-009 | Verify Activate option | PASS |
| TC-010 | Activate pending client | PASS |
| TC-011 | Verify activation confirmation | PASS |
| TC-012 | Verify client status changes to Active | PASS |
| TC-013 | Verify already active client behavior | PASS |
| TC-014 | Verify invalid activation behavior | PASS |
| TC-015 | Verify activation failure handling | PASS |
| TC-016 | Verify client remains unchanged after failed activation | PASS |
| TC-017 | Verify activation data validation | PASS |
| TC-018 | Verify activation date validation | PASS |
| TC-019 | Verify unauthorized user activation | PASS |
| TC-020 | Verify client data after activation | PASS |
| TC-021 | Verify client activation through API | PASS |
| TC-022 | Verify client status in database after activation | PASS |
| TC-023 | Verify UI/API status consistency | PASS |
| TC-024 | Verify UI/database status consistency | PASS |
| TC-025 | Verify activation status after page refresh | PASS |
| TC-026 | Verify other client records remain unaffected | PASS |

---

## 5. Failed Test Case

### TC-008 – Verify Three-Dot Menu is Displayed/Clickable

**Status:** FAIL

**Expected Result:**

The three-dot menu should be displayed and should be clickable.

**Actual Result:**

The three-dot menu is displayed, but the menu is not clickable as expected.

**Impact:**

The user cannot directly interact with the three-dot menu as expected during this test scenario.

**Defect Status:**

Open – to be documented in the Bug Report.

---

## 6. API Testing Result

### TC-021 – Activate Client Through API

**Status:** PASS

The client activation API was tested using Postman.

**Request:**

```text
POST /clients/{clientId}?command=activate