import model.Student;
import service.StudentService;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        StudentService service = new StudentService();

        service.addStudentSilently(new Student(
                101, "Aayush", 20, "B.Tech CSE",
                90, 85, 92, 88, 95
        ));

        service.addStudentSilently(new Student(
                102, "Rahul", 20, "B.Tech CSE",
                75, 80, 72, 78, 85
        ));

        service.addStudentSilently(new Student(
                103, "Priya", 20, "B.Tech CSE",
                95, 91, 94, 96, 98
        ));

        runApplication(service);

        scanner.close();
    }

    private static void runApplication(StudentService service) {

        boolean running = true;

        while (running) {

            displayMenu();

            int choice = readInt("Enter your choice: ");

            System.out.println();

            switch (choice) {

                case 1:
                    addStudent(service);
                    break;

                case 2:
                    service.displayAllStudents();
                    break;

                case 3:
                    searchStudent(service);
                    break;

                case 4:
                    service.sortStudentsByPercentage();
                    service.displayAllStudents();
                    break;

                case 5:
                    viewGradeDetails(service);
                    break;

                case 6:
                    updateGrades(service);
                    break;

                case 7:
                    generateTranscript(service);
                    break;

                case 8:
                    running = false;
                    System.out.println("Thank you for using Student Grade Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1-8.");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }

    private static void displayMenu() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("       STUDENT GRADE MANAGEMENT");
        System.out.println("========================================");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Sort by Percentage");
        System.out.println("5. View Grade Details");
        System.out.println("6. Update Grades");
        System.out.println("7. Generate Transcript");
        System.out.println("8. Exit");
        System.out.println("========================================");
    }

    private static void addStudent(StudentService service) {

        System.out.println("===== ADD STUDENT =====");

        int id = readInt("Student ID: ");

        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        int age = readInt("Age: ");

        scanner.nextLine();

        System.out.print("Course: ");
        String course = scanner.nextLine();

        double maths = readDouble("Maths marks: ");
        double physics = readDouble("Physics marks: ");
        double chemistry = readDouble("Chemistry marks: ");
        double english = readDouble("English marks: ");
        double computerScience =
                readDouble("Computer Science marks: ");

        Student student = new Student(
                id,
                name,
                age,
                course,
                maths,
                physics,
                chemistry,
                english,
                computerScience
        );

        service.addStudent(student);
    }

    private static void searchStudent(StudentService service) {

        System.out.println("===== SEARCH STUDENT =====");

        int id = readInt("Enter Student ID: ");

        Student student = service.searchStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Student found:");
            System.out.println(student);
        }
    }

    private static void viewGradeDetails(StudentService service) {

        System.out.println("===== GRADE DETAILS =====");

        int id = readInt("Enter Student ID: ");

        System.out.println(
                service.getStudentGradeDetails(id)
        );
    }

    private static void updateGrades(StudentService service) {

        System.out.println("===== UPDATE GRADES =====");

        int id = readInt("Enter Student ID: ");

        double maths = readDouble("New Maths marks: ");
        double physics = readDouble("New Physics marks: ");
        double chemistry = readDouble("New Chemistry marks: ");
        double english = readDouble("New English marks: ");
        double computerScience =
                readDouble("New Computer Science marks: ");

        service.updateStudentGrades(
                id,
                maths,
                physics,
                chemistry,
                english,
                computerScience
        );
    }

    private static void generateTranscript(StudentService service) {

        System.out.println("===== STUDENT TRANSCRIPT =====");

        int id = readInt("Enter Student ID: ");

        System.out.println(
                service.generateStudentTranscript(id)
        );
    }

    private static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }
    }

    private static double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Double.parseDouble(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }
    }
}