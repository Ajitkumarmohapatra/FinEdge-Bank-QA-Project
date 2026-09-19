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
| Execution Date | 19 September 2026 |
| Status | In Progress |

---

## 2. API Testing Objective

The objective is to verify that client activation is correctly processed through the Fineract backend API and that the resulting client state is reflected in the application.

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

For the local environment, `baseUrl` resolves to the Fineract API base path.

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

Do not commit the actual credential/token value to GitHub.

### Request Body

```json
{
  "activationDate": "19 September 2026",
  "dateFormat": "dd MMMM yyyy",
  "locale": "en"
}
```

---

## 4. API Test Execution

### TC-021 – Verify Client Activation Through API

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
8. Opened the Mifos client profile and verified the resulting status.

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
- Client displayed as active with the green status indicator.

**Result: PASS**

---

## 5. API Execution Summary

The API document contains multiple planned API validations, but only the successfully executed activation API test is recorded as executed at this stage.

| Metric | Count |
|---|---:|
| Executed API Test Cases | 1 |
| Passed | 1 |
| Failed | 0 |
| Not Executed | 14 |
| Defects from API Testing | 0 |

### Executed

- TC-021 – Successful client activation through API → **PASS**

### Planned / Remaining API Validation

- Invalid authentication
- Missing authentication
- Missing tenant header
- Invalid client ID
- Missing client ID
- Invalid request data
- Already active client
- Unauthorized API activation
- Duplicate activation request
- Additional response/header validations

These should remain **Not Executed** until actually tested.

---

## 6. API/UI Consistency

The successful API activation was followed by UI verification.

| Validation | Result |
|---|---|
| API returned 200 OK | PASS |
| API returned correct client ID | PASS |
| Client activation date reflected in UI | PASS |
| Client displayed as active in UI | PASS |

---

## 7. Current Status

**US-002 – Activate Client API Testing:** `In Progress`

Completed:

- Activation endpoint identification
- Request method validation
- Basic Authentication configuration
- Tenant header validation for successful request
- Successful activation request
- Response status validation
- Response body validation
- UI verification after API activation

Pending:

- Remaining negative API cases
- Authentication negative cases
- Header validation cases
- Already-active API behavior
- Duplicate activation validation
- Final Postman collection/documentation

---

## 8. Next Activity

Continue remaining API validations when required, then proceed with:

```text
08 – SQL Validation
```

Do not store real credentials, passwords, or tokens in the project repository.
