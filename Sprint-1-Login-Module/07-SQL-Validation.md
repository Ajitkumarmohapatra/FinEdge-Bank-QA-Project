Sprint 1 - Login Module

SQL / Database Validation

Project Information

Field

Details

Project

FinEdge Bank QA Project

Module

Login

Sprint

Sprint 1

Database

PostgreSQL

Database Name

fineract_default

Schema

public

Tool

pgAdmin 4

Environment

Local

Tester

Ajit Kumar

1. Objective

The objective of database validation is to verify Login-related user data, account status, role mapping, security state, password storage, and data integrity in the Mifos/Fineract PostgreSQL database.

2. Database Tables Validated

The following tables were investigated:

m_appuser

m_appuser_role

m_role

oauth_access_token

oauth_refresh_token

3. Database Structure Investigation

3.1 Find User, Authentication and Login Related Tables

SELECT table_name
FROM information_schema.tables
WHERE table_schema = 'public'
  AND (
       table_name ILIKE '%user%'
       OR table_name ILIKE '%auth%'
       OR table_name ILIKE '%login%'
      )
ORDER BY table_name;

3.2 Find Important Columns in m_appuser

SELECT
    column_name,
    data_type
FROM information_schema.columns
WHERE table_schema = 'public'
  AND table_name = 'm_appuser'
  AND (
       column_name ILIKE '%user%'
       OR column_name ILIKE '%username%'
       OR column_name ILIKE '%enabled%'
       OR column_name ILIKE '%active%'
       OR column_name ILIKE '%office%'
       OR column_name ILIKE '%id%'
      )
ORDER BY ordinal_position;

3.3 Find Password and Login Related Columns

SELECT
    column_name,
    data_type
FROM information_schema.columns
WHERE table_schema = 'public'
  AND table_name = 'm_appuser'
  AND (
       column_name ILIKE '%password%'
       OR column_name ILIKE '%login%'
      )
ORDER BY ordinal_position;

3.4 Check All Columns of m_appuser

SELECT
    column_name,
    data_type
FROM information_schema.columns
WHERE table_schema = 'public'
  AND table_name = 'm_appuser'
ORDER BY ordinal_position;

3.5 Check Columns of m_appuser_role

SELECT
    column_name,
    data_type
FROM information_schema.columns
WHERE table_schema = 'public'
  AND table_name = 'm_appuser_role'
ORDER BY ordinal_position;

3.6 Check Columns of m_role

SELECT
    column_name,
    data_type
FROM information_schema.columns
WHERE table_schema = 'public'
  AND table_name = 'm_role'
ORDER BY ordinal_position;

3.7 Check Columns of oauth_access_token

SELECT
    column_name,
    data_type
FROM information_schema.columns
WHERE table_schema = 'public'
  AND table_name = 'oauth_access_token'
ORDER BY ordinal_position;

3.8 Check Columns of oauth_refresh_token

SELECT
    column_name,
    data_type
FROM information_schema.columns
WHERE table_schema = 'public'
  AND table_name = 'oauth_refresh_token'
ORDER BY ordinal_position;

4. Login User Validation

DB_LOGIN_001 - Verify User Exists and Account Status

Query

SELECT
    id,
    username,
    enabled,
    is_deleted,
    nonlocked,
    nonexpired,
    nonexpired_credentials
FROM m_appuser
WHERE username = 'mifos';

Actual Result

Field

Value

id

1

username

mifos

enabled

true

is_deleted

false

nonlocked

true

nonexpired

true

nonexpired_credentials

true

Result

PASS

The mifos user exists and the account is enabled, not deleted, not locked, and not expired.

5. User Role Validation

DB_LOGIN_002 - Verify User Role Mapping

Query

SELECT
    u.id,
    u.username,
    r.id,
    r.name,
    r.is_disabled
FROM m_appuser u
JOIN m_appuser_role ur
    ON u.id = ur.appuser_id
JOIN m_role r
    ON ur.role_id = r.id
WHERE u.username = 'mifos';

Actual Result

User ID

Username

Role ID

Role

Role Disabled

1

mifos

1

Super user

false

Result

PASS

The mifos user is mapped to the Super user role and the role is enabled.

6. Login Security Validation

DB_LOGIN_003 - Verify Failed Login Attempts and Lock Status

Query

SELECT
    username,
    failed_login_attempts,
    is_login_retries_enabled,
    nonlocked
FROM m_appuser
WHERE username = 'mifos';

Actual Result

Username

Failed Login Attempts

Login Retries Enabled

Nonlocked

mifos

0

false

true

Result

PASS

The account currently has zero failed login attempts and is not locked.

Observation

Login retry protection is currently disabled for this account/configuration.

7. Account Authentication Eligibility

DB_LOGIN_004 - Verify Account Eligibility

Query

SELECT
    username,
    enabled,
    is_deleted,
    nonlocked,
    nonexpired,
    nonexpired_credentials
FROM m_appuser
WHERE username = 'mifos';

Actual Result

Field

Value

username

mifos

enabled

true

is_deleted

false

nonlocked

true

nonexpired

true

nonexpired_credentials

true

Result

PASS

The account is currently eligible for authentication based on its database status.

8. Username Validation

DB_LOGIN_005 - Verify Duplicate Usernames

Query

SELECT
    username,
    COUNT(*)
FROM m_appuser
GROUP BY username
HAVING COUNT(*) > 1;

Actual Result

No rows returned.

Result

PASS

No duplicate usernames were found in the m_appuser table.

9. User Count Validation

DB_LOGIN_006 - Verify Total Number of Users

Query

SELECT COUNT(*)
FROM m_appuser;

Actual Result

3

Result

PASS

Three user records are present in the m_appuser table.

10. All User Account Validation

DB_LOGIN_007 - Display All Users and Account Status

Query

SELECT
    id,
    username,
    enabled,
    is_deleted
FROM m_appuser
ORDER BY id;

Actual Result

ID

Username

Enabled

Is Deleted

1

mifos

true

false

2

system

true

false

3

interopUser

true

false

Result

PASS

All three users are currently enabled and not deleted.

11. Password Storage Validation

DB_LOGIN_008 - Verify Password Storage Length

Query

SELECT
    username,
    LENGTH(password)
FROM m_appuser;

Actual Result

Username

Stored Password Representation Length

mifos

76

system

76

interopUser

76

Result

PASS

All three user accounts contain a stored password representation.

The actual password values and password hashes were not included in the test documentation.

Observation

The value 76 represents the length of the stored database value. It does not represent the length of the user's original plaintext password.

12. Password Null/Empty Validation

DB_LOGIN_009 - Verify Password Value Is Not NULL or Empty

Query

SELECT
    username
FROM m_appuser
WHERE password IS NULL
   OR password = '';

Expected Result

No rows should be returned.

Result

PASS

No users with NULL or empty password values were identified.

13. OAuth Access Token Validation

DB_LOGIN_010 - Verify Access Token Records for mifos

Query

SELECT
    user_name,
    client_id,
    COUNT(*)
FROM oauth_access_token
WHERE user_name = 'mifos'
GROUP BY user_name, client_id;

Actual Result

No rows returned.

DB_LOGIN_011 - Verify Total Access Token Records

Query

SELECT COUNT(*)
FROM oauth_access_token;

Actual Result

0

Result

NOT VERIFIABLE

No persisted access-token records were found in the table during validation.

The Login API successfully generated authentication during API testing, but token persistence could not be verified from this table.

14. OAuth Refresh Token Validation

DB_LOGIN_012 - Verify Total Refresh Token Records

Query

SELECT COUNT(*)
FROM oauth_refresh_token;

Actual Result

0

Result

NOT VERIFIABLE

No persisted refresh-token records were found in the table during validation.

15. SQL Validation Summary

Test ID

Validation

Result

DB_LOGIN_001

User exists and account status

PASS

DB_LOGIN_002

User-role mapping

PASS

DB_LOGIN_003

Failed login and lock status

PASS

DB_LOGIN_004

Account authentication eligibility

PASS

DB_LOGIN_005

Duplicate usernames

PASS

DB_LOGIN_006

Total number of users

PASS

DB_LOGIN_007

User account status

PASS

DB_LOGIN_008

Password storage

PASS

DB_LOGIN_009

NULL/empty password validation

PASS

DB_LOGIN_010

Access token for mifos

NOT VERIFIABLE

DB_LOGIN_011

Total access tokens

NOT VERIFIABLE

DB_LOGIN_012

Total refresh tokens

NOT VERIFIABLE

16. Database Validation Findings

Users Identified

The database contains three user accounts:

mifos

system

interopUser

All three users are currently enabled and not deleted.

mifos Account

The mifos account was successfully validated for:

User existence

Account enabled status

Account deletion status

Account lock status

Account expiration status

Credential expiration status

Failed login attempts

Role mapping

Role enabled status

Password storage

The mifos user is mapped to the Super user role.

Username Validation

No duplicate usernames were found.

Password Validation

All three user accounts contain a stored password representation of 76 characters.

The original passwords and password hashes were not stored in the project documentation.

OAuth Validation

No records were found in:

oauth_access_token

oauth_refresh_token

Therefore, token persistence could not be verified from these tables in the current local configuration.

17. Overall SQL Validation Status

Execution Status: COMPLETED

Database validation for the Sprint 1 Login module has been completed.

The major Login-related database validations passed successfully.

No database defects were identified during the completed validation.

OAuth access-token and refresh-token persistence could not be verified because the corresponding tables contained zero records during testing.

18. Next Activity

The next pending Sprint 1 activity is:

Selenium Automation

Planned automation:

Selenium WebDriver

Java

TestNG

Maven

Page Object Model

Positive login scenario

Negative login scenarios

Mandatory field validation

Password visibility validation

Logout validation

Assertions

Explicit waits

Failure screenshots

Test reporting