# TaskFlow API

TaskFlow API is a Spring Boot based RESTful backend project developed for task management. The application allows users to create, list, update, and delete tasks with status, priority, and due date information.

## Features

- Create a new task
- List all tasks
- Get task details by ID
- Update an existing task
- Delete a task
- Request validation
- Global exception handling
- PostgreSQL database integration
- Swagger/OpenAPI documentation

## Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Hibernate
- Lombok
- Jakarta Validation
- Springdoc OpenAPI / Swagger UI
- Maven

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/tasks` | Lists all tasks |
| GET | `/api/tasks/{id}` | Retrieves a task by ID |
| POST | `/api/tasks` | Creates a new task |
| PUT | `/api/tasks/{id}` | Updates an existing task |
| DELETE | `/api/tasks/{id}` | Deletes a task |

## Example Request

```json
{
  "title": "Learn Spring Boot",
  "description": "Create the first REST API endpoint for TaskFlow project",
  "status": "TODO",
  "priority": "HIGH",
  "dueDate": "2026-05-15"
}
```

## Example Response

```json
{
  "id": 1,
  "title": "Learn Spring Boot",
  "description": "Create the first REST API endpoint for TaskFlow project",
  "status": "TODO",
  "priority": "HIGH",
  "dueDate": "2026-05-15",
  "createdAt": "2026-05-10T16:45:12",
  "updatedAt": "2026-05-10T16:45:12"
}
```

## Error Response Example

```json
{
  "error": "Not Found",
  "message": "Task not found with id: 999",
  "path": "/api/tasks/999",
  "status": 404,
  "timestamp": "2026-05-10T17:03:01"
}
```

## Swagger Documentation

After running the application, Swagger UI is available at:

```text
http://localhost:8080/swagger-ui/index.html
```

OpenAPI JSON is available at:

```text
http://localhost:8080/v3/api-docs
```

## Database Configuration

Create a PostgreSQL database named:

```sql
CREATE DATABASE taskflow_db;
```

Then configure `src/main/resources/application.properties`:

```properties
spring.application.name=taskflow

spring.datasource.url=jdbc:postgresql://localhost:5432/taskflow_db
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080
```

## How to Run

Clone the repository:

```bash
git clone https://github.com/Burakaynm/taskflow-api.git
```

Navigate to the project directory:

```bash
cd taskflow-api
```

Run the application:

```bash
./mvnw spring-boot:run
```

For Windows:

```bash
mvnw.cmd spring-boot:run
```

## Future Improvements

- Add user authentication with JWT
- Add task filtering by status and priority
- Add pagination and sorting
- Add Docker Compose support
- Add unit and integration tests
- Develop a React frontend