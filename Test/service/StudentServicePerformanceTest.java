package service;

import model.Student;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class StudentServicePerformanceTest {

    @Test
    void shouldMeasureStudentServicePerformance() {

        StudentService service = new StudentService();

        int numberOfStudents = 10_000;

        Random random = new Random(42);

        long startAdd = System.nanoTime();

        for (int i = 1; i <= numberOfStudents; i++) {

            Student student = new Student(
                    i,
                    "Student" + i,
                    20,
                    "B.Tech CSE",
                    random.nextDouble(101),
                    random.nextDouble(101),
                    random.nextDouble(101),
                    random.nextDouble(101),
                    random.nextDouble(101)
            );

            service.addStudentSilently(student);
        }

        long endAdd = System.nanoTime();


        long startSort = System.nanoTime();

        service.sortStudentsByPercentage();

        long endSort = System.nanoTime();


        long startSearch = System.nanoTime();

        for (int i = 1; i <= 1_000; i++) {
            service.searchStudentById(i);
        }

        long endSearch = System.nanoTime();

        // -------------------------------
        // Convert nanoseconds to ms
        // -------------------------------

        double addTimeMs =
                (endAdd - startAdd) / 1_000_000.0;

        double sortTimeMs =
                (endSort - startSort) / 1_000_000.0;

        double searchTimeMs =
                (endSearch - startSearch) / 1_000_000.0;

        System.out.println();
        System.out.println("===== PERFORMANCE TEST =====");
        System.out.println("Number of students : " + numberOfStudents);
        System.out.println("------------------------------------------");
        System.out.printf("Insertion time      : %.3f ms%n", addTimeMs);
        System.out.printf("Sorting time        : %.3f ms%n", sortTimeMs);
        System.out.printf("1000 searches time  : %.3f ms%n", searchTimeMs);
        System.out.println("==========================================");
    }
}