# FinEdge Bank QA Project

End-to-end Quality Assurance project for a banking application, covering manual testing, API testing, SQL/database validation, Selenium automation, defect management, and professional QA documentation.

---

# Project Overview

The **FinEdge Bank QA Project** is a portfolio-level banking QA project designed to demonstrate an end-to-end software testing workflow.

The project follows a structured QA process:

**Requirement Analysis → UI Analysis → Test Design → Manual Testing → API Testing → SQL Validation → Selenium Automation → Defect Reporting → Test Execution**

The project is organized into sprints and modules to simulate a real-world Agile QA environment.

---

# Sprint 1 – Login Module

## Objective

The objective of Sprint 1 is to perform end-to-end QA validation of the **Login Module**.

The Login Module was validated through:

- Requirement Analysis
- UI Analysis
- Test Scenario Design
- Test Case Design
- Manual UI Testing
- API Testing
- Postman
- SQL/Database Validation
- Selenium Automation
- Defect Reporting
- Test Execution Documentation

---

# Sprint 1 Status

**✅ COMPLETED**

All planned Sprint 1 QA activities and documentation have been completed.

The identified defects have been documented and tracked separately in the Bug Report.

---

# Sprint 1 QA Summary

| QA Activity | Status |
|---|---|
| Requirement Analysis | ✅ Completed |
| UI Analysis | ✅ Completed |
| Test Scenario Design | ✅ Completed |
| Test Case Design | ✅ Completed |
| Manual Testing | ✅ Completed |
| API Testing | ✅ Completed |
| Postman | ✅ Completed |
| SQL Validation | ✅ Completed |
| Selenium Automation | ✅ Completed |
| Bug Reporting | ✅ Completed |
| Test Execution Documentation | ✅ Completed |

---

# Test Execution Summary

## Manual Testing

A total of **70 Login test cases** were designed and executed.

| Result | Count |
|---|---:|
| Total | 70 |
| Passed | 56 |
| Failed | 3 |
| Skipped | 10 |
| Not Applicable | 1 |

### Failed Test Cases

| Test Case | Scenario | Defect |
|---|---|---|
| TC_LOGIN_012 | Username with Leading Spaces | BUG-002 |
| TC_LOGIN_013 | Username with Trailing Spaces | BUG-003 |
| TC_LOGIN_039 | Invalid Server URL | BUG-004 – Pending Verification |

---

# API Testing

The Login Authentication API was tested using Postman.

| Metric | Result |
|---|---:|
| Total API Test Cases | 17 |
| Passed | 17 |
| Failed | 0 |
| Blocked | 0 |
| Pass Percentage | 100% |
| API Defects | 0 |

### API Coverage

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
- HTTP status code validation

---

# SQL Validation

SQL/database validation was completed using the local PostgreSQL database.

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

**SQL Validation Status: ✅ Completed**

No database defects were identified during the completed validation.

OAuth token persistence could not be verified because the relevant OAuth token tables contained no records in the current local configuration.

---

# Selenium Automation

Selenium automation was implemented for the Login Module using:

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model

### Automation Coverage

**16 Login scenarios were automated.**

Automated scenarios include:

1. Valid Login
2. Invalid Username
3. Invalid Password
4. Empty Username
5. Empty Password
6. Empty Username and Password
7. Invalid Username and Password
8. Password Below Minimum Length
9. Username with Leading Spaces
10. Username with Trailing Spaces
11. Password with Leading Spaces
12. Password with Trailing Spaces
13. Username with Special Characters
14. Password with Special Characters
15. Username with Numbers Only
16. Invalid Server URL

**Selenium Automation Status: ✅ Completed**

---

# Defect Summary

Four defects have been documented for the Sprint 1 Login Module.

| Bug ID | Related Test Case | Description | Severity | Priority | Status |
|---|---|---|---|---|---|
| BUG-001 | TC_LOGIN_041 | Welcome message displays untranslated localization key | Minor | Low | Open |
| BUG-002 | TC_LOGIN_012 | Username accepts leading spaces | Medium | High | Open |
| BUG-003 | TC_LOGIN_013 | Username accepts trailing spaces | Medium | High | Open |
| BUG-004 | TC_LOGIN_039 | Invalid Server URL – verification required | TBD | TBD | Pending Verification |

### Defect Management

**Bug Reporting Status: ✅ Completed**

All identified defects have been documented in:

`09-Bug-Reports.xlsx`

The defect statuses shown above represent their current documented state.

---

# Project Structure

```text
FinEdge-Bank-QA-Project/
│
├── Sprint-1-Login-Module/
│   │
│   ├── 01-Requirement-Analysis.md
│   ├── 02-UI-Analysis.md
│   ├── 03-Test-Scenarios.md
│   ├── 04-Login-Test-Cases-Complete.xlsx
│   ├── 05-Manual-Testing.md
│   ├── 06-API-Testing.md
│   ├── 07-SQL-Validation.md
│   ├── 08-Selenium-Automation.md
│   ├── 09-Bug-Reports.xlsx
│   ├── 10-Test-Execution.md
│   │
│   ├── 11-Postman/
│   │   ├── Sprint-1-Login-API.postman_collection.json
│   │   └── Login-Environment.postman_environment.json
│   │
│   ├── PHASE-1-COMPLETION.md
│   └── README.md
│
└── README.md