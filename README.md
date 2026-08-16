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

## Project Structure

```text
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