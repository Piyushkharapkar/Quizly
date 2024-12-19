
# Quiz App

## Description

The Quiz App is a web-based platform where users can register, log in, and participate in interactive quizzes. It provides a smooth and engaging experience for testing knowledge, tracking quiz progress, and managing results. The app is designed with security and performance in mind, offering a responsive interface for both desktop and mobile users.

## Features

- **User Authentication**: Secure registration, login, and session management for users.
- **Dynamic Quizzes**: Users can take quizzes with real-time question tracking and scoring.
- **Real-time Feedback**: Instant results with scores.
- **User Dashboard**: A personalized dashboard to view past quiz results.
- **Responsive UI**: A mobile-friendly design for seamless use across all devices.

## Technologies Used

- **Frontend**:
  - **HTML**: Structure and layout of the web pages.
  - **CSS**: Styling to create an attractive and responsive design.
  - **JavaScript**: Dynamic features, quiz logic, and user interactions.
  
- **Backend**:
  - **Spring Boot**: For building the backend application and handling API requests.
  - **JPA (Java Persistence API)**: For interacting with the database and managing user data and quiz results.
  
- **Database**:
  - **MySQL**: Used for storing user data, quiz questions, and results.

## Installation

### Prerequisites

- **Java**: Ensure you have Java 11 or later installed for running the backend.
- **MySQL**: Make sure MySQL is installed and running for the database setup.
- **Maven**: For building and running the Spring Boot application.

### Steps to Run the Application

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/quiz-app.git
   ```

2. **Set up the Backend**:
   - Navigate to the backend folder:
     ```bash
     cd backend
     ```
   - Configure the `application.properties` file to connect to your MySQL database.
   - Build and run the Spring Boot application:
     ```bash
     mvn spring-boot:run
     ```

3. **Set up the Frontend**:
   - Open the `index.html` file in your browser to access the quiz interface.
   - The frontend will automatically connect to the backend via API calls for quizzes and user authentication.

4. **Database Configuration**:
   - Create a MySQL database and set up tables for storing user and quiz data. Database schema can be found in the `backend` folder.

## Usage

- **User Registration and Login**: Users can create an account and log in to participate in quizzes.
- **Quizzes**: Once logged in, users can start taking quizzes, which consist of multiple questions with multiple-choice answers.
- **Dashboard**: After completing a quiz, users can view their results and progress on the dashboard.
