package model;

public class Student {
    double gpa;
    String firstName;
    String lastName;
    int id;

    public Student(int id, String firstName, String lastName, double gpa) {
        this.gpa = gpa;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String toString() {
        return "Student{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + "', gpa=" + gpa + "}";
    }
}
