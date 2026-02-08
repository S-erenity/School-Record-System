package utilities;
import java.io.*;
import java.util.*;
import model.*;

public class CSVLoader {

    public static List<Student> loadStudents(String filePath) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String firstName = data[1];
                String lastName = data[2];
                double gpa = Double.parseDouble(data[3]);

                students.add(new Student(id, firstName, lastName, gpa));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }
}