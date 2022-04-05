package algorithms.sorting;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] A = {4, 2, 1, 3, 1, 6, 9};

        System.out.println("Original Array : ");
        display(A);
        System.out.println();

        // call
        quickSort(A, 0, A.length - 1);

        // display - sorted array
        display(A);
    }

    // Time Complexity :
    // 1. Best-Case = O(n * log2n)
    // 2. Average-Case = O(n * log2n) [Using Randomized-Partitioning]
    // 3. Worst-Case = O(n2)

    // Space Complexity in Worst-Case = O(log2n)

    public static void quickSort(int[] A, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotIndex = randomizedPartitioning(A, startIndex, endIndex);
            quickSort(A, startIndex, pivotIndex - 1);
            quickSort(A, pivotIndex + 1, endIndex);
        }
    }

    private static int randomizedPartitioning(int[] A, int startIndex, int endIndex) {
        int randomIndex = new Random().nextInt((endIndex - startIndex) + 1) + startIndex;

        // swap (A[randomIndex], A[endIndex])
        int temp = A[endIndex];
        A[endIndex] = A[randomIndex];
        A[randomIndex] = temp;

        return partitioning(A, startIndex, endIndex);
    }

    private static int partitioning(int[] A, int startIndex, int endIndex) {
        int pivotElement = A[endIndex];
        int pivotIndex = startIndex;

        for (int i = startIndex; i < endIndex; i++) {
            if (A[i] <= pivotElement) {
                // swap
                int temp = A[i];
                A[i] = A[pivotIndex];
                A[pivotIndex] = temp;

                // increment pivotIndex by 1
                pivotIndex = pivotIndex + 1;
            }
        }

        // swap
        A[endIndex] = A[pivotIndex];
        A[pivotIndex] = pivotElement;

        return pivotIndex;
    }

    private static void display(int[] A) {
        for (int number : A) {
            System.out.print(number + " ");
        }
    }
}
