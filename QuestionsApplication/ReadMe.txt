# Question Service

This is a Spring Boot application that provides a Question Service API for playing a question-based game.

## Getting Started

To run the application locally, follow these steps:

1. Clone this repository to your local machine.
2. Make sure you have Java and Maven installed.
3. Open a terminal or command prompt and navigate to the project's root directory.
4. Run the command `mvn spring-boot:run` to start the application.
5. The application will be accessible at `http://localhost:8080`.

## API Endpoints

The following API endpoints are available:

- `GET /api/play`: Retrieves a random question to play.
- `POST /api/next`: Checks the answer to the current question and retrieves the next question.

## Usage

### Retrieve a Question

To retrieve a random question, make a GET request to `/api/play`. The API will respond with a JSON object containing the question details.

### Check Answer and Get Next Question

To check the answer to the current question and retrieve the next question, make a POST request to `/api/next`. The request body should be a JSON object with the `questionId` and `answer` properties. The API will respond with a JSON object containing the response and the details of the next question.