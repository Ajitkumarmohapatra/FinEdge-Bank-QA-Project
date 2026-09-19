# US-002 – Activate Client – SQL Validation

## 1. Document Information

| Field | Details |
|---|---|
| Story ID | US-002 |
| Story Name | Activate Client |
| Module | Client Management |
| Priority | High |
| Testing Type | Database / SQL Validation |
| Application | Mifos / Apache Fineract |
| Database | PostgreSQL |
| Environment | Local QA/Test Environment |
| Execution Date | 19 September 2026 |
| Status | In Progress |

---

## 2. SQL Validation Objective

The objective is to verify that successful client activation is correctly persisted in the PostgreSQL database.

The validation confirms:

- Correct client record is identified.
- Client status is updated after activation.
- Activation date is stored.
- Database data is consistent with the application result.

---

## 3. Actual Database Information

The client data was validated in the Fineract client table:

```text
m_client
```

The client record used for validation was:

| Field | Value |
|---|---|
| Client ID | 11 |
| Client Name | Temp postman Customer |
| Account No. | 000000011 |
| Activation Date | 19 September 2026 |

---

## 4. Client Status Validation

### TC-022 – Verify Client Status in Database After Activation

**Status: PASS**

The client record was queried from `m_client`.

### Validation Query

```sql
SELECT
    id,
    display_name,
    status_enum,
    activation_date
FROM m_client
WHERE id = 11;
```

### Expected Result

The query should return Client ID 11 with the updated activation information after successful activation.

### Actual Result

The database record showed the expected current client data and activation date.

**Result: PASS**

---

## 5. Date-Based SQL Validation

Activation records were also validated using a date filter.

Example:

```sql
SELECT
    id,
    display_name,
    status_enum,
    activation_date
FROM m_client
WHERE activation_date::date = DATE '2026-09-15';
```

The query can be changed to any required date.

For grouped validation using `HAVING`:

```sql
SELECT
    activation_date::date AS activation_date,
    COUNT(*) AS total_clients
FROM m_client
GROUP BY activation_date::date
HAVING activation_date::date = DATE '2026-09-15'
   AND COUNT(*) > 1;
```

This confirms the correct use of `GROUP BY` and `HAVING` for aggregated date validation.

---

## 6. SQL Execution Summary

Only the executed SQL validation is recorded as completed at this stage.

| Metric | Count |
|---|---:|
| Executed SQL Test Cases | 1 |
| Passed | 1 |
| Failed | 0 |
| Not Executed | 13 |
| Defects from SQL Testing | 0 |

### Executed

- TC-022 – Verify client status in database after activation → **PASS**

### Remaining SQL Validation

Additional database validations may include:

- Failed activation does not change status
- Already-active client validation
- Only selected client is updated
- UI/database consistency
- API/database consistency
- Data integrity
- Audit/timestamp validation

These remain **Not Executed** until actually performed.

---

## 7. UI / API / Database Consistency

For the executed activation flow:

```text
Postman API
     ↓
HTTP 200 OK
     ↓
Client ID 11 activated
     ↓
Mifos UI shows Active
     ↓
PostgreSQL m_client record reflects activation
```

The executed API, UI, and database validation were consistent.

---

## 8. Important SQL Learning

### WHERE

`WHERE` filters individual rows before grouping.

Example:

```sql
SELECT *
FROM m_client
WHERE activation_date::date = DATE '2026-09-15';
```

### HAVING

`HAVING` filters grouped/aggregated results.

Example:

```sql
SELECT
    activation_date::date,
    COUNT(*) AS total_clients
FROM m_client
GROUP BY activation_date::date
HAVING activation_date::date = DATE '2026-09-15'
   AND COUNT(*) > 1;
```

The invalid expression:

```sql
activation_date = date = DATE '2026-09-15'
```

was corrected to:

```sql
activation_date::date = DATE '2026-09-15'
```

---

## 9. Current Status

**US-002 – Activate Client SQL Validation:** `In Progress`

Completed:

- PostgreSQL validation
- `m_client` table validation
- Client ID validation
- Activation date validation
- Successful activation database validation
- Date-based filtering
- `GROUP BY` / `HAVING` validation

Pending:

- Additional negative database validations
- UI/database integration validation
- API/database integration validation
- Additional data-integrity checks

---

## 10. Next Activity

Proceed with:

```text
09 – Selenium Automation
```

The Selenium automation should use the already verified UI flow:

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
Verify Activation
```

The failed three-dot menu scenario (**TC-008**) should also be considered when designing the automation and defect reproduction steps.
