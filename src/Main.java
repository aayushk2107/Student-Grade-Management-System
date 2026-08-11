import model.Student;
import service.StudentService;

public class Main {

    public static void main(String[] args) {

        StudentService service = new StudentService();

        Student student1 = new Student(
                101, "Aayush", 20, "B.Tech CSE",
                90, 85, 92, 88, 95
        );

        Student student2 = new Student(
                102, "Rahul", 20, "B.Tech CSE",
                75, 80, 72, 78, 85
        );

        Student student3 = new Student(
                103, "Priya", 20, "B.Tech CSE",
                95, 91, 94, 96, 98
        );

        service.addStudent(student1);
        service.addStudent(student2);
        service.addStudent(student3);

        System.out.println("===== BEFORE SORTING =====");
        service.displayAllStudents();

        System.out.println("===== SORTING =====");
        service.sortStudentsByPercentage();

        System.out.println("===== AFTER SORTING =====");
        service.displayAllStudents();

        System.out.println("===== STUDENT GRADE DETAILS =====");
        System.out.println(service.getStudentGradeDetails(103));
    }
}