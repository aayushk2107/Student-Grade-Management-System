package service;

public class GradeCalculator {

    private GradeCalculator() {
    }

    public static double calculateTotal(double maths,
                                        double physics,
                                        double chemistry,
                                        double english,
                                        double computerScience) {

        return maths + physics + chemistry + english + computerScience;
    }

    public static double calculatePercentage(double totalMarks) {

        return totalMarks / 5.0;
    }

    public static char calculateGrade(double percentage) {

        if (percentage >= 90) {
            return 'A';
        } else if (percentage >= 80) {
            return 'B';
        } else if (percentage >= 70) {
            return 'C';
        } else if (percentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}