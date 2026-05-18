# Pharmacy Inventory Backend API

Professional backend API for pharmacy inventory, sales management, stock control, and reporting.

## Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- H2 Database
- Gradle
- Swagger / OpenAPI
- Lombok

---

## Features

### Product Management
- Create products
- Update products
- Delete products
- Get products
- Barcode validation

### Inventory Management
- Inventory IN movements
- Inventory OUT movements
- Automatic stock updates
- Stock validation

### Sales Management
- Create sales
- Multiple sale items
- Automatic total calculation
- Automatic stock reduction

### Validation & Error Handling
- Global exception handling
- Request validation
- Clean API responses

---

## API Documentation

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

### Project Structure
```text
controller/
service/
repository/
entity/
dto/
mapper/
security/
exception/
```

### Running the Project

## Clone repository
```bash
git clone https://github.com/AndreSPy1/pharmacy-inventory-backend.git
```

## Run application
```bash
./gradlew bootRun
```

### Author
Andres Peña  
Senior Java Backend Engineer