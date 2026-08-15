/*package service;

import model.Student;

import util.InputValidator;

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

    public void addStudentSilently(Student student) {

        if (searchStudentById(student.getStudentId()) != null) {
            return;
        }

        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return new ArrayList<>(students);
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

        if (!InputValidator.isValidMarks(mathsMarks)) {
            System.out.println("Invalid Maths marks. Marks must be between 0 and 100.");
            return;
        }

        if (!InputValidator.isValidMarks(physicsMarks)) {
            System.out.println("Invalid Physics marks. Marks must be between 0 and 100.");
            return;
        }

        if (!InputValidator.isValidMarks(chemistryMarks)) {
            System.out.println("Invalid Chemistry marks. Marks must be between 0 and 100.");
            return;
        }

        if (!InputValidator.isValidMarks(englishMarks)) {
            System.out.println("Invalid English marks. Marks must be between 0 and 100.");
            return;
        }

        if (!InputValidator.isValidMarks(computerScienceMarks)) {
            System.out.println("Invalid Computer Science marks. Marks must be between 0 and 100.");
            return;
        }

        student.setMathsMarks(mathsMarks);
        student.setPhysicsMarks(physicsMarks);
        student.setChemistryMarks(chemistryMarks);
        student.setEnglishMarks(englishMarks);
        student.setComputerScienceMarks(computerScienceMarks);

        System.out.println("Student grades updated successfully.");
    }
}*/

package service;

import model.Student;
import util.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final List<Student> students;

    public StudentService() {
        students = new ArrayList<>();
    }

    // Add a student with validation and duplicate ID checking
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

    // Add a student without console output.
    // Used by performance testing to avoid measuring console I/O.
    public void addStudentSilently(Student student) {

        if (student == null) {
            return;
        }

        if (searchStudentById(student.getStudentId()) != null) {
            return;
        }

        students.add(student);
    }

    // Return a copy so callers cannot directly modify the internal list.
    public ArrayList<Student> getStudents() {
        return new ArrayList<>(students);
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

    // Search for a student by ID
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

            double percentage1 = calculateStudentPercentage(student1);
            double percentage2 = calculateStudentPercentage(student2);

            return Double.compare(percentage2, percentage1);
        });

        System.out.println("Students sorted by percentage successfully.");
    }

    // Calculate the percentage of a particular student
    private double calculateStudentPercentage(Student student) {

        double total = GradeCalculator.calculateTotal(
                student.getMathsMarks(),
                student.getPhysicsMarks(),
                student.getChemistryMarks(),
                student.getEnglishMarks(),
                student.getComputerScienceMarks()
        );

        return GradeCalculator.calculatePercentage(total);
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

        if (!areAllMarksValid(
                mathsMarks,
                physicsMarks,
                chemistryMarks,
                englishMarks,
                computerScienceMarks)) {
            System.out.println("Invalid marks. All marks must be between 0 and 100.");
            return;
        }

        student.setMathsMarks(mathsMarks);
        student.setPhysicsMarks(physicsMarks);
        student.setChemistryMarks(chemistryMarks);
        student.setEnglishMarks(englishMarks);
        student.setComputerScienceMarks(computerScienceMarks);

        System.out.println("Student grades updated successfully.");
    }

    // Validate all subject marks
    private boolean areAllMarksValid(
            double mathsMarks,
            double physicsMarks,
            double chemistryMarks,
            double englishMarks,
            double computerScienceMarks) {

        return InputValidator.isValidMarks(mathsMarks)
                && InputValidator.isValidMarks(physicsMarks)
                && InputValidator.isValidMarks(chemistryMarks)
                && InputValidator.isValidMarks(englishMarks)
                && InputValidator.isValidMarks(computerScienceMarks);
    }
}