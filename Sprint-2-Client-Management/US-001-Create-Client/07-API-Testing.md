# Sprint 2 – Client Management

# 07 – API Testing Report

---

# Project Information

| Field | Details |
|--------|---------|
| Project | FinEdge Bank QA Project |
| Application | Mifos Web Application |
| Module | Client Management |
| User Story | US-001 – Create Client |
| Sprint | Sprint 2 |
| API | POST /clients |
| Execution Type | Manual API Testing |
| Tool | Postman |
| Backend | Apache Fineract |
| Environment | Local |
| Tester | Ajit Kumar |

---

# Objective

The objective of API testing is to validate the Create Client REST API by verifying request validation, authentication, authorization, business rules, response status codes, data integrity, and security-related behavior.

---

# API Details

| Item | Value |
|------|-------|
| HTTP Method | POST |
| Endpoint | /clients |
| Content Type | application/json |
| Authentication | Basic Authentication |
| Tenant Header | Required |

---

# Test Execution Summary

| Metric | Count |
|---------|------:|
| Total API Test Cases | 26 |
| Passed | 23 |
| Failed | 0 |
| Observation | 3 |

---

# API Test Coverage

The following areas were validated during API execution:

- Client creation with valid data
- Mandatory field validation
- Invalid request validation
- Duplicate client validation
- Office validation
- Staff validation
- Date validation
- Invalid JSON payload
- Empty request body
- HTTP method validation
- Authorization validation
- Tenant header validation
- Content-Type validation
- Security payload validation
- Overall API health verification

---

# Status Code Validation

| Status Code | Description | Result |
|-------------|-------------|--------|
| 200 | Client Created Successfully | Verified |
| 400 | Bad Request / Validation Error | Verified |
| 401 | Unauthorized | Verified |
| 403 | Duplicate Client / Forbidden | Verified |
| 404 | Resource Not Found | Verified |
| 405 | Method Not Allowed | Verified |
| 406 / 415 | Unsupported Media Type / Not Acceptable | Verified |

---

# Authentication Validation

The following authentication scenarios were executed:

- Valid Authorization Header
- Missing Authorization Header
- Invalid Authorization Header
- Expired Authorization
- Missing Tenant Header
- Invalid Tenant Header

All authentication scenarios behaved as expected according to the executed test results.

---

# Business Rule Validation

The following business rules were verified:

- Client created successfully with valid request.
- Mandatory fields validated.
- Duplicate client detection verified.
- Office validation verified.
- Staff validation verified.
- Submitted date validation verified.
- Invalid payload validation verified.

---

# Security Validation

The following security-oriented scenarios were executed:

| Scenario | Result |
|----------|--------|
| SQL Injection Payload | Observation |
| Cross Site Scripting (XSS) Payload | Observation |
| Special Character Input | Observation |

### Observation

The above payloads were accepted during execution and have been recorded as observations. These results should be reviewed with the development or security team to determine whether the observed behavior is expected or indicates a potential security concern.

---

# API Execution Result Summary

| Result | Count |
|---------|------:|
| PASS | 23 |
| FAIL | 0 |
| OBSERVATION | 3 |

---

# Execution Remarks

- All planned Create Client API test cases were executed.
- Core Create Client functionality behaved as expected.
- Mandatory field validations were verified.
- Authentication and authorization scenarios were validated.
- HTTP status codes matched the expected behavior for the executed scenarios.
- Three security-related scenarios have been documented as observations for further review.

---

# Postman Artifacts

| Artifact | File |
|----------|------|
| Collection | Sprint-2-Create-Client-API.postman_collection.json |
| Environment | Login-Environment.postman_environment.json |

---

# Conclusion

API testing for **US-001 – Create Client** has been successfully completed.

- Total API Test Cases Executed: **26**
- Passed: **23**
- Failed: **0**
- Observation: **3**

The Create Client API demonstrated stable functional behavior for the executed scenarios. Security-related observations have been documented and should be reviewed as part of the application's secure development lifecycle.

---

# Overall Status

**Execution Status:** Completed

**Recommendation:** Ready for SQL Validation, Manual Testing Completion, Regression Testing, and Selenium Automation.