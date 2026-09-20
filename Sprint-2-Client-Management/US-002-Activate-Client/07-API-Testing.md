# US-002 – Activate Client – API Testing

## 1. Document Information

| Field | Details |
|---|---|
| Story ID | US-002 |
| Story Name | Activate Client |
| Module | Client Management |
| Priority | High |
| Testing Type | API Testing |
| Tool | Postman |
| Application | Mifos / Apache Fineract |
| Environment | Local QA/Test Environment |
| Overall Execution | 19–20 September 2026 |
| Status | Completed |

---

## 2. API Testing Objective

The objective of API testing for US-002 is to verify that client activation is correctly processed through the Apache Fineract backend API.

The testing covered:

- Successful client activation
- Invalid client ID
- Already active client
- Missing authentication
- Invalid authentication
- Missing tenant header
- Invalid tenant ID
- Invalid client ID format
- Unsupported HTTP method
- Client activation in an invalid state
- API response validation
- API/UI/Database consistency

---

## 3. Actual Activate Client API

The activation API was identified from the browser Network request during client activation.

### Request

**Method:**

```text
POST
```

**Endpoint:**

```text
{{baseUrl}}/clients/11?command=activate
```

### Headers

```text
Authorization: {{authorization}}
Fineract-Platform-TenantId: {{tenant}}
Content-Type: application/json
Accept: application/json
```

### Authentication

The current environment uses **Basic Authentication**.

The Postman environment variable:

```text
{{authorization}}
```

resolves to a Basic Authentication value.

Actual credentials are not stored in the project repository.

### Request Body

```json
{
  "activationDate": "19 September 2026",
  "dateFormat": "dd MMMM yyyy",
  "locale": "en"
}
```

---

# 4. Positive API Test

## TC-021 – Verify Client Activation Through API

**Execution Date:** 19 September 2026

**Status: PASS**

### Test Data

| Field | Value |
|---|---|
| Client Name | Temp postman Customer |
| Client ID | 11 |
| Account No. | 000000011 |
| Status before API activation | PENDING |
| Activation Date | 19 September 2026 |

### Execution Steps

1. Created a new Postman request.
2. Selected `POST` method.
3. Used the activation endpoint:
   `{{baseUrl}}/clients/11?command=activate`
4. Added the required authentication and tenant headers.
5. Added the activation request body.
6. Sent the request.
7. Verified the HTTP response.
8. Opened the Mifos client profile.
9. Verified that the client status changed to Active.
10. Validated the client status and activation date in the database.

### Actual Response

**HTTP Status:**

```text
200 OK
```

**Response Body:**

```json
{
  "officeId": 2,
  "clientId": 11,
  "resourceId": 11
}
```

### UI Verification

After the API request, Client ID 11 was opened in Mifos.

Observed:

- Client Name: `Temp postman Customer`
- Client ID: `11`
- Account No.: `000000011`
- Activation Date: `19 September 2026`
- Client displayed as Active with the green status indicator.

**Result: PASS**

---

# 5. Negative and Edge Case API Testing

Negative and edge-case API validations were executed on **20 September 2026** using Postman.

## NEG-01 – Invalid Client ID

**Request:**

```http
POST {{baseUrl}}/clients/999?command=activate
```

**Actual Response:**

```text
400 Bad Request
```

**Result: PASS**

The API rejected the request for an invalid/non-existing client ID.

---

## NEG-02 – Already Active Client

**Request:**

```http
POST {{baseUrl}}/clients/11?command=activate
```

**Actual Response:**

```text
400 Bad Request
```

**Result: PASS**

The API rejected the repeated activation request for a client that was already Active.

---

## NEG-03 – Missing Authentication

The Authorization header was removed from the request.

**Request:**

```http
POST {{baseUrl}}/clients/11?command=activate
```

**Actual Response:**

```text
401 Unauthorized
```

**Result: PASS**

The API correctly rejected the unauthenticated request.

---

## NEG-04 – Invalid Authentication

Basic Authentication was configured with invalid credentials.

**Request:**

```http
POST {{baseUrl}}/clients/11?command=activate
```

**Actual Response:**

```text
400 Bad Request
```

**Result: PASS**

The request was rejected and client activation was not performed.

> Note: The environment returned `400 Bad Request` rather than `401 Unauthorized`. The actual response returned by the environment is documented without changing it to an assumed status code.

---

## NEG-05 – Missing Tenant Header

The `Fineract-Platform-TenantId` header was removed.

**Request:**

```http
POST {{baseUrl}}/clients/11?command=activate
```

**Actual Response:**

```text
400 Bad Request
```

**Result: PASS**

The API rejected the request because the required tenant information was missing.

---

## NEG-06 – Invalid Tenant ID

An invalid tenant value was supplied.

```text
Fineract-Platform-TenantId: invalidtennat
```

**Request:**

```http
POST {{baseUrl}}/clients/11?command=activate
```

**Actual Response:**

```text
400 Bad Request
```

**Result: PASS**

The API rejected the request with an invalid tenant ID.

---

## NEG-07 – Invalid Client ID Format

A non-numeric client ID was supplied.

**Request:**

```http
POST {{baseUrl}}/clients/abc?command=activate
```

**Actual Response:**

```text
400 Bad Request
```

**Result: PASS**

The API rejected the invalid client ID format.

---

## NEG-08 – Unsupported HTTP Method

The activation endpoint was tested using an unsupported HTTP method instead of the required `POST`.

**Result: PASS**

The endpoint did not allow activation through the unsupported method.

---

## NEG-09 – Activate Client in Invalid State

A client in a non-activatable state was used to verify the activation business rule.

**Request:**

```http
POST {{baseUrl}}/clients/{clientId}?command=activate
```

**Result: PASS**

The API rejected activation when the client was not in a valid state for activation.

---

# 6. API Test Execution Summary

| Metric | Count |
|---|---:|
| Positive API Test Cases | 1 |
| Negative/Edge API Test Cases | 9 |
| Total Executed API Test Cases | 10 |
| Passed | 10 |
| Failed | 0 |
| Not Executed | 0 |
| API Defects Identified | 0 |

### Executed Test Cases

- TC-021 – Successful client activation → **PASS** — 19 September 2026
- NEG-01 – Invalid Client ID → **PASS**
- NEG-02 – Already Active Client → **PASS**
- NEG-03 – Missing Authentication → **PASS**
- NEG-04 – Invalid Authentication → **PASS**
- NEG-05 – Missing Tenant Header → **PASS**
- NEG-06 – Invalid Tenant ID → **PASS**
- NEG-07 – Invalid Client ID Format → **PASS**
- NEG-08 – Unsupported HTTP Method → **PASS**
- NEG-09 – Client in Invalid State → **PASS**

---

# 7. API and Database Validation

The successful activation was validated against the database.

### Database Table

```text
m_client
```

### Relevant Fields

```text
id
display_name
status_enum
activation_date
```

### Successful Activation Validation

For Client ID `11`:

| Validation | Result |
|---|---|
| Client ID exists | PASS |
| Client status changed to Active | PASS |
| Activation date populated | PASS |
| Activation date matches API/UI result | PASS |

### Negative/Edge Case Database Validation

For unsuccessful activation requests:

| Validation | Result |
|---|---|
| Client status should not be incorrectly changed | PASS |
| Activation date should not be incorrectly updated | PASS |
| Invalid client request should not modify existing client data | PASS |
| Invalid authentication should not modify client data | PASS |
| Invalid tenant request should not modify client data | PASS |
| Already active client should remain Active | PASS |

---

# 8. API/UI/Database Consistency

The activation flow was validated across all three layers.

```text
Postman API
     ↓
Fineract Backend
     ↓
Database
     ↓
Mifos Web UI
```

| Validation | Result |
|---|---|
| API returned successful activation response | PASS |
| Correct Client ID returned | PASS |
| Database status updated correctly | PASS |
| Database activation date populated correctly | PASS |
| UI displayed client as Active | PASS |
| UI activation date matched expected value | PASS |
| Negative API requests were rejected | PASS |
| Negative requests did not incorrectly modify database data | PASS |

---

# 9. Final API Testing Status

**US-002 – Activate Client API Testing: COMPLETED**

### Completed Activities

- Activation endpoint identification
- POST method validation
- Basic Authentication validation
- Tenant header validation
- Successful activation
- Response status validation
- Response body validation
- UI verification
- Database validation
- Invalid Client ID testing
- Already Active Client testing
- Missing Authentication testing
- Invalid Authentication testing
- Missing Tenant Header testing
- Invalid Tenant ID testing
- Invalid Client ID format testing
- Unsupported HTTP method testing
- Invalid client-state testing
- API/UI/Database consistency validation

### Final Result

```text
API Testing: COMPLETED
Positive Tests: PASS
Negative Tests: PASS
Edge Cases: PASS
Database Validation: PASS
UI Validation: PASS
Overall Result: PASS
```

---

# 10. Next Activity

US-002 API testing is complete.

Next activities:

```text
1. Complete/verify SQL validation documentation
2. Create/update API test execution documentation
3. Begin Activate Client automation
4. Add automated API/database validation where applicable
5. Update Sprint 2 completion documentation
```

Do not store real credentials, passwords, or tokens in the project repository.
