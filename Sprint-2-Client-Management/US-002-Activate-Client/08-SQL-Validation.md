# US-002 – Activate Client – SQL Validation

## 1. Document Information

| Field | Details |
|---|---|
| Story ID | US-002 |
| Story Name | Activate Client |
| Module | Client Management |
| Priority | High |
| Story Points | 5 |
| Testing Type | Database / SQL Validation |
| Application | Mifos / Apache Fineract |
| Database | PostgreSQL |
| Environment | Local QA/Test Environment |
| Status | In Progress – Baseline SQL validation executed |

---

## 2. SQL Validation Objective

The objective of SQL validation for US-002 is to verify that a successful client activation performed through the application or API is correctly persisted in the backend database.

Database validation should confirm:

- Correct client record is identified.
- Client status before activation is captured.
- Client status after activation is updated.
- Only the intended client record is affected.
- Failed activation does not incorrectly update the client status.
- UI, API, and database status remain consistent.
- The activation result persists after the application is refreshed or reopened.

> The exact Fineract database table and status column must be confirmed from the current database schema before execution. This document does not assume a table/column name that has not yet been verified.

---

# 3. SQL Testing Approach

The validation flow is:

```text
Identify Client
      ↓
Capture Client ID
      ↓
Query Database Before Activation
      ↓
Record Current Status
      ↓
Activate Client Through UI/API
      ↓
Query Database After Activation
      ↓
Compare Status
      ↓
Verify UI/API/DB Consistency
```

---

# 4. Database Environment

## Database

```text
PostgreSQL
```

## Application

```text
Mifos / Apache Fineract
```

## Environment

```text
Local QA/Test Environment
```

The actual database connection details should be taken from the running project's configuration.

Do not commit database passwords or other credentials to GitHub.

---

# 5. Database Information to Identify

Before executing SQL validation, confirm the following from the actual schema:

| Information | Value |
|---|---|
| Database Name | To be identified |
| Schema | To be identified |
| Client Table | `m_client` |
| Client ID Column | `id` |
| Status Column | `status_enum` |
| Status Representation | `300` = Active (verified); `100` observed, exact business mapping to be confirmed |
| Database Host | To be identified |
| Database Port | To be identified |
| Database User | To be identified |

---

# 6. Client Identification

Use the client ID from the Mifos application/API.

Example observed client data:

| Field | Example |
|---|---|
| Client Name | Example/test clients observed in current database |
| Account No. | Example: `0000000028` |
| External ID | Example value from prior test data |
| Office | Mumbai Branch |
| Client ID | Dynamic; latest observed ID = `49` |

The client ID should be used as the primary reference for database validation.

Avoid relying only on client name because names may not be unique.

---

# 7. Pre-Activation Database Validation

## SQL-TC-001 – Verify Client Record Exists

### Objective

Verify that the selected client exists in the database.

### Steps

1. Identify the client ID.
2. Connect to PostgreSQL.
3. Identify the verified client table.
4. Query the client using the client ID.
5. Review the returned record.

### SQL Template

Replace the placeholder table and column names with the names verified from the actual schema.

```sql
SELECT *
FROM <client_table>
WHERE <client_id_column> = <client_id>;
```

### Expected Result

Exactly the intended client record should be returned.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

# 8. Capture Status Before Activation

## SQL-TC-002 – Verify Initial Client Status

### Objective

Capture the client's status before activation.

### SQL Template

```sql
SELECT
    <client_id_column>,
    <status_column>
FROM <client_table>
WHERE <client_id_column> = <client_id>;
```

### Expected Result

The query should return the selected client's current status.

For the activation scenario, the client should be in a status that is eligible for activation.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

# 9. Successful Activation Database Validation

## SQL-TC-003 – Verify Status After Successful UI Activation

### Steps

1. Query and record the client's status before activation.
2. Activate the client through the Mifos UI.
3. Wait for the activation operation to complete.
4. Query the same client again.
5. Compare the status before and after activation.

### SQL Template

```sql
SELECT
    <client_id_column>,
    <status_column>
FROM <client_table>
WHERE <client_id_column> = <client_id>;
```

### Expected Result

The database should contain the status corresponding to the successful activation.

> The exact database value must be confirmed from the actual schema/application behavior.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

# 10. Successful API Activation Database Validation

## SQL-TC-004 – Verify Status After API Activation

### Steps

1. Identify an eligible client.
2. Query the client's current database status.
3. Activate the client through the API.
4. Query the client record again.
5. Compare the database status with the API response.

### Expected Result

The database should reflect the successful API activation.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

# 11. UI/API/Database Consistency

## SQL-TC-005 – Verify UI and Database Status

### Steps

1. Activate the client through the UI.
2. Record the status displayed by the application.
3. Query the same client in the database.
4. Compare the two values.

### Expected Result

The UI and database should represent the same client state.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## SQL-TC-006 – Verify API and Database Status

### Steps

1. Activate the client through the API.
2. Record the status returned by the API.
3. Query the corresponding database record.
4. Compare the values.

### Expected Result

The API and database should represent the same client state.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

# 12. Persistence Validation

## SQL-TC-007 – Verify Status After Application Refresh

### Steps

1. Successfully activate the client.
2. Refresh the Mifos application.
3. Verify the client status in the UI.
4. Query the same client in the database.

### Expected Result

The updated status should remain persisted in the database.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## SQL-TC-008 – Verify Status After Reopening Client

### Steps

1. Successfully activate the client.
2. Navigate away from the client profile.
3. Reopen the same client.
4. Verify the UI status.
5. Query the database.

### Expected Result

The client status should remain unchanged and consistent between UI and database.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

# 13. Negative Database Validation

## SQL-TC-009 – Verify Failed Activation Does Not Change Status

### Steps

1. Identify a client and record its current database status.
2. Trigger an activation failure through a valid negative test condition.
3. Query the client again.
4. Compare the status with the original value.

### Expected Result

The database should not contain an incorrect status change caused by the failed activation.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## SQL-TC-010 – Verify Already Active Client

### Steps

1. Identify an already active client.
2. Query its current database status.
3. Attempt activation through the UI/API.
4. Query the database again.

### Expected Result

The database should not create an invalid or duplicate activation state.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

# 14. Data Integrity Validation

## SQL-TC-011 – Verify Only Selected Client Is Updated

### Steps

1. Identify multiple client records.
2. Record their current statuses.
3. Activate one selected client.
4. Query all relevant client records.
5. Compare statuses before and after activation.

### Expected Result

Only the selected client should have its status changed as a result of the activation operation.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

## SQL-TC-012 – Verify Client Identity

### Steps

1. Identify the client in the UI.
2. Capture the client ID.
3. Query the database using the client ID.
4. Compare identifying information such as client name/external ID where applicable.

### Expected Result

The database record should correspond to the client selected in the application.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

# 15. Audit / Timestamp Validation

## SQL-TC-013 – Verify Relevant Audit Information

### Objective

Where the schema provides audit information, verify that the activation operation results in appropriate audit/timestamp information.

### Steps

1. Record relevant audit fields before activation.
2. Activate the client.
3. Query the client record after activation.
4. Compare the relevant audit information.

### Expected Result

Relevant audit fields should reflect the update according to the application's database design.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

> Do not assume specific audit columns. First verify them in the actual schema.

---

# 16. Transaction / Data Integrity Validation

## SQL-TC-014 – Verify No Partial Database Update

### Steps

1. Trigger a successful activation.
2. Review the relevant client data.
3. Verify that the record is internally consistent.
4. If activation fails, repeat the validation and check for unintended partial changes.

### Expected Result

- Successful activation should produce a consistent database state.
- Failed activation should not leave unintended partial data.

### Actual Result

To be recorded during execution.

### Status

`Not Executed`

---

# 17. Executed Database Validation – 22 September 2026

The following baseline SQL validations were executed against the current local PostgreSQL database. These results confirm the current `m_client` schema and client-status distribution. They are separate from the activation-specific UI/API test cases, which still require execution.

## 17.1 Total Client Records

```sql
SELECT COUNT(*) AS total_clients
FROM m_client;
```

**Observed:** `40` client records.

## 17.2 Client Count by Status

```sql
SELECT status_enum, COUNT(*) AS total_clients
FROM m_client
GROUP BY status_enum
ORDER BY status_enum;
```

**Observed:**

| Status Enum | Client Count | Interpretation |
|---:|---:|---|
| `100` | 29 | Status value observed; exact business mapping to be confirmed |
| `300` | 11 | **Active** – verified from the current Mifos/Fineract environment |

## 17.3 Active Client Records

```sql
SELECT id, account_no, display_name, status_enum
FROM m_client
WHERE status_enum = 300
ORDER BY id;
```

**Observed:** `11` active clients.

## 17.4 Client Records With Status 100

```sql
SELECT id, account_no, display_name
FROM m_client
WHERE status_enum = 100
ORDER BY account_no;
```

**Observed:** `29` clients. The document intentionally records this as **status 100** until its exact application/business label is confirmed.

## 17.5 Verify a Specific Client by Account Number

```sql
SELECT id, account_no, display_name, status_enum
FROM m_client
WHERE account_no = '0000000029';
```

**Observed:** Client ID `29`; `status_enum = 300` (Active).

## 17.6 Latest Client by ID

```sql
SELECT id, account_no, display_name, status_enum
FROM m_client
ORDER BY id DESC
LIMIT 1;
```

**Observed:** Client ID `49`, account number `0000000049`, `status_enum = 100`.

> The highest ID is used here as the latest identifier for the current dataset. For production-grade audit validation, use `created_on_utc` when verifying creation chronology.

## 17.7 Minimum Active Client ID

```sql
SELECT MIN(id) AS minimum_active_client_id
FROM m_client
WHERE status_enum = 300;
```

**Observed:** `1`.

## 17.8 Maximum Client ID

```sql
SELECT MAX(id) AS maximum_client_id
FROM m_client;
```

**Observed:** `49`.

## 17.9 Clients With Ajit in Display Name

```sql
SELECT COUNT(*) AS total_ajit_clients
FROM m_client
WHERE display_name LIKE '%Ajit%';
```

**Observed:** `24`.

## 17.10 Account Numbers Starting With 00000000

```sql
SELECT COUNT(*) AS matching_accounts
FROM m_client
WHERE account_no LIKE '00000000%';
```

**Observed:** `8`.

## 17.11 Database Validation Conclusion

The current database schema has been verified as follows:

- Client table: `m_client`
- Client primary key: `id`
- Account number: `account_no`
- Client name: `display_name`
- Client status: `status_enum`
- Active status value: `300`
- Current total client records: `40`
- Current active client records: `11`
- Current records with status `100`: `29`

Activation-specific database validation must still compare a client's **before-activation** and **after-activation** status as part of the UI/API activation test execution.

---

# 17. SQL Query Templates

## Find Client by ID

```sql
SELECT *
FROM <client_table>
WHERE <client_id_column> = <client_id>;
```

## Find Client by External ID

```sql
SELECT *
FROM <client_table>
WHERE <external_id_column> = '<external_id>';
```

## Check Client Status

```sql
SELECT
    <client_id_column>,
    <status_column>
FROM <client_table>
WHERE <client_id_column> = <client_id>;
```

## Verify Multiple Clients

```sql
SELECT
    <client_id_column>,
    <status_column>
FROM <client_table>
WHERE <client_id_column> IN (<client_id_1>, <client_id_2>);
```

> These are templates only. Replace placeholders after confirming the actual Fineract schema.

---

# 18. Database Validation Checklist

### Before Activation

- [ ] Client exists
- [ ] Correct client ID identified
- [ ] Initial status recorded
- [ ] Client is eligible for activation
- [ ] Relevant database table confirmed
- [ ] Relevant status column confirmed

### After Successful Activation

- [ ] Client record still exists
- [ ] Status is updated correctly
- [ ] Client ID is unchanged
- [ ] Relevant audit information is correct, if applicable
- [ ] No unrelated client record changed

### After Failed Activation

- [ ] Client record remains valid
- [ ] Status remains unchanged
- [ ] No unintended partial update
- [ ] Error is handled correctly

---

# 19. SQL Test Execution Summary

| Metric | Count |
|---|---:|
| Total SQL Test Cases | 14 |
| Executed | 0 |
| Passed | 0 |
| Failed | 0 |
| Blocked | 0 |
| Not Executed | 14 |
| Defects Raised | 0 |

Update these values after actual SQL execution.

---

# 20. Defect Reporting

For a database-related failure, record:

| Field | Details |
|---|---|
| Defect ID | BUG-XXX |
| SQL Test Case | SQL-TC-XXX |
| Client ID | Test client ID |
| Table | Actual table |
| Column | Actual column |
| Expected Value | Expected database value |
| Actual Value | Actual database value |
| SQL Query | Relevant query |
| Application Result | UI/API result |
| Database Result | DB result |
| Severity | Critical/High/Medium/Low |
| Priority | High/Medium/Low |
| Evidence | Screenshot/query output |
| Status | New |

Do not include database passwords, tokens, or other credentials in defect reports.

---

# 21. SQL Validation Completion Criteria

SQL validation for US-002 is complete when:

1. The actual client table has been identified.
2. The actual client ID column has been identified.
3. The actual status column/value has been identified.
4. Initial client status has been verified.
5. Successful UI activation has been validated in the database.
6. Successful API activation has been validated in the database.
7. Failed activation behavior has been validated.
8. Already-active behavior has been validated.
9. UI/API/database consistency has been verified.
10. Data integrity has been verified.
11. Relevant audit information has been checked where applicable.
12. SQL test results and defects have been documented.

---

# 22. Current Project Status

**US-002 – Activate Client:** `In Progress – Baseline SQL Validation Executed`

### Completed

```text
01-Requirement-Analysis.md
02-UI-Analysis.md
03-Test-Scenarios.md
04-US-002-Activate-Client-Test-Cases.xlsx
05-US-002-Activate-Client-Requirement-Traceability-Matrix.xlsx
06-US-002-Activate-Client-Manual-Testing.md
07-US-002-Activate-Client-API-Testing.md
08-US-002-Activate-Client-SQL-Validation.md
```

### Pending

```text
09-Selenium-Automation.md
10-Bug-Reports.xlsx
11-Test-Execution.md
12-Postman
PHASE-2-COMPLETION.md
```

---

# 23. Next Activity

After completing the baseline database validation documented above, proceed with the remaining activation-specific validation and then:

```text
09 – Selenium Automation
```

The Selenium automation will automate the verified UI flow:

```text
Clients
  ↓
Search Client
  ↓
Open Client
  ↓
Three-dot Menu
  ↓
Actions
  ↓
Activate
  ↓
Verify Activation Result
  ↓
Verify Client Status
```

Dynamic client IDs and client-specific data should be handled without hard-coding values wherever possible.
