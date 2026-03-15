# Task Management Project

[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-green)](https://spring.io/projects/spring-boot)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

A Spring Boot application to manage tasks, users, and managers efficiently. This project allows creating, assigning, updating, and tracking tasks with role-based access.

---

## Features

- Create, update, and delete tasks
- Assign tasks to users and managers
- Track task progress and status
- Role-based authentication and authorization (User / Manager)
- Configuration via `application.properties`
- Unit testing with JUnit

---

## Project Structure
src/main/java/com/project/taskmanagement
├── controller # REST API endpoints
├── service # Business logic (e.g., ManagerService)
├── model # Entity classes and DTOs
└── repository # Database access layer

src/main/resources
├── application.properties # Spring Boot configuration


---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- Git
- Optional: MySQL/PostgreSQL for database persistence

### Installation

1. Clone the repository:

```bash
git clone https://github.com/InnoHire/project.git
cd project
git checkout manager
mvn clean install
mvn spring-boot:run
API Endpoints
Task Endpoints
Method	Endpoint	Description
GET	/tasks	List all tasks
POST	/tasks	Create a new task
PUT	/tasks/{id}	Update an existing task
DELETE	/tasks/{id}	Delete a task
Manager Endpoints
Method	Endpoint	Description
GET	/managers	List all managers
POST	/managers	Add a new manager
PUT	/managers/{id}	Update manager information
