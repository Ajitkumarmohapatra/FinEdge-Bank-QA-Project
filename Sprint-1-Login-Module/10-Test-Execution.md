# Sprint 1 – Login Module
# Test Execution Report

---

## Project Information

| Item | Details |
|---|---|
| Project | FinEdge Bank QA Project |
| Module | Login |
| Sprint | Sprint 1 |
| Tester | Ajit Kumar |
| Environment | Local |
| Browser | Google Chrome |
| Operating System | Windows 11 |
| Execution Type | Manual + API Testing |
| Current Status | In Progress |

---

# 1. Execution Objective

The objective of Sprint 1 test execution is to validate the Login functionality through:

- Manual UI testing
- API testing
- Security validation
- Functional validation
- Negative testing
- Input validation
- Authentication validation

The execution results are consolidated from the Sprint 1 Manual Testing and API Testing reports.

---

# 2. Testing Activity Status

| Testing Activity | Status |
|---|---|
| Requirement Analysis | Completed |
| UI / Manual Testing | Completed |
| API Testing | Completed |
| Bug Reporting | In Progress |
| Test Execution Documentation | Completed |
| SQL Validation | Pending |
| Selenium Automation | Pending |

---

# 3. Manual Testing Execution

Manual testing was performed for the Login module.

## Manual Test Execution Summary

| Metric | Count |
|---|---:|
| Total Test Cases | 70 |
| Passed | 56 |
| Failed | 3 |
| Skipped | 10 |
| Not Applicable | 1 |

### Manual Testing Result

**Execution Status: Completed**

Manual testing identified three failed scenarios:

| Test Case ID | Scenario | Bug Status |
|---|---|---|
| TC_LOGIN_012 | Username with Leading Spaces | BUG-002 |
| TC_LOGIN_013 | Username with Trailing Spaces | BUG-003 |
| TC_LOGIN_039 | Invalid Server URL | BUG-004 – Pending Verification |

Detailed manual testing information is available in:

`Manual-Testing.md`

---

# 4. API Testing Execution

API testing was performed for the Login Authentication API.

### API Test Execution Summary

| Metric | Count |
|---|---:|
| Total API Test Cases | 17 |
| Passed | 17 |
| Failed | 0 |
| Blocked | 0 |
| Pass Percentage | 100% |

### API Result

**Execution Status: Completed**

All 17 API test cases passed successfully.

The following areas were validated:

- Valid authentication
- Invalid username
- Invalid password
- Blank credentials
- Invalid JSON
- HTTP method validation
- Content-Type validation
- SQL Injection
- XSS payload
- Long username
- Long password
- HTTP status codes

**API Defects Identified: 0**

Detailed API testing information is available in:

`API-Testing.md`

---

# 5. Security Testing Summary

Security-related Login scenarios were validated through API testing.

| Security Scenario | Result |
|---|---|
| SQL Injection | PASS |
| XSS Payload | PASS |
| Invalid Authentication | PASS |
| Invalid JSON | PASS |
| Unsupported Content-Type | PASS |
| Long Username | PASS |
| Long Password | PASS |

No API security defects were identified during the current execution.

---

# 6. Overall Execution Summary

Manual and API testing are reported separately because they represent different test suites.

### Manual Testing

**70 Test Cases**

- 56 Passed
- 3 Failed
- 10 Skipped
- 1 Not Applicable

### API Testing

**17 API Test Cases**

- 17 Passed
- 0 Failed
- 0 Blocked

---

# 7. Defect Summary

The current Manual Testing report identifies three failed test cases.

| Bug ID | Related Test Case | Description | Status |
|---|---|---|---|
| BUG-002 | TC_LOGIN_012 | Username accepts leading spaces | Open |
| BUG-003 | TC_LOGIN_013 | Username accepts trailing spaces | Open |
| BUG-004 | TC_LOGIN_039 | Invalid Server URL – verification required | Pending Verification |

### Existing Bug

`BUG-001` is listed in the Manual Testing report as:

- Severity: Minor
- Priority: Low
- Status: Open

However, the current Manual Testing report does not associate BUG-001 with a specific failed test case. Therefore, its test-case mapping should be confirmed before final traceability is established.

---

# 8. Skipped and Not Applicable Tests

### Skipped

**10 test cases** were skipped because of:

- Additional configuration requirements
- Dependency on unavailable functionality
- Scope limitations
- Future sprint requirements

### Not Applicable

**1 test case** was marked Not Applicable because it does not apply to the current Mifos Login implementation.

Detailed information is available in:

`Manual-Testing.md`

---

# 9. SQL Validation

SQL/database validation has not yet been completed for Sprint 1.

**Status: Pending**

Planned validation includes:

- Login-related database records
- User/account data validation
- Authentication-related data
- Data integrity checks
- SQL query validation

This section will be updated after SQL validation is executed.

---

# 10. Selenium Automation

Selenium automation for the Login module has not yet been completed.

**Status: Pending**

Planned automation will include:

- Selenium WebDriver
- Java
- TestNG
- Maven
- Page Object Model
- Explicit waits
- Assertions
- Positive scenarios
- Negative scenarios
- Validation scenarios
- Failure screenshots
- Test reporting

This section will be updated after automation implementation and execution.

---

# 11. Current Sprint 1 Status

| Activity | Status |
|---|---|
| Manual Testing | ✅ Completed |
| API Testing | ✅ Completed |
| Bug Reporting | ⏳ In Progress |
| Test Execution | ✅ Documented |
| SQL Validation | ⏳ Pending |
| Selenium Automation | ⏳ Pending |

---

# 12. Next Actions

1. Finalize the Sprint 1 Bug Report.
2. Confirm the mapping for BUG-001.
3. Verify TC_LOGIN_039 and determine whether BUG-004 should be formally logged.
4. Complete SQL validation.
5. Implement Selenium automation.
6. Retest failed scenarios after defect fixes.
7. Update defect statuses.
8. Perform regression testing.
9. Finalize Sprint 1 completion documentation.

---

# 13. Related Documents

- `Manual-Testing.md`
- `API-Testing.md`
- `Bug-Reports.xlsx`
- `SQL-Validation.md`
- `Selenium-Automation.md`

---

# Overall Sprint 1 Status

**Status: IN PROGRESS**

Manual UI testing and Login Authentication API testing have been completed.

Manual testing identified **3 failed test cases**, while all **17 API test cases passed successfully**.

SQL validation and Selenium automation remain pending.

Sprint 1 will be considered fully completed after the remaining testing activities, defect resolution, retesting, and final validation are completed.

---

**End of Sprint 1 Test Execution Report**