<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/88c4be05-3ee9-4bc3-bb60-d96eebedf90a" />

```text
# Student Grade Management System

A Java-based console application for managing student information and grades.

## Features

- Add students
- View all students
- Search students by ID
- Sort students by percentage
- Calculate total marks and percentage
- Calculate grades
- View student grade details
- Update student grades
- Generate student transcripts
- Validate grade input
- Handle invalid user input
- Log system activity
- Unit testing with JUnit
- Performance testing

## Requirements

- Java 17 or higher
- Git (optional, if cloning the repository)

## Running the Application

Clone the repository:

git clone https://github.com/aayushk2107/Student-Grade-Management-System.git

Open the project in IntelliJ IDEA or another Java IDE and run:

src/Main.java

The application starts as a console-based Student Grade Management System.

## Project Structure

src/
├── Main.java
├── model/
│   └── Student.java
├── service/
│   ├── StudentService.java
│   └── GradeCalculator.java
└── util/
    ├── InputValidator.java
    └── AppLogger.java

Test/
└── service/
    ├── GradeCalculatorTest.java
    ├── StudentServiceTest.java
    └── StudentServicePerformanceTest.java

## Production Deployment

The application is packaged as a Java JAR file for deployment.

### Build

Compile the application and create the executable JAR using Java 17.

### Run

java -jar StudentGradeManagementSystem.jar

The application will start in the terminal and display the Student Grade Management menu.

### Deployment Verification

The deployed application was tested by:

- Starting the application successfully
- Adding students
- Viewing student records
- Searching students
- Sorting students by percentage
- Updating grades
- Generating transcripts
- Validating invalid input
- Exiting the application successfully
