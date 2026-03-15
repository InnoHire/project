# Task Management Project

This is a Task Management System built using **Java**, **Spring Boot**, **Maven**, **MySQL**, and tested using **Postman**. It allows admins to create and assign tasks, managers to assign tasks to users based on skills, track progress, and send completed tasks back to the admin. The Manager workflow follows this flow: Manager Login → Receive Task from Admin → Search User by Skills → Assign Task → Receive Completed Task from User → Send to Admin.  

## Technologies Used
- Java 17and 17+
- Spring Boot 3.x
- Maven 3.8+
- MySQL/PostgreSQL (for database)
- Postman (API testing)
- Git & GitHub (version control)

## Project Structure
src/main/java/com/project/taskmanagement
├── controller # REST API endpoints
├── service # Business logic (e.g., ManagerService)
├── model # Entity classes and DTOs
└── repository # Database access layer

src/main/resources
└── application.properties # Spring Boot configuration

## Getting Started

### Prerequisites
- Java 17 or above
- Maven 3.8 or above
- Git installed
- Optional: MySQL/PostgreSQL database

### Installation & Running
1. Clone the repository:  
```bash
git clone https://github.com/InnoHire/project.git
cd project
git checkout manager
