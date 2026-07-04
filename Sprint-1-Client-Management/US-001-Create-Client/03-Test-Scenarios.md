# US-001 – Test Scenarios

---

## Purpose

This document identifies all high-level test scenarios for User Story US-001 (Create Client). These scenarios are derived from the Business Requirements,
Functional Requirements, Non-Functional Requirements, Business Rules, and UI Analysis.

---

# Test Scenario Summary

| Module | Total Scenarios |
|---------|----------------:|
| Navigation | 4 |
| UI Validation | 8 |
| Mandatory Field Validation | 10 |
| First Name Validation | 15 |
| Last Name Validation | 10 |
| Office Dropdown | 8 |
| Legal Form Dropdown | 8 |
| External ID | 8 |
| Date Picker | 5 |
| Checkbox Validation | 5 |
| Navigation Buttons | 5 |
| Business Rules | 8 |
| Error Handling | 8 |
| Security | 5 |
| Performance | 4 |
| Accessibility | 4 |

**Estimated Total Scenarios: 115**

---
# 1. Navigation

| Scenario ID | Test Scenario |
|-------------|---------------------------------------------------------------|
| TS-001 | Verify the Create Client page opens successfully. |
| TS-002 | Verify the page title displays "Create Client". |
| TS-003 | Verify the breadcrumb displays "Clients > Create Client". |
| TS-004 | Verify only authorized users can access the Create Client page. |

---
# 2. UI Validation

| Scenario ID | Test Scenario |
|-------------|---------------------------------------------------------------|
| TS-005 | Verify all labels are displayed correctly. |
| TS-006 | Verify all mandatory fields display an asterisk (*). |
| TS-007 | Verify all text fields are visible. |
| TS-008 | Verify all dropdown fields are visible. |
| TS-009 | Verify all buttons are visible. |
| TS-010 | Verify all checkboxes are visible. |
| TS-011 | Verify the page layout is properly aligned. |
| TS-012 | Verify the application theme is displayed correctly. |

---
# 3. Mandatory Field Validation

| Scenario ID | Test Scenario |
|-------------|---------------------------------------------------------------|
| TS-013 | Verify Office is mandatory. |
| TS-014 | Verify Legal Form is mandatory. |
| TS-015 | Verify First Name is mandatory. |
| TS-016 | Verify Last Name is mandatory. |
| TS-017 | Verify Submitted On is mandatory. |
| TS-018 | Verify the system prevents proceeding when mandatory fields are empty. |
| TS-019 | Verify validation messages are displayed for missing mandatory fields. |
| TS-020 | Verify multiple validation messages appear when multiple mandatory fields are left blank. |
| TS-021 | Verify mandatory field indicators (*) remain visible. |
| TS-022 | Verify the client cannot be created until all mandatory fields are completed. |

---
