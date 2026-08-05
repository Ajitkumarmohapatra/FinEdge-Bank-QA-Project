# Sprint 1 - Login Module

## Document

02-UI-Analysis.md

---

# Module Name

Login Module

---

# Objective

Analyze all User Interface (UI) elements available on the Login page and Home Dashboard to ensure they are displayed correctly, aligned properly, functional, and user-friendly.

---

# Login Page UI Components

## Browser

- Application URL should load successfully.
- Browser title should display correctly.
- HTTPS should be enabled.

---

## Server URL Dropdown

Expected Behaviour

- Dropdown should be visible.
- Default server URL should be displayed.
- User should be able to select another server (if multiple are configured).

---

## Language Dropdown

Expected Behaviour

- Dropdown should be visible.
- Default language should be English.
- User should be able to change language.
- Selected language should be applied successfully.

---

## Mifos Logo

Expected Behaviour

- Logo should be displayed.
- Logo should not be distorted.
- Logo should load successfully.

---

## Username Textbox

Validation

- Visible
- Enabled
- Accept keyboard input
- Mandatory
- Proper placeholder/label
- Copy-Paste support
- Maximum length validation (if applicable)

---

## Password Textbox

Validation

- Visible
- Enabled
- Mandatory
- Password masked by default
- Accept keyboard input
- Maximum length validation
- Copy-Paste behaviour

---

## Show / Hide Password Icon

Validation

- Eye icon should be visible.
- Clicking icon should reveal password.
- Clicking again should hide password.

---

## Login Button

Validation

- Visible
- Enabled
- Proper alignment
- Clickable
- Keyboard Enter key support
- Prevent multiple rapid clicks

---

# Login Page UI Validation Checklist

- Proper alignment
- Proper spacing
- Proper font
- Proper colors
- Responsive layout
- No overlapping controls
- No broken images
- No spelling mistakes
- No truncated text
- No console errors
- Proper tab navigation

---

# Home Dashboard UI Components

Top Navigation

- Institution
- Accounting
- Reports
- Admin
- Configuration Wizard

Top Right Section

- Search
- Language
- Notification
- Theme
- User Profile

Left Navigation

- Clients
- Groups
- Dashboard
- Tasks
- Accounting
- Products
- Cash
- Notifications
- Refresh
- Add
- Organization

Dashboard

- Welcome Message
- Dashboard Button
- Search Activity
- Version Information

---

# UI Validations after Login

- Dashboard should load successfully.
- Navigation menu should display correctly.
- Icons should load properly.
- Welcome message should display correctly.
- No broken UI components.
- No overlapping controls.
- Proper spacing.
- Proper alignment.
- Responsive layout.
- Logout option should be available.

---

# Potential Observations

Observation 1

Current Welcome Message:

Welcome mifos labels.text.To Default!

Possible Issue:

The text **labels.text.To** appears to be an untranslated localization key instead of user-friendly text.

Status:

To Be Verified

Severity:

Minor

Priority:

Low

---

# Accessibility Checks

- Keyboard navigation should work.
- Visible focus on controls.
- Labels should be readable.
- Buttons should be distinguishable.
- Icons should have sufficient contrast.

---

# Expected Result

The Login page and Dashboard should be visually consistent, user-friendly, responsive, and free from UI defects.
