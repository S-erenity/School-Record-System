import utilities.*;
import model.*;

import java.util.ArrayList;
import java.util.List;

import algorithms.*;

public class Main {
    public static void main(String[] args) {

        List<Student> data = CSVLoader.loadStudents("data/students_large.csv");
        SortAlgorithms.sortByID(data);

        // ----- SEARCH TESTS -----
        long linearTime = Timer.timeSearch(() ->
                SearchAlgorithms.linearSearch(data, 1003)
        );

        long binaryTime = Timer.timeSearch(() ->
                SearchAlgorithms.binarySearch(data, 1003)
        );

        System.out.println("Linear Search Time: " + linearTime + " ns");
        System.out.println("Binary Search Time: " + binaryTime + " ns");

        // ----- SORT TESTS -----
        List<Student> bubbleData = cloneList(data);
        List<Student> mergeData = cloneList(data);

        long bubbleTime = averageTime(() ->
                SortAlgorithms.bubbleSort(bubbleData), 10
        );

        long mergeTime = averageTime(() ->
                SortAlgorithms.mergeSort(mergeData), 10
        );

        System.out.println("Bubble Sort Time: " + bubbleTime + " ns");
        System.out.println("Merge Sort Time: " + mergeTime + " ns");
    }

    public static long averageTime(Runnable task, int runs) {
        long total = 0;
        for (int i = 0; i < runs; i++) {
            total += Timer.timeSort(task);
        }
        return total / runs;
    }

    public static List<Student> cloneList(List<Student> original) {
        return new ArrayList<>(original);
    }
}
