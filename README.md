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
```

**Response:**
```json
{
  "finalAmount": 319.75,
  "currency": "EUR"
}
```
![image](https://github.com/user-attachments/assets/222a5925-e6bc-4d79-8e74-eb9723aa1c50)


### 🔹 Login Endpoint (Demo Only)

**URL:** `POST /auth/login`

**Body:**
```json
{
  "username": "apiuser",
  "password": "password123"
}
```

**Response:**
```json
{
  "message": "Login successful",
  "user": "apiuser"
}
```

---

## 🧪 Run the App

```bash
./mvnw spring-boot:run
```

or (if using installed Maven):

```bash
mvn spring-boot:run
```

---

## 🧪 Run Tests

```bash
mvn test
```

---

## 📊 Generate Code Coverage Report

This project uses **JaCoCo** to generate code coverage.

```bash
mvn clean test jacoco:report
```

Open the report:

```
target/site/jacoco/index.html
```

---

## 📈 Static Code Analysis (Optional)

Use the following to run analysis:

```bash
mvn checkstyle:check
```

Or configure **SonarQube** and run:

```bash
mvn clean verify sonar:sonar
```

---

## 🌐 Exchange Rate API

This project integrates with the following endpoint:

```
https://open.er-api.com/v6/latest/{base_currency}?apikey=your-api-key
```

Replace `your-api-key` with your real API key in the `ExchangeRateService.java` or via `application.properties`.

---

## 🧊 Caching

Exchange rates are cached for 1 hour using **Guava CacheBuilder** to reduce API calls and improve performance.

---

## 📂 Project Structure

```
com.example.currencydiscountapi
├── controller
├── service
├── model
├── util
├── config
└── CurrencyDiscountApiApplication.java
```

---

## ✅ License

MIT

---

> Built with ❤️ by [Your Name]
```

---

Let me know if you want a `Dockerfile`, GitHub Actions CI config, or Swagger/OpenAPI doc setup too!
