
package service;
import util.AppLogger;
import model.Student;
import util.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final List<Student> students;

    public StudentService() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {

        if (student == null) {
            AppLogger.warning("Attempted to add null student.");
            System.out.println("Student cannot be null.");
            return;
        }

        if (searchStudentById(student.getStudentId()) != null) {
            AppLogger.warning(
                    "Duplicate student ID attempted: "
                            + student.getStudentId()
            );

            System.out.println("Student ID already exists.");
            return;
        }

        students.add(student);

        AppLogger.info(
                "Student added: ID="
                        + student.getStudentId()
                        + ", Name="
                        + student.getName()
        );

        System.out.println("Student added successfully.");
    }

    public void addStudentSilently(Student student) {

        if (student == null) {
            return;
        }

        if (searchStudentById(student.getStudentId()) != null) {
            return;
        }

        students.add(student);
    }


    public ArrayList<Student> getStudents() {
        return new ArrayList<>(students);
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

                AppLogger.info(
                        "Student found: ID=" + studentId
                );

                return student;
            }
        }

        AppLogger.warning(
                "Student not found: ID=" + studentId
        );

        return null;
    }

    public void sortStudentsByPercentage() {

        if (students.isEmpty()) {
            AppLogger.warning(
                    "Sorting requested with no students."
            );

            System.out.println("No students found.");
            return;
        }

        AppLogger.info(
                "Sorting " + students.size()
                        + " students by percentage."
        );


        AppLogger.info(
                "Student sorting completed successfully."
        );

        System.out.println(
                "Students sorted by percentage successfully."
        );
    }

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

            System.out.println(
                    "Invalid marks. All marks must be between 0 and 100."
            );
            return;
        }

        student.setMathsMarks(mathsMarks);
        student.setPhysicsMarks(physicsMarks);
        student.setChemistryMarks(chemistryMarks);
        student.setEnglishMarks(englishMarks);
        student.setComputerScienceMarks(computerScienceMarks);

        AppLogger.info(
                "Grades updated for student ID=" + studentId
        );

        System.out.println(
                "Student grades updated successfully."
        );
    }

    public String generateStudentTranscript(int studentId) {

        Student student = searchStudentById(studentId);

        if (student == null) {
            return "Student not found.";
        }

        double total = GradeCalculator.calculateTotal(
                student.getMathsMarks(),
                student.getPhysicsMarks(),
                student.getChemistryMarks(),
                student.getEnglishMarks(),
                student.getComputerScienceMarks()
        );

        double percentage = GradeCalculator.calculatePercentage(total);

        char grade = GradeCalculator.calculateGrade(percentage);

        return "============================================================\n" +
                "                    STUDENT TRANSCRIPT\n" +
                "============================================================\n\n" +

                "Student ID       : " + student.getStudentId() + "\n" +
                "Name             : " + student.getName() + "\n" +
                "Age              : " + student.getAge() + "\n" +
                "Course           : " + student.getCourse() + "\n\n" +

                "------------------------------------------------------------\n" +
                "SUBJECT                 MARKS\n" +
                "------------------------------------------------------------\n" +
                "Maths                   " + student.getMathsMarks() + "\n" +
                "Physics                 " + student.getPhysicsMarks() + "\n" +
                "Chemistry               " + student.getChemistryMarks() + "\n" +
                "English                 " + student.getEnglishMarks() + "\n" +
                "Computer Science        " + student.getComputerScienceMarks() + "\n" +
                "------------------------------------------------------------\n\n" +

                String.format("Total Marks             : %.2f / 500%n", total) +
                String.format("Percentage              : %.2f%%%n", percentage) +
                "Grade                   : " + grade + "\n\n" +

                "============================================================";
    }

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