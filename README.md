# Btsy Int Application

A Spring Boot application for managing bets and jackpots.

## Getting Started

### Prerequisites
- Docker
- Gradle

### Building and Running the Application

1. Build the Docker image:
   ```bash
   ./gradlew buildImage
   ```
2. Start the application using Docker Compose:
   ```bash
   docker-compose up
   ```
## Access the Application

1. **Web Application**: Open your browser and navigate to [http://localhost:8080](http://localhost:8080).
2. **Swagger UI**: Access the API documentation and test endpoints at [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).

## Usage

1. Retrieve the list of users and jackpots using Swagger UI or Postman.
2. Select a user and a jackpot.
3. Submit a bet for the selected user and jackpot using the `/api/bet/place` endpoint:
    - **Method**: PUT
    - **URL**: `http://localhost:8080/api/bet/place`
    - **Request Body** (example):
      ```json
      {
        "betId": 1,
        "userId": 1,
        "jackpotId": 1,
        "amount": 100
      }
      ```
4. The application evaluates the win chance and logs any winnings.
5. Check the logs or database for jackpot winnings and updated pools.