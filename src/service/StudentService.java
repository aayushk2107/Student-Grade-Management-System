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

    public void sortStudentsByPercentage() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        students.sort((student1, student2) -> {

            double total1 = GradeCalculator.calculateTotal(
                    student1.getMathsMarks(),
                    student1.getPhysicsMarks(),
                    student1.getChemistryMarks(),
                    student1.getEnglishMarks(),
                    student1.getComputerScienceMarks()
            );

            double total2 = GradeCalculator.calculateTotal(
                    student2.getMathsMarks(),
                    student2.getPhysicsMarks(),
                    student2.getChemistryMarks(),
                    student2.getEnglishMarks(),
                    student2.getComputerScienceMarks()
            );

            double percentage1 = GradeCalculator.calculatePercentage(total1);
            double percentage2 = GradeCalculator.calculatePercentage(total2);

            return Double.compare(percentage2, percentage1);
        });

        System.out.println("Students sorted by percentage successfully.");
    }
}