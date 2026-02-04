import java.io.*;
import java.util.*;

public class CSVLoader {

    public static void main(String[] args) {
        System.out.println("test");
    }

    public static List<model.Student> loadStudents(String filePath) {
        List<model.Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double gpa = Double.parseDouble(data[2]);

                students.add(new model.Student(id, name, gpa));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }
}