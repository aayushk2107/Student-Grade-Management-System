package service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradeCalculatorTest {

    @Test
    void shouldCalculateTotalMarks() {

        double total = GradeCalculator.calculateTotal(
                90,
                85,
                92,
                88,
                95
        );

        assertEquals(450.0, total);
    }

    @Test
    void shouldCalculatePercentage() {

        double percentage = GradeCalculator.calculatePercentage(450);

        assertEquals(90.0, percentage);
    }

    @Test
    void shouldCalculateGradeA() {

        char grade = GradeCalculator.calculateGrade(90);

        assertEquals('A', grade);
    }

    @Test
    void shouldCalculateGradeB() {

        char grade = GradeCalculator.calculateGrade(85);

        assertEquals('B', grade);
    }

    @Test
    void shouldCalculateGradeC() {

        char grade = GradeCalculator.calculateGrade(75);

        assertEquals('C', grade);
    }

    @Test
    void shouldCalculateGradeF() {

        char grade = GradeCalculator.calculateGrade(50);

        assertEquals('F', grade);
    }
}