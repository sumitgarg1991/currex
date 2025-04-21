# 💱 Currency Discount API - CURREX

A Spring Boot application that calculates the total payable amount for a bill in a specified currency after applying applicable discounts and converting the currency using real-time exchange rates.

---

## 🚀 Features

- ✅ Real-time exchange rates using [ExchangeRate-API](https://open.er-api.com/)
- ✅ Smart discount logic for employees, affiliates, loyal customers, and bill size
- ✅ Currency conversion between any two currencies
- ✅ Basic Authentication for secure endpoints
- ✅ Exchange rate caching with Guava
- ✅ Unit tests with mock services
- ✅ API exposed via `/api/calculate`
- ✅ Login endpoint (`/auth/login`) for credential validation

---

## 🛠 Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Security
- Google Guava (for caching)
- JUnit 5 + Mockito (for testing)
- Maven (build tool)

---

## 🔐 Authentication

This project uses **Basic Authentication**.

- **Username:** `apiuser`
- **Password:** `password123`

Add the credentials in your request headers or use Postman/Curl for testing.

---

## 📡 API Endpoints

### 🔹 Calculate Final Payable Amount

**URL:** `POST /api/calculate`

**Body (JSON):**
```json
{
  "items": [
    { "name": "TV", "category": "electronics", "amount": 400 },
    { "name": "Apples", "category": "groceries", "amount": 50 }
  ],
  "userType": "EMPLOYEE",
  "yearsCustomer": 3,
  "originalCurrency": "USD",
  "targetCurrency": "EUR"
}
