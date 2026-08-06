# Sprint 1 - Login Module

# API Testing Report

## Project Information

| Field | Details |
|--------|---------|
| Project | FinEdge Bank QA Project |
| Module | Login Authentication |
| Sprint | Sprint 1 |
| Tester | Ajit Kumar |
| API | Login Authentication API |
| HTTP Method | POST |
| Endpoint | /fineract-provider/api/v1/authentication |
| Tool | Postman |
| Environment | Local |
| Base URL | https://localhost:8443/fineract-provider/api/v1 |

---

# Test Execution Summary

| Metric | Count |
|---------|------:|
| Total API Test Cases | 17 |
| Passed | 17 |
| Failed | 0 |
| Blocked | 0 |
| Pass Percentage | 100% |

---

# Authentication Details

| Parameter | Value |
|-----------|-------|
| Authentication Type | Basic Authentication |
| Tenant | default |
| Username | mifos |
| Token Generation | Successful |

---

# API Test Execution Results

| TC ID | Scenario | Expected Status | Actual Status | Result |
|-------|----------|----------------:|--------------:|--------|
| TC_Login_01 | Valid Credentials | 200 | 200 | PASS |
| TC_Login_02 | Remember = False | 200 | 200 | PASS |
| TC_Login_03 | Remember = True | 200 | 200 | PASS |
| TC_Login_04 | Invalid Username | 401 | 401 | PASS |
| TC_Login_05 | Invalid Password | 401 | 401 | PASS |
| TC_Login_06 | Blank Username | 401 | 401 | PASS |
| TC_Login_07 | Blank Password | 401 | 401 | PASS |
| TC_Login_08 | Blank Username & Password | 401 | 401 | PASS |
| TC_Login_09 | Missing Remember | 200 | 200 | PASS |
| TC_Login_10 | Invalid JSON | 400 | 400 | PASS |
| TC_Login_11 | Wrong Method (GET) | 401 | 401 | PASS |
| TC_Login_12 | Wrong Method (PUT) | 401 | 401 | PASS |
| TC_Login_13 | Unsupported Content-Type | 415 | 415 | PASS |
| TC_Login_14 | SQL Injection | 401 | 401 | PASS |
| TC_Login_15 | XSS Payload | 401 | 401 | PASS |
| TC_Login_16 | Long Username | 401 | 401 | PASS |
| TC_Login_17 | Long Password | 401 | 401 | PASS |

---

# Status Code Validation

| Status Code | Description | Validation |
|-------------|-------------|------------|
| 200 | OK | Verified |
| 400 | Bad Request | Verified |
| 401 | Unauthorized | Verified |
| 415 | Unsupported Media Type | Verified |

---

# Security Validation

- SQL Injection payload was rejected successfully.
- XSS payload was rejected successfully.
- Invalid credentials returned **401 Unauthorized**.
- Invalid JSON returned **400 Bad Request**.
- Unsupported Content-Type returned **415 Unsupported Media Type**.
- Long username and password inputs were handled safely.

---

# Postman Artifacts

| Artifact | File |
|----------|------|
| Collection | Sprint-1-Login-API.postman_collection.json |
| Environment | Login-Environment.postman_environment.json |

---

# Execution Remarks

- Login Authentication API testing has been completed successfully.
- All 17 planned API test cases were executed.
- All API test cases passed successfully.
- No API defects were identified during execution.
- Authentication endpoint behaved as expected for both positive and negative scenarios.
- Postman Collection and Environment files have been added to the project repository.

---

# Overall Status

**Execution Status:** Completed ✅

**Recommendation:** Login Authentication API is stable and ready for regression testing and integration with subsequent Sprint modules.