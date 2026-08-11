import model.Student;
import service.StudentService;

public class Main {

    public static void main(String[] args) {

        StudentService service = new StudentService();

        Student student1 = new Student(
                101,
                "Aayush",
                20,
                "B.Tech CSE",
                90,
                85,
                92,
                88,
                95
        );

        Student student2 = new Student(
                102,
                "Rahul",
                20,
                "B.Tech CSE",
                75,
                80,
                72,
                78,
                85
        );

        Student student3 = new Student(
                103,
                "Priya",
                20,
                "B.Tech CSE",
                95,
                91,
                94,
                96,
                98
        );

        // Add students
        System.out.println("===== ADDING STUDENTS =====");

        service.addStudent(student1);
        service.addStudent(student2);
        service.addStudent(student3);

        // Display students before sorting
        System.out.println("\n===== BEFORE SORTING =====");
        service.displayAllStudents();

        // Sort students by percentage
        System.out.println("\n===== SORTING =====");
        service.sortStudentsByPercentage();

        // Display students after sorting
        System.out.println("\n===== AFTER SORTING =====");
        service.displayAllStudents();

        // Display Priya's grades
        System.out.println("\n===== STUDENT GRADE DETAILS =====");
        System.out.println(service.getStudentGradeDetails(103));

        // Update Priya's grades
        System.out.println("\n===== UPDATING STUDENT GRADES =====");

        service.updateStudentGrades(
                103,
                90,
                88,
                92,
                95,
                97
        );

        // Display updated grades
        System.out.println("\n===== UPDATED GRADE DETAILS =====");
        System.out.println(service.getStudentGradeDetails(103));
    }
}