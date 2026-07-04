# US-001 – Requirement Analysis

---

This document captures the requirement analysis for User Story US-001 (Create Client). It defines the business objective, functional expectations, business rules, stakeholders, data validation rules, quality attributes, and acceptance criteria before test design begins.

---

# 1. Business Requirement

## Objective

The banking system shall allow authorized bank employees to create and maintain a client profile by capturing, validating, and securely storing customer information. Upon successful creation, the client becomes eligible to access banking products and services such as Savings Accounts, Current Accounts, Fixed Deposits, and Loan products.

## Business Value

- Maintain a centralized customer database.
- Eliminate duplicate customer records.
- Improve customer onboarding.
- Ensure regulatory compliance (KYC).
- Enable customers to access banking products.
- Improve operational efficiency for bank staff.

---

# 2. Stakeholders

| Stakeholder | Responsibility |
|-------------|----------------|
| Customer | Provides personal information and supporting documents. |
| Bank Officer | Creates and manages the client profile. |
| Branch Manager | Reviews or approves client creation where applicable. |
| Operations Team | Maintains customer records. |
| Compliance Officer | Ensures regulatory and KYC compliance. |
| System Administrator | Manages application access and security. |

---

# 3. Functional Requirements

| ID | Requirement |
|----|-------------|
| FR-001 | The system shall allow only authorized bank employees to access the Create Client page. |
| FR-002 | The system shall display all mandatory and optional client information fields. |
| FR-003 | The system shall identify mandatory fields using a visual indicator (*). |
| FR-004 | The system shall allow users to enter valid client information. |
| FR-005 | The system shall validate mandatory fields before proceeding to the next step. |
| FR-006 | The system shall display appropriate validation messages for invalid or missing input. |
| FR-007 | The system shall allow users to navigate between wizard steps using the Next and Previous buttons. |
| FR-008 | The system shall preserve entered data while navigating between wizard steps. |
| FR-009 | The system shall create a new client after successful validation. |
| FR-010 | The system shall generate a unique Client ID for every newly created client. |
| FR-011 | The system shall display a success confirmation after successful client creation. |
| FR-012 | The newly created client shall be searchable from the Client module. |
| FR-013 | The system shall prevent duplicate client creation using configured unique identifiers. |
| FR-014 | The system shall provide a Cancel button to exit the process without saving data. |
| FR-015 | The system shall display dropdown lists where applicable and allow only valid selections. |
| FR-016 | The system shall validate all date fields. |
| FR-017 | The system shall retain user-entered information until validation errors are corrected. |
| FR-018 | The Create Client process shall be displayed as a multi-step wizard. |
| FR-019 | The system shall auto-populate default values where applicable (e.g., Submitted On date). |
| FR-020 | The system shall prevent duplicate submission caused by multiple Save button clicks. |
| FR-021 | The system shall retain entered data until the user cancels the client creation process. |

---

# 4. Non-Functional Requirements

| ID | Requirement |
|----|-------------|
| NFR-001 | The Create Client page shall load within 3 seconds under normal conditions. |
| NFR-002 | Only authenticated and authorized users shall access this functionality. |
| NFR-003 | All client information shall be transmitted using HTTPS. |
| NFR-004 | Sensitive customer information shall be securely stored. |
| NFR-005 | The application shall support Chrome, Firefox, Edge, and Safari. |
| NFR-006 | The system shall maintain data integrity during client creation. |
| NFR-007 | Audit logs shall be maintained for every client creation activity. |
| NFR-008 | The system shall maintain high availability during business hours. |
| NFR-009 | Validation messages shall be clear and user friendly. |
| NFR-010 | The application shall remain responsive under concurrent usage. |
| NFR-011 | The system shall support at least 100 concurrent client creation requests without performance degradation. |
| NFR-012 | The application shall recover gracefully from unexpected failures without data loss. |

---

# 5. Business Rules

| Rule ID | Business Rule |
|----------|---------------|
| BR-001 | The system shall generate a unique Client ID for every client. |
| BR-002 | First Name and Last Name are mandatory. |
| BR-003 | Multiple clients may have the same name but must have unique Client IDs. |
| BR-004 | Clients cannot perform banking transactions until activated. |
| BR-005 | Only authorized employees may create client profiles. |
| BR-006 | Office selection is mandatory. |
| BR-007 | The selected Legal Form determines which fields are displayed. |
| BR-008 | Mandatory fields must be completed before proceeding. |
| BR-009 | Submitted On cannot be a future date. |
| BR-010 | If "Open Savings Account" is selected, the system initiates the savings account creation workflow. |
| BR-011 | Every client creation shall be recorded in the audit log. |
| BR-012 | Generated Client ID shall not be editable. |
| BR-013 | Duplicate client creation using Aadhaar, PAN, Passport, or any configured unique identifier shall not be allowed. |

---

# 6. Data Validation Rules

| Field | Validation Rule |
|--------|-----------------|
| Office | Mandatory |
| Legal Form | Mandatory |
| First Name | Mandatory, alphabets only |
| Last Name | Mandatory |
| Date of Birth | Cannot be a future date |
| Gender | Must be selected if mandatory |
| Mobile Number | Numeric values only |
| Email Address | Valid email format |
| Aadhaar Number | Must be unique |
| External ID | Optional |
| Submitted On | Cannot be a future date |

---

# 7. Acceptance Criteria

| AC ID | Acceptance Criteria |
|-------|----------------------|
| AC-001 | Authorized users can access the Create Client page. |
| AC-002 | Mandatory fields are identified correctly. |
| AC-003 | Client is created successfully with valid information. |
| AC-004 | Validation messages are displayed for invalid input. |
| AC-005 | A unique Client ID is generated. |
| AC-006 | Newly created client is searchable. |
| AC-007 | Duplicate client creation is prevented. |
| AC-008 | Client creation is recorded in audit logs. |
| AC-009 | Entered information remains available after validation errors. |
| AC-010 | Cancel exits the process without saving data. |

---

# 8. Assumptions

- User has a valid account.
- User has Create Client permission.
- Apache Fineract server is available.
- Database connection is active.
- Office, Staff, Legal Form and reference data already exist.
- System date and time are correctly configured.

---

# 9. Dependencies

- Successful authentication.
- User role configuration.
- Office master data.
- Client Type configuration.
- Client Classification configuration.
- Staff records.
- Apache Fineract backend services.
- Database availability.

---

# 10. Out of Scope

- Loan creation
- Savings account transactions
- Fund transfers
- Customer login
- Interest calculation
- Report generation
- Customer approval workflow
- Account closure

---

# 11. Risk Analysis

| Risk ID | Risk | Impact | Mitigation |
|----------|------|--------|------------|
| R-001 | Mandatory validation failure | Invalid client records | Validate before save |
| R-002 | Duplicate client creation | Duplicate records | Enforce uniqueness |
| R-003 | Database failure | Data loss | Rollback transaction |
| R-004 | Unauthorized access | Security breach | Authentication & authorization |
| R-005 | Network interruption | Submission failure | Retry mechanism |
| R-006 | Browser compatibility | UI issues | Cross-browser testing |
| R-007 | Session timeout | Data loss | Session warning and auto-save if applicable |
