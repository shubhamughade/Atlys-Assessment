# Atlys QA Assignment

This repo contains my assignment which includes both **UI tests (Selenium)** and **API tests (RestAssured)** in a single `tests` package.

---

## 1. Setup
- JDK 11 or above  
- Maven 3.6+  
- Add all required dependencies
- IDE (IntelliJ / Eclipse)  
---

## 2. How to Run

- Run all tests:
mvn clean test

## 3. Run only UI tests:
- mvn -Dtest=UiSearchTest test

## 4. Run only API tests:
- mvn -Dtest=WidgetApiTest test

