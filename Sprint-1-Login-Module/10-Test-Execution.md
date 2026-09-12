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
| Execution Type | Manual + API + SQL + Selenium Automation |
| Current Status | In Progress |

---

# 1. Execution Objective

The objective of Sprint 1 test execution is to validate the Login functionality through:

- Manual UI testing
- API testing
- SQL/database validation
- Selenium automation
- Security validation
- Functional validation
- Negative testing
- Input validation
- Authentication validation

The execution results are consolidated from the Sprint 1 Manual Testing, API Testing, SQL Validation, and Selenium Automation activities.

---

# 2. Testing Activity Status

| Testing Activity | Status |
|---|---|
| Requirement Analysis | Completed |
| UI / Manual Testing | Completed |
| API Testing | Completed |
| Bug Reporting | In Progress |
| Test Execution Documentation | Completed |
| SQL Validation | Completed |
| Selenium Automation | Completed |

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
| TC_LOGIN_012 | Username with Leading Spaces | BUG-002 – Open |
| TC_LOGIN_013 | Username with Trailing Spaces | BUG-003 – Open |
| TC_LOGIN_039 | Invalid Server URL | BUG-004 – Pending Verification |

Detailed manual testing information is available in:

`05-Manual-Testing.md`

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

`06-API-Testing.md`

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

# 6. SQL Validation Execution

SQL/database validation was completed for the Login module.

### SQL Validation Summary

| Validation Area | Result |
|---|---|
| User account validation | PASS |
| User enabled status | PASS |
| User deletion status | PASS |
| Account lock status | PASS |
| Credential expiry validation | PASS |
| User-role mapping | PASS |
| Duplicate username validation | PASS |
| Password storage validation | PASS |
| NULL/empty password validation | PASS |
| OAuth token persistence | Not Verifiable |

### SQL Result

**Execution Status: Completed**

The `mifos` user and related account/role data were validated in the local PostgreSQL database.

No database defects were identified during the completed validation.

OAuth token persistence could not be verified because the relevant OAuth token tables contained no records in the current local configuration.

Detailed SQL validation information is available in:

`07-SQL-Validation.md`

---

# 7. Selenium Automation Execution

Selenium automation for the Login module has been completed.

### Automation Summary

| Metric | Details |
|---|---|
| Automation Framework | Selenium WebDriver |
| Programming Language | Java |
| Test Framework | TestNG |
| Build Tool | Maven |
| Design Pattern | Page Object Model |
| Automated Login Tests | 16 |
| Automation Status | Completed |

The automated scenarios include:

- Valid Login
- Invalid Username
- Invalid Password
- Empty Username
- Empty Password
- Empty Username and Password
- Invalid Username and Password
- Password Below Minimum Length
- Username with Leading Spaces
- Username with Trailing Spaces
- Password with Leading Spaces
- Password with Trailing Spaces
- Username with Special Characters
- Password with Special Characters
- Username with Numbers Only
- Invalid Server URL

**Automation Status: Completed**

Detailed Selenium automation information is available in:

`08-Selenium-Automation.md`

---

# 8. Overall Execution Summary

Manual, API, SQL, and Selenium activities are reported separately because they represent different validation approaches.

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
- 100% Pass

### SQL Validation

**Completed**

- Login-related database records validated
- User/account data validated
- Role mapping validated
- Password storage validation completed
- No database defects identified

### Selenium Automation

**16 Login Test Cases Automated**

- Positive scenarios
- Negative scenarios
- Mandatory field validation
- Boundary validation
- Input validation
- Special-character validation
- Invalid Server URL scenario

---

# 9. Defect Summary

The current Manual Testing execution identified three failed test cases.

| Bug ID | Related Test Case | Description | Status |
|---|---|---|---|
| BUG-001 | TC_LOGIN_041 | Welcome message displays untranslated localization key | Open |
| BUG-002 | TC_LOGIN_012 | Username accepts leading spaces | Open |
| BUG-003 | TC_LOGIN_013 | Username accepts trailing spaces | Open |
| BUG-004 | TC_LOGIN_039 | Invalid Server URL – verification required | Pending Verification |

### Defect Summary

- **BUG-001:** Minor / Low / Open
- **BUG-002:** Medium / High / Open
- **BUG-003:** Medium / High / Open
- **BUG-004:** Pending Verification

Detailed defect information is available in:

`09-Bug-Reports.xlsx`

---

# 10. Skipped and Not Applicable Tests

### Skipped

**10 test cases** were skipped because of:

- Additional configuration requirements
- Dependency on unavailable functionality
- Scope limitations
- Future sprint requirements

### Not Applicable

**1 test case** was marked Not Applicable because it does not apply to the current Mifos Login implementation.

Detailed information is available in:

`05-Manual-Testing.md`

---

# 11. Current Sprint 1 Status

| Activity | Status |
|---|---|
| Manual Testing | ✅ Completed |
| API Testing | ✅ Completed |
| SQL Validation | ✅ Completed |
| Selenium Automation | ✅ Completed |
| Bug Reporting | ⏳ In Progress |
| Test Execution | ✅ Documented |

### Overall Status

**IN PROGRESS**

The primary Sprint 1 testing activities have been completed.

The remaining work is primarily related to defect verification, defect resolution/retesting, regression testing, and final Sprint 1 documentation.

---

# 12. Next Actions

1. Verify TC_LOGIN_039 and determine the final status of BUG-004.
2. Retest failed scenarios after defect fixes.
3. Update defect statuses after retesting.
4. Perform regression testing for the Login module.
5. Finalize Sprint 1 completion documentation.
6. Review and update the Sprint 1 README.
7. Mark Sprint 1 as completed after final validation and documentation review.

---

# 13. Related Documents

- `01-Requirement-Analysis.md`
- `02-UI-Analysis.md`
- `03-Test-Scenarios.md`
- `04-Login-Test-Cases-Complete.xlsx`
- `05-Manual-Testing.md`
- `06-API-Testing.md`
- `07-SQL-Validation.md`
- `08-Selenium-Automation.md`
- `09-Bug-Reports.xlsx`
- `11-Postman/`

---

# Overall Sprint 1 Status

**Status: IN PROGRESS**

Sprint 1 Login testing activities have been substantially completed.

### Execution Summary

- **70 Manual Test Cases**
  - 56 Passed
  - 3 Failed
  - 10 Skipped
  - 1 Not Applicable

- **17 API Test Cases**
  - 17 Passed
  - 0 Failed
  - 0 Blocked
  - 100% Pass

- **SQL Validation**
  - Completed
  - No database defects identified

- **Selenium Automation**
  - 16 Login scenarios automated
  - Automation implementation completed

- **Defects**
  - 4 bugs documented
  - 3 open/pending defects requiring follow-up
  - BUG-004 pending verification

Sprint 1 will be considered fully completed after defect verification, retesting, regression testing, and final documentation review.

---

**End of Sprint 1 Test Execution Report**