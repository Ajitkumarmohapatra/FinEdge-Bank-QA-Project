# Mifos Web Application Setup

## Objective

This document describes the setup and configuration of the Mifos Web Application used in the FinEdge Bank QA Project.

---

# What is Mifos?

Mifos is the Angular-based web application that provides the user interface for Apache Fineract. It communicates with the backend through REST APIs and allows users to perform banking operations.

---

# Purpose

The Mifos Web Application is used for:

- User Login
- Client Management
- Savings Account Management
- Loan Management
- Transactions
- Reports

---

# Technologies Used

| Technology | Purpose |
|------------|---------|
| Angular | Frontend Framework |
| Node.js | Runtime Environment |
| Angular CLI | Build & Run Application |
| npm | Package Management |

---

# Setup Steps

## Step 1

Install project dependencies.

```bash
npm install
```

---

## Step 2

Start the application.

```bash
ng serve
```

---

## Step 3

Open the application in the browser.

```
http://localhost:4200
```

---

## Step 4

Verify that the login page loads successfully.

---

# Verification

The setup was verified by confirming:

- Angular project built successfully
- Mifos application started successfully
- Login page displayed
- Backend connection established

---

# Issues Encountered

During setup, the following situations were addressed:

- Installing project dependencies using npm
- Angular CLI configuration
- Port 4200 availability
- Frontend startup verification

---

# Resolution

The application was successfully started after resolving the setup requirements and verifying that the frontend was connected to the backend services.

---

# Outcome

The Mifos Web Application was successfully configured and is ready for Manual Testing, API Testing, and Automation Testing.
