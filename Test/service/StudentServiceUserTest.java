package service;

import model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceUserTest {

    @Test
    void testCompleteUserWorkflow() {
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

        Student foundStudent = service.searchStudentById(103);

        assertNotNull(foundStudent);
        assertEquals("Priya", foundStudent.getName());

        service.sortStudentsByPercentage();

        assertEquals(103, service.getStudents().get(0).getStudentId());
        assertEquals(101, service.getStudents().get(1).getStudentId());
        assertEquals(102, service.getStudents().get(2).getStudentId());

        String gradeDetails = service.getStudentGradeDetails(103);

        assertTrue(gradeDetails.contains("Priya"));
        assertTrue(gradeDetails.contains("95.0"));
        assertTrue(gradeDetails.contains("98.0"));

        service.updateStudentGrades(
                103,
                90,
                88,
                92,
                95,
                97
        );


        Student updatedStudent = service.searchStudentById(103);

        assertNotNull(updatedStudent);
        assertEquals(90, updatedStudent.getMathsMarks());
        assertEquals(88, updatedStudent.getPhysicsMarks());
        assertEquals(92, updatedStudent.getChemistryMarks());
        assertEquals(95, updatedStudent.getEnglishMarks());
        assertEquals(97, updatedStudent.getComputerScienceMarks());

        String updatedDetails =
                service.getStudentGradeDetails(103);

        assertTrue(updatedDetails.contains("90.0"));
        assertTrue(updatedDetails.contains("88.0"));
        assertTrue(updatedDetails.contains("97.0"));
    }

    @Test
    void testInvalidStudentSearch() {

        StudentService service = new StudentService();

        Student result = service.searchStudentById(999);

        assertNull(result);
    }

    @Test
    void testDuplicateStudentId() {

        StudentService service = new StudentService();

        Student first = new Student(
                101,
                "Aayush",
                20,
                "B.Tech CSE",
                90, 85, 92, 88, 95
        );

        Student duplicate = new Student(
                101,
                "Another Student",
                21,
                "B.Tech CSE",
                70, 70, 70, 70, 70
        );

        service.addStudent(first);
        service.addStudent(duplicate);

        assertEquals(1, service.getStudents().size());
    }

    @Test
    void testAddingNullStudentDoesNotCrash() {

        StudentService service = new StudentService();

        assertDoesNotThrow(() -> service.addStudentSilently(null));

        assertEquals(0, service.getStudents().size());
    }

    @Test
    void testInvalidGradeUpdate() {

        StudentService service = new StudentService();

        Student student = new Student(
                101,
                "Aayush",
                20,
                "B.Tech CSE",
                90, 85, 92, 88, 95
        );

        service.addStudent(student);

        // Invalid Maths mark: 150
        service.updateStudentGrades(
                101,
                150,
                88,
                92,
                95,
                97
        );

        assertEquals(90, student.getMathsMarks());
    }
}