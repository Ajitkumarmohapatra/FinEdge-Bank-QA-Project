# Software Installation

## Objective

This document describes the software required for the FinEdge Bank QA Project, including its purpose, installation, and verification.

---

# Software Installation Summary

| Software | Purpose | Status |
|----------|---------|--------|
| Java JDK 21 | Run Apache Fineract Backend | ✅ Installed |
| Git | Version Control | ✅ Installed |
| Docker Desktop | Container Management | ✅ Installed |
| PostgreSQL | Database | ✅ Installed |
| Node.js (LTS) | Angular Runtime | ✅ Installed |
| Angular CLI | Run Mifos Web Application | ✅ Installed |
| VS Code | Code Editor | ✅ Installed |
| Postman | API Testing | ✅ Installed |
| Google Chrome | Browser Testing | ✅ Installed |

---

# 1. Java JDK

### Purpose

Java is required to run the Apache Fineract backend services.

### Verification

```bash
java -version
```

### Status

✅ Installed Successfully

---

# 2. Git

### Purpose

Git is used for version control and GitHub repository management.

### Verification

```bash
git --version
```

### Status

✅ Installed Successfully

---

# 3. Docker Desktop

### Purpose

Docker is used to run Apache Fineract, PostgreSQL, Grafana, Prometheus, and other required services using containers.

### Verification

```bash
docker --version
docker ps
```

### Status

✅ Installed Successfully

---

# 4. PostgreSQL

### Purpose

Stores banking application data.

### Verification

- Connected successfully using PostgreSQL.
- Database available and accessible.

### Status

✅ Installed Successfully

---

# 5. Node.js

### Purpose

Required to run the Angular-based Mifos Web Application.

### Verification

```bash
node -v
npm -v
```

### Status

✅ Installed Successfully

---

# 6. Angular CLI

### Purpose

Used to build and run the Mifos Web Application.

### Verification

```bash
ng version
```

### Status

✅ Installed Successfully

---

# 7. VS Code

### Purpose

Used for viewing and editing project source code and documentation.

### Status

✅ Installed Successfully

---

# 8. Postman

### Purpose

Used for API testing and authentication.

### Status

✅ Installed Successfully

---

# 9. Google Chrome

### Purpose

Used for web application testing.

### Status

✅ Installed Successfully

---

# Installation Verification Checklist

- [x] Java Installed
- [x] Git Installed
- [x] Docker Desktop Installed
- [x] PostgreSQL Installed
- [x] Node.js Installed
- [x] Angular CLI Installed
- [x] VS Code Installed
- [x] Postman Installed
- [x] Google Chrome Installed

---

# Outcome

All required software was successfully installed and verified. The environment is ready for configuring Apache Fineract, the Mifos Web Application, and performing QA activities.
