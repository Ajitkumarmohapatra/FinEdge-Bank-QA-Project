# US-001 – UI Analysis

---

This document analyzes the **Create Client** user interface for **User Story US-001**. It identifies the screen structure, navigation flow, UI components, layout, field behavior, accessibility considerations, and potential UI risks before deriving Test Scenarios and Test Cases.

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

```
Login
   ↓
Institution
   ↓
Clients
   ↓
Create Client
```

## Expected Navigation

- User shall successfully navigate to **Clients → Create Client**.
- The page title shall display **Create Client**.
- Breadcrumb shall display **Clients > Create Client**.
- The Create Client page shall open without any errors.

---

# 3. Page Layout Analysis

The Create Client page contains the following sections:

- Page Header
- Breadcrumb Navigation
- General Information Section
- Client Information Form
- Family Members Section
- Navigation Controls

The page follows a clean and responsive Material Design layout.

## Layout Type

- Multi-step Wizard
- Single Page Form
- Material Design Components
- Responsive Layout
- Left-to-Right Form Flow

---

# 4. UI Components Identified

## Dropdown Controls

- Office *
- Legal Form *
- Gender
- Staff
- Client Type
- Client Classification

---

## Text Fields

- External ID
- First Name *
- Middle Name
- Last Name *
- Mobile Number
- Email Address

---

## Date Pickers

- Date of Birth
- Submitted On *

---

## Checkboxes

- Is Staff
- Active
- Open Savings Account

---

## Buttons

- Previous
- Next

---

# 5. Mandatory Fields

The following fields are mandatory and are identified using an asterisk (*).

- Office
- Legal Form
- First Name
- Last Name
- Submitted On

---

# 6. Optional Fields

The following fields are optional.

- External ID
- Middle Name
- Date of Birth
- Gender
- Staff
- Mobile Number
- Email Address
- Client Type
- Client Classification
- Active
- Open Savings Account

---

# 7. Dropdown Analysis

| Dropdown | Purpose |
|-----------|----------|
| Office | Select the branch where the client belongs. |
| Legal Form | Select whether the client is a Person or Entity. |
| Gender | Select client's gender. |
| Staff | Associate a staff member with the client. |
| Client Type | Select customer category. |
| Client Classification | Select client classification. |

Expected Behavior

- Dropdown opens correctly.
- All configured values are displayed.
- User can select only one value.
- Invalid values cannot be entered.
- Selected value remains after navigation.

---

# 8. Date Picker Analysis

The Create Client screen contains the following date fields.

- Date of Birth
- Submitted On

Expected Behavior

- Calendar icon is displayed.
- User can select a valid date.
- Invalid dates are rejected.
- Future Date of Birth is not allowed.
- Submitted On should default to the current system date.
- Submitted On should not accept future dates.

---

# 9. Checkbox Analysis

Checkboxes available:

- Is Staff
- Active
- Open Savings Account

Expected Behavior

- Default state should be unchecked unless configured.
- Checkbox should toggle correctly.
- Checkbox state should remain while navigating.
- Associated functionality should execute correctly when selected.

---

# 10. Button Analysis

Buttons available:

- Previous
- Next

Expected Behavior

- Buttons should be visible.
- Buttons should be properly aligned.
- Previous should be disabled on the first step.
- Next should navigate to the next wizard step.
- Buttons should be keyboard accessible.
- Buttons should display hover and focus effects.

---

# 11. Validation Message Analysis

Expected Behavior

- Validation messages appear below the respective field.
- Invalid fields are highlighted.
- Error messages use consistent formatting.
- Validation message disappears after correction.
- Mandatory field errors are displayed when applicable.

---

# 12. UI Consistency Analysis

Verify the following:

- Consistent font style.
- Consistent font size.
- Proper alignment.
- Equal spacing between controls.
- Consistent button design.
- Consistent colors.
- Proper margins and padding.
- Uniform control sizes.
- Consistent icon style.

---

# 13. Accessibility Analysis

Verify that:

- Labels are clearly visible.
- Keyboard navigation is supported.
- Logical tab order is maintained.
- Dropdowns are keyboard accessible.
- Date pickers are keyboard accessible.
- Checkboxes can be selected using keyboard.
- Buttons are accessible using keyboard.
- Mandatory fields are clearly identified.

---

# 14. Responsive Behavior

Verify the UI on:

- Desktop
- Laptop
- Tablet
- Mobile

Expected Behavior

- No overlapping controls.
- No truncated text.
- Responsive layout maintained.
- Buttons remain accessible.
- Dropdowns render correctly.

---

# 15. UI Risks

Potential UI Risks

- Misaligned controls.
- Missing mandatory indicators.
- Incorrect field labels.
- Responsive layout issues.
- Hidden controls.
- Disabled controls without explanation.
- Inconsistent spacing.
- Validation messages not displayed correctly.
- Broken navigation.

---

# 16. UI Improvement Suggestions

Possible Improvements

- Display placeholders where appropriate.
- Improve spacing between related controls.
- Add helper text for optional fields.
- Improve validation message visibility.
- Improve keyboard accessibility.
- Improve color contrast for accessibility.
- Display tooltips for complex fields.

---

# 17. UI Observations

Observed during UI Analysis

- Material Design UI components are used.
- Multi-step wizard interface.
- Required fields use an asterisk (*).
- Navigation uses Previous and Next buttons.
- Responsive page layout.
- Consistent alignment of controls.
- Clean and modern banking application design.

---

# 18. UI Analysis Summary

The Create Client screen consists of a responsive multi-step wizard designed for onboarding new banking customers.

The interface includes dropdowns, text fields, date pickers, checkboxes, and navigation controls. Mandatory fields are clearly identified, while optional fields support additional customer information.

This UI Analysis establishes the foundation for Test Scenario Design, Test Case Development, UI Validation, and Requirement Traceability Matrix (RTM) preparation.
