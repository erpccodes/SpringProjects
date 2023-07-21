# Contact Management App

The Contact Management App is a web application that allows users to manage their contacts. It provides features to add, view, update, and delete contacts. The application also includes user registration and login functionality with role-based access control.

## Technologies Used

- Java (Spring Boot)
- Thymeleaf (for server-side templating)
- Spring Security (for authentication and authorization)
- MySQL (or any other compatible database)

## Prerequisites

- Java Development Kit (JDK) version 8 or later
- MySQL or other compatible relational database
- Integrated Development Environment (IDE) - recommended: Eclipse or IntelliJ IDEA
- Maven (for dependency management)
- Web browser (for testing the application)

## Getting Started

1. Clone the repository to your local machine using the following command:


2. Import the project into your preferred IDE (Eclipse, IntelliJ IDEA, etc.).

3. Set up the database:
- Create a new database in MySQL (or your chosen database).
- Update the database configuration in the `application.properties` file located in the `src/main/resources` folder. Modify the following properties:
  ```
  spring.datasource.url=jdbc:mysql://<database-host>:<port>/<database-name>
  spring.datasource.username=<database-username>
  spring.datasource.password=<database-password>
  ```

4. Build the project using Maven:
mvn clean install

5. Run the application:
mvn spring-boot:run

6. Access the application in your web browser at: `http://localhost:8080`

## Usage

### User Registration

- Navigate to `/register` to access the registration form.
- Provide a unique username and password and click the "Register" button.
- If the registration is successful, you will be redirected to the login page.

### User Login

- Access the login page at `/login`.
- Enter your registered username and password and click the "Log in" button.
- Upon successful login, you will be redirected to the contact list page.

### Contact Management

- Once logged in, navigate to `/contacts` to view your contact list.
- Use the "Add Contact" button to add new contacts to your list.
- Click on the contact names to view or update contact details.
- Use the "Delete" button to remove a contact from the list.

### Logging Out

- Click on the "Logout" link in the navigation bar to log out from the application.


## Contributing

Contributions to this project are welcome! If you find any bugs or want to suggest improvements, please create an issue or submit a pull request.

