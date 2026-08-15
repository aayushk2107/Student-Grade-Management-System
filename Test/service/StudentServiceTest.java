package service;

import model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentServiceTest {

    @Test
    void shouldSortStudentsByPercentageDescending() {

        StudentService service = new StudentService();

        Student aayush = new Student(
                101,
                "Aayush",
                20,
                "B.Tech CSE",
                90, 85, 92, 88, 95
        );

        Student rahul = new Student(
                102,
                "Rahul",
                20,
                "B.Tech CSE",
                75, 80, 72, 78, 85
        );

        Student priya = new Student(
                103,
                "Priya",
                20,
                "B.Tech CSE",
                95, 91, 94, 96, 98
        );

        service.addStudent(aayush);
        service.addStudent(rahul);
        service.addStudent(priya);

        service.sortStudentsByPercentage();

        assertEquals(103, service.getStudents().get(0).getStudentId());
        assertEquals(101, service.getStudents().get(1).getStudentId());
        assertEquals(102, service.getStudents().get(2).getStudentId());
    }
}