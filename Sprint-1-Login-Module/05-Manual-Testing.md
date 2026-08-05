# Sprint 1 - Login Module

## Manual Testing Report

### Project Information

- **Project:** Mifos X
- **Module:** Login
- **Sprint:** Sprint 1
- **Tester:** Ajit Kumar
- **Execution Type:** Manual Testing
- **Environment:** Local
- **Browser:** Google Chrome
- **Operating System:** Windows 11

---

# Test Execution Summary

| Metric | Count |
|---------|------:|
| Total Test Cases | 70 |
| Passed | 56 |
| Failed | 3 |
| Skipped | 10 |
| Not Applicable | 1 |

---

## Failed Test Cases

| Test Case ID | Summary | Bug ID | Status |
|--------------|---------|--------|--------|
| TC_LOGIN_012 | Username with Leading Spaces | BUG-002 | Failed |
| TC_LOGIN_013 | Username with Trailing Spaces | BUG-003 | Failed |
| TC_LOGIN_039 | Invalid Server URL *(Needs Verification)* | BUG-004 *(or Pending Verification)* | Failed |

---

## Skipped Test Cases

Total Skipped: **10**

Reason:
- Test scenarios require additional configuration.
- Dependent functionality not available during current sprint.
- Deferred to a future sprint.

---

## Not Applicable

Total: **1**

Reason:
- Test case is not applicable to the current Mifos Login implementation.

---

## Bugs Logged

| Bug ID | Severity | Priority | Status |
|---------|----------|----------|--------|
| BUG-001 | Minor | Low | Open |
| BUG-002 | Medium | High | Open |
| BUG-003 | Medium | High | Open |

> **Note:** TC_LOGIN_039 is under verification. If confirmed, it will be logged as BUG-004.

---

## Execution Remarks

- Manual testing of the Login module has been completed.
- 70 test cases were prepared.
- 56 test cases passed successfully.
- 3 test cases failed and defects were identified.
- 10 test cases were skipped due to dependency or scope limitations.
- 1 test case was marked as Not Applicable.
- Failed test cases have been documented in the Bug Report workbook for further investigation.

---

## Overall Status

**Execution Status:** Completed

**Recommendation:** Ready for defect fixing and regression testing.