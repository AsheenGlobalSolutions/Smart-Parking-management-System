# Smart Parking Management System (SPMS)

A cloud-native microservice-based backend system to manage smart urban parking efficiently using Spring Boot and Spring Cloud ecosystem. This project is part of the final coursework for **ITS 1018 – Software Architectures & Design Patterns II**.

---

## 🚀 Project Overview

Urban cities suffer from traffic congestion and parking space shortages. SPMS aims to address these issues through:

- Real-time parking space availability tracking
- Seamless user reservation & vehicle simulation
- Digital transactions and booking receipts
- Modular and scalable architecture

---

## 🧱 Microservices Implemented

| Service            | Port  | Description                                                  |
|--------------------|-------|--------------------------------------------------------------|
| API Gateway        | 8080  | Entry point for all client requests                          |
| Config Server      | 8888  | Centralized configuration manager                           |
| Discovery Server   | 8761  | Eureka service registry and discovery                        |
| Parking Service    | 8084  | Manages parking space availability and reservation           |
| Vehicle Service    | 8083  | Handles vehicle registration and entry/exit simulation       |
| User Service       | 8082  | Manages user profiles and booking history                    |
| Payment Service    | 8085  | Handles mock payments and digital receipt generation         |

---

## ⚙️ Technologies Used

- **Spring Boot**
- **Spring Cloud (Eureka, Config, Gateway)**
- **Java 17**
- **MySQL**
- **Postman**
- Optional: Node.js / Python (not used in this implementation)

---

## 📦 Folder Structure

```

smart-parking-system/
├── api-gateway/
├── config-server/
├── discovery-server/
├── parking-service/
├── user-service/
├── vehicle-service/
├── payment-service/
├── postman_collection.json
├── docs/
│   └── screenshots/
│       └── eureka\_dashboard.png
└── README.md

```

---

## 📮 API Testing (Postman)

Use the Postman collection below to test all endpoints:

🔗 [Postman Collection](./postman_collection.json)

---

## 📸 Eureka Dashboard

This screenshot displays the successfully registered microservices in Eureka:

![Eureka Dashboard](docs/screenshots/eureka_dashboard.png)

---

## 🧪 How to Run

1. **Start Config Server** → Load all configurations
2. **Start Discovery Server (Eureka)**
3. **Start All Microservices** (Parking, User, Vehicle, Payment)
4. **Start API Gateway**
5. Use **Postman** to test endpoints via the gateway (`localhost:8080/`)

---

## ✍️ Author

**Charith Harsha**  
Software Engineering Undergraduate  
[Galle, Sri Lanka]

---

## 📚 Coursework Info

- **Course:** ITS 1018 – Software Architectures & Design Patterns II  
- **Assignment:** Final Examination – Microservice-based Parking System  
- **Institute:** Institute of Software Engineering - IJSE

---
