# Common Issues and Fixes

## Objective

This document captures the common issues encountered during the setup of the FinEdge Bank QA Project and the solutions used to resolve them.

---

# Issue 1 – Docker Desktop Not Starting

## Problem

Docker Desktop did not start correctly.

## Resolution

- Restart Docker Desktop.
- Verify WSL integration.
- Check Docker Engine status.

## Status

✅ Resolved

---

# Issue 2 – Docker Containers Not Running

## Problem

Required containers were not running after startup.

## Resolution

Run:

```bash
docker compose up -d
```

Verify:

```bash
docker ps
```

## Status

✅ Resolved

---

# Issue 3 – Port 4200 Already in Use

## Problem

Angular application failed to start because port 4200 was already occupied.

## Resolution

- Stop the process using port 4200.
- Restart the Angular application.

```bash
ng serve
```

## Status

✅ Resolved

---

# Issue 4 – Backend Services Taking Time to Start

## Problem

Apache Fineract services required additional time during the initial startup.

## Resolution

- Wait until all Docker containers become healthy.
- Verify container status using:

```bash
docker ps
```

## Status

✅ Resolved

---

# Issue 5 – Database Connection Verification

## Problem

Database connectivity needed to be verified before testing.

## Resolution

- Confirm PostgreSQL is running.
- Verify backend connection.
- Execute SQL queries for validation.

## Status

✅ Resolved

---

# Lessons Learned

- Verify Docker is running before starting backend services.
- Ensure all containers are healthy before opening the application.
- Confirm PostgreSQL connectivity before database validation.
- Start the backend before the frontend.
- Verify the environment before beginning testing.

---

# Outcome

All setup-related issues were successfully resolved. The project environment is stable and ready for QA activities.
