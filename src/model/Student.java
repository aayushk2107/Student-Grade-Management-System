package model;

public class Student {

    private int studentId;
    private String name;
    private int age;
    private String course;

    private double mathsMarks;
    private double physicsMarks;
    private double chemistryMarks;
    private double englishMarks;
    private double computerScienceMarks;

    public Student() {
    }

    public Student(int studentId, String name, int age, String course,
                   double mathsMarks,
                   double physicsMarks,
                   double chemistryMarks,
                   double englishMarks,
                   double computerScienceMarks) {

        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.course = course;

        this.mathsMarks = mathsMarks;
        this.physicsMarks = physicsMarks;
        this.chemistryMarks = chemistryMarks;
        this.englishMarks = englishMarks;
        this.computerScienceMarks = computerScienceMarks;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getMathsMarks() {
        return mathsMarks;
    }

    public void setMathsMarks(double mathsMarks) {
        this.mathsMarks = mathsMarks;
    }

    public double getPhysicsMarks() {
        return physicsMarks;
    }

    public void setPhysicsMarks(double physicsMarks) {
        this.physicsMarks = physicsMarks;
    }

    public double getChemistryMarks() {
        return chemistryMarks;
    }

    public void setChemistryMarks(double chemistryMarks) {
        this.chemistryMarks = chemistryMarks;
    }

    public double getEnglishMarks() {
        return englishMarks;
    }

    public void setEnglishMarks(double englishMarks) {
        this.englishMarks = englishMarks;
    }

    public double getComputerScienceMarks() {
        return computerScienceMarks;
    }

    public void setComputerScienceMarks(double computerScienceMarks) {
        this.computerScienceMarks = computerScienceMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                ", mathsMarks=" + mathsMarks +
                ", physicsMarks=" + physicsMarks +
                ", chemistryMarks=" + chemistryMarks +
                ", englishMarks=" + englishMarks +
                ", computerScienceMarks=" + computerScienceMarks +
                '}';
    }
}