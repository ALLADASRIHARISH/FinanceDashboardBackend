# Finance Dashboard Backend

## 📌 Overview

This project is a backend system for a finance dashboard that manages financial records and provides aggregated insights. It demonstrates API design, role-based access control, and business logic implementation using Spring Boot.

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
* **Service Layer** → Contains business logic
* **Repository Layer** → Handles database operations
* **Entity Layer** → Defines data models
* **Security Layer** → Role-based access control
* **Exception Layer** → Global error handling

---

## 👤 User Roles

| Role    | Permissions                        |
| ------- | ---------------------------------- |
| VIEWER  | View dashboard data                |
| ANALYST | View records and dashboard         |
| ADMIN   | Full access (CRUD users & records) |

---

## 🔐 Authentication

Basic Authentication is used with in-memory users:

* admin / password
* analyst / password
* viewer / password

---

## 📊 Features

### 1. User Management

* Create users
* Update role and active status
* Delete users

### 2. Financial Records

* Create record (ADMIN only)
* View records (all roles)
* Update record (ADMIN only)
* Delete record (ADMIN only)
* Filter records by category and type
* Pagination support

### 3. Dashboard Summary

* Total income
* Total expenses
* Net balance
* Category-wise totals
* Recent transactions

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

## ⚠️ Assumptions

* Basic authentication used for simplicity
* In-memory database used for quick setup
* No frontend included

---

## ⭐ Optional Enhancements

* JWT authentication
* Persistent database (MySQL/PostgreSQL)
* Swagger API documentation
* Advanced filtering and analytics

---

## 📌 Conclusion

This project demonstrates a clean backend architecture with role-based access control and financial data processing. It focuses on maintainability, clarity, and correct implementation of backend principles.
