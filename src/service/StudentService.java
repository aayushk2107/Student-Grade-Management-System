package service;

import model.Student;

import java.util.ArrayList;

public class StudentService {

    private final ArrayList<Student> students;

    public StudentService() {
        students = new ArrayList<>();
    }

    // Add a student
    public void addStudent(Student student) {

        if (student == null) {
            System.out.println("Student cannot be null.");
            return;
        }

        if (searchStudentById(student.getStudentId()) != null) {
            System.out.println("Student ID already exists.");
            return;
        }

        students.add(student);
        System.out.println("Student added successfully.");
    }

    // Display all students
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

    // Search student by ID
    public Student searchStudentById(int studentId) {

        for (Student student : students) {

            if (student.getStudentId() == studentId) {
                return student;
            }
        }

        return null;
    }

    // Sort students by percentage in descending order
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

            double percentage1 =
                    GradeCalculator.calculatePercentage(total1);

            double percentage2 =
                    GradeCalculator.calculatePercentage(total2);

            return Double.compare(percentage2, percentage1);
        });

        System.out.println("Students sorted by percentage successfully.");
    }

    // Get grade details of a student
    public String getStudentGradeDetails(int studentId) {

        Student student = searchStudentById(studentId);

        if (student == null) {
            return "Student not found.";
        }

        return "==========================================\n" +
                "           STUDENT GRADE DETAILS\n" +
                "==========================================\n" +
                "Student ID       : " + student.getStudentId() + "\n" +
                "Name             : " + student.getName() + "\n" +
                "Course           : " + student.getCourse() + "\n" +
                "------------------------------------------\n" +
                "Maths            : " + student.getMathsMarks() + "\n" +
                "Physics          : " + student.getPhysicsMarks() + "\n" +
                "Chemistry        : " + student.getChemistryMarks() + "\n" +
                "English          : " + student.getEnglishMarks() + "\n" +
                "Computer Science : " + student.getComputerScienceMarks() + "\n" +
                "==========================================";
    }

    // Update all subject grades of a student
    public void updateStudentGrades(
            int studentId,
            double mathsMarks,
            double physicsMarks,
            double chemistryMarks,
            double englishMarks,
            double computerScienceMarks) {

        Student student = searchStudentById(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        student.setMathsMarks(mathsMarks);
        student.setPhysicsMarks(physicsMarks);
        student.setChemistryMarks(chemistryMarks);
        student.setEnglishMarks(englishMarks);
        student.setComputerScienceMarks(computerScienceMarks);

        System.out.println("Student grades updated successfully.");
    }
}