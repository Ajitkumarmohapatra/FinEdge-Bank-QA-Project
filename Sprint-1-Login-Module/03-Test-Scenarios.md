# Sprint 1 - Login Module

## Document
03-Test-Scenarios.md

---

# Module Name

Login Module

---

# Objective

Identify all high-level scenarios that should be tested for the Login functionality.

---

## Functional Test Scenarios

TS-001 Verify Login page loads successfully.

TS-002 Verify Username textbox is displayed.

TS-003 Verify Password textbox is displayed.

TS-004 Verify Password is masked by default.

TS-005 Verify Show/Hide password functionality.

TS-006 Verify Login button is displayed.

TS-007 Verify login using valid credentials.

TS-008 Verify login using invalid username.

TS-009 Verify login using invalid password.

TS-010 Verify login using both invalid username and password.

TS-011 Verify mandatory field validation.

TS-012 Verify login with empty username.

TS-013 Verify login with empty password.

TS-014 Verify login with both fields empty.

---

## Boundary Value Test Scenarios

TS-015 Verify minimum username length.

TS-016 Verify maximum username length.

TS-017 Verify minimum password length.

TS-018 Verify maximum password length.

---

## Negative Test Scenarios

TS-019 Verify login with special characters.

TS-020 Verify login with SQL Injection attempts.

TS-021 Verify login with JavaScript/XSS input.

TS-022 Verify login with leading/trailing spaces.

---

## Security Test Scenarios

TS-023 Verify HTTPS is enabled.

TS-024 Verify password is masked.

TS-025 Verify session is created after successful login.

TS-026 Verify user cannot access dashboard without login.

TS-027 Verify logout invalidates session.

---

## UI Test Scenarios

TS-028 Verify alignment of UI controls.

TS-029 Verify labels and placeholders.

TS-030 Verify responsive layout.

TS-031 Verify logo visibility.

TS-032 Verify language dropdown functionality.

---

## Performance Test Scenarios

TS-033 Verify login response time.

TS-034 Verify application handles multiple login attempts.

---

## Accessibility Test Scenarios

TS-035 Verify keyboard navigation.

TS-036 Verify tab order.

TS-037 Verify visible focus indicators.

---

## Expected Result

All scenarios should execute successfully without functional, UI, security, or performance issues.
