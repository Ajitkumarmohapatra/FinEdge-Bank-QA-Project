# Phase 1 Completion Report

---

# Project Information

| Item | Details |
|------|---------|
| Project Name | FinEdge Bank QA Project |
| Sprint | Sprint 1 |
<<<<<<< HEAD
| User Story | US-001 |
| Story Name | Create Client |
| Phase | Requirement Analysis |
| Status | ✅ Completed |
| Completion Date | 04-Jul-2026 |
=======
| User Story | US-LOGIN-001 |
| Story Name | Login Module |
| Phase | Phase 1 – Login Module QA Validation |
| Status | ⏳ In Progress |
>>>>>>> a9d4ab1 (completed sprint 1 and all the files are up to date)
| Prepared By | Ajit Kumar Mohapatra |

---

# Phase Objective

Complete the end-to-end QA validation of the **Login Module** by analyzing requirements, designing test scenarios and test cases, performing manual UI testing, API testing, SQL/database validation, Selenium automation, and documenting identified defects.

The objective is to establish complete test coverage and provide a documented quality baseline for the Login functionality.

---

# Deliverables Completed

| No | Deliverable | Status |
|----|-------------|--------|
| 1 | Requirement Analysis | ✅ Completed |
| 2 | UI Analysis | ✅ Completed |
| 3 | Test Scenario Design | ✅ Completed |
| 4 | Test Case Design | ✅ Completed |
| 5 | Manual Testing | ✅ Completed |
| 6 | API Testing | ✅ Completed |
| 7 | Postman Collection | ✅ Completed |
| 8 | SQL Validation | ✅ Completed |
| 9 | Selenium Automation | ✅ Completed |
| 10 | Bug Reporting | ⏳ In Progress |
| 11 | Test Execution Documentation | ✅ Completed |

---

# Testing Summary

## Manual Testing

Manual UI testing was completed for the Login module.

| Metric | Count |
|--------|------:|
| Total Test Cases | 70 |
| Passed | 56 |
| Failed | 3 |
| Skipped | 10 |
| Not Applicable | 1 |

### Failed Test Cases

| Test Case ID | Scenario | Defect |
|--------------|----------|--------|
| TC_LOGIN_012 | Username with Leading Spaces | BUG-002 |
| TC_LOGIN_013 | Username with Trailing Spaces | BUG-003 |
| TC_LOGIN_039 | Invalid Server URL | BUG-004 – Pending Verification |

---

# API Testing

<<<<<<< HEAD
- README.md
- 01-Requirement-Analysis.md
- PHASE-1-COMPLETION.md
=======
Login Authentication API testing was completed.

| Metric | Count |
|--------|------:|
| Total API Test Cases | 17 |
| Passed | 17 |
| Failed | 0 |
| Blocked | 0 |
| Pass Percentage | 100% |

### API Areas Validated

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

---

# SQL Validation

SQL/database validation for the Login module was completed using the local PostgreSQL database.

### Validation Areas

- User account validation
- User enabled/disabled status
- User deletion status
- Account lock status
- Credential expiry validation
- User-role mapping
- Duplicate username validation
- Password storage validation
- NULL/empty password validation

### SQL Result

**Status: ✅ Completed**

No database defects were identified during the completed validation.

OAuth token persistence could not be verified because the relevant OAuth token tables contained no records in the current local configuration.

---

# Selenium Automation

Selenium automation for the Login module was completed using:

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model

### Automation Coverage

**16 Login scenarios were automated.**

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

**Automation Status: ✅ Completed**

---

# Defect Summary

The Sprint 1 Login Module currently contains four documented defects.

| Bug ID | Related Test Case | Description | Severity | Priority | Status |
|--------|-------------------|-------------|----------|----------|--------|
| BUG-001 | TC_LOGIN_041 | Welcome message displays untranslated localization key | Minor | Low | Open |
| BUG-002 | TC_LOGIN_012 | Username accepts leading spaces | Medium | High | Open |
| BUG-003 | TC_LOGIN_013 | Username accepts trailing spaces | Medium | High | Open |
| BUG-004 | TC_LOGIN_039 | Invalid Server URL – verification required | TBD | TBD | Pending Verification |

### Defect Status

- BUG-001 → Open
- BUG-002 → Open
- BUG-003 → Open
- BUG-004 → Pending Verification

Defect verification and retesting remain outstanding.

---

# Key QA Activities Completed

The following QA activities have been completed for the Login Module:

- Requirement analysis
- UI analysis
- Test scenario identification
- Test case design
- Manual functional testing
- Negative testing
- Boundary value testing
- Security-oriented API testing
- API validation
- Database validation
- Selenium automation
- Postman collection creation
- Defect documentation
- Test execution reporting

---

# Quality Metrics

| Metric | Value |
|--------|------:|
| Manual Test Cases | 70 |
| Manual Passed | 56 |
| Manual Failed | 3 |
| Manual Skipped | 10 |
| Manual N/A | 1 |
| API Test Cases | 17 |
| API Passed | 17 |
| API Pass Percentage | 100% |
| Selenium Automated Tests | 16 |
| Documented Defects | 4 |
>>>>>>> a9d4ab1 (completed sprint 1 and all the files are up to date)

---

# Lessons Learned

During Sprint 1, the following QA concepts and practices were applied:

- Requirement analysis before test design
- UI analysis and validation
- Functional and negative test design
- Boundary value analysis
- Input validation testing
- API testing using Postman
- Security-oriented API validation
- SQL/database validation
- Selenium WebDriver automation
- Page Object Model implementation
- TestNG-based test execution
- Maven project management
- Defect identification and reporting
- Requirement and test traceability
- Git and GitHub-based project documentation

---

# Current Phase Status

| QA Activity | Status |
|------------|--------|
| Requirement Analysis | ✅ Completed |
| UI Analysis | ✅ Completed |
| Test Scenarios | ✅ Completed |
| Test Cases | ✅ Completed |
| Manual Testing | ✅ Completed |
| API Testing | ✅ Completed |
| Postman | ✅ Completed |
| SQL Validation | ✅ Completed |
| Selenium Automation | ✅ Completed |
| Bug Reporting | ⏳ In Progress |
| Test Execution Documentation | ✅ Completed |

---

# Remaining Activities

The following activities remain before Sprint 1 can be formally closed:

1. Verify the behavior associated with **TC_LOGIN_039 / BUG-004**.
2. Retest failed scenarios after defect fixes.
3. Update defect statuses based on retesting results.
4. Perform Login module regression testing.
5. Complete final Sprint 1 documentation review.
6. Update the Sprint 1 README.
7. Perform final QA sign-off.

---

# Phase Summary

Phase 1 for the **Sprint 1 – Login Module** has substantially completed its planned QA validation activities.

Requirement Analysis, UI Analysis, Test Scenario Design, Test Case Design, Manual Testing, API Testing, Postman validation, SQL validation, Selenium automation, and Test Execution Documentation have been completed.

The current manual execution contains **70 test cases**, with **56 passed, 3 failed, 10 skipped, and 1 Not Applicable**.

API testing achieved **17/17 passed with a 100% pass rate**.

Selenium automation has been completed for **16 Login scenarios**.

Four defects have been documented. BUG-001, BUG-002, and BUG-003 are currently open, while BUG-004 remains pending verification.

Sprint 1 remains **IN PROGRESS** until defect verification, retesting, regression testing, and final documentation activities are completed.

---

# QA Sign-off

| Item | Status |
|------|--------|
| Requirement Analysis Completed | ✅ Yes |
| UI Analysis Completed | ✅ Yes |
| Test Scenarios Completed | ✅ Yes |
| Test Cases Completed | ✅ Yes |
| Manual Testing Completed | ✅ Yes |
| API Testing Completed | ✅ Yes |
| SQL Validation Completed | ✅ Yes |
| Selenium Automation Completed | ✅ Yes |
| Defects Documented | ✅ Yes |
| Defect Verification Completed | ⏳ Pending |
| Regression Testing Completed | ⏳ Pending |
| Final Sprint Sign-off | ⏳ Pending |

---

# Related Documents

- `01-Requirement-Analysis.md`
- `02-UI-Analysis.md`
- `03-Test-Scenarios.md`
- `04-Login-Test-Cases-Complete.xlsx`
- `05-Manual-Testing.md`
- `06-API-Testing.md`
- `07-SQL-Validation.md`
- `08-Selenium-Automation.md`
- `09-Bug-Reports.xlsx`
- `10-Test-Execution.md`
- `11-Postman/`
- `README.md`

---

# Final Status

**SPRINT 1 – LOGIN MODULE: IN PROGRESS**

Testing implementation is substantially completed.

Final closure is pending defect verification, retesting, regression testing, and documentation sign-off.

---

**End of Phase 1 Completion Report**