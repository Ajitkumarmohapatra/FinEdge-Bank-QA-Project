# Project Startup

## Objective

This document describes the daily startup procedure for the FinEdge Bank QA Project. Following these steps ensures that all required services are running before testing begins.

---

# Startup Workflow

1. Start Docker Desktop.
2. Verify Docker Engine is running.
3. Navigate to the Apache Fineract project.
4. Start backend services using Docker Compose.
5. Verify all required containers are running.
6. Navigate to the Mifos Web Application.
7. Install dependencies (if required).
8. Start the Angular application.
9. Open the application in the browser.
10. Log in and verify the environment.

---

# Step 1 – Start Docker Desktop

Ensure Docker Desktop is running before starting any backend services.

Verification:

```bash
docker ps
```

---

# Step 2 – Start Apache Fineract Backend

Navigate to the Apache Fineract project directory and start the backend.

```bash
docker compose up -d
```

Verify the running containers:

```bash
docker ps
```

---

# Step 3 – Start Mifos Web Application

Navigate to the Mifos Web App directory.

Install dependencies if required:

```bash
npm install
```

Start the application:

```bash
ng serve
```

---

# Step 4 – Open the Application

Open the application in your browser:

```
http://localhost:4200
```

---

# Step 5 – Verify Login

Verify that:

- Login page loads successfully.
- Backend connection is working.
- Authentication is successful.
- Dashboard opens after login.

---

# Environment Verification Checklist

- [x] Docker Running
- [x] Backend Running
- [x] PostgreSQL Connected
- [x] Angular Application Running
- [x] Login Page Accessible
- [x] Environment Ready for Testing

---

# Outcome

The FinEdge Bank QA environment is successfully started and ready for Manual Testing, API Testing, Database Testing, and Automation Testing.
