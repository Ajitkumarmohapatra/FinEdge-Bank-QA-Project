# Selenium Automation – Create Client Module

## 1. Overview

Selenium WebDriver automation has been implemented for the **Create Client** module under:

**User Story:** US-001 – Create Client

**Module:** Client Management

**Automation Framework:**
- Selenium WebDriver
- Java
- TestNG
- Maven
- Page Object Model (POM)
- WebDriverManager
- Extent Reports

---

## 2. Automation Objective

The objective of Selenium automation is to validate the Create Client workflow and verify the behavior of mandatory fields, validation messages, data retention, field validation, and navigation through the Create Client wizard.

---

## 3. Automated Test Cases

Currently, **10 Create Client test cases have been automated**.

| Test Case ID | Test Case Description | Automation Status | Latest Execution |
|---|---|---|---|
| TC-013 | Verify Office is Mandatory | Automated | Passed |
| TC-015 | Verify First Name is Mandatory | Automated | Passed |
| TC-016 | Verify Last Name is Mandatory | Automated | Failed |
| TC-023 | Verify Multiple Mandatory Field Validations | Automated | Passed |
| TC-024 | Verify Entered Data is Retained After Validation Error | Automated | Passed |
| TC-026 | Verify Validation Messages Disappear After Correction | Automated | Passed |
| TC-027 | Verify User Can Proceed After Completing Mandatory Fields | Automated | Passed |
| TC-032 | Verify First Name Rejects Numeric Input | Automated | Passed |
| TC-033 | Verify First Name Rejects Special Characters | Automated | Passed |
| Create Client Test | Verify Complete Create Client Workflow | Automated | Passed |

---

## 4. Current Execution Summary

The current Create Client TestNG class contains **10 automated test methods**.

### Latest Execution Result

| Metric | Result |
|---|---:|
| Total Tests | 10 |
| Passed | 9 |
| Failed | 1 |
| Skipped | 0 |
| Pass Percentage | 90% |

### Execution Status

**9 out of 10 Create Client automated test cases passed successfully.**

---

## 5. Failed Test Case

### TC-016 – Verify Last Name is Mandatory

**Status:** Failed

**Expected Validation Message:**

```text
Client last name is required