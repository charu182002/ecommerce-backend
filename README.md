# E-Commerce Backend

A RESTful E-Commerce Backend built using **Spring Boot** that provides secure JWT authentication, role-based authorization, product management, order processing, Apache Kafka integration, Swagger API documentation, Docker support, and MySQL database integration.

---

## Features

- JWT Authentication
- Role-Based Authorization (ADMIN / USER)
- Product CRUD APIs
- Product Search & Filtering
- Pagination Support
- Product Review APIs
- Order Processing APIs
- Apache Kafka Producer & Consumer
- Swagger/OpenAPI Documentation
- Docker Containerization
- MySQL Database Integration

---

## Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)

### Security
- JWT Authentication
- BCrypt Password Encoding

### Database
- MySQL

### Messaging
- Apache Kafka

### Documentation
- Swagger / OpenAPI

### Build Tool
- Maven

### Containerization
- Docker
- Docker Compose

---

## Project Structure

```text
src
├── controller
├── dto
├── entity
├── kafka
│   ├── KafkaProducerService
│   └── KafkaConsumerService
├── repository
├── security
├── service
├── spec
└── resources
```

---

## REST APIs

### Authentication

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/register` | Register a new user |
| POST | `/api/auth/login` | Authenticate user and generate JWT |

---

### Products

| Method | Endpoint | Access |
|--------|----------|--------|
| GET | `/api/products` | Public |
| GET | `/api/products/{id}` | Public |
| GET | `/api/products/search` | Public |
| POST | `/api/products` | ADMIN |
| PUT | `/api/products/{id}` | ADMIN |
| DELETE | `/api/products/{id}` | ADMIN |

---

### Product Reviews

| Method | Endpoint |
|--------|----------|
| POST | `/api/products/review` |

---

### Orders

| Method | Endpoint |
|--------|----------|
| POST | `/api/orders` |
| GET | `/api/orders/{orderNo}` |

---

## Role-Based Access

| User Role | Permissions |
|-----------|-------------|
| Public | Register, Login, View Products, Search Products |
| USER | Place Orders, Add Product Reviews |
| ADMIN | Create Products, Update Products, Delete Products |

---

## Kafka Event Flow

```text
Create Order
     │
     ▼
Save Order in MySQL
     │
     ▼
Publish Event to Kafka
     │
     ▼
Kafka Consumer Receives Event
     │
     ▼
Logs Order Created Message
```

---

## Running the Project

### Prerequisites

- Java 17
- Maven
- Docker
- Docker Compose
- MySQL

---

### Clone the Repository

```bash
git clone https://github.com/charu182002/ecommerce-backend.git
cd ecommerce-backend
```

---

## Docker

The project includes Docker and Docker Compose configuration to run the Spring Boot application and its required services.

### Start all Services

```bash
docker-compose up -d
```

### Build Docker Image

```bash
docker build -t ecart .
```

### Run Docker Container

```bash
docker run -p 8080:8080 ecart
```

---

### Configure Database

Update your database configuration in:

```
src/main/resources/application.properties
```

---

### Build the Project

```bash
mvn clean install
```

---

### Run the Application

```bash
mvn spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

---

## Swagger Documentation

After starting the application, open:

```
http://localhost:8080/swagger-ui/index.html
```

Swagger can be used to test all available REST APIs.

---

## JWT Authentication

Protected APIs require a JWT access token.

Example:

```http
Authorization: Bearer <JWT_TOKEN>
```

---

## Technologies Demonstrated

- RESTful API Development
- Layered Architecture
- DTO Mapping
- Spring Data JPA
- Dynamic Search using JPA Specifications
- Pagination
- Bean Validation
- JWT Authentication
- Spring Security
- Role-Based Authorization
- Apache Kafka Messaging
- Docker
- Swagger/OpenAPI
- MySQL Integration

---

## Author

**Charumathi P**

Java Backend Developer

LinkedIn:  
https://www.linkedin.com/in/charumathi-p-a167b221b
