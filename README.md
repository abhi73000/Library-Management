# Library-Management

Overview
This project is a Library Management System developed using Spring Boot, MySQL, Hibernate, and Spring Data JPA. It provides functionalities to manage books and departments within a library.

Technologies Used
Spring Boot: Framework for creating standalone, production-grade Spring-based applications.
MySQL: Relational database management system used for data storage.
Hibernate: Object-relational mapping framework for managing database interactions.
Spring Data JPA: Simplifies data access layer implementation based on JPA.
Features
Books Management:

Add new books to the library.
Remove books by ISBN.
Search books by title, author, and availability.
List all books and available books.
Department Management:

Add new departments.
List all departments.
Retrieve departments by ID.
Project Structure
bash
Copy code
├── src
│   ├── main
│   │   ├── java/com/project
│   │   │   ├── controller       # Contains REST API controllers
│   │   │   ├── entity           # Entity classes (e.g., Book, Department)
│   │   │   ├── repository       # Spring Data JPA repositories
│   │   │   ├── service          # Service classes (e.g., LibraryService, DepartmentService)
│   │   │   └── LibraryApplication.java  # Spring Boot application main class
│   │   └── resources
│   │       └── application.properties  # Application configuration
│   └── test
│       └── java/com/project     # Unit and integration tests
│           ├── DepartmentServiceTest.java
│           ├── LibraryServiceTest.java
│           └── ControllerTests  # Tests for REST API controllers
└── pom.xml                      # Maven project configuration
Getting Started
Prerequisites
JDK 11 or higher
MySQL installed and running
Setup
Clone the repository:

bash
Copy code
git clone <repository-url>
cd library-management-system
Configure MySQL:

Create a H2 database named library_db.
Update application.properties with your H2 username and password.
Run the Application:
http://localhost:8080/h2-console/

bash
Copy code
./mvnw spring-boot:run
Access the Application:

Open a web browser and go to http://localhost:8080/api/library to access the API endpoints.

API Endpoints
Books:

POST /books: Add a new book.
DELETE /books/{isbn}: Remove a book by ISBN.
GET /books/title/{title}: Find books by title.
GET /books/author/{author}: Find books by author.
GET /books: List all books.
GET /books/available: List available books.
Departments:

POST /departments: Add a new department.
GET /departments: List all departments.
GET /departments/{id}: Get department by ID.
Testing
Unit tests and integration tests are provided in the test directory.
Use ./mvnw test to run all tests.
Contributing
Contributions are welcome! Please fork the repository and create a pull request.
