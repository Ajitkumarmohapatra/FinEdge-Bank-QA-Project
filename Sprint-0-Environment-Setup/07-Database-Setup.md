# Database Setup

## Objective

This document describes the setup and verification of the PostgreSQL database used by the FinEdge Bank QA Project.

---

# Database Overview

Apache Fineract stores all banking data in a PostgreSQL database. This includes clients, savings accounts, loans, transactions, users, and other business data.

---

# Database Information

| Item | Value |
|------|-------|
| Database | PostgreSQL |
| Purpose | Store banking application data |
| Status | ✅ Configured |

---

# Purpose

The database is used to:

- Store client information
- Store savings account details
- Store loan information
- Store transaction history
- Store user authentication data
- Support backend REST APIs

---

# Database Verification

The database setup was verified by:

- PostgreSQL service running successfully
- Database connection established
- Required tables available
- Backend connected successfully

---

# SQL Validation

Database validation can be performed using SQL queries to verify that data created through the application or APIs is stored correctly.

Example:

```sql
SELECT * FROM m_client;
```

---

# Tools Used

| Tool | Purpose |
|------|---------|
| PostgreSQL | Database |
| SQL | Data Validation |
| Apache Fineract | Backend |
| VS Code / Database Client | Query Execution |

---

# Outcome

The PostgreSQL database was successfully configured and verified. It is ready for database validation during Manual Testing and API Testing.
