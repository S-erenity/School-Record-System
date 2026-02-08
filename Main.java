import utilities.*;
import model.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = CSVLoader.loadStudents("data/students_small.csv");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
