# User Management System and Task Management

## Description
This project implements a User Management System combined with a Task Management feature. Users can register, log in, add tasks, and search for tasks assigned to specific developers. The system uses a graphical user interface via dialog boxes to enhance user experience.

## Features
- **User Registration**: Users can register with a username, password, first name, and last name.
- **User Login**: Users can log in to access task management functionalities.
- **Task Management**: Users can add tasks and view the total hours of tasks added.
- **Task Search**: Users can search for tasks by name and retrieve the associated developer.

## Code Overview
- **Main Class**: Manages the flow of user interactions and integrates the various functionalities.
- **UserManagementSystem Class**: Handles user registration and login processes.
- **TaskManager Class**: Manages task creation and details.
- **SearchManager Class**: Provides functionality to search for tasks.
- **User Class**: Represents user details.

## Usage
1. Clone or download the repository.
2. Open the project in your preferred Java IDE.
3. Compile and run the `Main` class to start the application.
4. Follow the on-screen prompts to register, log in, and manage tasks.

## Example Workflow
1. **User Registration**: Input a valid username, password, first name, and last name.
2. **Login**: After registration, log in with the registered credentials.
3. **Task Management**: Add tasks, specify their durations, and check the accumulated total hours.
4. **Task Search**: Search for specific tasks and view the assigned developer.

## Test Cases
The project includes unit tests for the `UserManagementSystem` class to verify registration, login, and user details management.

### Example Test Cases:
- Test for successful user registration.
- Test for invalid username formats.
- Test for password complexity requirements.
- Test successful and failed login attempts.

## Requirements
- Java Development Kit (JDK) 8 or higher
- A Java IDE (e.g., IntelliJ IDEA, Eclipse)
