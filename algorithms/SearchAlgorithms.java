package algorithms;

import java.util.*;

import model.Student;
// need selection, insertion, bubble, merge, quick, heap
public class SearchAlgorithms {
    public static Student linearSearch(List<Student> students, int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public static Student binarySearch(List<Student> students, int id) {
        int left = 0;
        int right = students.size() - 1;

        while (left <= right) {
            int test = (left+right) / 2;
            if (students.get(test).getId() == id) {
                return students.get(test);
            } else if (students.get(test).getId() < id) {
                left = test + 1;
            } else {
                right = test - 1;
            }
        }
        return null;
    }
}
