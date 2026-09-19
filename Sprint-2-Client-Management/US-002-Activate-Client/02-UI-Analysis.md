# US-002 – Activate Client

## UI Analysis

---

# 1. Overview

## User Story

**US-002 – Activate Client**

The Activate Client functionality allows an authorized bank employee to activate an existing client from the Mifos Client Management module.

The client activation option is available from the individual client profile through the Actions menu.

---

# 2. Application Information

| Item | Details |
|------|---------|
| Application | Mifos / Apache Fineract |
| Module | Client Management |
| Feature | Activate Client |
| User Story | US-002 – Activate Client |
| Page | Clients |
| Environment | Local Development |
| Application URL | `http://localhost:4200/` |
| Client List URL | `http://localhost:4200/#/clients` |
| Client Profile URL | `http://localhost:4200/#/clients/{clientId}/general` |

---

# 3. Client Management Page

The Client Management page displays the list of clients available in the system.

The page contains the following major UI components:

- Client search field
- Show Closed Accounts toggle
- Client count
- Create Client button
- Client table
- Client action menu

---

# 4. Client Search

A search field is available at the top of the Client Management page.

### Placeholder

```text
Search by client name, external Id, mobile
```

### Purpose

The search field allows the bank employee to locate an existing client using:

- Client Name
- External ID
- Mobile Number

### UI Validation

The search field should:

- Be visible when the Clients page is loaded.
- Accept valid search input.
- Display matching client records.
- Allow the user to identify the required client.

---

# 5. Show Closed Accounts

A toggle is available with the label:

```text
Show Closed Accounts
```

### Purpose

The toggle allows the user to include closed client records in the displayed client list.

### UI Validation

The toggle should:

- Be visible on the Clients page.
- Allow the user to enable or disable the option.
- Update the displayed client records accordingly.

---

# 6. Client Count

The Client Management page displays the total number of clients.

Example observed in the current test environment:

```text
22 clients
```

The client count may change depending on the available test data.

---

# 7. Create Client Button

The Client Management page contains the following button:

```text
+ Create Client
```

This functionality belongs to **US-001 – Create Client** and is outside the primary scope of US-002.

---

# 8. Client Table

The Clients page displays the available client records in a table.

The following columns were observed:

| Column | Description |
|--------|-------------|
| Name | Name of the client |
| Status | Current status of the client |
| Account No. | Client/account number |
| External ID | External client identifier |
| Office Name | Office associated with the client |
| Actions | Available actions for the client |

---

# 9. Client Status

The Client List displays the current status of each client.

The current test environment contains clients with:

```text
PENDING
```

status.

Example observed client:

| Field | Value |
|------|-------|
| Client Name | Ajit695423 Kumar Test695423 |
| Status | PENDING |
| Account No. | 000000028 |
| External ID | EXT695423 |
| Office Name | Mumbai Branch |

A client with **Pending** status can be selected for the Activate Client workflow.

---

# 10. Select Client

The user can click the client name from the Client List.

Example:

```text
Ajit734492 Kumar Test734492
```

Clicking the client name opens the individual client profile.

Example observed URL:

```text
http://localhost:4200/#/clients/29/general
```

The client ID is dynamic and may change depending on the selected client.

---

# 11. Client General/Profile Page

After selecting a client from the Client List, the application opens the individual client General/Profile page.

Example observed URL:

```text
http://localhost:4200/#/clients/29/general
```

The client ID is dynamic and may change depending on the selected client.

The General/Profile page displays the selected client's information.

---

# 12. Client Information

The following client information was observed on the General/Profile page:

- Client Name
- Office
- Account No.
- External ID
- Staff
- Client Type
- Client Classification
- Mobile Number
- Email

### Example Observed Data

| Field | Example |
|------|---------|
| Client Name | Ajit734492 Kumar Test734492 |
| Office | Mumbai Branch |
| Account No. | 000000029 |
| External ID | EXT734492 |
| Staff | Unassigned |
| Client Type | Business |
| Client Classification | Regular |
| Mobile Number | 9817734492 |
| Email | ajit.test.734492@gmail.com |

The actual values may change depending on the test data.

---

# 13. Client Profile Tabs

The Client General page contains the following tabs:

| Tab | Purpose |
|-----|---------|
| General | Displays general client information |
| Personal Data | Displays personal information |
| Address | Displays client address information |
| Family Members | Displays family member information |
| Identities | Displays identity information |
| Documents | Displays client documents |
| Notes | Displays client notes |

The **General** tab is selected by default.

---

# 14. Client Performance History

The General page displays client performance information.

The following sections were observed:

- No. of Loan Cycles
- No. of Active Loans
- Last Loan Amount
- Total Savings

Example values observed:

| Field | Example |
|------|---------|
| No. of Loan Cycles | 0 |
| No. of Active Loans | 0 |
| Last Loan Amount | 0.00 |
| Total Savings | 0.00 |

These fields are informational and are not directly part of the Activate Client workflow.

---

# 15. Three-Dot Action Menu

The client profile contains a three-dot menu in the top-right area of the client information panel.

After clicking the three-dot menu, the following options are displayed:

```text
Edit
Actions
Assign Staff
More
```

---

# 16. Actions Menu

The **Actions** option provides additional operations for the selected client.

After opening the Actions submenu, the following options were observed:

```text
Close
Transfer Client
Activate
Withdraw
Reject
Delete
```

---

# 17. Activate Client Option

The **Activate** option is available inside the Actions submenu.

The navigation is:

```text
Three-Dot Menu
      ↓
Actions
      ↓
Activate
```

The Activate option is not directly available from the Client List.

The user must first open the individual client profile.

---

# 18. Complete Activate Client Navigation

The verified navigation flow is:

```text
Clients
   ↓
Search / Locate Client
   ↓
Select Client Name
   ↓
Client General Page
   ↓
Click Three-Dot Menu
   ↓
Click Actions
   ↓
Click Activate
   ↓
Activation Process
   ↓
Verify Client Status
```

---

# 19. Activation Workflow

## Step 1 – Open Clients Page

Navigate to the Client Management page.

```text
http://localhost:4200/#/clients
```

The Client Management page should load successfully.

## Step 2 – Locate Client

Use the Client Search field to locate the required client.

The search field supports:

- Client Name
- External ID
- Mobile Number

## Step 3 – Select Client

Click the required client name from the client list.

## Step 4 – Open Client Profile

The application opens the selected client's General/Profile page.

## Step 5 – Open Three-Dot Menu

Click the three-dot menu located in the client information panel.

## Step 6 – Open Actions

Click or hover over the **Actions** option.

## Step 7 – Select Activate

Select **Activate** from the Actions submenu.

## Step 8 – Complete Activation

Complete the activation process displayed by the application.

The exact activation screen and confirmation controls will be documented after manual inspection.

## Step 9 – Verify Client Status

After successful activation, verify that the client's status has been updated correctly.

Expected status:

```text
ACTIVE
```

---

# 20. UI Elements Identified

| UI Element | Location | Status |
|------------|----------|--------|
| Client Search | Clients page | ✅ Identified |
| Show Closed Accounts | Clients page | ✅ Identified |
| Client Count | Clients page | ✅ Identified |
| Create Client | Clients page | ✅ Identified |
| Client Name | Client table | ✅ Identified |
| Client Status | Client table | ✅ Identified |
| Account No. | Client table | ✅ Identified |
| External ID | Client table | ✅ Identified |
| Office Name | Client table | ✅ Identified |
| Three-Dot Menu | Client profile | ✅ Identified |
| Edit | Client menu | ✅ Identified |
| Actions | Client menu | ✅ Identified |
| Assign Staff | Client menu | ✅ Identified |
| More | Client menu | ✅ Identified |
| Close | Actions submenu | ✅ Identified |
| Transfer Client | Actions submenu | ✅ Identified |
| Activate | Actions submenu | ✅ Identified |
| Withdraw | Actions submenu | ✅ Identified |
| Reject | Actions submenu | ✅ Identified |
| Delete | Actions submenu | ✅ Identified |

---

# 21. Activation UI Elements

The following elements require inspection after selecting **Activate**:

| UI Element | Status |
|------------|--------|
| Activation dialog/page | ⏳ To be inspected |
| Activation date field | ⏳ To be inspected |
| Confirmation button | ⏳ To be inspected |
| Cancel button | ⏳ To be inspected |
| Validation message | ⏳ To be inspected |
| Success message | ⏳ To be inspected |
| Updated client status | ⏳ To be inspected |

These elements will be documented based on the actual application behavior rather than assumptions.

---

# 22. Locator Identification

Before Selenium automation, locators will be identified from the actual DOM.

The following elements require locator identification:

| Element | Locator Status |
|---------|----------------|
| Client Search | To be identified |
| Client Name | To be identified |
| Client Status | To be identified |
| Three-Dot Menu | To be identified |
| Actions | To be identified |
| Activate | To be identified |
| Activation Dialog | To be identified |
| Confirm Button | To be identified |
| Cancel Button | To be identified |
| Success Message | To be identified |
| Updated Status | To be identified |

### Locator Strategy

Preference should be given to stable attributes such as:

- `id`
- `name`
- `formcontrolname`
- `data-*` attributes
- Accessible labels
- Stable CSS selectors

XPath should be used when a stable attribute is not available.

---

# 23. Dynamic Data Considerations

Client information is dynamically generated in the test environment.

For example:

```text
Client Name:
Ajit734492 Kumar Test734492
```

and:

```text
External ID:
EXT734492
```

Therefore, Selenium automation should avoid hardcoding dynamic client values wherever possible.

The automation should preferably:

1. Search using controlled test data.
2. Identify the corresponding client.
3. Open the correct client profile.
4. Perform activation.
5. Verify the resulting status.

---

# 24. UI Validation Points

## Client List

- Clients page should load successfully.
- Search field should be visible.
- Client records should be displayed.
- Client status should be displayed.
- Client name should be selectable.

## Client Profile

- Selected client profile should open successfully.
- Client information should be displayed.
- General tab should be available.
- Three-dot menu should be available.

## Actions

- Actions option should be available.
- Actions submenu should open successfully.
- Activate option should be displayed for an eligible client.

## Activation

- Activate option should be selectable.
- Activation process should complete successfully.
- Appropriate confirmation or success message should be displayed, if applicable.
- Client status should be updated correctly.

## Persistence

- Updated client status should remain correct after refreshing the page.
- Updated status should remain correct after reopening the client profile.

---

# 25. Negative UI Scenarios

The following scenarios should be considered:

1. Attempt to activate a client who is already Active.
2. Cancel the activation operation.
3. Verify that a failed activation does not incorrectly change the client status.
4. Verify appropriate validation or error messages.
5. Verify activation permissions for unauthorized users, if role-based access is configured.
6. Verify that the Activate option behaves correctly according to the client's current status.

---

# 26. Selenium Automation Navigation

The Selenium automation will follow the same workflow as the manual UI:

```text
Login
   ↓
Navigate to Clients
   ↓
Search Client
   ↓
Select Client
   ↓
Open Client General Page
   ↓
Click Three-Dot Menu
   ↓
Click Actions
   ↓
Click Activate
   ↓
Complete Activation
   ↓
Verify Client Status
```

---

# 27. Expected Automation Components

The automation will follow the existing Page Object Model framework.

Potential page classes:

```text
pages/
    ClientsPage.java
    ClientDetailsPage.java
```

Potential test class:

```text
tests/
    ActivateClientTest.java
```

The final class names should be aligned with the existing project structure.

---

# 28. Test Data

The following client was observed during UI analysis:

| Field | Value |
|------|-------|
| Client Name | Ajit734492 Kumar Test734492 |
| Account No. | 000000029 |
| External ID | EXT734492 |
| Office | Mumbai Branch |
| Client Classification | Regular |
| Client Type | Business |
| Staff | Unassigned |

The above values are environment-specific and may change between test executions.

---

# 29. UI Analysis Summary

The Activate Client functionality is accessed from the individual client profile.

The verified navigation path is:

```text
Clients
   ↓
Client Name
   ↓
General/Profile
   ↓
Three-Dot Menu
   ↓
Actions
   ↓
Activate
```

The Client List displays clients with their current status, including Pending clients.

The Activate operation is available through the Actions submenu of the selected client profile.

The UI elements required to navigate to the Activate option have been identified.

The UI displayed after selecting **Activate** still needs to be inspected before documenting the final activation controls and confirmation behavior.

---

# 30. Conclusion

The UI analysis for **US-002 – Activate Client** has identified the major UI components and the complete navigation path required to reach the Activate Client operation.

The verified workflow is:

```text
Client Management
      ↓
Select Client
      ↓
Client General Page
      ↓
Three-Dot Menu
      ↓
Actions
      ↓
Activate
```

The next step is to manually select **Activate** and inspect the resulting activation screen, confirmation controls, messages, and final client status.

**Next Document:** `03-Test-Scenarios.md`
