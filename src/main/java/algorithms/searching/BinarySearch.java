package algorithms.searching;

import algorithms.sorting.QuickSort;

public class BinarySearch {

    public static void main(String[] args) {
        int[] A = {4, 2, 1, 3, 1, 6, 9};

        System.out.println("Original Array : ");
        display(A);
        printNewLine(2);

        System.out.println("Binary Search : Only Possible If Array Is Sorted -> Running QuickSort...");

        // Call QuickSort
        QuickSort.quickSort(A, 0, A.length - 1);
        System.out.println("Sorted Array : ");
        display(A);
        printNewLine(2);

        // Calling BinarySearch
        binarySearch(A, 6);
        printNewLine(1);

        binarySearch(A, 2);
        printNewLine(1);

        binarySearch(A, 5);
        printNewLine(1);

        binarySearch(A, 1);
        printNewLine(1);

        binarySearch(A, 8);
        printNewLine(1);

        binarySearch(A, 9);
        printNewLine(1);
    }

    private static boolean isElementExists(int[] A, int X, int startIndex, int endIndex) {
        // Base Condition To Exit
        if (startIndex > endIndex)
            return false;

        int mid = startIndex + (endIndex - startIndex) / 2; // Efficient
        if (X == A[mid])
            return true;
        else if (X < A[mid])
            return isElementExists(A, X, startIndex, mid - 1);
        else
            return isElementExists(A, X, mid + 1, endIndex);
    }

    // Time-Complexity in Worst-Case = O(log2n)

    private static void binarySearch(int[] A, int X) {
        System.out.println("Search Element = " + X);

        if (isElementExists(A, X, 0, A.length - 1))
            System.out.println("Success -> " + X + " is present...");
        else
            System.out.println("Failure -> " + X + " is not present...");
    }

    private static void display(int[] A) {
        for (int number : A) {
            System.out.print(number + " ");
        }
    }

    private static void printNewLine(int count) {
        while (count > 0) {
            System.out.println();
            count--;
        }
    }
}
