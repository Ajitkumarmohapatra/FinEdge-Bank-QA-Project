# US-002 – Activate Client

## User Story

**As a bank employee,**  
I want to activate an existing client,  
so that the client can access banking services.

---

## Story Information

| Item | Details |
|------|---------|
| Story ID | US-002 |
| Module | Client Management |
| Priority | 🔴 High |
| Story Points | 5 |
| Status | 🟡 In Progress |

---

# Business Objective

The Activate Client functionality allows an authorized bank employee to activate an existing client who is eligible for activation.

After successful activation, the client's status should be updated to **Active**, allowing the client to proceed with applicable banking services.

---

# Functional Requirements

### FR-001 – Access Existing Client

The system should allow the bank employee to access an existing client.

### FR-002 – Verify Client Status

The system should display the current status of the selected client.

### FR-003 – Activate Client

The system should provide an option to activate an eligible client.

### FR-004 – Activation Confirmation

The system should allow the bank employee to confirm the activation request.

### FR-005 – Update Client Status

After successful activation, the client's status should be updated to **Active**.

### FR-006 – Activation Validation

The system should validate whether the client is eligible for activation.

### FR-007 – Error Handling

The system should display an appropriate message when client activation fails.

### FR-008 – Data Persistence

The activated client status should persist after refreshing or reopening the client profile.

---

# Business Rules

1. Only an existing client can be activated.
2. The client must be in an eligible status before activation.
3. Only an authorized bank employee should be able to activate a client.
4. A successfully activated client should have the status **Active**.
5. A client who is already active should not be activated again.
6. If activation fails, the client's previous status should remain unchanged.
7. The updated client status should be persisted in the system.

---

# Acceptance Criteria

### AC-001 – Successful Client Activation

**Given** an eligible existing client  
**When** the bank employee activates the client  
**Then** the client status should change to **Active**.

### AC-002 – Current Client Status

**Given** an existing client  
**When** the client profile is opened  
**Then** the current client status should be displayed correctly.

### AC-003 – Activation Confirmation

**Given** an eligible client  
**When** the bank employee submits the activation request  
**Then** the system should successfully process the activation.

### AC-004 – Status Persistence

**Given** a client has been successfully activated  
**When** the client profile is refreshed or reopened  
**Then** the client status should remain **Active**.

### AC-005 – Already Active Client

**Given** a client whose status is already Active  
**When** the bank employee attempts to activate the client  
**Then** the system should prevent an invalid duplicate activation.

### AC-006 – Failed Activation

**Given** an activation request fails  
**When** the system processes the request  
**Then** the client status should remain unchanged and an appropriate error message should be displayed.

---

# Testing Scope

## In Scope

- Existing client access
- Client status verification
- Client activation
- Activation confirmation
- Status validation
- Status persistence
- Negative scenarios
- API testing
- SQL/database validation
- Selenium automation
- Regression testing

## Out of Scope

- Creating a new client
- Editing client information
- Closing a client
- Opening a savings account
- Loan processing
- Deposit and withdrawal transactions

---

# Testing Approach

The following testing activities will be performed:

1. Requirement Analysis
2. UI Analysis
3. Test Scenario Preparation
4. Test Case Preparation
5. Manual Functional Testing
6. API Testing
7. SQL Database Validation
8. Selenium Automation
9. Test Execution
10. Defect Reporting
11. Regression Testing

---

# Dependencies

- US-001 – Create Client
- Mifos / Apache Fineract application
- Authenticated bank employee
- Existing client test data
- API access
- Database access

---

# Risks

| Risk | Impact | Mitigation |
|------|--------|------------|
| Client is not eligible for activation | High | Prepare appropriate client test data |
| Activation request fails | High | Validate API response and UI message |
| Status is not persisted | High | Perform SQL validation |
| UI does not reflect updated status | Medium | Refresh and reopen client profile |
| Authorization issue | High | Verify user permissions |

---

# Definition of Done

US-002 will be considered complete when:

- Requirement Analysis is completed
- UI Analysis is completed
- Test Scenarios are completed
- Test Cases are prepared and executed
- Manual Testing is completed
- API Testing is completed
- SQL Validation is completed
- Selenium Automation is completed
- Defects are identified and documented
- Regression Testing is completed
- Documentation is updated
- Acceptance Criteria are satisfied