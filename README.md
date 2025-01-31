# Employee Tracker

The **Employee Tracker** is a backend application designed to help businesses efficiently manage employee data. It enables administrators to view, add, update, and delete employee records, roles, and departments. Built with **Spring Boot** and **Java**, this tool simplifies workforce management and ensures data accuracy.

### Technologies Used
- **Backend**: Spring Boot, Java
- **Database**: MySQL
- **API Testing**: Postman
- **Build Tool**: Maven
- **Version Control**: Git, GitHub

  ### Features
- View all employees, roles, and departments.
- Add new employees, roles, and departments.
- Update employee details and roles.
- Delete employee records.
- RESTful API for seamless integration with frontend applications.

  ### Usage
- Use **Postman** or any API client to interact with the RESTful API.
- Example API Endpoints:
  - **Get all employees**: `GET /api/employees`
  - **Add a new employee**: `POST /api/employees`
  - **Update an employee**: `PUT /api/employees/{id}`
  - **Delete an employee**: `DELETE /api/employees/{id}`

  ### API Documentation
#### Get All Employees
- **Endpoint**: `GET /api/employees`
- **Response**:
  ```json
  [
    {
      "id": 1,
      "name": "John Doe",
      "role": "Software Engineer",
      "department": "Engineering"
    }
  ]

  
