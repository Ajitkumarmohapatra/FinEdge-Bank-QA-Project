Create Client — SQL Validation

Objective

Database validation for the Create Client module using PostgreSQL and the m_client table.

Note: Query numbers follow our working session. Some queries were intentionally skipped/replaced while validating the database.

Query 01 — Verify Client ID and Account Number

Purpose: Verify client IDs and their generated account numbers.

SELECT id, account_no
FROM m_client
WHERE id IN (1,2,3);

Result: IDs 1, 2, 3 returned with account numbers 000000001, 000000002, 000000003.

Query 02 — Verify Client IDs Within a Range

Purpose: Retrieve clients whose IDs fall between 1 and 3.

SELECT id, account_no
FROM m_client
WHERE id BETWEEN 1 AND 3;

Query 03 — Find Unique Client Status Values

Purpose: Identify the different status_enum values currently stored.

SELECT DISTINCT status_enum
FROM m_client;

Observed: 100, 300.

Query 04 — Find Unique Office IDs

Purpose: Identify how many different offices are associated with clients.

SELECT DISTINCT office_id
FROM m_client;

Observed: 1, 2, 3.

Query 05 — Verify Status and Office Combinations

Purpose: Identify unique combinations of client status and office.

SELECT DISTINCT status_enum, office_id
FROM m_client;

Observed combinations: (300,3), (300,2), (100,1), (100,2), (300,1).

Query 06 — Count Total Clients

Purpose: Verify the total number of client records.

SELECT COUNT(*) AS total
FROM m_client;

Observed: 13.

Query 07 — Find Minimum and Maximum Client IDs

Purpose: Verify the lowest and highest client IDs currently present.

SELECT MIN(id) AS minimum,
       MAX(id) AS maximum
FROM m_client;

Observed: minimum 1, maximum 17.

Query 08 — Find Clients With NULL Mobile Number

Purpose: Identify clients where the mobile number is missing.

SELECT id, display_name
FROM m_client
WHERE mobile_no IS NULL;

Observed: One record was returned during testing.

Query 09 — Count Clients by Status

Purpose: Verify how many clients exist for each status.

SELECT status_enum, COUNT(*) AS total
FROM m_client
GROUP BY status_enum;

Observed: status 100 = 9, status 300 = 4.

Query 10 — Sort Client Status Counts Descending

Purpose: Display status groups from the highest client count to the lowest.

SELECT status_enum, COUNT(*) AS total
FROM m_client
GROUP BY status_enum
ORDER BY total DESC;

Query 11 — Sort Client Status Counts Ascending

Purpose: Display status groups from the lowest client count to the highest.

SELECT status_enum, COUNT(*) AS data
FROM m_client
GROUP BY status_enum
ORDER BY data ASC;

Observed: status 300 = 4, status 100 = 9.

Query 12 — Find Status Groups Having More Than 5 Clients

Purpose: Identify status values that contain more than five client records.

SELECT status_enum, COUNT(*) AS total
FROM m_client
GROUP BY status_enum
HAVING COUNT(*) > 5;

Observed: status 100 = 9.

Query 13 — Get Recent Clients

Purpose: Retrieve the three clients with the highest IDs.

SELECT id, display_name
FROM m_client
ORDER BY id DESC
LIMIT 3;

Observed: IDs 17, 16, 15.

Query 14 — Get First Three Clients

Purpose: Retrieve the first three clients based on ascending ID.

SELECT id, display_name
FROM m_client
ORDER BY id ASC
LIMIT 3;

Query 15 — Find Client Names Starting With R

Purpose: Search for client names beginning with R.

SELECT id, display_name
FROM m_client
WHERE display_name LIKE 'R%';

Query 16 — Find Duplicate Display Names

Purpose: Identify client display names that occur more than once.

SELECT display_name
FROM m_client
GROUP BY display_name
HAVING COUNT(*) > 1;

Observed: Temp postman Customer.

Query 17 — Find Duplicate Account Numbers

Purpose: Verify whether the same account number is assigned to multiple clients.

SELECT account_no, COUNT(*) AS total
FROM m_client
WHERE account_no IS NOT NULL
GROUP BY account_no
HAVING COUNT(*) > 1;

Query 18 — Find Clients With NULL Account Number

Purpose: Identify clients without an account number.

SELECT id, account_no, display_name
FROM m_client
WHERE account_no IS NULL;

Query 19 — Find Clients With NULL Display Name

Purpose: Identify client records where the display name is missing.

SELECT id, display_name
FROM m_client
WHERE display_name IS NULL;

Query 20 — Find Clients With NULL Office ID

Purpose: Identify clients that are not linked to an office.

SELECT id, display_name
FROM m_client
WHERE office_id IS NULL;

Observed: 0 rows.

Query 21 — Verify Office Referential Integrity

Purpose: Find clients whose office_id does not exist in m_office.

SELECT c.id, c.display_name, c.office_id
FROM m_client c
LEFT JOIN m_office o ON c.office_id = o.id
WHERE o.id IS NULL;

Observed: 0 rows.

Query 22 — Validate Status Values

Purpose: Find client records containing an unexpected status value.

SELECT DISTINCT status_enum
FROM m_client
WHERE status_enum NOT IN (100, 300);

Observed: 0 rows.

Query 23 — Find Duplicate Mobile Numbers

Purpose: Verify whether the same mobile number is assigned to multiple clients.

SELECT mobile_no, COUNT(*) AS total
FROM m_client
WHERE mobile_no IS NOT NULL
GROUP BY mobile_no
HAVING COUNT(*) > 1;

Observed: 0 rows.

Query 24 — Validate Mobile Number Length

Purpose: Find mobile numbers that are not exactly 10 characters long.

SELECT id, display_name, mobile_no
FROM m_client
WHERE mobile_no IS NOT NULL
  AND LENGTH(mobile_no) <> 10;

Observed: 0 rows.

Query 25 — Validate Mobile Number Characters

Purpose: Find mobile numbers containing letters, spaces, or special characters.

SELECT id, display_name, mobile_no
FROM m_client
WHERE mobile_no IS NOT NULL
  AND mobile_no !~ '^[0-9]+$';

Observed: 0 rows.

Query 26 — Check Available Columns in m_client

Purpose: Identify the actual column names before writing validation queries.

SELECT column_name
FROM information_schema.columns
WHERE table_name = 'm_client'
ORDER BY ordinal_position;

Important finding: The email column is email_address, not email.

Query 27 — Validate Email Format

Purpose: Find populated email addresses that do not match a basic email format.

SELECT id, display_name, email_address
FROM m_client
WHERE email_address IS NOT NULL
  AND email_address !~ '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$';

Observed: 0 rows.

Query 28 — Find Duplicate Email Addresses

Purpose: Find email addresses assigned to more than one client.

SELECT email_address, COUNT(*) AS total
FROM m_client
WHERE email_address IS NOT NULL
GROUP BY email_address
HAVING COUNT(*) > 1;

Observed: One email address was used by 5 client records.

Query 29 — Identify Clients With Duplicate Emails

Purpose: Retrieve the actual client records associated with duplicate email addresses.

SELECT id, account_no, display_name, email_address
FROM m_client
WHERE email_address IN (
    SELECT email_address
    FROM m_client
    WHERE email_address IS NOT NULL
    GROUP BY email_address
    HAVING COUNT(*) > 1
)
ORDER BY email_address, id;

Observed: 5 client records were returned.

Query 30 — Check Duplicate External IDs

Purpose: Verify whether multiple clients have the same external_id, which can cause integration/data-mapping problems.

SELECT external_id, COUNT(*) AS total
FROM m_client
WHERE external_id IS NOT NULL
GROUP BY external_id
HAVING COUNT(*) > 1;

Query 31 — Check Clients Missing External ID

Purpose: Identify clients that do not have an external_id.

SELECT id, account_no, display_name
FROM m_client
WHERE external_id IS NULL;

Query 32 — Count Clients by Active Status

Purpose: Check the distribution of is_active values.

SELECT is_active, COUNT(*) AS total
FROM m_client
GROUP BY is_active
ORDER BY is_active;

Additional High-Value QA Queries

Query 33 — Count Clients by Office

Purpose: Verify the number of clients assigned to each office.

SELECT office_id, COUNT(*) AS total_clients
FROM m_client
GROUP BY office_id
ORDER BY total_clients DESC;

Query 34 — Count Active Clients by Office

Purpose: Verify active-client distribution across offices.

SELECT office_id, COUNT(*) AS active_clients
FROM m_client
WHERE is_active = TRUE
GROUP BY office_id
ORDER BY active_clients DESC;

Query 35 — Count Inactive Clients by Office

Purpose: Verify inactive-client distribution across offices.

SELECT office_id, COUNT(*) AS inactive_clients
FROM m_client
WHERE is_active = FALSE
GROUP BY office_id
ORDER BY inactive_clients DESC;

Query 36 — Find Clients With Missing First Name

Purpose: Identify client records with a NULL first name.

SELECT id, account_no, display_name
FROM m_client
WHERE firstname IS NULL;

Query 37 — Find Clients With Missing Last Name

Purpose: Identify client records with a NULL last name.

SELECT id, account_no, display_name
FROM m_client
WHERE lastname IS NULL;

Query 38 — Find Clients With Missing Full Name

Purpose: Identify records where fullname is NULL.

SELECT id, account_no, display_name
FROM m_client
WHERE fullname IS NULL;

Query 39 — Find Clients With Missing Activation Date

Purpose: Identify clients that do not have an activation date.

SELECT id, account_no, display_name
FROM m_client
WHERE activation_date IS NULL;

Query 40 — Find Clients With Future Activation Date

Purpose: Detect clients whose activation date is incorrectly set in the future.

SELECT id, account_no, display_name, activation_date
FROM m_client
WHERE activation_date > CURRENT_DATE;

Query 41 — Find Clients With Future Submission Date

Purpose: Detect records whose submission date is later than today.

SELECT id, account_no, display_name, submittedon_date
FROM m_client
WHERE submittedon_date > CURRENT_DATE;

Query 42 — Verify Client Status/Office Distribution

Purpose: Analyze the number of clients for each status-office combination.

SELECT status_enum, office_id, COUNT(*) AS total
FROM m_client
GROUP BY status_enum, office_id
ORDER BY office_id, status_enum;

Query 43 — Find Active Clients With Missing Mobile Number

Purpose: Identify active clients who do not have a mobile number.

SELECT id, account_no, display_name
FROM m_client
WHERE is_active = TRUE
  AND mobile_no IS NULL;

Query 44 — Find Active Clients With Missing Email

Purpose: Identify active clients who do not have an email address.

SELECT id, account_no, display_name
FROM m_client
WHERE is_active = TRUE
  AND email_address IS NULL;

Query 45 — Find Clients With Both Mobile and Email Missing

Purpose: Identify client records missing both major contact fields.

SELECT id, account_no, display_name
FROM m_client
WHERE mobile_no IS NULL
  AND email_address IS NULL;

Query 46 — Find Clients With Both Mobile and Email Present

Purpose: Identify clients having both primary contact fields populated.

SELECT id, account_no, display_name, mobile_no, email_address
FROM m_client
WHERE mobile_no IS NOT NULL
  AND email_address IS NOT NULL;

Query 47 — Verify Account Number Length

Purpose: Find account numbers whose length differs from the expected 9-character format observed in the test data.

SELECT id, account_no, display_name
FROM m_client
WHERE account_no IS NOT NULL
  AND LENGTH(account_no) <> 9;

Adjust 9 if the application's actual account-number specification is different.

Query 48 — Check Account Number Characters

Purpose: Find account numbers containing non-digit characters.

SELECT id, account_no, display_name
FROM m_client
WHERE account_no IS NOT NULL
  AND account_no !~ '^[0-9]+$';

Query 49 — Find Duplicate Full Names

Purpose: Identify potentially duplicate client identities based on fullname.

SELECT fullname, COUNT(*) AS total
FROM m_client
WHERE fullname IS NOT NULL
GROUP BY fullname
HAVING COUNT(*) > 1;

Query 50 — Find Duplicate Mobile and Email Combination

Purpose: Identify clients sharing the exact same mobile/email combination.

SELECT mobile_no, email_address, COUNT(*) AS total
FROM m_client
WHERE mobile_no IS NOT NULL
  AND email_address IS NOT NULL
GROUP BY mobile_no, email_address
HAVING COUNT(*) > 1;

Query 51 — Verify IDs With Missing Account Number

Purpose: Check whether any client ID lacks a generated account number.

SELECT id, display_name
FROM m_client
WHERE account_no IS NULL
ORDER BY id;

Query 52 — Find Suspicious Display Names

Purpose: Identify client names containing HTML/script-like characters that may require security-test review.

SELECT id, display_name
FROM m_client
WHERE display_name ~ '[<>]';

Query 53 — Find Display Names Containing SQL-Like Keywords

Purpose: Identify suspicious data that may have originated from SQL-injection negative testing.

SELECT id, display_name
FROM m_client
WHERE display_name ILIKE '%DROP TABLE%'
   OR display_name ILIKE '%SELECT %'
   OR display_name ILIKE '%--%';

Query 54 — Verify Total Active vs Inactive Clients

Purpose: Get a simple active/inactive client count for reconciliation.

SELECT
    COUNT(*) FILTER (WHERE is_active = TRUE) AS active_clients,
    COUNT(*) FILTER (WHERE is_active = FALSE) AS inactive_clients,
    COUNT(*) AS total_clients
FROM m_client;

Query 55 — Verify Client IDs Are Unique

Purpose: Confirm that the primary-key client IDs are not duplicated.

SELECT id, COUNT(*) AS total
FROM m_client
GROUP BY id
HAVING COUNT(*) > 1;

Expected: 0 rows.

Query 56 — Find Clients Without a Valid Office

Purpose: Combined validation for NULL or invalid office references.

SELECT c.id, c.account_no, c.display_name, c.office_id
FROM m_client c
LEFT JOIN m_office o ON c.office_id = o.id
WHERE c.office_id IS NULL
   OR o.id IS NULL;

Expected: 0 rows.

Query 57 — Verify Status Count Against Total

Purpose: Reconcile grouped status counts with the total number of clients.

SELECT
    (SELECT COUNT(*) FROM m_client) AS total_clients,
    (SELECT COUNT(DISTINCT status_enum) FROM m_client) AS distinct_statuses;

Query 58 — Find Recently Created Clients

Purpose: Identify clients created most recently using the created_on_utc audit field.

SELECT id, account_no, display_name, created_on_utc
FROM m_client
ORDER BY created_on_utc DESC
LIMIT 10;

Query 59 — Find Recently Modified Clients

Purpose: Identify the clients most recently modified.

SELECT id, account_no, display_name, last_modified_on_utc
FROM m_client
ORDER BY last_modified_on_utc DESC
LIMIT 10;

Query 60 — Verify Audit Fields

Purpose: Find records where important audit fields are missing.

SELECT id, account_no, created_on_utc, created_by
FROM m_client
WHERE created_on_utc IS NULL
   OR created_by IS NULL;

Query 61 — Find Clients With Invalid Date Relationship

Purpose: Identify records where activation occurs before submission.

SELECT id, account_no, submittedon_date, activation_date
FROM m_client
WHERE submittedon_date IS NOT NULL
  AND activation_date IS NOT NULL
  AND activation_date < submittedon_date;

Query 62 — Verify Client Records Belong to Existing Offices

Purpose: Final referential-integrity check between m_client and m_office.

SELECT COUNT(*) AS invalid_office_references
FROM m_client c
LEFT JOIN m_office o ON c.office_id = o.id
WHERE c.office_id IS NOT NULL
  AND o.id IS NULL;

Expected: 0.

Key QA Validation Areas Covered

Record count validation

Primary-key validation

Account number validation

Office relationship validation

Status validation

Active/inactive validation

NULL-value validation

Duplicate-data validation

Mobile number format validation

Email format validation

External ID validation

Date validation

Audit-field validation

Referential-integrity validation

Security-test data review

Aggregation and reconciliation

Sorting and limiting

GROUP BY / HAVING validation

Important QA Note

A SQL query returning 0 rows is not always automatically a defect-free result. The expected result must be compared against the application/business requirement. For example, duplicate email addresses may be valid if the system allows multiple clients to share an email address.