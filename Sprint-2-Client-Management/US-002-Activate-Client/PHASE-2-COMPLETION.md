# PHASE 2 – CLIENT MANAGEMENT
## US-002 – Activate Client
### Phase Completion / Current Status Report

---

## 1. Document Information

| Field | Details |
|---|---|
| Project | FinEdge Bank QA Project |
| Phase | Phase 2 – Client Management |
| User Story | US-002 – Activate Client |
| Module | Client Management |
| Domain | Banking / BFSI |
| Priority | High |
| Story Points | 5 |
| Execution Date | 19 September 2026 |
| Current Status | **In Progress** |

---

## 2. User Story

**US-002 – Activate Client**

> As a bank employee, I want to activate an existing client so that the client can access banking services.

---

## 3. Objective

The objective of US-002 is to verify that an eligible existing client can be activated successfully and that the activation state is correctly reflected across the application, API, and database.

---

## 4. Phase 2 Deliverables Status

| # | Deliverable | Status |
|---|---|---|
| 1 | Requirement Analysis | Completed |
| 2 | UI Analysis | Completed |
| 3 | Test Scenarios | Completed |
| 4 | Test Cases | Completed |
| 5 | Requirement Traceability Matrix | Completed |
| 6 | Manual Testing | Executed |
| 7 | API Testing | Partially Executed |
| 8 | SQL Validation | Partially Executed |
| 9 | Selenium Automation | Pending |
| 10 | Bug Reports | Updated – 1 Open Defect |
| 11 | Test Execution Report | Updated |
| 12 | Postman Collection | In Progress |
| 13 | Phase 2 Completion | Pending |

---

## 5. Test Execution Summary

A total of **26 test cases** are defined for US-002.

| Metric | Count |
|---|---:|
| Total Test Cases | 26 |
| Passed | 25 |
| Failed | 1 |
| Not Executed | 0 |
| Pass Rate | 96.15% |
| Current Result | **PASS WITH 1 FAILURE** |

> Pass rate is calculated as 25 / 26 × 100.

---

## 6. Failed Test Case

### TC-008 – Verify Three-Dot Menu is Displayed/Clickable

**Status:** FAIL

**Expected Result:**

The three-dot menu should be visible and clickable so that client actions can be accessed.

**Actual Result:**

The three-dot menu is displayed, but it is not clickable as expected.

**Defect:**

`BUG-001`

**Defect Status:** Open

**Retest:** Pending

The defect is documented in:

```text
10-Bug-Reports.xlsx
```

---

## 7. Security Validation

### TC-019 – Unauthorized User Cannot Activate Client

**Status:** PASS

The unauthorized-user activation scenario was executed and the configured access-control behavior prevented unauthorized activation.

---

## 8. API Validation

### TC-021 – Successful Client Activation Through API

**Status:** PASS**

The activation API was executed using Postman.

### Request

```text
POST {{baseUrl}}/clients/11?command=activate
```

### Response

```text
HTTP 200 OK
```

Response:

```json
{
  "officeId": 2,
  "clientId": 11,
  "resourceId": 11
}
```

The resulting client status was also verified in the Mifos UI.

---

## 9. Database Validation

### TC-022 – Verify Client Status in Database

**Status:** PASS

The client activation result was validated in PostgreSQL using the `m_client` table.

Validation query:

```sql
SELECT
    id,
    display_name,
    status_enum,
    activation_date
FROM m_client
WHERE id = 11;
```

The database reflected the expected activation information.

---

## 10. Current Testing Evidence

The following validation chain has been executed successfully:

```text
Postman API
     ↓
HTTP 200 OK
     ↓
Client ID 11 activated
     ↓
Mifos UI shows Active
     ↓
PostgreSQL m_client reflects activation
```

This confirms the executed API/UI/database path for the selected client.

---

## 11. Documentation Completed

The following US-002 documents have been prepared/updated:

```text
01-Requirement-Analysis.md
02-UI-Analysis.md
03-Test-Scenarios.md
04-US-002-Activate-Client-Test-Cases.xlsx
05-US-002-Activate-Client-Requirement-Traceability-Matrix.xlsx
06-US-002-Activate-Client-Manual-Testing.md
07-US-002-Activate-Client-API-Testing.md
08-US-002-Activate-Client-SQL-Validation.md
10-Bug-Reports.xlsx
11-Test-Execution.md
```

---

## 12. Remaining Activities

US-002 is **not yet ready for final Phase 2 closure**.

Remaining activities are:

1. Continue positive API test cases.
2. Execute negative API test cases.
3. Continue positive database validations.
4. Execute negative database validations.
5. Complete Selenium automation.
6. Investigate/fix BUG-001.
7. Re-test TC-008 after the fix.
8. Update final test execution results.
9. Complete Postman collection/documentation.
10. Perform final traceability and documentation review.

---

## 13. Phase 2 Exit Criteria

US-002 can be considered ready for final completion when:

- All required test cases have been executed.
- Open defects have been resolved or formally accepted.
- Failed test cases have been re-tested.
- API positive and negative testing is completed.
- SQL positive and negative validation is completed.
- Selenium automation is completed as planned.
- Automation results are documented.
- Bug reports are finalized.
- Test execution report is finalized.
- Postman collection is added to the repository.
- Final requirement traceability is verified.

---

## 14. Current Conclusion

US-002 – Activate Client has completed the current manual execution cycle with:

**25 PASS / 1 FAIL out of 26 test cases.**

API and database validation has successfully confirmed the activation flow for the executed client.

One UI defect remains open:

```text
BUG-001 – TC-008
Three-dot menu is displayed but not clickable
```

Therefore:

> **US-002 – Activate Client: IN PROGRESS**

Final Phase 2 completion should be declared only after the remaining API/database positive and negative testing, Selenium automation, defect re-test, and final documentation activities are completed.
