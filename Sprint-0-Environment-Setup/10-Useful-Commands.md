# Useful Commands

## Objective

This document contains the most frequently used commands during the setup, execution, testing, and maintenance of the FinEdge Bank QA Project.

---

# Docker Commands

## Check Docker Version

```bash
docker --version
```

## View Running Containers

```bash
docker ps
```

## View All Containers

```bash
docker ps -a
```

## View Docker Images

```bash
docker images
```

## Start Services

```bash
docker compose up -d
```

## Stop Services

```bash
docker compose down
```

## Restart Services

```bash
docker compose restart
```

## View Container Logs

```bash
docker logs <container-name>
```

---

# Java Commands

## Check Java Version

```bash
java -version
```

---

# Git Commands

## Check Git Version

```bash
git --version
```

## Check Repository Status

```bash
git status
```

## Stage Files

```bash
git add .
```

## Commit Changes

```bash
git commit -m "Commit Message"
```

## Push Changes

```bash
git push
```

## Pull Latest Changes

```bash
git pull
```

---

# Node.js Commands

## Check Node Version

```bash
node -v
```

## Check npm Version

```bash
npm -v
```

---

# Angular Commands

## Check Angular Version

```bash
ng version
```

## Install Dependencies

```bash
npm install
```

## Start Angular Application

```bash
ng serve
```

---

# PostgreSQL Commands

## Open PostgreSQL

Use your preferred PostgreSQL client (such as pgAdmin or psql).

Example SQL:

```sql
SELECT * FROM m_client;
```

---

# API Testing

Launch Postman and use the configured environment for authentication and API execution.

---

# Verification Commands

## Check Docker Containers

```bash
docker ps
```

## Verify Angular

Open:

http://localhost:4200

## Verify Backend

Execute the Login API in Postman.

## Verify Database

Run SQL queries to confirm data integrity.

---

# Outcome

These commands provide a quick reference for setting up, running, verifying, and maintaining the FinEdge Bank QA Project.
