# Student Management System

A full-stack CRUD web application for managing student records. Users can add, view, update, and delete students from a browser. The data is stored in a PostgreSQL database.

## Features

- Add a new student (name, email, course, age)
- View all students in a table
- Edit an existing student
- Delete a student
- REST API built with Spring Boot
- Simple frontend built with HTML, CSS, and JavaScript, served by the same Spring Boot application

## Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 25, Spring Boot 4.1.1 |
| Database | PostgreSQL 18 |
| Data access | Spring Data JPA, Hibernate |
| Build tool | Maven |
| Frontend | HTML, CSS, JavaScript (Fetch API) |

## Architecture

The backend is split into layers, and each layer has one job:

```text
Browser  ->  Controller  ->  Service  ->  Repository  ->  PostgreSQL
```

- **Controller** receives HTTP requests and returns responses
- **Service** contains the application logic
- **Repository** talks to the database through Spring Data JPA
- **Model** (`Student`) describes a student and maps to the `student` table

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/students` | Get all students |
| GET | `/api/students/{id}` | Get one student |
| POST | `/api/students` | Add a student |
| PUT | `/api/students/{id}` | Update a student |
| DELETE | `/api/students/{id}` | Delete a student |

Example request body for POST and PUT:

```json
{
  "name": "Asha",
  "email": "asha@example.com",
  "course": "Maths",
  "age": 20
}
```

## Getting Started

### Prerequisites

- JDK 25
- PostgreSQL
- Git

### Run the project

1. Clone the repository:

   ```bash
   git clone https://github.com/Abhiram-tp/student-management-system.git
   cd student-management-system
   ```

2. Create the database in PostgreSQL:

   ```sql
   CREATE DATABASE student_management;
   ```

3. Create the file `src/main/resources/application-local.properties` with your PostgreSQL password. This file is listed in `.gitignore`, so it is never committed:

   ```properties
   spring.datasource.password=YOUR_POSTGRES_PASSWORD
   ```

   The default settings assume the PostgreSQL user `postgres` on `localhost:5432`. If yours is different, edit `src/main/resources/application.properties`.

4. Start the application:

   ```bash
   ./mvnw spring-boot:run
   ```

   On Windows PowerShell, use `.\mvnw.cmd spring-boot:run`.

5. Open `http://localhost:8080` in your browser.

The `student` table is created automatically by Hibernate on the first run.

## Project Structure

```text
src/main/java/com/example/student_management/
├── controller/    StudentController
├── model/         Student
├── repository/    StudentRepository
├── service/       StudentService
└── StudentManagementApplication.java
src/main/resources/
├── static/        index.html, style.css
└── application.properties
```

## Future Improvements

- Input validation and clearer error messages
- Authentication and authorization with Spring Security
- Search, sorting, and pagination
- Automated tests
- Deployment