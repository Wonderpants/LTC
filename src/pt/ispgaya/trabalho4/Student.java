package pt.ispgaya.trabalho4;

public class Student {

    private int code;
    private String name;
    private String assignment;
    private double grade;

    Student(int code, String name, String assignment, double grade
    ) {
        this.code = Integer.parseInt(String.valueOf(code).substring(4));
        this.name = name;
        this.assignment = assignment;
        this.grade = grade;
    }

    Student() {
        this.code = 0;
        this.name = "unknown";
        this.assignment = "unknown";
        this.grade = 0;
    }

    public void updateGrade(double grade) {
        this.grade = grade;
    }

    public int getCode() {
        return this.code;
    }

    String print() {
        return this.code + " " + this.name + ": " + this.grade;
    }

}
