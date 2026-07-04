# US-001 – Requirement Analysis

---
This document captures the requirement analysis for User Story US-001 (Create Client). It defines the business objective, functional expectations, stakeholders, business rules,
and quality requirements before test design begins.
---

# 1. Business Requirement

## Objective

The banking system shall allow authorized bank employees to create a new client profile by capturing and validating the required customer information. Once successfully created, 
the client becomes eligible to access banking services such as Savings Accounts,Current Accounts, Fixed Deposits, and Loan products.

## Business Value

- Maintain a centralized customer database.
- Eliminate duplicate customer records.
- Ensure regulatory compliance (KYC).
- Enable customers to access banking products.
- Improve operational efficiency for bank staff.

---

# 2. Stakeholders

| Stakeholder | Responsibility |
|-------------|----------------|
| Customer | Provides personal information and documents. |
| Bank Officer | Creates the client profile. |
| Branch Manager | Reviews or approves if required. |
| Operations Team | Maintains customer records. |
| System Administrator | Manages application access. |

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
| FR-007 | The system shall allow users to navigate between the Create Client wizard steps using the Next and Previous buttons.|
| FR-008 |The system shall preserve all previously entered client information while navigating between wizard steps. |
| FR-009 | The system shall create a new client when all required information is successfully submitted. |
| FR-010 | The system shall generate a unique Client ID for every newly created client. |
| FR-011 | The system shall display a success confirmation after successful client creation. |
| FR-012 | The newly created client shall be searchable in the Client module. |
| FR-013 | The system shall prevent duplicate client creation based on configured unique identifiers (e.g., PAN or another configured identifier). |
| FR-014 | The system shall provide a Cancel option that allows users to exit the Create Client process without saving the entered data. |
| FR-015 | The system shall provide dropdown lists for applicable fields and allow users to select only valid values. |
| FR-016 | The system shall validate date fields and prevent the selection of invalid dates. |
| FR-017 | The system shall retain user-entered data if validation errors occur until the errors are corrected. |

---

# 4. Non-Functional Requirements

| ID | Requirement |
|----|-------------|
| NFR-001 | The Create Client page shall load within 3 seconds under normal network conditions. |
| NFR-002 | The system shall allow only authenticated and authorized users to access the Create Client functionality. |
| NFR-003 | All client information shall be transmitted securely using HTTPS. |
| NFR-004 | Sensitive customer information shall be stored securely and protected against unauthorized access. |
| NFR-005 | The system shall support the latest versions of Chrome, Firefox, Edge, and Safari browsers. |
| NFR-006 | The system shall maintain data integrity and prevent partial or corrupted client records during client creation. |
| NFR-007 | The system shall record audit logs for client creation activities, including user, date, and time. |
| NFR-008 | The Create Client functionality shall be available during normal business operations with high system availability. |
| NFR-009 | Validation messages shall be clear, consistent, and understandable to end users. |
| NFR-010 | The application shall remain responsive when multiple authorized users create clients simultaneously. |

---

# 5. Business Rules

| Rule ID | Business Rule |
|----------|---------------|
| BR-001 | The system shall generate a unique Client ID for every client. |
| BR-002 | First Name and Last Name are mandatory fields. |
| BR-003 | Multiple clients may have the same name, but every client must have a unique Client ID. |
| BR-004 | A client shall not perform banking transactions until the client is activated. |
| BR-005 | Only authorized bank employees shall be allowed to create client profiles. |
| BR-006 | Office selection is mandatory during client creation. |
| BR-007 | The selected Legal Form shall determine which fields are displayed to the user. |
| BR-008 | Mandatory fields must be completed before proceeding to the next step. |
| BR-009 | The Submitted On date shall not be a future date. |
| BR-010 | If "Open Savings Account" is selected, the system shall initiate the savings account creation process after the client is created. |
| BR-011 | The system shall maintain an audit log for every client creation activity. |
| BR-012 | The generated Client ID shall not be editable by users. |
| BR-013 | The system shall not allow the creation of multiple client profiles using the same Aadhaar number. |

---

# 6. Acceptance Criteria

| AC ID | Acceptance Criteria |
|-------|----------------------|
| AC-001 | The authorized bank employee shall be able to access the Create Client page. |
| AC-002 | All mandatory fields shall be displayed with appropriate indicators. |
| AC-003 | The system shall successfully create a client when valid information is submitted. |
| AC-004 | Appropriate validation messages shall be displayed for invalid or missing input. |
| AC-005 | A unique Client ID shall be generated after successful client creation. |
| AC-006 | The newly created client shall be visible in the Client List/Search page. |
| AC-007 | The system shall prevent duplicate client creation based on configured unique identifiers. |
| AC-008 | The client creation activity shall be recorded in the audit log. |

---

# 7. Assumptions

- The bank employee has a valid user account.
- The user has permission to create client records.
- The Apache Fineract server is available.
- The database connection is active.
- Required reference data (Office, Legal Form, etc.) already exists in the system.

---

# 8. Dependencies

- User must be successfully authenticated.
- Required user roles and permissions must be configured.
- Office records must already exist.
- Apache Fineract backend services must be available.
- Database services must be operational.

---

# 9. Out of Scope

The following activities are not part of User Story US-001:

- Loan creation
- Savings account transactions
- Fund transfers
- Customer KYC verification workflow
- Client approval process
- Interest calculation
- Report generation

---

# 10. Risk Analysis

| Risk ID | Risk | Impact | Mitigation |
|----------|------|--------|------------|
| R-001 | Mandatory field validation fails | Invalid client records may be created | Validate all mandatory fields before saving |
| R-002 | Duplicate client creation | Duplicate customer records | Enforce uniqueness validation |
| R-003 | Database failure during save | Client information may not be stored | Display appropriate error and rollback transaction |
| R-004 | Unauthorized user access | Security breach | Verify authentication and authorization |
| R-005 | Network interruption during submission | Client creation may fail | Display proper error message and allow retry |
