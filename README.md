# Employees-Service
Service for managing employee data. Allowing users for fetching employee details based on his unique employee id.

## Local development setup.
### Prerequisites
- JDK 17
- Git
- Docker Desktop
- IntelliJ IDEA Community Edition/Ultimate

### Clone Repository
Clone repository using the web url:
<br><br>
<img width="352" height="254" alt="image" src="https://github.com/user-attachments/assets/0dc5f4a7-f3d0-43f4-b0a6-941b55e34da9" />
<br><br>
Clone repository using IntelliJ and Get from VSC option or git bash:
File -> New -> Project from Version Control..
<br><br>
<img width="643" height="489" alt="image" src="https://github.com/user-attachments/assets/94f52826-1af3-4d91-92b3-7c96e7796a2a" />
<br><br>
### Run Application
Run Docker Desktop and connect to docker Server:
- start docker-compose
  <br><br>
  <img width="517" height="448" alt="image" src="https://github.com/user-attachments/assets/f426a64d-9bf9-4fc3-a80a-866ded0e67a1" />
<br><br>
- start Spring Boot EmployeesServiceApplication:
  <br><br>
  <img width="600" height="172" alt="image" src="https://github.com/user-attachments/assets/e8ff8df6-198e-400f-8739-bd338883bd26" />
<br><br>
### Database Configuration
This application uses PostgreSQL as its primary database.
The database is set up locally using a Docker container, ensuring a consistent and reproducible environment across all development setups.
#### Setup Details
- Database Engine: PostgreSQL (Docker image)
- Schema Migrations: Managed with Liquibase, ensuring all database changes are version-controlled and automatically applied while app is running / during deployment.
- Database Management Tool: recommernded pgAdmin for manual configuration, inspection, and query execution.
#### How it works
- The PostgreSQL container is started via Docker.
- Liquibase runs migration scripts to initialize and update the database schema.
- pgAdmin allows developers to connect to the running container for database administration and debugging.
#### pgAdmin configuration
After running docker-compose and pulling postgreSQL docker image, database "employeesservice" will be created automatically.
- register server in pgAdmin:
  <br><br>
  <img width="681" height="404" alt="image" src="https://github.com/user-attachments/assets/050e1f55-35cb-4c59-9f31-97515bd5a8a5" />
  <br><br>
  <img width="700" height="400" alt="image" src="https://github.com/user-attachments/assets/a0bd321f-9f60-4f28-9815-157b5d4659b9" />
  <br><br>
- Database can be use via pgAdmin:
  <br><br>
  <img width="1295" height="667" alt="image" src="https://github.com/user-attachments/assets/7d6de2a0-cceb-44e6-8c04-ee803f4893b0" />
<br><br>
### Test Appplication
Application can be tested e.g using Swagger Ui.
- before testing, execute sql query to feed data base with example data:
INSERT into public.employee (employee_id, name, surname, role, hiring_date) values ('1', 'John', 'Doe', 'DEVELOPER', '2026-01-01');
INSERT into public.employee (employee_id, name, surname, role, hiring_date) values ('2', 'Mark', 'Kraft', 'MANAGER', '2025-10-01');
INSERT into public.employee (employee_id, name, surname, role, hiring_date) values ('3', 'Linda', 'McKay', 'TESTER', '2023-02-11');
- running Swagger UI:
  When application is running Swagger UI can be open via http://localhost:8080/swagger-ui/index.html
  <br><br>
  <img width="1327" height="498" alt="image" src="https://github.com/user-attachments/assets/17bd482f-dcb2-4fd6-a73b-17abbd095307" />
  <br><br>
- executing succes request (get exsiting employee details):
  <br><br>
  <img width="1030" height="655" alt="image" src="https://github.com/user-attachments/assets/7996efcd-a883-4d78-b9be-746178ecdb84" />
  <br><br>
- executing failure request (get not existing employee details):
  <br><br>
  <img width="1047" height="648" alt="image" src="https://github.com/user-attachments/assets/1f4c6c4b-bced-4abe-8243-7afb9312287a" />
  <br><br>






