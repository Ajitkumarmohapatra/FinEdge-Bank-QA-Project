# US-001 – UI Analysis

---

This document analyzes the Create Client user interface for User Story US-001. It identifies the screen structure, navigation flow, UI controls, layout, accessibility considerations, and potential UI risks before deriving test scenarios.

---

# 1. Screen Information

| Item | Details |
|------|---------|
| Project | FinEdge Bank QA Project |
| Sprint | Sprint 1 |
| User Story | US-001 |
| Screen Name | Create Client |
| Module | Client Management |
| Application | Mifos Web Application |
| Backend | Apache Fineract |
| Purpose | Allow authorized bank employees to create a new client profile. |

---

# 2. Navigation Analysis

## Navigation Path

Login
→ Institution
→ Clients
→ Create Client

## Expected Navigation

- The Create Client page shall open after selecting **Clients → Create Client**.
- The page title shall display **Create Client**.
- Breadcrumb navigation shall display **Clients > Create Client**.

---

# 3. Page Layout Analysis

The Create Client page contains the following UI sections:

- Page Header
- Breadcrumb Navigation
- General Information Section
- Client Information Form
- Navigation Buttons

The overall layout should be clean, responsive, and user-friendly.

---

# 4. UI Components Identified

## Dropdown Controls

- Office *
- Legal Form *
- Client Type
- Client Classification

---

## Text Fields

- External ID
- First Name *
- Middle Name
- Last Name *

---

## Date Picker

- Submitted On *

---

## Checkboxes

- Active
- Open Savings Account

---

## Buttons

- Previous
- Next

---

# 5. UI Consistency Analysis

Verify that:

- All labels use consistent font style.
- Mandatory fields display an asterisk (*).
- Form controls have consistent spacing.
- Alignment is consistent across the page.
- Buttons follow the same design.
- Colors follow the application theme.

---

# 6. Accessibility Observations

Verify that:

- Labels are visible.
- Keyboard navigation is supported.
- Tab order is logical.
- Mandatory fields are clearly indicated.
- Date picker is accessible.
- Dropdowns are keyboard accessible.

---

# 7. UI Risks

Potential UI risks include:

- Misaligned controls
- Missing mandatory indicators
- Incorrect labels
- Poor spacing
- Responsive layout issues
- Hidden fields
- Disabled controls without explanation

---

# 8. UI Improvement Suggestions

Possible improvements:

- Add placeholders where necessary.
- Improve spacing between controls.
- Display helper text for optional fields.
- Highlight validation errors more clearly.
- Improve keyboard accessibility.

---

# 9. UI Analysis Summary

The Create Client screen is designed to capture client information required for creating a new banking customer.

The page contains dropdowns, text fields, checkboxes, a date picker, and navigation buttons. Mandatory fields are identified using an asterisk (*). This analysis provides the foundation for deriving UI test scenarios and detailed test cases.
