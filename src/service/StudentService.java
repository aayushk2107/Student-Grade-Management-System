package service;

import model.Student;

import java.util.ArrayList;

public class StudentService {

    private final ArrayList<Student> students;

    public StudentService() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {

        if (searchStudentById(student.getStudentId()) != null) {
            System.out.println("Student ID already exists.");
            return;
        }

        students.add(student);
        System.out.println("Student added successfully.");
    }


    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
            System.out.println("------------------------------------------");
        }
    }

    public Student searchStudentById(int studentId) {

        for (Student student : students) {

            if (student.getStudentId() == studentId) {
                return student;
            }

        }

        return null;
    }

}