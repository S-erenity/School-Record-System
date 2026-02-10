package algorithms;

import java.util.List;
import java.util.Random;

import model.Student;

public class SortAlgorithms {
    // Sort helper methods

    public static void swap(List<Student> students, int i, int j) {
        Student temp = students.get(i);
        students.set(i, students.get(j));
        students.set(j, temp);
    }

    public static void merge(List<Student> students, List<Student> left, List<Student> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getGpa() < right.get(j).getGpa()) {
                students.set(k++, left.get(i++));
            } else {
                students.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            students.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            students.set(k++, right.get(j++));
        }
    }

    static int partition(List<Student> students, int low, int high) {
        
        // choose the pivot
        Student pivot = students.get(new Random().nextInt(low, high));
        
        // index of smaller element and indicates 
        // the right position of pivot found so far
        int i = low - 1;

        // traverse students[low..high] and move all smaller
        // elements to the left side. Elements from low to 
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (students.get(j).getGpa() < pivot.getGpa()) {
                i++;
                swap(students, i, j);
            }
        }
        
        // Move pivot after smaller elements and
        // return its position
        swap(students, i + 1, high);  
        return i + 1;
    }

    public static void heapify(List<Student> students, int n, int i) {

        // Initialize largest as root
        int largest = i;

        // left index = 2*i + 1
        int l = 2 * i + 1;

        // right index = 2*i + 2
        int r = 2 * i + 2;

        // If left child is larger than root
        if (l < n && students.get(l).getGpa() > students.get(largest).getGpa())
            largest = l;

        // If right child is larger than largest so far
        if (r < n && students.get(r).getGpa() > students.get(largest).getGpa())
            largest = r;

        // If largest is not root
        if (largest != i) {
            swap(students, i, largest);

            // Recursively heapify the affected sub-tree
            heapify(students, n, largest);
        }
    }

    public static void heapifyID(List<Student> students, int n, int i) {

        // Initialize largest as root
        int largest = i;

        // left index = 2*i + 1
        int l = 2 * i + 1;

        // right index = 2*i + 2
        int r = 2 * i + 2;

        // If left child is larger than root
        if (l < n && students.get(l).getId() > students.get(largest).getId())
            largest = l;

        // If right child is larger than largest so far
        if (r < n && students.get(r).getId() > students.get(largest).getId())
            largest = r;

        // If largest is not root
        if (largest != i) {
            swap(students, i, largest);

            // Recursively heapify the affected sub-tree
            heapify(students, n, largest);
        }
    }

    // Sorts

    public static void insertionSort(List<Student> students) {
        for (int i = 1; i < students.size(); i++) {
            int j = i;
            while(j>=0 && students.get(j).getGpa() < students.get(j-1).getGpa()) {
                swap(students, j, j-1);
                j--;
            }
        }
    }

    public static void bubbleSort(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.size() - 1 - i; j++) {
                if (students.get(j).getGpa() > students.get(j+1).getGpa()) {
                    swap(students, j, j+1);
                }
            }
        }
    }

    public static void selectionSort(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            int minIndex = i;
            for (int j = i+1; j < students.size(); j++) {
                if (students.get(j).getGpa() < students.get(minIndex).getGpa()) {
                    minIndex = j;
                }
            }
            swap(students, i, minIndex);
        }
    }

    public static void mergeSort(List<Student> students) {
        if (students.size() <= 1) {
            return;
        }
        int mid = students.size() / 2;
        List<Student> left = students.subList(0, mid);
        List<Student> right = students.subList(mid, students.size());

        mergeSort(left);
        mergeSort(right);

        merge(students, left, right);
    }

    public static void quickSort(List<Student> students, int low, int high) {
        if (low < high) {
            
            // pi is the partition return index of pivot
            int pi = partition(students, low, high);

            // recursion calls for smaller elements
            // and greater or equals elements
            quickSort(students, low, pi - 1);
            quickSort(students, pi + 1, high);
        }
    }

    public static void heapSort(List<Student> students) {
        int n = students.size();

        // Build heap (rearrange vector)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(students, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {

            // Move current root to end
            swap(students, 0, i);

            // Call max heapify on the reduced heap
            heapify(students, i, 0);
        }
    }

    public static void sortByID(List<Student> students) {
        int n = students.size();

        // Build heap (rearrange vector)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyID(students, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {

            // Move current root to end
            swap(students, 0, i);

            // Call max heapify on the reduced heap
            heapifyID(students, i, 0);
        }
    }
}
