# US-002 – Activate Client – API Testing

## 1. Document Information

| Field | Details |
|---|---|
| Story ID | US-002 |
| Story Name | Activate Client |
| Module | Client Management |
| Priority | High |
| Story Points | 5 |
| Testing Type | API Testing |
| Tool | Postman |
| Application | Mifos / Apache Fineract |
| Environment | Local QA/Test Environment |
| Status | In Progress |

---

## 2. API Testing Objective

The objective of API testing for US-002 is to verify that client activation is correctly handled through the backend API.

API testing should validate:

- Authentication
- Required headers
- Request method
- Endpoint
- Request payload
- Response status
- Response body
- Client status update
- Validation and error handling
- Unauthorized access
- Already-active client behavior
- UI/API consistency

> The exact activation endpoint, HTTP method, payload, and response structure must be confirmed from the application's backend/API implementation before execution. They are not assumed in this document.

---

# 3. API Testing Approach

The API testing process will follow:

```text
Identify Activation API
        ↓
Verify Authentication
        ↓
Verify Required Headers
        ↓
Prepare Request
        ↓
Send Activation Request
        ↓
Validate HTTP Response
        ↓
Validate Response Body
        ↓
Verify Client Status
        ↓
Cross-check with UI / Database
```

---

# 4. API Environment

## Base URL

```text
http://localhost:4200/
```

> The frontend URL above is known from the UI analysis. The backend API base URL must be confirmed from the running Fineract configuration before API execution.

## API Tool

```text
Postman
```

## Authentication

The API authentication mechanism must be confirmed from the current Fineract environment.

For the client API flow, verify:

- Username
- Password
- Authentication type
- Required tenant header
- Other mandatory headers

---

# 5. API Identification

Before creating the Postman request, identify the activation operation from the backend implementation or API documentation.

Record the following:

| Field | Value |
|---|---|
| API Name | Client Activation |
| HTTP Method | To be identified |
| Endpoint | To be identified |
| Base URL | To be identified |
| Authentication | To be identified |
| Tenant Header | To be identified |
| Content-Type | To be identified |
| Request Body | To be identified |
| Expected Success Status | To be confirmed |
| Expected Error Status | To be confirmed |

---

# 6. Required Headers

The following headers should be checked before execution:

| Header | Expected Value |
|---|---|
| Authorization | Valid authentication credentials/token |
| Fineract-Platform-TenantId | Correct tenant identifier |
| Content-Type | As required by the API |
| Accept | As required by the API |

> Header names and values should be verified against the actual API configuration.

---

# 7. Test Data

Use an existing eligible client.

Example client observed during UI analysis:

| Field | Example |
|---|---|
| Client Name | Ajit695423 Kumar Test695423 |
| Client ID | To be confirmed |
| Status | PENDING |
| Account No. | 000000028 |
| External ID | EXT695423 |
| Office | Mumbai Branch |

> Do not hard-code this client for final API automation. The client ID should be obtained dynamically or from controlled test data.

---

# 8. API Test Cases

## API-TC-001 – Verify Activation API Availability

### Objective

Verify that the client activation API endpoint is available.

### Steps

1. Identify the activation endpoint.
2. Open Postman.
3. Configure the required HTTP method.
4. Enter the endpoint.
5. Add required authentication and headers.
6. Send the request with valid test data.

### Expected Result

The API should respond successfully according to the configured activation operation.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## API-TC-002 – Successful Client Activation

### Objective

Verify successful activation of an eligible client.

### Preconditions

- Client exists.
- Client is eligible for activation.
- Valid authentication is available.
- Required tenant/header information is available.

### Steps

1. Identify an eligible client.
2. Prepare the activation request.
3. Add valid authentication.
4. Add required headers.
5. Send the activation request.
6. Validate the HTTP response.
7. Validate the response body.
8. Verify the client status.

### Expected Result

- Request should be accepted.
- Appropriate success HTTP status should be returned.
- Response should contain the expected activation result.
- Client status should be updated.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## API-TC-003 – Verify Response Status Code

### Steps

1. Send a valid activation request.
2. Check the HTTP response status.

### Expected Result

The API should return the appropriate success HTTP status defined by the actual implementation.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## API-TC-004 – Verify Response Body

### Steps

1. Send a successful activation request.
2. Inspect the response body.
3. Verify important response fields.

### Expected Result

The response body should contain the fields and values defined by the activation API.

### Validation Points

- Response structure
- Client identifier
- Activation result
- Status/message fields, if provided
- Error fields should not be present for a successful request

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## API-TC-005 – Verify Authentication

### Steps

1. Prepare the activation request.
2. Remove or invalidate authentication credentials.
3. Send the request.

### Expected Result

The API should reject the request according to its authentication mechanism.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## API-TC-006 – Verify Missing Tenant Header

### Steps

1. Prepare a valid activation request.
2. Remove the required tenant header.
3. Send the request.

### Expected Result

The API should reject the request if the tenant header is mandatory.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## API-TC-007 – Verify Invalid Client ID

### Steps

1. Prepare the activation request.
2. Provide an invalid/non-existing client ID.
3. Send the request.

### Expected Result

The API should reject the request and return an appropriate error response.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## API-TC-008 – Verify Missing Client ID

### Steps

1. Prepare the activation request.
2. Remove the required client identifier from the request.
3. Send the request.

### Expected Result

The API should reject the request and return an appropriate validation/error response.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## API-TC-009 – Verify Already Active Client

### Steps

1. Identify a client that is already active.
2. Send the activation request for that client.
3. Observe the response.

### Expected Result

The API should not incorrectly activate an already active client and should return the appropriate validation/business response.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## API-TC-010 – Verify Invalid Request Data

### Steps

1. Prepare an activation request.
2. Provide invalid request data according to the actual API contract.
3. Send the request.

### Expected Result

The API should reject invalid data and return appropriate validation information.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## API-TC-011 – Verify Unauthorized Activation

### Steps

1. Use credentials without the required activation permission.
2. Send a valid activation request.

### Expected Result

The API should reject the request if the user does not have sufficient permission.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## API-TC-012 – Verify Duplicate Activation Request

### Steps

1. Successfully activate an eligible client.
2. Send the activation request again for the same client.
3. Observe the response.

### Expected Result

The API should handle the duplicate activation request according to the application's business rules and should not create an invalid state.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

# 9. API and UI Integration Validation

## API-TC-013 – Verify API Activation Reflected in UI

### Steps

1. Activate the client through Postman.
2. Open the Mifos web application.
3. Navigate to Clients.
4. Search for the same client.
5. Open the client profile.
6. Check the client status.

### Expected Result

The UI should display the status resulting from the successful API activation.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

# 10. UI Activation Reflected in API

## API-TC-014 – Verify UI Activation Through API

### Steps

1. Select an eligible client in the Mifos UI.
2. Activate the client through the UI.
3. Retrieve the client information through the appropriate API.
4. Check the returned status.

### Expected Result

The API should reflect the status resulting from the UI activation.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

# 11. API and Database Validation

## API-TC-015 – Verify API Activation in Database

### Steps

1. Select an eligible client.
2. Activate the client using the API.
3. Identify the corresponding database record.
4. Query the relevant client data.
5. Compare the database status with the API result.

### Expected Result

The database should contain the status resulting from the successful API activation.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

> The exact database table and status column must be identified from the Fineract schema before execution.

---

# 12. Response Validation Checklist

For every successful activation request, verify:

- [ ] HTTP method is correct
- [ ] Endpoint is correct
- [ ] Authentication is valid
- [ ] Tenant header is correct
- [ ] Content-Type is correct
- [ ] Request payload is valid
- [ ] HTTP status is correct
- [ ] Response body is valid
- [ ] Client identifier is correct
- [ ] Activation result is correct
- [ ] Client status is updated
- [ ] No unexpected error is returned

---

# 13. Negative API Validation Checklist

Verify:

- [ ] Invalid authentication
- [ ] Missing authentication
- [ ] Missing tenant header
- [ ] Invalid client ID
- [ ] Missing client ID
- [ ] Invalid request data
- [ ] Already active client
- [ ] Unauthorized user
- [ ] Duplicate activation request

---

# 14. Postman Collection Structure

Recommended collection structure:

```text
FinEdge Bank QA Project
│
└── Sprint 2 - Client Management
    │
    └── US-002 - Activate Client
        │
        ├── 01 - Successful Activation
        ├── 02 - Authentication Validation
        ├── 03 - Header Validation
        ├── 04 - Client Validation
        ├── 05 - Negative Scenarios
        └── 06 - Integration Validation
```

---

# 15. Environment Variables

Recommended Postman environment variables:

| Variable | Purpose |
|---|---|
| `baseUrl` | Backend API base URL |
| `tenantId` | Fineract tenant identifier |
| `username` | API username |
| `password` | API password |
| `clientId` | Client ID used for activation |
| `authToken` | Authentication token, if applicable |

Example usage:

```text
{{baseUrl}}
{{tenantId}}
{{clientId}}
```

Actual values should be configured in the Postman environment and should not be hard-coded into requests.

---

# 16. API Test Execution Summary

| Metric | Count |
|---|---:|
| Total API Test Cases | 15 |
| Executed | 0 |
| Passed | 0 |
| Failed | 0 |
| Blocked | 0 |
| Not Executed | 15 |
| Defects Raised | 0 |

Update these values after actual API execution.

---

# 17. Defect Reporting

For any API failure, record:

| Field | Details |
|---|---|
| Defect ID | BUG-XXX |
| API Test Case | API-TC-XXX |
| Endpoint | Actual endpoint |
| HTTP Method | GET/POST/etc. |
| Request | Request details |
| Response Status | HTTP status |
| Expected | Expected behavior |
| Actual | Actual behavior |
| Response Body | Relevant response |
| Severity | Critical/High/Medium/Low |
| Priority | High/Medium/Low |
| Evidence | Postman screenshot/export |
| Status | New |

Do not store real passwords, tokens, or other secrets in defect screenshots or documentation.

---

# 18. API Testing Completion Criteria

API testing for US-002 is complete when:

1. The actual activation endpoint has been identified.
2. Authentication has been validated.
3. Required headers have been validated.
4. Successful activation has been tested.
5. Negative scenarios have been tested.
6. Already-active behavior has been verified.
7. Response status and body have been validated.
8. UI/API consistency has been verified.
9. Database consistency has been verified where applicable.
10. Defects have been documented.
11. Postman collection is saved in the project repository.

---

# 19. Current Status

**US-002 – Activate Client:** `In Progress`

### Completed Documentation

```text
01-Requirement-Analysis.md
02-UI-Analysis.md
03-Test-Scenarios.md
04-US-002-Activate-Client-Test-Cases.xlsx
05-US-002-Activate-Client-Requirement-Traceability-Matrix.xlsx
06-US-002-Activate-Client-Manual-Testing.md
```

### Current Document

```text
07-US-002-Activate-Client-API-Testing.md
```

### Pending

```text
08-SQL-Validation.md
09-Selenium-Automation.md
10-Bug-Reports.xlsx
11-Test-Execution.md
12-Postman
PHASE-2-COMPLETION.md
```

---

# 20. Next Activity

After the actual activation API endpoint is identified and API testing is executed, proceed with:

```text
08 – SQL Validation
```

The SQL validation should verify that the client status stored in the database matches the status returned/displayed after activation.
