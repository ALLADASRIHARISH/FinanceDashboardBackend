# Finance Dashboard Backend

## 📌 Overview

This project implements a backend system for a finance dashboard that manages financial records, enforces role-based access control, and provides real-time financial insights.

The application is built using Spring Boot with a focus on clean architecture, data integrity, and maintainable backend design.

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* H2 In-Memory Database

---

## 🧱 Architecture

The application follows a layered architecture:

* **Controller Layer** → Handles HTTP requests
* **Service Layer** → Implements business logic
* **Repository Layer** → Manages database operations
* **Entity Layer** → Defines data models
* **Security Layer** → Handles role-based access control
* **Exception Layer** → Provides global error handling

---

## 👤 User Roles & Access Control

| Role    | Permissions                                        |
| ------- | -------------------------------------------------- |
| VIEWER  | Read-only access to dashboard                      |
| ANALYST | Read access to records and analytics               |
| ADMIN   | Full access (CRUD operations on users and records) |

Role-based access control is implemented using Spring Security.

---

## 🔐 Authentication

Basic Authentication is used with in-memory users:

* admin / password
* analyst / password
* viewer / password

---

## 📊 Core Features

### 1. User Management

* Create, update, and delete users
* Assign roles (VIEWER, ANALYST, ADMIN)
* Manage user status (active/inactive)

---

### 2. Financial Records Management

* Create, update, delete financial records (ADMIN only)
* View records (all roles)
* Filter records by category and type
* Pagination support for scalability

---

### 3. Dashboard Analytics

* Total Income
* Total Expenses
* Net Balance
* Category-wise aggregation
* Recent transaction history

---

## 🔍 Mapping to Assignment Requirements

### ✔ User & Role Management

Implemented Role-Based Access Control (RBAC) with clear separation of permissions.

### ✔ Financial Records

Full CRUD operations with filtering and pagination support.

### ✔ Dashboard Summary APIs

Implemented `/dashboard/summary` endpoint providing:

* Total Income
* Total Expenses
* Net Balance
* Category-wise totals
* Recent activity

### ✔ Access Control Logic

Enforced using Spring Security with role-based endpoint restrictions.

### ✔ Validation & Error Handling

* Input validation using annotations (`@NotBlank`, `@Positive`, etc.)
* Global exception handler returning clean JSON error responses

### ✔ Data Persistence

* H2 in-memory database with JPA/Hibernate
* Automatic schema generation

---

## 🌐 API Endpoints

### 🔹 User APIs (ADMIN only)

* POST /users
* GET /users
* PATCH /users/{id}
* DELETE /users/{id}

---

### 🔹 Record APIs

* POST /records (ADMIN)
* GET /records (ALL)
* PATCH /records/{id} (ADMIN)
* DELETE /records/{id} (ADMIN)
* GET /records/filter?category=...&type=...

---

### 🔹 Dashboard

* GET /dashboard/summary

---

## 🧪 Sample Request

### POST /records

```json
{
  "amount": 5000,
  "type": "INCOME",
  "category": "Salary",
  "date": "2026-04-02",
  "notes": "Monthly salary"
}
```

---

## ⚙️ Setup Instructions

1. Clone the repository
2. Open in IntelliJ IDEA
3. Run `FinanceDashboardBackendApplication`
4. Access APIs at:

   * http://localhost:8080

---

## 🗄️ Database

* H2 in-memory database
* Data resets on application restart

---

## ⚠️ Technical Decisions & Trade-offs

* Used H2 database for simplicity and quick setup
* Used Basic Authentication instead of JWT for faster implementation
* Focused on backend architecture and business logic over deployment

---

## ⭐ Possible Enhancements

* JWT-based authentication
* Persistent database (MySQL/PostgreSQL)
* Swagger/OpenAPI documentation
* Advanced analytics (monthly trends, reports)

---

## 📌 Conclusion

This project demonstrates a well-structured backend system with role-based access control, financial data processing, and analytics. It emphasizes clarity, maintainability, and correct implementation of backend engineering principles.
